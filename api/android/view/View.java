package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ClipData;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Interpolator;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.LocaleUtil;
import android.util.Log;
import android.util.Pool;
import android.util.Poolable;
import android.util.PoolableManager;
import android.util.Pools;
import android.util.Property;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityEventSource;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollBarDrawable;
import static android.os.Build.VERSION_CODES.*;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import com.android.internal.view.menu.MenuBuilder;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class View implements Drawable.Callback, Drawable.Callback2, KeyEvent.Callback, AccessibilityEventSource {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "B2E23F53603EF963174A5DCDD21E377A", hash_generated_field = "DD721D19F83A9531A571F53535845605")

    private SparseArray<Object> mKeyedTags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "81C8D8BB5EDA313C426D4F0583A37B0F", hash_generated_field = "1A75C99521C9A69968375361930C982C")

    protected Animation mCurrentAnimation = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "30AF844796D32E1DD6D14B620B8355DF", hash_generated_field = "8AF08A92D2F66E40D67BD95DF20644CE")

    @ViewDebug.ExportedProperty(category = "measurement") int mMeasuredWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "0EF7F253195B445FA5A8B4E98FA98667", hash_generated_field = "92147C8788B6F0CA2DABA1FB3B19E8BF")

    @ViewDebug.ExportedProperty(category = "measurement") int mMeasuredHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "FA31AC557740873AF5104338EBA7FC19", hash_generated_field = "2D6D8008671A06EF61654718BEF765EB")

    boolean mRecreateDisplayList = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "5FFDC6E17099498D1825C5220B9BD0AE", hash_generated_field = "AFA40CB29D8B77AA456CB799510E6286")

    @ViewDebug.ExportedProperty(resolveId = true) int mID = NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "8EA4018BB68ADA26F78B9B1F42A67958", hash_generated_field = "CDDE4755ADE2BC204930CA88B5DBB470")

    int mAccessibilityViewId = NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.907 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "91C972E269A3F4396E01E84D6E3CCC58")

    protected Object mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "A3201A672D71DD5A79F87DF520AF188A", hash_generated_field = "7014A987CDECAA2300639BF21EC914DD")

    private int mOverScrollMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "E798458702129E681480C3268D9EB850")

    protected ViewParent mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "B1A49FF62D92BCD8AE5C70F97D680510", hash_generated_field = "7DACD6A85AA040B3D0EFA6ECFB8BF661")

    AttachInfo mAttachInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "DD07F24B502147BA1093569C14614DF6", hash_generated_field = "4B9A7C2E7189666FEFF6FEA48770F96F")

    @ViewDebug.ExportedProperty(flagMapping = {
        @ViewDebug.FlagToString(mask = FORCE_LAYOUT, equals = FORCE_LAYOUT,
                name = "FORCE_LAYOUT"),
        @ViewDebug.FlagToString(mask = LAYOUT_REQUIRED, equals = LAYOUT_REQUIRED,
                name = "LAYOUT_REQUIRED"),
        @ViewDebug.FlagToString(mask = DRAWING_CACHE_VALID, equals = DRAWING_CACHE_VALID,
            name = "DRAWING_CACHE_INVALID", outputIf = false),
        @ViewDebug.FlagToString(mask = DRAWN, equals = DRAWN, name = "DRAWN", outputIf = true),
        @ViewDebug.FlagToString(mask = DRAWN, equals = DRAWN, name = "NOT_DRAWN", outputIf = false),
        @ViewDebug.FlagToString(mask = DIRTY_MASK, equals = DIRTY_OPAQUE, name = "DIRTY_OPAQUE"),
        @ViewDebug.FlagToString(mask = DIRTY_MASK, equals = DIRTY, name = "DIRTY")
    }) int mPrivateFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "28E81DB49C33C12590DE3E9CA12A7A01", hash_generated_field = "A70874573E565834837AE3AE1A44105E")

    int mPrivateFlags2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "D03AF504A7FB8D1F39097D83B42BDFFD", hash_generated_field = "18478E9808210D74729295E4C33E2EEB")

    @ViewDebug.ExportedProperty(flagMapping = {
        @ViewDebug.FlagToString(mask = SYSTEM_UI_FLAG_LOW_PROFILE,
                                equals = SYSTEM_UI_FLAG_LOW_PROFILE,
                                name = "SYSTEM_UI_FLAG_LOW_PROFILE", outputIf = true),
        @ViewDebug.FlagToString(mask = SYSTEM_UI_FLAG_HIDE_NAVIGATION,
                                equals = SYSTEM_UI_FLAG_HIDE_NAVIGATION,
                                name = "SYSTEM_UI_FLAG_HIDE_NAVIGATION", outputIf = true),
        @ViewDebug.FlagToString(mask = PUBLIC_STATUS_BAR_VISIBILITY_MASK,
                                equals = SYSTEM_UI_FLAG_VISIBLE,
                                name = "SYSTEM_UI_FLAG_VISIBLE", outputIf = true)
    }) int mSystemUiVisibility;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "B4EADC228928954D156338C2784E8E5E", hash_generated_field = "AA3BA123C58FF5925198746B8B561359")

    int mWindowAttachCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "131BCA992A092424AD9B21CD196A5A23", hash_generated_field = "AC04A604736B65491405D9541E300EF7")

    protected ViewGroup.LayoutParams mLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "B4A6C3081B601CA613414848B92AAEAE", hash_generated_field = "D35E3C6B5D57FAA3D36920801FB7F998")

    @ViewDebug.ExportedProperty int mViewFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "06B81BDBD4699F35D8DC8F52040A7EB4", hash_generated_field = "814413531F598274EEECF8BE645FBF8D")

    TransformationInfo mTransformationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "9FEFCB6583E51099148CCC96D70DF025", hash_generated_field = "62AEC70730E07CC33ABF33611E56E0C9")

    private boolean mLastIsOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "B0CFD8B13BD2121822E87395D9B5EB0A")

    @ViewDebug.ExportedProperty(category = "layout") protected int mLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "720807298C0DE3DCF41AEC725F26A5A1", hash_generated_field = "51E02A5FF8AC135FCB771EE787BDB4C9")

    @ViewDebug.ExportedProperty(category = "layout") protected int mRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "496CBAA35C1D669530329F97A9C74114")

    @ViewDebug.ExportedProperty(category = "layout") protected int mTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "6F474ED228AC76685E91ED773CB73395")

    @ViewDebug.ExportedProperty(category = "layout") protected int mBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "9DC8F9676E14E93147EBEA37CE364B55", hash_generated_field = "1ACB7D4E721E5C41E8206F696A6DB2DB")

    @ViewDebug.ExportedProperty(category = "scrolling") protected int mScrollX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "4ABBFD585ECE4FE40BECD8E0C30C4E5E", hash_generated_field = "3AE77EDF3F10D09CA5B3A9FC1C16B667")

    @ViewDebug.ExportedProperty(category = "scrolling") protected int mScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "252F7DBD6188FA4BC0CBCF5785506FD8", hash_generated_field = "0D018CC517023EE199B2A8DAA6ECB500")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "1CC5609E099825B7F5335F0151334D28", hash_generated_field = "AEE809A9BA21DCA8517E2AD9D955D3B7")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "160C8C8F6F0F40401734402AE62419A9", hash_generated_field = "12E040F5B926130031C2D0EA1ECAF1B8")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "DC0A1BD9ED7E0615D8F16D5DA74E6D47", hash_generated_field = "AB005070934C3278D46BFF088EA941B9")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "72448C4AF26CE8C6C66360ACE1566CFE", hash_generated_field = "24275D1D330A85C524C74A0B09414AAB")

    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "CEB8CA928CC6F1226E948D86A175A8FC", hash_generated_field = "0C4869EF67BF3E50F8F10A68C2F9D716")

    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "3C518AC9A0E1AF98691ADD3A8A1CCB30", hash_generated_field = "1BE3737E54325E6415262D1A90E67453")

    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "5E1288938438CBB6C9289BF968E78727", hash_generated_field = "B3EF2958202B8FBC0F390975B72C0AB1")

    @ViewDebug.ExportedProperty(category = "padding") boolean mUserPaddingRelative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "82E152642CCF26B8B66B0CCCFE09EA44", hash_generated_field = "BFF4356AD8CC83E6872ED1781251B206")

    @ViewDebug.ExportedProperty(category = "padding") int mUserPaddingStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.908 -0400", hash_original_field = "4DBF4950DA8FCB8889499A80DAA6625F", hash_generated_field = "C099602A54FEC808EF713AD0C3E426B1")

    @ViewDebug.ExportedProperty(category = "padding") int mUserPaddingEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "82845C8137ABB799EDEBA2102E5BC6CA", hash_generated_field = "3BFE3DAC86E051A37E15269C1EBC8E4B")

    int mOldWidthMeasureSpec = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "F07A0625188625F817BFD34F6D66B011", hash_generated_field = "1C3D2A3A966DD51630301EB9B47C35E5")

    int mOldHeightMeasureSpec = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "AE73D526548104E4C1E17F7F245F81BC", hash_generated_field = "CD7692461BCF8CBA84620403F5E57E2E")

    private Drawable mBGDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "402426C85408915526629956C0CDBBC1", hash_generated_field = "EFFE71B257E8A8B334669D80482775BC")

    private int mBackgroundResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "8AFEAE5A926044C2D360A11EA8458209", hash_generated_field = "308B2769E6A04DC50D717155A3FFF7C8")

    private boolean mBackgroundSizeChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "78118D1764B56569D6B6E6C626D161A5", hash_generated_field = "29D621A32636521FA6951DD85766CC20")

    ListenerInfo mListenerInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "AC1C3EE794A682BD562C18565142DA7C", hash_generated_field = "8ED80A3CDB45EFD1EC966904F18B0C41")

    private ScrollabilityCache mScrollCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "60876A8DC985533C9A9E5260A5B1C8A3", hash_generated_field = "51C006923E88A244E6B4A81FAACDA6EF")

    private int[] mDrawableState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "A475F3D92E5FAC2EB37DD88F537E2964", hash_generated_field = "8763FD238D26A060847D5BFD5F110B02")

    public boolean mCachingFailed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "00D13CF2B6143C87E634D4CF05F6DBCC", hash_generated_field = "3DD824BE1FD179F4F5718F6A857553E0")

    private Bitmap mDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "9D429DAE730251946D577870B67FB966", hash_generated_field = "03126783BB83E37A27CE046D8A79B1C7")

    private Bitmap mUnscaledDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "B56FE185AB9316DBDB054606F5602E90", hash_generated_field = "CE60F7E3CE3B2722E2B23845AC923EB1")

    private HardwareLayer mHardwareLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "28797884D8917814D2A66A0146DC8FD5", hash_generated_field = "4FBA01527B47AF659DF19EA16E769B16")

    DisplayList mDisplayList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "2205CD40A12D3B9963716F25F00C61E5", hash_generated_field = "45B02C2955F0D136C014E9DC60FE3184")

    private int mNextFocusLeftId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "A47FAC14D63975AE3196CF8FC5EF36FD", hash_generated_field = "DF84F09C311C486A086B9C7EA2243503")

    private int mNextFocusRightId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "EA75E9C31361CFF469517E9FD54298D6", hash_generated_field = "9F4730280C31C2719C1F46BE8E8450BA")

    private int mNextFocusUpId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "A2B6D0B87912715ADB1AD5C9738CF374", hash_generated_field = "319D75290A4647F72AD3D5A42A864E5C")

    private int mNextFocusDownId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "B00173086AA038860B98671358FAAC9B", hash_generated_field = "218707A9C3C12F8433C4FECF627C213D")

    int mNextFocusForwardId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "956789F3DA470AD87E91A7076E41578B", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "775B249E2D7CD12DF12303812684BB7B", hash_generated_field = "B8AF3727C0596C63ED7DB54BAD71671F")

    private CheckForTap mPendingCheckForTap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "83D78F1B989F8D62D88496F5EC6FF33F", hash_generated_field = "99E4AAED357F9D1925CADBAC4D6015A4")

    private PerformClick mPerformClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "3A6CE60FA7A6FA838255E6DD66DA4901", hash_generated_field = "4EE5120DCD6EBA553548CD3C570A5967")

    private SendViewScrolledAccessibilityEvent mSendViewScrolledAccessibilityEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "1D15E7AFACCA72AA82FDEB1ED50C858E", hash_generated_field = "CDF30A3821A23955C4124811C1CA0AEA")

    private UnsetPressedState mUnsetPressedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.909 -0400", hash_original_field = "5A2F892720FCFD0DC61FB4EFF8239FF9", hash_generated_field = "751618E4ED7D5DBDA5B68F37D9865720")

    private boolean mHasPerformedLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "7B1C5936E045E46CDC7DE29B76B9E7F4", hash_generated_field = "F1A8CDC4E26D8D5C7DE32B2AF25C8740")

    @ViewDebug.ExportedProperty(category = "measurement") private int mMinHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "4FCEB583348C4614E548F5AFAEC98A67")

    @ViewDebug.ExportedProperty(category = "measurement") private int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "507FCACB9EF82E081076A9EEAEBF9B63", hash_generated_field = "E569734BF8D6E083A22CF46961923ECB")

    private TouchDelegate mTouchDelegate = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "6EDC251E57408BDC16F07004B6855199", hash_generated_field = "D92790A9877C98F11E8F179FB043C786")

    private int mDrawingCacheBackgroundColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "B97920548B94E92CFDC64D305AC20F69", hash_generated_field = "A0D36EEAADCE4EE07A5AC99F73C584E9")

    private ViewTreeObserver mFloatingTreeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "40F78C707625DBFDC188EF24918066C8", hash_generated_field = "031DB2A7C2250D8B7DE4F6272C82D45E")

    private ViewPropertyAnimator mAnimator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "790487E83CF3B009D444C02267049200", hash_generated_field = "2607C5FC6CCACC3F7D721707ADA72671")

    private float mVerticalScrollFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "87A1A37696C42230D03AF78A00037CA3", hash_generated_field = "4F21705D0823B901E43594B264DCB237")

    private int mVerticalScrollbarPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "FFD6DFFEEF7D4409E878CD8773FFADFF", hash_generated_field = "76D9A2089F38CDD618BD49C87D710C3C")

    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
            @ViewDebug.IntToString(from = LAYER_TYPE_NONE, to = "NONE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_SOFTWARE, to = "SOFTWARE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_HARDWARE, to = "HARDWARE")
    }) int mLayerType = LAYER_TYPE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "5870A18F50D7C3B8DE43F07B2A8E2BC8", hash_generated_field = "DF81DF3E7FE84B1D663D7E8ECAF0C794")

    Paint mLayerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "FA0B46D25C5CFBAFDF9C3E8111032A29", hash_generated_field = "5423282DE76FBF7AAAD365160A805585")

    Rect mLocalDirtyRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "08B5E57DCB5E26E7EF1C647028B3CDC5", hash_generated_field = "D73DE13E5337A6B5E189A73C651B0933")

    private boolean mSendingHoverAccessibilityEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "AB14B73F2A537D26873B7CD3721A2654", hash_generated_field = "ACE9AD3D63F4A66B9F893798ED18776A")

    AccessibilityDelegate mAccessibilityDelegate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "56F776C2E6CE1ACD33CDE41CE78F02EC", hash_generated_field = "B72A5C45BF32E84602E6733FBFEC7DAD")

    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    }) private int mTextDirection = DEFAULT_TEXT_DIRECTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "CA7F7356F0500733AA9EAA872F25A83A", hash_generated_field = "318F54594F0F5ED162811E42E0595AEA")

    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    }) private int mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "FBF46F0211B74BEC9C47C5EFFAF36A72")

    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.910 -0400", hash_original_method = "6E480C32A7FC910695FE07C33ABF7A7A", hash_generated_method = "AD454F01B4A79F64B85B96CBA3B68A9E")
    public  View(Context context) {
        mContext = context;
        mResources = context != null ? context.getResources() : null;
        mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
        mUserPaddingStart = -1;
        mUserPaddingEnd = -1;
        mUserPaddingRelative = false;
        // ---------- Original Method ----------
        //mContext = context;
        //mResources = context != null ? context.getResources() : null;
        //mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
        //mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        //setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
        //mUserPaddingStart = -1;
        //mUserPaddingEnd = -1;
        //mUserPaddingRelative = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.911 -0400", hash_original_method = "7A0AD99F840E8369EC476A6B56BA8ADA", hash_generated_method = "D878A93C1345BE8652B8CC2AFF1D23F2")
    public  View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.917 -0400", hash_original_method = "F8E7269105FB2D522A5F7FAB2F89EE95", hash_generated_method = "31C9E4D0F75FB66010F7ED39C6C4FDBB")
    public  View(Context context, AttributeSet attrs, int defStyle) {
        this(context);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.View,
                defStyle, 0);
        Drawable background = null;
        int leftPadding = -1;
        int topPadding = -1;
        int rightPadding = -1;
        int bottomPadding = -1;
        int startPadding = -1;
        int endPadding = -1;
        int padding = -1;
        int viewFlagValues = 0;
        int viewFlagMasks = 0;
        boolean setScrollContainer = false;
        int x = 0;
        int y = 0;
        float tx = 0;
        float ty = 0;
        float rotation = 0;
        float rotationX = 0;
        float rotationY = 0;
        float sx = 1f;
        float sy = 1f;
        boolean transformSet = false;
        int scrollbarStyle = SCROLLBARS_INSIDE_OVERLAY;
        int overScrollMode = mOverScrollMode;
        final int N = a.getIndexCount();
for(int i = 0;i < N;i++)
        {
            int attr = a.getIndex(i);
switch(attr){
            case com.android.internal.R.styleable.View_background:
            background = a.getDrawable(attr);
            break;
            case com.android.internal.R.styleable.View_padding:
            padding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_paddingLeft:
            leftPadding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_paddingTop:
            topPadding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_paddingRight:
            rightPadding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_paddingBottom:
            bottomPadding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_paddingStart:
            startPadding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_paddingEnd:
            endPadding = a.getDimensionPixelSize(attr, -1);
            break;
            case com.android.internal.R.styleable.View_scrollX:
            x = a.getDimensionPixelOffset(attr, 0);
            break;
            case com.android.internal.R.styleable.View_scrollY:
            y = a.getDimensionPixelOffset(attr, 0);
            break;
            case com.android.internal.R.styleable.View_alpha:
            setAlpha(a.getFloat(attr, 1f));
            break;
            case com.android.internal.R.styleable.View_transformPivotX:
            setPivotX(a.getDimensionPixelOffset(attr, 0));
            break;
            case com.android.internal.R.styleable.View_transformPivotY:
            setPivotY(a.getDimensionPixelOffset(attr, 0));
            break;
            case com.android.internal.R.styleable.View_translationX:
            tx = a.getDimensionPixelOffset(attr, 0);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_translationY:
            ty = a.getDimensionPixelOffset(attr, 0);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_rotation:
            rotation = a.getFloat(attr, 0);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_rotationX:
            rotationX = a.getFloat(attr, 0);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_rotationY:
            rotationY = a.getFloat(attr, 0);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_scaleX:
            sx = a.getFloat(attr, 1f);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_scaleY:
            sy = a.getFloat(attr, 1f);
            transformSet = true;
            break;
            case com.android.internal.R.styleable.View_id:
            mID = a.getResourceId(attr, NO_ID);
            break;
            case com.android.internal.R.styleable.View_tag:
            mTag = a.getText(attr);
            break;
            case com.android.internal.R.styleable.View_fitsSystemWindows:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= FITS_SYSTEM_WINDOWS;
                viewFlagMasks |= FITS_SYSTEM_WINDOWS;
            } //End block
            break;
            case com.android.internal.R.styleable.View_focusable:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= FOCUSABLE;
                viewFlagMasks |= FOCUSABLE_MASK;
            } //End block
            break;
            case com.android.internal.R.styleable.View_focusableInTouchMode:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE;
                viewFlagMasks |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE_MASK;
            } //End block
            break;
            case com.android.internal.R.styleable.View_clickable:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= CLICKABLE;
                viewFlagMasks |= CLICKABLE;
            } //End block
            break;
            case com.android.internal.R.styleable.View_longClickable:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= LONG_CLICKABLE;
                viewFlagMasks |= LONG_CLICKABLE;
            } //End block
            break;
            case com.android.internal.R.styleable.View_saveEnabled:
    if(!a.getBoolean(attr, true))            
            {
                viewFlagValues |= SAVE_DISABLED;
                viewFlagMasks |= SAVE_DISABLED_MASK;
            } //End block
            break;
            case com.android.internal.R.styleable.View_duplicateParentState:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= DUPLICATE_PARENT_STATE;
                viewFlagMasks |= DUPLICATE_PARENT_STATE;
            } //End block
            break;
            case com.android.internal.R.styleable.View_visibility:
            final int visibility = a.getInt(attr, 0);
    if(visibility != 0)            
            {
                viewFlagValues |= VISIBILITY_FLAGS[visibility];
                viewFlagMasks |= VISIBILITY_MASK;
            } //End block
            break;
            case com.android.internal.R.styleable.View_layoutDirection:
            viewFlagValues &= ~LAYOUT_DIRECTION_MASK;
            final int layoutDirection = a.getInt(attr, -1);
    if(layoutDirection != -1)            
            {
                viewFlagValues |= LAYOUT_DIRECTION_FLAGS[layoutDirection];
            } //End block
            else
            {
                viewFlagValues |= LAYOUT_DIRECTION_DEFAULT;
            } //End block
            viewFlagMasks |= LAYOUT_DIRECTION_MASK;
            break;
            case com.android.internal.R.styleable.View_drawingCacheQuality:
            final int cacheQuality = a.getInt(attr, 0);
    if(cacheQuality != 0)            
            {
                viewFlagValues |= DRAWING_CACHE_QUALITY_FLAGS[cacheQuality];
                viewFlagMasks |= DRAWING_CACHE_QUALITY_MASK;
            } //End block
            break;
            case com.android.internal.R.styleable.View_contentDescription:
            mContentDescription = a.getString(attr);
            break;
            case com.android.internal.R.styleable.View_soundEffectsEnabled:
    if(!a.getBoolean(attr, true))            
            {
                viewFlagValues &= ~SOUND_EFFECTS_ENABLED;
                viewFlagMasks |= SOUND_EFFECTS_ENABLED;
            } //End block
            break;
            case com.android.internal.R.styleable.View_hapticFeedbackEnabled:
    if(!a.getBoolean(attr, true))            
            {
                viewFlagValues &= ~HAPTIC_FEEDBACK_ENABLED;
                viewFlagMasks |= HAPTIC_FEEDBACK_ENABLED;
            } //End block
            break;
            case R.styleable.View_scrollbars:
            final int scrollbars = a.getInt(attr, SCROLLBARS_NONE);
    if(scrollbars != SCROLLBARS_NONE)            
            {
                viewFlagValues |= scrollbars;
                viewFlagMasks |= SCROLLBARS_MASK;
                initializeScrollbars(a);
            } //End block
            break;
            case R.styleable.View_fadingEdge:
    if(context.getApplicationInfo().targetSdkVersion >= ICE_CREAM_SANDWICH)            
            {
                break;
            } //End block
            case R.styleable.View_requiresFadingEdge:
            final int fadingEdge = a.getInt(attr, FADING_EDGE_NONE);
    if(fadingEdge != FADING_EDGE_NONE)            
            {
                viewFlagValues |= fadingEdge;
                viewFlagMasks |= FADING_EDGE_MASK;
                initializeFadingEdge(a);
            } //End block
            break;
            case R.styleable.View_scrollbarStyle:
            scrollbarStyle = a.getInt(attr, SCROLLBARS_INSIDE_OVERLAY);
    if(scrollbarStyle != SCROLLBARS_INSIDE_OVERLAY)            
            {
                viewFlagValues |= scrollbarStyle & SCROLLBARS_STYLE_MASK;
                viewFlagMasks |= SCROLLBARS_STYLE_MASK;
            } //End block
            break;
            case R.styleable.View_isScrollContainer:
            setScrollContainer = true;
    if(a.getBoolean(attr, false))            
            {
                setScrollContainer(true);
            } //End block
            break;
            case com.android.internal.R.styleable.View_keepScreenOn:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= KEEP_SCREEN_ON;
                viewFlagMasks |= KEEP_SCREEN_ON;
            } //End block
            break;
            case R.styleable.View_filterTouchesWhenObscured:
    if(a.getBoolean(attr, false))            
            {
                viewFlagValues |= FILTER_TOUCHES_WHEN_OBSCURED;
                viewFlagMasks |= FILTER_TOUCHES_WHEN_OBSCURED;
            } //End block
            break;
            case R.styleable.View_nextFocusLeft:
            mNextFocusLeftId = a.getResourceId(attr, View.NO_ID);
            break;
            case R.styleable.View_nextFocusRight:
            mNextFocusRightId = a.getResourceId(attr, View.NO_ID);
            break;
            case R.styleable.View_nextFocusUp:
            mNextFocusUpId = a.getResourceId(attr, View.NO_ID);
            break;
            case R.styleable.View_nextFocusDown:
            mNextFocusDownId = a.getResourceId(attr, View.NO_ID);
            break;
            case R.styleable.View_nextFocusForward:
            mNextFocusForwardId = a.getResourceId(attr, View.NO_ID);
            break;
            case R.styleable.View_minWidth:
            mMinWidth = a.getDimensionPixelSize(attr, 0);
            break;
            case R.styleable.View_minHeight:
            mMinHeight = a.getDimensionPixelSize(attr, 0);
            break;
            case R.styleable.View_onClick:
    if(context.isRestricted())            
            {
                IllegalStateException varE51FA648E43677A316E33BB1DE286CFC_541366472 = new IllegalStateException("The android:onClick attribute cannot "
                                + "be used within a restricted context");
                varE51FA648E43677A316E33BB1DE286CFC_541366472.addTaint(taint);
                throw varE51FA648E43677A316E33BB1DE286CFC_541366472;
            } //End block
            final String handlerName = a.getString(attr);
    if(handlerName != null)            
            {
                setOnClickListener(new OnClickListener() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.914 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "DD76E21366B40D00A372B0BC0CE30131")
        private Method mHandler;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.915 -0400", hash_original_method = "E9EFDD10534D1BAF541333BA74E853ED", hash_generated_method = "4A71CBF4D598208029A9597E8D378AA3")
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(v.getTaint());
    if(mHandler == null)            
            {
                try 
                {
                    mHandler = getContext().getClass().getMethod(handlerName,
                                                View.class);
                } //End block
                catch (NoSuchMethodException e)
                {
                    int id = getId();
                    String idText = id == NO_ID ? "" : " with id '"
                                                + getContext().getResources().getResourceEntryName(
                                                    id) + "'";
                    IllegalStateException varF3B771E137207AA2F5CB949A3ADC229B_2035788293 = new IllegalStateException("Could not find a method " +
                                                handlerName + "(View) in the activity "
                                                + getContext().getClass() + " for onClick handler"
                                                + " on view " + View.this.getClass() + idText, e);
                    varF3B771E137207AA2F5CB949A3ADC229B_2035788293.addTaint(taint);
                    throw varF3B771E137207AA2F5CB949A3ADC229B_2035788293;
                } //End block
            } //End block
            try 
            {
                mHandler.invoke(getContext(), View.this);
            } //End block
            catch (IllegalAccessException e)
            {
                IllegalStateException var8126889157D59676B595335189356A9C_1518155080 = new IllegalStateException("Could not execute non "
                                            + "public method of the activity", e);
                var8126889157D59676B595335189356A9C_1518155080.addTaint(taint);
                throw var8126889157D59676B595335189356A9C_1518155080;
            } //End block
            catch (InvocationTargetException e)
            {
                IllegalStateException varBD0AFB7A57DFE3E40CDB543B0F4EA3BD_1583611490 = new IllegalStateException("Could not execute "
                                            + "method of the activity", e);
                varBD0AFB7A57DFE3E40CDB543B0F4EA3BD_1583611490.addTaint(taint);
                throw varBD0AFB7A57DFE3E40CDB543B0F4EA3BD_1583611490;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
});
            } //End block
            break;
            case R.styleable.View_overScrollMode:
            overScrollMode = a.getInt(attr, OVER_SCROLL_IF_CONTENT_SCROLLS);
            break;
            case R.styleable.View_verticalScrollbarPosition:
            mVerticalScrollbarPosition = a.getInt(attr, SCROLLBAR_POSITION_DEFAULT);
            break;
            case R.styleable.View_layerType:
            setLayerType(a.getInt(attr, LAYER_TYPE_NONE), null);
            break;
            case R.styleable.View_textDirection:
            mTextDirection = a.getInt(attr, DEFAULT_TEXT_DIRECTION);
            break;
}
        } //End block
        a.recycle();
        setOverScrollMode(overScrollMode);
    if(background != null)        
        {
            setBackgroundDrawable(background);
        } //End block
        mUserPaddingRelative = (startPadding >= 0 || endPadding >= 0);
        mUserPaddingStart = startPadding;
        mUserPaddingEnd = endPadding;
    if(padding >= 0)        
        {
            leftPadding = padding;
            topPadding = padding;
            rightPadding = padding;
            bottomPadding = padding;
        } //End block
        setPadding(leftPadding >= 0 ? leftPadding : mPaddingLeft,
                topPadding >= 0 ? topPadding : mPaddingTop,
                rightPadding >= 0 ? rightPadding : mPaddingRight,
                bottomPadding >= 0 ? bottomPadding : mPaddingBottom);
    if(viewFlagMasks != 0)        
        {
            setFlags(viewFlagValues, viewFlagMasks);
        } //End block
    if(scrollbarStyle != SCROLLBARS_INSIDE_OVERLAY)        
        {
            recomputePadding();
        } //End block
    if(x != 0 || y != 0)        
        {
            scrollTo(x, y);
        } //End block
    if(transformSet)        
        {
            setTranslationX(tx);
            setTranslationY(ty);
            setRotation(rotation);
            setRotationX(rotationX);
            setRotationY(rotationY);
            setScaleX(sx);
            setScaleY(sy);
        } //End block
    if(!setScrollContainer && (viewFlagValues&SCROLLBARS_VERTICAL) != 0)        
        {
            setScrollContainer(true);
        } //End block
        computeOpaqueFlags();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.918 -0400", hash_original_method = "5C3A364FECC6F7D07E7A546170C25E98", hash_generated_method = "32A2A5FFE588BE14FBF7F5D017C5A252")
      View() {
        mResources = null;
        // ---------- Original Method ----------
        //mResources = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.919 -0400", hash_original_method = "F39CEBF0E5E47A818635618D8F975382", hash_generated_method = "D576B5DC26D7FBDAD21E367A9288C3E9")
    protected void initializeFadingEdge(TypedArray a) {
        initScrollCache();
        mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                R.styleable.View_fadingEdgeLength,
                ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
        // ---------- Original Method ----------
        //initScrollCache();
        //mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                //R.styleable.View_fadingEdgeLength,
                //ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.931 -0400", hash_original_method = "48BE981E65F7E857DD7A9FF8EF5006FF", hash_generated_method = "4ADB2D329E04489FDCF42605530DA805")
    public int getVerticalFadingEdgeLength() {
    if(isVerticalFadingEdgeEnabled())        
        {
            ScrollabilityCache cache = mScrollCache;
    if(cache != null)            
            {
                int varD5CEEE2ED71663847F4E3FFDE4BF21F8_1451302868 = (cache.fadingEdgeLength);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296690124 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_296690124;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_477044215 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906256538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906256538;
        // ---------- Original Method ----------
        //if (isVerticalFadingEdgeEnabled()) {
            //ScrollabilityCache cache = mScrollCache;
            //if (cache != null) {
                //return cache.fadingEdgeLength;
            //}
        //}
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.937 -0400", hash_original_method = "F316E2F78DFC9160954B8650C58C0898", hash_generated_method = "09B2620993C628341922180F596184D1")
    public void setFadingEdgeLength(int length) {
        initScrollCache();
        mScrollCache.fadingEdgeLength = length;
        // ---------- Original Method ----------
        //initScrollCache();
        //mScrollCache.fadingEdgeLength = length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.937 -0400", hash_original_method = "A8651530AFA26393AFB5F6425B22CDCD", hash_generated_method = "85D98B90A9D8EE79A38EB512DF1A6D69")
    public int getHorizontalFadingEdgeLength() {
    if(isHorizontalFadingEdgeEnabled())        
        {
            ScrollabilityCache cache = mScrollCache;
    if(cache != null)            
            {
                int varD5CEEE2ED71663847F4E3FFDE4BF21F8_591209508 = (cache.fadingEdgeLength);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559011171 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559011171;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_969233282 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433509253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433509253;
        // ---------- Original Method ----------
        //if (isHorizontalFadingEdgeEnabled()) {
            //ScrollabilityCache cache = mScrollCache;
            //if (cache != null) {
                //return cache.fadingEdgeLength;
            //}
        //}
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.938 -0400", hash_original_method = "9E8BEE4EA7290E77910774FBF44231C2", hash_generated_method = "BBFEE8BEAD13C54442FDE95F4C3340D5")
    public int getVerticalScrollbarWidth() {
        ScrollabilityCache cache = mScrollCache;
    if(cache != null)        
        {
            ScrollBarDrawable scrollBar = cache.scrollBar;
    if(scrollBar != null)            
            {
                int size = scrollBar.getSize(true);
    if(size <= 0)                
                {
                    size = cache.scrollBarSize;
                } //End block
                int varF7BD60B75B29D79B660A2859395C1A24_380825581 = (size);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219054655 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_219054655;
            } //End block
            int varCFCD208495D565EF66E7DFF9F98764DA_1477035916 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208923257 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208923257;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_19626349 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590498526 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590498526;
        // ---------- Original Method ----------
        //ScrollabilityCache cache = mScrollCache;
        //if (cache != null) {
            //ScrollBarDrawable scrollBar = cache.scrollBar;
            //if (scrollBar != null) {
                //int size = scrollBar.getSize(true);
                //if (size <= 0) {
                    //size = cache.scrollBarSize;
                //}
                //return size;
            //}
            //return 0;
        //}
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.938 -0400", hash_original_method = "6872C13C59C68BCC5CF5DE777A5D5AA0", hash_generated_method = "0373C63C90AD8887017CD2E8C331958C")
    protected int getHorizontalScrollbarHeight() {
        ScrollabilityCache cache = mScrollCache;
    if(cache != null)        
        {
            ScrollBarDrawable scrollBar = cache.scrollBar;
    if(scrollBar != null)            
            {
                int size = scrollBar.getSize(false);
    if(size <= 0)                
                {
                    size = cache.scrollBarSize;
                } //End block
                int varF7BD60B75B29D79B660A2859395C1A24_2126302250 = (size);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491649976 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491649976;
            } //End block
            int varCFCD208495D565EF66E7DFF9F98764DA_995493141 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689969693 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689969693;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_630178466 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062618510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062618510;
        // ---------- Original Method ----------
        //ScrollabilityCache cache = mScrollCache;
        //if (cache != null) {
            //ScrollBarDrawable scrollBar = cache.scrollBar;
            //if (scrollBar != null) {
                //int size = scrollBar.getSize(false);
                //if (size <= 0) {
                    //size = cache.scrollBarSize;
                //}
                //return size;
            //}
            //return 0;
        //}
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.940 -0400", hash_original_method = "92AEC3F31170B251C0CC405CA4D3250A", hash_generated_method = "DBA018743E478D845AB9FDEE5FC9EC23")
    protected void initializeScrollbars(TypedArray a) {
        addTaint(a.getTaint());
        initScrollCache();
        final ScrollabilityCache scrollabilityCache = mScrollCache;
    if(scrollabilityCache.scrollBar == null)        
        {
            scrollabilityCache.scrollBar = new ScrollBarDrawable();
        } //End block
        final boolean fadeScrollbars = a.getBoolean(R.styleable.View_fadeScrollbars, true);
    if(!fadeScrollbars)        
        {
            scrollabilityCache.state = ScrollabilityCache.ON;
        } //End block
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
        scrollabilityCache.scrollBarFadeDuration = a.getInt(
                R.styleable.View_scrollbarFadeDuration, ViewConfiguration
                        .getScrollBarFadeDuration());
        scrollabilityCache.scrollBarDefaultDelayBeforeFade = a.getInt(
                R.styleable.View_scrollbarDefaultDelayBeforeFade,
                ViewConfiguration.getScrollDefaultDelay());
        scrollabilityCache.scrollBarSize = a.getDimensionPixelSize(
                com.android.internal.R.styleable.View_scrollbarSize,
                ViewConfiguration.get(mContext).getScaledScrollBarSize());
        Drawable track = a.getDrawable(R.styleable.View_scrollbarTrackHorizontal);
        scrollabilityCache.scrollBar.setHorizontalTrackDrawable(track);
        Drawable thumb = a.getDrawable(R.styleable.View_scrollbarThumbHorizontal);
    if(thumb != null)        
        {
            scrollabilityCache.scrollBar.setHorizontalThumbDrawable(thumb);
        } //End block
        boolean alwaysDraw = a.getBoolean(R.styleable.View_scrollbarAlwaysDrawHorizontalTrack,
                false);
    if(alwaysDraw)        
        {
            scrollabilityCache.scrollBar.setAlwaysDrawHorizontalTrack(true);
        } //End block
        track = a.getDrawable(R.styleable.View_scrollbarTrackVertical);
        scrollabilityCache.scrollBar.setVerticalTrackDrawable(track);
        thumb = a.getDrawable(R.styleable.View_scrollbarThumbVertical);
    if(thumb != null)        
        {
            scrollabilityCache.scrollBar.setVerticalThumbDrawable(thumb);
        } //End block
        alwaysDraw = a.getBoolean(R.styleable.View_scrollbarAlwaysDrawVerticalTrack,
                false);
    if(alwaysDraw)        
        {
            scrollabilityCache.scrollBar.setAlwaysDrawVerticalTrack(true);
        } //End block
        resolvePadding();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.941 -0400", hash_original_method = "E049E8AF463EFBD39046D8F102EAF6B1", hash_generated_method = "BD8F7E36279B703FA59C33BDDA8DC2D1")
    private void initScrollCache() {
    if(mScrollCache == null)        
        {
            mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        } //End block
        // ---------- Original Method ----------
        //if (mScrollCache == null) {
            //mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.941 -0400", hash_original_method = "6A347D034BA88A40E4761231BE70B8AA", hash_generated_method = "DC8DD37A582D7EA564F70E0F42580729")
    public void setVerticalScrollbarPosition(int position) {
    if(mVerticalScrollbarPosition != position)        
        {
            mVerticalScrollbarPosition = position;
            computeOpaqueFlags();
            resolvePadding();
        } //End block
        // ---------- Original Method ----------
        //if (mVerticalScrollbarPosition != position) {
            //mVerticalScrollbarPosition = position;
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.942 -0400", hash_original_method = "0B028AFE1E9609D00D97AC9B679932DA", hash_generated_method = "813B4028205126FDD723623F55FB03C4")
    public int getVerticalScrollbarPosition() {
        int var87A1A37696C42230D03AF78A00037CA3_236185378 = (mVerticalScrollbarPosition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237429813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1237429813;
        // ---------- Original Method ----------
        //return mVerticalScrollbarPosition;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.942 -0400", hash_original_method = "3F6307E0FF2B24CF42D639D72702E7A3", hash_generated_method = "39C6FC6A0F858D3EDC2B285C27F68BB7")
     ListenerInfo getListenerInfo() {
    if(mListenerInfo != null)        
        {
ListenerInfo var5D4BC06FD98F42A8938BDDA15C13018A_315978357 =             mListenerInfo;
            var5D4BC06FD98F42A8938BDDA15C13018A_315978357.addTaint(taint);
            return var5D4BC06FD98F42A8938BDDA15C13018A_315978357;
        } //End block
        mListenerInfo = new ListenerInfo();
ListenerInfo var5D4BC06FD98F42A8938BDDA15C13018A_1490505371 =         mListenerInfo;
        var5D4BC06FD98F42A8938BDDA15C13018A_1490505371.addTaint(taint);
        return var5D4BC06FD98F42A8938BDDA15C13018A_1490505371;
        // ---------- Original Method ----------
        //if (mListenerInfo != null) {
            //return mListenerInfo;
        //}
        //mListenerInfo = new ListenerInfo();
        //return mListenerInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.943 -0400", hash_original_method = "D8AB5E19AA18F69BACA6EC368D2591FE", hash_generated_method = "918230E096603C3A4A7260C7ED46A6CC")
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnFocusChangeListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnFocusChangeListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.943 -0400", hash_original_method = "E2DB3817E7DB5D233E4A7D6EADE958A3", hash_generated_method = "651AA8E38276B9A73263B45BB3AAFCCD")
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        addTaint(listener.getTaint());
        ListenerInfo li = getListenerInfo();
    if(li.mOnLayoutChangeListeners == null)        
        {
            li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        } //End block
    if(!li.mOnLayoutChangeListeners.contains(listener))        
        {
            li.mOnLayoutChangeListeners.add(listener);
        } //End block
        // ---------- Original Method ----------
        //ListenerInfo li = getListenerInfo();
        //if (li.mOnLayoutChangeListeners == null) {
            //li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        //}
        //if (!li.mOnLayoutChangeListeners.contains(listener)) {
            //li.mOnLayoutChangeListeners.add(listener);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.943 -0400", hash_original_method = "98A56C49B0A9E0F5D269641F74288A13", hash_generated_method = "05B5EFC21B52262D91A5FC0E348E16CF")
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        addTaint(listener.getTaint());
        ListenerInfo li = mListenerInfo;
    if(li == null || li.mOnLayoutChangeListeners == null)        
        {
            return;
        } //End block
        li.mOnLayoutChangeListeners.remove(listener);
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li == null || li.mOnLayoutChangeListeners == null) {
            //return;
        //}
        //li.mOnLayoutChangeListeners.remove(listener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.944 -0400", hash_original_method = "BCC986125DE454FD64FA8CF6FF7B3375", hash_generated_method = "66797AD8E3C9495B63661C435054CACB")
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        addTaint(listener.getTaint());
        ListenerInfo li = getListenerInfo();
    if(li.mOnAttachStateChangeListeners == null)        
        {
            li.mOnAttachStateChangeListeners
                    = new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        } //End block
        li.mOnAttachStateChangeListeners.add(listener);
        // ---------- Original Method ----------
        //ListenerInfo li = getListenerInfo();
        //if (li.mOnAttachStateChangeListeners == null) {
            //li.mOnAttachStateChangeListeners
                    //= new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        //}
        //li.mOnAttachStateChangeListeners.add(listener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.944 -0400", hash_original_method = "BB59F05E95A495FA9A30543444FC5E76", hash_generated_method = "C1E52E5DFA25A3894995839880C5E653")
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        addTaint(listener.getTaint());
        ListenerInfo li = mListenerInfo;
    if(li == null || li.mOnAttachStateChangeListeners == null)        
        {
            return;
        } //End block
        li.mOnAttachStateChangeListeners.remove(listener);
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li == null || li.mOnAttachStateChangeListeners == null) {
            //return;
        //}
        //li.mOnAttachStateChangeListeners.remove(listener);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.944 -0400", hash_original_method = "A3D291AC9D619397F7033ECE59D11B86", hash_generated_method = "EBAB28BFC9C71ECB5BB6146A439FD435")
    public OnFocusChangeListener getOnFocusChangeListener() {
        ListenerInfo li = mListenerInfo;
OnFocusChangeListener var29F540C0B1ABCCAD45EDB3ADF0206923_1609921342 =         li != null ? li.mOnFocusChangeListener : null;
        var29F540C0B1ABCCAD45EDB3ADF0206923_1609921342.addTaint(taint);
        return var29F540C0B1ABCCAD45EDB3ADF0206923_1609921342;
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //return li != null ? li.mOnFocusChangeListener : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.945 -0400", hash_original_method = "45F4C058CBC73D55564FBEB6E17C2099", hash_generated_method = "2CCF413D10B18F4710B861DAA8D2C468")
    public void setOnClickListener(OnClickListener l) {
        addTaint(l.getTaint());
    if(!isClickable())        
        {
            setClickable(true);
        } //End block
        getListenerInfo().mOnClickListener = l;
        // ---------- Original Method ----------
        //if (!isClickable()) {
            //setClickable(true);
        //}
        //getListenerInfo().mOnClickListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.945 -0400", hash_original_method = "8038CCFA19DFF6DCB9855B2C21487DC3", hash_generated_method = "99C719F879BD50EB2FD9974C79CC6ACE")
    public boolean hasOnClickListeners() {
        ListenerInfo li = mListenerInfo;
        boolean varB7DF5224A9343701269F1EAEBF199236_298199672 = ((li != null && li.mOnClickListener != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577956193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577956193;
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //return (li != null && li.mOnClickListener != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.945 -0400", hash_original_method = "C88CD920669EF9D2067A739196536F5A", hash_generated_method = "D0D613F70C2942FC86B29E81BBEC02C7")
    public void setOnLongClickListener(OnLongClickListener l) {
        addTaint(l.getTaint());
    if(!isLongClickable())        
        {
            setLongClickable(true);
        } //End block
        getListenerInfo().mOnLongClickListener = l;
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //getListenerInfo().mOnLongClickListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.946 -0400", hash_original_method = "3B1D28314D3140C1C25951340EB50400", hash_generated_method = "F8603F3912CFECE5A51D58B35F52385B")
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        addTaint(l.getTaint());
    if(!isLongClickable())        
        {
            setLongClickable(true);
        } //End block
        getListenerInfo().mOnCreateContextMenuListener = l;
        // ---------- Original Method ----------
        //if (!isLongClickable()) {
            //setLongClickable(true);
        //}
        //getListenerInfo().mOnCreateContextMenuListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.946 -0400", hash_original_method = "F0CE5BDD9B8548BAC9D7A1A1FC9F10B8", hash_generated_method = "6A9722D42D498DB3D6276A0E5F5258B5")
    public boolean performClick() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnClickListener != null)        
        {
            playSoundEffect(SoundEffectConstants.CLICK);
            li.mOnClickListener.onClick(this);
            boolean varB326B5062B2F0E69046810717534CB09_836347314 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_671065208 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_671065208;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_934587757 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165434652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165434652;
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnClickListener != null) {
            //playSoundEffect(SoundEffectConstants.CLICK);
            //li.mOnClickListener.onClick(this);
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.946 -0400", hash_original_method = "102D936797B9C1FC40617DF92F54CFE2", hash_generated_method = "22805A011A17D0DB06A69756BAF66667")
    public boolean callOnClick() {
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnClickListener != null)        
        {
            li.mOnClickListener.onClick(this);
            boolean varB326B5062B2F0E69046810717534CB09_1139035492 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730574779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730574779;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1858737485 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244986542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244986542;
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnClickListener != null) {
            //li.mOnClickListener.onClick(this);
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.947 -0400", hash_original_method = "00035430EA6437DC8BB5C07835F45B65", hash_generated_method = "726FA3F3D9657B80A0B300B8FB22F256")
    public boolean performLongClick() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        boolean handled = false;
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnLongClickListener != null)        
        {
            handled = li.mOnLongClickListener.onLongClick(View.this);
        } //End block
    if(!handled)        
        {
            handled = showContextMenu();
        } //End block
    if(handled)        
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_605198636 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872577393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872577393;
        // ---------- Original Method ----------
        //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        //boolean handled = false;
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnLongClickListener != null) {
            //handled = li.mOnLongClickListener.onLongClick(View.this);
        //}
        //if (!handled) {
            //handled = showContextMenu();
        //}
        //if (handled) {
            //performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        //}
        //return handled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.948 -0400", hash_original_method = "0AFC4304DA44E934FA35FDC29342C80F", hash_generated_method = "D2D913F2F7FF808CF29766D6DEE55A18")
    protected boolean performButtonActionOnTouchDown(MotionEvent event) {
        addTaint(event.getTaint());
    if((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0)        
        {
    if(showContextMenu(event.getX(), event.getY(), event.getMetaState()))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_988771124 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541154525 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_541154525;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1332587124 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144312481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144312481;
        // ---------- Original Method ----------
        //if ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0) {
            //if (showContextMenu(event.getX(), event.getY(), event.getMetaState())) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.948 -0400", hash_original_method = "3A1C6F51C14FB3CA1856280BB08BDD78", hash_generated_method = "EC791FE1C54EAC8BC7D84B5AB59943FA")
    public boolean showContextMenu() {
        boolean var810785D06667E7621672A7F4FD0A8BEE_1485275386 = (getParent().showContextMenuForChild(this));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416135231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416135231;
        // ---------- Original Method ----------
        //return getParent().showContextMenuForChild(this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.948 -0400", hash_original_method = "B2C2D020E619A9A69ACCD76F29CBF0A8", hash_generated_method = "464290D11E451261442C3F7C53090C71")
    public boolean showContextMenu(float x, float y, int metaState) {
        addTaint(metaState);
        addTaint(y);
        addTaint(x);
        boolean var531ADFDCB5F70066112D2DB242F366E7_1261683662 = (showContextMenu());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804130827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804130827;
        // ---------- Original Method ----------
        //return showContextMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.949 -0400", hash_original_method = "554809A43858BFBD98E9D476D5975BC9", hash_generated_method = "08A5675AB5D65C1CDA6A0CD2A0F6B5D4")
    public ActionMode startActionMode(ActionMode.Callback callback) {
        addTaint(callback.getTaint());
ActionMode varFEE7D89FF8EA7E5929D2114BE8B8D7A0_1747337153 =         getParent().startActionModeForChild(this, callback);
        varFEE7D89FF8EA7E5929D2114BE8B8D7A0_1747337153.addTaint(taint);
        return varFEE7D89FF8EA7E5929D2114BE8B8D7A0_1747337153;
        // ---------- Original Method ----------
        //return getParent().startActionModeForChild(this, callback);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.949 -0400", hash_original_method = "31C7524DA5B5B98F54BA6C8BE0DEBF7E", hash_generated_method = "7FBB6E97E29E2B442479AA74A06DEACE")
    public void setOnKeyListener(OnKeyListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnKeyListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnKeyListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.949 -0400", hash_original_method = "D8E89DFA5C4F927FE4D243F514232285", hash_generated_method = "FAD93EF6065D966227DF0B34F5FA549E")
    public void setOnTouchListener(OnTouchListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnTouchListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnTouchListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.950 -0400", hash_original_method = "A6ED4A9DC8C6B322504EFE7525CB31A1", hash_generated_method = "78D2855DAFD24C14E31A59E4CC3ED53E")
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnGenericMotionListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnGenericMotionListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.950 -0400", hash_original_method = "A231A17C6E4AE608F5CD4B1132C585A7", hash_generated_method = "AF0F50527F36D4817ECABBCF52A7EDC4")
    public void setOnHoverListener(OnHoverListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnHoverListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnHoverListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.950 -0400", hash_original_method = "8FD55843B8D7F3FEDE7B7D516A1E3E35", hash_generated_method = "4CBBED9C856F5C2DFF6241158ECA507F")
    public void setOnDragListener(OnDragListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnDragListener = l;
        // ---------- Original Method ----------
        //getListenerInfo().mOnDragListener = l;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.951 -0400", hash_original_method = "16B5A8656CEB6785661CF48B92B45991", hash_generated_method = "86038C6982CE7DEC0FA567496521C1FA")
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if(DBG)        
        {
            System.out.println(this + " requestFocus()");
        } //End block
    if((mPrivateFlags & FOCUSED) == 0)        
        {
            mPrivateFlags |= FOCUSED;
    if(mParent != null)            
            {
                mParent.requestChildFocus(this, this);
            } //End block
            onFocusChanged(true, direction, previouslyFocusedRect);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " requestFocus()");
        //}
        //if ((mPrivateFlags & FOCUSED) == 0) {
            //mPrivateFlags |= FOCUSED;
            //if (mParent != null) {
                //mParent.requestChildFocus(this, this);
            //}
            //onFocusChanged(true, direction, previouslyFocusedRect);
            //refreshDrawableState();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.951 -0400", hash_original_method = "2192BF4A933C90A79FE0C71F9C0B2F3D", hash_generated_method = "ED6B88370DACD8B2C5553320D8B1182A")
    public boolean requestRectangleOnScreen(Rect rectangle) {
        addTaint(rectangle.getTaint());
        boolean var6C22E128DEEDDDA9433A4D4FCA50B790_2082874617 = (requestRectangleOnScreen(rectangle, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812730537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812730537;
        // ---------- Original Method ----------
        //return requestRectangleOnScreen(rectangle, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.952 -0400", hash_original_method = "BDB750CCBE647F1CD5444CDF496F66A3", hash_generated_method = "6D06E4DF391CA613673A3898F8AC5C07")
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        View child = this;
        ViewParent parent = mParent;
        boolean scrolled = false;
        while
(parent != null)        
        {
            scrolled |= parent.requestChildRectangleOnScreen(child,
                    rectangle, immediate);
            rectangle.offset(child.getLeft(), child.getTop());
            rectangle.offset(-child.getScrollX(), -child.getScrollY());
    if(!(parent instanceof View))            
            {
                break;
            } //End block
            child = (View) parent;
            parent = child.getParent();
        } //End block
        boolean var313315B0796120AF40F9657F89E85DC9_1559951135 = (scrolled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_878428421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_878428421;
        // ---------- Original Method ----------
        //View child = this;
        //ViewParent parent = mParent;
        //boolean scrolled = false;
        //while (parent != null) {
            //scrolled |= parent.requestChildRectangleOnScreen(child,
                    //rectangle, immediate);
            //rectangle.offset(child.getLeft(), child.getTop());
            //rectangle.offset(-child.getScrollX(), -child.getScrollY());
            //if (!(parent instanceof View)) {
                //break;
            //}
            //child = (View) parent;
            //parent = child.getParent();
        //}
        //return scrolled;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.952 -0400", hash_original_method = "A6F69BAD809415BD5537E3FD153C267F", hash_generated_method = "CCE0B8861F025083BB05C8299F2A68D4")
    public void clearFocus() {
    if(DBG)        
        {
            System.out.println(this + " clearFocus()");
        } //End block
    if((mPrivateFlags & FOCUSED) != 0)        
        {
            mPrivateFlags &= ~FOCUSED;
    if(mParent != null)            
            {
                mParent.clearChildFocus(this);
            } //End block
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " clearFocus()");
        //}
        //if ((mPrivateFlags & FOCUSED) != 0) {
            //mPrivateFlags &= ~FOCUSED;
            //if (mParent != null) {
                //mParent.clearChildFocus(this);
            //}
            //onFocusChanged(false, 0, null);
            //refreshDrawableState();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.953 -0400", hash_original_method = "B948A77A86E2A2242F3F753171415A6F", hash_generated_method = "FE17F0E7137F8F76CF80F5E68605B32D")
     void clearFocusForRemoval() {
    if((mPrivateFlags & FOCUSED) != 0)        
        {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if ((mPrivateFlags & FOCUSED) != 0) {
            //mPrivateFlags &= ~FOCUSED;
            //onFocusChanged(false, 0, null);
            //refreshDrawableState();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.953 -0400", hash_original_method = "895408B45B14DF7336768B76769FDFBE", hash_generated_method = "A02445737DBA548B20DD6CC71316BAAA")
     void unFocus() {
    if(DBG)        
        {
            System.out.println(this + " unFocus()");
        } //End block
    if((mPrivateFlags & FOCUSED) != 0)        
        {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " unFocus()");
        //}
        //if ((mPrivateFlags & FOCUSED) != 0) {
            //mPrivateFlags &= ~FOCUSED;
            //onFocusChanged(false, 0, null);
            //refreshDrawableState();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.953 -0400", hash_original_method = "337547862E6B052D2DEF8F8E7CCEA590", hash_generated_method = "C5D4A4463883C66C3F1E54952EB645FE")
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean hasFocus() {
        boolean varA8C13B6B5B465E10FA182C94781FB93A_1101088891 = ((mPrivateFlags & FOCUSED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288634604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288634604;
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.953 -0400", hash_original_method = "B2402A510BB29E4C255854E18659AE1B", hash_generated_method = "3545680A35E317F576E03C88CE4AFC6C")
    public boolean hasFocusable() {
        boolean var362276917823575EBD008E3A1CD60D55_2062982604 = ((mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1447549149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1447549149;
        // ---------- Original Method ----------
        //return (mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.954 -0400", hash_original_method = "5A1E14083BB718E6700BA53BA3884697", hash_generated_method = "3537513E8D9A61790D0698B725593122")
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        addTaint(gainFocus);
    if(gainFocus)        
        {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        } //End block
        InputMethodManager imm = InputMethodManager.peekInstance();
    if(!gainFocus)        
        {
    if(isPressed())            
            {
                setPressed(false);
            } //End block
    if(imm != null && mAttachInfo != null
                    && mAttachInfo.mHasWindowFocus)            
            {
                imm.focusOut(this);
            } //End block
            onFocusLost();
        } //End block
        else
    if(imm != null && mAttachInfo != null
                && mAttachInfo.mHasWindowFocus)        
        {
            imm.focusIn(this);
        } //End block
        invalidate(true);
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnFocusChangeListener != null)        
        {
            li.mOnFocusChangeListener.onFocusChange(this, gainFocus);
        } //End block
    if(mAttachInfo != null)        
        {
            mAttachInfo.mKeyDispatchState.reset(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.954 -0400", hash_original_method = "67C8279330D12E8D41FE4F9795D7EB79", hash_generated_method = "8787385EB5C454A76C874BA5EAC27C42")
    public void sendAccessibilityEvent(int eventType) {
        addTaint(eventType);
    if(mAccessibilityDelegate != null)        
        {
            mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        } //End block
        else
        {
            sendAccessibilityEventInternal(eventType);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        //} else {
            //sendAccessibilityEventInternal(eventType);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.954 -0400", hash_original_method = "BE2AB20B544FD38FEA2111E9FF446FAD", hash_generated_method = "E24CAE2B035F29D987D7802B1BE6AF63")
     void sendAccessibilityEventInternal(int eventType) {
        addTaint(eventType);
    if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
        } //End block
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.954 -0400", hash_original_method = "B790306D0C64AC6AB0D8747A1C899258", hash_generated_method = "334E6AFF4A11C90C99B39CE2804D92A6")
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        addTaint(event.getTaint());
    if(mAccessibilityDelegate != null)        
        {
            mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        } //End block
        else
        {
            sendAccessibilityEventUncheckedInternal(event);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
           //mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        //} else {
            //sendAccessibilityEventUncheckedInternal(event);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "2BAF48857D95094002D2EF1740E1384F", hash_generated_method = "C7DBE6158C47B48C69BA6A9AB61BAECA")
     void sendAccessibilityEventUncheckedInternal(AccessibilityEvent event) {
        addTaint(event.getTaint());
    if(!isShown())        
        {
            return;
        } //End block
        onInitializeAccessibilityEvent(event);
    if((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0)        
        {
            dispatchPopulateAccessibilityEvent(event);
        } //End block
        getParent().requestSendAccessibilityEvent(this, event);
        // ---------- Original Method ----------
        //if (!isShown()) {
            //return;
        //}
        //onInitializeAccessibilityEvent(event);
        //if ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0) {
            //dispatchPopulateAccessibilityEvent(event);
        //}
        //getParent().requestSendAccessibilityEvent(this, event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "927EED19E22DB3C930EC71946191C691", hash_generated_method = "B0F7BE9B5CEBD04FBE951DD2344F1941")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
    if(mAccessibilityDelegate != null)        
        {
            boolean var0851FE78AFFFEFA413DB64CA7D437E67_326085556 = (mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408175884 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408175884;
        } //End block
        else
        {
            boolean var5EEDBC4EA216C902C631B436BB1DD00F_2140383082 = (dispatchPopulateAccessibilityEventInternal(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752675340 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752675340;
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event);
        //} else {
            //return dispatchPopulateAccessibilityEventInternal(event);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "8EC2668F1DC902F63C332D19DDE36094", hash_generated_method = "3099DA3D6418829BE171D5D57512CE8D")
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        addTaint(event.getTaint());
        onPopulateAccessibilityEvent(event);
        boolean var68934A3E9455FA72420237EB05902327_1594058250 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557595782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_557595782;
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "A0DF1F515FF193F86B7E130DE16E38CE", hash_generated_method = "038B89549376715CCFD53990AC057473")
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mAccessibilityDelegate != null)        
        {
            mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        } //End block
        else
        {
            onPopulateAccessibilityEventInternal(event);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        //} else {
            //onPopulateAccessibilityEventInternal(event);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "CF40AA9C4C55BD5A22FC0E76716C7875", hash_generated_method = "C1E3420DDE9B8190E6B3E3D06A3CF139")
     void onPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "28310CBBAED9E8F097DF5C90DBA9CD0F", hash_generated_method = "20CE5765E838F77955F3F895FAE93A0F")
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if(mAccessibilityDelegate != null)        
        {
            mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        } //End block
        else
        {
            onInitializeAccessibilityEventInternal(event);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        //} else {
            //onInitializeAccessibilityEventInternal(event);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.955 -0400", hash_original_method = "43B5B6E634D7CF960BF74CE0E1DDA2CD", hash_generated_method = "FA3510234BDA67A644B2E262ECB1F963")
     void onInitializeAccessibilityEventInternal(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        event.setSource(this);
        event.setClassName(getClass().getName());
        event.setPackageName(getContext().getPackageName());
        event.setEnabled(isEnabled());
        event.setContentDescription(mContentDescription);
    if(event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null)        
        {
            ArrayList<View> focusablesTempList = mAttachInfo.mFocusablesTempList;
            getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    FOCUSABLES_ALL);
            event.setItemCount(focusablesTempList.size());
            event.setCurrentItemIndex(focusablesTempList.indexOf(this));
            focusablesTempList.clear();
        } //End block
        // ---------- Original Method ----------
        //event.setSource(this);
        //event.setClassName(getClass().getName());
        //event.setPackageName(getContext().getPackageName());
        //event.setEnabled(isEnabled());
        //event.setContentDescription(mContentDescription);
        //if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null) {
            //ArrayList<View> focusablesTempList = mAttachInfo.mFocusablesTempList;
            //getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    //FOCUSABLES_ALL);
            //event.setItemCount(focusablesTempList.size());
            //event.setCurrentItemIndex(focusablesTempList.indexOf(this));
            //focusablesTempList.clear();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.956 -0400", hash_original_method = "53F1596AC086DF0FD9B166B1443D793C", hash_generated_method = "690D06F8ED984224C2F211EC1DFE708A")
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this);
        onInitializeAccessibilityNodeInfo(info);
AccessibilityNodeInfo var43CF3338FDBA93597A9562D3166E9DC4_1415261734 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_1415261734.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_1415261734;
        // ---------- Original Method ----------
        //AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this);
        //onInitializeAccessibilityNodeInfo(info);
        //return info;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.956 -0400", hash_original_method = "BE2067901E907368432A8D9CCB431457", hash_generated_method = "667540D9606AD351E25D36EA96F006F9")
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
    if(mAccessibilityDelegate != null)        
        {
            mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        } //End block
        else
        {
            onInitializeAccessibilityNodeInfoInternal(info);
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        //} else {
            //onInitializeAccessibilityNodeInfoInternal(info);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.956 -0400", hash_original_method = "8753AD1110C37F0E73AF31B4448B5211", hash_generated_method = "F048C8A6A4BEB16F6AF9505B333AD392")
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        Rect bounds = mAttachInfo.mTmpInvalRect;
        getDrawingRect(bounds);
        info.setBoundsInParent(bounds);
        int[] locationOnScreen = mAttachInfo.mInvalidateChildLocation;
        getLocationOnScreen(locationOnScreen);
        bounds.offsetTo(0, 0);
        bounds.offset(locationOnScreen[0], locationOnScreen[1]);
        info.setBoundsInScreen(bounds);
    if((mPrivateFlags & IS_ROOT_NAMESPACE) == 0)        
        {
            ViewParent parent = getParent();
    if(parent instanceof View)            
            {
                View parentView = (View) parent;
                info.setParent(parentView);
            } //End block
        } //End block
        info.setPackageName(mContext.getPackageName());
        info.setClassName(getClass().getName());
        info.setContentDescription(getContentDescription());
        info.setEnabled(isEnabled());
        info.setClickable(isClickable());
        info.setFocusable(isFocusable());
        info.setFocused(isFocused());
        info.setSelected(isSelected());
        info.setLongClickable(isLongClickable());
        info.addAction(AccessibilityNodeInfo.ACTION_SELECT);
        info.addAction(AccessibilityNodeInfo.ACTION_CLEAR_SELECTION);
    if(isFocusable())        
        {
    if(isFocused())            
            {
                info.addAction(AccessibilityNodeInfo.ACTION_CLEAR_FOCUS);
            } //End block
            else
            {
                info.addAction(AccessibilityNodeInfo.ACTION_FOCUS);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.956 -0400", hash_original_method = "32F138BD45B7179C5519FF8B12AC5296", hash_generated_method = "54FEEF3A1A1C934FEB709560757E0564")
    public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        mAccessibilityDelegate = delegate;
        // ---------- Original Method ----------
        //mAccessibilityDelegate = delegate;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.956 -0400", hash_original_method = "64D1C3C95C84965C0C27E168EBDF3A77", hash_generated_method = "48E306CD51E0DD5D7685DC6116385937")
    public int getAccessibilityViewId() {
    if(mAccessibilityViewId == NO_ID)        
        {
            mAccessibilityViewId = sNextAccessibilityViewId++;
        } //End block
        int var9140D290AFC23A58A4FF1FDDABD634FC_692548164 = (mAccessibilityViewId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097364185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097364185;
        // ---------- Original Method ----------
        //if (mAccessibilityViewId == NO_ID) {
            //mAccessibilityViewId = sNextAccessibilityViewId++;
        //}
        //return mAccessibilityViewId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "ABBCC5D3939BB662168BF84991E4D81C", hash_generated_method = "3E7A842B0AF1414263D783BAD95F2835")
    public int getAccessibilityWindowId() {
        int var1E80B0C126519D5AEEB1ED17933A1FF3_566941638 = (mAttachInfo != null ? mAttachInfo.mAccessibilityWindowId : NO_ID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720551294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720551294;
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mAccessibilityWindowId : NO_ID;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "2CD9E0E97E52CCA7F083B08EF82790BD")
    public CharSequence getContentDescription() {
CharSequence varDF4802B31F5D315C6875E7B89F1B2E58_1144752222 =         mContentDescription;
        varDF4802B31F5D315C6875E7B89F1B2E58_1144752222.addTaint(taint);
        return varDF4802B31F5D315C6875E7B89F1B2E58_1144752222;
        // ---------- Original Method ----------
        //return mContentDescription;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "1087954D5CDD3C4C18E361D3DD728844", hash_generated_method = "6C6918B8BBDB2D7D09C9C3B313E5E324")
    @RemotableViewMethod
    public void setContentDescription(CharSequence contentDescription) {
        mContentDescription = contentDescription;
        // ---------- Original Method ----------
        //mContentDescription = contentDescription;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "5C1A3C599F20DF55DE3C4471944CAAB7", hash_generated_method = "38E1F736D1D0CE663B8F46A26D06B1FF")
    protected void onFocusLost() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        resetPressedState();
        // ---------- Original Method ----------
        //resetPressedState();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "81136F7A8F96E00E1C77CED95B4F9DA3", hash_generated_method = "B9A604A279F70F377F3C100837C592DA")
    private void resetPressedState() {
    if((mViewFlags & ENABLED_MASK) == DISABLED)        
        {
            return;
        } //End block
    if(isPressed())        
        {
            setPressed(false);
    if(!mHasPerformedLongPress)            
            {
                removeLongPressCallback();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((mViewFlags & ENABLED_MASK) == DISABLED) {
            //return;
        //}
        //if (isPressed()) {
            //setPressed(false);
            //if (!mHasPerformedLongPress) {
                //removeLongPressCallback();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "BAE18A1621CF10BDD62967DA8210DF90", hash_generated_method = "C5E2A52FB4E23A7B50A1CACE12045BBB")
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean isFocused() {
        boolean varA8C13B6B5B465E10FA182C94781FB93A_1049457969 = ((mPrivateFlags & FOCUSED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122703157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122703157;
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.957 -0400", hash_original_method = "DDD0B2B4CCE06873AEE74BD63DE5A294", hash_generated_method = "F02193D8AF88FAC33C027C065C4B2F7E")
    public View findFocus() {
View var0D35D917C1B840CE4A328380AFB5EF8A_449886110 =         (mPrivateFlags & FOCUSED) != 0 ? this : null;
        var0D35D917C1B840CE4A328380AFB5EF8A_449886110.addTaint(taint);
        return var0D35D917C1B840CE4A328380AFB5EF8A_449886110;
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 ? this : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "1D4A87A45389821BFC7421CA2D7AD61B", hash_generated_method = "522C9C9CD0FBCB43C484AEF543B6B0A3")
    public void setScrollContainer(boolean isScrollContainer) {
        addTaint(isScrollContainer);
    if(isScrollContainer)        
        {
    if(mAttachInfo != null && (mPrivateFlags&SCROLL_CONTAINER_ADDED) == 0)            
            {
                mAttachInfo.mScrollContainers.add(this);
                mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            } //End block
            mPrivateFlags |= SCROLL_CONTAINER;
        } //End block
        else
        {
    if((mPrivateFlags&SCROLL_CONTAINER_ADDED) != 0)            
            {
                mAttachInfo.mScrollContainers.remove(this);
            } //End block
            mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        } //End block
        // ---------- Original Method ----------
        //if (isScrollContainer) {
            //if (mAttachInfo != null && (mPrivateFlags&SCROLL_CONTAINER_ADDED) == 0) {
                //mAttachInfo.mScrollContainers.add(this);
                //mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            //}
            //mPrivateFlags |= SCROLL_CONTAINER;
        //} else {
            //if ((mPrivateFlags&SCROLL_CONTAINER_ADDED) != 0) {
                //mAttachInfo.mScrollContainers.remove(this);
            //}
            //mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "B2DEE8CA09FADC0B572CF46E784DEFD4", hash_generated_method = "6E509B4A274E0969DD21158DFB19A211")
    public int getDrawingCacheQuality() {
        int var37192F7FBA0FAE829F2C8DD1AB37A6CD_1423122755 = (mViewFlags & DRAWING_CACHE_QUALITY_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970481204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1970481204;
        // ---------- Original Method ----------
        //return mViewFlags & DRAWING_CACHE_QUALITY_MASK;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "9D6669AC39CE9592E8D8B20B25494E51", hash_generated_method = "83DC2D62BABCE03A169847A237199E9A")
    public void setDrawingCacheQuality(int quality) {
        addTaint(quality);
        setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
        // ---------- Original Method ----------
        //setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "03B1D1993EB8539284C7E9AFB4C193D6", hash_generated_method = "2C080B2E522DF20A40581DE24C29A2F6")
    public boolean getKeepScreenOn() {
        boolean varF413411F3EA6B29B2AC7572933FACC22_973510942 = ((mViewFlags & KEEP_SCREEN_ON) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560327355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560327355;
        // ---------- Original Method ----------
        //return (mViewFlags & KEEP_SCREEN_ON) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "99FBDDFD33142E06617327BD1E6B4E35", hash_generated_method = "0430735119271D252F3D12043BFC2B9F")
    public void setKeepScreenOn(boolean keepScreenOn) {
        addTaint(keepScreenOn);
        setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
        // ---------- Original Method ----------
        //setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "652E85B83FB56D2A13FFAE8255561FDD", hash_generated_method = "94CC693C56DD770C1AAB3F2B10D3B188")
    public int getNextFocusLeftId() {
        int var88673AFE84192094F2B42B842BD414CC_528972431 = (mNextFocusLeftId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647736206 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1647736206;
        // ---------- Original Method ----------
        //return mNextFocusLeftId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "38A879027311496175629221AC818202", hash_generated_method = "9E7B7FD166466BC7306079F36AA2B43B")
    public void setNextFocusLeftId(int nextFocusLeftId) {
        mNextFocusLeftId = nextFocusLeftId;
        // ---------- Original Method ----------
        //mNextFocusLeftId = nextFocusLeftId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "C88A703CE946F61F0459BFCDB166A908", hash_generated_method = "E76CC5730E876FF7AA163AEEEA0E3DE0")
    public int getNextFocusRightId() {
        int varBEE740D949A871AA05DEA9F00C512EC9_522018115 = (mNextFocusRightId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951959732 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_951959732;
        // ---------- Original Method ----------
        //return mNextFocusRightId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.958 -0400", hash_original_method = "2FF4A363CCED3B1F6EFFEC35EA0E0480", hash_generated_method = "5996750AB6CEE625E7FEB111E630C7C3")
    public void setNextFocusRightId(int nextFocusRightId) {
        mNextFocusRightId = nextFocusRightId;
        // ---------- Original Method ----------
        //mNextFocusRightId = nextFocusRightId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "88AE25872576F6D10940E7A2DFEC3C43", hash_generated_method = "F7891982AD43E02F6115C549DC2D61D7")
    public int getNextFocusUpId() {
        int varB6D89CFBE56117BB4D3B1CF662ECBFCE_741276475 = (mNextFocusUpId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447856149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_447856149;
        // ---------- Original Method ----------
        //return mNextFocusUpId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "EB6C60D159C1D76D120BCAB59C29C293", hash_generated_method = "ABE6A764A0F99D568CE282D19BD22817")
    public void setNextFocusUpId(int nextFocusUpId) {
        mNextFocusUpId = nextFocusUpId;
        // ---------- Original Method ----------
        //mNextFocusUpId = nextFocusUpId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "D4E7D4D04A0684EEEE5B75921F57CEF0", hash_generated_method = "F7614529BDA080C7EBAD3A6C55BABB3B")
    public int getNextFocusDownId() {
        int var6E5FBAFCC26075F1CF67BAD3D6B0404E_293286805 = (mNextFocusDownId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945113956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945113956;
        // ---------- Original Method ----------
        //return mNextFocusDownId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "3F02629850152C987A67C858A1F48B49", hash_generated_method = "DDFE9F521C426810DDF7E2178663902C")
    public void setNextFocusDownId(int nextFocusDownId) {
        mNextFocusDownId = nextFocusDownId;
        // ---------- Original Method ----------
        //mNextFocusDownId = nextFocusDownId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "73A79720EFCAB292687913BA58A7941B", hash_generated_method = "8D94FF5C7D571FE0152C1E783AE308DA")
    public int getNextFocusForwardId() {
        int varB9B37E85BBF827444D4149629581D778_2087549590 = (mNextFocusForwardId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342130806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1342130806;
        // ---------- Original Method ----------
        //return mNextFocusForwardId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "E9ABC127C8FB8F8FC934426D38CB5040", hash_generated_method = "41F6E7361641184AD5AE6B06157A5559")
    public void setNextFocusForwardId(int nextFocusForwardId) {
        mNextFocusForwardId = nextFocusForwardId;
        // ---------- Original Method ----------
        //mNextFocusForwardId = nextFocusForwardId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.959 -0400", hash_original_method = "9296F75E65D2F78CDC5D2F47E6CA50BF", hash_generated_method = "781554694CCF79450954D8F65CE67B55")
    public boolean isShown() {
        View current = this;
        do {
            {
    if((current.mViewFlags & VISIBILITY_MASK) != VISIBLE)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_596577446 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655389611 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655389611;
                } //End block
                ViewParent parent = current.mParent;
    if(parent == null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1843758114 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948479021 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_948479021;
                } //End block
    if(!(parent instanceof View))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_991693348 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_363612660 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_363612660;
                } //End block
                current = (View) parent;
            } //End block
} while (current != null);
        boolean var68934A3E9455FA72420237EB05902327_1673993883 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131116274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131116274;
        // ---------- Original Method ----------
        //View current = this;
        //do {
            //if ((current.mViewFlags & VISIBILITY_MASK) != VISIBLE) {
                //return false;
            //}
            //ViewParent parent = current.mParent;
            //if (parent == null) {
                //return false; 
            //}
            //if (!(parent instanceof View)) {
                //return true;
            //}
            //current = (View) parent;
        //} while (current != null);
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "A39140C8CB73A931FE842774091348D2", hash_generated_method = "2F05154E3A5E5C78AA171B999A7807B3")
    protected boolean fitSystemWindows(Rect insets) {
    if((mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS)        
        {
            mPaddingLeft = insets.left;
            mPaddingTop = insets.top;
            mPaddingRight = insets.right;
            mPaddingBottom = insets.bottom;
            requestLayout();
            boolean varB326B5062B2F0E69046810717534CB09_61580338 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12956459 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_12956459;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1386704129 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195921991 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_195921991;
        // ---------- Original Method ----------
        //if ((mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS) {
            //mPaddingLeft = insets.left;
            //mPaddingTop = insets.top;
            //mPaddingRight = insets.right;
            //mPaddingBottom = insets.bottom;
            //requestLayout();
            //return true;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "E3CDF7FA6CDC2881F199FFB75CF3D7D5", hash_generated_method = "4F9E388BF87FE0107B3701B26C22BD46")
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        addTaint(fitSystemWindows);
        setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
        // ---------- Original Method ----------
        //setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "5692CC010F12659264569BED146C3B41", hash_generated_method = "C2982A90630C83F5BED51F3CB7FD86A6")
    public boolean fitsSystemWindows() {
        boolean var68F1C104C320A9ACABB2B5101E156177_800238315 = ((mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452154760 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452154760;
        // ---------- Original Method ----------
        //return (mViewFlags & FITS_SYSTEM_WINDOWS) == FITS_SYSTEM_WINDOWS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "D2B31666DEBF08F8B4CA461C0B34FB1E", hash_generated_method = "2BB24F219F9404081AF68DC670E8FBD1")
    @ViewDebug.ExportedProperty(mapping = {
        @ViewDebug.IntToString(from = VISIBLE,   to = "VISIBLE"),
        @ViewDebug.IntToString(from = INVISIBLE, to = "INVISIBLE"),
        @ViewDebug.IntToString(from = GONE,      to = "GONE")
    })
    public int getVisibility() {
        int varFE8744F052EE3AB3DEDB4B3D8E30F3C2_1688239358 = (mViewFlags & VISIBILITY_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226793122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226793122;
        // ---------- Original Method ----------
        //return mViewFlags & VISIBILITY_MASK;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "02AF8E28E646A9214DED62901D5A05AB", hash_generated_method = "12CD63C08E5826A08632CB31AC72EFA8")
    @RemotableViewMethod
    public void setVisibility(int visibility) {
        addTaint(visibility);
        setFlags(visibility, VISIBILITY_MASK);
    if(mBGDrawable != null)        
        mBGDrawable.setVisible(visibility == VISIBLE, false);
        // ---------- Original Method ----------
        //setFlags(visibility, VISIBILITY_MASK);
        //if (mBGDrawable != null) mBGDrawable.setVisible(visibility == VISIBLE, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "1FAAF1AA1B65BC3CCFA44E36A044FBA3", hash_generated_method = "7E8D2E989CFFB19BEFDF4E257B1630A0")
    @ViewDebug.ExportedProperty
    public boolean isEnabled() {
        boolean var0B1C37AF21399AE4914DC767B08E274C_1079334414 = ((mViewFlags & ENABLED_MASK) == ENABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327709474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_327709474;
        // ---------- Original Method ----------
        //return (mViewFlags & ENABLED_MASK) == ENABLED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.960 -0400", hash_original_method = "82122684EF3D7563FCC0B376DF0849B5", hash_generated_method = "EBC43E23377C562E21E3AEB1FF5A0F26")
    @RemotableViewMethod
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
    if(enabled == isEnabled())        
        return;
        setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        refreshDrawableState();
        invalidate(true);
        // ---------- Original Method ----------
        //if (enabled == isEnabled()) return;
        //setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        //refreshDrawableState();
        //invalidate(true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "C9881A9860604453F19A8665970456AB", hash_generated_method = "DF1DFE8024569AA4ABAADB9F2EE6B6F0")
    public void setFocusable(boolean focusable) {
        addTaint(focusable);
    if(!focusable)        
        {
            setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        } //End block
        setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
        // ---------- Original Method ----------
        //if (!focusable) {
            //setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        //}
        //setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "2EADF8D169DEE1EA3C577B22372A4F29", hash_generated_method = "27ECBD44F4925CE7A53A35D26F2BDE3C")
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        addTaint(focusableInTouchMode);
        setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
    if(focusableInTouchMode)        
        {
            setFlags(FOCUSABLE, FOCUSABLE_MASK);
        } //End block
        // ---------- Original Method ----------
        //setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
        //if (focusableInTouchMode) {
            //setFlags(FOCUSABLE, FOCUSABLE_MASK);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "0616009511F2186FBF13D4B2BAEA6B3A", hash_generated_method = "3A89CE38E39B7520696E3B0B2DDE0D0A")
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        addTaint(soundEffectsEnabled);
        setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
        // ---------- Original Method ----------
        //setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "04FBA67AC1724C494C94FB884C5C883F", hash_generated_method = "A435AC7EF0702B1166CD9C15F5D23458")
    @ViewDebug.ExportedProperty
    public boolean isSoundEffectsEnabled() {
        boolean var2D9D0FA97908ED630DADDF166FC0428E_2012521079 = (SOUND_EFFECTS_ENABLED == (mViewFlags & SOUND_EFFECTS_ENABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_680452019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_680452019;
        // ---------- Original Method ----------
        //return SOUND_EFFECTS_ENABLED == (mViewFlags & SOUND_EFFECTS_ENABLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "665412B4BA3D450566C79B734C683A80", hash_generated_method = "22C51675F7DA2694BB3B0329569CA117")
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        addTaint(hapticFeedbackEnabled);
        setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
        // ---------- Original Method ----------
        //setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "69619136C00391879489C4434A4D0191", hash_generated_method = "34FC0D413F0481C7CFABBCD57C04E447")
    @ViewDebug.ExportedProperty
    public boolean isHapticFeedbackEnabled() {
        boolean varC8BC4A409647F734B9D32AE11A5ED957_2050590631 = (HAPTIC_FEEDBACK_ENABLED == (mViewFlags & HAPTIC_FEEDBACK_ENABLED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726464460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726464460;
        // ---------- Original Method ----------
        //return HAPTIC_FEEDBACK_ENABLED == (mViewFlags & HAPTIC_FEEDBACK_ENABLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "2C2C2D2C9CAFB887317333E5CB13B049", hash_generated_method = "4F1A5ECEA0680920360F2005C70A7AEA")
    @ViewDebug.ExportedProperty(category = "layout", mapping = {
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LTR,     to = "LTR"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_RTL,     to = "RTL"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_INHERIT, to = "INHERIT"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LOCALE,  to = "LOCALE")
    })
    public int getLayoutDirection() {
        int var31F37BBDDA40923D9C702C02616B3202_950408259 = (mViewFlags & LAYOUT_DIRECTION_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472286401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472286401;
        // ---------- Original Method ----------
        //return mViewFlags & LAYOUT_DIRECTION_MASK;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.961 -0400", hash_original_method = "72BED775868D43D3C5AF7895C4FF8A44", hash_generated_method = "2A9356CF72E7EB64425BE9108601F66B")
    @RemotableViewMethod
    public void setLayoutDirection(int layoutDirection) {
        addTaint(layoutDirection);
    if(getLayoutDirection() != layoutDirection)        
        {
            resetResolvedLayoutDirection();
            setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
        } //End block
        // ---------- Original Method ----------
        //if (getLayoutDirection() != layoutDirection) {
            //resetResolvedLayoutDirection();
            //setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "9F5111100CE328994E06DFE63B825110", hash_generated_method = "E645100180314A6DE535BDB967851E55")
    @ViewDebug.ExportedProperty(category = "layout", mapping = {
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LTR,     to = "RESOLVED_DIRECTION_LTR"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_RTL,     to = "RESOLVED_DIRECTION_RTL")
    })
    public int getResolvedLayoutDirection() {
        resolveLayoutDirectionIfNeeded();
        int varEFB489153A61CFF12E46C32A411BB649_928215101 = (((mPrivateFlags2 & LAYOUT_DIRECTION_RESOLVED_RTL) == LAYOUT_DIRECTION_RESOLVED_RTL) ?
                LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489292361 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_489292361;
        // ---------- Original Method ----------
        //resolveLayoutDirectionIfNeeded();
        //return ((mPrivateFlags2 & LAYOUT_DIRECTION_RESOLVED_RTL) == LAYOUT_DIRECTION_RESOLVED_RTL) ?
                //LAYOUT_DIRECTION_RTL : LAYOUT_DIRECTION_LTR;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "F4E28248D2C3D2566E14BBF2219E2BCD", hash_generated_method = "01DEA1B17D4BD837B08803FD1809DB39")
    @ViewDebug.ExportedProperty(category = "layout")
    public boolean isLayoutRtl() {
        boolean var5810184D6091C8D5E6D6134D39796FE8_1201099980 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316852551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316852551;
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "F9FAF3BB929B9847B181A3D88FABD842", hash_generated_method = "72AEBBADF987EA3F44E6CE103B1A5493")
    public void setWillNotDraw(boolean willNotDraw) {
        addTaint(willNotDraw);
        setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
        // ---------- Original Method ----------
        //setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "B6E391CBFCFD7EA26D5A2732CEE40DF4", hash_generated_method = "50D233EABE00E574E63F253309085A35")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotDraw() {
        boolean varBF0EEEFFC8D4B163C6BF70ABF33D1BDD_928924885 = ((mViewFlags & DRAW_MASK) == WILL_NOT_DRAW);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612833005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_612833005;
        // ---------- Original Method ----------
        //return (mViewFlags & DRAW_MASK) == WILL_NOT_DRAW;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "60A2EABB5E8AA4648C06B0E0E4A2AF9C", hash_generated_method = "9A6FA2F303341286FDBA1F2FF6F0B2AB")
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        addTaint(willNotCacheDrawing);
        setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
        // ---------- Original Method ----------
        //setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "4D65385BAE58DC536EC26F23A55907FF", hash_generated_method = "5AEBD23DBDFD8583D84C679E8A2B9259")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotCacheDrawing() {
        boolean varF24102916FBA070BBB9B9CA7CD44FCD5_1195635028 = ((mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866361789 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866361789;
        // ---------- Original Method ----------
        //return (mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "CAB421C9E4DB53058A0B9351F5E562C4", hash_generated_method = "155589309F7292992FFB25411B38D422")
    @ViewDebug.ExportedProperty
    public boolean isClickable() {
        boolean var7B494338FB9804A9F30C8497B3D6C2E7_528781157 = ((mViewFlags & CLICKABLE) == CLICKABLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802163982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802163982;
        // ---------- Original Method ----------
        //return (mViewFlags & CLICKABLE) == CLICKABLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "12111EA4E19255C8C0AB24AED3DDA51C", hash_generated_method = "F1B216867E26ACD036CEF181BCA50491")
    public void setClickable(boolean clickable) {
        addTaint(clickable);
        setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
        // ---------- Original Method ----------
        //setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.962 -0400", hash_original_method = "03A713DEC8C026709970488D282B8F0B", hash_generated_method = "0B6BC13CCB95820717629AB7729E5198")
    public boolean isLongClickable() {
        boolean var20408C028B5602348B0EC4C93F403B10_1530636673 = ((mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_502059111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_502059111;
        // ---------- Original Method ----------
        //return (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "43536DF18C7BAF4AF88A04663CE8F089", hash_generated_method = "E3F287A590F87D770767655A39136689")
    public void setLongClickable(boolean longClickable) {
        addTaint(longClickable);
        setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
        // ---------- Original Method ----------
        //setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "EED851B5F13351F1D2A34CF3C577E6B2", hash_generated_method = "61A34E21F61C9E5B5399DDD81D67317A")
    public void setPressed(boolean pressed) {
        addTaint(pressed);
    if(pressed)        
        {
            mPrivateFlags |= PRESSED;
        } //End block
        else
        {
            mPrivateFlags &= ~PRESSED;
        } //End block
        refreshDrawableState();
        dispatchSetPressed(pressed);
        // ---------- Original Method ----------
        //if (pressed) {
            //mPrivateFlags |= PRESSED;
        //} else {
            //mPrivateFlags &= ~PRESSED;
        //}
        //refreshDrawableState();
        //dispatchSetPressed(pressed);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "482399F15DBB51C97D7E5C81A9573A96")
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "2EE8A3F216F87253226045E7C3E687D4", hash_generated_method = "C13DB7966270941F3984CE65D842D21D")
    public boolean isPressed() {
        boolean varAD7014A3CC373195BAEF3A9A685BD0A6_1330314937 = ((mPrivateFlags & PRESSED) == PRESSED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_105396647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_105396647;
        // ---------- Original Method ----------
        //return (mPrivateFlags & PRESSED) == PRESSED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "A0C463B2F7163F6CE9FACC921DDDC0C1", hash_generated_method = "6FC93F9754B1244A92DBC379405A2573")
    public boolean isSaveEnabled() {
        boolean var26B2B62C8475A8EF4E2BF91D27B2BDEB_834063307 = ((mViewFlags & SAVE_DISABLED_MASK) != SAVE_DISABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852167890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852167890;
        // ---------- Original Method ----------
        //return (mViewFlags & SAVE_DISABLED_MASK) != SAVE_DISABLED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "245457DBE539B6534978F5D496F585EA", hash_generated_method = "05BFA1884E8066DFE5479F23875A2C2B")
    public void setSaveEnabled(boolean enabled) {
        addTaint(enabled);
        setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.963 -0400", hash_original_method = "A79886E869A4527EDC4A240CAA54713C", hash_generated_method = "4E5002C8FCE942BEBDD96CBD9F31CDDE")
    @ViewDebug.ExportedProperty
    public boolean getFilterTouchesWhenObscured() {
        boolean var476A0A54B313640DCA9DB400F742331C_953331983 = ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1784909537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1784909537;
        // ---------- Original Method ----------
        //return (mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.964 -0400", hash_original_method = "EDB53D9F0799F64121B32D1526967A47", hash_generated_method = "E057A866A4CD5FE778057F06E4EE65C9")
    public void setFilterTouchesWhenObscured(boolean enabled) {
        addTaint(enabled);
        setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                FILTER_TOUCHES_WHEN_OBSCURED);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                //FILTER_TOUCHES_WHEN_OBSCURED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.964 -0400", hash_original_method = "48E76F9595084274E97DBE24F2087BC5", hash_generated_method = "18DCD61E430E8DE4BBF2903931A2D0B1")
    public boolean isSaveFromParentEnabled() {
        boolean var517E33110AF0638F3F4ED00E9E312641_636568911 = ((mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1068138286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1068138286;
        // ---------- Original Method ----------
        //return (mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.964 -0400", hash_original_method = "72C3E4C29A0B231006D33E493310EA89", hash_generated_method = "D8D8A89FD2A85F3C3500C7DD41F9B5FF")
    public void setSaveFromParentEnabled(boolean enabled) {
        addTaint(enabled);
        setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
        // ---------- Original Method ----------
        //setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.964 -0400", hash_original_method = "C297173E860DE7426FAD1827D2AF0FEF", hash_generated_method = "71C3BE9A31E1678917B3BC3EDA794490")
    @ViewDebug.ExportedProperty(category = "focus")
    public final boolean isFocusable() {
        boolean var3A5A468F52734B95296A157496E86995_1196885244 = (FOCUSABLE == (mViewFlags & FOCUSABLE_MASK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981098538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981098538;
        // ---------- Original Method ----------
        //return FOCUSABLE == (mViewFlags & FOCUSABLE_MASK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.964 -0400", hash_original_method = "DC5548897986A7EA94B912A4E6E95490", hash_generated_method = "0FCF1C95D474E467A6900C1712F2547D")
    @ViewDebug.ExportedProperty
    public final boolean isFocusableInTouchMode() {
        boolean var6FC2AC8A23C438E4993BE30817F451F5_1027676986 = (FOCUSABLE_IN_TOUCH_MODE == (mViewFlags & FOCUSABLE_IN_TOUCH_MODE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1895084655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1895084655;
        // ---------- Original Method ----------
        //return FOCUSABLE_IN_TOUCH_MODE == (mViewFlags & FOCUSABLE_IN_TOUCH_MODE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.964 -0400", hash_original_method = "0DA4F7FC608C37A46918AF583285CEAA", hash_generated_method = "E72DAF6277C4E14E6B1A417D609E11D8")
    public View focusSearch(int direction) {
        addTaint(direction);
    if(mParent != null)        
        {
View varFBAF4B9F4A72F87A51A49091229F2BA5_470721267 =             mParent.focusSearch(this, direction);
            varFBAF4B9F4A72F87A51A49091229F2BA5_470721267.addTaint(taint);
            return varFBAF4B9F4A72F87A51A49091229F2BA5_470721267;
        } //End block
        else
        {
View var540C13E9E156B687226421B24F2DF178_117056394 =             null;
            var540C13E9E156B687226421B24F2DF178_117056394.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_117056394;
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //return mParent.focusSearch(this, direction);
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.965 -0400", hash_original_method = "3A7E0D4CA01222234C5493EC87211574", hash_generated_method = "F5C0BAE53B62AE3AE01B7D5DE3C549D7")
    public boolean dispatchUnhandledMove(View focused, int direction) {
        addTaint(direction);
        addTaint(focused.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_496532552 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527165937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527165937;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.977 -0400", hash_original_method = "402D36B98ACE611B6285D11A0B7474BF", hash_generated_method = "DC1177FD07D33AF17C9C687AEBA82FE3")
     View findUserSetNextFocus(View root, int direction) {
        addTaint(direction);
        addTaint(root.getTaint());
switch(direction){
        case FOCUS_LEFT:
    if(mNextFocusLeftId == View.NO_ID)        
        {
View var540C13E9E156B687226421B24F2DF178_36138239 =         null;
        var540C13E9E156B687226421B24F2DF178_36138239.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_36138239;
        }
View varE9FEBCEF635330C07FB6F2C7E88A7E1F_1109546755 =         findViewInsideOutShouldExist(root, mNextFocusLeftId);
        varE9FEBCEF635330C07FB6F2C7E88A7E1F_1109546755.addTaint(taint);
        return varE9FEBCEF635330C07FB6F2C7E88A7E1F_1109546755;
        case FOCUS_RIGHT:
    if(mNextFocusRightId == View.NO_ID)        
        {
View var540C13E9E156B687226421B24F2DF178_1665843081 =         null;
        var540C13E9E156B687226421B24F2DF178_1665843081.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1665843081;
        }
View var78241376FC92A62F952CAFC52ABE7CD1_613624032 =         findViewInsideOutShouldExist(root, mNextFocusRightId);
        var78241376FC92A62F952CAFC52ABE7CD1_613624032.addTaint(taint);
        return var78241376FC92A62F952CAFC52ABE7CD1_613624032;
        case FOCUS_UP:
    if(mNextFocusUpId == View.NO_ID)        
        {
View var540C13E9E156B687226421B24F2DF178_1807652628 =         null;
        var540C13E9E156B687226421B24F2DF178_1807652628.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1807652628;
        }
View varAC2448261BDC4A6751D75519B8836F6C_1013927380 =         findViewInsideOutShouldExist(root, mNextFocusUpId);
        varAC2448261BDC4A6751D75519B8836F6C_1013927380.addTaint(taint);
        return varAC2448261BDC4A6751D75519B8836F6C_1013927380;
        case FOCUS_DOWN:
    if(mNextFocusDownId == View.NO_ID)        
        {
View var540C13E9E156B687226421B24F2DF178_1486581355 =         null;
        var540C13E9E156B687226421B24F2DF178_1486581355.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1486581355;
        }
View varFB49CFB9D54D3700EDB40900E6C034E8_1517888597 =         findViewInsideOutShouldExist(root, mNextFocusDownId);
        varFB49CFB9D54D3700EDB40900E6C034E8_1517888597.addTaint(taint);
        return varFB49CFB9D54D3700EDB40900E6C034E8_1517888597;
        case FOCUS_FORWARD:
    if(mNextFocusForwardId == View.NO_ID)        
        {
View var540C13E9E156B687226421B24F2DF178_1567712191 =         null;
        var540C13E9E156B687226421B24F2DF178_1567712191.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1567712191;
        }
View var0378B770AFBE925A9D90587170A2C88B_2076807874 =         findViewInsideOutShouldExist(root, mNextFocusForwardId);
        var0378B770AFBE925A9D90587170A2C88B_2076807874.addTaint(taint);
        return var0378B770AFBE925A9D90587170A2C88B_2076807874;
        case FOCUS_BACKWARD:
        {
            final int id = mID;
View varA4CBE033600DE6CCC0328C29FCAF2F8F_2094916705 =             root.findViewByPredicateInsideOut(this, new Predicate<View>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.976 -0400", hash_original_method = "3BEF333C61A2928B61AE6075EB704595", hash_generated_method = "E1ECF19138C455EE170A5A0E666D2E29")
        @Override
        public boolean apply(View t) {
            addTaint(t.getTaint());
            boolean var18BFAC2C4009B9722536EE60F7D9D32A_1557057442 = (t.mNextFocusForwardId == id);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048301103 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048301103;
            // ---------- Original Method ----------
            //return t.mNextFocusForwardId == id;
        }
});
            varA4CBE033600DE6CCC0328C29FCAF2F8F_2094916705.addTaint(taint);
            return varA4CBE033600DE6CCC0328C29FCAF2F8F_2094916705;
        } //End block
}View var540C13E9E156B687226421B24F2DF178_1587474405 =         null;
        var540C13E9E156B687226421B24F2DF178_1587474405.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1587474405;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.977 -0400", hash_original_method = "B3DFEFAC3DA8B2AFE30A5DD5BC4E600A", hash_generated_method = "4F571F0685A4D1F3D136FBE468F6A209")
    private View findViewInsideOutShouldExist(View root, final int childViewId) {
        addTaint(childViewId);
        addTaint(root.getTaint());
        View result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            @Override
            public boolean apply(View t) {
                return t.mID == childViewId;
            }
        });
    if(result == null)        
        {
        } //End block
View varDC838461EE2FA0CA4C9BBB70A15456B0_1105926434 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1105926434.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1105926434;
        // ---------- Original Method ----------
        //View result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            //@Override
            //public boolean apply(View t) {
                //return t.mID == childViewId;
            //}
        //});
        //if (result == null) {
            //Log.w(VIEW_LOG_TAG, "couldn't find next focus view specified "
                    //+ "by user for id " + childViewId);
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.977 -0400", hash_original_method = "464AB183F4A2042C34DE93C717198DDB", hash_generated_method = "EF8C2A98D7E5E45F19A888DF3893B1A1")
    public ArrayList<View> getFocusables(int direction) {
        addTaint(direction);
        ArrayList<View> result = new ArrayList<View>(24);
        addFocusables(result, direction);
ArrayList<View> varDC838461EE2FA0CA4C9BBB70A15456B0_1952962510 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1952962510.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1952962510;
        // ---------- Original Method ----------
        //ArrayList<View> result = new ArrayList<View>(24);
        //addFocusables(result, direction);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.977 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "4B41400ABF5489E695B243E26C0B1F89")
    public void addFocusables(ArrayList<View> views, int direction) {
        addTaint(direction);
        addTaint(views.getTaint());
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.977 -0400", hash_original_method = "C71740B3CD39B4D243A828C918021CDE", hash_generated_method = "59BCF64F55AD8806E84103ECCE9851A2")
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        addTaint(focusableMode);
        addTaint(direction);
        addTaint(views.getTaint());
    if(!isFocusable())        
        {
            return;
        } //End block
    if((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                isInTouchMode() && !isFocusableInTouchMode())        
        {
            return;
        } //End block
    if(views != null)        
        {
            views.add(this);
        } //End block
        // ---------- Original Method ----------
        //if (!isFocusable()) {
            //return;
        //}
        //if ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                //isInTouchMode() && !isFocusableInTouchMode()) {
            //return;
        //}
        //if (views != null) {
            //views.add(this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.978 -0400", hash_original_method = "DD343D81D813CE2B90520525DB465FA4", hash_generated_method = "25F69A4D56F87131F719C916AEEF5BA9")
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        addTaint(flags);
        addTaint(searched.getTaint());
        addTaint(outViews.getTaint());
    if((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                && !TextUtils.isEmpty(mContentDescription))        
        {
            String searchedLowerCase = searched.toString().toLowerCase();
            String contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
    if(contentDescriptionLowerCase.contains(searchedLowerCase))            
            {
                outViews.add(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                //&& !TextUtils.isEmpty(mContentDescription)) {
            //String searchedLowerCase = searched.toString().toLowerCase();
            //String contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
            //if (contentDescriptionLowerCase.contains(searchedLowerCase)) {
                //outViews.add(this);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.978 -0400", hash_original_method = "FFA271D2293E365BAC2553CB237E7BDA", hash_generated_method = "ED838DD1A46BEF56C20D85B4FA561C3F")
    public ArrayList<View> getTouchables() {
        ArrayList<View> result = new ArrayList<View>();
        addTouchables(result);
ArrayList<View> varDC838461EE2FA0CA4C9BBB70A15456B0_458688603 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_458688603.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_458688603;
        // ---------- Original Method ----------
        //ArrayList<View> result = new ArrayList<View>();
        //addTouchables(result);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.978 -0400", hash_original_method = "4A9E887CF81CB13B9475E90E8F7B101A", hash_generated_method = "C32C051671147B304F4E85AB595D2256")
    public void addTouchables(ArrayList<View> views) {
        addTaint(views.getTaint());
        final int viewFlags = mViewFlags;
    if(((viewFlags & CLICKABLE) == CLICKABLE || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)
                && (viewFlags & ENABLED_MASK) == ENABLED)        
        {
            views.add(this);
        } //End block
        // ---------- Original Method ----------
        //final int viewFlags = mViewFlags;
        //if (((viewFlags & CLICKABLE) == CLICKABLE || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)
                //&& (viewFlags & ENABLED_MASK) == ENABLED) {
            //views.add(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.978 -0400", hash_original_method = "D80138743E3873A119DEBFC486319C6F", hash_generated_method = "3F3BD8A3DBE54BEBFB103BC7CE445852")
    public final boolean requestFocus() {
        boolean varA22A683A28A1D937C2D0E79395524295_910046575 = (requestFocus(View.FOCUS_DOWN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204250676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_204250676;
        // ---------- Original Method ----------
        //return requestFocus(View.FOCUS_DOWN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.978 -0400", hash_original_method = "0231248B41677D14ABD4C75C00BF9F51", hash_generated_method = "B553C457C3DD4183D5B3876CADAE7421")
    public final boolean requestFocus(int direction) {
        addTaint(direction);
        boolean varE55303DB510E424440F21FBA21052F6C_2002316898 = (requestFocus(direction, null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406485366 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406485366;
        // ---------- Original Method ----------
        //return requestFocus(direction, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.980 -0400", hash_original_method = "4D4D948013EFF9FDAFD5232E182C7F46", hash_generated_method = "F37D1324B03C72959A9A6C61D5572D4B")
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if((mViewFlags & FOCUSABLE_MASK) != FOCUSABLE ||
                (mViewFlags & VISIBILITY_MASK) != VISIBLE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_266982025 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33364163 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_33364163;
        } //End block
    if(isInTouchMode() &&
            (FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_580312234 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604678111 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_604678111;
        } //End block
    if(hasAncestorThatBlocksDescendantFocus())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1713514099 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991077042 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_991077042;
        } //End block
        handleFocusGainInternal(direction, previouslyFocusedRect);
        boolean varB326B5062B2F0E69046810717534CB09_1865102462 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2106736756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2106736756;
        // ---------- Original Method ----------
        //if ((mViewFlags & FOCUSABLE_MASK) != FOCUSABLE ||
                //(mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            //return false;
        //}
        //if (isInTouchMode() &&
            //(FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE))) {
               //return false;
        //}
        //if (hasAncestorThatBlocksDescendantFocus()) {
            //return false;
        //}
        //handleFocusGainInternal(direction, previouslyFocusedRect);
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.980 -0400", hash_original_method = "7FA91653ABFF57A00EB7068CB83E321B", hash_generated_method = "BA4BB96B7F18172AC44CC734EF642995")
     ViewRootImpl getViewRootImpl() {
        View root = getRootView();
ViewRootImpl varC2A55175AAF3E65E31E9E29DD6D1FC16_685850607 =         root != null ? (ViewRootImpl)root.getParent() : null;
        varC2A55175AAF3E65E31E9E29DD6D1FC16_685850607.addTaint(taint);
        return varC2A55175AAF3E65E31E9E29DD6D1FC16_685850607;
        // ---------- Original Method ----------
        //View root = getRootView();
        //return root != null ? (ViewRootImpl)root.getParent() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.980 -0400", hash_original_method = "1F9F6F0DA182BB29AC330886C262C4C3", hash_generated_method = "332D2E6DBDD84A3EFAC3EC10296F79F5")
    public final boolean requestFocusFromTouch() {
    if(isInTouchMode())        
        {
            ViewRootImpl viewRoot = getViewRootImpl();
    if(viewRoot != null)            
            {
                viewRoot.ensureTouchMode(false);
            } //End block
        } //End block
        boolean varA22A683A28A1D937C2D0E79395524295_439360018 = (requestFocus(View.FOCUS_DOWN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098492439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098492439;
        // ---------- Original Method ----------
        //if (isInTouchMode()) {
            //ViewRootImpl viewRoot = getViewRootImpl();
            //if (viewRoot != null) {
                //viewRoot.ensureTouchMode(false);
            //}
        //}
        //return requestFocus(View.FOCUS_DOWN);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.980 -0400", hash_original_method = "AF1FEBD7D3DF68D5685D255FEFA73D33", hash_generated_method = "6B192308A073B57811C2574096F5081F")
    private boolean hasAncestorThatBlocksDescendantFocus() {
        ViewParent ancestor = mParent;
        while
(ancestor instanceof ViewGroup)        
        {
            final ViewGroup vgAncestor = (ViewGroup) ancestor;
    if(vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1385097191 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691491105 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_691491105;
            } //End block
            else
            {
                ancestor = vgAncestor.getParent();
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1936835530 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_609557005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_609557005;
        // ---------- Original Method ----------
        //ViewParent ancestor = mParent;
        //while (ancestor instanceof ViewGroup) {
            //final ViewGroup vgAncestor = (ViewGroup) ancestor;
            //if (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS) {
                //return true;
            //} else {
                //ancestor = vgAncestor.getParent();
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.981 -0400", hash_original_method = "9E8D01E3E35914BE1B580652C44B6D92", hash_generated_method = "4068A66B11C8A715D0155C9B0F768AA3")
    public void dispatchStartTemporaryDetach() {
        onStartTemporaryDetach();
        // ---------- Original Method ----------
        //onStartTemporaryDetach();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.981 -0400", hash_original_method = "7B585748E6C2A3CE6D3BA7FDB91AA5A9", hash_generated_method = "835E4082F4217105CFFD467CF28422B0")
    public void onStartTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        removeUnsetPressCallback();
        mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
        // ---------- Original Method ----------
        //removeUnsetPressCallback();
        //mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.981 -0400", hash_original_method = "07C22BEB43BC8453BE2AEA4BC85C2345", hash_generated_method = "3223FB93CB255E66A3AC95410D228D51")
    public void dispatchFinishTemporaryDetach() {
        onFinishTemporaryDetach();
        // ---------- Original Method ----------
        //onFinishTemporaryDetach();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.981 -0400", hash_original_method = "B87297DA0096F2C31AB92D13B4246B81", hash_generated_method = "25EA709CBA250441F08254F97B05DEE6")
    public void onFinishTemporaryDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.981 -0400", hash_original_method = "5346C33A691675BA7E77EC00779EE7C7", hash_generated_method = "D7CA6910BA26A4A0464E2B232C3A8939")
    public KeyEvent.DispatcherState getKeyDispatcherState() {
KeyEvent.DispatcherState var218898967EDAC4CA2BD920B0C245F28C_136017952 =         mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
        var218898967EDAC4CA2BD920B0C245F28C_136017952.addTaint(taint);
        return var218898967EDAC4CA2BD920B0C245F28C_136017952;
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.996 -0400", hash_original_method = "6BC846EF16EEF6AFE683BBB51F853755", hash_generated_method = "CE5A18FA8DF5B5F3BE5F33F5EB158ADD")
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        addTaint(event.getTaint());
        boolean varCD786373D93AE4D183C2E9941B7284A6_1848134701 = (onKeyPreIme(event.getKeyCode(), event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229128773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229128773;
        // ---------- Original Method ----------
        //return onKeyPreIme(event.getKeyCode(), event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.997 -0400", hash_original_method = "E10762B11C67C141BFF5425226FAC8FB", hash_generated_method = "A72D4B2D4B63F169E332B1037E4FB0EF")
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } //End block
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnKeyListener.onKey(this, event.getKeyCode(), event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_881363703 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383787775 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_383787775;
        } //End block
    if(event.dispatch(this, mAttachInfo != null
                ? mAttachInfo.mKeyDispatchState : null, this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1238309866 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_502187487 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_502187487;
        } //End block
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1601891949 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748228753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748228753;
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        //}
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnKeyListener.onKey(this, event.getKeyCode(), event)) {
            //return true;
        //}
        //if (event.dispatch(this, mAttachInfo != null
                //? mAttachInfo.mKeyDispatchState : null, this)) {
            //return true;
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:51.999 -0400", hash_original_method = "24CC3891BCF06B080FB3833309F877D3", hash_generated_method = "4923DFD88408EDDD0B189D320F233EDD")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var156E4CB1D436F15C72AC6FC64572DBC8_385503815 = (onKeyShortcut(event.getKeyCode(), event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1511694298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1511694298;
        // ---------- Original Method ----------
        //return onKeyShortcut(event.getKeyCode(), event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.000 -0400", hash_original_method = "600B8A393DB97B903182B7AB1891AC3E", hash_generated_method = "5051E540EFD93F0BEAF1ECF5C3BA899D")
    public boolean dispatchTouchEvent(MotionEvent event) {
        addTaint(event.getTaint());
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } //End block
    if(onFilterTouchEventForSecurity(event))        
        {
            ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_2028603706 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689865151 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689865151;
            } //End block
    if(onTouchEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_774086510 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865360784 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_865360784;
            } //End block
        } //End block
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_661895770 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1757824958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1757824958;
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        //}
        //if (onFilterTouchEventForSecurity(event)) {
            //ListenerInfo li = mListenerInfo;
            //if (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    //&& li.mOnTouchListener.onTouch(this, event)) {
                //return true;
            //}
            //if (onTouchEvent(event)) {
                //return true;
            //}
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.001 -0400", hash_original_method = "D22D4E22492930B2B9E3C8840958D4D7", hash_generated_method = "A45AF1722AB28A74F20E6250B3F75991")
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
    if((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                && (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1305991695 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149604491 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149604491;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_52755079 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192367234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192367234;
        // ---------- Original Method ----------
        //if ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                //&& (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0) {
            //return false;
        //}
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.001 -0400", hash_original_method = "7D8730AF428F1F83C6EA34686735DEE9", hash_generated_method = "1330BE1A98B5101B5FA52716059D38BA")
    public boolean dispatchTrackballEvent(MotionEvent event) {
        addTaint(event.getTaint());
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } //End block
        boolean var44A53F50D22C482355EFEFA34E2078C0_1876410472 = (onTrackballEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764151250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764151250;
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        //}
        //return onTrackballEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.002 -0400", hash_original_method = "4D54FFDFE0E351BCF8C37A3BD601042A", hash_generated_method = "4103A887CF33884D378909CFCC6AA3F2")
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        addTaint(event.getTaint());
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } //End block
        final int source = event.getSource();
    if((source & InputDevice.SOURCE_CLASS_POINTER) != 0)        
        {
            final int action = event.getAction();
    if(action == MotionEvent.ACTION_HOVER_ENTER
                    || action == MotionEvent.ACTION_HOVER_MOVE
                    || action == MotionEvent.ACTION_HOVER_EXIT)            
            {
    if(dispatchHoverEvent(event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_388052760 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136499938 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136499938;
                } //End block
            } //End block
            else
    if(dispatchGenericPointerEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1403029099 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12812798 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_12812798;
            } //End block
        } //End block
        else
    if(dispatchGenericFocusedEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1838906620 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578916375 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578916375;
        } //End block
    if(dispatchGenericMotionEventInternal(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1197450373 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471284844 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_471284844;
        } //End block
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2108516734 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659946426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659946426;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.003 -0400", hash_original_method = "C7F259FDC1DD0446D3E9FDACCE813628", hash_generated_method = "A71CF89A82FAE2D88AA701279146EABC")
    private boolean dispatchGenericMotionEventInternal(MotionEvent event) {
        addTaint(event.getTaint());
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnGenericMotionListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnGenericMotionListener.onGenericMotion(this, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_481560249 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483224876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_483224876;
        } //End block
    if(onGenericMotionEvent(event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1681984809 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615133299 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_615133299;
        } //End block
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_752536722 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295454330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295454330;
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnGenericMotionListener != null
                //&& (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnGenericMotionListener.onGenericMotion(this, event)) {
            //return true;
        //}
        //if (onGenericMotionEvent(event)) {
            //return true;
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.003 -0400", hash_original_method = "648EC8AE542E2EA418563108E4E24BE8", hash_generated_method = "5AFAC82C11B3EBA04DAE704BE5E800FA")
    protected boolean dispatchHoverEvent(MotionEvent event) {
        addTaint(event.getTaint());
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnHoverListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnHoverListener.onHover(this, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_525796455 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726014897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_726014897;
        } //End block
        boolean var47449F9991FAD303C66FB26061BA8D47_4626962 = (onHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863732031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863732031;
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnHoverListener != null
                //&& (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnHoverListener.onHover(this, event)) {
            //return true;
        //}
        //return onHoverEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.004 -0400", hash_original_method = "6C63870709E0BCE3150AB1DBD762BE1B", hash_generated_method = "855E304BE5C5B4C4574B0383C7A5BF8A")
    protected boolean hasHoveredChild() {
        boolean var68934A3E9455FA72420237EB05902327_1873837221 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_325819871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_325819871;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.004 -0400", hash_original_method = "3E380A63A40D63CB8A25C818C007B9B3", hash_generated_method = "10317627C868F7268222B5CD30D28610")
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1166152106 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659234027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659234027;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.004 -0400", hash_original_method = "A2221AB8B5038CA8B5C4F66BF8310DCB", hash_generated_method = "2CA31BA6426E06EB750EA9AEFEE02682")
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_733889166 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293792831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293792831;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.004 -0400", hash_original_method = "5F3F937CAC1AD8405FC854A70098D82C", hash_generated_method = "2FF257B838EC044179010747B4A21998")
    public final boolean dispatchPointerEvent(MotionEvent event) {
        addTaint(event.getTaint());
    if(event.isTouchEvent())        
        {
            boolean var33AB54E33C3D091D0B7944415C6EB8F1_1912365600 = (dispatchTouchEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856925829 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856925829;
        } //End block
        else
        {
            boolean var151E199E337A36249346B64FF6D9F286_1031278217 = (dispatchGenericMotionEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935886778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935886778;
        } //End block
        // ---------- Original Method ----------
        //if (event.isTouchEvent()) {
            //return dispatchTouchEvent(event);
        //} else {
            //return dispatchGenericMotionEvent(event);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.005 -0400", hash_original_method = "F6C86F5501B65BFAFB8121E3F717BD02", hash_generated_method = "19548E40ECAB939B70472D292ABE19DD")
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        addTaint(hasFocus);
        onWindowFocusChanged(hasFocus);
        // ---------- Original Method ----------
        //onWindowFocusChanged(hasFocus);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.005 -0400", hash_original_method = "F57E7738E41C9719BB0FA37E2B51EE61", hash_generated_method = "60D581245D78216725151FB8DC966C29")
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hasWindowFocus);
        InputMethodManager imm = InputMethodManager.peekInstance();
    if(!hasWindowFocus)        
        {
    if(isPressed())            
            {
                setPressed(false);
            } //End block
    if(imm != null && (mPrivateFlags & FOCUSED) != 0)            
            {
                imm.focusOut(this);
            } //End block
            removeLongPressCallback();
            removeTapCallback();
            onFocusLost();
        } //End block
        else
    if(imm != null && (mPrivateFlags & FOCUSED) != 0)        
        {
            imm.focusIn(this);
        } //End block
        refreshDrawableState();
        // ---------- Original Method ----------
        //InputMethodManager imm = InputMethodManager.peekInstance();
        //if (!hasWindowFocus) {
            //if (isPressed()) {
                //setPressed(false);
            //}
            //if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
                //imm.focusOut(this);
            //}
            //removeLongPressCallback();
            //removeTapCallback();
            //onFocusLost();
        //} else if (imm != null && (mPrivateFlags & FOCUSED) != 0) {
            //imm.focusIn(this);
        //}
        //refreshDrawableState();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.006 -0400", hash_original_method = "43B27055CE530161D72F65ED0A59B9EC", hash_generated_method = "3F4F42A6E8F8824FCA281C16D885BA96")
    public boolean hasWindowFocus() {
        boolean var4FB6AC85BD3405CB6D3077C6A221027E_1583647043 = (mAttachInfo != null && mAttachInfo.mHasWindowFocus);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699641091 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_699641091;
        // ---------- Original Method ----------
        //return mAttachInfo != null && mAttachInfo.mHasWindowFocus;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.006 -0400", hash_original_method = "5A92DDE8F02B8EC7BB05F90066C877DB", hash_generated_method = "B8185D361C85CCC94D16F272F41901DA")
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        addTaint(visibility);
        addTaint(changedView.getTaint());
        onVisibilityChanged(changedView, visibility);
        // ---------- Original Method ----------
        //onVisibilityChanged(changedView, visibility);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.006 -0400", hash_original_method = "96367A8B641E87C53B477CCACD2EFDC5", hash_generated_method = "A85588AE5196AF1AD9DF1C1063133FA0")
    protected void onVisibilityChanged(View changedView, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        addTaint(changedView.getTaint());
    if(visibility == VISIBLE)        
        {
    if(mAttachInfo != null)            
            {
                initialAwakenScrollBars();
            } //End block
            else
            {
                mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (visibility == VISIBLE) {
            //if (mAttachInfo != null) {
                //initialAwakenScrollBars();
            //} else {
                //mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.007 -0400", hash_original_method = "5C1461045BB49CF5D091FC620162B930", hash_generated_method = "1486F57A9966B1DB5BC83AF15B9653F4")
    public void dispatchDisplayHint(int hint) {
        addTaint(hint);
        onDisplayHint(hint);
        // ---------- Original Method ----------
        //onDisplayHint(hint);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.007 -0400", hash_original_method = "5A8656B423BEB4FF4CA5CD6E6B7C0CE2", hash_generated_method = "7AFA45852F4248855F8AF6C17DF3F6DF")
    protected void onDisplayHint(int hint) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hint);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.007 -0400", hash_original_method = "3D097367CCB5A92F4CA94066B4093669", hash_generated_method = "1B20AFFD39B71BA1FBC54D82E91AE828")
    public void dispatchWindowVisibilityChanged(int visibility) {
        addTaint(visibility);
        onWindowVisibilityChanged(visibility);
        // ---------- Original Method ----------
        //onWindowVisibilityChanged(visibility);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.007 -0400", hash_original_method = "B52A85A1B1D14AC974ADC7B2B6CB318A", hash_generated_method = "9C4E88A475A991296E7F7E490C2449C7")
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
    if(visibility == VISIBLE)        
        {
            initialAwakenScrollBars();
        } //End block
        // ---------- Original Method ----------
        //if (visibility == VISIBLE) {
            //initialAwakenScrollBars();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.007 -0400", hash_original_method = "B335923547853AC72EE9B6DCDADA38B5", hash_generated_method = "E2701BC36C58FD0AEE83B7C736E9734F")
    public int getWindowVisibility() {
        int varA99840D4E07F0A1DB1B51511A7411401_1894606717 = (mAttachInfo != null ? mAttachInfo.mWindowVisibility : GONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135697817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135697817;
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mWindowVisibility : GONE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.008 -0400", hash_original_method = "D236207A35AB4B4964A2350C5EB42480", hash_generated_method = "C1350FDD9C592817EA31183F83E517FC")
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        addTaint(outRect.getTaint());
    if(mAttachInfo != null)        
        {
            try 
            {
                mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            } //End block
            catch (RemoteException e)
            {
                return;
            } //End block
            final Rect insets = mAttachInfo.mVisibleInsets;
            outRect.left += insets.left;
            outRect.top += insets.top;
            outRect.right -= insets.right;
            outRect.bottom -= insets.bottom;
            return;
        } //End block
        Display d = WindowManagerImpl.getDefault().getDefaultDisplay();
        d.getRectSize(outRect);
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //try {
                //mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            //} catch (RemoteException e) {
                //return;
            //}
            //final Rect insets = mAttachInfo.mVisibleInsets;
            //outRect.left += insets.left;
            //outRect.top += insets.top;
            //outRect.right -= insets.right;
            //outRect.bottom -= insets.bottom;
            //return;
        //}
        //Display d = WindowManagerImpl.getDefault().getDefaultDisplay();
        //d.getRectSize(outRect);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.009 -0400", hash_original_method = "54CB795C069B52CC42B32E2AD26066B2", hash_generated_method = "A862DA42BEC597C6F54D44BC4DFDBC10")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        addTaint(newConfig.getTaint());
        onConfigurationChanged(newConfig);
        // ---------- Original Method ----------
        //onConfigurationChanged(newConfig);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.009 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "466D77C1E8E53A4547ADE90D240CE428")
    protected void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.009 -0400", hash_original_method = "4092DD0F41D441E58BB892F3C094C4B3", hash_generated_method = "87E2E81281C784C42D0A9EF5345A8C34")
     void dispatchCollectViewAttributes(int visibility) {
        addTaint(visibility);
        performCollectViewAttributes(visibility);
        // ---------- Original Method ----------
        //performCollectViewAttributes(visibility);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.010 -0400", hash_original_method = "01D7FE9ADD969187268E5CA00DFC8244", hash_generated_method = "E34827BD82C94F5A7A13D3C1BE7A040E")
     void performCollectViewAttributes(int visibility) {
        addTaint(visibility);
    if((visibility & VISIBILITY_MASK) == VISIBLE && mAttachInfo != null)        
        {
    if((mViewFlags & KEEP_SCREEN_ON) == KEEP_SCREEN_ON)            
            {
                mAttachInfo.mKeepScreenOn = true;
            } //End block
            mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnSystemUiVisibilityChangeListener != null)            
            {
                mAttachInfo.mHasSystemUiListeners = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if ((visibility & VISIBILITY_MASK) == VISIBLE && mAttachInfo != null) {
            //if ((mViewFlags & KEEP_SCREEN_ON) == KEEP_SCREEN_ON) {
                //mAttachInfo.mKeepScreenOn = true;
            //}
            //mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            //ListenerInfo li = mListenerInfo;
            //if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
                //mAttachInfo.mHasSystemUiListeners = true;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.010 -0400", hash_original_method = "9FE32A4CBB26C218394F35C255A8CF99", hash_generated_method = "7DBAC713A61A4EFBD23600E577DAABC6")
     void needGlobalAttributesUpdate(boolean force) {
        addTaint(force);
        final AttachInfo ai = mAttachInfo;
    if(ai != null)        
        {
    if(force || ai.mKeepScreenOn || (ai.mSystemUiVisibility != 0)
                    || ai.mHasSystemUiListeners)            
            {
                ai.mRecomputeGlobalAttributes = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final AttachInfo ai = mAttachInfo;
        //if (ai != null) {
            //if (force || ai.mKeepScreenOn || (ai.mSystemUiVisibility != 0)
                    //|| ai.mHasSystemUiListeners) {
                //ai.mRecomputeGlobalAttributes = true;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.011 -0400", hash_original_method = "ED47CAF0B3847455A70DC2CFF6AB9C90", hash_generated_method = "C188F239EF0A5176A075764A25FA7C69")
    @ViewDebug.ExportedProperty
    public boolean isInTouchMode() {
    if(mAttachInfo != null)        
        {
            boolean var80256C29691AD59CD788A91F9FD83024_1850618877 = (mAttachInfo.mInTouchMode);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_469723941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_469723941;
        } //End block
        else
        {
            boolean varD8BB306EE7595498BC7078090AEB95CF_702766095 = (ViewRootImpl.isInTouchMode());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651972643 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_651972643;
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mInTouchMode;
        //} else {
            //return ViewRootImpl.isInTouchMode();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.011 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "21518477173E7A5C45C9D29F2DE94F48")
    @ViewDebug.CapturedViewProperty
    public final Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_2083052249 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_2083052249.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_2083052249;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.011 -0400", hash_original_method = "3F070CAC61386FAD746F2003533AED25", hash_generated_method = "E7623366D7C92B277B3B086C72163434")
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_1347348263 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_997046251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_997046251;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.012 -0400", hash_original_method = "30943D321BC4BC956C4D9D744FC13942", hash_generated_method = "DA1DDC3EF6BB58B5CF6B574F4C0A0BEF")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean result = false;
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
        {
    if((mViewFlags & ENABLED_MASK) == DISABLED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_663043641 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1452816813 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1452816813;
            } //End block
    if(((mViewFlags & CLICKABLE) == CLICKABLE ||
                        (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        (event.getRepeatCount() == 0))            
            {
                setPressed(true);
                checkForLongClick(0);
                boolean varB326B5062B2F0E69046810717534CB09_577746381 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057697407 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057697407;
            } //End block
            break;
        } //End block
}        boolean varB4A88417B3D0170D754C647C30B7216A_1334159854 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972797013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972797013;
        // ---------- Original Method ----------
        //boolean result = false;
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_ENTER: {
                //if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    //return true;
                //}
                //if (((mViewFlags & CLICKABLE) == CLICKABLE ||
                        //(mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        //(event.getRepeatCount() == 0)) {
                    //setPressed(true);
                    //checkForLongClick(0);
                    //return true;
                //}
                //break;
            //}
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.012 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "6D0EAE4297E8CD2E3377921DE2180BF5")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_602435546 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114776618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114776618;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.013 -0400", hash_original_method = "5AB62313644D9CD032AD8CDBAB33BB4C", hash_generated_method = "E967183E326A4B7EA24D1F35DDA676D9")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean result = false;
switch(keyCode){
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
        {
    if((mViewFlags & ENABLED_MASK) == DISABLED)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_670622287 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661955191 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_661955191;
            } //End block
    if((mViewFlags & CLICKABLE) == CLICKABLE && isPressed())            
            {
                setPressed(false);
    if(!mHasPerformedLongPress)                
                {
                    removeLongPressCallback();
                    result = performClick();
                } //End block
            } //End block
            break;
        } //End block
}        boolean varB4A88417B3D0170D754C647C30B7216A_548314386 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949962536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949962536;
        // ---------- Original Method ----------
        //boolean result = false;
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DPAD_CENTER:
            //case KeyEvent.KEYCODE_ENTER: {
                //if ((mViewFlags & ENABLED_MASK) == DISABLED) {
                    //return true;
                //}
                //if ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed()) {
                    //setPressed(false);
                    //if (!mHasPerformedLongPress) {
                        //removeLongPressCallback();
                        //result = performClick();
                    //}
                //}
                //break;
            //}
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.013 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "D49EBFD4697C1141E212CD29328886F3")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(repeatCount);
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_389143773 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109445163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109445163;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.014 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "FA1EA50218A4C31FFD2945D49895CD93")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        boolean var68934A3E9455FA72420237EB05902327_658989756 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281477022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281477022;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.014 -0400", hash_original_method = "47FC099EDD591711C69A21361EB96357", hash_generated_method = "9C9C728C06F4F844AAB7495E1C86277A")
    public boolean onCheckIsTextEditor() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean var68934A3E9455FA72420237EB05902327_1261343570 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387731678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387731678;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.014 -0400", hash_original_method = "0601401EB37355AF70FCC37B4ABEB0DF", hash_generated_method = "B6EB8B8F120393B5D8B99F52B137C22A")
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outAttrs.getTaint());
InputConnection var540C13E9E156B687226421B24F2DF178_1095059731 =         null;
        var540C13E9E156B687226421B24F2DF178_1095059731.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1095059731;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.015 -0400", hash_original_method = "225D79BB0F164EDB8833C9EDCA3E1422", hash_generated_method = "09B6B13EE29B2EE702E68F09F720E80C")
    public boolean checkInputConnectionProxy(View view) {
        addTaint(view.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1290595620 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98195049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_98195049;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.015 -0400", hash_original_method = "3CE367A3F7143B170AAF00E81005E914", hash_generated_method = "866B4701D968B16398F75D0D2DEDFC6B")
    public void createContextMenu(ContextMenu menu) {
        addTaint(menu.getTaint());
        ContextMenuInfo menuInfo = getContextMenuInfo();
        ((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        onCreateContextMenu(menu);
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnCreateContextMenuListener != null)        
        {
            li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        } //End block
        ((MenuBuilder)menu).setCurrentMenuInfo(null);
    if(mParent != null)        
        {
            mParent.createContextMenu(menu);
        } //End block
        // ---------- Original Method ----------
        //ContextMenuInfo menuInfo = getContextMenuInfo();
        //((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        //onCreateContextMenu(menu);
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnCreateContextMenuListener != null) {
            //li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        //}
        //((MenuBuilder)menu).setCurrentMenuInfo(null);
        //if (mParent != null) {
            //mParent.createContextMenu(menu);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.016 -0400", hash_original_method = "5F63695E16A345A992F87C295B6530DF", hash_generated_method = "814F81AF241815B104B944DDA3D75572")
    protected ContextMenuInfo getContextMenuInfo() {
ContextMenuInfo var540C13E9E156B687226421B24F2DF178_684408953 =         null;
        var540C13E9E156B687226421B24F2DF178_684408953.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_684408953;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.016 -0400", hash_original_method = "6522DD22D3C6D7A95FA248A3D5D95901", hash_generated_method = "015D5DE2243E972B4786C923AF15F92B")
    protected void onCreateContextMenu(ContextMenu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.016 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "0C8443E2E285827686F3E538A67AEB00")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_452159316 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630534408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630534408;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.016 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "E050863DC32178CC32400C41AD7AF1D8")
    public boolean onGenericMotionEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1497301364 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400451903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400451903;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.017 -0400", hash_original_method = "5922A88C022E21B0C70489BC0DBE35EF", hash_generated_method = "A97AD0660BFCC45223C5FC99C673F2B2")
    public boolean onHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        final int action = event.getAction();
    if(!mSendingHoverAccessibilityEvents)        
        {
    if((action == MotionEvent.ACTION_HOVER_ENTER
                    || action == MotionEvent.ACTION_HOVER_MOVE)
                    && !hasHoveredChild()
                    && pointInView(event.getX(), event.getY()))            
            {
                mSendingHoverAccessibilityEvents = true;
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_ENTER);
            } //End block
        } //End block
        else
        {
    if(action == MotionEvent.ACTION_HOVER_EXIT
                    || (action == MotionEvent.ACTION_HOVER_MOVE
                            && !pointInView(event.getX(), event.getY())))            
            {
                mSendingHoverAccessibilityEvents = false;
                sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_EXIT);
            } //End block
        } //End block
    if(isHoverable())        
        {
switch(action){
            case MotionEvent.ACTION_HOVER_ENTER:
            setHovered(true);
            break;
            case MotionEvent.ACTION_HOVER_EXIT:
            setHovered(false);
            break;
}            dispatchGenericMotionEventInternal(event);
            boolean varB326B5062B2F0E69046810717534CB09_59639650 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914877550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914877550;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_654681445 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_51707136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_51707136;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.017 -0400", hash_original_method = "B9B35BD663CAB028DDAC5D67FB09103D", hash_generated_method = "565F919ACB8253B35B3B7ABB4267D70D")
    private boolean isHoverable() {
        final int viewFlags = mViewFlags;
    if((viewFlags & ENABLED_MASK) == DISABLED)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1515643783 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_740188684 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_740188684;
        } //End block
        boolean var91A6C7E514B810B21796B69997C5EA61_757748747 = ((viewFlags & CLICKABLE) == CLICKABLE
                || (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719675419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719675419;
        // ---------- Original Method ----------
        //final int viewFlags = mViewFlags;
        //if ((viewFlags & ENABLED_MASK) == DISABLED) {
            //return false;
        //}
        //return (viewFlags & CLICKABLE) == CLICKABLE
                //|| (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.017 -0400", hash_original_method = "0724AE81F4A3A3591BB9677111DA3959", hash_generated_method = "EA6CBCF4977CF78015EB004E0690DFC4")
    @ViewDebug.ExportedProperty
    public boolean isHovered() {
        boolean varEF258735540300B7AE3AFCA0742A0287_1493881535 = ((mPrivateFlags & HOVERED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167050450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167050450;
        // ---------- Original Method ----------
        //return (mPrivateFlags & HOVERED) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.018 -0400", hash_original_method = "6A44BB0DB1E9547ADB3859B33BB1BB33", hash_generated_method = "A65F2E204E17A6F509CBA1EEC2D7E200")
    public void setHovered(boolean hovered) {
        addTaint(hovered);
    if(hovered)        
        {
    if((mPrivateFlags & HOVERED) == 0)            
            {
                mPrivateFlags |= HOVERED;
                refreshDrawableState();
                onHoverChanged(true);
            } //End block
        } //End block
        else
        {
    if((mPrivateFlags & HOVERED) != 0)            
            {
                mPrivateFlags &= ~HOVERED;
                refreshDrawableState();
                onHoverChanged(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (hovered) {
            //if ((mPrivateFlags & HOVERED) == 0) {
                //mPrivateFlags |= HOVERED;
                //refreshDrawableState();
                //onHoverChanged(true);
            //}
        //} else {
            //if ((mPrivateFlags & HOVERED) != 0) {
                //mPrivateFlags &= ~HOVERED;
                //refreshDrawableState();
                //onHoverChanged(false);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.018 -0400", hash_original_method = "E702D19B1B952DDC0E28AFCA7C53007F", hash_generated_method = "AE8841589F9FD221B263AD22F6BB1DA2")
    public void onHoverChanged(boolean hovered) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hovered);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.019 -0400", hash_original_method = "F0667DD3F99E763B1BFE85806FBAFB16", hash_generated_method = "BA66242EDF39D4AAF7047669D5D0004F")
    public boolean onTouchEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        final int viewFlags = mViewFlags;
    if((viewFlags & ENABLED_MASK) == DISABLED)        
        {
    if(event.getAction() == MotionEvent.ACTION_UP && (mPrivateFlags & PRESSED) != 0)            
            {
                mPrivateFlags &= ~PRESSED;
                refreshDrawableState();
            } //End block
            boolean var0A7E23972DBD2134015199FD40D35E97_884105544 = ((((viewFlags & CLICKABLE) == CLICKABLE ||
                    (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636615592 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636615592;
        } //End block
    if(mTouchDelegate != null)        
        {
    if(mTouchDelegate.onTouchEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1928680346 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020812029 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020812029;
            } //End block
        } //End block
    if(((viewFlags & CLICKABLE) == CLICKABLE ||
                (viewFlags & LONG_CLICKABLE) == LONG_CLICKABLE))        
        {
switch(event.getAction()){
            case MotionEvent.ACTION_UP:
            boolean prepressed = (mPrivateFlags & PREPRESSED) != 0;
    if((mPrivateFlags & PRESSED) != 0 || prepressed)            
            {
                boolean focusTaken = false;
    if(isFocusable() && isFocusableInTouchMode() && !isFocused())                
                {
                    focusTaken = requestFocus();
                } //End block
    if(prepressed)                
                {
                    mPrivateFlags |= PRESSED;
                    refreshDrawableState();
                } //End block
    if(!mHasPerformedLongPress)                
                {
                    removeLongPressCallback();
    if(!focusTaken)                    
                    {
    if(mPerformClick == null)                        
                        {
                            mPerformClick = new PerformClick();
                        } //End block
    if(!post(mPerformClick))                        
                        {
                            performClick();
                        } //End block
                    } //End block
                } //End block
    if(mUnsetPressedState == null)                
                {
                    mUnsetPressedState = new UnsetPressedState();
                } //End block
    if(prepressed)                
                {
                    postDelayed(mUnsetPressedState,
                                    ViewConfiguration.getPressedStateDuration());
                } //End block
                else
    if(!post(mUnsetPressedState))                
                {
                    mUnsetPressedState.run();
                } //End block
                removeTapCallback();
            } //End block
            break;
            case MotionEvent.ACTION_DOWN:
            mHasPerformedLongPress = false;
    if(performButtonActionOnTouchDown(event))            
            {
                break;
            } //End block
            boolean isInScrollingContainer = isInScrollingContainer();
    if(isInScrollingContainer)            
            {
                mPrivateFlags |= PREPRESSED;
    if(mPendingCheckForTap == null)                
                {
                    mPendingCheckForTap = new CheckForTap();
                } //End block
                postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
            } //End block
            else
            {
                mPrivateFlags |= PRESSED;
                refreshDrawableState();
                checkForLongClick(0);
            } //End block
            break;
            case MotionEvent.ACTION_CANCEL:
            mPrivateFlags &= ~PRESSED;
            refreshDrawableState();
            removeTapCallback();
            break;
            case MotionEvent.ACTION_MOVE:
            final int x = (int) event.getX();
            final int y = (int) event.getY();
    if(!pointInView(x, y, mTouchSlop))            
            {
                removeTapCallback();
    if((mPrivateFlags & PRESSED) != 0)                
                {
                    removeLongPressCallback();
                    mPrivateFlags &= ~PRESSED;
                    refreshDrawableState();
                } //End block
            } //End block
            break;
}            boolean varB326B5062B2F0E69046810717534CB09_1830865248 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479205489 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479205489;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1237214586 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243588967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_243588967;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.019 -0400", hash_original_method = "7808B21D2BE87077131F031A801646DE", hash_generated_method = "62CB67BFF596CCB92F91D96120415C80")
    public boolean isInScrollingContainer() {
        ViewParent p = getParent();
        while
(p != null && p instanceof ViewGroup)        
        {
    if(((ViewGroup) p).shouldDelayChildPressedState())            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1142309778 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463907578 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_463907578;
            } //End block
            p = p.getParent();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1166928900 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245847522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245847522;
        // ---------- Original Method ----------
        //ViewParent p = getParent();
        //while (p != null && p instanceof ViewGroup) {
            //if (((ViewGroup) p).shouldDelayChildPressedState()) {
                //return true;
            //}
            //p = p.getParent();
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.019 -0400", hash_original_method = "A93CC85053AADAF4A404AD13182B9757", hash_generated_method = "218BCBDD907FBF4A34B71226C11E54D7")
    private void removeLongPressCallback() {
    if(mPendingCheckForLongPress != null)        
        {
            removeCallbacks(mPendingCheckForLongPress);
        } //End block
        // ---------- Original Method ----------
        //if (mPendingCheckForLongPress != null) {
          //removeCallbacks(mPendingCheckForLongPress);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.019 -0400", hash_original_method = "E1C00ACE8BB8560C240B3C5D040006A3", hash_generated_method = "8656F4AC0FE9734E1D354D5AFFFFBD55")
    private void removePerformClickCallback() {
    if(mPerformClick != null)        
        {
            removeCallbacks(mPerformClick);
        } //End block
        // ---------- Original Method ----------
        //if (mPerformClick != null) {
            //removeCallbacks(mPerformClick);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.020 -0400", hash_original_method = "6062C7F52024ACE8958D902CC4268271", hash_generated_method = "42F0BD065912F12D5E417E67DEB88626")
    private void removeUnsetPressCallback() {
    if((mPrivateFlags & PRESSED) != 0 && mUnsetPressedState != null)        
        {
            setPressed(false);
            removeCallbacks(mUnsetPressedState);
        } //End block
        // ---------- Original Method ----------
        //if ((mPrivateFlags & PRESSED) != 0 && mUnsetPressedState != null) {
            //setPressed(false);
            //removeCallbacks(mUnsetPressedState);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.020 -0400", hash_original_method = "B67FA3EAF595424C7D0F48DB4ECBF54E", hash_generated_method = "0CC43B32325AF7DDC089FC5B76DFB1F6")
    private void removeTapCallback() {
    if(mPendingCheckForTap != null)        
        {
            mPrivateFlags &= ~PREPRESSED;
            removeCallbacks(mPendingCheckForTap);
        } //End block
        // ---------- Original Method ----------
        //if (mPendingCheckForTap != null) {
            //mPrivateFlags &= ~PREPRESSED;
            //removeCallbacks(mPendingCheckForTap);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.020 -0400", hash_original_method = "B45EC6A62A5C3981A23AB3F41840A566", hash_generated_method = "B4CC4E5CE3C81DAAFE2FEB90BADA5B6E")
    public void cancelLongPress() {
        removeLongPressCallback();
        removeTapCallback();
        // ---------- Original Method ----------
        //removeLongPressCallback();
        //removeTapCallback();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.020 -0400", hash_original_method = "8D4D94E2FFA3D8907911FEF22F0F072D", hash_generated_method = "557E8DA17A24274CAB0EB45CEE006FFD")
    private void removeSendViewScrolledAccessibilityEventCallback() {
    if(mSendViewScrolledAccessibilityEvent != null)        
        {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
        } //End block
        // ---------- Original Method ----------
        //if (mSendViewScrolledAccessibilityEvent != null) {
            //removeCallbacks(mSendViewScrolledAccessibilityEvent);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.020 -0400", hash_original_method = "61F54D1D0A5A4D0B5C8BE62B3B180D19", hash_generated_method = "E776BADE28CB148BB0B06BC8200B2011")
    public void setTouchDelegate(TouchDelegate delegate) {
        mTouchDelegate = delegate;
        // ---------- Original Method ----------
        //mTouchDelegate = delegate;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.020 -0400", hash_original_method = "C13C756E7E3DD9AFF35525DE74B6A0AE", hash_generated_method = "44ACBCD14986C2C923D08BEA555367EE")
    public TouchDelegate getTouchDelegate() {
TouchDelegate var836DEDB4AD3C27FC22D2CF31EEAF36E5_929239219 =         mTouchDelegate;
        var836DEDB4AD3C27FC22D2CF31EEAF36E5_929239219.addTaint(taint);
        return var836DEDB4AD3C27FC22D2CF31EEAF36E5_929239219;
        // ---------- Original Method ----------
        //return mTouchDelegate;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.021 -0400", hash_original_method = "DB01C6D64C7923FFF91C0044F6A0DAD3", hash_generated_method = "29B6121A3D743D05521606B493DD4E0B")
     void setFlags(int flags, int mask) {
        int old = mViewFlags;
        mViewFlags = (mViewFlags & ~mask) | (flags & mask);
        int changed = mViewFlags ^ old;
    if(changed == 0)        
        {
            return;
        } //End block
        int privateFlags = mPrivateFlags;
    if(((changed & FOCUSABLE_MASK) != 0) &&
                ((privateFlags & HAS_BOUNDS) !=0))        
        {
    if(((old & FOCUSABLE_MASK) == FOCUSABLE)
                    && ((privateFlags & FOCUSED) != 0))            
            {
                clearFocus();
            } //End block
            else
    if(((old & FOCUSABLE_MASK) == NOT_FOCUSABLE)
                    && ((privateFlags & FOCUSED) == 0))            
            {
    if(mParent != null)                
                mParent.focusableViewAvailable(this);
            } //End block
        } //End block
    if((flags & VISIBILITY_MASK) == VISIBLE)        
        {
    if((changed & VISIBILITY_MASK) != 0)            
            {
                mPrivateFlags |= DRAWN;
                invalidate(true);
                needGlobalAttributesUpdate(true);
    if((mParent != null) && (mBottom > mTop) && (mRight > mLeft))                
                {
                    mParent.focusableViewAvailable(this);
                } //End block
            } //End block
        } //End block
    if((changed & GONE) != 0)        
        {
            needGlobalAttributesUpdate(false);
            requestLayout();
    if(((mViewFlags & VISIBILITY_MASK) == GONE))            
            {
    if(hasFocus())                
                clearFocus();
                destroyDrawingCache();
    if(mParent instanceof View)                
                {
                    ((View) mParent).invalidate(true);
                } //End block
                mPrivateFlags |= DRAWN;
            } //End block
    if(mAttachInfo != null)            
            {
                mAttachInfo.mViewVisibilityChanged = true;
            } //End block
        } //End block
    if((changed & INVISIBLE) != 0)        
        {
            needGlobalAttributesUpdate(false);
            mPrivateFlags |= DRAWN;
    if(((mViewFlags & VISIBILITY_MASK) == INVISIBLE) && hasFocus())            
            {
    if(getRootView() != this)                
                {
                    clearFocus();
                } //End block
            } //End block
    if(mAttachInfo != null)            
            {
                mAttachInfo.mViewVisibilityChanged = true;
            } //End block
        } //End block
    if((changed & VISIBILITY_MASK) != 0)        
        {
    if(mParent instanceof ViewGroup)            
            {
                ((ViewGroup) mParent).onChildVisibilityChanged(this, (flags & VISIBILITY_MASK));
                ((View) mParent).invalidate(true);
            } //End block
            else
    if(mParent != null)            
            {
                mParent.invalidateChild(this, null);
            } //End block
            dispatchVisibilityChanged(this, (flags & VISIBILITY_MASK));
        } //End block
    if((changed & WILL_NOT_CACHE_DRAWING) != 0)        
        {
            destroyDrawingCache();
        } //End block
    if((changed & DRAWING_CACHE_ENABLED) != 0)        
        {
            destroyDrawingCache();
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            invalidateParentCaches();
        } //End block
    if((changed & DRAWING_CACHE_QUALITY_MASK) != 0)        
        {
            destroyDrawingCache();
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        } //End block
    if((changed & DRAW_MASK) != 0)        
        {
    if((mViewFlags & WILL_NOT_DRAW) != 0)            
            {
    if(mBGDrawable != null)                
                {
                    mPrivateFlags &= ~SKIP_DRAW;
                    mPrivateFlags |= ONLY_DRAWS_BACKGROUND;
                } //End block
                else
                {
                    mPrivateFlags |= SKIP_DRAW;
                } //End block
            } //End block
            else
            {
                mPrivateFlags &= ~SKIP_DRAW;
            } //End block
            requestLayout();
            invalidate(true);
        } //End block
    if((changed & KEEP_SCREEN_ON) != 0)        
        {
    if(mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)            
            {
                mParent.recomputeViewAttributes(this);
            } //End block
        } //End block
    if((changed & LAYOUT_DIRECTION_MASK) != 0)        
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "D3A1B9777480096EBBD21F82F884FF88", hash_generated_method = "30B26916A1861A6F8EE54291F6B0E39C")
    public void bringToFront() {
    if(mParent != null)        
        {
            mParent.bringChildToFront(this);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null) {
            //mParent.bringChildToFront(this);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "EDEAEC3E48D287D80E86A711CB6F1FA1", hash_generated_method = "0FC69F929AB1B536F1F28A8BDE2F1EFE")
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldt);
        addTaint(oldl);
        addTaint(t);
        addTaint(l);
    if(AccessibilityManager.getInstance(mContext).isEnabled())        
        {
            postSendViewScrolledAccessibilityEventCallback();
        } //End block
        mBackgroundSizeChanged = true;
        final AttachInfo ai = mAttachInfo;
    if(ai != null)        
        {
            ai.mViewScrollChanged = true;
        } //End block
        // ---------- Original Method ----------
        //if (AccessibilityManager.getInstance(mContext).isEnabled()) {
            //postSendViewScrolledAccessibilityEventCallback();
        //}
        //mBackgroundSizeChanged = true;
        //final AttachInfo ai = mAttachInfo;
        //if (ai != null) {
            //ai.mViewScrollChanged = true;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "B552DCA4F8335CB071F137C97CB4545F", hash_generated_method = "002F99225EE33BA3B69D5648F74D5A15")
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "3BF445E04BA2666375DFCD58601723DA")
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "23990FCA043695388FDF30165FAB53F8", hash_generated_method = "AE934F7D22CA30F42487441747EFF13C")
    public final ViewParent getParent() {
ViewParent var0FD24AAB8334CCBF65F979972AC650BD_1053309298 =         mParent;
        var0FD24AAB8334CCBF65F979972AC650BD_1053309298.addTaint(taint);
        return var0FD24AAB8334CCBF65F979972AC650BD_1053309298;
        // ---------- Original Method ----------
        //return mParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "A54235C6FCDDA2041C8AFAE3E4C1E483", hash_generated_method = "75FDE625F0F656AEAFE20F55ADBC463F")
    public void setScrollX(int value) {
        addTaint(value);
        scrollTo(value, mScrollY);
        // ---------- Original Method ----------
        //scrollTo(value, mScrollY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "F511D71F344E6F66807E97ABB51DFE9B", hash_generated_method = "EF7474FEFF1B13C0E78C4632B5B37DE7")
    public void setScrollY(int value) {
        addTaint(value);
        scrollTo(mScrollX, value);
        // ---------- Original Method ----------
        //scrollTo(mScrollX, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.022 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "E43C5CE643517B91ECD66E92773ADD40")
    public final int getScrollX() {
        int var9DC8F9676E14E93147EBEA37CE364B55_1571031013 = (mScrollX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479242273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479242273;
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "C97D31530FB31D5213F6BFAC523B503B")
    public final int getScrollY() {
        int var4ABBFD585ECE4FE40BECD8E0C30C4E5E_84121957 = (mScrollY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997537956 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_997537956;
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "FFF18028F96DB13B23AA35EC8A354DA6", hash_generated_method = "0DCF14208221AD617ACBA244D0790041")
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getWidth() {
        int var20F3EC73D1733E4595EAF2969537DCBC_651969845 = (mRight - mLeft);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156288240 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156288240;
        // ---------- Original Method ----------
        //return mRight - mLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "DB8E3D4F51A57F2E0389486CC016C662", hash_generated_method = "83BB22D5C439DC43F507E55CA55A8257")
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getHeight() {
        int var94734F9374EED7BBBA5D3FC64DB1B05E_529761119 = (mBottom - mTop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536437416 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536437416;
        // ---------- Original Method ----------
        //return mBottom - mTop;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "7CEA71A6443E0B0137E2E074FCAA909B", hash_generated_method = "F777CB8B57D81762E6E1F6CBB2BE23BC")
    public void getDrawingRect(Rect outRect) {
        addTaint(outRect.getTaint());
        outRect.left = mScrollX;
        outRect.top = mScrollY;
        outRect.right = mScrollX + (mRight - mLeft);
        outRect.bottom = mScrollY + (mBottom - mTop);
        // ---------- Original Method ----------
        //outRect.left = mScrollX;
        //outRect.top = mScrollY;
        //outRect.right = mScrollX + (mRight - mLeft);
        //outRect.bottom = mScrollY + (mBottom - mTop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "A160459557267C576C1546F5990AEB19", hash_generated_method = "B74A698EE5534646A7C10B137E0039F5")
    public final int getMeasuredWidth() {
        int varC7364098CE6B7D3F3AD7A3942B528BF7_28359043 = (mMeasuredWidth & MEASURED_SIZE_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914362202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_914362202;
        // ---------- Original Method ----------
        //return mMeasuredWidth & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "C38A45A87603EC21B0D791190210A10A", hash_generated_method = "0CD47208070B898A8B8DFE07287406F3")
    public final int getMeasuredWidthAndState() {
        int var30AF844796D32E1DD6D14B620B8355DF_911623932 = (mMeasuredWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400017927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400017927;
        // ---------- Original Method ----------
        //return mMeasuredWidth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "DA51B2F5E67991A819725ED6FD645434", hash_generated_method = "96AB9734B12E4A700715947633763456")
    public final int getMeasuredHeight() {
        int var7BB3ADD93FC0C02F16FF79AEA6BF5470_1691803315 = (mMeasuredHeight & MEASURED_SIZE_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269254809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_269254809;
        // ---------- Original Method ----------
        //return mMeasuredHeight & MEASURED_SIZE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.023 -0400", hash_original_method = "380B2985895F884CFF464A15E274F566", hash_generated_method = "45248B838CD534CA38A8507DB03314A5")
    public final int getMeasuredHeightAndState() {
        int var0EF7F253195B445FA5A8B4E98FA98667_477436602 = (mMeasuredHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611089015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611089015;
        // ---------- Original Method ----------
        //return mMeasuredHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.024 -0400", hash_original_method = "12D9B5BDD1AC8F21212E58A2AB0D2736", hash_generated_method = "54F2C657D6333213B4FC218514F90C04")
    public final int getMeasuredState() {
        int var65847BE4F21D4F65B4046996633DB1A8_1403208642 = ((mMeasuredWidth&MEASURED_STATE_MASK)
                | ((mMeasuredHeight>>MEASURED_HEIGHT_STATE_SHIFT)
                        & (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676440598 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1676440598;
        // ---------- Original Method ----------
        //return (mMeasuredWidth&MEASURED_STATE_MASK)
                //| ((mMeasuredHeight>>MEASURED_HEIGHT_STATE_SHIFT)
                        //& (MEASURED_STATE_MASK>>MEASURED_HEIGHT_STATE_SHIFT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.024 -0400", hash_original_method = "B4B4CEBFEE2F615BED379C4D0CB9432E", hash_generated_method = "70B86F97E4013F5538512A2BB6BF4F85")
    public Matrix getMatrix() {
    if(mTransformationInfo != null)        
        {
            updateMatrix();
Matrix var7C9CD4CB4FF63876216587DBF22B3308_1542374821 =             mTransformationInfo.mMatrix;
            var7C9CD4CB4FF63876216587DBF22B3308_1542374821.addTaint(taint);
            return var7C9CD4CB4FF63876216587DBF22B3308_1542374821;
        } //End block
Matrix var530F432EB8944544BD1B99BF930523E4_1401751954 =         Matrix.IDENTITY_MATRIX;
        var530F432EB8944544BD1B99BF930523E4_1401751954.addTaint(taint);
        return var530F432EB8944544BD1B99BF930523E4_1401751954;
        // ---------- Original Method ----------
        //if (mTransformationInfo != null) {
            //updateMatrix();
            //return mTransformationInfo.mMatrix;
        //}
        //return Matrix.IDENTITY_MATRIX;
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean nonzero(float value) {
        return (value < -NONZERO_EPSILON || value > NONZERO_EPSILON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.024 -0400", hash_original_method = "5E74D6706011574C7C512DCC96608456", hash_generated_method = "34BE767F4A088E50058FCFE89C7507E1")
    final boolean hasIdentityMatrix() {
    if(mTransformationInfo != null)        
        {
            updateMatrix();
            boolean var42D917E0CF36B87ACC49D4576FBF0D3D_729408135 = (mTransformationInfo.mMatrixIsIdentity);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1455298505 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1455298505;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1066754556 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1862840711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1862840711;
        // ---------- Original Method ----------
        //if (mTransformationInfo != null) {
            //updateMatrix();
            //return mTransformationInfo.mMatrixIsIdentity;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.024 -0400", hash_original_method = "4153D754422EE39DF2ACBB08A45B169B", hash_generated_method = "ACADFAC1D186E0757CFAA2F7095B0D9B")
     void ensureTransformationInfo() {
    if(mTransformationInfo == null)        
        {
            mTransformationInfo = new TransformationInfo();
        } //End block
        // ---------- Original Method ----------
        //if (mTransformationInfo == null) {
            //mTransformationInfo = new TransformationInfo();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.025 -0400", hash_original_method = "1DF4F5A3EE086291C2134A9A06069FA8", hash_generated_method = "3C31A6B560D4C0342AC29292924E4977")
    private void updateMatrix() {
        final TransformationInfo info = mTransformationInfo;
    if(info == null)        
        {
            return;
        } //End block
    if(info.mMatrixDirty)        
        {
    if((mPrivateFlags & PIVOT_EXPLICITLY_SET) == 0)            
            {
    if((mRight - mLeft) != info.mPrevWidth || (mBottom - mTop) != info.mPrevHeight)                
                {
                    info.mPrevWidth = mRight - mLeft;
                    info.mPrevHeight = mBottom - mTop;
                    info.mPivotX = info.mPrevWidth / 2f;
                    info.mPivotY = info.mPrevHeight / 2f;
                } //End block
            } //End block
            info.mMatrix.reset();
    if(!nonzero(info.mRotationX) && !nonzero(info.mRotationY))            
            {
                info.mMatrix.setTranslate(info.mTranslationX, info.mTranslationY);
                info.mMatrix.preRotate(info.mRotation, info.mPivotX, info.mPivotY);
                info.mMatrix.preScale(info.mScaleX, info.mScaleY, info.mPivotX, info.mPivotY);
            } //End block
            else
            {
    if(info.mCamera == null)                
                {
                    info.mCamera = new Camera();
                    info.matrix3D = new Matrix();
                } //End block
                info.mCamera.save();
                info.mMatrix.preScale(info.mScaleX, info.mScaleY, info.mPivotX, info.mPivotY);
                info.mCamera.rotate(info.mRotationX, info.mRotationY, -info.mRotation);
                info.mCamera.getMatrix(info.matrix3D);
                info.matrix3D.preTranslate(-info.mPivotX, -info.mPivotY);
                info.matrix3D.postTranslate(info.mPivotX + info.mTranslationX,
                        info.mPivotY + info.mTranslationY);
                info.mMatrix.postConcat(info.matrix3D);
                info.mCamera.restore();
            } //End block
            info.mMatrixDirty = false;
            info.mMatrixIsIdentity = info.mMatrix.isIdentity();
            info.mInverseMatrixDirty = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.025 -0400", hash_original_method = "9D52A0CAB8326A9AD998EDD411D2DD92", hash_generated_method = "66191BD22800F266BFA2AC207098FEFE")
    final Matrix getInverseMatrix() {
        final TransformationInfo info = mTransformationInfo;
    if(info != null)        
        {
            updateMatrix();
    if(info.mInverseMatrixDirty)            
            {
    if(info.mInverseMatrix == null)                
                {
                    info.mInverseMatrix = new Matrix();
                } //End block
                info.mMatrix.invert(info.mInverseMatrix);
                info.mInverseMatrixDirty = false;
            } //End block
Matrix var5741C1ADCD556059C1E3F1A614309277_1388514172 =             info.mInverseMatrix;
            var5741C1ADCD556059C1E3F1A614309277_1388514172.addTaint(taint);
            return var5741C1ADCD556059C1E3F1A614309277_1388514172;
        } //End block
Matrix var530F432EB8944544BD1B99BF930523E4_2051483983 =         Matrix.IDENTITY_MATRIX;
        var530F432EB8944544BD1B99BF930523E4_2051483983.addTaint(taint);
        return var530F432EB8944544BD1B99BF930523E4_2051483983;
        // ---------- Original Method ----------
        //final TransformationInfo info = mTransformationInfo;
        //if (info != null) {
            //updateMatrix();
            //if (info.mInverseMatrixDirty) {
                //if (info.mInverseMatrix == null) {
                    //info.mInverseMatrix = new Matrix();
                //}
                //info.mMatrix.invert(info.mInverseMatrix);
                //info.mInverseMatrixDirty = false;
            //}
            //return info.mInverseMatrix;
        //}
        //return Matrix.IDENTITY_MATRIX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.025 -0400", hash_original_method = "210DCA800515E4777DE0E07A52837B76", hash_generated_method = "497C1CB02BC85973B769E0434F0B4C4A")
    public void setCameraDistance(float distance) {
        addTaint(distance);
        invalidateParentCaches();
        invalidate(false);
        ensureTransformationInfo();
        final float dpi = mResources.getDisplayMetrics().densityDpi;
        final TransformationInfo info = mTransformationInfo;
    if(info.mCamera == null)        
        {
            info.mCamera = new Camera();
            info.matrix3D = new Matrix();
        } //End block
        info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        info.mMatrixDirty = true;
        invalidate(false);
        // ---------- Original Method ----------
        //invalidateParentCaches();
        //invalidate(false);
        //ensureTransformationInfo();
        //final float dpi = mResources.getDisplayMetrics().densityDpi;
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mCamera == null) {
            //info.mCamera = new Camera();
            //info.matrix3D = new Matrix();
        //}
        //info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        //info.mMatrixDirty = true;
        //invalidate(false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.025 -0400", hash_original_method = "6D5D42AE33FC6FF98224E10EE022285B", hash_generated_method = "C21B6718BCAF0686BEBCCA6A3DA88BC7")
    public float getRotation() {
        float var0AA40746965029C630FFAF44A9414AE3_701585621 = (mTransformationInfo != null ? mTransformationInfo.mRotation : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_943471134 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_943471134;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotation : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.025 -0400", hash_original_method = "5A5E2BB985CAA77255785D52BE0C3968", hash_generated_method = "15AB22910B579BB9024D4EEC2AD61731")
    public void setRotation(float rotation) {
        addTaint(rotation);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mRotation != rotation)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotation = rotation;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mRotation != rotation) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mRotation = rotation;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.026 -0400", hash_original_method = "AE949F6C8375A0B1C86B95F13F6ACDFA", hash_generated_method = "29D86D84A80A130C381D95554AE41D61")
    public float getRotationY() {
        float var161748DCA17BA25F37117A004F28AC0A_275911826 = (mTransformationInfo != null ? mTransformationInfo.mRotationY : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_961687721 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_961687721;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotationY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.026 -0400", hash_original_method = "5A233F5FAA167B597E6F53F6A1ED05E0", hash_generated_method = "F93CD20A889468CF28AF328650BD996E")
    public void setRotationY(float rotationY) {
        addTaint(rotationY);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mRotationY != rotationY)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationY = rotationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mRotationY != rotationY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mRotationY = rotationY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.026 -0400", hash_original_method = "A555D00D0BA60E223889AA9DD2F251D5", hash_generated_method = "719AC1BAD87FC26396837AB6C5AB45D4")
    public float getRotationX() {
        float varC290E5DEFE5EA777F51A1833A8108AE3_1607722634 = (mTransformationInfo != null ? mTransformationInfo.mRotationX : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_1730857435 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1730857435;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mRotationX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.026 -0400", hash_original_method = "6E42F99146F1D6958E2B3C15F474346C", hash_generated_method = "DB6ADE09C034857F92A22D21E2BFE220")
    public void setRotationX(float rotationX) {
        addTaint(rotationX);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mRotationX != rotationX)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationX = rotationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mRotationX != rotationX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mRotationX = rotationX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.026 -0400", hash_original_method = "632CD3DC31F3C9373697ECAF67FAF844", hash_generated_method = "BCC19B18822E1C0C1388C067ED7C5C4C")
    public float getScaleX() {
        float var0B6C0AE79FB2A1D62F2B63FCD9492CC0_1947701881 = (mTransformationInfo != null ? mTransformationInfo.mScaleX : 1);
                float var546ADE640B6EDFBC8A086EF31347E768_1770313030 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1770313030;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mScaleX : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.027 -0400", hash_original_method = "5D4E1982532E84086C93276B88F3BB0F", hash_generated_method = "90D6A532D2CD38D91989A41A4342C7AB")
    public void setScaleX(float scaleX) {
        addTaint(scaleX);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mScaleX != scaleX)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleX = scaleX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mScaleX != scaleX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mScaleX = scaleX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.027 -0400", hash_original_method = "0DC96E7C5CC6BBD5C09BD0CF27C74A57", hash_generated_method = "7481E8EBCC603ED46B4C8578D3B62E4C")
    public float getScaleY() {
        float varF1F4A73FF139710DAEC679D4C337BEF9_950049925 = (mTransformationInfo != null ? mTransformationInfo.mScaleY : 1);
                float var546ADE640B6EDFBC8A086EF31347E768_2026267065 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2026267065;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mScaleY : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.027 -0400", hash_original_method = "31C6EE08A123288B2AD5FB7A2AB8A50C", hash_generated_method = "925E0B55F652A796D85A68F255DCC311")
    public void setScaleY(float scaleY) {
        addTaint(scaleY);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mScaleY != scaleY)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleY = scaleY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mScaleY != scaleY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mScaleY = scaleY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.028 -0400", hash_original_method = "AEC7496CCA4C936C6BC2B5B4BAFC57DA", hash_generated_method = "EA319FCC4F12EC00A527500078DB8F56")
    public float getPivotX() {
        float var7B52150A513AFB4A6703016D161E62FC_530663161 = (mTransformationInfo != null ? mTransformationInfo.mPivotX : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_1134895233 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1134895233;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mPivotX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.028 -0400", hash_original_method = "DBB537948450A8273883C6E25FB642C5", hash_generated_method = "F823411225F40D2FF4E9A7D44E344E9D")
    public void setPivotX(float pivotX) {
        addTaint(pivotX);
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
    if(info.mPivotX != pivotX)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotX = pivotX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mPivotX != pivotX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mPivotX = pivotX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.028 -0400", hash_original_method = "0240E9206D9E9715A6B3E78480FB3A00", hash_generated_method = "5AE24C796CAB79F32D1025DB39D7F05E")
    public float getPivotY() {
        float var9BA5BE18AFC7DC2E2332149E40DFF6BD_1047360898 = (mTransformationInfo != null ? mTransformationInfo.mPivotY : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_97060688 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_97060688;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mPivotY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.028 -0400", hash_original_method = "6A61D38311657070A62B2EA4ECB210D8", hash_generated_method = "682078BAF40C2FB87E23EBAB97BFDD9E")
    public void setPivotY(float pivotY) {
        addTaint(pivotY);
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
    if(info.mPivotY != pivotY)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotY = pivotY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mPivotY != pivotY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mPivotY = pivotY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.028 -0400", hash_original_method = "93EFA4392922E182D3B77409B1564364", hash_generated_method = "3FB5DC55332C0FAC3BADB38B1D3930ED")
    public float getAlpha() {
        float var081CCBDA5D6CF05666A5CD9BDEC63377_1853794538 = (mTransformationInfo != null ? mTransformationInfo.mAlpha : 1);
                float var546ADE640B6EDFBC8A086EF31347E768_1538777099 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1538777099;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mAlpha : 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.030 -0400", hash_original_method = "D47D7B67C2848D6684CE263C68979D07", hash_generated_method = "FC87265BCD3523A20FE3871E324C7D4A")
    public void setAlpha(float alpha) {
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        invalidateParentCaches();
    if(onSetAlpha((int) (alpha * 255)))        
        {
            mPrivateFlags |= ALPHA_SET;
            invalidate(true);
        } //End block
        else
        {
            mPrivateFlags &= ~ALPHA_SET;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
        //invalidateParentCaches();
        //if (onSetAlpha((int) (alpha * 255))) {
            //mPrivateFlags |= ALPHA_SET;
            //invalidate(true);
        //} else {
            //mPrivateFlags &= ~ALPHA_SET;
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.031 -0400", hash_original_method = "3CB99BAEF01722CCB474EC85E6659EEE", hash_generated_method = "D87CCB84A37F81D9888F44DF807DD57E")
     boolean setAlphaNoInvalidation(float alpha) {
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        boolean subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
    if(subclassHandlesAlpha)        
        {
            mPrivateFlags |= ALPHA_SET;
        } //End block
        else
        {
            mPrivateFlags &= ~ALPHA_SET;
        } //End block
        boolean var51240E4A8D3C749DD52AB3BCC6BFB841_100703785 = (subclassHandlesAlpha);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676896203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676896203;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
        //boolean subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
        //if (subclassHandlesAlpha) {
            //mPrivateFlags |= ALPHA_SET;
        //} else {
            //mPrivateFlags &= ~ALPHA_SET;
        //}
        //return subclassHandlesAlpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.031 -0400", hash_original_method = "7F5BCC343553D8AF12DD736B7A32ED37", hash_generated_method = "B604D89B533A15F4B14E313E9CE16370")
    @ViewDebug.CapturedViewProperty
    public final int getTop() {
        int varD09DA346C6637C81F0228C8D0347388B_755381521 = (mTop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430446518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_430446518;
        // ---------- Original Method ----------
        //return mTop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.033 -0400", hash_original_method = "B40CE7C2F79D3592297A6568172CADD8", hash_generated_method = "0E15BF794ABC1356CE3B03EBD2DD51AB")
    public final void setTop(int top) {
    if(top != mTop)        
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
    if(matrixIsIdentity)            
            {
    if(mAttachInfo != null)                
                {
                    int minTop;
                    int yLoc;
    if(top < mTop)                    
                    {
                        minTop = top;
                        yLoc = top - mTop;
                    } //End block
                    else
                    {
                        minTop = mTop;
                        yLoc = 0;
                    } //End block
                    invalidate(0, yLoc, mRight - mLeft, mBottom - minTop);
                } //End block
            } //End block
            else
            {
                invalidate(true);
            } //End block
            int width = mRight - mLeft;
            int oldHeight = mBottom - mTop;
            mTop = top;
            onSizeChanged(width, mBottom - mTop, width, oldHeight);
    if(!matrixIsIdentity)            
            {
    if((mPrivateFlags & PIVOT_EXPLICITLY_SET) == 0)                
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.034 -0400", hash_original_method = "D7B6007ED4F8CEAF5E034DAB4DC51ADC", hash_generated_method = "E5592E383B244C7ABA839F9746715643")
    @ViewDebug.CapturedViewProperty
    public final int getBottom() {
        int var2FFD20D7E48915664FDF7F12FC3889D8_1022348420 = (mBottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268388372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_268388372;
        // ---------- Original Method ----------
        //return mBottom;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.034 -0400", hash_original_method = "389E1BFAE78D9C18A209C3C1F1063911", hash_generated_method = "2988DB83BAAC47361BDBDCA79D61080B")
    public boolean isDirty() {
        boolean varF30644B9561E50E8F6B339AF897D34B2_104378643 = ((mPrivateFlags & DIRTY_MASK) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518084210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518084210;
        // ---------- Original Method ----------
        //return (mPrivateFlags & DIRTY_MASK) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.035 -0400", hash_original_method = "23478A87AB3417F9EDAE904815FA444D", hash_generated_method = "3FF8A959C6378FE5BFA86AEF97A76ABC")
    public final void setBottom(int bottom) {
    if(bottom != mBottom)        
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
    if(matrixIsIdentity)            
            {
    if(mAttachInfo != null)                
                {
                    int maxBottom;
    if(bottom < mBottom)                    
                    {
                        maxBottom = mBottom;
                    } //End block
                    else
                    {
                        maxBottom = bottom;
                    } //End block
                    invalidate(0, 0, mRight - mLeft, maxBottom - mTop);
                } //End block
            } //End block
            else
            {
                invalidate(true);
            } //End block
            int width = mRight - mLeft;
            int oldHeight = mBottom - mTop;
            mBottom = bottom;
            onSizeChanged(width, mBottom - mTop, width, oldHeight);
    if(!matrixIsIdentity)            
            {
    if((mPrivateFlags & PIVOT_EXPLICITLY_SET) == 0)                
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.035 -0400", hash_original_method = "73B96062BAB5FB21A32F13529B38306E", hash_generated_method = "DDB6E4D97BBCAB6658A64AB18824A1A6")
    @ViewDebug.CapturedViewProperty
    public final int getLeft() {
        int varB5B776A6642DD69B16A47E6FCCAEEB6E_1320805630 = (mLeft);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008148912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1008148912;
        // ---------- Original Method ----------
        //return mLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.036 -0400", hash_original_method = "400602AE9C159A853CD1519C8EEA2C4D", hash_generated_method = "99E5A1F9B1DC56718802B6B6FF0AF4D6")
    public final void setLeft(int left) {
    if(left != mLeft)        
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
    if(matrixIsIdentity)            
            {
    if(mAttachInfo != null)                
                {
                    int minLeft;
                    int xLoc;
    if(left < mLeft)                    
                    {
                        minLeft = left;
                        xLoc = left - mLeft;
                    } //End block
                    else
                    {
                        minLeft = mLeft;
                        xLoc = 0;
                    } //End block
                    invalidate(xLoc, 0, mRight - minLeft, mBottom - mTop);
                } //End block
            } //End block
            else
            {
                invalidate(true);
            } //End block
            int oldWidth = mRight - mLeft;
            int height = mBottom - mTop;
            mLeft = left;
            onSizeChanged(mRight - mLeft, height, oldWidth, height);
    if(!matrixIsIdentity)            
            {
    if((mPrivateFlags & PIVOT_EXPLICITLY_SET) == 0)                
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.038 -0400", hash_original_method = "BAA591F437367FFFE3E50F2B2874B150", hash_generated_method = "33D9547FACA1354802679F4C1345D454")
    @ViewDebug.CapturedViewProperty
    public final int getRight() {
        int var720807298C0DE3DCF41AEC725F26A5A1_1633647964 = (mRight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943818169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_943818169;
        // ---------- Original Method ----------
        //return mRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.038 -0400", hash_original_method = "2D86637EDDF21E63210ED8568FEA8F8B", hash_generated_method = "E0E5AA7A6F52A0E03B6F0BE667C3AA4A")
    public final void setRight(int right) {
    if(right != mRight)        
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
    if(matrixIsIdentity)            
            {
    if(mAttachInfo != null)                
                {
                    int maxRight;
    if(right < mRight)                    
                    {
                        maxRight = mRight;
                    } //End block
                    else
                    {
                        maxRight = right;
                    } //End block
                    invalidate(0, 0, maxRight - mLeft, mBottom - mTop);
                } //End block
            } //End block
            else
            {
                invalidate(true);
            } //End block
            int oldWidth = mRight - mLeft;
            int height = mBottom - mTop;
            mRight = right;
            onSizeChanged(mRight - mLeft, height, oldWidth, height);
    if(!matrixIsIdentity)            
            {
    if((mPrivateFlags & PIVOT_EXPLICITLY_SET) == 0)                
                {
                    mTransformationInfo.mMatrixDirty = true;
                } //End block
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } //End block
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.038 -0400", hash_original_method = "245DBA10F47190D5F336E33CB089C2B3", hash_generated_method = "EA5DE2D2EA0FCB8BDA2A481A921D13A1")
    public float getX() {
        float var9305DEFD2649264342316797ED0D21D0_1544501691 = (mLeft + (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0));
                float var546ADE640B6EDFBC8A086EF31347E768_2134869826 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2134869826;
        // ---------- Original Method ----------
        //return mLeft + (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.040 -0400", hash_original_method = "CF32EA1F394F68FC79E0B0DE51F0C329", hash_generated_method = "EE5A41F1DC0F1D5CD20ACA5ED8540063")
    public void setX(float x) {
        addTaint(x);
        setTranslationX(x - mLeft);
        // ---------- Original Method ----------
        //setTranslationX(x - mLeft);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.041 -0400", hash_original_method = "52DD2F53B3B778139AEDE644F53CC413", hash_generated_method = "7DFE67794336BE7127C961C7C8AB199F")
    public float getY() {
        float var6EB4FBC5298FB39426EC8A3026DA26CE_985089550 = (mTop + (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0));
                float var546ADE640B6EDFBC8A086EF31347E768_833496599 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_833496599;
        // ---------- Original Method ----------
        //return mTop + (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.041 -0400", hash_original_method = "17990A784E3651A021C8D9C97053B995", hash_generated_method = "7945481C225198BD280D3B390F84B69F")
    public void setY(float y) {
        addTaint(y);
        setTranslationY(y - mTop);
        // ---------- Original Method ----------
        //setTranslationY(y - mTop);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.041 -0400", hash_original_method = "A376723ACFB723DF70FCDB72B84F3B74", hash_generated_method = "891DA9D21783096F1AB5859384F83F20")
    public float getTranslationX() {
        float var5E460E47D194E86A5174CCE8F651C550_455086211 = (mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_1574067807 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1574067807;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mTranslationX : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.042 -0400", hash_original_method = "099C9E42CAA9B2F0466F96FB99A2B049", hash_generated_method = "D1F6ADB47227CDA3FE8C52BD734B482D")
    public void setTranslationX(float translationX) {
        addTaint(translationX);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mTranslationX != translationX)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationX = translationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mTranslationX != translationX) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mTranslationX = translationX;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.042 -0400", hash_original_method = "3533DDBA4926D8143F5FEBC602AC7438", hash_generated_method = "1FA90FED729B3600B7D81AC2FF32DF45")
    public float getTranslationY() {
        float var699842D29065BEBBC971D320C3C2CC6C_1191826346 = (mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0);
                float var546ADE640B6EDFBC8A086EF31347E768_353576079 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_353576079;
        // ---------- Original Method ----------
        //return mTransformationInfo != null ? mTransformationInfo.mTranslationY : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.043 -0400", hash_original_method = "162C2FF9FF4565DE36BAE7FE449EEB59", hash_generated_method = "65065235F12D8B9F1B751CCE70CBD61B")
    public void setTranslationY(float translationY) {
        addTaint(translationY);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
    if(info.mTranslationY != translationY)        
        {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationY = translationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } //End block
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //if (info.mTranslationY != translationY) {
            //invalidateParentCaches();
            //invalidate(false);
            //info.mTranslationY = translationY;
            //info.mMatrixDirty = true;
            //mPrivateFlags |= DRAWN; 
            //invalidate(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.043 -0400", hash_original_method = "02B92D2EDB4EF774368BD328DB9464D0", hash_generated_method = "9C9456FE49907BCB27D2C445E3413DF6")
    public void setFastTranslationX(float x) {
        addTaint(x);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationX = x;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.043 -0400", hash_original_method = "7A3DD70389071B86917A72495144388B", hash_generated_method = "2A8C1F9492BF9A74EBE3866534792AA3")
    public void setFastTranslationY(float y) {
        addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.044 -0400", hash_original_method = "27E5E5A6B58B43EDE1C38FBEFFB0B4F7", hash_generated_method = "56238CC21CF3CF0F75C29F6F0C90FAF7")
    public void setFastX(float x) {
        addTaint(x);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x - mLeft;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationX = x - mLeft;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.055 -0400", hash_original_method = "435AAC5941937B26A66754F689D5E36E", hash_generated_method = "14B3AFDDC51B2308F239DD61D92E3279")
    public void setFastY(float y) {
        addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y - mTop;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mTranslationY = y - mTop;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.055 -0400", hash_original_method = "8FBF5EB14D6023B3D32370623C07D6EB", hash_generated_method = "D4FB71BD84798C0B542656CA8EBE5EC6")
    public void setFastScaleX(float x) {
        addTaint(x);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleX = x;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mScaleX = x;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.055 -0400", hash_original_method = "AA6BDD2065E69990CAD75C2A9525B2D0", hash_generated_method = "C1D3572968AA4F1FE3E2DF0336EECB8E")
    public void setFastScaleY(float y) {
        addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mScaleY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.056 -0400", hash_original_method = "AD7F6BBA7BB1872387A16DCF0021D7AA", hash_generated_method = "621D2591E23FA811817E9AE822951428")
    public void setFastAlpha(float alpha) {
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //mTransformationInfo.mAlpha = alpha;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.056 -0400", hash_original_method = "3ADB507BF62ACDA7E6B7E6725B1B98A0", hash_generated_method = "82E85ABA2E0B25CD74727AEB1F148063")
    public void setFastRotationY(float y) {
        addTaint(y);
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mRotationY = y;
        info.mMatrixDirty = true;
        // ---------- Original Method ----------
        //ensureTransformationInfo();
        //final TransformationInfo info = mTransformationInfo;
        //info.mRotationY = y;
        //info.mMatrixDirty = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.056 -0400", hash_original_method = "CD4FEC45EB5F7DBC5B440DED4446311E", hash_generated_method = "15E1D45E097AAB40C4D3352908365E32")
    public void getHitRect(Rect outRect) {
        addTaint(outRect.getTaint());
        updateMatrix();
        final TransformationInfo info = mTransformationInfo;
    if(info == null || info.mMatrixIsIdentity || mAttachInfo == null)        
        {
            outRect.set(mLeft, mTop, mRight, mBottom);
        } //End block
        else
        {
            final RectF tmpRect = mAttachInfo.mTmpTransformRect;
            tmpRect.set(-info.mPivotX, -info.mPivotY,
                    getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            info.mMatrix.mapRect(tmpRect);
            outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    (int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        } //End block
        // ---------- Original Method ----------
        //updateMatrix();
        //final TransformationInfo info = mTransformationInfo;
        //if (info == null || info.mMatrixIsIdentity || mAttachInfo == null) {
            //outRect.set(mLeft, mTop, mRight, mBottom);
        //} else {
            //final RectF tmpRect = mAttachInfo.mTmpTransformRect;
            //tmpRect.set(-info.mPivotX, -info.mPivotY,
                    //getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            //info.mMatrix.mapRect(tmpRect);
            //outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    //(int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.056 -0400", hash_original_method = "E2A76004025C1F44E382F6372B86BB53", hash_generated_method = "B2576839191966C7F2EC466B1A100788")
    final boolean pointInView(float localX, float localY) {
        addTaint(localY);
        addTaint(localX);
        boolean varD1F076381110EB17A221F1FA6D9019B9_327442080 = (localX >= 0 && localX < (mRight - mLeft)
                && localY >= 0 && localY < (mBottom - mTop));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155912574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155912574;
        // ---------- Original Method ----------
        //return localX >= 0 && localX < (mRight - mLeft)
                //&& localY >= 0 && localY < (mBottom - mTop);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.056 -0400", hash_original_method = "D00244756776E7D2FD65633E1CF43263", hash_generated_method = "269E582AE9C6157A846DA2F32421BAE6")
    private boolean pointInView(float localX, float localY, float slop) {
        addTaint(slop);
        addTaint(localY);
        addTaint(localX);
        boolean var0B42A372E2EAFCAB807D2ED61B554D18_1398713662 = (localX >= -slop && localY >= -slop && localX < ((mRight - mLeft) + slop) &&
                localY < ((mBottom - mTop) + slop));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684959652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684959652;
        // ---------- Original Method ----------
        //return localX >= -slop && localY >= -slop && localX < ((mRight - mLeft) + slop) &&
                //localY < ((mBottom - mTop) + slop);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.056 -0400", hash_original_method = "DDDABA6E6D899E7EA47B4452312088BE", hash_generated_method = "69C4A92C4F90015594D633B62B00353F")
    public void getFocusedRect(Rect r) {
        addTaint(r.getTaint());
        getDrawingRect(r);
        // ---------- Original Method ----------
        //getDrawingRect(r);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.057 -0400", hash_original_method = "24BDD9FA3E3C2FB6EA31ED75B384BDD9", hash_generated_method = "5102647ED05E695DF2E2874132B9BE9B")
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        addTaint(globalOffset.getTaint());
        addTaint(r.getTaint());
        int width = mRight - mLeft;
        int height = mBottom - mTop;
    if(width > 0 && height > 0)        
        {
            r.set(0, 0, width, height);
    if(globalOffset != null)            
            {
                globalOffset.set(-mScrollX, -mScrollY);
            } //End block
            boolean var0CE83123297DE8960892757CC7A7736A_1962194337 = (mParent == null || mParent.getChildVisibleRect(this, r, globalOffset));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188244374 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188244374;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1335578249 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670906875 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670906875;
        // ---------- Original Method ----------
        //int width = mRight - mLeft;
        //int height = mBottom - mTop;
        //if (width > 0 && height > 0) {
            //r.set(0, 0, width, height);
            //if (globalOffset != null) {
                //globalOffset.set(-mScrollX, -mScrollY);
            //}
            //return mParent == null || mParent.getChildVisibleRect(this, r, globalOffset);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.057 -0400", hash_original_method = "EADCD4C63731C6547F1C03CEAFC09A53", hash_generated_method = "E36FCEE181C6CBC544BCECCE724B2124")
    public final boolean getGlobalVisibleRect(Rect r) {
        addTaint(r.getTaint());
        boolean var3B0C16763C024380CCBF989323A18624_197086412 = (getGlobalVisibleRect(r, null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_635658288 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_635658288;
        // ---------- Original Method ----------
        //return getGlobalVisibleRect(r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.057 -0400", hash_original_method = "CB024757CF5A14ECB6F9DCD9789CD2F8", hash_generated_method = "285D4076CB24F26220F8ECB24B208B44")
    public final boolean getLocalVisibleRect(Rect r) {
        addTaint(r.getTaint());
        Point offset = new Point();
    if(getGlobalVisibleRect(r, offset))        
        {
            r.offset(-offset.x, -offset.y);
            boolean varB326B5062B2F0E69046810717534CB09_2014171669 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192467898 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192467898;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_483597308 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_82899071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_82899071;
        // ---------- Original Method ----------
        //Point offset = new Point();
        //if (getGlobalVisibleRect(r, offset)) {
            //r.offset(-offset.x, -offset.y); 
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.058 -0400", hash_original_method = "5A4ADD2D1ADF5703ED27FAE1582BB62A", hash_generated_method = "9922968F8CBE9F7631B37BC79B6247A7")
    public void offsetTopAndBottom(int offset) {
    if(offset != 0)        
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
    if(matrixIsIdentity)            
            {
                final ViewParent p = mParent;
    if(p != null && mAttachInfo != null)                
                {
                    final Rect r = mAttachInfo.mTmpInvalRect;
                    int minTop;
                    int maxBottom;
                    int yLoc;
    if(offset < 0)                    
                    {
                        minTop = mTop + offset;
                        maxBottom = mBottom;
                        yLoc = offset;
                    } //End block
                    else
                    {
                        minTop = mTop;
                        maxBottom = mBottom + offset;
                        yLoc = 0;
                    } //End block
                    r.set(0, yLoc, mRight - mLeft, maxBottom - minTop);
                    p.invalidateChild(this, r);
                } //End block
            } //End block
            else
            {
                invalidate(false);
            } //End block
            mTop += offset;
            mBottom += offset;
    if(!matrixIsIdentity)            
            {
                mPrivateFlags |= DRAWN;
                invalidate(false);
            } //End block
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.058 -0400", hash_original_method = "A934BA60BC3812BC980C4328CCEB9557", hash_generated_method = "F2209CB2E9CB73CC66B465A06BBD0BFE")
    public void offsetLeftAndRight(int offset) {
    if(offset != 0)        
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
    if(matrixIsIdentity)            
            {
                final ViewParent p = mParent;
    if(p != null && mAttachInfo != null)                
                {
                    final Rect r = mAttachInfo.mTmpInvalRect;
                    int minLeft;
                    int maxRight;
    if(offset < 0)                    
                    {
                        minLeft = mLeft + offset;
                        maxRight = mRight;
                    } //End block
                    else
                    {
                        minLeft = mLeft;
                        maxRight = mRight + offset;
                    } //End block
                    r.set(0, 0, maxRight - minLeft, mBottom - mTop);
                    p.invalidateChild(this, r);
                } //End block
            } //End block
            else
            {
                invalidate(false);
            } //End block
            mLeft += offset;
            mRight += offset;
    if(!matrixIsIdentity)            
            {
                mPrivateFlags |= DRAWN;
                invalidate(false);
            } //End block
            invalidateParentIfNeeded();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.058 -0400", hash_original_method = "5EB740A9A129A62709C940CDC3C1FA90", hash_generated_method = "6D0AB3E667BA6E1B0E34325112438FF0")
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
ViewGroup.LayoutParams varBC422307962CA736CE11EE8BCF6976E5_691216533 =         mLayoutParams;
        varBC422307962CA736CE11EE8BCF6976E5_691216533.addTaint(taint);
        return varBC422307962CA736CE11EE8BCF6976E5_691216533;
        // ---------- Original Method ----------
        //return mLayoutParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.058 -0400", hash_original_method = "279E70A70FA2B2FEFF6E7E1E87EEDC2B", hash_generated_method = "27B7F74DBAB3530CA468D7155D595670")
    public void setLayoutParams(ViewGroup.LayoutParams params) {
    if(params == null)        
        {
            NullPointerException var2A419BC4B55C0F255253ADE95268C482_654235178 = new NullPointerException("Layout parameters cannot be null");
            var2A419BC4B55C0F255253ADE95268C482_654235178.addTaint(taint);
            throw var2A419BC4B55C0F255253ADE95268C482_654235178;
        } //End block
        mLayoutParams = params;
        requestLayout();
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new NullPointerException("Layout parameters cannot be null");
        //}
        //mLayoutParams = params;
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.058 -0400", hash_original_method = "C9DC0366B539164245F3B3ACA0A07797", hash_generated_method = "74C326C7DE2A5769EED272A4162375E9")
    public void scrollTo(int x, int y) {
    if(mScrollX != x || mScrollY != y)        
        {
            int oldX = mScrollX;
            int oldY = mScrollY;
            mScrollX = x;
            mScrollY = y;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
    if(!awakenScrollBars())            
            {
                invalidate(true);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mScrollX != x || mScrollY != y) {
            //int oldX = mScrollX;
            //int oldY = mScrollY;
            //mScrollX = x;
            //mScrollY = y;
            //invalidateParentCaches();
            //onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            //if (!awakenScrollBars()) {
                //invalidate(true);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.059 -0400", hash_original_method = "9A3BFF0D9282AAB8B07B22048D68076B", hash_generated_method = "42249A3A6C8299F6D9670B7BCFF9929C")
    public void scrollBy(int x, int y) {
        addTaint(y);
        addTaint(x);
        scrollTo(mScrollX + x, mScrollY + y);
        // ---------- Original Method ----------
        //scrollTo(mScrollX + x, mScrollY + y);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.059 -0400", hash_original_method = "08F687B40826EF7DBBF2573184DC2210", hash_generated_method = "61BFBCE761FADFE65276D95177DA8D48")
    protected boolean awakenScrollBars() {
        boolean var0793F0016DB4614B53DD0EC66D04D8C7_1021792263 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391774924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_391774924;
        // ---------- Original Method ----------
        //return mScrollCache != null &&
                //awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.059 -0400", hash_original_method = "2B4CF6E85FAE9FF55F32C24BEFDC5081", hash_generated_method = "5DAABA89B196593228B4D32DD92A1C21")
    private boolean initialAwakenScrollBars() {
        boolean varBEBABCBF0F3150168E413021A1A55E2D_338024871 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92086904 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92086904;
        // ---------- Original Method ----------
        //return mScrollCache != null &&
                //awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.059 -0400", hash_original_method = "D5CE7E5EDCD7F839910A14AF470AF787", hash_generated_method = "44AC5FDF05B5C737354A17F248AE4ADB")
    protected boolean awakenScrollBars(int startDelay) {
        addTaint(startDelay);
        boolean varA9F1CBD17414F3838D5D9430455E1863_2041520886 = (awakenScrollBars(startDelay, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185367670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_185367670;
        // ---------- Original Method ----------
        //return awakenScrollBars(startDelay, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.059 -0400", hash_original_method = "CAD4350A25772201F660B41D91481A2E", hash_generated_method = "76269FAA775547A2627ED00ADB9E4917")
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        addTaint(invalidate);
        addTaint(startDelay);
        final ScrollabilityCache scrollCache = mScrollCache;
    if(scrollCache == null || !scrollCache.fadeScrollBars)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1406054107 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040106448 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040106448;
        } //End block
    if(scrollCache.scrollBar == null)        
        {
            scrollCache.scrollBar = new ScrollBarDrawable();
        } //End block
    if(isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled())        
        {
    if(invalidate)            
            {
                invalidate(true);
            } //End block
    if(scrollCache.state == ScrollabilityCache.OFF)            
            {
                final int KEY_REPEAT_FIRST_DELAY = 750;
                startDelay = Math.max(KEY_REPEAT_FIRST_DELAY, startDelay);
            } //End block
            long fadeStartTime = AnimationUtils.currentAnimationTimeMillis() + startDelay;
            scrollCache.fadeStartTime = fadeStartTime;
            scrollCache.state = ScrollabilityCache.ON;
    if(mAttachInfo != null)            
            {
                mAttachInfo.mHandler.removeCallbacks(scrollCache);
                mAttachInfo.mHandler.postAtTime(scrollCache, fadeStartTime);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_256778038 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728649002 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728649002;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1878618694 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666512647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666512647;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.059 -0400", hash_original_method = "FC7DFAD8D0391FACDB1212D1D56F8C7D", hash_generated_method = "E6FDB5D653B0C025E97E7DEFD6D9297C")
    private boolean skipInvalidate() {
        boolean varDDDF73EE3C444927EB83EC838D07327D_848897637 = ((mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                (!(mParent instanceof ViewGroup) ||
                        !((ViewGroup) mParent).isViewTransitioning(this)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1232294008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1232294008;
        // ---------- Original Method ----------
        //return (mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                //(!(mParent instanceof ViewGroup) ||
                        //!((ViewGroup) mParent).isViewTransitioning(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.060 -0400", hash_original_method = "C9F4885B3240AC42BDB62659847A9804", hash_generated_method = "13BD9F68A64D712716C557858E70330F")
    public void invalidate(Rect dirty) {
        addTaint(dirty.getTaint());
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
    if(skipInvalidate())        
        {
            return;
        } //End block
    if((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
                (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID ||
                (mPrivateFlags & INVALIDATED) != INVALIDATED)        
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            final ViewParent p = mParent;
            final AttachInfo ai = mAttachInfo;
    if(!HardwareRenderer.RENDER_DIRTY_REGIONS)            
            {
    if(p != null && ai != null && ai.mHardwareAccelerated)                
                {
                    p.invalidateChild(this, null);
                    return;
                } //End block
            } //End block
    if(p != null && ai != null)            
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                final Rect r = ai.mTmpInvalRect;
                r.set(dirty.left - scrollX, dirty.top - scrollY,
                        dirty.right - scrollX, dirty.bottom - scrollY);
                mParent.invalidateChild(this, r);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.060 -0400", hash_original_method = "ADB8190FF1114977057C1857B6D8BC7D", hash_generated_method = "3AAB2D0DD67F7A61F494EF6AC6C07575")
    public void invalidate(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
    if(skipInvalidate())        
        {
            return;
        } //End block
    if((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
                (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID ||
                (mPrivateFlags & INVALIDATED) != INVALIDATED)        
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            final ViewParent p = mParent;
            final AttachInfo ai = mAttachInfo;
    if(!HardwareRenderer.RENDER_DIRTY_REGIONS)            
            {
    if(p != null && ai != null && ai.mHardwareAccelerated)                
                {
                    p.invalidateChild(this, null);
                    return;
                } //End block
            } //End block
    if(p != null && ai != null && l < r && t < b)            
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                final Rect tmpr = ai.mTmpInvalRect;
                tmpr.set(l - scrollX, t - scrollY, r - scrollX, b - scrollY);
                p.invalidateChild(this, tmpr);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.060 -0400", hash_original_method = "DD9880156AB041E4BB31F756D1AB2189", hash_generated_method = "BF85BB9D7AA11B7869ED1AB59ACA8EDC")
    public void invalidate() {
        invalidate(true);
        // ---------- Original Method ----------
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.061 -0400", hash_original_method = "2A2B8D7DA5636907090E85C40DC13DF0", hash_generated_method = "DBEE56037EF79D07DEF33BE1C1D13D35")
     void invalidate(boolean invalidateCache) {
        addTaint(invalidateCache);
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } //End block
    if(skipInvalidate())        
        {
            return;
        } //End block
    if((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
                (invalidateCache && (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID) ||
                (mPrivateFlags & INVALIDATED) != INVALIDATED || isOpaque() != mLastIsOpaque)        
        {
            mLastIsOpaque = isOpaque();
            mPrivateFlags &= ~DRAWN;
            mPrivateFlags |= DIRTY;
    if(invalidateCache)            
            {
                mPrivateFlags |= INVALIDATED;
                mPrivateFlags &= ~DRAWING_CACHE_VALID;
            } //End block
            final AttachInfo ai = mAttachInfo;
            final ViewParent p = mParent;
    if(!HardwareRenderer.RENDER_DIRTY_REGIONS)            
            {
    if(p != null && ai != null && ai.mHardwareAccelerated)                
                {
                    p.invalidateChild(this, null);
                    return;
                } //End block
            } //End block
    if(p != null && ai != null)            
            {
                final Rect r = ai.mTmpInvalRect;
                r.set(0, 0, mRight - mLeft, mBottom - mTop);
                p.invalidateChild(this, r);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.061 -0400", hash_original_method = "9E49D44B70542B7D202A00B58BCD901B", hash_generated_method = "8E55D7F3371258C405E30125D298F9B0")
    public void fastInvalidate() {
    if(skipInvalidate())        
        {
            return;
        } //End block
    if((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
            (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID ||
            (mPrivateFlags & INVALIDATED) != INVALIDATED)        
        {
    if(mParent instanceof View)            
            {
                ((View) mParent).mPrivateFlags |= INVALIDATED;
            } //End block
            mPrivateFlags &= ~DRAWN;
            mPrivateFlags |= DIRTY;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
    if(mParent != null && mAttachInfo != null)            
            {
    if(mAttachInfo.mHardwareAccelerated)                
                {
                    mParent.invalidateChild(this, null);
                } //End block
                else
                {
                    final Rect r = mAttachInfo.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    mParent.invalidateChild(this, r);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.061 -0400", hash_original_method = "74A87B1768814B24E7FEDDF99D8537F0", hash_generated_method = "4E0F9D909DA8D65D0F3B2D5C80DC5B2B")
    protected void invalidateParentCaches() {
    if(mParent instanceof View)        
        {
            ((View) mParent).mPrivateFlags |= INVALIDATED;
        } //End block
        // ---------- Original Method ----------
        //if (mParent instanceof View) {
            //((View) mParent).mPrivateFlags |= INVALIDATED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.061 -0400", hash_original_method = "A648B59C2EE20F29A9B99BF448851618", hash_generated_method = "C582C2A32E41D9D43198452EDF828D4E")
    protected void invalidateParentIfNeeded() {
    if(isHardwareAccelerated() && mParent instanceof View)        
        {
            ((View) mParent).invalidate(true);
        } //End block
        // ---------- Original Method ----------
        //if (isHardwareAccelerated() && mParent instanceof View) {
            //((View) mParent).invalidate(true);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.062 -0400", hash_original_method = "E9C24F17558159FB485FCFC13D70293E", hash_generated_method = "CD1CDD13D7ABF8099BE16AE086B0BA87")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isOpaque() {
        boolean var9C20F126E40E86C6D78A0D5DDA7996DE_1104536392 = ((mPrivateFlags & OPAQUE_MASK) == OPAQUE_MASK &&
                ((mTransformationInfo != null ? mTransformationInfo.mAlpha : 1)
                        >= 1.0f - ViewConfiguration.ALPHA_THRESHOLD));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648865551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648865551;
        // ---------- Original Method ----------
        //return (mPrivateFlags & OPAQUE_MASK) == OPAQUE_MASK &&
                //((mTransformationInfo != null ? mTransformationInfo.mAlpha : 1)
                        //>= 1.0f - ViewConfiguration.ALPHA_THRESHOLD);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.062 -0400", hash_original_method = "497EF7DE92B2945B2FEC8F46EAD33430", hash_generated_method = "36A1A295B84056BEC0D324C9AB6AF567")
    protected void computeOpaqueFlags() {
    if(mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE)        
        {
            mPrivateFlags |= OPAQUE_BACKGROUND;
        } //End block
        else
        {
            mPrivateFlags &= ~OPAQUE_BACKGROUND;
        } //End block
        final int flags = mViewFlags;
    if(((flags & SCROLLBARS_VERTICAL) == 0 && (flags & SCROLLBARS_HORIZONTAL) == 0) ||
                (flags & SCROLLBARS_STYLE_MASK) == SCROLLBARS_INSIDE_OVERLAY)        
        {
            mPrivateFlags |= OPAQUE_SCROLLBARS;
        } //End block
        else
        {
            mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE) {
            //mPrivateFlags |= OPAQUE_BACKGROUND;
        //} else {
            //mPrivateFlags &= ~OPAQUE_BACKGROUND;
        //}
        //final int flags = mViewFlags;
        //if (((flags & SCROLLBARS_VERTICAL) == 0 && (flags & SCROLLBARS_HORIZONTAL) == 0) ||
                //(flags & SCROLLBARS_STYLE_MASK) == SCROLLBARS_INSIDE_OVERLAY) {
            //mPrivateFlags |= OPAQUE_SCROLLBARS;
        //} else {
            //mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.062 -0400", hash_original_method = "7EE186D55064FCDB5B25DFE594562441", hash_generated_method = "EEAC8EE64CB605FFA0E9ABDC79BA7FD2")
    protected boolean hasOpaqueScrollbars() {
        boolean var920B63B93807AE53666D5A18B79486C6_183456807 = ((mPrivateFlags & OPAQUE_SCROLLBARS) == OPAQUE_SCROLLBARS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066569734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066569734;
        // ---------- Original Method ----------
        //return (mPrivateFlags & OPAQUE_SCROLLBARS) == OPAQUE_SCROLLBARS;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.072 -0400", hash_original_method = "DDF5EC42ADE793605447903B93381C32", hash_generated_method = "8CC7196509A363A016993118E011958F")
    public Handler getHandler() {
    if(mAttachInfo != null)        
        {
Handler var4A2890E2AB70D238DF8DD7E2799B7F98_968175831 =             mAttachInfo.mHandler;
            var4A2890E2AB70D238DF8DD7E2799B7F98_968175831.addTaint(taint);
            return var4A2890E2AB70D238DF8DD7E2799B7F98_968175831;
        } //End block
Handler var540C13E9E156B687226421B24F2DF178_1320644908 =         null;
        var540C13E9E156B687226421B24F2DF178_1320644908.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1320644908;
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mHandler;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.073 -0400", hash_original_method = "8EDFE6EE958B917F012E9131A0AEA287", hash_generated_method = "10C9AD628ECB276E6F75E989BA8ED666")
    public boolean post(Runnable action) {
        addTaint(action.getTaint());
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
    if(attachInfo != null)        
        {
            handler = attachInfo.mHandler;
        } //End block
        else
        {
            ViewRootImpl.getRunQueue().post(action);
            boolean varB326B5062B2F0E69046810717534CB09_610597230 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632017900 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632017900;
        } //End block
        boolean var5AFD7C5D7C42EC2BC1F5C09468DF29BF_194950179 = (handler.post(action));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064236605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064236605;
        // ---------- Original Method ----------
        //Handler handler;
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //handler = attachInfo.mHandler;
        //} else {
            //ViewRootImpl.getRunQueue().post(action);
            //return true;
        //}
        //return handler.post(action);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.073 -0400", hash_original_method = "D354828971EFD085BD14FC0D83048A19", hash_generated_method = "FFCC4B6F82BABE3AA9B6A0DF9B13A2B9")
    public boolean postDelayed(Runnable action, long delayMillis) {
        addTaint(delayMillis);
        addTaint(action.getTaint());
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
    if(attachInfo != null)        
        {
            handler = attachInfo.mHandler;
        } //End block
        else
        {
            ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
            boolean varB326B5062B2F0E69046810717534CB09_1191814093 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508153217 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508153217;
        } //End block
        boolean var767AB10EA9FB9471F598E30FB2741625_1067129760 = (handler.postDelayed(action, delayMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956100509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956100509;
        // ---------- Original Method ----------
        //Handler handler;
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //handler = attachInfo.mHandler;
        //} else {
            //ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
            //return true;
        //}
        //return handler.postDelayed(action, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.073 -0400", hash_original_method = "924A8BEE16A312E53AB8660A02DEF27E", hash_generated_method = "072ECB3AA25B4B88CE43DFB361EC109B")
    public boolean removeCallbacks(Runnable action) {
        addTaint(action.getTaint());
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
    if(attachInfo != null)        
        {
            handler = attachInfo.mHandler;
        } //End block
        else
        {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
            boolean varB326B5062B2F0E69046810717534CB09_1390718373 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632465379 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632465379;
        } //End block
        handler.removeCallbacks(action);
        boolean varB326B5062B2F0E69046810717534CB09_1920994546 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207407095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207407095;
        // ---------- Original Method ----------
        //Handler handler;
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //handler = attachInfo.mHandler;
        //} else {
            //ViewRootImpl.getRunQueue().removeCallbacks(action);
            //return true;
        //}
        //handler.removeCallbacks(action);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.073 -0400", hash_original_method = "B784E31CF9F406A65D385399252675E5", hash_generated_method = "E1CD8F02A4425412097D3886A78B39EF")
    public void postInvalidate() {
        postInvalidateDelayed(0);
        // ---------- Original Method ----------
        //postInvalidateDelayed(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.073 -0400", hash_original_method = "F30B35993A01DC68F672A7097988A2B2", hash_generated_method = "57679BD85BD8A55EEA0003B2497B7780")
    public void postInvalidate(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        postInvalidateDelayed(0, left, top, right, bottom);
        // ---------- Original Method ----------
        //postInvalidateDelayed(0, left, top, right, bottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.074 -0400", hash_original_method = "04635C950E88519FA950A99E2186B20C", hash_generated_method = "D6505A6E0E42A69E41C0C6BEAF4824FD")
    public void postInvalidateDelayed(long delayMilliseconds) {
        addTaint(delayMilliseconds);
        AttachInfo attachInfo = mAttachInfo;
    if(attachInfo != null)        
        {
            Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_MSG;
            msg.obj = this;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        } //End block
        // ---------- Original Method ----------
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //Message msg = Message.obtain();
            //msg.what = AttachInfo.INVALIDATE_MSG;
            //msg.obj = this;
            //attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.074 -0400", hash_original_method = "2AD5AD2CFDC403E5ADB3F0CF5F7AB2F6", hash_generated_method = "44F00C148C790C1CEF7D91F80C02F3F4")
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top,
            int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(delayMilliseconds);
        AttachInfo attachInfo = mAttachInfo;
    if(attachInfo != null)        
        {
            final AttachInfo.InvalidateInfo info = AttachInfo.InvalidateInfo.acquire();
            info.target = this;
            info.left = left;
            info.top = top;
            info.right = right;
            info.bottom = bottom;
            final Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_RECT_MSG;
            msg.obj = info;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        } //End block
        // ---------- Original Method ----------
        //AttachInfo attachInfo = mAttachInfo;
        //if (attachInfo != null) {
            //final AttachInfo.InvalidateInfo info = AttachInfo.InvalidateInfo.acquire();
            //info.target = this;
            //info.left = left;
            //info.top = top;
            //info.right = right;
            //info.bottom = bottom;
            //final Message msg = Message.obtain();
            //msg.what = AttachInfo.INVALIDATE_RECT_MSG;
            //msg.obj = info;
            //attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.074 -0400", hash_original_method = "BB237226F39DBA7BCAA624BDCB91F777", hash_generated_method = "1DFB1B66E888015E26D2C38C8942DEDD")
    private void postSendViewScrolledAccessibilityEventCallback() {
    if(mSendViewScrolledAccessibilityEvent == null)        
        {
            mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        } //End block
    if(!mSendViewScrolledAccessibilityEvent.mIsPending)        
        {
            mSendViewScrolledAccessibilityEvent.mIsPending = true;
            postDelayed(mSendViewScrolledAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        } //End block
        // ---------- Original Method ----------
        //if (mSendViewScrolledAccessibilityEvent == null) {
            //mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        //}
        //if (!mSendViewScrolledAccessibilityEvent.mIsPending) {
            //mSendViewScrolledAccessibilityEvent.mIsPending = true;
            //postDelayed(mSendViewScrolledAccessibilityEvent,
                    //ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.074 -0400", hash_original_method = "7821AAE99E52242CE62352C839CCDCC3", hash_generated_method = "DC60F051596188244856202A1C5C2CDD")
    public void computeScroll() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.074 -0400", hash_original_method = "2F1443E103CAC5C1C2808AA2ECBBD417", hash_generated_method = "86F22DCC594C51F71572BC8533468BEF")
    public boolean isHorizontalFadingEdgeEnabled() {
        boolean var32AF06C508D4B36D23F12E24D9D56687_81947176 = ((mViewFlags & FADING_EDGE_HORIZONTAL) == FADING_EDGE_HORIZONTAL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017990242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017990242;
        // ---------- Original Method ----------
        //return (mViewFlags & FADING_EDGE_HORIZONTAL) == FADING_EDGE_HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.075 -0400", hash_original_method = "EC0EB62D805892CAAD99FC80B5C4BCFE", hash_generated_method = "E9F2A92473BB818C025A9B0ED736338E")
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        addTaint(horizontalFadingEdgeEnabled);
    if(isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled)        
        {
    if(horizontalFadingEdgeEnabled)            
            {
                initScrollCache();
            } //End block
            mViewFlags ^= FADING_EDGE_HORIZONTAL;
        } //End block
        // ---------- Original Method ----------
        //if (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled) {
            //if (horizontalFadingEdgeEnabled) {
                //initScrollCache();
            //}
            //mViewFlags ^= FADING_EDGE_HORIZONTAL;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.075 -0400", hash_original_method = "DC4B7092961F5604BD589F14B65154AC", hash_generated_method = "066B6EDB6C383B6BE3BE7436C01B5506")
    public boolean isVerticalFadingEdgeEnabled() {
        boolean varB46C541D87575C801C81E235B4D9A6D1_200927262 = ((mViewFlags & FADING_EDGE_VERTICAL) == FADING_EDGE_VERTICAL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1223416417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1223416417;
        // ---------- Original Method ----------
        //return (mViewFlags & FADING_EDGE_VERTICAL) == FADING_EDGE_VERTICAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.075 -0400", hash_original_method = "EAF2758FE6F0D2FA48FD42C13EB7A789", hash_generated_method = "8D677E12C5C29D70E80E3BFECA5EE296")
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        addTaint(verticalFadingEdgeEnabled);
    if(isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled)        
        {
    if(verticalFadingEdgeEnabled)            
            {
                initScrollCache();
            } //End block
            mViewFlags ^= FADING_EDGE_VERTICAL;
        } //End block
        // ---------- Original Method ----------
        //if (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled) {
            //if (verticalFadingEdgeEnabled) {
                //initScrollCache();
            //}
            //mViewFlags ^= FADING_EDGE_VERTICAL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.075 -0400", hash_original_method = "CA0383E2F77249B4067FF4C25AA980FC", hash_generated_method = "C7785CDA057B9F39551C41C9F60AC79C")
    protected float getTopFadingEdgeStrength() {
        float var0B3303EE55B88EC3FDD3900390335233_1599957589 = (computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1175281607 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1175281607;
        // ---------- Original Method ----------
        //return computeVerticalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.075 -0400", hash_original_method = "DD443087D4013745234D8B8402D9412B", hash_generated_method = "0D39294B51B18B07A65230C2DB20718B")
    protected float getBottomFadingEdgeStrength() {
        float var7086462D2DFFE74AA0E4F054BE3B3F37_824088974 = (computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                computeVerticalScrollRange() ? 1.0f : 0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1566734022 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1566734022;
        // ---------- Original Method ----------
        //return computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                //computeVerticalScrollRange() ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "7D1377787749722D9D47682EF553F1ED", hash_generated_method = "822F5F89897E7A4FB6DF2500B12924DF")
    protected float getLeftFadingEdgeStrength() {
        float var6930CEAEE108328F02DD4F671517C4C6_1424556092 = (computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1261388486 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1261388486;
        // ---------- Original Method ----------
        //return computeHorizontalScrollOffset() > 0 ? 1.0f : 0.0f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "1558452CB016696B11D09745F34240BE", hash_generated_method = "665DF0B3C9E5EF081E4BED96EE453037")
    protected float getRightFadingEdgeStrength() {
        float var8E2FE3DDD4209CA4A3D6BC8EDDE893F0_244603196 = (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                computeHorizontalScrollRange() ? 1.0f : 0.0f);
                float var546ADE640B6EDFBC8A086EF31347E768_1902051029 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1902051029;
        // ---------- Original Method ----------
        //return computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                //computeHorizontalScrollRange() ? 1.0f : 0.0f;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "4C9FBABF966493498122F359EE4D62B4", hash_generated_method = "0FDB6D0948399DAD12E7022911314A97")
    public boolean isHorizontalScrollBarEnabled() {
        boolean var404D2891CD28E4464AA46D518B293C44_1212442722 = ((mViewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858597923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858597923;
        // ---------- Original Method ----------
        //return (mViewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "5F4F07B15655223ADE33A1CCE75F1A0B", hash_generated_method = "B03D65C6D676E60B94CDF0D3FD18E4B2")
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        addTaint(horizontalScrollBarEnabled);
    if(isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled)        
        {
            mViewFlags ^= SCROLLBARS_HORIZONTAL;
            computeOpaqueFlags();
            resolvePadding();
        } //End block
        // ---------- Original Method ----------
        //if (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled) {
            //mViewFlags ^= SCROLLBARS_HORIZONTAL;
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "0838EB3187C4C037AF0DBFBDE06C59DB", hash_generated_method = "D43B2F7DF87E0C5742D63BA0CBA83676")
    public boolean isVerticalScrollBarEnabled() {
        boolean var1F4E4073A9C4C1519FB7548711BE3183_1969839327 = ((mViewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1332770272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1332770272;
        // ---------- Original Method ----------
        //return (mViewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "B0D859209D4F0DED05F4B405F254CC50", hash_generated_method = "C0B3FFD567C0A29BD6B3AE4CAE63FE2C")
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        addTaint(verticalScrollBarEnabled);
    if(isVerticalScrollBarEnabled() != verticalScrollBarEnabled)        
        {
            mViewFlags ^= SCROLLBARS_VERTICAL;
            computeOpaqueFlags();
            resolvePadding();
        } //End block
        // ---------- Original Method ----------
        //if (isVerticalScrollBarEnabled() != verticalScrollBarEnabled) {
            //mViewFlags ^= SCROLLBARS_VERTICAL;
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.076 -0400", hash_original_method = "DC71A98728014C366336C5BC467178FD", hash_generated_method = "796EA4F4D2AC58DE61356F54ACDA4918")
    protected void recomputePadding() {
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
        // ---------- Original Method ----------
        //setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.077 -0400", hash_original_method = "2388F31C9368DE1EC14347F689733603", hash_generated_method = "80AA66919F50C563D41504A8F7C5407C")
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        addTaint(fadeScrollbars);
        initScrollCache();
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
    if(fadeScrollbars)        
        {
            scrollabilityCache.state = ScrollabilityCache.OFF;
        } //End block
        else
        {
            scrollabilityCache.state = ScrollabilityCache.ON;
        } //End block
        // ---------- Original Method ----------
        //initScrollCache();
        //final ScrollabilityCache scrollabilityCache = mScrollCache;
        //scrollabilityCache.fadeScrollBars = fadeScrollbars;
        //if (fadeScrollbars) {
            //scrollabilityCache.state = ScrollabilityCache.OFF;
        //} else {
            //scrollabilityCache.state = ScrollabilityCache.ON;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.077 -0400", hash_original_method = "95A2058DEEA36EE0618643627EDFFE13", hash_generated_method = "8F1E11986CF9B165112397261A3E00B4")
    public boolean isScrollbarFadingEnabled() {
        boolean var3FB093C35E1AB080E8B36212229766A8_1967964361 = (mScrollCache != null && mScrollCache.fadeScrollBars);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_540914245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_540914245;
        // ---------- Original Method ----------
        //return mScrollCache != null && mScrollCache.fadeScrollBars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.077 -0400", hash_original_method = "A645B31717E594F6C2DC0D0454AA457D", hash_generated_method = "1AB94F9F08EF48015383A311D37ABE9D")
    public void setScrollBarStyle(int style) {
    if(style != (mViewFlags & SCROLLBARS_STYLE_MASK))        
        {
            mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            computeOpaqueFlags();
            resolvePadding();
        } //End block
        // ---------- Original Method ----------
        //if (style != (mViewFlags & SCROLLBARS_STYLE_MASK)) {
            //mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            //computeOpaqueFlags();
            //resolvePadding();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.077 -0400", hash_original_method = "05D4731F6FA79F6CC5101E8AAB13BDF7", hash_generated_method = "B8F315016F92551819F2AD023F62B97E")
    @ViewDebug.ExportedProperty(mapping = {
            @ViewDebug.IntToString(from = SCROLLBARS_INSIDE_OVERLAY, to = "INSIDE_OVERLAY"),
            @ViewDebug.IntToString(from = SCROLLBARS_INSIDE_INSET, to = "INSIDE_INSET"),
            @ViewDebug.IntToString(from = SCROLLBARS_OUTSIDE_OVERLAY, to = "OUTSIDE_OVERLAY"),
            @ViewDebug.IntToString(from = SCROLLBARS_OUTSIDE_INSET, to = "OUTSIDE_INSET")
    })
    public int getScrollBarStyle() {
        int var19DC7CDBAD16374FEFC4BA354B7618AB_1679098065 = (mViewFlags & SCROLLBARS_STYLE_MASK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230793084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230793084;
        // ---------- Original Method ----------
        //return mViewFlags & SCROLLBARS_STYLE_MASK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.078 -0400", hash_original_method = "70416A9E9D98F77424E9346E007FCC75", hash_generated_method = "9B7B45ED5B828FE694DFD7DAE6C9FB56")
    protected int computeHorizontalScrollRange() {
        int var36131DBB2E2F5BCF2181A419796EF343_1063025966 = (getWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602351694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1602351694;
        // ---------- Original Method ----------
        //return getWidth();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.078 -0400", hash_original_method = "1DA5A8790403B0D1F6BBC5796ED90152", hash_generated_method = "ED8373C4BD95408AA67E9D22943F8F36")
    protected int computeHorizontalScrollOffset() {
        int var9DC8F9676E14E93147EBEA37CE364B55_1246434242 = (mScrollX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260489218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260489218;
        // ---------- Original Method ----------
        //return mScrollX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.078 -0400", hash_original_method = "4D7C9CACEB957F5429D7FE01BD0E831F", hash_generated_method = "359F1E3132FA2AB337DEEA24B339F2AA")
    protected int computeHorizontalScrollExtent() {
        int var36131DBB2E2F5BCF2181A419796EF343_260258469 = (getWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099824950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099824950;
        // ---------- Original Method ----------
        //return getWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.079 -0400", hash_original_method = "BA8A199276036F5D8FAFD83598D6B62F", hash_generated_method = "95F9F749CB6E83799E93F91715E0A0B4")
    protected int computeVerticalScrollRange() {
        int varFD74B49932649290EF5C4EBB018490D1_391597793 = (getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137598227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137598227;
        // ---------- Original Method ----------
        //return getHeight();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.079 -0400", hash_original_method = "CE20178D0022D78BDA31343037F660C9", hash_generated_method = "019D188B9C888CBEBFCA98BB919A50DF")
    protected int computeVerticalScrollOffset() {
        int var4ABBFD585ECE4FE40BECD8E0C30C4E5E_677216844 = (mScrollY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906528084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_906528084;
        // ---------- Original Method ----------
        //return mScrollY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.079 -0400", hash_original_method = "3058943AF0E0D63E8ED42ACDC59A7606", hash_generated_method = "85214896979420BAD5AF14544095E9F6")
    protected int computeVerticalScrollExtent() {
        int varFD74B49932649290EF5C4EBB018490D1_248305215 = (getHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931946339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931946339;
        // ---------- Original Method ----------
        //return getHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.079 -0400", hash_original_method = "F18C2F0ACE32F9BDC531C26946C884DB", hash_generated_method = "2577F47E0F08BCB077DAC4371E30EBF5")
    public boolean canScrollHorizontally(int direction) {
        addTaint(direction);
        final int offset = computeHorizontalScrollOffset();
        final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
    if(range == 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1976967486 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_557578517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_557578517;
        }
    if(direction < 0)        
        {
            boolean var96CB4766E83AB23B26DB93A876808144_1910873683 = (offset > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_38872165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_38872165;
        } //End block
        else
        {
            boolean var22E978682E112D307C008488D4F3ADA0_1231052615 = (offset < range - 1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034073941 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034073941;
        } //End block
        // ---------- Original Method ----------
        //final int offset = computeHorizontalScrollOffset();
        //final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        //if (range == 0) return false;
        //if (direction < 0) {
            //return offset > 0;
        //} else {
            //return offset < range - 1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.079 -0400", hash_original_method = "222CDEC9A5062ECAF96BF1766D04B3AA", hash_generated_method = "A0EC4B365A2961BFE1E17038DFCD25BE")
    public boolean canScrollVertically(int direction) {
        addTaint(direction);
        final int offset = computeVerticalScrollOffset();
        final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
    if(range == 0)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1440600332 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_889009890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_889009890;
        }
    if(direction < 0)        
        {
            boolean var96CB4766E83AB23B26DB93A876808144_257403716 = (offset > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779216481 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779216481;
        } //End block
        else
        {
            boolean var22E978682E112D307C008488D4F3ADA0_719663114 = (offset < range - 1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856898023 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_856898023;
        } //End block
        // ---------- Original Method ----------
        //final int offset = computeVerticalScrollOffset();
        //final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        //if (range == 0) return false;
        //if (direction < 0) {
            //return offset > 0;
        //} else {
            //return offset < range - 1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.082 -0400", hash_original_method = "BC6A073022E6E75A0ACBB97281459E6B", hash_generated_method = "ABE24D921D5BAE588FBAB6AEE70D35A3")
    protected final void onDrawScrollBars(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        final ScrollabilityCache cache = mScrollCache;
    if(cache != null)        
        {
            int state = cache.state;
    if(state == ScrollabilityCache.OFF)            
            {
                return;
            } //End block
            boolean invalidate = false;
    if(state == ScrollabilityCache.FADING)            
            {
    if(cache.interpolatorValues == null)                
                {
                    cache.interpolatorValues = new float[1];
                } //End block
                float[] values = cache.interpolatorValues;
    if(cache.scrollBarInterpolator.timeToValues(values) ==
                        Interpolator.Result.FREEZE_END)                
                {
                    cache.state = ScrollabilityCache.OFF;
                } //End block
                else
                {
                    cache.scrollBar.setAlpha(Math.round(values[0]));
                } //End block
                invalidate = true;
            } //End block
            else
            {
                cache.scrollBar.setAlpha(255);
            } //End block
            final int viewFlags = mViewFlags;
            final boolean drawHorizontalScrollBar = (viewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
            final boolean drawVerticalScrollBar = (viewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL
                && !isVerticalScrollBarHidden();
    if(drawVerticalScrollBar || drawHorizontalScrollBar)            
            {
                final int width = mRight - mLeft;
                final int height = mBottom - mTop;
                final ScrollBarDrawable scrollBar = cache.scrollBar;
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                final int inside = (viewFlags & SCROLLBARS_OUTSIDE_MASK) == 0 ? ~0 : 0;
                int left;
                int top;
                int right;
                int bottom;
    if(drawHorizontalScrollBar)                
                {
                    int size = scrollBar.getSize(false);
    if(size <= 0)                    
                    {
                        size = cache.scrollBarSize;
                    } //End block
                    scrollBar.setParameters(computeHorizontalScrollRange(),
                                            computeHorizontalScrollOffset(),
                                            computeHorizontalScrollExtent(), false);
                    final int verticalScrollBarGap = drawVerticalScrollBar ?
                            getVerticalScrollbarWidth() : 0;
                    top = scrollY + height - size - (mUserPaddingBottom & inside);
                    left = scrollX + (mPaddingLeft & inside);
                    right = scrollX + width - (mUserPaddingRight & inside) - verticalScrollBarGap;
                    bottom = top + size;
                    onDrawHorizontalScrollBar(canvas, scrollBar, left, top, right, bottom);
    if(invalidate)                    
                    {
                        invalidate(left, top, right, bottom);
                    } //End block
                } //End block
    if(drawVerticalScrollBar)                
                {
                    int size = scrollBar.getSize(true);
    if(size <= 0)                    
                    {
                        size = cache.scrollBarSize;
                    } //End block
                    scrollBar.setParameters(computeVerticalScrollRange(),
                                            computeVerticalScrollOffset(),
                                            computeVerticalScrollExtent(), true);
switch(mVerticalScrollbarPosition){
                    default:
                    case SCROLLBAR_POSITION_DEFAULT:
                    case SCROLLBAR_POSITION_RIGHT:
                    left = scrollX + width - size - (mUserPaddingRight & inside);
                    break;
                    case SCROLLBAR_POSITION_LEFT:
                    left = scrollX + (mUserPaddingLeft & inside);
                    break;
}                    top = scrollY + (mPaddingTop & inside);
                    right = left + size;
                    bottom = scrollY + height - (mUserPaddingBottom & inside);
                    onDrawVerticalScrollBar(canvas, scrollBar, left, top, right, bottom);
    if(invalidate)                    
                    {
                        invalidate(left, top, right, bottom);
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.083 -0400", hash_original_method = "27496C077301642151620030AE06D353", hash_generated_method = "062538D2D569EC2801973E1BAE578B7E")
    protected boolean isVerticalScrollBarHidden() {
        boolean var68934A3E9455FA72420237EB05902327_315659187 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468213928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468213928;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.084 -0400", hash_original_method = "2196C3E195A3664813647CA1F4571C34", hash_generated_method = "67FA595BE083B89D9B29C2ED417FD6DE")
    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(scrollBar.getTaint());
        addTaint(canvas.getTaint());
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
        // ---------- Original Method ----------
        //scrollBar.setBounds(l, t, r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.084 -0400", hash_original_method = "4DC59479DF5AED0094F453B5C8C1A8B1", hash_generated_method = "3BAF2B4329D2D7DAA12C797ABF452066")
    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(scrollBar.getTaint());
        addTaint(canvas.getTaint());
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
        // ---------- Original Method ----------
        //scrollBar.setBounds(l, t, r, b);
        //scrollBar.draw(canvas);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.084 -0400", hash_original_method = "88C9EEC1EB66ECE8EDFB3E744FAAD32C", hash_generated_method = "8DE2AC8CD08D4DCB5B0CCD9E40E1637E")
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.085 -0400", hash_original_method = "B5B7B4C6E477A3DDB1740C53E1D10BEA", hash_generated_method = "405C87FE342DE3C5982F1CB3F2F08B5C")
     void assignParent(ViewParent parent) {
    if(mParent == null)        
        {
            mParent = parent;
        } //End block
        else
    if(parent == null)        
        {
            mParent = null;
        } //End block
        else
        {
            RuntimeException var0C6EF10E525860D156A778BAD8446231_449359624 = new RuntimeException("view " + this + " being added, but"
                    + " it already has a parent");
            var0C6EF10E525860D156A778BAD8446231_449359624.addTaint(taint);
            throw var0C6EF10E525860D156A778BAD8446231_449359624;
        } //End block
        // ---------- Original Method ----------
        //if (mParent == null) {
            //mParent = parent;
        //} else if (parent == null) {
            //mParent = null;
        //} else {
            //throw new RuntimeException("view " + this + " being added, but"
                    //+ " it already has a parent");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.085 -0400", hash_original_method = "6BE89DDC01776115240A35D213D194B1", hash_generated_method = "D271D71E0ADD3306065265FD93D60A9F")
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if((mPrivateFlags & REQUEST_TRANSPARENT_REGIONS) != 0)        
        {
            mParent.requestTransparentRegion(this);
        } //End block
    if((mPrivateFlags & AWAKEN_SCROLL_BARS_ON_ATTACH) != 0)        
        {
            initialAwakenScrollBars();
            mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        } //End block
        jumpDrawablesToCurrentState();
        resolveLayoutDirectionIfNeeded();
        resolvePadding();
        resolveTextDirection();
    if(isFocused())        
        {
            InputMethodManager imm = InputMethodManager.peekInstance();
            imm.focusIn(this);
        } //End block
        // ---------- Original Method ----------
        //if ((mPrivateFlags & REQUEST_TRANSPARENT_REGIONS) != 0) {
            //mParent.requestTransparentRegion(this);
        //}
        //if ((mPrivateFlags & AWAKEN_SCROLL_BARS_ON_ATTACH) != 0) {
            //initialAwakenScrollBars();
            //mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        //}
        //jumpDrawablesToCurrentState();
        //resolveLayoutDirectionIfNeeded();
        //resolvePadding();
        //resolveTextDirection();
        //if (isFocused()) {
            //InputMethodManager imm = InputMethodManager.peekInstance();
            //imm.focusIn(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.086 -0400", hash_original_method = "6355C1E1C593C70CD9AB72CB2C730A4B", hash_generated_method = "2A05A2B36FE209EE3EB8D2017801510C")
    private void resolveLayoutDirectionIfNeeded() {
    if((mPrivateFlags2 & LAYOUT_DIRECTION_RESOLVED) == LAYOUT_DIRECTION_RESOLVED)        
        return;
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED_RTL;
        resetResolvedTextDirection();
switch(getLayoutDirection()){
        case LAYOUT_DIRECTION_INHERIT:
    if(mParent == null)        
        return;
    if(mParent instanceof ViewGroup)        
        {
            ViewGroup viewGroup = ((ViewGroup) mParent);
    if(! viewGroup.canResolveLayoutDirection())            
            {
                return;
            } //End block
    if(viewGroup.getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL)            
            {
                mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
            } //End block
        } //End block
        break;
        case LAYOUT_DIRECTION_RTL:
        mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
        break;
        case LAYOUT_DIRECTION_LOCALE:
    if(isLayoutDirectionRtl(Locale.getDefault()))        
        {
            mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
        } //End block
        break;
        default:
}        mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.088 -0400", hash_original_method = "9FC12AEA6DFF38CE52A88C8E970B863F", hash_generated_method = "92137E35AF0173EF60952F5344965B60")
    protected void resolvePadding() {
switch(getResolvedLayoutDirection()){
        case LAYOUT_DIRECTION_RTL:
    if(mUserPaddingStart >= 0)        
        {
            mUserPaddingRight = mUserPaddingStart;
        } //End block
        else
    if(mUserPaddingRight < 0)        
        {
            mUserPaddingRight = mPaddingRight;
        } //End block
    if(mUserPaddingEnd >= 0)        
        {
            mUserPaddingLeft = mUserPaddingEnd;
        } //End block
        else
    if(mUserPaddingLeft < 0)        
        {
            mUserPaddingLeft = mPaddingLeft;
        } //End block
        break;
        case LAYOUT_DIRECTION_LTR:
        default:
    if(mUserPaddingStart >= 0)        
        {
            mUserPaddingLeft = mUserPaddingStart;
        } //End block
        else
    if(mUserPaddingLeft < 0)        
        {
            mUserPaddingLeft = mPaddingLeft;
        } //End block
    if(mUserPaddingEnd >= 0)        
        {
            mUserPaddingRight = mUserPaddingEnd;
        } //End block
        else
    if(mUserPaddingRight < 0)        
        {
            mUserPaddingRight = mPaddingRight;
        } //End block
}        mUserPaddingBottom = (mUserPaddingBottom >= 0) ? mUserPaddingBottom : mPaddingBottom;
        recomputePadding();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.089 -0400", hash_original_method = "2870C28D9742C58342A5849284011E72", hash_generated_method = "53D089C16A2B0EC8E8624E142297ED38")
    protected boolean canResolveLayoutDirection() {
switch(getLayoutDirection()){
        case LAYOUT_DIRECTION_INHERIT:
        boolean var6B3245D6F57329139C12126AFC403C69_108328696 = ((mParent != null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1407889128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1407889128;
        default:
        boolean varB326B5062B2F0E69046810717534CB09_1178763070 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144423112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144423112;
}
        // ---------- Original Method ----------
        //switch (getLayoutDirection()) {
            //case LAYOUT_DIRECTION_INHERIT:
                //return (mParent != null);
            //default:
                //return true;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.089 -0400", hash_original_method = "A8A20BDA6F309AE6FE3C70FD4EB76C3B", hash_generated_method = "146E092F23602F5144B45F38ADE2CB14")
    protected void resetResolvedLayoutDirection() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
        // ---------- Original Method ----------
        //mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
    }

    
        protected static boolean isLayoutDirectionRtl(Locale locale) {
        return (LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE ==
                LocaleUtil.getLayoutDirectionFromLocale(locale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.092 -0400", hash_original_method = "C1067653123E460806048F14F4245D8D", hash_generated_method = "6D45753A53DBAD9858DA7CCBB93A4FEE")
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        destroyDrawingCache();
        destroyLayer();
    if(mDisplayList != null)        
        {
            mDisplayList.invalidate();
        } //End block
    if(mAttachInfo != null)        
        {
            mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        } //End block
        mCurrentAnimation = null;
        resetResolvedLayoutDirection();
        resetResolvedTextDirection();
        // ---------- Original Method ----------
        //mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        //removeUnsetPressCallback();
        //removeLongPressCallback();
        //removePerformClickCallback();
        //removeSendViewScrolledAccessibilityEventCallback();
        //destroyDrawingCache();
        //destroyLayer();
        //if (mDisplayList != null) {
            //mDisplayList.invalidate();
        //}
        //if (mAttachInfo != null) {
            //mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        //}
        //mCurrentAnimation = null;
        //resetResolvedLayoutDirection();
        //resetResolvedTextDirection();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.092 -0400", hash_original_method = "96241ADC2AE65F6434F9D187AAD690E3", hash_generated_method = "F7DB7DDCF78899AFCA1D39B65D036C43")
    protected int getWindowAttachCount() {
        int varB4EADC228928954D156338C2784E8E5E_1109934314 = (mWindowAttachCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721802063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_721802063;
        // ---------- Original Method ----------
        //return mWindowAttachCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.092 -0400", hash_original_method = "B5E940E178CF821C1ABFCBA8A2963390", hash_generated_method = "9A764E3038F88B3C530C3B1DA7F46C8A")
    public IBinder getWindowToken() {
IBinder var34A641CF4772D7093E711326787DD0D2_1346589728 =         mAttachInfo != null ? mAttachInfo.mWindowToken : null;
        var34A641CF4772D7093E711326787DD0D2_1346589728.addTaint(taint);
        return var34A641CF4772D7093E711326787DD0D2_1346589728;
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mWindowToken : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.093 -0400", hash_original_method = "2166F0BF16D53373B488A496114897F8", hash_generated_method = "B9A8305F4E2AD05F89901B97B285432C")
    public IBinder getApplicationWindowToken() {
        AttachInfo ai = mAttachInfo;
    if(ai != null)        
        {
            IBinder appWindowToken = ai.mPanelParentWindowToken;
    if(appWindowToken == null)            
            {
                appWindowToken = ai.mWindowToken;
            } //End block
IBinder var1D66150F5786DDDDF49BF221D94613C3_811381439 =             appWindowToken;
            var1D66150F5786DDDDF49BF221D94613C3_811381439.addTaint(taint);
            return var1D66150F5786DDDDF49BF221D94613C3_811381439;
        } //End block
IBinder var540C13E9E156B687226421B24F2DF178_305112820 =         null;
        var540C13E9E156B687226421B24F2DF178_305112820.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_305112820;
        // ---------- Original Method ----------
        //AttachInfo ai = mAttachInfo;
        //if (ai != null) {
            //IBinder appWindowToken = ai.mPanelParentWindowToken;
            //if (appWindowToken == null) {
                //appWindowToken = ai.mWindowToken;
            //}
            //return appWindowToken;
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.093 -0400", hash_original_method = "502E0CC6497F900AADF2990690A51539", hash_generated_method = "9BA476AF3BD8E52A6090C6B666FA26F0")
     IWindowSession getWindowSession() {
IWindowSession varD52F925EA2097B43F6DE6F228DA1FAF2_681773291 =         mAttachInfo != null ? mAttachInfo.mSession : null;
        varD52F925EA2097B43F6DE6F228DA1FAF2_681773291.addTaint(taint);
        return varD52F925EA2097B43F6DE6F228DA1FAF2_681773291;
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mSession : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.094 -0400", hash_original_method = "8BF487FADEB8B54B52A076F5E8F3B4CC", hash_generated_method = "3C5AF52CB6602367B02D5BA90D9E5B8E")
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        addTaint(visibility);
        mAttachInfo = info;
        mWindowAttachCount++;
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
    if(mFloatingTreeObserver != null)        
        {
            info.mTreeObserver.merge(mFloatingTreeObserver);
            mFloatingTreeObserver = null;
        } //End block
    if((mPrivateFlags&SCROLL_CONTAINER) != 0)        
        {
            mAttachInfo.mScrollContainers.add(this);
            mPrivateFlags |= SCROLL_CONTAINER_ADDED;
        } //End block
        performCollectViewAttributes(visibility);
        onAttachedToWindow();
        ListenerInfo li = mListenerInfo;
        final CopyOnWriteArrayList<OnAttachStateChangeListener> listeners = li != null ? li.mOnAttachStateChangeListeners : null;
    if(listeners != null && listeners.size() > 0)        
        {
for(OnAttachStateChangeListener listener : listeners)
            {
                listener.onViewAttachedToWindow(this);
            } //End block
        } //End block
        int vis = info.mWindowVisibility;
    if(vis != GONE)        
        {
            onWindowVisibilityChanged(vis);
        } //End block
    if((mPrivateFlags&DRAWABLE_STATE_DIRTY) != 0)        
        {
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.094 -0400", hash_original_method = "6B0EA8A7D63E280C74DFE6EC34A7421B", hash_generated_method = "11A322A96F78C6EAC5F696294BD41521")
     void dispatchDetachedFromWindow() {
        AttachInfo info = mAttachInfo;
    if(info != null)        
        {
            int vis = info.mWindowVisibility;
    if(vis != GONE)            
            {
                onWindowVisibilityChanged(GONE);
            } //End block
        } //End block
        onDetachedFromWindow();
        ListenerInfo li = mListenerInfo;
        final CopyOnWriteArrayList<OnAttachStateChangeListener> listeners = li != null ? li.mOnAttachStateChangeListeners : null;
    if(listeners != null && listeners.size() > 0)        
        {
for(OnAttachStateChangeListener listener : listeners)
            {
                listener.onViewDetachedFromWindow(this);
            } //End block
        } //End block
    if((mPrivateFlags & SCROLL_CONTAINER_ADDED) != 0)        
        {
            mAttachInfo.mScrollContainers.remove(this);
            mPrivateFlags &= ~SCROLL_CONTAINER_ADDED;
        } //End block
        mAttachInfo = null;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.094 -0400", hash_original_method = "DE35B85EA98822B631F87F0518C5E70D", hash_generated_method = "E6BB3630B0F09EA22E8A13E09982E966")
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.095 -0400", hash_original_method = "946C013753556BBC605C0B72B86403CC", hash_generated_method = "20F888640970530DF5FE8472D8109D2D")
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
    if(mID != NO_ID && (mViewFlags & SAVE_DISABLED_MASK) == 0)        
        {
            mPrivateFlags &= ~SAVE_STATE_CALLED;
            Parcelable state = onSaveInstanceState();
    if((mPrivateFlags & SAVE_STATE_CALLED) == 0)            
            {
                IllegalStateException var3AC6518B2E70CB86B09E15593A1F4FC9_1380537236 = new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
                var3AC6518B2E70CB86B09E15593A1F4FC9_1380537236.addTaint(taint);
                throw var3AC6518B2E70CB86B09E15593A1F4FC9_1380537236;
            } //End block
    if(state != null)            
            {
                container.put(mID, state);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mID != NO_ID && (mViewFlags & SAVE_DISABLED_MASK) == 0) {
            //mPrivateFlags &= ~SAVE_STATE_CALLED;
            //Parcelable state = onSaveInstanceState();
            //if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                //throw new IllegalStateException(
                        //"Derived class did not call super.onSaveInstanceState()");
            //}
            //if (state != null) {
                //container.put(mID, state);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.098 -0400", hash_original_method = "071A0CD98D5CB5717BF4FD06D9363A03", hash_generated_method = "4A57ADF638B0B9268AC958AE259FC023")
    protected Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags |= SAVE_STATE_CALLED;
Parcelable var811282300C831A28E3AEFC5EE2A36FB6_2014288256 =         BaseSavedState.EMPTY_STATE;
        var811282300C831A28E3AEFC5EE2A36FB6_2014288256.addTaint(taint);
        return var811282300C831A28E3AEFC5EE2A36FB6_2014288256;
        // ---------- Original Method ----------
        //mPrivateFlags |= SAVE_STATE_CALLED;
        //return BaseSavedState.EMPTY_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.098 -0400", hash_original_method = "6EAC0E9F5E844401043B6CA1D363D57E", hash_generated_method = "027EB6B5C363383BD8918B24DA2757BF")
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.098 -0400", hash_original_method = "1E9589C1E01E87FD9C38DCF9C7B7C90F", hash_generated_method = "4F4C23647CFBCC41FC328055EC6D165C")
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
    if(mID != NO_ID)        
        {
            Parcelable state = container.get(mID);
    if(state != null)            
            {
                mPrivateFlags &= ~SAVE_STATE_CALLED;
                onRestoreInstanceState(state);
    if((mPrivateFlags & SAVE_STATE_CALLED) == 0)                
                {
                    IllegalStateException var041490C7009C0A495ADBC57E4BE325FC_974799647 = new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                    var041490C7009C0A495ADBC57E4BE325FC_974799647.addTaint(taint);
                    throw var041490C7009C0A495ADBC57E4BE325FC_974799647;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mID != NO_ID) {
            //Parcelable state = container.get(mID);
            //if (state != null) {
                //mPrivateFlags &= ~SAVE_STATE_CALLED;
                //onRestoreInstanceState(state);
                //if ((mPrivateFlags & SAVE_STATE_CALLED) == 0) {
                    //throw new IllegalStateException(
                            //"Derived class did not call super.onRestoreInstanceState()");
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.098 -0400", hash_original_method = "CCFCBEB3529A8F3F9E941DB1236D802B", hash_generated_method = "A854FDC091E1DB71A58485B38EF3B5A3")
    protected void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        mPrivateFlags |= SAVE_STATE_CALLED;
    if(state != BaseSavedState.EMPTY_STATE && state != null)        
        {
            IllegalArgumentException var87E770CC55727F96A45561C377B89420_1925939944 = new IllegalArgumentException("Wrong state class, expecting View State but "
                    + "received " + state.getClass().toString() + " instead. This usually happens "
                    + "when two views of different type have the same id in the same hierarchy. "
                    + "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    + "other views do not use the same id.");
            var87E770CC55727F96A45561C377B89420_1925939944.addTaint(taint);
            throw var87E770CC55727F96A45561C377B89420_1925939944;
        } //End block
        // ---------- Original Method ----------
        //mPrivateFlags |= SAVE_STATE_CALLED;
        //if (state != BaseSavedState.EMPTY_STATE && state != null) {
            //throw new IllegalArgumentException("Wrong state class, expecting View State but "
                    //+ "received " + state.getClass().toString() + " instead. This usually happens "
                    //+ "when two views of different type have the same id in the same hierarchy. "
                    //+ "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    //+ "other views do not use the same id.");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.098 -0400", hash_original_method = "120BB71A812D687D5EF2F0B8F5C8CCD2", hash_generated_method = "750BBC66CFE9F9300E604590FE9D3C4F")
    public long getDrawingTime() {
        long var1F40956FCED7B849A56406B7FD2C5FC7_1680581068 = (mAttachInfo != null ? mAttachInfo.mDrawingTime : 0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1267761130 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1267761130;
        // ---------- Original Method ----------
        //return mAttachInfo != null ? mAttachInfo.mDrawingTime : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.099 -0400", hash_original_method = "CAE567A7C394D0DF999555076FD0D1ED", hash_generated_method = "272C3F5FF4CF785914F33A4484BA43B0")
    public void setDuplicateParentStateEnabled(boolean enabled) {
        addTaint(enabled);
        setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
        // ---------- Original Method ----------
        //setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.099 -0400", hash_original_method = "AF26528701A515059D58013186164554", hash_generated_method = "B665F2DC10904EBD8FCAF5093A5BC691")
    public boolean isDuplicateParentStateEnabled() {
        boolean var555EA2F1428D976CFCFA036FD5F54B3A_1132901588 = ((mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597081505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597081505;
        // ---------- Original Method ----------
        //return (mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.100 -0400", hash_original_method = "280CFBA803CA9107455CB03D3F8C277D", hash_generated_method = "F2AE166F061DFDA7D5B5A43C652EA667")
    public void setLayerType(int layerType, Paint paint) {
    if(layerType < LAYER_TYPE_NONE || layerType > LAYER_TYPE_HARDWARE)        
        {
            IllegalArgumentException var0D1F4912420D20B4D4D38987D7F2A32B_331881786 = new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, "
                    + "LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
            var0D1F4912420D20B4D4D38987D7F2A32B_331881786.addTaint(taint);
            throw var0D1F4912420D20B4D4D38987D7F2A32B_331881786;
        } //End block
    if(layerType == mLayerType)        
        {
    if(layerType != LAYER_TYPE_NONE && paint != mLayerPaint)            
            {
                mLayerPaint = paint == null ? new Paint() : paint;
                invalidateParentCaches();
                invalidate(true);
            } //End block
            return;
        } //End block
switch(mLayerType){
        case LAYER_TYPE_HARDWARE:
        destroyLayer();
        case LAYER_TYPE_SOFTWARE:
        destroyDrawingCache();
        break;
        default:
        break;
}        mLayerType = layerType;
        final boolean layerDisabled = mLayerType == LAYER_TYPE_NONE;
        mLayerPaint = layerDisabled ? null : (paint == null ? new Paint() : paint);
        mLocalDirtyRect = layerDisabled ? null : new Rect();
        invalidateParentCaches();
        invalidate(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.100 -0400", hash_original_method = "E009407DF0C30C68D152BB83BB3493E0", hash_generated_method = "2C31E4E05E709FBD1CF4E08DE22CE76F")
     boolean hasStaticLayer() {
        boolean varBE9BD29E388B233B809DEA0CDCAA7B86_1239629586 = (mLayerType == LAYER_TYPE_NONE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800382277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800382277;
        // ---------- Original Method ----------
        //return mLayerType == LAYER_TYPE_NONE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.100 -0400", hash_original_method = "10BDECB6A9FC24A5B9656AF2BA9D9819", hash_generated_method = "36231A43B9B20C3935277D7B43F9597E")
    public int getLayerType() {
        int var2AD7B2E726BA7A853E37BAA8821A4B8A_1721343987 = (mLayerType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294653484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294653484;
        // ---------- Original Method ----------
        //return mLayerType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.100 -0400", hash_original_method = "FDD83A77B112AC8CB3AC65707C3CB088", hash_generated_method = "B3988AA7690F098E8A33CFA79DD7D6FF")
    public void buildLayer() {
    if(mLayerType == LAYER_TYPE_NONE)        
        return;
    if(mAttachInfo == null)        
        {
            IllegalStateException var938B858DCB950C10320DDE9D9C6E0EED_488936686 = new IllegalStateException("This view must be attached to a window first");
            var938B858DCB950C10320DDE9D9C6E0EED_488936686.addTaint(taint);
            throw var938B858DCB950C10320DDE9D9C6E0EED_488936686;
        } //End block
switch(mLayerType){
        case LAYER_TYPE_HARDWARE:
    if(mAttachInfo.mHardwareRenderer != null &&
                        mAttachInfo.mHardwareRenderer.isEnabled() &&
                        mAttachInfo.mHardwareRenderer.validate())        
        {
            getHardwareLayer();
        } //End block
        break;
        case LAYER_TYPE_SOFTWARE:
        buildDrawingCache(true);
        break;
}
        // ---------- Original Method ----------
        //if (mLayerType == LAYER_TYPE_NONE) return;
        //if (mAttachInfo == null) {
            //throw new IllegalStateException("This view must be attached to a window first");
        //}
        //switch (mLayerType) {
            //case LAYER_TYPE_HARDWARE:
                //if (mAttachInfo.mHardwareRenderer != null &&
                        //mAttachInfo.mHardwareRenderer.isEnabled() &&
                        //mAttachInfo.mHardwareRenderer.validate()) {
                    //getHardwareLayer();
                //}
                //break;
            //case LAYER_TYPE_SOFTWARE:
                //buildDrawingCache(true);
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.103 -0400", hash_original_method = "1C756BC3105DE982313252676EF7BEA5", hash_generated_method = "F56EE7411FD3B0F979574084A93E0EF7")
     HardwareLayer getHardwareLayer() {
    if(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null ||
                !mAttachInfo.mHardwareRenderer.isEnabled())        
        {
HardwareLayer var540C13E9E156B687226421B24F2DF178_1036427157 =             null;
            var540C13E9E156B687226421B24F2DF178_1036427157.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1036427157;
        } //End block
        final int width = mRight - mLeft;
        final int height = mBottom - mTop;
    if(width == 0 || height == 0)        
        {
HardwareLayer var540C13E9E156B687226421B24F2DF178_395304072 =             null;
            var540C13E9E156B687226421B24F2DF178_395304072.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_395304072;
        } //End block
    if((mPrivateFlags & DRAWING_CACHE_VALID) == 0 || mHardwareLayer == null)        
        {
    if(mHardwareLayer == null)            
            {
                mHardwareLayer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                        width, height, isOpaque());
                mLocalDirtyRect.setEmpty();
            } //End block
            else
    if(mHardwareLayer.getWidth() != width || mHardwareLayer.getHeight() != height)            
            {
                mHardwareLayer.resize(width, height);
                mLocalDirtyRect.setEmpty();
            } //End block
    if(!mHardwareLayer.isValid())            
            {
HardwareLayer var540C13E9E156B687226421B24F2DF178_1701845188 =                 null;
                var540C13E9E156B687226421B24F2DF178_1701845188.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1701845188;
            } //End block
            HardwareCanvas currentCanvas = mAttachInfo.mHardwareCanvas;
            final HardwareCanvas canvas = mHardwareLayer.start(currentCanvas);
    if(canvas == null)            
            {
                mHardwareLayer.end(currentCanvas);
HardwareLayer var540C13E9E156B687226421B24F2DF178_1732351942 =                 null;
                var540C13E9E156B687226421B24F2DF178_1732351942.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1732351942;
            } //End block
            mAttachInfo.mHardwareCanvas = canvas;
            try 
            {
                canvas.setViewport(width, height);
                canvas.onPreDraw(mLocalDirtyRect);
                mLocalDirtyRect.setEmpty();
                final int restoreCount = canvas.save();
                computeScroll();
                canvas.translate(-mScrollX, -mScrollY);
                mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
    if((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW)                
                {
                    mPrivateFlags &= ~DIRTY_MASK;
                    dispatchDraw(canvas);
                } //End block
                else
                {
                    draw(canvas);
                } //End block
                canvas.restoreToCount(restoreCount);
            } //End block
            finally 
            {
                canvas.onPostDraw();
                mHardwareLayer.end(currentCanvas);
                mAttachInfo.mHardwareCanvas = currentCanvas;
            } //End block
        } //End block
HardwareLayer varB61B9EFE82EF1863F43259E821062A8A_380446109 =         mHardwareLayer;
        varB61B9EFE82EF1863F43259E821062A8A_380446109.addTaint(taint);
        return varB61B9EFE82EF1863F43259E821062A8A_380446109;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.103 -0400", hash_original_method = "46CD3F4D955A0CC35E16981FB59107BF", hash_generated_method = "D7190822CA3D4B7BA14E3C693CBC9AC8")
     boolean destroyLayer() {
    if(mHardwareLayer != null)        
        {
            mHardwareLayer.destroy();
            mHardwareLayer = null;
            invalidate(true);
            invalidateParentCaches();
            boolean varB326B5062B2F0E69046810717534CB09_1472476415 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36935696 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_36935696;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1735691174 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94948113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94948113;
        // ---------- Original Method ----------
        //if (mHardwareLayer != null) {
            //mHardwareLayer.destroy();
            //mHardwareLayer = null;
            //invalidate(true);
            //invalidateParentCaches();
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.103 -0400", hash_original_method = "2A28B7876CAFDC07E0FAFA28070957E8", hash_generated_method = "40E2B8629BC48C8FF763F010A3364CFD")
    protected void destroyHardwareResources() {
        destroyLayer();
        // ---------- Original Method ----------
        //destroyLayer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.104 -0400", hash_original_method = "8AD6975BC71E736FF7830468F6E8AB45", hash_generated_method = "1CF8973C94E1C5C6BABAEA8660C754C3")
    public void setDrawingCacheEnabled(boolean enabled) {
        addTaint(enabled);
        mCachingFailed = false;
        setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
        // ---------- Original Method ----------
        //mCachingFailed = false;
        //setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.104 -0400", hash_original_method = "B123D3E623B7638C240DD8280788F70C", hash_generated_method = "B7425EDA983922304C404CBF3EE19DF0")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isDrawingCacheEnabled() {
        boolean var0244E13FA4385F49901CA7093FEEDAAC_1070463891 = ((mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1781536773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1781536773;
        // ---------- Original Method ----------
        //return (mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.105 -0400", hash_original_method = "ED3E6074026E0275E7BADCEAD02A1919", hash_generated_method = "3DED4EE6F6E5BD20D475B61C9DCD1435")
    @SuppressWarnings({"UnusedDeclaration"})
    public void outputDirtyFlags(String indent, boolean clear, int clearMask) {
        addTaint(clear);
        addTaint(indent.getTaint());
        Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                ") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                (mPrivateFlags & View.DRAWING_CACHE_VALID) +
                ") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
    if(clear)        
        {
            mPrivateFlags &= clearMask;
        } //End block
    if(this instanceof ViewGroup)        
        {
            ViewGroup parent = (ViewGroup) this;
            final int count = parent.getChildCount();
for(int i = 0;i < count;i++)
            {
                final View child = parent.getChildAt(i);
                child.outputDirtyFlags(indent + "  ", clear, clearMask);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                //") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                //(mPrivateFlags & View.DRAWING_CACHE_VALID) +
                //") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
        //if (clear) {
            //mPrivateFlags &= clearMask;
        //}
        //if (this instanceof ViewGroup) {
            //ViewGroup parent = (ViewGroup) this;
            //final int count = parent.getChildCount();
            //for (int i = 0; i < count; i++) {
                //final View child = parent.getChildAt(i);
                //child.outputDirtyFlags(indent + "  ", clear, clearMask);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.105 -0400", hash_original_method = "F520ED30BD4141F0E67AE80815EDDC89", hash_generated_method = "7D5447D36AD4507DE6BB8070E0DEAF7B")
    protected void dispatchGetDisplayList() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.105 -0400", hash_original_method = "AB7D77CF9F94D5BD05F1DB3F0B62C9D0", hash_generated_method = "8E1162BCA937A50533B7D6618FB5FFF5")
    public boolean canHaveDisplayList() {
        boolean var4C78B0E26A4D3AB720F1CAB15651B597_648635091 = (!(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990902720 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_990902720;
        // ---------- Original Method ----------
        //return !(mAttachInfo == null || mAttachInfo.mHardwareRenderer == null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.106 -0400", hash_original_method = "A79479675DF460DA0EF507C879CE4B27", hash_generated_method = "3D1775184B410A9DB74BE9FCA573582C")
    public DisplayList getDisplayList() {
    if(!canHaveDisplayList())        
        {
DisplayList var540C13E9E156B687226421B24F2DF178_188583628 =             null;
            var540C13E9E156B687226421B24F2DF178_188583628.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_188583628;
        } //End block
    if(((mPrivateFlags & DRAWING_CACHE_VALID) == 0 ||
                mDisplayList == null || !mDisplayList.isValid() ||
                mRecreateDisplayList))        
        {
    if(mDisplayList != null && mDisplayList.isValid() &&
                    !mRecreateDisplayList)            
            {
                mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                mPrivateFlags &= ~DIRTY_MASK;
                dispatchGetDisplayList();
DisplayList var227A794D808F38912C1BA9B7F905BA9E_558466415 =                 mDisplayList;
                var227A794D808F38912C1BA9B7F905BA9E_558466415.addTaint(taint);
                return var227A794D808F38912C1BA9B7F905BA9E_558466415;
            } //End block
            mRecreateDisplayList = true;
    if(mDisplayList == null)            
            {
                mDisplayList = mAttachInfo.mHardwareRenderer.createDisplayList();
                invalidateParentCaches();
            } //End block
            final HardwareCanvas canvas = mDisplayList.start();
            int restoreCount = 0;
            try 
            {
                int width = mRight - mLeft;
                int height = mBottom - mTop;
                canvas.setViewport(width, height);
                canvas.onPreDraw(null);
                computeScroll();
                restoreCount = canvas.save();
                canvas.translate(-mScrollX, -mScrollY);
                mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                mPrivateFlags &= ~DIRTY_MASK;
    if((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW)                
                {
                    dispatchDraw(canvas);
                } //End block
                else
                {
                    draw(canvas);
                } //End block
            } //End block
            finally 
            {
                canvas.restoreToCount(restoreCount);
                canvas.onPostDraw();
                mDisplayList.end();
            } //End block
        } //End block
        else
        {
            mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
            mPrivateFlags &= ~DIRTY_MASK;
        } //End block
DisplayList var227A794D808F38912C1BA9B7F905BA9E_920813972 =         mDisplayList;
        var227A794D808F38912C1BA9B7F905BA9E_920813972.addTaint(taint);
        return var227A794D808F38912C1BA9B7F905BA9E_920813972;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.107 -0400", hash_original_method = "16C485E3429312C7E841D79823374233", hash_generated_method = "68C87648B519DE0ABDC6A2DD2A881088")
    public Bitmap getDrawingCache() {
Bitmap var5795FD7B2753188791449C92EA4F6DE9_1489490728 =         getDrawingCache(false);
        var5795FD7B2753188791449C92EA4F6DE9_1489490728.addTaint(taint);
        return var5795FD7B2753188791449C92EA4F6DE9_1489490728;
        // ---------- Original Method ----------
        //return getDrawingCache(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.107 -0400", hash_original_method = "CA92F18E14EB0519BF84A3C226CE3F4A", hash_generated_method = "3F90A286F0234FB799675F06F072ADA1")
    public Bitmap getDrawingCache(boolean autoScale) {
        addTaint(autoScale);
    if((mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING)        
        {
Bitmap var540C13E9E156B687226421B24F2DF178_175170675 =             null;
            var540C13E9E156B687226421B24F2DF178_175170675.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_175170675;
        } //End block
    if((mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED)        
        {
            buildDrawingCache(autoScale);
        } //End block
Bitmap varB60FBC2A35B098CA8A0039ED8B8A6A5A_2118298471 =         autoScale ? mDrawingCache : mUnscaledDrawingCache;
        varB60FBC2A35B098CA8A0039ED8B8A6A5A_2118298471.addTaint(taint);
        return varB60FBC2A35B098CA8A0039ED8B8A6A5A_2118298471;
        // ---------- Original Method ----------
        //if ((mViewFlags & WILL_NOT_CACHE_DRAWING) == WILL_NOT_CACHE_DRAWING) {
            //return null;
        //}
        //if ((mViewFlags & DRAWING_CACHE_ENABLED) == DRAWING_CACHE_ENABLED) {
            //buildDrawingCache(autoScale);
        //}
        //return autoScale ? mDrawingCache : mUnscaledDrawingCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.107 -0400", hash_original_method = "0E5E783B90E69DDC86CBB5AF4D60343F", hash_generated_method = "CBCA8FDD5A40524178ADB772827C5780")
    public void destroyDrawingCache() {
    if(mDrawingCache != null)        
        {
            mDrawingCache.recycle();
            mDrawingCache = null;
        } //End block
    if(mUnscaledDrawingCache != null)        
        {
            mUnscaledDrawingCache.recycle();
            mUnscaledDrawingCache = null;
        } //End block
        // ---------- Original Method ----------
        //if (mDrawingCache != null) {
            //mDrawingCache.recycle();
            //mDrawingCache = null;
        //}
        //if (mUnscaledDrawingCache != null) {
            //mUnscaledDrawingCache.recycle();
            //mUnscaledDrawingCache = null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.109 -0400", hash_original_method = "2126772517D4D51A0CCD7D5847A54B89", hash_generated_method = "1C4335C220F52EB45915E0B56BD11A25")
    public void setDrawingCacheBackgroundColor(int color) {
    if(color != mDrawingCacheBackgroundColor)        
        {
            mDrawingCacheBackgroundColor = color;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        } //End block
        // ---------- Original Method ----------
        //if (color != mDrawingCacheBackgroundColor) {
            //mDrawingCacheBackgroundColor = color;
            //mPrivateFlags &= ~DRAWING_CACHE_VALID;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.109 -0400", hash_original_method = "4BEC5ECE79612E1091BBCBD880B92D6A", hash_generated_method = "87DADDA947F887066104DF892D6987E5")
    public int getDrawingCacheBackgroundColor() {
        int var82DEE2207665E891196DF5E2B07B5116_810554403 = (mDrawingCacheBackgroundColor);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754807475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_754807475;
        // ---------- Original Method ----------
        //return mDrawingCacheBackgroundColor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.109 -0400", hash_original_method = "8A1B171D557613DB7E4B9E775A2E64AA", hash_generated_method = "7863622F5BA5FABAB7E5B62D4108044D")
    public void buildDrawingCache() {
        buildDrawingCache(false);
        // ---------- Original Method ----------
        //buildDrawingCache(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.112 -0400", hash_original_method = "8AFFFACECE9FE8C2DF57758245D0721D", hash_generated_method = "D73B4B7D91B3A89E08EDDEF7BC77493B")
    public void buildDrawingCache(boolean autoScale) {
        addTaint(autoScale);
    if((mPrivateFlags & DRAWING_CACHE_VALID) == 0 || (autoScale ?
                mDrawingCache == null : mUnscaledDrawingCache == null))        
        {
            mCachingFailed = false;
    if(ViewDebug.TRACE_HIERARCHY)            
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.BUILD_CACHE);
            } //End block
            int width = mRight - mLeft;
            int height = mBottom - mTop;
            final AttachInfo attachInfo = mAttachInfo;
            final boolean scalingRequired = attachInfo != null && attachInfo.mScalingRequired;
    if(autoScale && scalingRequired)            
            {
                width = (int) ((width * attachInfo.mApplicationScale) + 0.5f);
                height = (int) ((height * attachInfo.mApplicationScale) + 0.5f);
            } //End block
            final int drawingCacheBackgroundColor = mDrawingCacheBackgroundColor;
            final boolean opaque = drawingCacheBackgroundColor != 0 || isOpaque();
            final boolean use32BitCache = attachInfo != null && attachInfo.mUse32BitDrawingCache;
    if(width <= 0 || height <= 0 ||
                    (width * height * (opaque && !use32BitCache ? 2 : 4) >
                            ViewConfiguration.get(mContext).getScaledMaximumDrawingCacheSize()))            
            {
                destroyDrawingCache();
                mCachingFailed = true;
                return;
            } //End block
            boolean clear = true;
            Bitmap bitmap = autoScale ? mDrawingCache : mUnscaledDrawingCache;
    if(bitmap == null || bitmap.getWidth() != width || bitmap.getHeight() != height)            
            {
                Bitmap.Config quality;
    if(!opaque)                
                {
switch(mViewFlags & DRAWING_CACHE_QUALITY_MASK){
                    case DRAWING_CACHE_QUALITY_AUTO:
                    quality = Bitmap.Config.ARGB_8888;
                    break;
                    case DRAWING_CACHE_QUALITY_LOW:
                    quality = Bitmap.Config.ARGB_8888;
                    break;
                    case DRAWING_CACHE_QUALITY_HIGH:
                    quality = Bitmap.Config.ARGB_8888;
                    break;
                    default:
                    quality = Bitmap.Config.ARGB_8888;
                    break;
}
                } //End block
                else
                {
                    quality = use32BitCache ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                } //End block
    if(bitmap != null)                
                bitmap.recycle();
                try 
                {
                    bitmap = Bitmap.createBitmap(width, height, quality);
                    bitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
    if(autoScale)                    
                    {
                        mDrawingCache = bitmap;
                    } //End block
                    else
                    {
                        mUnscaledDrawingCache = bitmap;
                    } //End block
    if(opaque && use32BitCache)                    
                    bitmap.setHasAlpha(false);
                } //End block
                catch (OutOfMemoryError e)
                {
    if(autoScale)                    
                    {
                        mDrawingCache = null;
                    } //End block
                    else
                    {
                        mUnscaledDrawingCache = null;
                    } //End block
                    mCachingFailed = true;
                    return;
                } //End block
                clear = drawingCacheBackgroundColor != 0;
            } //End block
            Canvas canvas;
    if(attachInfo != null)            
            {
                canvas = attachInfo.mCanvas;
    if(canvas == null)                
                {
                    canvas = new Canvas();
                } //End block
                canvas.setBitmap(bitmap);
                attachInfo.mCanvas = null;
            } //End block
            else
            {
                canvas = new Canvas(bitmap);
            } //End block
    if(clear)            
            {
                bitmap.eraseColor(drawingCacheBackgroundColor);
            } //End block
            computeScroll();
            final int restoreCount = canvas.save();
    if(autoScale && scalingRequired)            
            {
                final float scale = attachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } //End block
            canvas.translate(-mScrollX, -mScrollY);
            mPrivateFlags |= DRAWN;
    if(mAttachInfo == null || !mAttachInfo.mHardwareAccelerated ||
                    mLayerType != LAYER_TYPE_NONE)            
            {
                mPrivateFlags |= DRAWING_CACHE_VALID;
            } //End block
    if((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW)            
            {
    if(ViewDebug.TRACE_HIERARCHY)                
                {
                    ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                } //End block
                mPrivateFlags &= ~DIRTY_MASK;
                dispatchDraw(canvas);
            } //End block
            else
            {
                draw(canvas);
            } //End block
            canvas.restoreToCount(restoreCount);
            canvas.setBitmap(null);
    if(attachInfo != null)            
            {
                attachInfo.mCanvas = canvas;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.118 -0400", hash_original_method = "9EC32975405209F06A6AEBC988E2ADFA", hash_generated_method = "E7DE6915A553E326CE327048E499B6ED")
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        addTaint(skipChildren);
        addTaint(backgroundColor);
        addTaint(quality.getTaint());
        int width = mRight - mLeft;
        int height = mBottom - mTop;
        final AttachInfo attachInfo = mAttachInfo;
        final float scale = attachInfo != null ? attachInfo.mApplicationScale : 1.0f;
        width = (int) ((width * scale) + 0.5f);
        height = (int) ((height * scale) + 0.5f);
        Bitmap bitmap = Bitmap.createBitmap(width > 0 ? width : 1, height > 0 ? height : 1, quality);
    if(bitmap == null)        
        {
            OutOfMemoryError varA3E76AA7FE8B36059398F1CB49D9DAC3_1835453134 = new OutOfMemoryError();
            varA3E76AA7FE8B36059398F1CB49D9DAC3_1835453134.addTaint(taint);
            throw varA3E76AA7FE8B36059398F1CB49D9DAC3_1835453134;
        } //End block
        Resources resources = getResources();
    if(resources != null)        
        {
            bitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        } //End block
        Canvas canvas;
    if(attachInfo != null)        
        {
            canvas = attachInfo.mCanvas;
    if(canvas == null)            
            {
                canvas = new Canvas();
            } //End block
            canvas.setBitmap(bitmap);
            attachInfo.mCanvas = null;
        } //End block
        else
        {
            canvas = new Canvas(bitmap);
        } //End block
    if((backgroundColor & 0xff000000) != 0)        
        {
            bitmap.eraseColor(backgroundColor);
        } //End block
        computeScroll();
        final int restoreCount = canvas.save();
        canvas.scale(scale, scale);
        canvas.translate(-mScrollX, -mScrollY);
        int flags = mPrivateFlags;
        mPrivateFlags &= ~DIRTY_MASK;
    if((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW)        
        {
            dispatchDraw(canvas);
        } //End block
        else
        {
            draw(canvas);
        } //End block
        mPrivateFlags = flags;
        canvas.restoreToCount(restoreCount);
        canvas.setBitmap(null);
    if(attachInfo != null)        
        {
            attachInfo.mCanvas = canvas;
        } //End block
Bitmap var3752488A34EC2C4FECF5AE64DF03DAEB_809141438 =         bitmap;
        var3752488A34EC2C4FECF5AE64DF03DAEB_809141438.addTaint(taint);
        return var3752488A34EC2C4FECF5AE64DF03DAEB_809141438;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.119 -0400", hash_original_method = "B880B01C07154F288A73209778F72869", hash_generated_method = "0929E15EF3AB5F88838EA5FFB69D57EC")
    public boolean isInEditMode() {
        boolean var68934A3E9455FA72420237EB05902327_1902017163 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1289374464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1289374464;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.119 -0400", hash_original_method = "FAE0811CBF87AAE1D612614CB5EBE838", hash_generated_method = "8B2FF35B05CB79B253BD7500E5681988")
    protected boolean isPaddingOffsetRequired() {
        boolean var68934A3E9455FA72420237EB05902327_1624488873 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1845757164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1845757164;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.119 -0400", hash_original_method = "4C949B81A8DC7FEE598CF97986A5D947", hash_generated_method = "BFFCF40BE59968E782F80EBCA79335AA")
    protected int getLeftPaddingOffset() {
        int varCFCD208495D565EF66E7DFF9F98764DA_514174064 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58018717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_58018717;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.119 -0400", hash_original_method = "074FFDE548FCC46FA1E9A30627AB8A7C", hash_generated_method = "4ADAB50C7F2E299B0BA4CF909FB5F485")
    protected int getRightPaddingOffset() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1864018903 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408357199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1408357199;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.119 -0400", hash_original_method = "A9CEAAEF3075A726E0EAEBF5F9AFAFB2", hash_generated_method = "E3E8D92D606348D89398686306F1AEC9")
    protected int getTopPaddingOffset() {
        int varCFCD208495D565EF66E7DFF9F98764DA_584765643 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166873515 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1166873515;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.120 -0400", hash_original_method = "8428DF91FD33A9244C31B60F9D34D200", hash_generated_method = "4BDC24F48E98345C42D338C9F57CD9F8")
    protected int getBottomPaddingOffset() {
        int varCFCD208495D565EF66E7DFF9F98764DA_859701936 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565909286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565909286;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.120 -0400", hash_original_method = "6D1FD6806CEFCA87F4934C6F8CB34AD2", hash_generated_method = "EE3D76509298FF8EC6F290FBF75F36DF")
    protected int getFadeTop(boolean offsetRequired) {
        addTaint(offsetRequired);
        int top = mPaddingTop;
    if(offsetRequired)        
        top += getTopPaddingOffset();
        int varB28354B543375BFA94DABAEDA722927F_1419615624 = (top);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892874791 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1892874791;
        // ---------- Original Method ----------
        //int top = mPaddingTop;
        //if (offsetRequired) top += getTopPaddingOffset();
        //return top;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.120 -0400", hash_original_method = "9B6486C3AB53B66EA69662D43A443B3A", hash_generated_method = "D161E1ABE865C9263F8E6951D0A06CA3")
    protected int getFadeHeight(boolean offsetRequired) {
        addTaint(offsetRequired);
        int padding = mPaddingTop;
    if(offsetRequired)        
        padding += getTopPaddingOffset();
        int var2808ECE9D051F057E574E0EAD91AD2F5_1302270287 = (mBottom - mTop - mPaddingBottom - padding);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_774564798 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_774564798;
        // ---------- Original Method ----------
        //int padding = mPaddingTop;
        //if (offsetRequired) padding += getTopPaddingOffset();
        //return mBottom - mTop - mPaddingBottom - padding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.121 -0400", hash_original_method = "E6CC46F2CB7AE1B25C3F8DA9B9857709", hash_generated_method = "B04013C4AA414A5C92D49D917EAE48E1")
    public boolean isHardwareAccelerated() {
        boolean var2E59295D7FCBA475D9BDE271007158D4_2015202450 = (mAttachInfo != null && mAttachInfo.mHardwareAccelerated);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459820670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459820670;
        // ---------- Original Method ----------
        //return mAttachInfo != null && mAttachInfo.mHardwareAccelerated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.123 -0400", hash_original_method = "788C5C753E694A468D30095348832570", hash_generated_method = "BE77B975B8BB4A405692E5290E604BCD")
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
        } //End block
        final int privateFlags = mPrivateFlags;
        final boolean dirtyOpaque = (privateFlags & DIRTY_MASK) == DIRTY_OPAQUE &&
                (mAttachInfo == null || !mAttachInfo.mIgnoreDirtyState);
        mPrivateFlags = (privateFlags & ~DIRTY_MASK) | DRAWN;
        int saveCount;
    if(!dirtyOpaque)        
        {
            final Drawable background = mBGDrawable;
    if(background != null)            
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
    if(mBackgroundSizeChanged)                
                {
                    background.setBounds(0, 0,  mRight - mLeft, mBottom - mTop);
                    mBackgroundSizeChanged = false;
                } //End block
    if((scrollX | scrollY) == 0)                
                {
                    background.draw(canvas);
                } //End block
                else
                {
                    canvas.translate(scrollX, scrollY);
                    background.draw(canvas);
                    canvas.translate(-scrollX, -scrollY);
                } //End block
            } //End block
        } //End block
        final int viewFlags = mViewFlags;
        boolean horizontalEdges = (viewFlags & FADING_EDGE_HORIZONTAL) != 0;
        boolean verticalEdges = (viewFlags & FADING_EDGE_VERTICAL) != 0;
    if(!verticalEdges && !horizontalEdges)        
        {
    if(!dirtyOpaque)            
            onDraw(canvas);
            dispatchDraw(canvas);
            onDrawScrollBars(canvas);
            return;
        } //End block
        boolean drawTop = false;
        boolean drawBottom = false;
        boolean drawLeft = false;
        boolean drawRight = false;
        float topFadeStrength = 0.0f;
        float bottomFadeStrength = 0.0f;
        float leftFadeStrength = 0.0f;
        float rightFadeStrength = 0.0f;
        int paddingLeft = mPaddingLeft;
        final boolean offsetRequired = isPaddingOffsetRequired();
    if(offsetRequired)        
        {
            paddingLeft += getLeftPaddingOffset();
        } //End block
        int left = mScrollX + paddingLeft;
        int right = left + mRight - mLeft - mPaddingRight - paddingLeft;
        int top = mScrollY + getFadeTop(offsetRequired);
        int bottom = top + getFadeHeight(offsetRequired);
    if(offsetRequired)        
        {
            right += getRightPaddingOffset();
            bottom += getBottomPaddingOffset();
        } //End block
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        final float fadeHeight = scrollabilityCache.fadingEdgeLength;
        int length = (int) fadeHeight;
    if(verticalEdges && (top + length > bottom - length))        
        {
            length = (bottom - top) / 2;
        } //End block
    if(horizontalEdges && (left + length > right - length))        
        {
            length = (right - left) / 2;
        } //End block
    if(verticalEdges)        
        {
            topFadeStrength = Math.max(0.0f, Math.min(1.0f, getTopFadingEdgeStrength()));
            drawTop = topFadeStrength * fadeHeight > 1.0f;
            bottomFadeStrength = Math.max(0.0f, Math.min(1.0f, getBottomFadingEdgeStrength()));
            drawBottom = bottomFadeStrength * fadeHeight > 1.0f;
        } //End block
    if(horizontalEdges)        
        {
            leftFadeStrength = Math.max(0.0f, Math.min(1.0f, getLeftFadingEdgeStrength()));
            drawLeft = leftFadeStrength * fadeHeight > 1.0f;
            rightFadeStrength = Math.max(0.0f, Math.min(1.0f, getRightFadingEdgeStrength()));
            drawRight = rightFadeStrength * fadeHeight > 1.0f;
        } //End block
        saveCount = canvas.getSaveCount();
        int solidColor = getSolidColor();
    if(solidColor == 0)        
        {
            final int flags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
    if(drawTop)            
            {
                canvas.saveLayer(left, top, right, top + length, null, flags);
            } //End block
    if(drawBottom)            
            {
                canvas.saveLayer(left, bottom - length, right, bottom, null, flags);
            } //End block
    if(drawLeft)            
            {
                canvas.saveLayer(left, top, left + length, bottom, null, flags);
            } //End block
    if(drawRight)            
            {
                canvas.saveLayer(right - length, top, right, bottom, null, flags);
            } //End block
        } //End block
        else
        {
            scrollabilityCache.setFadeColor(solidColor);
        } //End block
    if(!dirtyOpaque)        
        onDraw(canvas);
        dispatchDraw(canvas);
        final Paint p = scrollabilityCache.paint;
        final Matrix matrix = scrollabilityCache.matrix;
        final Shader fade = scrollabilityCache.shader;
    if(drawTop)        
        {
            matrix.setScale(1, fadeHeight * topFadeStrength);
            matrix.postTranslate(left, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, top, right, top + length, p);
        } //End block
    if(drawBottom)        
        {
            matrix.setScale(1, fadeHeight * bottomFadeStrength);
            matrix.postRotate(180);
            matrix.postTranslate(left, bottom);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, bottom - length, right, bottom, p);
        } //End block
    if(drawLeft)        
        {
            matrix.setScale(1, fadeHeight * leftFadeStrength);
            matrix.postRotate(-90);
            matrix.postTranslate(left, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, top, left + length, bottom, p);
        } //End block
    if(drawRight)        
        {
            matrix.setScale(1, fadeHeight * rightFadeStrength);
            matrix.postRotate(90);
            matrix.postTranslate(right, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(right - length, top, right, bottom, p);
        } //End block
        canvas.restoreToCount(saveCount);
        onDrawScrollBars(canvas);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.125 -0400", hash_original_method = "6ABCD0F86C11EBC98FE78FD55BB4B1CF", hash_generated_method = "46ACB7D1CAD0876065EDA27734C74FAC")
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getSolidColor() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1679853967 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877168489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1877168489;
        // ---------- Original Method ----------
        //return 0;
    }

    
        private static String printFlags(int flags) {
        String output = "";
        int numFlags = 0;
        if ((flags & FOCUSABLE_MASK) == FOCUSABLE) {
            output += "TAKES_FOCUS";
            numFlags++;
        }
        switch (flags & VISIBILITY_MASK) {
        case INVISIBLE:
            if (numFlags > 0) {
                output += " ";
            }
            output += "INVISIBLE";
            break;
        case GONE:
            if (numFlags > 0) {
                output += " ";
            }
            output += "GONE";
            break;
        default:
            break;
        }
        return output;
    }

    
        private static String printPrivateFlags(int privateFlags) {
        String output = "";
        int numFlags = 0;
        if ((privateFlags & WANTS_FOCUS) == WANTS_FOCUS) {
            output += "WANTS_FOCUS";
            numFlags++;
        }
        if ((privateFlags & FOCUSED) == FOCUSED) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "FOCUSED";
            numFlags++;
        }
        if ((privateFlags & SELECTED) == SELECTED) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "SELECTED";
            numFlags++;
        }
        if ((privateFlags & IS_ROOT_NAMESPACE) == IS_ROOT_NAMESPACE) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "IS_ROOT_NAMESPACE";
            numFlags++;
        }
        if ((privateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "HAS_BOUNDS";
            numFlags++;
        }
        if ((privateFlags & DRAWN) == DRAWN) {
            if (numFlags > 0) {
                output += " ";
            }
            output += "DRAWN";
        }
        return output;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.125 -0400", hash_original_method = "AB08A97FC3701C702D6BD81573091B60", hash_generated_method = "EE52623E645A7EE10B2720F81766220F")
    public boolean isLayoutRequested() {
        boolean var77FD23DB3068C4AAE13F85BC046DFF7C_461191436 = ((mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509884604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509884604;
        // ---------- Original Method ----------
        //return (mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.126 -0400", hash_original_method = "288ECB50C55148E98CF66115292FF462", hash_generated_method = "509998F22FFA484A60F2E53241756752")
    @SuppressWarnings({"unchecked"})
    public void layout(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        int oldL = mLeft;
        int oldT = mTop;
        int oldB = mBottom;
        int oldR = mRight;
        boolean changed = setFrame(l, t, r, b);
    if(changed || (mPrivateFlags & LAYOUT_REQUIRED) == LAYOUT_REQUIRED)        
        {
    if(ViewDebug.TRACE_HIERARCHY)            
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_LAYOUT);
            } //End block
            onLayout(changed, l, t, r, b);
            mPrivateFlags &= ~LAYOUT_REQUIRED;
            ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnLayoutChangeListeners != null)            
            {
                ArrayList<OnLayoutChangeListener> listenersCopy = (ArrayList<OnLayoutChangeListener>)li.mOnLayoutChangeListeners.clone();
                int numListeners = listenersCopy.size();
for(int i = 0;i < numListeners;++i)
                {
                    listenersCopy.get(i).onLayoutChange(this, l, t, r, b, oldL, oldT, oldR, oldB);
                } //End block
            } //End block
        } //End block
        mPrivateFlags &= ~FORCE_LAYOUT;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.126 -0400", hash_original_method = "E68A871B23A3BFC32DE9705D7524956B", hash_generated_method = "EC7223FBF9E976EF2BC9413A53707B65")
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.128 -0400", hash_original_method = "D0D9CDE5209D8FC4BFA1DB8710882914", hash_generated_method = "3146BB2A5D491BE91B2AA16D0701FDEA")
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean changed = false;
    if(DBG)        
        {
            Log.d("View", this + " View.setFrame(" + left + "," + top + ","
                    + right + "," + bottom + ")");
        } //End block
    if(mLeft != left || mRight != right || mTop != top || mBottom != bottom)        
        {
            changed = true;
            int drawn = mPrivateFlags & DRAWN;
            int oldWidth = mRight - mLeft;
            int oldHeight = mBottom - mTop;
            int newWidth = right - left;
            int newHeight = bottom - top;
            boolean sizeChanged = (newWidth != oldWidth) || (newHeight != oldHeight);
            invalidate(sizeChanged);
            mLeft = left;
            mTop = top;
            mRight = right;
            mBottom = bottom;
            mPrivateFlags |= HAS_BOUNDS;
    if(sizeChanged)            
            {
    if((mPrivateFlags & PIVOT_EXPLICITLY_SET) == 0)                
                {
    if(mTransformationInfo != null)                    
                    {
                        mTransformationInfo.mMatrixDirty = true;
                    } //End block
                } //End block
                onSizeChanged(newWidth, newHeight, oldWidth, oldHeight);
            } //End block
    if((mViewFlags & VISIBILITY_MASK) == VISIBLE)            
            {
                mPrivateFlags |= DRAWN;
                invalidate(sizeChanged);
                invalidateParentCaches();
            } //End block
            mPrivateFlags |= drawn;
            mBackgroundSizeChanged = true;
        } //End block
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_77987459 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_376601769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_376601769;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.128 -0400", hash_original_method = "BECA18BF96D1F48EBBDC02908C938AE4", hash_generated_method = "A5AD1675E772B469DDBDD7D413837A2E")
    protected void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.128 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "5618D0C727DB9166FEF3D5EC6CADF023")
    public Resources getResources() {
Resources var346B953D96D762F7FED561E83C1656CA_992442464 =         mResources;
        var346B953D96D762F7FED561E83C1656CA_992442464.addTaint(taint);
        return var346B953D96D762F7FED561E83C1656CA_992442464;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.128 -0400", hash_original_method = "1B5315B2A2E6007B07F436EFC340A168", hash_generated_method = "044CCB2FECD13B4E3509421586B79332")
    public void invalidateDrawable(Drawable drawable) {
        addTaint(drawable.getTaint());
    if(verifyDrawable(drawable))        
        {
            final Rect dirty = drawable.getBounds();
            final int scrollX = mScrollX;
            final int scrollY = mScrollY;
            invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
        } //End block
        // ---------- Original Method ----------
        //if (verifyDrawable(drawable)) {
            //final Rect dirty = drawable.getBounds();
            //final int scrollX = mScrollX;
            //final int scrollY = mScrollY;
            //invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    //dirty.right + scrollX, dirty.bottom + scrollY);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.129 -0400", hash_original_method = "8ECDB7E126F9B8C9FE155246E2EA10DA", hash_generated_method = "C9BA2C52EA0FFEA6B155347F2DDE4CE1")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        addTaint(when);
        addTaint(what.getTaint());
        addTaint(who.getTaint());
    if(verifyDrawable(who) && what != null)        
        {
    if(mAttachInfo != null)            
            {
                mAttachInfo.mHandler.postAtTime(what, who, when);
            } //End block
            else
            {
                ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (verifyDrawable(who) && what != null) {
            //if (mAttachInfo != null) {
                //mAttachInfo.mHandler.postAtTime(what, who, when);
            //} else {
                //ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.129 -0400", hash_original_method = "20282D900D1527E5779752DD2D1E3601", hash_generated_method = "779F44DCA6F8AE4D71FAF81C4A562C8B")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
    if(verifyDrawable(who) && what != null)        
        {
    if(mAttachInfo != null)            
            {
                mAttachInfo.mHandler.removeCallbacks(what, who);
            } //End block
            else
            {
                ViewRootImpl.getRunQueue().removeCallbacks(what);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (verifyDrawable(who) && what != null) {
            //if (mAttachInfo != null) {
                //mAttachInfo.mHandler.removeCallbacks(what, who);
            //} else {
                //ViewRootImpl.getRunQueue().removeCallbacks(what);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.130 -0400", hash_original_method = "5631E9137ED00BCDF82AA1F70C739531", hash_generated_method = "96AB41C2F6139C9F9903564C9267FFAF")
    public void unscheduleDrawable(Drawable who) {
        addTaint(who.getTaint());
    if(mAttachInfo != null)        
        {
            mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.130 -0400", hash_original_method = "AE0F8179B8268398E41F65FF0C6F4434", hash_generated_method = "FE73E439CE9C582A11CCB95142D1CDA9")
    public int getResolvedLayoutDirection(Drawable who) {
        addTaint(who.getTaint());
        int varD57CE8EF0AFEE11E85DCF39434FCB6BF_994832542 = ((who == mBGDrawable) ? getResolvedLayoutDirection() : LAYOUT_DIRECTION_DEFAULT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84305383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_84305383;
        // ---------- Original Method ----------
        //return (who == mBGDrawable) ? getResolvedLayoutDirection() : LAYOUT_DIRECTION_DEFAULT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.130 -0400", hash_original_method = "4F9A094C3230B8AB80716D2738225FBB", hash_generated_method = "0E54B295F7240526EB2BC2E5E616B0C7")
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean var1BED8227607A0A158889DFD233DCAC40_967669814 = (who == mBGDrawable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803867316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803867316;
        // ---------- Original Method ----------
        //return who == mBGDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.130 -0400", hash_original_method = "73C0FB6C39E14C0EF8F5708E9524F27F", hash_generated_method = "8D9EBB729C6E6FEA651D780B5A596D0E")
    protected void drawableStateChanged() {
        Drawable d = mBGDrawable;
    if(d != null && d.isStateful())        
        {
            d.setState(getDrawableState());
        } //End block
        // ---------- Original Method ----------
        //Drawable d = mBGDrawable;
        //if (d != null && d.isStateful()) {
            //d.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.130 -0400", hash_original_method = "3D0ECB50F3069F68F8A036B0BBF9CAA8", hash_generated_method = "3629AB28852A5DC35462FFDD96FAF77B")
    public void refreshDrawableState() {
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        drawableStateChanged();
        ViewParent parent = mParent;
    if(parent != null)        
        {
            parent.childDrawableStateChanged(this);
        } //End block
        // ---------- Original Method ----------
        //mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        //drawableStateChanged();
        //ViewParent parent = mParent;
        //if (parent != null) {
            //parent.childDrawableStateChanged(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.130 -0400", hash_original_method = "7B628D8EF95C580B0BB9FD927C61FF3F", hash_generated_method = "F16591F1E575B2155ED1F8353BFA6422")
    public final int[] getDrawableState() {
    if((mDrawableState != null) && ((mPrivateFlags & DRAWABLE_STATE_DIRTY) == 0))        
        {
            int[] varFE5D94618BDBB3F34C7D879CD2497A4E_768269414 = (mDrawableState);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_425588163 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_425588163;
        } //End block
        else
        {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
            int[] varFE5D94618BDBB3F34C7D879CD2497A4E_689561170 = (mDrawableState);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1006214471 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1006214471;
        } //End block
        // ---------- Original Method ----------
        //if ((mDrawableState != null) && ((mPrivateFlags & DRAWABLE_STATE_DIRTY) == 0)) {
            //return mDrawableState;
        //} else {
            //mDrawableState = onCreateDrawableState(0);
            //mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
            //return mDrawableState;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.133 -0400", hash_original_method = "65DFC58C78CED9A3B9AF9F7EEF9C3470", hash_generated_method = "40133B88D20279ECAE778FE479A57CFC")
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extraSpace);
    if((mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE &&
                mParent instanceof View)        
        {
            int[] var1D46B5C31393AD9093AC204D6756828A_1413113505 = (((View) mParent).onCreateDrawableState(extraSpace));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_124846 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_124846;
        } //End block
        int[] drawableState;
        int privateFlags = mPrivateFlags;
        int viewStateIndex = 0;
    if((privateFlags & PRESSED) != 0)        
        viewStateIndex |= VIEW_STATE_PRESSED;
    if((mViewFlags & ENABLED_MASK) == ENABLED)        
        viewStateIndex |= VIEW_STATE_ENABLED;
    if(isFocused())        
        viewStateIndex |= VIEW_STATE_FOCUSED;
    if((privateFlags & SELECTED) != 0)        
        viewStateIndex |= VIEW_STATE_SELECTED;
    if(hasWindowFocus())        
        viewStateIndex |= VIEW_STATE_WINDOW_FOCUSED;
    if((privateFlags & ACTIVATED) != 0)        
        viewStateIndex |= VIEW_STATE_ACTIVATED;
    if(mAttachInfo != null && mAttachInfo.mHardwareAccelerationRequested &&
                HardwareRenderer.isAvailable())        
        {
            viewStateIndex |= VIEW_STATE_ACCELERATED;
        } //End block
    if((privateFlags & HOVERED) != 0)        
        viewStateIndex |= VIEW_STATE_HOVERED;
        final int privateFlags2 = mPrivateFlags2;
    if((privateFlags2 & DRAG_CAN_ACCEPT) != 0)        
        viewStateIndex |= VIEW_STATE_DRAG_CAN_ACCEPT;
    if((privateFlags2 & DRAG_HOVERED) != 0)        
        viewStateIndex |= VIEW_STATE_DRAG_HOVERED;
        drawableState = VIEW_STATE_SETS[viewStateIndex];
    if(false)        
        {
        } //End block
    if(extraSpace == 0)        
        {
            int[] var7A12E87773589D809FD51F1A26B9BDA9_499222785 = (drawableState);
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_238204040 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_238204040;
        } //End block
        int[] fullState;
    if(drawableState != null)        
        {
            fullState = new int[drawableState.length + extraSpace];
            System.arraycopy(drawableState, 0, fullState, 0, drawableState.length);
        } //End block
        else
        {
            fullState = new int[extraSpace];
        } //End block
        int[] var8F0D0850FB27FD85C3BFCB7062C08F4B_476204354 = (fullState);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1351283941 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1351283941;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        protected static int[] mergeDrawableStates(int[] baseState, int[] additionalState) {
        final int N = baseState.length;
        int i = N - 1;
        while (i >= 0 && baseState[i] == 0) {
            i--;
        }
        System.arraycopy(additionalState, 0, baseState, i + 1, additionalState.length);
        return baseState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.134 -0400", hash_original_method = "9FD34CE508D1EA4936B2EE985D9CB024", hash_generated_method = "746C000A35F2E48BC7AC16B5841F9511")
    public void jumpDrawablesToCurrentState() {
    if(mBGDrawable != null)        
        {
            mBGDrawable.jumpToCurrentState();
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable != null) {
            //mBGDrawable.jumpToCurrentState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.134 -0400", hash_original_method = "0F7EB0FE33D439CD82034214A1B516F3", hash_generated_method = "C2F0D8C7A4626385755C714F5E8DA6ED")
    @RemotableViewMethod
    public void setBackgroundColor(int color) {
        addTaint(color);
    if(mBGDrawable instanceof ColorDrawable)        
        {
            ((ColorDrawable) mBGDrawable).setColor(color);
        } //End block
        else
        {
            setBackgroundDrawable(new ColorDrawable(color));
        } //End block
        // ---------- Original Method ----------
        //if (mBGDrawable instanceof ColorDrawable) {
            //((ColorDrawable) mBGDrawable).setColor(color);
        //} else {
            //setBackgroundDrawable(new ColorDrawable(color));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.135 -0400", hash_original_method = "009D5DD04F6FB534689B81D1D35D5DCC", hash_generated_method = "194FD0D3DF9C60F10DB50E85AA4D67BD")
    @RemotableViewMethod
    public void setBackgroundResource(int resid) {
    if(resid != 0 && resid == mBackgroundResource)        
        {
            return;
        } //End block
        Drawable d = null;
    if(resid != 0)        
        {
            d = mResources.getDrawable(resid);
        } //End block
        setBackgroundDrawable(d);
        mBackgroundResource = resid;
        // ---------- Original Method ----------
        //if (resid != 0 && resid == mBackgroundResource) {
            //return;
        //}
        //Drawable d= null;
        //if (resid != 0) {
            //d = mResources.getDrawable(resid);
        //}
        //setBackgroundDrawable(d);
        //mBackgroundResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.137 -0400", hash_original_method = "925AEEB36C7C1277949151BD876A29D4", hash_generated_method = "A858DDB7F6D79A7BBE4B804B26C345A5")
    public void setBackgroundDrawable(Drawable d) {
    if(d == mBGDrawable)        
        {
            return;
        } //End block
        boolean requestLayout = false;
        mBackgroundResource = 0;
    if(mBGDrawable != null)        
        {
            mBGDrawable.setCallback(null);
            unscheduleDrawable(mBGDrawable);
        } //End block
    if(d != null)        
        {
            Rect padding = sThreadLocal.get();
    if(padding == null)            
            {
                padding = new Rect();
                sThreadLocal.set(padding);
            } //End block
    if(d.getPadding(padding))            
            {
switch(d.getResolvedLayoutDirectionSelf()){
                case LAYOUT_DIRECTION_RTL:
                setPadding(padding.right, padding.top, padding.left, padding.bottom);
                break;
                case LAYOUT_DIRECTION_LTR:
                default:
                setPadding(padding.left, padding.top, padding.right, padding.bottom);
}
            } //End block
    if(mBGDrawable == null || mBGDrawable.getMinimumHeight() != d.getMinimumHeight() ||
                    mBGDrawable.getMinimumWidth() != d.getMinimumWidth())            
            {
                requestLayout = true;
            } //End block
            d.setCallback(this);
    if(d.isStateful())            
            {
                d.setState(getDrawableState());
            } //End block
            d.setVisible(getVisibility() == VISIBLE, false);
            mBGDrawable = d;
    if((mPrivateFlags & SKIP_DRAW) != 0)            
            {
                mPrivateFlags &= ~SKIP_DRAW;
                mPrivateFlags |= ONLY_DRAWS_BACKGROUND;
                requestLayout = true;
            } //End block
        } //End block
        else
        {
            mBGDrawable = null;
    if((mPrivateFlags & ONLY_DRAWS_BACKGROUND) != 0)            
            {
                mPrivateFlags &= ~ONLY_DRAWS_BACKGROUND;
                mPrivateFlags |= SKIP_DRAW;
            } //End block
            requestLayout = true;
        } //End block
        computeOpaqueFlags();
    if(requestLayout)        
        {
            requestLayout();
        } //End block
        mBackgroundSizeChanged = true;
        invalidate(true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.137 -0400", hash_original_method = "80971671F36DCDE8D8060A8575F1E0DF", hash_generated_method = "C9A8AB98FE342991B34DF5C23BB2E66A")
    public Drawable getBackground() {
Drawable var3D25AD8BDBA06EF63D09CE4CD9B7A319_1708991263 =         mBGDrawable;
        var3D25AD8BDBA06EF63D09CE4CD9B7A319_1708991263.addTaint(taint);
        return var3D25AD8BDBA06EF63D09CE4CD9B7A319_1708991263;
        // ---------- Original Method ----------
        //return mBGDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.139 -0400", hash_original_method = "518320784120938CAC15B0472A139DBB", hash_generated_method = "F9CC58174E3CC8FD7E30C1DAA1369AE8")
    public void setPadding(int left, int top, int right, int bottom) {
        boolean changed = false;
        mUserPaddingRelative = false;
        mUserPaddingLeft = left;
        mUserPaddingRight = right;
        mUserPaddingBottom = bottom;
        final int viewFlags = mViewFlags;
    if((viewFlags & (SCROLLBARS_VERTICAL|SCROLLBARS_HORIZONTAL)) != 0)        
        {
    if((viewFlags & SCROLLBARS_VERTICAL) != 0)            
            {
                final int offset = (viewFlags & SCROLLBARS_INSET_MASK) == 0
                        ? 0 : getVerticalScrollbarWidth();
switch(mVerticalScrollbarPosition){
                case SCROLLBAR_POSITION_DEFAULT:
    if(getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL)                
                {
                    left += offset;
                } //End block
                else
                {
                    right += offset;
                } //End block
                break;
                case SCROLLBAR_POSITION_RIGHT:
                right += offset;
                break;
                case SCROLLBAR_POSITION_LEFT:
                left += offset;
                break;
}
            } //End block
    if((viewFlags & SCROLLBARS_HORIZONTAL) != 0)            
            {
                bottom += (viewFlags & SCROLLBARS_INSET_MASK) == 0
                        ? 0 : getHorizontalScrollbarHeight();
            } //End block
        } //End block
    if(mPaddingLeft != left)        
        {
            changed = true;
            mPaddingLeft = left;
        } //End block
    if(mPaddingTop != top)        
        {
            changed = true;
            mPaddingTop = top;
        } //End block
    if(mPaddingRight != right)        
        {
            changed = true;
            mPaddingRight = right;
        } //End block
    if(mPaddingBottom != bottom)        
        {
            changed = true;
            mPaddingBottom = bottom;
        } //End block
    if(changed)        
        {
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.143 -0400", hash_original_method = "F50D0F04B3AF13DC9F9192544EA8BA6E", hash_generated_method = "B78F2E7F2B918572339AD07963F42CD5")
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        addTaint(bottom);
        addTaint(top);
        mUserPaddingRelative = true;
        mUserPaddingStart = start;
        mUserPaddingEnd = end;
switch(getResolvedLayoutDirection()){
        case LAYOUT_DIRECTION_RTL:
        setPadding(end, top, start, bottom);
        break;
        case LAYOUT_DIRECTION_LTR:
        default:
        setPadding(start, top, end, bottom);
}
        // ---------- Original Method ----------
        //mUserPaddingRelative = true;
        //mUserPaddingStart = start;
        //mUserPaddingEnd = end;
        //switch(getResolvedLayoutDirection()) {
            //case LAYOUT_DIRECTION_RTL:
                //setPadding(end, top, start, bottom);
                //break;
            //case LAYOUT_DIRECTION_LTR:
            //default:
                //setPadding(start, top, end, bottom);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.143 -0400", hash_original_method = "71BE64DF9CA1E548604AD18ADE3DFBDD", hash_generated_method = "3400A2B70C2EC7D3817CE85628DFCC6C")
    public int getPaddingTop() {
        int var160C8C8F6F0F40401734402AE62419A9_553524285 = (mPaddingTop);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665597161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665597161;
        // ---------- Original Method ----------
        //return mPaddingTop;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.143 -0400", hash_original_method = "472EE1BBE725DA831283E7FA94BE4536", hash_generated_method = "B2449D5703731BF4FF591E18CEB68FB3")
    public int getPaddingBottom() {
        int varDC0A1BD9ED7E0615D8F16D5DA74E6D47_2020802662 = (mPaddingBottom);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596477668 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1596477668;
        // ---------- Original Method ----------
        //return mPaddingBottom;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.144 -0400", hash_original_method = "F854F7F8F07B4C3AC7B7FE5B9B528BAE", hash_generated_method = "49EB0666848F234A77AB4388C2F44778")
    public int getPaddingLeft() {
        int var252F7DBD6188FA4BC0CBCF5785506FD8_506575466 = (mPaddingLeft);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164387457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164387457;
        // ---------- Original Method ----------
        //return mPaddingLeft;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.144 -0400", hash_original_method = "78A5E196850432C8DD415DC0673D2C8F", hash_generated_method = "AC753CEFC1C24FBFC0FF21C192772DC3")
    public int getPaddingStart() {
        int varD75F1F7E0FF803677F24DAD6B1BE1D7A_111451157 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                mPaddingRight : mPaddingLeft);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442138086 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1442138086;
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                //mPaddingRight : mPaddingLeft;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.144 -0400", hash_original_method = "6AC4AEB4D1AD621C23B7EB8B08E4182E", hash_generated_method = "138FB308EEC5EC9706A8E7D9B96D21BF")
    public int getPaddingRight() {
        int var1CC5609E099825B7F5335F0151334D28_1264738596 = (mPaddingRight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034703966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2034703966;
        // ---------- Original Method ----------
        //return mPaddingRight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.145 -0400", hash_original_method = "EE58EF7C85312E1C063201AE8CA23F8D", hash_generated_method = "9CC75CF0371B780A5C471B866C23D213")
    public int getPaddingEnd() {
        int var602D28FB18C19C142C8DE47916CDB087_1369884980 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                mPaddingLeft : mPaddingRight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701521664 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_701521664;
        // ---------- Original Method ----------
        //return (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL) ?
                //mPaddingLeft : mPaddingRight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.145 -0400", hash_original_method = "84D71EDE4F7EF14E19771B4AB735B283", hash_generated_method = "A93A4A1D257C61B51FE91097C847503F")
    public boolean isPaddingRelative() {
        boolean var5E1288938438CBB6C9289BF968E78727_816286088 = (mUserPaddingRelative);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_497812631 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_497812631;
        // ---------- Original Method ----------
        //return mUserPaddingRelative;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.145 -0400", hash_original_method = "91676949986DAC4CFDCFD2A3FAD3A69B", hash_generated_method = "E50C5BA98288C0F4C70B95A1970A6106")
    public void setSelected(boolean selected) {
    if(((mPrivateFlags & SELECTED) != 0) != selected)        
        {
            mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
    if(!selected)            
            resetPressedState();
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(selected);
        } //End block
        // ---------- Original Method ----------
        //if (((mPrivateFlags & SELECTED) != 0) != selected) {
            //mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
            //if (!selected) resetPressedState();
            //invalidate(true);
            //refreshDrawableState();
            //dispatchSetSelected(selected);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.145 -0400", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "D0F40E63E0975CE8FE5A4FA8E00A2A22")
    protected void dispatchSetSelected(boolean selected) {
        addTaint(selected);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.145 -0400", hash_original_method = "48002052E4D321A2B2BAD55BEF8E0A66", hash_generated_method = "18A357ACC992B01CDC30D09040366EEB")
    @ViewDebug.ExportedProperty
    public boolean isSelected() {
        boolean varE74B3C4BFAFCC40BEDD59CA305A19F2E_1254667973 = ((mPrivateFlags & SELECTED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053726065 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053726065;
        // ---------- Original Method ----------
        //return (mPrivateFlags & SELECTED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.146 -0400", hash_original_method = "449C65D8ABD541EEF5AF1DFBC99BE952", hash_generated_method = "8A5F85065A32D5DD432F56407D4F3AAC")
    public void setActivated(boolean activated) {
    if(((mPrivateFlags & ACTIVATED) != 0) != activated)        
        {
            mPrivateFlags = (mPrivateFlags & ~ACTIVATED) | (activated ? ACTIVATED : 0);
            invalidate(true);
            refreshDrawableState();
            dispatchSetActivated(activated);
        } //End block
        // ---------- Original Method ----------
        //if (((mPrivateFlags & ACTIVATED) != 0) != activated) {
            //mPrivateFlags = (mPrivateFlags & ~ACTIVATED) | (activated ? ACTIVATED : 0);
            //invalidate(true);
            //refreshDrawableState();
            //dispatchSetActivated(activated);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.146 -0400", hash_original_method = "857B49EDB2F7375261DD6F1ED2F34094", hash_generated_method = "51446F3DB68DBD70CEFE789714FC4FCB")
    protected void dispatchSetActivated(boolean activated) {
        addTaint(activated);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.147 -0400", hash_original_method = "807E5BA633430E7244B8D5311A7423DE", hash_generated_method = "A45DCA9DC1EDD44B7847C0D38CA8289D")
    @ViewDebug.ExportedProperty
    public boolean isActivated() {
        boolean var871AC35687815F62DFD1B1A18D18B0DE_1810714164 = ((mPrivateFlags & ACTIVATED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_57817014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_57817014;
        // ---------- Original Method ----------
        //return (mPrivateFlags & ACTIVATED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.147 -0400", hash_original_method = "99F6A92222C13DFFEF0BA3B363A5F1C1", hash_generated_method = "5C6874E7DC9AD38E5C6A6F66147B207F")
    public ViewTreeObserver getViewTreeObserver() {
    if(mAttachInfo != null)        
        {
ViewTreeObserver var7C0B44B80288784A978CA5CBF6E2B0A3_952646494 =             mAttachInfo.mTreeObserver;
            var7C0B44B80288784A978CA5CBF6E2B0A3_952646494.addTaint(taint);
            return var7C0B44B80288784A978CA5CBF6E2B0A3_952646494;
        } //End block
    if(mFloatingTreeObserver == null)        
        {
            mFloatingTreeObserver = new ViewTreeObserver();
        } //End block
ViewTreeObserver varDFAEB6FE3E7A93038B43658CA0AF8C6B_596364357 =         mFloatingTreeObserver;
        varDFAEB6FE3E7A93038B43658CA0AF8C6B_596364357.addTaint(taint);
        return varDFAEB6FE3E7A93038B43658CA0AF8C6B_596364357;
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //return mAttachInfo.mTreeObserver;
        //}
        //if (mFloatingTreeObserver == null) {
            //mFloatingTreeObserver = new ViewTreeObserver();
        //}
        //return mFloatingTreeObserver;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.147 -0400", hash_original_method = "399BB6B1CB98987E45F7FD1BEC4104A8", hash_generated_method = "CC7042A547B1E84E5C4FDFF9BAA61E5B")
    public View getRootView() {
    if(mAttachInfo != null)        
        {
            final View v = mAttachInfo.mRootView;
    if(v != null)            
            {
View var6DC76BC51820DD65E8396280E884AA78_261768934 =                 v;
                var6DC76BC51820DD65E8396280E884AA78_261768934.addTaint(taint);
                return var6DC76BC51820DD65E8396280E884AA78_261768934;
            } //End block
        } //End block
        View parent = this;
        while
(parent.mParent != null && parent.mParent instanceof View)        
        {
            parent = (View) parent.mParent;
        } //End block
View var0F49909EA73F8892C338E4DCA6EB9906_588632882 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_588632882.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_588632882;
        // ---------- Original Method ----------
        //if (mAttachInfo != null) {
            //final View v = mAttachInfo.mRootView;
            //if (v != null) {
                //return v;
            //}
        //}
        //View parent = this;
        //while (parent.mParent != null && parent.mParent instanceof View) {
            //parent = (View) parent.mParent;
        //}
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.147 -0400", hash_original_method = "6E1F3A14CB89D70C54E776D2215F970D", hash_generated_method = "916BB458EEA6DB724A4482EB5BA95B78")
    public void getLocationOnScreen(int[] location) {
        addTaint(location[0]);
        getLocationInWindow(location);
        final AttachInfo info = mAttachInfo;
    if(info != null)        
        {
            location[0] += info.mWindowLeft;
            location[1] += info.mWindowTop;
        } //End block
        // ---------- Original Method ----------
        //getLocationInWindow(location);
        //final AttachInfo info = mAttachInfo;
        //if (info != null) {
            //location[0] += info.mWindowLeft;
            //location[1] += info.mWindowTop;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.150 -0400", hash_original_method = "D5745CE4077A3F8C966A99FAE28757B4", hash_generated_method = "929468321B818AAFEE26E614D08BE54B")
    public void getLocationInWindow(int[] location) {
        addTaint(location[0]);
    if(mAttachInfo == null)        
        return;
    if(location == null || location.length < 2)        
        {
            IllegalArgumentException varC2C96B1345878FF50081D292CBE21A3E_43926032 = new IllegalArgumentException("location must be an array of two integers");
            varC2C96B1345878FF50081D292CBE21A3E_43926032.addTaint(taint);
            throw varC2C96B1345878FF50081D292CBE21A3E_43926032;
        } //End block
        float[] position = mAttachInfo.mTmpTransformLocation;
        position[0] = position[1] = 0.0f;
    if(!hasIdentityMatrix())        
        {
            getMatrix().mapPoints(position);
        } //End block
        position[0] += mLeft;
        position[1] += mTop;
        ViewParent viewParent = mParent;
        while
(viewParent instanceof View)        
        {
            final View view = (View) viewParent;
            position[0] -= view.mScrollX;
            position[1] -= view.mScrollY;
    if(!view.hasIdentityMatrix())            
            {
                view.getMatrix().mapPoints(position);
            } //End block
            position[0] += view.mLeft;
            position[1] += view.mTop;
            viewParent = view.mParent;
        } //End block
    if(viewParent instanceof ViewRootImpl)        
        {
            final ViewRootImpl vr = (ViewRootImpl) viewParent;
            position[1] -= vr.mCurScrollY;
        } //End block
        location[0] = (int) (position[0] + 0.5f);
        location[1] = (int) (position[1] + 0.5f);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.150 -0400", hash_original_method = "0641E50E124E0C6CE4C02F73E2175BDE", hash_generated_method = "168C9B3F0B461A6D45E82F04E389841E")
    protected View findViewTraversal(int id) {
        addTaint(id);
    if(id == mID)        
        {
View var72A74007B2BE62B849F475C7BDA4658B_1719860983 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1719860983.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1719860983;
        } //End block
View var540C13E9E156B687226421B24F2DF178_1877343987 =         null;
        var540C13E9E156B687226421B24F2DF178_1877343987.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1877343987;
        // ---------- Original Method ----------
        //if (id == mID) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.150 -0400", hash_original_method = "B50CD4B4D228C210BD89E9DF598807C7", hash_generated_method = "9FC7C4099F219EC2788411F048C048FB")
    protected View findViewWithTagTraversal(Object tag) {
        addTaint(tag.getTaint());
    if(tag != null && tag.equals(mTag))        
        {
View var72A74007B2BE62B849F475C7BDA4658B_1999618669 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1999618669.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1999618669;
        } //End block
View var540C13E9E156B687226421B24F2DF178_1868382729 =         null;
        var540C13E9E156B687226421B24F2DF178_1868382729.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1868382729;
        // ---------- Original Method ----------
        //if (tag != null && tag.equals(mTag)) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.151 -0400", hash_original_method = "65DA32C16954A521B825F7D31B571CEF", hash_generated_method = "1072867013B37E4B0FB600001CE39C8C")
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        addTaint(childToSkip.getTaint());
        addTaint(predicate.getTaint());
    if(predicate.apply(this))        
        {
View var72A74007B2BE62B849F475C7BDA4658B_394161272 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_394161272.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_394161272;
        } //End block
View var540C13E9E156B687226421B24F2DF178_1774784880 =         null;
        var540C13E9E156B687226421B24F2DF178_1774784880.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1774784880;
        // ---------- Original Method ----------
        //if (predicate.apply(this)) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.151 -0400", hash_original_method = "C8E06C0ED5E3D035BF7CE8B77FB6FB02", hash_generated_method = "574793D166F000FC27C4297F05F07111")
    public final View findViewById(int id) {
        addTaint(id);
    if(id < 0)        
        {
View var540C13E9E156B687226421B24F2DF178_813574626 =             null;
            var540C13E9E156B687226421B24F2DF178_813574626.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_813574626;
        } //End block
View var7A74F82C592A1D78CF473A9FA603E778_1196852761 =         findViewTraversal(id);
        var7A74F82C592A1D78CF473A9FA603E778_1196852761.addTaint(taint);
        return var7A74F82C592A1D78CF473A9FA603E778_1196852761;
        // ---------- Original Method ----------
        //if (id < 0) {
            //return null;
        //}
        //return findViewTraversal(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.152 -0400", hash_original_method = "DAB2723BE4C5F25FDBDAA56D4A941A95", hash_generated_method = "0D35BD2935D0F565A39FC34596FC8467")
    final View findViewByAccessibilityId(int accessibilityId) {
        addTaint(accessibilityId);
    if(accessibilityId < 0)        
        {
View var540C13E9E156B687226421B24F2DF178_237556898 =             null;
            var540C13E9E156B687226421B24F2DF178_237556898.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_237556898;
        } //End block
View var13B4F75B003B478760C64505CECBDEDC_404243750 =         findViewByAccessibilityIdTraversal(accessibilityId);
        var13B4F75B003B478760C64505CECBDEDC_404243750.addTaint(taint);
        return var13B4F75B003B478760C64505CECBDEDC_404243750;
        // ---------- Original Method ----------
        //if (accessibilityId < 0) {
            //return null;
        //}
        //return findViewByAccessibilityIdTraversal(accessibilityId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.152 -0400", hash_original_method = "0033D4DC027C6D84BC9CA79DB06FA7C7", hash_generated_method = "9EEB1EB8BC98F8A8229CFA12DE87FE41")
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        addTaint(accessibilityId);
    if(getAccessibilityViewId() == accessibilityId)        
        {
View var72A74007B2BE62B849F475C7BDA4658B_1606052973 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1606052973.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1606052973;
        } //End block
View var540C13E9E156B687226421B24F2DF178_1125241776 =         null;
        var540C13E9E156B687226421B24F2DF178_1125241776.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1125241776;
        // ---------- Original Method ----------
        //if (getAccessibilityViewId() == accessibilityId) {
            //return this;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.152 -0400", hash_original_method = "DB0D3478EC5FC406F90807706EB086DC", hash_generated_method = "D694E61AEB96F858A56BCA8E8565EE4D")
    public final View findViewWithTag(Object tag) {
        addTaint(tag.getTaint());
    if(tag == null)        
        {
View var540C13E9E156B687226421B24F2DF178_804623873 =             null;
            var540C13E9E156B687226421B24F2DF178_804623873.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_804623873;
        } //End block
View varC81F0BD6A25B6D77EAE74F7B5DBFB2EF_2151298 =         findViewWithTagTraversal(tag);
        varC81F0BD6A25B6D77EAE74F7B5DBFB2EF_2151298.addTaint(taint);
        return varC81F0BD6A25B6D77EAE74F7B5DBFB2EF_2151298;
        // ---------- Original Method ----------
        //if (tag == null) {
            //return null;
        //}
        //return findViewWithTagTraversal(tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.152 -0400", hash_original_method = "1599799F36C9F7803A0B97DCCA829DED", hash_generated_method = "5F60F5D5C86D86B0BEBAE392D4B15A5D")
    public final View findViewByPredicate(Predicate<View> predicate) {
        addTaint(predicate.getTaint());
View varF919CE02FFD44B0445DABEAE852654F6_1650816654 =         findViewByPredicateTraversal(predicate, null);
        varF919CE02FFD44B0445DABEAE852654F6_1650816654.addTaint(taint);
        return varF919CE02FFD44B0445DABEAE852654F6_1650816654;
        // ---------- Original Method ----------
        //return findViewByPredicateTraversal(predicate, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.154 -0400", hash_original_method = "485BA369E24687F2D5FF0693ABF816B2", hash_generated_method = "23ABC200B2FBDA5DF4B20BBF86DEAB1C")
    public final View findViewByPredicateInsideOut(View start, Predicate<View> predicate) {
        addTaint(predicate.getTaint());
        addTaint(start.getTaint());
        View childToSkip = null;
for(;;)
        {
            View view = start.findViewByPredicateTraversal(predicate, childToSkip);
    if(view != null || start == this)            
            {
View var057D265746AE9672AFE5F9FF6338071D_1394064425 =                 view;
                var057D265746AE9672AFE5F9FF6338071D_1394064425.addTaint(taint);
                return var057D265746AE9672AFE5F9FF6338071D_1394064425;
            } //End block
            ViewParent parent = start.getParent();
    if(parent == null || !(parent instanceof View))            
            {
View var540C13E9E156B687226421B24F2DF178_1972800757 =                 null;
                var540C13E9E156B687226421B24F2DF178_1972800757.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1972800757;
            } //End block
            childToSkip = start;
            start = (View) parent;
        } //End block
        // ---------- Original Method ----------
        //View childToSkip = null;
        //for (;;) {
            //View view = start.findViewByPredicateTraversal(predicate, childToSkip);
            //if (view != null || start == this) {
                //return view;
            //}
            //ViewParent parent = start.getParent();
            //if (parent == null || !(parent instanceof View)) {
                //return null;
            //}
            //childToSkip = start;
            //start = (View) parent;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.154 -0400", hash_original_method = "125195EB8F3EB02BBD72A4003F2E03BD", hash_generated_method = "491B6D8B484C16297DCBDA4E3A5ECCE1")
    public void setId(int id) {
        mID = id;
        // ---------- Original Method ----------
        //mID = id;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.154 -0400", hash_original_method = "B06467135FDA3C6D538127B3AC355349", hash_generated_method = "C360E63D178EE8D3FDB05ABF5AF04E49")
    public void setIsRootNamespace(boolean isRoot) {
        addTaint(isRoot);
    if(isRoot)        
        {
            mPrivateFlags |= IS_ROOT_NAMESPACE;
        } //End block
        else
        {
            mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        } //End block
        // ---------- Original Method ----------
        //if (isRoot) {
            //mPrivateFlags |= IS_ROOT_NAMESPACE;
        //} else {
            //mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.154 -0400", hash_original_method = "74A41C2D2B744E005149431B820C27E4", hash_generated_method = "1B149B6B2E82F8A70025109A4C28996E")
    public boolean isRootNamespace() {
        boolean var10437CF7D440B1B34C03831FB75AAB5C_1741548228 = ((mPrivateFlags&IS_ROOT_NAMESPACE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_141441861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_141441861;
        // ---------- Original Method ----------
        //return (mPrivateFlags&IS_ROOT_NAMESPACE) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.154 -0400", hash_original_method = "B0378653037A8E20BF93620A5E0AA660", hash_generated_method = "EEA276EA9420193FD286DBB87BFBD394")
    @ViewDebug.CapturedViewProperty
    public int getId() {
        int varF967916F035DAD625F94606212B89077_979618086 = (mID);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109403592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109403592;
        // ---------- Original Method ----------
        //return mID;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.155 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "EEA33EFF22BCEC3CC99ECE0B8A0BEB20")
    @ViewDebug.ExportedProperty
    public Object getTag() {
Object varD6A25044F8E609F6CD67330C1523D33D_680934302 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_680934302.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_680934302;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.156 -0400", hash_original_method = "8D2B18A079B1EE90519A06D435C647B9", hash_generated_method = "A88DBE9CF3CA0D1CB8F5AC3014136EA5")
    public void setTag(final Object tag) {
        mTag = tag;
        // ---------- Original Method ----------
        //mTag = tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.156 -0400", hash_original_method = "8295DF3154C0458AF2AF3A51D79A598B", hash_generated_method = "86504A3022473C9D92D5CCF388F65DE5")
    public Object getTag(int key) {
        addTaint(key);
    if(mKeyedTags != null)        
        {
Object var1E713A5D92F0B70048CD475E4B22F692_967398921 =         mKeyedTags.get(key);
        var1E713A5D92F0B70048CD475E4B22F692_967398921.addTaint(taint);
        return var1E713A5D92F0B70048CD475E4B22F692_967398921;
        }
Object var540C13E9E156B687226421B24F2DF178_604852188 =         null;
        var540C13E9E156B687226421B24F2DF178_604852188.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_604852188;
        // ---------- Original Method ----------
        //if (mKeyedTags != null) return mKeyedTags.get(key);
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.156 -0400", hash_original_method = "C739488AB1D92CB0D6B67C6D73AEF4DA", hash_generated_method = "8635D41108F6DE6433368F260175D127")
    public void setTag(int key, final Object tag) {
        addTaint(tag.getTaint());
        addTaint(key);
    if((key >>> 24) < 2)        
        {
            IllegalArgumentException var7524EDDAEEBAF47CBF14971391820A1B_298066929 = new IllegalArgumentException("The key must be an application-specific "
                    + "resource id.");
            var7524EDDAEEBAF47CBF14971391820A1B_298066929.addTaint(taint);
            throw var7524EDDAEEBAF47CBF14971391820A1B_298066929;
        } //End block
        setKeyedTag(key, tag);
        // ---------- Original Method ----------
        //if ((key >>> 24) < 2) {
            //throw new IllegalArgumentException("The key must be an application-specific "
                    //+ "resource id.");
        //}
        //setKeyedTag(key, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.156 -0400", hash_original_method = "5A92838330F5A71B83A0155FDDE52450", hash_generated_method = "0A723D6067DB04E48546B78B5C5482DF")
    public void setTagInternal(int key, Object tag) {
        addTaint(tag.getTaint());
        addTaint(key);
    if((key >>> 24) != 0x1)        
        {
            IllegalArgumentException var5DA18DC2D4F1C5D762FB5CF2806978F3_1786750592 = new IllegalArgumentException("The key must be a framework-specific "
                    + "resource id.");
            var5DA18DC2D4F1C5D762FB5CF2806978F3_1786750592.addTaint(taint);
            throw var5DA18DC2D4F1C5D762FB5CF2806978F3_1786750592;
        } //End block
        setKeyedTag(key, tag);
        // ---------- Original Method ----------
        //if ((key >>> 24) != 0x1) {
            //throw new IllegalArgumentException("The key must be a framework-specific "
                    //+ "resource id.");
        //}
        //setKeyedTag(key, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.157 -0400", hash_original_method = "0255761BE2D8372B1493AF7283C8F5B5", hash_generated_method = "75EFC44FE0BDC6709E109C2CB6715186")
    private void setKeyedTag(int key, Object tag) {
        addTaint(tag.getTaint());
        addTaint(key);
    if(mKeyedTags == null)        
        {
            mKeyedTags = new SparseArray<Object>();
        } //End block
        mKeyedTags.put(key, tag);
        // ---------- Original Method ----------
        //if (mKeyedTags == null) {
            //mKeyedTags = new SparseArray<Object>();
        //}
        //mKeyedTags.put(key, tag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.157 -0400", hash_original_method = "C5EE38E619F11A07C2A1169818F1E749", hash_generated_method = "6DEFEB0A97038FCBFB3D9098E26705BA")
    protected boolean dispatchConsistencyCheck(int consistency) {
        addTaint(consistency);
        boolean varDA1FC31B9B53FFD193B649EABF43C326_113708360 = (onConsistencyCheck(consistency));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149601894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149601894;
        // ---------- Original Method ----------
        //return onConsistencyCheck(consistency);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.159 -0400", hash_original_method = "2064C42F46AA0108673BA11B037AF3A0", hash_generated_method = "4F8CAEE4E8C485F94ED7E205E5433966")
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(consistency);
        boolean result = true;
        final boolean checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        final boolean checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
    if(checkLayout)        
        {
    if(getParent() == null)            
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " does not have a parent.");
            } //End block
    if(mAttachInfo == null)            
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " is not attached to a window.");
            } //End block
        } //End block
    if(checkDrawing)        
        {
    if((mPrivateFlags & DRAWN) != DRAWN &&
                    (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID)            
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " was invalidated but its drawing cache is valid.");
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_2027831198 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1701602878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1701602878;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.159 -0400", hash_original_method = "6F90E3DC82B178E80E1C9DDC98738197", hash_generated_method = "D147ED463C0B27338F948465FB673FC2")
    public void debug() {
        debug(0);
        // ---------- Original Method ----------
        //debug(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.161 -0400", hash_original_method = "3D5CB916992FEDBE62B11876DD1CF29A", hash_generated_method = "884BABAB839C143BA5BDDCAAF394E6BA")
    protected void debug(int depth) {
        addTaint(depth);
        String output = debugIndent(depth - 1);
        output += "+ " + this;
        int id = getId();
    if(id != -1)        
        {
            output += " (id=" + id + ")";
        } //End block
        Object tag = getTag();
    if(tag != null)        
        {
            output += " (tag=" + tag + ")";
        } //End block
        Log.d(VIEW_LOG_TAG, output);
    if((mPrivateFlags & FOCUSED) != 0)        
        {
            output = debugIndent(depth) + " FOCUSED";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";
        Log.d(VIEW_LOG_TAG, output);
    if(mPaddingLeft != 0 || mPaddingTop != 0 || mPaddingRight != 0
                || mPaddingBottom != 0)        
        {
            output = debugIndent(depth);
            output += "padding={" + mPaddingLeft + ", " + mPaddingTop
                    + ", " + mPaddingRight + ", " + mPaddingBottom + "}";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        output = debugIndent(depth);
        output += "mMeasureWidth=" + mMeasuredWidth +
                " mMeasureHeight=" + mMeasuredHeight;
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
    if(mLayoutParams == null)        
        {
            output += "BAD! no layout params";
        } //End block
        else
        {
            output = mLayoutParams.debug(output);
        } //End block
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
        output += "flags={";
        output += View.printFlags(mViewFlags);
        output += "}";
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
        output += "privateFlags={";
        output += View.printPrivateFlags(mPrivateFlags);
        output += "}";
        Log.d(VIEW_LOG_TAG, output);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        protected static String debugIndent(int depth) {
        StringBuilder spaces = new StringBuilder((depth * 2 + 3) * 2);
        for (int i = 0; i < (depth * 2) + 3; i++) {
            spaces.append(' ').append(' ');
        }
        return spaces.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.161 -0400", hash_original_method = "04C72C8D15A6DF3440AFF547FAD30ABA", hash_generated_method = "109B7960284A27B29146E69858907693")
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_347543674 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039810788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039810788;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.161 -0400", hash_original_method = "B7CE3104FF9ED0677BFFACD05F948960", hash_generated_method = "02B2D43609D93E7AEB3719C186901422")
    public void requestLayout() {
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        } //End block
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
    if(mParent != null)        
        {
    if(mLayoutParams != null)            
            {
                mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            } //End block
    if(!mParent.isLayoutRequested())            
            {
                mParent.requestLayout();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (ViewDebug.TRACE_HIERARCHY) {
            //ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        //}
        //mPrivateFlags |= FORCE_LAYOUT;
        //mPrivateFlags |= INVALIDATED;
        //if (mParent != null) {
            //if (mLayoutParams != null) {
                //mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            //}
            //if (!mParent.isLayoutRequested()) {
                //mParent.requestLayout();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.163 -0400", hash_original_method = "5F70867C98C203969EB162B4B724A790", hash_generated_method = "1F7ADA8EF52B745DA17A5F28CC890DA3")
    public void forceLayout() {
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        // ---------- Original Method ----------
        //mPrivateFlags |= FORCE_LAYOUT;
        //mPrivateFlags |= INVALIDATED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.163 -0400", hash_original_method = "26BA2349651C8679968382F6A84D9E92", hash_generated_method = "F73F2E54C14B082C708C31A396EB6A9C")
    public final void measure(int widthMeasureSpec, int heightMeasureSpec) {
    if((mPrivateFlags & FORCE_LAYOUT) == FORCE_LAYOUT ||
                widthMeasureSpec != mOldWidthMeasureSpec ||
                heightMeasureSpec != mOldHeightMeasureSpec)        
        {
            mPrivateFlags &= ~MEASURED_DIMENSION_SET;
    if(ViewDebug.TRACE_HIERARCHY)            
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_MEASURE);
            } //End block
            onMeasure(widthMeasureSpec, heightMeasureSpec);
    if((mPrivateFlags & MEASURED_DIMENSION_SET) != MEASURED_DIMENSION_SET)            
            {
                IllegalStateException var4406B44D36A5DEF1E7366917EA5EE02E_2009669302 = new IllegalStateException("onMeasure() did not set the"
                        + " measured dimension by calling"
                        + " setMeasuredDimension()");
                var4406B44D36A5DEF1E7366917EA5EE02E_2009669302.addTaint(taint);
                throw var4406B44D36A5DEF1E7366917EA5EE02E_2009669302;
            } //End block
            mPrivateFlags |= LAYOUT_REQUIRED;
        } //End block
        mOldWidthMeasureSpec = widthMeasureSpec;
        mOldHeightMeasureSpec = heightMeasureSpec;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.163 -0400", hash_original_method = "2024EA7D99B2D61F149E7A5A9BB7EB8E", hash_generated_method = "05759B14B32BA883F23EDE15B96E2AD1")
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        // ---------- Original Method ----------
        //setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                //getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.166 -0400", hash_original_method = "5AB327430FB1DFBD1DD895A1A32A2AA8", hash_generated_method = "8B2B36A03163D56C56910520694D78FC")
    protected final void setMeasuredDimension(int measuredWidth, int measuredHeight) {
        mMeasuredWidth = measuredWidth;
        mMeasuredHeight = measuredHeight;
        mPrivateFlags |= MEASURED_DIMENSION_SET;
        // ---------- Original Method ----------
        //mMeasuredWidth = measuredWidth;
        //mMeasuredHeight = measuredHeight;
        //mPrivateFlags |= MEASURED_DIMENSION_SET;
    }

    
        @DSModeled(DSC.SAFE)
    public static int combineMeasuredStates(int curState, int newState) {
        return curState | newState;
    }

    
        public static int resolveSize(int size, int measureSpec) {
        return resolveSizeAndState(size, measureSpec, 0) & MEASURED_SIZE_MASK;
    }

    
        public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize =  MeasureSpec.getSize(measureSpec);
        switch (specMode) {
        case MeasureSpec.UNSPECIFIED:
            result = size;
            break;
        case MeasureSpec.AT_MOST:
            if (specSize < size) {
                result = specSize | MEASURED_STATE_TOO_SMALL;
            } else {
                result = size;
            }
            break;
        case MeasureSpec.EXACTLY:
            result = specSize;
            break;
        }
        return result | (childMeasuredState&MEASURED_STATE_MASK);
    }

    
        public static int getDefaultSize(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        switch (specMode) {
        case MeasureSpec.UNSPECIFIED:
            result = size;
            break;
        case MeasureSpec.AT_MOST:
        case MeasureSpec.EXACTLY:
            result = specSize;
            break;
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.167 -0400", hash_original_method = "B59EA0BF10E69D3FFCA86CC30267F8DC", hash_generated_method = "A41E20DDFF4982372E1FA79B27321579")
    protected int getSuggestedMinimumHeight() {
        int suggestedMinHeight = mMinHeight;
    if(mBGDrawable != null)        
        {
            final int bgMinHeight = mBGDrawable.getMinimumHeight();
    if(suggestedMinHeight < bgMinHeight)            
            {
                suggestedMinHeight = bgMinHeight;
            } //End block
        } //End block
        int varBEA00719C8089A92827ACA20004245C4_1936935454 = (suggestedMinHeight);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874033949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1874033949;
        // ---------- Original Method ----------
        //int suggestedMinHeight = mMinHeight;
        //if (mBGDrawable != null) {
            //final int bgMinHeight = mBGDrawable.getMinimumHeight();
            //if (suggestedMinHeight < bgMinHeight) {
                //suggestedMinHeight = bgMinHeight;
            //}
        //}
        //return suggestedMinHeight;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.167 -0400", hash_original_method = "008B87CD2B3ED33B965CD69B13D61BFC", hash_generated_method = "A53D25374107E4D75CFAD4F823E106F4")
    protected int getSuggestedMinimumWidth() {
        int suggestedMinWidth = mMinWidth;
    if(mBGDrawable != null)        
        {
            final int bgMinWidth = mBGDrawable.getMinimumWidth();
    if(suggestedMinWidth < bgMinWidth)            
            {
                suggestedMinWidth = bgMinWidth;
            } //End block
        } //End block
        int var7C64000ECDB6740B2AED0BA7BF328D87_1982264047 = (suggestedMinWidth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309816015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309816015;
        // ---------- Original Method ----------
        //int suggestedMinWidth = mMinWidth;
        //if (mBGDrawable != null) {
            //final int bgMinWidth = mBGDrawable.getMinimumWidth();
            //if (suggestedMinWidth < bgMinWidth) {
                //suggestedMinWidth = bgMinWidth;
            //}
        //}
        //return suggestedMinWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.169 -0400", hash_original_method = "879BFA5FA0241047CB6974ED67682297", hash_generated_method = "A39DF7CE68D27AD1F832F37EFF38AC83")
    public void setMinimumHeight(int minHeight) {
        mMinHeight = minHeight;
        // ---------- Original Method ----------
        //mMinHeight = minHeight;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.169 -0400", hash_original_method = "CE129FBEAB6CCA0889899FF1E8E78A67", hash_generated_method = "94906ED9E91744BCBB1BA063108152BC")
    public void setMinimumWidth(int minWidth) {
        mMinWidth = minWidth;
        // ---------- Original Method ----------
        //mMinWidth = minWidth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.169 -0400", hash_original_method = "CDBB00D26F9C60D5F3E6B97847853936", hash_generated_method = "2A60177B958E3221D2ED988F43D96AED")
    public Animation getAnimation() {
Animation var576345169E506609FB9166758BB31DA1_1086744897 =         mCurrentAnimation;
        var576345169E506609FB9166758BB31DA1_1086744897.addTaint(taint);
        return var576345169E506609FB9166758BB31DA1_1086744897;
        // ---------- Original Method ----------
        //return mCurrentAnimation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.169 -0400", hash_original_method = "8B9244EE03042EB67F130AFDAD9A68F9", hash_generated_method = "2AA1B0AA3718014CF200153D5728A605")
    public void startAnimation(Animation animation) {
        addTaint(animation.getTaint());
        animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
        // ---------- Original Method ----------
        //animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        //setAnimation(animation);
        //invalidateParentCaches();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.169 -0400", hash_original_method = "743A148D3AA9DA63FB0D1635C16263C7", hash_generated_method = "6FE17EC5FB9E0594CBFC8DB82D778C7E")
    public void clearAnimation() {
    if(mCurrentAnimation != null)        
        {
            mCurrentAnimation.detach();
        } //End block
        mCurrentAnimation = null;
        invalidateParentIfNeeded();
        // ---------- Original Method ----------
        //if (mCurrentAnimation != null) {
            //mCurrentAnimation.detach();
        //}
        //mCurrentAnimation = null;
        //invalidateParentIfNeeded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.169 -0400", hash_original_method = "80992FCFACCF22F26EEB305124C3026E", hash_generated_method = "F3E70C5FD1473D27E94007273C220073")
    public void setAnimation(Animation animation) {
        mCurrentAnimation = animation;
    if(animation != null)        
        {
            animation.reset();
        } //End block
        // ---------- Original Method ----------
        //mCurrentAnimation = animation;
        //if (animation != null) {
            //animation.reset();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.171 -0400", hash_original_method = "AAD5AA561778224F71E3AF6921CD4105", hash_generated_method = "06D6C8F61FFE52559A40E6B98F790853")
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags |= ANIMATION_STARTED;
        // ---------- Original Method ----------
        //mPrivateFlags |= ANIMATION_STARTED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.171 -0400", hash_original_method = "F4AD81FC3499666E7AC93E3735AFEF8E", hash_generated_method = "05026BAADDDB17252B779F88E55782F5")
    protected void onAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mPrivateFlags &= ~ANIMATION_STARTED;
        // ---------- Original Method ----------
        //mPrivateFlags &= ~ANIMATION_STARTED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.171 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "F8D6AD4927E611641C230B29FA70C2C9")
    protected boolean onSetAlpha(int alpha) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(alpha);
        boolean var68934A3E9455FA72420237EB05902327_603838028 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1808918626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1808918626;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.171 -0400", hash_original_method = "A01500863A3F6668743C7034A9645220", hash_generated_method = "016BD767EF6A6DE1C57E374C7578C157")
    public boolean gatherTransparentRegion(Region region) {
        addTaint(region.getTaint());
        final AttachInfo attachInfo = mAttachInfo;
    if(region != null && attachInfo != null)        
        {
            final int pflags = mPrivateFlags;
    if((pflags & SKIP_DRAW) == 0)            
            {
                final int[] location = attachInfo.mTransparentLocation;
                getLocationInWindow(location);
                region.op(location[0], location[1], location[0] + mRight - mLeft,
                        location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            } //End block
            else
    if((pflags & ONLY_DRAWS_BACKGROUND) != 0 && mBGDrawable != null)            
            {
                applyDrawableToTransparentRegion(mBGDrawable, region);
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2021386016 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_242049990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_242049990;
        // ---------- Original Method ----------
        //final AttachInfo attachInfo = mAttachInfo;
        //if (region != null && attachInfo != null) {
            //final int pflags = mPrivateFlags;
            //if ((pflags & SKIP_DRAW) == 0) {
                //final int[] location = attachInfo.mTransparentLocation;
                //getLocationInWindow(location);
                //region.op(location[0], location[1], location[0] + mRight - mLeft,
                        //location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            //} else if ((pflags & ONLY_DRAWS_BACKGROUND) != 0 && mBGDrawable != null) {
                //applyDrawableToTransparentRegion(mBGDrawable, region);
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.171 -0400", hash_original_method = "92BFD91D600C047225F186391F6079B0", hash_generated_method = "EE56C572C537BBE209951B64A18D5597")
    public void playSoundEffect(int soundConstant) {
        addTaint(soundConstant);
    if(mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled())        
        {
            return;
        } //End block
        mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
        // ---------- Original Method ----------
        //if (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled()) {
            //return;
        //}
        //mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.172 -0400", hash_original_method = "75954C55ABC6CE5681E22BCDE96F4903", hash_generated_method = "30B6A0B314766A39B02BD6C53563D3D6")
    public boolean performHapticFeedback(int feedbackConstant) {
        addTaint(feedbackConstant);
        boolean var3E169FC783D629BB57ED9DE4B6A2EC51_629332353 = (performHapticFeedback(feedbackConstant, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1919373591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1919373591;
        // ---------- Original Method ----------
        //return performHapticFeedback(feedbackConstant, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.173 -0400", hash_original_method = "A19669526C11317AB6CCDC764945F176", hash_generated_method = "9F0BFE8F6973C5A28F1330240D4C09D6")
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        addTaint(flags);
        addTaint(feedbackConstant);
    if(mAttachInfo == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2104124418 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152975849 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_152975849;
        } //End block
    if((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                && !isHapticFeedbackEnabled())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1978134078 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068863901 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068863901;
        } //End block
        boolean var99BA8A57EA5C3723FE316D0990ED0845_1031300761 = (mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                (flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809492187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809492187;
        // ---------- Original Method ----------
        //if (mAttachInfo == null) {
            //return false;
        //}
        //if ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                //&& !isHapticFeedbackEnabled()) {
            //return false;
        //}
        //return mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                //(flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.173 -0400", hash_original_method = "1F6436CCBBD24CDC20D09B9CE44A0912", hash_generated_method = "3DC5256EF62DE90126E0C5DEDAB89525")
    public void setSystemUiVisibility(int visibility) {
    if(visibility != mSystemUiVisibility)        
        {
            mSystemUiVisibility = visibility;
    if(mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)            
            {
                mParent.recomputeViewAttributes(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (visibility != mSystemUiVisibility) {
            //mSystemUiVisibility = visibility;
            //if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
                //mParent.recomputeViewAttributes(this);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.173 -0400", hash_original_method = "FA02CCE186B627C6CF56D55D5156174E", hash_generated_method = "5A10261224449A21C3D6E05EB14D8F98")
    public int getSystemUiVisibility() {
        int varD03AF504A7FB8D1F39097D83B42BDFFD_1187117036 = (mSystemUiVisibility);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311333081 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311333081;
        // ---------- Original Method ----------
        //return mSystemUiVisibility;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.173 -0400", hash_original_method = "1911D5DDAC8087DF02FDB915711E3D30", hash_generated_method = "5EA40FB72F7862ED99FF6B894F225AF6")
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        addTaint(l.getTaint());
        getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
    if(mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)        
        {
            mParent.recomputeViewAttributes(this);
        } //End block
        // ---------- Original Method ----------
        //getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
        //if (mParent != null && mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            //mParent.recomputeViewAttributes(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.173 -0400", hash_original_method = "31A60EE50D18A3986849FF003231E28E", hash_generated_method = "001CB53A4401C32ADDE2E9BACA79FCC4")
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        addTaint(visibility);
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnSystemUiVisibilityChangeListener != null)        
        {
            li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        } //End block
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnSystemUiVisibilityChangeListener != null) {
            //li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    //visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.174 -0400", hash_original_method = "BE707BAA551F425B19E1E4FBE454F716", hash_generated_method = "17983415C75AF49164B86781D1E36E30")
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        addTaint(localChanges);
        addTaint(localValue);
        int val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
    if(val != mSystemUiVisibility)        
        {
            setSystemUiVisibility(val);
        } //End block
        // ---------- Original Method ----------
        //int val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
        //if (val != mSystemUiVisibility) {
            //setSystemUiVisibility(val);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.175 -0400", hash_original_method = "F914DF1AC479022C6AA4BFD6DD1247D7", hash_generated_method = "164FF2C2A2E2B3E8605DB3628CE2AD14")
    public final boolean startDrag(ClipData data, DragShadowBuilder shadowBuilder,
            Object myLocalState, int flags) {
        addTaint(flags);
        addTaint(myLocalState.getTaint());
        addTaint(shadowBuilder.getTaint());
        addTaint(data.getTaint());
    if(ViewDebug.DEBUG_DRAG)        
        {
            Log.d(VIEW_LOG_TAG, "startDrag: data=" + data + " flags=" + flags);
        } //End block
        boolean okay = false;
        Point shadowSize = new Point();
        Point shadowTouchPoint = new Point();
        shadowBuilder.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
    if((shadowSize.x < 0) || (shadowSize.y < 0) ||
                (shadowTouchPoint.x < 0) || (shadowTouchPoint.y < 0))        
        {
            IllegalStateException var3AF94414FFB32B63DAF62EEA64DB9D42_433394827 = new IllegalStateException("Drag shadow dimensions must not be negative");
            var3AF94414FFB32B63DAF62EEA64DB9D42_433394827.addTaint(taint);
            throw var3AF94414FFB32B63DAF62EEA64DB9D42_433394827;
        } //End block
    if(ViewDebug.DEBUG_DRAG)        
        {
            Log.d(VIEW_LOG_TAG, "drag shadow: width=" + shadowSize.x + " height=" + shadowSize.y
                    + " shadowX=" + shadowTouchPoint.x + " shadowY=" + shadowTouchPoint.y);
        } //End block
        Surface surface = new Surface();
        try 
        {
            IBinder token = mAttachInfo.mSession.prepareDrag(mAttachInfo.mWindow,
                    flags, shadowSize.x, shadowSize.y, surface);
    if(ViewDebug.DEBUG_DRAG)            
            Log.d(VIEW_LOG_TAG, "prepareDrag returned token=" + token
                    + " surface=" + surface);
    if(token != null)            
            {
                Canvas canvas = surface.lockCanvas(null);
                try 
                {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    shadowBuilder.onDrawShadow(canvas);
                } //End block
                finally 
                {
                    surface.unlockCanvasAndPost(canvas);
                } //End block
                final ViewRootImpl root = getViewRootImpl();
                root.setLocalDragState(myLocalState);
                root.getLastTouchPoint(shadowSize);
                okay = mAttachInfo.mSession.performDrag(mAttachInfo.mWindow, token,
                        shadowSize.x, shadowSize.y,
                        shadowTouchPoint.x, shadowTouchPoint.y, data);
    if(ViewDebug.DEBUG_DRAG)                
                Log.d(VIEW_LOG_TAG, "performDrag returned " + okay);
                surface.release();
            } //End block
        } //End block
        catch (Exception e)
        {
            surface.destroy();
        } //End block
        boolean varDF8FEDE7FF71608E24A5576326E41C75_189315664 = (okay);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072855222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072855222;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.175 -0400", hash_original_method = "7E645D896E88F7A2CE991A302B5729A7", hash_generated_method = "2F04FDE26105CD7A76E0949069FB839E")
    public boolean onDragEvent(DragEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_440781626 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198224688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_198224688;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.175 -0400", hash_original_method = "2E7102A43746FEAE9D11C37FDA834A21", hash_generated_method = "604A75D3B9DCA85A18BAD3AF69D8D378")
    public boolean dispatchDragEvent(DragEvent event) {
        addTaint(event.getTaint());
        ListenerInfo li = mListenerInfo;
    if(li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnDragListener.onDrag(this, event))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_928423900 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700895252 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_700895252;
        } //End block
        boolean var3F5C47311102D9E7DA8D160D2C43921F_1605405222 = (onDragEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107614118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_107614118;
        // ---------- Original Method ----------
        //ListenerInfo li = mListenerInfo;
        //if (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                //&& li.mOnDragListener.onDrag(this, event)) {
            //return true;
        //}
        //return onDragEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.175 -0400", hash_original_method = "C990D75777DFB098F96F21BE433F897F", hash_generated_method = "A2B5E36286C013CA9FFBBC562BF8DF30")
     boolean canAcceptDrag() {
        boolean var010ACAE98CBCB96C4958A9F7092258BF_376498937 = ((mPrivateFlags2 & DRAG_CAN_ACCEPT) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243619588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_243619588;
        // ---------- Original Method ----------
        //return (mPrivateFlags2 & DRAG_CAN_ACCEPT) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.176 -0400", hash_original_method = "059265693C3FBF9CA8D6100876A0DA7C", hash_generated_method = "4027BFE56A9421810369202A60B7D2BD")
    public void onCloseSystemDialogs(String reason) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.177 -0400", hash_original_method = "14C9DBE3395E98A8750BC15A93AD3A45", hash_generated_method = "5BD6A3D03A8E6B6025331D1A47E35440")
    public void applyDrawableToTransparentRegion(Drawable dr, Region region) {
        addTaint(region.getTaint());
        addTaint(dr.getTaint());
    if(DBG)        
        {
        } //End block
        final Region r = dr.getTransparentRegion();
        final Rect db = dr.getBounds();
        final AttachInfo attachInfo = mAttachInfo;
    if(r != null && attachInfo != null)        
        {
            final int w = getRight()-getLeft();
            final int h = getBottom()-getTop();
    if(db.left > 0)            
            {
                r.op(0, 0, db.left, h, Region.Op.UNION);
            } //End block
    if(db.right < w)            
            {
                r.op(db.right, 0, w, h, Region.Op.UNION);
            } //End block
    if(db.top > 0)            
            {
                r.op(0, 0, w, db.top, Region.Op.UNION);
            } //End block
    if(db.bottom < h)            
            {
                r.op(0, db.bottom, w, h, Region.Op.UNION);
            } //End block
            final int[] location = attachInfo.mTransparentLocation;
            getLocationInWindow(location);
            r.translate(location[0], location[1]);
            region.op(r, Region.Op.INTERSECT);
        } //End block
        else
        {
            region.op(db, Region.Op.DIFFERENCE);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.178 -0400", hash_original_method = "3A330A3DE83C0EE0C70042D452F74FC4", hash_generated_method = "87556D2FAAD7BFCB3ADDC7B21CAAE8AF")
    private void checkForLongClick(int delayOffset) {
        addTaint(delayOffset);
    if((mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE)        
        {
            mHasPerformedLongPress = false;
    if(mPendingCheckForLongPress == null)            
            {
                mPendingCheckForLongPress = new CheckForLongPress();
            } //End block
            mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForLongPress,
                    ViewConfiguration.getLongPressTimeout() - delayOffset);
        } //End block
        // ---------- Original Method ----------
        //if ((mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) {
            //mHasPerformedLongPress = false;
            //if (mPendingCheckForLongPress == null) {
                //mPendingCheckForLongPress = new CheckForLongPress();
            //}
            //mPendingCheckForLongPress.rememberWindowAttachCount();
            //postDelayed(mPendingCheckForLongPress,
                    //ViewConfiguration.getLongPressTimeout() - delayOffset);
        //}
    }

    
        public static View inflate(Context context, int resource, ViewGroup root) {
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, root);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.180 -0400", hash_original_method = "5E47C984391EE91860CD25320EB410A4", hash_generated_method = "A67EA747D10AB2C727A6D5B69F30BA1F")
    @SuppressWarnings({"UnusedParameters"})
    protected boolean overScrollBy(int deltaX, int deltaY,
            int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY,
            int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent) {
        addTaint(isTouchEvent);
        addTaint(maxOverScrollY);
        addTaint(maxOverScrollX);
        addTaint(scrollRangeY);
        addTaint(scrollRangeX);
        addTaint(scrollY);
        addTaint(scrollX);
        addTaint(deltaY);
        addTaint(deltaX);
        final int overScrollMode = mOverScrollMode;
        final boolean canScrollHorizontal = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        final boolean canScrollVertical = computeVerticalScrollRange() > computeVerticalScrollExtent();
        final boolean overScrollHorizontal = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollHorizontal);
        final boolean overScrollVertical = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollVertical);
        int newScrollX = scrollX + deltaX;
    if(!overScrollHorizontal)        
        {
            maxOverScrollX = 0;
        } //End block
        int newScrollY = scrollY + deltaY;
    if(!overScrollVertical)        
        {
            maxOverScrollY = 0;
        } //End block
        final int left = -maxOverScrollX;
        final int right = maxOverScrollX + scrollRangeX;
        final int top = -maxOverScrollY;
        final int bottom = maxOverScrollY + scrollRangeY;
        boolean clampedX = false;
    if(newScrollX > right)        
        {
            newScrollX = right;
            clampedX = true;
        } //End block
        else
    if(newScrollX < left)        
        {
            newScrollX = left;
            clampedX = true;
        } //End block
        boolean clampedY = false;
    if(newScrollY > bottom)        
        {
            newScrollY = bottom;
            clampedY = true;
        } //End block
        else
    if(newScrollY < top)        
        {
            newScrollY = top;
            clampedY = true;
        } //End block
        onOverScrolled(newScrollX, newScrollY, clampedX, clampedY);
        boolean varBAEAA8C3A9306118E868B194D60DDE3A_1554127418 = (clampedX || clampedY);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168382358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168382358;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.180 -0400", hash_original_method = "4CE95B84751ED417CECEABF7E9F1BBA1", hash_generated_method = "7015CEF17633EFF64491C6EA8A04C360")
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(clampedY);
        addTaint(clampedX);
        addTaint(scrollY);
        addTaint(scrollX);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.180 -0400", hash_original_method = "89CDC9D85B7569FFDF89FB6E096C8833", hash_generated_method = "7BBA6FB4319A1FF88DEACF901303F2B7")
    public int getOverScrollMode() {
        int varA3201A672D71DD5A79F87DF520AF188A_1622826629 = (mOverScrollMode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026112873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2026112873;
        // ---------- Original Method ----------
        //return mOverScrollMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.181 -0400", hash_original_method = "D7A7F397651806FFF8FA254EEF23303B", hash_generated_method = "59A7DC9F33037F7C06B65236D4D26A73")
    public void setOverScrollMode(int overScrollMode) {
    if(overScrollMode != OVER_SCROLL_ALWAYS &&
                overScrollMode != OVER_SCROLL_IF_CONTENT_SCROLLS &&
                overScrollMode != OVER_SCROLL_NEVER)        
        {
            IllegalArgumentException var959B9B86C0F33D877ECE138932256AFB_2135910626 = new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
            var959B9B86C0F33D877ECE138932256AFB_2135910626.addTaint(taint);
            throw var959B9B86C0F33D877ECE138932256AFB_2135910626;
        } //End block
        mOverScrollMode = overScrollMode;
        // ---------- Original Method ----------
        //if (overScrollMode != OVER_SCROLL_ALWAYS &&
                //overScrollMode != OVER_SCROLL_IF_CONTENT_SCROLLS &&
                //overScrollMode != OVER_SCROLL_NEVER) {
            //throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        //}
        //mOverScrollMode = overScrollMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.182 -0400", hash_original_method = "9CF1D38E8E376FF50D8C64A9F9733663", hash_generated_method = "33A89669C8676C8A3BF0DBDD045450B7")
    protected float getVerticalScrollFactor() {
    if(mVerticalScrollFactor == 0)        
        {
            TypedValue outValue = new TypedValue();
    if(!mContext.getTheme().resolveAttribute(
                    com.android.internal.R.attr.listPreferredItemHeight, outValue, true))            
            {
                IllegalStateException var29C964C2BBE483DA47B8C67D058FB597_1304247163 = new IllegalStateException(
                        "Expected theme to define listPreferredItemHeight.");
                var29C964C2BBE483DA47B8C67D058FB597_1304247163.addTaint(taint);
                throw var29C964C2BBE483DA47B8C67D058FB597_1304247163;
            } //End block
            mVerticalScrollFactor = outValue.getDimension(
                    mContext.getResources().getDisplayMetrics());
        } //End block
        float var790487E83CF3B009D444C02267049200_1452101138 = (mVerticalScrollFactor);
                float var546ADE640B6EDFBC8A086EF31347E768_1565004018 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1565004018;
        // ---------- Original Method ----------
        //if (mVerticalScrollFactor == 0) {
            //TypedValue outValue = new TypedValue();
            //if (!mContext.getTheme().resolveAttribute(
                    //com.android.internal.R.attr.listPreferredItemHeight, outValue, true)) {
                //throw new IllegalStateException(
                        //"Expected theme to define listPreferredItemHeight.");
            //}
            //mVerticalScrollFactor = outValue.getDimension(
                    //mContext.getResources().getDisplayMetrics());
        //}
        //return mVerticalScrollFactor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.182 -0400", hash_original_method = "E54E00038FC64298D390BA41C98DC1D8", hash_generated_method = "FB1B6068B3B00EB8C69DF495E1F8DB03")
    protected float getHorizontalScrollFactor() {
        float varB74833E73F2FE02575797FF78DC9E0C1_583760565 = (getVerticalScrollFactor());
                float var546ADE640B6EDFBC8A086EF31347E768_931969822 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_931969822;
        // ---------- Original Method ----------
        //return getVerticalScrollFactor();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.182 -0400", hash_original_method = "66C84E939C2024746D4813377EE28DA8", hash_generated_method = "B31B315F4F0CDC04E5F90BBBFE554276")
    public int getTextDirection() {
        int varEABB83A13F5203725522D66DBC3AF7E5_266427383 = (mTextDirection);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653445479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1653445479;
        // ---------- Original Method ----------
        //return mTextDirection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.182 -0400", hash_original_method = "A0414376D9ECFBC599F5D349FFC72987", hash_generated_method = "84B9F2CE731D55CDBEDA176FFE47F874")
    public void setTextDirection(int textDirection) {
    if(textDirection != mTextDirection)        
        {
            mTextDirection = textDirection;
            resetResolvedTextDirection();
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (textDirection != mTextDirection) {
            //mTextDirection = textDirection;
            //resetResolvedTextDirection();
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.182 -0400", hash_original_method = "99501F3EA14EF54863B388ACFA67B227", hash_generated_method = "678B87AAD77B6AFE83A6B3EABA4625C1")
    public int getResolvedTextDirection() {
    if(mResolvedTextDirection == TEXT_DIRECTION_INHERIT)        
        {
            resolveTextDirection();
        } //End block
        int varC089C6BBD25CC5A0856604CC6469CEF8_1876471139 = (mResolvedTextDirection);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182893162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182893162;
        // ---------- Original Method ----------
        //if (mResolvedTextDirection == TEXT_DIRECTION_INHERIT) {
            //resolveTextDirection();
        //}
        //return mResolvedTextDirection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.184 -0400", hash_original_method = "DF8FC39519D36B1AC7371F6D87C199FC", hash_generated_method = "D8B1BCA60FECB24861BF3D9FF5A4F76D")
    protected void resolveTextDirection() {
    if(mTextDirection != TEXT_DIRECTION_INHERIT)        
        {
            mResolvedTextDirection = mTextDirection;
            return;
        } //End block
    if(mParent != null && mParent instanceof ViewGroup)        
        {
            mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
            return;
        } //End block
        mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
        // ---------- Original Method ----------
        //if (mTextDirection != TEXT_DIRECTION_INHERIT) {
            //mResolvedTextDirection = mTextDirection;
            //return;
        //}
        //if (mParent != null && mParent instanceof ViewGroup) {
            //mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
            //return;
        //}
        //mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.184 -0400", hash_original_method = "BB79EF6AB24983F71C49AA466BBC15FC", hash_generated_method = "7309B27E3B8E0EA585A6CF1593E51E30")
    protected void resetResolvedTextDirection() {
        mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
        // ---------- Original Method ----------
        //mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.184 -0400", hash_original_method = "AF21ED671E180E70DBE0B7255059F75E", hash_generated_method = "9A6BA26B98FE57B58A6B05E019D06035")
    public void hackTurnOffWindowResizeAnim(boolean off) {
        mAttachInfo.mTurnOffWindowResizeAnim = off;
        // ---------- Original Method ----------
        //mAttachInfo.mTurnOffWindowResizeAnim = off;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.184 -0400", hash_original_method = "E195CA02B57C3CA07D3D00B98A2A4177", hash_generated_method = "BDA36158EBA81C0133200DAE9B815248")
    public ViewPropertyAnimator animate() {
    if(mAnimator == null)        
        {
            mAnimator = new ViewPropertyAnimator(this);
        } //End block
ViewPropertyAnimator var0904F24F3F5742670FBC5DCC12499E09_1491883338 =         mAnimator;
        var0904F24F3F5742670FBC5DCC12499E09_1491883338.addTaint(taint);
        return var0904F24F3F5742670FBC5DCC12499E09_1491883338;
        // ---------- Original Method ----------
        //if (mAnimator == null) {
            //mAnimator = new ViewPropertyAnimator(this);
        //}
        //return mAnimator;
    }

    
    static class TransformationInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "01A5A714698019F46F7B3BE18D3A81EF", hash_generated_field = "D632FEE6EB1660D61E8B851D372C57FD")

        private final Matrix mMatrix = new Matrix();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "892FD7717D9FE700C26A99B107E83D2D", hash_generated_field = "5F11E3B225AB20CA6908F99BD2DCCD69")

        private Matrix mInverseMatrix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "E6AF1B5575F48589B11F67F181886D00", hash_generated_field = "39319A786965FE4B527A01145F904472")

        boolean mMatrixDirty = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "DFB8A8C1AC71929285F6E9C21422BD39", hash_generated_field = "0D5DDC0830CE5F8AD2A6C72FEF2EE898")

        private boolean mInverseMatrixDirty = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "91D62B45A9A6983F3FF66229817A7939", hash_generated_field = "067E11491097A23D40918282A928EBA9")

        private boolean mMatrixIsIdentity = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "114805850A4BFF346FD6EAF00216606F", hash_generated_field = "EDD47554C3CEE3D946B262053B454BFB")

        private Camera mCamera = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.185 -0400", hash_original_field = "CC31A142BE3901700F0A5BABD448641D", hash_generated_field = "19CC34893873FBEA96612C704706273A")

        private Matrix matrix3D = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "0E1D00ACFA6A3EE1137A1995B4598449", hash_generated_field = "888097DA3FEAC04F59E84914FC3B299F")

        private int mPrevWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "B16CB4E01E2F0EC3C3D762413BCFA3EA", hash_generated_field = "3F17D196FD1B71E4E9A79484B73B3DC2")

        private int mPrevHeight = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "8461EF13A0961B85C57153ADEACDA2AF", hash_generated_field = "5BFF8D9CD2F407BBEC3BAA9D3113E814")

        @ViewDebug.ExportedProperty float mRotationY = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "91D13B8ABAABE76FB1A1DB257483240D", hash_generated_field = "1773CD64DE2B81950EEC26683C7BFC12")

        @ViewDebug.ExportedProperty float mRotationX = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "3EA2C3E9FA82D448BC8E393E6731068D", hash_generated_field = "CBCF8195E197871A173AFD82B249BEE8")

        @ViewDebug.ExportedProperty float mRotation = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "FC3C2A4E393ED24A270EF0FBD816080B", hash_generated_field = "7E653D53DDF7B3176405F85A676F9E8E")

        @ViewDebug.ExportedProperty float mTranslationX = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "48CC9A3909395E2C748DF341969B13EE", hash_generated_field = "477946415FF37E50D7898E1A45EA53F2")

        @ViewDebug.ExportedProperty float mTranslationY = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "76B60FCE9805D699B1614259B56C0AB4", hash_generated_field = "39698B539B591C7643D57DD23054914D")

        @ViewDebug.ExportedProperty float mScaleX = 1f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "63BF484C692B6E739EBA4C830C8776F0", hash_generated_field = "37E347D4565A795C12A91CA0C0BB20C1")

        @ViewDebug.ExportedProperty float mScaleY = 1f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "64048540B5D91324BCD1C40B4709FFB9", hash_generated_field = "C294D047888DF6C232DB6BC89AB6C1DE")

        @ViewDebug.ExportedProperty float mPivotX = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "802D68E29E0889774E6BCE439C574FF3", hash_generated_field = "65227B6A59140FE7F7093243C8409FD1")

        @ViewDebug.ExportedProperty float mPivotY = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.186 -0400", hash_original_field = "14E45EEE3993C8F9A0BE01602FD0F58C", hash_generated_field = "3F07B4C8BDBAF8B8C3DFBAA769694247")

        @ViewDebug.ExportedProperty float mAlpha = 1f;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_method = "047CC1B263AEE84E056E34E366D57D72", hash_generated_method = "047CC1B263AEE84E056E34E366D57D72")
        public TransformationInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static class ListenerInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "5EDF09010D7E466461FD8808B8CD4E69", hash_generated_field = "E3E0A2AA3DAD3D497FEC69653B249F3D")

        protected OnFocusChangeListener mOnFocusChangeListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "80A99C2B2F1995E5AD3272A74B10D327", hash_generated_field = "3E61511956959B716B0660A267A5DDB6")

        private ArrayList<OnLayoutChangeListener> mOnLayoutChangeListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "0929A78505E1C2FDC3DC86E818DAF2F7", hash_generated_field = "7FB9E86C55D3FC29D5ABA87F653B7F5E")

        private CopyOnWriteArrayList<OnAttachStateChangeListener> mOnAttachStateChangeListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "65DB77DAF20E9BC1F7135E1B0259ED25")

        public OnClickListener mOnClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "1F048D1AF1E6F6E42591AF652558180F", hash_generated_field = "5EAF3560EF7F9BB7565DBDF37FE7A2AA")

        protected OnLongClickListener mOnLongClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "6996D732079774CBDC0064D12CA733BA", hash_generated_field = "ADA44730A1380CB9786AA8F8DC39301D")

        protected OnCreateContextMenuListener mOnCreateContextMenuListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

        private OnKeyListener mOnKeyListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "E3CF51F249FF4488CF47961A962A84DF", hash_generated_field = "538D6DAEFDEDFC1E31809D314A35E30B")

        private OnTouchListener mOnTouchListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "3DD3E58D944D15D906FC81C9FFCDF4EB", hash_generated_field = "9960EE08CE022E6057B016EBE9068862")

        private OnHoverListener mOnHoverListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "1E80FECA9E68B33E73223CA0C1DB09A3", hash_generated_field = "6F0FC6D93F2673180702A6C98E43EB3F")

        private OnGenericMotionListener mOnGenericMotionListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "F02B5B95401314D0E43EFCAB5D8909E7", hash_generated_field = "BB6976B05A50BD6226C5F3224361BE75")

        private OnDragListener mOnDragListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "99F78B64D05DD39CB96527A5F31D1B1F", hash_generated_field = "BCD3219BF0AB6E6E91E075D0ABDA8C97")

        private OnSystemUiVisibilityChangeListener mOnSystemUiVisibilityChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_method = "30D31F497118E5B2F2D60734B7298038", hash_generated_method = "30D31F497118E5B2F2D60734B7298038")
        public ListenerInfo ()
        {
            //Synthesized constructor
        }


    }


    
    public static class DragShadowBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "08E85E83D778EC246746E6855B21BE82")

        private WeakReference<View> mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.187 -0400", hash_original_method = "0B0DC4A9FB3A9C12A7904682E22ADAD8", hash_generated_method = "1DC795717C9F5A625AFA7215FE485718")
        public  DragShadowBuilder(View view) {
            mView = new WeakReference<View>(view);
            // ---------- Original Method ----------
            //mView = new WeakReference<View>(view);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.188 -0400", hash_original_method = "39157EB374747DFD28056DCE3D5D84EC", hash_generated_method = "1653C54FAA06D8A2D8309AF09F1D8648")
        public  DragShadowBuilder() {
            mView = new WeakReference<View>(null);
            // ---------- Original Method ----------
            //mView = new WeakReference<View>(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.188 -0400", hash_original_method = "12EFA38B650211F3F0DA583E081C360F", hash_generated_method = "D02B4F9D2806CDDC5805E8D177A39656")
        @SuppressWarnings({"JavadocReference"})
        final public View getView() {
View varDA4366AEE4EA0BBB6014EFE0812F7F53_475441721 =             mView.get();
            varDA4366AEE4EA0BBB6014EFE0812F7F53_475441721.addTaint(taint);
            return varDA4366AEE4EA0BBB6014EFE0812F7F53_475441721;
            // ---------- Original Method ----------
            //return mView.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.188 -0400", hash_original_method = "7C575AFDC5B7223F530AD0DF57B52E75", hash_generated_method = "CAE5B9535B333EA220A83C3E183076BF")
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(shadowTouchPoint.getTaint());
            addTaint(shadowSize.getTaint());
            final View view = mView.get();
    if(view != null)            
            {
                shadowSize.set(view.getWidth(), view.getHeight());
                shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            } //End block
            else
            {
            } //End block
            // ---------- Original Method ----------
            //final View view = mView.get();
            //if (view != null) {
                //shadowSize.set(view.getWidth(), view.getHeight());
                //shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            //} else {
                //Log.e(View.VIEW_LOG_TAG, "Asked for drag thumb metrics but no view");
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_method = "F5A2B90321F064D0A4C62262ED411079", hash_generated_method = "1F28F23D720D337912554CDB1FD14A5F")
        public void onDrawShadow(Canvas canvas) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(canvas.getTaint());
            final View view = mView.get();
    if(view != null)            
            {
                view.draw(canvas);
            } //End block
            else
            {
            } //End block
            // ---------- Original Method ----------
            //final View view = mView.get();
            //if (view != null) {
                //view.draw(canvas);
            //} else {
                //Log.e(View.VIEW_LOG_TAG, "Asked to draw drag shadow but no view");
            //}
        }

        
    }


    
    public static class MeasureSpec {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_method = "2EA619F0F89BA048B9092F3C9EFB9775", hash_generated_method = "2EA619F0F89BA048B9092F3C9EFB9775")
        public MeasureSpec ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
        public static int makeMeasureSpec(int size, int mode) {
            return size + mode;
        }

        
                @DSModeled(DSC.SAFE)
        public static int getMode(int measureSpec) {
            return (measureSpec & MODE_MASK);
        }

        
                @DSModeled(DSC.SAFE)
        public static int getSize(int measureSpec) {
            return (measureSpec & ~MODE_MASK);
        }

        
                public static String toString(int measureSpec) {
            int mode = getMode(measureSpec);
            int size = getSize(measureSpec);
            StringBuilder sb = new StringBuilder("MeasureSpec: ");
            if (mode == UNSPECIFIED)
                sb.append("UNSPECIFIED ");
            else if (mode == EXACTLY)
                sb.append("EXACTLY ");
            else if (mode == AT_MOST)
                sb.append("AT_MOST ");
            else
                sb.append(mode).append(" ");
            sb.append(size);
            return sb.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_field = "2765924A26051A383644CD53D86A0033", hash_generated_field = "7E13FB3629EDD21F2BB56B2286490FD6")

        private static final int MODE_SHIFT = 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_field = "52AD9C81A7DF8D66D374004C50CC933D", hash_generated_field = "528C4AF1BEE1BC62589DFB30A7C1B2F3")

        private static final int MODE_MASK = 0x3 << MODE_SHIFT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_field = "3E92AA0FE7738A8CA58BD3891BC70636", hash_generated_field = "A67A5415D6CD099BE0676E65CF93997F")

        public static final int UNSPECIFIED = 0 << MODE_SHIFT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_field = "28026BF47C29664BEB4B773976B4D4D7", hash_generated_field = "89B436B79BB9AD4BDF272AC596A5C764")

        public static final int EXACTLY     = 1 << MODE_SHIFT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.189 -0400", hash_original_field = "0920EC621B50E1BCDC08E0162D119463", hash_generated_field = "29BD87BC74A43396432B999614D66E82")

        public static final int AT_MOST     = 2 << MODE_SHIFT;
    }


    
    class CheckForLongPress implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.190 -0400", hash_original_field = "FECF4FD7C8A3DE72E8F25B320193017C", hash_generated_field = "440C867B7432C58C78CA96D4BD4198E7")

        private int mOriginalWindowAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.190 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.193 -0400", hash_original_method = "01CD5F3DDC5391038879A6F141003B2C", hash_generated_method = "23F48C0EC92F38B176EC9E029E3AFF84")
        public void run() {
    if(isPressed() && (mParent != null)
                    && mOriginalWindowAttachCount == mWindowAttachCount)            
            {
    if(performLongClick())                
                {
                    mHasPerformedLongPress = true;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (isPressed() && (mParent != null)
                    //&& mOriginalWindowAttachCount == mWindowAttachCount) {
                //if (performLongClick()) {
                    //mHasPerformedLongPress = true;
                //}
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.193 -0400", hash_original_method = "52714AB9B90C75C7141A8D07DDC0C4CA", hash_generated_method = "AB01C47E8931054C927C8BF677A5865E")
        public void rememberWindowAttachCount() {
            mOriginalWindowAttachCount = mWindowAttachCount;
            // ---------- Original Method ----------
            //mOriginalWindowAttachCount = mWindowAttachCount;
        }

        
    }


    
    private final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.193 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.193 -0400", hash_original_method = "8B4AC781B811E80364C995C3750D80D8", hash_generated_method = "AB19EB04DF28937B1DF516E63AC74EFA")
        public void run() {
            mPrivateFlags &= ~PREPRESSED;
            mPrivateFlags |= PRESSED;
            refreshDrawableState();
            checkForLongClick(ViewConfiguration.getTapTimeout());
            // ---------- Original Method ----------
            //mPrivateFlags &= ~PREPRESSED;
            //mPrivateFlags |= PRESSED;
            //refreshDrawableState();
            //checkForLongClick(ViewConfiguration.getTapTimeout());
        }

        
    }


    
    private final class PerformClick implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.194 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.194 -0400", hash_original_method = "566460B544C528A9D4CEF77A7D21BD20", hash_generated_method = "6E0C9FA1A1110473D753CE2E91D91FD7")
        public void run() {
            performClick();
            // ---------- Original Method ----------
            //performClick();
        }

        
    }


    
    private final class UnsetPressedState implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.194 -0400", hash_original_method = "6C14B43BA30389F098070D93AD09F5B4", hash_generated_method = "6C14B43BA30389F098070D93AD09F5B4")
        public UnsetPressedState ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.194 -0400", hash_original_method = "8ADFD7FB5655235FFF1C14FE5EF3EDC3", hash_generated_method = "51E5C56E0FC59533122E120E30019564")
        public void run() {
            setPressed(false);
            // ---------- Original Method ----------
            //setPressed(false);
        }

        
    }


    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.194 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "EE939DE64E4E13C6649033F638632686")
        public  BaseSavedState(Parcel source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.194 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "E01D93B6DF9621DF15B2FA6FE9F6F642")
        public  BaseSavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "F69D27D6C01716FC1482B26F47E53A23", hash_generated_field = "1603EC57FF7A24DE0B9CE75D44794F2A")

        public static final Parcelable.Creator<BaseSavedState> CREATOR =
                new Parcelable.Creator<BaseSavedState>() {
            public BaseSavedState createFromParcel(Parcel in) {
                return new BaseSavedState(in);
            }

            public BaseSavedState[] newArray(int size) {
                return new BaseSavedState[size];
            }
        };
    }


    
    static class AttachInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "380F2E6581760A76AE57EA2F3E243A67")

        IWindowSession mSession;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "B4A12BFD7130A50D27FFF405887EA83D")

        IWindow mWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "2C6E9C841DFC028F3BFE93152F5069A6", hash_generated_field = "794F056D6C296F490A191063CBE7D73B")

        IBinder mWindowToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "560034CC43D7EBF06318F6BD9836E171", hash_generated_field = "D9C5224ACF349426CF4E47DACA6240CF")

        Callbacks mRootCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "0512EB3F1C233A640787AA69FB3C6BC3", hash_generated_field = "CDD863CC905A95D66D4F1A2915FF3C29")

        HardwareCanvas mHardwareCanvas;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "03503F4E2878305C59038D192AB3AC15", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

        View mRootView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "53546B13F3B3308728C0CD603626602C", hash_generated_field = "942BE5BD2F034C6C8D3F0E7C02B28BE8")

        IBinder mPanelParentWindowToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "76C3E3B9188F3B101287AE8BD0308DA5", hash_generated_field = "718CD3BE0BDD64302FC8F6AC61AA9980")

        Surface mSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "6AB4A5F453379ED66BAA79CE64FDFD98", hash_generated_field = "68B6EC09532005E80B3FF968D0432D9B")

        boolean mHardwareAccelerated;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "53166A41533AEFA4A0E24E658361324F", hash_generated_field = "74EE98E39C4C179E4AA66BC509EA4A56")

        boolean mHardwareAccelerationRequested;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "8B3DB6BF4469C5CF02B1DDD03F5B6055", hash_generated_field = "D13B4D472586A36E031009AA64FCFC65")

        HardwareRenderer mHardwareRenderer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "BA56BB6DE53CE1621F0CD780B0B7B006", hash_generated_field = "D30A01C9AA1020553FD9B357D21DBD2D")

        float mApplicationScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "7C5648CE63D60A3EFBF527D9F67B890F", hash_generated_field = "491DD861F0499CC9AE05718FA07FF84E")

        boolean mScalingRequired;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.196 -0400", hash_original_field = "A67458ADF8F3C4889CE90A27B584015A", hash_generated_field = "463612CF0072B2D91F7638B2CC4F4779")

        boolean mTurnOffWindowResizeAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "EAF515EB51AE996EDE42F4E5B627AD5E", hash_generated_field = "027A7FFA44C832AF6DBE17CAF301CFD3")

        int mWindowLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "0F58D99361211F88A00F2836CB54C580", hash_generated_field = "2CCD3F58E4022E0E51EBBEE7A97CEEC6")

        int mWindowTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "07DA16BCBAA87C3CB8254BCB048BC847", hash_generated_field = "1E46B60B1C8864BF9327E726C9FC6A9D")

        boolean mUse32BitDrawingCache;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "5E83131046575CE08F0EE6BB5ECA21AF", hash_generated_field = "7E3E0CF71C5FF5FEFC1FCFE669E40B4A")

        final Rect mContentInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "CDCC88BCD1FA2B6E7E3A22E8D09269CC", hash_generated_field = "74237CDD8A53EAC9CF0433F0AD4D3E35")

        final Rect mVisibleInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "B9C1A8313191AF75B3FDD14AE8272BBF", hash_generated_field = "8A62AD277EFE6A58E30A5F0CEE7CACEB")

        final ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets = new ViewTreeObserver.InternalInsetsInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "19E9C980D069B1B740AB2CC0BC312416", hash_generated_field = "345FD42085C843C83F8EDE4F1834FEE6")

        final ArrayList<View> mScrollContainers = new ArrayList<View>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "D89222A2A8F942CB3BB02A6B7C95EB1C", hash_generated_field = "FFF6B9F57874D80592FB8DD373F3C84C")

        final KeyEvent.DispatcherState mKeyDispatchState = new KeyEvent.DispatcherState();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "057FC6CF6E6C2229CBCF27ECD410FEE9", hash_generated_field = "A03D646FF0D655946847407BDB557086")

        boolean mHasWindowFocus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "9DB03FBC1019FA899D003FDB9C62771D", hash_generated_field = "3A96D9774881A4202AEE797B3EE3C1D7")

        int mWindowVisibility;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "993AB8FD817B53B283DAECCB59F45A16", hash_generated_field = "28D76E2182EF97A430A42D24DED52D44")

        long mDrawingTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "431974CC97F96D1DF9B4087E57810191", hash_generated_field = "37B2655ADC8B3B21EEDE7EC8BFE1453D")

        boolean mIgnoreDirtyState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "6C8B75CB378D7E6E081C4786CF1119C4", hash_generated_field = "E92F335BE2D9512E3DDCA1603BFA0A77")

        boolean mSetIgnoreDirtyState = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "8AA89BDDF6ED14A8B3486A6AC69598E8", hash_generated_field = "24BF563E82E7B3377EAF3AE738C5792F")

        boolean mInTouchMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "C60259BC6FCF33DB61A1381FA9E441E6", hash_generated_field = "E29840F7AED8F4EF12BD623D6B7943B5")

        boolean mRecomputeGlobalAttributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "20C86703DA01BC32FBE3795085CE94E7", hash_generated_field = "D34584B0CD3D73B43FC67A71CBBCEDA5")

        boolean mForceReportNewAttributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "18D19E1FD7B728605825EF18061C519E", hash_generated_field = "3FE2095DEBDC328EDDA9F609AE6396C1")

        boolean mKeepScreenOn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "D03AF504A7FB8D1F39097D83B42BDFFD", hash_generated_field = "BA594DC97B7780A916BA2DC51EC8AB28")

        int mSystemUiVisibility;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "AE823141C20BCF628969BBCA7EBCC5B2", hash_generated_field = "DE4F434008ACCD754FC4F174AA6749F2")

        boolean mHasSystemUiListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "C364A0DEF59116677330BF528B9D4525", hash_generated_field = "880659755C401DC1FD279B3CDCEB5013")

        boolean mViewVisibilityChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.197 -0400", hash_original_field = "578BCFB5A4EF012FBD6B92643DCE1C39", hash_generated_field = "EC57C8BF7094A89AF638ACD00871F015")

        boolean mViewScrollChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "9686DBE15950AE62BFE7FE798270EC39", hash_generated_field = "E13EF288A8359A2A0BBA668D58D91954")

        final int[] mTransparentLocation = new int[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "EE057DEB82EEF457E13733F3DEDC0B17", hash_generated_field = "2D1B002DD69D7601933D9317EA67321A")

        final int[] mInvalidateChildLocation = new int[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "00AA4723378DFABB790D518F5A26D40E", hash_generated_field = "9464421AA3AA82093FBCB7CDAFC0B825")

        final float[] mTmpTransformLocation = new float[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "58CDF2679DDF2A5B177BCDC3A6E7BA17", hash_generated_field = "722D3D966A44E5DB85CE72D6A92EFD09")

        final ViewTreeObserver mTreeObserver = new ViewTreeObserver();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "D8DB47E921EE865182E76421C432A14B")

        Canvas mCanvas;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "EBC79DD6C9AD45ACA6AB5072C3340A8B", hash_generated_field = "588DE05706C2848B18EFBA5AB5C7B09C")

        final Rect mTmpInvalRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "A9C4430F886F001DD9A9AF970C3078A8", hash_generated_field = "F7AE129955F14FB825DEC531D93514BF")

        final RectF mTmpTransformRect = new RectF();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "2251E9E672C5A755A127E5EF1B510FD8", hash_generated_field = "5A9A000DB49C0CEED945C8004A36E778")

        final ArrayList<View> mFocusablesTempList = new ArrayList<View>(24);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_field = "F4C54CBDEE3AB8CB436DCB41CB5AF49E", hash_generated_field = "2E729681C5CD99C66AC4181B19223EFE")

        int mAccessibilityWindowId = View.NO_ID;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.198 -0400", hash_original_method = "0CDE5ADA82BD9455683884E38A135C3D", hash_generated_method = "48395FA4C7CA9BF9A79558648C28309A")
          AttachInfo(IWindowSession session, IWindow window,
                Handler handler, Callbacks effectPlayer) {
            mSession = session;
            mWindow = window;
            mWindowToken = window.asBinder();
            mHandler = handler;
            mRootCallbacks = effectPlayer;
            // ---------- Original Method ----------
            //mSession = session;
            //mWindow = window;
            //mWindowToken = window.asBinder();
            //mHandler = handler;
            //mRootCallbacks = effectPlayer;
        }

        
        static class InvalidateInfo implements Poolable<InvalidateInfo> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "E9AD1A72A0CA1F1648249A15490614B6")

            private InvalidateInfo mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "4A3D67FC5D08B2108A5D942762FE7F37")

            View target;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "F8DAB7F926CD7972429F7B948D9F5533")

            int left;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "9620536E5A5D6E12CC93092A5EBB857E")

            int top;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "49C6BE2EEC7270CFEAEFBD796F2C423B")

            int right;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "7F74B1869951CB3A6660AA746710A714")

            int bottom;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_method = "7F8409C46E15AE6EC7087A7F4E97E2BF", hash_generated_method = "7F8409C46E15AE6EC7087A7F4E97E2BF")
            public InvalidateInfo ()
            {
                //Synthesized constructor
            }


            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_method = "AAFC70DDA5FB82CEF5E58C1F01C303B7", hash_generated_method = "F6E2001C60EDD672A67B8BFFD0EA80B4")
            public void setNextPoolable(InvalidateInfo element) {
                mNext = element;
                // ---------- Original Method ----------
                //mNext = element;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.203 -0400", hash_original_method = "8D8571C3CBC87318B5EA7A031BC44388", hash_generated_method = "51933AD8AE5B8DF2D6C796B08BF56335")
            public InvalidateInfo getNextPoolable() {
InvalidateInfo varA29C6A1F0F29A0F3732076BE541D5DCD_1699884132 =                 mNext;
                varA29C6A1F0F29A0F3732076BE541D5DCD_1699884132.addTaint(taint);
                return varA29C6A1F0F29A0F3732076BE541D5DCD_1699884132;
                // ---------- Original Method ----------
                //return mNext;
            }

            
                        static InvalidateInfo acquire() {
                return sPool.acquire();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.204 -0400", hash_original_method = "8830525D8149BF52E4AE797FF2AC88D3", hash_generated_method = "E9DF48B1A3244CDF3D09900CA1C3DD95")
             void release() {
                sPool.release(this);
                // ---------- Original Method ----------
                //sPool.release(this);
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.204 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "FD76448E3A3C2833AD7A48BEFAAF8ACC")
            public boolean isPooled() {
                boolean var224D05F4261498DA1D9DF38424832532_46235442 = (mIsPooled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219756848 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_219756848;
                // ---------- Original Method ----------
                //return mIsPooled;
            }

            
            @DSModeled(DSC.SAFE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                // ---------- Original Method ----------
                //mIsPooled = isPooled;
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_field = "39F2AAED9AA054FDE5289F88EBF184A3", hash_generated_field = "B2FFB1CA44DC2BFD07F60AEC442C51E3")

            private static final int POOL_LIMIT = 10;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_field = "A44E5FD188239AC11EA0848B9AD6048D", hash_generated_field = "67EB9377321F551D15C7ACB3DE2B7448")

            private static final Pool<InvalidateInfo> sPool = Pools.synchronizedPool(
                    Pools.finitePool(new PoolableManager<InvalidateInfo>() {
                        public InvalidateInfo newInstance() {
                            return new InvalidateInfo();
                        }

                        public void onAcquired(InvalidateInfo element) {
                        }

                        public void onReleased(InvalidateInfo element) {
                            element.target = null;
                        }
                    }, POOL_LIMIT)
            );
        }


        
        interface Callbacks {
            void playSoundEffect(int effectId);
            boolean performHapticFeedback(int effectId, boolean always);
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_field = "D23B25F3A767CD848A78CCBE0431BFF8", hash_generated_field = "8A0661C8B0A6976975978FE86693F94C")

        static final int INVALIDATE_MSG = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_field = "83760A1BB0DB99F124FB0ACBE07D9D1C", hash_generated_field = "F72E4284C0ED2AE67CE51BE3A94EBA52")

        static final int INVALIDATE_RECT_MSG = 0x2;
    }


    
    private static class ScrollabilityCache implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_field = "36CF4BED2347A59BA24D1080B4773D94", hash_generated_field = "C6A1369EC898F10B405072E1D6B6F8F1")

        public boolean fadeScrollBars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.205 -0400", hash_original_field = "6F6698AC7C7E3B95006C569A10C73321", hash_generated_field = "1655F035B56E41B8BE16E5CF56B77BA2")

        public int fadingEdgeLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.206 -0400", hash_original_field = "82987CB0DFB57EF0D7E6071CBAEED976", hash_generated_field = "0B6D856A35EB0627FF7887D758165295")

        public int scrollBarDefaultDelayBeforeFade;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.206 -0400", hash_original_field = "F330F5B1F62629DE00AA6130936F3A51", hash_generated_field = "E863540FC8628DCB2E031D759E080999")

        public int scrollBarFadeDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.206 -0400", hash_original_field = "16D99E080DA3394608D0C10D69303259", hash_generated_field = "83B1C5317C031D0AB20405882919848B")

        public int scrollBarSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.206 -0400", hash_original_field = "5D1F5486649A4BAD621B1C4B13A5092E", hash_generated_field = "C08FDE67EA8E9E077C57F9B7B9A2DF77")

        public ScrollBarDrawable scrollBar;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.206 -0400", hash_original_field = "4CCF1E17C0001A4A25316D33537A790B", hash_generated_field = "CB96A972AA75A47BFD6582D710EC82DF")

        public float[] interpolatorValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "56B8BC9706D6E065A7599937E8F804CC")

        public View host;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "C1940AEEB9693A02E28C52EB85CE261C", hash_generated_field = "7AA4ED035C35711F4B33B0135B4A7789")

        public Paint paint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "21B72C0B7ADC5C7B4A50FFCB90D92DD6", hash_generated_field = "2ED3478F7527E1ECF1A41F8EA29E0792")

        public Matrix matrix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "842E3E5FE6C1B834705ABD4BCB213342", hash_generated_field = "BD5E2F7CC0958EF9E9784897D7D71294")

        public Shader shader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "9171F43D541F940B89A7FB26C6794AE8", hash_generated_field = "38B61C924838E45A7FCDE7AF77E8755E")

        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "83ADDA5FC3DEE395042A82E7A1746419", hash_generated_field = "FA7A925863D78B977D2FC3469F1DC9E9")

        public long fadeStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "60A253603933185CFAB4CA7DE20B9E69", hash_generated_field = "41AF84CAED377B81AC74E102DF2E9D6D")

        public int state = OFF;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_field = "F62531BE971FA5E1FC4011E8E61EFD62", hash_generated_field = "AC03B4B52C8DAA90037D992009D92CB0")

        private int mLastColor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.208 -0400", hash_original_method = "AB4B2D8281C9D79EC8FB184A37CE88FD", hash_generated_method = "05F8FAC0C3110F2BB5070A90BB23F048")
        public  ScrollabilityCache(ViewConfiguration configuration, View host) {
            fadingEdgeLength = configuration.getScaledFadingEdgeLength();
            scrollBarSize = configuration.getScaledScrollBarSize();
            scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
            scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
            paint = new Paint();
            matrix = new Matrix();
            shader = new LinearGradient(0, 0, 0, 1, 0xFF000000, 0, Shader.TileMode.CLAMP);
            paint.setShader(shader);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.host = host;
            // ---------- Original Method ----------
            //fadingEdgeLength = configuration.getScaledFadingEdgeLength();
            //scrollBarSize = configuration.getScaledScrollBarSize();
            //scrollBarDefaultDelayBeforeFade = ViewConfiguration.getScrollDefaultDelay();
            //scrollBarFadeDuration = ViewConfiguration.getScrollBarFadeDuration();
            //paint = new Paint();
            //matrix = new Matrix();
            //shader = new LinearGradient(0, 0, 0, 1, 0xFF000000, 0, Shader.TileMode.CLAMP);
            //paint.setShader(shader);
            //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            //this.host = host;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_method = "96C29AC8476B3BD548A01E55E35CBC04", hash_generated_method = "3C396A6A1AAEC7240A403FB45AB07852")
        public void setFadeColor(int color) {
    if(color != 0 && color != mLastColor)            
            {
                mLastColor = color;
                color |= 0xFF000000;
                shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                paint.setShader(shader);
                paint.setXfermode(null);
            } //End block
            // ---------- Original Method ----------
            //if (color != 0 && color != mLastColor) {
                //mLastColor = color;
                //color |= 0xFF000000;
                //shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        //color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                //paint.setShader(shader);
                //paint.setXfermode(null);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_method = "14A33F30726B3AE59CE909C1A535F2F0", hash_generated_method = "853A3FFF4A4554B924C7D99A1793D5A8")
        public void run() {
            long now = AnimationUtils.currentAnimationTimeMillis();
    if(now >= fadeStartTime)            
            {
                int nextFrame = (int) now;
                int framesCount = 0;
                Interpolator interpolator = scrollBarInterpolator;
                interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                nextFrame += scrollBarFadeDuration;
                interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                state = FADING;
                host.invalidate(true);
            } //End block
            // ---------- Original Method ----------
            //long now = AnimationUtils.currentAnimationTimeMillis();
            //if (now >= fadeStartTime) {
                //int nextFrame = (int) now;
                //int framesCount = 0;
                //Interpolator interpolator = scrollBarInterpolator;
                //interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                //nextFrame += scrollBarFadeDuration;
                //interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                //state = FADING;
                //host.invalidate(true);
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_field = "5A25F59FDD7EADE938232D542AC9DF31", hash_generated_field = "7C2FCAABFF0839BC46F5A1C3AF188D77")

        public static final int OFF = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_field = "D4174A52FA4F808F71BC2954FF2D0727", hash_generated_field = "4AEC3247A48615FF5865CC0B1A3C7705")

        public static final int ON = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_field = "EC0311F896B24AC1A92AD2C030F6530B", hash_generated_field = "656FDD706C20A529B22AC373F45EB16E")

        public static final int FADING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_field = "AE0BB3ACA40F6E07B62845DE2F1E0641", hash_generated_field = "C6ECC8F0B0BA37B0E970AFED1D0BFB91")

        private static final float[] OPAQUE = { 255 };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_field = "128E3645098B3255219073257445D573", hash_generated_field = "52ECE7CD9B5C9B08E7595DC0D955B8C4")

        private static final float[] TRANSPARENT = { 0.0f };
    }


    
    private class SendViewScrolledAccessibilityEvent implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_field = "AD12063E8FC163523FAE892D8D8BEA2B", hash_generated_field = "8E5087238AE27D181E6487D7D8E8CADB")

        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_method = "67D827D7B507D3EF133C26B0E057ECB2", hash_generated_method = "67D827D7B507D3EF133C26B0E057ECB2")
        public SendViewScrolledAccessibilityEvent ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.209 -0400", hash_original_method = "13F513362861425D1A8D234F009B3F81", hash_generated_method = "53A034A606164AD076ADC134C6992AE7")
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            mIsPending = false;
            // ---------- Original Method ----------
            //sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            //mIsPending = false;
        }

        
    }


    
    public static class AccessibilityDelegate {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.210 -0400", hash_original_method = "B81C1E38B66B1195ED1D00E194D402D3", hash_generated_method = "B81C1E38B66B1195ED1D00E194D402D3")
        public AccessibilityDelegate ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.213 -0400", hash_original_method = "BC0125D947E50318963E057CA3B612F3", hash_generated_method = "A4DB4792EAFB7E4D5F1CBFDB64A0640A")
        public void sendAccessibilityEvent(View host, int eventType) {
            addTaint(eventType);
            addTaint(host.getTaint());
            host.sendAccessibilityEventInternal(eventType);
            // ---------- Original Method ----------
            //host.sendAccessibilityEventInternal(eventType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.213 -0400", hash_original_method = "C58028C1DB413A86B928F475AB0100FB", hash_generated_method = "9E0650420EC29C3209E6890F94576862")
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            host.sendAccessibilityEventUncheckedInternal(event);
            // ---------- Original Method ----------
            //host.sendAccessibilityEventUncheckedInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.213 -0400", hash_original_method = "5A39804E8EC5B74D862B80B866B8F576", hash_generated_method = "FF72549AADE9DE1063DC9B2F9FAC00C4")
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            boolean var159F720672FEA048035DC53B1EB5C1C6_1058956043 = (host.dispatchPopulateAccessibilityEventInternal(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1641662858 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1641662858;
            // ---------- Original Method ----------
            //return host.dispatchPopulateAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.213 -0400", hash_original_method = "D41C8BE91A25AAE323FB25E37AFB61F0", hash_generated_method = "6D51C45DFB5EE609ADEFF292C27C7EAC")
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            host.onPopulateAccessibilityEventInternal(event);
            // ---------- Original Method ----------
            //host.onPopulateAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.213 -0400", hash_original_method = "D490954174BD599BC02D1199D955E569", hash_generated_method = "3112ABEEFB0818686FC5C76A39664F41")
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(host.getTaint());
            host.onInitializeAccessibilityEventInternal(event);
            // ---------- Original Method ----------
            //host.onInitializeAccessibilityEventInternal(event);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.214 -0400", hash_original_method = "E392CA582CA236DC9AD11007B17CF1A9", hash_generated_method = "2E65A13EF8839E6A009FCF88F41C6B43")
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(info.getTaint());
            addTaint(host.getTaint());
            host.onInitializeAccessibilityNodeInfoInternal(info);
            // ---------- Original Method ----------
            //host.onInitializeAccessibilityNodeInfoInternal(info);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.214 -0400", hash_original_method = "4AE2346D08FE5ECB588C47045A997DF1", hash_generated_method = "3188CD832094A6DCAF26BD19F3F3E35C")
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(event.getTaint());
            addTaint(child.getTaint());
            addTaint(host.getTaint());
            boolean var595ACE641BD3B004CA100E82AB17D3FF_605778066 = (host.onRequestSendAccessibilityEventInternal(child, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479942027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_479942027;
            // ---------- Original Method ----------
            //return host.onRequestSendAccessibilityEventInternal(child, event);
        }

        
    }


    
    public interface OnLayoutChangeListener {
        
        void onLayoutChange(View v, int left, int top, int right, int bottom,
            int oldLeft, int oldTop, int oldRight, int oldBottom);
    }
    
    public interface OnKeyListener {
        
        boolean onKey(View v, int keyCode, KeyEvent event);
    }
    
    public interface OnTouchListener {
        
        boolean onTouch(View v, MotionEvent event);
    }
    
    public interface OnHoverListener {
        
        boolean onHover(View v, MotionEvent event);
    }
    
    public interface OnGenericMotionListener {
        
        boolean onGenericMotion(View v, MotionEvent event);
    }
    
    public interface OnLongClickListener {
        
        boolean onLongClick(View v);
    }
    
    public interface OnDragListener {
        
        boolean onDrag(View v, DragEvent event);
    }
    
    public interface OnFocusChangeListener {
        
        void onFocusChange(View v, boolean hasFocus);
    }
    
    public interface OnClickListener {
        
        void onClick(View v);
    }
    
    public interface OnCreateContextMenuListener {
        
        void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo);
    }
    
    public interface OnSystemUiVisibilityChangeListener {
        
        public void onSystemUiVisibilityChange(int visibility);
    }
    
    public interface OnAttachStateChangeListener {
        
        public void onViewAttachedToWindow(View v);
        
        public void onViewDetachedFromWindow(View v);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.214 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.214 -0400", hash_original_field = "B21E54ADF6F1EC7B79C6C1AE44FBD181", hash_generated_field = "728AEBF400875BC43623925282C27543")

    protected static final String VIEW_LOG_TAG = "View";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.214 -0400", hash_original_field = "88123DE8DF5143F6086D0A4BB7B00CB8", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.214 -0400", hash_original_field = "CFE01EBDF16FDABBC2834404C207239C", hash_generated_field = "01F44804D4B2E5BAA321A3D08FADF1E0")

    private static final int NOT_FOCUSABLE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.215 -0400", hash_original_field = "0AD9E0CCD4B721DF1CC94B96EC4D5898", hash_generated_field = "B60F2F3FD613AE8F66EF43CAEDBD3D6A")

    private static final int FOCUSABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.215 -0400", hash_original_field = "719E9855B3D953E2EE9987A580012D6B", hash_generated_field = "4A7BFB7B79B1D1A27F3C6D27933C451E")

    private static final int FOCUSABLE_MASK = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.215 -0400", hash_original_field = "6FB94F3D7A7CDF037678C662A9689D7D", hash_generated_field = "BF038E8C825175307230C582E611F852")

    private static final int FITS_SYSTEM_WINDOWS = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.215 -0400", hash_original_field = "136D41ED3DF9DD9EF3A9A81DADD58165", hash_generated_field = "829F05479D332281B757C73E71A7184A")

    public static final int VISIBLE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.215 -0400", hash_original_field = "0DA34D083070BE2C2BFC30813441B002", hash_generated_field = "24C25C40295AD2D0D5F7C693CBE8FFEE")

    public static final int INVISIBLE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.215 -0400", hash_original_field = "E019C9B7503AD69082F721EC41DE4F50", hash_generated_field = "DADE7E47CBB0DBC6ACF868046DED7DE3")

    public static final int GONE = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "638A50E778AE3706DD0D02F81C3A69AB", hash_generated_field = "46DC4CB49B4B1C753E9EF0933116882A")

    static final int VISIBILITY_MASK = 0x0000000C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "B46EF765402AAEC87B7D8B6CB93C354D", hash_generated_field = "F0ED5F92DDC8DA6B5C7B1F0EC92787C9")

    private static final int[] VISIBILITY_FLAGS = {VISIBLE, INVISIBLE, GONE};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "943A232E38D580886D6006ECC118446C", hash_generated_field = "E946149DFEA69D0B6E9AC928D5226811")

    static final int ENABLED = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "C0CCF30A42F7B85896FEB21D5D80087A", hash_generated_field = "5038EB1B1BDDC780ECAFF35A7312B00D")

    static final int DISABLED = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "09EBD9C5DC9B7133964216D0458D4EB5", hash_generated_field = "FF7AB53A5D2F6D9583260DBE04CE70E5")

    static final int ENABLED_MASK = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "223956AEDC09AE3486F61724D9FE32DF", hash_generated_field = "D9E91EE0E33950072C99789F48286A11")

    static final int WILL_NOT_DRAW = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "72902DCD9DEC9AD627AE18B829F03F6C", hash_generated_field = "8224E5760520AD61AA5C786E772EE5EC")

    static final int DRAW_MASK = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "C0E5737567CB3157DA185632001CA225", hash_generated_field = "269F3C1F1CB4BA6EE4598627F04279FD")

    static final int SCROLLBARS_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.217 -0400", hash_original_field = "8D26450D077C1E00326EA645922486EF", hash_generated_field = "84D26661F3B38DB7E15F3E6C3E59DCB6")

    static final int SCROLLBARS_HORIZONTAL = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.218 -0400", hash_original_field = "BAA86D9ECDBE9A3AEEAC46D1513B3AF6", hash_generated_field = "0CF016AFAC1CE3FE718CD07BD8D5C506")

    static final int SCROLLBARS_VERTICAL = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.218 -0400", hash_original_field = "AEDA673F22AC5A75D39DAD07ACEB90E6", hash_generated_field = "C7EB856B5222623AEFC3E1FE97CAEEFC")

    static final int SCROLLBARS_MASK = 0x00000300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.218 -0400", hash_original_field = "73E0703DA900EFA90928C97AE715BC6D", hash_generated_field = "5BD75921BC796BD559A68AD91D052366")

    static final int FILTER_TOUCHES_WHEN_OBSCURED = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.218 -0400", hash_original_field = "D24F1A8E6549666B005031D398FEE558", hash_generated_field = "75E0E7DA45FF4A99E2ED6F15A7B537D2")

    static final int FADING_EDGE_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.218 -0400", hash_original_field = "3A7A261ACE5B30ECA9279C1BE5DE1696", hash_generated_field = "8AB4B1AA261BDC35537908CB321B1983")

    static final int FADING_EDGE_HORIZONTAL = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.220 -0400", hash_original_field = "EEC6CF3A171DE7EDA9EC195460F15A88", hash_generated_field = "D9D649DC317847AAD19E64C3E113BBC4")

    static final int FADING_EDGE_VERTICAL = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.220 -0400", hash_original_field = "18F27278FD3AAB92633A835806666397", hash_generated_field = "B35A040391A4C00443C19C2995B90AB0")

    static final int FADING_EDGE_MASK = 0x00003000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.220 -0400", hash_original_field = "45B15C364F25251A3C127619E90B5F7F", hash_generated_field = "8E82BA9946E5FC8217E2D093C0DEE86F")

    static final int CLICKABLE = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "51A3AB9F876C508B5C1D05DB9E1A930D", hash_generated_field = "D5C8DBBB19A01A4ADC1CFC3DF56604DE")

    static final int DRAWING_CACHE_ENABLED = 0x00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "D8742CC8D1D72215607E7D4AC10BC8C0", hash_generated_field = "58220690B3964939EFD247679F6DBB16")

    static final int SAVE_DISABLED = 0x000010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "A75506DA371A486D311CDD4D029A330E", hash_generated_field = "1AF7B603B206D36BAFEFE71A2856456F")

    static final int SAVE_DISABLED_MASK = 0x000010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "A6FA078274716D518128E150581D2851", hash_generated_field = "51995E9C673CBAC6019B76C649BEC0DE")

    static final int WILL_NOT_CACHE_DRAWING = 0x000020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "E03A3305D740CA16331145E801848E22", hash_generated_field = "469110FE5469C37A921A47B3637A87F0")

    static final int FOCUSABLE_IN_TOUCH_MODE = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "FA3A1555CC434AC18D966F00D2423C82", hash_generated_field = "00C745D591E053E355D9F95CAA502483")

    public static final int DRAWING_CACHE_QUALITY_LOW = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "1C715F9A3E4D054995D7540181249A42", hash_generated_field = "5C1456CB937D24EC2357B82160B57D70")

    public static final int DRAWING_CACHE_QUALITY_HIGH = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "4AF63F90FCB3729D33ED8E285AF2B74E", hash_generated_field = "1F818F030504ADAB1788120175C0B1E5")

    public static final int DRAWING_CACHE_QUALITY_AUTO = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "3207B6651A0BF5F174E5CAF999AB8905", hash_generated_field = "7060269E37AC69A7EAA5771D16F0390B")

    private static final int[] DRAWING_CACHE_QUALITY_FLAGS = {
            DRAWING_CACHE_QUALITY_AUTO, DRAWING_CACHE_QUALITY_LOW, DRAWING_CACHE_QUALITY_HIGH
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "510EB04A8874ADFC53C33C3DB0F22789", hash_generated_field = "CDA2F575CC8014BF1E2BB36F24BF1F1A")

    static final int DRAWING_CACHE_QUALITY_MASK = 0x00180000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "B2686CD8BA58915A28F18A2290D383B1", hash_generated_field = "22F50F883FF6C25DC52493F220C9ABB8")

    static final int LONG_CLICKABLE = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "6F25A9D7ED2043A0A5C3D937F4EE60B0", hash_generated_field = "B27AFB8C724A77CC01C8FE3AAC770306")

    static final int DUPLICATE_PARENT_STATE = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "2747E2837D818C6355EE71D69B9684B7", hash_generated_field = "3942DDD065BFB4D5847FE6C074D13B8C")

    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "234F4C5DCDC5DE24A3652BD6011D93D9", hash_generated_field = "99D8798FCB61EE70472EB6CEB2B1D2BD")

    public static final int SCROLLBARS_INSIDE_INSET = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "ED751E830351C6E99A81725F83CA320D", hash_generated_field = "26082E7DF00E5D63F0836B2C3593B9A1")

    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "98278E487E36D61B5EFF4EB199CD5F66", hash_generated_field = "8D486D5878BEE68EEDFC2466A5593564")

    public static final int SCROLLBARS_OUTSIDE_INSET = 0x03000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.221 -0400", hash_original_field = "C9838B952BE0085ABBD5F18638048C95", hash_generated_field = "8A31E0CDC781D04365F399522A814CD5")

    static final int SCROLLBARS_INSET_MASK = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.222 -0400", hash_original_field = "FB72F7534C13B44CC119CFC03DC847EA", hash_generated_field = "70944B9F44919B5C2B302411CDD199D0")

    static final int SCROLLBARS_OUTSIDE_MASK = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.222 -0400", hash_original_field = "237A29BBCB2DB13E041F3DA844444538", hash_generated_field = "129B7C59D8FDD7BACE6ECE8C3BBCA0AB")

    static final int SCROLLBARS_STYLE_MASK = 0x03000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.222 -0400", hash_original_field = "5A93B62D57F19F1248E061B9DF6D4586", hash_generated_field = "026A7CCCB8A871DB74312537DD84B5CB")

    public static final int KEEP_SCREEN_ON = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.222 -0400", hash_original_field = "EBF2D0C0B786CD060B5AE41494DA59C6", hash_generated_field = "65C2782715263C009044AB84624A4EB2")

    public static final int SOUND_EFFECTS_ENABLED = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.222 -0400", hash_original_field = "1078F74C572D9516578E7FA7289C750A", hash_generated_field = "104909D35DACCE7A451CA8A4158F790C")

    public static final int HAPTIC_FEEDBACK_ENABLED = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "F23DDA0E5F90CEFBF8B46DBA0BCB190F", hash_generated_field = "571D760F29262F82EDAAA90E822EBAF8")

    static final int PARENT_SAVE_DISABLED = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "6B97792AE6AB5644826FC2B8CA55EA66", hash_generated_field = "D47B48591230EE766F208E58DC2093F4")

    static final int PARENT_SAVE_DISABLED_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "042290192ED37463656C62A299DCD56C", hash_generated_field = "A688099F9FE53C57D5410ECB0B78ECF6")

    public static final int LAYOUT_DIRECTION_LTR = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "D50A627E81AC5EE86F73722012E61B2A", hash_generated_field = "1E680499F28E2DB403E520F9B378996F")

    public static final int LAYOUT_DIRECTION_RTL = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "A405E7709C580A39852B4DEBD01E0B25", hash_generated_field = "3C8F75DD79F0631A6C45E4E961B35BE6")

    public static final int LAYOUT_DIRECTION_INHERIT = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "352E9691543D117A79FEE50BA922BA21", hash_generated_field = "309700780AC169B61849F35A862B3E65")

    public static final int LAYOUT_DIRECTION_LOCALE = 0xC0000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "62FB84FF84367768D9A8010C1DE8DFE5", hash_generated_field = "6FE5303D659D6470BE6AE1DC66925B88")

    static final int LAYOUT_DIRECTION_MASK = 0xC0000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "45F3ED7F85CB672108B49A6F1CBFF483", hash_generated_field = "2B195F9D5574504A59136591EF21764E")

    private static final int[] LAYOUT_DIRECTION_FLAGS = {LAYOUT_DIRECTION_LTR,
        LAYOUT_DIRECTION_RTL, LAYOUT_DIRECTION_INHERIT, LAYOUT_DIRECTION_LOCALE};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "A4258B7D410E3ABEA2DAED93E7FC2DBF", hash_generated_field = "0FF5069567EECE1EABD2593046037335")

    private static final int LAYOUT_DIRECTION_DEFAULT = LAYOUT_DIRECTION_INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "60991A843680A700D8903D1037CD1027", hash_generated_field = "4E5D1049C9EF75861592546EF88DBF53")

    public static final int FOCUSABLES_ALL = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "75B8D0D830284C8413D9475FE15DED7B", hash_generated_field = "FDC3A4AE8FBDEDEDFB25081E70F0EAFA")

    public static final int FOCUSABLES_TOUCH_MODE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "16EA4D0DF6A96534ED21707D0DC9D7D1", hash_generated_field = "169DA3FC15889071D72206CA09A960FA")

    public static final int FOCUS_BACKWARD = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "6FAD780F10ED98A64C11256A4F65B843", hash_generated_field = "4B7B29E11785A4D3C7319284FE29BB61")

    public static final int FOCUS_FORWARD = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "3748FE498607ED50B4BEA594F402D00E", hash_generated_field = "936F919E08FC8B9F1C931D6E632F8DE0")

    public static final int FOCUS_LEFT = 0x00000011;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "8C5862526CF4B48EEE48CD48164CF908", hash_generated_field = "E877EF3790B7F3E0F15FFC2846DA5A4A")

    public static final int FOCUS_UP = 0x00000021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "7836E0401589D48A18437C3C00FB92B1", hash_generated_field = "8A54B461A03C16A38D0974EA5435F806")

    public static final int FOCUS_RIGHT = 0x00000042;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "DA9FCEAFDE994E9275E734E38EC26AF2", hash_generated_field = "32373BABA82126482CBABBE76E9F36D3")

    public static final int FOCUS_DOWN = 0x00000082;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "7C5B34C3F66563DEDF69054B4573D7A0", hash_generated_field = "3584CE2038396D56F00CBCE4E0AF47E7")

    public static final int MEASURED_SIZE_MASK = 0x00ffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "26BC6B4F75C09AA87725780145BF0053", hash_generated_field = "874FE93B404AA4B2617E7E2F47B091CC")

    public static final int MEASURED_STATE_MASK = 0xff000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "BEAD869C6CD87263DD66EA8E7F53CAB5", hash_generated_field = "859653BE0AACCFF2DA07F4D6CA30948B")

    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "58C4E838736B52712EDDA9AADE5146ED", hash_generated_field = "499640E6C451DA0A8A056EE1F14203E6")

    public static final int MEASURED_STATE_TOO_SMALL = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "51B7591E0F578681A0C2EE5DA47C2D4E", hash_generated_field = "A60706A950ABFA6787DAFE2333D1D63E")

    protected static int[] EMPTY_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.223 -0400", hash_original_field = "1487025A5AB6A88FEACB03AB7990FFA5", hash_generated_field = "99443560A8BB02795565A31C7E7FF7B1")

    protected static int[] ENABLED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "7263334C9DDB4A7D666B1C3DD61A0C6A", hash_generated_field = "11C8381528C7451EAC51D425793F56C2")

    protected static int[] FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "E33DADA1965FE739883D993B5AA18F9F", hash_generated_field = "3A452259C52C53C1EFB914A335939407")

    protected static int[] SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "88939EA751CCCC7A7DB0509EA010F6DA", hash_generated_field = "1150481E1245BD4252FBDD6D8BF7F65F")

    protected static int[] PRESSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "2E3E59175269A05F91C5A19CB85A694E", hash_generated_field = "8E5DAB90AC5DCA5817D14D9B6C547303")

    protected static int[] WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "6C90D4BB8E9AC1B71CDEEBC3645B2780", hash_generated_field = "7288DEFD6843DAD9B8306502492E9853")

    protected static int[] ENABLED_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "0BA64AB46B8FBDF51E936CAF79AD944B", hash_generated_field = "26F780CD73153C56C935B863B7CA60FA")

    protected static int[] ENABLED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "77BE7752F47EB351E50B3E41073FEC4B", hash_generated_field = "4E4EEFF45753D32998559D55A6EF44B8")

    protected static int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.225 -0400", hash_original_field = "A25D57A9D8267C415AE05F818FF6AC5E", hash_generated_field = "E4F27C2333C782D6E4D173DE3B06BF18")

    protected static int[] FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "919907B0612F6254887EB3E97A22BF9C", hash_generated_field = "89F4391F6DDF155A225E114339942430")

    protected static int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "611D21495AB54356BC2E7665025343B3", hash_generated_field = "94022B56BE402F58E4270EB350792883")

    protected static int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "4B146E73AB4ADACFAAF2647A8B055DF1", hash_generated_field = "15E50E4B54201BE1BE6EB6674087A2FF")

    protected static int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "8262D29B4D0A9F17177FD6254B2D3930", hash_generated_field = "FDA0C2E170F0F36949DABE497139E672")

    protected static int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "FBD49E3069AD0761FCFAD89ED56531BE", hash_generated_field = "7B5D9A889C2FFA9A561E0EA4250EBE37")

    protected static int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "26E63DE2BE2B46BFEBC5C441C4D6E1F9", hash_generated_field = "C7506CCBA97AA185D5649A7B40AB28D9")

    protected static int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "BE4CEC84B4BE8BFFB0455DE22E885108", hash_generated_field = "21701468D299EEF2E6314D17CDA4A09B")

    protected static int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "9A1FBDAD10063482B7658C13B8A0B02F", hash_generated_field = "F8383F641270D614B30774F08FA72D27")

    protected static int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "4B4B3833D917124D356E8A05CEE57412", hash_generated_field = "D26868EDEAAF82B3EF5953C4049C5BF8")

    protected static int[] PRESSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "945046E9CCAB02225F85C9AEF80FD0F1", hash_generated_field = "DB8F785F4FD804A28291B083216F3C9E")

    protected static int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "32DFD335BE0EC6D93B8CB7E154077B5A", hash_generated_field = "FF997AEB254DFD2B8E8AF4DC32EF1D31")

    protected static int[] PRESSED_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "BC1A2C878ED403A3DC4AB16C2C5236C4", hash_generated_field = "B219816DBAFB4C4AE58A96AEE6F32010")

    protected static int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "10128D4A007A2E3A355578602006E698", hash_generated_field = "EB888E73506F6FA9D225D7A6FC4285F7")

    protected static int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "13BF55722C5919CC13ABB211D7D8FC34", hash_generated_field = "DA91E046B143C9258573479BFD455473")

    protected static int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "EEBB047B97E6CC005B66BB4DF8F94E74", hash_generated_field = "47A198E35052CA7F982234E83E6AE0B5")

    protected static int[] PRESSED_ENABLED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "8EA96FD8BA37E8726D3FF37428005A84", hash_generated_field = "1241C342AD96CD3177F39E12E55B08A1")

    protected static int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.226 -0400", hash_original_field = "D7F5B6940CEB03AF4DB7C638C8DB86C9", hash_generated_field = "B8447E4F384C40AC956314579E0EC168")

    protected static int[] PRESSED_ENABLED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.227 -0400", hash_original_field = "CD5B9CAE61BF5681D131974B48D45F35", hash_generated_field = "F3A6207F343FCB93F7AD3D66BE9819DE")

    protected static int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.227 -0400", hash_original_field = "2B786A01E298E73EF07DF178EFA649DE", hash_generated_field = "92A36B4EAE93002927F999631B9F3F0B")

    protected static int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.227 -0400", hash_original_field = "8C8090C7CEA34E704C4D34265493EFB7", hash_generated_field = "95A751D33F39D2426A2D5C87AED66425")

    protected static int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.227 -0400", hash_original_field = "EB47BA02ACDC4579D77D7F37C47E607B", hash_generated_field = "7FA35EC1F5140E40D7F86CA44E6DBA3D")

    protected static int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "D944FE429EDF53CE63EEC14D8093A840", hash_generated_field = "74D8BB51BDEF099D4EDB19D4AB388E56")

    protected static int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "7CACA492F8EB04441960954CE8E31F4E", hash_generated_field = "07E5728FFC69B34D451F1FFD96A500DE")

    private static int[][] VIEW_STATE_SETS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "840023F54AE77F6B7CB6EA057A29345F", hash_generated_field = "14A9EEAFA20652E17C004627513442D3")

    static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "30BF9633946B236206204B1B228F9B4E", hash_generated_field = "8F5DACC3E931BB6D45970C3D4F236044")

    static final int VIEW_STATE_SELECTED = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "13F309EA19E97FDCAB0F34A82B513727", hash_generated_field = "3BDE49CD992A557C6BC150E37203E374")

    static final int VIEW_STATE_FOCUSED = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "3DBC2F54FADC09E29BF1B8FBBEA3FB0D", hash_generated_field = "FF062786656E19CBE9DF873C32B837B4")

    static final int VIEW_STATE_ENABLED = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "73B0F4C3283212372DB4AD900092822F", hash_generated_field = "42D0A243D87878B393907AB494DF9D6F")

    static final int VIEW_STATE_PRESSED = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "76ECEEDE7E2BE2C35DBAF0A9660EF84E", hash_generated_field = "6C91EA09E2C90C1DF3101479368CB380")

    static final int VIEW_STATE_ACTIVATED = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "B0A3894D2E7A8DECC31DDF557084056F", hash_generated_field = "9EC9B10B5927E85F8F05CFFD3E1BCB7D")

    static final int VIEW_STATE_ACCELERATED = 1 << 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.228 -0400", hash_original_field = "CD5EC9C04D78EAE85439A49EE43548B7", hash_generated_field = "E89AF08FD103519565D8ACE924E0CCDE")

    static final int VIEW_STATE_HOVERED = 1 << 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.229 -0400", hash_original_field = "7963B56E34789A515DD35DC186470423", hash_generated_field = "1D4DC52F9C46700D3A32C0B94E81EC4A")

    static final int VIEW_STATE_DRAG_CAN_ACCEPT = 1 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "1D0657EAA0C99CDDC29972AFF5927F66", hash_generated_field = "622438F15831E9532B4F4DDFC41CF098")

    static final int VIEW_STATE_DRAG_HOVERED = 1 << 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "F0FE506AC7CE0271C963DE2DFB2246CA", hash_generated_field = "AAC5495A62AC6D4ACFA4E56618BD582F")

    static final int[] VIEW_STATE_IDS = new int[] {
        R.attr.state_window_focused,    VIEW_STATE_WINDOW_FOCUSED,
        R.attr.state_selected,          VIEW_STATE_SELECTED,
        R.attr.state_focused,           VIEW_STATE_FOCUSED,
        R.attr.state_enabled,           VIEW_STATE_ENABLED,
        R.attr.state_pressed,           VIEW_STATE_PRESSED,
        R.attr.state_activated,         VIEW_STATE_ACTIVATED,
        R.attr.state_accelerated,       VIEW_STATE_ACCELERATED,
        R.attr.state_hovered,           VIEW_STATE_HOVERED,
        R.attr.state_drag_can_accept,   VIEW_STATE_DRAG_CAN_ACCEPT,
        R.attr.state_drag_hovered,      VIEW_STATE_DRAG_HOVERED,
    };
    static {
        if ((VIEW_STATE_IDS.length/2) != R.styleable.ViewDrawableStates.length) {
            throw new IllegalStateException(
                    "VIEW_STATE_IDs array length does not match ViewDrawableStates style array");
        }
        int[] orderedIds = new int[VIEW_STATE_IDS.length];
        for (int i = 0; i < R.styleable.ViewDrawableStates.length; i++) {
            int viewState = R.styleable.ViewDrawableStates[i];
            for (int j = 0; j<VIEW_STATE_IDS.length; j += 2) {
                if (VIEW_STATE_IDS[j] == viewState) {
                    orderedIds[i * 2] = viewState;
                    orderedIds[i * 2 + 1] = VIEW_STATE_IDS[j + 1];
                }
            }
        }
        final int NUM_BITS = VIEW_STATE_IDS.length / 2;
        VIEW_STATE_SETS = new int[1 << NUM_BITS][];
        for (int i = 0; i < VIEW_STATE_SETS.length; i++) {
            int numBits = Integer.bitCount(i);
            int[] set = new int[numBits];
            int pos = 0;
            for (int j = 0; j < orderedIds.length; j += 2) {
                if ((i & orderedIds[j+1]) != 0) {
                    set[pos++] = orderedIds[j];
                }
            }
            VIEW_STATE_SETS[i] = set;
        }
        EMPTY_STATE_SET = VIEW_STATE_SETS[0];
        WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_WINDOW_FOCUSED];
        SELECTED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_SELECTED];
        SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED];
        FOCUSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_FOCUSED];
        FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED];
        FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED];
        FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED];
        ENABLED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_ENABLED];
        ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_ENABLED];
        ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_ENABLED];
        ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED];
        ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED| VIEW_STATE_ENABLED];
        PRESSED_STATE_SET = VIEW_STATE_SETS[VIEW_STATE_PRESSED];
        PRESSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_PRESSED];
        PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_PRESSED];
        PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_FOCUSED | VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_SELECTED | VIEW_STATE_FOCUSED
                | VIEW_STATE_ENABLED | VIEW_STATE_PRESSED];
        PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET = VIEW_STATE_SETS[
                VIEW_STATE_WINDOW_FOCUSED | VIEW_STATE_SELECTED
                | VIEW_STATE_FOCUSED| VIEW_STATE_ENABLED
                | VIEW_STATE_PRESSED];
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "BC732632754162FEA3F07CEB5C7D8AE4", hash_generated_field = "09FD46ADE03A21840451EFC738B1A7A7")

    private static final int POPULATING_ACCESSIBILITY_EVENT_TYPES = AccessibilityEvent.TYPE_VIEW_CLICKED
            | AccessibilityEvent.TYPE_VIEW_LONG_CLICKED
            | AccessibilityEvent.TYPE_VIEW_SELECTED
            | AccessibilityEvent.TYPE_VIEW_FOCUSED
            | AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            | AccessibilityEvent.TYPE_VIEW_HOVER_ENTER
            | AccessibilityEvent.TYPE_VIEW_HOVER_EXIT
            | AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
            | AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "E3D3FC8D07AB0B919D55A05D03BD2DDA", hash_generated_field = "684181D325E3591F0B7AAD06CC900A68")

    static final ThreadLocal<Rect> sThreadLocal = new ThreadLocal<Rect>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "D7DE0ACE26DFCBFA81B727E7D697D6DC", hash_generated_field = "7D4D749E981D95615D6EBF2D704DB8B6")

    private static int sNextAccessibilityViewId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "500117F1360ECD0E2A1C758A384C6BDE", hash_generated_field = "324935551C98559798BFC98BC88D0E16")

    static final int WANTS_FOCUS = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "83B85F39C701A1CD9E8E850630AFB73D", hash_generated_field = "76144A0AFA07456ADF5BD6C61EFDD82A")

    static final int FOCUSED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.230 -0400", hash_original_field = "AEFAC5139B1F408F0396832810DBCEB7", hash_generated_field = "B8FCBDDA4AC19831AC8F95B5E299A019")

    static final int SELECTED = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.231 -0400", hash_original_field = "96DF4F8FC6E2AD4704C5C57F486C62A7", hash_generated_field = "40E315525D7E3F79CE6749FA5486016E")

    static final int IS_ROOT_NAMESPACE = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.231 -0400", hash_original_field = "CA7D68B3A5540FFD5359787C666DB078", hash_generated_field = "A57A7453C08B33D43AA0903652335D6B")

    static final int HAS_BOUNDS = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.233 -0400", hash_original_field = "ACA3CC4C13B40B8ECB3C6210C98DFCA5", hash_generated_field = "9EF7FA33897722D87B0F3A6B600D5E81")

    static final int DRAWN = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.233 -0400", hash_original_field = "3FB0E221E190E60E340F7D7FED25A8A9", hash_generated_field = "9DE5C056A7D09D1D07F14977B6558968")

    static final int DRAW_ANIMATION = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.233 -0400", hash_original_field = "A949A8DDF17378D569923BDB3BD3CE4D", hash_generated_field = "60FF926409B2F5933B181900B19AAC45")

    static final int SKIP_DRAW = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "7DEECFEEC7611D16BD2F9A3756FA2BB1", hash_generated_field = "42E39DC4A1F2A24AE76342261ED67462")

    static final int ONLY_DRAWS_BACKGROUND = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "2A62805F3B4B271B6D733C06F3A3786F", hash_generated_field = "6FDF9B9C295413E46CD84B530D99A3CC")

    static final int REQUEST_TRANSPARENT_REGIONS = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "7A69759A1E34A3948363D6F2AD631B39", hash_generated_field = "23439B38EE9E7C6C702D63C4F1ED384A")

    static final int DRAWABLE_STATE_DIRTY = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "6C0298510DAE034B4A70716048ADE945", hash_generated_field = "02DFB1F097A0748DE08336A975D45816")

    static final int MEASURED_DIMENSION_SET = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "6A440126BB00967A51CCB88DAACD1292", hash_generated_field = "945693F86F0A771A9EC4BD547C7EA2C6")

    static final int FORCE_LAYOUT = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "4FEA9D60E4244C5452CD42C4851D13F1", hash_generated_field = "138A2DA084E8C20D234F0FD286F24C09")

    static final int LAYOUT_REQUIRED = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "3B39792FDAC39DE65F7ED2FD34A515EA", hash_generated_field = "A32BF712F0570B663C9C802C05CF1890")

    private static final int PRESSED = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.234 -0400", hash_original_field = "CA4B0F471AC38326CCE490FE95DD9DBF", hash_generated_field = "6A22DCE014F56DCE137CB587120D93F9")

    static final int DRAWING_CACHE_VALID = 0x00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "C008718263AEA3F654A7431B2FEE1AE0", hash_generated_field = "042862CB0ADBC6B3E35B81806CA38E37")

    static final int ANIMATION_STARTED = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "520300B25E15DC461FC807E3DDE2EC9D", hash_generated_field = "BA4D09564EB1E0038BBEC9BC2D384011")

    private static final int SAVE_STATE_CALLED = 0x00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "7A9B464E0EC754E6120D11506C660E74", hash_generated_field = "2ADF228F56CBDA6B09A2A154F6926EFA")

    static final int ALPHA_SET = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "F2642ABC015872B1D18A10BA26436F68", hash_generated_field = "44E3C961B99F63E3A07CB003A0CA4B9B")

    static final int SCROLL_CONTAINER = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "77FD38926931873CE64CCCD9AAA636EE", hash_generated_field = "FBC3A0FBB44FEC222F3F4C8C1E04A345")

    static final int SCROLL_CONTAINER_ADDED = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "D12AE92211483CEAE28211A899954171", hash_generated_field = "96ADCAB4A37B8BB124ECD80E384642EA")

    static final int DIRTY = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "90A4B5DC715FC521F95E6BF53938EA44", hash_generated_field = "96FBB855B8A08D7EDC96EFCEC1705F07")

    static final int DIRTY_OPAQUE = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "FE623C860E0D6689B3FAA8DCFDE2DA83", hash_generated_field = "E59459A965FA6E2D0EE74CC520B7969C")

    static final int DIRTY_MASK = 0x00600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "AD218DA12A70673BD9767DB67BAE40E2", hash_generated_field = "B74861256F94749BBD076F0EE1BB6697")

    static final int OPAQUE_BACKGROUND = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "152E9A4D03C0868595B1B3A98EC5DD59", hash_generated_field = "CB076E5ABDBD6D2DB2CAA68F9BBF25B9")

    static final int OPAQUE_SCROLLBARS = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "1FF0D2CB4E21A22B233B4091B7F3EA7A", hash_generated_field = "26BE9A5B6506A9A205564B56496E86A7")

    static final int OPAQUE_MASK = 0x01800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "F344EC503BD86AEEBCFDAC09D95E8E68", hash_generated_field = "9B3764730F327DBBF2A2D3CD5D565A0E")

    private static final int PREPRESSED = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.235 -0400", hash_original_field = "89B3AE233E472F6B44029C702E7C3F9D", hash_generated_field = "9B73CB25776C9F2B49E35CE827A563CB")

    static final int CANCEL_NEXT_UP_EVENT = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.236 -0400", hash_original_field = "36D406F449B7F4F8631F62229F52A4AA", hash_generated_field = "8A59740EC03CDB8433058BC75E6CC2DF")

    private static final int AWAKEN_SCROLL_BARS_ON_ATTACH = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.246 -0400", hash_original_field = "682EFAC34FCD91477D1163FC4F0544CA", hash_generated_field = "5A4D1B7B954FE6E9DB7211EC1037FB16")

    private static final int HOVERED = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.246 -0400", hash_original_field = "311BEC00A2A57CF70925B2CB9CFA061F", hash_generated_field = "B9DEE496A6C9D6738C4CCD97A0FFC329")

    private static final int PIVOT_EXPLICITLY_SET = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.246 -0400", hash_original_field = "9E6EB47515D35AE672239BCA100D80B5", hash_generated_field = "E7C6D1F67DF39F2566312582F97AA88E")

    static final int ACTIVATED = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "38FB36FF33AF5682C9A3C817ACE91449", hash_generated_field = "0A4C84F7E1053F2B7F2C1216C1B89639")

    static final int INVALIDATED = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "7A41027FA0D80172C61A63E1749F8522", hash_generated_field = "1E3191E90B3292678814CED4910ECCB3")

    static final int DRAG_CAN_ACCEPT = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "3AB4DF7D76BF92F0AF881CE9B561B121", hash_generated_field = "0A71D3250F076CE3F2CA33F0AFEA1360")

    static final int DRAG_HOVERED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "F115C5B400B4AD33E411E3D853951590", hash_generated_field = "533431F61C3E776BF1DC4F0C19BFFFBE")

    static final int LAYOUT_DIRECTION_RESOLVED_RTL = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "E38A74D27FDCCB03C2FA1DF706DB289B", hash_generated_field = "EB582E7E7DEA8F1CBFEE72038956E0BA")

    static final int LAYOUT_DIRECTION_RESOLVED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "3C7B642C2343EB20487AA2B5D199EA6B", hash_generated_field = "DE17281667B863CA7CEAE6DA8567A548")

    static final int DRAG_MASK = DRAG_CAN_ACCEPT | DRAG_HOVERED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "7EB0B2502005C4CB40D46FF10A6B736D", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "67D34493973359A97A217AD3B17DA6CF", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "E1779A27D7E8D7DB9FBA34E6E8D0F4A8", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "BF7D37DAD8E455C992BC7E68A0990530", hash_generated_field = "125903A773621693E8ED9CD79E76CEE2")

    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.247 -0400", hash_original_field = "906B1D91F782CE5AC8B7F0D668A6C3DE", hash_generated_field = "D22EB113F7E463630AC5C1BF53857810")

    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "4F3ABEF5C072D169DE48CFCD8D83ACB3", hash_generated_field = "C08307181AE930BB4EB97AF7E4BA99C2")

    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "5D67A0854A678B7421A5D8EB5EE8C592", hash_generated_field = "E2BDD60871070DE88B6211D48982B8C2")

    public static final int STATUS_BAR_HIDDEN = SYSTEM_UI_FLAG_LOW_PROFILE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "0F4BC827AD7F800E9D5FBFE4091527AC", hash_generated_field = "8B75629E21794DD2B63C2EBB0F5C5651")

    public static final int STATUS_BAR_VISIBLE = SYSTEM_UI_FLAG_VISIBLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "B8E435BADA682778215DD51A19DF8FFB", hash_generated_field = "B2C2F68118A98B0D9DC29F6548450BB1")

    public static final int STATUS_BAR_DISABLE_EXPAND = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "3C2F21B6325236E297702C891D965A0C", hash_generated_field = "F15A9A270E6E94C57BE4C34A504CA2E4")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 0x00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "F1CA414B01FED44D125FD7D69B8A2752", hash_generated_field = "A29040D2CCE82CD2248FC7CE5DD6F34C")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "7FEF4130863D936A12C0424A654E5D3E", hash_generated_field = "16D9107672695454170019843C771E6E")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "C3C38A73496A3D57718587B370F541F7", hash_generated_field = "F95F66DC605FC858FD4E71DFA5C0F9BD")

    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "7E1FCA75C299F4E34A9DD82FD57BBDFD", hash_generated_field = "AAFD5A01803D7358E81163F32EB064CC")

    public static final int STATUS_BAR_DISABLE_HOME = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "A35BDA216974994591355F84D3B5274C", hash_generated_field = "E23FAA42E397EEA07B1B79A8F58007E0")

    public static final int STATUS_BAR_DISABLE_BACK = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "E9E375135941614B6E6CB8C9E2379A94", hash_generated_field = "DCC7B8B91738A06DD4F62CA9D5735F60")

    public static final int STATUS_BAR_DISABLE_CLOCK = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "5CCE851821E73C19D62138787ABDCA10", hash_generated_field = "CCF974A2E5C1C62EC6B351C6AF50C578")

    public static final int STATUS_BAR_DISABLE_RECENT = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.248 -0400", hash_original_field = "B43FB7EFDEC3382EC0990C0A9E8B271C", hash_generated_field = "0C7A3AEFD08471993D7A4F0326BFA356")

    @Deprecated
    public static final int STATUS_BAR_DISABLE_NAVIGATION = 
            STATUS_BAR_DISABLE_HOME | STATUS_BAR_DISABLE_RECENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "C1B7F07AFA8039E59BC19145B086410C", hash_generated_field = "C93A2BBD1CA42547C4B5B418761D706E")

    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 0x0000FFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "C0E867B817C5074EE01AB86DFED8F6C6", hash_generated_field = "9B73CC22DA15165280173F1866272945")

    public static final int SYSTEM_UI_CLEARABLE_FLAGS =
            SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "51FF96EA2D2BD34250562D6F671E164F", hash_generated_field = "7B20A663B4D3B5566CC5C719038AA2BA")

    public static final int FIND_VIEWS_WITH_TEXT = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "2EB0F42C98B29EF37AEA628C8410E67D", hash_generated_field = "DC0F2D99F610668CF27C5B6686754038")

    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "311CAB010F7D36E164A93EFE4C4E86BD", hash_generated_field = "861292948F794A707C7A0C135A7073D2")

    private static final float NONZERO_EPSILON = .001f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "C6E278D91B5DF64AC1C4D714250083AB", hash_generated_field = "C08C16CB7F1DD117251F7E01BD2A9C0A")

    public static final int DRAG_FLAG_GLOBAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "16240D771FB90A67263EFE9E2C291DEA", hash_generated_field = "A5FF12741D477D00096166439C6E6A47")

    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "D30F0164D22B00A11A1CCB2B977A764B", hash_generated_field = "DC33B736EF2AA325AA97A5FCD399D9D8")

    public static final int SCROLLBAR_POSITION_LEFT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "3DC6508AD3033900527EC4DB3791E127", hash_generated_field = "3F9EAAC738BDA10511E9A3B6436EF6E3")

    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "96AA91F8A048281129229FD083B1358D", hash_generated_field = "4B71A3CAAC0983C5CC19785C41F5E14C")

    public static final int LAYER_TYPE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.249 -0400", hash_original_field = "DCBB776A50163456B0C217708A748171", hash_generated_field = "9362C41130448D1BEC071BA7F3927A19")

    public static final int LAYER_TYPE_SOFTWARE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "047EE5E7394F65AAAF3F8809914E0CE3", hash_generated_field = "339CEE307F54C01A3C41187443B4553A")

    public static final int LAYER_TYPE_HARDWARE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "7E5F4F35F076DD4A01417879834ED5A8", hash_generated_field = "8B7A964E0E3D6E1CA183DED21E99796E")

    public static final int TEXT_DIRECTION_INHERIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "C9DC0711FEE92DC0E5A418B930214358", hash_generated_field = "A11F693FD1415D67D865FDE1AE59FAC8")

    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "C0ED02B1DFA8E1E0002994F29FE0DBF1", hash_generated_field = "FE7C3FEA62FE2BEB4EAF36B5581E7BE1")

    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "5BAC4FF9879DCA7AFE5C4CA8A82E2F9A", hash_generated_field = "7D98B23250113084506842828EB2DF5B")

    public static final int TEXT_DIRECTION_LTR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "213E189EFF089F8F261EBA1867B24AC5", hash_generated_field = "9D4940C20853BDAD0B50AED80FB5511C")

    public static final int TEXT_DIRECTION_RTL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:52.250 -0400", hash_original_field = "4E44E9C56C5AB65B582CBC8E90D683E3", hash_generated_field = "08FC45D9BA58A3E9219785E4F9BE4255")

    protected static int DEFAULT_TEXT_DIRECTION = TEXT_DIRECTION_INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.936 -0400", hash_original_field = "FA09DC8AEDA5E8EC77C5C9595F5C0901", hash_generated_field = "FBECC1F0B7896BA34000AC7921CE605B")

    public static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_method = "1511B05B546CB67262D01EAC74D91223", hash_generated_method = "014FC564C485D78CC18EDE0C8BB618E8")
        @Override
        public void setValue(View object, float value) {
            object.setAlpha(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.936 -0400", hash_original_method = "0828A056C08A4787018BC5ECB849DDAD", hash_generated_method = "DE1EB7DBB6E310B0AFAEB58AB78581BF")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_1695897025 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1695897025 = object.getAlpha();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1695897025.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1695897025;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.938 -0400", hash_original_field = "2463A82C1B3B068FBED45F14B07DEA60", hash_generated_field = "AD8D9F358D832E916C04BB8CDF3EDEC7")

    public static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.937 -0400", hash_original_method = "71D30789CC0083AAA14E647D4066A62B", hash_generated_method = "613A1F383C5C797BB24708632A46223C")
        @Override
        public void setValue(View object, float value) {
            object.setTranslationX(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.937 -0400", hash_original_method = "AE4ED8B1A0B86A64F67E6D55304484F8", hash_generated_method = "EF6A5963C1ED79B08D13E56BCB07CE97")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_2123527479 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2123527479 = object.getTranslationX();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2123527479.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2123527479;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.939 -0400", hash_original_field = "7372D8389B757BEF40F84E15ACD0B19E", hash_generated_field = "E222D5A1FC2280E9F226470340A96BC4")

    public static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.938 -0400", hash_original_method = "35EB991A21102AE6A66798A0E05F4EB7", hash_generated_method = "859D2DBB0F6F143B9E2065EC1314D06E")
        @Override
        public void setValue(View object, float value) {
            object.setTranslationY(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.939 -0400", hash_original_method = "602B4C29E3FDDB39DD10FBFA4C1D4EAD", hash_generated_method = "FF4A35C0EA29DC7F31ECDECC03D60CBE")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_1881485096 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1881485096 = object.getTranslationY();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1881485096.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1881485096;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.941 -0400", hash_original_field = "7ABCFD2CD0D4C099DC453E558FE85F44", hash_generated_field = "A3728D78CC7E34B9772CC79423DCBDD1")

    public static Property<View, Float> X = new FloatProperty<View>("x") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.940 -0400", hash_original_method = "942D12A2907E436F9DD2D5A3BB599D1C", hash_generated_method = "5673AD22F2B7A4B4A4DB7FC87A386EBB")
        @Override
        public void setValue(View object, float value) {
            object.setX(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.941 -0400", hash_original_method = "87F550DC0E1D4FED879AF17D796C775D", hash_generated_method = "D095DD87E4223ADD802923E40E611854")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_1503250681 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1503250681 = object.getX();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1503250681.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1503250681;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.942 -0400", hash_original_field = "CFD3CAFD4126436BCB87BFC085957E57", hash_generated_field = "9BC2065962C2C3CCB0E3167C85CF0F86")

    public static Property<View, Float> Y = new FloatProperty<View>("y") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.942 -0400", hash_original_method = "F66C6BF603238C3B745DBF80CCB68E15", hash_generated_method = "DEA583D8267371BB5F5499D21CFA9376")
        @Override
        public void setValue(View object, float value) {
            object.setY(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.942 -0400", hash_original_method = "107F13AA20F45AE0A7AF10B2A89B1B3D", hash_generated_method = "839E3912C2E8E9146BDB9AA8C47F9C13")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_626871970 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_626871970 = object.getY();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_626871970.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_626871970;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.944 -0400", hash_original_field = "E56D0E5046417B3F74FFC7B03E80BE5C", hash_generated_field = "4907F259669A69B8844D7C89C2713884")

    public static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.943 -0400", hash_original_method = "E4DD5C8F5E4B6A35D65B3372F3D8BFBA", hash_generated_method = "7B87B76B28B2CCC97296B3440E96F4B8")
        @Override
        public void setValue(View object, float value) {
            object.setRotation(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.944 -0400", hash_original_method = "6F0DC1763312BEA34F1272E5458BA30D", hash_generated_method = "922530A3FB6416251576E0357B8C4C69")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_71805431 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_71805431 = object.getRotation();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_71805431.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_71805431;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.946 -0400", hash_original_field = "E6B3F0C9E4238E32ABB7463CE9AD008B", hash_generated_field = "4BD89C92D17FA0771933817A93E913E9")

    public static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.945 -0400", hash_original_method = "D8E97A391BF9703940D7A06280ABBB3F", hash_generated_method = "50B23055286DFEC2BEF078575B84D379")
        @Override
        public void setValue(View object, float value) {
            object.setRotationX(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.946 -0400", hash_original_method = "3FE8B70962F32AF948528D0D6E8ED1AF", hash_generated_method = "D5B5C4E91B950AFF30E17F5954C40A12")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_86353170 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_86353170 = object.getRotationX();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_86353170.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_86353170;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.947 -0400", hash_original_field = "E871DD5638C4B35E145FF614A448D053", hash_generated_field = "F195AF0D0B75ED1ABC9BEE1FAC0B8AA5")

    public static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.946 -0400", hash_original_method = "CDE80AB2A44D5B173DB76AD6CA4559A4", hash_generated_method = "6BFA4FE5AFEE6877C144D55E489FA238")
        @Override
        public void setValue(View object, float value) {
            object.setRotationY(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.947 -0400", hash_original_method = "EE835584282672E99083546AE5304355", hash_generated_method = "79705676E50FDCB272E3CA453652BF3F")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_363068760 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_363068760 = object.getRotationY();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_363068760.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_363068760;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.948 -0400", hash_original_field = "D10E65978F70513DFF3F1897F968D4D2", hash_generated_field = "E9378A7F33D39385F814A55ABD5667DC")

    public static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.947 -0400", hash_original_method = "1B653DA1FDE36CFBF0835E42B933826F", hash_generated_method = "6407D9D8200FAC2F976B75EF5CEBDEB3")
        @Override
        public void setValue(View object, float value) {
            object.setScaleX(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.948 -0400", hash_original_method = "A2F336BAC519262505475338F6D5EC55", hash_generated_method = "FD72E4D0834310FB6ABC65B4538C40D0")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_577436261 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_577436261 = object.getScaleX();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_577436261.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_577436261;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.949 -0400", hash_original_field = "5ABACA635607E234A6DDA7D7BAA57212", hash_generated_field = "7719A1959F9F1CCD5193A8994F496983")

    public static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.948 -0400", hash_original_method = "1D5FE7CAB5F43F92B9050D214C28178E", hash_generated_method = "D1BA0A2967AE20F37607AFC8879E09FD")
        @Override
        public void setValue(View object, float value) {
            object.setScaleY(value);
            addTaint(object.getTaint());
            addTaint(value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.949 -0400", hash_original_method = "CDBF0205ED6FCB3C37D74DE97C039D1E", hash_generated_method = "421C6105718F928B8583D864D18A3DBF")
        @Override
        public Float get(View object) {
            Float varB4EAC82CA7396A68D541C85D26508E83_1092074713 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1092074713 = object.getScaleY();
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1092074713.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1092074713;
            
            
        }

        
};
}

