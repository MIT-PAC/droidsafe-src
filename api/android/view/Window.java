package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemProperties;
import android.view.accessibility.AccessibilityEvent;

public abstract class Window {
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    static CompatibilityInfoHolder getCompatInfo(Context context) {
    	CompatibilityInfoHolder retVal;
        Application app = (Application)context.getApplicationContext();
        retVal = app != null ? app.mLoadedApk.mCompatibilityInfo : new CompatibilityInfoHolder();
        retVal.addTaint(context.getTaint());
        return retVal;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.519 -0500", hash_original_field = "32164F5F2C88C3946BA0CED41FA6D42F", hash_generated_field = "472DA983306B223D5089DE41C6B304F6")

    public static final int FEATURE_OPTIONS_PANEL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.522 -0500", hash_original_field = "DDDC7C6104CC3B76505D78224CBE2775", hash_generated_field = "0E27D3969BF23D79444C083F69CE913B")

    public static final int FEATURE_NO_TITLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.525 -0500", hash_original_field = "93111DAE5CA55B45E67B159869507D5F", hash_generated_field = "C56DCBD5961394440275C325C5322980")

    public static final int FEATURE_PROGRESS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.528 -0500", hash_original_field = "8E11A046758589DA7F08A55141EA33E0", hash_generated_field = "1A609527E6D52575F7BB34AA94FA5452")

    public static final int FEATURE_LEFT_ICON = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.531 -0500", hash_original_field = "8188526FC05048CE31A351DFC5746A31", hash_generated_field = "1950720A14827F199C723E292C8843CB")

    public static final int FEATURE_RIGHT_ICON = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.533 -0500", hash_original_field = "CC1260D333A941C33AADA534DB43C60F", hash_generated_field = "A0820169C7BD3B2ADEF3346DA41635B2")

    public static final int FEATURE_INDETERMINATE_PROGRESS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.536 -0500", hash_original_field = "AA065878468B78C597A389741E5EBEB4", hash_generated_field = "330D7D49F8F1B757C106B92F0683EDB7")

    public static final int FEATURE_CONTEXT_MENU = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.539 -0500", hash_original_field = "2AFD794F3BAEF16AEFBC53B1BC79FC0A", hash_generated_field = "DECB0F3E1BE49983D78AAF2637ECB72D")

    public static final int FEATURE_CUSTOM_TITLE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.542 -0500", hash_original_field = "4A9C9A63F6241452E3E13E0FA0F9E3C3", hash_generated_field = "C443D1CC878B321D84BA4ED206191978")

    public static final int FEATURE_ACTION_BAR = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.545 -0500", hash_original_field = "B81ADB63AF93F524E2F7E58B47C1567C", hash_generated_field = "136B78431D739532A1C4A86F966210BE")

    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.548 -0500", hash_original_field = "F6967A7C2A88F7DC630306017B52F74C", hash_generated_field = "691774D2B2F1BBA031D2D45979BFB0DE")

    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.552 -0500", hash_original_field = "534BBA912B21C076B9C3CD575039FCAD", hash_generated_field = "9D38CA915D3E74CA2094BA5902BED0B2")

    public static final int PROGRESS_VISIBILITY_ON = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.554 -0500", hash_original_field = "B6B2BAF27D9E11FB96A36F54DDC57F34", hash_generated_field = "5D4C8296C206C08EA35B814522DD9983")

    public static final int PROGRESS_VISIBILITY_OFF = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.558 -0500", hash_original_field = "634E81C863EF0AFA0AF86147602C93DF", hash_generated_field = "1877511F5796C123D37BB3D39E902341")

    public static final int PROGRESS_INDETERMINATE_ON = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.561 -0500", hash_original_field = "C7566D65C70B1857D225F12DEA2DC6F0", hash_generated_field = "68E36EAEDD10C796D1EA6ADEF387DFC2")

    public static final int PROGRESS_INDETERMINATE_OFF = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.563 -0500", hash_original_field = "4B91C5E42A1BB6DD42D97647B6BC7E89", hash_generated_field = "8A8B490338B3753D82CBEEAAB64BD7CA")

    public static final int PROGRESS_START = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.566 -0500", hash_original_field = "E5F405F048676ABF4B6BEF3DF55C28D3", hash_generated_field = "40A0B7325B8605AF6527271642B9A30A")

    public static final int PROGRESS_END = 10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.568 -0500", hash_original_field = "7C73DE83BE622D84C3192961597718DE", hash_generated_field = "5F723C725C29E1DA5AF89AB3DD752716")

    public static final int PROGRESS_SECONDARY_START = 20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.572 -0500", hash_original_field = "1CD748B0A71856781DE1D03A8A052C3C", hash_generated_field = "CC459F31B753B125143BA79C6808282B")

    public static final int PROGRESS_SECONDARY_END = 30000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.575 -0500", hash_original_field = "07D2DE56DE72171FE628028FAD74D848", hash_generated_field = "9C42AD869F8A2C22203ED8B37C7EB793")

    @SuppressWarnings({"PointlessBitwiseExpression"})
    protected static final int DEFAULT_FEATURES = (1 << FEATURE_OPTIONS_PANEL) |
            (1 << FEATURE_CONTEXT_MENU);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.578 -0500", hash_original_field = "2EC946D433E4C4615352D6B45A240DCD", hash_generated_field = "93F6ACF9E071115D7CCE648A911B5392")

    public static final int ID_ANDROID_CONTENT = com.android.internal.R.id.content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.581 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.583 -0500", hash_original_field = "62D55BD845189080E97B5CD6967737ED", hash_generated_field = "FE42DB9D5DCA1AF8D89775C484584DA0")
    
    private TypedArray mWindowStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.586 -0500", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.589 -0500", hash_original_field = "83A062836C11DD52DC32F4325712F233", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.591 -0500", hash_original_field = "72D49B42BD8B7296305C5E2D109BB407", hash_generated_field = "BB83A73F1EDDB2848C32920D653DC06A")

    private IBinder mAppToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.593 -0500", hash_original_field = "FF6B21A219020E404C24F9D91876FDAC", hash_generated_field = "501107DCDCDE4B64DECA2D54F1B3291E")

    private String mAppName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.596 -0500", hash_original_field = "1775672197EE92B91DE4188D3D1D762E", hash_generated_field = "4CDA12FC009B8C79FD6D240C994A9B4E")

    private Window mContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.598 -0500", hash_original_field = "C7C14F9134C1C0BD4109E0B031515497", hash_generated_field = "DAACFEA6BDA9FDD8068D4E47DE036B80")

    private Window mActiveChild;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.601 -0500", hash_original_field = "C120A51E7DE48D58AEF52C0CF79EB17F", hash_generated_field = "4A15BC690E6A07E466E1CFFEE049FB44")

    private boolean mIsActive = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.603 -0500", hash_original_field = "85665B0B7F2A30AE7FC95FF48C9FF2BC", hash_generated_field = "AE99BD7E76B07B1A3DB18B1673132924")

    private boolean mHasChildren = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.605 -0500", hash_original_field = "CD8256286262F365D95E85FC89ACA0CB", hash_generated_field = "6682B7CD42017C622EC5F9455D0BBBB5")

    private boolean mCloseOnTouchOutside = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.607 -0500", hash_original_field = "F8100DFCE473356820DB7371107F482F", hash_generated_field = "913E6AEF20F2BF812FF1E6B4367E9661")

    private boolean mSetCloseOnTouchOutside = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.610 -0500", hash_original_field = "42EEE6C1F7C8178D03108715AAD41F4E", hash_generated_field = "1D791569E1CBBFE45EC5118F952AEEB8")

    private int mForcedWindowFlags = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.613 -0500", hash_original_field = "2CA8A535EE115D924568340E7B63F534", hash_generated_field = "8DD2F8572C71CE50B81F1050762E8D15")

    private int mFeatures = DEFAULT_FEATURES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.616 -0500", hash_original_field = "3BD5D0DC9811AA66D3A5E1CD5B164BB7", hash_generated_field = "8F439E32EE732AE863B494C6265A86B0")

    private int mLocalFeatures = DEFAULT_FEATURES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.618 -0500", hash_original_field = "D027A5D997BA49DFC4DE2A50E4E7E316", hash_generated_field = "68BCF9C876C3A5A4265478D3D60D9E88")

    private boolean mHaveWindowFormat = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.620 -0500", hash_original_field = "4CC9C7E412BDF87F6FEB2F19B0B11593", hash_generated_field = "08A6E705463382C516C1DE51AD82637F")

    private boolean mHaveDimAmount = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.623 -0500", hash_original_field = "C096C7820B9590EFFE866C639CC4579B", hash_generated_field = "D05EC1E75FF8953CFD3364A5A03E7B08")

    private int mDefaultWindowFormat = PixelFormat.OPAQUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.625 -0500", hash_original_field = "2A6C51158B59E4799002B25D5C92C03A", hash_generated_field = "0B8978AD19103B60226718E5263B1651")

    private boolean mHasSoftInputMode = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.627 -0500", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")
    
    private boolean mDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.630 -0500", hash_original_field = "D292E6945091564B50F91497CC02D2E3", hash_generated_field = "7F9A9896CA9A2F1A549BC7CFD23C8D28")

    private final WindowManager.LayoutParams mWindowAttributes =
        new WindowManager.LayoutParams();

    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.640 -0500", hash_original_method = "50ED378DEE1AF31F505AB3EFDADA9166", hash_generated_method = "32C9EF35DB9FD5BC71C6F81F3A4479CB")
    
public Window(Context context) {
        mContext = context;
    }

    /**
     * Return the Context this window policy is running in, for retrieving
     * resources and other information.
     *
     * @return Context The Context that was supplied to the constructor.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.643 -0500", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DDB999668EFCAD36DFA58D5D665B592E")
    
public final Context getContext() {
        return mContext;
    }

    /**
     * Return the {@link android.R.styleable#Window} attributes from this
     * window's theme.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.645 -0500", hash_original_method = "F2F0D9C02E357CB8D6CDE50C6B929622", hash_generated_method = "95D02BA30E4563A49977A7C5D6C3433D")
    
public final TypedArray getWindowStyle() {
        synchronized (this) {
            if (mWindowStyle == null) {
                mWindowStyle = mContext.obtainStyledAttributes(
                        com.android.internal.R.styleable.Window);
            }
            return mWindowStyle;
        }
    }
    
    /**
     * Set the container for this window.  If not set, the DecorWindow
     * operates as a top-level window; otherwise, it negotiates with the
     * container to display itself appropriately.
     *
     * @param container The desired containing Window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.648 -0500", hash_original_method = "8852F0C837DC7060948A60A90C2A9042", hash_generated_method = "C915C4C2996F07D15B77E49361B7201D")
    
public void setContainer(Window container) {
        mContainer = container;
        if (container != null) {
            // Embedded screens never have a title.
            mFeatures |= 1<<FEATURE_NO_TITLE;
            mLocalFeatures |= 1<<FEATURE_NO_TITLE;
            container.mHasChildren = true;
        }
    }

    /**
     * Return the container for this Window.
     *
     * @return Window The containing window, or null if this is a
     *         top-level window.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.650 -0500", hash_original_method = "DCCDF946CE22DD9064205FD95E96DECD", hash_generated_method = "E5037941C1C854578D58E7795830D99D")
    
public final Window getContainer() {
        return mContainer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.652 -0500", hash_original_method = "E436A7964E92BE677F4D553F3B295F27", hash_generated_method = "C6A7D1145010786B461D1C4A925E6EB2")
    
public final boolean hasChildren() {
        return mHasChildren;
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.661 -0500", hash_original_method = "66C6B9EE658776AAE6ED0A2EE9CF8E48", hash_generated_method = "97DCA33F37F03E23CF3AA888FC4404C7")
    
public final void destroy() {
        mDestroyed = true;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.664 -0500", hash_original_method = "36E279B4F2F5FC702C91E645725B1821", hash_generated_method = "9EEC1C89D5057237817BB38BA003A8EE")
    
public final boolean isDestroyed() {
        return mDestroyed;
    }

    /**
     * Set the window manager for use by this Window to, for example,
     * display panels.  This is <em>not</em> used for displaying the
     * Window itself -- that must be done by the client.
     *
     * @param wm The ViewManager for adding new windows.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.667 -0500", hash_original_method = "49C37E5CFC1C233E6DF0E927E49CABF4", hash_generated_method = "ACF58D7384A6A4C76F5B2E34722A8F62")
    
public void setWindowManager(WindowManager wm, IBinder appToken, String appName) {
        setWindowManager(wm, appToken, appName, false);
    }

    /**
     * Set the window manager for use by this Window to, for example,
     * display panels.  This is <em>not</em> used for displaying the
     * Window itself -- that must be done by the client.
     *
     * @param wm The ViewManager for adding new windows.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.669 -0500", hash_original_method = "07A6DAE3F5C8016383AB9A64DB3A39A3", hash_generated_method = "A7E33978AEAFD473593AEA8D4E8E796A")
    
public void setWindowManager(WindowManager wm, IBinder appToken, String appName,
            boolean hardwareAccelerated) {
        mAppToken = appToken;
        mAppName = appName;
        if (wm == null) {
            wm = WindowManagerImpl.getDefault();
        }
        mWindowManager = new LocalWindowManager(wm, hardwareAccelerated);
    }

    /**
     * Return the window manager allowing this Window to display its own
     * windows.
     *
     * @return WindowManager The ViewManager.
     */
    @DSComment("Android Manager retrieved/accessed")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.692 -0500", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "0C79B12DA4736ABBDC4EC55B1426644A")
    
public WindowManager getWindowManager() {
        return mWindowManager;
    }

    /**
     * Set the Callback interface for this window, used to intercept key
     * events and other dynamic operations in the window.
     *
     * @param callback The desired Callback interface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.694 -0500", hash_original_method = "DD1DEB01F922CA329B6B6BD86F551D46", hash_generated_method = "5615805491ED61938F7759B1973A8A9C")
    
public void setCallback(Callback callback) {
        mCallback = callback;
    }

    /**
     * Return the current Callback interface for this window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.697 -0500", hash_original_method = "F07002384A5D5C29596645EE02BC1965", hash_generated_method = "4DB162AD74090EDDED8FC1B6B98EF150")
    
public final Callback getCallback() {
        return mCallback;
    }

    /**
     * Take ownership of this window's surface.  The window's view hierarchy
     * will no longer draw into the surface, though it will otherwise continue
     * to operate (such as for receiving input events).  The given SurfaceHolder
     * callback will be used to tell you about state changes to the surface.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.699 -0500", hash_original_method = "A5E049B033A02DB442210D734E4A791B", hash_generated_method = "B9795F506ED7121B0198CF5DD36E4C32")
    
public abstract void takeSurface(SurfaceHolder.Callback2 callback);
    
    /**
     * Take ownership of this window's InputQueue.  The window will no
     * longer read and dispatch input events from the queue; it is your
     * responsibility to do so.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.701 -0500", hash_original_method = "CE435DE7D655DD4B3E095367266A5892", hash_generated_method = "1E3AE335144C6D4295AEFD7D61883D72")
    
public abstract void takeInputQueue(InputQueue.Callback callback);
    
    /**
     * Return whether this window is being displayed with a floating style
     * (based on the {@link android.R.attr#windowIsFloating} attribute in
     * the style/theme).
     *
     * @return Returns true if the window is configured to be displayed floating
     * on top of whatever is behind it.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.703 -0500", hash_original_method = "DC8EB6738801C481B4EE73E5DB010C0B", hash_generated_method = "C5D94EC02DADE54137B266373C99D648")
    
public abstract boolean isFloating();

    /**
     * Set the width and height layout parameters of the window.  The default
     * for both of these is MATCH_PARENT; you can change them to WRAP_CONTENT
     * or an absolute value to make a window that is not full-screen.
     *
     * @param width The desired layout width of the window.
     * @param height The desired layout height of the window.
     *
     * @see ViewGroup.LayoutParams#height
     * @see ViewGroup.LayoutParams#width
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.706 -0500", hash_original_method = "BDF4A9191EC276CB59743DF4E4B8A744", hash_generated_method = "E2F8F32EF8BFCBF61E5E552E01071180")
    
public void setLayout(int width, int height) {
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.width = width;
        attrs.height = height;
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Set the gravity of the window, as per the Gravity constants.  This
     * controls how the window manager is positioned in the overall window; it
     * is only useful when using WRAP_CONTENT for the layout width or height.
     *
     * @param gravity The desired gravity constant.
     *
     * @see Gravity
     * @see #setLayout
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.709 -0500", hash_original_method = "76A69B8FD04E6A39E52E254D3C51CA75", hash_generated_method = "F4D072DF86135354A573AF2B10CD9E6D")
    
public void setGravity(int gravity)
    {
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.gravity = gravity;
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Set the type of the window, as per the WindowManager.LayoutParams
     * types.
     *
     * @param type The new window type (see WindowManager.LayoutParams).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.711 -0500", hash_original_method = "07612A9950A1C7129B1F4B699CE0FA52", hash_generated_method = "B26B3223DA48497C1EA7C6DC8CD41C67")
    
public void setType(int type) {
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.type = type;
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Set the format of window, as per the PixelFormat types.  This overrides
     * the default format that is selected by the Window based on its
     * window decorations.
     *
     * @param format The new window format (see PixelFormat).  Use
     *               PixelFormat.UNKNOWN to allow the Window to select
     *               the format.
     *
     * @see PixelFormat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.714 -0500", hash_original_method = "ADD82385ADE43D8CE9305C2F63E34252", hash_generated_method = "1D66B199B5B9499EFD5F4F6AA78D2275")
    
public void setFormat(int format) {
        final WindowManager.LayoutParams attrs = getAttributes();
        if (format != PixelFormat.UNKNOWN) {
            attrs.format = format;
            mHaveWindowFormat = true;
        } else {
            attrs.format = mDefaultWindowFormat;
            mHaveWindowFormat = false;
        }
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Specify custom animations to use for the window, as per
     * {@link WindowManager.LayoutParams#windowAnimations
     * WindowManager.LayoutParams.windowAnimations}.  Providing anything besides
     * 0 here will override the animations the window would
     * normally retrieve from its theme.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.716 -0500", hash_original_method = "4617417E681280CCA3448C5B912BCD7D", hash_generated_method = "69164DB609B64EC08D9A345D8DDE6B2D")
    
public void setWindowAnimations(int resId) {
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.windowAnimations = resId;
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Specify an explicit soft input mode to use for the window, as per
     * {@link WindowManager.LayoutParams#softInputMode
     * WindowManager.LayoutParams.softInputMode}.  Providing anything besides
     * "unspecified" here will override the input mode the window would
     * normally retrieve from its theme.
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.719 -0500", hash_original_method = "C4620B459A4A0F6C7D91CF9A478EC82D", hash_generated_method = "68F1B142EA49D217FB23E63225B18818")
    
public void setSoftInputMode(int mode) {
        final WindowManager.LayoutParams attrs = getAttributes();
        if (mode != WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
            attrs.softInputMode = mode;
            mHasSoftInputMode = true;
        } else {
            mHasSoftInputMode = false;
        }
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }
    
    /**
     * Convenience function to set the flag bits as specified in flags, as
     * per {@link #setFlags}.
     * @param flags The flag bits to be set.
     * @see #setFlags
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.722 -0500", hash_original_method = "0498A767AE3286E2ACD9E77A8750E86F", hash_generated_method = "D313765D7EE886EA0958BBAD876109EF")
    
public void addFlags(int flags) {
        setFlags(flags, flags);
    }
    
    /**
     * Convenience function to clear the flag bits as specified in flags, as
     * per {@link #setFlags}.
     * @param flags The flag bits to be cleared.
     * @see #setFlags
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.724 -0500", hash_original_method = "1B1BB2C51A9E558BB4222C67BD342AB1", hash_generated_method = "52011151D7FF452638D837BC419171AD")
    
public void clearFlags(int flags) {
        setFlags(0, flags);
    }

    /**
     * Set the flags of the window, as per the
     * {@link WindowManager.LayoutParams WindowManager.LayoutParams}
     * flags.
     * 
     * <p>Note that some flags must be set before the window decoration is
     * created (by the first call to
     * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)} or
     * {@link #getDecorView()}:
     * {@link WindowManager.LayoutParams#FLAG_LAYOUT_IN_SCREEN} and
     * {@link WindowManager.LayoutParams#FLAG_LAYOUT_INSET_DECOR}.  These
     * will be set for you based on the {@link android.R.attr#windowIsFloating}
     * attribute.
     *
     * @param flags The new window flags (see WindowManager.LayoutParams).
     * @param mask Which of the window flag bits to modify.
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.727 -0500", hash_original_method = "40E42D383A45AE28D15E52653F68CBD5", hash_generated_method = "33AC6D1792EC1888DE667493ABB11B9B")
    
public void setFlags(int flags, int mask) {
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.flags = (attrs.flags&~mask) | (flags&mask);
        if ((mask&WindowManager.LayoutParams.FLAG_NEEDS_MENU_KEY) != 0) {
            attrs.privateFlags |= WindowManager.LayoutParams.PRIVATE_FLAG_SET_NEEDS_MENU_KEY;
        }
        mForcedWindowFlags |= mask;
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Set the amount of dim behind the window when using
     * {@link WindowManager.LayoutParams#FLAG_DIM_BEHIND}.  This overrides
     * the default dim amount of that is selected by the Window based on
     * its theme.
     *
     * @param amount The new dim amount, from 0 for no dim to 1 for full dim.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.729 -0500", hash_original_method = "9455DB63259C6955368CE857C592C952", hash_generated_method = "AF9D5E1C1DA746803B0CE98E62F1C149")
    
public void setDimAmount(float amount) {
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.dimAmount = amount;
        mHaveDimAmount = true;
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(attrs);
        }
    }

    /**
     * Specify custom window attributes.  <strong>PLEASE NOTE:</strong> the
     * layout params you give here should generally be from values previously
     * retrieved with {@link #getAttributes()}; you probably do not want to
     * blindly create and apply your own, since this will blow away any values
     * set by the framework that you are not interested in.
     *
     * @param a The new window attributes, which will completely override any
     *          current values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.732 -0500", hash_original_method = "66B5C1599B3320A30790CC9FF26FC996", hash_generated_method = "A7EC3A2BFA80F89B2461532AF260D632")
    
public void setAttributes(WindowManager.LayoutParams a) {
        mWindowAttributes.copyFrom(a);
        if (mCallback != null) {
            mCallback.onWindowAttributesChanged(mWindowAttributes);
        }
    }

    /**
     * Retrieve the current window attributes associated with this panel.
     *
     * @return WindowManager.LayoutParams Either the existing window
     *         attributes object, or a freshly created one if there is none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.737 -0500", hash_original_method = "1740BD4A684D4859A9304C42BFBB0628", hash_generated_method = "971AECF2967770A660CA66946ABA7DF4")
    
public final WindowManager.LayoutParams getAttributes() {
        return mWindowAttributes;
    }

    /**
     * Return the window flags that have been explicitly set by the client,
     * so will not be modified by {@link #getDecorView}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.739 -0500", hash_original_method = "78D10AE7087B6FEDF7B8FA7D71B4D366", hash_generated_method = "F6432753592495ABBD8F1BB553FC4ACD")
    
protected final int getForcedWindowFlags() {
        return mForcedWindowFlags;
    }
    
    /**
     * Has the app specified their own soft input mode?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.741 -0500", hash_original_method = "3FB6B9359B05585EE87D1E296E0BA56E", hash_generated_method = "82CABF23D2D94ED262F22EB23295B60D")
    
protected final boolean hasSoftInputMode() {
        return mHasSoftInputMode;
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.743 -0500", hash_original_method = "A665A75B43AC6644089B2FAB21289091", hash_generated_method = "55A958F5DD98167B0B0A353DEAFDFA22")
    
public void setCloseOnTouchOutside(boolean close) {
        mCloseOnTouchOutside = close;
        mSetCloseOnTouchOutside = true;
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.746 -0500", hash_original_method = "585D2A4E90DC505694C50AFA60811C60", hash_generated_method = "923D66053A2D584774230575C30205D1")
    
public void setCloseOnTouchOutsideIfNotSet(boolean close) {
        if (!mSetCloseOnTouchOutside) {
            mCloseOnTouchOutside = close;
            mSetCloseOnTouchOutside = true;
        }
    }
    
    /** @hide */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.748 -0500", hash_original_method = "ECAC4D4F75238244675EE49EE332E518", hash_generated_method = "03DCD867BBE5E0EF8C0907D757F3E483")
    
public abstract void alwaysReadCloseOnTouchAttr();
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.750 -0500", hash_original_method = "8CE0B3F5C0E964B12FFD1AA84260C5B9", hash_generated_method = "50F81850E90327E8C9AC7CEB398A2D60")
    
public boolean shouldCloseOnTouch(Context context, MotionEvent event) {
        if (mCloseOnTouchOutside && event.getAction() == MotionEvent.ACTION_DOWN
                && isOutOfBounds(context, event) && peekDecorView() != null) {
            return true;
        }
        return false;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.753 -0500", hash_original_method = "AB4AFCB92A037D63668D3D8B793C0712", hash_generated_method = "2E2E79A6D34196E9E4A65BCF67F5E4C8")
    
private boolean isOutOfBounds(Context context, MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        final View decorView = getDecorView();
        return (x < -slop) || (y < -slop)
                || (x > (decorView.getWidth()+slop))
                || (y > (decorView.getHeight()+slop));
    }
    
    /**
     * Enable extended screen features.  This must be called before
     * setContentView().  May be called as many times as desired as long as it
     * is before setContentView().  If not called, no extended features
     * will be available.  You can not turn off a feature once it is requested.
     * You canot use other title features with {@link #FEATURE_CUSTOM_TITLE}.
     *
     * @param featureId The desired features, defined as constants by Window.
     * @return The features that are now set.
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.755 -0500", hash_original_method = "56D6FF40FC7BCA35CBE5379E385EA86C", hash_generated_method = "E3D53C16CA69D14614EBC23876A3893B")
    
public boolean requestFeature(int featureId) {
        final int flag = 1<<featureId;
        mFeatures |= flag;
        mLocalFeatures |= mContainer != null ? (flag&~mContainer.mFeatures) : flag;
        return (mFeatures&flag) != 0;
    }

    /**
     * @hide Used internally to help resolve conflicting features.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.758 -0500", hash_original_method = "24AB1A47189F5640F802580999D5EF0B", hash_generated_method = "74F265A41EFFA4916A85E4BC9A501898")
    
protected void removeFeature(int featureId) {
        final int flag = 1<<featureId;
        mFeatures &= ~flag;
        mLocalFeatures &= ~(mContainer != null ? (flag&~mContainer.mFeatures) : flag);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.760 -0500", hash_original_method = "B5CCAAF5805277DBB8CBB8283B5C5952", hash_generated_method = "375308A3A092A52E8EB1E6F79AB53111")
    
public final void makeActive() {
        if (mContainer != null) {
            if (mContainer.mActiveChild != null) {
                mContainer.mActiveChild.mIsActive = false;
            }
            mContainer.mActiveChild = this;
        }
        mIsActive = true;
        onActive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.763 -0500", hash_original_method = "825B8CF70F64E49AF2D9884D4F1141F6", hash_generated_method = "495CFC07720862CDEBF9203354CC52BE")
    
public final boolean isActive()
    {
        return mIsActive;
    }

    /**
     * Finds a view that was identified by the id attribute from the XML that
     * was processed in {@link android.app.Activity#onCreate}.  This will
     * implicitly call {@link #getDecorView} for you, with all of the
     * associated side-effects.
     *
     * @return The view if found or null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.765 -0500", hash_original_method = "06392AB1384FAD789566489ED7477D15", hash_generated_method = "E31D4B048E37B9B79BBF0440D009283C")
    
public View findViewById(int id) {
        return getDecorView().findViewById(id);
    }

    /**
     * Convenience for
     * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}
     * to set the screen content from a layout resource.  The resource will be
     * inflated, adding all top-level views to the screen.
     *
     * @param layoutResID Resource ID to be inflated.
     * @see #setContentView(View, android.view.ViewGroup.LayoutParams)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.768 -0500", hash_original_method = "9773B78A0DDFABD7EC1D4950258114B8", hash_generated_method = "EB433CC04E8E9E0A64557B9580BE400E")
    
public abstract void setContentView(int layoutResID);

    /**
     * Convenience for
     * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}
     * set the screen content to an explicit view.  This view is placed
     * directly into the screen's view hierarchy.  It can itself be a complex
     * view hierarhcy.
     *
     * @param view The desired content to display.
     * @see #setContentView(View, android.view.ViewGroup.LayoutParams)
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.771 -0500", hash_original_method = "AF94DA1B8B3F19BB99455C41C42AAA2F", hash_generated_method = "7C75EF3022C19CA0AC6D4456AC6BC868")
    
public abstract void setContentView(View view);

    /**
     * Set the screen content to an explicit view.  This view is placed
     * directly into the screen's view hierarchy.  It can itself be a complex
     * view hierarchy.
     *
     * <p>Note that calling this function "locks in" various characteristics
     * of the window that can not, from this point forward, be changed: the
     * features that have been requested with {@link #requestFeature(int)},
     * and certain window flags as described in {@link #setFlags(int, int)}.
     * 
     * @param view The desired content to display.
     * @param params Layout parameters for the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.775 -0500", hash_original_method = "A59E85D62B1A024FE94FF10CB5C5397F", hash_generated_method = "6878E2F71A50FC32A24E9E0CB6CBCEB4")
    
public abstract void setContentView(View view, ViewGroup.LayoutParams params);

    /**
     * Variation on
     * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}
     * to add an additional content view to the screen.  Added after any existing
     * ones in the screen -- existing views are NOT removed.
     *
     * @param view The desired content to display.
     * @param params Layout parameters for the view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.778 -0500", hash_original_method = "D65C1F649E1EC548381F5E6D0A372F64", hash_generated_method = "C56060DF65649B31EB62F6AEA252A3CE")
    
public abstract void addContentView(View view, ViewGroup.LayoutParams params);

    /**
     * Return the view in this Window that currently has focus, or null if
     * there are none.  Note that this does not look in any containing
     * Window.
     *
     * @return View The current View with focus or null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.781 -0500", hash_original_method = "507FEC83FAC03422D964FF6776DEED99", hash_generated_method = "F7ED30B276282FDAA9CEB77D401B4EB2")
    
public abstract View getCurrentFocus();

    /**
     * Quick access to the {@link LayoutInflater} instance that this Window
     * retrieved from its Context.
     *
     * @return LayoutInflater The shared LayoutInflater.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.784 -0500", hash_original_method = "847F3379611271C0321E2C5BAA33B7FA", hash_generated_method = "8FB812958D8E2D9F54789B094DECD781")
    
public abstract LayoutInflater getLayoutInflater();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.787 -0500", hash_original_method = "410835EEA321510B785087E900780AFB", hash_generated_method = "F61FA778C52CF90209781407DFEFC387")
    
public abstract void setTitle(CharSequence title);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.789 -0500", hash_original_method = "FBE668620F097D2B1FD15F1108FE61BF", hash_generated_method = "38D664D8F582AA9CE8BF80135B76B213")
    
public abstract void setTitleColor(int textColor);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.791 -0500", hash_original_method = "E3F140A8A8946BBC4133CA8E35BE24A2", hash_generated_method = "EB53D1759C01B34065D8EFF757E094AE")
    
public abstract void openPanel(int featureId, KeyEvent event);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.794 -0500", hash_original_method = "17C348F7D6A27EB7E670CF4E97DB069A", hash_generated_method = "C5E28C46FC3BE6940390177BE65BD46E")
    
public abstract void closePanel(int featureId);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.797 -0500", hash_original_method = "B7E544C233801B67A59F057C364E33AE", hash_generated_method = "56E4A676A3C14B8726ACB0C5A19BB79B")
    
public abstract void togglePanel(int featureId, KeyEvent event);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.800 -0500", hash_original_method = "ED5A2AB5A6A6225F17A71D49A205D55B", hash_generated_method = "3AF92264D614DD6D3C6140C9D60AEF63")
    
public abstract void invalidatePanelMenu(int featureId);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.803 -0500", hash_original_method = "57C27522BC8A2BD20032BAB8BDF1BC84", hash_generated_method = "2CF623669E242775C92A49875BF8A904")
    
public abstract boolean performPanelShortcut(int featureId,
                                                 int keyCode,
                                                 KeyEvent event,
                                                 int flags);
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.806 -0500", hash_original_method = "FFD6B495855F1C596AE1C5FE4D74FA0E", hash_generated_method = "1D3384F9A7095A92AD4FF11977BA0739")
    
public abstract boolean performPanelIdentifierAction(int featureId,
                                                 int id,
                                                 int flags);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.809 -0500", hash_original_method = "02386DB32EC504F68F7F7939721861EB", hash_generated_method = "5BC90B45830AC0D44B19D720598E60C7")
    
public abstract void closeAllPanels();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.812 -0500", hash_original_method = "CF91ED3CA90DF5B83550D754FC71B528", hash_generated_method = "2F3B6CC21808873F4DE190F0481E6768")
    
public abstract boolean performContextMenuIdentifierAction(int id, int flags);

    /**
     * Should be called when the configuration is changed.
     * 
     * @param newConfig The new configuration.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.815 -0500", hash_original_method = "1AE11CFD391BD9AE98B6BD4696F9FDCA", hash_generated_method = "10F7775671EDD17F46F560ADD64B19A7")
    
public abstract void onConfigurationChanged(Configuration newConfig);
    
    /**
     * Change the background of this window to a Drawable resource. Setting the
     * background to null will make the window be opaque. To make the window
     * transparent, you can use an empty drawable (for instance a ColorDrawable
     * with the color 0 or the system drawable android:drawable/empty.)
     * 
     * @param resid The resource identifier of a drawable resource which will be
     *              installed as the new background.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.817 -0500", hash_original_method = "AFC383C5A753BE0283DE80727207DE11", hash_generated_method = "3C1C0B95983C16D6419782DD69A8F724")
    
public void setBackgroundDrawableResource(int resid)
    {
        setBackgroundDrawable(mContext.getResources().getDrawable(resid));
    }

    /**
     * Change the background of this window to a custom Drawable. Setting the
     * background to null will make the window be opaque. To make the window
     * transparent, you can use an empty drawable (for instance a ColorDrawable
     * with the color 0 or the system drawable android:drawable/empty.)
     *
     * @param drawable The new Drawable to use for this window's background.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.820 -0500", hash_original_method = "413AE16E7BB25699B376E766DB0A8D3D", hash_generated_method = "BE47D9F2FD6C215AED538CB308453AFC")
    
public abstract void setBackgroundDrawable(Drawable drawable);

    /**
     * Set the value for a drawable feature of this window, from a resource
     * identifier.  You must have called requestFeauture(featureId) before
     * calling this function.
     *
     * @see android.content.res.Resources#getDrawable(int)
     *
     * @param featureId The desired drawable feature to change, defined as a
     * constant by Window.
     * @param resId Resource identifier of the desired image.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.823 -0500", hash_original_method = "D85024C42C38E01D8D1381EA0521413A", hash_generated_method = "8F53D434F9FEEAE22B35D318FA73CC8A")
    
public abstract void setFeatureDrawableResource(int featureId, int resId);

    /**
     * Set the value for a drawable feature of this window, from a URI. You
     * must have called requestFeature(featureId) before calling this
     * function.
     *
     * <p>The only URI currently supported is "content:", specifying an image
     * in a content provider.
     *
     * @see android.widget.ImageView#setImageURI
     *
     * @param featureId The desired drawable feature to change. Features are
     * constants defined by Window.
     * @param uri The desired URI.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.825 -0500", hash_original_method = "606E3B866EAA709E9AD8275566324796", hash_generated_method = "628262CC8BBF9DEF97C060ED121954EB")
    
public abstract void setFeatureDrawableUri(int featureId, Uri uri);

    /**
     * Set an explicit Drawable value for feature of this window. You must
     * have called requestFeature(featureId) before calling this function.
     *
     * @param featureId The desired drawable feature to change.
     * Features are constants defined by Window.
     * @param drawable A Drawable object to display.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.828 -0500", hash_original_method = "5D87EAB77EFB6B36E1B55DA6ADE4971E", hash_generated_method = "07A6FF99C5A6A6108FE676B6201685B1")
    
public abstract void setFeatureDrawable(int featureId, Drawable drawable);

    /**
     * Set a custom alpha value for the given drawale feature, controlling how
     * much the background is visible through it.
     *
     * @param featureId The desired drawable feature to change.
     * Features are constants defined by Window.
     * @param alpha The alpha amount, 0 is completely transparent and 255 is
     *              completely opaque.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.834 -0500", hash_original_method = "C0C8F25B5F920501D9958E4D2352BD14", hash_generated_method = "7C1EDA2F0C35DC3785D5BE9FC0B9F644")
    
public abstract void setFeatureDrawableAlpha(int featureId, int alpha);

    /**
     * Set the integer value for a feature.  The range of the value depends on
     * the feature being set.  For FEATURE_PROGRESSS, it should go from 0 to
     * 10000. At 10000 the progress is complete and the indicator hidden.
     *
     * @param featureId The desired feature to change.
     * Features are constants defined by Window.
     * @param value The value for the feature.  The interpretation of this
     *              value is feature-specific.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.837 -0500", hash_original_method = "F69F194C10A724FF5B54AE7707FA4E1F", hash_generated_method = "42C5E0BC5C45BCA76685BDD45D4E7A66")
    
public abstract void setFeatureInt(int featureId, int value);

    /**
     * Request that key events come to this activity. Use this if your
     * activity has no views with focus, but the activity still wants
     * a chance to process key events.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.840 -0500", hash_original_method = "28F608A9E663E51DCFC12E09E6764B8F", hash_generated_method = "6C0A4C97DA6DA505BAB7EFFBA6D1C4E3")
    
public abstract void takeKeyEvents(boolean get);

    /**
     * Used by custom windows, such as Dialog, to pass the key press event
     * further down the view hierarchy. Application developers should
     * not need to implement or call this.
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.842 -0500", hash_original_method = "D1451E151613AE9B75118E481B4EEA60", hash_generated_method = "D5F884291B7F1B1C530292AA966CA735")
    
public abstract boolean superDispatchKeyEvent(KeyEvent event);
    
    private class LocalWindowManager extends WindowManagerImpl.CompatModeWrapper {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.675 -0500", hash_original_field = "A52D19DE7788F57CC5C01823E2C1F35F", hash_generated_field = "BA2C677D1D301CB311A67BA2544B79AA")

        private static final String PROPERTY_HARDWARE_UI = "persist.sys.ui.hw";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.677 -0500", hash_original_field = "68B6EC09532005E80B3FF968D0432D9B", hash_generated_field = "C592280128F52BDDBAD2DA621E45F814")

        private  boolean mHardwareAccelerated;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.680 -0500", hash_original_method = "BB2707026A85041C76D7C937C71FA0C1", hash_generated_method = "BB2707026A85041C76D7C937C71FA0C1")
        
LocalWindowManager(WindowManager wm, boolean hardwareAccelerated) {
            super(wm, getCompatInfo(mContext));
            mHardwareAccelerated = hardwareAccelerated ||
                    SystemProperties.getBoolean(PROPERTY_HARDWARE_UI, false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.683 -0500", hash_original_method = "93C5B5997EB72284CF079AECD506D640", hash_generated_method = "8AC065B184C3880B5284F85AD1FBEBDE")
        
public boolean isHardwareAccelerated() {
            return mHardwareAccelerated;
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.687 -0500", hash_original_method = "AADD2F7F32065CABAE6715302100F897", hash_generated_method = "216FD5E69D2757A8BF9184F21932F884")
        
public final void addView(View view, ViewGroup.LayoutParams params) {
            // Let this throw an exception on a bad params.
            WindowManager.LayoutParams wp = (WindowManager.LayoutParams)params;
            CharSequence curTitle = wp.getTitle();
            if (wp.type >= WindowManager.LayoutParams.FIRST_SUB_WINDOW &&
                wp.type <= WindowManager.LayoutParams.LAST_SUB_WINDOW) {
                if (wp.token == null) {
                    View decor = peekDecorView();
                    if (decor != null) {
                        wp.token = decor.getWindowToken();
                    }
                }
                if (curTitle == null || curTitle.length() == 0) {
                    String title;
                    if (wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA) {
                        title="Media";
                    } else if (wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY) {
                        title="MediaOvr";
                    } else if (wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
                        title="Panel";
                    } else if (wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL) {
                        title="SubPanel";
                    } else if (wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG) {
                        title="AtchDlg";
                    } else {
                        title=Integer.toString(wp.type);
                    }
                    if (mAppName != null) {
                        title += ":" + mAppName;
                    }
                    wp.setTitle(title);
                }
            } else {
                if (wp.token == null) {
                    wp.token = mContainer == null ? mAppToken : mContainer.mAppToken;
                }
                if ((curTitle == null || curTitle.length() == 0)
                        && mAppName != null) {
                    wp.setTitle(mAppName);
                }
           }
            if (wp.packageName == null) {
                wp.packageName = mContext.getPackageName();
            }
            if (mHardwareAccelerated) {
                wp.flags |= WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED;
            }
            super.addView(view, params);
        }
    }
    
    public interface Callback {
        
        public boolean dispatchKeyEvent(KeyEvent event);
        
        public boolean dispatchKeyShortcutEvent(KeyEvent event);
        
        public boolean dispatchTouchEvent(MotionEvent event);
        
        public boolean dispatchTrackballEvent(MotionEvent event);
        
        public boolean dispatchGenericMotionEvent(MotionEvent event);
        
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event);
        
        public View onCreatePanelView(int featureId);
        
        public boolean onCreatePanelMenu(int featureId, Menu menu);
        
        public boolean onPreparePanel(int featureId, View view, Menu menu);
        
        public boolean onMenuOpened(int featureId, Menu menu);
        
        public boolean onMenuItemSelected(int featureId, MenuItem item);
        
        public void onWindowAttributesChanged(WindowManager.LayoutParams attrs);
        
        public void onContentChanged();
        
        public void onWindowFocusChanged(boolean hasFocus);
        
        public void onAttachedToWindow();
        
        public void onDetachedFromWindow();
        
        public void onPanelClosed(int featureId, Menu menu);
        
        public boolean onSearchRequested();
        
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback);
        
        public void onActionModeStarted(ActionMode mode);
        
        public void onActionModeFinished(ActionMode mode);
    }

    /**
     * Used by custom windows, such as Dialog, to pass the key shortcut press event
     * further down the view hierarchy. Application developers should
     * not need to implement or call this.
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.845 -0500", hash_original_method = "6C7372A6AAED52604447FEC6A64B288B", hash_generated_method = "FBFDD993FA5F6C13470FDF2E18CE9642")
    
public abstract boolean superDispatchKeyShortcutEvent(KeyEvent event);

    /**
     * Used by custom windows, such as Dialog, to pass the touch screen event
     * further down the view hierarchy. Application developers should
     * not need to implement or call this.
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.848 -0500", hash_original_method = "E5160F800594D1AAD73D8C30FF262B56", hash_generated_method = "48F5ED9E47EA85886FB52F6888A37DE6")
    
public abstract boolean superDispatchTouchEvent(MotionEvent event);
    
    /**
     * Used by custom windows, such as Dialog, to pass the trackball event
     * further down the view hierarchy. Application developers should
     * not need to implement or call this.
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.850 -0500", hash_original_method = "8F45AF12C4C1F8295DF4B1576F2849CB", hash_generated_method = "1D4006478FBEE10C7D10CF12564A2276")
    
public abstract boolean superDispatchTrackballEvent(MotionEvent event);
    
    /**
     * Used by custom windows, such as Dialog, to pass the generic motion event
     * further down the view hierarchy. Application developers should
     * not need to implement or call this.
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.854 -0500", hash_original_method = "3EEB372C3A6CF7A6285F5820C3E6AA47", hash_generated_method = "A005D4A8693BD01466990BC9769FC250")
    
public abstract boolean superDispatchGenericMotionEvent(MotionEvent event);

    /**
     * Retrieve the top-level window decor view (containing the standard
     * window frame/decorations and the client's content inside of that), which
     * can be added as a window to the window manager.
     * 
     * <p><em>Note that calling this function for the first time "locks in"
     * various window characteristics as described in
     * {@link #setContentView(View, android.view.ViewGroup.LayoutParams)}.</em></p>
     * 
     * @return Returns the top-level window decor view.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.856 -0500", hash_original_method = "83066C83022E8181658B34D6E338F2C6", hash_generated_method = "54D70119532474D04D2C263537967038")
    
public abstract View getDecorView();

    /**
     * Retrieve the current decor view, but only if it has already been created;
     * otherwise returns null.
     * 
     * @return Returns the top-level window decor or null.
     * @see #getDecorView
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.859 -0500", hash_original_method = "2974F4DCDFC5197E408CC7132A85C497", hash_generated_method = "AC66449657450B58FE24F7BE61A493AE")
    
public abstract View peekDecorView();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.861 -0500", hash_original_method = "68C4DB4B1C44FD7724106402D0F5F177", hash_generated_method = "DF8122A9A10BA3C6C573005E047ABB19")
    
public abstract Bundle saveHierarchyState();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.864 -0500", hash_original_method = "8EE3C98BDDCEAF1033423457647508C1", hash_generated_method = "B19D245C1F299DD2EF370F3415329349")
    
public abstract void restoreHierarchyState(Bundle savedInstanceState);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.867 -0500", hash_original_method = "67F014C6E07E062BFF37CE9BC7936F72", hash_generated_method = "28DBC7E78B766240A7F794DEBE59B15A")
    
protected abstract void onActive();

    /**
     * Return the feature bits that are enabled.  This is the set of features
     * that were given to requestFeature(), and are being handled by this
     * Window itself or its container.  That is, it is the set of
     * requested features that you can actually use.
     *
     * <p>To do: add a public version of this API that allows you to check for
     * features by their feature ID.
     *
     * @return int The feature bits.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.869 -0500", hash_original_method = "201C8696C96B5CE4C022F78574069483", hash_generated_method = "DDB7798DC1EBDAB25A85981689E14E5A")
    
protected final int getFeatures()
    {
        return mFeatures;
    }
    
    /**
     * Query for the availability of a certain feature.
     * 
     * @param feature The feature ID to check
     * @return true if the feature is enabled, false otherwise.
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.872 -0500", hash_original_method = "5A085FB22E39DFD08969173C82283E9B", hash_generated_method = "1F7260A02653D87AB5FD59DC838B3743")
    
public boolean hasFeature(int feature) {
        return (getFeatures() & (1 << feature)) != 0;
    }

    /**
     * Return the feature bits that are being implemented by this Window.
     * This is the set of features that were given to requestFeature(), and are
     * being handled by only this Window itself, not by its containers.
     *
     * @return int The feature bits.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.874 -0500", hash_original_method = "D46E90B97B876B97E16E92A5FEA18EB3", hash_generated_method = "9647CC1BF49BEB42DD8E7D5AC4D811EA")
    
protected final int getLocalFeatures()
    {
        return mLocalFeatures;
    }

    /**
     * Set the default format of window, as per the PixelFormat types.  This
     * is the format that will be used unless the client specifies in explicit
     * format with setFormat();
     *
     * @param format The new window format (see PixelFormat).
     *
     * @see #setFormat
     * @see PixelFormat
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.876 -0500", hash_original_method = "439CF6A84E0EE9568E72DFCB057259B4", hash_generated_method = "D056471AF0CAB1AB80E839510665B7FC")
    
protected void setDefaultWindowFormat(int format) {
        mDefaultWindowFormat = format;
        if (!mHaveWindowFormat) {
            final WindowManager.LayoutParams attrs = getAttributes();
            attrs.format = format;
            if (mCallback != null) {
                mCallback.onWindowAttributesChanged(attrs);
            }
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.879 -0500", hash_original_method = "765B449347DE858F4538165B748C680A", hash_generated_method = "32A437DB3B9380C114EACB40C45E4C9E")
    
protected boolean haveDimAmount() {
        return mHaveDimAmount;
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.882 -0500", hash_original_method = "E183EAEC11BA99DB4FC1ABD632308ED6", hash_generated_method = "A873284BFB86D1301955C5E6E3AED808")
    
public abstract void setChildDrawable(int featureId, Drawable drawable);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.884 -0500", hash_original_method = "91795A246E82C211760659389AB7E425", hash_generated_method = "8EAEFC23FA8FD2B5718A2D35594663D8")
    
public abstract void setChildInt(int featureId, int value);

    /**
     * Is a keypress one of the defined shortcut keys for this window.
     * @param keyCode the key code from {@link android.view.KeyEvent} to check.
     * @param event the {@link android.view.KeyEvent} to use to help check.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.887 -0500", hash_original_method = "B26619F1D37F9834AAF85A0F4DE23CD5", hash_generated_method = "76A548F8E3C0BCABED0B6DF2C71B59AE")
    
public abstract boolean isShortcutKey(int keyCode, KeyEvent event);
    
    /**
     * @see android.app.Activity#setVolumeControlStream(int) 
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.889 -0500", hash_original_method = "990D00AE8E113AC83065E187F08BB6F3", hash_generated_method = "0FCF48EBB7E229B2613FD06DE8596EF2")
    
public abstract void setVolumeControlStream(int streamType);

    /**
     * @see android.app.Activity#getVolumeControlStream()
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.892 -0500", hash_original_method = "E22A8B3D08EAD711AFBEA9D09A632202", hash_generated_method = "70ED8A285B2F0361BE472450A9D0E0EE")
    
public abstract int getVolumeControlStream();

    /**
     * Set extra options that will influence the UI for this window.
     * @param uiOptions Flags specifying extra options for this window.
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.894 -0500", hash_original_method = "5C7A5DC825C127CAEB67314627C1344D", hash_generated_method = "E7803D9EA57EDD53A6619582D74C929D")
    
public void setUiOptions(int uiOptions) { }

    /**
     * Set extra options that will influence the UI for this window.
     * Only the bits filtered by mask will be modified.
     * @param uiOptions Flags specifying extra options for this window.
     * @param mask Flags specifying which options should be modified. Others will remain unchanged.
     */
    @DSComment("Normal UI operations")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:26.897 -0500", hash_original_method = "DD14EAF3AEC819DEC25B96FED2D2DF84", hash_generated_method = "F49B7763563715E51446AA4C72042315")
    
public void setUiOptions(int uiOptions, int mask) { }
}

