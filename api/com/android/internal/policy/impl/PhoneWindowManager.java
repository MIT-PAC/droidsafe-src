package com.android.internal.policy.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.R;
import android.os.Vibrator;
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
import android.view.WindowManager.LayoutParams.TYPE_STATUS_BAR;
import android.media.IAudioService;
import android.app.UiModeManager;
import android.view.WindowManager.LayoutParams.TYPE_VOLUME_OVERLAY;
import android.view.WindowOrientationListener;
import android.view.WindowManager.LayoutParams.TYPE_HIDDEN_NAV_CONSUMER;
import android.os.RemoteException;
import android.view.WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG;
import java.io.PrintWriter;
import android.database.ContentObserver;
import android.view.InputChannel;
import android.view.Surface;
import android.view.WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST;
import android.content.ActivityNotFoundException;
import android.view.WindowManager.LayoutParams.TYPE_STATUS_BAR_PANEL;
import android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
import com.android.internal.view.BaseInputHandler;
import android.os.Messenger;
import android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
import android.provider.Settings;
import android.view.MotionEvent;
import android.os.IRemoteCallback;
import android.util.Slog;
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG;
import android.view.WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD;
import android.content.ServiceConnection;
import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.view.WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW;
import android.view.WindowManager.LayoutParams.TYPE_TOAST;
import android.view.WindowManager.LayoutParams.TYPE_PRIORITY_PHONE;
import android.view.WindowManagerImpl;
import android.view.InputQueue;
import com.android.internal.statusbar.IStatusBarService;
import android.view.WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.HapticFeedbackConstants;
import java.io.IOException;
import android.util.EventLog;
import android.view.WindowManager.LayoutParams.TYPE_INPUT_METHOD;
import android.content.Intent;
import android.app.Activity;
import android.os.Handler;
import android.app.ActivityManagerNative;
import android.content.ContentResolver;
import android.view.WindowManager.LayoutParams.TYPE_STATUS_BAR_SUB_PANEL;
import android.view.WindowManagerPolicy;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.ArrayList;
import android.view.WindowManager.LayoutParams.LAST_APPLICATION_WINDOW;
import android.os.IBinder;
import android.view.animation.AnimationUtils;
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
import android.view.WindowManager.LayoutParams.TYPE_PHONE;
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
import android.content.IntentFilter;
import com.android.internal.app.ShutdownThread;
import android.content.pm.ActivityInfo;
import android.app.IActivityManager;
import android.content.pm.PackageManager;
import android.view.KeyCharacterMap;
import android.view.WindowManager.LayoutParams.TYPE_WALLPAPER;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;
import android.app.IUiModeManager;
import android.view.ViewConfiguration;
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY;
import android.view.WindowManager.LayoutParams.TYPE_BOOT_PROGRESS;
import android.view.Gravity;
import android.view.WindowManager.LayoutParams.TYPE_SECURE_SYSTEM_OVERLAY;
import android.os.ServiceManager;
import android.view.KeyEvent;
import android.view.WindowManager.LayoutParams.TYPE_DRAG;
import android.view.IApplicationToken;
import android.util.DisplayMetrics;
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG;
import com.android.internal.widget.PointerLocationView;
import android.view.WindowManager.LayoutParams.TYPE_NAVIGATION_BAR;
import android.view.WindowManager.LayoutParams.TYPE_SEARCH_BAR;
import android.view.animation.Animation;
import android.os.SystemProperties;
import com.android.internal.telephony.ITelephony;
import android.os.Bundle;
import android.view.Window;
import android.graphics.PixelFormat;
import java.io.File;
import android.os.UEventObserver;
import android.view.InputHandler;
import android.view.KeyCharacterMap.FallbackAction;
import android.os.SystemClock;
import android.graphics.Rect;
import android.view.WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL;
import java.io.FileReader;
import android.media.AudioManager;
import android.util.Log;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
import android.graphics.RectF;
import com.android.internal.policy.PolicyManager;
import android.content.BroadcastReceiver;
import android.view.accessibility.AccessibilityEvent;
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
import android.os.BatteryManager;
import android.os.LocalPowerManager;
import android.view.WindowManager.LayoutParams.TYPE_INPUT_METHOD_DIALOG;
import android.view.WindowManager.LayoutParams.TYPE_POINTER;
import android.view.IWindowManager;
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
import android.view.WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR;
import java.io.FileDescriptor;
import android.view.WindowManager.LayoutParams.TYPE_KEYGUARD;
import android.view.WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON;
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
import android.os.PowerManager;
public class PhoneWindowManager implements WindowManagerPolicy {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.835 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "3EEB584C1A7A9B5459C6282DA8CA3C6E")

    final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.835 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.836 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "B04764B9349CA95B8854A0911E0557A1")

    IWindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.837 -0400", hash_original_field = "34B2C782E2B1FA1DC4AD5A35CC01D060", hash_generated_field = "ED6418937000714DEE412B355BAA01D4")

    WindowManagerFuncs mWindowManagerFuncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.838 -0400", hash_original_field = "914EF4BB3FD2989BEA197B83DB980E43", hash_generated_field = "27D320FDB637A47A55FEA67AB945CC12")

    LocalPowerManager mPowerManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.838 -0400", hash_original_field = "80AC68E34FAF2AE36120B0AFC3FE1859", hash_generated_field = "3943E89265170906D73E31B8494BE106")

    IStatusBarService mStatusBarService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.838 -0400", hash_original_field = "560EC933FF5763F980C1AAA7887459D4", hash_generated_field = "F2F253862F471095FD3B733FE80BFF63")

    Vibrator mVibrator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.838 -0400", hash_original_field = "EDBB8DF56D30602799CE1AD1BEB7B879", hash_generated_field = "1F2824B58B73A44B6A19A13B84DBEDBD")

    long[] mLongPressVibePattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.838 -0400", hash_original_field = "B4B389061FD6E0AC8EC0991E8E2FB397", hash_generated_field = "13D41C899C9991732143E6EBD3B64174")

    long[] mVirtualKeyVibePattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.839 -0400", hash_original_field = "52AE3F51202C8E14B37758F8594707C5", hash_generated_field = "941571B2E7DD373D1312EED6287D8DA8")

    long[] mKeyboardTapVibePattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.839 -0400", hash_original_field = "96CAA1F70DD645968BB316FE82B62BD5", hash_generated_field = "4EB830CDC9DA4BDB875D60B791984E02")

    long[] mSafeModeDisabledVibePattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.839 -0400", hash_original_field = "1F772959ED59A3BA0DF50E9F8F8C38BE", hash_generated_field = "BCB4310D1AAC7EE89E062BDC3D6FBDDA")

    long[] mSafeModeEnabledVibePattern;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.839 -0400", hash_original_field = "6A4F2AA95320CE101B03986540B04929", hash_generated_field = "41C4BE8B19E9CD3BA37EA9D0F35E884C")

    boolean mEnableShiftMenuBugReports = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.839 -0400", hash_original_field = "18CF8AA04AC6DCCB0F8C7A20044E676C", hash_generated_field = "423D5A0A75159BB98CE131934587C990")

    boolean mSafeMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.840 -0400", hash_original_field = "6A071436F87012911E1B16FBA348C749", hash_generated_field = "0C91BDAD1F985C1380EC97E1256230E1")

    WindowState mStatusBar = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.840 -0400", hash_original_field = "EFD6080F68124BA2A0960DB18523C5D0", hash_generated_field = "C2F8D66CAE1D05A317C13CA820278809")

    boolean mStatusBarCanHide;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.840 -0400", hash_original_field = "50BEAD32946FBEAC898EF47E212C0952", hash_generated_field = "624F34E749FF7A69380BE084E8E2813C")

    int mStatusBarHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.840 -0400", hash_original_field = "B9DF0AB9C2A119801BE683B0471621DB", hash_generated_field = "FB63ADA637A886884E8AA0E3DA75B1FF")

    final ArrayList<WindowState> mStatusBarPanels = new ArrayList<WindowState>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.840 -0400", hash_original_field = "632BB83C355FE37298C5F25ABE18F4FD", hash_generated_field = "C3509952E1188356A2A84A01B60748AA")

    WindowState mNavigationBar = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.841 -0400", hash_original_field = "35AAF270490664F2C4F787FFEB311B3A", hash_generated_field = "CC52A925E11912B85A45D69628BA8E24")

    boolean mHasNavigationBar = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.841 -0400", hash_original_field = "726E4F377FC428E33CB4CCA8D6F3EFF3", hash_generated_field = "1FE154512A68CFD528681EC903B2DC89")

    int mNavigationBarWidth = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.841 -0400", hash_original_field = "0C73C2B722F0208CC0CC851994E42EF7", hash_generated_field = "F33B467D75992F50A78377B65AFA1F84")

    int mNavigationBarHeight = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.841 -0400", hash_original_field = "0083EEE0DAD467D3FC787B9C7EA06526", hash_generated_field = "95AE4948BC2948C67D030DE619878F55")

    WindowState mKeyguard = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.841 -0400", hash_original_field = "3CC560EB76BCF3F97C758724C3EE53D4", hash_generated_field = "71F07E70F53F2544826138323B234EBC")

    KeyguardViewMediator mKeyguardMediator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.842 -0400", hash_original_field = "C3A476D3BD8B3CACA75442B4BAD0EF2E", hash_generated_field = "8DAD39B455C9B4BA1CB7F130CFA7E528")

    GlobalActions mGlobalActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.842 -0400", hash_original_field = "2FDB41A8EC17B073E32ED7118077BC47", hash_generated_field = "92141661D6DAA08865B3DDC96EC1E04E")

    volatile boolean mPowerKeyHandled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.842 -0400", hash_original_field = "92C9E1DDD85AA3214ED27119683F55CA", hash_generated_field = "4DF630499AB0F8256103DD6BD1285D01")

    boolean mPendingPowerKeyUpCanceled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.842 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.842 -0400", hash_original_field = "9A7F4D553073E27734765A6F320E30B6", hash_generated_field = "878FD5D0020C2376278F13F85DF11F31")

    RecentApplicationsDialog mRecentAppsDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.842 -0400", hash_original_field = "0B64EA530A7229FF6A4F4E02B9878B70", hash_generated_field = "6EE0CEADAF241EC306925AF15658DBF6")

    int mRecentAppsDialogHeldModifiers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "03E83294DE85C776FA26BB6906D636AD", hash_generated_field = "D4E63F2132F048CC9A35DD954039B914")

    int mLidOpen = LID_ABSENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "E686BD4BFC5A90E09B877B21565DC3C2", hash_generated_field = "37EFC6AB2B5A47B5386233C6F87CC6F0")

    boolean mSystemReady;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "8DB5462666429EF157F212369B1D942E", hash_generated_field = "56567F235C9871208E8B4EB9C072F730")

    boolean mSystemBooted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "CBE2F7C2286F142E98C455173F6EDB85", hash_generated_field = "BD327C17FD700E9B927DE0D6AF7B33D1")

    boolean mHdmiPlugged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "F20428B13E4CAAAB74C8102E66FA59B0", hash_generated_field = "A78B39A23469FE8F4B077C25B07F3A82")

    int mUiMode = Configuration.UI_MODE_TYPE_NORMAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "5E41FB758CAC491408DABC2AFA0172E5", hash_generated_field = "9B8A988AEFCFD2743EE24EBC86C5C2F0")

    int mDockMode = Intent.EXTRA_DOCK_STATE_UNDOCKED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.843 -0400", hash_original_field = "598958521BBE825DFB8BEAA7541E0594", hash_generated_field = "0121A9DDE38074029854AC06F894A81B")

    int mLidOpenRotation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.844 -0400", hash_original_field = "630C9680E1EBD2E83F6FE4145441D6C8", hash_generated_field = "65E997C05D9A3BF94CC334F3CAF6BFB7")

    int mCarDockRotation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.844 -0400", hash_original_field = "BC2BC87027EB4365C30DEFC16F337737", hash_generated_field = "5DDCCFC491544CD1663F1B7D2B1D2B5A")

    int mDeskDockRotation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.844 -0400", hash_original_field = "44E0B869B190E8E8932B8F5C330635AF", hash_generated_field = "3EE2597ADF6E85578F65A67960868909")

    int mHdmiRotation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.844 -0400", hash_original_field = "AC5B8BD19EC5600CA7BA14D468E73503", hash_generated_field = "33FB57F9BC1CAF979FE8736F4A04F703")

    int mUserRotationMode = WindowManagerPolicy.USER_ROTATION_FREE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.844 -0400", hash_original_field = "4DD2E2D3B16193E8D5B874DD4BEC03E8", hash_generated_field = "4BF1F37610F8EDE7108A74BA541AA270")

    int mUserRotation = Surface.ROTATION_0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.844 -0400", hash_original_field = "C66D1D441FFCA59DB148583C96751882", hash_generated_field = "FF915CBB93B6ECE2D7B62D32A56DBBDC")

    int mAllowAllRotations = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "EC594F4F359F9690F2C738F766C10C56", hash_generated_field = "42CDF551A3530E17D6B9D6B997BA201B")

    boolean mCarDockEnablesAccelerometer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "06D539A5CB723AF83789A7631A300BE0", hash_generated_field = "7AF4921586E6B542CCDD0C83FC751374")

    boolean mDeskDockEnablesAccelerometer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "F597610DF1A580B6A15D199AA304F424", hash_generated_field = "169607F9E25A254495424CC04C87377D")

    int mLidKeyboardAccessibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "DFA495FAABFCE82880F43C3B68055784", hash_generated_field = "56A47DB8C8F90592BD85B993C0EACC7F")

    int mLidNavigationAccessibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "1FD4A70F5832E9E6BFB2724DEB88A7DF", hash_generated_field = "CA99A996CE3A33E9BD07C956FCC501BC")

    int mLongPressOnPowerBehavior = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "C0F4E738D759F39D5AF8F77A8A73D4CD", hash_generated_field = "49F138386BB0F6E1D5568C7C430E1F94")

    boolean mScreenOnEarly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.845 -0400", hash_original_field = "00A3E981D2F9730A568DF5A6A2FEDB44", hash_generated_field = "7A343BC4F4A6A6A7AEA3117FC2236CB6")

    boolean mScreenOnFully = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.846 -0400", hash_original_field = "35006DC743CC675B637278F0A03E8FDD", hash_generated_field = "78E18D0F1C3C39118890948ED29A0F9D")

    boolean mOrientationSensorEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.846 -0400", hash_original_field = "A8BED0676BB7BA14BC059DA3792CD8E5", hash_generated_field = "B3A4FB90DDC207E7E08FC470E649FFD7")

    int mCurrentAppOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.846 -0400", hash_original_field = "3A74F0DDAE49163557F115426E934023", hash_generated_field = "09786E9FA6296BC0C7242195F8D617E1")

    int mAccelerometerDefault = DEFAULT_ACCELEROMETER_ROTATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.846 -0400", hash_original_field = "3EB6CC7AA6C7FE4B058B59FD42C6C479", hash_generated_field = "A50C0070DC55D189F4EC84A49D58A03C")

    boolean mHasSoftInput = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.846 -0400", hash_original_field = "31520AC658DA8733F99222E771DDAAA0", hash_generated_field = "B76E1B642797EF67CA92A26D3ADF5C55")

    int mPointerLocationMode = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.847 -0400", hash_original_field = "708649569963E0D4380DE1EFB306FCAF", hash_generated_field = "36E48BFBE79C5F85ACE58869B725F429")

    PointerLocationView mPointerLocationView = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.847 -0400", hash_original_field = "94F78E6CD2C4CDCF880FA86E6A72CFF1", hash_generated_field = "2D0A3B37CB4E2031A65729E4E29A5A0A")

    InputChannel mPointerLocationInputChannel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.847 -0400", hash_original_field = "50D8E99CB917B05B3E18C9C01FE7E4E4", hash_generated_field = "6B1979F206F8DCB83EB9A5D7BDC2ACE4")

    WindowState mFocusedWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.847 -0400", hash_original_field = "67C468A7F908B7E84C1454AFD5B3F810", hash_generated_field = "2908FD55AA81C9E10C9818EFA7314DCB")

    IApplicationToken mFocusedApp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.849 -0400", hash_original_field = "BBFA56E5C9581C8B235C8671F5C16583", hash_generated_field = "035EBB5CF2EA346B53A5C729FF364303")

    private final InputHandler mPointerLocationInputHandler = new BaseInputHandler()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.848 -0400", hash_original_method = "A62DEF2238F74ADCC8CF4B55B74B0CD1", hash_generated_method = "BD7BBCB795BCFB34ED21E4888CB4617D")
        @Override
        public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
            addTaint(finishedCallback.getTaint());
            addTaint(event.getTaint());
            boolean handled = false;
            try 
            {
                if((event.getSource()&InputDevice.SOURCE_CLASS_POINTER)!=0)                
                {
                    synchronized
(mLock)                    {
                        if(mPointerLocationView!=null)                        
                        {
mPointerLocationView.addPointerEvent(event)handled=true
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
finishedCallback.finished(handled)
            } //End block
            // ---------- Original Method ----------
            //boolean handled = false;
            //try {
                //if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
                    //synchronized (mLock) {
                        //if (mPointerLocationView != null) {
                            //mPointerLocationView.addPointerEvent(event);
                            //handled = true;
                        //}
                    //}
                //}
            //} finally {
                //finishedCallback.finished(handled);
            //}
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.849 -0400", hash_original_field = "E25642C3C5D1E28A15C4931A33F25E29", hash_generated_field = "AF4119EB67AD5FF827B9347D72D760D8")

    int mUnrestrictedScreenLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.849 -0400", hash_original_field = "AD2D2D0F2AC804C0EAD3AC0A98D4E691", hash_generated_field = "5FB83DDE75885BA02869119B9481A209")

    int mUnrestrictedScreenTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.849 -0400", hash_original_field = "CC75330F32405C76B35391D458C35532", hash_generated_field = "709F2626B56E9BA1A6E1E7FD721CBCB4")

    int mUnrestrictedScreenWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.849 -0400", hash_original_field = "9956842BAC81AB47B81F0C789280550C", hash_generated_field = "C718C3F3E12062B9FBF8D810F4C6A57B")

    int mUnrestrictedScreenHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.850 -0400", hash_original_field = "CF9F5E0EB7686A2587B9F6A37092BA2B", hash_generated_field = "A9BD44C1EF3C504D44AB056FB193D92B")

    int mRestrictedScreenLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.850 -0400", hash_original_field = "05608D9A9191390978F50CD523DD80BC", hash_generated_field = "6265C2C6CCF5660B2D09052486A8332A")

    int mRestrictedScreenTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.850 -0400", hash_original_field = "28B90BA9A20641583D28D7C509CA10FD", hash_generated_field = "78A4D1E41A3088C306B5164503C9C926")

    int mRestrictedScreenWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.850 -0400", hash_original_field = "E7019E2ED093B1966302EF88B2CEC472", hash_generated_field = "EF487A3FEC01E47DEC2DDAE1FCD6F36C")

    int mRestrictedScreenHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.850 -0400", hash_original_field = "95C1DDBF3C06CB6D45615A11BC377F8D", hash_generated_field = "2AB739226A3CBFB5F31E56613FE5D07D")

    int mCurLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.850 -0400", hash_original_field = "B5634E1369DF6DD527A61D3291838203", hash_generated_field = "6C6CBA9837CD293A76E1DD106A28D6BA")

    int mCurTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "F582625F557AD5FCA9FEE2BA359D9591", hash_generated_field = "D51278978AE6AC334E8C19740DBD76BC")

    int mCurRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "BA3B9DF7677AFC92CC966FADBE6668DE", hash_generated_field = "0B1F131CEA2EEDCBDC4786387D0DC08C")

    int mCurBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "72C2BCC1219988F902CEEAD2C0F79024", hash_generated_field = "E64A0E2A69DFD26B975B1334C2ACFE4B")

    int mContentLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "76924FC17D6D62D3E51DE10CACDFE23F", hash_generated_field = "DC5F89C8E50285FDDD190E191A2AA9E0")

    int mContentTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "3B1954F14EA53DCD63A1795A994166C0", hash_generated_field = "B6EF0C0C3940FC8CC81B1277FB3DDCDE")

    int mContentRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "426CE52CB6A29AFC16D1C600B2D93046", hash_generated_field = "379465E98A95B800A8C13B2A62E62EA8")

    int mContentBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.851 -0400", hash_original_field = "262A336EFD42E20707E2569CCA7289C7", hash_generated_field = "ECB09440A05B6A3DD9427EC5940CDEDC")

    int mDockLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "25A8426DC6C9A929E09B9A35AF7923E4", hash_generated_field = "B69211ADE05504935DE0835EDE28018E")

    int mDockTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "281AA2A4004FF8E914A85637E66624C7", hash_generated_field = "2E4E99185B8AC3234ADED7250C77EAF3")

    int mDockRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "8A8E42C9CA82DDBDE357B4C2E54AD1A8", hash_generated_field = "35F26F198FD33C4954A47ABC48493A9C")

    int mDockBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "F7530EF86A4689D501C481B8772C2586", hash_generated_field = "C29F81152E132FD6DD851FAB326EB4B9")

    int mDockLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "F1517B987D0CB8AD8CDECD312AA8EB03", hash_generated_field = "5335CA9D16A9787076D422628F2DF015")

    int mLastSystemUiFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "C7A9C2CFCC2F7FE7E7EB85DD18C59820", hash_generated_field = "56166DC4093AA7C0791F0598E53DBC31")

    int mResettingSystemUiFlags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.852 -0400", hash_original_field = "02C537DF75A9E8D26282261D3CFF1BC9", hash_generated_field = "A8E5FF420EE280E01F79451D5686E249")

    int mForceClearedSystemUiFlags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "D33B673FC57AC7A8A1AE272422961A29", hash_generated_field = "35C5E3DEFA043F1D37D673BE71D45733")

    boolean mLastFocusNeedsMenu = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "BBAE36F7D889CEFB09182828967AB69E", hash_generated_field = "54E114BCD750657A55268C044D62DE35")

    FakeWindow mHideNavFakeWindow = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "86A201F49B21BDFCD482A2D52D5CEF50", hash_generated_field = "3D98DDECB4B66D9147357A7832708075")

    WindowState mTopFullscreenOpaqueWindowState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "F825DA7636B69183A573F01DFFD5DFC9", hash_generated_field = "37F55C1A2A4413C0B9D318697ADBE22A")

    boolean mTopIsFullscreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "DE6A23EA465E4B988D419F6ED1882C18", hash_generated_field = "8BB6B9AF98C674D7F19A25D9FA00981D")

    boolean mForceStatusBar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "7B04951B224ACE95BA7C1262CE84CAE4", hash_generated_field = "268945E991FFEDCEC1043CB07F2A63D7")

    boolean mHideLockScreen;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.853 -0400", hash_original_field = "FDE33E555DA816013DBFB2F39AD9ABE8", hash_generated_field = "D9B87BC6002832CDFA3922186B136BF4")

    boolean mDismissKeyguard;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "6663BEBB4912779702FBB175EDB66847", hash_generated_field = "CAFCC73AF1DEE0E9757524C25D51920D")

    boolean mHomePressed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "C9A38522E524B8601DA81A131CEF0AE7", hash_generated_field = "0023351BB45A29C33109760378F26397")

    Intent mHomeIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "32E7D6D6166E9CB61B3AEF3A4AE1C7EE", hash_generated_field = "A6BDECD7BA33E383D502342C28245EB6")

    Intent mCarDockIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "80AEE7F6595F176D81B761D4D98CFCBA", hash_generated_field = "639EA3E4F0F18F0E649EC3CCB881C06E")

    Intent mDeskDockIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "3455D8851C07B89E49DE9C1C5BA7E34B", hash_generated_field = "E746E33FDC56050BBB3D386D53BFF4B4")

    int mShortcutKeyPressed = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "FE24538311419B8AF9029B048337CE5A", hash_generated_field = "0E53A6C3EF9D3193ECBD54D3E8119BBF")

    boolean mConsumeShortcutKeyUp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "A9DDC99D6261C4D2D5A0459B6F9709A8", hash_generated_field = "1B736E222B9C660BA528CD46ADB2BB37")

    boolean mAllowLockscreenWhenOn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.854 -0400", hash_original_field = "BE77705371352B28A63C86877CF12FAB", hash_generated_field = "0A0632C88D60883EA790D89E0BB61CC8")

    int mLockScreenTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "0544AA4B8BFD52513BE826DC10F7C943", hash_generated_field = "AE5CEDBE6983BCF836AA901ABABD6AC0")

    boolean mLockScreenTimerActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "CE8782E25C1F38D328839759FDF306C4", hash_generated_field = "6120034E5545AC461087FCA2259E3DC6")

    int mEndcallBehavior;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "A0FB490EFC88ED04FE47CD9B9264BC24", hash_generated_field = "29FE7588E24647006F1DA7F019B34E53")

    int mIncallPowerBehavior;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "2F053F0C91CDC4A0B67B200A756CE418", hash_generated_field = "C07BB851CB1416E619AB93AB50EF2A1F")

    int mLandscapeRotation = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "6210C85D41BCA0C99361EEA67D5F92DC", hash_generated_field = "A67E65F75C9D45ADDEAF3C1D1D01D141")

    int mSeascapeRotation = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "94CD0C02486F77BA0AF260742B8995DE", hash_generated_field = "1779D8A1F5ABABDB67495DC919B83868")

    int mPortraitRotation = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "306AC48E46E28130BF6239A1CEE4D4F8", hash_generated_field = "9ECF3DB51388439BB1804CCBF1BBD56D")

    int mUpsideDownRotation = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "B6CC2D1EB7641BB9202E32517D34F9E5", hash_generated_field = "DCFB4F2D26CACF839E27FE412E0CDDD5")

    private int mLongPressOnHomeBehavior = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.855 -0400", hash_original_field = "5DA6664D684653E30BF601C2F251EC89", hash_generated_field = "09ED7CA78410AD74D620539C219F71C6")

    private boolean mVolumeDownKeyTriggered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "65F90ED8020A77D7789DF5C384A7E3CB", hash_generated_field = "53314EA23357598A06A2DF933FD6A7C5")

    private long mVolumeDownKeyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "F218F60AB3348E7DFCAF42ABBD593343", hash_generated_field = "5202F1F218D1E54D3B2ECC11F94238C3")

    private boolean mVolumeDownKeyConsumedByScreenshotChord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "62EC0309BDB68EDDFE0311254465FE99", hash_generated_field = "3A1B3DAF722D80237AEF5BFA058E346D")

    private boolean mVolumeUpKeyTriggered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "3CFD8DAA9353C2A9346586946F084D51", hash_generated_field = "5B1E4AC54BDAE35BFF86837EB5AF69DA")

    private boolean mPowerKeyTriggered;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "D17D73E09B6F71DD86E337EE900D2B68", hash_generated_field = "60D09D4D7392501ACE8B402113FFC88D")

    private long mPowerKeyTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "0544D62D9C1F6A12A5AC7BFFF45D1D10", hash_generated_field = "12A70A8B86A9F9424B538412623C7B92")

    ShortcutManager mShortcutManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "1C4056766A1C4EB6E07EBD083F2DFDCA", hash_generated_field = "C29A468ECA17EE005122C176EE8D40F0")

    PowerManager.WakeLock mBroadcastWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.856 -0400", hash_original_field = "363497290327EB7D974B8711F78F2427", hash_generated_field = "D040A5B8BD172E62395D3DABF7A26DA7")

    final KeyCharacterMap.FallbackAction mFallbackAction = new KeyCharacterMap.FallbackAction();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.857 -0400", hash_original_field = "411ED69946D122B5EC4AC7F6AE63CF00", hash_generated_field = "6810083998CF04FE8E381E2F0ECD288B")

    private UEventObserver mHDMIObserver = new UEventObserver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.857 -0400", hash_original_method = "F80A8F41F08F901BD6AE7F9FA6AD1DB8", hash_generated_method = "F298B86D34963DC48E22DA32909AC4B4")
        @Override
        public void onUEvent(UEventObserver.UEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
setHdmiPlugged("1".equals(event.get("SWITCH_STATE")))
            // ---------- Original Method ----------
            //setHdmiPlugged("1".equals(event.get("SWITCH_STATE")));
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.857 -0400", hash_original_field = "50920FA74A0A918F73F6B58F3557DA9D", hash_generated_field = "F909D75B050CC669E700268E8C918219")

    MyOrientationListener mOrientationListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.858 -0400", hash_original_field = "9ABC2C1E3BD903B53FCDD984110B237C", hash_generated_field = "08BE3F6AEB5DD352C445311C178C52C2")

    private final Runnable mPowerLongPress = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.858 -0400", hash_original_method = "B0FE73DF937049F532D3D280E68BD215", hash_generated_method = "271D4346584D02BF44852E542152A0F4")
        public void run() {
            if(mLongPressOnPowerBehavior<0)            
            {
mLongPressOnPowerBehavior=mContext.getResources().getInteger(com.android.internal.R.integer.config_longPressOnPowerBehavior)
            } //End block
            switch(mLongPressOnPowerBehavior){
            case LONG_PRESS_POWER_NOTHING:
            break;
            case LONG_PRESS_POWER_GLOBAL_ACTIONS:
mPowerKeyHandled=trueperformHapticFeedbackLw(null, HapticFeedbackConstants.LONG_PRESS, false)sendCloseSystemWindows(SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS)showGlobalActionsDialog()            break;
            case LONG_PRESS_POWER_SHUT_OFF:
mPowerKeyHandled=trueperformHapticFeedbackLw(null, HapticFeedbackConstants.LONG_PRESS, false)sendCloseSystemWindows(SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS)ShutdownThread.shutdown(mContext, true)            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.859 -0400", hash_original_field = "FA6E70042271283780B80B35CD1436B5", hash_generated_field = "AC1F7767C4E4CF0528E2DC0A618CCC17")

    private final Runnable mScreenshotChordLongPress = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.859 -0400", hash_original_method = "996887822B338BF8E34D67207568463E", hash_generated_method = "13D8BBD915460C436EA8B06572F61F07")
        public void run() {
takeScreenshot()
            // ---------- Original Method ----------
            //takeScreenshot();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.860 -0400", hash_original_field = "489DD7F990797D8C261FF79C5E25A2EE", hash_generated_field = "D0F7C8DCC67C709B7F91F3B365AE7954")

    final Runnable mAllowSystemUiDelay = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.859 -0400", hash_original_method = "941C644B96F3E7EE75FAD0CC47E0EEC2", hash_generated_method = "59CEB6FC88ACCF40D82905831EBD8B4D")
        @Override
        public void run() {
            // ---------- Original Method ----------
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.862 -0400", hash_original_field = "D8C690E7A7A68D12399924A53A43CD8C", hash_generated_field = "C2AFEDE2B97292C56540C0B446116763")

    final InputHandler mHideNavInputHandler = new BaseInputHandler()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.862 -0400", hash_original_method = "CF7D67D6CB24313E0942338635EBA311", hash_generated_method = "C5339F3E25D8FADA0D327946706D447C")
        @Override
        public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback) {
            addTaint(finishedCallback.getTaint());
            addTaint(event.getTaint());
            boolean handled = false;
            try 
            {
                if((event.getSource()&InputDevice.SOURCE_CLASS_POINTER)!=0)                
                {
                    if(event.getAction()==MotionEvent.ACTION_DOWN)                    
                    {
                        boolean changed = false;
                        synchronized
(mLock)                        {
                            int newVal = mResettingSystemUiFlags
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                            if(mResettingSystemUiFlags!=newVal)                            
                            {
mResettingSystemUiFlags=newValchanged=true
                            } //End block
newVal=mForceClearedSystemUiFlags|View.SYSTEM_UI_FLAG_HIDE_NAVIGATION                            if(mForceClearedSystemUiFlags!=newVal)                            
                            {
mForceClearedSystemUiFlags=newValchanged=truemHandler.postDelayed(new Runnable()                                {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.861 -0400", hash_original_method = "A017D24018A792D5B38A55C97B38C6E7", hash_generated_method = "BE411A95B21F5A63BBABA12AD5634ADD")
            @Override
            public void run() {
                synchronized
(mLock)                {
mForceClearedSystemUiFlags&=~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                } //End block
mWindowManagerFuncs.reevaluateStatusBarVisibility()
                // ---------- Original Method ----------
                //synchronized (mLock) {
                                            //mForceClearedSystemUiFlags &=
                                                    //~View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
                                        //}
                //mWindowManagerFuncs.reevaluateStatusBarVisibility();
            }
                                }
, 1000)
                            } //End block
                        } //End block
                        if(changed)                        
                        {
mWindowManagerFuncs.reevaluateStatusBarVisibility()
                        } //End block
                    } //End block
                } //End block
            } //End block
            finally 
            {
finishedCallback.finished(handled)
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.862 -0400", hash_original_field = "C7E0F1AB0B9C27A5AF068A1FE61CBA16", hash_generated_field = "4AE9B25A982A30082F632F7E323365F5")

    final Object mScreenshotLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.862 -0400", hash_original_field = "B846671DE52D282D9392B0206E64383B", hash_generated_field = "7E55E529950EE96EDD5F89AA753DFD43")

    ServiceConnection mScreenshotConnection = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.863 -0400", hash_original_field = "F9CEF54656598130610CE6B32A796F46", hash_generated_field = "0D449AC96C8507BB5A9BE66027BB8E04")

    final Runnable mScreenshotTimeout = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.863 -0400", hash_original_method = "75C46066BF5695370C5662CB23C5746E", hash_generated_method = "CA32C4C5E87D05D23C71EE1D42C3A808")
        @Override
        public void run() {
            synchronized
(mScreenshotLock)            {
                if(mScreenshotConnection!=null)                
                {
mContext.unbindService(mScreenshotConnection)mScreenshotConnection=null
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mScreenshotLock) {
                //if (mScreenshotConnection != null) {
                    //mContext.unbindService(mScreenshotConnection);
                    //mScreenshotConnection = null;
                //}
            //}
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.864 -0400", hash_original_field = "F2FF3CCA04FF982E062A6072CB213D8F", hash_generated_field = "64BB81B34BEA156D08E9943B2C59DBA2")

    BroadcastReceiver mBroadcastDone = new BroadcastReceiver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.864 -0400", hash_original_method = "319FAA72E0F616EDB7D6BA42360ED91C", hash_generated_method = "BECBF4FEAD2CBC7651B3AECD0C1F4484")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
mBroadcastWakeLock.release()
            // ---------- Original Method ----------
            //mBroadcastWakeLock.release();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.865 -0400", hash_original_field = "708F0AA8B8A6ED22171E1E079159EE6C", hash_generated_field = "62C3A9FB5831DFF35245ACC161454341")

    BroadcastReceiver mDockReceiver = new BroadcastReceiver()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.864 -0400", hash_original_method = "6F4032F59B965DD7EA61E23FEE3340C6", hash_generated_method = "E826EBF39FC0E5EF518B5CFD9F2514D4")
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            if(Intent.ACTION_DOCK_EVENT.equals(intent.getAction()))            
            {
mDockMode=intent.getIntExtra(Intent.EXTRA_DOCK_STATE, Intent.EXTRA_DOCK_STATE_UNDOCKED)
            } //End block
            else
            {
                try 
                {
                    IUiModeManager uiModeService = IUiModeManager.Stub.asInterface(
                            ServiceManager.getService(Context.UI_MODE_SERVICE));
mUiMode=uiModeService.getCurrentModeType()
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
updateRotation(true)updateOrientationListenerLp()
            // ---------- Original Method ----------
            //if (Intent.ACTION_DOCK_EVENT.equals(intent.getAction())) {
                //mDockMode = intent.getIntExtra(Intent.EXTRA_DOCK_STATE,
                        //Intent.EXTRA_DOCK_STATE_UNDOCKED);
            //} else {
                //try {
                    //IUiModeManager uiModeService = IUiModeManager.Stub.asInterface(
                            //ServiceManager.getService(Context.UI_MODE_SERVICE));
                    //mUiMode = uiModeService.getCurrentModeType();
                //} catch (RemoteException e) {
                //}
            //}
            //updateRotation(true);
            //updateOrientationListenerLp();
        }

        
    }
;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.865 -0400", hash_original_field = "E908DF8647699601CEE18C017B667A53", hash_generated_field = "AB67FE30B86BF08FC2A83CC2C131469A")

    ProgressDialog mBootMsgDialog = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.865 -0400", hash_original_field = "732F8F6D0FCD2976124277F238D38737", hash_generated_field = "7ADD95B4F7424373326EAE36E3125413")

    Runnable mScreenLockTimeout = new Runnable()    {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.865 -0400", hash_original_method = "BA28AE4F9326EDB7CA3929A40DD7FFE7", hash_generated_method = "3BB05B16F43868B20D41A4DCFF04B416")
        public void run() {
            synchronized
(this)            {
                if(localLOGV){ }mKeyguardMediator.doKeyguardTimeout()mLockScreenTimerActive=false
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (localLOGV) Log.v(TAG, "mScreenLockTimeout activating keyguard");
                //mKeyguardMediator.doKeyguardTimeout();
                //mLockScreenTimerActive = false;
            //}
        }

        
    }
;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.866 -0400", hash_original_method = "B3B62C1BE53C593D030A97637ABE4D4F", hash_generated_method = "B3B62C1BE53C593D030A97637ABE4D4F")
    public PhoneWindowManager ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.866 -0400", hash_original_method = "44ED22D507DA9429D287B6D175108C88", hash_generated_method = "B90330093093EA300CF90319D525CF12")
     boolean needSensorRunningLp() {
        if(mCurrentAppOrientation==ActivityInfo.SCREEN_ORIENTATION_SENSOR||mCurrentAppOrientation==ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR||mCurrentAppOrientation==ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT||mCurrentAppOrientation==ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_967013775 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116461305 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116461305;
        } //End block
        if((mCarDockEnablesAccelerometer&&mDockMode==Intent.EXTRA_DOCK_STATE_CAR)||(mDeskDockEnablesAccelerometer&&(mDockMode==Intent.EXTRA_DOCK_STATE_DESK||mDockMode==Intent.EXTRA_DOCK_STATE_LE_DESK||mDockMode==Intent.EXTRA_DOCK_STATE_HE_DESK)))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1919150223 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117716399 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117716399;
        } //End block
        if(mAccelerometerDefault==0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1604679162 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646938350 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_646938350;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_857437572 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090152044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090152044;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.868 -0400", hash_original_method = "AB24297EBE6570DB7446321DF663FF8C", hash_generated_method = "EA701645474DD50B8082711F0519095F")
     void updateOrientationListenerLp() {
        if(!mOrientationListener.canDetectOrientation())        
        {
            return;
        } //End block
        if(localLOGV){ }        boolean disable = true;
        if(mScreenOnEarly)        
        {
            if(needSensorRunningLp())            
            {
disable=false                if(!mOrientationSensorEnabled)                
                {
mOrientationListener.enable()                    if(localLOGV){ }mOrientationSensorEnabled=true
                } //End block
            } //End block
        } //End block
        if(disable&&mOrientationSensorEnabled)        
        {
mOrientationListener.disable()            if(localLOGV){ }mOrientationSensorEnabled=false
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.869 -0400", hash_original_method = "11BB58E08CA9A2C52BF0F11CADF60E7D", hash_generated_method = "997DEA8ED32EBDAF82A0E024F815E333")
    private void interceptPowerKeyDown(boolean handled) {
        addTaint(handled);
mPowerKeyHandled=handled        if(!handled)        
        {
mHandler.postDelayed(mPowerLongPress, ViewConfiguration.getGlobalActionKeyTimeout())
        } //End block
        // ---------- Original Method ----------
        //mPowerKeyHandled = handled;
        //if (!handled) {
            //mHandler.postDelayed(mPowerLongPress, ViewConfiguration.getGlobalActionKeyTimeout());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.870 -0400", hash_original_method = "E486A036500C23F8C2F1E53E855E566E", hash_generated_method = "291252B31D024997AF56070ECC2F88B3")
    private boolean interceptPowerKeyUp(boolean canceled) {
        addTaint(canceled);
        if(!mPowerKeyHandled)        
        {
mHandler.removeCallbacks(mPowerLongPress)            boolean varC2E88BF5847FB8A15B5983A9AAF143AE_737844498 = (!canceled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647688426 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647688426;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1729929171 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885505842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885505842;
        // ---------- Original Method ----------
        //if (!mPowerKeyHandled) {
            //mHandler.removeCallbacks(mPowerLongPress);
            //return !canceled;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.870 -0400", hash_original_method = "5AC35BCA884A912D6E68E5FA42CA42E1", hash_generated_method = "A6428F9B20EE7A20561D306D60613E6B")
    private void cancelPendingPowerKeyAction() {
        if(!mPowerKeyHandled)        
        {
mHandler.removeCallbacks(mPowerLongPress)
        } //End block
        if(mPowerKeyTriggered)        
        {
mPendingPowerKeyUpCanceled=true
        } //End block
        // ---------- Original Method ----------
        //if (!mPowerKeyHandled) {
            //mHandler.removeCallbacks(mPowerLongPress);
        //}
        //if (mPowerKeyTriggered) {
            //mPendingPowerKeyUpCanceled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.871 -0400", hash_original_method = "E2A02FCF1EFD6BB8CAFCDABD267BE1BE", hash_generated_method = "4BC5510A0CD577ED53A76FE14DEB2E38")
    private void interceptScreenshotChord() {
        if(mVolumeDownKeyTriggered&&mPowerKeyTriggered&&!mVolumeUpKeyTriggered)        
        {
            final long now = SystemClock.uptimeMillis();
            if(now<=mVolumeDownKeyTime+SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS&&now<=mPowerKeyTime+SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS)            
            {
mVolumeDownKeyConsumedByScreenshotChord=truecancelPendingPowerKeyAction()mHandler.postDelayed(mScreenshotChordLongPress, ViewConfiguration.getGlobalActionKeyTimeout())
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mVolumeDownKeyTriggered && mPowerKeyTriggered && !mVolumeUpKeyTriggered) {
            //final long now = SystemClock.uptimeMillis();
            //if (now <= mVolumeDownKeyTime + SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS
                    //&& now <= mPowerKeyTime + SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS) {
                //mVolumeDownKeyConsumedByScreenshotChord = true;
                //cancelPendingPowerKeyAction();
                //mHandler.postDelayed(mScreenshotChordLongPress,
                        //ViewConfiguration.getGlobalActionKeyTimeout());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.872 -0400", hash_original_method = "267F0FDC465132D80243D272EEBC3AEE", hash_generated_method = "A9A7A7A300B40FC33F6D98174BB1E17E")
    private void cancelPendingScreenshotChordAction() {
mHandler.removeCallbacks(mScreenshotChordLongPress)
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mScreenshotChordLongPress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.873 -0400", hash_original_method = "99BABE49B4CC9A56D5474FDD893652D1", hash_generated_method = "7DFC6A719BC3D555A5975518F222BBF0")
     void showGlobalActionsDialog() {
        if(mGlobalActions==null)        
        {
mGlobalActions=new GlobalActions(mContext)
        } //End block
        final boolean keyguardShowing = mKeyguardMediator.isShowingAndNotHidden();
mGlobalActions.showDialog(keyguardShowing, isDeviceProvisioned())        if(keyguardShowing)        
        {
mKeyguardMediator.pokeWakelock()
        } //End block
        // ---------- Original Method ----------
        //if (mGlobalActions == null) {
            //mGlobalActions = new GlobalActions(mContext);
        //}
        //final boolean keyguardShowing = mKeyguardMediator.isShowingAndNotHidden();
        //mGlobalActions.showDialog(keyguardShowing, isDeviceProvisioned());
        //if (keyguardShowing) {
            //mKeyguardMediator.pokeWakelock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.874 -0400", hash_original_method = "C7B52C096A3471B0A34344D66740BAEB", hash_generated_method = "7962E39E06B70242A18AD4FB9F6C6DCD")
     boolean isDeviceProvisioned() {
        boolean var467D5D0784A624D1FFD44F0EE00E8085_316639756 = (Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.DEVICE_PROVISIONED, 0)!=0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427846605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_427846605;
        // ---------- Original Method ----------
        //return Settings.Secure.getInt(
                //mContext.getContentResolver(), Settings.Secure.DEVICE_PROVISIONED, 0) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.875 -0400", hash_original_method = "6D1152F9AB7AB67D1F1D5E5322C6F946", hash_generated_method = "056D6D217805713CFD2087A17A3B86A1")
    private void handleLongPressOnHome() {
        if(mLongPressOnHomeBehavior<0)        
        {
mLongPressOnHomeBehavior=mContext.getResources().getInteger(R.integer.config_longPressOnHomeBehavior)            if(mLongPressOnHomeBehavior<LONG_PRESS_HOME_NOTHING||mLongPressOnHomeBehavior>LONG_PRESS_HOME_RECENT_SYSTEM_UI)            
            {
mLongPressOnHomeBehavior=LONG_PRESS_HOME_NOTHING
            } //End block
        } //End block
        if(mLongPressOnHomeBehavior!=LONG_PRESS_HOME_NOTHING)        
        {
performHapticFeedbackLw(null, HapticFeedbackConstants.LONG_PRESS, false)sendCloseSystemWindows(SYSTEM_DIALOG_REASON_RECENT_APPS)mHomePressed=false
        } //End block
        if(mLongPressOnHomeBehavior==LONG_PRESS_HOME_RECENT_DIALOG)        
        {
showOrHideRecentAppsDialog(RECENT_APPS_BEHAVIOR_SHOW_OR_DISMISS)
        } //End block
        else
        if(mLongPressOnHomeBehavior==LONG_PRESS_HOME_RECENT_SYSTEM_UI)        
        {
            try 
            {
mStatusBarService.toggleRecentApps()
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.878 -0400", hash_original_method = "0FE696C73DBFB861C1648B83B4A3CAEB", hash_generated_method = "1FEBF124BDA1F17FD12AE5B14647F429")
     void showOrHideRecentAppsDialog(final int behavior) {
        addTaint(behavior);
mHandler.post(new Runnable()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.877 -0400", hash_original_method = "A817F8F241C5F6C70F2B7C0AEF837BF8", hash_generated_method = "3C6E8D02C4C3322BF3A36F31D2748FD3")
        @Override
        public void run() {
            if(mRecentAppsDialog==null)            
            {
mRecentAppsDialog=new RecentApplicationsDialog(mContext)
            } //End block
            if(mRecentAppsDialog.isShowing())            
            {
                switch(behavior){
                case RECENT_APPS_BEHAVIOR_SHOW_OR_DISMISS:
mRecentAppsDialog.dismiss()                break;
                case RECENT_APPS_BEHAVIOR_DISMISS_AND_SWITCH:
mRecentAppsDialog.dismissAndSwitch()                break;
                case RECENT_APPS_BEHAVIOR_EXIT_TOUCH_MODE_AND_SHOW:
                default:
                break;
}
            } //End block
            else
            {
                switch(behavior){
                case RECENT_APPS_BEHAVIOR_SHOW_OR_DISMISS:
mRecentAppsDialog.show()                break;
                case RECENT_APPS_BEHAVIOR_EXIT_TOUCH_MODE_AND_SHOW:
                try 
                {
mWindowManager.setInTouchMode(false)
                } //End block
                catch (RemoteException e)
                {
                } //End block
mRecentAppsDialog.show()                break;
                case RECENT_APPS_BEHAVIOR_DISMISS_AND_SWITCH:
                default:
                break;
}
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        }
)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.880 -0400", hash_original_method = "F1447C0A1859C5C1B22CB5EE8A47CAFB", hash_generated_method = "CEC86A81398B6898382B7538E0024D08")
    public void init(Context context, IWindowManager windowManager,
            WindowManagerFuncs windowManagerFuncs,
            LocalPowerManager powerManager) {
        addTaint(powerManager.getTaint());
        addTaint(windowManagerFuncs.getTaint());
        addTaint(windowManager.getTaint());
        addTaint(context.getTaint());
mContext=contextmWindowManager=windowManagermWindowManagerFuncs=windowManagerFuncsmPowerManager=powerManagermKeyguardMediator=new KeyguardViewMediator(context, this, powerManager)mHandler=new Handler()mOrientationListener=new MyOrientationListener(mContext)        try 
        {
mOrientationListener.setCurrentRotation(windowManager.getRotation())
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        SettingsObserver settingsObserver = new SettingsObserver(mHandler);
settingsObserver.observe()mShortcutManager=new ShortcutManager(context, mHandler)mShortcutManager.observe()mHomeIntent=new Intent(Intent.ACTION_MAIN, null)mHomeIntent.addCategory(Intent.CATEGORY_HOME)mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)mCarDockIntent=new Intent(Intent.ACTION_MAIN, null)mCarDockIntent.addCategory(Intent.CATEGORY_CAR_DOCK)mCarDockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)mDeskDockIntent=new Intent(Intent.ACTION_MAIN, null)mDeskDockIntent.addCategory(Intent.CATEGORY_DESK_DOCK)mDeskDockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
mBroadcastWakeLock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "PhoneWindowManager.mBroadcastWakeLock")mEnableShiftMenuBugReports="1".equals(SystemProperties.get("ro.debuggable"))mLidOpenRotation=readRotation(com.android.internal.R.integer.config_lidOpenRotation)mCarDockRotation=readRotation(com.android.internal.R.integer.config_carDockRotation)mDeskDockRotation=readRotation(com.android.internal.R.integer.config_deskDockRotation)mCarDockEnablesAccelerometer=mContext.getResources().getBoolean(com.android.internal.R.bool.config_carDockEnablesAccelerometer)mDeskDockEnablesAccelerometer=mContext.getResources().getBoolean(com.android.internal.R.bool.config_deskDockEnablesAccelerometer)mLidKeyboardAccessibility=mContext.getResources().getInteger(com.android.internal.R.integer.config_lidKeyboardAccessibility)mLidNavigationAccessibility=mContext.getResources().getInteger(com.android.internal.R.integer.config_lidNavigationAccessibility)        IntentFilter filter = new IntentFilter();
filter.addAction(UiModeManager.ACTION_ENTER_CAR_MODE)filter.addAction(UiModeManager.ACTION_EXIT_CAR_MODE)filter.addAction(UiModeManager.ACTION_ENTER_DESK_MODE)filter.addAction(UiModeManager.ACTION_EXIT_DESK_MODE)filter.addAction(Intent.ACTION_DOCK_EVENT)        Intent intent = context.registerReceiver(mDockReceiver, filter);
        if(intent!=null)        
        {
mDockMode=intent.getIntExtra(Intent.EXTRA_DOCK_STATE, Intent.EXTRA_DOCK_STATE_UNDOCKED)
        } //End block
mVibrator=new Vibrator()mLongPressVibePattern=getLongIntArray(mContext.getResources(), com.android.internal.R.array.config_longPressVibePattern)mVirtualKeyVibePattern=getLongIntArray(mContext.getResources(), com.android.internal.R.array.config_virtualKeyVibePattern)mKeyboardTapVibePattern=getLongIntArray(mContext.getResources(), com.android.internal.R.array.config_keyboardTapVibePattern)mSafeModeDisabledVibePattern=getLongIntArray(mContext.getResources(), com.android.internal.R.array.config_safeModeDisabledVibePattern)mSafeModeEnabledVibePattern=getLongIntArray(mContext.getResources(), com.android.internal.R.array.config_safeModeEnabledVibePattern)initializeHdmiState()        if(mPowerManager.isScreenOn())        
        {
screenTurningOn(null)
        } //End block
        else
        {
screenTurnedOff(WindowManagerPolicy.OFF_BECAUSE_OF_USER)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.883 -0400", hash_original_method = "CBEFB1AF0F866515B01E631804A020B4", hash_generated_method = "A538DF55CC7CD0CA044F3F2D9B123E84")
    public void setInitialDisplaySize(int width, int height) {
        addTaint(height);
        addTaint(width);
        int shortSize;
        if(width>height)        
        {
shortSize=heightmLandscapeRotation=Surface.ROTATION_0mSeascapeRotation=Surface.ROTATION_180            if(mContext.getResources().getBoolean(com.android.internal.R.bool.config_reverseDefaultRotation))            
            {
mPortraitRotation=Surface.ROTATION_90mUpsideDownRotation=Surface.ROTATION_270
            } //End block
            else
            {
mPortraitRotation=Surface.ROTATION_270mUpsideDownRotation=Surface.ROTATION_90
            } //End block
        } //End block
        else
        {
shortSize=widthmPortraitRotation=Surface.ROTATION_0mUpsideDownRotation=Surface.ROTATION_180            if(mContext.getResources().getBoolean(com.android.internal.R.bool.config_reverseDefaultRotation))            
            {
mLandscapeRotation=Surface.ROTATION_270mSeascapeRotation=Surface.ROTATION_90
            } //End block
            else
            {
mLandscapeRotation=Surface.ROTATION_90mSeascapeRotation=Surface.ROTATION_270
            } //End block
        } //End block
        int shortSizeDp = shortSize
                * DisplayMetrics.DENSITY_DEFAULT
                / DisplayMetrics.DENSITY_DEVICE;
mStatusBarCanHide=shortSizeDp<600mStatusBarHeight=mContext.getResources().getDimensionPixelSize(mStatusBarCanHide?com.android.internal.R.dimen.status_bar_height:com.android.internal.R.dimen.status_bar_height)mHasNavigationBar=mContext.getResources().getBoolean(com.android.internal.R.bool.config_showNavigationBar)        String navBarOverride = SystemProperties.get("qemu.hw.mainkeys");
        if(!"".equals(navBarOverride))        
        {
            if(navBarOverride.equals("1"))            
mHasNavigationBar=false
            else
            if(navBarOverride.equals("0"))            
mHasNavigationBar=true
        } //End block
mNavigationBarHeight=mHasNavigationBar?mContext.getResources().getDimensionPixelSize(com.android.internal.R.dimen.navigation_bar_height):mContext.getResources().getDimensionPixelSize(com.android.internal.R.dimen.navigation_bar_height)mNavigationBarWidth=mHasNavigationBar?mContext.getResources().getDimensionPixelSize(com.android.internal.R.dimen.navigation_bar_width):mContext.getResources().getDimensionPixelSize(com.android.internal.R.dimen.navigation_bar_width)        if("portrait".equals(SystemProperties.get("persist.demo.hdmirotation")))        
        {
mHdmiRotation=mPortraitRotation
        } //End block
        else
        {
mHdmiRotation=mLandscapeRotation
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.887 -0400", hash_original_method = "DFD47CB0A9BAC40743BA1B2FBCB2D28E", hash_generated_method = "008DA77465BD221D2D6020ECB6892A7C")
    public void updateSettings() {
        ContentResolver resolver = mContext.getContentResolver();
        boolean updateRotation = false;
        View addView = null;
        View removeView = null;
        synchronized
(mLock)        {
mEndcallBehavior=Settings.System.getInt(resolver, Settings.System.END_BUTTON_BEHAVIOR, Settings.System.END_BUTTON_BEHAVIOR_DEFAULT)mIncallPowerBehavior=Settings.Secure.getInt(resolver, Settings.Secure.INCALL_POWER_BUTTON_BEHAVIOR, Settings.Secure.INCALL_POWER_BUTTON_BEHAVIOR_DEFAULT)            int accelerometerDefault = Settings.System.getInt(resolver,
                    Settings.System.ACCELEROMETER_ROTATION, DEFAULT_ACCELEROMETER_ROTATION);
mUserRotationMode=(accelerometerDefault==0)?WindowManagerPolicy.USER_ROTATION_LOCKED:WindowManagerPolicy.USER_ROTATION_LOCKEDmUserRotation=Settings.System.getInt(resolver, Settings.System.USER_ROTATION, Surface.ROTATION_0)            if(mAccelerometerDefault!=accelerometerDefault)            
            {
mAccelerometerDefault=accelerometerDefaultupdateOrientationListenerLp()
            } //End block
mOrientationListener.setLogEnabled(Settings.System.getInt(resolver, Settings.System.WINDOW_ORIENTATION_LISTENER_LOG, 0)!=0)            if(mSystemReady)            
            {
                int pointerLocation = Settings.System.getInt(resolver,
                        Settings.System.POINTER_LOCATION, 0);
                if(mPointerLocationMode!=pointerLocation)                
                {
mPointerLocationMode=pointerLocation                    if(pointerLocation!=0)                    
                    {
                        if(mPointerLocationView==null)                        
                        {
mPointerLocationView=new PointerLocationView(mContext)mPointerLocationView.setPrintCoords(false)addView=mPointerLocationView
                        } //End block
                    } //End block
                    else
                    {
removeView=mPointerLocationViewmPointerLocationView=null
                    } //End block
                } //End block
            } //End block
mLockScreenTimeout=Settings.System.getInt(resolver, Settings.System.SCREEN_OFF_TIMEOUT, 0)            String imId = Settings.Secure.getString(resolver,
                    Settings.Secure.DEFAULT_INPUT_METHOD);
            boolean hasSoftInput = imId != null && imId.length() > 0;
            if(mHasSoftInput!=hasSoftInput)            
            {
mHasSoftInput=hasSoftInputupdateRotation=true
            } //End block
        } //End block
        if(updateRotation)        
        {
updateRotation(true)
        } //End block
        if(addView!=null)        
        {
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT);
lp.type=WindowManager.LayoutParams.TYPE_SECURE_SYSTEM_OVERLAYlp.flags=WindowManager.LayoutParams.FLAG_FULLSCREEN|WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREENlp.format=PixelFormat.TRANSLUCENTlp.setTitle("PointerLocation")            WindowManager wm = (WindowManager)
                    mContext.getSystemService(Context.WINDOW_SERVICE);
lp.inputFeatures|=WindowManager.LayoutParams.INPUT_FEATURE_NO_INPUT_CHANNELwm.addView(addView, lp)            if(mPointerLocationInputChannel==null)            
            {
                try 
                {
mPointerLocationInputChannel=mWindowManager.monitorInput("PointerLocationView")InputQueue.registerInputChannel(mPointerLocationInputChannel, mPointerLocationInputHandler, mHandler.getLooper().getQueue())
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
        } //End block
        if(removeView!=null)        
        {
            if(mPointerLocationInputChannel!=null)            
            {
InputQueue.unregisterInputChannel(mPointerLocationInputChannel)mPointerLocationInputChannel.dispose()mPointerLocationInputChannel=null
            } //End block
            WindowManager wm = (WindowManager)
                    mContext.getSystemService(Context.WINDOW_SERVICE);
wm.removeView(removeView)
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.891 -0400", hash_original_method = "EA99564D33A13E1D77000F5310B6AEAA", hash_generated_method = "D875A76531D5406CD35663E983E8B859")
    private int readRotation(int resID) {
        addTaint(resID);
        try 
        {
            int rotation = mContext.getResources().getInteger(resID);
            switch(rotation){
            case 0:
            int varE560F3BBCB073851AA5D49F37B757556_1162101205 = (Surface.ROTATION_0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332032941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332032941;
            case 90:
            int varF83F726C27573929DD22715D646A6DB1_180043181 = (Surface.ROTATION_90);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600079257 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1600079257;
            case 180:
            int var5AC5BE7B317D059C65A9167F71765BE1_1714337338 = (Surface.ROTATION_180);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197919516 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197919516;
            case 270:
            int var0DFC330080ACBBE87628B00A4B98BAD4_1067329640 = (Surface.ROTATION_270);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566912434 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1566912434;
}
        } //End block
        catch (Resources.NotFoundException e)
        {
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1318010428 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412757481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412757481;
        // ---------- Original Method ----------
        //try {
            //int rotation = mContext.getResources().getInteger(resID);
            //switch (rotation) {
                //case 0:
                    //return Surface.ROTATION_0;
                //case 90:
                    //return Surface.ROTATION_90;
                //case 180:
                    //return Surface.ROTATION_180;
                //case 270:
                    //return Surface.ROTATION_270;
            //}
        //} catch (Resources.NotFoundException e) {
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.894 -0400", hash_original_method = "23CE57833680877992AAD3C56339CC22", hash_generated_method = "C46A5DF98251E43DE277718BE3F5566E")
    public int checkAddPermission(WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        int type = attrs.type;
        if(type<WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW||type>WindowManager.LayoutParams.LAST_SYSTEM_WINDOW)        
        {
            int varBEB882FFF92D04B1F8CFF9C22EF33812_2030852909 = (WindowManagerImpl.ADD_OKAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173660869 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1173660869;
        } //End block
        String permission = null;
        switch(type){
        case TYPE_TOAST:
        break;
        case TYPE_INPUT_METHOD:
        case TYPE_WALLPAPER:
        break;
        case TYPE_PHONE:
        case TYPE_PRIORITY_PHONE:
        case TYPE_SYSTEM_ALERT:
        case TYPE_SYSTEM_ERROR:
        case TYPE_SYSTEM_OVERLAY:
permission=android.Manifest.permission.SYSTEM_ALERT_WINDOW        break;
        default:
permission=android.Manifest.permission.INTERNAL_SYSTEM_WINDOW}        if(permission!=null)        
        {
            if(mContext.checkCallingOrSelfPermission(permission)!=PackageManager.PERMISSION_GRANTED)            
            {
                int var960073A93DFC7A07A93BFF509FCBA8EC_891611370 = (WindowManagerImpl.ADD_PERMISSION_DENIED);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509973855 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509973855;
            } //End block
        } //End block
        int varBEB882FFF92D04B1F8CFF9C22EF33812_523907731 = (WindowManagerImpl.ADD_OKAY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692111372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692111372;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.896 -0400", hash_original_method = "FE88FE188C50B1D3575E05001A266642", hash_generated_method = "38BC6E7B7DA3A74D196DEDCB4E8ADA49")
    public void adjustWindowParamsLw(WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        switch(attrs.type){
        case TYPE_SYSTEM_OVERLAY:
        case TYPE_SECURE_SYSTEM_OVERLAY:
        case TYPE_TOAST:
attrs.flags|=WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_NOT_TOUCHABLEattrs.flags&=~WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH        break;
}
        // ---------- Original Method ----------
        //switch (attrs.type) {
            //case TYPE_SYSTEM_OVERLAY:
            //case TYPE_SECURE_SYSTEM_OVERLAY:
            //case TYPE_TOAST:
                //attrs.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        //| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
                //attrs.flags &= ~WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.897 -0400", hash_original_method = "3C4130B444FA12E8EE84BDC293E5B06C", hash_generated_method = "B5E1CFA5347C3CBA4B942510AF3E1314")
     void readLidState() {
        try 
        {
            int sw = mWindowManager.getSwitchState(SW_LID);
            if(sw>0)            
            {
mLidOpen=LID_OPEN
            } //End block
            else
            if(sw==0)            
            {
mLidOpen=LID_CLOSED
            } //End block
            else
            {
mLidOpen=LID_ABSENT
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //int sw = mWindowManager.getSwitchState(SW_LID);
            //if (sw > 0) {
                //mLidOpen = LID_OPEN;
            //} else if (sw == 0) {
                //mLidOpen = LID_CLOSED;
            //} else {
                //mLidOpen = LID_ABSENT;
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.899 -0400", hash_original_method = "045B8C8B9B3C0309CE59C646DE978B6C", hash_generated_method = "5B3FE1478581DE8CA8B082D5CD83F4AC")
    private int determineHiddenState(int mode, int hiddenValue, int visibleValue) {
        addTaint(visibleValue);
        addTaint(hiddenValue);
        addTaint(mode);
        if(mLidOpen!=LID_ABSENT)        
        {
            switch(mode){
            case 1:
            int varCBEBD12B666AA14BB02122D4928B6425_512488119 = (mLidOpen==LID_OPEN?visibleValue:visibleValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732804382 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732804382;
            case 2:
            int varC3863C03CF6248841C85A74497065F7B_2088509777 = (mLidOpen==LID_OPEN?hiddenValue:hiddenValue);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110883361 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1110883361;
}
        } //End block
        int var10043DB24482C6BAC84768FB75436150_1027917747 = (visibleValue);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120840381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2120840381;
        // ---------- Original Method ----------
        //if (mLidOpen != LID_ABSENT) {
            //switch (mode) {
                //case 1:
                    //return mLidOpen == LID_OPEN ? visibleValue : hiddenValue;
                //case 2:
                    //return mLidOpen == LID_OPEN ? hiddenValue : visibleValue;
            //}
        //}
        //return visibleValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.900 -0400", hash_original_method = "988E91A3D43A0FBC3447B0BEB613F023", hash_generated_method = "F8F77E419FA9BE069C7814DC344F9A20")
    public void adjustConfigurationLw(Configuration config) {
        addTaint(config.getTaint());
readLidState()updateKeyboardVisibility()        if(config.keyboard==Configuration.KEYBOARD_NOKEYS)        
        {
config.hardKeyboardHidden=Configuration.HARDKEYBOARDHIDDEN_YES
        } //End block
        else
        {
config.hardKeyboardHidden=determineHiddenState(mLidKeyboardAccessibility, Configuration.HARDKEYBOARDHIDDEN_YES, Configuration.HARDKEYBOARDHIDDEN_NO)
        } //End block
        if(config.navigation==Configuration.NAVIGATION_NONAV)        
        {
config.navigationHidden=Configuration.NAVIGATIONHIDDEN_YES
        } //End block
        else
        {
config.navigationHidden=determineHiddenState(mLidNavigationAccessibility, Configuration.NAVIGATIONHIDDEN_YES, Configuration.NAVIGATIONHIDDEN_NO)
        } //End block
        if(mHasSoftInput||config.hardKeyboardHidden==Configuration.HARDKEYBOARDHIDDEN_NO)        
        {
config.keyboardHidden=Configuration.KEYBOARDHIDDEN_NO
        } //End block
        else
        {
config.keyboardHidden=Configuration.KEYBOARDHIDDEN_YES
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.903 -0400", hash_original_method = "6B3162D4FD292B52BBBCEF1EF97E5897", hash_generated_method = "E12B4637C632FF27A1706D98EACBBCF6")
    public int windowTypeToLayerLw(int type) {
        addTaint(type);
        if(type>=FIRST_APPLICATION_WINDOW&&type<=LAST_APPLICATION_WINDOW)        
        {
            int varBA2480B9D6E249731D1948A2883392E8_1883857913 = (APPLICATION_LAYER);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156441452 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156441452;
        } //End block
        switch(type){
        case TYPE_STATUS_BAR:
        int var1A67B482F1458C829A4D850BF3AAD0FD_1767844985 = (STATUS_BAR_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530771202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530771202;
        case TYPE_STATUS_BAR_PANEL:
        int var918B5C1222945522756B68DE18589DF5_567527230 = (STATUS_BAR_PANEL_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130341113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130341113;
        case TYPE_STATUS_BAR_SUB_PANEL:
        int varA3C0B22306291B43AC487DEE09FF436A_152482251 = (STATUS_BAR_SUB_PANEL_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962345434 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962345434;
        case TYPE_SYSTEM_DIALOG:
        int varFCCB55FEC880E80D4345FB03C7AB844C_256790672 = (SYSTEM_DIALOG_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284847882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284847882;
        case TYPE_SEARCH_BAR:
        int var3DDD2A18793CFA35D31C6D409F6D3CC8_1558900842 = (SEARCH_BAR_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893667222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893667222;
        case TYPE_PHONE:
        int var468AF228D71CAC2D9436110829E9E5C3_1123919447 = (PHONE_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991929052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991929052;
        case TYPE_KEYGUARD:
        int var3DF9C2B877F101DA443C9C2163EFDFE9_103300624 = (KEYGUARD_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887144983 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1887144983;
        case TYPE_KEYGUARD_DIALOG:
        int varC6A27B455ABEED2CA1364DD0637EB1EC_36579042 = (KEYGUARD_DIALOG_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645875212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645875212;
        case TYPE_SYSTEM_ALERT:
        int varCC529F856222E3A68CB5D0453A2A9750_923942306 = (SYSTEM_ALERT_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084522192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2084522192;
        case TYPE_SYSTEM_ERROR:
        int varAC0D375BD53B92A27BC6C339BB6ECAD2_1300108860 = (SYSTEM_ERROR_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433386012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1433386012;
        case TYPE_INPUT_METHOD:
        int varA18F57F21F3D00C659EDC3EF2697A51C_1507148123 = (INPUT_METHOD_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923499182 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_923499182;
        case TYPE_INPUT_METHOD_DIALOG:
        int varF593ECF47CE8693EED17C6FA7FD61EF8_2055061951 = (INPUT_METHOD_DIALOG_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530165046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530165046;
        case TYPE_VOLUME_OVERLAY:
        int var408A61A4F2D98F682D7175F72A276DA3_1455595506 = (VOLUME_OVERLAY_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387107341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387107341;
        case TYPE_SYSTEM_OVERLAY:
        int varD3A06D37239B4AE2AED21B3851AE03D1_359796111 = (SYSTEM_OVERLAY_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853867439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853867439;
        case TYPE_SECURE_SYSTEM_OVERLAY:
        int varF40463AAB4E102C887BF34F0BB5C3127_1370073509 = (SECURE_SYSTEM_OVERLAY_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487874105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487874105;
        case TYPE_PRIORITY_PHONE:
        int varBA2C53BD5EB2025A774CA9833A34E766_2032730873 = (PRIORITY_PHONE_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144466275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1144466275;
        case TYPE_TOAST:
        int varE0665EE46C07001AD9D04C6163985F3B_212701787 = (TOAST_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725382432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_725382432;
        case TYPE_WALLPAPER:
        int var056DAA2C8A8E0DCB3D5AF0E9DCFE0C60_457361737 = (WALLPAPER_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657448234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657448234;
        case TYPE_DRAG:
        int var85A7BCD67F013CC25F9F6F9915B1BE1A_2112332699 = (DRAG_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658164458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1658164458;
        case TYPE_POINTER:
        int varB59A78DFC752B2D9ED64D2CA44E0A1F2_1311465249 = (POINTER_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850101675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850101675;
        case TYPE_NAVIGATION_BAR:
        int var0B0829D1628CE5884A068852BCE3DFB2_1675342228 = (NAVIGATION_BAR_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888807211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888807211;
        case TYPE_BOOT_PROGRESS:
        int var397FCA4216A531942F61FDA2D652DE91_381680659 = (BOOT_PROGRESS_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790366389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790366389;
        case TYPE_HIDDEN_NAV_CONSUMER:
        int var0727047E7E497C095962F61899ADB64E_865969656 = (HIDDEN_NAV_CONSUMER_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197579067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197579067;
}        int varBA2480B9D6E249731D1948A2883392E8_2121362285 = (APPLICATION_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811874286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811874286;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.905 -0400", hash_original_method = "4C83BEC81AF303062985FBC77FA027BE", hash_generated_method = "D24EF73767BDC6F3FE03B09053EADA81")
    public int subWindowTypeToLayerLw(int type) {
        addTaint(type);
        switch(type){
        case TYPE_APPLICATION_PANEL:
        case TYPE_APPLICATION_ATTACHED_DIALOG:
        int var803E1C3824804AE3A10D57783427CB6C_897826440 = (APPLICATION_PANEL_SUBLAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120935572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120935572;
        case TYPE_APPLICATION_MEDIA:
        int var34C08BDFD29BDAF09326348D12FAE054_536875817 = (APPLICATION_MEDIA_SUBLAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832934929 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1832934929;
        case TYPE_APPLICATION_MEDIA_OVERLAY:
        int var8641E3FCAFE5657659C94898A5371920_336014817 = (APPLICATION_MEDIA_OVERLAY_SUBLAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418296505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418296505;
        case TYPE_APPLICATION_SUB_PANEL:
        int var459710A66C5B14E0D61E297A88CF5E2A_362614800 = (APPLICATION_SUB_PANEL_SUBLAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851905039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851905039;
}        int varCFCD208495D565EF66E7DFF9F98764DA_516911318 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1507041946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1507041946;
        // ---------- Original Method ----------
        //switch (type) {
        //case TYPE_APPLICATION_PANEL:
        //case TYPE_APPLICATION_ATTACHED_DIALOG:
            //return APPLICATION_PANEL_SUBLAYER;
        //case TYPE_APPLICATION_MEDIA:
            //return APPLICATION_MEDIA_SUBLAYER;
        //case TYPE_APPLICATION_MEDIA_OVERLAY:
            //return APPLICATION_MEDIA_OVERLAY_SUBLAYER;
        //case TYPE_APPLICATION_SUB_PANEL:
            //return APPLICATION_SUB_PANEL_SUBLAYER;
        //}
        //Log.e(TAG, "Unknown sub-window type: " + type);
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.906 -0400", hash_original_method = "9781A3B1877B8A1D665A07833B1F5C9E", hash_generated_method = "CE5692E37F976AC0672693E080E31B0E")
    public int getMaxWallpaperLayer() {
        int var1A67B482F1458C829A4D850BF3AAD0FD_2059863639 = (STATUS_BAR_LAYER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911142191 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911142191;
        // ---------- Original Method ----------
        //return STATUS_BAR_LAYER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.907 -0400", hash_original_method = "F858FE284F20D8FFB630FC593622B695", hash_generated_method = "990B60AE25E84B0DE659D2A3AAD0C0D2")
    public boolean canStatusBarHide() {
        boolean varEFD6080F68124BA2A0960DB18523C5D0_1801629198 = (mStatusBarCanHide);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2034479167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2034479167;
        // ---------- Original Method ----------
        //return mStatusBarCanHide;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.908 -0400", hash_original_method = "9B754D4C6B6D295CDE11C859940B5C22", hash_generated_method = "3DD30AE210F73C797E496FD83403B1F2")
    public int getNonDecorDisplayWidth(int fullWidth, int fullHeight, int rotation) {
        addTaint(rotation);
        addTaint(fullHeight);
        addTaint(fullWidth);
        if(fullWidth>fullHeight)        
        {
            int var057A16C82704BCDC2487C08BAF1F026C_1839211746 = (fullWidth-mNavigationBarWidth);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043247259 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043247259;
        } //End block
        int var4EC25E806772B24AA6004CF748BFF017_1517820240 = (fullWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662634765 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662634765;
        // ---------- Original Method ----------
        //if (fullWidth > fullHeight) {
            //return fullWidth - mNavigationBarWidth;
        //}
        //return fullWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.909 -0400", hash_original_method = "6EC6EDB03E94F41036EF12B12AC1B125", hash_generated_method = "087615207635D44F38C5755F9C94C643")
    public int getNonDecorDisplayHeight(int fullWidth, int fullHeight, int rotation) {
        addTaint(rotation);
        addTaint(fullHeight);
        addTaint(fullWidth);
        int var92796A22F43B5C2D91ECD2B51A65690D_1950069009 = (fullHeight-(mStatusBarCanHide?0:0)-((fullWidth>fullHeight)?0:0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176702218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_176702218;
        // ---------- Original Method ----------
        //return fullHeight
            //- (mStatusBarCanHide ? 0 : mStatusBarHeight)
            //- ((fullWidth > fullHeight) ? 0 : mNavigationBarHeight);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.910 -0400", hash_original_method = "199654F1FC20D7283D473CF1584C3179", hash_generated_method = "7DA5F71B7E34C1047A4B7F97A9F37E38")
    public int getConfigDisplayWidth(int fullWidth, int fullHeight, int rotation) {
        addTaint(rotation);
        addTaint(fullHeight);
        addTaint(fullWidth);
        int var519E59008C8C76F88F85D001FEB14707_710205933 = (getNonDecorDisplayWidth(fullWidth, fullHeight, rotation));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717611019 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_717611019;
        // ---------- Original Method ----------
        //return getNonDecorDisplayWidth(fullWidth, fullHeight, rotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.910 -0400", hash_original_method = "39AC4CDEE267FA8B92D9A204F8691412", hash_generated_method = "1BD4DCA1F8F880A94C437FE7C80FF351")
    public int getConfigDisplayHeight(int fullWidth, int fullHeight, int rotation) {
        addTaint(rotation);
        addTaint(fullHeight);
        addTaint(fullWidth);
        int var63571EE4B5DFA932F36B5B140D1198E2_1179724120 = (getNonDecorDisplayHeight(fullWidth, fullHeight, rotation)-(mStatusBarCanHide?mStatusBarHeight:mStatusBarHeight));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150884530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150884530;
        // ---------- Original Method ----------
        //return getNonDecorDisplayHeight(fullWidth, fullHeight, rotation)
                //- (mStatusBarCanHide ? mStatusBarHeight : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.911 -0400", hash_original_method = "E8E6FC114EDF3909D14EE366BED0A001", hash_generated_method = "CDD58B70600BBABB8B6015DB4115B4F9")
    public boolean doesForceHide(WindowState win, WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        addTaint(win.getTaint());
        boolean var49CC02487A89951D145105147ED614EC_325391484 = (attrs.type==WindowManager.LayoutParams.TYPE_KEYGUARD);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_971554659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_971554659;
        // ---------- Original Method ----------
        //return attrs.type == WindowManager.LayoutParams.TYPE_KEYGUARD;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.911 -0400", hash_original_method = "AD471BA58E7000AAFB5D26045C72A7D6", hash_generated_method = "C538A771E7899A030EA2F8C452751851")
    public boolean canBeForceHidden(WindowState win, WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        addTaint(win.getTaint());
        boolean var2EA5DB5DEAC1B66D90278914D037AB4B_908320131 = (attrs.type!=WindowManager.LayoutParams.TYPE_STATUS_BAR&&attrs.type!=WindowManager.LayoutParams.TYPE_WALLPAPER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784814126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784814126;
        // ---------- Original Method ----------
        //return attrs.type != WindowManager.LayoutParams.TYPE_STATUS_BAR
                //&& attrs.type != WindowManager.LayoutParams.TYPE_WALLPAPER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.913 -0400", hash_original_method = "A94F97CD33EAE5FA48DFF8737979F182", hash_generated_method = "83BF7D8B023D1C8785422ADCAB657E59")
    public View addStartingWindow(IBinder appToken, String packageName, int theme,
            CompatibilityInfo compatInfo, CharSequence nonLocalizedLabel, int labelRes,
            int icon, int windowFlags) {
        addTaint(windowFlags);
        addTaint(icon);
        addTaint(labelRes);
        addTaint(nonLocalizedLabel.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(theme);
        addTaint(packageName.getTaint());
        addTaint(appToken.getTaint());
        if(!SHOW_STARTING_ANIMATIONS)        
        {
View var540C13E9E156B687226421B24F2DF178_1628726220 = null            var540C13E9E156B687226421B24F2DF178_1628726220.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1628726220;
        } //End block
        if(packageName==null)        
        {
View var540C13E9E156B687226421B24F2DF178_1208158125 = null            var540C13E9E156B687226421B24F2DF178_1208158125.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1208158125;
        } //End block
        try 
        {
            Context context = mContext;
            if(theme!=context.getThemeResId()||labelRes!=0)            
            {
                try 
                {
context=context.createPackageContext(packageName, 0)context.setTheme(theme)
                } //End block
                catch (PackageManager.NameNotFoundException e)
                {
                } //End block
            } //End block
            Window win = PolicyManager.makeNewWindow(context);
            if(win.getWindowStyle().getBoolean(com.android.internal.R.styleable.Window_windowDisablePreview, false))            
            {
View var540C13E9E156B687226421B24F2DF178_632780435 = null                var540C13E9E156B687226421B24F2DF178_632780435.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_632780435;
            } //End block
            Resources r = context.getResources();
win.setTitle(r.getText(labelRes, nonLocalizedLabel))win.setType(WindowManager.LayoutParams.TYPE_APPLICATION_STARTING)win.setFlags(windowFlags|WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM, windowFlags|WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE|WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)            if(!compatInfo.supportsScreen())            
            {
win.addFlags(WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW)
            } //End block
win.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)            final WindowManager.LayoutParams params = win.getAttributes();
params.token=appTokenparams.packageName=packageNameparams.windowAnimations=win.getWindowStyle().getResourceId(com.android.internal.R.styleable.Window_windowAnimationStyle, 0)params.privateFlags|=WindowManager.LayoutParams.PRIVATE_FLAG_FAKE_HARDWARE_ACCELERATEDparams.setTitle("Starting "+packageName)            WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
            View view = win.getDecorView();
            if(win.isFloating())            
            {
View var540C13E9E156B687226421B24F2DF178_403529174 = null                var540C13E9E156B687226421B24F2DF178_403529174.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_403529174;
            } //End block
            if(localLOGV){ }wm.addView(view, params)View varA7DA0E9A6107642B5C1E1FF1C5945F2F_2135552746 = view.getParent()!=null?view:view            varA7DA0E9A6107642B5C1E1FF1C5945F2F_2135552746.addTaint(taint);
            return varA7DA0E9A6107642B5C1E1FF1C5945F2F_2135552746;
        } //End block
        catch (WindowManagerImpl.BadTokenException e)
        {
        } //End block
        catch (RuntimeException e)
        {
        } //End block
View var540C13E9E156B687226421B24F2DF178_365927244 = null        var540C13E9E156B687226421B24F2DF178_365927244.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_365927244;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.914 -0400", hash_original_method = "337E143088575DC7DDA826E8CB193312", hash_generated_method = "8637E3B1BF003ABF5013DB8DE09B4DA6")
    public void removeStartingWindow(IBinder appToken, View window) {
        addTaint(window.getTaint());
        addTaint(appToken.getTaint());
        if(localLOGV){ }        if(window!=null)        
        {
            WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
wm.removeView(window)
        } //End block
        // ---------- Original Method ----------
        //if (localLOGV) Log.v(
            //TAG, "Removing starting window for " + appToken + ": " + window);
        //if (window != null) {
            //WindowManager wm = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
            //wm.removeView(window);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.915 -0400", hash_original_method = "412DE2910B205BFA66B17E513C769BCC", hash_generated_method = "E51C013E88719C4A56345505140ED10B")
    public int prepareAddWindowLw(WindowState win, WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        addTaint(win.getTaint());
        switch(attrs.type){
        case TYPE_STATUS_BAR:
mContext.enforceCallingOrSelfPermission(android.Manifest.permission.STATUS_BAR_SERVICE, "PhoneWindowManager")        if(mStatusBar!=null)        
        {
            int varA788DE92769555E65312C7EDD45C8BB5_1832080538 = (WindowManagerImpl.ADD_MULTIPLE_SINGLETON);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738917652 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738917652;
        } //End block
mStatusBar=win        break;
        case TYPE_NAVIGATION_BAR:
mContext.enforceCallingOrSelfPermission(android.Manifest.permission.STATUS_BAR_SERVICE, "PhoneWindowManager")mNavigationBar=win        if(DEBUG_LAYOUT){ }        break;
        case TYPE_STATUS_BAR_PANEL:
mContext.enforceCallingOrSelfPermission(android.Manifest.permission.STATUS_BAR_SERVICE, "PhoneWindowManager")mStatusBarPanels.add(win)        break;
        case TYPE_STATUS_BAR_SUB_PANEL:
mContext.enforceCallingOrSelfPermission(android.Manifest.permission.STATUS_BAR_SERVICE, "PhoneWindowManager")mStatusBarPanels.add(win)        break;
        case TYPE_KEYGUARD:
        if(mKeyguard!=null)        
        {
            int varA788DE92769555E65312C7EDD45C8BB5_1904888690 = (WindowManagerImpl.ADD_MULTIPLE_SINGLETON);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045702883 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045702883;
        } //End block
mKeyguard=win        break;
}        int varBEB882FFF92D04B1F8CFF9C22EF33812_528380552 = (WindowManagerImpl.ADD_OKAY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141580661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2141580661;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.916 -0400", hash_original_method = "639617A7D2E8ED8D902DD73A5F60F044", hash_generated_method = "792B74F7444A3471CC7AA9C821369D29")
    public void removeWindowLw(WindowState win) {
        addTaint(win.getTaint());
        if(mStatusBar==win)        
        {
mStatusBar=null
        } //End block
        else
        if(mKeyguard==win)        
        {
mKeyguard=null
        } //End block
        else
        if(mNavigationBar==win)        
        {
mNavigationBar=null
        } //End block
        else
        {
mStatusBarPanels.remove(win)
        } //End block
        // ---------- Original Method ----------
        //if (mStatusBar == win) {
            //mStatusBar = null;
        //} else if (mKeyguard == win) {
            //mKeyguard = null;
        //} else if (mNavigationBar == win) {
            //mNavigationBar = null;
        //} else {
            //mStatusBarPanels.remove(win);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.917 -0400", hash_original_method = "FDB0B188AD832119FBF8CB7ACF33137E", hash_generated_method = "6D95D4E3842816BA3992E516B838E5D9")
    public int selectAnimationLw(WindowState win, int transit) {
        addTaint(transit);
        addTaint(win.getTaint());
        if(PRINT_ANIM){ }        if(transit==TRANSIT_PREVIEW_DONE)        
        {
            if(win.hasAppShownWindows())            
            {
                if(PRINT_ANIM){ }                int var63FE96E160F6B4692BE86A25DC561FC1_18674036 = (com.android.internal.R.anim.app_starting_exit);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_610311412 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_610311412;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2126007916 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706852631 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706852631;
        // ---------- Original Method ----------
        //if (PRINT_ANIM) Log.i(TAG, "selectAnimation in " + win
              //+ ": transit=" + transit);
        //if (transit == TRANSIT_PREVIEW_DONE) {
            //if (win.hasAppShownWindows()) {
                //if (PRINT_ANIM) Log.i(TAG, "**** STARTING EXIT");
                //return com.android.internal.R.anim.app_starting_exit;
            //}
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.918 -0400", hash_original_method = "849D9631B2C3C6A94CFED15C768BF623", hash_generated_method = "EB16BB200757C2202223DCD9EE66159D")
    public Animation createForceHideEnterAnimation() {
Animation var10A26262ECE131CFB6783FB5485E11D4_1330702487 = AnimationUtils.loadAnimation(mContext, com.android.internal.R.anim.lock_screen_behind_enter)        var10A26262ECE131CFB6783FB5485E11D4_1330702487.addTaint(taint);
        return var10A26262ECE131CFB6783FB5485E11D4_1330702487;
        // ---------- Original Method ----------
        //return AnimationUtils.loadAnimation(mContext,
                //com.android.internal.R.anim.lock_screen_behind_enter);
    }

    
        static ITelephony getTelephonyService() {
        ITelephony telephonyService = ITelephony.Stub.asInterface(
                ServiceManager.checkService(Context.TELEPHONY_SERVICE));
        if (telephonyService == null) {
            Log.w(TAG, "Unable to find ITelephony interface.");
        }
        return telephonyService;
    }

    
        static IAudioService getAudioService() {
        IAudioService audioService = IAudioService.Stub.asInterface(
                ServiceManager.checkService(Context.AUDIO_SERVICE));
        if (audioService == null) {
            Log.w(TAG, "Unable to find IAudioService interface.");
        }
        return audioService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.919 -0400", hash_original_method = "052CBA63602E809490A7335063853BD0", hash_generated_method = "B98F716B62B0E240987E6246E3D6272A")
     boolean keyguardOn() {
        boolean varF26AB41CA3525C5F183AE96E14C76A1E_97041991 = (keyguardIsShowingTq()||inKeyguardRestrictedKeyInputMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311224705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311224705;
        // ---------- Original Method ----------
        //return keyguardIsShowingTq() || inKeyguardRestrictedKeyInputMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.925 -0400", hash_original_method = "5E54EA577CE3D65DB3090D703ED02ABC", hash_generated_method = "DF68822D900BBF43B9E403D6E8202F61")
    @Override
    public long interceptKeyBeforeDispatching(WindowState win, KeyEvent event, int policyFlags) {
        addTaint(policyFlags);
        addTaint(event.getTaint());
        addTaint(win.getTaint());
        final boolean keyguardOn = keyguardOn();
        final int keyCode = event.getKeyCode();
        final int repeatCount = event.getRepeatCount();
        final int metaState = event.getMetaState();
        final int flags = event.getFlags();
        final boolean down = event.getAction() == KeyEvent.ACTION_DOWN;
        final boolean canceled = event.isCanceled();
        if(false)        
        {
Log.d(TAG, "interceptKeyTi keyCode="+keyCode+" down="+down+" repeatCount="+repeatCount+" keyguardOn="+keyguardOn+" mHomePressed="+mHomePressed)
        } //End block
        if((flags&KeyEvent.FLAG_FALLBACK)==0)        
        {
            if(mVolumeDownKeyTriggered&&!mPowerKeyTriggered)            
            {
                final long now = SystemClock.uptimeMillis();
                final long timeoutTime = mVolumeDownKeyTime + SCREENSHOT_CHORD_DEBOUNCE_DELAY_MILLIS;
                if(now<timeoutTime)                
                {
                    long var1965B2863CB6CE23C475B15050AA52AB_1241067740 = (timeoutTime-now);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1692166016 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1692166016;
                } //End block
            } //End block
            if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN&&mVolumeDownKeyConsumedByScreenshotChord)            
            {
                if(!down)                
                {
mVolumeDownKeyConsumedByScreenshotChord=false
                } //End block
                long var6BB61E3B7BCE0931DA574D19D1D82C88_23944338 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_289560958 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_289560958;
            } //End block
        } //End block
        if(keyCode==KeyEvent.KEYCODE_HOME)        
        {
            if(mHomePressed&&!down)            
            {
mHomePressed=false                if(!canceled)                
                {
                    boolean incomingRinging = false;
                    try 
                    {
                        ITelephony telephonyService = getTelephonyService();
                        if(telephonyService!=null)                        
                        {
incomingRinging=telephonyService.isRinging()
                        } //End block
                    } //End block
                    catch (RemoteException ex)
                    {
                    } //End block
                    if(incomingRinging)                    
                    {
                    } //End block
                    else
                    {
launchHomeFromHotKey()
                    } //End block
                } //End block
                else
                {
                } //End block
                long var6BB61E3B7BCE0931DA574D19D1D82C88_740038241 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1776242023 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1776242023;
            } //End block
            WindowManager.LayoutParams attrs = win != null ? win.getAttrs() : null;
            if(attrs!=null)            
            {
                final int type = attrs.type;
                if(type==WindowManager.LayoutParams.TYPE_KEYGUARD||type==WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG)                
                {
                    long varCFCD208495D565EF66E7DFF9F98764DA_1470105023 = (0);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1098607628 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1098607628;
                } //End block
                final int typeCount = WINDOW_TYPES_WHERE_HOME_DOESNT_WORK.length;
for(int i=0;i<typeCount;i)
                {
                    if(type==WINDOW_TYPES_WHERE_HOME_DOESNT_WORK[i])                    
                    {
                        long var6BB61E3B7BCE0931DA574D19D1D82C88_367197397 = (-1);
                                                long var0F5264038205EDFB1AC05FBB0E8C5E94_122969162 = getTaintLong();
                        return var0F5264038205EDFB1AC05FBB0E8C5E94_122969162;
                    } //End block
                } //End block
            } //End block
            if(down)            
            {
                if(repeatCount==0)                
                {
mHomePressed=true
                } //End block
                else
                if((event.getFlags()&KeyEvent.FLAG_LONG_PRESS)!=0)                
                {
                    if(!keyguardOn)                    
                    {
handleLongPressOnHome()
                    } //End block
                } //End block
            } //End block
            long var6BB61E3B7BCE0931DA574D19D1D82C88_618546890 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_530718064 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_530718064;
        } //End block
        else
        if(keyCode==KeyEvent.KEYCODE_MENU)        
        {
            final int chordBug = KeyEvent.META_SHIFT_ON;
            if(down&&repeatCount==0)            
            {
                if(mEnableShiftMenuBugReports&&(metaState&chordBug)==chordBug)                
                {
                    Intent intent = new Intent(Intent.ACTION_BUG_REPORT);
mContext.sendOrderedBroadcast(intent, null)                    long var6BB61E3B7BCE0931DA574D19D1D82C88_2125801165 = (-1);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1806412035 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1806412035;
                } //End block
                else
                if(SHOW_PROCESSES_ON_ALT_MENU&&(metaState&KeyEvent.META_ALT_ON)==KeyEvent.META_ALT_ON)                
                {
                    Intent service = new Intent();
service.setClassName(mContext, "com.android.server.LoadAverageService")                    ContentResolver res = mContext.getContentResolver();
                    boolean shown = Settings.System.getInt(
                            res, Settings.System.SHOW_PROCESSES, 0) != 0;
                    if(!shown)                    
                    {
mContext.startService(service)
                    } //End block
                    else
                    {
mContext.stopService(service)
                    } //End block
Settings.System.putInt(res, Settings.System.SHOW_PROCESSES, shown?0:0)                    long var6BB61E3B7BCE0931DA574D19D1D82C88_805836632 = (-1);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_512112330 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_512112330;
                } //End block
            } //End block
        } //End block
        else
        if(keyCode==KeyEvent.KEYCODE_SEARCH)        
        {
            if(down)            
            {
                if(repeatCount==0)                
                {
mShortcutKeyPressed=keyCodemConsumeShortcutKeyUp=false
                } //End block
            } //End block
            else
            if(keyCode==mShortcutKeyPressed)            
            {
mShortcutKeyPressed=-1                if(mConsumeShortcutKeyUp)                
                {
mConsumeShortcutKeyUp=false                    long var6BB61E3B7BCE0931DA574D19D1D82C88_752745722 = (-1);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_933013876 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_933013876;
                } //End block
            } //End block
            long varCFCD208495D565EF66E7DFF9F98764DA_999248288 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_909807022 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_909807022;
        } //End block
        else
        if(keyCode==KeyEvent.KEYCODE_APP_SWITCH)        
        {
            if(down&&repeatCount==0)            
            {
showOrHideRecentAppsDialog(RECENT_APPS_BEHAVIOR_SHOW_OR_DISMISS)
            } //End block
            long var6BB61E3B7BCE0931DA574D19D1D82C88_1667622646 = (-1);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_934383105 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_934383105;
        } //End block
        if(mShortcutKeyPressed!=-1)        
        {
            final KeyCharacterMap kcm = event.getKeyCharacterMap();
            if(kcm.isPrintingKey(keyCode))            
            {
mConsumeShortcutKeyUp=true                if(down&&repeatCount==0&&!keyguardOn)                
                {
                    Intent shortcutIntent = mShortcutManager.getIntent(kcm, keyCode, metaState);
                    if(shortcutIntent!=null)                    
                    {
shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)                        try 
                        {
mContext.startActivity(shortcutIntent)
                        } //End block
                        catch (ActivityNotFoundException ex)
                        {
                        } //End block
                    } //End block
                    else
                    {
                    } //End block
                } //End block
                long var6BB61E3B7BCE0931DA574D19D1D82C88_392633862 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1001293041 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1001293041;
            } //End block
        } //End block
        if(down&&repeatCount==0&&(metaState&KeyEvent.META_META_ON)!=0)        
        {
            final KeyCharacterMap kcm = event.getKeyCharacterMap();
            Intent shortcutIntent = mShortcutManager.getIntent(kcm, keyCode,
                    metaState & ~(KeyEvent.META_META_ON
                            | KeyEvent.META_META_LEFT_ON | KeyEvent.META_META_RIGHT_ON));
            if(shortcutIntent!=null)            
            {
shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)                try 
                {
mContext.startActivity(shortcutIntent)
                } //End block
                catch (ActivityNotFoundException ex)
                {
                } //End block
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1396319495 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1899899332 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1899899332;
            } //End block
        } //End block
        if(down&&repeatCount==0)        
        {
            String category = sApplicationLaunchKeyCategories.get(keyCode);
            if(category!=null)            
            {
                Intent intent = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, category);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)                try 
                {
mContext.startActivity(intent)
                } //End block
                catch (ActivityNotFoundException ex)
                {
                } //End block
                long var6BB61E3B7BCE0931DA574D19D1D82C88_1752689856 = (-1);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_259026921 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_259026921;
            } //End block
        } //End block
        if(down&&repeatCount==0&&keyCode==KeyEvent.KEYCODE_TAB)        
        {
            if(mRecentAppsDialogHeldModifiers==0)            
            {
                final int shiftlessModifiers = event.getModifiers() & ~KeyEvent.META_SHIFT_MASK;
                if(KeyEvent.metaStateHasModifiers(shiftlessModifiers, KeyEvent.META_ALT_ON)||KeyEvent.metaStateHasModifiers(shiftlessModifiers, KeyEvent.META_META_ON))                
                {
mRecentAppsDialogHeldModifiers=shiftlessModifiersshowOrHideRecentAppsDialog(RECENT_APPS_BEHAVIOR_EXIT_TOUCH_MODE_AND_SHOW)                    long var6BB61E3B7BCE0931DA574D19D1D82C88_739247135 = (-1);
                                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1963958043 = getTaintLong();
                    return var0F5264038205EDFB1AC05FBB0E8C5E94_1963958043;
                } //End block
            } //End block
        } //End block
        else
        if(!down&&mRecentAppsDialogHeldModifiers!=0&&(metaState&mRecentAppsDialogHeldModifiers)==0)        
        {
mRecentAppsDialogHeldModifiers=0showOrHideRecentAppsDialog(RECENT_APPS_BEHAVIOR_DISMISS_AND_SWITCH)
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_1834082360 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_127491275 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_127491275;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.929 -0400", hash_original_method = "8BECFB5BDA2868CAFEC924462B003C0B", hash_generated_method = "0014A5A71A1084419F3328E443950D12")
    @Override
    public KeyEvent dispatchUnhandledKey(WindowState win, KeyEvent event, int policyFlags) {
        addTaint(policyFlags);
        addTaint(event.getTaint());
        addTaint(win.getTaint());
        if(DEBUG_FALLBACK)        
        {
Slog.d(TAG, "Unhandled key: win="+win+", action="+event.getAction()+", flags="+event.getFlags()+", keyCode="+event.getKeyCode()+", scanCode="+event.getScanCode()+", metaState="+event.getMetaState()+", repeatCount="+event.getRepeatCount()+", policyFlags="+policyFlags)
        } //End block
        if((event.getFlags()&KeyEvent.FLAG_FALLBACK)==0)        
        {
            final KeyCharacterMap kcm = event.getKeyCharacterMap();
            final int keyCode = event.getKeyCode();
            final int metaState = event.getMetaState();
            if(getFallbackAction(kcm, keyCode, metaState, mFallbackAction))            
            {
                if(DEBUG_FALLBACK)                
                {
Slog.d(TAG, "Fallback: keyCode="+mFallbackAction.keyCode+" metaState="+Integer.toHexString(mFallbackAction.metaState))
                } //End block
                int flags = event.getFlags() | KeyEvent.FLAG_FALLBACK;
                KeyEvent fallbackEvent = KeyEvent.obtain(
                        event.getDownTime(), event.getEventTime(),
                        event.getAction(), mFallbackAction.keyCode,
                        event.getRepeatCount(), mFallbackAction.metaState,
                        event.getDeviceId(), event.getScanCode(),
                        flags, event.getSource(), null);
                int actions = interceptKeyBeforeQueueing(fallbackEvent, policyFlags, true);
                if((actions&ACTION_PASS_TO_USER)!=0)                
                {
                    long delayMillis = interceptKeyBeforeDispatching(
                            win, fallbackEvent, policyFlags);
                    if(delayMillis==0)                    
                    {
                        if(DEBUG_FALLBACK)                        
                        {
Slog.d(TAG, "Performing fallback.")
                        } //End block
KeyEvent var611E599F7AC59A497C2215EC4B33F898_1162562066 = fallbackEvent                        var611E599F7AC59A497C2215EC4B33F898_1162562066.addTaint(taint);
                        return var611E599F7AC59A497C2215EC4B33F898_1162562066;
                    } //End block
                } //End block
fallbackEvent.recycle()
            } //End block
        } //End block
        if(DEBUG_FALLBACK)        
        {
Slog.d(TAG, "No fallback.")
        } //End block
KeyEvent var540C13E9E156B687226421B24F2DF178_13522709 = null        var540C13E9E156B687226421B24F2DF178_13522709.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_13522709;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.931 -0400", hash_original_method = "B2CC9AFE555481948382E029136D67A4", hash_generated_method = "43267B5578C223C755D6311F7933BF7F")
    private boolean getFallbackAction(KeyCharacterMap kcm, int keyCode, int metaState,
            FallbackAction outFallbackAction) {
        addTaint(outFallbackAction.getTaint());
        addTaint(metaState);
        addTaint(keyCode);
        addTaint(kcm.getTaint());
        boolean var828C81208846690A33C6FDC6D827B824_1047663223 = (kcm.getFallbackAction(keyCode, metaState, outFallbackAction));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481815043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481815043;
        // ---------- Original Method ----------
        //return kcm.getFallbackAction(keyCode, metaState, outFallbackAction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.935 -0400", hash_original_method = "66455D67D8FD19982FD4FC5C7D34B66C", hash_generated_method = "AAA524B690B04786BB5EB9F7E64F48F5")
     void launchHomeFromHotKey() {
        if(mKeyguardMediator.isShowingAndNotHidden())        
        {
        } //End block
        else
        if(!mHideLockScreen&&mKeyguardMediator.isInputRestricted())        
        {
mKeyguardMediator.verifyUnlock(new OnKeyguardExitResult()            {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.934 -0400", hash_original_method = "19E43D4F486A96A11232470FD6BCD260", hash_generated_method = "EF0EE5FDB0AD34DAE8FC6BA95D1FE93A")
        public void onKeyguardExitResult(boolean success) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(success);
            if(success)            
            {
                try 
                {
ActivityManagerNative.getDefault().stopAppSwitches()
                } //End block
                catch (RemoteException e)
                {
                } //End block
sendCloseSystemWindows(SYSTEM_DIALOG_REASON_HOME_KEY)startDockOrHome()
            } //End block
            // ---------- Original Method ----------
            //if (success) {
                        //try {
                            //ActivityManagerNative.getDefault().stopAppSwitches();
                        //} catch (RemoteException e) {
                        //}
                        //sendCloseSystemWindows(SYSTEM_DIALOG_REASON_HOME_KEY);
                        //startDockOrHome();
                    //}
        }
            }
)
        } //End block
        else
        {
            try 
            {
ActivityManagerNative.getDefault().stopAppSwitches()
            } //End block
            catch (RemoteException e)
            {
            } //End block
sendCloseSystemWindows(SYSTEM_DIALOG_REASON_HOME_KEY)startDockOrHome()
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.936 -0400", hash_original_method = "F59CD0E95C400B0A230E5BFC67F0438C", hash_generated_method = "7618E4F36AA27FCB410AC04FEC24FB5A")
    @Override
    public int adjustSystemUiVisibilityLw(int visibility) {
        addTaint(visibility);
mResettingSystemUiFlags&=visibility        int varC6EE2C9EA00563214C9DA975D5AACE4D_1988510438 = (visibility&~mResettingSystemUiFlags&~mForceClearedSystemUiFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175293775 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175293775;
        // ---------- Original Method ----------
        //mResettingSystemUiFlags &= visibility;
        //return visibility & ~mResettingSystemUiFlags
                //& ~mForceClearedSystemUiFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.937 -0400", hash_original_method = "821F928B793F45BEEDC271F83A0B46E6", hash_generated_method = "316EB950F87E9D2219DF1DEC96F548BA")
    public void getContentInsetHintLw(WindowManager.LayoutParams attrs, Rect contentInset) {
        addTaint(contentInset.getTaint());
        addTaint(attrs.getTaint());
        final int fl = attrs.flags;
        if((fl&(FLAG_LAYOUT_IN_SCREEN|FLAG_FULLSCREEN|FLAG_LAYOUT_INSET_DECOR))==(FLAG_LAYOUT_IN_SCREEN|FLAG_LAYOUT_INSET_DECOR))        
        {
contentInset.set(mCurLeft, mCurTop, (mRestrictedScreenLeft+mRestrictedScreenWidth)-mCurRight, (mRestrictedScreenTop+mRestrictedScreenHeight)-mCurBottom)
        } //End block
        else
        {
contentInset.setEmpty()
        } //End block
        // ---------- Original Method ----------
        //final int fl = attrs.flags;
        //if ((fl & (FLAG_LAYOUT_IN_SCREEN | FLAG_FULLSCREEN | FLAG_LAYOUT_INSET_DECOR))
                //== (FLAG_LAYOUT_IN_SCREEN | FLAG_LAYOUT_INSET_DECOR)) {
            //contentInset.set(mCurLeft, mCurTop,
                    //(mRestrictedScreenLeft+mRestrictedScreenWidth) - mCurRight,
                    //(mRestrictedScreenTop+mRestrictedScreenHeight) - mCurBottom);
        //} else {
            //contentInset.setEmpty();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.939 -0400", hash_original_method = "63112888C868A2D247E426E1E538F2AE", hash_generated_method = "0A69CB4D1E3684F1C7A7F5B9309A87D6")
    public void beginLayoutLw(int displayWidth, int displayHeight, int displayRotation) {
        addTaint(displayRotation);
        addTaint(displayHeight);
        addTaint(displayWidth);
mUnrestrictedScreenLeft=mUnrestrictedScreenTop=0mUnrestrictedScreenWidth=displayWidthmUnrestrictedScreenHeight=displayHeightmRestrictedScreenLeft=mRestrictedScreenTop=0mRestrictedScreenWidth=displayWidthmRestrictedScreenHeight=displayHeightmDockLeft=mContentLeft=mCurLeft=0mDockTop=mContentTop=mCurTop=0mDockRight=mContentRight=mCurRight=displayWidthmDockBottom=mContentBottom=mCurBottom=displayHeightmDockLayer=0x10000000        final Rect pf = mTmpParentFrame;
        final Rect df = mTmpDisplayFrame;
        final Rect vf = mTmpVisibleFrame;
pf.left=df.left=vf.left=mDockLeftpf.top=df.top=vf.top=mDockToppf.right=df.right=vf.right=mDockRightpf.bottom=df.bottom=vf.bottom=mDockBottom        final boolean navVisible = (mNavigationBar == null || mNavigationBar.isVisibleLw()) &&
                (mLastSystemUiFlags&View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0;
        if(navVisible)        
        {
            if(mHideNavFakeWindow!=null)            
            {
mHideNavFakeWindow.dismiss()mHideNavFakeWindow=null
            } //End block
        } //End block
        else
        if(mHideNavFakeWindow==null)        
        {
mHideNavFakeWindow=mWindowManagerFuncs.addFakeWindow(mHandler.getLooper(), mHideNavInputHandler, "hidden nav", WindowManager.LayoutParams.TYPE_HIDDEN_NAV_CONSUMER, 0, false, false, true)
        } //End block
        if(mStatusBar!=null)        
        {
            if(mNavigationBar!=null)            
            {
                if(displayWidth<displayHeight)                
                {
mTmpNavigationFrame.set(0, displayHeight-mNavigationBarHeight, displayWidth, displayHeight)                    if(navVisible)                    
                    {
mDockBottom=mTmpNavigationFrame.topmRestrictedScreenHeight=mDockBottom-mDockTop
                    } //End block
                    else
                    {
mTmpNavigationFrame.offset(0, mNavigationBarHeight)
                    } //End block
                } //End block
                else
                {
mTmpNavigationFrame.set(displayWidth-mNavigationBarWidth, 0, displayWidth, displayHeight)                    if(navVisible)                    
                    {
mDockRight=mTmpNavigationFrame.leftmRestrictedScreenWidth=mDockRight-mDockLeft
                    } //End block
                    else
                    {
mTmpNavigationFrame.offset(mNavigationBarWidth, 0)
                    } //End block
                } //End block
mContentTop=mCurTop=mDockTopmContentBottom=mCurBottom=mDockBottommContentLeft=mCurLeft=mDockLeftmContentRight=mCurRight=mDockRightmNavigationBar.computeFrameLw(mTmpNavigationFrame, mTmpNavigationFrame, mTmpNavigationFrame, mTmpNavigationFrame)                if(DEBUG_LAYOUT){ }
            } //End block
            if(DEBUG_LAYOUT){ }pf.left=df.left=vf.left=mDockLeftpf.top=df.top=vf.top=mDockToppf.right=df.right=vf.right=mDockRightpf.bottom=df.bottom=vf.bottom=mDockBottommStatusBar.computeFrameLw(pf, df, vf, vf)            if(mStatusBar.isVisibleLw())            
            {
                final Rect r = mStatusBar.getFrameLw();
                if(mStatusBarCanHide)                
                {
                    if(mDockTop==r.top)                    
mDockTop=r.bottom
                    else
                    if(mDockBottom==r.bottom)                    
mDockBottom=r.top
mContentTop=mCurTop=mDockTopmContentBottom=mCurBottom=mDockBottommContentLeft=mCurLeft=mDockLeftmContentRight=mCurRight=mDockRight                    if(DEBUG_LAYOUT){ }
                } //End block
                else
                {
                    if(mRestrictedScreenTop==r.top)                    
                    {
mRestrictedScreenTop=r.bottommRestrictedScreenHeight-=(r.bottom-r.top)
                    } //End block
                    else
                    if((mRestrictedScreenHeight-mRestrictedScreenTop)==r.bottom)                    
                    {
mRestrictedScreenHeight-=(r.bottom-r.top)
                    } //End block
mContentTop=mCurTop=mDockTop=mRestrictedScreenTopmContentBottom=mCurBottom=mDockBottom=mRestrictedScreenTop+mRestrictedScreenHeight                    if(DEBUG_LAYOUT){ }
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.941 -0400", hash_original_method = "A95F24F7825E7A915E2E3BA5B6C6082B", hash_generated_method = "6DCD4B7148DB1A9CFDCF49962AFAE474")
     void setAttachedWindowFrames(WindowState win, int fl, int adjust,
            WindowState attached, boolean insetDecors, Rect pf, Rect df, Rect cf, Rect vf) {
        addTaint(vf.getTaint());
        addTaint(cf.getTaint());
        addTaint(df.getTaint());
        addTaint(pf.getTaint());
        addTaint(insetDecors);
        addTaint(attached.getTaint());
        addTaint(adjust);
        addTaint(fl);
        addTaint(win.getTaint());
        if(win.getSurfaceLayer()>mDockLayer&&attached.getSurfaceLayer()<mDockLayer)        
        {
df.left=cf.left=vf.left=mDockLeftdf.top=cf.top=vf.top=mDockTopdf.right=cf.right=vf.right=mDockRightdf.bottom=cf.bottom=vf.bottom=mDockBottom
        } //End block
        else
        {
            if(adjust!=SOFT_INPUT_ADJUST_RESIZE)            
            {
cf.set(attached.getDisplayFrameLw())
            } //End block
            else
            {
cf.set(attached.getContentFrameLw())                if(attached.getSurfaceLayer()<mDockLayer)                
                {
                    if(cf.left<mContentLeft)                    
cf.left=mContentLeft
                    if(cf.top<mContentTop)                    
cf.top=mContentTop
                    if(cf.right>mContentRight)                    
cf.right=mContentRight
                    if(cf.bottom>mContentBottom)                    
cf.bottom=mContentBottom
                } //End block
            } //End block
df.set(insetDecors?attached.getDisplayFrameLw():attached.getDisplayFrameLw())vf.set(attached.getVisibleFrameLw())
        } //End block
pf.set((fl&FLAG_LAYOUT_IN_SCREEN)==0?attached.getFrameLw():attached.getFrameLw())
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.947 -0400", hash_original_method = "3CE883DFCA1A0A2AA2BD0BDA3C681C17", hash_generated_method = "95C0DCD76352184A2B3FC821E963C128")
    public void layoutWindowLw(WindowState win, WindowManager.LayoutParams attrs,
            WindowState attached) {
        addTaint(attached.getTaint());
        addTaint(attrs.getTaint());
        addTaint(win.getTaint());
        if(win==mStatusBar||win==mNavigationBar)        
        {
            return;
        } //End block
        final int fl = attrs.flags;
        final int sim = attrs.softInputMode;
        final Rect pf = mTmpParentFrame;
        final Rect df = mTmpDisplayFrame;
        final Rect cf = mTmpContentFrame;
        final Rect vf = mTmpVisibleFrame;
        final boolean hasNavBar = (mHasNavigationBar 
                && mNavigationBar != null && mNavigationBar.isVisibleLw());
        if(attrs.type==TYPE_INPUT_METHOD)        
        {
pf.left=df.left=cf.left=vf.left=mDockLeftpf.top=df.top=cf.top=vf.top=mDockToppf.right=df.right=cf.right=vf.right=mDockRightpf.bottom=df.bottom=cf.bottom=vf.bottom=mDockBottomattrs.gravity=Gravity.BOTTOMmDockLayer=win.getSurfaceLayer()
        } //End block
        else
        {
            final int adjust = sim & SOFT_INPUT_MASK_ADJUST;
            if((fl&(FLAG_LAYOUT_IN_SCREEN|FLAG_FULLSCREEN|FLAG_LAYOUT_INSET_DECOR))==(FLAG_LAYOUT_IN_SCREEN|FLAG_LAYOUT_INSET_DECOR))            
            {
                if(DEBUG_LAYOUT){ }                if(attached!=null)                
                {
setAttachedWindowFrames(win, fl, sim, attached, true, pf, df, cf, vf)
                } //End block
                else
                {
                    if(attrs.type==TYPE_STATUS_BAR_PANEL||attrs.type==TYPE_STATUS_BAR_SUB_PANEL)                    
                    {
pf.left=df.left=hasNavBar?mDockLeft:mDockLeftpf.top=df.top=mUnrestrictedScreenToppf.right=df.right=hasNavBar?mRestrictedScreenLeft+mRestrictedScreenWidth:mRestrictedScreenLeft+mRestrictedScreenWidthpf.bottom=df.bottom=hasNavBar?mRestrictedScreenTop+mRestrictedScreenHeight:mRestrictedScreenTop+mRestrictedScreenHeight                        if(DEBUG_LAYOUT)                        
                        {
                        } //End block
                    } //End block
                    else
                    {
pf.left=df.left=mRestrictedScreenLeftpf.top=df.top=mRestrictedScreenToppf.right=df.right=mRestrictedScreenLeft+mRestrictedScreenWidthpf.bottom=df.bottom=mRestrictedScreenTop+mRestrictedScreenHeight
                    } //End block
                    if(adjust!=SOFT_INPUT_ADJUST_RESIZE)                    
                    {
cf.left=mDockLeftcf.top=mDockTopcf.right=mDockRightcf.bottom=mDockBottom
                    } //End block
                    else
                    {
cf.left=mContentLeftcf.top=mContentTopcf.right=mContentRightcf.bottom=mContentBottom
                    } //End block
                    if(adjust!=SOFT_INPUT_ADJUST_NOTHING)                    
                    {
vf.left=mCurLeftvf.top=mCurTopvf.right=mCurRightvf.bottom=mCurBottom
                    } //End block
                    else
                    {
vf.set(cf)
                    } //End block
                } //End block
            } //End block
            else
            if((fl&FLAG_LAYOUT_IN_SCREEN)!=0)            
            {
                if(DEBUG_LAYOUT){ }                if(attrs.type==TYPE_STATUS_BAR_PANEL||attrs.type==TYPE_STATUS_BAR_SUB_PANEL)                
                {
pf.left=df.left=cf.left=hasNavBar?mDockLeft:mDockLeftpf.top=df.top=cf.top=mUnrestrictedScreenToppf.right=df.right=cf.right=hasNavBar?mRestrictedScreenLeft+mRestrictedScreenWidth:mRestrictedScreenLeft+mRestrictedScreenWidthpf.bottom=df.bottom=cf.bottom=hasNavBar?mRestrictedScreenTop+mRestrictedScreenHeight:mRestrictedScreenTop+mRestrictedScreenHeight                    if(DEBUG_LAYOUT)                    
                    {
                    } //End block
                } //End block
                else
                if(attrs.type==TYPE_NAVIGATION_BAR)                
                {
pf.left=df.left=mUnrestrictedScreenLeftpf.top=df.top=mUnrestrictedScreenToppf.right=df.right=mUnrestrictedScreenLeft+mUnrestrictedScreenWidthpf.bottom=df.bottom=mUnrestrictedScreenTop+mUnrestrictedScreenHeight                    if(DEBUG_LAYOUT)                    
                    {
                    } //End block
                } //End block
                else
                if((attrs.type==TYPE_SECURE_SYSTEM_OVERLAY||attrs.type==TYPE_BOOT_PROGRESS)&&((fl&FLAG_FULLSCREEN)!=0))                
                {
pf.left=df.left=mUnrestrictedScreenLeftpf.top=df.top=mUnrestrictedScreenToppf.right=df.right=mUnrestrictedScreenLeft+mUnrestrictedScreenWidthpf.bottom=df.bottom=mUnrestrictedScreenTop+mUnrestrictedScreenHeight
                } //End block
                else
                if(attrs.type==TYPE_BOOT_PROGRESS)                
                {
pf.left=df.left=cf.left=mUnrestrictedScreenLeftpf.top=df.top=cf.top=mUnrestrictedScreenToppf.right=df.right=cf.right=mUnrestrictedScreenLeft+mUnrestrictedScreenWidthpf.bottom=df.bottom=cf.bottom=mUnrestrictedScreenTop+mUnrestrictedScreenHeight
                } //End block
                else
                {
pf.left=df.left=cf.left=mRestrictedScreenLeftpf.top=df.top=cf.top=mRestrictedScreenToppf.right=df.right=cf.right=mRestrictedScreenLeft+mRestrictedScreenWidthpf.bottom=df.bottom=cf.bottom=mRestrictedScreenTop+mRestrictedScreenHeight
                } //End block
                if(adjust!=SOFT_INPUT_ADJUST_NOTHING)                
                {
vf.left=mCurLeftvf.top=mCurTopvf.right=mCurRightvf.bottom=mCurBottom
                } //End block
                else
                {
vf.set(cf)
                } //End block
            } //End block
            else
            if(attached!=null)            
            {
                if(DEBUG_LAYOUT){ }setAttachedWindowFrames(win, fl, adjust, attached, false, pf, df, cf, vf)
            } //End block
            else
            {
                if(DEBUG_LAYOUT){ }                if(attrs.type==TYPE_STATUS_BAR_PANEL)                
                {
pf.left=df.left=cf.left=mRestrictedScreenLeftpf.top=df.top=cf.top=mRestrictedScreenToppf.right=df.right=cf.right=mRestrictedScreenLeft+mRestrictedScreenWidthpf.bottom=df.bottom=cf.bottom=mRestrictedScreenTop+mRestrictedScreenHeight
                } //End block
                else
                {
pf.left=mContentLeftpf.top=mContentToppf.right=mContentRightpf.bottom=mContentBottom                    if(adjust!=SOFT_INPUT_ADJUST_RESIZE)                    
                    {
df.left=cf.left=mDockLeftdf.top=cf.top=mDockTopdf.right=cf.right=mDockRightdf.bottom=cf.bottom=mDockBottom
                    } //End block
                    else
                    {
df.left=cf.left=mContentLeftdf.top=cf.top=mContentTopdf.right=cf.right=mContentRightdf.bottom=cf.bottom=mContentBottom
                    } //End block
                    if(adjust!=SOFT_INPUT_ADJUST_NOTHING)                    
                    {
vf.left=mCurLeftvf.top=mCurTopvf.right=mCurRightvf.bottom=mCurBottom
                    } //End block
                    else
                    {
vf.set(cf)
                    } //End block
                } //End block
            } //End block
        } //End block
        if((fl&FLAG_LAYOUT_NO_LIMITS)!=0)        
        {
df.left=df.top=cf.left=cf.top=vf.left=vf.top=-10000df.right=df.bottom=cf.right=cf.bottom=vf.right=vf.bottom=10000
        } //End block
        if(DEBUG_LAYOUT){ }win.computeFrameLw(pf, df, cf, vf)        if(attrs.type==TYPE_INPUT_METHOD&&!win.getGivenInsetsPendingLw())        
        {
            int top = win.getContentFrameLw().top;
top+=win.getGivenContentInsetsLw().top            if(mContentBottom>top)            
            {
mContentBottom=top
            } //End block
top=win.getVisibleFrameLw().toptop+=win.getGivenVisibleInsetsLw().top            if(mCurBottom>top)            
            {
mCurBottom=top
            } //End block
            if(DEBUG_LAYOUT){ }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.950 -0400", hash_original_method = "5E2DDCDDCF7A40AAD40B37A38670B78F", hash_generated_method = "7A563A52782A1E1EE0F6E45F50CCC76A")
    public int finishLayoutLw() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1218032959 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411539403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_411539403;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.950 -0400", hash_original_method = "9CABDC016032189321248A498C11BB55", hash_generated_method = "5A0C8BC65CE87DA1E85CAED6DA6B8F48")
    public void beginAnimationLw(int displayWidth, int displayHeight) {
        addTaint(displayHeight);
        addTaint(displayWidth);
mTopFullscreenOpaqueWindowState=nullmForceStatusBar=falsemHideLockScreen=falsemAllowLockscreenWhenOn=falsemDismissKeyguard=false
        // ---------- Original Method ----------
        //mTopFullscreenOpaqueWindowState = null;
        //mForceStatusBar = false;
        //mHideLockScreen = false;
        //mAllowLockscreenWhenOn = false;
        //mDismissKeyguard = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.951 -0400", hash_original_method = "DAA55AAEA4D3BA738AEB85B8088453A5", hash_generated_method = "6ED08E2DDA6FB120E025054E65D5D3CE")
    public void animatingWindowLw(WindowState win,
                                WindowManager.LayoutParams attrs) {
        addTaint(attrs.getTaint());
        addTaint(win.getTaint());
        if(DEBUG_LAYOUT){ }        if(mTopFullscreenOpaqueWindowState==null&&win.isVisibleOrBehindKeyguardLw()&&!win.isGoneForLayoutLw())        
        {
            if((attrs.flags&FLAG_FORCE_NOT_FULLSCREEN)!=0)            
            {
mForceStatusBar=true
            } //End block
            if(attrs.type>=FIRST_APPLICATION_WINDOW&&attrs.type<=LAST_APPLICATION_WINDOW&&attrs.x==0&&attrs.y==0&&attrs.width==WindowManager.LayoutParams.MATCH_PARENT&&attrs.height==WindowManager.LayoutParams.MATCH_PARENT)            
            {
                if(DEBUG_LAYOUT){ }mTopFullscreenOpaqueWindowState=win                if((attrs.flags&FLAG_SHOW_WHEN_LOCKED)!=0)                
                {
                    if(localLOGV){ }mHideLockScreen=true
                } //End block
                if((attrs.flags&FLAG_DISMISS_KEYGUARD)!=0)                
                {
                    if(localLOGV){ }mDismissKeyguard=true
                } //End block
                if((attrs.flags&FLAG_ALLOW_LOCK_WHILE_SCREEN_ON)!=0)                
                {
mAllowLockscreenWhenOn=true
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.954 -0400", hash_original_method = "3ED30B142CDA3D72F722E75C9CD061AE", hash_generated_method = "2ACC1891511CAC4462175CBA2C921D98")
    public int finishAnimationLw() {
        int changes = 0;
        boolean topIsFullscreen = false;
        final WindowManager.LayoutParams lp = (mTopFullscreenOpaqueWindowState != null)
                ? mTopFullscreenOpaqueWindowState.getAttrs()
                : null;
        if(mStatusBar!=null)        
        {
            if(DEBUG_LAYOUT){ }            if(mForceStatusBar)            
            {
                if(DEBUG_LAYOUT){ }                if(mStatusBar.showLw(true))                
changes|=FINISH_LAYOUT_REDO_LAYOUT
            } //End block
            else
            if(mTopFullscreenOpaqueWindowState!=null)            
            {
                if(localLOGV)                
                {
Log.d(TAG, "frame: "+mTopFullscreenOpaqueWindowState.getFrameLw()+" shown frame: "+mTopFullscreenOpaqueWindowState.getShownFrameLw())Log.d(TAG, "attr: "+mTopFullscreenOpaqueWindowState.getAttrs()+" lp.flags=0x"+Integer.toHexString(lp.flags))
                } //End block
topIsFullscreen=(lp.flags&WindowManager.LayoutParams.FLAG_FULLSCREEN)!=0                if(topIsFullscreen)                
                {
                    if(mStatusBarCanHide)                    
                    {
                        if(DEBUG_LAYOUT){ }                        if(mStatusBar.hideLw(true))                        
                        {
changes|=FINISH_LAYOUT_REDO_LAYOUTmHandler.post(new Runnable()                            {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.953 -0400", hash_original_method = "4855B29998613A42E622F74813FCF517", hash_generated_method = "B31065D4EC14CDC930EB43767674B94D")
        public void run() {
            if(mStatusBarService!=null)            
            {
                try 
                {
mStatusBarService.collapse()
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (mStatusBarService != null) {
                                    //try {
                                        //mStatusBarService.collapse();
                                    //} catch (RemoteException ex) {}
                                //}
        }
                            }
)
                        } //End block
                    } //End block
                    else
                    if(DEBUG_LAYOUT)                    
                    {
                    } //End block
                } //End block
                else
                {
                    if(DEBUG_LAYOUT){ }                    if(mStatusBar.showLw(true))                    
changes|=FINISH_LAYOUT_REDO_LAYOUT
                } //End block
            } //End block
        } //End block
mTopIsFullscreen=topIsFullscreen        if(mKeyguard!=null)        
        {
            if(localLOGV){ }            if(mDismissKeyguard&&!mKeyguardMediator.isSecure())            
            {
                if(mKeyguard.hideLw(true))                
                {
changes|=FINISH_LAYOUT_REDO_LAYOUT|FINISH_LAYOUT_REDO_CONFIG|FINISH_LAYOUT_REDO_WALLPAPER
                } //End block
                if(mKeyguardMediator.isShowing())                
                {
mHandler.post(new Runnable()                    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.953 -0400", hash_original_method = "6221773156D37105E36DFC92191FFF68", hash_generated_method = "A54831DF5E8A4EC6B5FF12E0C3F5F9AC")
        public void run() {
mKeyguardMediator.keyguardDone(false, false)
            // ---------- Original Method ----------
            //mKeyguardMediator.keyguardDone(false, false);
        }
                    }
)
                } //End block
            } //End block
            else
            if(mHideLockScreen)            
            {
                if(mKeyguard.hideLw(true))                
                {
changes|=FINISH_LAYOUT_REDO_LAYOUT|FINISH_LAYOUT_REDO_CONFIG|FINISH_LAYOUT_REDO_WALLPAPER
                } //End block
mKeyguardMediator.setHidden(true)
            } //End block
            else
            {
                if(mKeyguard.showLw(true))                
                {
changes|=FINISH_LAYOUT_REDO_LAYOUT|FINISH_LAYOUT_REDO_CONFIG|FINISH_LAYOUT_REDO_WALLPAPER
                } //End block
mKeyguardMediator.setHidden(false)
            } //End block
        } //End block
        if((updateSystemUiVisibilityLw()&View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)!=0)        
        {
changes|=FINISH_LAYOUT_REDO_LAYOUT
        } //End block
updateLockScreenTimeout()        int var5A9D18BB87FF12835DC844883C5C3EBE_1486641446 = (changes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023784410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2023784410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.957 -0400", hash_original_method = "F4B5BEA1E1E6EBBB970BD3DF87C4413C", hash_generated_method = "67D7A66DFCADFB6BC5D66E683D025D40")
    public boolean allowAppAnimationsLw() {
        if(mKeyguard!=null&&mKeyguard.isVisibleLw())        
        {
            boolean var68934A3E9455FA72420237EB05902327_441591735 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054598189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054598189;
        } //End block
        if(false)        
        {
            if(mStatusBar!=null&&mStatusBar.isVisibleLw())            
            {
                RectF rect = new RectF(mStatusBar.getShownFrameLw());
for(int i=mStatusBarPanels.size()-1;i>=0;i)
                {
                    WindowState w = mStatusBarPanels.get(i);
                    if(w.isVisibleLw())                    
                    {
rect.union(w.getShownFrameLw())
                    } //End block
                } //End block
                final int insetw = mRestrictedScreenWidth/10;
                final int inseth = mRestrictedScreenHeight/10;
                if(rect.contains(insetw, inseth, mRestrictedScreenWidth-insetw, mRestrictedScreenHeight-inseth))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1112505456 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1221946196 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1221946196;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_32129613 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224701663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224701663;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.958 -0400", hash_original_method = "31357C9F4F4C948A89FF09590873E8F9", hash_generated_method = "15418CC46431AE9EB2E16F3F29D5CBED")
    public int focusChangedLw(WindowState lastFocus, WindowState newFocus) {
        addTaint(newFocus.getTaint());
        addTaint(lastFocus.getTaint());
mFocusedWindow=newFocus        if((updateSystemUiVisibilityLw()&View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)!=0)        
        {
            int var83F529AD799843982D0761DD3B47ACFD_970079380 = (FINISH_LAYOUT_REDO_LAYOUT);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771114953 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771114953;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_1851654953 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144619006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2144619006;
        // ---------- Original Method ----------
        //mFocusedWindow = newFocus;
        //if ((updateSystemUiVisibilityLw()&View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) != 0) {
            //return FINISH_LAYOUT_REDO_LAYOUT;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.959 -0400", hash_original_method = "3662AAD48455EDD6B5A9299A02B4CD1C", hash_generated_method = "AEC131EBD45C0421A3A67F41CBCBEABA")
    public void notifyLidSwitchChanged(long whenNanos, boolean lidOpen) {
        addTaint(lidOpen);
        addTaint(whenNanos);
mLidOpen=lidOpen?LID_OPEN:LID_OPENupdateKeyboardVisibility()        boolean awakeNow = mKeyguardMediator.doLidChangeTq(lidOpen);
updateRotation(true)        if(awakeNow)        
        {
mKeyguardMediator.pokeWakelock()
        } //End block
        else
        if(keyguardIsShowingTq())        
        {
            if(lidOpen)            
            {
mKeyguardMediator.onWakeKeyWhenKeyguardShowingTq(KeyEvent.KEYCODE_POWER, mDockMode!=Intent.EXTRA_DOCK_STATE_UNDOCKED)
            } //End block
        } //End block
        else
        {
            if(lidOpen)            
            {
mPowerManager.userActivity(SystemClock.uptimeMillis(), false, LocalPowerManager.BUTTON_EVENT)
            } //End block
            else
            {
mPowerManager.userActivity(SystemClock.uptimeMillis(), false, LocalPowerManager.OTHER_EVENT)
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.960 -0400", hash_original_method = "BF9E985574D04FE58D64018391E5DFAC", hash_generated_method = "E1B16A2061D622E26786F5849FF6DDA3")
     void setHdmiPlugged(boolean plugged) {
        addTaint(plugged);
        if(mHdmiPlugged!=plugged)        
        {
mHdmiPlugged=pluggedupdateRotation(true)            Intent intent = new Intent(ACTION_HDMI_PLUGGED);
intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT)intent.putExtra(EXTRA_HDMI_PLUGGED_STATE, plugged)mContext.sendStickyBroadcast(intent)
        } //End block
        // ---------- Original Method ----------
        //if (mHdmiPlugged != plugged) {
            //mHdmiPlugged = plugged;
            //updateRotation(true);
            //Intent intent = new Intent(ACTION_HDMI_PLUGGED);
            //intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY_BEFORE_BOOT);
            //intent.putExtra(EXTRA_HDMI_PLUGGED_STATE, plugged);
            //mContext.sendStickyBroadcast(intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.961 -0400", hash_original_method = "94421FD931B343EAA867A258AA9C894E", hash_generated_method = "3062A4CDBA60DCD850CE61FF165E9B60")
     void initializeHdmiState() {
        boolean plugged = false;
        if(new File("/sys/devices/virtual/switch/hdmi/state").exists())        
        {
mHDMIObserver.startObserving("DEVPATH=/devices/virtual/switch/hdmi")            final String filename = "/sys/class/switch/hdmi/state";
            FileReader reader = null;
            try 
            {
reader=new FileReader(filename)                char[] buf = new char[15];
                int n = reader.read(buf);
                if(n>1)                
                {
plugged=0!=Integer.parseInt(new String(buf, 0, n-1))
                } //End block
            } //End block
            catch (IOException ex)
            {
            } //End block
            catch (NumberFormatException ex)
            {
            } //End block
            finally 
            {
                if(reader!=null)                
                {
                    try 
                    {
reader.close()
                    } //End block
                    catch (IOException ex)
                    {
                    } //End block
                } //End block
            } //End block
        } //End block
mHdmiPlugged=!pluggedsetHdmiPlugged(!mHdmiPlugged)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.962 -0400", hash_original_method = "EF159ACDE710F89E1CBD4F9DFC4155C7", hash_generated_method = "7C79B6E61C92381C5AD945875E13B34F")
     boolean isMusicActive() {
        final AudioManager am = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        if(am==null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1692863093 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2075684914 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2075684914;
        } //End block
        boolean var1B3EDB0FC2E2832D0E9703C5979FA33B_479735045 = (am.isMusicActive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839302124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839302124;
        // ---------- Original Method ----------
        //final AudioManager am = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        //if (am == null) {
            //Log.w(TAG, "isMusicActive: couldn't get AudioManager reference");
            //return false;
        //}
        //return am.isMusicActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.963 -0400", hash_original_method = "440D384BCD76AC128F7F76E13A46AA69", hash_generated_method = "3492292B639C7AF75A371B51E49B6546")
     void handleVolumeKey(int stream, int keycode) {
        addTaint(keycode);
        addTaint(stream);
        IAudioService audioService = getAudioService();
        if(audioService==null)        
        {
            return;
        } //End block
        try 
        {
mBroadcastWakeLock.acquire()audioService.adjustStreamVolume(stream, keycode==KeyEvent.KEYCODE_VOLUME_UP?AudioManager.ADJUST_RAISE:AudioManager.ADJUST_RAISE, 0)
        } //End block
        catch (RemoteException e)
        {
        } //End block
        finally 
        {
mBroadcastWakeLock.release()
        } //End block
        // ---------- Original Method ----------
        //IAudioService audioService = getAudioService();
        //if (audioService == null) {
            //return;
        //}
        //try {
            //mBroadcastWakeLock.acquire();
            //audioService.adjustStreamVolume(stream,
                //keycode == KeyEvent.KEYCODE_VOLUME_UP
                            //? AudioManager.ADJUST_RAISE
                            //: AudioManager.ADJUST_LOWER,
                    //0);
        //} catch (RemoteException e) {
            //Log.w(TAG, "IAudioService.adjustStreamVolume() threw RemoteException " + e);
        //} finally {
            //mBroadcastWakeLock.release();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.964 -0400", hash_original_method = "D061BB3A21A972590996BC5DDCCEBA70", hash_generated_method = "CEBC7682E3128C58271708F4C81C1D58")
    private void takeScreenshot() {
        synchronized
(mScreenshotLock)        {
            if(mScreenshotConnection!=null)            
            {
                return;
            } //End block
            ComponentName cn = new ComponentName("com.android.systemui",
                    "com.android.systemui.screenshot.TakeScreenshotService");
            Intent intent = new Intent();
intent.setComponent(cn)            ServiceConnection conn = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    synchronized (mScreenshotLock) {
                        if (mScreenshotConnection != this) {
                            return;
                        }
                        Messenger messenger = new Messenger(service);
                        Message msg = Message.obtain(null, 1);
                        final ServiceConnection myConn = this;
                        Handler h = new Handler(mHandler.getLooper()) {
                            @Override
                            public void handleMessage(Message msg) {
                                synchronized (mScreenshotLock) {
                                    if (mScreenshotConnection == myConn) {
                                        mContext.unbindService(mScreenshotConnection);
                                        mScreenshotConnection = null;
                                        mHandler.removeCallbacks(mScreenshotTimeout);
                                    }
                                }
                            }
                        };
                        msg.replyTo = new Messenger(h);
                        msg.arg1 = msg.arg2 = 0;
                        if (mStatusBar != null && mStatusBar.isVisibleLw())
                            msg.arg1 = 1;
                        if (mNavigationBar != null && mNavigationBar.isVisibleLw())
                            msg.arg2 = 1;
                        try {
                            messenger.send(msg);
                        } catch (RemoteException e) {
                        }
                    }
                }
                @Override
                public void onServiceDisconnected(ComponentName name) {}
            };
            if(mContext.bindService(intent, conn, Context.BIND_AUTO_CREATE))            
            {
mScreenshotConnection=connmHandler.postDelayed(mScreenshotTimeout, 10000)
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.968 -0400", hash_original_method = "9B230F6656A0AD13295EA2082EA3513F", hash_generated_method = "9F0E1ABFD37CEA368747109DC45F6B81")
    @Override
    public int interceptKeyBeforeQueueing(KeyEvent event, int policyFlags, boolean isScreenOn) {
        addTaint(isScreenOn);
        addTaint(policyFlags);
        addTaint(event.getTaint());
        final boolean down = event.getAction() == KeyEvent.ACTION_DOWN;
        final boolean canceled = event.isCanceled();
        final int keyCode = event.getKeyCode();
        final boolean isInjected = (policyFlags & WindowManagerPolicy.FLAG_INJECTED) != 0;
        final boolean keyguardActive = (isScreenOn ?
                                        mKeyguardMediator.isShowingAndNotHidden() :
                                        mKeyguardMediator.isShowing());
        if(!mSystemBooted)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_980811337 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840109837 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840109837;
        } //End block
        if(false)        
        {
Log.d(TAG, "interceptKeyTq keycode="+keyCode+" screenIsOn="+isScreenOn+" keyguardActive="+keyguardActive)
        } //End block
        if(down&&(policyFlags&WindowManagerPolicy.FLAG_VIRTUAL)!=0&&event.getRepeatCount()==0)        
        {
performHapticFeedbackLw(null, HapticFeedbackConstants.VIRTUAL_KEY, false)
        } //End block
        int result;
        if(isScreenOn||isInjected)        
        {
result=ACTION_PASS_TO_USER
        } //End block
        else
        {
result=0            final boolean isWakeKey = (policyFlags
                    & (WindowManagerPolicy.FLAG_WAKE | WindowManagerPolicy.FLAG_WAKE_DROPPED)) != 0;
            if(down&&isWakeKey)            
            {
                if(keyguardActive)                
                {
mKeyguardMediator.onWakeKeyWhenKeyguardShowingTq(keyCode, mDockMode!=Intent.EXTRA_DOCK_STATE_UNDOCKED)
                } //End block
                else
                {
result|=ACTION_POKE_USER_ACTIVITY
                } //End block
            } //End block
        } //End block
        switch(keyCode){
        case KeyEvent.KEYCODE_VOLUME_DOWN:
        case KeyEvent.KEYCODE_VOLUME_UP:
        case KeyEvent.KEYCODE_VOLUME_MUTE:
        {
            if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN)            
            {
                if(down)                
                {
                    if(isScreenOn&&!mVolumeDownKeyTriggered&&(event.getFlags()&KeyEvent.FLAG_FALLBACK)==0)                    
                    {
mVolumeDownKeyTriggered=truemVolumeDownKeyTime=event.getDownTime()mVolumeDownKeyConsumedByScreenshotChord=falsecancelPendingPowerKeyAction()interceptScreenshotChord()
                    } //End block
                } //End block
                else
                {
mVolumeDownKeyTriggered=falsecancelPendingScreenshotChordAction()
                } //End block
            } //End block
            else
            if(keyCode==KeyEvent.KEYCODE_VOLUME_UP)            
            {
                if(down)                
                {
                    if(isScreenOn&&!mVolumeUpKeyTriggered&&(event.getFlags()&KeyEvent.FLAG_FALLBACK)==0)                    
                    {
mVolumeUpKeyTriggered=truecancelPendingPowerKeyAction()cancelPendingScreenshotChordAction()
                    } //End block
                } //End block
                else
                {
mVolumeUpKeyTriggered=falsecancelPendingScreenshotChordAction()
                } //End block
            } //End block
            if(down)            
            {
                ITelephony telephonyService = getTelephonyService();
                if(telephonyService!=null)                
                {
                    try 
                    {
                        if(telephonyService.isRinging())                        
                        {
telephonyService.silenceRinger()result&=~ACTION_PASS_TO_USER                            break;
                        } //End block
                        if(telephonyService.isOffhook()&&(result&ACTION_PASS_TO_USER)==0)                        
                        {
handleVolumeKey(AudioManager.STREAM_VOICE_CALL, keyCode)                            break;
                        } //End block
                    } //End block
                    catch (RemoteException ex)
                    {
                    } //End block
                } //End block
                if(isMusicActive()&&(result&ACTION_PASS_TO_USER)==0)                
                {
handleVolumeKey(AudioManager.STREAM_MUSIC, keyCode)                    break;
                } //End block
            } //End block
            break;
        } //End block
        case KeyEvent.KEYCODE_ENDCALL:
        {
result&=~ACTION_PASS_TO_USER            if(down)            
            {
                ITelephony telephonyService = getTelephonyService();
                boolean hungUp = false;
                if(telephonyService!=null)                
                {
                    try 
                    {
hungUp=telephonyService.endCall()
                    } //End block
                    catch (RemoteException ex)
                    {
                    } //End block
                } //End block
interceptPowerKeyDown(!isScreenOn||hungUp)
            } //End block
            else
            {
                if(interceptPowerKeyUp(canceled))                
                {
                    if((mEndcallBehavior&Settings.System.END_BUTTON_BEHAVIOR_HOME)!=0)                    
                    {
                        if(goHome())                        
                        {
                            break;
                        } //End block
                    } //End block
                    if((mEndcallBehavior&Settings.System.END_BUTTON_BEHAVIOR_SLEEP)!=0)                    
                    {
result=(result&~ACTION_POKE_USER_ACTIVITY)|ACTION_GO_TO_SLEEP
                    } //End block
                } //End block
            } //End block
            break;
        } //End block
        case KeyEvent.KEYCODE_POWER:
        {
result&=~ACTION_PASS_TO_USER            if(down)            
            {
                if(isScreenOn&&!mPowerKeyTriggered&&(event.getFlags()&KeyEvent.FLAG_FALLBACK)==0)                
                {
mPowerKeyTriggered=truemPowerKeyTime=event.getDownTime()interceptScreenshotChord()
                } //End block
                ITelephony telephonyService = getTelephonyService();
                boolean hungUp = false;
                if(telephonyService!=null)                
                {
                    try 
                    {
                        if(telephonyService.isRinging())                        
                        {
telephonyService.silenceRinger()
                        } //End block
                        else
                        if((mIncallPowerBehavior&Settings.Secure.INCALL_POWER_BUTTON_BEHAVIOR_HANGUP)!=0&&telephonyService.isOffhook())                        
                        {
hungUp=telephonyService.endCall()
                        } //End block
                    } //End block
                    catch (RemoteException ex)
                    {
                    } //End block
                } //End block
interceptPowerKeyDown(!isScreenOn||hungUp||mVolumeDownKeyTriggered||mVolumeUpKeyTriggered)
            } //End block
            else
            {
mPowerKeyTriggered=falsecancelPendingScreenshotChordAction()                if(interceptPowerKeyUp(canceled||mPendingPowerKeyUpCanceled))                
                {
result=(result&~ACTION_POKE_USER_ACTIVITY)|ACTION_GO_TO_SLEEP
                } //End block
mPendingPowerKeyUpCanceled=false
            } //End block
            break;
        } //End block
        case KeyEvent.KEYCODE_MEDIA_PLAY:
        case KeyEvent.KEYCODE_MEDIA_PAUSE:
        case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
        if(down)        
        {
            ITelephony telephonyService = getTelephonyService();
            if(telephonyService!=null)            
            {
                try 
                {
                    if(!telephonyService.isIdle())                    
                    {
                        break;
                    } //End block
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
        } //End block
        case KeyEvent.KEYCODE_HEADSETHOOK:
        case KeyEvent.KEYCODE_MUTE:
        case KeyEvent.KEYCODE_MEDIA_STOP:
        case KeyEvent.KEYCODE_MEDIA_NEXT:
        case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
        case KeyEvent.KEYCODE_MEDIA_REWIND:
        case KeyEvent.KEYCODE_MEDIA_RECORD:
        case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
        {
            if((result&ACTION_PASS_TO_USER)==0)            
            {
mBroadcastWakeLock.acquire()mHandler.post(new PassHeadsetKey(new KeyEvent(event)))
            } //End block
            break;
        } //End block
        case KeyEvent.KEYCODE_CALL:
        {
            if(down)            
            {
                ITelephony telephonyService = getTelephonyService();
                if(telephonyService!=null)                
                {
                    try 
                    {
                        if(telephonyService.isRinging())                        
                        {
telephonyService.answerRingingCall()result&=~ACTION_PASS_TO_USER
                        } //End block
                    } //End block
                    catch (RemoteException ex)
                    {
                    } //End block
                } //End block
            } //End block
            break;
        } //End block
}        int varB4A88417B3D0170D754C647C30B7216A_501058257 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175545024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175545024;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.984 -0400", hash_original_method = "AF519B85C30AEC53268B007BDBA6DE20", hash_generated_method = "1DE651F0690C8CB3E402C5E86A8972E1")
    @Override
    public int interceptMotionBeforeQueueingWhenScreenOff(int policyFlags) {
        addTaint(policyFlags);
        int result = 0;
        final boolean isWakeMotion = (policyFlags
                & (WindowManagerPolicy.FLAG_WAKE | WindowManagerPolicy.FLAG_WAKE_DROPPED)) != 0;
        if(isWakeMotion)        
        {
            if(mKeyguardMediator.isShowing())            
            {
mKeyguardMediator.onWakeMotionWhenKeyguardShowingTq()
            } //End block
            else
            {
result|=ACTION_POKE_USER_ACTIVITY
            } //End block
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_652260607 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058925917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058925917;
        // ---------- Original Method ----------
        //int result = 0;
        //final boolean isWakeMotion = (policyFlags
                //& (WindowManagerPolicy.FLAG_WAKE | WindowManagerPolicy.FLAG_WAKE_DROPPED)) != 0;
        //if (isWakeMotion) {
            //if (mKeyguardMediator.isShowing()) {
                //mKeyguardMediator.onWakeMotionWhenKeyguardShowingTq();
            //} else {
                //result |= ACTION_POKE_USER_ACTIVITY;
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.985 -0400", hash_original_method = "81A4B650270FC9DEB80116CAD6CA18C4", hash_generated_method = "FC56A7FF8953D44D16BA9E7B65E8C6D7")
    public void screenTurnedOff(int why) {
        addTaint(why);
EventLog.writeEvent(70000, 0)        synchronized
(mLock)        {
mScreenOnEarly=falsemScreenOnFully=false
        } //End block
mKeyguardMediator.onScreenTurnedOff(why)        synchronized
(mLock)        {
updateOrientationListenerLp()updateLockScreenTimeout()
        } //End block
        // ---------- Original Method ----------
        //EventLog.writeEvent(70000, 0);
        //synchronized (mLock) {
            //mScreenOnEarly = false;
            //mScreenOnFully = false;
        //}
        //mKeyguardMediator.onScreenTurnedOff(why);
        //synchronized (mLock) {
            //updateOrientationListenerLp();
            //updateLockScreenTimeout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.988 -0400", hash_original_method = "F8A94432FAD687DBCBB1F8338A1FB346", hash_generated_method = "0D6E02D2484143F847F9B92C47D05C8C")
    public void screenTurningOn(final ScreenOnListener screenOnListener) {
        addTaint(screenOnListener.getTaint());
EventLog.writeEvent(70000, 1)        if(false)        
        {
            RuntimeException here = new RuntimeException("here");
here.fillInStackTrace()
        } //End block
        if(screenOnListener!=null)        
        {
mKeyguardMediator.onScreenTurnedOn(new KeyguardViewManager.ShowListener()            {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.987 -0400", hash_original_method = "D5A2E401B44D3C4250372D59CD06302F", hash_generated_method = "56DCE54501B581BEF8F4BDA1C2AEC855")
        @Override
        public void onShown(IBinder windowToken) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(windowToken.getTaint());
            if(windowToken!=null)            
            {
                try 
                {
mWindowManager.waitForWindowDrawn(windowToken, new IRemoteCallback.Stub()                    {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.987 -0400", hash_original_method = "7DF9379ECA33D904F809037FCF0E2B8F", hash_generated_method = "F3437205243AECEF0D950B1633FA381F")
            @Override
            public void sendResult(Bundle data) {
                addTaint(data.getTaint());
screenOnListener.onScreenOn()                synchronized
(mLock)                {
mScreenOnFully=true
                } //End block
                // ---------- Original Method ----------
                //Slog.i(TAG, "Lock screen displayed!");
                //screenOnListener.onScreenOn();
                //synchronized (mLock) {
                                        //mScreenOnFully = true;
                                    //}
            }
                    }
)
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
            else
            {
screenOnListener.onScreenOn()                synchronized
(mLock)                {
mScreenOnFully=true
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
            }
)
        } //End block
        else
        {
            synchronized
(mLock)            {
mScreenOnFully=true
            } //End block
        } //End block
        synchronized
(mLock)        {
mScreenOnEarly=trueupdateOrientationListenerLp()updateLockScreenTimeout()
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.988 -0400", hash_original_method = "59301AF3344C4AE7E6CC24D562C13FE4", hash_generated_method = "AF91606C37582130220461D56D5122D2")
    public boolean isScreenOnEarly() {
        boolean var4A0844A47CFA2547D5A684C8B46E394F_1871724998 = (mScreenOnEarly);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382789800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382789800;
        // ---------- Original Method ----------
        //return mScreenOnEarly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.989 -0400", hash_original_method = "2A31FBA720B3451B420D156319BBEFFB", hash_generated_method = "B22DF1197549949DBDB081296352934F")
    public boolean isScreenOnFully() {
        boolean var2575147156B7055AD3E955659C4E0F42_1452290663 = (mScreenOnFully);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289535541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_289535541;
        // ---------- Original Method ----------
        //return mScreenOnFully;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.990 -0400", hash_original_method = "A9317B4EFDCD31735BE9EFFEB83E0B18", hash_generated_method = "3D2726D9647D20547CE92D4739A69E06")
    public void enableKeyguard(boolean enabled) {
        addTaint(enabled);
mKeyguardMediator.setKeyguardEnabled(enabled)
        // ---------- Original Method ----------
        //mKeyguardMediator.setKeyguardEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.991 -0400", hash_original_method = "3237FD073421C781FBA92996FE6F3B04", hash_generated_method = "4FB473C37F097BD5595860C53C21AA7E")
    public void exitKeyguardSecurely(OnKeyguardExitResult callback) {
        addTaint(callback.getTaint());
mKeyguardMediator.verifyUnlock(callback)
        // ---------- Original Method ----------
        //mKeyguardMediator.verifyUnlock(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.991 -0400", hash_original_method = "4F099C2645A6FD4C6CEA8756A2802416", hash_generated_method = "4E1D9B9384ACBAFBC35A3CB291C4F484")
    private boolean keyguardIsShowingTq() {
        boolean varA1A4A671BA8E38217D80B40D3ABBC6D9_1112939581 = (mKeyguardMediator.isShowingAndNotHidden());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1096665092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1096665092;
        // ---------- Original Method ----------
        //return mKeyguardMediator.isShowingAndNotHidden();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.992 -0400", hash_original_method = "B7422D2C59016DE886256D3D292BC242", hash_generated_method = "8415B93841086A46EE9B428F26D11C13")
    public boolean isKeyguardLocked() {
        boolean var2FEFF672571E46D60D281C590C819F8E_2100156848 = (keyguardOn());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008314485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008314485;
        // ---------- Original Method ----------
        //return keyguardOn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.993 -0400", hash_original_method = "EFFBAC82872C4BAEC7C5544176F961B4", hash_generated_method = "EBCB5A1432893ECD2AB1D5E13F5DA0E8")
    public boolean isKeyguardSecure() {
        boolean var884561D4D9255900BE169277ACBE0805_1327526029 = (mKeyguardMediator.isSecure());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101768715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101768715;
        // ---------- Original Method ----------
        //return mKeyguardMediator.isSecure();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.994 -0400", hash_original_method = "E50AEE8A950B1BE0DA845D79E95D04F0", hash_generated_method = "F13BA8B12CBDAB756CA13C3B95A028C1")
    public boolean inKeyguardRestrictedKeyInputMode() {
        boolean var9ACDDB8F565016F743FB7A131DBD141E_202205301 = (mKeyguardMediator.isInputRestricted());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301228343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301228343;
        // ---------- Original Method ----------
        //return mKeyguardMediator.isInputRestricted();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.995 -0400", hash_original_method = "0D3C20CDEAE8926239C8B8B14D22874E", hash_generated_method = "5DEE1B76F60BC92D08B52D8562BF5D65")
    public void dismissKeyguardLw() {
        if(!mKeyguardMediator.isSecure())        
        {
            if(mKeyguardMediator.isShowing())            
            {
mHandler.post(new Runnable()                {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.995 -0400", hash_original_method = "D99DD30BCE3C5DCD254DB6211B6CA2D3", hash_generated_method = "924577305A8B3E0D359E7E65FAD03D7F")
        public void run() {
mKeyguardMediator.keyguardDone(false, true)
            // ---------- Original Method ----------
            //mKeyguardMediator.keyguardDone(false, true);
        }
                }
)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!mKeyguardMediator.isSecure()) {
            //if (mKeyguardMediator.isShowing()) {
                //mHandler.post(new Runnable() {
                    //public void run() {
                        //mKeyguardMediator.keyguardDone(false, true);
                    //}
                //});
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.995 -0400", hash_original_method = "1DEE23F13B9B353EC138FB4CA31D92E4", hash_generated_method = "D94A4491A0C8D76B8A543D00436D851E")
     void sendCloseSystemWindows() {
sendCloseSystemWindows(mContext, null)
        // ---------- Original Method ----------
        //sendCloseSystemWindows(mContext, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.996 -0400", hash_original_method = "0EC9ECBC6E656D07CAA7A73F72F52C53", hash_generated_method = "AED90D83FDB50127805D15945F525084")
     void sendCloseSystemWindows(String reason) {
        addTaint(reason.getTaint());
sendCloseSystemWindows(mContext, reason)
        // ---------- Original Method ----------
        //sendCloseSystemWindows(mContext, reason);
    }

    
        static void sendCloseSystemWindows(Context context, String reason) {
        if (ActivityManagerNative.isSystemReady()) {
            try {
                ActivityManagerNative.getDefault().closeSystemDialogs(reason);
            } catch (RemoteException e) {
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:50.999 -0400", hash_original_method = "869595B9D37D4816FBA596D4FA6BC137", hash_generated_method = "363FCD7BB80D2CA2764C56F0A64695ED")
    @Override
    public int rotationForOrientationLw(int orientation, int lastRotation) {
        addTaint(lastRotation);
        addTaint(orientation);
        if(false)        
        {
        } //End block
        synchronized
(mLock)        {
            int sensorRotation = mOrientationListener.getProposedRotation();
            if(sensorRotation<0)            
            {
sensorRotation=lastRotation
            } //End block
            int preferredRotation;
            if(mLidOpen==LID_OPEN&&mLidOpenRotation>=0)            
            {
preferredRotation=mLidOpenRotation
            } //End block
            else
            if(mDockMode==Intent.EXTRA_DOCK_STATE_CAR&&(mCarDockEnablesAccelerometer||mCarDockRotation>=0))            
            {
preferredRotation=mCarDockEnablesAccelerometer?sensorRotation:sensorRotation
            } //End block
            else
            if((mDockMode==Intent.EXTRA_DOCK_STATE_DESK||mDockMode==Intent.EXTRA_DOCK_STATE_LE_DESK||mDockMode==Intent.EXTRA_DOCK_STATE_HE_DESK)&&(mDeskDockEnablesAccelerometer||mDeskDockRotation>=0))            
            {
preferredRotation=mDeskDockEnablesAccelerometer?sensorRotation:sensorRotation
            } //End block
            else
            if(mHdmiPlugged)            
            {
preferredRotation=mHdmiRotation
            } //End block
            else
            if((mAccelerometerDefault!=0&&(orientation==ActivityInfo.SCREEN_ORIENTATION_USER||orientation==ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED))||orientation==ActivityInfo.SCREEN_ORIENTATION_SENSOR||orientation==ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR||orientation==ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE||orientation==ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT)            
            {
                if(mAllowAllRotations<0)                
                {
mAllowAllRotations=mContext.getResources().getBoolean(com.android.internal.R.bool.config_allowAllRotations)?1:1
                } //End block
                if(sensorRotation!=Surface.ROTATION_180||mAllowAllRotations==1||orientation==ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR)                
                {
preferredRotation=sensorRotation
                } //End block
                else
                {
preferredRotation=lastRotation
                } //End block
            } //End block
            else
            if(mUserRotationMode==WindowManagerPolicy.USER_ROTATION_LOCKED)            
            {
preferredRotation=mUserRotation
            } //End block
            else
            {
preferredRotation=-1
            } //End block
            switch(orientation){
            case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
            if(isAnyPortrait(preferredRotation))            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_516535150 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449264156 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449264156;
            } //End block
            int varC95C36774EE309313538BC7E2BC52B15_401391199 = (mPortraitRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920409496 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920409496;
            case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
            if(isLandscapeOrSeascape(preferredRotation))            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_1811960085 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569432193 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1569432193;
            } //End block
            int varE94A4F10998279A7D18D41A6C55AA2C2_1449251121 = (mLandscapeRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442238526 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442238526;
            case ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT:
            if(isAnyPortrait(preferredRotation))            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_185512006 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130053342 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1130053342;
            } //End block
            int var1CEF4023902D32A009A700D532CCF92E_1853501875 = (mUpsideDownRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665239217 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665239217;
            case ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE:
            if(isLandscapeOrSeascape(preferredRotation))            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_1116242555 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608857816 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608857816;
            } //End block
            int var1182CB937617FE2B560F6802FDB5DBD8_140664602 = (mSeascapeRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001787945 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2001787945;
            case ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE:
            if(isLandscapeOrSeascape(preferredRotation))            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_1008969424 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217608144 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1217608144;
            } //End block
            if(isLandscapeOrSeascape(lastRotation))            
            {
                int var37E5C487C9CFA424E0D8F2CACF79E6F4_794587538 = (lastRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41282936 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41282936;
            } //End block
            int varE94A4F10998279A7D18D41A6C55AA2C2_802397974 = (mLandscapeRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275841791 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1275841791;
            case ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT:
            if(isAnyPortrait(preferredRotation))            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_340031066 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353349367 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353349367;
            } //End block
            if(isAnyPortrait(lastRotation))            
            {
                int var37E5C487C9CFA424E0D8F2CACF79E6F4_222751614 = (lastRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934957355 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1934957355;
            } //End block
            int varC95C36774EE309313538BC7E2BC52B15_1180981849 = (mPortraitRotation);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859557542 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_859557542;
            default:
            if(preferredRotation>=0)            
            {
                int var2CD67F1385137D517BCE470BCAEDD95D_581955508 = (preferredRotation);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250373001 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_250373001;
            } //End block
            int varE560F3BBCB073851AA5D49F37B757556_1731613103 = (Surface.ROTATION_0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911688537 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_911688537;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.004 -0400", hash_original_method = "E998223E4E58735645A87424E89BC617", hash_generated_method = "C10254A3619ABD53637D1836A9471857")
    @Override
    public boolean rotationHasCompatibleMetricsLw(int orientation, int rotation) {
        addTaint(rotation);
        addTaint(orientation);
        switch(orientation){
        case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
        case ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT:
        case ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT:
        boolean var3BA529A2CB8B6F1950045841B959A032_2052301321 = (isAnyPortrait(rotation));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_269465254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_269465254;
        case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
        case ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE:
        case ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE:
        boolean varC63B26C277F6128881F02834BBA15B1D_1652806626 = (isLandscapeOrSeascape(rotation));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686738969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_686738969;
        default:
        boolean varB326B5062B2F0E69046810717534CB09_93843511 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619393484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619393484;
}
        // ---------- Original Method ----------
        //switch (orientation) {
            //case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
            //case ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT:
            //case ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT:
                //return isAnyPortrait(rotation);
            //case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
            //case ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE:
            //case ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE:
                //return isLandscapeOrSeascape(rotation);
            //default:
                //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.005 -0400", hash_original_method = "BA680264553DEF7F97F93F286164E4D2", hash_generated_method = "A5B525C444E9A48AB9046E283C408D31")
    @Override
    public void setRotationLw(int rotation) {
        addTaint(rotation);
mOrientationListener.setCurrentRotation(rotation)
        // ---------- Original Method ----------
        //mOrientationListener.setCurrentRotation(rotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.006 -0400", hash_original_method = "56AE848E4A9E3B0B7C521A4F9A8CBD42", hash_generated_method = "FCB32C267D1EAE1C995C7F0B9A10A862")
    private boolean isLandscapeOrSeascape(int rotation) {
        addTaint(rotation);
        boolean var42BEF6791C2028FA24D739316539EDBF_401843977 = (rotation==mLandscapeRotation||rotation==mSeascapeRotation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190223611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190223611;
        // ---------- Original Method ----------
        //return rotation == mLandscapeRotation || rotation == mSeascapeRotation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.007 -0400", hash_original_method = "7DC63B67332A2446F9286420610DFBF6", hash_generated_method = "B0813522B5EBD0C5D6EA41F6C6DA45CD")
    private boolean isAnyPortrait(int rotation) {
        addTaint(rotation);
        boolean varC43E971414CC09617A858F8D1B8E90AB_1393716208 = (rotation==mPortraitRotation||rotation==mUpsideDownRotation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310651214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_310651214;
        // ---------- Original Method ----------
        //return rotation == mPortraitRotation || rotation == mUpsideDownRotation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.009 -0400", hash_original_method = "A8BA544D50C527B685E99E1E6D8224B7", hash_generated_method = "4216C28DBFDC140D863703A89289700B")
    public void setUserRotationMode(int mode, int rot) {
        addTaint(rot);
        addTaint(mode);
        ContentResolver res = mContext.getContentResolver();
        if(mode==WindowManagerPolicy.USER_ROTATION_LOCKED)        
        {
Settings.System.putInt(res, Settings.System.USER_ROTATION, rot)Settings.System.putInt(res, Settings.System.ACCELEROMETER_ROTATION, 0)
        } //End block
        else
        {
Settings.System.putInt(res, Settings.System.ACCELEROMETER_ROTATION, 1)
        } //End block
        // ---------- Original Method ----------
        //ContentResolver res = mContext.getContentResolver();
        //if (mode == WindowManagerPolicy.USER_ROTATION_LOCKED) {
            //Settings.System.putInt(res,
                    //Settings.System.USER_ROTATION,
                    //rot);
            //Settings.System.putInt(res,
                    //Settings.System.ACCELEROMETER_ROTATION,
                    //0);
        //} else {
            //Settings.System.putInt(res,
                    //Settings.System.ACCELEROMETER_ROTATION,
                    //1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.011 -0400", hash_original_method = "3B4BC3F6C002FEF0DEA96B51941DD66A", hash_generated_method = "5429A6E64DC057232B2C1A4AD8BF6BDC")
    public boolean detectSafeMode() {
        try 
        {
            int menuState = mWindowManager.getKeycodeState(KeyEvent.KEYCODE_MENU);
            int sState = mWindowManager.getKeycodeState(KeyEvent.KEYCODE_S);
            int dpadState = mWindowManager.getDPadKeycodeState(KeyEvent.KEYCODE_DPAD_CENTER);
            int trackballState = mWindowManager.getTrackballScancodeState(BTN_MOUSE);
            int volumeDownState = mWindowManager.getKeycodeState(KeyEvent.KEYCODE_VOLUME_DOWN);
mSafeMode=menuState>0||sState>0||dpadState>0||trackballState>0||volumeDownState>0performHapticFeedbackLw(null, mSafeMode?HapticFeedbackConstants.SAFE_MODE_ENABLED:HapticFeedbackConstants.SAFE_MODE_ENABLED, true)            if(mSafeMode)            
            {
            } //End block
            else
            {
            } //End block
            boolean var18CF8AA04AC6DCCB0F8C7A20044E676C_1056905994 = (mSafeMode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775851483 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_775851483;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException var510708BE01B1072ED300E4E0D46BB260_865479892 = new RuntimeException("window manager dead");
            var510708BE01B1072ED300E4E0D46BB260_865479892.addTaint(taint);
            throw var510708BE01B1072ED300E4E0D46BB260_865479892;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static long[] getLongIntArray(Resources r, int resid) {
        int[] ar = r.getIntArray(resid);
        if (ar == null) {
            return null;
        }
        long[] out = new long[ar.length];
        for (int i=0; i<ar.length; i++) {
            out[i] = ar[i];
        }
        return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.013 -0400", hash_original_method = "90D8824E44EA4DEC04D1DAA693480EB5", hash_generated_method = "FD8CA111A4B07CF07785932C95141B88")
    public void systemReady() {
mKeyguardMediator.onSystemReady()android.os.SystemProperties.set("dev.bootcomplete", "1")        synchronized
(mLock)        {
updateOrientationListenerLp()mSystemReady=truemHandler.post(new Runnable()            {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.013 -0400", hash_original_method = "DE1F18D18EF537CB065642EFCDD039A9", hash_generated_method = "F48B5017166799B88BC94E152A759885")
        public void run() {
updateSettings()
            // ---------- Original Method ----------
            //updateSettings();
        }
            }
)
        } //End block
        // ---------- Original Method ----------
        //mKeyguardMediator.onSystemReady();
        //android.os.SystemProperties.set("dev.bootcomplete", "1");
        //synchronized (mLock) {
            //updateOrientationListenerLp();
            //mSystemReady = true;
            //mHandler.post(new Runnable() {
                //public void run() {
                    //updateSettings();
                //}
            //});
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.014 -0400", hash_original_method = "362C2FC04F0437CBA94AEDCAD4D860C0", hash_generated_method = "D3C1A165493C955DB6D5127C5FF416A8")
    public void systemBooted() {
        synchronized
(mLock)        {
mSystemBooted=true
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //mSystemBooted = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.023 -0400", hash_original_method = "EDF2D303B9ACAC1ACF2912D5959D2A77", hash_generated_method = "37132B9980ABC3A89EEE568DBB24D9E1")
    public void showBootMessage(final CharSequence msg, final boolean always) {
        addTaint(always);
        addTaint(msg.getTaint());
mHandler.post(new Runnable()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.022 -0400", hash_original_method = "526297C751DC8CE48885B0007D33D9D0", hash_generated_method = "2CA9052CFA735A3D8C0C9D2F64E274E2")
        @Override
        public void run() {
            if(mBootMsgDialog==null)            
            {
mBootMsgDialog=new ProgressDialog(mContext)                {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.017 -0400", hash_original_method = "31EAB23606083D0F4AED3A08DC0C6501", hash_generated_method = "5D42105FAE6701918E2598535315C3A7")
            @Override
            public boolean dispatchKeyEvent(KeyEvent event) {
                addTaint(event.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_1428210651 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578365886 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578365886;
                // ---------- Original Method ----------
                //return true;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.018 -0400", hash_original_method = "38269CA1832A47926B87A0F4C70227CB", hash_generated_method = "0A55B9CE72186A6420F2A6201CB37A02")
            @Override
            public boolean dispatchKeyShortcutEvent(KeyEvent event) {
                addTaint(event.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_1247389514 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364847643 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_364847643;
                // ---------- Original Method ----------
                //return true;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.018 -0400", hash_original_method = "4B93BA9F7E04E3F01D04E9A582F768A7", hash_generated_method = "99AAC03A6421B7562A11D7F69FDF985E")
            @Override
            public boolean dispatchTouchEvent(MotionEvent ev) {
                addTaint(ev.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_1911902381 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312376614 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312376614;
                // ---------- Original Method ----------
                //return true;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.019 -0400", hash_original_method = "4F044217C947043DFC972309EEB1D971", hash_generated_method = "CDE139287F176DD86B136CD6FA1945A1")
            @Override
            public boolean dispatchTrackballEvent(MotionEvent ev) {
                addTaint(ev.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_1238051573 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026024403 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026024403;
                // ---------- Original Method ----------
                //return true;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.020 -0400", hash_original_method = "4DEED6E5CD30C346B70C0FBAC7F9732B", hash_generated_method = "442942A84467DFFDBC7E21A2F283C9AC")
            @Override
            public boolean dispatchGenericMotionEvent(MotionEvent ev) {
                addTaint(ev.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_988992579 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153597477 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153597477;
                // ---------- Original Method ----------
                //return true;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.021 -0400", hash_original_method = "CE24DFE0518892E61AFCE05906F89CB6", hash_generated_method = "DB42ED45E8435B1A02C8EA978CED1F1A")
            @Override
            public boolean dispatchPopulateAccessibilityEvent(
                                AccessibilityEvent event) {
                addTaint(event.getTaint());
                boolean varB326B5062B2F0E69046810717534CB09_1350860871 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_353200305 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_353200305;
                // ---------- Original Method ----------
                //return true;
            }
                }
mBootMsgDialog.setTitle(R.string.android_upgrading_title)mBootMsgDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)mBootMsgDialog.setIndeterminate(true)mBootMsgDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_BOOT_PROGRESS)mBootMsgDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND|WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)mBootMsgDialog.getWindow().setDimAmount(1)                WindowManager.LayoutParams lp = mBootMsgDialog.getWindow().getAttributes();
lp.screenOrientation=ActivityInfo.SCREEN_ORIENTATION_NOSENSORmBootMsgDialog.getWindow().setAttributes(lp)mBootMsgDialog.setCancelable(false)mBootMsgDialog.show()
            } //End block
mBootMsgDialog.setMessage(msg)
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
        }
)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.025 -0400", hash_original_method = "2200F02C1ABCE15FA6A6FA0B36C6A169", hash_generated_method = "0779D09C3A0FD3A86813732B396A5C3C")
    public void hideBootMessages() {
mHandler.post(new Runnable()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.024 -0400", hash_original_method = "9C2B0FAA7527BB604A2B6BE27B6E1918", hash_generated_method = "728EEFDF7E7B8FA991800377228FB916")
        @Override
        public void run() {
            if(mBootMsgDialog!=null)            
            {
mBootMsgDialog.dismiss()mBootMsgDialog=null
            } //End block
            // ---------- Original Method ----------
            //if (mBootMsgDialog != null) {
                    //mBootMsgDialog.dismiss();
                    //mBootMsgDialog = null;
                //}
        }
        }
)
        // ---------- Original Method ----------
        //mHandler.post(new Runnable() {
            //@Override public void run() {
                //if (mBootMsgDialog != null) {
                    //mBootMsgDialog.dismiss();
                    //mBootMsgDialog = null;
                //}
            //}
        //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.026 -0400", hash_original_method = "FD0FD9276BCF19C2AC9A5DF5530EC6A1", hash_generated_method = "A6C123D1FDE6AD5C17A024F81710A24E")
    public void userActivity() {
        synchronized
(mScreenLockTimeout)        {
            if(mLockScreenTimerActive)            
            {
mHandler.removeCallbacks(mScreenLockTimeout)mHandler.postDelayed(mScreenLockTimeout, mLockScreenTimeout)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mScreenLockTimeout) {
            //if (mLockScreenTimerActive) {
                //mHandler.removeCallbacks(mScreenLockTimeout);
                //mHandler.postDelayed(mScreenLockTimeout, mLockScreenTimeout);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.028 -0400", hash_original_method = "2193E64981324CADC94EE0065EEB5A6F", hash_generated_method = "BBA714A43575F7BA0E7D593700B9BDAB")
    public void lockNow() {
mContext.enforceCallingOrSelfPermission(android.Manifest.permission.DEVICE_POWER, null)mHandler.removeCallbacks(mScreenLockTimeout)mHandler.post(mScreenLockTimeout)
        // ---------- Original Method ----------
        //mContext.enforceCallingOrSelfPermission(android.Manifest.permission.DEVICE_POWER, null);
        //mHandler.removeCallbacks(mScreenLockTimeout);
        //mHandler.post(mScreenLockTimeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.029 -0400", hash_original_method = "E17D0064CB8AA90BB54AC68F0CA3F3A9", hash_generated_method = "27964C27FA3EE4BF15163CAD8370ED10")
    private void updateLockScreenTimeout() {
        synchronized
(mScreenLockTimeout)        {
            boolean enable = (mAllowLockscreenWhenOn && mScreenOnEarly && mKeyguardMediator.isSecure());
            if(mLockScreenTimerActive!=enable)            
            {
                if(enable)                
                {
                    if(localLOGV){ }mHandler.postDelayed(mScreenLockTimeout, mLockScreenTimeout)
                } //End block
                else
                {
                    if(localLOGV){ }mHandler.removeCallbacks(mScreenLockTimeout)
                } //End block
mLockScreenTimerActive=enable
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mScreenLockTimeout) {
            //boolean enable = (mAllowLockscreenWhenOn && mScreenOnEarly && mKeyguardMediator.isSecure());
            //if (mLockScreenTimerActive != enable) {
                //if (enable) {
                    //if (localLOGV) Log.v(TAG, "setting lockscreen timer");
                    //mHandler.postDelayed(mScreenLockTimeout, mLockScreenTimeout);
                //} else {
                    //if (localLOGV) Log.v(TAG, "clearing lockscreen timer");
                    //mHandler.removeCallbacks(mScreenLockTimeout);
                //}
                //mLockScreenTimerActive = enable;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.030 -0400", hash_original_method = "401E6A6CB6FC7583FFA4D389A42390FA", hash_generated_method = "8F22360810E3205AE68ED7D89A679D4C")
    public void enableScreenAfterBoot() {
readLidState()updateKeyboardVisibility()updateRotation(true)
        // ---------- Original Method ----------
        //readLidState();
        //updateKeyboardVisibility();
        //updateRotation(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.031 -0400", hash_original_method = "8A819B2361397F386032ED3830388989", hash_generated_method = "82F5338898ED1DA24B18772DE82BC784")
    private void updateKeyboardVisibility() {
mPowerManager.setKeyboardVisibility(mLidOpen==LID_OPEN)
        // ---------- Original Method ----------
        //mPowerManager.setKeyboardVisibility(mLidOpen == LID_OPEN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.032 -0400", hash_original_method = "9ABA6B72977F0BA3ECFC4F34AD663084", hash_generated_method = "50A51DD2CC22B78803B7C6C97F908310")
     void updateRotation(boolean alwaysSendConfiguration) {
        addTaint(alwaysSendConfiguration);
        try 
        {
mWindowManager.updateRotation(alwaysSendConfiguration)
        } //End block
        catch (RemoteException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mWindowManager.updateRotation(alwaysSendConfiguration);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.033 -0400", hash_original_method = "D86135F66F0CE595701263054C8E2809", hash_generated_method = "C8267610D719FB2947C12C945CC12162")
     Intent createHomeDockIntent() {
        Intent intent = null;
        if(mUiMode==Configuration.UI_MODE_TYPE_CAR)        
        {
            if(ENABLE_CAR_DOCK_HOME_CAPTURE)            
            {
intent=mCarDockIntent
            } //End block
        } //End block
        else
        if(mUiMode==Configuration.UI_MODE_TYPE_DESK)        
        {
            if(ENABLE_DESK_DOCK_HOME_CAPTURE)            
            {
intent=mDeskDockIntent
            } //End block
        } //End block
        if(intent==null)        
        {
Intent var540C13E9E156B687226421B24F2DF178_855850761 = null            var540C13E9E156B687226421B24F2DF178_855850761.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_855850761;
        } //End block
        ActivityInfo ai = intent.resolveActivityInfo(
                mContext.getPackageManager(), PackageManager.GET_META_DATA);
        if(ai==null)        
        {
Intent var540C13E9E156B687226421B24F2DF178_1001868105 = null            var540C13E9E156B687226421B24F2DF178_1001868105.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1001868105;
        } //End block
        if(ai.metaData!=null&&ai.metaData.getBoolean(Intent.METADATA_DOCK_HOME))        
        {
intent=new Intent(intent)intent.setClassName(ai.packageName, ai.name)Intent var095937E5B36214360A2644916BF0E8DF_1896818695 = intent            var095937E5B36214360A2644916BF0E8DF_1896818695.addTaint(taint);
            return var095937E5B36214360A2644916BF0E8DF_1896818695;
        } //End block
Intent var540C13E9E156B687226421B24F2DF178_2011932100 = null        var540C13E9E156B687226421B24F2DF178_2011932100.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2011932100;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.035 -0400", hash_original_method = "DBA380E86757515156ABAC62C7B6FC22", hash_generated_method = "D56EF1EE0E1F2C273BE5F9F84F75D20A")
     void startDockOrHome() {
        Intent dock = createHomeDockIntent();
        if(dock!=null)        
        {
            try 
            {
mContext.startActivity(dock)                return;
            } //End block
            catch (ActivityNotFoundException e)
            {
            } //End block
        } //End block
mContext.startActivity(mHomeIntent)
        // ---------- Original Method ----------
        //Intent dock = createHomeDockIntent();
        //if (dock != null) {
            //try {
                //mContext.startActivity(dock);
                //return;
            //} catch (ActivityNotFoundException e) {
            //}
        //}
        //mContext.startActivity(mHomeIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.037 -0400", hash_original_method = "54A29E14CA89A86F7C835ADC93123FF0", hash_generated_method = "689BD85C86801163AC2C69EA7B817BCB")
     boolean goHome() {
        if(false)        
        {
            try 
            {
ActivityManagerNative.getDefault().stopAppSwitches()
            } //End block
            catch (RemoteException e)
            {
            } //End block
sendCloseSystemWindows()startDockOrHome()
        } //End block
        else
        {
            try 
            {
                if(SystemProperties.getInt("persist.sys.uts-test-mode", 0)==1)                
                {
Log.d(TAG, "UTS-TEST-MODE")
                } //End block
                else
                {
ActivityManagerNative.getDefault().stopAppSwitches()sendCloseSystemWindows()                    Intent dock = createHomeDockIntent();
                    if(dock!=null)                    
                    {
                        int result = ActivityManagerNative.getDefault()
                                .startActivity(null, dock,
                                        dock.resolveTypeIfNeeded(mContext.getContentResolver()),
                                        null, 0, null, null, 0, true , false,
                                        null, null, false);
                        if(result==IActivityManager.START_RETURN_INTENT_TO_CALLER)                        
                        {
                            boolean var68934A3E9455FA72420237EB05902327_1920906656 = (false);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628513806 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_628513806;
                        } //End block
                    } //End block
                } //End block
                int result = ActivityManagerNative.getDefault()
                        .startActivity(null, mHomeIntent,
                                mHomeIntent.resolveTypeIfNeeded(mContext.getContentResolver()),
                                null, 0, null, null, 0, true , false,
                                null, null, false);
                if(result==IActivityManager.START_RETURN_INTENT_TO_CALLER)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1637369756 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647249753 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_647249753;
                } //End block
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1950926130 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943253569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_943253569;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.039 -0400", hash_original_method = "01B94BB5B7ED7603B3F5E94737BEA2D0", hash_generated_method = "4C453A5782B654276DB05EBEFB8F87F1")
    public void setCurrentOrientationLw(int newOrientation) {
        addTaint(newOrientation);
        synchronized
(mLock)        {
            if(newOrientation!=mCurrentAppOrientation)            
            {
mCurrentAppOrientation=newOrientationupdateOrientationListenerLp()
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (newOrientation != mCurrentAppOrientation) {
                //mCurrentAppOrientation = newOrientation;
                //updateOrientationListenerLp();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.041 -0400", hash_original_method = "594354E53570365A5C2C71874900568B", hash_generated_method = "6BAE32ABE856FB3640CE21D27CE3B56D")
    public boolean performHapticFeedbackLw(WindowState win, int effectId, boolean always) {
        addTaint(always);
        addTaint(effectId);
        addTaint(win.getTaint());
        final boolean hapticsDisabled = Settings.System.getInt(mContext.getContentResolver(),
                Settings.System.HAPTIC_FEEDBACK_ENABLED, 0) == 0;
        if(!always&&(hapticsDisabled||mKeyguardMediator.isShowingAndNotHidden()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1746369913 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674738236 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_674738236;
        } //End block
        long[] pattern = null;
        switch(effectId){
        case HapticFeedbackConstants.LONG_PRESS:
pattern=mLongPressVibePattern        break;
        case HapticFeedbackConstants.VIRTUAL_KEY:
pattern=mVirtualKeyVibePattern        break;
        case HapticFeedbackConstants.KEYBOARD_TAP:
pattern=mKeyboardTapVibePattern        break;
        case HapticFeedbackConstants.SAFE_MODE_DISABLED:
pattern=mSafeModeDisabledVibePattern        break;
        case HapticFeedbackConstants.SAFE_MODE_ENABLED:
pattern=mSafeModeEnabledVibePattern        break;
        default:
        boolean var68934A3E9455FA72420237EB05902327_1582688241 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313790380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313790380;
}        if(pattern.length==1)        
        {
mVibrator.vibrate(pattern[0])
        } //End block
        else
        {
mVibrator.vibrate(pattern, -1)
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1627538472 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433871646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433871646;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.042 -0400", hash_original_method = "46EBA00518A62FB02E8ED399D001CCD1", hash_generated_method = "8540C65134332F39102F6B1D9CCC556D")
    public void screenOnStartedLw() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.043 -0400", hash_original_method = "1839F2823BCC54A9D9AF53618B2288DB", hash_generated_method = "5A1F47A3E4C4F0044A07EBF6F09D71C7")
    public void screenOnStoppedLw() {
        if(mPowerManager.isScreenOn())        
        {
            if(!mKeyguardMediator.isShowingAndNotHidden())            
            {
                long curTime = SystemClock.uptimeMillis();
mPowerManager.userActivity(curTime, false, LocalPowerManager.OTHER_EVENT)
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mPowerManager.isScreenOn()) {
            //if (!mKeyguardMediator.isShowingAndNotHidden()) {
                //long curTime = SystemClock.uptimeMillis();
                //mPowerManager.userActivity(curTime, false, LocalPowerManager.OTHER_EVENT);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.044 -0400", hash_original_method = "14E9F7BC0A9564AA3949978730E04835", hash_generated_method = "CC7B533C32D1D4DD186B1FD7A2693BDD")
    public boolean allowKeyRepeat() {
        boolean var4A0844A47CFA2547D5A684C8B46E394F_1553668677 = (mScreenOnEarly);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485934456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485934456;
        // ---------- Original Method ----------
        //return mScreenOnEarly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.047 -0400", hash_original_method = "5C189A22BCA57C0F8ED98DD29FFA96E4", hash_generated_method = "2FAE9AFC87F44B79E4177FF63E5C086E")
    private int updateSystemUiVisibilityLw() {
        if(mFocusedWindow==null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_163075893 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979454089 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1979454089;
        } //End block
        final int visibility = mFocusedWindow.getSystemUiVisibility()
                & ~mResettingSystemUiFlags
                & ~mForceClearedSystemUiFlags;
        int diff = visibility ^ mLastSystemUiFlags;
        final boolean needsMenu = mFocusedWindow.getNeedsMenuLw(mTopFullscreenOpaqueWindowState);
        if(diff==0&&mLastFocusNeedsMenu==needsMenu&&mFocusedApp==mFocusedWindow.getAppToken())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_628583708 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555102582 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_555102582;
        } //End block
mLastSystemUiFlags=visibilitymLastFocusNeedsMenu=needsMenumFocusedApp=mFocusedWindow.getAppToken()mHandler.post(new Runnable()        {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.047 -0400", hash_original_method = "EB308DA07E83C047508711A320506992", hash_generated_method = "CD11AF0B79263AC0A7344B44EFFBBF45")
        public void run() {
            if(mStatusBarService==null)            
            {
mStatusBarService=IStatusBarService.Stub.asInterface(ServiceManager.getService("statusbar"))
            } //End block
            if(mStatusBarService!=null)            
            {
                try 
                {
mStatusBarService.setSystemUiVisibility(visibility)mStatusBarService.topAppWindowChanged(needsMenu)
                } //End block
                catch (RemoteException e)
                {
mStatusBarService=null
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (mStatusBarService == null) {
                        //mStatusBarService = IStatusBarService.Stub.asInterface(
                                //ServiceManager.getService("statusbar"));
                    //}
            //if (mStatusBarService != null) {
                        //try {
                            //mStatusBarService.setSystemUiVisibility(visibility);
                            //mStatusBarService.topAppWindowChanged(needsMenu);
                        //} catch (RemoteException e) {
                            //mStatusBarService = null;
                        //}
                    //}
        }
        }
)        int var2D2DEE7AF60385A060EAE7F556845A8B_1880785955 = (diff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727742711 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727742711;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.049 -0400", hash_original_method = "270EA33DC503FB82762F4A584D056514", hash_generated_method = "396379E4F34B27505E74ED2EEE2EE6BE")
    public boolean hasNavigationBar() {
        boolean varE41D2270EBE3E0CF5D3EFA13DCD2297F_1318895298 = (mHasNavigationBar);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461132254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461132254;
        // ---------- Original Method ----------
        //return mHasNavigationBar;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.053 -0400", hash_original_method = "4BC8313A2C048340348E26A9EB2A11F1", hash_generated_method = "1E00615851F163E6CE5DCEB71A60FC7C")
    public void dump(String prefix, FileDescriptor fd, PrintWriter pw, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(pw.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
pw.print(prefix)pw.print("mSafeMode=")pw.print(mSafeMode)pw.print(" mSystemReady=")pw.print(mSystemReady)pw.print(" mSystemBooted=")pw.println(mSystemBooted)pw.print(prefix)pw.print("mLidOpen=")pw.print(mLidOpen)pw.print(" mLidOpenRotation=")pw.print(mLidOpenRotation)pw.print(" mHdmiPlugged=")pw.println(mHdmiPlugged)        if(mLastSystemUiFlags!=0||mResettingSystemUiFlags!=0||mForceClearedSystemUiFlags!=0)        
        {
pw.print(prefix)pw.print("mLastSystemUiFlags=0x")pw.print(Integer.toHexString(mLastSystemUiFlags))pw.print(" mResettingSystemUiFlags=0x")pw.print(Integer.toHexString(mResettingSystemUiFlags))pw.print(" mForceClearedSystemUiFlags=0x")pw.println(Integer.toHexString(mForceClearedSystemUiFlags))
        } //End block
        if(mLastFocusNeedsMenu)        
        {
pw.print(prefix)pw.print("mLastFocusNeedsMenu=")pw.println(mLastFocusNeedsMenu)
        } //End block
pw.print(prefix)pw.print("mUiMode=")pw.print(mUiMode)pw.print(" mDockMode=")pw.print(mDockMode)pw.print(" mCarDockRotation=")pw.print(mCarDockRotation)pw.print(" mDeskDockRotation=")pw.println(mDeskDockRotation)pw.print(prefix)pw.print("mUserRotationMode=")pw.print(mUserRotationMode)pw.print(" mUserRotation=")pw.print(mUserRotation)pw.print(" mAllowAllRotations=")pw.println(mAllowAllRotations)pw.print(prefix)pw.print("mAccelerometerDefault=")pw.print(mAccelerometerDefault)pw.print(" mCurrentAppOrientation=")pw.println(mCurrentAppOrientation)pw.print(prefix)pw.print("mCarDockEnablesAccelerometer=")pw.print(mCarDockEnablesAccelerometer)pw.print(" mDeskDockEnablesAccelerometer=")pw.println(mDeskDockEnablesAccelerometer)pw.print(prefix)pw.print("mLidKeyboardAccessibility=")pw.print(mLidKeyboardAccessibility)pw.print(" mLidNavigationAccessibility=")pw.print(mLidNavigationAccessibility)pw.print(" mLongPressOnPowerBehavior=")pw.println(mLongPressOnPowerBehavior)pw.print(prefix)pw.print("mScreenOnEarly=")pw.print(mScreenOnEarly)pw.print(" mScreenOnFully=")pw.print(mScreenOnFully)pw.print(" mOrientationSensorEnabled=")pw.print(mOrientationSensorEnabled)pw.print(" mHasSoftInput=")pw.println(mHasSoftInput)pw.print(prefix)pw.print("mUnrestrictedScreen=(")pw.print(mUnrestrictedScreenLeft)pw.print(",")pw.print(mUnrestrictedScreenTop)pw.print(") ")pw.print(mUnrestrictedScreenWidth)pw.print("x")pw.println(mUnrestrictedScreenHeight)pw.print(prefix)pw.print("mRestrictedScreen=(")pw.print(mRestrictedScreenLeft)pw.print(",")pw.print(mRestrictedScreenTop)pw.print(") ")pw.print(mRestrictedScreenWidth)pw.print("x")pw.println(mRestrictedScreenHeight)pw.print(prefix)pw.print("mCur=(")pw.print(mCurLeft)pw.print(",")pw.print(mCurTop)pw.print(")-(")pw.print(mCurRight)pw.print(",")pw.print(mCurBottom)pw.println(")")pw.print(prefix)pw.print("mContent=(")pw.print(mContentLeft)pw.print(",")pw.print(mContentTop)pw.print(")-(")pw.print(mContentRight)pw.print(",")pw.print(mContentBottom)pw.println(")")pw.print(prefix)pw.print("mDock=(")pw.print(mDockLeft)pw.print(",")pw.print(mDockTop)pw.print(")-(")pw.print(mDockRight)pw.print(",")pw.print(mDockBottom)pw.println(")")pw.print(prefix)pw.print("mDockLayer=")pw.println(mDockLayer)pw.print(prefix)pw.print("mTopFullscreenOpaqueWindowState=")pw.println(mTopFullscreenOpaqueWindowState)pw.print(prefix)pw.print("mTopIsFullscreen=")pw.print(mTopIsFullscreen)pw.print(" mForceStatusBar=")pw.print(mForceStatusBar)pw.print(" mHideLockScreen=")pw.println(mHideLockScreen)pw.print(prefix)pw.print("mDismissKeyguard=")pw.print(mDismissKeyguard)pw.print(" mHomePressed=")pw.println(mHomePressed)pw.print(prefix)pw.print("mAllowLockscreenWhenOn=")pw.print(mAllowLockscreenWhenOn)pw.print(" mLockScreenTimeout=")pw.print(mLockScreenTimeout)pw.print(" mLockScreenTimerActive=")pw.println(mLockScreenTimerActive)pw.print(prefix)pw.print("mEndcallBehavior=")pw.print(mEndcallBehavior)pw.print(" mIncallPowerBehavior=")pw.print(mIncallPowerBehavior)pw.print(" mLongPressOnHomeBehavior=")pw.println(mLongPressOnHomeBehavior)pw.print(prefix)pw.print("mLandscapeRotation=")pw.print(mLandscapeRotation)pw.print(" mSeascapeRotation=")pw.println(mSeascapeRotation)pw.print(prefix)pw.print("mPortraitRotation=")pw.print(mPortraitRotation)pw.print(" mUpsideDownRotation=")pw.println(mUpsideDownRotation)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    class SettingsObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.055 -0400", hash_original_method = "63CDF656A8CAED22C90A5683F9F30A98", hash_generated_method = "B9872E8048205EC3DC872035379DAF9D")
          SettingsObserver(Handler handler) {
            super(handler);
            addTaint(handler.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.056 -0400", hash_original_method = "42B8F987A46F1F03AF4FF238D2CD995D", hash_generated_method = "7D90F34F09C550C7DD6EFD51D5198A9A")
         void observe() {
            ContentResolver resolver = mContext.getContentResolver();
resolver.registerContentObserver(Settings.System.getUriFor(Settings.System.END_BUTTON_BEHAVIOR), false, this)resolver.registerContentObserver(Settings.Secure.getUriFor(Settings.Secure.INCALL_POWER_BUTTON_BEHAVIOR), false, this)resolver.registerContentObserver(Settings.System.getUriFor(Settings.System.ACCELEROMETER_ROTATION), false, this)resolver.registerContentObserver(Settings.System.getUriFor(Settings.System.USER_ROTATION), false, this)resolver.registerContentObserver(Settings.System.getUriFor(Settings.System.SCREEN_OFF_TIMEOUT), false, this)resolver.registerContentObserver(Settings.System.getUriFor(Settings.System.WINDOW_ORIENTATION_LISTENER_LOG), false, this)resolver.registerContentObserver(Settings.System.getUriFor(Settings.System.POINTER_LOCATION), false, this)resolver.registerContentObserver(Settings.Secure.getUriFor(Settings.Secure.DEFAULT_INPUT_METHOD), false, this)resolver.registerContentObserver(Settings.System.getUriFor("fancy_rotation_anim"), false, this)updateSettings()
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.057 -0400", hash_original_method = "E40EE66170FCF9780C30DC8E20271E28", hash_generated_method = "506CAF4EE9EF6820A7E7CCD566C56220")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
updateSettings()updateRotation(false)
            // ---------- Original Method ----------
            //updateSettings();
            //updateRotation(false);
        }

        
    }


    
    class MyOrientationListener extends WindowOrientationListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.058 -0400", hash_original_method = "AD63E0913A78929EBCD6DC1105CE7924", hash_generated_method = "B4584A334A40CDB8BA62F4FA206BE5A5")
          MyOrientationListener(Context context) {
            super(context);
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.059 -0400", hash_original_method = "CF24CE8AF6711EC5AFB8A590AB522B75", hash_generated_method = "4D49A39B3D26C384AAEDAD73ED742D7F")
        @Override
        public void onProposedRotationChanged(int rotation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(rotation);
            if(localLOGV){ }updateRotation(false)
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "onProposedRotationChanged, rotation=" + rotation);
            //updateRotation(false);
        }

        
    }


    
    class PassHeadsetKey implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.060 -0400", hash_original_field = "5E8B578F842B6510E84BA438BC146C27", hash_generated_field = "D645AD22F39EA38698A47A2CA91BD334")

        KeyEvent mKeyEvent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.060 -0400", hash_original_method = "C608E282C153F88208F17528DA2E1B6B", hash_generated_method = "8552BE6834968488166D85CE0148F5BB")
          PassHeadsetKey(KeyEvent keyEvent) {
            addTaint(keyEvent.getTaint());
mKeyEvent=keyEvent
            // ---------- Original Method ----------
            //mKeyEvent = keyEvent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.061 -0400", hash_original_method = "601AAE5B38C30BABD15CF8ABE9DE157B", hash_generated_method = "08E67390B8810E1D34A6828EDDCD1A58")
        public void run() {
            if(ActivityManagerNative.isSystemReady())            
            {
                Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
intent.putExtra(Intent.EXTRA_KEY_EVENT, mKeyEvent)mContext.sendOrderedBroadcast(intent, null, mBroadcastDone, mHandler, Activity.RESULT_OK, null, null)
            } //End block
            // ---------- Original Method ----------
            //if (ActivityManagerNative.isSystemReady()) {
                //Intent intent = new Intent(Intent.ACTION_MEDIA_BUTTON, null);
                //intent.putExtra(Intent.EXTRA_KEY_EVENT, mKeyEvent);
                //mContext.sendOrderedBroadcast(intent, null, mBroadcastDone,
                        //mHandler, Activity.RESULT_OK, null, null);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.062 -0400", hash_original_field = "55219F40F20070D8D15ED26AFD1A6538", hash_generated_field = "527EE40A31E561EF0FFB6CC25D2FAF1B")

    static final String TAG = "WindowManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.063 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "F09208C088E716A2CD36A97B937BB5EA")

    static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.063 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "071B7B77A9473B9527F9198838C91D11")

    static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.063 -0400", hash_original_field = "AE79DA49EF1AFB43695F495E1C15BCEE", hash_generated_field = "A79CAFC8090665678020DD782183AE77")

    static final boolean DEBUG_LAYOUT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.063 -0400", hash_original_field = "90E1173F938E5A7325608EA8F4F8B37F", hash_generated_field = "DC5FBCB6E23D26C061BE22FB6378C6C9")

    static final boolean DEBUG_FALLBACK = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.064 -0400", hash_original_field = "C39479097F426051BC495807CABCED99", hash_generated_field = "EBFC7C428631713557C3F42B2C946218")

    static final boolean SHOW_STARTING_ANIMATIONS = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.064 -0400", hash_original_field = "A6DFC1D87E9A71F08FEFEE412E8AE34A", hash_generated_field = "8AED3E912AE5D6A21E4BAC847BC5673C")

    static final boolean SHOW_PROCESSES_ON_ALT_MENU = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.064 -0400", hash_original_field = "3638EC6C8D6D30015436808759AA5893", hash_generated_field = "F0F7F003ACF001FA136188E705B6F4A5")

    static final boolean ENABLE_CAR_DOCK_HOME_CAPTURE = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.064 -0400", hash_original_field = "9D3360AB98665F2053E0645D1E87BDAC", hash_generated_field = "5E9B6CD5E8D43459A2DB49954CAEE3A6")

    static final boolean ENABLE_DESK_DOCK_HOME_CAPTURE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.065 -0400", hash_original_field = "5F45732B689055DDC8A4B0117A6AC1D0", hash_generated_field = "50B0C977DF9DBB80314D8B458911700B")

    static final int LONG_PRESS_POWER_NOTHING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.065 -0400", hash_original_field = "EB0B6D3316A230CFFD33CF90243AFE59", hash_generated_field = "6E466D5F87F9773FC746D842DCA08A70")

    static final int LONG_PRESS_POWER_GLOBAL_ACTIONS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.065 -0400", hash_original_field = "2AABC3A80C042B3FE5FEDAD6E64C2274", hash_generated_field = "8B970903D00BBEF9D9D14AE3920993F2")

    static final int LONG_PRESS_POWER_SHUT_OFF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.065 -0400", hash_original_field = "D1E625D0A55D4FD6290C63D621663CC4", hash_generated_field = "180E03EC4F553A34E6A12BC844F543D2")

    static final int LONG_PRESS_HOME_NOTHING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.066 -0400", hash_original_field = "1900C4386634779C217A1DD5871C232E", hash_generated_field = "F854BA8AABB0747502950F74DD78825F")

    static final int LONG_PRESS_HOME_RECENT_DIALOG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.066 -0400", hash_original_field = "837551A33A67CFDD786516743A5FBD9E", hash_generated_field = "FB62FE70017A06C2E8E2C0F8BED54A9C")

    static final int LONG_PRESS_HOME_RECENT_SYSTEM_UI = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.066 -0400", hash_original_field = "EDE0CB6F07D5D0206B8CD09749DEA8DF", hash_generated_field = "51D19D7366AFA172BFCAA60543EB2BED")

    static final int WALLPAPER_LAYER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.066 -0400", hash_original_field = "39037DD315C671E35ABE83CF8DE12090", hash_generated_field = "1FAC12982FDA9EAD446F656EACFE89C4")

    static final int APPLICATION_LAYER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "0A176A38C5EDE283B65B0C80B823C58D", hash_generated_field = "38073B202309ED177B11CA3EA2EEE9BF")

    static final int PHONE_LAYER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "7C6BA30C95C51B8205818BD47150BB12", hash_generated_field = "7096F1FE3A96BC65CFBF2F4BC8E9386A")

    static final int SEARCH_BAR_LAYER = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "97F23085AD3208554FB44A6BA6B4B9B2", hash_generated_field = "E5F56528446CFA00E9B26143B8786D6F")

    static final int SYSTEM_DIALOG_LAYER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "4CD43A802EFE36C94617E10C33F04BB0", hash_generated_field = "3CD0842293A494758280ECC676E3AA51")

    static final int TOAST_LAYER = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "C19CBB4753E4136DB7C1C87B34F8078A", hash_generated_field = "2C8DB1BDB0BAB53881A5C763A64C7061")

    static final int PRIORITY_PHONE_LAYER = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "E8AA85D31A5F042D63CBC73C15B8D5A4", hash_generated_field = "CE3EC65A956CBFAD5FA98BAEFA7FA671")

    static final int SYSTEM_ALERT_LAYER = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "032D0B7C2BF8C611CFC8485E0E4978A7", hash_generated_field = "39227639635A05BD79A15C7B7DED163F")

    static final int INPUT_METHOD_LAYER = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.067 -0400", hash_original_field = "7A8A447F49875BAE5F7041F4A51373F2", hash_generated_field = "54300AB974DC63C3D66145A87065D258")

    static final int INPUT_METHOD_DIALOG_LAYER = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "889DB3BD56673286BD22B03761444975", hash_generated_field = "F9FED0AA4B1CDE62ADDD15CF38BE8314")

    static final int KEYGUARD_LAYER = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "87B5465F65B13256110BEFE52760F799", hash_generated_field = "2D8B901ED453D408BD48F53E15910699")

    static final int KEYGUARD_DIALOG_LAYER = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "12F8EEDF57D04158795EA963908FF360", hash_generated_field = "B347BD861935F48A7320A08B3F79844B")

    static final int STATUS_BAR_SUB_PANEL_LAYER = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "D46FDCE55CD362D232E3F7E4FF82939B", hash_generated_field = "8F09BBD742CB81ABC1BDB6378118197A")

    static final int STATUS_BAR_LAYER = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "24FD472AD5C56AA8336CA54229BF14EE", hash_generated_field = "FA5DA1B15C6D1FA04F9F91FD089CD14A")

    static final int STATUS_BAR_PANEL_LAYER = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "9C78E64ACD1DA117A06011B76538F7EE", hash_generated_field = "C6C968CB603B3BC099ADAB81D11CE6C7")

    static final int VOLUME_OVERLAY_LAYER = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "59B0E35B9DB39D09E017B7976D5905EE", hash_generated_field = "6B475486CF8F83CB29D300CEADB4AB3D")

    static final int SYSTEM_OVERLAY_LAYER = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.068 -0400", hash_original_field = "853B49722F06B2F131604F094D22B238", hash_generated_field = "0F310E838D370D8FBBE6359523A1E191")

    static final int NAVIGATION_BAR_LAYER = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.069 -0400", hash_original_field = "DBE00C70D4FAFF59194983853CB9D7DC", hash_generated_field = "0CD0CED9CF79C596EF47D96C42A610CB")

    static final int SYSTEM_ERROR_LAYER = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.069 -0400", hash_original_field = "2343A0707C16941AC5A711D283F9718B", hash_generated_field = "BBF99549CFE036252C91425D2BFCCAF8")

    static final int DRAG_LAYER = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.069 -0400", hash_original_field = "C7172FDBDA7D84C601BCEC2AB38ED9C9", hash_generated_field = "CD07E5C35C837D33CC505876031A39E2")

    static final int SECURE_SYSTEM_OVERLAY_LAYER = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.069 -0400", hash_original_field = "9F5F56A878FA57B84ED41A723DF7FB38", hash_generated_field = "16A74D3E0A649C37C6644CAB4678DACA")

    static final int BOOT_PROGRESS_LAYER = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.069 -0400", hash_original_field = "5241D92BB2535670D031FC7BACC8318D", hash_generated_field = "CEFBD640CBFFC5704F06F9CBF23C5D98")

    static final int POINTER_LAYER = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.069 -0400", hash_original_field = "05CCCC6D49C973C47214413ADB968477", hash_generated_field = "DB968EC7404685E1362A0FB5E4D91A83")

    static final int HIDDEN_NAV_CONSUMER_LAYER = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.070 -0400", hash_original_field = "A3592FB9255A0EAA58F9F27D7A8FB8E9", hash_generated_field = "DAAA0F64FF125C909C21D4CABC3A02AD")

    static final int APPLICATION_MEDIA_SUBLAYER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.070 -0400", hash_original_field = "A3851332E75BAAE939CBC9E62D0C39F7", hash_generated_field = "0007B858E820941D1E6D0000ACA056E5")

    static final int APPLICATION_MEDIA_OVERLAY_SUBLAYER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.070 -0400", hash_original_field = "98D9B33037CAA33B710EF7D79248BE2A", hash_generated_field = "97A1A9B50731D08150A3E24A5FF9B411")

    static final int APPLICATION_PANEL_SUBLAYER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.070 -0400", hash_original_field = "1F349056BCC7B7D9FB01C93674126C73", hash_generated_field = "E1172A521902854BC1855F52A898B6DE")

    static final int APPLICATION_SUB_PANEL_SUBLAYER = 2;

