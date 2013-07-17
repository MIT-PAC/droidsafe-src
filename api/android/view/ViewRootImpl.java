package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.Manifest;
import android.animation.LayoutTransition;
import android.app.ActivityManagerNative;
import android.content.ClipDescription;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.LatencyTimer;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.Log;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityInteractionClient;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.IAccessibilityInteractionConnection;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.android.internal.policy.PolicyManager;
import com.android.internal.view.BaseSurfaceHolder;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.RootViewSurfaceTaker;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class ViewRootImpl extends Handler implements ViewParent, View.AttachInfo.Callbacks, HardwareRenderer.HardwareDrawCallbacks {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.668 -0400", hash_original_field = "9FB8722C5639B6B2D197FB488F8BB7B1", hash_generated_field = "843FBE1A9F9CBF827094CA7CF070DBDE")

    long mLastTrackballTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.668 -0400", hash_original_field = "2B60F4783E50055B6531781826673342", hash_generated_field = "8405ACA924158429D7DAF509E106E80E")

    final TrackballAxis mTrackballAxisX = new TrackballAxis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.668 -0400", hash_original_field = "7C147ECFA14972FC5351B85686A43DC6", hash_generated_field = "E58AB91B5ACFBE3D4FB913472293F77A")

    final TrackballAxis mTrackballAxisY = new TrackballAxis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.668 -0400", hash_original_field = "DA607F1FD199037ED5097D2149AAA2B8", hash_generated_field = "1F6F035B05518F799CC4A631830DEA24")

    int mLastJoystickXDirection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.668 -0400", hash_original_field = "F688B5DE04C2BC837F48B8E4887F918D", hash_generated_field = "FAD79A20871B99E6C09DCA8C579054AF")

    int mLastJoystickYDirection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "CCCFAD6BEACBCB767770713431A278CC", hash_generated_field = "008A164762C8272B4BD8A8FAE6C0E3A7")

    int mLastJoystickXKeyCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "5D2609CBCF4FB4C283F7493B7E076C84", hash_generated_field = "70296AF28AFADF018D48568A1EC7CDC1")

    int mLastJoystickYKeyCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "4BC786D43E92B4BEDC23ACC8C07672C0", hash_generated_field = "192CBA0F154C36DD2A24DDE2AD97DD40")

    final int[] mTmpLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "161FA5687A7D7AC4B9C9A80AF829FBD9", hash_generated_field = "F4896FA60EAF46F89D1B23DB39A94469")

    final TypedValue mTmpValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "F506AF951DDADDB13AB99733DA5C81D8", hash_generated_field = "B902B282F1853C48591AA333FC5C6930")

    InputMethodCallback mInputMethodCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "F0B2281F6B06E2C5558D41AAD03EB9CB", hash_generated_field = "598B68B7DF6E876D9AF774185C389FF7")

    final SparseArray<Object> mPendingEvents = new SparseArray<Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "64EE0AB7FC4C5BD8F8AA06BB346EBFCD", hash_generated_field = "8504A7AA7F77E97847E07EE0E13DD89E")

    int mPendingEventSeq = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "8CE20653889294789C714060A391C40F")

    Thread mThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "F0FFEA60326B2D639F57F2EAC1D83F2E")

    WindowLeaked mLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "5A8DDBFFB48FB5038CAE7BDFEFA84A3A", hash_generated_field = "FBA586EC47BBF8235BA69538A45A084C")

    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "17DBBC35D1D58356620B06871EA80682")

    W mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "62D22558492391EE18A59E61D13DF59B", hash_generated_field = "B8EEE6865DFA2D11E19D316E427BCF57")

    int mTargetSdkVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "8913F44A11D4302ED7B203F0CF0BA11B")

    int mSeq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "F8D40828BB6C29B3FC912398E721F9E4", hash_generated_field = "A476C52E6AE87C5E9FAFA76F8149063E")

    View mFocusedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "263E0B76878C860DE84233A41BC0016F", hash_generated_field = "3DC22EE5DBB3E6E14C770C4103F10EB9")

    View mRealFocusedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "96660D25AF9DB923A87425CCE07A5A95", hash_generated_field = "6F90E9BEC145DE5BCF5865F1869A8817")

    int mViewVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "7C431AA37BCFA92BDB40DEDC3EAC95F6", hash_generated_field = "CBD2E44BCC5B5ECBFE52241EEB9711C5")

    boolean mAppVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "E743A0BAB0ED12D120CA433EEA8B537F", hash_generated_field = "0AEB888D275C51C81ED076AFA9DC9522")

    int mOrigWindowType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "8CCD825644680C613E93DCA15E2DC7DC", hash_generated_field = "80618C8C8672F89E380C28D4E4CF2CB6")

    boolean mStopped = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "6387A3D856A63A2AD73C8C9FC21DD388", hash_generated_field = "23B6B29357EB27D126E7D0E5137E40A2")

    boolean mLastInCompatMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "53874A648990BC9189119A03E709B8A9", hash_generated_field = "D3FE6DB201CFE61D34745A493F584192")

    SurfaceHolder.Callback2 mSurfaceHolderCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "81860DC8C5AA6AEFA5F2B79E06C56A49", hash_generated_field = "F864CA3F05AD6C8A628535B131A61BBF")

    BaseSurfaceHolder mSurfaceHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "0E2361D9DC5F8ED2D80C3189D2E3EE01", hash_generated_field = "8F301FBCF4999017F75CC0B716F2517E")

    boolean mIsCreating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "0822D4118140B9899091B78395995296", hash_generated_field = "31E39D3D4E66A5056EAD95BE27A3903C")

    boolean mDrawingAllowed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "6F7C2ABB1A4FE62E56F6B6EC8E8EBFC2", hash_generated_field = "C0C52C8769544E33D239458B4880FB79")

    Region mTransparentRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "CB41328D3239692AD26CC8CEC7EA02B7", hash_generated_field = "6DD5B69EF744EC321638C5B663EA67C0")

    Region mPreviousTransparentRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

    int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

    int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "76D7D73778AD0C3E9D57E6A56AEDF738", hash_generated_field = "E76116A4E1D56F9ACB236AA480F07D5C")

    Rect mDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "37730831ED21F3ED3D8D3D4010E8939D", hash_generated_field = "7D059A3482DA1107B4225C068EC3B96C")

    final Rect mCurrentDirty = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "D2034914CD1C91DF53E95B41AD3A026A", hash_generated_field = "27F620C09DF5AF3A58C0B01A44A71C88")

    final Rect mPreviousDirty = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "A81D486C7031EC82F0DD218A6FB06245", hash_generated_field = "97BCAC515A131331E06C789507755EE7")

    boolean mIsAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.669 -0400", hash_original_field = "D30D964DEC107E6D034DC2A2CB80EA28", hash_generated_field = "A237DD2C3AA1799B8037D96788707A83")

    CompatibilityInfo.Translator mTranslator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "B1A49FF62D92BCD8AE5C70F97D680510", hash_generated_field = "86473EE91D5723F9F75E2A56F39C84CF")

    View.AttachInfo mAttachInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "C24CAB0CD635949A89D283C9B1D6E3B2", hash_generated_field = "19DDA5FF34DEE6F036F3E0F6D18E8BCF")

    InputChannel mInputChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "4C0768DE09E1813B3CA03AA187B50C3E", hash_generated_field = "BF4123EFADD525416DF2ECCC683CF87D")

    InputQueue.Callback mInputQueueCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "E211911F07DE1C0E219865F6EE524326", hash_generated_field = "214B662EBB0919E92BC2DA7797C68593")

    InputQueue mInputQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "7389C8F86B7D2B4FBCD7A6DFA85E64A4", hash_generated_field = "45AD45F5DD34AE4545398CF3CECF17C4")

    FallbackEventHandler mFallbackEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "B856E02779DE10EA84221FCD1182A1A3", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")

    Rect mTempRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "17A1D92354A641BBDCCF8626DAEC1345", hash_generated_field = "75DE7B8E36E8E0070CF83B97AE3C5ADD")

    Rect mVisRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "84C921D46AB1AE020C78FA0054A37992", hash_generated_field = "5CAC89A6B43ECD32B0872A407087A6F4")

    boolean mTraversalScheduled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "BA8CB8DD5FC64D4CBDC965EED503DF10", hash_generated_field = "EB355C7A896FD8B8387186109992F2B8")

    long mLastTraversalFinishedTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "1B0095C8C9CCD6630BF56AB8B690BFD1", hash_generated_field = "C8304D699838C82BC498F4723E240C1F")

    long mLastDrawDurationNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "66D724D804CEE3D3CDFA5CEB8F590D53", hash_generated_field = "345D78977A28AFF99B79AE805D352734")

    boolean mWillDrawSoon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "ED91C157C05E401358FF44C4420F25D8", hash_generated_field = "48AB4660010DD29E688C29E9BF84B71B")

    boolean mLayoutRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "ECAEBEC6BB782BEA13F3E7E1E2E20C36", hash_generated_field = "562F659A65CBB4A1A6DBAAFE4E932885")

    boolean mFirst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "51F1A68CA6419C547A7FC4D19875727A", hash_generated_field = "2977B3A45EA900C6A3042BD62F95188E")

    boolean mReportNextDraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "42D47128B1CC1E1CF45B3EEF3812B5C5", hash_generated_field = "DAF006AD70DDF288E744168F840824B7")

    boolean mFullRedrawNeeded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "2A00A465430A75857B0A3E7F16924D01", hash_generated_field = "F4C0F083E90A29856957BA6D1DDAED83")

    boolean mNewSurfaceNeeded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "23B72EC0285F5B24CD2688A42BB92034", hash_generated_field = "5F83D526A3FA8B2F4898EDD5EF0E2A3A")

    boolean mHasHadWindowFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "B1654BA812658AE2CAC4E8DE7C39A73C", hash_generated_field = "2ABCD72F1C5FD8723FE1304A4714716F")

    boolean mLastWasImTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "6AB0E48DFAFE78320455EAA4F7F74832", hash_generated_field = "F8F7FAB20882F1D392651D5DEC2E7327")

    InputEventMessage mPendingInputEvents = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "8E1CD3EAC4AACECC2DB5ED0102F14E57", hash_generated_field = "06BBA4AD1FBDA3B0B33CE36EFE1027EA")

    boolean mWindowAttributesChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "6C9CE9DA8E36B853987265BA98EB99F3", hash_generated_field = "546953AC84915AC28C8B7DAF9502F5E5")

    int mWindowAttributesChangesFlag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "F9AB9D95165B53F1F9A8EA582223EE4E")

    private final Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "29AFB5DC7D4AAD5CD9E8254338F52F08", hash_generated_field = "3272EA4F55AF2134E76D819B48B053D5")

    boolean mAddedTouchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "5EAC126C193FC41ACB184C1D10F2C250")

    CompatibilityInfoHolder mCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "15F4BBB64D636278834545B7F4E2C47C", hash_generated_field = "4FAA064DF54D7CC2DBADC1DAB51471A6")

    int mAddNesting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "5AB326DBD4F2418E1C70019D5FE2E9E8", hash_generated_field = "79F142AE0DEC957F939DD6F49191F7DA")

    Rect mWinFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "DC58415BE393FFE45C7379968D07F03C", hash_generated_field = "D7BF56D7D1AA140BE857C621B183EA1F")

    final Rect mPendingVisibleInsets = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "43939E34AD094B79CC29455B4656BD89", hash_generated_field = "1B6C360B3EA1E6006390DB0BE53A7892")

    final Rect mPendingContentInsets = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "ECC65560EF31D2DB1799F5C14EEAFA7A", hash_generated_field = "3ECCDFE4A47C5AABC0FEC62DB447749A")

    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets = new ViewTreeObserver.InternalInsetsInfo();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "08DB6ABADAC97CB9632E1F54B9A7669B", hash_generated_field = "34376B54378B9B3D43FDDE460CA57C87")

    final Configuration mLastConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.670 -0400", hash_original_field = "316EF42C37A6359FA90E8EB8163158FD", hash_generated_field = "8DF7E1052933D1F73177C1BFC385AA74")

    final Configuration mPendingConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "DFF428E4D0E1C2EF7455DC5BF527B4A0", hash_generated_field = "F73A2E8B0FBF1242431CC31A3DD9702B")

    boolean mScrollMayChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "33E2F9EB615FA3DC117548E2AB4E3CB8", hash_generated_field = "CF8B89DFEF5F4625A0C19FC1D32C3421")

    int mSoftInputMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "7C464F8694B05041AFB58885DA000588", hash_generated_field = "7D8A0E0CD7FFB1F73E763DA6C4667A4E")

    View mLastScrolledFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "4ABBFD585ECE4FE40BECD8E0C30C4E5E", hash_generated_field = "EC6AD52CC705AA3985B25CDB13E68426")

    int mScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "4E0E149B23ABE221D2EDBEA643C6A2D9", hash_generated_field = "565D20E48244C9362550DBB0B49B53BB")

    int mCurScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "16226695B3E75E1B75AD8C16FE7698DB")

    Scroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "5C66C74E599CCAEE2E860C595DB5E3B9", hash_generated_field = "F55691E21802586D78CD6F9FD51B171A")

    HardwareLayer mResizeBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "4BD630B1466E79D64E5FF79ACF9E8172", hash_generated_field = "69E5E6DEA9BA26DB325DFF8EBCCC1A06")

    long mResizeBufferStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "201B3310C28F7E7F5D41E09AB658F61A", hash_generated_field = "43B2C18D48C325F81780B31D87D0EC3F")

    int mResizeBufferDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "EAEC9E1DC504AA33FAEE1754B9E6C2E6", hash_generated_field = "A493757D2D083CF70CF0156B7D650811")

    private ArrayList<LayoutTransition> mPendingTransitions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "72AA02F8181FBA74DCEB8E5DAFCB11D1", hash_generated_field = "ABA78699C698034369F90645C9496674")

    ViewConfiguration mViewConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "8608A99B6E89C2555B396A625012580E", hash_generated_field = "CC0FC278B71622219C45AD52C9FB53C8")

    ClipDescription mDragDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "3DDC2DD80BBDAAFF3D7748437C0F92DB", hash_generated_field = "025092BC7B1A6638564A2FBB4D620E8D")

    View mCurrentDragView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "3B3A215548FF8C27E628B48C3E7FAF73", hash_generated_field = "7D186346EFCB228BBC632C710813F06A")

    volatile Object mLocalDragState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "B14068A442685E0109118ED262F29150", hash_generated_field = "C40BD10C38FBF577696C33E32B5A5F15")

    final PointF mDragPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "D31662568CF1A3E94E597074D8A0BA65", hash_generated_field = "CEA70AEA2380B8689249771FEECDD683")

    final PointF mLastTouchPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "429F074741C37582EBA166C2E096303A", hash_generated_field = "2A75F6FAF247C6A563147144451919B0")

    private boolean mProfileRendering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "CC7DDE7BC68056B1485F45767EDBE40A", hash_generated_field = "2967540D832074C93AFE31D56D615C87")

    private Thread mRenderProfiler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "560CE8A7AFD95647E11E51470AD892CE", hash_generated_field = "F1ABF1663FFD4FAD46EB136874019F65")

    private volatile boolean mRenderProfilingEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.671 -0400", hash_original_field = "488242DCDD6F32D36158D6036C7B7B00", hash_generated_field = "AE62D52D470E5307BF23FF4D57A005B1")

    private long mFpsStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "531EFF915955FD6ECB4AB5C999E11FCC", hash_generated_field = "4B09966683DBC242A92E84CFC3759305")

    private long mFpsPrevTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "FDAB8945A474B114D638198C883D5706", hash_generated_field = "500CC8C8BBFEA70158BD5B319AA9473F")

    private int mFpsNumFrames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "81931559493F052ED78BA000FD1BC717")

    AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "7F1B3F6A6E334A72020206E0E9A4FF92", hash_generated_field = "2467CDF4E5E89FDAF3ABD83B3362838B")

    AccessibilityManager mAccessibilityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "F9D67EE332FEFEABE6FCE029947A296F", hash_generated_field = "326964F84FEA789C7EA69B5AD84D099B")

    AccessibilityInteractionController mAccessibilityInteractionController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "22FE57590D994BD53ACBA88A13C1D432", hash_generated_field = "1EE07D7B37AEA69E13942B821067B159")

    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "47DEF5F55071FA14EADD51CCA34A7B60", hash_generated_field = "ED6865A95E9BDB4B92489EC925B4337E")

    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "CB41FCB74021FD4BA0B8B886D751AB3B")

    private int mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "FBF46F0211B74BEC9C47C5EFFAF36A72")

    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "F0D5A808F49DE0DFBB2EBC21349D60F9", hash_generated_field = "93DCF807A0C07D048164002C3BB5DC84")

    private boolean mProfile = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "2DAA81707CC3223C543DA09460FE0B5F", hash_generated_field = "771F3E0240CB2201808586E811799152")

    int mHardwareYOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "9097CFC01E63EBE4150B17671D27D895", hash_generated_field = "43FB9582B41438DE11C8033508791B9A")

    int mResizeAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "C3D947F17C54D1EB736DB694E6D1F8D2", hash_generated_field = "7840CC47EC1E67F4E118E7172F117D39")

    final Paint mResizePaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "67423D5E67ED1443D33F13C001525444", hash_generated_field = "7265E6F2381DF6B2AD9FD72699DAD27A")

    private long mInputEventReceiveTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "AA3C6B1620E27E0B9FA892D045F064D2", hash_generated_field = "B12640E94E9B6FC4860989B653C215E6")

    private long mInputEventDeliverTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "1FFA08FA13CD0C201A131759BEE8CAD7", hash_generated_field = "F589D3B75D0D824F988415EE16A4D910")

    private long mInputEventDeliverPostImeTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.672 -0400", hash_original_field = "E00B3A1621C501CDA1A76EB46C5AA0E7", hash_generated_field = "FA48E12ED3D38101FA265C33F8B4EB33")

    private InputQueue.FinishedCallback mFinishedCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_field = "18C98C39E8D3C77B924AFC1D76DB38D1", hash_generated_field = "10425C1D99C9B3E146C1BBB81040F9EF")

    private final InputHandler mInputHandler = new InputHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_method = "DA8B85C0B97B283164189BFC107A0C51", hash_generated_method = "FF89E1B449B2A3760D958F63C22C8E1D")
        public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback) {
            startInputEvent(finishedCallback);
            dispatchKey(event, true);
            addTaint(event.getTaint());
            addTaint(finishedCallback.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_method = "BA251C4BE7EEF8348B6DA839AE6C5F99", hash_generated_method = "6D32680B0C65B263C80F930005E38CDC")
        public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
            startInputEvent(finishedCallback);
            dispatchMotion(event, true);
            addTaint(event.getTaint());
            addTaint(finishedCallback.getTaint());
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_field = "09A95A1FC3FF30F6E7CF942F1FC6A265", hash_generated_field = "99F32DA5E56A393932E6EDF801E99038")

    private SurfaceHolder mHolder = new SurfaceHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "13BADEA14E6A49BCC17141EB1CC9ABAB")
        public Surface getSurface() {
            Surface varB4EAC82CA7396A68D541C85D26508E83_1564047814 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1564047814 = mSurface;
            varB4EAC82CA7396A68D541C85D26508E83_1564047814.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1564047814;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "111414E0BC27432A58777D8D7A8A5313", hash_generated_method = "404CE96BADDBDD106E676659F86D0C86")
        public boolean isCreating() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116664615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_116664615;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "1534EBA7EE38BC120F6309F5A1B3FF9E", hash_generated_method = "1D39A8EC720482719F771CC26E2A5136")
        public void addCallback(Callback callback) {
            addTaint(callback.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "1D7F6566A3906AFA0AB54EE06949ABBB", hash_generated_method = "4529A5CE4ECB0918530466545BD7FADC")
        public void removeCallback(Callback callback) {
            addTaint(callback.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "0FF9F7AB4B875AE8A0C5A8C3535F85C8", hash_generated_method = "D84D02E4950B7C76C7CC605634C9A5E7")
        public void setFixedSize(int width, int height) {
            addTaint(width);
            addTaint(height);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "0794758F1C90C59C5D7A2C0BDE8FAA38", hash_generated_method = "2283705EABC76CCAA7D98B4015CCD0EC")
        public void setSizeFromLayout() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "CF1EA2FC05AD6DEBDFA26DEE8FD9DB43", hash_generated_method = "7A8B1BC0D08BE1C3FCDE74335C415748")
        public void setFormat(int format) {
            addTaint(format);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "F16672983FBE594CFFF27796E8300DE9")
        public void setType(int type) {
            addTaint(type);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.019 -0400", hash_original_method = "46E48CC06FE228B4151C3D83F1499F0C", hash_generated_method = "2B4B08250D222564E5F449F984CD77F8")
        public void setKeepScreenOn(boolean screenOn) {
            addTaint(screenOn);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.020 -0400", hash_original_method = "3082759B8090FD86F4392C9CC2C4FBD0", hash_generated_method = "42B586D14B6CE5A0CCC956C7A302F059")
        public Canvas lockCanvas() {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_949446256 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_949446256 = null;
            varB4EAC82CA7396A68D541C85D26508E83_949446256.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_949446256;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "3E84C9B445B974E90BE60751B0E8F5B3", hash_generated_method = "E3CA96D4EA0FD882850C6F6D5D588F7B")
        public Canvas lockCanvas(Rect dirty) {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_1552549708 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1552549708 = null;
            addTaint(dirty.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1552549708.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1552549708;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "398534786B4B68CC68F8CE8B2E298404", hash_generated_method = "069FC062D6BD12CF8E4DC29D8D01209E")
        public void unlockCanvasAndPost(Canvas canvas) {
            addTaint(canvas.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "0458ACEC2C801E19AE11DF373ED70BEE", hash_generated_method = "C1182B7EEE68E099E2C5404841EDF4EE")
        public Rect getSurfaceFrame() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1346833247 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1346833247 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1346833247.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1346833247;
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.673 -0400", hash_original_method = "30AB3DC3CF45F6460C1B2C84DB6BEEC3", hash_generated_method = "1900A1317F48CC1DB27F4F76882AE33F")
    public  ViewRootImpl(Context context) {
        super();
        if(MEASURE_LATENCY)        
        {
            if(lt == null)            
            {
                lt = new LatencyTimer(100, 1000);
            } //End block
        } //End block
        getWindowSession(context.getMainLooper());
        mThread = Thread.currentThread();
        mLocation = new WindowLeaked(null);
        mLocation.fillInStackTrace();
        mWidth = -1;
        mHeight = -1;
        mDirty = new Rect();
        mTempRect = new Rect();
        mVisRect = new Rect();
        mWinFrame = new Rect();
        mWindow = new W(this);
        mTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        mInputMethodCallback = new InputMethodCallback(this);
        mViewVisibility = View.GONE;
        mTransparentRegion = new Region();
        mPreviousTransparentRegion = new Region();
        mFirst = true;
        mAdded = false;
        mAccessibilityManager = AccessibilityManager.getInstance(context);
        mAccessibilityInteractionConnectionManager =
            new AccessibilityInteractionConnectionManager();
        mAccessibilityManager.addAccessibilityStateChangeListener(
                mAccessibilityInteractionConnectionManager);
        mAttachInfo = new View.AttachInfo(sWindowSession, mWindow, this, this);
        mViewConfiguration = ViewConfiguration.get(context);
        mDensity = context.getResources().getDisplayMetrics().densityDpi;
        mFallbackEventHandler = PolicyManager.makeNewFallbackEventHandler(context);
        mProfileRendering = Boolean.parseBoolean(
                SystemProperties.get(PROPERTY_PROFILE_RENDERING, "false"));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static IWindowSession getWindowSession(Looper mainLooper) {
        synchronized (mStaticInit) {
            if (!mInitialized) {
                try {
                    InputMethodManager imm = InputMethodManager.getInstance(mainLooper);
                    sWindowSession = Display.getWindowManager().openSession(
                            imm.getClient(), imm.getInputContext());
                    mInitialized = true;
                } catch (RemoteException e) {
                }
            }
            return sWindowSession;
        }
    }

    
    public static void addFirstDrawHandler(Runnable callback) {
        synchronized (sFirstDrawHandlers) {
            if (!sFirstDrawComplete) {
                sFirstDrawHandlers.add(callback);
            }
        }
    }

    
    public static void addConfigCallback(ComponentCallbacks callback) {
        synchronized (sConfigCallbacks) {
            sConfigCallbacks.add(callback);
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.674 -0400", hash_original_method = "CC8B7F3C56C4BD3E79E20E40E6BC7183", hash_generated_method = "B1C47515DF4380EC2E00EEA4CF22D73A")
    public void profile() {
        mProfile = true;
        // ---------- Original Method ----------
        //mProfile = true;
    }

    
    static boolean isInTouchMode() {
        if (mInitialized) {
            try {
                return sWindowSession.getInTouchMode();
            } catch (RemoteException e) {
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.675 -0400", hash_original_method = "41A7A71F10D2AEAE23E30A793138BBB4", hash_generated_method = "5482824D2C4F5DDEF843DD9D400D2BD9")
    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        synchronized
(this)        {
            if(mView == null)            
            {
                mView = view;
                mFallbackEventHandler.setView(view);
                mWindowAttributes.copyFrom(attrs);
                attrs = mWindowAttributes;
                if(view instanceof RootViewSurfaceTaker)                
                {
                    mSurfaceHolderCallback =
                            ((RootViewSurfaceTaker)view).willYouTakeTheSurface();
                    if(mSurfaceHolderCallback != null)                    
                    {
                        mSurfaceHolder = new TakenSurfaceHolder();
                        mSurfaceHolder.setFormat(PixelFormat.UNKNOWN);
                    } //End block
                } //End block
                CompatibilityInfo compatibilityInfo = mCompatibilityInfo.get();
                mTranslator = compatibilityInfo.getTranslator();
                if(mSurfaceHolder == null)                
                {
                    enableHardwareAcceleration(attrs);
                } //End block
                boolean restore = false;
                if(mTranslator != null)                
                {
                    mSurface.setCompatibilityTranslator(mTranslator);
                    restore = true;
                    attrs.backup();
                    mTranslator.translateWindowLayout(attrs);
                } //End block
                if(DEBUG_LAYOUT)                
                Log.d(TAG, "WindowLayout in setView:" + attrs);
                if(!compatibilityInfo.supportsScreen())                
                {
                    attrs.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    mLastInCompatMode = true;
                } //End block
                mSoftInputMode = attrs.softInputMode;
                mWindowAttributesChanged = true;
                mWindowAttributesChangesFlag = WindowManager.LayoutParams.EVERYTHING_CHANGED;
                mAttachInfo.mRootView = view;
                mAttachInfo.mScalingRequired = mTranslator != null;
                mAttachInfo.mApplicationScale =
                        mTranslator == null ? 1.0f : mTranslator.applicationScale;
                if(panelParentView != null)                
                {
                    mAttachInfo.mPanelParentWindowToken
                            = panelParentView.getApplicationWindowToken();
                } //End block
                mAdded = true;
                int res;
                requestLayout();
                if((mWindowAttributes.inputFeatures
                        & WindowManager.LayoutParams.INPUT_FEATURE_NO_INPUT_CHANNEL) == 0)                
                {
                    mInputChannel = new InputChannel();
                } //End block
                try 
                {
                    mOrigWindowType = mWindowAttributes.type;
                    res = sWindowSession.add(mWindow, mSeq, mWindowAttributes,
                            getHostVisibility(), mAttachInfo.mContentInsets,
                            mInputChannel);
                } //End block
                catch (RemoteException e)
                {
                    mAdded = false;
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mInputChannel = null;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
                    RuntimeException var9C55015CD947593623EA98690096C9BE_576048364 = new RuntimeException("Adding window failed", e);
                    var9C55015CD947593623EA98690096C9BE_576048364.addTaint(taint);
                    throw var9C55015CD947593623EA98690096C9BE_576048364;
                } //End block
                finally 
                {
                    if(restore)                    
                    {
                        attrs.restore();
                    } //End block
                } //End block
                if(mTranslator != null)                
                {
                    mTranslator.translateRectInScreenToAppWindow(mAttachInfo.mContentInsets);
                } //End block
                mPendingContentInsets.set(mAttachInfo.mContentInsets);
                mPendingVisibleInsets.set(0, 0, 0, 0);
                if(DEBUG_LAYOUT){ }                if(res < WindowManagerImpl.ADD_OKAY)                
                {
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mAdded = false;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
switch(res){
                    case WindowManagerImpl.ADD_BAD_APP_TOKEN:
                    case WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN:
                    WindowManagerImpl.BadTokenException var6733BC6EE654F7A7AFB320351CF37431_983933427 = new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not valid; is your activity running?");
                    var6733BC6EE654F7A7AFB320351CF37431_983933427.addTaint(taint);
                    throw var6733BC6EE654F7A7AFB320351CF37431_983933427;
                    case WindowManagerImpl.ADD_NOT_APP_TOKEN:
                    WindowManagerImpl.BadTokenException varCEF847F704B7168FF49F1F6384D358BD_66403236 = new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not for an application");
                    varCEF847F704B7168FF49F1F6384D358BD_66403236.addTaint(taint);
                    throw varCEF847F704B7168FF49F1F6384D358BD_66403236;
                    case WindowManagerImpl.ADD_APP_EXITING:
                    WindowManagerImpl.BadTokenException varCF195268E936DD0A9A03E6DD6D88913A_1026477259 = new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- app for token " + attrs.token
                                + " is exiting");
                    varCF195268E936DD0A9A03E6DD6D88913A_1026477259.addTaint(taint);
                    throw varCF195268E936DD0A9A03E6DD6D88913A_1026477259;
                    case WindowManagerImpl.ADD_DUPLICATE_ADD:
                    WindowManagerImpl.BadTokenException var8280A67AA43862E8691B31F9EAECD341_1022197943 = new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- window " + mWindow
                                + " has already been added");
                    var8280A67AA43862E8691B31F9EAECD341_1022197943.addTaint(taint);
                    throw var8280A67AA43862E8691B31F9EAECD341_1022197943;
                    case WindowManagerImpl.ADD_STARTING_NOT_NEEDED:
                    return;
                    case WindowManagerImpl.ADD_MULTIPLE_SINGLETON:
                    WindowManagerImpl.BadTokenException var94A59CEF2283A89B6B739880A68EA1F1_1968117596 = new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- another window of this type already exists");
                    var94A59CEF2283A89B6B739880A68EA1F1_1968117596.addTaint(taint);
                    throw var94A59CEF2283A89B6B739880A68EA1F1_1968117596;
                    case WindowManagerImpl.ADD_PERMISSION_DENIED:
                    WindowManagerImpl.BadTokenException var4BC37D295943ACACDB31A43D839411DB_2059412050 = new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- permission denied for this window type");
                    var4BC37D295943ACACDB31A43D839411DB_2059412050.addTaint(taint);
                    throw var4BC37D295943ACACDB31A43D839411DB_2059412050;
}                    RuntimeException varAD663AE041B17675C9531B3148A585C8_2018954226 = new RuntimeException(
                        "Unable to add window -- unknown error code " + res);
                    varAD663AE041B17675C9531B3148A585C8_2018954226.addTaint(taint);
                    throw varAD663AE041B17675C9531B3148A585C8_2018954226;
                } //End block
                if(view instanceof RootViewSurfaceTaker)                
                {
                    mInputQueueCallback =
                        ((RootViewSurfaceTaker)view).willYouTakeTheInputQueue();
                } //End block
                if(mInputChannel != null)                
                {
                    if(mInputQueueCallback != null)                    
                    {
                        mInputQueue = new InputQueue(mInputChannel);
                        mInputQueueCallback.onInputQueueCreated(mInputQueue);
                    } //End block
                    else
                    {
                        InputQueue.registerInputChannel(mInputChannel, mInputHandler,
                                Looper.myQueue());
                    } //End block
                } //End block
                view.assignParent(this);
                mAddedTouchMode = (res&WindowManagerImpl.ADD_FLAG_IN_TOUCH_MODE) != 0;
                mAppVisible = (res&WindowManagerImpl.ADD_FLAG_APP_VISIBLE) != 0;
                if(mAccessibilityManager.isEnabled())                
                {
                    mAccessibilityInteractionConnectionManager.ensureConnection();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.676 -0400", hash_original_method = "CB86722DA8E467DDCEDA5A630CA3194B", hash_generated_method = "DEA0DDBB752FA33DB22AE0AAF9F63BEC")
     void destroyHardwareResources() {
        if(mAttachInfo.mHardwareRenderer != null)        
        {
            if(mAttachInfo.mHardwareRenderer.isEnabled())            
            {
                mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            } //End block
            mAttachInfo.mHardwareRenderer.destroy(false);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo.mHardwareRenderer != null) {
            //if (mAttachInfo.mHardwareRenderer.isEnabled()) {
                //mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            //}
            //mAttachInfo.mHardwareRenderer.destroy(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.676 -0400", hash_original_method = "E3F9E04A5716D71423EBE08431EEB223", hash_generated_method = "0AACD19AA83D71A1BDC6273864FF64E8")
     void terminateHardwareResources() {
        if(mAttachInfo.mHardwareRenderer != null)        
        {
            mAttachInfo.mHardwareRenderer.destroyHardwareResources(mView);
            mAttachInfo.mHardwareRenderer.destroy(false);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo.mHardwareRenderer != null) {
            //mAttachInfo.mHardwareRenderer.destroyHardwareResources(mView);
            //mAttachInfo.mHardwareRenderer.destroy(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.676 -0400", hash_original_method = "E840B8B43E5ABE6BE2D8F4EA2D3CA2C1", hash_generated_method = "0CBA1B6F983BCEDBAC51E414C090AF26")
     void destroyHardwareLayers() {
        if(mThread != Thread.currentThread())        
        {
            if(mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled())            
            {
                HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
            } //End block
        } //End block
        else
        {
            if(mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled())            
            {
                mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mThread != Thread.currentThread()) {
            //if (mAttachInfo.mHardwareRenderer != null &&
                    //mAttachInfo.mHardwareRenderer.isEnabled()) {
                //HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
            //}
        //} else {
            //if (mAttachInfo.mHardwareRenderer != null &&
                    //mAttachInfo.mHardwareRenderer.isEnabled()) {
                //mAttachInfo.mHardwareRenderer.destroyLayers(mView);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.677 -0400", hash_original_method = "645D4C027059B67B04B5E1D1CDD7444E", hash_generated_method = "B5C99A64B7377C51A286BF9E089503E0")
    private void enableHardwareAcceleration(WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        mAttachInfo.mHardwareAccelerated = false;
        mAttachInfo.mHardwareAccelerationRequested = false;
        if(mTranslator != null)        
        return;
        final boolean hardwareAccelerated = (attrs.flags & WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED) != 0;
        if(hardwareAccelerated)        
        {
            if(!HardwareRenderer.isAvailable())            
            {
                return;
            } //End block
            final boolean fakeHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED) != 0;
            final boolean forceHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED) != 0;
            if(!HardwareRenderer.sRendererDisabled || (HardwareRenderer.sSystemRendererDisabled
                    && forceHwAccelerated))            
            {
                if(!HardwareRenderer.sSystemRendererDisabled
                        && Looper.getMainLooper() != Looper.myLooper())                
                {
                    return;
                } //End block
                final boolean translucent = attrs.format != PixelFormat.OPAQUE;
                if(mAttachInfo.mHardwareRenderer != null)                
                {
                    mAttachInfo.mHardwareRenderer.destroy(true);
                } //End block
                mAttachInfo.mHardwareRenderer = HardwareRenderer.createGlRenderer(2, translucent);
                mAttachInfo.mHardwareAccelerated = mAttachInfo.mHardwareAccelerationRequested
                        = mAttachInfo.mHardwareRenderer != null;
            } //End block
            else
            if(fakeHwAccelerated)            
            {
                mAttachInfo.mHardwareAccelerationRequested = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.677 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "010161B6F3D594E12F673E998588207D")
    public View getView() {
View var2A050D4EA4182130A6C1E6806618CCD0_1342880318 =         mView;
        var2A050D4EA4182130A6C1E6806618CCD0_1342880318.addTaint(taint);
        return var2A050D4EA4182130A6C1E6806618CCD0_1342880318;
        // ---------- Original Method ----------
        //return mView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.677 -0400", hash_original_method = "6C3085A5B27688C16B5F48D71E61D048", hash_generated_method = "69C03ACE6D067CAAA80EFBD807CAD7DF")
    final WindowLeaked getLocation() {
WindowLeaked varC67D9EAB8F8C7974312627C3F915A447_1138292045 =         mLocation;
        varC67D9EAB8F8C7974312627C3F915A447_1138292045.addTaint(taint);
        return varC67D9EAB8F8C7974312627C3F915A447_1138292045;
        // ---------- Original Method ----------
        //return mLocation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.677 -0400", hash_original_method = "344B8CEF50FED73B6C66A984FDFE543C", hash_generated_method = "C9C064B7E2FA409A229715313986542F")
     void setLayoutParams(WindowManager.LayoutParams attrs, boolean newView) {
        addTaint(newView);
        synchronized
(this)        {
            int oldSoftInputMode = mWindowAttributes.softInputMode;
            int compatibleWindowFlag = mWindowAttributes.flags & WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
            mWindowAttributesChangesFlag = mWindowAttributes.copyFrom(attrs);
            mWindowAttributes.flags |= compatibleWindowFlag;
            if(newView)            
            {
                mSoftInputMode = attrs.softInputMode;
                requestLayout();
            } //End block
            if((attrs.softInputMode&WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST)
                    == WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED)            
            {
                mWindowAttributes.softInputMode = (mWindowAttributes.softInputMode
                        & ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST)
                        | (oldSoftInputMode
                                & WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
            } //End block
            mWindowAttributesChanged = true;
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.678 -0400", hash_original_method = "F0FE5EE4E253DD8DC552809A1CA2533F", hash_generated_method = "4A98D5E8B12F10E08E17BE37BBFF33DA")
     void handleAppVisibility(boolean visible) {
        if(mAppVisible != visible)        
        {
            mAppVisible = visible;
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        //if (mAppVisible != visible) {
            //mAppVisible = visible;
            //scheduleTraversals();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.678 -0400", hash_original_method = "18299B4078E7C7C61849ACAFD8526C89", hash_generated_method = "BB6EAB3409F9822032460A2B78E57E8C")
     void handleGetNewSurface() {
        mNewSurfaceNeeded = true;
        mFullRedrawNeeded = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //mNewSurfaceNeeded = true;
        //mFullRedrawNeeded = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.678 -0400", hash_original_method = "A2905530B195FBB19B3C3F0AC663BF20", hash_generated_method = "B4F533FE3D3C8C28D85C11EA8103DD14")
    public void requestLayout() {
        checkThread();
        mLayoutRequested = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //checkThread();
        //mLayoutRequested = true;
        //scheduleTraversals();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.678 -0400", hash_original_method = "13F945759D2C310C5D0BB68B6FB1E2B8", hash_generated_method = "178C31BD348B63C0AB9AC52035A806CC")
    public boolean isLayoutRequested() {
        boolean varED91C157C05E401358FF44C4420F25D8_549423192 = (mLayoutRequested);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058711923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058711923;
        // ---------- Original Method ----------
        //return mLayoutRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.678 -0400", hash_original_method = "1BB28848D4C8EEFEA34E8E46FE6AC5D5", hash_generated_method = "24812859B26AF526EB124295527A5D23")
    public void invalidateChild(View child, Rect dirty) {
        addTaint(dirty.getTaint());
        addTaint(child.getTaint());
        checkThread();
        if(DEBUG_DRAW){ }        if(dirty == null)        
        {
            invalidate();
            return;
        } //End block
        if(mCurScrollY != 0 || mTranslator != null)        
        {
            mTempRect.set(dirty);
            dirty = mTempRect;
            if(mCurScrollY != 0)            
            {
                dirty.offset(0, -mCurScrollY);
            } //End block
            if(mTranslator != null)            
            {
                mTranslator.translateRectInAppWindowToScreen(dirty);
            } //End block
            if(mAttachInfo.mScalingRequired)            
            {
                dirty.inset(-1, -1);
            } //End block
        } //End block
        if(!mDirty.isEmpty() && !mDirty.contains(dirty))        
        {
            mAttachInfo.mSetIgnoreDirtyState = true;
            mAttachInfo.mIgnoreDirtyState = true;
        } //End block
        mDirty.union(dirty);
        if(!mWillDrawSoon)        
        {
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "813AAD1E42CFCCC731AB301BBB74FC18", hash_generated_method = "C9B69269B05104AFF802002D325AD2DE")
     void invalidate() {
        mDirty.set(0, 0, mWidth, mHeight);
        scheduleTraversals();
        // ---------- Original Method ----------
        //mDirty.set(0, 0, mWidth, mHeight);
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "081DD37813B858E5AB3FA0820EF5D835", hash_generated_method = "7B1DAB09A6D305BFFE4A7510994573F9")
     void setStopped(boolean stopped) {
        if(mStopped != stopped)        
        {
            mStopped = stopped;
            if(!stopped)            
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mStopped != stopped) {
            //mStopped = stopped;
            //if (!stopped) {
                //scheduleTraversals();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "DCC308262D5800610A000228CF8970A4", hash_generated_method = "0E3128A158723B9AA32B94691F78FE54")
    public ViewParent getParent() {
ViewParent var540C13E9E156B687226421B24F2DF178_1121572334 =         null;
        var540C13E9E156B687226421B24F2DF178_1121572334.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1121572334;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "67B0199062309B0E78F2F88E3E2AD59A", hash_generated_method = "F964834C972E369035199E3D42BA0E53")
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        addTaint(dirty.getTaint());
        addTaint(location[0]);
        invalidateChild(null, dirty);
ViewParent var540C13E9E156B687226421B24F2DF178_2110556346 =         null;
        var540C13E9E156B687226421B24F2DF178_2110556346.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2110556346;
        // ---------- Original Method ----------
        //invalidateChild(null, dirty);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "FB92C76BB083D5DC37740C978F02B71C", hash_generated_method = "2373A3BBEC609D5EE6AF0F11770E53B1")
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        addTaint(offset.getTaint());
        addTaint(r.getTaint());
        addTaint(child.getTaint());
        if(child != mView)        
        {
            RuntimeException varD1413D319D7061CD26EC06ED620B9159_512094581 = new RuntimeException("child is not mine, honest!");
            varD1413D319D7061CD26EC06ED620B9159_512094581.addTaint(taint);
            throw varD1413D319D7061CD26EC06ED620B9159_512094581;
        } //End block
        boolean var5356EFD4322D66EEA5CE14A788F5B8B5_1719813839 = (r.intersect(0, 0, mWidth, mHeight));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143143656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143143656;
        // ---------- Original Method ----------
        //if (child != mView) {
            //throw new RuntimeException("child is not mine, honest!");
        //}
        //return r.intersect(0, 0, mWidth, mHeight);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "57451ED91AC07EA69FA21499971D2B45", hash_generated_method = "AC406F6D5A6EF83824A653E030726C19")
    public void bringChildToFront(View child) {
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.679 -0400", hash_original_method = "0E9A2AD60F5B60B1A096C27CF046877D", hash_generated_method = "AC6341A81C168A673946A891C493263B")
    public void scheduleTraversals() {
        if(!mTraversalScheduled)        
        {
            mTraversalScheduled = true;
            if(ViewDebug.DEBUG_LATENCY && mLastTraversalFinishedTimeNanos != 0)            
            {
                final long now = System.nanoTime();
                Log.d(TAG, "Latency: Scheduled traversal, it has been "
                        + ((now - mLastTraversalFinishedTimeNanos) * 0.000001f)
                        + "ms since the last traversal finished.");
            } //End block
            sendEmptyMessage(DO_TRAVERSAL);
        } //End block
        // ---------- Original Method ----------
        //if (!mTraversalScheduled) {
            //mTraversalScheduled = true;
            //if (ViewDebug.DEBUG_LATENCY && mLastTraversalFinishedTimeNanos != 0) {
                //final long now = System.nanoTime();
                //Log.d(TAG, "Latency: Scheduled traversal, it has been "
                        //+ ((now - mLastTraversalFinishedTimeNanos) * 0.000001f)
                        //+ "ms since the last traversal finished.");
            //}
            //sendEmptyMessage(DO_TRAVERSAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.680 -0400", hash_original_method = "0B26D78664F51D8793A6008ECDA459E7", hash_generated_method = "4C55AB4BA0A8F4206589CF200FBC51BA")
    public void unscheduleTraversals() {
        if(mTraversalScheduled)        
        {
            mTraversalScheduled = false;
            removeMessages(DO_TRAVERSAL);
        } //End block
        // ---------- Original Method ----------
        //if (mTraversalScheduled) {
            //mTraversalScheduled = false;
            //removeMessages(DO_TRAVERSAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.680 -0400", hash_original_method = "27A276950AD49DC3B2BCAC57214867E1", hash_generated_method = "1CAE626019F2AB689C5B6C110A897E16")
     int getHostVisibility() {
        int var142814C4BB818D867C7CF9854AA79FA8_1339216952 = (mAppVisible ? mView.getVisibility() : View.GONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204128355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_204128355;
        // ---------- Original Method ----------
        //return mAppVisible ? mView.getVisibility() : View.GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.680 -0400", hash_original_method = "4A37F94A433BB0C51ABAD4CD2013B711", hash_generated_method = "95E4174456AE944C8DAAA9411EF6A6E7")
     void disposeResizeBuffer() {
        if(mResizeBuffer != null)        
        {
            mResizeBuffer.destroy();
            mResizeBuffer = null;
        } //End block
        // ---------- Original Method ----------
        //if (mResizeBuffer != null) {
            //mResizeBuffer.destroy();
            //mResizeBuffer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.680 -0400", hash_original_method = "9CCD20C4D5BE58E51524A629AA69C9DE", hash_generated_method = "8E21490AE46D433D03C55532A0289A27")
    public void requestTransitionStart(LayoutTransition transition) {
        addTaint(transition.getTaint());
        if(mPendingTransitions == null || !mPendingTransitions.contains(transition))        
        {
            if(mPendingTransitions == null)            
            {
                mPendingTransitions = new ArrayList<LayoutTransition>();
            } //End block
            mPendingTransitions.add(transition);
        } //End block
        // ---------- Original Method ----------
        //if (mPendingTransitions == null || !mPendingTransitions.contains(transition)) {
            //if (mPendingTransitions == null) {
                 //mPendingTransitions = new ArrayList<LayoutTransition>();
            //}
            //mPendingTransitions.add(transition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.680 -0400", hash_original_method = "E06FBD8158D133D090EB34C23F0C9FD1", hash_generated_method = "04ECB8BFD4D151B80ACA08D41DE605FD")
    private void processInputEvents(boolean outOfOrder) {
        addTaint(outOfOrder);
        while
(mPendingInputEvents != null)        
        {
            handleMessage(mPendingInputEvents.mMessage);
            InputEventMessage tmpMessage = mPendingInputEvents;
            mPendingInputEvents = mPendingInputEvents.mNext;
            tmpMessage.recycle();
            if(outOfOrder)            
            {
                removeMessages(PROCESS_INPUT_EVENTS);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //while (mPendingInputEvents != null) {
            //handleMessage(mPendingInputEvents.mMessage);
            //InputEventMessage tmpMessage = mPendingInputEvents;
            //mPendingInputEvents = mPendingInputEvents.mNext;
            //tmpMessage.recycle();
            //if (outOfOrder) {
                //removeMessages(PROCESS_INPUT_EVENTS);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.689 -0400", hash_original_method = "DF10FEADFB061504FA9A2B620C341C55", hash_generated_method = "9C02723291C575BC810BEA73B64F40DF")
    private void performTraversals() {
        final View host = mView;
        processInputEvents(true);
        if(DBG)        
        {
            System.out.println("======================================");
            System.out.println("performTraversals");
            host.debug();
        } //End block
        if(host == null || !mAdded)        
        return;
        mTraversalScheduled = false;
        mWillDrawSoon = true;
        boolean windowSizeMayChange = false;
        boolean fullRedrawNeeded = mFullRedrawNeeded;
        boolean newSurface = false;
        boolean surfaceChanged = false;
        WindowManager.LayoutParams lp = mWindowAttributes;
        int desiredWindowWidth;
        int desiredWindowHeight;
        int childWidthMeasureSpec;
        int childHeightMeasureSpec;
        final View.AttachInfo attachInfo = mAttachInfo;
        final int viewVisibility = getHostVisibility();
        boolean viewVisibilityChanged = mViewVisibility != viewVisibility
                || mNewSurfaceNeeded;
        WindowManager.LayoutParams params = null;
        if(mWindowAttributesChanged)        
        {
            mWindowAttributesChanged = false;
            surfaceChanged = true;
            params = lp;
        } //End block
        CompatibilityInfo compatibilityInfo = mCompatibilityInfo.get();
        if(compatibilityInfo.supportsScreen() == mLastInCompatMode)        
        {
            params = lp;
            fullRedrawNeeded = true;
            mLayoutRequested = true;
            if(mLastInCompatMode)            
            {
                params.flags &= ~WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                mLastInCompatMode = false;
            } //End block
            else
            {
                params.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                mLastInCompatMode = true;
            } //End block
        } //End block
        mWindowAttributesChangesFlag = 0;
        Rect frame = mWinFrame;
        if(mFirst)        
        {
            fullRedrawNeeded = true;
            mLayoutRequested = true;
            if(lp.type == WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL)            
            {
                Display disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                Point size = new Point();
                disp.getRealSize(size);
                desiredWindowWidth = size.x;
                desiredWindowHeight = size.y;
            } //End block
            else
            {
                DisplayMetrics packageMetrics = mView.getContext().getResources().getDisplayMetrics();
                desiredWindowWidth = packageMetrics.widthPixels;
                desiredWindowHeight = packageMetrics.heightPixels;
            } //End block
            attachInfo.mSurface = mSurface;
            attachInfo.mUse32BitDrawingCache = true;
            attachInfo.mHasWindowFocus = false;
            attachInfo.mWindowVisibility = viewVisibility;
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            viewVisibilityChanged = false;
            mLastConfiguration.setTo(host.getResources().getConfiguration());
            host.dispatchAttachedToWindow(attachInfo, 0);
            host.fitSystemWindows(mAttachInfo.mContentInsets);
        } //End block
        else
        {
            desiredWindowWidth = frame.width();
            desiredWindowHeight = frame.height();
            if(desiredWindowWidth != mWidth || desiredWindowHeight != mHeight)            
            {
                if(DEBUG_ORIENTATION){ }                fullRedrawNeeded = true;
                mLayoutRequested = true;
                windowSizeMayChange = true;
            } //End block
        } //End block
        if(viewVisibilityChanged)        
        {
            attachInfo.mWindowVisibility = viewVisibility;
            host.dispatchWindowVisibilityChanged(viewVisibility);
            if(viewVisibility != View.VISIBLE || mNewSurfaceNeeded)            
            {
                destroyHardwareResources();
            } //End block
            if(viewVisibility == View.GONE)            
            {
                mHasHadWindowFocus = false;
            } //End block
        } //End block
        boolean insetsChanged = false;
        if(mLayoutRequested && !mStopped)        
        {
            getRunQueue().executeActions(attachInfo.mHandler);
            final Resources res = mView.getContext().getResources();
            if(mFirst)            
            {
                mAttachInfo.mInTouchMode = !mAddedTouchMode;
                ensureTouchModeLocally(mAddedTouchMode);
            } //End block
            else
            {
                if(!mPendingContentInsets.equals(mAttachInfo.mContentInsets))                
                {
                    insetsChanged = true;
                } //End block
                if(!mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets))                
                {
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                    if(DEBUG_LAYOUT){ }
                } //End block
                if(lp.width == ViewGroup.LayoutParams.WRAP_CONTENT
                        || lp.height == ViewGroup.LayoutParams.WRAP_CONTENT)                
                {
                    windowSizeMayChange = true;
                    if(lp.type == WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL)                    
                    {
                        Display disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                        Point size = new Point();
                        disp.getRealSize(size);
                        desiredWindowWidth = size.x;
                        desiredWindowHeight = size.y;
                    } //End block
                    else
                    {
                        DisplayMetrics packageMetrics = res.getDisplayMetrics();
                        desiredWindowWidth = packageMetrics.widthPixels;
                        desiredWindowHeight = packageMetrics.heightPixels;
                    } //End block
                } //End block
            } //End block
            if(DEBUG_ORIENTATION || DEBUG_LAYOUT){ }            boolean goodMeasure = false;
            if(lp.width == ViewGroup.LayoutParams.WRAP_CONTENT)            
            {
                final DisplayMetrics packageMetrics = res.getDisplayMetrics();
                res.getValue(com.android.internal.R.dimen.config_prefDialogWidth, mTmpValue, true);
                int baseSize = 0;
                if(mTmpValue.type == TypedValue.TYPE_DIMENSION)                
                {
                    baseSize = (int)mTmpValue.getDimension(packageMetrics);
                } //End block
                if(DEBUG_DIALOG){ }                if(baseSize != 0 && desiredWindowWidth > baseSize)                
                {
                    childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                    childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                    host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    if(DEBUG_DIALOG){ }                    if((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0)                    
                    {
                        goodMeasure = true;
                    } //End block
                    else
                    {
                        baseSize = (baseSize+desiredWindowWidth)/2;
                        if(DEBUG_DIALOG){ }                        childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                        host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        if(DEBUG_DIALOG){ }                        if((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0)                        
                        {
                            if(DEBUG_DIALOG){ }                            goodMeasure = true;
                        } //End block
                    } //End block
                } //End block
            } //End block
            if(!goodMeasure)            
            {
                childWidthMeasureSpec = getRootMeasureSpec(desiredWindowWidth, lp.width);
                childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                if(mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight())                
                {
                    windowSizeMayChange = true;
                } //End block
            } //End block
            if(DBG)            
            {
                System.out.println("======================================");
                System.out.println("performTraversals -- after measure");
                host.debug();
            } //End block
        } //End block
        if(attachInfo.mRecomputeGlobalAttributes && host.mAttachInfo != null)        
        {
            attachInfo.mRecomputeGlobalAttributes = false;
            boolean oldScreenOn = attachInfo.mKeepScreenOn;
            int oldVis = attachInfo.mSystemUiVisibility;
            boolean oldHasSystemUiListeners = attachInfo.mHasSystemUiListeners;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            attachInfo.mHasSystemUiListeners = false;
            host.dispatchCollectViewAttributes(0);
            if(attachInfo.mKeepScreenOn != oldScreenOn
                    || attachInfo.mSystemUiVisibility != oldVis
                    || attachInfo.mHasSystemUiListeners != oldHasSystemUiListeners)            
            {
                params = lp;
            } //End block
        } //End block
        if(attachInfo.mForceReportNewAttributes)        
        {
            attachInfo.mForceReportNewAttributes = false;
            params = lp;
        } //End block
        if(mFirst || attachInfo.mViewVisibilityChanged)        
        {
            attachInfo.mViewVisibilityChanged = false;
            int resizeMode = mSoftInputMode &
                    WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST;
            if(resizeMode == WindowManager.LayoutParams.SOFT_INPUT_ADJUST_UNSPECIFIED)            
            {
                final int N = attachInfo.mScrollContainers.size();
for(int i=0;i<N;i++)
                {
                    if(attachInfo.mScrollContainers.get(i).isShown())                    
                    {
                        resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
                    } //End block
                } //End block
                if(resizeMode == 0)                
                {
                    resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
                } //End block
                if((lp.softInputMode &
                        WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST) != resizeMode)                
                {
                    lp.softInputMode = (lp.softInputMode &
                            ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST) |
                            resizeMode;
                    params = lp;
                } //End block
            } //End block
        } //End block
        if(params != null && (host.mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) != 0)        
        {
            if(!PixelFormat.formatHasAlpha(params.format))            
            {
                params.format = PixelFormat.TRANSLUCENT;
            } //End block
        } //End block
        boolean windowShouldResize = mLayoutRequested && windowSizeMayChange
            && ((mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight())
                || (lp.width == ViewGroup.LayoutParams.WRAP_CONTENT &&
                        frame.width() < desiredWindowWidth && frame.width() != mWidth)
                || (lp.height == ViewGroup.LayoutParams.WRAP_CONTENT &&
                        frame.height() < desiredWindowHeight && frame.height() != mHeight));
        final boolean computesInternalInsets = attachInfo.mTreeObserver.hasComputeInternalInsetsListeners();
        boolean insetsPending = false;
        int relayoutResult = 0;
        if(mFirst || windowShouldResize || insetsChanged ||
                viewVisibilityChanged || params != null)        
        {
            if(viewVisibility == View.VISIBLE)            
            {
                insetsPending = computesInternalInsets && (mFirst || viewVisibilityChanged);
            } //End block
            if(mSurfaceHolder != null)            
            {
                mSurfaceHolder.mSurfaceLock.lock();
                mDrawingAllowed = true;
            } //End block
            boolean hwInitialized = false;
            boolean contentInsetsChanged = false;
            boolean visibleInsetsChanged;
            boolean hadSurface = mSurface.isValid();
            try 
            {
                int fl = 0;
                if(params != null)                
                {
                    fl = params.flags;
                    if(attachInfo.mKeepScreenOn)                    
                    {
                        params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                    } //End block
                    params.subtreeSystemUiVisibility = attachInfo.mSystemUiVisibility;
                    params.hasSystemUiListeners = attachInfo.mHasSystemUiListeners;
                } //End block
                if(DEBUG_LAYOUT)                
                {
                } //End block
                final int surfaceGenerationId = mSurface.getGenerationId();
                relayoutResult = relayoutWindow(params, viewVisibility, insetsPending);
                if(params != null)                
                {
                    params.flags = fl;
                } //End block
                if(DEBUG_LAYOUT){ }                if(mPendingConfiguration.seq != 0)                
                {
                    if(DEBUG_CONFIGURATION){ }                    updateConfiguration(mPendingConfiguration, !mFirst);
                    mPendingConfiguration.seq = 0;
                } //End block
                contentInsetsChanged = !mPendingContentInsets.equals(
                        mAttachInfo.mContentInsets);
                visibleInsetsChanged = !mPendingVisibleInsets.equals(
                        mAttachInfo.mVisibleInsets);
                if(contentInsetsChanged)                
                {
                    if(mWidth > 0 && mHeight > 0 &&
                            mSurface != null && mSurface.isValid() &&
                            !mAttachInfo.mTurnOffWindowResizeAnim &&
                            mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled() &&
                            mAttachInfo.mHardwareRenderer.validate() &&
                            lp != null && !PixelFormat.formatHasAlpha(lp.format))                    
                    {
                        disposeResizeBuffer();
                        boolean completed = false;
                        HardwareCanvas hwRendererCanvas = mAttachInfo.mHardwareRenderer.getCanvas();
                        HardwareCanvas layerCanvas = null;
                        try 
                        {
                            if(mResizeBuffer == null)                            
                            {
                                mResizeBuffer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                                        mWidth, mHeight, false);
                            } //End block
                            else
                            if(mResizeBuffer.getWidth() != mWidth ||
                                    mResizeBuffer.getHeight() != mHeight)                            
                            {
                                mResizeBuffer.resize(mWidth, mHeight);
                            } //End block
                            layerCanvas = mResizeBuffer.start(hwRendererCanvas);
                            layerCanvas.setViewport(mWidth, mHeight);
                            layerCanvas.onPreDraw(null);
                            final int restoreCount = layerCanvas.save();
                            layerCanvas.drawColor(0xff000000, PorterDuff.Mode.SRC);
                            int yoff;
                            final boolean scrolling = mScroller != null
                                    && mScroller.computeScrollOffset();
                            if(scrolling)                            
                            {
                                yoff = mScroller.getCurrY();
                                mScroller.abortAnimation();
                            } //End block
                            else
                            {
                                yoff = mScrollY;
                            } //End block
                            layerCanvas.translate(0, -yoff);
                            if(mTranslator != null)                            
                            {
                                mTranslator.translateCanvas(layerCanvas);
                            } //End block
                            mView.draw(layerCanvas);
                            mResizeBufferStartTime = SystemClock.uptimeMillis();
                            mResizeBufferDuration = mView.getResources().getInteger(
                                    com.android.internal.R.integer.config_mediumAnimTime);
                            completed = true;
                            layerCanvas.restoreToCount(restoreCount);
                        } //End block
                        catch (OutOfMemoryError e)
                        {
                        } //End block
                        finally 
                        {
                            if(layerCanvas != null)                            
                            {
                                layerCanvas.onPostDraw();
                            } //End block
                            if(mResizeBuffer != null)                            
                            {
                                mResizeBuffer.end(hwRendererCanvas);
                                if(!completed)                                
                                {
                                    mResizeBuffer.destroy();
                                    mResizeBuffer = null;
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                    mAttachInfo.mContentInsets.set(mPendingContentInsets);
                    host.fitSystemWindows(mAttachInfo.mContentInsets);
                    if(DEBUG_LAYOUT){ }
                } //End block
                if(visibleInsetsChanged)                
                {
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                    if(DEBUG_LAYOUT){ }
                } //End block
                if(!hadSurface)                
                {
                    if(mSurface.isValid())                    
                    {
                        newSurface = true;
                        fullRedrawNeeded = true;
                        mPreviousTransparentRegion.setEmpty();
                        if(mAttachInfo.mHardwareRenderer != null)                        
                        {
                            try 
                            {
                                hwInitialized = mAttachInfo.mHardwareRenderer.initialize(mHolder);
                            } //End block
                            catch (Surface.OutOfResourcesException e)
                            {
                                try 
                                {
                                    if(!sWindowSession.outOfMemory(mWindow))                                    
                                    {
                                        Process.killProcess(Process.myPid());
                                    } //End block
                                } //End block
                                catch (RemoteException ex)
                                {
                                } //End block
                                mLayoutRequested = true;
                                return;
                            } //End block
                        } //End block
                    } //End block
                } //End block
                else
                if(!mSurface.isValid())                
                {
                    mLastScrolledFocus = null;
                    mScrollY = mCurScrollY = 0;
                    if(mScroller != null)                    
                    {
                        mScroller.abortAnimation();
                    } //End block
                    disposeResizeBuffer();
                    if(mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled())                    
                    {
                        mAttachInfo.mHardwareRenderer.destroy(true);
                    } //End block
                } //End block
                else
                if(surfaceGenerationId != mSurface.getGenerationId() &&
                        mSurfaceHolder == null && mAttachInfo.mHardwareRenderer != null)                
                {
                    fullRedrawNeeded = true;
                    try 
                    {
                        mAttachInfo.mHardwareRenderer.updateSurface(mHolder);
                    } //End block
                    catch (Surface.OutOfResourcesException e)
                    {
                        try 
                        {
                            if(!sWindowSession.outOfMemory(mWindow))                            
                            {
                                Process.killProcess(Process.myPid());
                            } //End block
                        } //End block
                        catch (RemoteException ex)
                        {
                        } //End block
                        mLayoutRequested = true;
                        return;
                    } //End block
                } //End block
            } //End block
            catch (RemoteException e)
            {
            } //End block
            if(DEBUG_ORIENTATION){ }            attachInfo.mWindowLeft = frame.left;
            attachInfo.mWindowTop = frame.top;
            mWidth = frame.width();
            mHeight = frame.height();
            if(mSurfaceHolder != null)            
            {
                if(mSurface.isValid())                
                {
                    mSurfaceHolder.mSurface = mSurface;
                } //End block
                mSurfaceHolder.setSurfaceFrameSize(mWidth, mHeight);
                mSurfaceHolder.mSurfaceLock.unlock();
                if(mSurface.isValid())                
                {
                    if(!hadSurface)                    
                    {
                        mSurfaceHolder.ungetCallbacks();
                        mIsCreating = true;
                        mSurfaceHolderCallback.surfaceCreated(mSurfaceHolder);
                        SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                        if(callbacks != null)                        
                        {
for(SurfaceHolder.Callback c : callbacks)
                            {
                                c.surfaceCreated(mSurfaceHolder);
                            } //End block
                        } //End block
                        surfaceChanged = true;
                    } //End block
                    if(surfaceChanged)                    
                    {
                        mSurfaceHolderCallback.surfaceChanged(mSurfaceHolder,
                                lp.format, mWidth, mHeight);
                        SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                        if(callbacks != null)                        
                        {
for(SurfaceHolder.Callback c : callbacks)
                            {
                                c.surfaceChanged(mSurfaceHolder, lp.format,
                                        mWidth, mHeight);
                            } //End block
                        } //End block
                    } //End block
                    mIsCreating = false;
                } //End block
                else
                if(hadSurface)                
                {
                    mSurfaceHolder.ungetCallbacks();
                    SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                    mSurfaceHolderCallback.surfaceDestroyed(mSurfaceHolder);
                    if(callbacks != null)                    
                    {
for(SurfaceHolder.Callback c : callbacks)
                        {
                            c.surfaceDestroyed(mSurfaceHolder);
                        } //End block
                    } //End block
                    mSurfaceHolder.mSurfaceLock.lock();
                    try 
                    {
                        mSurfaceHolder.mSurface = new Surface();
                    } //End block
                    finally 
                    {
                        mSurfaceHolder.mSurfaceLock.unlock();
                    } //End block
                } //End block
            } //End block
            if(mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled())            
            {
                if(hwInitialized || windowShouldResize ||
                        mWidth != mAttachInfo.mHardwareRenderer.getWidth() ||
                        mHeight != mAttachInfo.mHardwareRenderer.getHeight())                
                {
                    mAttachInfo.mHardwareRenderer.setup(mWidth, mHeight);
                    if(!hwInitialized)                    
                    {
                        mAttachInfo.mHardwareRenderer.invalidate(mHolder);
                    } //End block
                } //End block
            } //End block
            if(!mStopped)            
            {
                boolean focusChangedDueToTouchMode = ensureTouchModeLocally(
                        (relayoutResult&WindowManagerImpl.RELAYOUT_RES_IN_TOUCH_MODE) != 0);
                if(focusChangedDueToTouchMode || mWidth != host.getMeasuredWidth()
                        || mHeight != host.getMeasuredHeight() || contentInsetsChanged)                
                {
                    childWidthMeasureSpec = getRootMeasureSpec(mWidth, lp.width);
                    childHeightMeasureSpec = getRootMeasureSpec(mHeight, lp.height);
                    if(DEBUG_LAYOUT){ }                    host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    int width = host.getMeasuredWidth();
                    int height = host.getMeasuredHeight();
                    boolean measureAgain = false;
                    if(lp.horizontalWeight > 0.0f)                    
                    {
                        width += (int) ((mWidth - width) * lp.horizontalWeight);
                        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width,
                                MeasureSpec.EXACTLY);
                        measureAgain = true;
                    } //End block
                    if(lp.verticalWeight > 0.0f)                    
                    {
                        height += (int) ((mHeight - height) * lp.verticalWeight);
                        childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                                MeasureSpec.EXACTLY);
                        measureAgain = true;
                    } //End block
                    if(measureAgain)                    
                    {
                        if(DEBUG_LAYOUT){ }                        host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    } //End block
                    mLayoutRequested = true;
                } //End block
            } //End block
        } //End block
        final boolean didLayout = mLayoutRequested && !mStopped;
        boolean triggerGlobalLayoutListener = didLayout
                || attachInfo.mRecomputeGlobalAttributes;
        if(didLayout)        
        {
            mLayoutRequested = false;
            mScrollMayChange = true;
            if(DEBUG_ORIENTATION || DEBUG_LAYOUT){ }            long startTime = 0L;
            if(ViewDebug.DEBUG_PROFILE_LAYOUT)            
            {
                startTime = SystemClock.elapsedRealtime();
            } //End block
            host.layout(0, 0, host.getMeasuredWidth(), host.getMeasuredHeight());
            if(false && ViewDebug.consistencyCheckEnabled)            
            {
                if(!host.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_LAYOUT))                
                {
                    IllegalStateException var68DC24C0F422438B24EC99F1121C3DC1_549328726 = new IllegalStateException("The view hierarchy is an inconsistent state,"
                            + "please refer to the logs with the tag "
                            + ViewDebug.CONSISTENCY_LOG_TAG + " for more infomation.");
                    var68DC24C0F422438B24EC99F1121C3DC1_549328726.addTaint(taint);
                    throw var68DC24C0F422438B24EC99F1121C3DC1_549328726;
                } //End block
            } //End block
            if(ViewDebug.DEBUG_PROFILE_LAYOUT)            
            {
                EventLog.writeEvent(60001, SystemClock.elapsedRealtime() - startTime);
            } //End block
            if((host.mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) != 0)            
            {
                host.getLocationInWindow(mTmpLocation);
                mTransparentRegion.set(mTmpLocation[0], mTmpLocation[1],
                        mTmpLocation[0] + host.mRight - host.mLeft,
                        mTmpLocation[1] + host.mBottom - host.mTop);
                host.gatherTransparentRegion(mTransparentRegion);
                if(mTranslator != null)                
                {
                    mTranslator.translateRegionInWindowToScreen(mTransparentRegion);
                } //End block
                if(!mTransparentRegion.equals(mPreviousTransparentRegion))                
                {
                    mPreviousTransparentRegion.set(mTransparentRegion);
                    try 
                    {
                        sWindowSession.setTransparentRegion(mWindow, mTransparentRegion);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
            } //End block
            if(DBG)            
            {
                System.out.println("======================================");
                System.out.println("performTraversals -- after setFrame");
                host.debug();
            } //End block
        } //End block
        if(triggerGlobalLayoutListener)        
        {
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mTreeObserver.dispatchOnGlobalLayout();
            if(AccessibilityManager.getInstance(host.mContext).isEnabled())            
            {
                postSendWindowContentChangedCallback();
            } //End block
        } //End block
        if(computesInternalInsets)        
        {
            final ViewTreeObserver.InternalInsetsInfo insets = attachInfo.mGivenInternalInsets;
            insets.reset();
            attachInfo.mTreeObserver.dispatchOnComputeInternalInsets(insets);
            if(insetsPending || !mLastGivenInsets.equals(insets))            
            {
                mLastGivenInsets.set(insets);
                Rect contentInsets;
                Rect visibleInsets;
                Region touchableRegion;
                if(mTranslator != null)                
                {
                    contentInsets = mTranslator.getTranslatedContentInsets(insets.contentInsets);
                    visibleInsets = mTranslator.getTranslatedVisibleInsets(insets.visibleInsets);
                    touchableRegion = mTranslator.getTranslatedTouchableArea(insets.touchableRegion);
                } //End block
                else
                {
                    contentInsets = insets.contentInsets;
                    visibleInsets = insets.visibleInsets;
                    touchableRegion = insets.touchableRegion;
                } //End block
                try 
                {
                    sWindowSession.setInsets(mWindow, insets.mTouchableInsets,
                            contentInsets, visibleInsets, touchableRegion);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        if(mFirst)        
        {
            if(DEBUG_INPUT_RESIZE){ }            if(mView != null)            
            {
                if(!mView.hasFocus())                
                {
                    mView.requestFocus(View.FOCUS_FORWARD);
                    mFocusedView = mRealFocusedView = mView.findFocus();
                    if(DEBUG_INPUT_RESIZE){ }
                } //End block
                else
                {
                    mRealFocusedView = mView.findFocus();
                    if(DEBUG_INPUT_RESIZE){ }
                } //End block
            } //End block
        } //End block
        mFirst = false;
        mWillDrawSoon = false;
        mNewSurfaceNeeded = false;
        mViewVisibility = viewVisibility;
        if(mAttachInfo.mHasWindowFocus)        
        {
            final boolean imTarget = WindowManager.LayoutParams
                    .mayUseInputMethod(mWindowAttributes.flags);
            if(imTarget != mLastWasImTarget)            
            {
                mLastWasImTarget = imTarget;
                InputMethodManager imm = InputMethodManager.peekInstance();
                if(imm != null && imTarget)                
                {
                    imm.startGettingWindowFocus(mView);
                    imm.onWindowFocus(mView, mView.findFocus(),
                            mWindowAttributes.softInputMode,
                            !mHasHadWindowFocus, mWindowAttributes.flags);
                } //End block
            } //End block
        } //End block
        boolean cancelDraw = attachInfo.mTreeObserver.dispatchOnPreDraw() ||
                viewVisibility != View.VISIBLE;
        if(!cancelDraw && !newSurface)        
        {
            if(mPendingTransitions != null && mPendingTransitions.size() > 0)            
            {
for(int i = 0;i < mPendingTransitions.size();++i)
                {
                    mPendingTransitions.get(i).startChangingAnimations();
                } //End block
                mPendingTransitions.clear();
            } //End block
            mFullRedrawNeeded = false;
            long drawStartTime;
            if(ViewDebug.DEBUG_LATENCY)            
            {
                drawStartTime = System.nanoTime();
            } //End block
            draw(fullRedrawNeeded);
            if(ViewDebug.DEBUG_LATENCY)            
            {
                mLastDrawDurationNanos = System.nanoTime() - drawStartTime;
            } //End block
            if((relayoutResult&WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0
                    || mReportNextDraw)            
            {
                if(LOCAL_LOGV)                
                {
                } //End block
                mReportNextDraw = false;
                if(mSurfaceHolder != null && mSurface.isValid())                
                {
                    mSurfaceHolderCallback.surfaceRedrawNeeded(mSurfaceHolder);
                    SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                    if(callbacks != null)                    
                    {
for(SurfaceHolder.Callback c : callbacks)
                        {
                            if(c instanceof SurfaceHolder.Callback2)                            
                            {
                                ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                        mSurfaceHolder);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                try 
                {
                    sWindowSession.finishDrawing(mWindow);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
        } //End block
        else
        {
            if(mPendingTransitions != null && mPendingTransitions.size() > 0)            
            {
for(int i = 0;i < mPendingTransitions.size();++i)
                {
                    mPendingTransitions.get(i).endChangingAnimations();
                } //End block
                mPendingTransitions.clear();
            } //End block
            if((relayoutResult&WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0)            
            {
                mReportNextDraw = true;
            } //End block
            if(fullRedrawNeeded)            
            {
                mFullRedrawNeeded = true;
            } //End block
            if(viewVisibility == View.VISIBLE)            
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.696 -0400", hash_original_method = "365202E212CCFCA6F73CFA951F572330", hash_generated_method = "97332D9A2B1208107AE761D2933E7039")
    public void requestTransparentRegion(View child) {
        addTaint(child.getTaint());
        checkThread();
        if(mView == child)        
        {
            mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            mWindowAttributesChanged = true;
            mWindowAttributesChangesFlag = 0;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mView == child) {
            //mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            //mWindowAttributesChanged = true;
            //mWindowAttributesChangesFlag = 0;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.696 -0400", hash_original_method = "66EB141D637AEB4DAD3BF6AA91407C70", hash_generated_method = "493BFD860307C7F5963348E2BEEC8431")
    private int getRootMeasureSpec(int windowSize, int rootDimension) {
        addTaint(rootDimension);
        addTaint(windowSize);
        int measureSpec;
switch(rootDimension){
        case ViewGroup.LayoutParams.MATCH_PARENT:
        measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
        break;
        case ViewGroup.LayoutParams.WRAP_CONTENT:
        measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
        break;
        default:
        measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
        break;
}        int var4DBE2C778E19A82616066A0A1C1DBEC9_49500016 = (measureSpec);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343840155 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1343840155;
        // ---------- Original Method ----------
        //int measureSpec;
        //switch (rootDimension) {
        //case ViewGroup.LayoutParams.MATCH_PARENT:
            //measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
            //break;
        //case ViewGroup.LayoutParams.WRAP_CONTENT:
            //measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
            //break;
        //default:
            //measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
            //break;
        //}
        //return measureSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.696 -0400", hash_original_method = "40FADC477E8B2549BFFAC38F5B19946C", hash_generated_method = "6FAD1092DFFF46E02505F777F43C3DDC")
    public void onHardwarePreDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        canvas.translate(0, -mHardwareYOffset);
        // ---------- Original Method ----------
        //canvas.translate(0, -mHardwareYOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.697 -0400", hash_original_method = "0640B89EE45E5EFA4DD1A520BD523415", hash_generated_method = "4E6169D850D97A2E2FD694BE2EC6A9E5")
    public void onHardwarePostDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        if(mResizeBuffer != null)        
        {
            mResizePaint.setAlpha(mResizeAlpha);
            canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        } //End block
        // ---------- Original Method ----------
        //if (mResizeBuffer != null) {
            //mResizePaint.setAlpha(mResizeAlpha);
            //canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.698 -0400", hash_original_method = "6ED7CE075B975161CAA5CFD7B073E953", hash_generated_method = "97B50B99A2F39A876F8201C5D40EA811")
     void outputDisplayList(View view) {
        addTaint(view.getTaint());
        if(mAttachInfo != null && mAttachInfo.mHardwareCanvas != null)        
        {
            DisplayList displayList = view.getDisplayList();
            if(displayList != null)            
            {
                mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null && mAttachInfo.mHardwareCanvas != null) {
            //DisplayList displayList = view.getDisplayList();
            //if (displayList != null) {
                //mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.701 -0400", hash_original_method = "910E3893A962467411DC222791137B30", hash_generated_method = "49387EC969D416737BD7B733A6FE8CAA")
    private void profileRendering(boolean enabled) {
        if(mProfileRendering)        
        {
            mRenderProfilingEnabled = enabled;
            if(mRenderProfiler == null)            
            {
                mRenderProfiler = new Thread(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.700 -0400", hash_original_method = "EA0E14B14C78DD1BF1B50C8FA4E06FFC", hash_generated_method = "A0138F50BF6D6A9908DFF1FE3657E223")
        @Override
        public void run() {
            Log.d(TAG, "Starting profiling thread");
            while
(mRenderProfilingEnabled)            
            {
                mAttachInfo.mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.699 -0400", hash_original_method = "4A3D1224B1F9A46A2478F0B98B77BC62", hash_generated_method = "3306EB70EC747DC660D40B63C10E33A1")
            @Override
            public void run() {
                mDirty.set(0, 0, mWidth, mHeight);
                scheduleTraversals();
                // ---------- Original Method ----------
                //mDirty.set(0, 0, mWidth, mHeight);
                //scheduleTraversals();
            }
});
                try 
                {
                    Thread.sleep(15);
                } //End block
                catch (InterruptedException e)
                {
                    Log.d(TAG, "Exiting profiling thread");
                } //End block
            } //End block
            // ---------- Original Method ----------
            //Log.d(TAG, "Starting profiling thread");
            //while (mRenderProfilingEnabled) {
                            //mAttachInfo.mHandler.post(new Runnable() {
                                //@Override
                                //public void run() {
                                    //mDirty.set(0, 0, mWidth, mHeight);
                                    //scheduleTraversals();
                                //}
                            //});
                            //try {
                                //Thread.sleep(15);
                            //} catch (InterruptedException e) {
                                //Log.d(TAG, "Exiting profiling thread");
                            //}                            
                        //}
        }
}, "Rendering Profiler");
                mRenderProfiler.start();
            } //End block
            else
            {
                mRenderProfiler.interrupt();
                mRenderProfiler = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.703 -0400", hash_original_method = "1AA1A4B748D7601F4F3826735499E6F6", hash_generated_method = "CCA669169C1C908F782E87A5CFB244C5")
    private void trackFPS() {
        long nowTime = System.currentTimeMillis();
        if(mFpsStartTime < 0)        
        {
            mFpsStartTime = mFpsPrevTime = nowTime;
            mFpsNumFrames = 0;
        } //End block
        else
        {
            ++mFpsNumFrames;
            String thisHash = Integer.toHexString(System.identityHashCode(this));
            long frameTime = nowTime - mFpsPrevTime;
            long totalTime = nowTime - mFpsStartTime;
            mFpsPrevTime = nowTime;
            if(totalTime > 1000)            
            {
                float fps = (float) mFpsNumFrames * 1000 / totalTime;
                mFpsStartTime = nowTime;
                mFpsNumFrames = 0;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //long nowTime = System.currentTimeMillis();
        //if (mFpsStartTime < 0) {
            //mFpsStartTime = mFpsPrevTime = nowTime;
            //mFpsNumFrames = 0;
        //} else {
            //++mFpsNumFrames;
            //String thisHash = Integer.toHexString(System.identityHashCode(this));
            //long frameTime = nowTime - mFpsPrevTime;
            //long totalTime = nowTime - mFpsStartTime;
            //Log.v(TAG, "0x" + thisHash + "\tFrame time:\t" + frameTime);
            //mFpsPrevTime = nowTime;
            //if (totalTime > 1000) {
                //float fps = (float) mFpsNumFrames * 1000 / totalTime;
                //Log.v(TAG, "0x" + thisHash + "\tFPS:\t" + fps);
                //mFpsStartTime = nowTime;
                //mFpsNumFrames = 0;
            //}
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.707 -0400", hash_original_method = "E37EF3DCFB26F629DB3873EE57113F2D", hash_generated_method = "585D4D7435DF39014F722DB595521D0D")
    private void draw(boolean fullRedrawNeeded) {
        addTaint(fullRedrawNeeded);
        Surface surface = mSurface;
        if(surface == null || !surface.isValid())        
        {
            return;
        } //End block
        if(DEBUG_FPS)        
        {
            trackFPS();
        } //End block
        if(!sFirstDrawComplete)        
        {
            synchronized
(sFirstDrawHandlers)            {
                sFirstDrawComplete = true;
                final int count = sFirstDrawHandlers.size();
for(int i = 0;i< count;i++)
                {
                    post(sFirstDrawHandlers.get(i));
                } //End block
            } //End block
        } //End block
        scrollToRectOrFocus(null, false);
        if(mAttachInfo.mViewScrollChanged)        
        {
            mAttachInfo.mViewScrollChanged = false;
            mAttachInfo.mTreeObserver.dispatchOnScrollChanged();
        } //End block
        int yoff;
        boolean animating = mScroller != null && mScroller.computeScrollOffset();
        if(animating)        
        {
            yoff = mScroller.getCurrY();
        } //End block
        else
        {
            yoff = mScrollY;
        } //End block
        if(mCurScrollY != yoff)        
        {
            mCurScrollY = yoff;
            fullRedrawNeeded = true;
        } //End block
        float appScale = mAttachInfo.mApplicationScale;
        boolean scalingRequired = mAttachInfo.mScalingRequired;
        int resizeAlpha = 0;
        if(mResizeBuffer != null)        
        {
            long deltaTime = SystemClock.uptimeMillis() - mResizeBufferStartTime;
            if(deltaTime < mResizeBufferDuration)            
            {
                float amt = deltaTime/(float) mResizeBufferDuration;
                amt = mResizeInterpolator.getInterpolation(amt);
                animating = true;
                resizeAlpha = 255 - (int)(amt*255);
            } //End block
            else
            {
                disposeResizeBuffer();
            } //End block
        } //End block
        Rect dirty = mDirty;
        if(mSurfaceHolder != null)        
        {
            dirty.setEmpty();
            if(animating)            
            {
                if(mScroller != null)                
                {
                    mScroller.abortAnimation();
                } //End block
                disposeResizeBuffer();
            } //End block
            return;
        } //End block
        if(fullRedrawNeeded)        
        {
            mAttachInfo.mIgnoreDirtyState = true;
            dirty.set(0, 0, (int) (mWidth * appScale + 0.5f), (int) (mHeight * appScale + 0.5f));
        } //End block
        if(mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled())        
        {
            if(!dirty.isEmpty() || mIsAnimating)            
            {
                mIsAnimating = false;
                mHardwareYOffset = yoff;
                mResizeAlpha = resizeAlpha;
                mCurrentDirty.set(dirty);
                mCurrentDirty.union(mPreviousDirty);
                mPreviousDirty.set(dirty);
                dirty.setEmpty();
                Rect currentDirty = mCurrentDirty;
                if(animating)                
                {
                    currentDirty = null;
                } //End block
                if(mAttachInfo.mHardwareRenderer.draw(mView, mAttachInfo, this, currentDirty))                
                {
                    mPreviousDirty.set(0, 0, mWidth, mHeight);
                } //End block
            } //End block
            if(animating)            
            {
                mFullRedrawNeeded = true;
                scheduleTraversals();
            } //End block
            return;
        } //End block
        if(DEBUG_ORIENTATION || DEBUG_DRAW)        
        {
        } //End block
        if(!dirty.isEmpty() || mIsAnimating)        
        {
            Canvas canvas;
            try 
            {
                int left = dirty.left;
                int top = dirty.top;
                int right = dirty.right;
                int bottom = dirty.bottom;
                long lockCanvasStartTime;
                if(ViewDebug.DEBUG_LATENCY)                
                {
                    lockCanvasStartTime = System.nanoTime();
                } //End block
                canvas = surface.lockCanvas(dirty);
                if(ViewDebug.DEBUG_LATENCY)                
                {
                    long now = System.nanoTime();
                    Log.d(TAG, "Latency: Spent "
                            + ((now - lockCanvasStartTime) * 0.000001f)
                            + "ms waiting for surface.lockCanvas()");
                } //End block
                if(left != dirty.left || top != dirty.top || right != dirty.right ||
                        bottom != dirty.bottom)                
                {
                    mAttachInfo.mIgnoreDirtyState = true;
                } //End block
                canvas.setDensity(mDensity);
            } //End block
            catch (Surface.OutOfResourcesException e)
            {
                try 
                {
                    if(!sWindowSession.outOfMemory(mWindow))                    
                    {
                        Process.killProcess(Process.myPid());
                    } //End block
                } //End block
                catch (RemoteException ex)
                {
                } //End block
                mLayoutRequested = true;
                return;
            } //End block
            catch (IllegalArgumentException e)
            {
                mLayoutRequested = true;
                return;
            } //End block
            try 
            {
                if(!dirty.isEmpty() || mIsAnimating)                
                {
                    long startTime = 0L;
                    if(DEBUG_ORIENTATION || DEBUG_DRAW)                    
                    {
                    } //End block
                    if(ViewDebug.DEBUG_PROFILE_DRAWING)                    
                    {
                        startTime = SystemClock.elapsedRealtime();
                    } //End block
                    if(!canvas.isOpaque() || yoff != 0)                    
                    {
                        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    } //End block
                    dirty.setEmpty();
                    mIsAnimating = false;
                    mAttachInfo.mDrawingTime = SystemClock.uptimeMillis();
                    mView.mPrivateFlags |= View.DRAWN;
                    if(DEBUG_DRAW)                    
                    {
                        Context cxt = mView.getContext();
                    } //End block
                    try 
                    {
                        canvas.translate(0, -yoff);
                        if(mTranslator != null)                        
                        {
                            mTranslator.translateCanvas(canvas);
                        } //End block
                        canvas.setScreenDensity(scalingRequired
                                ? DisplayMetrics.DENSITY_DEVICE : 0);
                        mAttachInfo.mSetIgnoreDirtyState = false;
                        mView.draw(canvas);
                    } //End block
                    finally 
                    {
                        if(!mAttachInfo.mSetIgnoreDirtyState)                        
                        {
                            mAttachInfo.mIgnoreDirtyState = false;
                        } //End block
                    } //End block
                    if(false && ViewDebug.consistencyCheckEnabled)                    
                    {
                        mView.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_DRAWING);
                    } //End block
                    if(ViewDebug.DEBUG_PROFILE_DRAWING)                    
                    {
                        EventLog.writeEvent(60000, SystemClock.elapsedRealtime() - startTime);
                    } //End block
                } //End block
            } //End block
            finally 
            {
                surface.unlockCanvasAndPost(canvas);
            } //End block
        } //End block
        if(LOCAL_LOGV)        
        {
        } //End block
        if(animating)        
        {
            mFullRedrawNeeded = true;
            scheduleTraversals();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.709 -0400", hash_original_method = "FAD7953F436A3C038802D5DE07F19E9E", hash_generated_method = "3A620D214332DEFD4806B8F4DCCD5CB8")
     boolean scrollToRectOrFocus(Rect rectangle, boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        final View.AttachInfo attachInfo = mAttachInfo;
        final Rect ci = attachInfo.mContentInsets;
        final Rect vi = attachInfo.mVisibleInsets;
        int scrollY = 0;
        boolean handled = false;
        if(vi.left > ci.left || vi.top > ci.top
                || vi.right > ci.right || vi.bottom > ci.bottom)        
        {
            scrollY = mScrollY;
            View focus = mRealFocusedView;
            if(focus == null || focus.mAttachInfo != mAttachInfo)            
            {
                mRealFocusedView = null;
                boolean var68934A3E9455FA72420237EB05902327_1664346025 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671231845 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671231845;
            } //End block
            if(focus != mLastScrolledFocus)            
            {
                rectangle = null;
            } //End block
            if(DEBUG_INPUT_RESIZE){ }            if(focus == mLastScrolledFocus && !mScrollMayChange
                    && rectangle == null)            
            {
                if(DEBUG_INPUT_RESIZE){ }
            } //End block
            else
            if(focus != null)            
            {
                mLastScrolledFocus = focus;
                mScrollMayChange = false;
                if(DEBUG_INPUT_RESIZE){ }                if(focus.getGlobalVisibleRect(mVisRect, null))                
                {
                    if(DEBUG_INPUT_RESIZE){ }                    if(rectangle == null)                    
                    {
                        focus.getFocusedRect(mTempRect);
                        if(DEBUG_INPUT_RESIZE){ }                        if(mView instanceof ViewGroup)                        
                        {
                            ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focus, mTempRect);
                        } //End block
                        if(DEBUG_INPUT_RESIZE){ }
                    } //End block
                    else
                    {
                        mTempRect.set(rectangle);
                        if(DEBUG_INPUT_RESIZE){ }
                    } //End block
                    if(mTempRect.intersect(mVisRect))                    
                    {
                        if(DEBUG_INPUT_RESIZE){ }                        if(mTempRect.height() >
                                (mView.getHeight()-vi.top-vi.bottom))                        
                        {
                            if(DEBUG_INPUT_RESIZE){ }
                        } //End block
                        else
                        if((mTempRect.top-scrollY) < vi.top)                        
                        {
                            scrollY -= vi.top - (mTempRect.top-scrollY);
                            if(DEBUG_INPUT_RESIZE){ }
                        } //End block
                        else
                        if((mTempRect.bottom-scrollY)
                                > (mView.getHeight()-vi.bottom))                        
                        {
                            scrollY += (mTempRect.bottom-scrollY)
                                    - (mView.getHeight()-vi.bottom);
                            if(DEBUG_INPUT_RESIZE){ }
                        } //End block
                        handled = true;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(scrollY != mScrollY)        
        {
            if(DEBUG_INPUT_RESIZE){ }            if(!immediate && mResizeBuffer == null)            
            {
                if(mScroller == null)                
                {
                    mScroller = new Scroller(mView.getContext());
                } //End block
                mScroller.startScroll(0, mScrollY, 0, scrollY-mScrollY);
            } //End block
            else
            if(mScroller != null)            
            {
                mScroller.abortAnimation();
            } //End block
            mScrollY = scrollY;
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1179491542 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123555833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_123555833;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.710 -0400", hash_original_method = "9E09AEB1258054D8E474B794DDE3DA53", hash_generated_method = "8D7694D2CF9132ABA6121FD3EBE08FBD")
    public void requestChildFocus(View child, View focused) {
        addTaint(child.getTaint());
        checkThread();
        if(mFocusedView != focused)        
        {
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mFocusedView, focused);
            scheduleTraversals();
        } //End block
        mFocusedView = mRealFocusedView = focused;
        if(DEBUG_INPUT_RESIZE){ }
        // ---------- Original Method ----------
        //checkThread();
        //if (mFocusedView != focused) {
            //mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mFocusedView, focused);
            //scheduleTraversals();
        //}
        //mFocusedView = mRealFocusedView = focused;
        //if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Request child focus: focus now "
                //+ mFocusedView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.711 -0400", hash_original_method = "D78AE43D1295D32838328E11498E7092", hash_generated_method = "9A3FD784D83C2EA4B2127A3D49FEF32D")
    public void clearChildFocus(View child) {
        addTaint(child.getTaint());
        checkThread();
        View oldFocus = mFocusedView;
        if(DEBUG_INPUT_RESIZE){ }        mFocusedView = mRealFocusedView = null;
        if(mView != null && !mView.hasFocus())        
        {
            if(!mView.requestFocus(View.FOCUS_FORWARD))            
            {
                mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
            } //End block
        } //End block
        else
        if(oldFocus != null)        
        {
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //View oldFocus = mFocusedView;
        //if (DEBUG_INPUT_RESIZE) Log.v(TAG, "Clearing child focus");
        //mFocusedView = mRealFocusedView = null;
        //if (mView != null && !mView.hasFocus()) {
            //if (!mView.requestFocus(View.FOCUS_FORWARD)) {
                //mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
            //}
        //} else if (oldFocus != null) {
            //mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.711 -0400", hash_original_method = "8AB5F5420D903C559791A9BF9B9BF8FD", hash_generated_method = "59B06C632F78E4BF24D775196340FA27")
    public void focusableViewAvailable(View v) {
        addTaint(v.getTaint());
        checkThread();
        if(mView != null)        
        {
            if(!mView.hasFocus())            
            {
                v.requestFocus();
            } //End block
            else
            {
                mFocusedView = mView.findFocus();
                boolean descendantsHaveDibsOnFocus = (mFocusedView instanceof ViewGroup) &&
                            (((ViewGroup) mFocusedView).getDescendantFocusability() ==
                                    ViewGroup.FOCUS_AFTER_DESCENDANTS);
                if(descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView))                
                {
                    v.requestFocus();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mView != null) {
            //if (!mView.hasFocus()) {
                //v.requestFocus();
            //} else {
                //mFocusedView = mView.findFocus();
                //boolean descendantsHaveDibsOnFocus =
                        //(mFocusedView instanceof ViewGroup) &&
                            //(((ViewGroup) mFocusedView).getDescendantFocusability() ==
                                    //ViewGroup.FOCUS_AFTER_DESCENDANTS);
                //if (descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView)) {
                    //v.requestFocus();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.712 -0400", hash_original_method = "66451BF0E175BE00AB35036422B65D7E", hash_generated_method = "7E7E675E93FBD9242C0C7F59AC241A19")
    public void recomputeViewAttributes(View child) {
        addTaint(child.getTaint());
        checkThread();
        if(mView == child)        
        {
            mAttachInfo.mRecomputeGlobalAttributes = true;
            if(!mWillDrawSoon)            
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkThread();
        //if (mView == child) {
            //mAttachInfo.mRecomputeGlobalAttributes = true;
            //if (!mWillDrawSoon) {
                //scheduleTraversals();
            //}
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.712 -0400", hash_original_method = "59E93FB376BDE71F69616A2B01BFF0AF", hash_generated_method = "7A315E1F9F609BE89A389E9106B36598")
     void dispatchDetachedFromWindow() {
        if(mView != null && mView.mAttachInfo != null)        
        {
            if(mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled())            
            {
                mAttachInfo.mHardwareRenderer.validate();
            } //End block
            mView.dispatchDetachedFromWindow();
        } //End block
        mAccessibilityInteractionConnectionManager.ensureNoConnection();
        mAccessibilityManager.removeAccessibilityStateChangeListener(
                mAccessibilityInteractionConnectionManager);
        removeSendWindowContentChangedCallback();
        mView = null;
        mAttachInfo.mRootView = null;
        mAttachInfo.mSurface = null;
        destroyHardwareRenderer();
        mSurface.release();
        if(mInputQueueCallback != null && mInputQueue != null)        
        {
            mInputQueueCallback.onInputQueueDestroyed(mInputQueue);
            mInputQueueCallback = null;
            mInputQueue = null;
        } //End block
        else
        if(mInputChannel != null)        
        {
            InputQueue.unregisterInputChannel(mInputChannel);
        } //End block
        try 
        {
            sWindowSession.remove(mWindow);
        } //End block
        catch (RemoteException e)
        {
        } //End block
        if(mInputChannel != null)        
        {
            mInputChannel.dispose();
            mInputChannel = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.713 -0400", hash_original_method = "095941099FB476714878603F2FD5257D", hash_generated_method = "BB6BD59336207DEDA614CEA51776FD59")
     void updateConfiguration(Configuration config, boolean force) {
        addTaint(force);
        addTaint(config.getTaint());
        if(DEBUG_CONFIGURATION){ }        CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        if(ci != null)        
        {
            config = new Configuration(config);
            ci.applyToConfiguration(config);
        } //End block
        synchronized
(sConfigCallbacks)        {
for(int i=sConfigCallbacks.size()-1;i>=0;i--)
            {
                sConfigCallbacks.get(i).onConfigurationChanged(config);
            } //End block
        } //End block
        if(mView != null)        
        {
            config = mView.getResources().getConfiguration();
            if(force || mLastConfiguration.diff(config) != 0)            
            {
                mLastConfiguration.setTo(config);
                mView.dispatchConfigurationChanged(config);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }
        final ViewParent theParent = child.getParent();
        return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    
    private static void forceLayout(View view) {
        view.forceLayout();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            final int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                forceLayout(group.getChildAt(i));
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.714 -0400", hash_original_method = "95F12947A9B342E5A748CE842344783A", hash_generated_method = "73D802B587924AADF9727BFD8E1C11E8")
    @Override
    public String getMessageName(Message message) {
        addTaint(message.getTaint());
switch(message.what){
        case DO_TRAVERSAL:
String var009EE0D3A81042046344ADF4EDF5C71A_1995523261 =         "DO_TRAVERSAL";
        var009EE0D3A81042046344ADF4EDF5C71A_1995523261.addTaint(taint);
        return var009EE0D3A81042046344ADF4EDF5C71A_1995523261;
        case DIE:
String varAE1F1B3718793C3AD8C3C91EAFA956F4_1407242591 =         "DIE";
        varAE1F1B3718793C3AD8C3C91EAFA956F4_1407242591.addTaint(taint);
        return varAE1F1B3718793C3AD8C3C91EAFA956F4_1407242591;
        case RESIZED:
String var4D6BEE3D8412D1DD099D8FDC6D9E355E_1346441748 =         "RESIZED";
        var4D6BEE3D8412D1DD099D8FDC6D9E355E_1346441748.addTaint(taint);
        return var4D6BEE3D8412D1DD099D8FDC6D9E355E_1346441748;
        case RESIZED_REPORT:
String var637E2530E38AE79C3001700EF82015AC_1868036047 =         "RESIZED_REPORT";
        var637E2530E38AE79C3001700EF82015AC_1868036047.addTaint(taint);
        return var637E2530E38AE79C3001700EF82015AC_1868036047;
        case WINDOW_FOCUS_CHANGED:
String varEDAA91A06D2E139E8058D7ABC53E0270_67881347 =         "WINDOW_FOCUS_CHANGED";
        varEDAA91A06D2E139E8058D7ABC53E0270_67881347.addTaint(taint);
        return varEDAA91A06D2E139E8058D7ABC53E0270_67881347;
        case DISPATCH_KEY:
String var8E32E12F9EFBAA8ADB8EC4E8B9AE7A92_1702769772 =         "DISPATCH_KEY";
        var8E32E12F9EFBAA8ADB8EC4E8B9AE7A92_1702769772.addTaint(taint);
        return var8E32E12F9EFBAA8ADB8EC4E8B9AE7A92_1702769772;
        case DISPATCH_POINTER:
String var05CA40E111D783A93CF71F4F972974B5_543411202 =         "DISPATCH_POINTER";
        var05CA40E111D783A93CF71F4F972974B5_543411202.addTaint(taint);
        return var05CA40E111D783A93CF71F4F972974B5_543411202;
        case DISPATCH_TRACKBALL:
String var2A0B62D3F480D3D9E5B7BC2F1DFCB633_1678889610 =         "DISPATCH_TRACKBALL";
        var2A0B62D3F480D3D9E5B7BC2F1DFCB633_1678889610.addTaint(taint);
        return var2A0B62D3F480D3D9E5B7BC2F1DFCB633_1678889610;
        case DISPATCH_APP_VISIBILITY:
String varB3895287E850A51A132E988E07828717_105515537 =         "DISPATCH_APP_VISIBILITY";
        varB3895287E850A51A132E988E07828717_105515537.addTaint(taint);
        return varB3895287E850A51A132E988E07828717_105515537;
        case DISPATCH_GET_NEW_SURFACE:
String var2D6D325A34862826781845611AB0916A_1102767884 =         "DISPATCH_GET_NEW_SURFACE";
        var2D6D325A34862826781845611AB0916A_1102767884.addTaint(taint);
        return var2D6D325A34862826781845611AB0916A_1102767884;
        case FINISHED_EVENT:
String varAE6053E98349010588F6F2B56F625C4D_909784587 =         "FINISHED_EVENT";
        varAE6053E98349010588F6F2B56F625C4D_909784587.addTaint(taint);
        return varAE6053E98349010588F6F2B56F625C4D_909784587;
        case DISPATCH_KEY_FROM_IME:
String var7DEEF7004257DED516429CB647A667BE_829782902 =         "DISPATCH_KEY_FROM_IME";
        var7DEEF7004257DED516429CB647A667BE_829782902.addTaint(taint);
        return var7DEEF7004257DED516429CB647A667BE_829782902;
        case FINISH_INPUT_CONNECTION:
String var2794B2420562EBD80B1EF81A0CCD79B4_192793902 =         "FINISH_INPUT_CONNECTION";
        var2794B2420562EBD80B1EF81A0CCD79B4_192793902.addTaint(taint);
        return var2794B2420562EBD80B1EF81A0CCD79B4_192793902;
        case CHECK_FOCUS:
String varA9CB3DAD7B6938CD5C41BEFEFF357381_1440912090 =         "CHECK_FOCUS";
        varA9CB3DAD7B6938CD5C41BEFEFF357381_1440912090.addTaint(taint);
        return varA9CB3DAD7B6938CD5C41BEFEFF357381_1440912090;
        case CLOSE_SYSTEM_DIALOGS:
String varC51FC247E77CA5C2441E03D1B529DF13_668071964 =         "CLOSE_SYSTEM_DIALOGS";
        varC51FC247E77CA5C2441E03D1B529DF13_668071964.addTaint(taint);
        return varC51FC247E77CA5C2441E03D1B529DF13_668071964;
        case DISPATCH_DRAG_EVENT:
String var0706B44EA07F33B4F96E2A745CE6A146_340952292 =         "DISPATCH_DRAG_EVENT";
        var0706B44EA07F33B4F96E2A745CE6A146_340952292.addTaint(taint);
        return var0706B44EA07F33B4F96E2A745CE6A146_340952292;
        case DISPATCH_DRAG_LOCATION_EVENT:
String varA13901A0FABB7214F841A0D86ADDA66F_65987116 =         "DISPATCH_DRAG_LOCATION_EVENT";
        varA13901A0FABB7214F841A0D86ADDA66F_65987116.addTaint(taint);
        return varA13901A0FABB7214F841A0D86ADDA66F_65987116;
        case DISPATCH_SYSTEM_UI_VISIBILITY:
String var765ACE35D4E1554CEBEF92015620111D_114780296 =         "DISPATCH_SYSTEM_UI_VISIBILITY";
        var765ACE35D4E1554CEBEF92015620111D_114780296.addTaint(taint);
        return var765ACE35D4E1554CEBEF92015620111D_114780296;
        case DISPATCH_GENERIC_MOTION:
String varD9264C82D993CA306F17FFEA61AB4FB7_1615515730 =         "DISPATCH_GENERIC_MOTION";
        varD9264C82D993CA306F17FFEA61AB4FB7_1615515730.addTaint(taint);
        return varD9264C82D993CA306F17FFEA61AB4FB7_1615515730;
        case UPDATE_CONFIGURATION:
String var1DC761183928A39776C5ADBD379A8580_1136361895 =         "UPDATE_CONFIGURATION";
        var1DC761183928A39776C5ADBD379A8580_1136361895.addTaint(taint);
        return var1DC761183928A39776C5ADBD379A8580_1136361895;
        case DO_PERFORM_ACCESSIBILITY_ACTION:
String var6C5DC7D569F36C0F4093A70C2A9E7688_1118445019 =         "DO_PERFORM_ACCESSIBILITY_ACTION";
        var6C5DC7D569F36C0F4093A70C2A9E7688_1118445019.addTaint(taint);
        return var6C5DC7D569F36C0F4093A70C2A9E7688_1118445019;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID:
String var963F7C104B117E092F428220B83C3061_153320097 =         "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID";
        var963F7C104B117E092F428220B83C3061_153320097.addTaint(taint);
        return var963F7C104B117E092F428220B83C3061_153320097;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID:
String varE80284C4CC54C4E38D8D5FFDF90EDA97_141196568 =         "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID";
        varE80284C4CC54C4E38D8D5FFDF90EDA97_141196568.addTaint(taint);
        return varE80284C4CC54C4E38D8D5FFDF90EDA97_141196568;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT:
String var2C289731832777E25521B29BCAA78671_1879348487 =         "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT";
        var2C289731832777E25521B29BCAA78671_1879348487.addTaint(taint);
        return var2C289731832777E25521B29BCAA78671_1879348487;
        case PROCESS_INPUT_EVENTS:
String varEAAFDC5A38F2A528C77C90424EDC1794_811821829 =         "PROCESS_INPUT_EVENTS";
        varEAAFDC5A38F2A528C77C90424EDC1794_811821829.addTaint(taint);
        return varEAAFDC5A38F2A528C77C90424EDC1794_811821829;
}String var1EF09E984C26996A9E64B724864BFE50_165876789 =         super.getMessageName(message);
        var1EF09E984C26996A9E64B724864BFE50_165876789.addTaint(taint);
        return var1EF09E984C26996A9E64B724864BFE50_165876789;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.716 -0400", hash_original_method = "0C83FFF474CF8ADB1C57E65037847991", hash_generated_method = "D6D2BC77A22B4347859EE5332E6FDE8F")
    @Override
    public void handleMessage(Message msg) {
switch(msg.what){
        case View.AttachInfo.INVALIDATE_MSG:
        ((View) msg.obj).invalidate();
        break;
        case View.AttachInfo.INVALIDATE_RECT_MSG:
        final View.AttachInfo.InvalidateInfo info = (View.AttachInfo.InvalidateInfo) msg.obj;
        info.target.invalidate(info.left, info.top, info.right, info.bottom);
        info.release();
        break;
        case DO_TRAVERSAL:
        if(mProfile)        
        {
            Debug.startMethodTracing("ViewAncestor");
        } //End block
        long traversalStartTime;
        if(ViewDebug.DEBUG_LATENCY)        
        {
            traversalStartTime = System.nanoTime();
            mLastDrawDurationNanos = 0;
        } //End block
        performTraversals();
        if(ViewDebug.DEBUG_LATENCY)        
        {
            long now = System.nanoTime();
            Log.d(TAG, "Latency: Spent "
                        + ((now - traversalStartTime) * 0.000001f)
                        + "ms in performTraversals(), with "
                        + (mLastDrawDurationNanos * 0.000001f)
                        + "ms of that time in draw()");
            mLastTraversalFinishedTimeNanos = now;
        } //End block
        if(mProfile)        
        {
            Debug.stopMethodTracing();
            mProfile = false;
        } //End block
        break;
        case FINISHED_EVENT:
        handleFinishedEvent(msg.arg1, msg.arg2 != 0);
        break;
        case DISPATCH_KEY:
        deliverKeyEvent((KeyEvent)msg.obj, msg.arg1 != 0);
        break;
        case DISPATCH_POINTER:
        deliverPointerEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        break;
        case DISPATCH_TRACKBALL:
        deliverTrackballEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        break;
        case DISPATCH_GENERIC_MOTION:
        deliverGenericMotionEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        break;
        case PROCESS_INPUT_EVENTS:
        processInputEvents(false);
        break;
        case DISPATCH_APP_VISIBILITY:
        handleAppVisibility(msg.arg1 != 0);
        break;
        case DISPATCH_GET_NEW_SURFACE:
        handleGetNewSurface();
        break;
        case RESIZED:
        ResizedInfo ri = (ResizedInfo)msg.obj;
        if(mWinFrame.width() == msg.arg1 && mWinFrame.height() == msg.arg2
                    && mPendingContentInsets.equals(ri.coveredInsets)
                    && mPendingVisibleInsets.equals(ri.visibleInsets)
                    && ((ResizedInfo)msg.obj).newConfig == null)        
        {
            break;
        } //End block
        case RESIZED_REPORT:
        if(mAdded)        
        {
            Configuration config = ((ResizedInfo)msg.obj).newConfig;
            if(config != null)            
            {
                updateConfiguration(config, false);
            } //End block
            mWinFrame.left = 0;
            mWinFrame.right = msg.arg1;
            mWinFrame.top = 0;
            mWinFrame.bottom = msg.arg2;
            mPendingContentInsets.set(((ResizedInfo)msg.obj).coveredInsets);
            mPendingVisibleInsets.set(((ResizedInfo)msg.obj).visibleInsets);
            if(msg.what == RESIZED_REPORT)            
            {
                mReportNextDraw = true;
            } //End block
            if(mView != null)            
            {
                forceLayout(mView);
            } //End block
            requestLayout();
        } //End block
        break;
        case WINDOW_FOCUS_CHANGED:
        {
            if(mAdded)            
            {
                boolean hasWindowFocus = msg.arg1 != 0;
                mAttachInfo.mHasWindowFocus = hasWindowFocus;
                profileRendering(hasWindowFocus);
                if(hasWindowFocus)                
                {
                    boolean inTouchMode = msg.arg2 != 0;
                    ensureTouchModeLocally(inTouchMode);
                    if(mAttachInfo.mHardwareRenderer != null &&
                            mSurface != null && mSurface.isValid())                    
                    {
                        mFullRedrawNeeded = true;
                        try 
                        {
                            mAttachInfo.mHardwareRenderer.initializeIfNeeded(mWidth, mHeight,
                                    mAttachInfo, mHolder);
                        } //End block
                        catch (Surface.OutOfResourcesException e)
                        {
                            try 
                            {
                                if(!sWindowSession.outOfMemory(mWindow))                                
                                {
                                    Process.killProcess(Process.myPid());
                                } //End block
                            } //End block
                            catch (RemoteException ex)
                            {
                            } //End block
                            sendMessageDelayed(obtainMessage(msg.what, msg.arg1, msg.arg2), 500);
                            return;
                        } //End block
                    } //End block
                } //End block
                mLastWasImTarget = WindowManager.LayoutParams
                        .mayUseInputMethod(mWindowAttributes.flags);
                InputMethodManager imm = InputMethodManager.peekInstance();
                if(mView != null)                
                {
                    if(hasWindowFocus && imm != null && mLastWasImTarget)                    
                    {
                        imm.startGettingWindowFocus(mView);
                    } //End block
                    mAttachInfo.mKeyDispatchState.reset();
                    mView.dispatchWindowFocusChanged(hasWindowFocus);
                } //End block
                if(hasWindowFocus)                
                {
                    if(imm != null && mLastWasImTarget)                    
                    {
                        imm.onWindowFocus(mView, mView.findFocus(),
                                mWindowAttributes.softInputMode,
                                !mHasHadWindowFocus, mWindowAttributes.flags);
                    } //End block
                    mWindowAttributes.softInputMode &=
                            ~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
                    ((WindowManager.LayoutParams)mView.getLayoutParams())
                            .softInputMode &=
                                ~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
                    mHasHadWindowFocus = true;
                } //End block
                if(hasWindowFocus && mView != null)                
                {
                    sendAccessibilityEvents();
                } //End block
            } //End block
        } //End block
        break;
        case DIE:
        doDie();
        break;
        case DISPATCH_KEY_FROM_IME:
        {
            if(LOCAL_LOGV){ }            KeyEvent event = (KeyEvent)msg.obj;
            if((event.getFlags()&KeyEvent.FLAG_FROM_SYSTEM) != 0)            
            {
                event = KeyEvent.changeFlags(event, event.getFlags() & ~KeyEvent.FLAG_FROM_SYSTEM);
            } //End block
            deliverKeyEventPostIme((KeyEvent)msg.obj, false);
        } //End block
        break;
        case FINISH_INPUT_CONNECTION:
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            {
                imm.reportFinishInputConnection((InputConnection)msg.obj);
            } //End block
        } //End block
        break;
        case CHECK_FOCUS:
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            {
                imm.checkFocus();
            } //End block
        } //End block
        break;
        case CLOSE_SYSTEM_DIALOGS:
        {
            if(mView != null)            
            {
                mView.onCloseSystemDialogs((String)msg.obj);
            } //End block
        } //End block
        break;
        case DISPATCH_DRAG_EVENT:
        case DISPATCH_DRAG_LOCATION_EVENT:
        {
            DragEvent event = (DragEvent)msg.obj;
            event.mLocalState = mLocalDragState;
            handleDragEvent(event);
        } //End block
        break;
        case DISPATCH_SYSTEM_UI_VISIBILITY:
        {
            handleDispatchSystemUiVisibilityChanged((SystemUiVisibilityInfo)msg.obj);
        } //End block
        break;
        case UPDATE_CONFIGURATION:
        {
            Configuration config = (Configuration)msg.obj;
            if(config.isOtherSeqNewer(mLastConfiguration))            
            {
                config = mLastConfiguration;
            } //End block
            updateConfiguration(config, false);
        } //End block
        break;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID:
        {
            if(mView != null)            
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdUiThread(msg);
            } //End block
        } //End block
        break;
        case DO_PERFORM_ACCESSIBILITY_ACTION:
        {
            if(mView != null)            
            {
                getAccessibilityInteractionController()
                    .perfromAccessibilityActionUiThread(msg);
            } //End block
        } //End block
        break;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID:
        {
            if(mView != null)            
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdUiThread(msg);
            } //End block
        } //End block
        break;
        case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT:
        {
            if(mView != null)            
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextUiThread(msg);
            } //End block
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.717 -0400", hash_original_method = "0B0FC84CA02F82927D98059C965571E0", hash_generated_method = "B69B882F2F1744E78F85E4BCA35E3A12")
    private void startInputEvent(InputQueue.FinishedCallback finishedCallback) {
        if(mFinishedCallback != null)        
        {
        } //End block
        if(ViewDebug.DEBUG_LATENCY)        
        {
            mInputEventReceiveTimeNanos = System.nanoTime();
            mInputEventDeliverTimeNanos = 0;
            mInputEventDeliverPostImeTimeNanos = 0;
        } //End block
        mFinishedCallback = finishedCallback;
        // ---------- Original Method ----------
        //if (mFinishedCallback != null) {
            //Slog.w(TAG, "Received a new input event from the input queue but there is "
                    //+ "already an unfinished input event in progress.");
        //}
        //if (ViewDebug.DEBUG_LATENCY) {
            //mInputEventReceiveTimeNanos = System.nanoTime();
            //mInputEventDeliverTimeNanos = 0;
            //mInputEventDeliverPostImeTimeNanos = 0;
        //}
        //mFinishedCallback = finishedCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.717 -0400", hash_original_method = "06AEBC75FF0DC9B70A4E2BB2CC6850C1", hash_generated_method = "227B620B78820D6DF4F84A74EB4B6C4A")
    private void finishInputEvent(InputEvent event, boolean handled) {
        addTaint(handled);
        addTaint(event.getTaint());
        if(LOCAL_LOGV){ }        if(mFinishedCallback == null)        
        {
            return;
        } //End block
        if(ViewDebug.DEBUG_LATENCY)        
        {
            final long now = System.nanoTime();
            final long eventTime = event.getEventTimeNano();
            final StringBuilder msg = new StringBuilder();
            msg.append("Latency: Spent ");
            msg.append((now - mInputEventReceiveTimeNanos) * 0.000001f);
            msg.append("ms processing ");
            if(event instanceof KeyEvent)            
            {
                final KeyEvent keyEvent = (KeyEvent)event;
                msg.append("key event, action=");
                msg.append(KeyEvent.actionToString(keyEvent.getAction()));
            } //End block
            else
            {
                final MotionEvent motionEvent = (MotionEvent)event;
                msg.append("motion event, action=");
                msg.append(MotionEvent.actionToString(motionEvent.getAction()));
                msg.append(", historySize=");
                msg.append(motionEvent.getHistorySize());
            } //End block
            msg.append(", handled=");
            msg.append(handled);
            msg.append(", received at +");
            msg.append((mInputEventReceiveTimeNanos - eventTime) * 0.000001f);
            if(mInputEventDeliverTimeNanos != 0)            
            {
                msg.append("ms, delivered at +");
                msg.append((mInputEventDeliverTimeNanos - eventTime) * 0.000001f);
            } //End block
            if(mInputEventDeliverPostImeTimeNanos != 0)            
            {
                msg.append("ms, delivered post IME at +");
                msg.append((mInputEventDeliverPostImeTimeNanos - eventTime) * 0.000001f);
            } //End block
            msg.append("ms, finished at +");
            msg.append((now - eventTime) * 0.000001f);
            msg.append("ms.");
            Log.d(TAG, msg.toString());
        } //End block
        mFinishedCallback.finished(handled);
        mFinishedCallback = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.719 -0400", hash_original_method = "A6640F15C2D0A406B73F798DB9EA077C", hash_generated_method = "1264E76AC74BAB6113FD61FD4F4053B6")
     boolean ensureTouchMode(boolean inTouchMode) {
        addTaint(inTouchMode);
        if(DBG)        
        Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        if(mAttachInfo.mInTouchMode == inTouchMode)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1478844707 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272125300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272125300;
        }
        try 
        {
            sWindowSession.setInTouchMode(inTouchMode);
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_455683189 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_455683189.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_455683189;
        } //End block
        boolean var692F86F152C1BB12AD00082FEF0077B6_444936728 = (ensureTouchModeLocally(inTouchMode));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577992372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577992372;
        // ---------- Original Method ----------
        //if (DBG) Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current "
                //+ "touch mode is " + mAttachInfo.mInTouchMode);
        //if (mAttachInfo.mInTouchMode == inTouchMode) return false;
        //try {
            //sWindowSession.setInTouchMode(inTouchMode);
        //} catch (RemoteException e) {
            //throw new RuntimeException(e);
        //}
        //return ensureTouchModeLocally(inTouchMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.719 -0400", hash_original_method = "A817FB22551D2F047707EAAC44367E27", hash_generated_method = "806EFD34E01226D9F2F82B637B29DBF0")
    private boolean ensureTouchModeLocally(boolean inTouchMode) {
        if(DBG)        
        Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        if(mAttachInfo.mInTouchMode == inTouchMode)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1779405558 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088525151 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088525151;
        }
        mAttachInfo.mInTouchMode = inTouchMode;
        mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        boolean var3E54BAA8A577DB05DFA85553795907C5_1377149497 = ((inTouchMode) ? enterTouchMode() : leaveTouchMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452898341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452898341;
        // ---------- Original Method ----------
        //if (DBG) Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                //+ "touch mode is " + mAttachInfo.mInTouchMode);
        //if (mAttachInfo.mInTouchMode == inTouchMode) return false;
        //mAttachInfo.mInTouchMode = inTouchMode;
        //mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        //return (inTouchMode) ? enterTouchMode() : leaveTouchMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.720 -0400", hash_original_method = "4D22F5F97C319901FE80DD8DAA6DBF2B", hash_generated_method = "27A64EA551A518789AEE449B0CEB765C")
    private boolean enterTouchMode() {
        if(mView != null)        
        {
            if(mView.hasFocus())            
            {
                final View focused = mView.findFocus();
                if(focused != null && !focused.isFocusableInTouchMode())                
                {
                    final ViewGroup ancestorToTakeFocus = findAncestorToTakeFocusInTouchMode(focused);
                    if(ancestorToTakeFocus != null)                    
                    {
                        boolean var0774C92D79374772E4B5929C9059B10C_928101804 = (ancestorToTakeFocus.requestFocus());
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_947729056 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_947729056;
                    } //End block
                    else
                    {
                        mView.unFocus();
                        mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(focused, null);
                        mFocusedView = null;
                        boolean varB326B5062B2F0E69046810717534CB09_1317868770 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62252063 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62252063;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1120144723 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145078810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145078810;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.720 -0400", hash_original_method = "A2FE4CBD06D42BF7C573F07F56417767", hash_generated_method = "60F155B20713CA766123F7393098DC6E")
    private ViewGroup findAncestorToTakeFocusInTouchMode(View focused) {
        addTaint(focused.getTaint());
        ViewParent parent = focused.getParent();
        while
(parent instanceof ViewGroup)        
        {
            final ViewGroup vgParent = (ViewGroup) parent;
            if(vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    && vgParent.isFocusableInTouchMode())            
            {
ViewGroup varFBFA1772B797F5D46A0D81B60844AE87_356154941 =                 vgParent;
                varFBFA1772B797F5D46A0D81B60844AE87_356154941.addTaint(taint);
                return varFBFA1772B797F5D46A0D81B60844AE87_356154941;
            } //End block
            if(vgParent.isRootNamespace())            
            {
ViewGroup var540C13E9E156B687226421B24F2DF178_1601722899 =                 null;
                var540C13E9E156B687226421B24F2DF178_1601722899.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1601722899;
            } //End block
            else
            {
                parent = vgParent.getParent();
            } //End block
        } //End block
ViewGroup var540C13E9E156B687226421B24F2DF178_2137381528 =         null;
        var540C13E9E156B687226421B24F2DF178_2137381528.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2137381528;
        // ---------- Original Method ----------
        //ViewParent parent = focused.getParent();
        //while (parent instanceof ViewGroup) {
            //final ViewGroup vgParent = (ViewGroup) parent;
            //if (vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    //&& vgParent.isFocusableInTouchMode()) {
                //return vgParent;
            //}
            //if (vgParent.isRootNamespace()) {
                //return null;
            //} else {
                //parent = vgParent.getParent();
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.722 -0400", hash_original_method = "6D4A7A06FF255705F6FF85A0D8D1E147", hash_generated_method = "E60B26EB4988B8DDE3BBDF1F804EC31F")
    private boolean leaveTouchMode() {
        if(mView != null)        
        {
            if(mView.hasFocus())            
            {
                mFocusedView = mView.findFocus();
                if(!(mFocusedView instanceof ViewGroup))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_370742831 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866290713 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_866290713;
                } //End block
                else
                if(((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        ViewGroup.FOCUS_AFTER_DESCENDANTS)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_11980113 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488641932 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488641932;
                } //End block
            } //End block
            final View focused = focusSearch(null, View.FOCUS_DOWN);
            if(focused != null)            
            {
                boolean var44B53D67AEDFAC9AEC4E3B30D3006E9C_1876911134 = (focused.requestFocus(View.FOCUS_DOWN));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884618222 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_884618222;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_234902613 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347854210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347854210;
        // ---------- Original Method ----------
        //if (mView != null) {
            //if (mView.hasFocus()) {
                //mFocusedView = mView.findFocus();
                //if (!(mFocusedView instanceof ViewGroup)) {
                    //return false;
                //} else if (((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        //ViewGroup.FOCUS_AFTER_DESCENDANTS) {
                    //return false;
                //}
            //}
            //final View focused = focusSearch(null, View.FOCUS_DOWN);
            //if (focused != null) {
                //return focused.requestFocus(View.FOCUS_DOWN);
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.723 -0400", hash_original_method = "8F847D145475DB0C2BA683E62F600908", hash_generated_method = "51DD6CAE1BD98AB9B7BFCFAD4D8F619C")
    private void deliverPointerEvent(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        if(ViewDebug.DEBUG_LATENCY)        
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        final boolean isTouchEvent = event.isTouchEvent();
        if(mInputEventConsistencyVerifier != null)        
        {
            if(isTouchEvent)            
            {
                mInputEventConsistencyVerifier.onTouchEvent(event, 0);
            } //End block
            else
            {
                mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
            } //End block
        } //End block
        if(mView == null || !mAdded)        
        {
            finishMotionEvent(event, sendDone, false);
            return;
        } //End block
        if(mTranslator != null)        
        {
            mTranslator.translateEventInScreenToAppWindow(event);
        } //End block
        final int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_SCROLL)        
        {
            ensureTouchMode(true);
        } //End block
        if(mCurScrollY != 0)        
        {
            event.offsetLocation(0, mCurScrollY);
        } //End block
        if(MEASURE_LATENCY)        
        {
            lt.sample("A Dispatching PointerEvents", System.nanoTime() - event.getEventTimeNano());
        } //End block
        if(isTouchEvent)        
        {
            mLastTouchPoint.x = event.getRawX();
            mLastTouchPoint.y = event.getRawY();
        } //End block
        boolean handled = mView.dispatchPointerEvent(event);
        if(MEASURE_LATENCY)        
        {
            lt.sample("B Dispatched PointerEvents ", System.nanoTime() - event.getEventTimeNano());
        } //End block
        if(handled)        
        {
            finishMotionEvent(event, sendDone, true);
            return;
        } //End block
        finishMotionEvent(event, sendDone, false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.724 -0400", hash_original_method = "DF90914307EFCD2CA23CDB09D8C7F95D", hash_generated_method = "E97DC75B54E53716E029F229E374BAFF")
    private void finishMotionEvent(MotionEvent event, boolean sendDone, boolean handled) {
        addTaint(handled);
        addTaint(sendDone);
        addTaint(event.getTaint());
        event.recycle();
        if(sendDone)        
        {
            finishInputEvent(event, handled);
        } //End block
        if(LOCAL_LOGV || WATCH_POINTER)        
        {
            if((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0)            
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //event.recycle();
        //if (sendDone) {
            //finishInputEvent(event, handled);
        //}
        //if (LOCAL_LOGV || WATCH_POINTER) {
            //if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
                //Log.i(TAG, "Done dispatching!");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.726 -0400", hash_original_method = "B306A4DB67A1B71DDAAA3D4C50CD59B0", hash_generated_method = "D2D2F4BE42EE6A4792EFE071952B0359")
    private void deliverTrackballEvent(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        if(ViewDebug.DEBUG_LATENCY)        
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        if(DEBUG_TRACKBALL){ }        if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } //End block
        if(mView == null || !mAdded)        
        {
            finishMotionEvent(event, sendDone, false);
            return;
        } //End block
        if(mView.dispatchTrackballEvent(event))        
        {
            ensureTouchMode(false);
            finishMotionEvent(event, sendDone, true);
            mLastTrackballTime = Integer.MIN_VALUE;
            return;
        } //End block
        final TrackballAxis x = mTrackballAxisX;
        final TrackballAxis y = mTrackballAxisY;
        long curTime = SystemClock.uptimeMillis();
        if((mLastTrackballTime + MAX_TRACKBALL_DELAY) < curTime)        
        {
            x.reset(0);
            y.reset(0);
            mLastTrackballTime = curTime;
        } //End block
        final int action = event.getAction();
        final int metaState = event.getMetaState();
switch(action){
        case MotionEvent.ACTION_DOWN:
        x.reset(2);
        y.reset(2);
        deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
        break;
        case MotionEvent.ACTION_UP:
        x.reset(2);
        y.reset(2);
        deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
        break;
}        if(DEBUG_TRACKBALL){ }        final float xOff = x.collect(event.getX(), event.getEventTime(), "X");
        final float yOff = y.collect(event.getY(), event.getEventTime(), "Y");
        int keycode = 0;
        int movement = 0;
        float accel = 1;
        if(xOff > yOff)        
        {
            movement = x.generate((2/event.getXPrecision()));
            if(movement != 0)            
            {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_RIGHT
                        : KeyEvent.KEYCODE_DPAD_LEFT;
                accel = x.acceleration;
                y.reset(2);
            } //End block
        } //End block
        else
        if(yOff > 0)        
        {
            movement = y.generate((2/event.getYPrecision()));
            if(movement != 0)            
            {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_DOWN
                        : KeyEvent.KEYCODE_DPAD_UP;
                accel = y.acceleration;
                x.reset(2);
            } //End block
        } //End block
        if(keycode != 0)        
        {
            if(movement < 0)            
            movement = -movement;
            int accelMovement = (int)(movement * accel);
            if(DEBUG_TRACKBALL){ }            if(accelMovement > movement)            
            {
                if(DEBUG_TRACKBALL){ }                movement--;
                int repeatCount = accelMovement - movement;
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_MULTIPLE, keycode, repeatCount, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            } //End block
            while
(movement > 0)            
            {
                if(DEBUG_TRACKBALL){ }                movement--;
                curTime = SystemClock.uptimeMillis();
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, keycode, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, keycode, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            } //End block
            mLastTrackballTime = curTime;
        } //End block
        finishMotionEvent(event, sendDone, true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.728 -0400", hash_original_method = "D79206E9EE4BD2FB4F0103FA8C72904A", hash_generated_method = "4445E06BACE4B28C07C5DBB24CEA2DD1")
    private void deliverGenericMotionEvent(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        if(ViewDebug.DEBUG_LATENCY)        
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } //End block
        final int source = event.getSource();
        final boolean isJoystick = (source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0;
        if(mView == null || !mAdded)        
        {
            if(isJoystick)            
            {
                updateJoystickDirection(event, false);
            } //End block
            finishMotionEvent(event, sendDone, false);
            return;
        } //End block
        if(mView.dispatchGenericMotionEvent(event))        
        {
            if(isJoystick)            
            {
                updateJoystickDirection(event, false);
            } //End block
            finishMotionEvent(event, sendDone, true);
            return;
        } //End block
        if(isJoystick)        
        {
            updateJoystickDirection(event, true);
            finishMotionEvent(event, sendDone, true);
        } //End block
        else
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.730 -0400", hash_original_method = "3F24F6EAAF68F5E1EBCC50D38D5B0024", hash_generated_method = "C0E65DDAF20FE49D3B3A2E1F290A6318")
    private void updateJoystickDirection(MotionEvent event, boolean synthesizeNewKeys) {
        addTaint(synthesizeNewKeys);
        addTaint(event.getTaint());
        final long time = event.getEventTime();
        final int metaState = event.getMetaState();
        final int deviceId = event.getDeviceId();
        final int source = event.getSource();
        int xDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_X));
        if(xDirection == 0)        
        {
            xDirection = joystickAxisValueToDirection(event.getX());
        } //End block
        int yDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_Y));
        if(yDirection == 0)        
        {
            yDirection = joystickAxisValueToDirection(event.getY());
        } //End block
        if(xDirection != mLastJoystickXDirection)        
        {
            if(mLastJoystickXKeyCode != 0)            
            {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickXKeyCode = 0;
            } //End block
            mLastJoystickXDirection = xDirection;
            if(xDirection != 0 && synthesizeNewKeys)            
            {
                mLastJoystickXKeyCode = xDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_RIGHT : KeyEvent.KEYCODE_DPAD_LEFT;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            } //End block
        } //End block
        if(yDirection != mLastJoystickYDirection)        
        {
            if(mLastJoystickYKeyCode != 0)            
            {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickYKeyCode = 0;
            } //End block
            mLastJoystickYDirection = yDirection;
            if(yDirection != 0 && synthesizeNewKeys)            
            {
                mLastJoystickYKeyCode = yDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_DOWN : KeyEvent.KEYCODE_DPAD_UP;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    private static int joystickAxisValueToDirection(float value) {
        if (value >= 0.5f) {
            return 1;
        } else if (value <= -0.5f) {
            return -1;
        } else {
            return 0;
        }
    }

    
    private static boolean isNavigationKey(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
        case KeyEvent.KEYCODE_DPAD_RIGHT:
        case KeyEvent.KEYCODE_DPAD_UP:
        case KeyEvent.KEYCODE_DPAD_DOWN:
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_PAGE_UP:
        case KeyEvent.KEYCODE_PAGE_DOWN:
        case KeyEvent.KEYCODE_MOVE_HOME:
        case KeyEvent.KEYCODE_MOVE_END:
        case KeyEvent.KEYCODE_TAB:
        case KeyEvent.KEYCODE_SPACE:
        case KeyEvent.KEYCODE_ENTER:
            return true;
        }
        return false;
    }

    
    private static boolean isTypingKey(KeyEvent keyEvent) {
        return keyEvent.getUnicodeChar() > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.731 -0400", hash_original_method = "4A4EC0979E3C48040C37CBDD240E0778", hash_generated_method = "7B2A9253FC7CC99FE59491BE733FBB90")
    private boolean checkForLeavingTouchModeAndConsume(KeyEvent event) {
        addTaint(event.getTaint());
        if(!mAttachInfo.mInTouchMode)        
        {
            boolean var68934A3E9455FA72420237EB05902327_753470494 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764597022 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764597022;
        } //End block
        final int action = event.getAction();
        if(action != KeyEvent.ACTION_DOWN && action != KeyEvent.ACTION_MULTIPLE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_903198012 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801960232 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801960232;
        } //End block
        if((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1479184238 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689578365 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689578365;
        } //End block
        if(isNavigationKey(event))        
        {
            boolean varB2FDA8E224E054879B524CA3016FAB75_668485898 = (ensureTouchMode(false));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1214161528 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1214161528;
        } //End block
        if(isTypingKey(event))        
        {
            ensureTouchMode(false);
            boolean var68934A3E9455FA72420237EB05902327_1291475883 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225661421 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_225661421;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_611448698 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2110429639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2110429639;
        // ---------- Original Method ----------
        //if (!mAttachInfo.mInTouchMode) {
            //return false;
        //}
        //final int action = event.getAction();
        //if (action != KeyEvent.ACTION_DOWN && action != KeyEvent.ACTION_MULTIPLE) {
            //return false;
        //}
        //if ((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0) {
            //return false;
        //}
        //if (isNavigationKey(event)) {
            //return ensureTouchMode(false);
        //}
        //if (isTypingKey(event)) {
            //ensureTouchMode(false);
            //return false;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.731 -0400", hash_original_method = "DD7540FF4FE8EF5C7F3D3C1B535F6D84", hash_generated_method = "41543EEDD5E92A1C9BFAA6450E8CE134")
     int enqueuePendingEvent(Object event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        int seq = mPendingEventSeq+1;
        if(seq < 0)        
        seq = 0;
        mPendingEventSeq = seq;
        mPendingEvents.put(seq, event);
        int var4A57C27C5ABAE20AEB59D3FA44331F63_861066399 = (sendDone ? seq : -seq);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_675280416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_675280416;
        // ---------- Original Method ----------
        //int seq = mPendingEventSeq+1;
        //if (seq < 0) seq = 0;
        //mPendingEventSeq = seq;
        //mPendingEvents.put(seq, event);
        //return sendDone ? seq : -seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.732 -0400", hash_original_method = "D1881A2DE4A478B1C2476E8789D90C4F", hash_generated_method = "596AF5E870386D8C113D6F37E0CD2355")
     Object retrievePendingEvent(int seq) {
        addTaint(seq);
        if(seq < 0)        
        seq = -seq;
        Object event = mPendingEvents.get(seq);
        if(event != null)        
        {
            mPendingEvents.remove(seq);
        } //End block
Object var3162E7A4A1E5D72F1058A9B39A6A8738_942388120 =         event;
        var3162E7A4A1E5D72F1058A9B39A6A8738_942388120.addTaint(taint);
        return var3162E7A4A1E5D72F1058A9B39A6A8738_942388120;
        // ---------- Original Method ----------
        //if (seq < 0) seq = -seq;
        //Object event = mPendingEvents.get(seq);
        //if (event != null) {
            //mPendingEvents.remove(seq);
        //}
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.732 -0400", hash_original_method = "7BC82D96B9DB6F7A084DA2256A5743DA", hash_generated_method = "F19C78CAAF33F57B8E1B221463F28BA1")
    private void deliverKeyEvent(KeyEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        if(ViewDebug.DEBUG_LATENCY)        
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } //End block
        if(mView == null || !mAdded)        
        {
            finishKeyEvent(event, sendDone, false);
            return;
        } //End block
        if(LOCAL_LOGV){ }        if(mView.dispatchKeyEventPreIme(event))        
        {
            finishKeyEvent(event, sendDone, true);
            return;
        } //End block
        if(mLastWasImTarget)        
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            if(imm != null)            
            {
                int seq = enqueuePendingEvent(event, sendDone);
                if(DEBUG_IMF){ }                imm.dispatchKeyEvent(mView.getContext(), seq, event, mInputMethodCallback);
                return;
            } //End block
        } //End block
        deliverKeyEventPostIme(event, sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.732 -0400", hash_original_method = "1D388C4C66D020B7A8C536C50B24E128", hash_generated_method = "2CFD9BB70A1C76644C8B56EB0622637F")
    private void handleFinishedEvent(int seq, boolean handled) {
        addTaint(handled);
        addTaint(seq);
        final KeyEvent event = (KeyEvent)retrievePendingEvent(seq);
        if(DEBUG_IMF){ }        if(event != null)        
        {
            final boolean sendDone = seq >= 0;
            if(handled)            
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
            else
            {
                deliverKeyEventPostIme(event, sendDone);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final KeyEvent event = (KeyEvent)retrievePendingEvent(seq);
        //if (DEBUG_IMF) Log.v(TAG, "IME finished event: seq=" + seq
                //+ " handled=" + handled + " event=" + event);
        //if (event != null) {
            //final boolean sendDone = seq >= 0;
            //if (handled) {
                //finishKeyEvent(event, sendDone, true);
            //} else {
                //deliverKeyEventPostIme(event, sendDone);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.733 -0400", hash_original_method = "3773604D66AC7B7214885F4E3DA58090", hash_generated_method = "729E7E69E03EF3F3DA508A071687E78B")
    private void deliverKeyEventPostIme(KeyEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        if(ViewDebug.DEBUG_LATENCY)        
        {
            mInputEventDeliverPostImeTimeNanos = System.nanoTime();
        } //End block
        if(mView == null || !mAdded)        
        {
            finishKeyEvent(event, sendDone, false);
            return;
        } //End block
        if(checkForLeavingTouchModeAndConsume(event))        
        {
            finishKeyEvent(event, sendDone, true);
            return;
        } //End block
        mFallbackEventHandler.preDispatchKeyEvent(event);
        if(mView.dispatchKeyEvent(event))        
        {
            finishKeyEvent(event, sendDone, true);
            return;
        } //End block
        if(event.getAction() == KeyEvent.ACTION_DOWN
                && event.isCtrlPressed()
                && event.getRepeatCount() == 0
                && !KeyEvent.isModifierKey(event.getKeyCode()))        
        {
            if(mView.dispatchKeyShortcutEvent(event))            
            {
                finishKeyEvent(event, sendDone, true);
                return;
            } //End block
        } //End block
        if(mFallbackEventHandler.dispatchKeyEvent(event))        
        {
            finishKeyEvent(event, sendDone, true);
            return;
        } //End block
        if(event.getAction() == KeyEvent.ACTION_DOWN)        
        {
            int direction = 0;
switch(event.getKeyCode()){
            case KeyEvent.KEYCODE_DPAD_LEFT:
            if(event.hasNoModifiers())            
            {
                direction = View.FOCUS_LEFT;
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            if(event.hasNoModifiers())            
            {
                direction = View.FOCUS_RIGHT;
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_UP:
            if(event.hasNoModifiers())            
            {
                direction = View.FOCUS_UP;
            } //End block
            break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
            if(event.hasNoModifiers())            
            {
                direction = View.FOCUS_DOWN;
            } //End block
            break;
            case KeyEvent.KEYCODE_TAB:
            if(event.hasNoModifiers())            
            {
                direction = View.FOCUS_FORWARD;
            } //End block
            else
            if(event.hasModifiers(KeyEvent.META_SHIFT_ON))            
            {
                direction = View.FOCUS_BACKWARD;
            } //End block
            break;
}            if(direction != 0)            
            {
                View focused = mView != null ? mView.findFocus() : null;
                if(focused != null)                
                {
                    View v = focused.focusSearch(direction);
                    if(v != null && v != focused)                    
                    {
                        focused.getFocusedRect(mTempRect);
                        if(mView instanceof ViewGroup)                        
                        {
                            ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focused, mTempRect);
                            ((ViewGroup) mView).offsetRectIntoDescendantCoords(
                                    v, mTempRect);
                        } //End block
                        if(v.requestFocus(direction, mTempRect))                        
                        {
                            playSoundEffect(
                                    SoundEffectConstants.getContantForFocusDirection(direction));
                            finishKeyEvent(event, sendDone, true);
                            return;
                        } //End block
                    } //End block
                    if(mView.dispatchUnhandledMove(focused, direction))                    
                    {
                        finishKeyEvent(event, sendDone, true);
                        return;
                    } //End block
                } //End block
            } //End block
        } //End block
        finishKeyEvent(event, sendDone, false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.734 -0400", hash_original_method = "2621255CFED260FE88FD0E0DE76ACADD", hash_generated_method = "0062FAD33EB31DF87E573A849A7C4611")
    private void finishKeyEvent(KeyEvent event, boolean sendDone, boolean handled) {
        addTaint(handled);
        addTaint(sendDone);
        addTaint(event.getTaint());
        if(sendDone)        
        {
            finishInputEvent(event, handled);
        } //End block
        // ---------- Original Method ----------
        //if (sendDone) {
            //finishInputEvent(event, handled);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.734 -0400", hash_original_method = "0FF9C383AA2E451EDBB7C2A5CA6E3F80", hash_generated_method = "12BE574BF3F1201CE287FC107D86E1D9")
     void setLocalDragState(Object obj) {
        mLocalDragState = obj;
        // ---------- Original Method ----------
        //mLocalDragState = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.736 -0400", hash_original_method = "977584242F0720CC5E20503FC56D761D", hash_generated_method = "ACA3120D3354BB29585252F43173DFE2")
    private void handleDragEvent(DragEvent event) {
        if(mView != null && mAdded)        
        {
            final int what = event.mAction;
            if(what == DragEvent.ACTION_DRAG_EXITED)            
            {
                mView.dispatchDragEvent(event);
            } //End block
            else
            {
                if(what == DragEvent.ACTION_DRAG_STARTED)                
                {
                    mCurrentDragView = null;
                    mDragDescription = event.mClipDescription;
                } //End block
                else
                {
                    event.mClipDescription = mDragDescription;
                } //End block
                if((what == DragEvent.ACTION_DRAG_LOCATION) || (what == DragEvent.ACTION_DROP))                
                {
                    mDragPoint.set(event.mX, event.mY);
                    if(mTranslator != null)                    
                    {
                        mTranslator.translatePointInScreenToAppWindow(mDragPoint);
                    } //End block
                    if(mCurScrollY != 0)                    
                    {
                        mDragPoint.offset(0, mCurScrollY);
                    } //End block
                    event.mX = mDragPoint.x;
                    event.mY = mDragPoint.y;
                } //End block
                final View prevDragView = mCurrentDragView;
                boolean result = mView.dispatchDragEvent(event);
                if(prevDragView != mCurrentDragView)                
                {
                    try 
                    {
                        if(prevDragView != null)                        
                        {
                            sWindowSession.dragRecipientExited(mWindow);
                        } //End block
                        if(mCurrentDragView != null)                        
                        {
                            sWindowSession.dragRecipientEntered(mWindow);
                        } //End block
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
                if(what == DragEvent.ACTION_DROP)                
                {
                    mDragDescription = null;
                    try 
                    {
                        sWindowSession.reportDropResult(mWindow, result);
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
                if(what == DragEvent.ACTION_DRAG_ENDED)                
                {
                    setLocalDragState(null);
                } //End block
            } //End block
        } //End block
        event.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.737 -0400", hash_original_method = "504EE99E4FC1047B3EE4816C6C3CF55E", hash_generated_method = "E5CF2091F2065628ED04AFFE334EC876")
    public void handleDispatchSystemUiVisibilityChanged(SystemUiVisibilityInfo args) {
        if(mSeq != args.seq)        
        {
            mSeq = args.seq;
            mAttachInfo.mForceReportNewAttributes = true;
            scheduleTraversals();
        } //End block
        if(mView == null)        
        return;
        if(args.localChanges != 0)        
        {
            if(mAttachInfo != null)            
            {
                mAttachInfo.mSystemUiVisibility =
                        (mAttachInfo.mSystemUiVisibility&~args.localChanges)
                        | (args.localValue&args.localChanges);
            } //End block
            mView.updateLocalSystemUiVisibility(args.localValue, args.localChanges);
            mAttachInfo.mRecomputeGlobalAttributes = true;
            scheduleTraversals();
        } //End block
        mView.dispatchSystemUiVisibilityChanged(args.globalVisibility);
        // ---------- Original Method ----------
        //if (mSeq != args.seq) {
            //mSeq = args.seq;
            //mAttachInfo.mForceReportNewAttributes = true;
            //scheduleTraversals();            
        //}
        //if (mView == null) return;
        //if (args.localChanges != 0) {
            //if (mAttachInfo != null) {
                //mAttachInfo.mSystemUiVisibility =
                        //(mAttachInfo.mSystemUiVisibility&~args.localChanges)
                        //| (args.localValue&args.localChanges);
            //}
            //mView.updateLocalSystemUiVisibility(args.localValue, args.localChanges);
            //mAttachInfo.mRecomputeGlobalAttributes = true;
            //scheduleTraversals();            
        //}
        //mView.dispatchSystemUiVisibilityChanged(args.globalVisibility);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.737 -0400", hash_original_method = "45F97324DFA9B47BC7B47DB7731173BB", hash_generated_method = "F7D135282A84C18BFAB0A383940A6AD0")
    public void getLastTouchPoint(Point outLocation) {
        addTaint(outLocation.getTaint());
        outLocation.x = (int) mLastTouchPoint.x;
        outLocation.y = (int) mLastTouchPoint.y;
        // ---------- Original Method ----------
        //outLocation.x = (int) mLastTouchPoint.x;
        //outLocation.y = (int) mLastTouchPoint.y;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.737 -0400", hash_original_method = "D8987F1AD41DCFCEC13505B3421C8BB0", hash_generated_method = "B392F31E1E7E2ED94E90253AA3169A62")
    public void setDragFocus(View newDragTarget) {
        if(mCurrentDragView != newDragTarget)        
        {
            mCurrentDragView = newDragTarget;
        } //End block
        // ---------- Original Method ----------
        //if (mCurrentDragView != newDragTarget) {
            //mCurrentDragView = newDragTarget;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.737 -0400", hash_original_method = "63BA605FA957D5097ED6886D9988BC53", hash_generated_method = "C40C72B698BB44D307B7D90537321D0B")
    private AudioManager getAudioManager() {
        if(mView == null)        
        {
            IllegalStateException var4AF1A1BD4019F01CC40A68C2B07DA69B_2119916668 = new IllegalStateException("getAudioManager called when there is no mView");
            var4AF1A1BD4019F01CC40A68C2B07DA69B_2119916668.addTaint(taint);
            throw var4AF1A1BD4019F01CC40A68C2B07DA69B_2119916668;
        } //End block
        if(mAudioManager == null)        
        {
            mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        } //End block
AudioManager var226F0E2B00577D32190D246C077B27CF_616604701 =         mAudioManager;
        var226F0E2B00577D32190D246C077B27CF_616604701.addTaint(taint);
        return var226F0E2B00577D32190D246C077B27CF_616604701;
        // ---------- Original Method ----------
        //if (mView == null) {
            //throw new IllegalStateException("getAudioManager called when there is no mView");
        //}
        //if (mAudioManager == null) {
            //mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        //}
        //return mAudioManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.738 -0400", hash_original_method = "C22EE439EF1C63381F42BE80F34ED0C5", hash_generated_method = "88DFB9277B6838E3691A7C556F40492C")
    public AccessibilityInteractionController getAccessibilityInteractionController() {
        if(mView == null)        
        {
            IllegalStateException var8CD49EA6E9981691C922697F1E3ED63A_1951291999 = new IllegalStateException("getAccessibilityInteractionController"
                    + " called when there is no mView");
            var8CD49EA6E9981691C922697F1E3ED63A_1951291999.addTaint(taint);
            throw var8CD49EA6E9981691C922697F1E3ED63A_1951291999;
        } //End block
        if(mAccessibilityInteractionController == null)        
        {
            mAccessibilityInteractionController = new AccessibilityInteractionController();
        } //End block
AccessibilityInteractionController var3AAD98268BEDCAFD4454ABEB3DE43C55_1279675155 =         mAccessibilityInteractionController;
        var3AAD98268BEDCAFD4454ABEB3DE43C55_1279675155.addTaint(taint);
        return var3AAD98268BEDCAFD4454ABEB3DE43C55_1279675155;
        // ---------- Original Method ----------
        //if (mView == null) {
            //throw new IllegalStateException("getAccessibilityInteractionController"
                    //+ " called when there is no mView");
        //}
        //if (mAccessibilityInteractionController == null) {
            //mAccessibilityInteractionController = new AccessibilityInteractionController();
        //}
        //return mAccessibilityInteractionController;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.739 -0400", hash_original_method = "0B2FE2E2B393762D66EC0169ABC2799A", hash_generated_method = "EF6D7F8DE7EB8430681A7F3AB51269DE")
    private int relayoutWindow(WindowManager.LayoutParams params, int viewVisibility,
            boolean insetsPending) throws RemoteException {
        addTaint(insetsPending);
        addTaint(viewVisibility);
        addTaint(params.getTaint());
        float appScale = mAttachInfo.mApplicationScale;
        boolean restore = false;
        if(params != null && mTranslator != null)        
        {
            restore = true;
            params.backup();
            mTranslator.translateWindowLayout(params);
        } //End block
        if(params != null)        
        {
            if(DBG)            
            Log.d(TAG, "WindowLayout in layoutWindow:" + params);
        } //End block
        mPendingConfiguration.seq = 0;
        if(params != null && mOrigWindowType != params.type)        
        {
            if(mTargetSdkVersion < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH)            
            {
                params.type = mOrigWindowType;
            } //End block
        } //End block
        int relayoutResult = sWindowSession.relayout(
                mWindow, mSeq, params,
                (int) (mView.getMeasuredWidth() * appScale + 0.5f),
                (int) (mView.getMeasuredHeight() * appScale + 0.5f),
                viewVisibility, insetsPending ? WindowManagerImpl.RELAYOUT_INSETS_PENDING : 0,
                mWinFrame, mPendingContentInsets, mPendingVisibleInsets,
                mPendingConfiguration, mSurface);
        if(restore)        
        {
            params.restore();
        } //End block
        if(mTranslator != null)        
        {
            mTranslator.translateRectInScreenToAppWinFrame(mWinFrame);
            mTranslator.translateRectInScreenToAppWindow(mPendingContentInsets);
            mTranslator.translateRectInScreenToAppWindow(mPendingVisibleInsets);
        } //End block
        int varFBA83592868FAAEDC2F5A83BBD7572C0_78772166 = (relayoutResult);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981985698 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981985698;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.739 -0400", hash_original_method = "15B8C68C65C02C1955DF774990289073", hash_generated_method = "E874191CA8502E5317C9B4137E6FD2AE")
    public void playSoundEffect(int effectId) {
        addTaint(effectId);
        checkThread();
        try 
        {
            final AudioManager audioManager = getAudioManager();
switch(effectId){
            case SoundEffectConstants.CLICK:
            audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);
            return;
            case SoundEffectConstants.NAVIGATION_DOWN:
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_DOWN);
            return;
            case SoundEffectConstants.NAVIGATION_LEFT:
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_LEFT);
            return;
            case SoundEffectConstants.NAVIGATION_RIGHT:
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_RIGHT);
            return;
            case SoundEffectConstants.NAVIGATION_UP:
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_UP);
            return;
            default:
            IllegalArgumentException var61246FE41259C7688FFFCAF7A0EEB648_1578658447 = new IllegalArgumentException("unknown effect id " + effectId +
                            " not defined in " + SoundEffectConstants.class.getCanonicalName());
            var61246FE41259C7688FFFCAF7A0EEB648_1578658447.addTaint(taint);
            throw var61246FE41259C7688FFFCAF7A0EEB648_1578658447;
}
        } //End block
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.740 -0400", hash_original_method = "B8D922B767BD06C4283BB3EF0BFA3172", hash_generated_method = "1080F5A5D8EAA6D5AA734E14712E191D")
    public boolean performHapticFeedback(int effectId, boolean always) {
        addTaint(always);
        addTaint(effectId);
        try 
        {
            boolean var9198E76E1AA7457086DD428D5CB0156B_1488308904 = (sWindowSession.performHapticFeedback(mWindow, effectId, always));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787178965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_787178965;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1465247188 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975263534 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975263534;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return sWindowSession.performHapticFeedback(mWindow, effectId, always);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.740 -0400", hash_original_method = "220A5158C443CFE1D4535C372C690545", hash_generated_method = "7E368C1A0162F08F49BE7DC3399C56DF")
    public View focusSearch(View focused, int direction) {
        addTaint(direction);
        addTaint(focused.getTaint());
        checkThread();
        if(!(mView instanceof ViewGroup))        
        {
View var540C13E9E156B687226421B24F2DF178_419687901 =             null;
            var540C13E9E156B687226421B24F2DF178_419687901.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_419687901;
        } //End block
View var8AF06A933C5FFD7CDE18ACE3D58088CE_541731021 =         FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
        var8AF06A933C5FFD7CDE18ACE3D58088CE_541731021.addTaint(taint);
        return var8AF06A933C5FFD7CDE18ACE3D58088CE_541731021;
        // ---------- Original Method ----------
        //checkThread();
        //if (!(mView instanceof ViewGroup)) {
            //return null;
        //}
        //return FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.740 -0400", hash_original_method = "5C67D040EE10672AA68B296434D2F63D", hash_generated_method = "265CF6F642B6AAE7F0DC95CDCBD015E9")
    public void debug() {
        mView.debug();
        // ---------- Original Method ----------
        //mView.debug();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.741 -0400", hash_original_method = "818AD1A70B8E095131DC73E371E19514", hash_generated_method = "7EBCC75FD6998525C0DDAD9FB2F435E5")
    public void dumpGfxInfo(PrintWriter pw, int[] info) {
        addTaint(info[0]);
        addTaint(pw.getTaint());
        if(mView != null)        
        {
            getGfxInfo(mView, info);
        } //End block
        else
        {
            info[0] = info[1] = 0;
        } //End block
        // ---------- Original Method ----------
        //if (mView != null) {
            //getGfxInfo(mView, info);
        //} else {
            //info[0] = info[1] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.741 -0400", hash_original_method = "CD86B0B9CE453C77251859969963B0E8", hash_generated_method = "446018F3BE5AE7CA33D602E5C86FECAC")
    private void getGfxInfo(View view, int[] info) {
        addTaint(info[0]);
        addTaint(view.getTaint());
        DisplayList displayList = view.mDisplayList;
        info[0]++;
        if(displayList != null)        
        {
            info[1] += displayList.getSize();
        } //End block
        if(view instanceof ViewGroup)        
        {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
for(int i = 0;i < count;i++)
            {
                getGfxInfo(group.getChildAt(i), info);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //DisplayList displayList = view.mDisplayList;
        //info[0]++;
        //if (displayList != null) {
            //info[1] += displayList.getSize();
        //}
        //if (view instanceof ViewGroup) {
            //ViewGroup group = (ViewGroup) view;
            //int count = group.getChildCount();
            //for (int i = 0; i < count; i++) {
                //getGfxInfo(group.getChildAt(i), info);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.741 -0400", hash_original_method = "F971131E8183B74AE14F7AE1993EB770", hash_generated_method = "FEA4FACFD3A5A98FF402B61477A30171")
    public void die(boolean immediate) {
        addTaint(immediate);
        if(immediate)        
        {
            doDie();
        } //End block
        else
        {
            sendEmptyMessage(DIE);
        } //End block
        // ---------- Original Method ----------
        //if (immediate) {
            //doDie();
        //} else {
            //sendEmptyMessage(DIE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.742 -0400", hash_original_method = "8D1DF41E880ED97CD9EA450CBF8DEBA9", hash_generated_method = "99D091A71B2A3842DEFBAF0DCDE0AF1C")
     void doDie() {
        checkThread();
        if(LOCAL_LOGV){ }        synchronized
(this)        {
            if(mAdded)            
            {
                mAdded = false;
                dispatchDetachedFromWindow();
            } //End block
            if(mAdded && !mFirst)            
            {
                destroyHardwareRenderer();
                int viewVisibility = mView.getVisibility();
                boolean viewVisibilityChanged = mViewVisibility != viewVisibility;
                if(mWindowAttributesChanged || viewVisibilityChanged)                
                {
                    try 
                    {
                        if((relayoutWindow(mWindowAttributes, viewVisibility, false)
                                & WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0)                        
                        {
                            sWindowSession.finishDrawing(mWindow);
                        } //End block
                    } //End block
                    catch (RemoteException e)
                    {
                    } //End block
                } //End block
                mSurface.release();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.742 -0400", hash_original_method = "C21E5BD1C0448C03922FA84C1B8F3673", hash_generated_method = "C4EBE55E44DE06301CF5F105BC54FE92")
    public void requestUpdateConfiguration(Configuration config) {
        addTaint(config.getTaint());
        Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.743 -0400", hash_original_method = "83B5F7EEB6D7B3078A7769D15E86950B", hash_generated_method = "36BA56E3C9FBDA55F1773A56E348C1A0")
    private void destroyHardwareRenderer() {
        if(mAttachInfo.mHardwareRenderer != null)        
        {
            mAttachInfo.mHardwareRenderer.destroy(true);
            mAttachInfo.mHardwareRenderer = null;
            mAttachInfo.mHardwareAccelerated = false;
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo.mHardwareRenderer != null) {
            //mAttachInfo.mHardwareRenderer.destroy(true);
            //mAttachInfo.mHardwareRenderer = null;
            //mAttachInfo.mHardwareAccelerated = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.743 -0400", hash_original_method = "459EFA224EE61797FCF735DB24F377FF", hash_generated_method = "FF095DC71063A0322E2D52E52F7DA076")
    public void dispatchFinishedEvent(int seq, boolean handled) {
        addTaint(handled);
        addTaint(seq);
        Message msg = obtainMessage(FINISHED_EVENT);
        msg.arg1 = seq;
        msg.arg2 = handled ? 1 : 0;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(FINISHED_EVENT);
        //msg.arg1 = seq;
        //msg.arg2 = handled ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.744 -0400", hash_original_method = "176F47B7EDC9D70A69736114EF5A25ED", hash_generated_method = "B23AE563E056EF06E52FADF39A891091")
    public void dispatchResized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        addTaint(newConfig.getTaint());
        addTaint(reportDraw);
        addTaint(visibleInsets.getTaint());
        addTaint(coveredInsets.getTaint());
        addTaint(h);
        addTaint(w);
        if(DEBUG_LAYOUT){ }        Message msg = obtainMessage(reportDraw ? RESIZED_REPORT :RESIZED);
        if(mTranslator != null)        
        {
            mTranslator.translateRectInScreenToAppWindow(coveredInsets);
            mTranslator.translateRectInScreenToAppWindow(visibleInsets);
            w *= mTranslator.applicationInvertedScale;
            h *= mTranslator.applicationInvertedScale;
        } //End block
        msg.arg1 = w;
        msg.arg2 = h;
        ResizedInfo ri = new ResizedInfo();
        ri.coveredInsets = new Rect(coveredInsets);
        ri.visibleInsets = new Rect(visibleInsets);
        ri.newConfig = newConfig;
        msg.obj = ri;
        sendMessage(msg);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.744 -0400", hash_original_method = "42F15B8B44D9B8805537AB8032035046", hash_generated_method = "68AFAAE01BD55E6BB2200CEF230ABECC")
    private void enqueueInputEvent(Message msg, long when) {
        addTaint(when);
        addTaint(msg.getTaint());
        InputEventMessage inputMessage = InputEventMessage.obtain(msg);
        if(mPendingInputEvents == null)        
        {
            mPendingInputEvents = inputMessage;
        } //End block
        else
        {
            InputEventMessage currMessage = mPendingInputEvents;
            while
(currMessage.mNext != null)            
            {
                currMessage = currMessage.mNext;
            } //End block
            currMessage.mNext = inputMessage;
        } //End block
        sendEmptyMessageAtTime(PROCESS_INPUT_EVENTS, when);
        // ---------- Original Method ----------
        //InputEventMessage inputMessage = InputEventMessage.obtain(msg);
        //if (mPendingInputEvents == null) {
            //mPendingInputEvents = inputMessage;
        //} else {
            //InputEventMessage currMessage = mPendingInputEvents;
            //while (currMessage.mNext != null) {
                //currMessage = currMessage.mNext;
            //}
            //currMessage.mNext = inputMessage;
        //}
        //sendEmptyMessageAtTime(PROCESS_INPUT_EVENTS, when);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.744 -0400", hash_original_method = "CF232D7D6B258A687467B35A15A72FA0", hash_generated_method = "D4B903330EB1E35489485416540A383B")
    public void dispatchKey(KeyEvent event) {
        addTaint(event.getTaint());
        dispatchKey(event, false);
        // ---------- Original Method ----------
        //dispatchKey(event, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.746 -0400", hash_original_method = "40FF3F3DF013E72EC5E96E0A49136BE3", hash_generated_method = "565D41EE556E624B0BED8CEEEF5398C6")
    private void dispatchKey(KeyEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        if(false && event.getAction() == KeyEvent.ACTION_DOWN)        
        {
            if(event.getKeyCode() == KeyEvent.KEYCODE_CAMERA)            
            {
                if(DBG)                
                Log.d("keydisp", "===================================================");
                if(DBG)                
                Log.d("keydisp", "Focused view Hierarchy is:");
                debug();
                if(DBG)                
                Log.d("keydisp", "===================================================");
            } //End block
        } //End block
        Message msg = obtainMessage(DISPATCH_KEY);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        if(LOCAL_LOGV){ }        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //if (false && event.getAction() == KeyEvent.ACTION_DOWN) {
            //if (event.getKeyCode() == KeyEvent.KEYCODE_CAMERA) {
                //if (DBG) Log.d("keydisp", "===================================================");
                //if (DBG) Log.d("keydisp", "Focused view Hierarchy is:");
                //debug();
                //if (DBG) Log.d("keydisp", "===================================================");
            //}
        //}
        //Message msg = obtainMessage(DISPATCH_KEY);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //if (LOCAL_LOGV) Log.v(
            //TAG, "sending key " + event + " to " + mView);
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.746 -0400", hash_original_method = "F90A161CC4BD8998AC3B193B63EB7E53", hash_generated_method = "E6B678A7402001146DB9ED703B52419E")
    private void dispatchMotion(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        int source = event.getSource();
        if((source & InputDevice.SOURCE_CLASS_POINTER) != 0)        
        {
            dispatchPointer(event, sendDone);
        } //End block
        else
        if((source & InputDevice.SOURCE_CLASS_TRACKBALL) != 0)        
        {
            dispatchTrackball(event, sendDone);
        } //End block
        else
        {
            dispatchGenericMotion(event, sendDone);
        } //End block
        // ---------- Original Method ----------
        //int source = event.getSource();
        //if ((source & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            //dispatchPointer(event, sendDone);
        //} else if ((source & InputDevice.SOURCE_CLASS_TRACKBALL) != 0) {
            //dispatchTrackball(event, sendDone);
        //} else {
            //dispatchGenericMotion(event, sendDone);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.747 -0400", hash_original_method = "DD56557FEAC8CACD87B056C5C0C702D1", hash_generated_method = "06CAB68CD99C4D22C9F20B046BC21977")
    private void dispatchPointer(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        Message msg = obtainMessage(DISPATCH_POINTER);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_POINTER);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.748 -0400", hash_original_method = "CA2BFA17163311E1AAAA771C667E27EE", hash_generated_method = "B17D3B5A1DCE1C0B7C28C8EE7362468C")
    private void dispatchTrackball(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        Message msg = obtainMessage(DISPATCH_TRACKBALL);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_TRACKBALL);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.748 -0400", hash_original_method = "BF71C2E204EC82729A1EA0969E06871A", hash_generated_method = "0BA7834E904103442AD37940CA9725B9")
    private void dispatchGenericMotion(MotionEvent event, boolean sendDone) {
        addTaint(sendDone);
        addTaint(event.getTaint());
        Message msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.748 -0400", hash_original_method = "609DE6F7AC6918A6ED5E47157E290835", hash_generated_method = "3E9F9F9431F5F244DB5BE82C4EDC88DD")
    public void dispatchAppVisibility(boolean visible) {
        addTaint(visible);
        Message msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        msg.arg1 = visible ? 1 : 0;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        //msg.arg1 = visible ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.748 -0400", hash_original_method = "4D3A3DC5DC743660725FA6A11A372A07", hash_generated_method = "C12E8F86927C6A1FB5221B95AE3FC2E7")
    public void dispatchGetNewSurface() {
        Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.748 -0400", hash_original_method = "0CD487AEEAC72879653D2DB3DCCCEB86", hash_generated_method = "10ADFFE8F78F16FF9BC008057B2706B5")
    public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
        addTaint(inTouchMode);
        addTaint(hasFocus);
        Message msg = Message.obtain();
        msg.what = WINDOW_FOCUS_CHANGED;
        msg.arg1 = hasFocus ? 1 : 0;
        msg.arg2 = inTouchMode ? 1 : 0;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = WINDOW_FOCUS_CHANGED;
        //msg.arg1 = hasFocus ? 1 : 0;
        //msg.arg2 = inTouchMode ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.750 -0400", hash_original_method = "DCE84E54CF89AABF2B838105364C2821", hash_generated_method = "5C2C862890C31FC82A04DFFD5A434443")
    public void dispatchCloseSystemDialogs(String reason) {
        addTaint(reason.getTaint());
        Message msg = Message.obtain();
        msg.what = CLOSE_SYSTEM_DIALOGS;
        msg.obj = reason;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = CLOSE_SYSTEM_DIALOGS;
        //msg.obj = reason;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.750 -0400", hash_original_method = "786F6A89EC1BE66218A42841DB30F7AC", hash_generated_method = "B0EBB2CF519F449454746905E0EA89B8")
    public void dispatchDragEvent(DragEvent event) {
        addTaint(event.getTaint());
        int what;
        if(event.getAction() == DragEvent.ACTION_DRAG_LOCATION)        
        {
            what = DISPATCH_DRAG_LOCATION_EVENT;
            removeMessages(what);
        } //End block
        else
        {
            what = DISPATCH_DRAG_EVENT;
        } //End block
        Message msg = obtainMessage(what, event);
        sendMessage(msg);
        // ---------- Original Method ----------
        //final int what;
        //if (event.getAction() == DragEvent.ACTION_DRAG_LOCATION) {
            //what = DISPATCH_DRAG_LOCATION_EVENT;
            //removeMessages(what);
        //} else {
            //what = DISPATCH_DRAG_EVENT;
        //}
        //Message msg = obtainMessage(what, event);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.751 -0400", hash_original_method = "95F6C6AC5462FA09198431CBF084B2BE", hash_generated_method = "9F276153D081BA73B699DBF238EF2521")
    public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
            int localValue, int localChanges) {
        addTaint(localChanges);
        addTaint(localValue);
        addTaint(globalVisibility);
        addTaint(seq);
        SystemUiVisibilityInfo args = new SystemUiVisibilityInfo();
        args.seq = seq;
        args.globalVisibility = globalVisibility;
        args.localValue = localValue;
        args.localChanges = localChanges;
        sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
        // ---------- Original Method ----------
        //SystemUiVisibilityInfo args = new SystemUiVisibilityInfo();
        //args.seq = seq;
        //args.globalVisibility = globalVisibility;
        //args.localValue = localValue;
        //args.localChanges = localChanges;
        //sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.752 -0400", hash_original_method = "DE2DA8F2C91C4BAC5E71DE180C591B82", hash_generated_method = "6C3C0B9666B4A7E7E6A2D719B65AA405")
    private void sendAccessibilityEvents() {
        if(!mAccessibilityManager.isEnabled())        
        {
            return;
        } //End block
        mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        View focusedView = mView.findFocus();
        if(focusedView != null && focusedView != mView)        
        {
            focusedView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        } //End block
        // ---------- Original Method ----------
        //if (!mAccessibilityManager.isEnabled()) {
            //return;
        //}
        //mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        //View focusedView = mView.findFocus();
        //if (focusedView != null && focusedView != mView) {
            //focusedView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.752 -0400", hash_original_method = "3EBD42CE7AD44788B8B5975E509C0AD4", hash_generated_method = "1589CEEAC299DADF193B2FB484784665")
    private void postSendWindowContentChangedCallback() {
        if(mSendWindowContentChangedAccessibilityEvent == null)        
        {
            mSendWindowContentChangedAccessibilityEvent =
                new SendWindowContentChangedAccessibilityEvent();
        } //End block
        if(!mSendWindowContentChangedAccessibilityEvent.mIsPending)        
        {
            mSendWindowContentChangedAccessibilityEvent.mIsPending = true;
            postDelayed(mSendWindowContentChangedAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        } //End block
        // ---------- Original Method ----------
        //if (mSendWindowContentChangedAccessibilityEvent == null) {
            //mSendWindowContentChangedAccessibilityEvent =
                //new SendWindowContentChangedAccessibilityEvent();
        //}
        //if (!mSendWindowContentChangedAccessibilityEvent.mIsPending) {
            //mSendWindowContentChangedAccessibilityEvent.mIsPending = true;
            //postDelayed(mSendWindowContentChangedAccessibilityEvent,
                    //ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.752 -0400", hash_original_method = "B38BF7B18A0D0C0D14C2E79D97568CE9", hash_generated_method = "3E18D5197413B6DFFD87E4329868D248")
    private void removeSendWindowContentChangedCallback() {
        if(mSendWindowContentChangedAccessibilityEvent != null)        
        {
            removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendWindowContentChangedAccessibilityEvent != null) {
            //removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.752 -0400", hash_original_method = "3A017950A97502A630256434B0EBF7E8", hash_generated_method = "A1A4EDE71138CAB490AD920130130BFE")
    public boolean showContextMenuForChild(View originalView) {
        addTaint(originalView.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1085976987 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901908359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901908359;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.752 -0400", hash_original_method = "492AE6A9C9C6F2F7E659E19901E3E487", hash_generated_method = "925D68212DBEEB2CD9B2472EF8582C7B")
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        addTaint(callback.getTaint());
        addTaint(originalView.getTaint());
ActionMode var540C13E9E156B687226421B24F2DF178_2127714526 =         null;
        var540C13E9E156B687226421B24F2DF178_2127714526.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2127714526;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.753 -0400", hash_original_method = "FB735C9133B887C07751FC797F168B65", hash_generated_method = "A7DA1CFB4829C8E1B84DF1FFE066706B")
    public void createContextMenu(ContextMenu menu) {
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.753 -0400", hash_original_method = "C40FC95C25B6655ACCA9227D471DC892", hash_generated_method = "FB4FD2CE39B9A19ED55CF997B56E8AAD")
    public void childDrawableStateChanged(View child) {
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.753 -0400", hash_original_method = "975E17A58706A43B9CF06D84428C706E", hash_generated_method = "F44B4DD13EE92F2DC4A36E6188B2FEAA")
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        addTaint(event.getTaint());
        addTaint(child.getTaint());
        if(mView == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1300471236 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_897232708 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_897232708;
        } //End block
        mAccessibilityManager.sendAccessibilityEvent(event);
        boolean varB326B5062B2F0E69046810717534CB09_2144573457 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1931748934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1931748934;
        // ---------- Original Method ----------
        //if (mView == null) {
            //return false;
        //}
        //mAccessibilityManager.sendAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.753 -0400", hash_original_method = "C963D9A99CD7BE986B275021EA99CB95", hash_generated_method = "42A2DBF138CF04E548E7D8DD51AADDF0")
     void checkThread() {
        if(mThread != Thread.currentThread())        
        {
            CalledFromWrongThreadException var31F1BA0AEAB9B7C2E91B74470CBD7375_1931589692 = new CalledFromWrongThreadException(
                    "Only the original thread that created a view hierarchy can touch its views.");
            var31F1BA0AEAB9B7C2E91B74470CBD7375_1931589692.addTaint(taint);
            throw var31F1BA0AEAB9B7C2E91B74470CBD7375_1931589692;
        } //End block
        // ---------- Original Method ----------
        //if (mThread != Thread.currentThread()) {
            //throw new CalledFromWrongThreadException(
                    //"Only the original thread that created a view hierarchy can touch its views.");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.754 -0400", hash_original_method = "F9834E22E1AF22274F19B27CD50E21E5", hash_generated_method = "8C6445ECC283015C0E55FA20D0DB11D5")
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        addTaint(disallowIntercept);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.754 -0400", hash_original_method = "176476ED7A31EA7594378C530DAA6036", hash_generated_method = "34E26BF710C512F8D6D73495B0A6059B")
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        addTaint(child.getTaint());
        boolean var342440852E7643230B9A793CC2DC5299_1323676551 = (scrollToRectOrFocus(rectangle, immediate));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646256715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646256715;
        // ---------- Original Method ----------
        //return scrollToRectOrFocus(rectangle, immediate);
    }

    
    static RunQueue getRunQueue() {
        RunQueue rq = sRunQueues.get();
        if (rq != null) {
            return rq;
        }
        rq = new RunQueue();
        sRunQueues.set(rq);
        return rq;
    }

    
    class ResizedInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "87B176B1B575D0EBABCED2EA986D231E", hash_generated_field = "47DADDCDE2ABE98E0EA742CE6D950BCA")

        Rect coveredInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "A61C7CD3070C24C4D07AD92D2435193C", hash_generated_field = "0B179B80C8AEF7EE8B7A9887F27D40FA")

        Rect visibleInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "6D069C9B9BA8B31B534F29F6B998EB02", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "50B840B7E2FD8E0275C71397DAD0B09A", hash_generated_method = "50B840B7E2FD8E0275C71397DAD0B09A")
        public ResizedInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class SystemUiVisibilityInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "9AA0E19EC2BEA0A624663676438F19F7", hash_generated_field = "29F921E441BDF940DE75A15B6BF90A8A")

        int globalVisibility;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "A4F2C94518DDF678500A137497CD9AFC", hash_generated_field = "1D88C8081D2F96806DB5C538B6E7C0F8")

        int localValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "D681324457E353443A7299399AC9C35A", hash_generated_field = "824A34BA64EB40D64E4FA95CF88B8DD6")

        int localChanges;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "A01B0E4A631704C3007E2CC2ECBBD6C3", hash_generated_method = "A01B0E4A631704C3007E2CC2ECBBD6C3")
        public SystemUiVisibilityInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputEventMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "2D41D548AF5E6C9BAD3BF2AC7B0EDE61")

        Message mMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "BB8AFFB0007C8D035A06590D15408355")

        InputEventMessage mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "B714885B0648B0EB69373E467D5A2ACF", hash_generated_method = "5C7FFAA5DA7B01CBEE7862EEC63062E5")
        private  InputEventMessage(Message m) {
            mMessage = m;
            mNext = null;
            // ---------- Original Method ----------
            //mMessage = m;
            //mNext = null;
        }

        
        public static InputEventMessage obtain(Message msg) {
            synchronized (sPoolSync) {
                if (sPool != null) {
                    InputEventMessage m = sPool;
                    sPool = m.mNext;
                    m.mNext = null;
                    sPoolSize--;
                    m.mMessage = msg;
                    return m;
                }
            }
            return new InputEventMessage(msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "9F2D00AD0B3B7E97E6983E3E4DE01E8D", hash_generated_method = "24A38EA2469BD2D633E229EAE781FFA5")
        public void recycle() {
            mMessage.recycle();
            synchronized
(sPoolSync)            {
                if(sPoolSize < MAX_POOL_SIZE)                
                {
                    mNext = sPool;
                    sPool = this;
                    sPoolSize++;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //mMessage.recycle();
            //synchronized (sPoolSync) {
                //if (sPoolSize < MAX_POOL_SIZE) {
                    //mNext = sPool;
                    //sPool = this;
                    //sPoolSize++;
                //}
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "D5B99AC4B86CE940DBBD3CF3FA1D542C")

        private static final Object sPoolSync = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "3276E3FE464DBE4BDC4F9753A4DD418D")

        private static InputEventMessage sPool;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

        private static int sPoolSize = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

        private static final int MAX_POOL_SIZE = 10;
    }


    
    class TakenSurfaceHolder extends BaseSurfaceHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.755 -0400", hash_original_method = "C250C7CF3696759C39C0C66232FB4E2F", hash_generated_method = "C250C7CF3696759C39C0C66232FB4E2F")
        public TakenSurfaceHolder ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "93900AD5EB4A5A0D65615E175C2FC0CA", hash_generated_method = "BB518BD4F173E86F137ECE730F7686C1")
        @Override
        public boolean onAllowLockCanvas() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var0822D4118140B9899091B78395995296_937732926 = (mDrawingAllowed);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377390000 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377390000;
            // ---------- Original Method ----------
            //return mDrawingAllowed;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "CAFD67152D224915C2628F6ACAAF5E06", hash_generated_method = "769E8A917A2AE0CACCF50C3D308C76DF")
        @Override
        public void onRelayoutContainer() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "E07C2927AF02C0614ECCFDEAF72047C2", hash_generated_method = "08368F0767219BEAF7E4EDA996732683")
        public void setFormat(int format) {
            addTaint(format);
            ((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "EE34E0B82BE2B114D60991753727E9A6", hash_generated_method = "9BF191EBFD1C84422D42D9D075C77A00")
        public void setType(int type) {
            addTaint(type);
            ((RootViewSurfaceTaker)mView).setSurfaceType(type);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceType(type);
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "65C8D4CF87AA6164C88CB73B7231A722", hash_generated_method = "8E830E16730C0BA568FB86258CFF9061")
        @Override
        public void onUpdateSurface() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            IllegalStateException varD8DEC26EB0EDEE2D9D45FECC8727EF4E_544887521 = new IllegalStateException("Shouldn't be here");
            varD8DEC26EB0EDEE2D9D45FECC8727EF4E_544887521.addTaint(taint);
            throw varD8DEC26EB0EDEE2D9D45FECC8727EF4E_544887521;
            // ---------- Original Method ----------
            //throw new IllegalStateException("Shouldn't be here");
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "B8B485B006F71F92CB0565F418AB216D")
        public boolean isCreating() {
            boolean var0E2361D9DC5F8ED2D80C3189D2E3EE01_1589666516 = (mIsCreating);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1515961250 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1515961250;
            // ---------- Original Method ----------
            //return mIsCreating;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.756 -0400", hash_original_method = "DFAAE278D74727ACF1AA5508094F804D", hash_generated_method = "A7F38437678F3680E51DF8DCF5430249")
        @Override
        public void setFixedSize(int width, int height) {
            addTaint(height);
            addTaint(width);
            UnsupportedOperationException var77744EB20207222815B0FC830B0B88DF_1472446631 = new UnsupportedOperationException(
                    "Currently only support sizing from layout");
            var77744EB20207222815B0FC830B0B88DF_1472446631.addTaint(taint);
            throw var77744EB20207222815B0FC830B0B88DF_1472446631;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException(
                    //"Currently only support sizing from layout");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.757 -0400", hash_original_method = "21F6CF6D8B53BD856057ED05ABC33177", hash_generated_method = "03636794D5DFD961E2AD2ACF8BD267CE")
        public void setKeepScreenOn(boolean screenOn) {
            addTaint(screenOn);
            ((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
        }

        
    }


    
    static class InputMethodCallback extends IInputMethodCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.757 -0400", hash_original_field = "BDC69E2933EF10AA19C929361BF070F9", hash_generated_field = "E7FFD6E9BC298C91066F7F076BB25FC3")

        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.757 -0400", hash_original_method = "54191F901FEF749694D67ED7BF80E958", hash_generated_method = "94B33F5DBF40614378A9EE46EF7CB527")
        public  InputMethodCallback(ViewRootImpl viewAncestor) {
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.757 -0400", hash_original_method = "BE17249E230FCA094C5B0C5E3A1F0AA4", hash_generated_method = "494FBCF89DFB4604B7683262CCAA1B7A")
        public void finishedEvent(int seq, boolean handled) {
            addTaint(handled);
            addTaint(seq);
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchFinishedEvent(seq, handled);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchFinishedEvent(seq, handled);
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.757 -0400", hash_original_method = "93549AC7AA704598E881A2A0D800AB4C", hash_generated_method = "B59F51822D7ED309BAF5863A034576FE")
        public void sessionCreated(IInputMethodSession session) {
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static class W extends IWindow.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.757 -0400", hash_original_field = "BDC69E2933EF10AA19C929361BF070F9", hash_generated_field = "E7FFD6E9BC298C91066F7F076BB25FC3")

        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.759 -0400", hash_original_method = "D1CF0E60435976F2AA38BD5BC7DA8E27", hash_generated_method = "B0B8B7CF155794D34CA9E098CB8D485B")
          W(ViewRootImpl viewAncestor) {
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.759 -0400", hash_original_method = "A648B76CE506B7CD274906DE238C17D8", hash_generated_method = "C6AC4709F29E983B145BE026D0E4508F")
        public void resized(int w, int h, Rect coveredInsets, Rect visibleInsets,
                boolean reportDraw, Configuration newConfig) {
            addTaint(newConfig.getTaint());
            addTaint(reportDraw);
            addTaint(visibleInsets.getTaint());
            addTaint(coveredInsets.getTaint());
            addTaint(h);
            addTaint(w);
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        newConfig);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        //newConfig);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.759 -0400", hash_original_method = "EB98E21C67C8D9A44F58CD671F491CDA", hash_generated_method = "42D1C3755F74969A0D8CD569C34712DD")
        public void dispatchAppVisibility(boolean visible) {
            addTaint(visible);
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchAppVisibility(visible);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchAppVisibility(visible);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.760 -0400", hash_original_method = "5CE742A9FFA814199F790759E49D980E", hash_generated_method = "1C3A91EE7ED3FABC6410333C97D1765A")
        public void dispatchGetNewSurface() {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchGetNewSurface();
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchGetNewSurface();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.760 -0400", hash_original_method = "294D771D49852BEC83940B0D8623D316", hash_generated_method = "90B660729A148167F654B111D2814C0B")
        public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
            addTaint(inTouchMode);
            addTaint(hasFocus);
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.windowFocusChanged(hasFocus, inTouchMode);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.windowFocusChanged(hasFocus, inTouchMode);
            //}
        }

        
        private static int checkCallingPermission(String permission) {
            try {
                return ActivityManagerNative.getDefault().checkPermission(
                        permission, Binder.getCallingPid(), Binder.getCallingUid());
            } catch (RemoteException e) {
                return PackageManager.PERMISSION_DENIED;
            }
        }

        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.761 -0400", hash_original_method = "BAC64B61AF453BEA5AB28D214B8FF7C5", hash_generated_method = "3B86501AC3F04B1A5332FCF929CE28FA")
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            addTaint(out.getTaint());
            addTaint(parameters.getTaint());
            addTaint(command.getTaint());
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                final View view = viewAncestor.mView;
                if(view != null)                
                {
                    if(checkCallingPermission(Manifest.permission.DUMP) !=
                            PackageManager.PERMISSION_GRANTED)                    
                    {
                        SecurityException varA2EB9AF33004BF7F05931B044B6301F2_1787056745 = new SecurityException("Insufficient permissions to invoke"
                                + " executeCommand() from pid=" + Binder.getCallingPid()
                                + ", uid=" + Binder.getCallingUid());
                        varA2EB9AF33004BF7F05931B044B6301F2_1787056745.addTaint(taint);
                        throw varA2EB9AF33004BF7F05931B044B6301F2_1787056745;
                    } //End block
                    OutputStream clientStream = null;
                    try 
                    {
                        clientStream = new ParcelFileDescriptor.AutoCloseOutputStream(out);
                        ViewDebug.dispatchCommand(view, command, parameters, clientStream);
                    } //End block
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    } //End block
                    finally 
                    {
                        if(clientStream != null)                        
                        {
                            try 
                            {
                                clientStream.close();
                            } //End block
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.761 -0400", hash_original_method = "0341134904B032AC1241DC2205E79E01", hash_generated_method = "E56172F70A2F85396EF280C8418D04FE")
        public void closeSystemDialogs(String reason) {
            addTaint(reason.getTaint());
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchCloseSystemDialogs(reason);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchCloseSystemDialogs(reason);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.762 -0400", hash_original_method = "0D1309853D34ED0E4A19A33B54F85778", hash_generated_method = "DE90A182FEC193DA8B677B6DA708CCAC")
        public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep,
                boolean sync) {
            addTaint(sync);
            addTaint(yStep);
            addTaint(xStep);
            addTaint(y);
            addTaint(x);
            if(sync)            
            {
                try 
                {
                    sWindowSession.wallpaperOffsetsComplete(asBinder());
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (sync) {
                //try {
                    //sWindowSession.wallpaperOffsetsComplete(asBinder());
                //} catch (RemoteException e) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.762 -0400", hash_original_method = "084CB00632E8F4F79253F4CBB0703969", hash_generated_method = "432BB01D60EE50963C5565A817FD4C9E")
        public void dispatchWallpaperCommand(String action, int x, int y,
                int z, Bundle extras, boolean sync) {
            addTaint(sync);
            addTaint(extras.getTaint());
            addTaint(z);
            addTaint(y);
            addTaint(x);
            addTaint(action.getTaint());
            if(sync)            
            {
                try 
                {
                    sWindowSession.wallpaperCommandComplete(asBinder(), null);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (sync) {
                //try {
                    //sWindowSession.wallpaperCommandComplete(asBinder(), null);
                //} catch (RemoteException e) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.762 -0400", hash_original_method = "AE33DC8C57E72B3B1EEF7B37E6DC4CB6", hash_generated_method = "64E87438A97E3F7CE5A88E7B2C83C812")
        public void dispatchDragEvent(DragEvent event) {
            addTaint(event.getTaint());
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchDragEvent(event);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchDragEvent(event);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_method = "0BC30404A661769E03F23017D2DE8196", hash_generated_method = "9478F2F7EF82B76737D7168FEFA3779B")
        public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
                int localValue, int localChanges) {
            addTaint(localChanges);
            addTaint(localValue);
            addTaint(globalVisibility);
            addTaint(seq);
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            if(viewAncestor != null)            
            {
                viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        localValue, localChanges);
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        //localValue, localChanges);
            //}
        }

        
    }


    
    static final class TrackballAxis {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "722609B4032E08961786F0112C7E37CB")

        float position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "B29619EA76E3BF5BA77E443C78C9D903", hash_generated_field = "2BC82C89B8860ABF3FA89A1E7B3206F3")

        float absPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "FD9F905F7F3D9B6366C514E37B686214", hash_generated_field = "F2035D00830CD97606C06BFD7F9DAD98")

        float acceleration = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "F34DECEAD687C48B7FAF16267CBFC237", hash_generated_field = "629DD7870B747F7AC2FDA49880D52BD5")

        long lastMoveTime = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "2764CA9D34E90313978D044F27AE433B", hash_generated_field = "4351D9E8E936913B3754B1B6ADCCBF7A")

        int step;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "736007832D2167BAAAE763FD3A3F3CF1", hash_generated_field = "32FF19239F28E132D49E8333CE74D2D7")

        int dir;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_field = "5F7D2E7F870DA0C9CD0B93AD0ADF0585", hash_generated_field = "887ADC84C7F0FC3F8C0B95BBC171A673")

        int nonAccelMovement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.763 -0400", hash_original_method = "D5D0F3DD2FCFEEF1D3847F5A318F142A", hash_generated_method = "D5D0F3DD2FCFEEF1D3847F5A318F142A")
        public TrackballAxis ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.764 -0400", hash_original_method = "A6304CADA1EF057D91BA6FF70064FCCC", hash_generated_method = "94AD87BF947D2DA6B9302A4900B6F256")
         void reset(int _step) {
            position = 0;
            acceleration = 1;
            lastMoveTime = 0;
            step = _step;
            dir = 0;
            // ---------- Original Method ----------
            //position = 0;
            //acceleration = 1;
            //lastMoveTime = 0;
            //step = _step;
            //dir = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.764 -0400", hash_original_method = "7BE12B55CFE54AFD4A89AB866136213C", hash_generated_method = "FD1AE2030702A2984287374123F450F1")
         float collect(float off, long time, String axis) {
            addTaint(axis.getTaint());
            long normTime;
            if(off > 0)            
            {
                normTime = (long)(off * FAST_MOVE_TIME);
                if(dir < 0)                
                {
                    if(DEBUG_TRACKBALL){ }                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                } //End block
                dir = 1;
            } //End block
            else
            if(off < 0)            
            {
                normTime = (long)((-off) * FAST_MOVE_TIME);
                if(dir > 0)                
                {
                    if(DEBUG_TRACKBALL){ }                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                } //End block
                dir = -1;
            } //End block
            else
            {
                normTime = 0;
            } //End block
            if(normTime > 0)            
            {
                long delta = time - lastMoveTime;
                lastMoveTime = time;
                float acc = acceleration;
                if(delta < normTime)                
                {
                    float scale = (normTime-delta) * ACCEL_MOVE_SCALING_FACTOR;
                    if(scale > 1)                    
                    acc *= scale;
                    if(DEBUG_TRACKBALL){ }                    acceleration = acc < MAX_ACCELERATION ? acc : MAX_ACCELERATION;
                } //End block
                else
                {
                    float scale = (delta-normTime) * ACCEL_MOVE_SCALING_FACTOR;
                    if(scale > 1)                    
                    acc /= scale;
                    if(DEBUG_TRACKBALL){ }                    acceleration = acc > 1 ? acc : 1;
                } //End block
            } //End block
            position += off;
            float var6083644206F817C352812C556C17968C_1041871074 = ((absPosition = Math.abs(position)));
                        float var546ADE640B6EDFBC8A086EF31347E768_493698083 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_493698083;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.766 -0400", hash_original_method = "94A3484B43A305FA2D2533E09119590B", hash_generated_method = "C9745129AB5FF33D0A10299252FE0328")
         int generate(float precision) {
            addTaint(precision);
            int movement = 0;
            nonAccelMovement = 0;
            do {
                {
                    final int dir = position >= 0 ? 1 : -1;
switch(step){
                    case 0:
                    if(absPosition < precision)                    
                    {
                        int var74BCC1E0384A916F56360C649F543F3A_1620179402 = (movement);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649239732 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1649239732;
                    } //End block
                    movement += dir;
                    nonAccelMovement += dir;
                    step = 1;
                    break;
                    case 1:
                    if(absPosition < 2)                    
                    {
                        int var74BCC1E0384A916F56360C649F543F3A_476691115 = (movement);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731659130 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731659130;
                    } //End block
                    movement += dir;
                    nonAccelMovement += dir;
                    position += dir > 0 ? -2 : 2;
                    absPosition = Math.abs(position);
                    step = 2;
                    break;
                    default:
                    if(absPosition < 1)                    
                    {
                        int var74BCC1E0384A916F56360C649F543F3A_475442343 = (movement);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094898886 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1094898886;
                    } //End block
                    movement += dir;
                    position += dir >= 0 ? -1 : 1;
                    absPosition = Math.abs(position);
                    float acc = acceleration;
                    acc *= 1.1f;
                    acceleration = acc < MAX_ACCELERATION ? acc : acceleration;
                    break;
}
                } //End block
} while (true);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.766 -0400", hash_original_field = "FFB8D9084F5E7C4FE0D8B75212BB972A", hash_generated_field = "973768C090750F2E47DF477502675CB2")

        static final float MAX_ACCELERATION = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.766 -0400", hash_original_field = "21FFA872A4349714F48F231AF43BA975", hash_generated_field = "107EAA5D46224CB4A8CF941F26CA7ECA")

        static final long FAST_MOVE_TIME = 150;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.766 -0400", hash_original_field = "8592CB949A3002098EAFA7A362CA67B9", hash_generated_field = "F2C6BC14D2039A7C27D6C313A91A0FF8")

        static final float ACCEL_MOVE_SCALING_FACTOR = (1.0f/40);
    }


    
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_method = "D704015D17B148E0274888D3BE6B5A1B", hash_generated_method = "5206D6D9B9B192FA36F61484BBA93ECD")
        public  CalledFromWrongThreadException(String msg) {
            super(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static final class RunQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_field = "EF3FD8395D5A4D4B896DE1728B5B7AFF", hash_generated_field = "F821D9D70BB932D42D3D9D491D5A29A1")

        private final ArrayList<HandlerAction> mActions = new ArrayList<HandlerAction>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_method = "9D853D73EE638AB90ACD5CD9573763A9", hash_generated_method = "9D853D73EE638AB90ACD5CD9573763A9")
        public RunQueue ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_method = "D30AD5886AAB6A1562A9D91A9C03E0DF", hash_generated_method = "1ACD9620B44B3B640FE2F3BB6B593533")
         void post(Runnable action) {
            addTaint(action.getTaint());
            postDelayed(action, 0);
            // ---------- Original Method ----------
            //postDelayed(action, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_method = "37D90AC712BBF73BCC19C8079034F8F1", hash_generated_method = "E7B6D767066D468BE44498BFEB49A8E7")
         void postDelayed(Runnable action, long delayMillis) {
            addTaint(delayMillis);
            addTaint(action.getTaint());
            HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = action;
            handlerAction.delay = delayMillis;
            synchronized
(mActions)            {
                mActions.add(handlerAction);
            } //End block
            // ---------- Original Method ----------
            //HandlerAction handlerAction = new HandlerAction();
            //handlerAction.action = action;
            //handlerAction.delay = delayMillis;
            //synchronized (mActions) {
                //mActions.add(handlerAction);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.767 -0400", hash_original_method = "5BA3715297222A78241D425B9BCC6DE7", hash_generated_method = "6565A97F68429A3DECA69D936833AECC")
         void removeCallbacks(Runnable action) {
            addTaint(action.getTaint());
            final HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = action;
            synchronized
(mActions)            {
                final ArrayList<HandlerAction> actions = mActions;
                while
(actions.remove(handlerAction))                
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //final HandlerAction handlerAction = new HandlerAction();
            //handlerAction.action = action;
            //synchronized (mActions) {
                //final ArrayList<HandlerAction> actions = mActions;
                //while (actions.remove(handlerAction)) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.768 -0400", hash_original_method = "3626F7B757A14315643B29FE9818088B", hash_generated_method = "992068F0C403A6CBE987BFB17CC16677")
         void executeActions(Handler handler) {
            addTaint(handler.getTaint());
            synchronized
(mActions)            {
                final ArrayList<HandlerAction> actions = mActions;
                final int count = actions.size();
for(int i = 0;i < count;i++)
                {
                    final HandlerAction handlerAction = actions.get(i);
                    handler.postDelayed(handlerAction.action, handlerAction.delay);
                } //End block
                actions.clear();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mActions) {
                //final ArrayList<HandlerAction> actions = mActions;
                //final int count = actions.size();
                //for (int i = 0; i < count; i++) {
                    //final HandlerAction handlerAction = actions.get(i);
                    //handler.postDelayed(handlerAction.action, handlerAction.delay);
                //}
                //actions.clear();
            //}
        }

        
        private static class HandlerAction {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.769 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "6E604B84976ABCF0C30A63D2F996D309")

            Runnable action;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.769 -0400", hash_original_field = "7243F8BE75253AFBADF7477867021F8B", hash_generated_field = "D26E4607AC64CA745B70892C422A8C3F")

            long delay;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.769 -0400", hash_original_method = "30472C53850B994B9A76B3EFD24AA1BA", hash_generated_method = "30472C53850B994B9A76B3EFD24AA1BA")
            public HandlerAction ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.769 -0400", hash_original_method = "EC304D8CC82834BC90F0FBE66AB5A5B9", hash_generated_method = "4256DCBE71A71EDFC25B8B181B8D586A")
            @Override
            public boolean equals(Object o) {
                addTaint(o.getTaint());
                if(this == o)                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1885446602 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1355009632 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1355009632;
                }
                if(o == null || getClass() != o.getClass())                
                {
                boolean var68934A3E9455FA72420237EB05902327_1559902902 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197221169 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197221169;
                }
                HandlerAction that = (HandlerAction) o;
                boolean varD63B39472A91826C5CC2997C8A84997B_1477138605 = (!(action != null ? !action.equals(that.action) : that.action != null));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914755296 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914755296;
                // ---------- Original Method ----------
                //if (this == o) return true;
                //if (o == null || getClass() != o.getClass()) return false;
                //HandlerAction that = (HandlerAction) o;
                //return !(action != null ? !action.equals(that.action) : that.action != null);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.769 -0400", hash_original_method = "09AD30FBB7C8AE284E2A2DAD39966BF7", hash_generated_method = "7E69D58B436B7A6DAFBB25A0C6CD518E")
            @Override
            public int hashCode() {
                int result = action != null ? action.hashCode() : 0;
                result = 31 * result + (int) (delay ^ (delay >>> 32));
                int varB4A88417B3D0170D754C647C30B7216A_1376196562 = (result);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592359446 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592359446;
                // ---------- Original Method ----------
                //int result = action != null ? action.hashCode() : 0;
                //result = 31 * result + (int) (delay ^ (delay >>> 32));
                //return result;
            }

            
        }


        
    }


    
    final class AccessibilityInteractionConnectionManager implements AccessibilityStateChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.770 -0400", hash_original_method = "B130C22D2DF300A6E0FC543B73826678", hash_generated_method = "B130C22D2DF300A6E0FC543B73826678")
        public AccessibilityInteractionConnectionManager ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.770 -0400", hash_original_method = "8A20E0BF76F2FE3CB2E135C12DE9692E", hash_generated_method = "03B280CA9C8F15D4FA876E8A24AE578A")
        public void onAccessibilityStateChanged(boolean enabled) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(enabled);
            if(enabled)            
            {
                ensureConnection();
            } //End block
            else
            {
                ensureNoConnection();
            } //End block
            // ---------- Original Method ----------
            //if (enabled) {
                //ensureConnection();
            //} else {
                //ensureNoConnection();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.770 -0400", hash_original_method = "92A9A6CA8F5EA055DBA3D736397E37E0", hash_generated_method = "341DCCA51152A7059495FC8D600202D5")
        public void ensureConnection() {
            final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            if(!registered)            
            {
                mAttachInfo.mAccessibilityWindowId =
                    mAccessibilityManager.addAccessibilityInteractionConnection(mWindow,
                            new AccessibilityInteractionConnection(ViewRootImpl.this));
            } //End block
            // ---------- Original Method ----------
            //final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            //if (!registered) {
                //mAttachInfo.mAccessibilityWindowId =
                    //mAccessibilityManager.addAccessibilityInteractionConnection(mWindow,
                            //new AccessibilityInteractionConnection(ViewRootImpl.this));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.770 -0400", hash_original_method = "C22E99B1A3881672FEB45F6BE843B278", hash_generated_method = "20A53AE746AB53AF2F1EF09883F747C4")
        public void ensureNoConnection() {
            final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            if(registered)            
            {
                mAttachInfo.mAccessibilityWindowId = View.NO_ID;
                mAccessibilityManager.removeAccessibilityInteractionConnection(mWindow);
            } //End block
            // ---------- Original Method ----------
            //final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
            //if (registered) {
                //mAttachInfo.mAccessibilityWindowId = View.NO_ID;
                //mAccessibilityManager.removeAccessibilityInteractionConnection(mWindow);
            //}
        }

        
    }


    
    static final class AccessibilityInteractionConnection extends IAccessibilityInteractionConnection.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.771 -0400", hash_original_field = "116A8D8AC04E6AC49EB407DCA6EEA4A9", hash_generated_field = "53CC87D794214F8DCA645D22E8A949F9")

        private WeakReference<ViewRootImpl> mRootImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.771 -0400", hash_original_method = "D539A7CCB822AF3CDF20BB7941121D94", hash_generated_method = "3B1B370109F8D6C40FF65F8AD31BE9A1")
          AccessibilityInteractionConnection(ViewRootImpl viewAncestor) {
            mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.771 -0400", hash_original_method = "EE5D719A51240BF55D02CDA16E5D3A9D", hash_generated_method = "869F0F5FE6FD9096834310B378A4FCC2")
        public void findAccessibilityNodeInfoByAccessibilityId(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interrogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(accessibilityId);
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if(viewRootImpl != null)            
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        interactionId, callback, interrogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        //interactionId, callback, interrogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.771 -0400", hash_original_method = "150D2C0671760B2C49B4A2BEA648BFF0", hash_generated_method = "0528CBA150AF5A162127EC59AA84A666")
        public void performAccessibilityAction(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(action);
            addTaint(accessibilityId);
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if(viewRootImpl != null)            
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            callback, interogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            //callback, interogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.771 -0400", hash_original_method = "480C93EC256597CABC1B248D841B9A3E", hash_generated_method = "C137A38428D2F92C6B77FFE7E3A18CA1")
        public void findAccessibilityNodeInfoByViewId(int viewId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interrogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(viewId);
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if(viewRootImpl != null)            
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            interrogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            //interrogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.772 -0400", hash_original_method = "9891EE3B36B5E5E829B36E62164827F4", hash_generated_method = "0BD9BEF99A951A7B96920000F8A7489B")
        public void findAccessibilityNodeInfosByViewText(String text, int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interrogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(accessibilityId);
            addTaint(text.getTaint());
            ViewRootImpl viewRootImpl = mRootImpl.get();
            if(viewRootImpl != null)            
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextClientThread(text, accessibilityId,
                            interactionId, callback, interrogatingPid, interrogatingTid);
            } //End block
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfosByViewTextClientThread(text, accessibilityId,
                            //interactionId, callback, interrogatingPid, interrogatingTid);
            //}
        }

        
    }


    
    final class AccessibilityInteractionController {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.772 -0400", hash_original_field = "C3E8C63735AAC0E72D6CCFDDE0328331", hash_generated_field = "2FD14E145489DD00A8E7926145DAD829")

        private ArrayList<AccessibilityNodeInfo> mTempAccessibilityNodeInfoList = new ArrayList<AccessibilityNodeInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.772 -0400", hash_original_field = "87ED3D57DB6E520DDD2EDF337ED05257", hash_generated_field = "38B485AE2AFC301A08861106EB06C4F1")

        private final Pool<SomeArgs> mPool = Pools.synchronizedPool(Pools.finitePool(
                new PoolableManager<SomeArgs>() {
                    public SomeArgs newInstance() {
                        return new SomeArgs();
                    }

                    public void onAcquired(SomeArgs info) {
                        
                    }

                    public void onReleased(SomeArgs info) {
                        info.clear();
                    }
                }, POOL_SIZE)
        );
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.772 -0400", hash_original_method = "AB87C85D23FC0F804AE52922F865B9CD", hash_generated_method = "AB87C85D23FC0F804AE52922F865B9CD")
        public AccessibilityInteractionController ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.773 -0400", hash_original_method = "2F6D3BCB232629523E59C738D4AD3A95", hash_generated_method = "95684B002C2F7CAC89BB1F10B9A07F51")
        public void findAccessibilityNodeInfoByAccessibilityIdClientThread(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interrogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(accessibilityId);
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID;
            message.arg1 = accessibilityId;
            message.arg2 = interactionId;
            message.obj = callback;
            if(interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId())            
            {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } //End block
            else
            {
                sendMessage(message);
            } //End block
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID;
            //message.arg1 = accessibilityId;
            //message.arg2 = interactionId;
            //message.obj = callback;
            //if (interrogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.773 -0400", hash_original_method = "145D07D178B3372CAAF2CB93D024125F", hash_generated_method = "F3C44BE9DA094054CB6C4C8EF43FD109")
        public void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
            addTaint(message.getTaint());
            final int accessibilityId = message.arg1;
            final int interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) message.obj;
            AccessibilityNodeInfo info = null;
            try 
            {
                View target = findViewByAccessibilityId(accessibilityId);
                if(target != null)                
                {
                    info = target.createAccessibilityNodeInfo();
                } //End block
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } //End block
                catch (RemoteException re)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //final int accessibilityId = message.arg1;
            //final int interactionId = message.arg2;
            //final IAccessibilityInteractionConnectionCallback callback =
                //(IAccessibilityInteractionConnectionCallback) message.obj;
            //AccessibilityNodeInfo info = null;
            //try {
                //View target = findViewByAccessibilityId(accessibilityId);
                //if (target != null) {
                    //info = target.createAccessibilityNodeInfo();
                //}
            //} finally {
                //try {
                    //callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                //} catch (RemoteException re) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.775 -0400", hash_original_method = "ADA0B35A4DB3EC9F459DCBB8D66C434D", hash_generated_method = "6C99524B3E392743966B0109E96FC5CE")
        public void findAccessibilityNodeInfoByViewIdClientThread(int viewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interrogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(viewId);
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID;
            message.arg1 = viewId;
            message.arg2 = interactionId;
            message.obj = callback;
            if(interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId())            
            {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } //End block
            else
            {
                sendMessage(message);
            } //End block
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID;
            //message.arg1 = viewId;
            //message.arg2 = interactionId;
            //message.obj = callback;
            //if (interrogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.775 -0400", hash_original_method = "6B2A3077FB5BC3E815A1727E6C950B5E", hash_generated_method = "D0EEA6185357E0DB95568EAF38E7B38B")
        public void findAccessibilityNodeInfoByViewIdUiThread(Message message) {
            addTaint(message.getTaint());
            final int viewId = message.arg1;
            final int interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) message.obj;
            AccessibilityNodeInfo info = null;
            try 
            {
                View root = ViewRootImpl.this.mView;
                View target = root.findViewById(viewId);
                if(target != null && target.getVisibility() == View.VISIBLE)                
                {
                    info = target.createAccessibilityNodeInfo();
                } //End block
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } //End block
                catch (RemoteException re)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //final int viewId = message.arg1;
            //final int interactionId = message.arg2;
            //final IAccessibilityInteractionConnectionCallback callback =
                //(IAccessibilityInteractionConnectionCallback) message.obj;
            //AccessibilityNodeInfo info = null;
            //try {
                //View root = ViewRootImpl.this.mView;
                //View target = root.findViewById(viewId);
                //if (target != null && target.getVisibility() == View.VISIBLE) {
                    //info = target.createAccessibilityNodeInfo();
                //}
            //} finally {
                //try {
                    //callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                //} catch (RemoteException re) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.776 -0400", hash_original_method = "74A990105163D5D10216C3B475062D28", hash_generated_method = "F328B3E94BEBD2459A6C433B0DF11772")
        public void findAccessibilityNodeInfosByViewTextClientThread(String text,
                int accessibilityViewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interrogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(accessibilityViewId);
            addTaint(text.getTaint());
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT;
            SomeArgs args = mPool.acquire();
            args.arg1 = text;
            args.argi1 = accessibilityViewId;
            args.argi2 = interactionId;
            args.arg2 = callback;
            message.obj = args;
            if(interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId())            
            {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } //End block
            else
            {
                sendMessage(message);
            } //End block
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT;
            //SomeArgs args = mPool.acquire();
            //args.arg1 = text;
            //args.argi1 = accessibilityViewId;
            //args.argi2 = interactionId;
            //args.arg2 = callback;
            //message.obj = args;
            //if (interrogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.777 -0400", hash_original_method = "51BC2DACC971DA52CB7F7912294499A7", hash_generated_method = "6D3BE2EDA042EB2BA9F1A3B964D887BB")
        public void findAccessibilityNodeInfosByViewTextUiThread(Message message) {
            addTaint(message.getTaint());
            SomeArgs args = (SomeArgs) message.obj;
            final String text = (String) args.arg1;
            final int accessibilityViewId = args.argi1;
            final int interactionId = args.argi2;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) args.arg2;
            mPool.release(args);
            List<AccessibilityNodeInfo> infos = null;
            try 
            {
                ArrayList<View> foundViews = mAttachInfo.mFocusablesTempList;
                foundViews.clear();
                View root = null;
                if(accessibilityViewId != View.NO_ID)                
                {
                    root = findViewByAccessibilityId(accessibilityViewId);
                } //End block
                else
                {
                    root = ViewRootImpl.this.mView;
                } //End block
                if(root == null || root.getVisibility() != View.VISIBLE)                
                {
                    return;
                } //End block
                root.findViewsWithText(foundViews, text, View.FIND_VIEWS_WITH_TEXT
                        | View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                if(foundViews.isEmpty())                
                {
                    return;
                } //End block
                infos = mTempAccessibilityNodeInfoList;
                infos.clear();
                final int viewCount = foundViews.size();
for(int i = 0;i < viewCount;i++)
                {
                    View foundView = foundViews.get(i);
                    if(foundView.getVisibility() == View.VISIBLE)                    
                    {
                        infos.add(foundView.createAccessibilityNodeInfo());
                    } //End block
                } //End block
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfosResult(infos, interactionId);
                } //End block
                catch (RemoteException re)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.780 -0400", hash_original_method = "10A09FD4DC34F1BE42EB309D47EC9715", hash_generated_method = "27129AC796AC4A949AD3FBFC7320F76F")
        public void performAccessibilityActionClientThread(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            addTaint(interrogatingTid);
            addTaint(interogatingPid);
            addTaint(callback.getTaint());
            addTaint(interactionId);
            addTaint(action);
            addTaint(accessibilityId);
            Message message = Message.obtain();
            message.what = DO_PERFORM_ACCESSIBILITY_ACTION;
            SomeArgs args = mPool.acquire();
            args.argi1 = accessibilityId;
            args.argi2 = action;
            args.argi3 = interactionId;
            args.arg1 = callback;
            message.obj = args;
            if(interogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId())            
            {
                message.setTarget(ViewRootImpl.this);
                AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            } //End block
            else
            {
                sendMessage(message);
            } //End block
            // ---------- Original Method ----------
            //Message message = Message.obtain();
            //message.what = DO_PERFORM_ACCESSIBILITY_ACTION;
            //SomeArgs args = mPool.acquire();
            //args.argi1 = accessibilityId;
            //args.argi2 = action;
            //args.argi3 = interactionId;
            //args.arg1 = callback;
            //message.obj = args;
            //if (interogatingPid == Process.myPid()
                    //&& interrogatingTid == Looper.getMainLooper().getThread().getId()) {
                //message.setTarget(ViewRootImpl.this);
                //AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
            //} else {
                //sendMessage(message);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.782 -0400", hash_original_method = "B5557005BEFFE1DA9F706439FD376D18", hash_generated_method = "27CDB1B19CD534B9D485ABB2C1D2A79C")
        public void perfromAccessibilityActionUiThread(Message message) {
            addTaint(message.getTaint());
            SomeArgs args = (SomeArgs) message.obj;
            final int accessibilityId = args.argi1;
            final int action = args.argi2;
            final int interactionId = args.argi3;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) args.arg1;
            mPool.release(args);
            boolean succeeded = false;
            try 
            {
switch(action){
                case AccessibilityNodeInfo.ACTION_FOCUS:
                {
                    succeeded = performActionFocus(accessibilityId);
                } //End block
                break;
                case AccessibilityNodeInfo.ACTION_CLEAR_FOCUS:
                {
                    succeeded = performActionClearFocus(accessibilityId);
                } //End block
                break;
                case AccessibilityNodeInfo.ACTION_SELECT:
                {
                    succeeded = performActionSelect(accessibilityId);
                } //End block
                break;
                case AccessibilityNodeInfo.ACTION_CLEAR_SELECTION:
                {
                    succeeded = performActionClearSelection(accessibilityId);
                } //End block
                break;
}
            } //End block
            finally 
            {
                try 
                {
                    callback.setPerformAccessibilityActionResult(succeeded, interactionId);
                } //End block
                catch (RemoteException re)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.782 -0400", hash_original_method = "0DF709A77C91001270CD6D5BCBC66D0E", hash_generated_method = "FF54A3D2BDE28CB68B27603C7E332A33")
        private boolean performActionFocus(int accessibilityId) {
            addTaint(accessibilityId);
            View target = findViewByAccessibilityId(accessibilityId);
            if(target == null || target.getVisibility() != View.VISIBLE)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1559898140 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654699486 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654699486;
            } //End block
            ensureTouchMode(false);
            boolean var9B0BCCDFA6520FE87D90E781D98F88CB_978150256 = (target.requestFocus());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698693403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698693403;
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //ensureTouchMode(false);
            //return target.requestFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.783 -0400", hash_original_method = "7E9614B48F5F4EC29BCF64D3A075976C", hash_generated_method = "8C18343BD02DF8F3D81986F70849539D")
        private boolean performActionClearFocus(int accessibilityId) {
            addTaint(accessibilityId);
            View target = findViewByAccessibilityId(accessibilityId);
            if(target == null || target.getVisibility() != View.VISIBLE)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1879926364 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337004532 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337004532;
            } //End block
            if(!target.isFocused())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1706397267 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996787401 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996787401;
            } //End block
            target.clearFocus();
            boolean var997EF5D3AFAC3534DDA1029D1CBDB41D_772149147 = (!target.isFocused());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1863841187 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1863841187;
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //if (!target.isFocused()) {
                //return false;
            //}
            //target.clearFocus();
            //return !target.isFocused();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.783 -0400", hash_original_method = "AB7AA9516F9E78D5A5AD4BBEB80A41A0", hash_generated_method = "E3794A0E991ED76E48D177BCD74A7743")
        private boolean performActionSelect(int accessibilityId) {
            addTaint(accessibilityId);
            View target = findViewByAccessibilityId(accessibilityId);
            if(target == null || target.getVisibility() != View.VISIBLE)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1905030621 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1236920241 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1236920241;
            } //End block
            if(target.isSelected())            
            {
                boolean var68934A3E9455FA72420237EB05902327_564722851 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115519646 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115519646;
            } //End block
            target.setSelected(true);
            boolean var17C54E64DF78CAC09E89999E75A4523F_938317789 = (target.isSelected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1443049308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1443049308;
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //if (target.isSelected()) {
                //return false;
            //}
            //target.setSelected(true);
            //return target.isSelected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.784 -0400", hash_original_method = "E102B39F5DF94C3320BE2ED1E2D3B323", hash_generated_method = "29F4715B969364BBF4886E6266CADDB2")
        private boolean performActionClearSelection(int accessibilityId) {
            addTaint(accessibilityId);
            View target = findViewByAccessibilityId(accessibilityId);
            if(target == null || target.getVisibility() != View.VISIBLE)            
            {
                boolean var68934A3E9455FA72420237EB05902327_697641478 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190583893 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_190583893;
            } //End block
            if(!target.isSelected())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1565579054 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585676676 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_585676676;
            } //End block
            target.setSelected(false);
            boolean var3429767672DCF8500B2A7598DBF0FF10_829145867 = (!target.isSelected());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2005927968 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2005927968;
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //if (!target.isSelected()) {
                //return false;
            //}
            //target.setSelected(false);
            //return !target.isSelected();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_method = "B9D971669B3F873AC0D1B0C38F7811F4", hash_generated_method = "45B34E263CF5D482BD01D4FD8D399842")
        private View findViewByAccessibilityId(int accessibilityId) {
            addTaint(accessibilityId);
            View root = ViewRootImpl.this.mView;
            if(root == null)            
            {
View var540C13E9E156B687226421B24F2DF178_544342650 =                 null;
                var540C13E9E156B687226421B24F2DF178_544342650.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_544342650;
            } //End block
            View foundView = root.findViewByAccessibilityId(accessibilityId);
            if(foundView != null && foundView.getVisibility() != View.VISIBLE)            
            {
View var540C13E9E156B687226421B24F2DF178_1100166343 =                 null;
                var540C13E9E156B687226421B24F2DF178_1100166343.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1100166343;
            } //End block
View varC924E529DE927E973A786678D4C8F00A_66690485 =             foundView;
            varC924E529DE927E973A786678D4C8F00A_66690485.addTaint(taint);
            return varC924E529DE927E973A786678D4C8F00A_66690485;
            // ---------- Original Method ----------
            //View root = ViewRootImpl.this.mView;
            //if (root == null) {
                //return null;
            //}
            //View foundView = root.findViewByAccessibilityId(accessibilityId);
            //if (foundView != null && foundView.getVisibility() != View.VISIBLE) {
                //return null;
            //}
            //return foundView;
        }

        
        public class SomeArgs implements Poolable<SomeArgs> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "DA4F0B9DBC6F4431600CE5D0AA462E29")

            private SomeArgs mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")

            public Object arg1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

            public Object arg2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "45EA0AE08E2E96F45B382FC093F32969", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

            public int argi1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "AD47A7F028721D8AB76072E225148A71", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

            public int argi2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.785 -0400", hash_original_field = "14D7B84204F2BD6B05340ABF4F0B2AAB", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

            public int argi3;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
            public SomeArgs ()
            {
                //Synthesized constructor
            }


                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "BEE0522D727ED0DB1FBC81A3E3B176C5", hash_generated_method = "0D5BAB706DB4310D85BA6B5228916FEE")
            public SomeArgs getNextPoolable() {
SomeArgs varA29C6A1F0F29A0F3732076BE541D5DCD_57083093 =                 mNext;
                varA29C6A1F0F29A0F3732076BE541D5DCD_57083093.addTaint(taint);
                return varA29C6A1F0F29A0F3732076BE541D5DCD_57083093;
                // ---------- Original Method ----------
                //return mNext;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "A12C02F0BC8529BE33CF43F5D92BDD44")
            public boolean isPooled() {
                boolean var224D05F4261498DA1D9DF38424832532_1975761918 = (mIsPooled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995345498 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995345498;
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "B595989EA0DDF2662B95D2584CF9AF77", hash_generated_method = "F4A2EC156C0A86672F5B936336F0364D")
            public void setNextPoolable(SomeArgs args) {
                mNext = args;
                // ---------- Original Method ----------
                //mNext = args;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
                        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "95D0476EAE9CBD3221945617281C6DDB", hash_generated_method = "316EB695B735DFEA458AF811F180A884")
            private void clear() {
                arg1 = null;
                arg2 = null;
                argi1 = 0;
                argi2 = 0;
                argi3 = 0;
                // ---------- Original Method ----------
                //arg1 = null;
                //arg2 = null;
                //argi1 = 0;
                //argi2 = 0;
                //argi3 = 0;
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_field = "C2E05B03A1E5A4773797E14A5759FDE0", hash_generated_field = "9C5EE85F599ECE1BA2255910141DCB18")

        private static final int POOL_SIZE = 5;
    }


    
    private class SendWindowContentChangedAccessibilityEvent implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_field = "AD12063E8FC163523FAE892D8D8BEA2B", hash_generated_field = "8E5087238AE27D181E6487D7D8E8CADB")

        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "22B280316CE346FC3EE6EA7A3C31108C", hash_generated_method = "22B280316CE346FC3EE6EA7A3C31108C")
        public SendWindowContentChangedAccessibilityEvent ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.786 -0400", hash_original_method = "3411919DDECDF923DB080425515AE494", hash_generated_method = "4EA98F068549172EC2CA7E8973919575")
        public void run() {
            if(mView != null)            
            {
                mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
                mIsPending = false;
            } //End block
            // ---------- Original Method ----------
            //if (mView != null) {
                //mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
                //mIsPending = false;
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "7E6EF6CA984A814E54DEF53937367AEC", hash_generated_field = "20A0B237EA7FED0897D15F2C9A434731")

    private static final String TAG = "ViewRootImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "AAFDAF871858750A211AC8DBE6D1B76E", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "81BC73E608D026D04E3B0D79ED385A75", hash_generated_field = "971AF06B9A1B36F9E637DA19FBC7C8E8")

    private static final boolean DEBUG_DRAW = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "E7914D46191772C2DFC3082FA07C5113", hash_generated_field = "CB8EB2CBBD50573AA52874C3C657F261")

    private static final boolean DEBUG_LAYOUT = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "3E9B61D7306485C1EBF46DD64F93002F", hash_generated_field = "8EA22DB3A605D961CEA3CCDA576DF97D")

    private static final boolean DEBUG_DIALOG = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "6954DCA4F52EB3F7707E23BA3AAB73BF", hash_generated_field = "A5F9DE67F8CD98CB6CDB329B70C684A4")

    private static final boolean DEBUG_INPUT_RESIZE = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "01E2E972D69F91A7F53036A4BA38B963", hash_generated_field = "23E83E11FDABB85CB4C188C31B75DA5C")

    private static final boolean DEBUG_ORIENTATION = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "89BD8CB6EDCD2701549EC23413AED997", hash_generated_field = "77EE0AA06B23769B780A309B393E32FA")

    private static final boolean DEBUG_TRACKBALL = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "70989F0A550BD62CC84D8B650E71E267", hash_generated_field = "7B7C0ECBA08420BBFAB103815EABD246")

    private static final boolean DEBUG_IMF = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "13D8941946EC6485CACF79D87C642394", hash_generated_field = "E7DDC8C264C9F86DB032DBB6CABC2709")

    private static final boolean DEBUG_CONFIGURATION = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "1EFCDC73DAE6A5FD924B8DD06B5F556D", hash_generated_field = "A0CF8EE94CFC62F1428857DCF5542F88")

    private static final boolean DEBUG_FPS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "FEC45B2BB71B7194F717163B3BA5CC82", hash_generated_field = "5FA7473017ED5A2E46DB49A8BFC34BE9")

    private static final boolean WATCH_POINTER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "1DF900DD37598133E05CC46EE5C93B83", hash_generated_field = "3A883DE2B0B67773D8F82B7654B7D004")

    private static final String PROPERTY_PROFILE_RENDERING = "viewancestor.profile_rendering";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "C0BC221229095D032C888D69A46129BE", hash_generated_field = "E5342F079514828E15AB01F9FA97BF6C")

    private static final boolean MEASURE_LATENCY = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "D91AF6958918AF87D6A057C1CDF5B225", hash_generated_field = "4C70E88FDA504CF3924879E0993C2C35")

    private static LatencyTimer lt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "18E551674F4F8BCF0D1B014EC1FFE225", hash_generated_field = "B0C223721AEEA6A8D58BAE0775580384")

    static final int MAX_TRACKBALL_DELAY = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "844A08A1319C1FF73C67A1955AE19000", hash_generated_field = "CE60587CF2EE3A6FA7BC23F1967EFA78")

    static IWindowSession sWindowSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "F85483633A397D700D9550D630F94703", hash_generated_field = "906814A8DD92904364CC348726E82FDF")

    static final Object mStaticInit = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "536734E2DD91AB5EDF1F3B60AFB40B7C")

    static boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "BEFFC6565DC1CA41B1B9BCD8BAFC0608", hash_generated_field = "B17B98FA673511F1A0E4D0FB5118C35F")

    static final ThreadLocal<RunQueue> sRunQueues = new ThreadLocal<RunQueue>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "88C55A175576611D1262F4DEB603DD11", hash_generated_field = "B99793B7C0D11503969031E3D368FFEC")

    static final ArrayList<Runnable> sFirstDrawHandlers = new ArrayList<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "417B1AC24707509FE1229159D5D2FD6A", hash_generated_field = "63BD0028405F2577A6800DED464B8A3B")

    static boolean sFirstDrawComplete = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "55AB80B80BF4397CA994CF036DDAA729", hash_generated_field = "7E01A30DB4DBEA8BAA84FC6A8EA8B318")

    static final ArrayList<ComponentCallbacks> sConfigCallbacks = new ArrayList<ComponentCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "580B9D5636F3C1BAD99EA0DA732D0ACB", hash_generated_field = "347C4ECD6969CCE8F943EAB38DB0079A")

    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "E824FF2BAD31069ED6F0ED3D10172F45", hash_generated_field = "3EB90E2F993B9CB287747FD7EEEF5D90")

    public final static int DO_TRAVERSAL = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "1C5BB561E88C8BE5FAFEE0790C955B81", hash_generated_field = "F0BCA4B075D24D0FF66A6916CC127271")

    public final static int DIE = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "459694EAE0AFBDCF7F5FE59E926751AC", hash_generated_field = "EA01F9146001F93DF12B6DD8FF81CC53")

    public final static int RESIZED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "FD1224F49B0BF6E289BE701A8A4B6B60", hash_generated_field = "AB61E328C1E2634C736F13E407311D18")

    public final static int RESIZED_REPORT = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "9DF5EC78475F54E37A56BEC42BEB1D2A", hash_generated_field = "2FD8D787B807B4EE2C688EC81CAD354C")

    public final static int WINDOW_FOCUS_CHANGED = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "61E6CA8CFDD30043CF5371A303A21611", hash_generated_field = "46BC1AB0B59868BC1AC272F074AD853B")

    public final static int DISPATCH_KEY = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "B756EB713FDD7EBFEC40D507E44BA7DD", hash_generated_field = "CFCFDFB572BC4BDCA1471B291D10B9FE")

    public final static int DISPATCH_POINTER = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "76D47D386450074FBF1E818F21242699", hash_generated_field = "D9F532C1428B70D44A71437836C78C0B")

    public final static int DISPATCH_TRACKBALL = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.787 -0400", hash_original_field = "4A72F41D34459CE79383884522ECCAE4", hash_generated_field = "FA67D6D19432E9CAFFF018FDFFC4D8E2")

    public final static int DISPATCH_APP_VISIBILITY = 1008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "476162F3CD411E58F30414F1566B6652", hash_generated_field = "1CD05315E6CF2B4F64EBB262782DA709")

    public final static int DISPATCH_GET_NEW_SURFACE = 1009;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "6E0B574D9F9C9940E785731CC021CE12", hash_generated_field = "A872A4B58863DDD392F65C30D22E6818")

    public final static int FINISHED_EVENT = 1010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "1F337768A4463FBDA713A52511B04E2A", hash_generated_field = "8F58AD3EA7EA7BCABB230C363AF6864D")

    public final static int DISPATCH_KEY_FROM_IME = 1011;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "83000FF7A8A5ECC49BD31658E6C66783", hash_generated_field = "0E2AE4E9BC35AB1C012C9D523F2DB54F")

    public final static int FINISH_INPUT_CONNECTION = 1012;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "0A5C035A6EDFB84A087A5F4C20A6D073", hash_generated_field = "89F79CCE1AF9647DEE46375D53A1C760")

    public final static int CHECK_FOCUS = 1013;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "6B4348D5AABB4767CEE45424C7BB84F6", hash_generated_field = "222999CFB72FB7D242E23460229012C5")

    public final static int CLOSE_SYSTEM_DIALOGS = 1014;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "F6DDF0332FBE95DE04649B3D12340F93", hash_generated_field = "4B576476AE6F6AA4611FDC7AEC60C475")

    public final static int DISPATCH_DRAG_EVENT = 1015;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "D8BE14C1FE01569A265642416EC01D8E", hash_generated_field = "B771249D49FABB56D119E90358FD2BFB")

    public final static int DISPATCH_DRAG_LOCATION_EVENT = 1016;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "52125BABF3FB5DCE0C3580064D8E0637", hash_generated_field = "63FAB3F2B47509EA62E2799705C2C615")

    public final static int DISPATCH_SYSTEM_UI_VISIBILITY = 1017;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "9BCBF8FCAD1A7BD6C0D47AB48F0B1416", hash_generated_field = "E0183864301CE37CAD6F15B696A751C5")

    public final static int DISPATCH_GENERIC_MOTION = 1018;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "9CCCF62492CC6FA2FCD717AA4551C7BC", hash_generated_field = "90DC4C76E6F79F810FC476C28E742912")

    public final static int UPDATE_CONFIGURATION = 1019;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "3B1C3A24166215F6F9EF105C321E49DD", hash_generated_field = "A5F752869EC9ED93776BAA0EEBD6A03B")

    public final static int DO_PERFORM_ACCESSIBILITY_ACTION = 1020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "08CF04FD26A46FE6CD65B60B90CFE644", hash_generated_field = "4D02D16C0FBA008C4C6CA5ABF6F0455F")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID = 1021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "9B9999530EF0733C7E023792A6AD9019", hash_generated_field = "29168F52297DC460BEBF7B0492E61AB6")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID = 1022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "085AF99B529699074495D41497EE7822", hash_generated_field = "3D3A76CBE28044195F427274AA43966C")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:47.788 -0400", hash_original_field = "39890F94B1CD9459F4EB95642DD3836A", hash_generated_field = "70877CF2932D34884120E6D77E84ADE5")

    public final static int PROCESS_INPUT_EVENTS = 1024;
}

