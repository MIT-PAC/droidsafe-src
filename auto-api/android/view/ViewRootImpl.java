package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "9FB8722C5639B6B2D197FB488F8BB7B1", hash_generated_field = "843FBE1A9F9CBF827094CA7CF070DBDE")

    long mLastTrackballTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "2B60F4783E50055B6531781826673342", hash_generated_field = "8405ACA924158429D7DAF509E106E80E")

    final TrackballAxis mTrackballAxisX = new TrackballAxis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "7C147ECFA14972FC5351B85686A43DC6", hash_generated_field = "E58AB91B5ACFBE3D4FB913472293F77A")

    final TrackballAxis mTrackballAxisY = new TrackballAxis();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "DA607F1FD199037ED5097D2149AAA2B8", hash_generated_field = "1F6F035B05518F799CC4A631830DEA24")

    int mLastJoystickXDirection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "F688B5DE04C2BC837F48B8E4887F918D", hash_generated_field = "FAD79A20871B99E6C09DCA8C579054AF")

    int mLastJoystickYDirection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "CCCFAD6BEACBCB767770713431A278CC", hash_generated_field = "008A164762C8272B4BD8A8FAE6C0E3A7")

    int mLastJoystickXKeyCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "5D2609CBCF4FB4C283F7493B7E076C84", hash_generated_field = "70296AF28AFADF018D48568A1EC7CDC1")

    int mLastJoystickYKeyCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "4BC786D43E92B4BEDC23ACC8C07672C0", hash_generated_field = "192CBA0F154C36DD2A24DDE2AD97DD40")

    final int[] mTmpLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "161FA5687A7D7AC4B9C9A80AF829FBD9", hash_generated_field = "F4896FA60EAF46F89D1B23DB39A94469")

    final TypedValue mTmpValue = new TypedValue();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "F506AF951DDADDB13AB99733DA5C81D8", hash_generated_field = "B902B282F1853C48591AA333FC5C6930")

    InputMethodCallback mInputMethodCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "F0B2281F6B06E2C5558D41AAD03EB9CB", hash_generated_field = "598B68B7DF6E876D9AF774185C389FF7")

    final SparseArray<Object> mPendingEvents = new SparseArray<Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "64EE0AB7FC4C5BD8F8AA06BB346EBFCD", hash_generated_field = "8504A7AA7F77E97847E07EE0E13DD89E")

    int mPendingEventSeq = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "8CE20653889294789C714060A391C40F")

    Thread mThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "36AEE7DB2B3FEF907E8DF98C14332655", hash_generated_field = "F0FFEA60326B2D639F57F2EAC1D83F2E")

    WindowLeaked mLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "5A8DDBFFB48FB5038CAE7BDFEFA84A3A", hash_generated_field = "FBA586EC47BBF8235BA69538A45A084C")

    final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "17DBBC35D1D58356620B06871EA80682")

    W mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "62D22558492391EE18A59E61D13DF59B", hash_generated_field = "B8EEE6865DFA2D11E19D316E427BCF57")

    int mTargetSdkVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "8913F44A11D4302ED7B203F0CF0BA11B")

    int mSeq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "F8D40828BB6C29B3FC912398E721F9E4", hash_generated_field = "A476C52E6AE87C5E9FAFA76F8149063E")

    View mFocusedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "263E0B76878C860DE84233A41BC0016F", hash_generated_field = "3DC22EE5DBB3E6E14C770C4103F10EB9")

    View mRealFocusedView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "96660D25AF9DB923A87425CCE07A5A95", hash_generated_field = "6F90E9BEC145DE5BCF5865F1869A8817")

    int mViewVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "7C431AA37BCFA92BDB40DEDC3EAC95F6", hash_generated_field = "CBD2E44BCC5B5ECBFE52241EEB9711C5")

    boolean mAppVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "E743A0BAB0ED12D120CA433EEA8B537F", hash_generated_field = "0AEB888D275C51C81ED076AFA9DC9522")

    int mOrigWindowType = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "8CCD825644680C613E93DCA15E2DC7DC", hash_generated_field = "80618C8C8672F89E380C28D4E4CF2CB6")

    boolean mStopped = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.013 -0400", hash_original_field = "6387A3D856A63A2AD73C8C9FC21DD388", hash_generated_field = "23B6B29357EB27D126E7D0E5137E40A2")

    boolean mLastInCompatMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "53874A648990BC9189119A03E709B8A9", hash_generated_field = "D3FE6DB201CFE61D34745A493F584192")

    SurfaceHolder.Callback2 mSurfaceHolderCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "81860DC8C5AA6AEFA5F2B79E06C56A49", hash_generated_field = "F864CA3F05AD6C8A628535B131A61BBF")

    BaseSurfaceHolder mSurfaceHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "0E2361D9DC5F8ED2D80C3189D2E3EE01", hash_generated_field = "8F301FBCF4999017F75CC0B716F2517E")

    boolean mIsCreating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "0822D4118140B9899091B78395995296", hash_generated_field = "31E39D3D4E66A5056EAD95BE27A3903C")

    boolean mDrawingAllowed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "6F7C2ABB1A4FE62E56F6B6EC8E8EBFC2", hash_generated_field = "C0C52C8769544E33D239458B4880FB79")

    Region mTransparentRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "CB41328D3239692AD26CC8CEC7EA02B7", hash_generated_field = "6DD5B69EF744EC321638C5B663EA67C0")

    Region mPreviousTransparentRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "A3DB1626A190732E588FD0D14FC8FB31", hash_generated_field = "AF6410B200BC05DCA2CF0BE65165448A")

    int mWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "483542B05A951AA16D89C7F809C20811", hash_generated_field = "7DDAE255893B528E7BEBEC203BC2D9F3")

    int mHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "76D7D73778AD0C3E9D57E6A56AEDF738", hash_generated_field = "E76116A4E1D56F9ACB236AA480F07D5C")

    Rect mDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "37730831ED21F3ED3D8D3D4010E8939D", hash_generated_field = "7D059A3482DA1107B4225C068EC3B96C")

    final Rect mCurrentDirty = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "D2034914CD1C91DF53E95B41AD3A026A", hash_generated_field = "27F620C09DF5AF3A58C0B01A44A71C88")

    final Rect mPreviousDirty = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "A81D486C7031EC82F0DD218A6FB06245", hash_generated_field = "97BCAC515A131331E06C789507755EE7")

    boolean mIsAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "D30D964DEC107E6D034DC2A2CB80EA28", hash_generated_field = "A237DD2C3AA1799B8037D96788707A83")

    CompatibilityInfo.Translator mTranslator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "B1A49FF62D92BCD8AE5C70F97D680510", hash_generated_field = "86473EE91D5723F9F75E2A56F39C84CF")

    View.AttachInfo mAttachInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "C24CAB0CD635949A89D283C9B1D6E3B2", hash_generated_field = "19DDA5FF34DEE6F036F3E0F6D18E8BCF")

    InputChannel mInputChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "4C0768DE09E1813B3CA03AA187B50C3E", hash_generated_field = "BF4123EFADD525416DF2ECCC683CF87D")

    InputQueue.Callback mInputQueueCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "E211911F07DE1C0E219865F6EE524326", hash_generated_field = "214B662EBB0919E92BC2DA7797C68593")

    InputQueue mInputQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "7389C8F86B7D2B4FBCD7A6DFA85E64A4", hash_generated_field = "45AD45F5DD34AE4545398CF3CECF17C4")

    FallbackEventHandler mFallbackEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "B856E02779DE10EA84221FCD1182A1A3", hash_generated_field = "9F1BD97088B2257F3EF12D8B258FBB69")

    Rect mTempRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "17A1D92354A641BBDCCF8626DAEC1345", hash_generated_field = "75DE7B8E36E8E0070CF83B97AE3C5ADD")

    Rect mVisRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "84C921D46AB1AE020C78FA0054A37992", hash_generated_field = "5CAC89A6B43ECD32B0872A407087A6F4")

    boolean mTraversalScheduled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "BA8CB8DD5FC64D4CBDC965EED503DF10", hash_generated_field = "EB355C7A896FD8B8387186109992F2B8")

    long mLastTraversalFinishedTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "1B0095C8C9CCD6630BF56AB8B690BFD1", hash_generated_field = "C8304D699838C82BC498F4723E240C1F")

    long mLastDrawDurationNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "66D724D804CEE3D3CDFA5CEB8F590D53", hash_generated_field = "345D78977A28AFF99B79AE805D352734")

    boolean mWillDrawSoon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "ED91C157C05E401358FF44C4420F25D8", hash_generated_field = "48AB4660010DD29E688C29E9BF84B71B")

    boolean mLayoutRequested;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "ECAEBEC6BB782BEA13F3E7E1E2E20C36", hash_generated_field = "562F659A65CBB4A1A6DBAAFE4E932885")

    boolean mFirst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "51F1A68CA6419C547A7FC4D19875727A", hash_generated_field = "2977B3A45EA900C6A3042BD62F95188E")

    boolean mReportNextDraw;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "42D47128B1CC1E1CF45B3EEF3812B5C5", hash_generated_field = "DAF006AD70DDF288E744168F840824B7")

    boolean mFullRedrawNeeded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "2A00A465430A75857B0A3E7F16924D01", hash_generated_field = "F4C0F083E90A29856957BA6D1DDAED83")

    boolean mNewSurfaceNeeded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "23B72EC0285F5B24CD2688A42BB92034", hash_generated_field = "5F83D526A3FA8B2F4898EDD5EF0E2A3A")

    boolean mHasHadWindowFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "B1654BA812658AE2CAC4E8DE7C39A73C", hash_generated_field = "2ABCD72F1C5FD8723FE1304A4714716F")

    boolean mLastWasImTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "6AB0E48DFAFE78320455EAA4F7F74832", hash_generated_field = "F8F7FAB20882F1D392651D5DEC2E7327")

    InputEventMessage mPendingInputEvents = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "8E1CD3EAC4AACECC2DB5ED0102F14E57", hash_generated_field = "06BBA4AD1FBDA3B0B33CE36EFE1027EA")

    boolean mWindowAttributesChanged = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "6C9CE9DA8E36B853987265BA98EB99F3", hash_generated_field = "546953AC84915AC28C8B7DAF9502F5E5")

    int mWindowAttributesChangesFlag = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "F9AB9D95165B53F1F9A8EA582223EE4E")

    private final Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "29AFB5DC7D4AAD5CD9E8254338F52F08", hash_generated_field = "3272EA4F55AF2134E76D819B48B053D5")

    boolean mAddedTouchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "27C9B400936470E0D86B9AA2CDF3AED4", hash_generated_field = "5EAC126C193FC41ACB184C1D10F2C250")

    CompatibilityInfoHolder mCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "15F4BBB64D636278834545B7F4E2C47C", hash_generated_field = "4FAA064DF54D7CC2DBADC1DAB51471A6")

    int mAddNesting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "5AB326DBD4F2418E1C70019D5FE2E9E8", hash_generated_field = "79F142AE0DEC957F939DD6F49191F7DA")

    Rect mWinFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "DC58415BE393FFE45C7379968D07F03C", hash_generated_field = "D7BF56D7D1AA140BE857C621B183EA1F")

    final Rect mPendingVisibleInsets = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "43939E34AD094B79CC29455B4656BD89", hash_generated_field = "1B6C360B3EA1E6006390DB0BE53A7892")

    final Rect mPendingContentInsets = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "ECC65560EF31D2DB1799F5C14EEAFA7A", hash_generated_field = "3ECCDFE4A47C5AABC0FEC62DB447749A")

    final ViewTreeObserver.InternalInsetsInfo mLastGivenInsets = new ViewTreeObserver.InternalInsetsInfo();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "08DB6ABADAC97CB9632E1F54B9A7669B", hash_generated_field = "34376B54378B9B3D43FDDE460CA57C87")

    final Configuration mLastConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "316EF42C37A6359FA90E8EB8163158FD", hash_generated_field = "8DF7E1052933D1F73177C1BFC385AA74")

    final Configuration mPendingConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "DFF428E4D0E1C2EF7455DC5BF527B4A0", hash_generated_field = "F73A2E8B0FBF1242431CC31A3DD9702B")

    boolean mScrollMayChange;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "33E2F9EB615FA3DC117548E2AB4E3CB8", hash_generated_field = "CF8B89DFEF5F4625A0C19FC1D32C3421")

    int mSoftInputMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "7C464F8694B05041AFB58885DA000588", hash_generated_field = "7D8A0E0CD7FFB1F73E763DA6C4667A4E")

    View mLastScrolledFocus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "4ABBFD585ECE4FE40BECD8E0C30C4E5E", hash_generated_field = "EC6AD52CC705AA3985B25CDB13E68426")

    int mScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "4E0E149B23ABE221D2EDBEA643C6A2D9", hash_generated_field = "565D20E48244C9362550DBB0B49B53BB")

    int mCurScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "16226695B3E75E1B75AD8C16FE7698DB")

    Scroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.014 -0400", hash_original_field = "5C66C74E599CCAEE2E860C595DB5E3B9", hash_generated_field = "F55691E21802586D78CD6F9FD51B171A")

    HardwareLayer mResizeBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "4BD630B1466E79D64E5FF79ACF9E8172", hash_generated_field = "69E5E6DEA9BA26DB325DFF8EBCCC1A06")

    long mResizeBufferStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "201B3310C28F7E7F5D41E09AB658F61A", hash_generated_field = "43B2C18D48C325F81780B31D87D0EC3F")

    int mResizeBufferDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "EAEC9E1DC504AA33FAEE1754B9E6C2E6", hash_generated_field = "A493757D2D083CF70CF0156B7D650811")

    private ArrayList<LayoutTransition> mPendingTransitions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "72AA02F8181FBA74DCEB8E5DAFCB11D1", hash_generated_field = "ABA78699C698034369F90645C9496674")

    ViewConfiguration mViewConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "8608A99B6E89C2555B396A625012580E", hash_generated_field = "CC0FC278B71622219C45AD52C9FB53C8")

    ClipDescription mDragDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "3DDC2DD80BBDAAFF3D7748437C0F92DB", hash_generated_field = "025092BC7B1A6638564A2FBB4D620E8D")

    View mCurrentDragView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "3B3A215548FF8C27E628B48C3E7FAF73", hash_generated_field = "7D186346EFCB228BBC632C710813F06A")

    volatile Object mLocalDragState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "B14068A442685E0109118ED262F29150", hash_generated_field = "C40BD10C38FBF577696C33E32B5A5F15")

    final PointF mDragPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "D31662568CF1A3E94E597074D8A0BA65", hash_generated_field = "CEA70AEA2380B8689249771FEECDD683")

    final PointF mLastTouchPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "429F074741C37582EBA166C2E096303A", hash_generated_field = "2A75F6FAF247C6A563147144451919B0")

    private boolean mProfileRendering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "CC7DDE7BC68056B1485F45767EDBE40A", hash_generated_field = "2967540D832074C93AFE31D56D615C87")

    private Thread mRenderProfiler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "560CE8A7AFD95647E11E51470AD892CE", hash_generated_field = "F1ABF1663FFD4FAD46EB136874019F65")

    private volatile boolean mRenderProfilingEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "488242DCDD6F32D36158D6036C7B7B00", hash_generated_field = "AE62D52D470E5307BF23FF4D57A005B1")

    private long mFpsStartTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "531EFF915955FD6ECB4AB5C999E11FCC", hash_generated_field = "4B09966683DBC242A92E84CFC3759305")

    private long mFpsPrevTime = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "FDAB8945A474B114D638198C883D5706", hash_generated_field = "500CC8C8BBFEA70158BD5B319AA9473F")

    private int mFpsNumFrames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "DC563AE6C758BE979A84432D84FFAC40", hash_generated_field = "81931559493F052ED78BA000FD1BC717")

    AudioManager mAudioManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "7F1B3F6A6E334A72020206E0E9A4FF92", hash_generated_field = "2467CDF4E5E89FDAF3ABD83B3362838B")

    AccessibilityManager mAccessibilityManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "F9D67EE332FEFEABE6FCE029947A296F", hash_generated_field = "326964F84FEA789C7EA69B5AD84D099B")

    AccessibilityInteractionController mAccessibilityInteractionController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "22FE57590D994BD53ACBA88A13C1D432", hash_generated_field = "1EE07D7B37AEA69E13942B821067B159")

    AccessibilityInteractionConnectionManager mAccessibilityInteractionConnectionManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "47DEF5F55071FA14EADD51CCA34A7B60", hash_generated_field = "ED6865A95E9BDB4B92489EC925B4337E")

    SendWindowContentChangedAccessibilityEvent mSendWindowContentChangedAccessibilityEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "174BB9FF4691CBE6254BA90AE9FA0B63", hash_generated_field = "CB41FCB74021FD4BA0B8B886D751AB3B")

    private int mDensity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "FBF46F0211B74BEC9C47C5EFFAF36A72")

    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "F0D5A808F49DE0DFBB2EBC21349D60F9", hash_generated_field = "93DCF807A0C07D048164002C3BB5DC84")

    private boolean mProfile = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "2DAA81707CC3223C543DA09460FE0B5F", hash_generated_field = "771F3E0240CB2201808586E811799152")

    int mHardwareYOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "9097CFC01E63EBE4150B17671D27D895", hash_generated_field = "43FB9582B41438DE11C8033508791B9A")

    int mResizeAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "C3D947F17C54D1EB736DB694E6D1F8D2", hash_generated_field = "7840CC47EC1E67F4E118E7172F117D39")

    final Paint mResizePaint = new Paint();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "67423D5E67ED1443D33F13C001525444", hash_generated_field = "7265E6F2381DF6B2AD9FD72699DAD27A")

    private long mInputEventReceiveTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "AA3C6B1620E27E0B9FA892D045F064D2", hash_generated_field = "B12640E94E9B6FC4860989B653C215E6")

    private long mInputEventDeliverTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "1FFA08FA13CD0C201A131759BEE8CAD7", hash_generated_field = "F589D3B75D0D824F988415EE16A4D910")

    private long mInputEventDeliverPostImeTimeNanos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.015 -0400", hash_original_field = "E00B3A1621C501CDA1A76EB46C5AA0E7", hash_generated_field = "FA48E12ED3D38101FA265C33F8B4EB33")

    private InputQueue.FinishedCallback mFinishedCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_field = "18C98C39E8D3C77B924AFC1D76DB38D1", hash_generated_field = "10425C1D99C9B3E146C1BBB81040F9EF")

    private final InputHandler mInputHandler = new InputHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_method = "DA8B85C0B97B283164189BFC107A0C51", hash_generated_method = "FF89E1B449B2A3760D958F63C22C8E1D")
        public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback) {
            startInputEvent(finishedCallback);
            dispatchKey(event, true);
            addTaint(event.getTaint());
            addTaint(finishedCallback.getTaint());
            // ---------- Original Method ----------
            //startInputEvent(finishedCallback);
            //dispatchKey(event, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.016 -0400", hash_original_method = "BA251C4BE7EEF8348B6DA839AE6C5F99", hash_generated_method = "6D32680B0C65B263C80F930005E38CDC")
        public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
            startInputEvent(finishedCallback);
            dispatchMotion(event, true);
            addTaint(event.getTaint());
            addTaint(finishedCallback.getTaint());
            // ---------- Original Method ----------
            //startInputEvent(finishedCallback);
            //dispatchMotion(event, true);
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_field = "09A95A1FC3FF30F6E7CF942F1FC6A265", hash_generated_field = "99F32DA5E56A393932E6EDF801E99038")

    private SurfaceHolder mHolder = new SurfaceHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "13BADEA14E6A49BCC17141EB1CC9ABAB")
        public Surface getSurface() {
            Surface varB4EAC82CA7396A68D541C85D26508E83_1564047814 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1564047814 = mSurface;
            varB4EAC82CA7396A68D541C85D26508E83_1564047814.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1564047814;
            // ---------- Original Method ----------
            //return mSurface;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "111414E0BC27432A58777D8D7A8A5313", hash_generated_method = "404CE96BADDBDD106E676659F86D0C86")
        public boolean isCreating() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116664615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_116664615;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "1534EBA7EE38BC120F6309F5A1B3FF9E", hash_generated_method = "1D39A8EC720482719F771CC26E2A5136")
        public void addCallback(Callback callback) {
            addTaint(callback.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.017 -0400", hash_original_method = "1D7F6566A3906AFA0AB54EE06949ABBB", hash_generated_method = "4529A5CE4ECB0918530466545BD7FADC")
        public void removeCallback(Callback callback) {
            addTaint(callback.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "0FF9F7AB4B875AE8A0C5A8C3535F85C8", hash_generated_method = "D84D02E4950B7C76C7CC605634C9A5E7")
        public void setFixedSize(int width, int height) {
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "0794758F1C90C59C5D7A2C0BDE8FAA38", hash_generated_method = "2283705EABC76CCAA7D98B4015CCD0EC")
        public void setSizeFromLayout() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "CF1EA2FC05AD6DEBDFA26DEE8FD9DB43", hash_generated_method = "7A8B1BC0D08BE1C3FCDE74335C415748")
        public void setFormat(int format) {
            addTaint(format);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.018 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "F16672983FBE594CFFF27796E8300DE9")
        public void setType(int type) {
            addTaint(type);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.019 -0400", hash_original_method = "46E48CC06FE228B4151C3D83F1499F0C", hash_generated_method = "2B4B08250D222564E5F449F984CD77F8")
        public void setKeepScreenOn(boolean screenOn) {
            addTaint(screenOn);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.020 -0400", hash_original_method = "3082759B8090FD86F4392C9CC2C4FBD0", hash_generated_method = "42B586D14B6CE5A0CCC956C7A302F059")
        public Canvas lockCanvas() {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_949446256 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_949446256 = null;
            varB4EAC82CA7396A68D541C85D26508E83_949446256.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_949446256;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "3E84C9B445B974E90BE60751B0E8F5B3", hash_generated_method = "E3CA96D4EA0FD882850C6F6D5D588F7B")
        public Canvas lockCanvas(Rect dirty) {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_1552549708 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1552549708 = null;
            addTaint(dirty.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1552549708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1552549708;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "398534786B4B68CC68F8CE8B2E298404", hash_generated_method = "069FC062D6BD12CF8E4DC29D8D01209E")
        public void unlockCanvasAndPost(Canvas canvas) {
            addTaint(canvas.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.021 -0400", hash_original_method = "0458ACEC2C801E19AE11DF373ED70BEE", hash_generated_method = "C1182B7EEE68E099E2C5404841EDF4EE")
        public Rect getSurfaceFrame() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1346833247 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1346833247 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1346833247.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1346833247;
            // ---------- Original Method ----------
            //return null;
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.022 -0400", hash_original_method = "30AB3DC3CF45F6460C1B2C84DB6BEEC3", hash_generated_method = "BD6504AA85A44CC2EBEB29811B3B3866")
    public  ViewRootImpl(Context context) {
        super();
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.024 -0400", hash_original_method = "CC8B7F3C56C4BD3E79E20E40E6BC7183", hash_generated_method = "B1C47515DF4380EC2E00EEA4CF22D73A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.025 -0400", hash_original_method = "41A7A71F10D2AEAE23E30A793138BBB4", hash_generated_method = "823C05F6DFE7BFB4B1CC58AEE3639795")
    public void setView(View view, WindowManager.LayoutParams attrs, View panelParentView) {
        {
            {
                mView = view;
                mFallbackEventHandler.setView(view);
                mWindowAttributes.copyFrom(attrs);
                attrs = mWindowAttributes;
                {
                    mSurfaceHolderCallback =
                            ((RootViewSurfaceTaker)view).willYouTakeTheSurface();
                    {
                        mSurfaceHolder = new TakenSurfaceHolder();
                        mSurfaceHolder.setFormat(PixelFormat.UNKNOWN);
                    } //End block
                } //End block
                CompatibilityInfo compatibilityInfo = mCompatibilityInfo.get();
                mTranslator = compatibilityInfo.getTranslator();
                {
                    enableHardwareAcceleration(attrs);
                } //End block
                boolean restore = false;
                {
                    mSurface.setCompatibilityTranslator(mTranslator);
                    restore = true;
                    attrs.backup();
                    mTranslator.translateWindowLayout(attrs);
                } //End block
                Log.d(TAG, "WindowLayout in setView:" + attrs);
                {
                    boolean var2EEA59713A247080EA419945AB126FA8_612661561 = (!compatibilityInfo.supportsScreen());
                    {
                        attrs.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                        mLastInCompatMode = true;
                    } //End block
                } //End collapsed parenthetic
                mSoftInputMode = attrs.softInputMode;
                mWindowAttributesChanged = true;
                mWindowAttributesChangesFlag = WindowManager.LayoutParams.EVERYTHING_CHANGED;
                mAttachInfo.mRootView = view;
                mAttachInfo.mScalingRequired = mTranslator != null;
                mAttachInfo.mApplicationScale =
                        mTranslator == null ? 1.0f : mTranslator.applicationScale;
                {
                    mAttachInfo.mPanelParentWindowToken
                            = panelParentView.getApplicationWindowToken();
                } //End block
                mAdded = true;
                int res;
                requestLayout();
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
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Adding window failed", e);
                } //End block
                finally 
                {
                    {
                        attrs.restore();
                    } //End block
                } //End block
                {
                    mTranslator.translateRectInScreenToAppWindow(mAttachInfo.mContentInsets);
                } //End block
                mPendingContentInsets.set(mAttachInfo.mContentInsets);
                mPendingVisibleInsets.set(0, 0, 0, 0);
                {
                    mView = null;
                    mAttachInfo.mRootView = null;
                    mAdded = false;
                    mFallbackEventHandler.setView(null);
                    unscheduleTraversals();
                    //Begin case WindowManagerImpl.ADD_BAD_APP_TOKEN WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not valid; is your activity running?");
                    //End case WindowManagerImpl.ADD_BAD_APP_TOKEN WindowManagerImpl.ADD_BAD_SUBWINDOW_TOKEN 
                    //Begin case WindowManagerImpl.ADD_NOT_APP_TOKEN 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- token " + attrs.token
                                + " is not for an application");
                    //End case WindowManagerImpl.ADD_NOT_APP_TOKEN 
                    //Begin case WindowManagerImpl.ADD_APP_EXITING 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- app for token " + attrs.token
                                + " is exiting");
                    //End case WindowManagerImpl.ADD_APP_EXITING 
                    //Begin case WindowManagerImpl.ADD_DUPLICATE_ADD 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window -- window " + mWindow
                                + " has already been added");
                    //End case WindowManagerImpl.ADD_DUPLICATE_ADD 
                    //Begin case WindowManagerImpl.ADD_MULTIPLE_SINGLETON 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- another window of this type already exists");
                    //End case WindowManagerImpl.ADD_MULTIPLE_SINGLETON 
                    //Begin case WindowManagerImpl.ADD_PERMISSION_DENIED 
                    if (DroidSafeAndroidRuntime.control) throw new WindowManagerImpl.BadTokenException(
                                "Unable to add window " + mWindow +
                                " -- permission denied for this window type");
                    //End case WindowManagerImpl.ADD_PERMISSION_DENIED 
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to add window -- unknown error code " + res);
                } //End block
                {
                    mInputQueueCallback =
                        ((RootViewSurfaceTaker)view).willYouTakeTheInputQueue();
                } //End block
                {
                    {
                        mInputQueue = new InputQueue(mInputChannel);
                        mInputQueueCallback.onInputQueueCreated(mInputQueue);
                    } //End block
                    {
                        InputQueue.registerInputChannel(mInputChannel, mInputHandler,
                                Looper.myQueue());
                    } //End block
                } //End block
                view.assignParent(this);
                mAddedTouchMode = (res&WindowManagerImpl.ADD_FLAG_IN_TOUCH_MODE) != 0;
                mAppVisible = (res&WindowManagerImpl.ADD_FLAG_APP_VISIBLE) != 0;
                {
                    boolean var9FA688D7A8792CFDE0FE1059C3B8F748_1689043978 = (mAccessibilityManager.isEnabled());
                    {
                        mAccessibilityInteractionConnectionManager.ensureConnection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.026 -0400", hash_original_method = "CB86722DA8E467DDCEDA5A630CA3194B", hash_generated_method = "1D180D346267FF4FD734E09DF4803A3B")
     void destroyHardwareResources() {
        {
            {
                boolean var4CC7CC042FB1A0B872228C316C872BB4_80227409 = (mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    mAttachInfo.mHardwareRenderer.destroyLayers(mView);
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.026 -0400", hash_original_method = "E3F9E04A5716D71423EBE08431EEB223", hash_generated_method = "80B1CB47DAD8C3CC1A3F0A3833BB55F1")
     void terminateHardwareResources() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.026 -0400", hash_original_method = "E840B8B43E5ABE6BE2D8F4EA2D3CA2C1", hash_generated_method = "A7888002E0258337C684D23974349152")
     void destroyHardwareLayers() {
        {
            boolean varAB6333097DFD9DC250CE668EF24070FA_1900998902 = (mThread != Thread.currentThread());
            {
                {
                    boolean var4E18E42BE327D8168CEC924FF750FE04_2045396110 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                    {
                        HardwareRenderer.trimMemory(ComponentCallbacks2.TRIM_MEMORY_MODERATE);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var4E18E42BE327D8168CEC924FF750FE04_1968718290 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                    {
                        mAttachInfo.mHardwareRenderer.destroyLayers(mView);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.027 -0400", hash_original_method = "645D4C027059B67B04B5E1D1CDD7444E", hash_generated_method = "07B836B0434617B5E1D7D87A010F526B")
    private void enableHardwareAcceleration(WindowManager.LayoutParams attrs) {
        mAttachInfo.mHardwareAccelerated = false;
        mAttachInfo.mHardwareAccelerationRequested = false;
        final boolean hardwareAccelerated = (attrs.flags & WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED) != 0;
        {
            {
                boolean varEAF487A08F9D7C7E236198761FEC371F_588737440 = (!HardwareRenderer.isAvailable());
            } //End collapsed parenthetic
            final boolean fakeHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATED) != 0;
            final boolean forceHwAccelerated = (attrs.privateFlags &
                    WindowManager.LayoutParams.PRIVATE_FLAG_FORCE_HARDWARE_ACCELERATED) != 0;
            {
                {
                    boolean var902B8BD79FA592FACE1DE1F2E5EEDD20_1938603955 = (!HardwareRenderer.sSystemRendererDisabled
                        && Looper.getMainLooper() != Looper.myLooper());
                } //End collapsed parenthetic
                final boolean translucent = attrs.format != PixelFormat.OPAQUE;
                {
                    mAttachInfo.mHardwareRenderer.destroy(true);
                } //End block
                mAttachInfo.mHardwareRenderer = HardwareRenderer.createGlRenderer(2, translucent);
                mAttachInfo.mHardwareAccelerated = mAttachInfo.mHardwareAccelerationRequested
                        = mAttachInfo.mHardwareRenderer != null;
            } //End block
            {
                mAttachInfo.mHardwareAccelerationRequested = true;
            } //End block
        } //End block
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.028 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "03A8AABC5B6938420897250301477AD6")
    public View getView() {
        View varB4EAC82CA7396A68D541C85D26508E83_693826588 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_693826588 = mView;
        varB4EAC82CA7396A68D541C85D26508E83_693826588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_693826588;
        // ---------- Original Method ----------
        //return mView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.029 -0400", hash_original_method = "6C3085A5B27688C16B5F48D71E61D048", hash_generated_method = "F5FA82C0BF9B8D25CB2E152F3147F61B")
    final WindowLeaked getLocation() {
        WindowLeaked varB4EAC82CA7396A68D541C85D26508E83_1798947947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1798947947 = mLocation;
        varB4EAC82CA7396A68D541C85D26508E83_1798947947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1798947947;
        // ---------- Original Method ----------
        //return mLocation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.030 -0400", hash_original_method = "344B8CEF50FED73B6C66A984FDFE543C", hash_generated_method = "26920344B21720A3E5447F56DBF791CF")
     void setLayoutParams(WindowManager.LayoutParams attrs, boolean newView) {
        {
            int oldSoftInputMode = mWindowAttributes.softInputMode;
            int compatibleWindowFlag = mWindowAttributes.flags & WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
            mWindowAttributesChangesFlag = mWindowAttributes.copyFrom(attrs);
            mWindowAttributes.flags |= compatibleWindowFlag;
            {
                mSoftInputMode = attrs.softInputMode;
                requestLayout();
            } //End block
            {
                mWindowAttributes.softInputMode = (mWindowAttributes.softInputMode
                        & ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST)
                        | (oldSoftInputMode
                                & WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST);
            } //End block
            mWindowAttributesChanged = true;
            scheduleTraversals();
        } //End block
        addTaint(newView);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.032 -0400", hash_original_method = "F0FE5EE4E253DD8DC552809A1CA2533F", hash_generated_method = "BB3F58BEB7E98A222CAA6A06EADD2204")
     void handleAppVisibility(boolean visible) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.032 -0400", hash_original_method = "18299B4078E7C7C61849ACAFD8526C89", hash_generated_method = "BB6EAB3409F9822032460A2B78E57E8C")
     void handleGetNewSurface() {
        mNewSurfaceNeeded = true;
        mFullRedrawNeeded = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //mNewSurfaceNeeded = true;
        //mFullRedrawNeeded = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.033 -0400", hash_original_method = "A2905530B195FBB19B3C3F0AC663BF20", hash_generated_method = "B4F533FE3D3C8C28D85C11EA8103DD14")
    public void requestLayout() {
        checkThread();
        mLayoutRequested = true;
        scheduleTraversals();
        // ---------- Original Method ----------
        //checkThread();
        //mLayoutRequested = true;
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.033 -0400", hash_original_method = "13F945759D2C310C5D0BB68B6FB1E2B8", hash_generated_method = "F42D1EB9DCFCA8A713EDB14D86B0A8E3")
    public boolean isLayoutRequested() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770965368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_770965368;
        // ---------- Original Method ----------
        //return mLayoutRequested;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.034 -0400", hash_original_method = "1BB28848D4C8EEFEA34E8E46FE6AC5D5", hash_generated_method = "C63FBBE87EF829972EFB178200985C1D")
    public void invalidateChild(View child, Rect dirty) {
        checkThread();
        {
            invalidate();
        } //End block
        {
            mTempRect.set(dirty);
            dirty = mTempRect;
            {
                dirty.offset(0, -mCurScrollY);
            } //End block
            {
                mTranslator.translateRectInAppWindowToScreen(dirty);
            } //End block
            {
                dirty.inset(-1, -1);
            } //End block
        } //End block
        {
            boolean varEF86BD19BDAC3E37812F85F40921C01A_457964745 = (!mDirty.isEmpty() && !mDirty.contains(dirty));
            {
                mAttachInfo.mSetIgnoreDirtyState = true;
                mAttachInfo.mIgnoreDirtyState = true;
            } //End block
        } //End collapsed parenthetic
        mDirty.union(dirty);
        {
            scheduleTraversals();
        } //End block
        addTaint(child.getTaint());
        addTaint(dirty.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.034 -0400", hash_original_method = "813AAD1E42CFCCC731AB301BBB74FC18", hash_generated_method = "C9B69269B05104AFF802002D325AD2DE")
     void invalidate() {
        mDirty.set(0, 0, mWidth, mHeight);
        scheduleTraversals();
        // ---------- Original Method ----------
        //mDirty.set(0, 0, mWidth, mHeight);
        //scheduleTraversals();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.034 -0400", hash_original_method = "081DD37813B858E5AB3FA0820EF5D835", hash_generated_method = "BE38183A7C56A195F6DCD32502016493")
     void setStopped(boolean stopped) {
        {
            mStopped = stopped;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.035 -0400", hash_original_method = "DCC308262D5800610A000228CF8970A4", hash_generated_method = "A40FBF3A0AAFE3ABD2C5BCB3C996382E")
    public ViewParent getParent() {
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_1909148550 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1909148550 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1909148550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1909148550;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.035 -0400", hash_original_method = "67B0199062309B0E78F2F88E3E2AD59A", hash_generated_method = "7C1CCB9105BBF9733363C241274ED21F")
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_604813224 = null; //Variable for return #1
        invalidateChild(null, dirty);
        varB4EAC82CA7396A68D541C85D26508E83_604813224 = null;
        addTaint(location[0]);
        addTaint(dirty.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_604813224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_604813224;
        // ---------- Original Method ----------
        //invalidateChild(null, dirty);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.036 -0400", hash_original_method = "FB92C76BB083D5DC37740C978F02B71C", hash_generated_method = "21B479C3216D255129C3C8D4134BF4AD")
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("child is not mine, honest!");
        } //End block
        boolean var3C447C15080EDED58EBDD084A72DF38D_2119530550 = (r.intersect(0, 0, mWidth, mHeight));
        addTaint(child.getTaint());
        addTaint(r.getTaint());
        addTaint(offset.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1828226747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1828226747;
        // ---------- Original Method ----------
        //if (child != mView) {
            //throw new RuntimeException("child is not mine, honest!");
        //}
        //return r.intersect(0, 0, mWidth, mHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.036 -0400", hash_original_method = "57451ED91AC07EA69FA21499971D2B45", hash_generated_method = "AC406F6D5A6EF83824A653E030726C19")
    public void bringChildToFront(View child) {
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.036 -0400", hash_original_method = "0E9A2AD60F5B60B1A096C27CF046877D", hash_generated_method = "D58052B3480BF2F2C4B731BD3F111731")
    public void scheduleTraversals() {
        {
            mTraversalScheduled = true;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.037 -0400", hash_original_method = "0B26D78664F51D8793A6008ECDA459E7", hash_generated_method = "BFA015F92D16949DEB22819F36EBF3B3")
    public void unscheduleTraversals() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.037 -0400", hash_original_method = "27A276950AD49DC3B2BCAC57214867E1", hash_generated_method = "97B7C815E69A717C721A25A1FC862E23")
     int getHostVisibility() {
        {
            Object var8D6CE5BDBC311FE3B049ABF0D70214FD_1278847309 = (mView.getVisibility());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758689112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_758689112;
        // ---------- Original Method ----------
        //return mAppVisible ? mView.getVisibility() : View.GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.038 -0400", hash_original_method = "4A37F94A433BB0C51ABAD4CD2013B711", hash_generated_method = "0B7B046B5B1C7C45D8B416132FB9272C")
     void disposeResizeBuffer() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.038 -0400", hash_original_method = "9CCD20C4D5BE58E51524A629AA69C9DE", hash_generated_method = "0DF6062487C1984FBA1C767D9D54E9AA")
    public void requestTransitionStart(LayoutTransition transition) {
        {
            boolean var194FCB9DF54F69E97F56CE68C10354D0_1625449915 = (mPendingTransitions == null || !mPendingTransitions.contains(transition));
            {
                {
                    mPendingTransitions = new ArrayList<LayoutTransition>();
                } //End block
                mPendingTransitions.add(transition);
            } //End block
        } //End collapsed parenthetic
        addTaint(transition.getTaint());
        // ---------- Original Method ----------
        //if (mPendingTransitions == null || !mPendingTransitions.contains(transition)) {
            //if (mPendingTransitions == null) {
                 //mPendingTransitions = new ArrayList<LayoutTransition>();
            //}
            //mPendingTransitions.add(transition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.039 -0400", hash_original_method = "E06FBD8158D133D090EB34C23F0C9FD1", hash_generated_method = "8A15759E0BF045870F855B9C02867206")
    private void processInputEvents(boolean outOfOrder) {
        {
            handleMessage(mPendingInputEvents.mMessage);
            InputEventMessage tmpMessage = mPendingInputEvents;
            mPendingInputEvents = mPendingInputEvents.mNext;
            tmpMessage.recycle();
            {
                removeMessages(PROCESS_INPUT_EVENTS);
            } //End block
        } //End block
        addTaint(outOfOrder);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.236 -0400", hash_original_method = "DF10FEADFB061504FA9A2B620C341C55", hash_generated_method = "E39C760F8BFD22578B65FF82E91CFE01")
    private void performTraversals() {
        final View host = mView;
        processInputEvents(true);
        {
            System.out.println("======================================");
            System.out.println("performTraversals");
            host.debug();
        } //End block
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
        {
            mWindowAttributesChanged = false;
            surfaceChanged = true;
            params = lp;
        } //End block
        CompatibilityInfo compatibilityInfo = mCompatibilityInfo.get();
        {
            boolean var0A004AC3811C18545614B32625CEEC49_1894747257 = (compatibilityInfo.supportsScreen() == mLastInCompatMode);
            {
                params = lp;
                fullRedrawNeeded = true;
                mLayoutRequested = true;
                {
                    params.flags &= ~WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    mLastInCompatMode = false;
                } //End block
                {
                    params.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                    mLastInCompatMode = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        mWindowAttributesChangesFlag = 0;
        Rect frame = mWinFrame;
        {
            fullRedrawNeeded = true;
            mLayoutRequested = true;
            {
                Display disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                Point size = new Point();
                disp.getRealSize(size);
                desiredWindowWidth = size.x;
                desiredWindowHeight = size.y;
            } //End block
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
        {
            desiredWindowWidth = frame.width();
            desiredWindowHeight = frame.height();
            {
                fullRedrawNeeded = true;
                mLayoutRequested = true;
                windowSizeMayChange = true;
            } //End block
        } //End block
        {
            attachInfo.mWindowVisibility = viewVisibility;
            host.dispatchWindowVisibilityChanged(viewVisibility);
            {
                destroyHardwareResources();
            } //End block
            {
                mHasHadWindowFocus = false;
            } //End block
        } //End block
        boolean insetsChanged = false;
        {
            getRunQueue().executeActions(attachInfo.mHandler);
            final Resources res = mView.getContext().getResources();
            {
                mAttachInfo.mInTouchMode = !mAddedTouchMode;
                ensureTouchModeLocally(mAddedTouchMode);
            } //End block
            {
                {
                    boolean var62033EA88707C143C01D8EAFE9900154_462162374 = (!mPendingContentInsets.equals(mAttachInfo.mContentInsets));
                    {
                        insetsChanged = true;
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var0CAA9A1F030432324CBF6F78F99C9DD7_1304827491 = (!mPendingVisibleInsets.equals(mAttachInfo.mVisibleInsets));
                    {
                        mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                    } //End block
                } //End collapsed parenthetic
                {
                    windowSizeMayChange = true;
                    {
                        Display disp = WindowManagerImpl.getDefault().getDefaultDisplay();
                        Point size = new Point();
                        disp.getRealSize(size);
                        desiredWindowWidth = size.x;
                        desiredWindowHeight = size.y;
                    } //End block
                    {
                        DisplayMetrics packageMetrics = res.getDisplayMetrics();
                        desiredWindowWidth = packageMetrics.widthPixels;
                        desiredWindowHeight = packageMetrics.heightPixels;
                    } //End block
                } //End block
            } //End block
            boolean goodMeasure = false;
            {
                final DisplayMetrics packageMetrics = res.getDisplayMetrics();
                res.getValue(com.android.internal.R.dimen.config_prefDialogWidth, mTmpValue, true);
                int baseSize = 0;
                {
                    baseSize = (int)mTmpValue.getDimension(packageMetrics);
                } //End block
                {
                    childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                    childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                    host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    {
                        boolean var21D962C086164386A94062CBCB36B58F_1936765932 = ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0);
                        {
                            goodMeasure = true;
                        } //End block
                        {
                            baseSize = (baseSize+desiredWindowWidth)/2;
                            childWidthMeasureSpec = getRootMeasureSpec(baseSize, lp.width);
                            host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                            {
                                boolean var9F98C604F7D547E03F47254F3D22799F_1715640138 = ((host.getMeasuredWidthAndState()&View.MEASURED_STATE_TOO_SMALL) == 0);
                                {
                                    goodMeasure = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                childWidthMeasureSpec = getRootMeasureSpec(desiredWindowWidth, lp.width);
                childHeightMeasureSpec = getRootMeasureSpec(desiredWindowHeight, lp.height);
                host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                {
                    boolean varDF7BF5380028FDCE8B63C5F6F1205021_728232367 = (mWidth != host.getMeasuredWidth() || mHeight != host.getMeasuredHeight());
                    {
                        windowSizeMayChange = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                System.out.println("======================================");
                System.out.println("performTraversals -- after measure");
                host.debug();
            } //End block
        } //End block
        {
            attachInfo.mRecomputeGlobalAttributes = false;
            boolean oldScreenOn = attachInfo.mKeepScreenOn;
            int oldVis = attachInfo.mSystemUiVisibility;
            boolean oldHasSystemUiListeners = attachInfo.mHasSystemUiListeners;
            attachInfo.mKeepScreenOn = false;
            attachInfo.mSystemUiVisibility = 0;
            attachInfo.mHasSystemUiListeners = false;
            host.dispatchCollectViewAttributes(0);
            {
                params = lp;
            } //End block
        } //End block
        {
            attachInfo.mForceReportNewAttributes = false;
            params = lp;
        } //End block
        {
            attachInfo.mViewVisibilityChanged = false;
            int resizeMode = mSoftInputMode &
                    WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST;
            {
                final int N = attachInfo.mScrollContainers.size();
                {
                    int i = 0;
                    {
                        {
                            boolean varA64E9739EA7F01D5D1160845BAD0386A_246074724 = (attachInfo.mScrollContainers.get(i).isShown());
                            {
                                resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    resizeMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
                } //End block
                {
                    lp.softInputMode = (lp.softInputMode &
                            ~WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST) |
                            resizeMode;
                    params = lp;
                } //End block
            } //End block
        } //End block
        {
            {
                boolean var124397EC8E035E35B1B90F57C49E8065_659677130 = (!PixelFormat.formatHasAlpha(params.format));
                {
                    params.format = PixelFormat.TRANSLUCENT;
                } //End block
            } //End collapsed parenthetic
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
        {
            {
                insetsPending = computesInternalInsets && (mFirst || viewVisibilityChanged);
            } //End block
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
                {
                    fl = params.flags;
                    {
                        params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                    } //End block
                    params.subtreeSystemUiVisibility = attachInfo.mSystemUiVisibility;
                    params.hasSystemUiListeners = attachInfo.mHasSystemUiListeners;
                } //End block
                final int surfaceGenerationId = mSurface.getGenerationId();
                relayoutResult = relayoutWindow(params, viewVisibility, insetsPending);
                {
                    params.flags = fl;
                } //End block
                {
                    updateConfiguration(mPendingConfiguration, !mFirst);
                    mPendingConfiguration.seq = 0;
                } //End block
                contentInsetsChanged = !mPendingContentInsets.equals(
                        mAttachInfo.mContentInsets);
                visibleInsetsChanged = !mPendingVisibleInsets.equals(
                        mAttachInfo.mVisibleInsets);
                {
                    {
                        boolean var1E0539E09B573A600F6F1CFEAFBE4679_1332565360 = (mWidth > 0 && mHeight > 0 &&
                            mSurface != null && mSurface.isValid() &&
                            !mAttachInfo.mTurnOffWindowResizeAnim &&
                            mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled() &&
                            mAttachInfo.mHardwareRenderer.validate() &&
                            lp != null && !PixelFormat.formatHasAlpha(lp.format));
                        {
                            disposeResizeBuffer();
                            boolean completed = false;
                            HardwareCanvas hwRendererCanvas = mAttachInfo.mHardwareRenderer.getCanvas();
                            HardwareCanvas layerCanvas = null;
                            try 
                            {
                                {
                                    mResizeBuffer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                                        mWidth, mHeight, false);
                                } //End block
                                {
                                    boolean var3E6D8158ACA9AC4B059634A10A6CF6F6_860403515 = (mResizeBuffer.getWidth() != mWidth ||
                                    mResizeBuffer.getHeight() != mHeight);
                                    {
                                        mResizeBuffer.resize(mWidth, mHeight);
                                    } //End block
                                } //End collapsed parenthetic
                                layerCanvas = mResizeBuffer.start(hwRendererCanvas);
                                layerCanvas.setViewport(mWidth, mHeight);
                                layerCanvas.onPreDraw(null);
                                final int restoreCount = layerCanvas.save();
                                layerCanvas.drawColor(0xff000000, PorterDuff.Mode.SRC);
                                int yoff;
                                final boolean scrolling = mScroller != null
                                    && mScroller.computeScrollOffset();
                                {
                                    yoff = mScroller.getCurrY();
                                    mScroller.abortAnimation();
                                } //End block
                                {
                                    yoff = mScrollY;
                                } //End block
                                layerCanvas.translate(0, -yoff);
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
                            { }
                            finally 
                            {
                                {
                                    layerCanvas.onPostDraw();
                                } //End block
                                {
                                    mResizeBuffer.end(hwRendererCanvas);
                                    {
                                        mResizeBuffer.destroy();
                                        mResizeBuffer = null;
                                    } //End block
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    mAttachInfo.mContentInsets.set(mPendingContentInsets);
                    host.fitSystemWindows(mAttachInfo.mContentInsets);
                } //End block
                {
                    mAttachInfo.mVisibleInsets.set(mPendingVisibleInsets);
                } //End block
                {
                    {
                        boolean var85F0101842CACF01F09324AA7EC986C7_1679107765 = (mSurface.isValid());
                        {
                            newSurface = true;
                            fullRedrawNeeded = true;
                            mPreviousTransparentRegion.setEmpty();
                            {
                                try 
                                {
                                    hwInitialized = mAttachInfo.mHardwareRenderer.initialize(mHolder);
                                } //End block
                                catch (Surface.OutOfResourcesException e)
                                {
                                    try 
                                    {
                                        {
                                            boolean varDF4C39F3C79070D8F8930AEFD74A46C5_821022582 = (!sWindowSession.outOfMemory(mWindow));
                                            {
                                                Process.killProcess(Process.myPid());
                                            } //End block
                                        } //End collapsed parenthetic
                                    } //End block
                                    catch (RemoteException ex)
                                    { }
                                    mLayoutRequested = true;
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean var223FE8BD2DC3BE69B6019B00E048EE0C_1737153451 = (!mSurface.isValid());
                    {
                        mLastScrolledFocus = null;
                        mScrollY = mCurScrollY = 0;
                        {
                            mScroller.abortAnimation();
                        } //End block
                        disposeResizeBuffer();
                        {
                            boolean var750EE654262A2705CF0E4AE4A63530E4_235521900 = (mAttachInfo.mHardwareRenderer != null &&
                            mAttachInfo.mHardwareRenderer.isEnabled());
                            {
                                mAttachInfo.mHardwareRenderer.destroy(true);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        boolean varA621B9B0F4C63EC9228FD0CAB33867BD_429367387 = (surfaceGenerationId != mSurface.getGenerationId() &&
                        mSurfaceHolder == null && mAttachInfo.mHardwareRenderer != null);
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
                                    {
                                        boolean var6D55857E69BE616DA2387C824B8B58FA_1660385141 = (!sWindowSession.outOfMemory(mWindow));
                                        {
                                            Process.killProcess(Process.myPid());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                catch (RemoteException ex)
                                { }
                                mLayoutRequested = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            catch (RemoteException e)
            { }
            attachInfo.mWindowLeft = frame.left;
            attachInfo.mWindowTop = frame.top;
            mWidth = frame.width();
            mHeight = frame.height();
            {
                {
                    boolean var0D8FEFF8FF7B19DB704450AA7E0BA173_1050569292 = (mSurface.isValid());
                    {
                        mSurfaceHolder.mSurface = mSurface;
                    } //End block
                } //End collapsed parenthetic
                mSurfaceHolder.setSurfaceFrameSize(mWidth, mHeight);
                mSurfaceHolder.mSurfaceLock.unlock();
                {
                    boolean var0D8FEFF8FF7B19DB704450AA7E0BA173_1569360065 = (mSurface.isValid());
                    {
                        {
                            mSurfaceHolder.ungetCallbacks();
                            mIsCreating = true;
                            mSurfaceHolderCallback.surfaceCreated(mSurfaceHolder);
                            SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                            {
                                {
                                    SurfaceHolder.Callback c = callbacks[0];
                                    {
                                        c.surfaceCreated(mSurfaceHolder);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            surfaceChanged = true;
                        } //End block
                        {
                            mSurfaceHolderCallback.surfaceChanged(mSurfaceHolder,
                                lp.format, mWidth, mHeight);
                            SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                            {
                                {
                                    SurfaceHolder.Callback c = callbacks[0];
                                    {
                                        c.surfaceChanged(mSurfaceHolder, lp.format,
                                        mWidth, mHeight);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                        mIsCreating = false;
                    } //End block
                    {
                        mSurfaceHolder.ungetCallbacks();
                        SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                        mSurfaceHolderCallback.surfaceDestroyed(mSurfaceHolder);
                        {
                            {
                                SurfaceHolder.Callback c = callbacks[0];
                                {
                                    c.surfaceDestroyed(mSurfaceHolder);
                                } //End block
                            } //End collapsed parenthetic
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
                } //End collapsed parenthetic
            } //End block
            {
                boolean varCD2E6CE6A1CFB30D773CBD0CD1B5DD28_1280886522 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    {
                        boolean var68BE6CA5337B3E1A6C30D35C34420F08_1410267786 = (hwInitialized || windowShouldResize ||
                        mWidth != mAttachInfo.mHardwareRenderer.getWidth() ||
                        mHeight != mAttachInfo.mHardwareRenderer.getHeight());
                        {
                            mAttachInfo.mHardwareRenderer.setup(mWidth, mHeight);
                            {
                                mAttachInfo.mHardwareRenderer.invalidate(mHolder);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean focusChangedDueToTouchMode = ensureTouchModeLocally(
                        (relayoutResult&WindowManagerImpl.RELAYOUT_RES_IN_TOUCH_MODE) != 0);
                {
                    boolean varA6DAF762C1B830FF995EE7E2238847D5_285590153 = (focusChangedDueToTouchMode || mWidth != host.getMeasuredWidth()
                        || mHeight != host.getMeasuredHeight() || contentInsetsChanged);
                    {
                        childWidthMeasureSpec = getRootMeasureSpec(mWidth, lp.width);
                        childHeightMeasureSpec = getRootMeasureSpec(mHeight, lp.height);
                        host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        int width = host.getMeasuredWidth();
                        int height = host.getMeasuredHeight();
                        boolean measureAgain = false;
                        {
                            width += (int) ((mWidth - width) * lp.horizontalWeight);
                            childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width,
                                MeasureSpec.EXACTLY);
                            measureAgain = true;
                        } //End block
                        {
                            height += (int) ((mHeight - height) * lp.verticalWeight);
                            childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                                MeasureSpec.EXACTLY);
                            measureAgain = true;
                        } //End block
                        {
                            host.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        } //End block
                        mLayoutRequested = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        final boolean didLayout = mLayoutRequested && !mStopped;
        boolean triggerGlobalLayoutListener = didLayout
                || attachInfo.mRecomputeGlobalAttributes;
        {
            mLayoutRequested = false;
            mScrollMayChange = true;
            long startTime = 0L;
            {
                startTime = SystemClock.elapsedRealtime();
            } //End block
            host.layout(0, 0, host.getMeasuredWidth(), host.getMeasuredHeight());
            {
                {
                    boolean var31831045BDEFED9943FC4835790CC5A9_806937765 = (!host.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_LAYOUT));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The view hierarchy is an inconsistent state,"
                            + "please refer to the logs with the tag "
                            + ViewDebug.CONSISTENCY_LOG_TAG + " for more infomation.");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                EventLog.writeEvent(60001, SystemClock.elapsedRealtime() - startTime);
            } //End block
            {
                host.getLocationInWindow(mTmpLocation);
                mTransparentRegion.set(mTmpLocation[0], mTmpLocation[1],
                        mTmpLocation[0] + host.mRight - host.mLeft,
                        mTmpLocation[1] + host.mBottom - host.mTop);
                host.gatherTransparentRegion(mTransparentRegion);
                {
                    mTranslator.translateRegionInWindowToScreen(mTransparentRegion);
                } //End block
                {
                    boolean var9116609D398330DBB934B3776C260A89_1654045383 = (!mTransparentRegion.equals(mPreviousTransparentRegion));
                    {
                        mPreviousTransparentRegion.set(mTransparentRegion);
                        try 
                        {
                            sWindowSession.setTransparentRegion(mWindow, mTransparentRegion);
                        } //End block
                        catch (RemoteException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                System.out.println("======================================");
                System.out.println("performTraversals -- after setFrame");
                host.debug();
            } //End block
        } //End block
        {
            attachInfo.mRecomputeGlobalAttributes = false;
            attachInfo.mTreeObserver.dispatchOnGlobalLayout();
            {
                boolean var673B0FAE9DD6499A44EB4983D0077ABD_198565120 = (AccessibilityManager.getInstance(host.mContext).isEnabled());
                {
                    postSendWindowContentChangedCallback();
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            final ViewTreeObserver.InternalInsetsInfo insets = attachInfo.mGivenInternalInsets;
            insets.reset();
            attachInfo.mTreeObserver.dispatchOnComputeInternalInsets(insets);
            {
                boolean var0FBD0E114506B508CD538E9D69F15B52_1418660097 = (insetsPending || !mLastGivenInsets.equals(insets));
                {
                    mLastGivenInsets.set(insets);
                    Rect contentInsets;
                    Rect visibleInsets;
                    Region touchableRegion;
                    {
                        contentInsets = mTranslator.getTranslatedContentInsets(insets.contentInsets);
                        visibleInsets = mTranslator.getTranslatedVisibleInsets(insets.visibleInsets);
                        touchableRegion = mTranslator.getTranslatedTouchableArea(insets.touchableRegion);
                    } //End block
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
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                {
                    boolean var4424A784A6C03CB3A8B3EDDFC8E02AD9_525346279 = (!mView.hasFocus());
                    {
                        mView.requestFocus(View.FOCUS_FORWARD);
                        mFocusedView = mRealFocusedView = mView.findFocus();
                    } //End block
                    {
                        mRealFocusedView = mView.findFocus();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mFirst = false;
        mWillDrawSoon = false;
        mNewSurfaceNeeded = false;
        mViewVisibility = viewVisibility;
        {
            final boolean imTarget = WindowManager.LayoutParams
                    .mayUseInputMethod(mWindowAttributes.flags);
            {
                mLastWasImTarget = imTarget;
                InputMethodManager imm = InputMethodManager.peekInstance();
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
        {
            {
                boolean var01179B785E9234D284AD849ED1C97F52_1571654257 = (mPendingTransitions != null && mPendingTransitions.size() > 0);
                {
                    {
                        int i = 0;
                        boolean varAD8106A5496A57A8FDEF861C44502FBE_684056755 = (i < mPendingTransitions.size());
                        {
                            mPendingTransitions.get(i).startChangingAnimations();
                        } //End block
                    } //End collapsed parenthetic
                    mPendingTransitions.clear();
                } //End block
            } //End collapsed parenthetic
            mFullRedrawNeeded = false;
            long drawStartTime;
            {
                drawStartTime = System.nanoTime();
            } //End block
            draw(fullRedrawNeeded);
            {
                mLastDrawDurationNanos = System.nanoTime() - drawStartTime;
            } //End block
            {
                mReportNextDraw = false;
                {
                    boolean varFBA90BC0FA837508D9D80EA4B8A252E5_1655357586 = (mSurfaceHolder != null && mSurface.isValid());
                    {
                        mSurfaceHolderCallback.surfaceRedrawNeeded(mSurfaceHolder);
                        SurfaceHolder.Callback callbacks[] = mSurfaceHolder.getCallbacks();
                        {
                            {
                                SurfaceHolder.Callback c = callbacks[0];
                                {
                                    {
                                        ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                        mSurfaceHolder);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                try 
                {
                    sWindowSession.finishDrawing(mWindow);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End block
        {
            {
                boolean var01179B785E9234D284AD849ED1C97F52_1199478855 = (mPendingTransitions != null && mPendingTransitions.size() > 0);
                {
                    {
                        int i = 0;
                        boolean varAD8106A5496A57A8FDEF861C44502FBE_828089707 = (i < mPendingTransitions.size());
                        {
                            mPendingTransitions.get(i).endChangingAnimations();
                        } //End block
                    } //End collapsed parenthetic
                    mPendingTransitions.clear();
                } //End block
            } //End collapsed parenthetic
            {
                mReportNextDraw = true;
            } //End block
            {
                mFullRedrawNeeded = true;
            } //End block
            {
                scheduleTraversals();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.239 -0400", hash_original_method = "365202E212CCFCA6F73CFA951F572330", hash_generated_method = "2720F11BC7CE86C538F794FDD2D420E3")
    public void requestTransparentRegion(View child) {
        checkThread();
        {
            mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            mWindowAttributesChanged = true;
            mWindowAttributesChangesFlag = 0;
            requestLayout();
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (mView == child) {
            //mView.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            //mWindowAttributesChanged = true;
            //mWindowAttributesChangesFlag = 0;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.241 -0400", hash_original_method = "66EB141D637AEB4DAD3BF6AA91407C70", hash_generated_method = "09181E91181182119215CC05922131F1")
    private int getRootMeasureSpec(int windowSize, int rootDimension) {
        int measureSpec;
        //Begin case ViewGroup.LayoutParams.MATCH_PARENT 
        measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.EXACTLY);
        //End case ViewGroup.LayoutParams.MATCH_PARENT 
        //Begin case ViewGroup.LayoutParams.WRAP_CONTENT 
        measureSpec = MeasureSpec.makeMeasureSpec(windowSize, MeasureSpec.AT_MOST);
        //End case ViewGroup.LayoutParams.WRAP_CONTENT 
        //Begin case default 
        measureSpec = MeasureSpec.makeMeasureSpec(rootDimension, MeasureSpec.EXACTLY);
        //End case default 
        addTaint(windowSize);
        addTaint(rootDimension);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873362968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1873362968;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.241 -0400", hash_original_method = "40FADC477E8B2549BFFAC38F5B19946C", hash_generated_method = "32E324117EEFF16ED44FA5DE43E49630")
    public void onHardwarePreDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        canvas.translate(0, -mHardwareYOffset);
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //canvas.translate(0, -mHardwareYOffset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.241 -0400", hash_original_method = "0640B89EE45E5EFA4DD1A520BD523415", hash_generated_method = "734510ABF50DB7FCFFAD1CA881FDAE7B")
    public void onHardwarePostDraw(HardwareCanvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mResizePaint.setAlpha(mResizeAlpha);
            canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //if (mResizeBuffer != null) {
            //mResizePaint.setAlpha(mResizeAlpha);
            //canvas.drawHardwareLayer(mResizeBuffer, 0.0f, mHardwareYOffset, mResizePaint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.242 -0400", hash_original_method = "6ED7CE075B975161CAA5CFD7B073E953", hash_generated_method = "7C5F5EBA2D01B8D1C82DEB512982417A")
     void outputDisplayList(View view) {
        {
            DisplayList displayList = view.getDisplayList();
            {
                mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            } //End block
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //if (mAttachInfo != null && mAttachInfo.mHardwareCanvas != null) {
            //DisplayList displayList = view.getDisplayList();
            //if (displayList != null) {
                //mAttachInfo.mHardwareCanvas.outputDisplayList(displayList);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.243 -0400", hash_original_method = "910E3893A962467411DC222791137B30", hash_generated_method = "021611C28F3980C73CEC1FAFA9FAB17B")
    private void profileRendering(boolean enabled) {
        {
            mRenderProfilingEnabled = enabled;
            {
                mRenderProfiler = new Thread(new Runnable() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.243 -0400", hash_original_method = "EA0E14B14C78DD1BF1B50C8FA4E06FFC", hash_generated_method = "F7CC3EDA03D93F96D61D5B7625D3A958")
                    @Override
                    public void run() {
                        Log.d(TAG, "Starting profiling thread");
                        {
                            mAttachInfo.mHandler.post(new Runnable() {                                
                                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.243 -0400", hash_original_method = "4A3D1224B1F9A46A2478F0B98B77BC62", hash_generated_method = "3306EB70EC747DC660D40B63C10E33A1")
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
            {
                mRenderProfiler.interrupt();
                mRenderProfiler = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.244 -0400", hash_original_method = "1AA1A4B748D7601F4F3826735499E6F6", hash_generated_method = "F5357DB836BC435D3CE4DF57349BCF75")
    private void trackFPS() {
        long nowTime = System.currentTimeMillis();
        {
            mFpsStartTime = mFpsPrevTime = nowTime;
            mFpsNumFrames = 0;
        } //End block
        {
            String thisHash = Integer.toHexString(System.identityHashCode(this));
            long frameTime = nowTime - mFpsPrevTime;
            long totalTime = nowTime - mFpsStartTime;
            mFpsPrevTime = nowTime;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.246 -0400", hash_original_method = "E37EF3DCFB26F629DB3873EE57113F2D", hash_generated_method = "B849A345A3931D68D41E3001EACFDBE6")
    private void draw(boolean fullRedrawNeeded) {
        Surface surface = mSurface;
        {
            boolean var2E815E81AF85D59B92EF3DD48D335D0C_1187789560 = (surface == null || !surface.isValid());
        } //End collapsed parenthetic
        {
            trackFPS();
        } //End block
        {
            {
                sFirstDrawComplete = true;
                final int count = sFirstDrawHandlers.size();
                {
                    int i = 0;
                    {
                        post(sFirstDrawHandlers.get(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        scrollToRectOrFocus(null, false);
        {
            mAttachInfo.mViewScrollChanged = false;
            mAttachInfo.mTreeObserver.dispatchOnScrollChanged();
        } //End block
        int yoff;
        boolean animating = mScroller != null && mScroller.computeScrollOffset();
        {
            yoff = mScroller.getCurrY();
        } //End block
        {
            yoff = mScrollY;
        } //End block
        {
            mCurScrollY = yoff;
            fullRedrawNeeded = true;
        } //End block
        float appScale = mAttachInfo.mApplicationScale;
        boolean scalingRequired = mAttachInfo.mScalingRequired;
        int resizeAlpha = 0;
        {
            long deltaTime = SystemClock.uptimeMillis() - mResizeBufferStartTime;
            {
                float amt = deltaTime/(float) mResizeBufferDuration;
                amt = mResizeInterpolator.getInterpolation(amt);
                animating = true;
                resizeAlpha = 255 - (int)(amt*255);
            } //End block
            {
                disposeResizeBuffer();
            } //End block
        } //End block
        Rect dirty = mDirty;
        {
            dirty.setEmpty();
            {
                {
                    mScroller.abortAnimation();
                } //End block
                disposeResizeBuffer();
            } //End block
        } //End block
        {
            mAttachInfo.mIgnoreDirtyState = true;
            dirty.set(0, 0, (int) (mWidth * appScale + 0.5f), (int) (mHeight * appScale + 0.5f));
        } //End block
        {
            boolean var5D30B77E3F89F2623E0DAAFBA8BE8C49_978383237 = (mAttachInfo.mHardwareRenderer != null && mAttachInfo.mHardwareRenderer.isEnabled());
            {
                {
                    boolean varD5F827B9D34B0B1DC1F85ACE756947A8_951746689 = (!dirty.isEmpty() || mIsAnimating);
                    {
                        mIsAnimating = false;
                        mHardwareYOffset = yoff;
                        mResizeAlpha = resizeAlpha;
                        mCurrentDirty.set(dirty);
                        mCurrentDirty.union(mPreviousDirty);
                        mPreviousDirty.set(dirty);
                        dirty.setEmpty();
                        Rect currentDirty = mCurrentDirty;
                        {
                            currentDirty = null;
                        } //End block
                        {
                            boolean varDE04A2AF95D6F679E2E2203A2A073551_515597063 = (mAttachInfo.mHardwareRenderer.draw(mView, mAttachInfo, this, currentDirty));
                            {
                                mPreviousDirty.set(0, 0, mWidth, mHeight);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    mFullRedrawNeeded = true;
                    scheduleTraversals();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAC62E7C7590DB61B5214E434C55175F8_1533662364 = (!dirty.isEmpty() || mIsAnimating);
            {
                Canvas canvas;
                try 
                {
                    int left = dirty.left;
                    int top = dirty.top;
                    int right = dirty.right;
                    int bottom = dirty.bottom;
                    long lockCanvasStartTime;
                    {
                        lockCanvasStartTime = System.nanoTime();
                    } //End block
                    canvas = surface.lockCanvas(dirty);
                    {
                        long now = System.nanoTime();
                        Log.d(TAG, "Latency: Spent "
                            + ((now - lockCanvasStartTime) * 0.000001f)
                            + "ms waiting for surface.lockCanvas()");
                    } //End block
                    {
                        mAttachInfo.mIgnoreDirtyState = true;
                    } //End block
                    canvas.setDensity(mDensity);
                } //End block
                catch (Surface.OutOfResourcesException e)
                {
                    try 
                    {
                        {
                            boolean var752BE542D442F142A9DEDCDCD20ADA9F_1291735604 = (!sWindowSession.outOfMemory(mWindow));
                            {
                                Process.killProcess(Process.myPid());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException ex)
                    { }
                    mLayoutRequested = true;
                } //End block
                catch (IllegalArgumentException e)
                {
                    mLayoutRequested = true;
                } //End block
                try 
                {
                    {
                        boolean var94DD6BEDF06EB37762BEEC60B9337CF6_1368500425 = (!dirty.isEmpty() || mIsAnimating);
                        {
                            long startTime = 0L;
                            {
                                startTime = SystemClock.elapsedRealtime();
                            } //End block
                            {
                                boolean varD1E08946F6E52A077FF56A289B9208C1_878873009 = (!canvas.isOpaque() || yoff != 0);
                                {
                                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                                } //End block
                            } //End collapsed parenthetic
                            dirty.setEmpty();
                            mIsAnimating = false;
                            mAttachInfo.mDrawingTime = SystemClock.uptimeMillis();
                            mView.mPrivateFlags |= View.DRAWN;
                            {
                                Context cxt = mView.getContext();
                            } //End block
                            try 
                            {
                                canvas.translate(0, -yoff);
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
                                {
                                    mAttachInfo.mIgnoreDirtyState = false;
                                } //End block
                            } //End block
                            {
                                mView.dispatchConsistencyCheck(ViewDebug.CONSISTENCY_DRAWING);
                            } //End block
                            {
                                EventLog.writeEvent(60000, SystemClock.elapsedRealtime() - startTime);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                finally 
                {
                    surface.unlockCanvasAndPost(canvas);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mFullRedrawNeeded = true;
            scheduleTraversals();
        } //End block
        addTaint(fullRedrawNeeded);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.247 -0400", hash_original_method = "FAD7953F436A3C038802D5DE07F19E9E", hash_generated_method = "2973AC653CF38E6A75AE9EC455B50579")
     boolean scrollToRectOrFocus(Rect rectangle, boolean immediate) {
        final View.AttachInfo attachInfo = mAttachInfo;
        final Rect ci = attachInfo.mContentInsets;
        final Rect vi = attachInfo.mVisibleInsets;
        int scrollY = 0;
        boolean handled = false;
        {
            scrollY = mScrollY;
            View focus = mRealFocusedView;
            {
                mRealFocusedView = null;
            } //End block
            {
                rectangle = null;
            } //End block
            {
                mLastScrolledFocus = focus;
                mScrollMayChange = false;
                {
                    boolean var6E219E0A30DABE54C1FB5AE05AB0C96F_1875941892 = (focus.getGlobalVisibleRect(mVisRect, null));
                    {
                        {
                            focus.getFocusedRect(mTempRect);
                            {
                                ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focus, mTempRect);
                            } //End block
                        } //End block
                        {
                            mTempRect.set(rectangle);
                        } //End block
                        {
                            boolean var7B24AA8599694B5C184BD1D7A0EA3976_1870185221 = (mTempRect.intersect(mVisRect));
                            {
                                {
                                    boolean var3D339EB9AF254B1679979682435121C1_1955758708 = (mTempRect.height() >
                                (mView.getHeight()-vi.top-vi.bottom));
                                    {
                                        scrollY -= vi.top - (mTempRect.top-scrollY);
                                    } //End block
                                    {
                                        boolean var3406F2BDBAA7A3EBFD045E8954640BCE_706432303 = ((mTempRect.bottom-scrollY)
                                > (mView.getHeight()-vi.bottom));
                                        {
                                            scrollY += (mTempRect.bottom-scrollY)
                                    - (mView.getHeight()-vi.bottom);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                                handled = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                {
                    mScroller = new Scroller(mView.getContext());
                } //End block
                mScroller.startScroll(0, mScrollY, 0, scrollY-mScrollY);
            } //End block
            {
                mScroller.abortAnimation();
            } //End block
            mScrollY = scrollY;
        } //End block
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_697137785 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_697137785;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.248 -0400", hash_original_method = "9E09AEB1258054D8E474B794DDE3DA53", hash_generated_method = "2A0E3D299D790F6B9D19C22F9E9778B7")
    public void requestChildFocus(View child, View focused) {
        checkThread();
        {
            mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(mFocusedView, focused);
            scheduleTraversals();
        } //End block
        mFocusedView = mRealFocusedView = focused;
        addTaint(child.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.248 -0400", hash_original_method = "D78AE43D1295D32838328E11498E7092", hash_generated_method = "2EAA3360A955FC9DDD37C8BAB9F2AB9F")
    public void clearChildFocus(View child) {
        checkThread();
        View oldFocus = mFocusedView;
        mFocusedView = mRealFocusedView = null;
        {
            boolean var0C2CE9934D88CF89C62BF802E1814E91_1319633750 = (mView != null && !mView.hasFocus());
            {
                {
                    boolean varC84B37DB46E138B03F613C2E132675E1_334133090 = (!mView.requestFocus(View.FOCUS_FORWARD));
                    {
                        mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(oldFocus, null);
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.248 -0400", hash_original_method = "8AB5F5420D903C559791A9BF9B9BF8FD", hash_generated_method = "4646840279E0401D613BD2B9AE1ECF85")
    public void focusableViewAvailable(View v) {
        checkThread();
        {
            {
                boolean var9C9B0C0875517AC338686EE7008FD35A_3657439 = (!mView.hasFocus());
                {
                    v.requestFocus();
                } //End block
                {
                    mFocusedView = mView.findFocus();
                    boolean descendantsHaveDibsOnFocus = (mFocusedView instanceof ViewGroup) &&
                            (((ViewGroup) mFocusedView).getDescendantFocusability() ==
                                    ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    {
                        boolean var673A3BE5EE0B137534BC4B96ECEA81C3_1707941674 = (descendantsHaveDibsOnFocus && isViewDescendantOf(v, mFocusedView));
                        {
                            v.requestFocus();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(v.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.249 -0400", hash_original_method = "66451BF0E175BE00AB35036422B65D7E", hash_generated_method = "1D152A7DA72F72210095DA826CF7E89F")
    public void recomputeViewAttributes(View child) {
        checkThread();
        {
            mAttachInfo.mRecomputeGlobalAttributes = true;
            {
                scheduleTraversals();
            } //End block
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //checkThread();
        //if (mView == child) {
            //mAttachInfo.mRecomputeGlobalAttributes = true;
            //if (!mWillDrawSoon) {
                //scheduleTraversals();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.250 -0400", hash_original_method = "59E93FB376BDE71F69616A2B01BFF0AF", hash_generated_method = "3E4DF2392B74902D7C9F3D973A959C02")
     void dispatchDetachedFromWindow() {
        {
            {
                boolean varCD2E6CE6A1CFB30D773CBD0CD1B5DD28_557795393 = (mAttachInfo.mHardwareRenderer != null &&
                    mAttachInfo.mHardwareRenderer.isEnabled());
                {
                    mAttachInfo.mHardwareRenderer.validate();
                } //End block
            } //End collapsed parenthetic
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
        {
            mInputQueueCallback.onInputQueueDestroyed(mInputQueue);
            mInputQueueCallback = null;
            mInputQueue = null;
        } //End block
        {
            InputQueue.unregisterInputChannel(mInputChannel);
        } //End block
        try 
        {
            sWindowSession.remove(mWindow);
        } //End block
        catch (RemoteException e)
        { }
        {
            mInputChannel.dispose();
            mInputChannel = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.251 -0400", hash_original_method = "095941099FB476714878603F2FD5257D", hash_generated_method = "CC4704D499162436E1C2D7E162F542C3")
     void updateConfiguration(Configuration config, boolean force) {
        CompatibilityInfo ci = mCompatibilityInfo.getIfNeeded();
        {
            config = new Configuration(config);
            ci.applyToConfiguration(config);
        } //End block
        {
            {
                int i = sConfigCallbacks.size()-1;
                {
                    sConfigCallbacks.get(i).onConfigurationChanged(config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            config = mView.getResources().getConfiguration();
            {
                boolean var8C30D5838B256BB265C26C428C6B837E_1313735515 = (force || mLastConfiguration.diff(config) != 0);
                {
                    mLastConfiguration.setTo(config);
                    mView.dispatchConfigurationChanged(config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(config.getTaint());
        addTaint(force);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.255 -0400", hash_original_method = "95F12947A9B342E5A748CE842344783A", hash_generated_method = "5C41A6B6247188DDD94FBF9798064D2B")
    @Override
    public String getMessageName(Message message) {
        String varB4EAC82CA7396A68D541C85D26508E83_1348230129 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_955721383 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_821185737 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_61132957 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1126713264 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_800143566 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_35192736 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1425538837 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_982724620 = null; //Variable for return #9
        String varB4EAC82CA7396A68D541C85D26508E83_115410528 = null; //Variable for return #10
        String varB4EAC82CA7396A68D541C85D26508E83_703065452 = null; //Variable for return #11
        String varB4EAC82CA7396A68D541C85D26508E83_510834228 = null; //Variable for return #12
        String varB4EAC82CA7396A68D541C85D26508E83_1322368229 = null; //Variable for return #13
        String varB4EAC82CA7396A68D541C85D26508E83_1913703904 = null; //Variable for return #14
        String varB4EAC82CA7396A68D541C85D26508E83_391705100 = null; //Variable for return #15
        String varB4EAC82CA7396A68D541C85D26508E83_713983964 = null; //Variable for return #16
        String varB4EAC82CA7396A68D541C85D26508E83_1612679015 = null; //Variable for return #17
        String varB4EAC82CA7396A68D541C85D26508E83_216321393 = null; //Variable for return #18
        String varB4EAC82CA7396A68D541C85D26508E83_1132036380 = null; //Variable for return #19
        String varB4EAC82CA7396A68D541C85D26508E83_1363881397 = null; //Variable for return #20
        String varB4EAC82CA7396A68D541C85D26508E83_71854061 = null; //Variable for return #21
        String varB4EAC82CA7396A68D541C85D26508E83_1657340051 = null; //Variable for return #22
        String varB4EAC82CA7396A68D541C85D26508E83_1855927217 = null; //Variable for return #23
        String varB4EAC82CA7396A68D541C85D26508E83_1960795569 = null; //Variable for return #24
        String varB4EAC82CA7396A68D541C85D26508E83_2038852221 = null; //Variable for return #25
        String varB4EAC82CA7396A68D541C85D26508E83_1649165308 = null; //Variable for return #26
        //Begin case DO_TRAVERSAL 
        varB4EAC82CA7396A68D541C85D26508E83_1348230129 = "DO_TRAVERSAL";
        //End case DO_TRAVERSAL 
        //Begin case DIE 
        varB4EAC82CA7396A68D541C85D26508E83_955721383 = "DIE";
        //End case DIE 
        //Begin case RESIZED 
        varB4EAC82CA7396A68D541C85D26508E83_821185737 = "RESIZED";
        //End case RESIZED 
        //Begin case RESIZED_REPORT 
        varB4EAC82CA7396A68D541C85D26508E83_61132957 = "RESIZED_REPORT";
        //End case RESIZED_REPORT 
        //Begin case WINDOW_FOCUS_CHANGED 
        varB4EAC82CA7396A68D541C85D26508E83_1126713264 = "WINDOW_FOCUS_CHANGED";
        //End case WINDOW_FOCUS_CHANGED 
        //Begin case DISPATCH_KEY 
        varB4EAC82CA7396A68D541C85D26508E83_800143566 = "DISPATCH_KEY";
        //End case DISPATCH_KEY 
        //Begin case DISPATCH_POINTER 
        varB4EAC82CA7396A68D541C85D26508E83_35192736 = "DISPATCH_POINTER";
        //End case DISPATCH_POINTER 
        //Begin case DISPATCH_TRACKBALL 
        varB4EAC82CA7396A68D541C85D26508E83_1425538837 = "DISPATCH_TRACKBALL";
        //End case DISPATCH_TRACKBALL 
        //Begin case DISPATCH_APP_VISIBILITY 
        varB4EAC82CA7396A68D541C85D26508E83_982724620 = "DISPATCH_APP_VISIBILITY";
        //End case DISPATCH_APP_VISIBILITY 
        //Begin case DISPATCH_GET_NEW_SURFACE 
        varB4EAC82CA7396A68D541C85D26508E83_115410528 = "DISPATCH_GET_NEW_SURFACE";
        //End case DISPATCH_GET_NEW_SURFACE 
        //Begin case FINISHED_EVENT 
        varB4EAC82CA7396A68D541C85D26508E83_703065452 = "FINISHED_EVENT";
        //End case FINISHED_EVENT 
        //Begin case DISPATCH_KEY_FROM_IME 
        varB4EAC82CA7396A68D541C85D26508E83_510834228 = "DISPATCH_KEY_FROM_IME";
        //End case DISPATCH_KEY_FROM_IME 
        //Begin case FINISH_INPUT_CONNECTION 
        varB4EAC82CA7396A68D541C85D26508E83_1322368229 = "FINISH_INPUT_CONNECTION";
        //End case FINISH_INPUT_CONNECTION 
        //Begin case CHECK_FOCUS 
        varB4EAC82CA7396A68D541C85D26508E83_1913703904 = "CHECK_FOCUS";
        //End case CHECK_FOCUS 
        //Begin case CLOSE_SYSTEM_DIALOGS 
        varB4EAC82CA7396A68D541C85D26508E83_391705100 = "CLOSE_SYSTEM_DIALOGS";
        //End case CLOSE_SYSTEM_DIALOGS 
        //Begin case DISPATCH_DRAG_EVENT 
        varB4EAC82CA7396A68D541C85D26508E83_713983964 = "DISPATCH_DRAG_EVENT";
        //End case DISPATCH_DRAG_EVENT 
        //Begin case DISPATCH_DRAG_LOCATION_EVENT 
        varB4EAC82CA7396A68D541C85D26508E83_1612679015 = "DISPATCH_DRAG_LOCATION_EVENT";
        //End case DISPATCH_DRAG_LOCATION_EVENT 
        //Begin case DISPATCH_SYSTEM_UI_VISIBILITY 
        varB4EAC82CA7396A68D541C85D26508E83_216321393 = "DISPATCH_SYSTEM_UI_VISIBILITY";
        //End case DISPATCH_SYSTEM_UI_VISIBILITY 
        //Begin case DISPATCH_GENERIC_MOTION 
        varB4EAC82CA7396A68D541C85D26508E83_1132036380 = "DISPATCH_GENERIC_MOTION";
        //End case DISPATCH_GENERIC_MOTION 
        //Begin case UPDATE_CONFIGURATION 
        varB4EAC82CA7396A68D541C85D26508E83_1363881397 = "UPDATE_CONFIGURATION";
        //End case UPDATE_CONFIGURATION 
        //Begin case DO_PERFORM_ACCESSIBILITY_ACTION 
        varB4EAC82CA7396A68D541C85D26508E83_71854061 = "DO_PERFORM_ACCESSIBILITY_ACTION";
        //End case DO_PERFORM_ACCESSIBILITY_ACTION 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID 
        varB4EAC82CA7396A68D541C85D26508E83_1657340051 = "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID";
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID 
        varB4EAC82CA7396A68D541C85D26508E83_1855927217 = "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID";
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT 
        varB4EAC82CA7396A68D541C85D26508E83_1960795569 = "DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT";
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT 
        //Begin case PROCESS_INPUT_EVENTS 
        varB4EAC82CA7396A68D541C85D26508E83_2038852221 = "PROCESS_INPUT_EVENTS";
        //End case PROCESS_INPUT_EVENTS 
        varB4EAC82CA7396A68D541C85D26508E83_1649165308 = super.getMessageName(message);
        addTaint(message.getTaint());
        String varA7E53CE21691AB073D9660D615818899_192878107; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1348230129;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_955721383;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_821185737;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_61132957;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1126713264;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_800143566;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_35192736;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1425538837;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_982724620;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_115410528;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_703065452;
                break;
            case 12: //Assign result for return ordinal #12
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_510834228;
                break;
            case 13: //Assign result for return ordinal #13
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1322368229;
                break;
            case 14: //Assign result for return ordinal #14
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1913703904;
                break;
            case 15: //Assign result for return ordinal #15
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_391705100;
                break;
            case 16: //Assign result for return ordinal #16
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_713983964;
                break;
            case 17: //Assign result for return ordinal #17
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1612679015;
                break;
            case 18: //Assign result for return ordinal #18
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_216321393;
                break;
            case 19: //Assign result for return ordinal #19
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1132036380;
                break;
            case 20: //Assign result for return ordinal #20
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1363881397;
                break;
            case 21: //Assign result for return ordinal #21
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_71854061;
                break;
            case 22: //Assign result for return ordinal #22
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1657340051;
                break;
            case 23: //Assign result for return ordinal #23
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1855927217;
                break;
            case 24: //Assign result for return ordinal #24
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1960795569;
                break;
            case 25: //Assign result for return ordinal #25
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_2038852221;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_192878107 = varB4EAC82CA7396A68D541C85D26508E83_1649165308;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_192878107.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_192878107;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.258 -0400", hash_original_method = "0C83FFF474CF8ADB1C57E65037847991", hash_generated_method = "4F8F20D35BE19FD295932F252841BBDA")
    @Override
    public void handleMessage(Message msg) {
        //Begin case View.AttachInfo.INVALIDATE_MSG 
        ((View) msg.obj).invalidate();
        //End case View.AttachInfo.INVALIDATE_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        final View.AttachInfo.InvalidateInfo info = (View.AttachInfo.InvalidateInfo) msg.obj;
        //End case View.AttachInfo.INVALIDATE_RECT_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        info.target.invalidate(info.left, info.top, info.right, info.bottom);
        //End case View.AttachInfo.INVALIDATE_RECT_MSG 
        //Begin case View.AttachInfo.INVALIDATE_RECT_MSG 
        info.release();
        //End case View.AttachInfo.INVALIDATE_RECT_MSG 
        //Begin case DO_TRAVERSAL 
        {
            Debug.startMethodTracing("ViewAncestor");
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        long traversalStartTime;
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        {
            traversalStartTime = System.nanoTime();
            mLastDrawDurationNanos = 0;
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        performTraversals();
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        {
            long now = System.nanoTime();
            Log.d(TAG, "Latency: Spent "
                        + ((now - traversalStartTime) * 0.000001f)
                        + "ms in performTraversals(), with "
                        + (mLastDrawDurationNanos * 0.000001f)
                        + "ms of that time in draw()");
            mLastTraversalFinishedTimeNanos = now;
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case DO_TRAVERSAL 
        {
            Debug.stopMethodTracing();
            mProfile = false;
        } //End block
        //End case DO_TRAVERSAL 
        //Begin case FINISHED_EVENT 
        handleFinishedEvent(msg.arg1, msg.arg2 != 0);
        //End case FINISHED_EVENT 
        //Begin case DISPATCH_KEY 
        deliverKeyEvent((KeyEvent)msg.obj, msg.arg1 != 0);
        //End case DISPATCH_KEY 
        //Begin case DISPATCH_POINTER 
        deliverPointerEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        //End case DISPATCH_POINTER 
        //Begin case DISPATCH_TRACKBALL 
        deliverTrackballEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        //End case DISPATCH_TRACKBALL 
        //Begin case DISPATCH_GENERIC_MOTION 
        deliverGenericMotionEvent((MotionEvent) msg.obj, msg.arg1 != 0);
        //End case DISPATCH_GENERIC_MOTION 
        //Begin case PROCESS_INPUT_EVENTS 
        processInputEvents(false);
        //End case PROCESS_INPUT_EVENTS 
        //Begin case DISPATCH_APP_VISIBILITY 
        handleAppVisibility(msg.arg1 != 0);
        //End case DISPATCH_APP_VISIBILITY 
        //Begin case DISPATCH_GET_NEW_SURFACE 
        handleGetNewSurface();
        //End case DISPATCH_GET_NEW_SURFACE 
        //Begin case RESIZED 
        ResizedInfo ri = (ResizedInfo)msg.obj;
        //End case RESIZED 
        //Begin case RESIZED 
        {
            boolean var143D5C08604C0AF03595F421C2A612C0_1191801717 = (mWinFrame.width() == msg.arg1 && mWinFrame.height() == msg.arg2
                    && mPendingContentInsets.equals(ri.coveredInsets)
                    && mPendingVisibleInsets.equals(ri.visibleInsets)
                    && ((ResizedInfo)msg.obj).newConfig == null);
        } //End collapsed parenthetic
        //End case RESIZED 
        //Begin case RESIZED_REPORT 
        {
            Configuration config = ((ResizedInfo)msg.obj).newConfig;
            {
                updateConfiguration(config, false);
            } //End block
            mWinFrame.left = 0;
            mWinFrame.right = msg.arg1;
            mWinFrame.top = 0;
            mWinFrame.bottom = msg.arg2;
            mPendingContentInsets.set(((ResizedInfo)msg.obj).coveredInsets);
            mPendingVisibleInsets.set(((ResizedInfo)msg.obj).visibleInsets);
            {
                mReportNextDraw = true;
            } //End block
            {
                forceLayout(mView);
            } //End block
            requestLayout();
        } //End block
        //End case RESIZED_REPORT 
        //Begin case WINDOW_FOCUS_CHANGED 
        {
            {
                boolean hasWindowFocus = msg.arg1 != 0;
                mAttachInfo.mHasWindowFocus = hasWindowFocus;
                profileRendering(hasWindowFocus);
                {
                    boolean inTouchMode = msg.arg2 != 0;
                    ensureTouchModeLocally(inTouchMode);
                    {
                        boolean var3AE98E3D719D8E57E314A6EF6D2DA333_749806780 = (mAttachInfo.mHardwareRenderer != null &&
                            mSurface != null && mSurface.isValid());
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
                                    {
                                        boolean var6D55857E69BE616DA2387C824B8B58FA_80687077 = (!sWindowSession.outOfMemory(mWindow));
                                        {
                                            Process.killProcess(Process.myPid());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                catch (RemoteException ex)
                                { }
                                sendMessageDelayed(obtainMessage(msg.what, msg.arg1, msg.arg2), 500);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                mLastWasImTarget = WindowManager.LayoutParams
                        .mayUseInputMethod(mWindowAttributes.flags);
                InputMethodManager imm = InputMethodManager.peekInstance();
                {
                    {
                        imm.startGettingWindowFocus(mView);
                    } //End block
                    mAttachInfo.mKeyDispatchState.reset();
                    mView.dispatchWindowFocusChanged(hasWindowFocus);
                } //End block
                {
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
                {
                    sendAccessibilityEvents();
                } //End block
            } //End block
        } //End block
        //End case WINDOW_FOCUS_CHANGED 
        //Begin case DIE 
        doDie();
        //End case DIE 
        //Begin case DISPATCH_KEY_FROM_IME 
        {
            KeyEvent event = (KeyEvent)msg.obj;
            {
                boolean varE3C639C95D7D8182790DE92882BAC40A_253756197 = ((event.getFlags()&KeyEvent.FLAG_FROM_SYSTEM) != 0);
                {
                    event = KeyEvent.changeFlags(event, event.getFlags() & ~KeyEvent.FLAG_FROM_SYSTEM);
                } //End block
            } //End collapsed parenthetic
            deliverKeyEventPostIme((KeyEvent)msg.obj, false);
        } //End block
        //End case DISPATCH_KEY_FROM_IME 
        //Begin case FINISH_INPUT_CONNECTION 
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            {
                imm.reportFinishInputConnection((InputConnection)msg.obj);
            } //End block
        } //End block
        //End case FINISH_INPUT_CONNECTION 
        //Begin case CHECK_FOCUS 
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            {
                imm.checkFocus();
            } //End block
        } //End block
        //End case CHECK_FOCUS 
        //Begin case CLOSE_SYSTEM_DIALOGS 
        {
            {
                mView.onCloseSystemDialogs((String)msg.obj);
            } //End block
        } //End block
        //End case CLOSE_SYSTEM_DIALOGS 
        //Begin case DISPATCH_DRAG_EVENT DISPATCH_DRAG_LOCATION_EVENT 
        {
            DragEvent event = (DragEvent)msg.obj;
            event.mLocalState = mLocalDragState;
            handleDragEvent(event);
        } //End block
        //End case DISPATCH_DRAG_EVENT DISPATCH_DRAG_LOCATION_EVENT 
        //Begin case DISPATCH_SYSTEM_UI_VISIBILITY 
        {
            handleDispatchSystemUiVisibilityChanged((SystemUiVisibilityInfo)msg.obj);
        } //End block
        //End case DISPATCH_SYSTEM_UI_VISIBILITY 
        //Begin case UPDATE_CONFIGURATION 
        {
            Configuration config = (Configuration)msg.obj;
            {
                boolean var1B1857A3FCA31AAF6E6915F53921CC12_1620243465 = (config.isOtherSeqNewer(mLastConfiguration));
                {
                    config = mLastConfiguration;
                } //End block
            } //End collapsed parenthetic
            updateConfiguration(config, false);
        } //End block
        //End case UPDATE_CONFIGURATION 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID 
        {
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdUiThread(msg);
            } //End block
        } //End block
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID 
        //Begin case DO_PERFORM_ACCESSIBILITY_ACTION 
        {
            {
                getAccessibilityInteractionController()
                    .perfromAccessibilityActionUiThread(msg);
            } //End block
        } //End block
        //End case DO_PERFORM_ACCESSIBILITY_ACTION 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID 
        {
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdUiThread(msg);
            } //End block
        } //End block
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID 
        //Begin case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT 
        {
            {
                getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextUiThread(msg);
            } //End block
        } //End block
        //End case DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.258 -0400", hash_original_method = "0B0FC84CA02F82927D98059C965571E0", hash_generated_method = "29666BE886F2F012D724DBECFE146092")
    private void startInputEvent(InputQueue.FinishedCallback finishedCallback) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.259 -0400", hash_original_method = "06AEBC75FF0DC9B70A4E2BB2CC6850C1", hash_generated_method = "D68E4E3A5B97F103EFA579DA1A919E02")
    private void finishInputEvent(InputEvent event, boolean handled) {
        {
            final long now = System.nanoTime();
            final long eventTime = event.getEventTimeNano();
            final StringBuilder msg = new StringBuilder();
            msg.append("Latency: Spent ");
            msg.append((now - mInputEventReceiveTimeNanos) * 0.000001f);
            msg.append("ms processing ");
            {
                final KeyEvent keyEvent = (KeyEvent)event;
                msg.append("key event, action=");
                msg.append(KeyEvent.actionToString(keyEvent.getAction()));
            } //End block
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
            {
                msg.append("ms, delivered at +");
                msg.append((mInputEventDeliverTimeNanos - eventTime) * 0.000001f);
            } //End block
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
        addTaint(event.getTaint());
        addTaint(handled);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.260 -0400", hash_original_method = "A6640F15C2D0A406B73F798DB9EA077C", hash_generated_method = "7ECD94018594A86CA483F3AE07861A62")
     boolean ensureTouchMode(boolean inTouchMode) {
        Log.d("touchmode", "ensureTouchMode(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        try 
        {
            sWindowSession.setInTouchMode(inTouchMode);
        } //End block
        catch (RemoteException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        boolean var7211DA2D02AAD3EC6219E770D8E33669_598683115 = (ensureTouchModeLocally(inTouchMode));
        addTaint(inTouchMode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2006991200 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2006991200;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.261 -0400", hash_original_method = "A817FB22551D2F047707EAAC44367E27", hash_generated_method = "C1BBA328B5A01D37EFFEA0DB371B6BDA")
    private boolean ensureTouchModeLocally(boolean inTouchMode) {
        Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                + "touch mode is " + mAttachInfo.mInTouchMode);
        mAttachInfo.mInTouchMode = inTouchMode;
        mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        {
            Object varD5C5D13645C8843ADC3AA1EF553CA4E0_1093069205 = (enterTouchMode());
            Object var1779B98836824743D0F81D690D2F09AF_1991536887 = (leaveTouchMode());
        } //End flattened ternary
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075694289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075694289;
        // ---------- Original Method ----------
        //if (DBG) Log.d("touchmode", "ensureTouchModeLocally(" + inTouchMode + "), current "
                //+ "touch mode is " + mAttachInfo.mInTouchMode);
        //if (mAttachInfo.mInTouchMode == inTouchMode) return false;
        //mAttachInfo.mInTouchMode = inTouchMode;
        //mAttachInfo.mTreeObserver.dispatchOnTouchModeChanged(inTouchMode);
        //return (inTouchMode) ? enterTouchMode() : leaveTouchMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.262 -0400", hash_original_method = "4D22F5F97C319901FE80DD8DAA6DBF2B", hash_generated_method = "35C0DEEC9BE140B648865618F6A4D461")
    private boolean enterTouchMode() {
        {
            {
                boolean varC693284E56ACFD9F443A7AF6887A182D_759874641 = (mView.hasFocus());
                {
                    final View focused = mView.findFocus();
                    {
                        boolean var672E3B133FEEB41FF55DF762226C4368_1736721460 = (focused != null && !focused.isFocusableInTouchMode());
                        {
                            final ViewGroup ancestorToTakeFocus = findAncestorToTakeFocusInTouchMode(focused);
                            {
                                boolean var4BDB6BBF285F787DB5D62E792270B9CC_188979422 = (ancestorToTakeFocus.requestFocus());
                            } //End block
                            {
                                mView.unFocus();
                                mAttachInfo.mTreeObserver.dispatchOnGlobalFocusChange(focused, null);
                                mFocusedView = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_679705567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_679705567;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.264 -0400", hash_original_method = "A2FE4CBD06D42BF7C573F07F56417767", hash_generated_method = "B950AA80B9C12951F6D73B224A63607F")
    private ViewGroup findAncestorToTakeFocusInTouchMode(View focused) {
        ViewGroup varB4EAC82CA7396A68D541C85D26508E83_1497873766 = null; //Variable for return #1
        ViewGroup varB4EAC82CA7396A68D541C85D26508E83_637093816 = null; //Variable for return #2
        ViewGroup varB4EAC82CA7396A68D541C85D26508E83_237045811 = null; //Variable for return #3
        ViewParent parent = focused.getParent();
        {
            final ViewGroup vgParent = (ViewGroup) parent;
            {
                boolean varC23A07520BE483EA425697E9FFE7255F_99851256 = (vgParent.getDescendantFocusability() == ViewGroup.FOCUS_AFTER_DESCENDANTS
                    && vgParent.isFocusableInTouchMode());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1497873766 = vgParent;
                } //End block
            } //End collapsed parenthetic
            {
                boolean var410E9039314AA011024573FA45C6C4E3_215433592 = (vgParent.isRootNamespace());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_637093816 = null;
                } //End block
                {
                    parent = vgParent.getParent();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_237045811 = null;
        addTaint(focused.getTaint());
        ViewGroup varA7E53CE21691AB073D9660D615818899_1555507086; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1555507086 = varB4EAC82CA7396A68D541C85D26508E83_1497873766;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1555507086 = varB4EAC82CA7396A68D541C85D26508E83_637093816;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1555507086 = varB4EAC82CA7396A68D541C85D26508E83_237045811;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1555507086.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1555507086;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.264 -0400", hash_original_method = "6D4A7A06FF255705F6FF85A0D8D1E147", hash_generated_method = "C61B7B11068550C7DD5865783FF19DE7")
    private boolean leaveTouchMode() {
        {
            {
                boolean varC693284E56ACFD9F443A7AF6887A182D_1378074027 = (mView.hasFocus());
                {
                    mFocusedView = mView.findFocus();
                    {
                        boolean var685A2905466615BFEF6173704AD9363B_1117295710 = (((ViewGroup)mFocusedView).getDescendantFocusability() !=
                        ViewGroup.FOCUS_AFTER_DESCENDANTS);
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            final View focused = focusSearch(null, View.FOCUS_DOWN);
            {
                boolean var36C6CFA2F3F9A6ADFC90E9AFC6590240_1311109420 = (focused.requestFocus(View.FOCUS_DOWN));
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658459354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658459354;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.265 -0400", hash_original_method = "8F847D145475DB0C2BA683E62F600908", hash_generated_method = "6201A7D5CF2D69E760F61EF34B073820")
    private void deliverPointerEvent(MotionEvent event, boolean sendDone) {
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        final boolean isTouchEvent = event.isTouchEvent();
        {
            {
                mInputEventConsistencyVerifier.onTouchEvent(event, 0);
            } //End block
            {
                mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
            } //End block
        } //End block
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            mTranslator.translateEventInScreenToAppWindow(event);
        } //End block
        final int action = event.getAction();
        {
            ensureTouchMode(true);
        } //End block
        {
            event.offsetLocation(0, mCurScrollY);
        } //End block
        {
            lt.sample("A Dispatching PointerEvents", System.nanoTime() - event.getEventTimeNano());
        } //End block
        {
            mLastTouchPoint.x = event.getRawX();
            mLastTouchPoint.y = event.getRawY();
        } //End block
        boolean handled = mView.dispatchPointerEvent(event);
        {
            lt.sample("B Dispatched PointerEvents ", System.nanoTime() - event.getEventTimeNano());
        } //End block
        {
            finishMotionEvent(event, sendDone, true);
        } //End block
        finishMotionEvent(event, sendDone, false);
        addTaint(sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.265 -0400", hash_original_method = "DF90914307EFCD2CA23CDB09D8C7F95D", hash_generated_method = "F7489C43A3E1BDC798C9B3CCFA593AE5")
    private void finishMotionEvent(MotionEvent event, boolean sendDone, boolean handled) {
        event.recycle();
        {
            finishInputEvent(event, handled);
        } //End block
        {
            {
                boolean varFE47529C887D16DE595A17210AB89645_174934368 = ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0);
            } //End collapsed parenthetic
        } //End block
        addTaint(event.getTaint());
        addTaint(sendDone);
        addTaint(handled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.267 -0400", hash_original_method = "B306A4DB67A1B71DDAAA3D4C50CD59B0", hash_generated_method = "A709557D467AC14304231322A9BEA17D")
    private void deliverTrackballEvent(MotionEvent event, boolean sendDone) {
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } //End block
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            boolean var0BF4F8530CCB1128C2413D92D7C48A33_986746728 = (mView.dispatchTrackballEvent(event));
            {
                ensureTouchMode(false);
                finishMotionEvent(event, sendDone, true);
                mLastTrackballTime = Integer.MIN_VALUE;
            } //End block
        } //End collapsed parenthetic
        final TrackballAxis x = mTrackballAxisX;
        final TrackballAxis y = mTrackballAxisY;
        long curTime = SystemClock.uptimeMillis();
        {
            x.reset(0);
            y.reset(0);
            mLastTrackballTime = curTime;
        } //End block
        final int action = event.getAction();
        final int metaState = event.getMetaState();
        //Begin case MotionEvent.ACTION_DOWN 
        x.reset(2);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        y.reset(2);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_DOWN 
        deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_UP 
        x.reset(2);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        y.reset(2);
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_UP 
        deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DPAD_CENTER, 0, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
        //End case MotionEvent.ACTION_UP 
        final float xOff = x.collect(event.getX(), event.getEventTime(), "X");
        final float yOff = y.collect(event.getY(), event.getEventTime(), "Y");
        int keycode = 0;
        int movement = 0;
        float accel = 1;
        {
            movement = x.generate((2/event.getXPrecision()));
            {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_RIGHT
                        : KeyEvent.KEYCODE_DPAD_LEFT;
                accel = x.acceleration;
                y.reset(2);
            } //End block
        } //End block
        {
            movement = y.generate((2/event.getYPrecision()));
            {
                keycode = movement > 0 ? KeyEvent.KEYCODE_DPAD_DOWN
                        : KeyEvent.KEYCODE_DPAD_UP;
                accel = y.acceleration;
                x.reset(2);
            } //End block
        } //End block
        {
            movement = -movement;
            int accelMovement = (int)(movement * accel);
            {
                int repeatCount = accelMovement - movement;
                deliverKeyEvent(new KeyEvent(curTime, curTime,
                        KeyEvent.ACTION_MULTIPLE, keycode, repeatCount, metaState,
                        KeyCharacterMap.VIRTUAL_KEYBOARD, 0, KeyEvent.FLAG_FALLBACK,
                        InputDevice.SOURCE_KEYBOARD), false);
            } //End block
            {
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
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.267 -0400", hash_original_method = "D79206E9EE4BD2FB4F0103FA8C72904A", hash_generated_method = "AA0FA2AB0136AC30FB58D463C0D13AB9")
    private void deliverGenericMotionEvent(MotionEvent event, boolean sendDone) {
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } //End block
        final int source = event.getSource();
        final boolean isJoystick = (source & InputDevice.SOURCE_CLASS_JOYSTICK) != 0;
        {
            {
                updateJoystickDirection(event, false);
            } //End block
            finishMotionEvent(event, sendDone, false);
        } //End block
        {
            boolean var1480525DCF9F333BCCE9610B03BC6BD1_129649955 = (mView.dispatchGenericMotionEvent(event));
            {
                {
                    updateJoystickDirection(event, false);
                } //End block
                finishMotionEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            updateJoystickDirection(event, true);
            finishMotionEvent(event, sendDone, true);
        } //End block
        {
            finishMotionEvent(event, sendDone, false);
        } //End block
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.268 -0400", hash_original_method = "3F24F6EAAF68F5E1EBCC50D38D5B0024", hash_generated_method = "FE813DC9B88F68847891EB17C4564071")
    private void updateJoystickDirection(MotionEvent event, boolean synthesizeNewKeys) {
        final long time = event.getEventTime();
        final int metaState = event.getMetaState();
        final int deviceId = event.getDeviceId();
        final int source = event.getSource();
        int xDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_X));
        {
            xDirection = joystickAxisValueToDirection(event.getX());
        } //End block
        int yDirection = joystickAxisValueToDirection(event.getAxisValue(MotionEvent.AXIS_HAT_Y));
        {
            yDirection = joystickAxisValueToDirection(event.getY());
        } //End block
        {
            {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickXKeyCode = 0;
            } //End block
            mLastJoystickXDirection = xDirection;
            {
                mLastJoystickXKeyCode = xDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_RIGHT : KeyEvent.KEYCODE_DPAD_LEFT;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickXKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            } //End block
        } //End block
        {
            {
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_UP, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
                mLastJoystickYKeyCode = 0;
            } //End block
            mLastJoystickYDirection = yDirection;
            {
                mLastJoystickYKeyCode = yDirection > 0
                        ? KeyEvent.KEYCODE_DPAD_DOWN : KeyEvent.KEYCODE_DPAD_UP;
                deliverKeyEvent(new KeyEvent(time, time,
                        KeyEvent.ACTION_DOWN, mLastJoystickYKeyCode, 0, metaState,
                        deviceId, 0, KeyEvent.FLAG_FALLBACK, source), false);
            } //End block
        } //End block
        addTaint(event.getTaint());
        addTaint(synthesizeNewKeys);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.269 -0400", hash_original_method = "4A4EC0979E3C48040C37CBDD240E0778", hash_generated_method = "CDD50D374BE8234045281476585745E5")
    private boolean checkForLeavingTouchModeAndConsume(KeyEvent event) {
        final int action = event.getAction();
        {
            boolean var374764C2EBA0004373F7F9D216C18EBE_802197810 = ((event.getFlags() & KeyEvent.FLAG_KEEP_TOUCH_MODE) != 0);
        } //End collapsed parenthetic
        {
            boolean varC540748EA661E5534CCE6D53AFE70351_1284248884 = (isNavigationKey(event));
            {
                boolean varDCF046E768F735C43D4A4F2892DB8761_554471349 = (ensureTouchMode(false));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDC7BE1867293052F150F168518DBFDDE_1755748540 = (isTypingKey(event));
            {
                ensureTouchMode(false);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872777557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872777557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.270 -0400", hash_original_method = "DD7540FF4FE8EF5C7F3D3C1B535F6D84", hash_generated_method = "2AADB4BD736441D45B8AAB71EB9D1901")
     int enqueuePendingEvent(Object event, boolean sendDone) {
        int seq = mPendingEventSeq+1;
        seq = 0;
        mPendingEventSeq = seq;
        mPendingEvents.put(seq, event);
        addTaint(event.getTaint());
        addTaint(sendDone);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012598822 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012598822;
        // ---------- Original Method ----------
        //int seq = mPendingEventSeq+1;
        //if (seq < 0) seq = 0;
        //mPendingEventSeq = seq;
        //mPendingEvents.put(seq, event);
        //return sendDone ? seq : -seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.271 -0400", hash_original_method = "D1881A2DE4A478B1C2476E8789D90C4F", hash_generated_method = "F8C6FC87E4B4C16E80570ACF4DF573E3")
     Object retrievePendingEvent(int seq) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1847994876 = null; //Variable for return #1
        seq = -seq;
        Object event = mPendingEvents.get(seq);
        {
            mPendingEvents.remove(seq);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1847994876 = event;
        addTaint(seq);
        varB4EAC82CA7396A68D541C85D26508E83_1847994876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847994876;
        // ---------- Original Method ----------
        //if (seq < 0) seq = -seq;
        //Object event = mPendingEvents.get(seq);
        //if (event != null) {
            //mPendingEvents.remove(seq);
        //}
        //return event;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.271 -0400", hash_original_method = "7BC82D96B9DB6F7A084DA2256A5743DA", hash_generated_method = "06C11C0295246688E68D3D4982C4BF65")
    private void deliverKeyEvent(KeyEvent event, boolean sendDone) {
        {
            mInputEventDeliverTimeNanos = System.nanoTime();
        } //End block
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } //End block
        {
            finishKeyEvent(event, sendDone, false);
        } //End block
        {
            boolean var5290A33EAEDAF51EED599C106DE398FD_1856521321 = (mView.dispatchKeyEventPreIme(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            {
                int seq = enqueuePendingEvent(event, sendDone);
                imm.dispatchKeyEvent(mView.getContext(), seq, event, mInputMethodCallback);
            } //End block
        } //End block
        deliverKeyEventPostIme(event, sendDone);
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.272 -0400", hash_original_method = "1D388C4C66D020B7A8C536C50B24E128", hash_generated_method = "E7BFF04977CF57A6A7425128B942C259")
    private void handleFinishedEvent(int seq, boolean handled) {
        final KeyEvent event = (KeyEvent)retrievePendingEvent(seq);
        {
            final boolean sendDone = seq >= 0;
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
            {
                deliverKeyEventPostIme(event, sendDone);
            } //End block
        } //End block
        addTaint(seq);
        addTaint(handled);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.274 -0400", hash_original_method = "3773604D66AC7B7214885F4E3DA58090", hash_generated_method = "06A7F62083FA65EF6493A7544B758468")
    private void deliverKeyEventPostIme(KeyEvent event, boolean sendDone) {
        {
            mInputEventDeliverPostImeTimeNanos = System.nanoTime();
        } //End block
        {
            finishKeyEvent(event, sendDone, false);
        } //End block
        {
            boolean var972B8A8CC08694C2525DE534B4F8BB01_216253066 = (checkForLeavingTouchModeAndConsume(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        mFallbackEventHandler.preDispatchKeyEvent(event);
        {
            boolean var9386095FD83FC6C0A38FFA49591950FC_1648253512 = (mView.dispatchKeyEvent(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var85A8FDC8626CC7E23374B602A2E2C62C_1258322374 = (event.getAction() == KeyEvent.ACTION_DOWN
                && event.isCtrlPressed()
                && event.getRepeatCount() == 0
                && !KeyEvent.isModifierKey(event.getKeyCode()));
            {
                {
                    boolean varF97DC0BD6AE66CDC354B90DB1D102EE2_142620779 = (mView.dispatchKeyShortcutEvent(event));
                    {
                        finishKeyEvent(event, sendDone, true);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB867097ED2D7A136AEC6AB204A7A4421_2096230617 = (mFallbackEventHandler.dispatchKeyEvent(event));
            {
                finishKeyEvent(event, sendDone, true);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_1057650117 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                int direction = 0;
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_610900188 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1626838297 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_LEFT;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_504175597 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_RIGHT;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_DPAD_UP 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_1765954578 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_UP;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_UP 
                    //Begin case KeyEvent.KEYCODE_DPAD_DOWN 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_2094436510 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_DOWN;
                        } //End block
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_DPAD_DOWN 
                    //Begin case KeyEvent.KEYCODE_TAB 
                    {
                        boolean var3A3095F7575E47050F710FB26AF5006E_224428253 = (event.hasNoModifiers());
                        {
                            direction = View.FOCUS_FORWARD;
                        } //End block
                        {
                            boolean varC6F58190DE4A31A0CF9704EF99A62451_1723483332 = (event.hasModifiers(KeyEvent.META_SHIFT_ON));
                            {
                                direction = View.FOCUS_BACKWARD;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                    //End case KeyEvent.KEYCODE_TAB 
                } //End collapsed parenthetic
                {
                    View focused;
                    focused = mView.findFocus();
                    focused = null;
                    {
                        View v = focused.focusSearch(direction);
                        {
                            focused.getFocusedRect(mTempRect);
                            {
                                ((ViewGroup) mView).offsetDescendantRectToMyCoords(
                                    focused, mTempRect);
                                ((ViewGroup) mView).offsetRectIntoDescendantCoords(
                                    v, mTempRect);
                            } //End block
                            {
                                boolean var8E442CEC6A978F0FDB8EDCFD023A5F81_116684200 = (v.requestFocus(direction, mTempRect));
                                {
                                    playSoundEffect(
                                    SoundEffectConstants.getContantForFocusDirection(direction));
                                    finishKeyEvent(event, sendDone, true);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean varF5C20EE82F62ADD0C6A5E46AE0DD38DF_2102282411 = (mView.dispatchUnhandledMove(focused, direction));
                            {
                                finishKeyEvent(event, sendDone, true);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        finishKeyEvent(event, sendDone, false);
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.275 -0400", hash_original_method = "2621255CFED260FE88FD0E0DE76ACADD", hash_generated_method = "69A00624277FB176806394C9F31FD3AF")
    private void finishKeyEvent(KeyEvent event, boolean sendDone, boolean handled) {
        {
            finishInputEvent(event, handled);
        } //End block
        addTaint(event.getTaint());
        addTaint(sendDone);
        addTaint(handled);
        // ---------- Original Method ----------
        //if (sendDone) {
            //finishInputEvent(event, handled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.275 -0400", hash_original_method = "0FF9C383AA2E451EDBB7C2A5CA6E3F80", hash_generated_method = "12BE574BF3F1201CE287FC107D86E1D9")
     void setLocalDragState(Object obj) {
        mLocalDragState = obj;
        // ---------- Original Method ----------
        //mLocalDragState = obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.276 -0400", hash_original_method = "977584242F0720CC5E20503FC56D761D", hash_generated_method = "106498285DE2504CF6A9F83E29DF5E57")
    private void handleDragEvent(DragEvent event) {
        {
            final int what = event.mAction;
            {
                mView.dispatchDragEvent(event);
            } //End block
            {
                {
                    mCurrentDragView = null;
                    mDragDescription = event.mClipDescription;
                } //End block
                {
                    event.mClipDescription = mDragDescription;
                } //End block
                {
                    mDragPoint.set(event.mX, event.mY);
                    {
                        mTranslator.translatePointInScreenToAppWindow(mDragPoint);
                    } //End block
                    {
                        mDragPoint.offset(0, mCurScrollY);
                    } //End block
                    event.mX = mDragPoint.x;
                    event.mY = mDragPoint.y;
                } //End block
                final View prevDragView = mCurrentDragView;
                boolean result = mView.dispatchDragEvent(event);
                {
                    try 
                    {
                        {
                            sWindowSession.dragRecipientExited(mWindow);
                        } //End block
                        {
                            sWindowSession.dragRecipientEntered(mWindow);
                        } //End block
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                {
                    mDragDescription = null;
                    try 
                    {
                        sWindowSession.reportDropResult(mWindow, result);
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                {
                    setLocalDragState(null);
                } //End block
            } //End block
        } //End block
        event.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.276 -0400", hash_original_method = "504EE99E4FC1047B3EE4816C6C3CF55E", hash_generated_method = "79EB8953DDC45FC5FA0F03123CD143CB")
    public void handleDispatchSystemUiVisibilityChanged(SystemUiVisibilityInfo args) {
        {
            mSeq = args.seq;
            mAttachInfo.mForceReportNewAttributes = true;
            scheduleTraversals();
        } //End block
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.277 -0400", hash_original_method = "45F97324DFA9B47BC7B47DB7731173BB", hash_generated_method = "785C4186E4B16928BF21E5D2656A38D5")
    public void getLastTouchPoint(Point outLocation) {
        outLocation.x = (int) mLastTouchPoint.x;
        outLocation.y = (int) mLastTouchPoint.y;
        addTaint(outLocation.getTaint());
        // ---------- Original Method ----------
        //outLocation.x = (int) mLastTouchPoint.x;
        //outLocation.y = (int) mLastTouchPoint.y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.277 -0400", hash_original_method = "D8987F1AD41DCFCEC13505B3421C8BB0", hash_generated_method = "051B467B5AE36D1DCA8729F3237D117F")
    public void setDragFocus(View newDragTarget) {
        {
            mCurrentDragView = newDragTarget;
        } //End block
        // ---------- Original Method ----------
        //if (mCurrentDragView != newDragTarget) {
            //mCurrentDragView = newDragTarget;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.278 -0400", hash_original_method = "63BA605FA957D5097ED6886D9988BC53", hash_generated_method = "FBAA02019C1781552DC153D24AE956EA")
    private AudioManager getAudioManager() {
        AudioManager varB4EAC82CA7396A68D541C85D26508E83_579443849 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getAudioManager called when there is no mView");
        } //End block
        {
            mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_579443849 = mAudioManager;
        varB4EAC82CA7396A68D541C85D26508E83_579443849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579443849;
        // ---------- Original Method ----------
        //if (mView == null) {
            //throw new IllegalStateException("getAudioManager called when there is no mView");
        //}
        //if (mAudioManager == null) {
            //mAudioManager = (AudioManager) mView.getContext().getSystemService(Context.AUDIO_SERVICE);
        //}
        //return mAudioManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.278 -0400", hash_original_method = "C22EE439EF1C63381F42BE80F34ED0C5", hash_generated_method = "4F4E2ADBB685D16D99D3B3F65D6DE221")
    public AccessibilityInteractionController getAccessibilityInteractionController() {
        AccessibilityInteractionController varB4EAC82CA7396A68D541C85D26508E83_48664092 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("getAccessibilityInteractionController"
                    + " called when there is no mView");
        } //End block
        {
            mAccessibilityInteractionController = new AccessibilityInteractionController();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_48664092 = mAccessibilityInteractionController;
        varB4EAC82CA7396A68D541C85D26508E83_48664092.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_48664092;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.279 -0400", hash_original_method = "0B2FE2E2B393762D66EC0169ABC2799A", hash_generated_method = "2E19CB3C06E72197FACB06DF1FE4B5C3")
    private int relayoutWindow(WindowManager.LayoutParams params, int viewVisibility,
            boolean insetsPending) throws RemoteException {
        float appScale = mAttachInfo.mApplicationScale;
        boolean restore = false;
        {
            restore = true;
            params.backup();
            mTranslator.translateWindowLayout(params);
        } //End block
        {
            Log.d(TAG, "WindowLayout in layoutWindow:" + params);
        } //End block
        mPendingConfiguration.seq = 0;
        {
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
                mPendingConfiguration, mSurface);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            params.restore();
        } //End block
        {
            mTranslator.translateRectInScreenToAppWinFrame(mWinFrame);
            mTranslator.translateRectInScreenToAppWindow(mPendingContentInsets);
            mTranslator.translateRectInScreenToAppWindow(mPendingVisibleInsets);
        } //End block
        addTaint(params.getTaint());
        addTaint(viewVisibility);
        addTaint(insetsPending);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890275544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890275544;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.279 -0400", hash_original_method = "15B8C68C65C02C1955DF774990289073", hash_generated_method = "F564C5CE2197B90A2199960308757326")
    public void playSoundEffect(int effectId) {
        checkThread();
        try 
        {
            final AudioManager audioManager = getAudioManager();
            //Begin case SoundEffectConstants.CLICK 
            audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK);
            //End case SoundEffectConstants.CLICK 
            //Begin case SoundEffectConstants.NAVIGATION_DOWN 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_DOWN);
            //End case SoundEffectConstants.NAVIGATION_DOWN 
            //Begin case SoundEffectConstants.NAVIGATION_LEFT 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_LEFT);
            //End case SoundEffectConstants.NAVIGATION_LEFT 
            //Begin case SoundEffectConstants.NAVIGATION_RIGHT 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_RIGHT);
            //End case SoundEffectConstants.NAVIGATION_RIGHT 
            //Begin case SoundEffectConstants.NAVIGATION_UP 
            audioManager.playSoundEffect(AudioManager.FX_FOCUS_NAVIGATION_UP);
            //End case SoundEffectConstants.NAVIGATION_UP 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown effect id " + effectId +
                            " not defined in " + SoundEffectConstants.class.getCanonicalName());
            //End case default 
        } //End block
        catch (IllegalStateException e)
        {
            e.printStackTrace();
        } //End block
        addTaint(effectId);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.280 -0400", hash_original_method = "B8D922B767BD06C4283BB3EF0BFA3172", hash_generated_method = "D793A3CA6DB4FA5CB7DE57BF88796803")
    public boolean performHapticFeedback(int effectId, boolean always) {
        try 
        {
            boolean varFBBA9023D273BC1BC4D4CED056000D00_1536694546 = (sWindowSession.performHapticFeedback(mWindow, effectId, always));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(effectId);
        addTaint(always);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117653894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117653894;
        // ---------- Original Method ----------
        //try {
            //return sWindowSession.performHapticFeedback(mWindow, effectId, always);
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.281 -0400", hash_original_method = "220A5158C443CFE1D4535C372C690545", hash_generated_method = "4338181A95BA65115DD566F4A406401C")
    public View focusSearch(View focused, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_2030558819 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1807122049 = null; //Variable for return #2
        checkThread();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2030558819 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1807122049 = FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
        addTaint(focused.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_732664601; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_732664601 = varB4EAC82CA7396A68D541C85D26508E83_2030558819;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_732664601 = varB4EAC82CA7396A68D541C85D26508E83_1807122049;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_732664601.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_732664601;
        // ---------- Original Method ----------
        //checkThread();
        //if (!(mView instanceof ViewGroup)) {
            //return null;
        //}
        //return FocusFinder.getInstance().findNextFocus((ViewGroup) mView, focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.282 -0400", hash_original_method = "5C67D040EE10672AA68B296434D2F63D", hash_generated_method = "265CF6F642B6AAE7F0DC95CDCBD015E9")
    public void debug() {
        mView.debug();
        // ---------- Original Method ----------
        //mView.debug();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.283 -0400", hash_original_method = "818AD1A70B8E095131DC73E371E19514", hash_generated_method = "449F8CB372A0D0354D93F91CE8A5502A")
    public void dumpGfxInfo(PrintWriter pw, int[] info) {
        {
            getGfxInfo(mView, info);
        } //End block
        {
            info[0] = info[1] = 0;
        } //End block
        addTaint(pw.getTaint());
        addTaint(info[0]);
        // ---------- Original Method ----------
        //if (mView != null) {
            //getGfxInfo(mView, info);
        //} else {
            //info[0] = info[1] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.284 -0400", hash_original_method = "CD86B0B9CE453C77251859969963B0E8", hash_generated_method = "C38160F365F8EB8493BFAD7EC3B7CC48")
    private void getGfxInfo(View view, int[] info) {
        DisplayList displayList = view.mDisplayList;
        {
            info[1] += displayList.getSize();
        } //End block
        {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            {
                int i = 0;
                {
                    getGfxInfo(group.getChildAt(i), info);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(view.getTaint());
        addTaint(info[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.284 -0400", hash_original_method = "F971131E8183B74AE14F7AE1993EB770", hash_generated_method = "E79E0B4D4A02BEBAA11D919C7EA47BCB")
    public void die(boolean immediate) {
        {
            doDie();
        } //End block
        {
            sendEmptyMessage(DIE);
        } //End block
        addTaint(immediate);
        // ---------- Original Method ----------
        //if (immediate) {
            //doDie();
        //} else {
            //sendEmptyMessage(DIE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.285 -0400", hash_original_method = "8D1DF41E880ED97CD9EA450CBF8DEBA9", hash_generated_method = "96F25496A09A143BF4A89006E8CFFB46")
     void doDie() {
        checkThread();
        {
            {
                mAdded = false;
                dispatchDetachedFromWindow();
            } //End block
            {
                destroyHardwareRenderer();
                int viewVisibility = mView.getVisibility();
                boolean viewVisibilityChanged = mViewVisibility != viewVisibility;
                {
                    try 
                    {
                        {
                            boolean var9AE39921E95FF8EFBAECC8E0B3546A66_1241867935 = ((relayoutWindow(mWindowAttributes, viewVisibility, false)
                                & WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0);
                            {
                                sWindowSession.finishDrawing(mWindow);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    catch (RemoteException e)
                    { }
                } //End block
                mSurface.release();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.285 -0400", hash_original_method = "C21E5BD1C0448C03922FA84C1B8F3673", hash_generated_method = "BCCE470B2300B4BA5042983FDF1869E1")
    public void requestUpdateConfiguration(Configuration config) {
        Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        sendMessage(msg);
        addTaint(config.getTaint());
        // ---------- Original Method ----------
        //Message msg = obtainMessage(UPDATE_CONFIGURATION, config);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.286 -0400", hash_original_method = "83B5F7EEB6D7B3078A7769D15E86950B", hash_generated_method = "8B0C7B51612C6768308E296410004249")
    private void destroyHardwareRenderer() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.286 -0400", hash_original_method = "459EFA224EE61797FCF735DB24F377FF", hash_generated_method = "87B6E9DB9289D060D4707659A1D03C60")
    public void dispatchFinishedEvent(int seq, boolean handled) {
        Message msg = obtainMessage(FINISHED_EVENT);
        msg.arg1 = seq;
        msg.arg2 = handled ? 1 : 0;
        sendMessage(msg);
        addTaint(seq);
        addTaint(handled);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(FINISHED_EVENT);
        //msg.arg1 = seq;
        //msg.arg2 = handled ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.287 -0400", hash_original_method = "176F47B7EDC9D70A69736114EF5A25ED", hash_generated_method = "AF36DF707A16F5965A2EB571B8FAD2DA")
    public void dispatchResized(int w, int h, Rect coveredInsets,
            Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
        Message msg = obtainMessage(reportDraw ? RESIZED_REPORT :RESIZED);//DSFIXME:  CODE0008: Nested ternary operator in expression
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
        addTaint(w);
        addTaint(h);
        addTaint(coveredInsets.getTaint());
        addTaint(visibleInsets.getTaint());
        addTaint(reportDraw);
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.287 -0400", hash_original_method = "42F15B8B44D9B8805537AB8032035046", hash_generated_method = "CF4792E5B47B02D252A8852FDDE1D2D9")
    private void enqueueInputEvent(Message msg, long when) {
        InputEventMessage inputMessage = InputEventMessage.obtain(msg);
        {
            mPendingInputEvents = inputMessage;
        } //End block
        {
            InputEventMessage currMessage = mPendingInputEvents;
            {
                currMessage = currMessage.mNext;
            } //End block
            currMessage.mNext = inputMessage;
        } //End block
        sendEmptyMessageAtTime(PROCESS_INPUT_EVENTS, when);
        addTaint(msg.getTaint());
        addTaint(when);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.287 -0400", hash_original_method = "CF232D7D6B258A687467B35A15A72FA0", hash_generated_method = "CB5259B78B747326AE22E0299BB9F21E")
    public void dispatchKey(KeyEvent event) {
        dispatchKey(event, false);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //dispatchKey(event, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.288 -0400", hash_original_method = "40FF3F3DF013E72EC5E96E0A49136BE3", hash_generated_method = "35B8AEE341482F4264BBAE7CB4DCEDAC")
    private void dispatchKey(KeyEvent event, boolean sendDone) {
        {
            boolean var614B93C66D10470F75E816C5D006D92E_1888009158 = (false && event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    boolean var93BBE93F11B74C6BE1CA3CCD54D7C4DB_1716923787 = (event.getKeyCode() == KeyEvent.KEYCODE_CAMERA);
                    {
                        Log.d("keydisp", "===================================================");
                        Log.d("keydisp", "Focused view Hierarchy is:");
                        debug();
                        Log.d("keydisp", "===================================================");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        Message msg = obtainMessage(DISPATCH_KEY);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        addTaint(event.getTaint());
        addTaint(sendDone);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.288 -0400", hash_original_method = "F90A161CC4BD8998AC3B193B63EB7E53", hash_generated_method = "44A86CDE9247F07909E5EC2BD09E72B9")
    private void dispatchMotion(MotionEvent event, boolean sendDone) {
        int source = event.getSource();
        {
            dispatchPointer(event, sendDone);
        } //End block
        {
            dispatchTrackball(event, sendDone);
        } //End block
        {
            dispatchGenericMotion(event, sendDone);
        } //End block
        addTaint(event.getTaint());
        addTaint(sendDone);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.288 -0400", hash_original_method = "DD56557FEAC8CACD87B056C5C0C702D1", hash_generated_method = "54B1C29EED681DC31257BE63263FECE9")
    private void dispatchPointer(MotionEvent event, boolean sendDone) {
        Message msg = obtainMessage(DISPATCH_POINTER);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_POINTER);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.289 -0400", hash_original_method = "CA2BFA17163311E1AAAA771C667E27EE", hash_generated_method = "2A4C3F44DB799E38FE764C831B1CB387")
    private void dispatchTrackball(MotionEvent event, boolean sendDone) {
        Message msg = obtainMessage(DISPATCH_TRACKBALL);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_TRACKBALL);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.289 -0400", hash_original_method = "BF71C2E204EC82729A1EA0969E06871A", hash_generated_method = "71620293CBEC01103FB8987F762DF6D3")
    private void dispatchGenericMotion(MotionEvent event, boolean sendDone) {
        Message msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        msg.obj = event;
        msg.arg1 = sendDone ? 1 : 0;
        enqueueInputEvent(msg, event.getEventTime());
        addTaint(event.getTaint());
        addTaint(sendDone);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GENERIC_MOTION);
        //msg.obj = event;
        //msg.arg1 = sendDone ? 1 : 0;
        //enqueueInputEvent(msg, event.getEventTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.290 -0400", hash_original_method = "609DE6F7AC6918A6ED5E47157E290835", hash_generated_method = "68402BCEBCDA4A326267CB20EAF26532")
    public void dispatchAppVisibility(boolean visible) {
        Message msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        msg.arg1 = visible ? 1 : 0;
        sendMessage(msg);
        addTaint(visible);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_APP_VISIBILITY);
        //msg.arg1 = visible ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.290 -0400", hash_original_method = "4D3A3DC5DC743660725FA6A11A372A07", hash_generated_method = "C12E8F86927C6A1FB5221B95AE3FC2E7")
    public void dispatchGetNewSurface() {
        Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = obtainMessage(DISPATCH_GET_NEW_SURFACE);
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.291 -0400", hash_original_method = "0CD487AEEAC72879653D2DB3DCCCEB86", hash_generated_method = "95FEF1F6DA58CB541A5EE5BA08B89D4F")
    public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
        Message msg = Message.obtain();
        msg.what = WINDOW_FOCUS_CHANGED;
        msg.arg1 = hasFocus ? 1 : 0;
        msg.arg2 = inTouchMode ? 1 : 0;
        sendMessage(msg);
        addTaint(hasFocus);
        addTaint(inTouchMode);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = WINDOW_FOCUS_CHANGED;
        //msg.arg1 = hasFocus ? 1 : 0;
        //msg.arg2 = inTouchMode ? 1 : 0;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.291 -0400", hash_original_method = "DCE84E54CF89AABF2B838105364C2821", hash_generated_method = "066CAEA8EC8ABA4CDC6F1321B9434F4C")
    public void dispatchCloseSystemDialogs(String reason) {
        Message msg = Message.obtain();
        msg.what = CLOSE_SYSTEM_DIALOGS;
        msg.obj = reason;
        sendMessage(msg);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = CLOSE_SYSTEM_DIALOGS;
        //msg.obj = reason;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.291 -0400", hash_original_method = "786F6A89EC1BE66218A42841DB30F7AC", hash_generated_method = "72C1A778E056088FBDAE1E9187F4AECE")
    public void dispatchDragEvent(DragEvent event) {
        int what;
        {
            boolean varB24B6A2E894360805412F219C1784FDD_101519985 = (event.getAction() == DragEvent.ACTION_DRAG_LOCATION);
            {
                what = DISPATCH_DRAG_LOCATION_EVENT;
                removeMessages(what);
            } //End block
            {
                what = DISPATCH_DRAG_EVENT;
            } //End block
        } //End collapsed parenthetic
        Message msg = obtainMessage(what, event);
        sendMessage(msg);
        addTaint(event.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.292 -0400", hash_original_method = "95F6C6AC5462FA09198431CBF084B2BE", hash_generated_method = "6A4BE23A6F68495290C410ADF5F1B638")
    public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
            int localValue, int localChanges) {
        SystemUiVisibilityInfo args = new SystemUiVisibilityInfo();
        args.seq = seq;
        args.globalVisibility = globalVisibility;
        args.localValue = localValue;
        args.localChanges = localChanges;
        sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
        addTaint(seq);
        addTaint(globalVisibility);
        addTaint(localValue);
        addTaint(localChanges);
        // ---------- Original Method ----------
        //SystemUiVisibilityInfo args = new SystemUiVisibilityInfo();
        //args.seq = seq;
        //args.globalVisibility = globalVisibility;
        //args.localValue = localValue;
        //args.localChanges = localChanges;
        //sendMessage(obtainMessage(DISPATCH_SYSTEM_UI_VISIBILITY, args));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.293 -0400", hash_original_method = "DE2DA8F2C91C4BAC5E71DE180C591B82", hash_generated_method = "9D71FEC784F880F346A2146961A17FC6")
    private void sendAccessibilityEvents() {
        {
            boolean var6B92FF47081CEAA2DFA035B3AA7C5808_1495195856 = (!mAccessibilityManager.isEnabled());
        } //End collapsed parenthetic
        mView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        View focusedView = mView.findFocus();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.294 -0400", hash_original_method = "3EBD42CE7AD44788B8B5975E509C0AD4", hash_generated_method = "6430AC1E6ACAAA4B282708CE6E24FA0A")
    private void postSendWindowContentChangedCallback() {
        {
            mSendWindowContentChangedAccessibilityEvent =
                new SendWindowContentChangedAccessibilityEvent();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.294 -0400", hash_original_method = "B38BF7B18A0D0C0D14C2E79D97568CE9", hash_generated_method = "FAC2CD6D88CE2CBA23C83AAB105F610D")
    private void removeSendWindowContentChangedCallback() {
        {
            removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendWindowContentChangedAccessibilityEvent != null) {
            //removeCallbacks(mSendWindowContentChangedAccessibilityEvent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.294 -0400", hash_original_method = "3A017950A97502A630256434B0EBF7E8", hash_generated_method = "8A6052FAEFEE4A6C389CD1C9F3B88CB8")
    public boolean showContextMenuForChild(View originalView) {
        addTaint(originalView.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759532185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_759532185;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.295 -0400", hash_original_method = "492AE6A9C9C6F2F7E659E19901E3E487", hash_generated_method = "EE8504237A9A6C085080EF40421553A7")
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1678552509 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1678552509 = null;
        addTaint(originalView.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1678552509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1678552509;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.295 -0400", hash_original_method = "FB735C9133B887C07751FC797F168B65", hash_generated_method = "A7DA1CFB4829C8E1B84DF1FFE066706B")
    public void createContextMenu(ContextMenu menu) {
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.295 -0400", hash_original_method = "C40FC95C25B6655ACCA9227D471DC892", hash_generated_method = "FB4FD2CE39B9A19ED55CF997B56E8AAD")
    public void childDrawableStateChanged(View child) {
        addTaint(child.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.296 -0400", hash_original_method = "975E17A58706A43B9CF06D84428C706E", hash_generated_method = "664567D7FF6311D6E26B5AA8E4367B00")
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        mAccessibilityManager.sendAccessibilityEvent(event);
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_521087904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_521087904;
        // ---------- Original Method ----------
        //if (mView == null) {
            //return false;
        //}
        //mAccessibilityManager.sendAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.296 -0400", hash_original_method = "C963D9A99CD7BE986B275021EA99CB95", hash_generated_method = "D0DF8E06106DDB7707F49988AFFA48F4")
     void checkThread() {
        {
            boolean varAB6333097DFD9DC250CE668EF24070FA_1545028585 = (mThread != Thread.currentThread());
            {
                if (DroidSafeAndroidRuntime.control) throw new CalledFromWrongThreadException(
                    "Only the original thread that created a view hierarchy can touch its views.");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mThread != Thread.currentThread()) {
            //throw new CalledFromWrongThreadException(
                    //"Only the original thread that created a view hierarchy can touch its views.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.296 -0400", hash_original_method = "F9834E22E1AF22274F19B27CD50E21E5", hash_generated_method = "8C6445ECC283015C0E55FA20D0DB11D5")
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        addTaint(disallowIntercept);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_method = "176476ED7A31EA7594378C530DAA6036", hash_generated_method = "D3195F1636E8D3B62F98B0415FB92368")
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        boolean var01DB072A3F092F21B9D32C2DD4D3AD8E_587281658 = (scrollToRectOrFocus(rectangle, immediate));
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_599228080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_599228080;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "87B176B1B575D0EBABCED2EA986D231E", hash_generated_field = "47DADDCDE2ABE98E0EA742CE6D950BCA")

        Rect coveredInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "A61C7CD3070C24C4D07AD92D2435193C", hash_generated_field = "0B179B80C8AEF7EE8B7A9887F27D40FA")

        Rect visibleInsets;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "6D069C9B9BA8B31B534F29F6B998EB02", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_method = "50B840B7E2FD8E0275C71397DAD0B09A", hash_generated_method = "50B840B7E2FD8E0275C71397DAD0B09A")
        public ResizedInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class SystemUiVisibilityInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "9AA0E19EC2BEA0A624663676438F19F7", hash_generated_field = "29F921E441BDF940DE75A15B6BF90A8A")

        int globalVisibility;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "A4F2C94518DDF678500A137497CD9AFC", hash_generated_field = "1D88C8081D2F96806DB5C538B6E7C0F8")

        int localValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "D681324457E353443A7299399AC9C35A", hash_generated_field = "824A34BA64EB40D64E4FA95CF88B8DD6")

        int localChanges;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_method = "A01B0E4A631704C3007E2CC2ECBBD6C3", hash_generated_method = "A01B0E4A631704C3007E2CC2ECBBD6C3")
        public SystemUiVisibilityInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static class InputEventMessage {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "2D41D548AF5E6C9BAD3BF2AC7B0EDE61")

        Message mMessage;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "BB8AFFB0007C8D035A06590D15408355")

        InputEventMessage mNext;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.297 -0400", hash_original_method = "B714885B0648B0EB69373E467D5A2ACF", hash_generated_method = "5C7FFAA5DA7B01CBEE7862EEC63062E5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.298 -0400", hash_original_method = "9F2D00AD0B3B7E97E6983E3E4DE01E8D", hash_generated_method = "FF5788078DC74AE3CD4E25C6ECEF7407")
        public void recycle() {
            mMessage.recycle();
            {
                {
                    mNext = sPool;
                    sPool = this;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.298 -0400", hash_original_field = "695C1FB30F6443A40182A7409583CA63", hash_generated_field = "D5B99AC4B86CE940DBBD3CF3FA1D542C")

        private static final Object sPoolSync = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.298 -0400", hash_original_field = "0DDC63886CD8DB777504574D2935937E", hash_generated_field = "3276E3FE464DBE4BDC4F9753A4DD418D")

        private static InputEventMessage sPool;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.298 -0400", hash_original_field = "4F049A98A9127B46EEEAAAE7FA453CDC", hash_generated_field = "A60993B78066ACEFAC0F4A6F4AB10BB4")

        private static int sPoolSize = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.298 -0400", hash_original_field = "EB2583C9A133F7C44A9BFAD1B17484D6", hash_generated_field = "FB8E412EAB46029C42E8E38ED918C6D9")

        private static final int MAX_POOL_SIZE = 10;
    }


    
    class TakenSurfaceHolder extends BaseSurfaceHolder {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.298 -0400", hash_original_method = "C250C7CF3696759C39C0C66232FB4E2F", hash_generated_method = "C250C7CF3696759C39C0C66232FB4E2F")
        public TakenSurfaceHolder ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.299 -0400", hash_original_method = "93900AD5EB4A5A0D65615E175C2FC0CA", hash_generated_method = "2C1BB336E518A3E99AD42D8EC1455512")
        @Override
        public boolean onAllowLockCanvas() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362738104 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362738104;
            // ---------- Original Method ----------
            //return mDrawingAllowed;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.299 -0400", hash_original_method = "CAFD67152D224915C2628F6ACAAF5E06", hash_generated_method = "769E8A917A2AE0CACCF50C3D308C76DF")
        @Override
        public void onRelayoutContainer() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.299 -0400", hash_original_method = "E07C2927AF02C0614ECCFDEAF72047C2", hash_generated_method = "00D2E8D3D11EED752DB55D1E26F8B57D")
        public void setFormat(int format) {
            ((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
            addTaint(format);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceFormat(format);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.299 -0400", hash_original_method = "EE34E0B82BE2B114D60991753727E9A6", hash_generated_method = "B3E1BE9B445A071C881095BE14A0671E")
        public void setType(int type) {
            ((RootViewSurfaceTaker)mView).setSurfaceType(type);
            addTaint(type);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceType(type);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.300 -0400", hash_original_method = "65C8D4CF87AA6164C88CB73B7231A722", hash_generated_method = "F372C0B52A7977F3E6CD7075DE72C5D9")
        @Override
        public void onUpdateSurface() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Shouldn't be here");
            // ---------- Original Method ----------
            //throw new IllegalStateException("Shouldn't be here");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.300 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "3C714ECAB857257CA09657659AC224B3")
        public boolean isCreating() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790601217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_790601217;
            // ---------- Original Method ----------
            //return mIsCreating;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.300 -0400", hash_original_method = "DFAAE278D74727ACF1AA5508094F804D", hash_generated_method = "1F51570B7E91C27DDDF291F2A7C4A650")
        @Override
        public void setFixedSize(int width, int height) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
                    "Currently only support sizing from layout");
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException(
                    //"Currently only support sizing from layout");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.301 -0400", hash_original_method = "21F6CF6D8B53BD856057ED05ABC33177", hash_generated_method = "083D4B49DEF233181D9ACB249C6F9D3C")
        public void setKeepScreenOn(boolean screenOn) {
            ((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
            addTaint(screenOn);
            // ---------- Original Method ----------
            //((RootViewSurfaceTaker)mView).setSurfaceKeepScreenOn(screenOn);
        }

        
    }


    
    static class InputMethodCallback extends IInputMethodCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.301 -0400", hash_original_field = "BDC69E2933EF10AA19C929361BF070F9", hash_generated_field = "E7FFD6E9BC298C91066F7F076BB25FC3")

        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.301 -0400", hash_original_method = "54191F901FEF749694D67ED7BF80E958", hash_generated_method = "94B33F5DBF40614378A9EE46EF7CB527")
        public  InputMethodCallback(ViewRootImpl viewAncestor) {
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.301 -0400", hash_original_method = "BE17249E230FCA094C5B0C5E3A1F0AA4", hash_generated_method = "FE5D050578201C317F86CB578C1D5E20")
        public void finishedEvent(int seq, boolean handled) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchFinishedEvent(seq, handled);
            } //End block
            addTaint(seq);
            addTaint(handled);
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchFinishedEvent(seq, handled);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.302 -0400", hash_original_method = "93549AC7AA704598E881A2A0D800AB4C", hash_generated_method = "B59F51822D7ED309BAF5863A034576FE")
        public void sessionCreated(IInputMethodSession session) {
            addTaint(session.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static class W extends IWindow.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.302 -0400", hash_original_field = "BDC69E2933EF10AA19C929361BF070F9", hash_generated_field = "E7FFD6E9BC298C91066F7F076BB25FC3")

        private WeakReference<ViewRootImpl> mViewAncestor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.302 -0400", hash_original_method = "D1CF0E60435976F2AA38BD5BC7DA8E27", hash_generated_method = "B0B8B7CF155794D34CA9E098CB8D485B")
          W(ViewRootImpl viewAncestor) {
            mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mViewAncestor = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.303 -0400", hash_original_method = "A648B76CE506B7CD274906DE238C17D8", hash_generated_method = "8071641679D7572CEF481A80D7660184")
        public void resized(int w, int h, Rect coveredInsets, Rect visibleInsets,
                boolean reportDraw, Configuration newConfig) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        newConfig);
            } //End block
            addTaint(w);
            addTaint(h);
            addTaint(coveredInsets.getTaint());
            addTaint(visibleInsets.getTaint());
            addTaint(reportDraw);
            addTaint(newConfig.getTaint());
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchResized(w, h, coveredInsets, visibleInsets, reportDraw,
                        //newConfig);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.304 -0400", hash_original_method = "EB98E21C67C8D9A44F58CD671F491CDA", hash_generated_method = "20027A58052D13EC03A049DA31534DBA")
        public void dispatchAppVisibility(boolean visible) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchAppVisibility(visible);
            } //End block
            addTaint(visible);
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchAppVisibility(visible);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.304 -0400", hash_original_method = "5CE742A9FFA814199F790759E49D980E", hash_generated_method = "DAB8B79BB7B2F06D21315E73FB3529F7")
        public void dispatchGetNewSurface() {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchGetNewSurface();
            } //End block
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchGetNewSurface();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.304 -0400", hash_original_method = "294D771D49852BEC83940B0D8623D316", hash_generated_method = "6DF4159C7915426D68EFFB0A89968123")
        public void windowFocusChanged(boolean hasFocus, boolean inTouchMode) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.windowFocusChanged(hasFocus, inTouchMode);
            } //End block
            addTaint(hasFocus);
            addTaint(inTouchMode);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.305 -0400", hash_original_method = "BAC64B61AF453BEA5AB28D214B8FF7C5", hash_generated_method = "FE693F5A43BD4CB40BB998C69F34826D")
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                final View view = viewAncestor.mView;
                {
                    {
                        boolean varD985B2C74752F819AC5BC1C5B2498154_1118589209 = (checkCallingPermission(Manifest.permission.DUMP) !=
                            PackageManager.PERMISSION_GRANTED);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException("Insufficient permissions to invoke"
                                + " executeCommand() from pid=" + Binder.getCallingPid()
                                + ", uid=" + Binder.getCallingUid());
                        } //End block
                    } //End collapsed parenthetic
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
            addTaint(command.getTaint());
            addTaint(parameters.getTaint());
            addTaint(out.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.306 -0400", hash_original_method = "0341134904B032AC1241DC2205E79E01", hash_generated_method = "2AE31E0301A2289D687D50B423CDBA7C")
        public void closeSystemDialogs(String reason) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchCloseSystemDialogs(reason);
            } //End block
            addTaint(reason.getTaint());
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchCloseSystemDialogs(reason);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.306 -0400", hash_original_method = "0D1309853D34ED0E4A19A33B54F85778", hash_generated_method = "4F14287C5C0F3B4290D636D0A473A03F")
        public void dispatchWallpaperOffsets(float x, float y, float xStep, float yStep,
                boolean sync) {
            {
                try 
                {
                    sWindowSession.wallpaperOffsetsComplete(asBinder());
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            addTaint(x);
            addTaint(y);
            addTaint(xStep);
            addTaint(yStep);
            addTaint(sync);
            // ---------- Original Method ----------
            //if (sync) {
                //try {
                    //sWindowSession.wallpaperOffsetsComplete(asBinder());
                //} catch (RemoteException e) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.306 -0400", hash_original_method = "084CB00632E8F4F79253F4CBB0703969", hash_generated_method = "B3351A2BFA143752474CA3E1DF77C84C")
        public void dispatchWallpaperCommand(String action, int x, int y,
                int z, Bundle extras, boolean sync) {
            {
                try 
                {
                    sWindowSession.wallpaperCommandComplete(asBinder(), null);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            addTaint(action.getTaint());
            addTaint(x);
            addTaint(y);
            addTaint(z);
            addTaint(extras.getTaint());
            addTaint(sync);
            // ---------- Original Method ----------
            //if (sync) {
                //try {
                    //sWindowSession.wallpaperCommandComplete(asBinder(), null);
                //} catch (RemoteException e) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_method = "AE33DC8C57E72B3B1EEF7B37E6DC4CB6", hash_generated_method = "54E1C434DFBE7A5BD540CE4D8EC48BFD")
        public void dispatchDragEvent(DragEvent event) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchDragEvent(event);
            } //End block
            addTaint(event.getTaint());
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchDragEvent(event);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_method = "0BC30404A661769E03F23017D2DE8196", hash_generated_method = "211D6089FF224F057D625E3C81AF9F2C")
        public void dispatchSystemUiVisibilityChanged(int seq, int globalVisibility,
                int localValue, int localChanges) {
            final ViewRootImpl viewAncestor = mViewAncestor.get();
            {
                viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        localValue, localChanges);
            } //End block
            addTaint(seq);
            addTaint(globalVisibility);
            addTaint(localValue);
            addTaint(localChanges);
            // ---------- Original Method ----------
            //final ViewRootImpl viewAncestor = mViewAncestor.get();
            //if (viewAncestor != null) {
                //viewAncestor.dispatchSystemUiVisibilityChanged(seq, globalVisibility,
                        //localValue, localChanges);
            //}
        }

        
    }


    
    static final class TrackballAxis {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "722609B4032E08961786F0112C7E37CB")

        float position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "B29619EA76E3BF5BA77E443C78C9D903", hash_generated_field = "2BC82C89B8860ABF3FA89A1E7B3206F3")

        float absPosition;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "FD9F905F7F3D9B6366C514E37B686214", hash_generated_field = "F2035D00830CD97606C06BFD7F9DAD98")

        float acceleration = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "F34DECEAD687C48B7FAF16267CBFC237", hash_generated_field = "629DD7870B747F7AC2FDA49880D52BD5")

        long lastMoveTime = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "2764CA9D34E90313978D044F27AE433B", hash_generated_field = "4351D9E8E936913B3754B1B6ADCCBF7A")

        int step;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "736007832D2167BAAAE763FD3A3F3CF1", hash_generated_field = "32FF19239F28E132D49E8333CE74D2D7")

        int dir;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_field = "5F7D2E7F870DA0C9CD0B93AD0ADF0585", hash_generated_field = "887ADC84C7F0FC3F8C0B95BBC171A673")

        int nonAccelMovement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.307 -0400", hash_original_method = "D5D0F3DD2FCFEEF1D3847F5A318F142A", hash_generated_method = "D5D0F3DD2FCFEEF1D3847F5A318F142A")
        public TrackballAxis ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.308 -0400", hash_original_method = "A6304CADA1EF057D91BA6FF70064FCCC", hash_generated_method = "94AD87BF947D2DA6B9302A4900B6F256")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.308 -0400", hash_original_method = "7BE12B55CFE54AFD4A89AB866136213C", hash_generated_method = "171D88E5960AC47B6E29743CA9C007EC")
         float collect(float off, long time, String axis) {
            long normTime;
            {
                normTime = (long)(off * FAST_MOVE_TIME);
                {
                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                } //End block
                dir = 1;
            } //End block
            {
                normTime = (long)((-off) * FAST_MOVE_TIME);
                {
                    position = 0;
                    step = 0;
                    acceleration = 1;
                    lastMoveTime = 0;
                } //End block
                dir = -1;
            } //End block
            {
                normTime = 0;
            } //End block
            {
                long delta = time - lastMoveTime;
                lastMoveTime = time;
                float acc = acceleration;
                {
                    float scale = (normTime-delta) * ACCEL_MOVE_SCALING_FACTOR;
                    acc *= scale;
                    acceleration = acc < MAX_ACCELERATION ? acc : MAX_ACCELERATION;
                } //End block
                {
                    float scale = (delta-normTime) * ACCEL_MOVE_SCALING_FACTOR;
                    acc /= scale;
                    acceleration = acc > 1 ? acc : 1;
                } //End block
            } //End block
            position += off;
            float var529C98EBF363E511405F79C0EF23EDF4_220545511 = ((absPosition = Math.abs(position)));
            addTaint(axis.getTaint());
            float var546ADE640B6EDFBC8A086EF31347E768_604589880 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_604589880;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.309 -0400", hash_original_method = "94A3484B43A305FA2D2533E09119590B", hash_generated_method = "2A83D12A747D4B504D390A21AF079DCB")
         int generate(float precision) {
            int movement = 0;
            nonAccelMovement = 0;
            {
                int dir;
                dir = 1;
                dir = -1;
                //Begin case 0 
                movement += dir;
                //End case 0 
                //Begin case 0 
                nonAccelMovement += dir;
                //End case 0 
                //Begin case 0 
                step = 1;
                //End case 0 
                //Begin case 1 
                movement += dir;
                //End case 1 
                //Begin case 1 
                nonAccelMovement += dir;
                //End case 1 
                //Begin case 1 
                position += dir > 0 ? -2 : 2;
                //End case 1 
                //Begin case 1 
                absPosition = Math.abs(position);
                //End case 1 
                //Begin case 1 
                step = 2;
                //End case 1 
                //Begin case default 
                movement += dir;
                //End case default 
                //Begin case default 
                position += dir >= 0 ? -1 : 1;
                //End case default 
                //Begin case default 
                absPosition = Math.abs(position);
                //End case default 
                //Begin case default 
                float acc = acceleration;
                //End case default 
                //Begin case default 
                acc *= 1.1f;
                //End case default 
                //Begin case default 
                acceleration = acc < MAX_ACCELERATION ? acc : acceleration;
                //End case default 
            } //End block
            addTaint(precision);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013071740 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013071740;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.309 -0400", hash_original_field = "FFB8D9084F5E7C4FE0D8B75212BB972A", hash_generated_field = "973768C090750F2E47DF477502675CB2")

        static final float MAX_ACCELERATION = 20;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.309 -0400", hash_original_field = "21FFA872A4349714F48F231AF43BA975", hash_generated_field = "107EAA5D46224CB4A8CF941F26CA7ECA")

        static final long FAST_MOVE_TIME = 150;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.309 -0400", hash_original_field = "8592CB949A3002098EAFA7A362CA67B9", hash_generated_field = "F2C6BC14D2039A7C27D6C313A91A0FF8")

        static final float ACCEL_MOVE_SCALING_FACTOR = (1.0f/40);
    }


    
    public static final class CalledFromWrongThreadException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.310 -0400", hash_original_method = "D704015D17B148E0274888D3BE6B5A1B", hash_generated_method = "5206D6D9B9B192FA36F61484BBA93ECD")
        public  CalledFromWrongThreadException(String msg) {
            super(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    static final class RunQueue {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.310 -0400", hash_original_field = "EF3FD8395D5A4D4B896DE1728B5B7AFF", hash_generated_field = "F821D9D70BB932D42D3D9D491D5A29A1")

        private final ArrayList<HandlerAction> mActions = new ArrayList<HandlerAction>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.310 -0400", hash_original_method = "9D853D73EE638AB90ACD5CD9573763A9", hash_generated_method = "9D853D73EE638AB90ACD5CD9573763A9")
        public RunQueue ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.310 -0400", hash_original_method = "D30AD5886AAB6A1562A9D91A9C03E0DF", hash_generated_method = "C4D520331B8FA12D47566FA3AFA8AF6A")
         void post(Runnable action) {
            postDelayed(action, 0);
            addTaint(action.getTaint());
            // ---------- Original Method ----------
            //postDelayed(action, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.310 -0400", hash_original_method = "37D90AC712BBF73BCC19C8079034F8F1", hash_generated_method = "B94B581B45F5A4C3C2321430081716B9")
         void postDelayed(Runnable action, long delayMillis) {
            HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = action;
            handlerAction.delay = delayMillis;
            {
                mActions.add(handlerAction);
            } //End block
            addTaint(action.getTaint());
            addTaint(delayMillis);
            // ---------- Original Method ----------
            //HandlerAction handlerAction = new HandlerAction();
            //handlerAction.action = action;
            //handlerAction.delay = delayMillis;
            //synchronized (mActions) {
                //mActions.add(handlerAction);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.311 -0400", hash_original_method = "5BA3715297222A78241D425B9BCC6DE7", hash_generated_method = "7EF3446A6DFE34B7EED0EEEB5D84709D")
         void removeCallbacks(Runnable action) {
            final HandlerAction handlerAction = new HandlerAction();
            handlerAction.action = action;
            {
                final ArrayList<HandlerAction> actions = mActions;
                {
                    boolean var36C1E9EF466D02D50DB2A2AD92DBF5C4_1339221730 = (actions.remove(handlerAction));
                } //End collapsed parenthetic
            } //End block
            addTaint(action.getTaint());
            // ---------- Original Method ----------
            //final HandlerAction handlerAction = new HandlerAction();
            //handlerAction.action = action;
            //synchronized (mActions) {
                //final ArrayList<HandlerAction> actions = mActions;
                //while (actions.remove(handlerAction)) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.311 -0400", hash_original_method = "3626F7B757A14315643B29FE9818088B", hash_generated_method = "26BD1B6E92F8E8B25AE5A7E2E3855AC1")
         void executeActions(Handler handler) {
            {
                final ArrayList<HandlerAction> actions = mActions;
                final int count = actions.size();
                {
                    int i = 0;
                    {
                        final HandlerAction handlerAction = actions.get(i);
                        handler.postDelayed(handlerAction.action, handlerAction.delay);
                    } //End block
                } //End collapsed parenthetic
                actions.clear();
            } //End block
            addTaint(handler.getTaint());
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.311 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "6E604B84976ABCF0C30A63D2F996D309")

            Runnable action;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.311 -0400", hash_original_field = "7243F8BE75253AFBADF7477867021F8B", hash_generated_field = "D26E4607AC64CA745B70892C422A8C3F")

            long delay;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.311 -0400", hash_original_method = "30472C53850B994B9A76B3EFD24AA1BA", hash_generated_method = "30472C53850B994B9A76B3EFD24AA1BA")
            public HandlerAction ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.312 -0400", hash_original_method = "EC304D8CC82834BC90F0FBE66AB5A5B9", hash_generated_method = "E7851E37B5419C6F9081159FCDC02BBD")
            @Override
            public boolean equals(Object o) {
                {
                    boolean var282528ACEB1CC10074B7BD702EFB8F50_1060288591 = (o == null || getClass() != o.getClass());
                } //End collapsed parenthetic
                HandlerAction that = (HandlerAction) o;
                boolean varB89771406AB9E6A784E553026517A2DD_1590966239 = (!(action != null ? !action.equals(that.action) : that.action != null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
                addTaint(o.getTaint());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545245948 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545245948;
                // ---------- Original Method ----------
                //if (this == o) return true;
                //if (o == null || getClass() != o.getClass()) return false;
                //HandlerAction that = (HandlerAction) o;
                //return !(action != null ? !action.equals(that.action) : that.action != null);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.312 -0400", hash_original_method = "09AD30FBB7C8AE284E2A2DAD39966BF7", hash_generated_method = "C7BB2EDFE8098D80789B49461C6453F5")
            @Override
            public int hashCode() {
                int result;
                result = action.hashCode();
                result = 0;
                result = 31 * result + (int) (delay ^ (delay >>> 32));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_151596583 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_151596583;
                // ---------- Original Method ----------
                //int result = action != null ? action.hashCode() : 0;
                //result = 31 * result + (int) (delay ^ (delay >>> 32));
                //return result;
            }

            
        }


        
    }


    
    final class AccessibilityInteractionConnectionManager implements AccessibilityStateChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.313 -0400", hash_original_method = "B130C22D2DF300A6E0FC543B73826678", hash_generated_method = "B130C22D2DF300A6E0FC543B73826678")
        public AccessibilityInteractionConnectionManager ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.314 -0400", hash_original_method = "8A20E0BF76F2FE3CB2E135C12DE9692E", hash_generated_method = "70F559A57667577FAC3D62BDA1B49526")
        public void onAccessibilityStateChanged(boolean enabled) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                ensureConnection();
            } //End block
            {
                ensureNoConnection();
            } //End block
            addTaint(enabled);
            // ---------- Original Method ----------
            //if (enabled) {
                //ensureConnection();
            //} else {
                //ensureNoConnection();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.315 -0400", hash_original_method = "92A9A6CA8F5EA055DBA3D736397E37E0", hash_generated_method = "A57DA784397FF6E6C9A1B8243EC2BC62")
        public void ensureConnection() {
            final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.315 -0400", hash_original_method = "C22E99B1A3881672FEB45F6BE843B278", hash_generated_method = "D753495D391B578B2FBF3039A3611502")
        public void ensureNoConnection() {
            final boolean registered = mAttachInfo.mAccessibilityWindowId != View.NO_ID;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.315 -0400", hash_original_field = "116A8D8AC04E6AC49EB407DCA6EEA4A9", hash_generated_field = "53CC87D794214F8DCA645D22E8A949F9")

        private WeakReference<ViewRootImpl> mRootImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.315 -0400", hash_original_method = "D539A7CCB822AF3CDF20BB7941121D94", hash_generated_method = "3B1B370109F8D6C40FF65F8AD31BE9A1")
          AccessibilityInteractionConnection(ViewRootImpl viewAncestor) {
            mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
            // ---------- Original Method ----------
            //mRootImpl = new WeakReference<ViewRootImpl>(viewAncestor);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.316 -0400", hash_original_method = "EE5D719A51240BF55D02CDA16E5D3A9D", hash_generated_method = "2C3381C0E4EC0199530CEBE8FA666DBA")
        public void findAccessibilityNodeInfoByAccessibilityId(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        interactionId, callback, interrogatingPid, interrogatingTid);
            } //End block
            addTaint(accessibilityId);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interrogatingPid);
            addTaint(interrogatingTid);
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfoByAccessibilityIdClientThread(accessibilityId,
                        //interactionId, callback, interrogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.316 -0400", hash_original_method = "150D2C0671760B2C49B4A2BEA648BFF0", hash_generated_method = "CB2D986C7424DF0352AA77B1673041BF")
        public void performAccessibilityAction(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            callback, interogatingPid, interrogatingTid);
            } //End block
            addTaint(accessibilityId);
            addTaint(action);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interogatingPid);
            addTaint(interrogatingTid);
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.performAccessibilityActionClientThread(accessibilityId, action, interactionId,
                            //callback, interogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.317 -0400", hash_original_method = "480C93EC256597CABC1B248D841B9A3E", hash_generated_method = "02D7FD3AB5C31CDBE963ADA2C4E42B38")
        public void findAccessibilityNodeInfoByViewId(int viewId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            interrogatingPid, interrogatingTid);
            } //End block
            addTaint(viewId);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interrogatingPid);
            addTaint(interrogatingTid);
            // ---------- Original Method ----------
            //ViewRootImpl viewRootImpl = mRootImpl.get();
            //if (viewRootImpl != null) {
                //viewRootImpl.getAccessibilityInteractionController()
                    //.findAccessibilityNodeInfoByViewIdClientThread(viewId, interactionId, callback,
                            //interrogatingPid, interrogatingTid);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.317 -0400", hash_original_method = "9891EE3B36B5E5E829B36E62164827F4", hash_generated_method = "26418B36BF01EA087E2CB3C681B78AFE")
        public void findAccessibilityNodeInfosByViewText(String text, int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            ViewRootImpl viewRootImpl = mRootImpl.get();
            {
                viewRootImpl.getAccessibilityInteractionController()
                    .findAccessibilityNodeInfosByViewTextClientThread(text, accessibilityId,
                            interactionId, callback, interrogatingPid, interrogatingTid);
            } //End block
            addTaint(text.getTaint());
            addTaint(accessibilityId);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interrogatingPid);
            addTaint(interrogatingTid);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.317 -0400", hash_original_field = "C3E8C63735AAC0E72D6CCFDDE0328331", hash_generated_field = "2FD14E145489DD00A8E7926145DAD829")

        private ArrayList<AccessibilityNodeInfo> mTempAccessibilityNodeInfoList = new ArrayList<AccessibilityNodeInfo>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.317 -0400", hash_original_field = "87ED3D57DB6E520DDD2EDF337ED05257", hash_generated_field = "38B485AE2AFC301A08861106EB06C4F1")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.317 -0400", hash_original_method = "AB87C85D23FC0F804AE52922F865B9CD", hash_generated_method = "AB87C85D23FC0F804AE52922F865B9CD")
        public AccessibilityInteractionController ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.318 -0400", hash_original_method = "2F6D3BCB232629523E59C738D4AD3A95", hash_generated_method = "F4623C0C05BF30ADC56AD6EA045128B3")
        public void findAccessibilityNodeInfoByAccessibilityIdClientThread(int accessibilityId,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interrogatingPid, long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID;
            message.arg1 = accessibilityId;
            message.arg2 = interactionId;
            message.obj = callback;
            {
                boolean var8107759D1151D3101276FAAE5511E68D_1261483506 = (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            addTaint(accessibilityId);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interrogatingPid);
            addTaint(interrogatingTid);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.318 -0400", hash_original_method = "145D07D178B3372CAAF2CB93D024125F", hash_generated_method = "1CEFABE5E9CDED2ED9BC6204C6F8042F")
        public void findAccessibilityNodeInfoByAccessibilityIdUiThread(Message message) {
            final int accessibilityId = message.arg1;
            final int interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) message.obj;
            AccessibilityNodeInfo info = null;
            try 
            {
                View target = findViewByAccessibilityId(accessibilityId);
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
                { }
            } //End block
            addTaint(message.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.319 -0400", hash_original_method = "ADA0B35A4DB3EC9F459DCBB8D66C434D", hash_generated_method = "312D5F85FBE1F9A67ED450EC7E706A52")
        public void findAccessibilityNodeInfoByViewIdClientThread(int viewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID;
            message.arg1 = viewId;
            message.arg2 = interactionId;
            message.obj = callback;
            {
                boolean var8107759D1151D3101276FAAE5511E68D_677148123 = (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            addTaint(viewId);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interrogatingPid);
            addTaint(interrogatingTid);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.319 -0400", hash_original_method = "6B2A3077FB5BC3E815A1727E6C950B5E", hash_generated_method = "9D461882A63336431CA07A5509B9F68B")
        public void findAccessibilityNodeInfoByViewIdUiThread(Message message) {
            final int viewId = message.arg1;
            final int interactionId = message.arg2;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) message.obj;
            AccessibilityNodeInfo info = null;
            try 
            {
                View root = ViewRootImpl.this.mView;
                View target = root.findViewById(viewId);
                {
                    boolean varAD6C034A8B4788EA6598018C4A7CCA13_496229082 = (target != null && target.getVisibility() == View.VISIBLE);
                    {
                        info = target.createAccessibilityNodeInfo();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfoResult(info, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            addTaint(message.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.320 -0400", hash_original_method = "74A990105163D5D10216C3B475062D28", hash_generated_method = "DE498A9AFAF4BA78A7BEBB1F823C4F0A")
        public void findAccessibilityNodeInfosByViewTextClientThread(String text,
                int accessibilityViewId, int interactionId,
                IAccessibilityInteractionConnectionCallback callback, int interrogatingPid,
                long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT;
            SomeArgs args = mPool.acquire();
            args.arg1 = text;
            args.argi1 = accessibilityViewId;
            args.argi2 = interactionId;
            args.arg2 = callback;
            message.obj = args;
            {
                boolean var8107759D1151D3101276FAAE5511E68D_1072074548 = (interrogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            addTaint(text.getTaint());
            addTaint(accessibilityViewId);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interrogatingPid);
            addTaint(interrogatingTid);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.320 -0400", hash_original_method = "51BC2DACC971DA52CB7F7912294499A7", hash_generated_method = "B0F32B6ACDFF6A6F1880A003BC1E80E8")
        public void findAccessibilityNodeInfosByViewTextUiThread(Message message) {
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
                {
                    root = findViewByAccessibilityId(accessibilityViewId);
                } //End block
                {
                    root = ViewRootImpl.this.mView;
                } //End block
                {
                    boolean var9C0D384BF3EBA7F37FDD9A142533A8EE_1356667511 = (root == null || root.getVisibility() != View.VISIBLE);
                } //End collapsed parenthetic
                root.findViewsWithText(foundViews, text, View.FIND_VIEWS_WITH_TEXT
                        | View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                {
                    boolean var8A7BFE1EB8C1A34CA2C8E115CC06AAA3_259106644 = (foundViews.isEmpty());
                } //End collapsed parenthetic
                infos = mTempAccessibilityNodeInfoList;
                infos.clear();
                final int viewCount = foundViews.size();
                {
                    int i = 0;
                    {
                        View foundView = foundViews.get(i);
                        {
                            boolean var8598062468ACAD090E81AB592F4F32E5_1188152451 = (foundView.getVisibility() == View.VISIBLE);
                            {
                                infos.add(foundView.createAccessibilityNodeInfo());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                try 
                {
                    callback.setFindAccessibilityNodeInfosResult(infos, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.321 -0400", hash_original_method = "10A09FD4DC34F1BE42EB309D47EC9715", hash_generated_method = "D5EC86FD5A22A7E69FB4BC160C15E27D")
        public void performAccessibilityActionClientThread(int accessibilityId, int action,
                int interactionId, IAccessibilityInteractionConnectionCallback callback,
                int interogatingPid, long interrogatingTid) {
            Message message = Message.obtain();
            message.what = DO_PERFORM_ACCESSIBILITY_ACTION;
            SomeArgs args = mPool.acquire();
            args.argi1 = accessibilityId;
            args.argi2 = action;
            args.argi3 = interactionId;
            args.arg1 = callback;
            message.obj = args;
            {
                boolean varBA474D4A1DE421276FA94C5F81C7FD11_2094494722 = (interogatingPid == Process.myPid()
                    && interrogatingTid == Looper.getMainLooper().getThread().getId());
                {
                    message.setTarget(ViewRootImpl.this);
                    AccessibilityInteractionClient.getInstance().setSameThreadMessage(message);
                } //End block
                {
                    sendMessage(message);
                } //End block
            } //End collapsed parenthetic
            addTaint(accessibilityId);
            addTaint(action);
            addTaint(interactionId);
            addTaint(callback.getTaint());
            addTaint(interogatingPid);
            addTaint(interrogatingTid);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.322 -0400", hash_original_method = "B5557005BEFFE1DA9F706439FD376D18", hash_generated_method = "718223273D0C40976DAF48EA7E2B8FA0")
        public void perfromAccessibilityActionUiThread(Message message) {
            SomeArgs args = (SomeArgs) message.obj;
            final int accessibilityId = args.argi1;
            final int action = args.argi2;
            final int interactionId = args.argi3;
            final IAccessibilityInteractionConnectionCallback callback = (IAccessibilityInteractionConnectionCallback) args.arg1;
            mPool.release(args);
            boolean succeeded = false;
            try 
            {
                //Begin case AccessibilityNodeInfo.ACTION_FOCUS 
                {
                    succeeded = performActionFocus(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_FOCUS 
                //Begin case AccessibilityNodeInfo.ACTION_CLEAR_FOCUS 
                {
                    succeeded = performActionClearFocus(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_CLEAR_FOCUS 
                //Begin case AccessibilityNodeInfo.ACTION_SELECT 
                {
                    succeeded = performActionSelect(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_SELECT 
                //Begin case AccessibilityNodeInfo.ACTION_CLEAR_SELECTION 
                {
                    succeeded = performActionClearSelection(accessibilityId);
                } //End block
                //End case AccessibilityNodeInfo.ACTION_CLEAR_SELECTION 
            } //End block
            finally 
            {
                try 
                {
                    callback.setPerformAccessibilityActionResult(succeeded, interactionId);
                } //End block
                catch (RemoteException re)
                { }
            } //End block
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.322 -0400", hash_original_method = "0DF709A77C91001270CD6D5BCBC66D0E", hash_generated_method = "90D6A02512B1DAD64E7E58FE0CC98645")
        private boolean performActionFocus(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_574222682 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            ensureTouchMode(false);
            boolean var0F57617D4E8F9359CC9AD7E4CA12AF24_1855530326 = (target.requestFocus());
            addTaint(accessibilityId);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_200127656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_200127656;
            // ---------- Original Method ----------
            //View target = findViewByAccessibilityId(accessibilityId);
            //if (target == null || target.getVisibility() != View.VISIBLE) {
                //return false;
            //}
            //ensureTouchMode(false);
            //return target.requestFocus();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.323 -0400", hash_original_method = "7E9614B48F5F4EC29BCF64D3A075976C", hash_generated_method = "37031376F4A65627F989179EFAB7B57D")
        private boolean performActionClearFocus(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_819928541 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean var85D47F37C8A8E496A11CE0CD99470B85_1895715400 = (!target.isFocused());
            } //End collapsed parenthetic
            target.clearFocus();
            boolean var6B4E7E773AB55FC14DC5D0B1ACCA65EC_1260597048 = (!target.isFocused());
            addTaint(accessibilityId);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766352704 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_766352704;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.324 -0400", hash_original_method = "AB7AA9516F9E78D5A5AD4BBEB80A41A0", hash_generated_method = "1BF19330A40205B7E664F2FE13E9E11D")
        private boolean performActionSelect(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_1629683586 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean varB0F56BADB6D848BC74C2EB6E3BAB7BCC_48914301 = (target.isSelected());
            } //End collapsed parenthetic
            target.setSelected(true);
            boolean varE49BAE8F367158D1AAA608101541F1A5_971079622 = (target.isSelected());
            addTaint(accessibilityId);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082555922 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082555922;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.325 -0400", hash_original_method = "E102B39F5DF94C3320BE2ED1E2D3B323", hash_generated_method = "16ACE995F68ACC53604EA18E5A2573A0")
        private boolean performActionClearSelection(int accessibilityId) {
            View target = findViewByAccessibilityId(accessibilityId);
            {
                boolean var1B633B56F0AFAC0F4C74324F357BD14A_766270897 = (target == null || target.getVisibility() != View.VISIBLE);
            } //End collapsed parenthetic
            {
                boolean varCEA2FEA7AB8ACAC93A58D6FAF61E7763_210219097 = (!target.isSelected());
            } //End collapsed parenthetic
            target.setSelected(false);
            boolean varDE00FAE324BEAA0EBABFEB29089F51C8_137785660 = (!target.isSelected());
            addTaint(accessibilityId);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857123495 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_857123495;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_method = "B9D971669B3F873AC0D1B0C38F7811F4", hash_generated_method = "13B5B8CD51C85D1FA792AD7E74C97D0B")
        private View findViewByAccessibilityId(int accessibilityId) {
            View varB4EAC82CA7396A68D541C85D26508E83_146837054 = null; //Variable for return #1
            View varB4EAC82CA7396A68D541C85D26508E83_1082923699 = null; //Variable for return #2
            View varB4EAC82CA7396A68D541C85D26508E83_2035340525 = null; //Variable for return #3
            View root = ViewRootImpl.this.mView;
            {
                varB4EAC82CA7396A68D541C85D26508E83_146837054 = null;
            } //End block
            View foundView = root.findViewByAccessibilityId(accessibilityId);
            {
                boolean varB5E3FDDC281E79B82F6D09E4AAD9E0FF_1934611095 = (foundView != null && foundView.getVisibility() != View.VISIBLE);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1082923699 = null;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2035340525 = foundView;
            addTaint(accessibilityId);
            View varA7E53CE21691AB073D9660D615818899_1872826068; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1872826068 = varB4EAC82CA7396A68D541C85D26508E83_146837054;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1872826068 = varB4EAC82CA7396A68D541C85D26508E83_1082923699;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1872826068 = varB4EAC82CA7396A68D541C85D26508E83_2035340525;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1872826068.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1872826068;
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "DA4F0B9DBC6F4431600CE5D0AA462E29")

            private SomeArgs mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")

            public Object arg1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

            public Object arg2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "45EA0AE08E2E96F45B382FC093F32969", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

            public int argi1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "AD47A7F028721D8AB76072E225148A71", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

            public int argi2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_field = "14D7B84204F2BD6B05340ABF4F0B2AAB", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

            public int argi3;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
            public SomeArgs ()
            {
                //Synthesized constructor
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.326 -0400", hash_original_method = "BEE0522D727ED0DB1FBC81A3E3B176C5", hash_generated_method = "D35B9F19D3E1AC0544A54BC4FEEC323D")
            public SomeArgs getNextPoolable() {
                SomeArgs varB4EAC82CA7396A68D541C85D26508E83_1797377885 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1797377885 = mNext;
                varB4EAC82CA7396A68D541C85D26508E83_1797377885.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1797377885;
                // ---------- Original Method ----------
                //return mNext;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.327 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "1EA6636C21BFE932B4D6BCB4F78AA008")
            public boolean isPooled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557037504 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_557037504;
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.327 -0400", hash_original_method = "B595989EA0DDF2662B95D2584CF9AF77", hash_generated_method = "F4A2EC156C0A86672F5B936336F0364D")
            public void setNextPoolable(SomeArgs args) {
                mNext = args;
                // ---------- Original Method ----------
                //mNext = args;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.327 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_method = "95D0476EAE9CBD3221945617281C6DDB", hash_generated_method = "316EB695B735DFEA458AF811F180A884")
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


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "C2E05B03A1E5A4773797E14A5759FDE0", hash_generated_field = "9C5EE85F599ECE1BA2255910141DCB18")

        private static final int POOL_SIZE = 5;
    }


    
    private class SendWindowContentChangedAccessibilityEvent implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "AD12063E8FC163523FAE892D8D8BEA2B", hash_generated_field = "8E5087238AE27D181E6487D7D8E8CADB")

        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_method = "22B280316CE346FC3EE6EA7A3C31108C", hash_generated_method = "22B280316CE346FC3EE6EA7A3C31108C")
        public SendWindowContentChangedAccessibilityEvent ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_method = "3411919DDECDF923DB080425515AE494", hash_generated_method = "47C531BB66138CE208DE726513162DE0")
        public void run() {
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "7E6EF6CA984A814E54DEF53937367AEC", hash_generated_field = "20A0B237EA7FED0897D15F2C9A434731")

    private static final String TAG = "ViewRootImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "AAFDAF871858750A211AC8DBE6D1B76E", hash_generated_field = "626038DAE6BB26944A3CF12B5D6F74EE")

    private static final boolean LOCAL_LOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "81BC73E608D026D04E3B0D79ED385A75", hash_generated_field = "971AF06B9A1B36F9E637DA19FBC7C8E8")

    private static final boolean DEBUG_DRAW = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "E7914D46191772C2DFC3082FA07C5113", hash_generated_field = "CB8EB2CBBD50573AA52874C3C657F261")

    private static final boolean DEBUG_LAYOUT = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "3E9B61D7306485C1EBF46DD64F93002F", hash_generated_field = "8EA22DB3A605D961CEA3CCDA576DF97D")

    private static final boolean DEBUG_DIALOG = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "6954DCA4F52EB3F7707E23BA3AAB73BF", hash_generated_field = "A5F9DE67F8CD98CB6CDB329B70C684A4")

    private static final boolean DEBUG_INPUT_RESIZE = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "01E2E972D69F91A7F53036A4BA38B963", hash_generated_field = "23E83E11FDABB85CB4C188C31B75DA5C")

    private static final boolean DEBUG_ORIENTATION = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "89BD8CB6EDCD2701549EC23413AED997", hash_generated_field = "77EE0AA06B23769B780A309B393E32FA")

    private static final boolean DEBUG_TRACKBALL = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "70989F0A550BD62CC84D8B650E71E267", hash_generated_field = "7B7C0ECBA08420BBFAB103815EABD246")

    private static final boolean DEBUG_IMF = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "13D8941946EC6485CACF79D87C642394", hash_generated_field = "E7DDC8C264C9F86DB032DBB6CABC2709")

    private static final boolean DEBUG_CONFIGURATION = false || LOCAL_LOGV;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.328 -0400", hash_original_field = "1EFCDC73DAE6A5FD924B8DD06B5F556D", hash_generated_field = "A0CF8EE94CFC62F1428857DCF5542F88")

    private static final boolean DEBUG_FPS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "FEC45B2BB71B7194F717163B3BA5CC82", hash_generated_field = "5FA7473017ED5A2E46DB49A8BFC34BE9")

    private static final boolean WATCH_POINTER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "1DF900DD37598133E05CC46EE5C93B83", hash_generated_field = "3A883DE2B0B67773D8F82B7654B7D004")

    private static final String PROPERTY_PROFILE_RENDERING = "viewancestor.profile_rendering";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "C0BC221229095D032C888D69A46129BE", hash_generated_field = "E5342F079514828E15AB01F9FA97BF6C")

    private static final boolean MEASURE_LATENCY = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "D91AF6958918AF87D6A057C1CDF5B225", hash_generated_field = "4C70E88FDA504CF3924879E0993C2C35")

    private static LatencyTimer lt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "18E551674F4F8BCF0D1B014EC1FFE225", hash_generated_field = "B0C223721AEEA6A8D58BAE0775580384")

    static final int MAX_TRACKBALL_DELAY = 250;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "844A08A1319C1FF73C67A1955AE19000", hash_generated_field = "CE60587CF2EE3A6FA7BC23F1967EFA78")

    static IWindowSession sWindowSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "F85483633A397D700D9550D630F94703", hash_generated_field = "906814A8DD92904364CC348726E82FDF")

    static final Object mStaticInit = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "82073B9F728953BFC0E99AB45C8BBB4A", hash_generated_field = "536734E2DD91AB5EDF1F3B60AFB40B7C")

    static boolean mInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "BEFFC6565DC1CA41B1B9BCD8BAFC0608", hash_generated_field = "B17B98FA673511F1A0E4D0FB5118C35F")

    static final ThreadLocal<RunQueue> sRunQueues = new ThreadLocal<RunQueue>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "88C55A175576611D1262F4DEB603DD11", hash_generated_field = "B99793B7C0D11503969031E3D368FFEC")

    static final ArrayList<Runnable> sFirstDrawHandlers = new ArrayList<Runnable>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "417B1AC24707509FE1229159D5D2FD6A", hash_generated_field = "63BD0028405F2577A6800DED464B8A3B")

    static boolean sFirstDrawComplete = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "55AB80B80BF4397CA994CF036DDAA729", hash_generated_field = "7E01A30DB4DBEA8BAA84FC6A8EA8B318")

    static final ArrayList<ComponentCallbacks> sConfigCallbacks = new ArrayList<ComponentCallbacks>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "580B9D5636F3C1BAD99EA0DA732D0ACB", hash_generated_field = "347C4ECD6969CCE8F943EAB38DB0079A")

    static final Interpolator mResizeInterpolator = new AccelerateDecelerateInterpolator();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "E824FF2BAD31069ED6F0ED3D10172F45", hash_generated_field = "3EB90E2F993B9CB287747FD7EEEF5D90")

    public final static int DO_TRAVERSAL = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "1C5BB561E88C8BE5FAFEE0790C955B81", hash_generated_field = "F0BCA4B075D24D0FF66A6916CC127271")

    public final static int DIE = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "459694EAE0AFBDCF7F5FE59E926751AC", hash_generated_field = "EA01F9146001F93DF12B6DD8FF81CC53")

    public final static int RESIZED = 1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "FD1224F49B0BF6E289BE701A8A4B6B60", hash_generated_field = "AB61E328C1E2634C736F13E407311D18")

    public final static int RESIZED_REPORT = 1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "9DF5EC78475F54E37A56BEC42BEB1D2A", hash_generated_field = "2FD8D787B807B4EE2C688EC81CAD354C")

    public final static int WINDOW_FOCUS_CHANGED = 1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "61E6CA8CFDD30043CF5371A303A21611", hash_generated_field = "46BC1AB0B59868BC1AC272F074AD853B")

    public final static int DISPATCH_KEY = 1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "B756EB713FDD7EBFEC40D507E44BA7DD", hash_generated_field = "CFCFDFB572BC4BDCA1471B291D10B9FE")

    public final static int DISPATCH_POINTER = 1006;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "76D47D386450074FBF1E818F21242699", hash_generated_field = "D9F532C1428B70D44A71437836C78C0B")

    public final static int DISPATCH_TRACKBALL = 1007;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "4A72F41D34459CE79383884522ECCAE4", hash_generated_field = "FA67D6D19432E9CAFFF018FDFFC4D8E2")

    public final static int DISPATCH_APP_VISIBILITY = 1008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "476162F3CD411E58F30414F1566B6652", hash_generated_field = "1CD05315E6CF2B4F64EBB262782DA709")

    public final static int DISPATCH_GET_NEW_SURFACE = 1009;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "6E0B574D9F9C9940E785731CC021CE12", hash_generated_field = "A872A4B58863DDD392F65C30D22E6818")

    public final static int FINISHED_EVENT = 1010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "1F337768A4463FBDA713A52511B04E2A", hash_generated_field = "8F58AD3EA7EA7BCABB230C363AF6864D")

    public final static int DISPATCH_KEY_FROM_IME = 1011;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "83000FF7A8A5ECC49BD31658E6C66783", hash_generated_field = "0E2AE4E9BC35AB1C012C9D523F2DB54F")

    public final static int FINISH_INPUT_CONNECTION = 1012;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "0A5C035A6EDFB84A087A5F4C20A6D073", hash_generated_field = "89F79CCE1AF9647DEE46375D53A1C760")

    public final static int CHECK_FOCUS = 1013;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "6B4348D5AABB4767CEE45424C7BB84F6", hash_generated_field = "222999CFB72FB7D242E23460229012C5")

    public final static int CLOSE_SYSTEM_DIALOGS = 1014;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "F6DDF0332FBE95DE04649B3D12340F93", hash_generated_field = "4B576476AE6F6AA4611FDC7AEC60C475")

    public final static int DISPATCH_DRAG_EVENT = 1015;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "D8BE14C1FE01569A265642416EC01D8E", hash_generated_field = "B771249D49FABB56D119E90358FD2BFB")

    public final static int DISPATCH_DRAG_LOCATION_EVENT = 1016;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "52125BABF3FB5DCE0C3580064D8E0637", hash_generated_field = "63FAB3F2B47509EA62E2799705C2C615")

    public final static int DISPATCH_SYSTEM_UI_VISIBILITY = 1017;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "9BCBF8FCAD1A7BD6C0D47AB48F0B1416", hash_generated_field = "E0183864301CE37CAD6F15B696A751C5")

    public final static int DISPATCH_GENERIC_MOTION = 1018;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "9CCCF62492CC6FA2FCD717AA4551C7BC", hash_generated_field = "90DC4C76E6F79F810FC476C28E742912")

    public final static int UPDATE_CONFIGURATION = 1019;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "3B1C3A24166215F6F9EF105C321E49DD", hash_generated_field = "A5F752869EC9ED93776BAA0EEBD6A03B")

    public final static int DO_PERFORM_ACCESSIBILITY_ACTION = 1020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "08CF04FD26A46FE6CD65B60B90CFE644", hash_generated_field = "4D02D16C0FBA008C4C6CA5ABF6F0455F")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_ACCESSIBILITY_ID = 1021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "9B9999530EF0733C7E023792A6AD9019", hash_generated_field = "29168F52297DC460BEBF7B0492E61AB6")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_ID = 1022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "085AF99B529699074495D41497EE7822", hash_generated_field = "3D3A76CBE28044195F427274AA43966C")

    public final static int DO_FIND_ACCESSIBLITY_NODE_INFO_BY_VIEW_TEXT = 1023;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:00.329 -0400", hash_original_field = "39890F94B1CD9459F4EB95642DD3836A", hash_generated_field = "70877CF2932D34884120E6D77E84ADE5")

    public final static int PROCESS_INPUT_EVENTS = 1024;
}

