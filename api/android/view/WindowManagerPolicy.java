package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.Rect;
import android.view.animation.Animation;
import android.os.IBinder;
import android.graphics.RectF;
import android.os.LocalPowerManager;
import java.io.PrintWriter;
import android.content.res.CompatibilityInfo;
import android.content.Context;
import android.os.Looper;
import java.io.FileDescriptor;
import android.content.res.Configuration;
public interface WindowManagerPolicy {
    
    public final static int FLAG_WAKE = 0x00000001;
    public final static int FLAG_WAKE_DROPPED = 0x00000002;
    public final static int FLAG_SHIFT = 0x00000004;
    public final static int FLAG_CAPS_LOCK = 0x00000008;
    public final static int FLAG_ALT = 0x00000010;
    public final static int FLAG_ALT_GR = 0x00000020;
    public final static int FLAG_MENU = 0x00000040;
    public final static int FLAG_LAUNCHER = 0x00000080;
    public final static int FLAG_VIRTUAL = 0x00000100;

    public final static int FLAG_INJECTED = 0x01000000;
    public final static int FLAG_TRUSTED = 0x02000000;
    public final static int FLAG_FILTERED = 0x04000000;
    public final static int FLAG_DISABLE_KEY_REPEAT = 0x08000000;

    public final static int FLAG_WOKE_HERE = 0x10000000;
    public final static int FLAG_BRIGHT_HERE = 0x20000000;
    public final static int FLAG_PASS_TO_USER = 0x40000000;

    public final static boolean WATCH_POINTER = false;

    
    public final static String ACTION_HDMI_PLUGGED = "android.intent.action.HDMI_PLUGGED";

    
    public final static String EXTRA_HDMI_PLUGGED_STATE = "state";

    
    public final static int ACTION_PASS_TO_USER = 0x00000001;

    
    public final static int ACTION_POKE_USER_ACTIVITY = 0x00000002;

    
    public final static int ACTION_GO_TO_SLEEP = 0x00000004;

    
    public interface WindowState {
        
        public void computeFrameLw(Rect parentFrame, Rect displayFrame,
                Rect contentFrame, Rect visibleFrame);

        
        public Rect getFrameLw();

        
        public RectF getShownFrameLw();

        
        public Rect getDisplayFrameLw();

        
        public Rect getContentFrameLw();

        
        public Rect getVisibleFrameLw();

        
        public boolean getGivenInsetsPendingLw();
        
        
        public Rect getGivenContentInsetsLw();

        
        public Rect getGivenVisibleInsetsLw();

        
        public WindowManager.LayoutParams getAttrs();

        
        public boolean getNeedsMenuLw(WindowState bottom);

        
        public int getSystemUiVisibility();

        
        public int getSurfaceLayer();
        
        
        public IApplicationToken getAppToken();

        
        public boolean hasAppShownWindows();

        
        boolean isVisibleLw();
        
        
        boolean isVisibleOrBehindKeyguardLw();
        
        
        boolean isDisplayedLw();

        
        public boolean hasDrawnLw();

        
        public boolean hideLw(boolean doAnimation);
        
        
        public boolean showLw(boolean doAnimation);
    }

    
    public interface FakeWindow {
        
        void dismiss();
    }

    
    public interface WindowManagerFuncs {
        
        public void reevaluateStatusBarVisibility();

        
        public FakeWindow addFakeWindow(Looper looper, InputHandler inputHandler,
                String name, int windowType, int layoutParamsFlags, boolean canReceiveKeys,
                boolean hasFocus, boolean touchFullscreen);
    }

    
    public final int TRANSIT_ENTER_MASK = 0x1000;
    
    
    public final int TRANSIT_EXIT_MASK = 0x2000;
    
    
    public final int TRANSIT_UNSET = -1;
    
    public final int TRANSIT_NONE = 0;
    
    public final int TRANSIT_ENTER = 1 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_EXIT = 2 | TRANSIT_EXIT_MASK;
    
    public final int TRANSIT_SHOW = 3 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_HIDE = 4 | TRANSIT_EXIT_MASK;
    
    public final int TRANSIT_PREVIEW_DONE = 5;
    
    public final int TRANSIT_ACTIVITY_OPEN = 6 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_ACTIVITY_CLOSE = 7 | TRANSIT_EXIT_MASK;
    
    public final int TRANSIT_TASK_OPEN = 8 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_TASK_CLOSE = 9 | TRANSIT_EXIT_MASK;
    
    public final int TRANSIT_TASK_TO_FRONT = 10 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_TASK_TO_BACK = 11 | TRANSIT_EXIT_MASK;
    
    public final int TRANSIT_WALLPAPER_CLOSE = 12 | TRANSIT_EXIT_MASK;
    
    public final int TRANSIT_WALLPAPER_OPEN = 13 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_WALLPAPER_INTRA_OPEN = 14 | TRANSIT_ENTER_MASK;
    
    public final int TRANSIT_WALLPAPER_INTRA_CLOSE = 15 | TRANSIT_EXIT_MASK;
    
    
    
    
    
    public final int OFF_BECAUSE_OF_ADMIN = 1;
    
    public final int OFF_BECAUSE_OF_USER = 2;
    
    public final int OFF_BECAUSE_OF_TIMEOUT = 3;
    
    public final int OFF_BECAUSE_OF_PROX_SENSOR = 4;

    
    public final int USER_ROTATION_FREE = 0;
    
    public final int USER_ROTATION_LOCKED = 1;
    
    
    public void init(Context context, IWindowManager windowManager,
            WindowManagerFuncs windowManagerFuncs,
            LocalPowerManager powerManager);

    
    public void setInitialDisplaySize(int width, int height);

    
    public int checkAddPermission(WindowManager.LayoutParams attrs);

    
    public void adjustWindowParamsLw(WindowManager.LayoutParams attrs);
    
    
    public void adjustConfigurationLw(Configuration config);
    
    
    public int windowTypeToLayerLw(int type);

    
    public int subWindowTypeToLayerLw(int type);

    
    public int getMaxWallpaperLayer();
    
    
    public boolean canStatusBarHide();

    
    public int getNonDecorDisplayWidth(int fullWidth, int fullHeight, int rotation);

    
    public int getNonDecorDisplayHeight(int fullWidth, int fullHeight, int rotation);

    
    public int getConfigDisplayWidth(int fullWidth, int fullHeight, int rotation);

    
    public int getConfigDisplayHeight(int fullWidth, int fullHeight, int rotation);

    
    public boolean doesForceHide(WindowState win, WindowManager.LayoutParams attrs);
    
    
    public boolean canBeForceHidden(WindowState win, WindowManager.LayoutParams attrs);
    
    
    public View addStartingWindow(IBinder appToken, String packageName,
            int theme, CompatibilityInfo compatInfo, CharSequence nonLocalizedLabel,
            int labelRes, int icon, int windowFlags);

    
    public void removeStartingWindow(IBinder appToken, View window);

    
    public int prepareAddWindowLw(WindowState win,
            WindowManager.LayoutParams attrs);

    
    public void removeWindowLw(WindowState win);

    
    public int selectAnimationLw(WindowState win, int transit);

    
    public Animation createForceHideEnterAnimation();
    
    
    public int interceptKeyBeforeQueueing(KeyEvent event, int policyFlags, boolean isScreenOn);

    
    public int interceptMotionBeforeQueueingWhenScreenOff(int policyFlags);

    
    public long interceptKeyBeforeDispatching(WindowState win, KeyEvent event, int policyFlags);

    
    public KeyEvent dispatchUnhandledKey(WindowState win, KeyEvent event, int policyFlags);

    
    public void beginLayoutLw(int displayWidth, int displayHeight, int displayRotation);

    
    public void layoutWindowLw(WindowState win,
            WindowManager.LayoutParams attrs, WindowState attached);

    
    
    public void getContentInsetHintLw(WindowManager.LayoutParams attrs, Rect contentInset);
    
    
    public int finishLayoutLw();

    
    static final int FINISH_LAYOUT_REDO_LAYOUT = 0x0001;
    
    static final int FINISH_LAYOUT_REDO_CONFIG = 0x0002;
    
    static final int FINISH_LAYOUT_REDO_WALLPAPER = 0x0004;
    
    static final int FINISH_LAYOUT_REDO_ANIM = 0x0008;
    
    
    public void beginAnimationLw(int displayWidth, int displayHeight);

    
    public void animatingWindowLw(WindowState win,
            WindowManager.LayoutParams attrs);

    
    public int finishAnimationLw();

    
    public boolean allowAppAnimationsLw();


    
    public int focusChangedLw(WindowState lastFocus, WindowState newFocus);
    
    
    public void screenTurnedOff(int why);

    public interface ScreenOnListener {
        void onScreenOn();
    };

    
    public void screenTurningOn(ScreenOnListener screenOnListener);

    
    public boolean isScreenOnEarly();

    
    public boolean isScreenOnFully();

    
    public void notifyLidSwitchChanged(long whenNanos, boolean lidOpen);
    
    
    public void enableKeyguard(boolean enabled);

    
    interface OnKeyguardExitResult {
        void onKeyguardExitResult(boolean success);
    }

    
    void exitKeyguardSecurely(OnKeyguardExitResult callback);

    
    public boolean isKeyguardLocked();

    
    public boolean isKeyguardSecure();

    
    public boolean inKeyguardRestrictedKeyInputMode();

    
    public void dismissKeyguardLw();

    
    public int rotationForOrientationLw(int orientation, int lastRotation);

    
    public boolean rotationHasCompatibleMetricsLw(int orientation, int rotation);

    
    public void setRotationLw(int rotation);

    
    public boolean detectSafeMode();
    
    
    public void systemReady();

    
    public void systemBooted();

    
    public void showBootMessage(final CharSequence msg, final boolean always);

    
    public void hideBootMessages();

    
    public void userActivity();

    
    public void enableScreenAfterBoot();
    
    public void setCurrentOrientationLw(int newOrientation);
    
    
    public boolean performHapticFeedbackLw(WindowState win, int effectId, boolean always);
    
    
    public void screenOnStartedLw();

    
    public void screenOnStoppedLw();

    
    public boolean allowKeyRepeat();

    
    public void setUserRotationMode(int mode, int rotation);

    
    public int adjustSystemUiVisibilityLw(int visibility);

    
    public boolean hasNavigationBar();

    
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);
}
