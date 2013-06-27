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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.603 -0400", hash_original_field = "69994B385C8EE3CB1FC89C139F80EE2C", hash_generated_field = "D7ACA1EA4615702CAE0E6513097C1B9D")

    private SparseArray<ManagedDialog> mManagedDialogs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.604 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.612 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "48FA2AB88D7976975EE44F222013EB79")

    private IBinder mToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.613 -0400", hash_original_field = "9ECD332EA0315F97A6C2A47F0DFCF2CA", hash_generated_field = "1C52ADC6FAC22BA15FC5CB45EFB9C704")

    private int mIdent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.613 -0400", hash_original_field = "1F8EA74468A18EB8C9F4629DC88D43D9", hash_generated_field = "A96A287BB650BF201DDA299E34737419")

    String mEmbeddedID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.614 -0400", hash_original_field = "6B35E9B21496C1A77A324DB1577A6395", hash_generated_field = "53FA3553B85F7414D1C5F2C302FDEBF9")

    private Application mApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.624 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "1811495D939DB843870F6315E04555CC")

    Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.624 -0400", hash_original_field = "C0386E973BB6E008B1720A8BB4936F69", hash_generated_field = "1B40E7C57A0B1682389BAE16521C0844")

    private ComponentName mComponent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.625 -0400", hash_original_field = "4BA355497E3293EF79CEB324C2759EC3", hash_generated_field = "C71CEE98D7B6D75F61EDC7C7807C69E4")

    ActivityInfo mActivityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.626 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.641 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "CD55C80FF47FF655766F475F33319B07")

    Activity mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.642 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.643 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.649 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.649 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.650 -0400", hash_original_field = "33AF93F952A554412842C66D48683981", hash_generated_field = "7A3A2F4FBB99BD4528DF7EC8A1065318")

    private boolean mStopped;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.651 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

    boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.651 -0400", hash_original_field = "D6CAA0132EF985A9C48E94EF5C72A353", hash_generated_field = "4271970B01F3FE84D04BB6304D70A20E")

    boolean mStartedActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.656 -0400", hash_original_field = "DD793F13DDAF2B567A8C331E578AA5A1", hash_generated_field = "E2F9380D6A364C95010BE19858A38D28")

    boolean mTemporaryPause = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.657 -0400", hash_original_field = "9D9C29E34F0ED4F978EFE00DFB6384BA", hash_generated_field = "D9F8EBFD0B8B6BCDE3A24A3C3A2D769A")

    boolean mChangingConfigurations = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.657 -0400", hash_original_field = "C276475150FAB89E9C0772A14D5411EF", hash_generated_field = "8737FBBAA51F2079A35CA72C17030BD1")

    int mConfigChangeFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.674 -0400", hash_original_field = "49D0F54F6F251B7A443EE498C968E7F0", hash_generated_field = "C5BC4D87F668E7C84F089BDA831D492B")

    Configuration mCurrentConfig;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.675 -0400", hash_original_field = "32BBEFAC8E5B50979F727CF657FBCDC5", hash_generated_field = "EC37B561700692089320F9D5E535EAC6")

    private SearchManager mSearchManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.676 -0400", hash_original_field = "EC6D3DC1F9EEB509CBA3527543E491C5", hash_generated_field = "53E9FC1E44FE670BE318B42372895069")

    private MenuInflater mMenuInflater;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.676 -0400", hash_original_field = "A330FB67942A8EBA9AA052BF6E9BD824", hash_generated_field = "103BD895478A6A40124D791931151EE2")

    NonConfigurationInstances mLastNonConfigurationInstances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.686 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "C669AC20EF93035981B8D3BE2898892F")

    private Window mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.686 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.687 -0400", hash_original_field = "51828538BFE4CBE4B66B359B3F441676", hash_generated_field = "E1BBD6179BBAC61DB86866A787E8F58C")

    View mDecor = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.687 -0400", hash_original_field = "D04D49A04B1C9F713DA6373581960A20", hash_generated_field = "55C28C3FE3EA0FDA8C94FC41EC701FCC")

    boolean mWindowAdded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.688 -0400", hash_original_field = "F4264B08F586521DD9D9932CF43D3E98", hash_generated_field = "8DFFFB221D63F9E9F2CE49B7477D9272")

    boolean mVisibleFromServer = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.703 -0400", hash_original_field = "A0B583B0E04E9DAD985B75BE1B4455FB", hash_generated_field = "5F61707B4AC1003B88348BA722FB1276")

    boolean mVisibleFromClient = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.704 -0400", hash_original_field = "E174CF32536D070CADCB31C79B6A2A6D", hash_generated_field = "1CE82A6BEC35E312C3A47BC38BD7B9BC")

    ActionBarImpl mActionBar = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.705 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.706 -0400", hash_original_field = "31044357223C0CBA3321867ECA01F93C", hash_generated_field = "CF4E9C052F96C3E80581AE8AF634872B")

    private int mTitleColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.706 -0400", hash_original_field = "9E9F5C9A2D303AC76B37DDF504A5EF92", hash_generated_field = "770A646DB3FFD5D268F1207A9B6648B8")

    FragmentManagerImpl mFragments = new FragmentManagerImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.707 -0400", hash_original_field = "C3FC98EBFA953A5BA9BDADB9981A948A", hash_generated_field = "207A321ED3571899F1F73399691FB216")

    SparseArray<LoaderManagerImpl> mAllLoaderManagers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.725 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.726 -0400", hash_original_field = "4FADE50651FFFEF0B3EB84F52D784589", hash_generated_field = "51291E8604BFC44218E4DBA470119372")

    private ArrayList<ManagedCursor> mManagedCursors = new ArrayList<ManagedCursor>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.727 -0400", hash_original_field = "E342FEFA537FF05142CD9015EE3A0E7D", hash_generated_field = "2FA7D874AF2386F63CF856FBF24A7710")

    int mResultCode = RESULT_CANCELED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.737 -0400", hash_original_field = "1096C650F15AC7BAC99BEA828E92A3B2", hash_generated_field = "33B7C8CE0002446D9B0EE0274776A0A9")

    Intent mResultData = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.738 -0400", hash_original_field = "4F715D0874F4F1364B7BFCBD6E8E0F0A", hash_generated_field = "AB8AC56D76B8BEA00FC5296846330527")

    private boolean mTitleReady = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.738 -0400", hash_original_field = "E63F81EBF009861E6158D6EBEF422559", hash_generated_field = "B2DD3A4B48EBE858054417FEDBBD4E9F")

    private int mDefaultKeyMode = DEFAULT_KEYS_DISABLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.739 -0400", hash_original_field = "56ABC0D9D60C4A18066C25A91AA319BA", hash_generated_field = "2B1292D0EBD0751B84B1BAFF83080A8F")

    private SpannableStringBuilder mDefaultKeySsb = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.739 -0400", hash_original_field = "EA2540686B911BB0954AF2AA78EF465E", hash_generated_field = "CD3BD1DDD6EB5EDF0F7620D63FE081AA")

    private Object mInstanceTracker = StrictMode.trackActivity(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.740 -0400", hash_original_field = "C5D62B7C4F8BE6B828DA51239EC692E0", hash_generated_field = "A94051227A36AE91A6CE3B31BF1DD3E6")

    private Thread mUiThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.741 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "AD9C3D1E48D73BF1547D53C4C62401B2")

    Handler mHandler = new Handler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.757 -0400", hash_original_method = "AACC12F53D348DF0EC8A64E180708AE7", hash_generated_method = "AACC12F53D348DF0EC8A64E180708AE7")
    public Activity ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.760 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "FDA5D28C4CEDEBA5EB2D75A043445213")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_15577123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_15577123 = mIntent;
        varB4EAC82CA7396A68D541C85D26508E83_15577123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_15577123;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.783 -0400", hash_original_method = "CC61C883982068788EAC9DED2F81C9E5", hash_generated_method = "B79BA4B24A70D57CC8AC980D0B341130")
    public void setIntent(Intent newIntent) {
        mIntent = newIntent;
        // ---------- Original Method ----------
        //mIntent = newIntent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.785 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "FA86E3DDE6DD1366B7638E6AE46B7D25")
    public final Application getApplication() {
        Application varB4EAC82CA7396A68D541C85D26508E83_170035906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_170035906 = mApplication;
        varB4EAC82CA7396A68D541C85D26508E83_170035906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170035906;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.797 -0400", hash_original_method = "68263BD6D248286EA0E84780534AEB0C", hash_generated_method = "811D9138FCD4EFD2A6699B7C5DC5726B")
    public final boolean isChild() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179716599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179716599;
        // ---------- Original Method ----------
        //return mParent != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.816 -0400", hash_original_method = "9F036901744EF56469FFF11C0925658F", hash_generated_method = "9B406BC755DCAD9828947DB3A7D69226")
    public final Activity getParent() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1413305403 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1413305403 = mParent;
        varB4EAC82CA7396A68D541C85D26508E83_1413305403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1413305403;
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.826 -0400", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "6E42417AE61403721845CA73AE069185")
    public WindowManager getWindowManager() {
        WindowManager varB4EAC82CA7396A68D541C85D26508E83_1441093984 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1441093984 = mWindowManager;
        varB4EAC82CA7396A68D541C85D26508E83_1441093984.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441093984;
        // ---------- Original Method ----------
        //return mWindowManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.834 -0400", hash_original_method = "51ACB33F24592F8ED3FAFF9D96DEAF2A", hash_generated_method = "6D5C989622AEB17C0CB17383965E4ACB")
    public Window getWindow() {
        Window varB4EAC82CA7396A68D541C85D26508E83_1346872821 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1346872821 = mWindow;
        varB4EAC82CA7396A68D541C85D26508E83_1346872821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1346872821;
        // ---------- Original Method ----------
        //return mWindow;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.854 -0400", hash_original_method = "6FD2535D569839ECA0CF9FB0769EA7E8", hash_generated_method = "F878A6EDBBD8AE82DCF010E4B1BD3FF5")
    public LoaderManager getLoaderManager() {
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_1326215773 = null; //Variable for return #1
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_1641240945 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1326215773 = mLoaderManager;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        varB4EAC82CA7396A68D541C85D26508E83_1641240945 = mLoaderManager;
        LoaderManager varA7E53CE21691AB073D9660D615818899_1861615019; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1861615019 = varB4EAC82CA7396A68D541C85D26508E83_1326215773;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1861615019 = varB4EAC82CA7396A68D541C85D26508E83_1641240945;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1861615019.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1861615019;
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = getLoaderManager(-1, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.878 -0400", hash_original_method = "08140101E6179DFA80CB04A3C57AF21B", hash_generated_method = "C7C0C9DC6D0F74713FE74CF6569A58C4")
     LoaderManagerImpl getLoaderManager(int index, boolean started, boolean create) {
        LoaderManagerImpl varB4EAC82CA7396A68D541C85D26508E83_603787783 = null; //Variable for return #1
        {
            mAllLoaderManagers = new SparseArray<LoaderManagerImpl>();
        } //End block
        LoaderManagerImpl lm;
        lm = mAllLoaderManagers.get(index);
        {
            {
                lm = new LoaderManagerImpl(this, started);
                mAllLoaderManagers.put(index, lm);
            } //End block
        } //End block
        {
            lm.updateActivity(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_603787783 = lm;
        addTaint(index);
        addTaint(started);
        addTaint(create);
        varB4EAC82CA7396A68D541C85D26508E83_603787783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603787783;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.895 -0400", hash_original_method = "44957F5326E5A87B91E438DCD3C71232", hash_generated_method = "138DBB17E09CCE1E4D93F00C97812975")
    public View getCurrentFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_1884047989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1884047989 = mWindow != null ? mWindow.getCurrentFocus() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1884047989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1884047989;
        // ---------- Original Method ----------
        //return mWindow != null ? mWindow.getCurrentFocus() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.909 -0400", hash_original_method = "B17127798FA6CFC370BF4A1AB8F1546E", hash_generated_method = "F3448D81C9DECFAC03970CA11C11082F")
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mAllLoaderManagers = mLastNonConfigurationInstances.loaders;
        } //End block
        {
            Parcelable p;
            p = savedInstanceState.getParcelable(FRAGMENTS_TAG);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.920 -0400", hash_original_method = "F96DCFB160CAE669DE173597BCAB5D29", hash_generated_method = "04CD208A03098F358C20529956E3E77B")
    final void performRestoreInstanceState(Bundle savedInstanceState) {
        onRestoreInstanceState(savedInstanceState);
        restoreManagedDialogs(savedInstanceState);
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //onRestoreInstanceState(savedInstanceState);
        //restoreManagedDialogs(savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.939 -0400", hash_original_method = "310E3A3C8C3B3732DFA9529F42CA26F1", hash_generated_method = "B68D81F44DFE1383742FDCBF52468E3E")
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Bundle windowState;
            windowState = savedInstanceState.getBundle(WINDOW_HIERARCHY_TAG);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.951 -0400", hash_original_method = "0F730FD08B46E6D42261031E4F07C651", hash_generated_method = "9428A97F20EC83573B61FF3EF47D8A1D")
    private void restoreManagedDialogs(Bundle savedInstanceState) {
        Bundle b;
        b = savedInstanceState.getBundle(SAVED_DIALOGS_TAG);
        int[] ids;
        ids = b.getIntArray(SAVED_DIALOG_IDS_KEY);
        int numDialogs;
        numDialogs = ids.length;
        mManagedDialogs = new SparseArray<ManagedDialog>(numDialogs);
        {
            int i;
            i = 0;
            {
                Integer dialogId;
                dialogId = ids[i];
                Bundle dialogState;
                dialogState = b.getBundle(savedDialogKeyFor(dialogId));
                {
                    ManagedDialog md;
                    md = new ManagedDialog();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:36.976 -0400", hash_original_method = "F21B3418C21CA75D12B54B07BD48021E", hash_generated_method = "93258F1042BF21612E49E635A8B74D6D")
    private Dialog createDialog(Integer dialogId, Bundle state, Bundle args) {
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1219383478 = null; //Variable for return #1
        Dialog varB4EAC82CA7396A68D541C85D26508E83_484691327 = null; //Variable for return #2
        Dialog dialog;
        dialog = onCreateDialog(dialogId, args);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1219383478 = null;
        } //End block
        dialog.dispatchOnCreate(state);
        varB4EAC82CA7396A68D541C85D26508E83_484691327 = dialog;
        addTaint(dialogId.getTaint());
        addTaint(state.getTaint());
        addTaint(args.getTaint());
        Dialog varA7E53CE21691AB073D9660D615818899_1743469588; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1743469588 = varB4EAC82CA7396A68D541C85D26508E83_1219383478;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1743469588 = varB4EAC82CA7396A68D541C85D26508E83_484691327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1743469588.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1743469588;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.021 -0400", hash_original_method = "15D630F6A1CF1F711678BA91927530D5", hash_generated_method = "DC506CE5A88E103D01F4784EE1104028")
    protected void onPostCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var1E47DE65F9CFFB5FFE0047F063F1F3E2_1578663824 = (!isChild());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.042 -0400", hash_original_method = "79A696122767FFD8BC894F5F20A8F390", hash_generated_method = "2397E2132D66A9B67652FE4FE96B68CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.054 -0400", hash_original_method = "9551F017AAC8568C86A29525E7DD6889", hash_generated_method = "BFAD3826B369FB60CEBE705C5D3DE3AF")
    protected void onRestart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.056 -0400", hash_original_method = "AC4046BA89469FB1DB71AF45F366E61A", hash_generated_method = "386EEADB41ACC4B4BD80CE17A193C26A")
    protected void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityResumed(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityResumed(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.074 -0400", hash_original_method = "F3C7FB58C48A3E40E2BB0C45916F9A60", hash_generated_method = "5DDD54CC19246F63B4BB45703DAAE5AA")
    protected void onPostResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Window win;
        win = getWindow();
        win.makeActive();
        mActionBar.setShowHideAnimationEnabled(true);
        mCalled = true;
        // ---------- Original Method ----------
        //final Window win = getWindow();
        //if (win != null) win.makeActive();
        //if (mActionBar != null) mActionBar.setShowHideAnimationEnabled(true);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.096 -0400", hash_original_method = "ECA12E6FCFF6C8E6301C9A23FD34F5BD", hash_generated_method = "55BB01BD8178596262072C6AD03D450A")
    protected void onNewIntent(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.098 -0400", hash_original_method = "0B461FC0ABFD8E876BD0A4555078BB43", hash_generated_method = "F3FA9E9361FD8CB50CB6AE1B3A5F66A3")
    final void performSaveInstanceState(Bundle outState) {
        onSaveInstanceState(outState);
        saveManagedDialogs(outState);
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
        //onSaveInstanceState(outState);
        //saveManagedDialogs(outState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.116 -0400", hash_original_method = "7ACED454726A10AD27032B8542185EA6", hash_generated_method = "3C1CB9D5828DD30F3EBB8249B718E93D")
    protected void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        outState.putBundle(WINDOW_HIERARCHY_TAG, mWindow.saveHierarchyState());
        Parcelable p;
        p = mFragments.saveAllState();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.153 -0400", hash_original_method = "8A0B1A781281636D9884F4D74FBF5AF9", hash_generated_method = "B2A3E0825CE9B1DB157891555A30D1AD")
    private void saveManagedDialogs(Bundle outState) {
        int numDialogs;
        numDialogs = mManagedDialogs.size();
        Bundle dialogState;
        dialogState = new Bundle();
        int[] ids;
        ids = new int[mManagedDialogs.size()];
        {
            int i;
            i = 0;
            {
                int key;
                key = mManagedDialogs.keyAt(i);
                ids[i] = key;
                ManagedDialog md;
                md = mManagedDialogs.valueAt(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.168 -0400", hash_original_method = "B6F2BA46109080323AC17E644CBE52E4", hash_generated_method = "486584B3FE1F7AACB7AE3C8DA52C0E5B")
    protected void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        getApplication().dispatchActivityPaused(this);
        mCalled = true;
        // ---------- Original Method ----------
        //getApplication().dispatchActivityPaused(this);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.169 -0400", hash_original_method = "F09D1B8D5CADCA3B5931B472B638BC48", hash_generated_method = "E9DC8D666FB72967F203DDC8123D3668")
    protected void onUserLeaveHint() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.189 -0400", hash_original_method = "88BB0202BF6BAEB771096BFB80D04435", hash_generated_method = "F33974E1CC306DB4034893FEEBBACCE4")
    public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outBitmap.getTaint());
        addTaint(canvas.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715371630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715371630;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.192 -0400", hash_original_method = "ABF3FC9B35FB67DA4650457E79D2DAE8", hash_generated_method = "5DF7F1FDEB3F32F863EAD2B10B01EF08")
    public CharSequence onCreateDescription() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1803871736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1803871736 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1803871736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1803871736;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.223 -0400", hash_original_method = "24615BF0697D6E27C5190BAC65D711E7", hash_generated_method = "B96FF3EC182066563D7EFF3F55303022")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.243 -0400", hash_original_method = "4E5533F51E688B9D4BB620414B9C0889", hash_generated_method = "FBDB3A4D8F710EDDB9070B14A04EF278")
    protected void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            int numDialogs;
            numDialogs = mManagedDialogs.size();
            {
                int i;
                i = 0;
                {
                    ManagedDialog md;
                    md = mManagedDialogs.valueAt(i);
                    {
                        boolean var45C50B8B627C1BA4D235A3956BED22BE_1171443407 = (md.mDialog.isShowing());
                        {
                            md.mDialog.dismiss();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            mManagedDialogs = null;
        } //End block
        {
            int numCursors;
            numCursors = mManagedCursors.size();
            {
                int i;
                i = 0;
                {
                    ManagedCursor c;
                    c = mManagedCursors.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.265 -0400", hash_original_method = "30CE766C89D5A8D407C7E787A35027AF", hash_generated_method = "4D1FA5B9C502EA77AEB0068A6951F095")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.284 -0400", hash_original_method = "60C5D0D9DB2F726CCDEA80A841C2981A", hash_generated_method = "9CB8425BA2ED929C4D671A92348AD087")
    public int getChangingConfigurations() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201543102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201543102;
        // ---------- Original Method ----------
        //return mConfigChangeFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.297 -0400", hash_original_method = "A4ED76D57E3C56C838C9F6AEF3843C6C", hash_generated_method = "A8C6613CC15F2B56C4A8C30785A26133")
    @Deprecated
    public Object getLastNonConfigurationInstance() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1876838345 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1876838345 = mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.activity : null;
        varB4EAC82CA7396A68D541C85D26508E83_1876838345.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1876838345;
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.activity : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.314 -0400", hash_original_method = "1AAF173FB42EFD7F047F27F49A93F1B0", hash_generated_method = "C610108C62B257EB3FC823D55CEAF09E")
    public Object onRetainNonConfigurationInstance() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Object varB4EAC82CA7396A68D541C85D26508E83_658925278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658925278 = null;
        varB4EAC82CA7396A68D541C85D26508E83_658925278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658925278;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.330 -0400", hash_original_method = "891F87189588B9AE1E11F6F1107773C1", hash_generated_method = "56E47EA5B01036DDFCABA21117AAB996")
     HashMap<String, Object> getLastNonConfigurationChildInstances() {
        HashMap<String, Object> varB4EAC82CA7396A68D541C85D26508E83_647192905 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_647192905 = mLastNonConfigurationInstances != null
                ? mLastNonConfigurationInstances.children : null;
        varB4EAC82CA7396A68D541C85D26508E83_647192905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_647192905;
        // ---------- Original Method ----------
        //return mLastNonConfigurationInstances != null
                //? mLastNonConfigurationInstances.children : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.347 -0400", hash_original_method = "342B0C995620FF868A09DAF694D00C04", hash_generated_method = "7A4C6A7D85C248EF2B3D3DB6349A463E")
     HashMap<String,Object> onRetainNonConfigurationChildInstances() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        HashMap<String,Object> varB4EAC82CA7396A68D541C85D26508E83_1727141679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1727141679 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1727141679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1727141679;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.381 -0400", hash_original_method = "927AC7E194A76481C5C9B757C08C225A", hash_generated_method = "4275053E13EDD0500A8EFF35E3504F68")
     NonConfigurationInstances retainNonConfigurationInstances() {
        NonConfigurationInstances varB4EAC82CA7396A68D541C85D26508E83_1235314755 = null; //Variable for return #1
        NonConfigurationInstances varB4EAC82CA7396A68D541C85D26508E83_1593167320 = null; //Variable for return #2
        Object activity;
        activity = onRetainNonConfigurationInstance();
        HashMap<String, Object> children;
        children = onRetainNonConfigurationChildInstances();
        ArrayList<Fragment> fragments;
        fragments = mFragments.retainNonConfig();
        boolean retainLoaders;
        retainLoaders = false;
        {
            {
                int i;
                i = mAllLoaderManagers.size()-1;
                {
                    LoaderManagerImpl lm;
                    lm = mAllLoaderManagers.valueAt(i);
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
            varB4EAC82CA7396A68D541C85D26508E83_1235314755 = null;
        } //End block
        NonConfigurationInstances nci;
        nci = new NonConfigurationInstances();
        nci.activity = activity;
        nci.children = children;
        nci.fragments = fragments;
        nci.loaders = mAllLoaderManagers;
        varB4EAC82CA7396A68D541C85D26508E83_1593167320 = nci;
        NonConfigurationInstances varA7E53CE21691AB073D9660D615818899_1951910146; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1951910146 = varB4EAC82CA7396A68D541C85D26508E83_1235314755;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1951910146 = varB4EAC82CA7396A68D541C85D26508E83_1593167320;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1951910146.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1951910146;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.393 -0400", hash_original_method = "85EA10C9746E5BAE09F0BEB2EAF91433", hash_generated_method = "DF43C28571D148477AB74F4811D8645C")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchLowMemory();
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchLowMemory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.407 -0400", hash_original_method = "B7E71156F952E373C8BB026507E8D786", hash_generated_method = "D9508E7C57AFBD7E938E2947FFDAA6DC")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        mFragments.dispatchTrimMemory(level);
        addTaint(level);
        // ---------- Original Method ----------
        //mCalled = true;
        //mFragments.dispatchTrimMemory(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.420 -0400", hash_original_method = "C5EB33D6873EE026D87972F02E8EBD4B", hash_generated_method = "CA2B4F33ECD5CBA3D70F4871547326BF")
    public FragmentManager getFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_737535061 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_737535061 = mFragments;
        varB4EAC82CA7396A68D541C85D26508E83_737535061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_737535061;
        // ---------- Original Method ----------
        //return mFragments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.423 -0400", hash_original_method = "36D6A0BA7A439406C26069B6EB63A924", hash_generated_method = "E660C20BDEC48BDEAF481C3B089543F7")
     void invalidateFragmentIndex(int index) {
        {
            LoaderManagerImpl lm;
            lm = mAllLoaderManagers.get(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.424 -0400", hash_original_method = "28C2B4CF762BABC0F8C194FDD6A98E77", hash_generated_method = "7BA62512AFE4BD6BB2D807B17B09B3A6")
    public void onAttachFragment(Fragment fragment) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.637 -0400", hash_original_method = "BCF4BFC69850BAC01DAD91770055CA28", hash_generated_method = "B222B92B691AB9ADCD5DFB731F2B24DD")
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1521306783 = null; //Variable for return #1
        Cursor c;
        c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        {
            startManagingCursor(c);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1521306783 = c;
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1521306783.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521306783;
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, null, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.654 -0400", hash_original_method = "957642E226FD04681CA818B5E27D8161", hash_generated_method = "2341757F24A3B92A9DCEFCDDDA5E2E6D")
    @Deprecated
    public final Cursor managedQuery(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        Cursor varB4EAC82CA7396A68D541C85D26508E83_1200417131 = null; //Variable for return #1
        Cursor c;
        c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        {
            startManagingCursor(c);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1200417131 = c;
        addTaint(uri.getTaint());
        addTaint(projection[0].getTaint());
        addTaint(selection.getTaint());
        addTaint(selectionArgs[0].getTaint());
        addTaint(sortOrder.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1200417131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1200417131;
        // ---------- Original Method ----------
        //Cursor c = getContentResolver().query(uri, projection, selection, selectionArgs, sortOrder);
        //if (c != null) {
            //startManagingCursor(c);
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.672 -0400", hash_original_method = "A63FE9916C33F333B3D894D85FA64949", hash_generated_method = "348D5F320412D05C8B87C7C9F09A04AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.688 -0400", hash_original_method = "6A91264601243F53EF1A64547761DF34", hash_generated_method = "40D09F82FBED9648A3929852F37A90CF")
    @Deprecated
    public void stopManagingCursor(Cursor c) {
        {
            int N;
            N = mManagedCursors.size();
            {
                int i;
                i = 0;
                {
                    ManagedCursor mc;
                    mc = mManagedCursors.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.697 -0400", hash_original_method = "14D9F664592BF6CD2790F336C855BE58", hash_generated_method = "C1728DB8A9348DEE6C39624FD13930AC")
    @Deprecated
    public void setPersistent(boolean isPersistent) {
        addTaint(isPersistent);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.705 -0400", hash_original_method = "6A267AF8CD8DFD046F9AA4A840E0F1F1", hash_generated_method = "3941031FAFC0A85A9FB7D94798B30577")
    public View findViewById(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_667165593 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_667165593 = getWindow().findViewById(id);
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_667165593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_667165593;
        // ---------- Original Method ----------
        //return getWindow().findViewById(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.728 -0400", hash_original_method = "EC6DC7C8BFDE6FF47CE21F97E3274EE5", hash_generated_method = "AF83D0E7EEA0FEC8CE7724A232967322")
    public ActionBar getActionBar() {
        ActionBar varB4EAC82CA7396A68D541C85D26508E83_518772761 = null; //Variable for return #1
        initActionBar();
        varB4EAC82CA7396A68D541C85D26508E83_518772761 = mActionBar;
        varB4EAC82CA7396A68D541C85D26508E83_518772761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_518772761;
        // ---------- Original Method ----------
        //initActionBar();
        //return mActionBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.742 -0400", hash_original_method = "1F37525CA4259BFCC1AC98918D267A3B", hash_generated_method = "8B0F15BFA211BAEC62C9B0E3B2FE030F")
    private void initActionBar() {
        Window window;
        window = getWindow();
        window.getDecorView();
        {
            boolean varDD4E522E8814A0C229F7C100E74BEA95_1362476517 = (isChild() || !window.hasFeature(Window.FEATURE_ACTION_BAR) || mActionBar != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.755 -0400", hash_original_method = "FC4CFA409E0DBC3CD2C86D908686341E", hash_generated_method = "99531264B62A1567E246A8B28A73A994")
    public void setContentView(int layoutResID) {
        getWindow().setContentView(layoutResID);
        initActionBar();
        addTaint(layoutResID);
        // ---------- Original Method ----------
        //getWindow().setContentView(layoutResID);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.770 -0400", hash_original_method = "6143DA20A0E63D3DD26D6D6CC3A0350F", hash_generated_method = "61FF09B5B4538CBB3A1FC06BBD5BABCD")
    public void setContentView(View view) {
        getWindow().setContentView(view);
        initActionBar();
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //getWindow().setContentView(view);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.780 -0400", hash_original_method = "FCB0E6F09A4D449F841F63B35D6A2C9A", hash_generated_method = "05A7DC4935A58527735DFAD3186107BA")
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getWindow().setContentView(view, params);
        initActionBar();
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //getWindow().setContentView(view, params);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.783 -0400", hash_original_method = "FC447FA34EAD1A15520CE5D8778BF36F", hash_generated_method = "10F6146D011E16DA07D2783A6955D172")
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getWindow().addContentView(view, params);
        initActionBar();
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //getWindow().addContentView(view, params);
        //initActionBar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.803 -0400", hash_original_method = "729048B37138D48F6A74BC6AFCECACEE", hash_generated_method = "0F9F517E80ECC2FDFAFC4F2FD7F8AC05")
    public void setFinishOnTouchOutside(boolean finish) {
        mWindow.setCloseOnTouchOutside(finish);
        addTaint(finish);
        // ---------- Original Method ----------
        //mWindow.setCloseOnTouchOutside(finish);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.815 -0400", hash_original_method = "84B2B4D9720193C8DC3107EE4335392B", hash_generated_method = "F8702E5326475477D335C1152AA7CA98")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.859 -0400", hash_original_method = "447EA7C05CB03D3ADA1829E3AD87227A", hash_generated_method = "76231CD2301C5C523E2F897E1DC91757")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                boolean var6C8C397317C30451187B86B88E0B9C4B_156775813 = (getApplicationInfo().targetSdkVersion
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
                boolean varBB73A2A4C4FF1B16BF9427D966A4A801_526810265 = (getWindow().performPanelShortcut(Window.FEATURE_OPTIONS_PANEL, 
                    keyCode, event, Menu.FLAG_ALWAYS_PERFORM_CLOSE));
            } //End collapsed parenthetic
        } //End block
        {
            boolean clearSpannable;
            clearSpannable = false;
            boolean handled;
            {
                boolean var083CEDCC9F1335B2AB0C1AAC01AAF679_1384989483 = ((event.getRepeatCount() != 0) || event.isSystem());
                {
                    clearSpannable = true;
                    handled = false;
                } //End block
                {
                    handled = TextKeyListener.getInstance().onKeyDown(
                        null, mDefaultKeySsb, keyCode, event);
                    {
                        boolean varEE1C0A7E7A940EF9FBEBBE171CEDD5A9_1084553259 = (handled && mDefaultKeySsb.length() > 0);
                        {
                            String str;
                            str = mDefaultKeySsb.toString();
                            clearSpannable = true;
                            //Begin case DEFAULT_KEYS_DIALER 
                            Intent intent;
                            intent = new Intent(Intent.ACTION_DIAL,  Uri.parse("tel:" + str));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_506159373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_506159373;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.871 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "7224CF77EEF81D03D8F1D8A035723953")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1326483514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1326483514;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.883 -0400", hash_original_method = "25B851F5D41453D6013FB2C2AA511AE1", hash_generated_method = "D16B77825B9BC536D59B2017E5A71EA9")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varDD97E8990072EF9A9394C8CEA67054A7_908313371 = (getApplicationInfo().targetSdkVersion
                >= Build.VERSION_CODES.ECLAIR);
            {
                {
                    boolean var1C6DFE5F80166C4CE3FD88815AAAD598_1673130246 = (keyCode == KeyEvent.KEYCODE_BACK && event.isTracking()
                    && !event.isCanceled());
                    {
                        onBackPressed();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749355686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749355686;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.911 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "387C308A45A1F774C016F8283FA9D407")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1795857252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1795857252;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.924 -0400", hash_original_method = "6AE13C43A807A8F581EF7E482513BDAF", hash_generated_method = "1227AAA5393A86EA4EE73DBA846C81A4")
    public void onBackPressed() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5C240956F2A34791A06A0F4236D73061_1741440661 = (!mFragments.popBackStackImmediate());
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!mFragments.popBackStackImmediate()) {
            //finish();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.926 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "00979CB40A3F9AB7BAE7C9C4893486AF")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30052858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_30052858;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.942 -0400", hash_original_method = "587C23A975B49ED816BE95A55AB82601", hash_generated_method = "341A5B1F324760A3F3F746D1D89E848D")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5B881718D56E5E510CAAD751F448A0C9_1367522355 = (mWindow.shouldCloseOnTouch(this, event));
            {
                finish();
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916754066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916754066;
        // ---------- Original Method ----------
        //if (mWindow.shouldCloseOnTouch(this, event)) {
            //finish();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.953 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "D8451EB84691297781EE35397222251E")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299839560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299839560;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.968 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "D4B296AE81707621C2657F4C36B74287")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515304450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515304450;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:37.970 -0400", hash_original_method = "787C037504CBD45EADF1B222AFA073D0", hash_generated_method = "A806D85F6475EA9E3D8F95C8B0E85BF8")
    public void onUserInteraction() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.000 -0400", hash_original_method = "1D902756EB8B1D6D1B39ED873E4CD230", hash_generated_method = "D5CD9C5FF1169C0E69B81B37AE5A9169")
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            View decor;
            decor = mDecor;
            {
                boolean var518FD95C1D322AE3CA22F3454EF80BC3_846253176 = (decor != null && decor.getParent() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.013 -0400", hash_original_method = "32D7339793DCE0D5AEFE6621981EC978", hash_generated_method = "15CE33052F85E41C1BB65E1E6B2C108A")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.015 -0400", hash_original_method = "C7622FC561A602386C2112BC0445F7C6", hash_generated_method = "EEF2114A935228AD19BFEE6FAB48379F")
    public void onWindowFocusChanged(boolean hasFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasFocus);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.024 -0400", hash_original_method = "D6E949EE9F0768F47016EEA4FC0347A8", hash_generated_method = "0E08FFA9282E502085CC6973CB60CDA1")
    public void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.025 -0400", hash_original_method = "E592299EBB4DE1D6696EB8C4009A9EF4", hash_generated_method = "1328510831112E7A424EFCA8583CA87C")
    public void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.043 -0400", hash_original_method = "7F717562D5C1B102DE657A2EE434F557", hash_generated_method = "2C7F093A9306F2D9C93CC08E11CF0150")
    public boolean hasWindowFocus() {
        Window w;
        w = getWindow();
        {
            View d;
            d = w.getDecorView();
            {
                boolean varB73A262141F3E017F7CE2E1136F11BDF_1678050623 = (d.hasWindowFocus());
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638798712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638798712;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.056 -0400", hash_original_method = "1A094AE61005DB4CDA2599E7F0A4A230", hash_generated_method = "FE94548D77F428CD45008DF075713D43")
    public boolean dispatchKeyEvent(KeyEvent event) {
        onUserInteraction();
        Window win;
        win = getWindow();
        {
            boolean varB72D02E2D60D06CF890A5BAC6ED691A6_185443352 = (win.superDispatchKeyEvent(event));
        } //End collapsed parenthetic
        View decor;
        decor = mDecor;
        decor = win.getDecorView();
        boolean var0F3BC286E711F8FE369DCCE6C96A1F39_244649865 = (event.dispatch(this, decor != null
                ? decor.getKeyDispatcherState() : null, this)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895008041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895008041;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.071 -0400", hash_original_method = "1BC9E6494D7E888C2866773840EEFAF2", hash_generated_method = "B3624DFDA1D0C82522EBDCC76FB1D542")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        onUserInteraction();
        {
            boolean var22B3DC591CCDF9027A8822387BB60CC1_1859229327 = (getWindow().superDispatchKeyShortcutEvent(event));
        } //End collapsed parenthetic
        boolean varB65319FC5255424F872A964CBDE1432E_523471275 = (onKeyShortcut(event.getKeyCode(), event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2054877899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2054877899;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchKeyShortcutEvent(event)) {
            //return true;
        //}
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.091 -0400", hash_original_method = "9C043C82D0E35283EE51DCEF499F92C6", hash_generated_method = "B12D24BA0FBCDA6FD3B6DDF0F878437B")
    public boolean dispatchTouchEvent(MotionEvent ev) {
        {
            boolean var89AADF399BE9B0E2DFA5C9BD5C451F2D_1540324240 = (ev.getAction() == MotionEvent.ACTION_DOWN);
            {
                onUserInteraction();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var63BEDD669BE8863D86EB2C005414F90C_1531934625 = (getWindow().superDispatchTouchEvent(ev));
        } //End collapsed parenthetic
        boolean var985DA2294C2CD7796EE4EFA7F3FBE91B_385698891 = (onTouchEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717465918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717465918;
        // ---------- Original Method ----------
        //if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //onUserInteraction();
        //}
        //if (getWindow().superDispatchTouchEvent(ev)) {
            //return true;
        //}
        //return onTouchEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.104 -0400", hash_original_method = "B4E564288E5B587F0E42C599C68E6C62", hash_generated_method = "38333C6F79781ACD09200FE96ECF36FF")
    public boolean dispatchTrackballEvent(MotionEvent ev) {
        onUserInteraction();
        {
            boolean var344CC3B3CF0390FD00C126501759FC6E_432003255 = (getWindow().superDispatchTrackballEvent(ev));
        } //End collapsed parenthetic
        boolean varE24895B72E913D801FFC5B9D9055D482_217062561 = (onTrackballEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169976873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169976873;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchTrackballEvent(ev)) {
            //return true;
        //}
        //return onTrackballEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.121 -0400", hash_original_method = "8A5C748F888ED0234B6228EEE9B28C6A", hash_generated_method = "3F91D3A69A24CD5742A405E0DA79CCA1")
    public boolean dispatchGenericMotionEvent(MotionEvent ev) {
        onUserInteraction();
        {
            boolean var0488FB753A1A4840338895882C17972B_370406114 = (getWindow().superDispatchGenericMotionEvent(ev));
        } //End collapsed parenthetic
        boolean var82ABE1E641E95D27D650D268E959F965_1175254894 = (onGenericMotionEvent(ev));
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533146566 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_533146566;
        // ---------- Original Method ----------
        //onUserInteraction();
        //if (getWindow().superDispatchGenericMotionEvent(ev)) {
            //return true;
        //}
        //return onGenericMotionEvent(ev);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.132 -0400", hash_original_method = "E0DA176D51FB90EA428361841719B862", hash_generated_method = "5D3D80D935817229D3854F1F56C09E22")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        event.setClassName(getClass().getName());
        event.setPackageName(getPackageName());
        LayoutParams params;
        params = getWindow().getAttributes();
        boolean isFullScreen;
        isFullScreen = (params.width == LayoutParams.MATCH_PARENT) &&
            (params.height == LayoutParams.MATCH_PARENT);
        event.setFullScreen(isFullScreen);
        CharSequence title;
        title = getTitle();
        {
            boolean var4315037A3FEAFB24D399CA884BFC6923_1639909274 = (!TextUtils.isEmpty(title));
            {
                event.getText().add(title);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300947935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300947935;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.151 -0400", hash_original_method = "8FB2859FE43E0606E21921E291A18BDA", hash_generated_method = "26D9E7B6262D8DC654EB021EC1353CAD")
    public View onCreatePanelView(int featureId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1385773199 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1385773199 = null;
        addTaint(featureId);
        varB4EAC82CA7396A68D541C85D26508E83_1385773199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1385773199;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.173 -0400", hash_original_method = "3CEBC68A0556AFB2BA0DA511B7D323DE", hash_generated_method = "4C7BF14C33AD230839E29392E821F811")
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean show;
            show = onCreateOptionsMenu(menu);
            show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
        } //End block
        addTaint(featureId);
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797222043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_797222043;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL) {
            //boolean show = onCreateOptionsMenu(menu);
            //show |= mFragments.dispatchCreateOptionsMenu(menu, getMenuInflater());
            //return show;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.368 -0400", hash_original_method = "A6A8332EF2663DFC6EB1A100F6AD5BEC", hash_generated_method = "BD591DD4B0AFD547D77FE8E58FA07F51")
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean goforit;
            goforit = onPrepareOptionsMenu(menu);
            goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            boolean var7116118DD297E6C08BE1AD40992AA51A_68246769 = (goforit && menu.hasVisibleItems());
        } //End block
        addTaint(featureId);
        addTaint(view.getTaint());
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_782793767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_782793767;
        // ---------- Original Method ----------
        //if (featureId == Window.FEATURE_OPTIONS_PANEL && menu != null) {
            //boolean goforit = onPrepareOptionsMenu(menu);
            //goforit |= mFragments.dispatchPrepareOptionsMenu(menu);
            //return goforit && menu.hasVisibleItems();
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.371 -0400", hash_original_method = "FE81CE57FF3B2984A6841999BDAFE276", hash_generated_method = "04B839C5FF036D6B553FC15955CBC309")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96425623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_96425623;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.379 -0400", hash_original_method = "06AE80A8039E39DC7E4DC1C38B6D66B0", hash_generated_method = "AB94B9B4B94DBFE040EFAFEB602B28DD")
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        EventLog.writeEvent(50000, 0, item.getTitleCondensed());
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        {
            boolean var3550B832F8A6DB96B87874C60FB2152D_1091676455 = (onOptionsItemSelected(item));
        } //End collapsed parenthetic
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_OPTIONS_PANEL 
        boolean varE8A690D6428BE61C39A35A33EE497930_1798569990 = (mFragments.dispatchOptionsItemSelected(item));
        //End case Window.FEATURE_OPTIONS_PANEL 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        EventLog.writeEvent(50000, 1, item.getTitleCondensed());
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        {
            boolean varB8F885094F9CD83DEADF429F082FB201_1115703368 = (onContextItemSelected(item));
        } //End collapsed parenthetic
        //End case Window.FEATURE_CONTEXT_MENU 
        //Begin case Window.FEATURE_CONTEXT_MENU 
        boolean var06F6B009CCB26CDE69B7F5C36D0D4DFE_1687005998 = (mFragments.dispatchContextItemSelected(item));
        //End case Window.FEATURE_CONTEXT_MENU 
        addTaint(featureId);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143884162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143884162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.390 -0400", hash_original_method = "89E795D5B25B105016E6897E97159EA1", hash_generated_method = "5CED3190A2B807A6AE080FFB5E3665E1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.408 -0400", hash_original_method = "319389EBA801B290FB41D02473EB2E9E", hash_generated_method = "E3CB03CA5E4EB5916215E567B4276E95")
    public void invalidateOptionsMenu() {
        mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.422 -0400", hash_original_method = "D798A5E9CBD6E094B476E3BCFB506C48", hash_generated_method = "E23FD81CA09340E9E4FF00E1D5A0E68B")
    public boolean onCreateOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varF935B90ABE5131DCB630E9E27DC64FE3_83110337 = (mParent.onCreateOptionsMenu(menu));
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324047133 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324047133;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onCreateOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.446 -0400", hash_original_method = "E91DC6A73B73F0C36C3453FFD6D52B27", hash_generated_method = "0ED19E853A294A1E25CEA262D1D8EE04")
    public boolean onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varAAB92CF1F1A4A0A344E7476B2B22B35C_1462252089 = (mParent.onPrepareOptionsMenu(menu));
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1021056017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1021056017;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onPrepareOptionsMenu(menu);
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.456 -0400", hash_original_method = "3F90928280ED0097B9620B898E691C1D", hash_generated_method = "2C812269240341CE9609A3E57CEA9F7C")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var47DFB44A8390EC1DC29AA40E602F6D38_979959690 = (mParent.onOptionsItemSelected(item));
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922552850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922552850;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onOptionsItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.469 -0400", hash_original_method = "F56CDE64C3E3D8A72B60F2808B2AA992", hash_generated_method = "F5AFA2FA4E4D9523C3E90F7709D7E7A5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.471 -0400", hash_original_method = "756759165F6AB2C8C6E469E63BE14186", hash_generated_method = "8F36C449192E9A4FC8F578B78BE7C244")
    public void openOptionsMenu() {
        mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
        // ---------- Original Method ----------
        //mWindow.openPanel(Window.FEATURE_OPTIONS_PANEL, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.496 -0400", hash_original_method = "D12ED1735BBB9BCDCD831C99F03640D7", hash_generated_method = "249BD0BDCB652EF31D4B735086D0BDEC")
    public void closeOptionsMenu() {
        mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_OPTIONS_PANEL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.513 -0400", hash_original_method = "85F2A519B2781A30F4BC68DB47459C98", hash_generated_method = "170D9A5A5BFA1A654CA19943D4D0F496")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.515 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "0FEECD9EF1102B65D35844FDFD151864")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        view.setOnCreateContextMenuListener(this);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.532 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "344591114B98358744F7FCF1C426D7AD")
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.533 -0400", hash_original_method = "D1451DBD5DFD14FAE397660897192E3C", hash_generated_method = "0E259D70C84DA1F0D8EA55F14095AA14")
    public void openContextMenu(View view) {
        view.showContextMenu();
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //view.showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.541 -0400", hash_original_method = "0F5BE8719D80390C88A4C0CDCF0E8C81", hash_generated_method = "A649B62C078D6DDA81669B8C50CB3152")
    public void closeContextMenu() {
        mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
        // ---------- Original Method ----------
        //mWindow.closePanel(Window.FEATURE_CONTEXT_MENU);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.547 -0400", hash_original_method = "BE982B537DFF57F9B4E6459A3621A4C0", hash_generated_method = "127EBD2DFB0279855B7D035A49F33AC2")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var7ECF1B2F229D5634CCEBD2144EC86F5A_639349901 = (mParent.onContextItemSelected(item));
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378677511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378677511;
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.onContextItemSelected(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.572 -0400", hash_original_method = "3B89231032C2ACDB0A53B5E9B36C3177", hash_generated_method = "289A28B79761B391DA11B88EBEFC8A18")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.591 -0400", hash_original_method = "5C4ABBE5E4F27E10ACC00467798D80D8", hash_generated_method = "B6D8BB49205784C1365993C4D991D9DA")
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1068335233 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1068335233 = null;
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_1068335233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1068335233;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.597 -0400", hash_original_method = "34E3D2628A4C0BFC6C20A449A8141897", hash_generated_method = "A99C42FD4589B8617924B3ACCEA55CDD")
    @Deprecated
    protected Dialog onCreateDialog(int id, Bundle args) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Dialog varB4EAC82CA7396A68D541C85D26508E83_1136893638 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1136893638 = onCreateDialog(id);
        addTaint(id);
        addTaint(args.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1136893638.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1136893638;
        // ---------- Original Method ----------
        //return onCreateDialog(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.608 -0400", hash_original_method = "7779942926F36CBECCFB305682D0E188", hash_generated_method = "5C8F94F2C9918C0B84A5BCEDC8DCAE6A")
    @Deprecated
    protected void onPrepareDialog(int id, Dialog dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dialog.setOwnerActivity(this);
        addTaint(id);
        addTaint(dialog.getTaint());
        // ---------- Original Method ----------
        //dialog.setOwnerActivity(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.626 -0400", hash_original_method = "5C5331293ECB563ADEBB709047E6FA90", hash_generated_method = "9422F52F9A944A595ABA094DA7D27D51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.629 -0400", hash_original_method = "C69337B465910082B7749F46A60AEA22", hash_generated_method = "2EA32EF1E9332B890938D738539A8F4C")
    @Deprecated
    public final void showDialog(int id) {
        showDialog(id, null);
        addTaint(id);
        // ---------- Original Method ----------
        //showDialog(id, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.669 -0400", hash_original_method = "3DD1E3020EFCD44C0CA311C29E1CC42D", hash_generated_method = "92946F8E202094898410C1743181D59B")
    @Deprecated
    public final boolean showDialog(int id, Bundle args) {
        {
            mManagedDialogs = new SparseArray<ManagedDialog>();
        } //End block
        ManagedDialog md;
        md = mManagedDialogs.get(id);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561227344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561227344;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.680 -0400", hash_original_method = "E601E473B0753C1FEDA76812E1FD9E58", hash_generated_method = "3AC14F418F5D868A49F4FC023E24F14E")
    @Deprecated
    public final void dismissDialog(int id) {
        {
            if (DroidSafeAndroidRuntime.control) throw missingDialog(id);
        } //End block
        ManagedDialog md;
        md = mManagedDialogs.get(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.701 -0400", hash_original_method = "A39236F46CF5FE1491F0C82DFDF249BB", hash_generated_method = "7EF7B1A35158C46D52D731BD56C3C950")
    private IllegalArgumentException missingDialog(int id) {
        IllegalArgumentException varB4EAC82CA7396A68D541C85D26508E83_2036752151 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2036752151 = new IllegalArgumentException("no dialog with id " + id + " was ever "
                + "shown via Activity#showDialog");
        addTaint(id);
        varB4EAC82CA7396A68D541C85D26508E83_2036752151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2036752151;
        // ---------- Original Method ----------
        //return new IllegalArgumentException("no dialog with id " + id + " was ever "
                //+ "shown via Activity#showDialog");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.703 -0400", hash_original_method = "3D1D9959965F7A331D31AA1B43803DC2", hash_generated_method = "EC38D07625A03BEB071ED6AC6FA7D09C")
    @Deprecated
    public final void removeDialog(int id) {
        {
            ManagedDialog md;
            md = mManagedDialogs.get(id);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.722 -0400", hash_original_method = "0DF3BA4E928401133F2B75C6B5EB4631", hash_generated_method = "F500AAEE974F3C0AA98C72187C1F8CE8")
    public boolean onSearchRequested() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        startSearch(null, false, null, false);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1302560909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1302560909;
        // ---------- Original Method ----------
        //startSearch(null, false, null, false);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.728 -0400", hash_original_method = "E294F26A29AF2F9D8B2D38BC4A0138F5", hash_generated_method = "1C0121E8942AAFED9A6DD6719AAA0DBB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.754 -0400", hash_original_method = "A3EE90277ACB35FF640742FD629291A1", hash_generated_method = "1B35D2DF8EB410E5AED714A16AD3EF54")
    public void triggerSearch(String query, Bundle appSearchData) {
        ensureSearchManager();
        mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
        addTaint(query.getTaint());
        addTaint(appSearchData.getTaint());
        // ---------- Original Method ----------
        //ensureSearchManager();
        //mSearchManager.triggerSearch(query, getComponentName(), appSearchData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.763 -0400", hash_original_method = "0192041795732D663EE503A2AEC04112", hash_generated_method = "1C4EC0D223F9E3DCEC8DCF0D86A4D651")
    public void takeKeyEvents(boolean get) {
        getWindow().takeKeyEvents(get);
        addTaint(get);
        // ---------- Original Method ----------
        //getWindow().takeKeyEvents(get);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.770 -0400", hash_original_method = "3CDF417FCD4F33EAE6CFCF0FB6D583A8", hash_generated_method = "268CE8D0EE7C69DCFF20E2AC0496125C")
    public final boolean requestWindowFeature(int featureId) {
        boolean varB82514052F40771017139C27F50D7D45_1366267855 = (getWindow().requestFeature(featureId));
        addTaint(featureId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435122832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_435122832;
        // ---------- Original Method ----------
        //return getWindow().requestFeature(featureId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.788 -0400", hash_original_method = "E7AFD534CB1DF8060614ED36111B2407", hash_generated_method = "1D84D45038FD5866F8926E34F140C5A2")
    public final void setFeatureDrawableResource(int featureId, int resId) {
        getWindow().setFeatureDrawableResource(featureId, resId);
        addTaint(featureId);
        addTaint(resId);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableResource(featureId, resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.790 -0400", hash_original_method = "2E53659D6309BF8C5C8E8AD82BD6A577", hash_generated_method = "2B27B06D57220A2D7BDBB2E34E6E392C")
    public final void setFeatureDrawableUri(int featureId, Uri uri) {
        getWindow().setFeatureDrawableUri(featureId, uri);
        addTaint(featureId);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableUri(featureId, uri);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.807 -0400", hash_original_method = "D3FA0A5870730A6F3C959B16FC004BCD", hash_generated_method = "F557D4B7A04B56974C87A9013515B72F")
    public final void setFeatureDrawable(int featureId, Drawable drawable) {
        getWindow().setFeatureDrawable(featureId, drawable);
        addTaint(featureId);
        addTaint(drawable.getTaint());
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawable(featureId, drawable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.810 -0400", hash_original_method = "4D2A81FF8C2C83F47460DEB3120C04CB", hash_generated_method = "04310BD6B9B4218E4C6AF4E9D6650F61")
    public final void setFeatureDrawableAlpha(int featureId, int alpha) {
        getWindow().setFeatureDrawableAlpha(featureId, alpha);
        addTaint(featureId);
        addTaint(alpha);
        // ---------- Original Method ----------
        //getWindow().setFeatureDrawableAlpha(featureId, alpha);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.824 -0400", hash_original_method = "2F200E491A9F2CDC38C392035D21ED48", hash_generated_method = "14A448CAAA710CA18AFAD6C364D50CB9")
    public LayoutInflater getLayoutInflater() {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_1536704067 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1536704067 = getWindow().getLayoutInflater();
        varB4EAC82CA7396A68D541C85D26508E83_1536704067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536704067;
        // ---------- Original Method ----------
        //return getWindow().getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.840 -0400", hash_original_method = "E3707649B39EF110B7161F89DE89D715", hash_generated_method = "ADC42A7F80447C2D501885E6AE56D269")
    public MenuInflater getMenuInflater() {
        MenuInflater varB4EAC82CA7396A68D541C85D26508E83_1410513996 = null; //Variable for return #1
        {
            initActionBar();
            {
                mMenuInflater = new MenuInflater(mActionBar.getThemedContext());
            } //End block
            {
                mMenuInflater = new MenuInflater(this);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1410513996 = mMenuInflater;
        varB4EAC82CA7396A68D541C85D26508E83_1410513996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1410513996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.853 -0400", hash_original_method = "4857987668195170B5763D3AC5F48499", hash_generated_method = "6CDAB149CA785B821DB941A7AAB1BC80")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.867 -0400", hash_original_method = "30D6BE1E6EC7F84FBEF609A16BE7CA4B", hash_generated_method = "5C71865E1986F3B0D4C7AE93FFCE783E")
    public void startActivityForResult(Intent intent, int requestCode) {
        {
            Instrumentation.ActivityResult ar;
            ar = mInstrumentation.execStartActivity(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.895 -0400", hash_original_method = "97600DFB6FE5B26D9938AA60DE8024CD", hash_generated_method = "FA10EF31903F88D2581DE195777EC527")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.904 -0400", hash_original_method = "5FAE47F5C92447A2EE7F29A0B33663DC", hash_generated_method = "5645BBE44453067E14D18409744B25E7")
    private void startIntentSenderForResultInner(IntentSender intent, int requestCode,
            Intent fillInIntent, int flagsMask, int flagsValues, Activity activity) throws IntentSender.SendIntentException {
        try 
        {
            String resolvedType;
            resolvedType = null;
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } //End block
            int result;
            result = ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.926 -0400", hash_original_method = "496A47C2900A9596F27A50B4876A4F74", hash_generated_method = "7E32BC9F71CA50B44AEBBB0B32CF0606")
    @Override
    public void startActivity(Intent intent) {
        startActivityForResult(intent, -1);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //startActivityForResult(intent, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.929 -0400", hash_original_method = "E2A55AFC4750254BD88786F18353EE8B", hash_generated_method = "7D07A5F51482F3088CADC2E5114E30E8")
    @Override
    public void startActivities(Intent[] intents) {
        mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                mToken, this, intents);
        addTaint(intents[0].getTaint());
        // ---------- Original Method ----------
        //mInstrumentation.execStartActivities(this, mMainThread.getApplicationThread(),
                //mToken, this, intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.956 -0400", hash_original_method = "9F69F403C1C5722F41E10FF600B75C73", hash_generated_method = "53FC79B0A90985C80375B1F1564CCE14")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.961 -0400", hash_original_method = "190134DCA27346A23C03C3693BD2B9AA", hash_generated_method = "25C8FAEC26C9DBDCC0EB382C12984697")
    public boolean startActivityIfNeeded(Intent intent, int requestCode) {
        {
            int result;
            result = IActivityManager.START_RETURN_INTENT_TO_CALLER;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851061458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851061458;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:38.979 -0400", hash_original_method = "BA57A0705EEE92F3B7079102E9F6CF18", hash_generated_method = "CBE6EE3FDB0FB8C907EEE631EAC7A02D")
    public boolean startNextMatchingActivity(Intent intent) {
        {
            try 
            {
                intent.setAllowFds(false);
                boolean var48E21F8A126EF0CF3E2826B5E3578F5C_1324293477 = (ActivityManagerNative.getDefault()
                    .startNextMatchingActivity(mToken, intent));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "startNextMatchingActivity can only be called from a top-level activity");
        addTaint(intent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404661250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_404661250;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.220 -0400", hash_original_method = "DF04C3C173E07E956B29F2B3DAB7E481", hash_generated_method = "DE311F65AC996E5102B3505F3399A101")
    public void startActivityFromChild(Activity child, Intent intent, 
            int requestCode) {
        Instrumentation.ActivityResult ar;
        ar = mInstrumentation.execStartActivity(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.229 -0400", hash_original_method = "5E733A6053D527FE1D06898E4868AC5B", hash_generated_method = "9418D7A5694E6B567697750097F9BCD1")
    public void startActivityFromFragment(Fragment fragment, Intent intent, 
            int requestCode) {
        Instrumentation.ActivityResult ar;
        ar = mInstrumentation.execStartActivity(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.234 -0400", hash_original_method = "39BD7073F28230B53A756B456127D77C", hash_generated_method = "03BC87FA40B57EECC467DABFFB2B357D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.262 -0400", hash_original_method = "0CB07497B5E56C46E5A71AB5CB4CC143", hash_generated_method = "3C3AE556460FDD4910F9956EE91C22B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.271 -0400", hash_original_method = "A1F0E9D1C51A75D776561E1E894349B6", hash_generated_method = "CBA7E9A53147862BFCEA6CECBA6507F1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.273 -0400", hash_original_method = "6BED503DFB65A20EFD511A0C71BBBEA5", hash_generated_method = "66418680AB3895336C309FFB7F7A89BA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.297 -0400", hash_original_method = "88476E01B039440C5805C3F210A00F20", hash_generated_method = "B3B6A7CA3954AA6E28719FB34479D8E2")
    public String getCallingPackage() {
        String varB4EAC82CA7396A68D541C85D26508E83_458968725 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1652517559 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_458968725 = ActivityManagerNative.getDefault().getCallingPackage(mToken);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1652517559 = null;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1272936873; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1272936873 = varB4EAC82CA7396A68D541C85D26508E83_458968725;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1272936873 = varB4EAC82CA7396A68D541C85D26508E83_1652517559;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1272936873.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1272936873;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingPackage(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.325 -0400", hash_original_method = "BA5844B2C9F3C6D12393731B7AECDFB9", hash_generated_method = "1053173E7F5703C3C46C238BE50E1B23")
    public ComponentName getCallingActivity() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1985045478 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_962836302 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1985045478 = ActivityManagerNative.getDefault().getCallingActivity(mToken);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_962836302 = null;
        } //End block
        ComponentName varA7E53CE21691AB073D9660D615818899_1241850085; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1241850085 = varB4EAC82CA7396A68D541C85D26508E83_1985045478;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1241850085 = varB4EAC82CA7396A68D541C85D26508E83_962836302;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1241850085.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1241850085;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().getCallingActivity(mToken);
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.330 -0400", hash_original_method = "0E2F74853BCADD728740841EA37367F9", hash_generated_method = "98C465A75DCF544E2D7649C493FC173F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.347 -0400", hash_original_method = "FB761D67DEFD95C853371C7404DC7410", hash_generated_method = "E96E8EF98F9D8728FE14E4FCA26AD5B0")
     void makeVisible() {
        {
            ViewManager wm;
            wm = getWindowManager();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.357 -0400", hash_original_method = "43D5EE376AB6A31BE07F9DEA063A3A15", hash_generated_method = "47388F1DB5AC92DCDC657E1CED29DD6B")
    public boolean isFinishing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991361396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_991361396;
        // ---------- Original Method ----------
        //return mFinished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.375 -0400", hash_original_method = "FE2E80A11740332998069879BC688861", hash_generated_method = "EC6047B86DA7117A87CA079BB1BAFA97")
    public boolean isChangingConfigurations() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_186803771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_186803771;
        // ---------- Original Method ----------
        //return mChangingConfigurations;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.377 -0400", hash_original_method = "3298831B26ECD21F1FDB51A320DC7BE6", hash_generated_method = "5163A1FEB6220452765BBFE747D0F147")
    public void recreate() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can only be called on top-level activity");
        } //End block
        {
            boolean var61A058F6D0650572B0637A5D7A729D5C_229810759 = (Looper.myLooper() != mMainThread.getLooper());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.393 -0400", hash_original_method = "996A5282391C6D355ADB156CA1D0ED89", hash_generated_method = "D804952A9E239D335080203B147D8D50")
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
                    boolean var98DEA089FC32BBD5488A00FF4FF0CC1E_1668294494 = (ActivityManagerNative.getDefault()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.408 -0400", hash_original_method = "75F7E4E1E03EB9263BD8694C580B708B", hash_generated_method = "95D8EA88836F03895ACAE5F76BE9CDDC")
    public void finishFromChild(Activity child) {
        finish();
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //finish();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.411 -0400", hash_original_method = "5ADA8FCD727B0FDDA383F561FB00E0D6", hash_generated_method = "7E7C91CA52C29DBAB74C5FA347EF2F40")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.424 -0400", hash_original_method = "78F43A087FD65470CED68BD5979667B7", hash_generated_method = "A17C18FD8318DD04E820B34B2C2A868B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.439 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "FA2BB58664560B8B761B02F0C8FA09C1")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.459 -0400", hash_original_method = "724A566EB4440BBE32F479663ADACFA1", hash_generated_method = "2AC66358565D3D685EA0300B3A19E68E")
    public PendingIntent createPendingResult(int requestCode, Intent data,
            int flags) {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_118937589 = null; //Variable for return #1
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_507980784 = null; //Variable for return #2
        String packageName;
        packageName = getPackageName();
        try 
        {
            data.setAllowFds(false);
            IIntentSender target;
            target = ActivityManagerNative.getDefault().getIntentSender(
                        IActivityManager.INTENT_SENDER_ACTIVITY_RESULT, packageName,
                        mParent == null ? mToken : mParent.mToken,
                        mEmbeddedID, requestCode, new Intent[] { data }, null, flags);//DSFIXME:  CODE0008: Nested ternary operator in expression
            varB4EAC82CA7396A68D541C85D26508E83_118937589 = target != null ? new PendingIntent(target) : null;
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_507980784 = null;
        addTaint(requestCode);
        addTaint(data.getTaint());
        addTaint(flags);
        PendingIntent varA7E53CE21691AB073D9660D615818899_1741989898; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1741989898 = varB4EAC82CA7396A68D541C85D26508E83_118937589;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1741989898 = varB4EAC82CA7396A68D541C85D26508E83_507980784;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1741989898.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1741989898;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.467 -0400", hash_original_method = "AB602316CD63B19CFF08DCE67D0ABE67", hash_generated_method = "5CDD1FBB0154268F02D99F0D81B8C6FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.495 -0400", hash_original_method = "DB34404EF91E1F4006BE0A78903A055D", hash_generated_method = "31694DD255C0451CEB81F4A67566984A")
    public int getRequestedOrientation() {
        {
            try 
            {
                int varF73A2C1D42F32A8E880FEE19D43552B0_1257630636 = (ActivityManagerNative.getDefault()
                        .getRequestedOrientation(mToken));
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            int var6BA699CCE9FE9ECEB5C2EB944481D0CA_1541489540 = (mParent.getRequestedOrientation());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570348768 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1570348768;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.506 -0400", hash_original_method = "617D78E91C885EF783A85ACE788D978C", hash_generated_method = "3378A05F5732CA8AA2026F50920AF7B4")
    public int getTaskId() {
        try 
        {
            int varB14910B437D45BFD02C50351FBFB3D89_749635655 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, false));
        } //End block
        catch (RemoteException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936779051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936779051;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, false);
        //} catch (RemoteException e) {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.519 -0400", hash_original_method = "6E45F873D7236EF61D26B672F842F45F", hash_generated_method = "FE13DCD40749C8B2BDCFEBF0AF457BEB")
    public boolean isTaskRoot() {
        try 
        {
            boolean var4B80DC96910152E8758D098D1964B8FB_1782299691 = (ActivityManagerNative.getDefault()
                .getTaskForActivity(mToken, true) >= 0);
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039733323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039733323;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault()
                //.getTaskForActivity(mToken, true) >= 0;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.525 -0400", hash_original_method = "9A59EFD62BA4B2B1BB27D9BF60C81F37", hash_generated_method = "722300B663FD5986DF7E042FC6377070")
    public boolean moveTaskToBack(boolean nonRoot) {
        try 
        {
            boolean var098F37A659AB56219B499ADFB5DCEEF7_1624151333 = (ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    mToken, nonRoot));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(nonRoot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951416738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951416738;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().moveActivityTaskToBack(
                    //mToken, nonRoot);
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.555 -0400", hash_original_method = "551AAFB8F3EA920969607A2C223A3A3A", hash_generated_method = "32BDA91A976C9267431A7744DCF41219")
    public String getLocalClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_436362127 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_817657562 = null; //Variable for return #2
        String pkg;
        pkg = getPackageName();
        String cls;
        cls = mComponent.getClassName();
        int packageLen;
        packageLen = pkg.length();
        {
            boolean var0EAAC10B288339C1570AA8AB20356E7A_1743869615 = (!cls.startsWith(pkg) || cls.length() <= packageLen
                || cls.charAt(packageLen) != '.');
            {
                varB4EAC82CA7396A68D541C85D26508E83_436362127 = cls;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_817657562 = cls.substring(packageLen+1);
        String varA7E53CE21691AB073D9660D615818899_1403354341; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1403354341 = varB4EAC82CA7396A68D541C85D26508E83_436362127;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1403354341 = varB4EAC82CA7396A68D541C85D26508E83_817657562;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1403354341.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1403354341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.570 -0400", hash_original_method = "6C1D36E28C0C97736EA4779A7FB1715C", hash_generated_method = "BC046C9290D6CA2BCA18C46B5B92AEDC")
    public ComponentName getComponentName() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_2138220692 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2138220692 = mComponent;
        varB4EAC82CA7396A68D541C85D26508E83_2138220692.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2138220692;
        // ---------- Original Method ----------
        //return mComponent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.573 -0400", hash_original_method = "8FF11253989B916424A8F19A417B9894", hash_generated_method = "1B0635E429CE6DC686C10BC7E42C5732")
    public SharedPreferences getPreferences(int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1183792329 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1183792329 = getSharedPreferences(getLocalClassName(), mode);
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1183792329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1183792329;
        // ---------- Original Method ----------
        //return getSharedPreferences(getLocalClassName(), mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.578 -0400", hash_original_method = "4647E231E061B70291C2AAA883C4D14E", hash_generated_method = "74AAF8A2D90559508EC965512345BF71")
    private void ensureSearchManager() {
        mSearchManager = new SearchManager(this, null);
        // ---------- Original Method ----------
        //if (mSearchManager != null) {
            //return;
        //}
        //mSearchManager = new SearchManager(this, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.605 -0400", hash_original_method = "C911C3513CF522AB406EF738AFCD068D", hash_generated_method = "9C9E123E56E4E1E2ABBEB2E88E20E0CA")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1774066702 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_231762273 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1628492193 = null; //Variable for return #3
        {
            boolean var147AC2BBBF3AEE182DB26FB40142700F_482637241 = (getBaseContext() == null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "System services not available to Activities before onCreate()");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1CCF0F4FD95ED5B34F2142B4928344D1_1479491485 = (WINDOW_SERVICE.equals(name));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1774066702 = mWindowManager;
            } //End block
            {
                boolean var2768C019CA3E7B10A866FFEC217F769C_1328425865 = (SEARCH_SERVICE.equals(name));
                {
                    ensureSearchManager();
                    varB4EAC82CA7396A68D541C85D26508E83_231762273 = mSearchManager;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1628492193 = super.getSystemService(name);
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1607016157; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1607016157 = varB4EAC82CA7396A68D541C85D26508E83_1774066702;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1607016157 = varB4EAC82CA7396A68D541C85D26508E83_231762273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1607016157 = varB4EAC82CA7396A68D541C85D26508E83_1628492193;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1607016157.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1607016157;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.625 -0400", hash_original_method = "917DB493889E2A2E4400765775D2C5BF", hash_generated_method = "803D7E132DC6DFFEC761022DE8638786")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.627 -0400", hash_original_method = "A39F8277E51A7F6BD4A471D6255FEBC5", hash_generated_method = "74E2CECC78E84CDA22FC324C82785781")
    public void setTitle(int titleId) {
        setTitle(getText(titleId));
        addTaint(titleId);
        // ---------- Original Method ----------
        //setTitle(getText(titleId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.646 -0400", hash_original_method = "FA24EF1A624DFEEBC72DEB2A718D69DE", hash_generated_method = "BC4A216472427DDD027996C04C5326DB")
    public void setTitleColor(int textColor) {
        mTitleColor = textColor;
        onTitleChanged(mTitle, textColor);
        // ---------- Original Method ----------
        //mTitleColor = textColor;
        //onTitleChanged(mTitle, textColor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.649 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "6B2241C7D267166B7102CBBA6BBDEBB6")
    public final CharSequence getTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1285613420 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1285613420 = mTitle;
        varB4EAC82CA7396A68D541C85D26508E83_1285613420.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285613420;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.650 -0400", hash_original_method = "96312D04BD6FB534546AC8090A725A72", hash_generated_method = "000E49074C1D86398EEE29BAC42C74F3")
    public final int getTitleColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907421826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907421826;
        // ---------- Original Method ----------
        //return mTitleColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.663 -0400", hash_original_method = "907C0E9079D015DC414B2AE462CAF06D", hash_generated_method = "68900A962EFB8C3375FA8E31383644C1")
    protected void onTitleChanged(CharSequence title, int color) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Window win;
            win = getWindow();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.665 -0400", hash_original_method = "7A7CC5A839395F1C996BC46DE28C9533", hash_generated_method = "47D28BBF002CF6FFA1CB46B0EBB355C9")
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(childActivity.getTaint());
        addTaint(title.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.679 -0400", hash_original_method = "32B6571BC6889F247F99CDBE3AE16965", hash_generated_method = "C5A973EF9F1894795713A701D8A54420")
    public final void setProgressBarVisibility(boolean visible) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            Window.PROGRESS_VISIBILITY_OFF);
        addTaint(visible);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, visible ? Window.PROGRESS_VISIBILITY_ON :
            //Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.695 -0400", hash_original_method = "1DF5015282F18776361652D68AED30B4", hash_generated_method = "3EA7373D37F405FB95C46CF566ECA25A")
    public final void setProgressBarIndeterminateVisibility(boolean visible) {
        getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
        addTaint(visible);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_INDETERMINATE_PROGRESS,
                //visible ? Window.PROGRESS_VISIBILITY_ON : Window.PROGRESS_VISIBILITY_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.713 -0400", hash_original_method = "2F28E974BBABA05D28D9AF73C25D13FA", hash_generated_method = "5E7C9F5DD29C9C9A48FCCFA6469CB37F")
    public final void setProgressBarIndeterminate(boolean indeterminate) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
        addTaint(indeterminate);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //indeterminate ? Window.PROGRESS_INDETERMINATE_ON : Window.PROGRESS_INDETERMINATE_OFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.715 -0400", hash_original_method = "55067894B88907AA64DBBC76309FF362", hash_generated_method = "859E0EDEA9F9F5AE9DDB25BA660309E7")
    public final void setProgress(int progress) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
        addTaint(progress);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS, progress + Window.PROGRESS_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.733 -0400", hash_original_method = "FF0EFB07F2D369BD624208547BA4F187", hash_generated_method = "C4E25A3829BBFD1BF97CF8A6EE368191")
    public final void setSecondaryProgress(int secondaryProgress) {
        getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                secondaryProgress + Window.PROGRESS_SECONDARY_START);
        addTaint(secondaryProgress);
        // ---------- Original Method ----------
        //getWindow().setFeatureInt(Window.FEATURE_PROGRESS,
                //secondaryProgress + Window.PROGRESS_SECONDARY_START);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.735 -0400", hash_original_method = "70729F29EB37CCBEC739A5986214C32F", hash_generated_method = "2764BD226534A1A95BF3BECEF1136ABC")
    public final void setVolumeControlStream(int streamType) {
        getWindow().setVolumeControlStream(streamType);
        addTaint(streamType);
        // ---------- Original Method ----------
        //getWindow().setVolumeControlStream(streamType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.753 -0400", hash_original_method = "03A841DC7655848901B3CE2C14084AAE", hash_generated_method = "A378E85FE490CEF98A721B904E188B55")
    public final int getVolumeControlStream() {
        int var10019DD6073F3F6675C482019A78518D_1305308887 = (getWindow().getVolumeControlStream());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249600435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1249600435;
        // ---------- Original Method ----------
        //return getWindow().getVolumeControlStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.768 -0400", hash_original_method = "691B4E9428578C2267EA5A6538081943", hash_generated_method = "D2EF00F63E76A3872E681C23ADE038F1")
    public final void runOnUiThread(Runnable action) {
        {
            boolean varD46220B6DBDB2780BC14591AF2433BD7_344855790 = (Thread.currentThread() != mUiThread);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.770 -0400", hash_original_method = "C11741BEACAA4DD4B803A04296254194", hash_generated_method = "E9B22690000CEAD3C4E1C03E51D61FC4")
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_1746748907 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1746748907 = null;
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1746748907.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1746748907;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.843 -0400", hash_original_method = "6AED635285422A876000505F10FFFED0", hash_generated_method = "A235BD089689E30B41308FC68452A591")
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        View varB4EAC82CA7396A68D541C85D26508E83_2037813086 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1296161801 = null; //Variable for return #2
        {
            boolean var0F10F717A8824D895C9119EA392D7F2A_734863817 = (!"fragment".equals(name));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2037813086 = onCreateView(name, context, attrs);
            } //End block
        } //End collapsed parenthetic
        String fname;
        fname = attrs.getAttributeValue(null, "class");
        TypedArray a;
        a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.Fragment);
        {
            fname = a.getString(com.android.internal.R.styleable.Fragment_name);
        } //End block
        int id;
        id = a.getResourceId(com.android.internal.R.styleable.Fragment_id, View.NO_ID);
        String tag;
        tag = a.getString(com.android.internal.R.styleable.Fragment_tag);
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
            boolean var28AAFB4908746F4035C573FBEA5D04E5_1749855061 = (fragment.mView.getTag() == null);
            {
                fragment.mView.setTag(tag);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1296161801 = fragment.mView;
        addTaint(parent.getTaint());
        addTaint(name.getTaint());
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1861766811; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1861766811 = varB4EAC82CA7396A68D541C85D26508E83_2037813086;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1861766811 = varB4EAC82CA7396A68D541C85D26508E83_1296161801;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1861766811.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1861766811;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.036 -0400", hash_original_method = "A3B02D247D35A4A6189512589B728713", hash_generated_method = "52E53E339BADD8D252B000E6A5B5F26A")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("Local Activity ");
        writer.print(Integer.toHexString(System.identityHashCode(this)));
        writer.println(" State:");
        String innerPrefix;
        innerPrefix = prefix + "  ";
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.056 -0400", hash_original_method = "F5F1BD517EE731E56F922C1A6872A499", hash_generated_method = "3CE116CFDE2DF849F8FFEDE3FB09C171")
    public boolean isImmersive() {
        try 
        {
            boolean var8E24EC029BEB1ED19FFEAC6EBBA9556E_970037381 = (ActivityManagerNative.getDefault().isImmersive(mToken));
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1540072122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1540072122;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().isImmersive(mToken);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.065 -0400", hash_original_method = "9D8EB8E29C9BCD315046F1934B1FF39B", hash_generated_method = "F967F018A9C613C44B7AACBB5F12019D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.068 -0400", hash_original_method = "2C973E12746FE944D244FE9652432CFA", hash_generated_method = "84827B62D5B794D8B6AB4691CF5642D1")
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_587782927 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_587782927 = mWindow.getDecorView().startActionMode(callback);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_587782927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_587782927;
        // ---------- Original Method ----------
        //return mWindow.getDecorView().startActionMode(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.090 -0400", hash_original_method = "371F08E85934452E39039D6D8CFF84EA", hash_generated_method = "265B5686096D8FCA7D7DAC00536D5BAF")
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_812416424 = null; //Variable for return #1
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1508238509 = null; //Variable for return #2
        initActionBar();
        {
            varB4EAC82CA7396A68D541C85D26508E83_812416424 = mActionBar.startActionMode(callback);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1508238509 = null;
        addTaint(callback.getTaint());
        ActionMode varA7E53CE21691AB073D9660D615818899_1832222480; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1832222480 = varB4EAC82CA7396A68D541C85D26508E83_812416424;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1832222480 = varB4EAC82CA7396A68D541C85D26508E83_1508238509;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1832222480.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1832222480;
        // ---------- Original Method ----------
        //initActionBar();
        //if (mActionBar != null) {
            //return mActionBar.startActionMode(callback);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.105 -0400", hash_original_method = "255BA88D048ED7CA66014BFC1FF334C0", hash_generated_method = "5C31F22675E6C5EC34FEE649E89B1DA7")
    public void onActionModeStarted(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.107 -0400", hash_original_method = "731D5E497065CC7A99050B1E6205CD2C", hash_generated_method = "8341400BB35382A7F4737BEFC40A4A06")
    public void onActionModeFinished(ActionMode mode) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.135 -0400", hash_original_method = "CB0EFE3ADA1587CB31B88C9EC51AC6CD", hash_generated_method = "51CAD08D31A322104F1A9E253F06E70C")
    final void setParent(Activity parent) {
        mParent = parent;
        // ---------- Original Method ----------
        //mParent = parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.138 -0400", hash_original_method = "F5D036702945AFC6D1167650D88CF89C", hash_generated_method = "0C47A382579D247541533956F3D67822")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.177 -0400", hash_original_method = "1337919A8B79C562A3EF2FA6EE3B4075", hash_generated_method = "3C7499855B2FB72A6DC51EFDAAC4B253")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.188 -0400", hash_original_method = "032FECF5166BB774C48681F5A73546B5", hash_generated_method = "E1D5E782C0BA65FDBC3FE6873071F5C2")
    final IBinder getActivityToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_2115844240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115844240 = mParent != null ? mParent.getActivityToken() : mToken;
        varB4EAC82CA7396A68D541C85D26508E83_2115844240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115844240;
        // ---------- Original Method ----------
        //return mParent != null ? mParent.getActivityToken() : mToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.204 -0400", hash_original_method = "DAB379B095765C858B51976FA2FCF6E4", hash_generated_method = "B5B8BA41346A89857C284FC24F96A375")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.235 -0400", hash_original_method = "82BCF6383A02A95A38B6B2EB9C1C7555", hash_generated_method = "D7916EBEEC24C8591B41D0F2AE192A8A")
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
                int i;
                i = mAllLoaderManagers.size()-1;
                {
                    LoaderManagerImpl lm;
                    lm = mAllLoaderManagers.valueAt(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.277 -0400", hash_original_method = "3EBAEF204822031FA104B5D3C8D08DD5", hash_generated_method = "63EA1675A2C3938D4F39CA8BB8301864")
    final void performRestart() {
        mFragments.noteStateNotSaved();
        {
            mStopped = false;
            {
                WindowManagerImpl.getDefault().setStoppedState(mToken, false);
            } //End block
            {
                int N;
                N = mManagedCursors.size();
                {
                    int i;
                    i = 0;
                    {
                        ManagedCursor mc;
                        mc = mManagedCursors.get(i);
                        {
                            {
                                boolean var04A5C84C1C3F081B6B9C5407629BB7FE_1156839754 = (!mc.mCursor.requery());
                                {
                                    {
                                        boolean varF1BBC5758062A55B0A9400E3F4AF6947_1724267912 = (getApplicationInfo().targetSdkVersion
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.313 -0400", hash_original_method = "F35F1467F0B7E6EEBE9DD69D8D6AD358", hash_generated_method = "524EF6E5195B2CDE387F3EC9A59B137C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.324 -0400", hash_original_method = "F81A8DB24B00685E2B896EC5528AF34D", hash_generated_method = "1D3EED3AE940323919631DA0E64BDE1C")
    final void performPause() {
        mFragments.dispatchPause();
        mCalled = false;
        onPause();
        mResumed = false;
        {
            boolean varAE0213A865A9842D2D0B2E8D0A5C03B4_959683349 = (!mCalled && getApplicationInfo().targetSdkVersion
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.326 -0400", hash_original_method = "ABDB3944564BF35742E6297221FCB3EA", hash_generated_method = "31170BEEC73668AEDE9E7F6B4C817A47")
    final void performUserLeaving() {
        onUserInteraction();
        onUserLeaveHint();
        // ---------- Original Method ----------
        //onUserInteraction();
        //onUserLeaveHint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.360 -0400", hash_original_method = "1444D8CCB63DB563C5707F75C9D1FF30", hash_generated_method = "0453AE17022F2252C680A49D261C8411")
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
                int N;
                N = mManagedCursors.size();
                {
                    int i;
                    i = 0;
                    {
                        ManagedCursor mc;
                        mc = mManagedCursors.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.377 -0400", hash_original_method = "1C8656F81B9FFA0D582D8F6098E0BE30", hash_generated_method = "4E1B7C77883127F7CF94D3870067FF51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.382 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "DAABE338E751339316047F7FA37CEDBA")
    public final boolean isResumed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636644611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636644611;
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.401 -0400", hash_original_method = "9EF1B69B76655E6A901B5D291A25C28E", hash_generated_method = "5AF4A5B9DECCA23CFF65C7B2ECF85175")
     void dispatchActivityResult(String who, int requestCode, 
        int resultCode, Intent data) {
        mFragments.noteStateNotSaved();
        {
            onActivityResult(requestCode, resultCode, data);
        } //End block
        {
            Fragment frag;
            frag = mFragments.findFragmentByWho(who);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.415 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "0C87BCBAF0D95855709E5BEE2BDBA46D")

        Dialog mDialog;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.416 -0400", hash_original_field = "E8543AD9E6F42B0AF96855D6D0BAB0A3", hash_generated_field = "7B435E447280D5DC4E48D52C3AACF101")

        Bundle mArgs;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.417 -0400", hash_original_method = "9DCA77B5D1234925DAEE8DA8399779D6", hash_generated_method = "9DCA77B5D1234925DAEE8DA8399779D6")
        public ManagedDialog ()
        {
            //Synthesized constructor
        }


    }


    
    static final class NonConfigurationInstances {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.418 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "AE7D68ABA75D09946A953E289939C500")

        Object activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.421 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "39C55DEAC9D9B669F0F104569866C7D7")

        HashMap<String, Object> children;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.421 -0400", hash_original_field = "AD7BA86BB6B55B3BB2BB5F974A84CECF", hash_generated_field = "CB2FDAC93F3729E9B59C5F21C93A6FFF")

        ArrayList<Fragment> fragments;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.422 -0400", hash_original_field = "2AB8B63748D15E45B6CE4A33D435F369", hash_generated_field = "D5FA06C5EF7E6F3388FB9592AB447362")

        SparseArray<LoaderManagerImpl> loaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.423 -0400", hash_original_method = "6ECBAFFBF9F9B3F6A966772230E87049", hash_generated_method = "6ECBAFFBF9F9B3F6A966772230E87049")
        public NonConfigurationInstances ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ManagedCursor {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.424 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

        private Cursor mCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.425 -0400", hash_original_field = "59BD2047126E05F523EC535BB598B674", hash_generated_field = "6C470EAC7065369BBFA5B5575968482A")

        private boolean mReleased;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.448 -0400", hash_original_field = "63EBA8D5D32C815A530E6A72B411BAD1", hash_generated_field = "823188B97D251C7D61AAB004C3DA6C8F")

        private boolean mUpdated;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.451 -0400", hash_original_method = "1B2A6EC67EE1273DC41D2716939B2D2A", hash_generated_method = "42977AB1E1BFB8F07C0C61D524D131AA")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.461 -0400", hash_original_field = "9C29F19CBB2417EFCC04569A35A2C147", hash_generated_field = "431E5787FF3C659859C97AAC2FD09693")

    private static String TAG = "Activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.462 -0400", hash_original_field = "F82AA367945C18050D2033244725EAF5", hash_generated_field = "2241ED7572C2B89FA014BFB20EB1AF72")

    public static final int RESULT_CANCELED    = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.463 -0400", hash_original_field = "962F509BC72F354FB94AC40E73A4B7A4", hash_generated_field = "F91B70B7F6D5082BE48EF2C98C1E7358")

    public static final int RESULT_OK           = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.463 -0400", hash_original_field = "E43060F557E7C9ED788A22939DB0D79E", hash_generated_field = "5077A6A22B66E72C7578FB99A7F608D6")

    public static final int RESULT_FIRST_USER   = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.464 -0400", hash_original_field = "B65D15DDA07492A4A8DE08D820B3BC23", hash_generated_field = "9C252D257636A4561467B2C4C29F1831")

    private static String WINDOW_HIERARCHY_TAG = "android:viewHierarchyState";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.465 -0400", hash_original_field = "FB4A22E192730B645166187558A8A796", hash_generated_field = "1E0256FDEF80EA7B6BEF24A71175438C")

    private static String FRAGMENTS_TAG = "android:fragments";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.465 -0400", hash_original_field = "E5B3C7DC3F4E78258F87EF385D628C7C", hash_generated_field = "E6D3D733D65608C10B313F2D5DF51830")

    private static String SAVED_DIALOG_IDS_KEY = "android:savedDialogIds";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.481 -0400", hash_original_field = "CEFECAA57483EE3BEADD7413245EF60B", hash_generated_field = "9FD460B98AC1B43114736EA413D522E7")

    private static String SAVED_DIALOGS_TAG = "android:savedDialogs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.481 -0400", hash_original_field = "BDEC88B1A06E3B4B8EAD965EA57EAD9F", hash_generated_field = "47775BA34E54A733D9148DD8677370AD")

    private static String SAVED_DIALOG_KEY_PREFIX = "android:dialog_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.482 -0400", hash_original_field = "B5CEBA5CE662022E22C9CE3982D9DCE2", hash_generated_field = "F4A66456AC210F2609ECDF051C589604")

    private static String SAVED_DIALOG_ARGS_KEY_PREFIX = "android:dialog_args_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.483 -0400", hash_original_field = "4066C9D5A8E645EE130BB72CD59497D1", hash_generated_field = "99A13E103D3002367713929FD312840E")

    protected static int[] FOCUSED_STATE_SET = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.483 -0400", hash_original_field = "8CB380EC154CB62ED9B10D3B61A2D67C", hash_generated_field = "45127B126EE2B3619E2DE44F606F53C3")

    static public final int DEFAULT_KEYS_DISABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.484 -0400", hash_original_field = "BEC0DDDE6C52F8C9CB44C35DDF3A2D50", hash_generated_field = "F05278144A2B935FA742242E4E3A61A2")

    static public final int DEFAULT_KEYS_DIALER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.485 -0400", hash_original_field = "B9A091052EFFE8B52D43580CA139320C", hash_generated_field = "B4C1B32500D4540AA59C81E1B33DAC14")

    static public final int DEFAULT_KEYS_SHORTCUT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.510 -0400", hash_original_field = "265CCE449D6408B73F80115B406B0F94", hash_generated_field = "7B0F2176FF8E3A9C8466EB909FF8E3C8")

    static public final int DEFAULT_KEYS_SEARCH_LOCAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.510 -0400", hash_original_field = "414426DEE5BB2437FCFB3279CDC238E7", hash_generated_field = "0C973E25C195EE36EA7FD3DD74B22EB1")

    static public final int DEFAULT_KEYS_SEARCH_GLOBAL = 4;
}

