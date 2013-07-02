package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "B2E23F53603EF963174A5DCDD21E377A", hash_generated_field = "DD721D19F83A9531A571F53535845605")

    private SparseArray<Object> mKeyedTags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "81C8D8BB5EDA313C426D4F0583A37B0F", hash_generated_field = "1A75C99521C9A69968375361930C982C")

    protected Animation mCurrentAnimation = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "30AF844796D32E1DD6D14B620B8355DF", hash_generated_field = "8AF08A92D2F66E40D67BD95DF20644CE")

    @ViewDebug.ExportedProperty(category = "measurement") int mMeasuredWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "0EF7F253195B445FA5A8B4E98FA98667", hash_generated_field = "92147C8788B6F0CA2DABA1FB3B19E8BF")

    @ViewDebug.ExportedProperty(category = "measurement") int mMeasuredHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "FA31AC557740873AF5104338EBA7FC19", hash_generated_field = "2D6D8008671A06EF61654718BEF765EB")

    boolean mRecreateDisplayList = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "5FFDC6E17099498D1825C5220B9BD0AE", hash_generated_field = "AFA40CB29D8B77AA456CB799510E6286")

    @ViewDebug.ExportedProperty(resolveId = true) int mID = NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "8EA4018BB68ADA26F78B9B1F42A67958", hash_generated_field = "CDDE4755ADE2BC204930CA88B5DBB470")

    int mAccessibilityViewId = NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "91C972E269A3F4396E01E84D6E3CCC58")

    protected Object mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "A3201A672D71DD5A79F87DF520AF188A", hash_generated_field = "7014A987CDECAA2300639BF21EC914DD")

    private int mOverScrollMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "E798458702129E681480C3268D9EB850")

    protected ViewParent mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "B1A49FF62D92BCD8AE5C70F97D680510", hash_generated_field = "7DACD6A85AA040B3D0EFA6ECFB8BF661")

    AttachInfo mAttachInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "DD07F24B502147BA1093569C14614DF6", hash_generated_field = "4B9A7C2E7189666FEFF6FEA48770F96F")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "28E81DB49C33C12590DE3E9CA12A7A01", hash_generated_field = "A70874573E565834837AE3AE1A44105E")

    int mPrivateFlags2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "D03AF504A7FB8D1F39097D83B42BDFFD", hash_generated_field = "18478E9808210D74729295E4C33E2EEB")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "B4EADC228928954D156338C2784E8E5E", hash_generated_field = "AA3BA123C58FF5925198746B8B561359")

    int mWindowAttachCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "131BCA992A092424AD9B21CD196A5A23", hash_generated_field = "AC04A604736B65491405D9541E300EF7")

    protected ViewGroup.LayoutParams mLayoutParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "B4A6C3081B601CA613414848B92AAEAE", hash_generated_field = "D35E3C6B5D57FAA3D36920801FB7F998")

    @ViewDebug.ExportedProperty int mViewFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "06B81BDBD4699F35D8DC8F52040A7EB4", hash_generated_field = "814413531F598274EEECF8BE645FBF8D")

    TransformationInfo mTransformationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "9FEFCB6583E51099148CCC96D70DF025", hash_generated_field = "62AEC70730E07CC33ABF33611E56E0C9")

    private boolean mLastIsOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "B5B776A6642DD69B16A47E6FCCAEEB6E", hash_generated_field = "B0CFD8B13BD2121822E87395D9B5EB0A")

    @ViewDebug.ExportedProperty(category = "layout") protected int mLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "720807298C0DE3DCF41AEC725F26A5A1", hash_generated_field = "51E02A5FF8AC135FCB771EE787BDB4C9")

    @ViewDebug.ExportedProperty(category = "layout") protected int mRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "D09DA346C6637C81F0228C8D0347388B", hash_generated_field = "496CBAA35C1D669530329F97A9C74114")

    @ViewDebug.ExportedProperty(category = "layout") protected int mTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "2FFD20D7E48915664FDF7F12FC3889D8", hash_generated_field = "6F474ED228AC76685E91ED773CB73395")

    @ViewDebug.ExportedProperty(category = "layout") protected int mBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "9DC8F9676E14E93147EBEA37CE364B55", hash_generated_field = "1ACB7D4E721E5C41E8206F696A6DB2DB")

    @ViewDebug.ExportedProperty(category = "scrolling") protected int mScrollX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "4ABBFD585ECE4FE40BECD8E0C30C4E5E", hash_generated_field = "3AE77EDF3F10D09CA5B3A9FC1C16B667")

    @ViewDebug.ExportedProperty(category = "scrolling") protected int mScrollY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "252F7DBD6188FA4BC0CBCF5785506FD8", hash_generated_field = "0D018CC517023EE199B2A8DAA6ECB500")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "1CC5609E099825B7F5335F0151334D28", hash_generated_field = "AEE809A9BA21DCA8517E2AD9D955D3B7")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "160C8C8F6F0F40401734402AE62419A9", hash_generated_field = "12E040F5B926130031C2D0EA1ECAF1B8")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingTop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "DC0A1BD9ED7E0615D8F16D5DA74E6D47", hash_generated_field = "AB005070934C3278D46BFF088EA941B9")

    @ViewDebug.ExportedProperty(category = "padding") protected int mPaddingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "073D0187C9F61FAD4E5B0B851BDDC2B3", hash_generated_field = "8594C4137F32107058E48C17931382B5")

    private CharSequence mContentDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "72448C4AF26CE8C6C66360ACE1566CFE", hash_generated_field = "24275D1D330A85C524C74A0B09414AAB")

    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingRight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "CEB8CA928CC6F1226E948D86A175A8FC", hash_generated_field = "0C4869EF67BF3E50F8F10A68C2F9D716")

    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingBottom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "3C518AC9A0E1AF98691ADD3A8A1CCB30", hash_generated_field = "1BE3737E54325E6415262D1A90E67453")

    @ViewDebug.ExportedProperty(category = "padding") protected int mUserPaddingLeft;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "5E1288938438CBB6C9289BF968E78727", hash_generated_field = "B3EF2958202B8FBC0F390975B72C0AB1")

    @ViewDebug.ExportedProperty(category = "padding") boolean mUserPaddingRelative;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "82E152642CCF26B8B66B0CCCFE09EA44", hash_generated_field = "BFF4356AD8CC83E6872ED1781251B206")

    @ViewDebug.ExportedProperty(category = "padding") int mUserPaddingStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "4DBF4950DA8FCB8889499A80DAA6625F", hash_generated_field = "C099602A54FEC808EF713AD0C3E426B1")

    @ViewDebug.ExportedProperty(category = "padding") int mUserPaddingEnd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "82845C8137ABB799EDEBA2102E5BC6CA", hash_generated_field = "3BFE3DAC86E051A37E15269C1EBC8E4B")

    int mOldWidthMeasureSpec = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "F07A0625188625F817BFD34F6D66B011", hash_generated_field = "1C3D2A3A966DD51630301EB9B47C35E5")

    int mOldHeightMeasureSpec = Integer.MIN_VALUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "AE73D526548104E4C1E17F7F245F81BC", hash_generated_field = "CD7692461BCF8CBA84620403F5E57E2E")

    private Drawable mBGDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "402426C85408915526629956C0CDBBC1", hash_generated_field = "EFFE71B257E8A8B334669D80482775BC")

    private int mBackgroundResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "8AFEAE5A926044C2D360A11EA8458209", hash_generated_field = "308B2769E6A04DC50D717155A3FFF7C8")

    private boolean mBackgroundSizeChanged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "78118D1764B56569D6B6E6C626D161A5", hash_generated_field = "29D621A32636521FA6951DD85766CC20")

    ListenerInfo mListenerInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.430 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "AC1C3EE794A682BD562C18565142DA7C", hash_generated_field = "8ED80A3CDB45EFD1EC966904F18B0C41")

    private ScrollabilityCache mScrollCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "60876A8DC985533C9A9E5260A5B1C8A3", hash_generated_field = "51C006923E88A244E6B4A81FAACDA6EF")

    private int[] mDrawableState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "A475F3D92E5FAC2EB37DD88F537E2964", hash_generated_field = "8763FD238D26A060847D5BFD5F110B02")

    public boolean mCachingFailed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "00D13CF2B6143C87E634D4CF05F6DBCC", hash_generated_field = "3DD824BE1FD179F4F5718F6A857553E0")

    private Bitmap mDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "9D429DAE730251946D577870B67FB966", hash_generated_field = "03126783BB83E37A27CE046D8A79B1C7")

    private Bitmap mUnscaledDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "B56FE185AB9316DBDB054606F5602E90", hash_generated_field = "CE60F7E3CE3B2722E2B23845AC923EB1")

    private HardwareLayer mHardwareLayer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "28797884D8917814D2A66A0146DC8FD5", hash_generated_field = "4FBA01527B47AF659DF19EA16E769B16")

    DisplayList mDisplayList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "2205CD40A12D3B9963716F25F00C61E5", hash_generated_field = "45B02C2955F0D136C014E9DC60FE3184")

    private int mNextFocusLeftId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "A47FAC14D63975AE3196CF8FC5EF36FD", hash_generated_field = "DF84F09C311C486A086B9C7EA2243503")

    private int mNextFocusRightId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "EA75E9C31361CFF469517E9FD54298D6", hash_generated_field = "9F4730280C31C2719C1F46BE8E8450BA")

    private int mNextFocusUpId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "A2B6D0B87912715ADB1AD5C9738CF374", hash_generated_field = "319D75290A4647F72AD3D5A42A864E5C")

    private int mNextFocusDownId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "B00173086AA038860B98671358FAAC9B", hash_generated_field = "218707A9C3C12F8433C4FECF627C213D")

    int mNextFocusForwardId = View.NO_ID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "956789F3DA470AD87E91A7076E41578B", hash_generated_field = "AAAA968A40447481F73888524A1890C6")

    private CheckForLongPress mPendingCheckForLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "775B249E2D7CD12DF12303812684BB7B", hash_generated_field = "B8AF3727C0596C63ED7DB54BAD71671F")

    private CheckForTap mPendingCheckForTap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "83D78F1B989F8D62D88496F5EC6FF33F", hash_generated_field = "99E4AAED357F9D1925CADBAC4D6015A4")

    private PerformClick mPerformClick;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "3A6CE60FA7A6FA838255E6DD66DA4901", hash_generated_field = "4EE5120DCD6EBA553548CD3C570A5967")

    private SendViewScrolledAccessibilityEvent mSendViewScrolledAccessibilityEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "1D15E7AFACCA72AA82FDEB1ED50C858E", hash_generated_field = "CDF30A3821A23955C4124811C1CA0AEA")

    private UnsetPressedState mUnsetPressedState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "5A2F892720FCFD0DC61FB4EFF8239FF9", hash_generated_field = "751618E4ED7D5DBDA5B68F37D9865720")

    private boolean mHasPerformedLongPress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "7B1C5936E045E46CDC7DE29B76B9E7F4", hash_generated_field = "F1A8CDC4E26D8D5C7DE32B2AF25C8740")

    @ViewDebug.ExportedProperty(category = "measurement") private int mMinHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "4FCEB583348C4614E548F5AFAEC98A67")

    @ViewDebug.ExportedProperty(category = "measurement") private int mMinWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "507FCACB9EF82E081076A9EEAEBF9B63", hash_generated_field = "E569734BF8D6E083A22CF46961923ECB")

    private TouchDelegate mTouchDelegate = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "6EDC251E57408BDC16F07004B6855199", hash_generated_field = "D92790A9877C98F11E8F179FB043C786")

    private int mDrawingCacheBackgroundColor = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "B97920548B94E92CFDC64D305AC20F69", hash_generated_field = "A0D36EEAADCE4EE07A5AC99F73C584E9")

    private ViewTreeObserver mFloatingTreeObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "40F78C707625DBFDC188EF24918066C8", hash_generated_field = "031DB2A7C2250D8B7DE4F6272C82D45E")

    private ViewPropertyAnimator mAnimator = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "790487E83CF3B009D444C02267049200", hash_generated_field = "2607C5FC6CCACC3F7D721707ADA72671")

    private float mVerticalScrollFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "87A1A37696C42230D03AF78A00037CA3", hash_generated_field = "4F21705D0823B901E43594B264DCB237")

    private int mVerticalScrollbarPosition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "FFD6DFFEEF7D4409E878CD8773FFADFF", hash_generated_field = "76D9A2089F38CDD618BD49C87D710C3C")

    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
            @ViewDebug.IntToString(from = LAYER_TYPE_NONE, to = "NONE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_SOFTWARE, to = "SOFTWARE"),
            @ViewDebug.IntToString(from = LAYER_TYPE_HARDWARE, to = "HARDWARE")
    }) int mLayerType = LAYER_TYPE_NONE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "5870A18F50D7C3B8DE43F07B2A8E2BC8", hash_generated_field = "DF81DF3E7FE84B1D663D7E8ECAF0C794")

    Paint mLayerPaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "FA0B46D25C5CFBAFDF9C3E8111032A29", hash_generated_field = "5423282DE76FBF7AAAD365160A805585")

    Rect mLocalDirtyRect;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "08B5E57DCB5E26E7EF1C647028B3CDC5", hash_generated_field = "D73DE13E5337A6B5E189A73C651B0933")

    private boolean mSendingHoverAccessibilityEvents;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "AB14B73F2A537D26873B7CD3721A2654", hash_generated_field = "ACE9AD3D63F4A66B9F893798ED18776A")

    AccessibilityDelegate mAccessibilityDelegate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "56F776C2E6CE1ACD33CDE41CE78F02EC", hash_generated_field = "B72A5C45BF32E84602E6733FBFEC7DAD")

    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    }) private int mTextDirection = DEFAULT_TEXT_DIRECTION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "CA7F7356F0500733AA9EAA872F25A83A", hash_generated_field = "318F54594F0F5ED162811E42E0595AEA")

    @ViewDebug.ExportedProperty(category = "text", mapping = {
            @ViewDebug.IntToString(from = TEXT_DIRECTION_INHERIT, to = "INHERIT"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_FIRST_STRONG, to = "FIRST_STRONG"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_ANY_RTL, to = "ANY_RTL"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_LTR, to = "LTR"),
            @ViewDebug.IntToString(from = TEXT_DIRECTION_RTL, to = "RTL")
    }) private int mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.431 -0400", hash_original_field = "EFB0BA2843C7293EEB82F8592A2A0298", hash_generated_field = "FBF46F0211B74BEC9C47C5EFFAF36A72")

    protected final InputEventConsistencyVerifier mInputEventConsistencyVerifier = InputEventConsistencyVerifier.isInstrumentationEnabled() ?
                    new InputEventConsistencyVerifier(this, 0) : null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.432 -0400", hash_original_method = "6E480C32A7FC910695FE07C33ABF7A7A", hash_generated_method = "AD454F01B4A79F64B85B96CBA3B68A9E")
    public  View(Context context) {
        mContext = context;
        mResources = context != null ? context.getResources() : null;
        mViewFlags = SOUND_EFFECTS_ENABLED | HAPTIC_FEEDBACK_ENABLED | LAYOUT_DIRECTION_INHERIT;
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setOverScrollMode(OVER_SCROLL_IF_CONTENT_SCROLLS);
        mUserPaddingStart = -1;
        mUserPaddingEnd = -1;
        mUserPaddingRelative = false;
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.435 -0400", hash_original_method = "7A0AD99F840E8369EC476A6B56BA8ADA", hash_generated_method = "00397D0AF16E98E30CF9582D6D39EE0E")
    public  View(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.439 -0400", hash_original_method = "F8E7269105FB2D522A5F7FAB2F89EE95", hash_generated_method = "06FDACD94B141F330EF81DB3CEFADA6B")
    public  View(Context context, AttributeSet attrs, int defStyle) {
        this(context);
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
        {
            int i = 0;
            {
                int attr = a.getIndex(i);
                
                background = a.getDrawable(attr);
                
                
                padding = a.getDimensionPixelSize(attr, -1);
                
                
                leftPadding = a.getDimensionPixelSize(attr, -1);
                
                
                topPadding = a.getDimensionPixelSize(attr, -1);
                
                
                rightPadding = a.getDimensionPixelSize(attr, -1);
                
                
                bottomPadding = a.getDimensionPixelSize(attr, -1);
                
                
                startPadding = a.getDimensionPixelSize(attr, -1);
                
                
                endPadding = a.getDimensionPixelSize(attr, -1);
                
                
                x = a.getDimensionPixelOffset(attr, 0);
                
                
                y = a.getDimensionPixelOffset(attr, 0);
                
                
                setAlpha(a.getFloat(attr, 1f));
                
                
                setPivotX(a.getDimensionPixelOffset(attr, 0));
                
                
                setPivotY(a.getDimensionPixelOffset(attr, 0));
                
                
                tx = a.getDimensionPixelOffset(attr, 0);
                
                
                transformSet = true;
                
                
                ty = a.getDimensionPixelOffset(attr, 0);
                
                
                transformSet = true;
                
                
                rotation = a.getFloat(attr, 0);
                
                
                transformSet = true;
                
                
                rotationX = a.getFloat(attr, 0);
                
                
                transformSet = true;
                
                
                rotationY = a.getFloat(attr, 0);
                
                
                transformSet = true;
                
                
                sx = a.getFloat(attr, 1f);
                
                
                transformSet = true;
                
                
                sy = a.getFloat(attr, 1f);
                
                
                transformSet = true;
                
                
                mID = a.getResourceId(attr, NO_ID);
                
                
                mTag = a.getText(attr);
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_279772812 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FITS_SYSTEM_WINDOWS;
                        viewFlagMasks |= FITS_SYSTEM_WINDOWS;
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_274859969 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FOCUSABLE;
                        viewFlagMasks |= FOCUSABLE_MASK;
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1764695657 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE;
                        viewFlagMasks |= FOCUSABLE_IN_TOUCH_MODE | FOCUSABLE_MASK;
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1308169927 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= CLICKABLE;
                        viewFlagMasks |= CLICKABLE;
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_846595932 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= LONG_CLICKABLE;
                        viewFlagMasks |= LONG_CLICKABLE;
                    } 
                } 
                
                
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_344607049 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues |= SAVE_DISABLED;
                        viewFlagMasks |= SAVE_DISABLED_MASK;
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1789097241 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= DUPLICATE_PARENT_STATE;
                        viewFlagMasks |= DUPLICATE_PARENT_STATE;
                    } 
                } 
                
                
                final int visibility = a.getInt(attr, 0);
                
                
                {
                    viewFlagValues |= VISIBILITY_FLAGS[visibility];
                    viewFlagMasks |= VISIBILITY_MASK;
                } 
                
                
                viewFlagValues &= ~LAYOUT_DIRECTION_MASK;
                
                
                final int layoutDirection = a.getInt(attr, -1);
                
                
                {
                    viewFlagValues |= LAYOUT_DIRECTION_FLAGS[layoutDirection];
                } 
                {
                    viewFlagValues |= LAYOUT_DIRECTION_DEFAULT;
                } 
                
                
                viewFlagMasks |= LAYOUT_DIRECTION_MASK;
                
                
                final int cacheQuality = a.getInt(attr, 0);
                
                
                {
                    viewFlagValues |= DRAWING_CACHE_QUALITY_FLAGS[cacheQuality];
                    viewFlagMasks |= DRAWING_CACHE_QUALITY_MASK;
                } 
                
                
                mContentDescription = a.getString(attr);
                
                
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_237934094 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues &= ~SOUND_EFFECTS_ENABLED;
                        viewFlagMasks |= SOUND_EFFECTS_ENABLED;
                    } 
                } 
                
                
                {
                    boolean varE83A5B5DD6F1EFE4CE2BCD602A46684B_970155553 = (!a.getBoolean(attr, true));
                    {
                        viewFlagValues &= ~HAPTIC_FEEDBACK_ENABLED;
                        viewFlagMasks |= HAPTIC_FEEDBACK_ENABLED;
                    } 
                } 
                
                
                final int scrollbars = a.getInt(attr, SCROLLBARS_NONE);
                
                
                {
                    viewFlagValues |= scrollbars;
                    viewFlagMasks |= SCROLLBARS_MASK;
                    initializeScrollbars(a);
                } 
                
                
                {
                    boolean varC070C09F5C0916551B09381C0852B394_58307377 = (context.getApplicationInfo().targetSdkVersion >= ICE_CREAM_SANDWICH);
                } 
                
                
                final int fadingEdge = a.getInt(attr, FADING_EDGE_NONE);
                
                
                {
                    viewFlagValues |= fadingEdge;
                    viewFlagMasks |= FADING_EDGE_MASK;
                    initializeFadingEdge(a);
                } 
                
                
                scrollbarStyle = a.getInt(attr, SCROLLBARS_INSIDE_OVERLAY);
                
                
                {
                    viewFlagValues |= scrollbarStyle & SCROLLBARS_STYLE_MASK;
                    viewFlagMasks |= SCROLLBARS_STYLE_MASK;
                } 
                
                
                setScrollContainer = true;
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_961967928 = (a.getBoolean(attr, false));
                    {
                        setScrollContainer(true);
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_542865133 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= KEEP_SCREEN_ON;
                        viewFlagMasks |= KEEP_SCREEN_ON;
                    } 
                } 
                
                
                {
                    boolean var45591D90FC7AE21A8CB6FE28079E45A9_1113795497 = (a.getBoolean(attr, false));
                    {
                        viewFlagValues |= FILTER_TOUCHES_WHEN_OBSCURED;
                        viewFlagMasks |= FILTER_TOUCHES_WHEN_OBSCURED;
                    } 
                } 
                
                
                mNextFocusLeftId = a.getResourceId(attr, View.NO_ID);
                
                
                mNextFocusRightId = a.getResourceId(attr, View.NO_ID);
                
                
                mNextFocusUpId = a.getResourceId(attr, View.NO_ID);
                
                
                mNextFocusDownId = a.getResourceId(attr, View.NO_ID);
                
                
                mNextFocusForwardId = a.getResourceId(attr, View.NO_ID);
                
                
                mMinWidth = a.getDimensionPixelSize(attr, 0);
                
                
                mMinHeight = a.getDimensionPixelSize(attr, 0);
                
                
                {
                    boolean var493A86E51AC82FCCEFBD5D9BA92432B0_2030471368 = (context.isRestricted());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The android:onClick attribute cannot "
                                + "be used within a restricted context");
                    } 
                } 
                
                
                final String handlerName = a.getString(attr);
                
                
                {
                    setOnClickListener(new OnClickListener() {                        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.437 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "DD76E21366B40D00A372B0BC0CE30131")
                        private Method mHandler;
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.438 -0400", hash_original_method = "E9EFDD10534D1BAF541333BA74E853ED", hash_generated_method = "FBC50A1D0ADCA4625792E0F0AFC6C78E")
                        public void onClick(View v) {
                            
                            {
                                try 
                                {
                                    mHandler = getContext().getClass().getMethod(handlerName,
                                                View.class);
                                } 
                                catch (NoSuchMethodException e)
                                {
                                    int id = getId();
                                    String idText;
                                    idText = "";
                                    idText = " with id '"
                                                + getContext().getResources().getResourceEntryName(
                                                    id) + "'";
                                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not find a method " +
                                                handlerName + "(View) in the activity "
                                                + getContext().getClass() + " for onClick handler"
                                                + " on view " + View.this.getClass() + idText, e);
                                } 
                            } 
                            try 
                            {
                                mHandler.invoke(getContext(), View.this);
                            } 
                            catch (IllegalAccessException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not execute non "
                                            + "public method of the activity", e);
                            } 
                            catch (InvocationTargetException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Could not execute "
                                            + "method of the activity", e);
                            } 
                            addTaint(v.getTaint());
                            
                            
                        }
});
                } 
                
                
                overScrollMode = a.getInt(attr, OVER_SCROLL_IF_CONTENT_SCROLLS);
                
                
                mVerticalScrollbarPosition = a.getInt(attr, SCROLLBAR_POSITION_DEFAULT);
                
                
                setLayerType(a.getInt(attr, LAYER_TYPE_NONE), null);
                
                
                mTextDirection = a.getInt(attr, DEFAULT_TEXT_DIRECTION);
                
            } 
        } 
        a.recycle();
        setOverScrollMode(overScrollMode);
        {
            setBackgroundDrawable(background);
        } 
        mUserPaddingRelative = (startPadding >= 0 || endPadding >= 0);
        mUserPaddingStart = startPadding;
        mUserPaddingEnd = endPadding;
        {
            leftPadding = padding;
            topPadding = padding;
            rightPadding = padding;
            bottomPadding = padding;
        } 
        setPadding(leftPadding >= 0 ? leftPadding : mPaddingLeft,
                topPadding >= 0 ? topPadding : mPaddingTop,
                rightPadding >= 0 ? rightPadding : mPaddingRight,
                bottomPadding >= 0 ? bottomPadding : mPaddingBottom);
        {
            setFlags(viewFlagValues, viewFlagMasks);
        } 
        {
            recomputePadding();
        } 
        {
            scrollTo(x, y);
        } 
        {
            setTranslationX(tx);
            setTranslationY(ty);
            setRotation(rotation);
            setRotationX(rotationX);
            setRotationY(rotationY);
            setScaleX(sx);
            setScaleY(sy);
        } 
        {
            setScrollContainer(true);
        } 
        computeOpaqueFlags();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.440 -0400", hash_original_method = "5C3A364FECC6F7D07E7A546170C25E98", hash_generated_method = "32A2A5FFE588BE14FBF7F5D017C5A252")
      View() {
        mResources = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.440 -0400", hash_original_method = "F39CEBF0E5E47A818635618D8F975382", hash_generated_method = "D576B5DC26D7FBDAD21E367A9288C3E9")
    protected void initializeFadingEdge(TypedArray a) {
        initScrollCache();
        mScrollCache.fadingEdgeLength = a.getDimensionPixelSize(
                R.styleable.View_fadingEdgeLength,
                ViewConfiguration.get(mContext).getScaledFadingEdgeLength());
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.440 -0400", hash_original_method = "48BE981E65F7E857DD7A9FF8EF5006FF", hash_generated_method = "21BF2BCFD1179613956139A58184DF98")
    public int getVerticalFadingEdgeLength() {
        {
            boolean var50B16E908CD6883BB4A53F1CCAB8FFC0_612575903 = (isVerticalFadingEdgeEnabled());
            {
                ScrollabilityCache cache = mScrollCache;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360691162 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_360691162;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.440 -0400", hash_original_method = "F316E2F78DFC9160954B8650C58C0898", hash_generated_method = "09B2620993C628341922180F596184D1")
    public void setFadingEdgeLength(int length) {
        initScrollCache();
        mScrollCache.fadingEdgeLength = length;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.441 -0400", hash_original_method = "A8651530AFA26393AFB5F6425B22CDCD", hash_generated_method = "434DAABA8F408AACDE45D603C8FED9AD")
    public int getHorizontalFadingEdgeLength() {
        {
            boolean var5D77CA7D5D90FF39CB3E108D33083F4D_98553482 = (isHorizontalFadingEdgeEnabled());
            {
                ScrollabilityCache cache = mScrollCache;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201068757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_201068757;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.441 -0400", hash_original_method = "9E8BEE4EA7290E77910774FBF44231C2", hash_generated_method = "454FB4770305F85829A74061DBCDEB04")
    public int getVerticalScrollbarWidth() {
        ScrollabilityCache cache = mScrollCache;
        {
            ScrollBarDrawable scrollBar = cache.scrollBar;
            {
                int size = scrollBar.getSize(true);
                {
                    size = cache.scrollBarSize;
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908784457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908784457;
        
        
        
            
            
                
                
                    
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.441 -0400", hash_original_method = "6872C13C59C68BCC5CF5DE777A5D5AA0", hash_generated_method = "3098D645566B60B7B6488F883DE55E0D")
    protected int getHorizontalScrollbarHeight() {
        ScrollabilityCache cache = mScrollCache;
        {
            ScrollBarDrawable scrollBar = cache.scrollBar;
            {
                int size = scrollBar.getSize(false);
                {
                    size = cache.scrollBarSize;
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682013115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682013115;
        
        
        
            
            
                
                
                    
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.442 -0400", hash_original_method = "92AEC3F31170B251C0CC405CA4D3250A", hash_generated_method = "C2CB8B5B06C1BDF8AEEDB05E4C833F2D")
    protected void initializeScrollbars(TypedArray a) {
        initScrollCache();
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        {
            scrollabilityCache.scrollBar = new ScrollBarDrawable();
        } 
        final boolean fadeScrollbars = a.getBoolean(R.styleable.View_fadeScrollbars, true);
        {
            scrollabilityCache.state = ScrollabilityCache.ON;
        } 
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
        {
            scrollabilityCache.scrollBar.setHorizontalThumbDrawable(thumb);
        } 
        boolean alwaysDraw = a.getBoolean(R.styleable.View_scrollbarAlwaysDrawHorizontalTrack,
                false);
        {
            scrollabilityCache.scrollBar.setAlwaysDrawHorizontalTrack(true);
        } 
        track = a.getDrawable(R.styleable.View_scrollbarTrackVertical);
        scrollabilityCache.scrollBar.setVerticalTrackDrawable(track);
        thumb = a.getDrawable(R.styleable.View_scrollbarThumbVertical);
        {
            scrollabilityCache.scrollBar.setVerticalThumbDrawable(thumb);
        } 
        alwaysDraw = a.getBoolean(R.styleable.View_scrollbarAlwaysDrawVerticalTrack,
                false);
        {
            scrollabilityCache.scrollBar.setAlwaysDrawVerticalTrack(true);
        } 
        resolvePadding();
        addTaint(a.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.443 -0400", hash_original_method = "E049E8AF463EFBD39046D8F102EAF6B1", hash_generated_method = "006228A8170D06675B7944AFD610FE31")
    private void initScrollCache() {
        {
            mScrollCache = new ScrollabilityCache(ViewConfiguration.get(mContext), this);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.443 -0400", hash_original_method = "6A347D034BA88A40E4761231BE70B8AA", hash_generated_method = "CBC9F0E4CC2229FC5210E4575370C152")
    public void setVerticalScrollbarPosition(int position) {
        {
            mVerticalScrollbarPosition = position;
            computeOpaqueFlags();
            resolvePadding();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.443 -0400", hash_original_method = "0B028AFE1E9609D00D97AC9B679932DA", hash_generated_method = "030E759F245E98DC7AA87DA842C20238")
    public int getVerticalScrollbarPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058949693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058949693;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.444 -0400", hash_original_method = "3F6307E0FF2B24CF42D639D72702E7A3", hash_generated_method = "4CCBE0467AB7CCA0B0E7408BF5552FC9")
     ListenerInfo getListenerInfo() {
        ListenerInfo varB4EAC82CA7396A68D541C85D26508E83_1125890995 = null; 
        ListenerInfo varB4EAC82CA7396A68D541C85D26508E83_1766434432 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1125890995 = mListenerInfo;
        } 
        mListenerInfo = new ListenerInfo();
        varB4EAC82CA7396A68D541C85D26508E83_1766434432 = mListenerInfo;
        ListenerInfo varA7E53CE21691AB073D9660D615818899_1778262044; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1778262044 = varB4EAC82CA7396A68D541C85D26508E83_1125890995;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1778262044 = varB4EAC82CA7396A68D541C85D26508E83_1766434432;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1778262044.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1778262044;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.444 -0400", hash_original_method = "D8AB5E19AA18F69BACA6EC368D2591FE", hash_generated_method = "B562B80D34F4061A6A11FD4C9AB8BEF1")
    public void setOnFocusChangeListener(OnFocusChangeListener l) {
        getListenerInfo().mOnFocusChangeListener = l;
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.445 -0400", hash_original_method = "E2DB3817E7DB5D233E4A7D6EADE958A3", hash_generated_method = "E526A0C55FF3EE8CA2AEB14A6ED5BE8C")
    public void addOnLayoutChangeListener(OnLayoutChangeListener listener) {
        ListenerInfo li = getListenerInfo();
        {
            li.mOnLayoutChangeListeners = new ArrayList<OnLayoutChangeListener>();
        } 
        {
            boolean var5BC5FBAFE932C29989D14499066114E0_2041538616 = (!li.mOnLayoutChangeListeners.contains(listener));
            {
                li.mOnLayoutChangeListeners.add(listener);
            } 
        } 
        addTaint(listener.getTaint());
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.445 -0400", hash_original_method = "98A56C49B0A9E0F5D269641F74288A13", hash_generated_method = "9624010A065730F99107E26669EE4AF2")
    public void removeOnLayoutChangeListener(OnLayoutChangeListener listener) {
        ListenerInfo li = mListenerInfo;
        li.mOnLayoutChangeListeners.remove(listener);
        addTaint(listener.getTaint());
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.446 -0400", hash_original_method = "BCC986125DE454FD64FA8CF6FF7B3375", hash_generated_method = "81186FA28122BCF0147951A5ED9CE99E")
    public void addOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        ListenerInfo li = getListenerInfo();
        {
            li.mOnAttachStateChangeListeners
                    = new CopyOnWriteArrayList<OnAttachStateChangeListener>();
        } 
        li.mOnAttachStateChangeListeners.add(listener);
        addTaint(listener.getTaint());
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.448 -0400", hash_original_method = "BB59F05E95A495FA9A30543444FC5E76", hash_generated_method = "C68DCDF4677E30AB7E74ECEC5CD9A7E7")
    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener listener) {
        ListenerInfo li = mListenerInfo;
        li.mOnAttachStateChangeListeners.remove(listener);
        addTaint(listener.getTaint());
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.449 -0400", hash_original_method = "A3D291AC9D619397F7033ECE59D11B86", hash_generated_method = "D5E949F28B882FCA3C661F26CB317764")
    public OnFocusChangeListener getOnFocusChangeListener() {
        OnFocusChangeListener varB4EAC82CA7396A68D541C85D26508E83_1112207619 = null; 
        ListenerInfo li = mListenerInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1112207619 = li != null ? li.mOnFocusChangeListener : null;
        varB4EAC82CA7396A68D541C85D26508E83_1112207619.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1112207619;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.449 -0400", hash_original_method = "45F4C058CBC73D55564FBEB6E17C2099", hash_generated_method = "391EC80CF055DD320791878CE461B6A4")
    public void setOnClickListener(OnClickListener l) {
        {
            boolean var04EA38E4DA3FCC73953331C5213AFF9F_2040204452 = (!isClickable());
            {
                setClickable(true);
            } 
        } 
        getListenerInfo().mOnClickListener = l;
        addTaint(l.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.450 -0400", hash_original_method = "8038CCFA19DFF6DCB9855B2C21487DC3", hash_generated_method = "1AB763F26DD4BAE2F8B3E0F75428B1CD")
    public boolean hasOnClickListeners() {
        ListenerInfo li = mListenerInfo;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520754959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520754959;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.450 -0400", hash_original_method = "C88CD920669EF9D2067A739196536F5A", hash_generated_method = "B5256616E36C19DDC1C5E3FD06DEC054")
    public void setOnLongClickListener(OnLongClickListener l) {
        {
            boolean var4E9822764F29F607F332912995A375BC_1521695652 = (!isLongClickable());
            {
                setLongClickable(true);
            } 
        } 
        getListenerInfo().mOnLongClickListener = l;
        addTaint(l.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.451 -0400", hash_original_method = "3B1D28314D3140C1C25951340EB50400", hash_generated_method = "5D700876A1AC01405A0A92B0B10F8469")
    public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
        {
            boolean var4E9822764F29F607F332912995A375BC_1409290655 = (!isLongClickable());
            {
                setLongClickable(true);
            } 
        } 
        getListenerInfo().mOnCreateContextMenuListener = l;
        addTaint(l.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.451 -0400", hash_original_method = "F0CE5BDD9B8548BAC9D7A1A1FC9F10B8", hash_generated_method = "A77D500413CED8647BE0B6614FC9F64E")
    public boolean performClick() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_CLICKED);
        ListenerInfo li = mListenerInfo;
        {
            playSoundEffect(SoundEffectConstants.CLICK);
            li.mOnClickListener.onClick(this);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707279671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707279671;
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.451 -0400", hash_original_method = "102D936797B9C1FC40617DF92F54CFE2", hash_generated_method = "C54265E7AE52B01C9139F02A4825354C")
    public boolean callOnClick() {
        ListenerInfo li = mListenerInfo;
        {
            li.mOnClickListener.onClick(this);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_326011002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_326011002;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.452 -0400", hash_original_method = "00035430EA6437DC8BB5C07835F45B65", hash_generated_method = "781FD84A6A6DE2921FBA6D83FF438E8D")
    public boolean performLongClick() {
        sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_LONG_CLICKED);
        boolean handled = false;
        ListenerInfo li = mListenerInfo;
        {
            handled = li.mOnLongClickListener.onLongClick(View.this);
        } 
        {
            handled = showContextMenu();
        } 
        {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013744090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013744090;
        
        
        
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.452 -0400", hash_original_method = "0AFC4304DA44E934FA35FDC29342C80F", hash_generated_method = "C8C73268E6635B620B7378F4B7D50F4A")
    protected boolean performButtonActionOnTouchDown(MotionEvent event) {
        {
            boolean var431FF76FC0879DE3BD003EA2EA16B78F_412152206 = ((event.getButtonState() & MotionEvent.BUTTON_SECONDARY) != 0);
            {
                {
                    boolean var1A9C8D31FBEACF9594778DB5C5D1B4C1_244366810 = (showContextMenu(event.getX(), event.getY(), event.getMetaState()));
                } 
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718432389 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718432389;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.453 -0400", hash_original_method = "3A1C6F51C14FB3CA1856280BB08BDD78", hash_generated_method = "808F3BDAB51EBC31A4094E5A8D9946C1")
    public boolean showContextMenu() {
        boolean var57558D56D4CFDCF7F086DB96E3562251_1483057156 = (getParent().showContextMenuForChild(this));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460318998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460318998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.453 -0400", hash_original_method = "B2C2D020E619A9A69ACCD76F29CBF0A8", hash_generated_method = "138341150B5C1247783C6B7EF86E3426")
    public boolean showContextMenu(float x, float y, int metaState) {
        boolean varA4958949E9E0853BF05BBEE347C0FF81_1373846361 = (showContextMenu());
        addTaint(x);
        addTaint(y);
        addTaint(metaState);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1038521872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1038521872;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.454 -0400", hash_original_method = "554809A43858BFBD98E9D476D5975BC9", hash_generated_method = "6BA8F209897222D3C2149F6D080E46FD")
    public ActionMode startActionMode(ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1351465819 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1351465819 = getParent().startActionModeForChild(this, callback);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1351465819.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1351465819;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.454 -0400", hash_original_method = "31C7524DA5B5B98F54BA6C8BE0DEBF7E", hash_generated_method = "294CB2950201588ED4A5114BA97E3763")
    public void setOnKeyListener(OnKeyListener l) {
        getListenerInfo().mOnKeyListener = l;
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.454 -0400", hash_original_method = "D8E89DFA5C4F927FE4D243F514232285", hash_generated_method = "41A94930ECBAC1A7614AFF7CE35AA6E6")
    public void setOnTouchListener(OnTouchListener l) {
        getListenerInfo().mOnTouchListener = l;
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.454 -0400", hash_original_method = "A6ED4A9DC8C6B322504EFE7525CB31A1", hash_generated_method = "CB031BE34EEF52F9B8F48225C8DBA900")
    public void setOnGenericMotionListener(OnGenericMotionListener l) {
        getListenerInfo().mOnGenericMotionListener = l;
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.455 -0400", hash_original_method = "A231A17C6E4AE608F5CD4B1132C585A7", hash_generated_method = "5D22CC0CB48D300F64F3712B52B69F0F")
    public void setOnHoverListener(OnHoverListener l) {
        getListenerInfo().mOnHoverListener = l;
        addTaint(l.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.455 -0400", hash_original_method = "8FD55843B8D7F3FEDE7B7D516A1E3E35", hash_generated_method = "A9968561BDC0011E33B09237CF6CFF77")
    public void setOnDragListener(OnDragListener l) {
        getListenerInfo().mOnDragListener = l;
        addTaint(l.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.456 -0400", hash_original_method = "16B5A8656CEB6785661CF48B92B45991", hash_generated_method = "0E462B4578169A032465CD2E0962E903")
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        {
            System.out.println(this + " requestFocus()");
        } 
        {
            mPrivateFlags |= FOCUSED;
            {
                mParent.requestChildFocus(this, this);
            } 
            onFocusChanged(true, direction, previouslyFocusedRect);
            refreshDrawableState();
        } 
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
            
        
        
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.457 -0400", hash_original_method = "2192BF4A933C90A79FE0C71F9C0B2F3D", hash_generated_method = "AFA442E6DBEB4946E768E5071EAE9E85")
    public boolean requestRectangleOnScreen(Rect rectangle) {
        boolean varB53A64F27CEF8B117CF782EC0F44B212_570259134 = (requestRectangleOnScreen(rectangle, false));
        addTaint(rectangle.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_585796746 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_585796746;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.458 -0400", hash_original_method = "BDB750CCBE647F1CD5444CDF496F66A3", hash_generated_method = "D1373A0F6379B4F77F676FD44AEABC7C")
    public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
        View child = this;
        ViewParent parent = mParent;
        boolean scrolled = false;
        {
            scrolled |= parent.requestChildRectangleOnScreen(child,
                    rectangle, immediate);
            rectangle.offset(child.getLeft(), child.getTop());
            rectangle.offset(-child.getScrollX(), -child.getScrollY());
            child = (View) parent;
            parent = child.getParent();
        } 
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054132643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054132643;
        
        
        
        
        
            
                    
            
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.459 -0400", hash_original_method = "A6F69BAD809415BD5537E3FD153C267F", hash_generated_method = "E804AFE297232281A3D184C897B2A3B3")
    public void clearFocus() {
        {
            System.out.println(this + " clearFocus()");
        } 
        {
            mPrivateFlags &= ~FOCUSED;
            {
                mParent.clearChildFocus(this);
            } 
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } 
        
        
            
        
        
            
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.459 -0400", hash_original_method = "B948A77A86E2A2242F3F753171415A6F", hash_generated_method = "E185FEEAEED513A145564C4D000D5AD6")
     void clearFocusForRemoval() {
        {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.460 -0400", hash_original_method = "895408B45B14DF7336768B76769FDFBE", hash_generated_method = "8CFD639286A261F7C8B5F8F3C689E3F6")
     void unFocus() {
        {
            System.out.println(this + " unFocus()");
        } 
        {
            mPrivateFlags &= ~FOCUSED;
            onFocusChanged(false, 0, null);
            refreshDrawableState();
        } 
        
        
            
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.460 -0400", hash_original_method = "337547862E6B052D2DEF8F8E7CCEA590", hash_generated_method = "374E55EAF49BB2233CF278905E0487EA")
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean hasFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1652315989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1652315989;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.460 -0400", hash_original_method = "B2402A510BB29E4C255854E18659AE1B", hash_generated_method = "50EB82FF6CEC80132B117AA63BF5F92C")
    public boolean hasFocusable() {
        boolean var45438BF76A2F167C289F26830B3A9B93_1977874261 = ((mViewFlags & VISIBILITY_MASK) == VISIBLE && isFocusable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_981434270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_981434270;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.461 -0400", hash_original_method = "5A1E14083BB718E6700BA53BA3884697", hash_generated_method = "6357CC758C9F82F7527EB0298B82B8E5")
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        
        {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
        } 
        InputMethodManager imm = InputMethodManager.peekInstance();
        {
            {
                boolean varF27F491A5EAB0B2989FBEF44657192A7_1832759669 = (isPressed());
                {
                    setPressed(false);
                } 
            } 
            {
                imm.focusOut(this);
            } 
            onFocusLost();
        } 
        {
            imm.focusIn(this);
        } 
        invalidate(true);
        ListenerInfo li = mListenerInfo;
        {
            li.mOnFocusChangeListener.onFocusChange(this, gainFocus);
        } 
        {
            mAttachInfo.mKeyDispatchState.reset(this);
        } 
        addTaint(gainFocus);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.461 -0400", hash_original_method = "67C8279330D12E8D41FE4F9795D7EB79", hash_generated_method = "443DCFE8D319517E5CCCF7FDF2380E1F")
    public void sendAccessibilityEvent(int eventType) {
        {
            mAccessibilityDelegate.sendAccessibilityEvent(this, eventType);
        } 
        {
            sendAccessibilityEventInternal(eventType);
        } 
        addTaint(eventType);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.461 -0400", hash_original_method = "BE2AB20B544FD38FEA2111E9FF446FAD", hash_generated_method = "A4479704D853EB0ED1B4E38257669FE4")
     void sendAccessibilityEventInternal(int eventType) {
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_2084593557 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                sendAccessibilityEventUnchecked(AccessibilityEvent.obtain(eventType));
            } 
        } 
        addTaint(eventType);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.462 -0400", hash_original_method = "B790306D0C64AC6AB0D8747A1C899258", hash_generated_method = "E7C7A44253D65A405CDA02739031BA76")
    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        {
            mAccessibilityDelegate.sendAccessibilityEventUnchecked(this, event);
        } 
        {
            sendAccessibilityEventUncheckedInternal(event);
        } 
        addTaint(event.getTaint());
        
        
           
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.462 -0400", hash_original_method = "2BAF48857D95094002D2EF1740E1384F", hash_generated_method = "05229D83F222D9E19D06BF5ADFF8C096")
     void sendAccessibilityEventUncheckedInternal(AccessibilityEvent event) {
        {
            boolean var2E2E2221860B3DCAB8C5D4F0DAD9AC26_1846641383 = (!isShown());
        } 
        onInitializeAccessibilityEvent(event);
        {
            boolean var9D05604FB3FF39F2704B15C63CA7D337_1845895778 = ((event.getEventType() & POPULATING_ACCESSIBILITY_EVENT_TYPES) != 0);
            {
                dispatchPopulateAccessibilityEvent(event);
            } 
        } 
        getParent().requestSendAccessibilityEvent(this, event);
        addTaint(event.getTaint());
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.462 -0400", hash_original_method = "927EED19E22DB3C930EC71946191C691", hash_generated_method = "7EC728B9154A5F22873B3B51FAFBACE8")
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        {
            boolean varC130CACCC03E1AF22AC94D08B8319DCD_1368274868 = (mAccessibilityDelegate.dispatchPopulateAccessibilityEvent(this, event));
        } 
        {
            boolean var372DEE9301D724A2D11E91D3D5BF5A44_2106225482 = (dispatchPopulateAccessibilityEventInternal(event));
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817278144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817278144;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.463 -0400", hash_original_method = "8EC2668F1DC902F63C332D19DDE36094", hash_generated_method = "5D30AD768B1DB323CE25069BDD6FEE97")
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_158138130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_158138130;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.463 -0400", hash_original_method = "A0DF1F515FF193F86B7E130DE16E38CE", hash_generated_method = "810EF0AFD12B38CDE493EEDFECC93832")
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        
        {
            mAccessibilityDelegate.onPopulateAccessibilityEvent(this, event);
        } 
        {
            onPopulateAccessibilityEventInternal(event);
        } 
        addTaint(event.getTaint());
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.463 -0400", hash_original_method = "CF40AA9C4C55BD5A22FC0E76716C7875", hash_generated_method = "C1E3420DDE9B8190E6B3E3D06A3CF139")
     void onPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        
        addTaint(event.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.464 -0400", hash_original_method = "28310CBBAED9E8F097DF5C90DBA9CD0F", hash_generated_method = "EF501DEAFC1D2AF86576632784174A7B")
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        
        {
            mAccessibilityDelegate.onInitializeAccessibilityEvent(this, event);
        } 
        {
            onInitializeAccessibilityEventInternal(event);
        } 
        addTaint(event.getTaint());
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.464 -0400", hash_original_method = "43B5B6E634D7CF960BF74CE0E1DDA2CD", hash_generated_method = "A6BAE42A863676C68738E0D6D531536B")
     void onInitializeAccessibilityEventInternal(AccessibilityEvent event) {
        
        event.setSource(this);
        event.setClassName(getClass().getName());
        event.setPackageName(getContext().getPackageName());
        event.setEnabled(isEnabled());
        event.setContentDescription(mContentDescription);
        {
            boolean var703D9E8BC245CC3A7B48B35F52188203_1344835509 = (event.getEventType() == AccessibilityEvent.TYPE_VIEW_FOCUSED && mAttachInfo != null);
            {
                ArrayList<View> focusablesTempList = mAttachInfo.mFocusablesTempList;
                getRootView().addFocusables(focusablesTempList, View.FOCUS_FORWARD,
                    FOCUSABLES_ALL);
                event.setItemCount(focusablesTempList.size());
                event.setCurrentItemIndex(focusablesTempList.indexOf(this));
                focusablesTempList.clear();
            } 
        } 
        addTaint(event.getTaint());
        
        
        
        
        
        
        
            
            
                    
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.465 -0400", hash_original_method = "53F1596AC086DF0FD9B166B1443D793C", hash_generated_method = "87E3413A56DC73690AF5990C3D0C7DA3")
    public AccessibilityNodeInfo createAccessibilityNodeInfo() {
        AccessibilityNodeInfo varB4EAC82CA7396A68D541C85D26508E83_289614069 = null; 
        AccessibilityNodeInfo info = AccessibilityNodeInfo.obtain(this);
        onInitializeAccessibilityNodeInfo(info);
        varB4EAC82CA7396A68D541C85D26508E83_289614069 = info;
        varB4EAC82CA7396A68D541C85D26508E83_289614069.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_289614069;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.466 -0400", hash_original_method = "BE2067901E907368432A8D9CCB431457", hash_generated_method = "B1DD873D32B686B6B0284A470F90D597")
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        
        {
            mAccessibilityDelegate.onInitializeAccessibilityNodeInfo(this, info);
        } 
        {
            onInitializeAccessibilityNodeInfoInternal(info);
        } 
        addTaint(info.getTaint());
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.466 -0400", hash_original_method = "8753AD1110C37F0E73AF31B4448B5211", hash_generated_method = "6E66DE85B2FD549BAABD6A4C45E16B5B")
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        
        Rect bounds = mAttachInfo.mTmpInvalRect;
        getDrawingRect(bounds);
        info.setBoundsInParent(bounds);
        int[] locationOnScreen = mAttachInfo.mInvalidateChildLocation;
        getLocationOnScreen(locationOnScreen);
        bounds.offsetTo(0, 0);
        bounds.offset(locationOnScreen[0], locationOnScreen[1]);
        info.setBoundsInScreen(bounds);
        {
            ViewParent parent = getParent();
            {
                View parentView = (View) parent;
                info.setParent(parentView);
            } 
        } 
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
        {
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_1201840174 = (isFocusable());
            {
                {
                    boolean var807A689000786E69147E7D957AAAFB6F_1451286731 = (isFocused());
                    {
                        info.addAction(AccessibilityNodeInfo.ACTION_CLEAR_FOCUS);
                    } 
                    {
                        info.addAction(AccessibilityNodeInfo.ACTION_FOCUS);
                    } 
                } 
            } 
        } 
        addTaint(info.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.467 -0400", hash_original_method = "32F138BD45B7179C5519FF8B12AC5296", hash_generated_method = "54FEEF3A1A1C934FEB709560757E0564")
    public void setAccessibilityDelegate(AccessibilityDelegate delegate) {
        mAccessibilityDelegate = delegate;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.468 -0400", hash_original_method = "64D1C3C95C84965C0C27E168EBDF3A77", hash_generated_method = "016EDB319722C619B25ABC32F6757E40")
    public int getAccessibilityViewId() {
        {
            mAccessibilityViewId = sNextAccessibilityViewId++;
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413166208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1413166208;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.469 -0400", hash_original_method = "ABBCC5D3939BB662168BF84991E4D81C", hash_generated_method = "0A38E12DBD520DD61A7996397F933615")
    public int getAccessibilityWindowId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948985251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948985251;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.469 -0400", hash_original_method = "6DAFF86A43A6BABA543C66C7DDAE7D00", hash_generated_method = "43DD34E8AB2C406B38CF4B56C291B250")
    public CharSequence getContentDescription() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1540221403 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1540221403 = mContentDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1540221403.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1540221403;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.470 -0400", hash_original_method = "1087954D5CDD3C4C18E361D3DD728844", hash_generated_method = "6C6918B8BBDB2D7D09C9C3B313E5E324")
    @RemotableViewMethod
    public void setContentDescription(CharSequence contentDescription) {
        mContentDescription = contentDescription;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.470 -0400", hash_original_method = "5C1A3C599F20DF55DE3C4471944CAAB7", hash_generated_method = "38E1F736D1D0CE663B8F46A26D06B1FF")
    protected void onFocusLost() {
        
        resetPressedState();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.470 -0400", hash_original_method = "81136F7A8F96E00E1C77CED95B4F9DA3", hash_generated_method = "D4EAD1E150EA8661ABEA3BAF9A0DE525")
    private void resetPressedState() {
        {
            boolean varCBC9727A244F165456D2D6CDD8022488_647866200 = (isPressed());
            {
                setPressed(false);
                {
                    removeLongPressCallback();
                } 
            } 
        } 
        
        
            
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.471 -0400", hash_original_method = "BAE18A1621CF10BDD62967DA8210DF90", hash_generated_method = "3E110D517D09BB29557E5612F0486CBC")
    @ViewDebug.ExportedProperty(category = "focus")
    public boolean isFocused() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187354001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_187354001;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.471 -0400", hash_original_method = "DDD0B2B4CCE06873AEE74BD63DE5A294", hash_generated_method = "0225324234BB923E466B94F33E53FCB6")
    public View findFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_1369267933 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1369267933 = (mPrivateFlags & FOCUSED) != 0 ? this : null;
        varB4EAC82CA7396A68D541C85D26508E83_1369267933.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1369267933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.472 -0400", hash_original_method = "1D4A87A45389821BFC7421CA2D7AD61B", hash_generated_method = "935832AC3930E39C59A3AD0B36B2D958")
    public void setScrollContainer(boolean isScrollContainer) {
        {
            {
                mAttachInfo.mScrollContainers.add(this);
                mPrivateFlags |= SCROLL_CONTAINER_ADDED;
            } 
            mPrivateFlags |= SCROLL_CONTAINER;
        } 
        {
            {
                mAttachInfo.mScrollContainers.remove(this);
            } 
            mPrivateFlags &= ~(SCROLL_CONTAINER|SCROLL_CONTAINER_ADDED);
        } 
        addTaint(isScrollContainer);
        
        
            
                
                
            
            
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.472 -0400", hash_original_method = "B2DEE8CA09FADC0B572CF46E784DEFD4", hash_generated_method = "18A18441C579E7E7690C814B7265A7A9")
    public int getDrawingCacheQuality() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519593159 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519593159;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.472 -0400", hash_original_method = "9D6669AC39CE9592E8D8B20B25494E51", hash_generated_method = "36A7C0E9E645CBC81EE5C481686480FA")
    public void setDrawingCacheQuality(int quality) {
        setFlags(quality, DRAWING_CACHE_QUALITY_MASK);
        addTaint(quality);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.473 -0400", hash_original_method = "03B1D1993EB8539284C7E9AFB4C193D6", hash_generated_method = "2B23EFBBDD1D209B56FA2AE62291590D")
    public boolean getKeepScreenOn() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146011431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146011431;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.473 -0400", hash_original_method = "99FBDDFD33142E06617327BD1E6B4E35", hash_generated_method = "00AAF5587B8D93F79AA78116E2D71D7D")
    public void setKeepScreenOn(boolean keepScreenOn) {
        setFlags(keepScreenOn ? KEEP_SCREEN_ON : 0, KEEP_SCREEN_ON);
        addTaint(keepScreenOn);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.473 -0400", hash_original_method = "652E85B83FB56D2A13FFAE8255561FDD", hash_generated_method = "4E3472F4E3B3607641E3CC97D8E321EE")
    public int getNextFocusLeftId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930148317 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930148317;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.473 -0400", hash_original_method = "38A879027311496175629221AC818202", hash_generated_method = "9E7B7FD166466BC7306079F36AA2B43B")
    public void setNextFocusLeftId(int nextFocusLeftId) {
        mNextFocusLeftId = nextFocusLeftId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.474 -0400", hash_original_method = "C88A703CE946F61F0459BFCDB166A908", hash_generated_method = "701B2E1DEBD9E8851375523B1037BD71")
    public int getNextFocusRightId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783433675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783433675;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.474 -0400", hash_original_method = "2FF4A363CCED3B1F6EFFEC35EA0E0480", hash_generated_method = "5996750AB6CEE625E7FEB111E630C7C3")
    public void setNextFocusRightId(int nextFocusRightId) {
        mNextFocusRightId = nextFocusRightId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.474 -0400", hash_original_method = "88AE25872576F6D10940E7A2DFEC3C43", hash_generated_method = "9E060428A1454E18BD91480EB82B0DFB")
    public int getNextFocusUpId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726786770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726786770;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.475 -0400", hash_original_method = "EB6C60D159C1D76D120BCAB59C29C293", hash_generated_method = "ABE6A764A0F99D568CE282D19BD22817")
    public void setNextFocusUpId(int nextFocusUpId) {
        mNextFocusUpId = nextFocusUpId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.475 -0400", hash_original_method = "D4E7D4D04A0684EEEE5B75921F57CEF0", hash_generated_method = "335E8AF71D8F2E82D127DA4D84B2E562")
    public int getNextFocusDownId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559042097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559042097;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.476 -0400", hash_original_method = "3F02629850152C987A67C858A1F48B49", hash_generated_method = "DDFE9F521C426810DDF7E2178663902C")
    public void setNextFocusDownId(int nextFocusDownId) {
        mNextFocusDownId = nextFocusDownId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.476 -0400", hash_original_method = "73A79720EFCAB292687913BA58A7941B", hash_generated_method = "D7AEBFC39F1C273B6DD743685DC7695F")
    public int getNextFocusForwardId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620170478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1620170478;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.476 -0400", hash_original_method = "E9ABC127C8FB8F8FC934426D38CB5040", hash_generated_method = "41F6E7361641184AD5AE6B06157A5559")
    public void setNextFocusForwardId(int nextFocusForwardId) {
        mNextFocusForwardId = nextFocusForwardId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.477 -0400", hash_original_method = "9296F75E65D2F78CDC5D2F47E6CA50BF", hash_generated_method = "AA5655C08E9199873F55C6171A9377A5")
    public boolean isShown() {
        View current = this;
        {
            ViewParent parent = current.mParent;
            current = (View) parent;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773477585 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773477585;
        
        
        
            
                
            
            
            
                
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.478 -0400", hash_original_method = "A39140C8CB73A931FE842774091348D2", hash_generated_method = "69C430A467D1E27A028C24410BF178E5")
    protected boolean fitSystemWindows(Rect insets) {
        {
            mPaddingLeft = insets.left;
            mPaddingTop = insets.top;
            mPaddingRight = insets.right;
            mPaddingBottom = insets.bottom;
            requestLayout();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173505039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173505039;
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.478 -0400", hash_original_method = "E3CDF7FA6CDC2881F199FFB75CF3D7D5", hash_generated_method = "FF5A6377EA2F89F12F7A12CEEF188149")
    public void setFitsSystemWindows(boolean fitSystemWindows) {
        setFlags(fitSystemWindows ? FITS_SYSTEM_WINDOWS : 0, FITS_SYSTEM_WINDOWS);
        addTaint(fitSystemWindows);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.479 -0400", hash_original_method = "5692CC010F12659264569BED146C3B41", hash_generated_method = "BC6D3001DC20F6E573C3BDCD1EA9226A")
    public boolean fitsSystemWindows() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285996289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285996289;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.479 -0400", hash_original_method = "D2B31666DEBF08F8B4CA461C0B34FB1E", hash_generated_method = "550358F4A3BA3FB61080F30273326085")
    @ViewDebug.ExportedProperty(mapping = {
        @ViewDebug.IntToString(from = VISIBLE,   to = "VISIBLE"),
        @ViewDebug.IntToString(from = INVISIBLE, to = "INVISIBLE"),
        @ViewDebug.IntToString(from = GONE,      to = "GONE")
    })
    public int getVisibility() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271740125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_271740125;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.479 -0400", hash_original_method = "02AF8E28E646A9214DED62901D5A05AB", hash_generated_method = "2C0C53FFB22650D6FE393221DEFB4B76")
    @RemotableViewMethod
    public void setVisibility(int visibility) {
        setFlags(visibility, VISIBILITY_MASK);
        mBGDrawable.setVisible(visibility == VISIBLE, false);
        addTaint(visibility);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.480 -0400", hash_original_method = "1FAAF1AA1B65BC3CCFA44E36A044FBA3", hash_generated_method = "DD5191D3D08C19B9FF014BE499076EF4")
    @ViewDebug.ExportedProperty
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1876309839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1876309839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.480 -0400", hash_original_method = "82122684EF3D7563FCC0B376DF0849B5", hash_generated_method = "D5538EC8B66CBD116F69CFE31CCD7461")
    @RemotableViewMethod
    public void setEnabled(boolean enabled) {
        {
            boolean var7DA8DB0EDBF2B3C1E618EFC1F33534DC_1626469134 = (enabled == isEnabled());
        } 
        setFlags(enabled ? ENABLED : DISABLED, ENABLED_MASK);
        refreshDrawableState();
        invalidate(true);
        addTaint(enabled);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.480 -0400", hash_original_method = "C9881A9860604453F19A8665970456AB", hash_generated_method = "664333A1EA25CC82A0F4439E4CD26AEB")
    public void setFocusable(boolean focusable) {
        {
            setFlags(0, FOCUSABLE_IN_TOUCH_MODE);
        } 
        setFlags(focusable ? FOCUSABLE : NOT_FOCUSABLE, FOCUSABLE_MASK);
        addTaint(focusable);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.481 -0400", hash_original_method = "2EADF8D169DEE1EA3C577B22372A4F29", hash_generated_method = "F4404B47505B58A113C56AFA417794D7")
    public void setFocusableInTouchMode(boolean focusableInTouchMode) {
        setFlags(focusableInTouchMode ? FOCUSABLE_IN_TOUCH_MODE : 0, FOCUSABLE_IN_TOUCH_MODE);
        {
            setFlags(FOCUSABLE, FOCUSABLE_MASK);
        } 
        addTaint(focusableInTouchMode);
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.481 -0400", hash_original_method = "0616009511F2186FBF13D4B2BAEA6B3A", hash_generated_method = "F636D38F57C66EBB9793043D928DA120")
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        setFlags(soundEffectsEnabled ? SOUND_EFFECTS_ENABLED: 0, SOUND_EFFECTS_ENABLED);
        addTaint(soundEffectsEnabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.481 -0400", hash_original_method = "04FBA67AC1724C494C94FB884C5C883F", hash_generated_method = "DAB4A8EA0674384E837925165CA41A8D")
    @ViewDebug.ExportedProperty
    public boolean isSoundEffectsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1806051114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1806051114;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.482 -0400", hash_original_method = "665412B4BA3D450566C79B734C683A80", hash_generated_method = "D1B39588408E385BC53837E77F2E736F")
    public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
        setFlags(hapticFeedbackEnabled ? HAPTIC_FEEDBACK_ENABLED: 0, HAPTIC_FEEDBACK_ENABLED);
        addTaint(hapticFeedbackEnabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.482 -0400", hash_original_method = "69619136C00391879489C4434A4D0191", hash_generated_method = "14C45FB5F8D0AA8216D3CCA0A5D640DB")
    @ViewDebug.ExportedProperty
    public boolean isHapticFeedbackEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_436405757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_436405757;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.482 -0400", hash_original_method = "2C2C2D2C9CAFB887317333E5CB13B049", hash_generated_method = "C66C239E2E4E22EC40A4E877EAAE3594")
    @ViewDebug.ExportedProperty(category = "layout", mapping = {
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LTR,     to = "LTR"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_RTL,     to = "RTL"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_INHERIT, to = "INHERIT"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LOCALE,  to = "LOCALE")
    })
    public int getLayoutDirection() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612090149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612090149;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.483 -0400", hash_original_method = "72BED775868D43D3C5AF7895C4FF8A44", hash_generated_method = "88F9408EA9B667B1F334D333041A33D4")
    @RemotableViewMethod
    public void setLayoutDirection(int layoutDirection) {
        {
            boolean var321A562371C59BD383BBC58B39275A56_1958148321 = (getLayoutDirection() != layoutDirection);
            {
                resetResolvedLayoutDirection();
                setFlags(layoutDirection, LAYOUT_DIRECTION_MASK);
            } 
        } 
        addTaint(layoutDirection);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.483 -0400", hash_original_method = "9F5111100CE328994E06DFE63B825110", hash_generated_method = "237DE14F0F33395234F631030BE03977")
    @ViewDebug.ExportedProperty(category = "layout", mapping = {
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_LTR,     to = "RESOLVED_DIRECTION_LTR"),
        @ViewDebug.IntToString(from = LAYOUT_DIRECTION_RTL,     to = "RESOLVED_DIRECTION_RTL")
    })
    public int getResolvedLayoutDirection() {
        resolveLayoutDirectionIfNeeded();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638886542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_638886542;
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.483 -0400", hash_original_method = "F4E28248D2C3D2566E14BBF2219E2BCD", hash_generated_method = "6EC398D349CA9934E0899AA8C85FB469")
    @ViewDebug.ExportedProperty(category = "layout")
    public boolean isLayoutRtl() {
        boolean varA36BF340EF5BBC5D48962FD8A0BF863A_1775997520 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812229247 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812229247;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.483 -0400", hash_original_method = "F9FAF3BB929B9847B181A3D88FABD842", hash_generated_method = "913A20B99E96CE03CF598425BC83F2C3")
    public void setWillNotDraw(boolean willNotDraw) {
        setFlags(willNotDraw ? WILL_NOT_DRAW : 0, DRAW_MASK);
        addTaint(willNotDraw);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.484 -0400", hash_original_method = "B6E391CBFCFD7EA26D5A2732CEE40DF4", hash_generated_method = "D1B0B70D93D5D0C8D99E493802230478")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotDraw() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318896979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318896979;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.484 -0400", hash_original_method = "60A2EABB5E8AA4648C06B0E0E4A2AF9C", hash_generated_method = "F94A42F4837B35CD7A18E49F6F7F2A5A")
    public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
        setFlags(willNotCacheDrawing ? WILL_NOT_CACHE_DRAWING : 0, WILL_NOT_CACHE_DRAWING);
        addTaint(willNotCacheDrawing);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.484 -0400", hash_original_method = "4D65385BAE58DC536EC26F23A55907FF", hash_generated_method = "C8F3EA326AD40A57567EB5E0AA66065F")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean willNotCacheDrawing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014299591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014299591;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.485 -0400", hash_original_method = "CAB421C9E4DB53058A0B9351F5E562C4", hash_generated_method = "C664B9A934090C404B560BA14416BC05")
    @ViewDebug.ExportedProperty
    public boolean isClickable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026855538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026855538;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.485 -0400", hash_original_method = "12111EA4E19255C8C0AB24AED3DDA51C", hash_generated_method = "4374D08E261D36E6FE00E0AF9F065003")
    public void setClickable(boolean clickable) {
        setFlags(clickable ? CLICKABLE : 0, CLICKABLE);
        addTaint(clickable);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.485 -0400", hash_original_method = "03A713DEC8C026709970488D282B8F0B", hash_generated_method = "29F1D52CEF8F34F24111C30711D7CF83")
    public boolean isLongClickable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713417482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713417482;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.486 -0400", hash_original_method = "43536DF18C7BAF4AF88A04663CE8F089", hash_generated_method = "E1B74B95D9F2AD6E13CC75A43B18D3C5")
    public void setLongClickable(boolean longClickable) {
        setFlags(longClickable ? LONG_CLICKABLE : 0, LONG_CLICKABLE);
        addTaint(longClickable);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.486 -0400", hash_original_method = "EED851B5F13351F1D2A34CF3C577E6B2", hash_generated_method = "C4057CF4BACA15652385B8746442BE91")
    public void setPressed(boolean pressed) {
        {
            mPrivateFlags |= PRESSED;
        } 
        {
            mPrivateFlags &= ~PRESSED;
        } 
        refreshDrawableState();
        dispatchSetPressed(pressed);
        addTaint(pressed);
        
        
            
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.486 -0400", hash_original_method = "AF011537E523E131D566F09FD5E6C732", hash_generated_method = "482399F15DBB51C97D7E5C81A9573A96")
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.487 -0400", hash_original_method = "2EE8A3F216F87253226045E7C3E687D4", hash_generated_method = "A9D9ACF716AB276EEF8AC622F55C58A0")
    public boolean isPressed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1501204748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1501204748;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.487 -0400", hash_original_method = "A0C463B2F7163F6CE9FACC921DDDC0C1", hash_generated_method = "86B90F84E1CEC35774DE1B4A875D4D79")
    public boolean isSaveEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1530660431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1530660431;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.488 -0400", hash_original_method = "245457DBE539B6534978F5D496F585EA", hash_generated_method = "3884A300598E0D18BAFFD2FE7E71BDEC")
    public void setSaveEnabled(boolean enabled) {
        setFlags(enabled ? 0 : SAVE_DISABLED, SAVE_DISABLED_MASK);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.488 -0400", hash_original_method = "A79886E869A4527EDC4A240CAA54713C", hash_generated_method = "2F3F5BAA22154637C972DD4270F92070")
    @ViewDebug.ExportedProperty
    public boolean getFilterTouchesWhenObscured() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346869404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_346869404;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.489 -0400", hash_original_method = "EDB53D9F0799F64121B32D1526967A47", hash_generated_method = "566C41DA00E1F9BE3A83B4E671DBAD1F")
    public void setFilterTouchesWhenObscured(boolean enabled) {
        setFlags(enabled ? 0 : FILTER_TOUCHES_WHEN_OBSCURED,
                FILTER_TOUCHES_WHEN_OBSCURED);
        addTaint(enabled);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.489 -0400", hash_original_method = "48E76F9595084274E97DBE24F2087BC5", hash_generated_method = "0C5B86FF569CD8E56AB1B17670C2A541")
    public boolean isSaveFromParentEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040779974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040779974;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.489 -0400", hash_original_method = "72C3E4C29A0B231006D33E493310EA89", hash_generated_method = "E4484042BE0E5564A91AC960C81FCAF8")
    public void setSaveFromParentEnabled(boolean enabled) {
        setFlags(enabled ? 0 : PARENT_SAVE_DISABLED, PARENT_SAVE_DISABLED_MASK);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.490 -0400", hash_original_method = "C297173E860DE7426FAD1827D2AF0FEF", hash_generated_method = "584B8D92979C72835A094AC1DCBAD3E4")
    @ViewDebug.ExportedProperty(category = "focus")
    public final boolean isFocusable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622734491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622734491;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.491 -0400", hash_original_method = "DC5548897986A7EA94B912A4E6E95490", hash_generated_method = "67429E167DA750650488556DC15ED70C")
    @ViewDebug.ExportedProperty
    public final boolean isFocusableInTouchMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_903227061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_903227061;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.492 -0400", hash_original_method = "0DA4F7FC608C37A46918AF583285CEAA", hash_generated_method = "25E02413F1B243AF1B92436D0F32BA52")
    public View focusSearch(int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_1365364019 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1729935140 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1365364019 = mParent.focusSearch(this, direction);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1729935140 = null;
        } 
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_776909240; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_776909240 = varB4EAC82CA7396A68D541C85D26508E83_1365364019;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_776909240 = varB4EAC82CA7396A68D541C85D26508E83_1729935140;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_776909240.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_776909240;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.492 -0400", hash_original_method = "3A7E0D4CA01222234C5493EC87211574", hash_generated_method = "E92B1FE250E643848227BC29B8220DB8")
    public boolean dispatchUnhandledMove(View focused, int direction) {
        addTaint(focused.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681750913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681750913;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.493 -0400", hash_original_method = "402D36B98ACE611B6285D11A0B7474BF", hash_generated_method = "C150BD674BE49C7CCA54DEEF2C466641")
     View findUserSetNextFocus(View root, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_97664805 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1014604080 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_144962035 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1987624477 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_709255075 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_2087578100 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_86177965 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_146462140 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_548273316 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_445311459 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_2002206954 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_731931235 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_97664805 = null;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1014604080 = findViewInsideOutShouldExist(root, mNextFocusLeftId);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_144962035 = null;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1987624477 = findViewInsideOutShouldExist(root, mNextFocusRightId);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_709255075 = null;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2087578100 = findViewInsideOutShouldExist(root, mNextFocusUpId);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_86177965 = null;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_146462140 = findViewInsideOutShouldExist(root, mNextFocusDownId);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_548273316 = null;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_445311459 = findViewInsideOutShouldExist(root, mNextFocusForwardId);
        
        
        {
            final int id = mID;
            varB4EAC82CA7396A68D541C85D26508E83_2002206954 = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
                    @Override
                    public boolean apply(View t) {
                        return t.mNextFocusForwardId == id;
                    }
                });
        } 
        
        varB4EAC82CA7396A68D541C85D26508E83_731931235 = null;
        addTaint(root.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_1222655541; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_97664805;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_1014604080;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_144962035;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_1987624477;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_709255075;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_2087578100;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_86177965;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_146462140;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_548273316;
                break;
            case 10: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_445311459;
                break;
            case 11: 
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_2002206954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1222655541 = varB4EAC82CA7396A68D541C85D26508E83_731931235;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1222655541.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1222655541;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.494 -0400", hash_original_method = "B3DFEFAC3DA8B2AFE30A5DD5BC4E600A", hash_generated_method = "0BE001AF849368AA2EC7E90C2FDC21CF")
    private View findViewInsideOutShouldExist(View root, final int childViewId) {
        View varB4EAC82CA7396A68D541C85D26508E83_1040108750 = null; 
        View result = root.findViewByPredicateInsideOut(this, new Predicate<View>() {
            @Override
            public boolean apply(View t) {
                return t.mID == childViewId;
            }
        });
        varB4EAC82CA7396A68D541C85D26508E83_1040108750 = result;
        addTaint(root.getTaint());
        addTaint(childViewId);
        varB4EAC82CA7396A68D541C85D26508E83_1040108750.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1040108750;
        
        
            
            
                
            
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.495 -0400", hash_original_method = "464AB183F4A2042C34DE93C717198DDB", hash_generated_method = "CCB92318176829018EBAEC60DE73E778")
    public ArrayList<View> getFocusables(int direction) {
        ArrayList<View> varB4EAC82CA7396A68D541C85D26508E83_673833548 = null; 
        ArrayList<View> result = new ArrayList<View>(24);
        addFocusables(result, direction);
        varB4EAC82CA7396A68D541C85D26508E83_673833548 = result;
        addTaint(direction);
        varB4EAC82CA7396A68D541C85D26508E83_673833548.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_673833548;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.495 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "5094D6BB39AFC12E74B6D1EB7B6739A8")
    public void addFocusables(ArrayList<View> views, int direction) {
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        addTaint(views.getTaint());
        addTaint(direction);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.496 -0400", hash_original_method = "C71740B3CD39B4D243A828C918021CDE", hash_generated_method = "D5C9BBDCC3A9B414060C1AD7437D2125")
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        {
            boolean var8DB70F00D9A309F787FE648FEF017045_1202102480 = (!isFocusable());
        } 
        {
            boolean var2850B2A852F5A5DCF1E2CF378227B555_821518967 = ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                isInTouchMode() && !isFocusableInTouchMode());
        } 
        {
            views.add(this);
        } 
        addTaint(views.getTaint());
        addTaint(direction);
        addTaint(focusableMode);
        
        
            
        
        
                
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.496 -0400", hash_original_method = "DD343D81D813CE2B90520525DB465FA4", hash_generated_method = "30DED5C28206D484A1797FBC264E76C6")
    public void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags) {
        {
            boolean var14B0D5F38B5F4B978CEA9F4FD1437EE5_254225782 = ((flags & FIND_VIEWS_WITH_CONTENT_DESCRIPTION) != 0 && !TextUtils.isEmpty(searched)
                && !TextUtils.isEmpty(mContentDescription));
            {
                String searchedLowerCase = searched.toString().toLowerCase();
                String contentDescriptionLowerCase = mContentDescription.toString().toLowerCase();
                {
                    boolean var5F42F50A6B3B93A57712332F7515E0D4_1522445819 = (contentDescriptionLowerCase.contains(searchedLowerCase));
                    {
                        outViews.add(this);
                    } 
                } 
            } 
        } 
        addTaint(outViews.getTaint());
        addTaint(searched.getTaint());
        addTaint(flags);
        
        
                
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.497 -0400", hash_original_method = "FFA271D2293E365BAC2553CB237E7BDA", hash_generated_method = "5749D9523ECAD08857F6ED3F85BBDAB5")
    public ArrayList<View> getTouchables() {
        ArrayList<View> varB4EAC82CA7396A68D541C85D26508E83_1397852273 = null; 
        ArrayList<View> result = new ArrayList<View>();
        addTouchables(result);
        varB4EAC82CA7396A68D541C85D26508E83_1397852273 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1397852273.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1397852273;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.498 -0400", hash_original_method = "4A9E887CF81CB13B9475E90E8F7B101A", hash_generated_method = "CF6D2B08EDAEAC62D43777EE9D8BE606")
    public void addTouchables(ArrayList<View> views) {
        final int viewFlags = mViewFlags;
        {
            views.add(this);
        } 
        addTaint(views.getTaint());
        
        
        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.498 -0400", hash_original_method = "D80138743E3873A119DEBFC486319C6F", hash_generated_method = "D6920443EA1A12301B0868C5B73A651E")
    public final boolean requestFocus() {
        boolean varB33B1AB5B273EC528C5AE67F69172D01_1315789724 = (requestFocus(View.FOCUS_DOWN));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115130005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115130005;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.499 -0400", hash_original_method = "0231248B41677D14ABD4C75C00BF9F51", hash_generated_method = "327D06F814044CC4118EE520BBF18746")
    public final boolean requestFocus(int direction) {
        boolean varBEB132F64DDBBBEA263C94C9131D5FCE_193241800 = (requestFocus(direction, null));
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693978818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693978818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.499 -0400", hash_original_method = "4D4D948013EFF9FDAFD5232E182C7F46", hash_generated_method = "4C83FC4359345CAFDB3016F0C8D4F99A")
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        {
            boolean varD02361A86C03997E5AE6B9686A81F1C2_1928776347 = (isInTouchMode() &&
            (FOCUSABLE_IN_TOUCH_MODE != (mViewFlags & FOCUSABLE_IN_TOUCH_MODE)));
        } 
        {
            boolean varFCFFB1819C9B89AC39385EED17BA34F3_1719655569 = (hasAncestorThatBlocksDescendantFocus());
        } 
        handleFocusGainInternal(direction, previouslyFocusedRect);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_115478758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_115478758;
        
        
                
            
        
        
            
               
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.500 -0400", hash_original_method = "7FA91653ABFF57A00EB7068CB83E321B", hash_generated_method = "7208556ED126126DE94D56E296C2957E")
     ViewRootImpl getViewRootImpl() {
        ViewRootImpl varB4EAC82CA7396A68D541C85D26508E83_685110027 = null; 
        View root = getRootView();
        varB4EAC82CA7396A68D541C85D26508E83_685110027 = root != null ? (ViewRootImpl)root.getParent() : null;
        varB4EAC82CA7396A68D541C85D26508E83_685110027.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_685110027;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.500 -0400", hash_original_method = "1F9F6F0DA182BB29AC330886C262C4C3", hash_generated_method = "367A6A2FAED6987AF05BEF8FFAD413CE")
    public final boolean requestFocusFromTouch() {
        {
            boolean varA7F65F2C3551E1C19C22954843677DD3_1546244275 = (isInTouchMode());
            {
                ViewRootImpl viewRoot = getViewRootImpl();
                {
                    viewRoot.ensureTouchMode(false);
                } 
            } 
        } 
        boolean varB33B1AB5B273EC528C5AE67F69172D01_278797656 = (requestFocus(View.FOCUS_DOWN));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759635070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759635070;
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.501 -0400", hash_original_method = "AF1FEBD7D3DF68D5685D255FEFA73D33", hash_generated_method = "3FAFF27A0B6AE85CB927AECEEFD23AB4")
    private boolean hasAncestorThatBlocksDescendantFocus() {
        ViewParent ancestor = mParent;
        {
            final ViewGroup vgAncestor = (ViewGroup) ancestor;
            {
                boolean var6A93B533F786283E71D28D2D3BB8654E_144518684 = (vgAncestor.getDescendantFocusability() == ViewGroup.FOCUS_BLOCK_DESCENDANTS);
                {
                    ancestor = vgAncestor.getParent();
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316615139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316615139;
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.501 -0400", hash_original_method = "9E8D01E3E35914BE1B580652C44B6D92", hash_generated_method = "4068A66B11C8A715D0155C9B0F768AA3")
    public void dispatchStartTemporaryDetach() {
        onStartTemporaryDetach();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.501 -0400", hash_original_method = "7B585748E6C2A3CE6D3BA7FDB91AA5A9", hash_generated_method = "835E4082F4217105CFFD467CF28422B0")
    public void onStartTemporaryDetach() {
        
        removeUnsetPressCallback();
        mPrivateFlags |= CANCEL_NEXT_UP_EVENT;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.502 -0400", hash_original_method = "07C22BEB43BC8453BE2AEA4BC85C2345", hash_generated_method = "3223FB93CB255E66A3AC95410D228D51")
    public void dispatchFinishTemporaryDetach() {
        onFinishTemporaryDetach();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.502 -0400", hash_original_method = "B87297DA0096F2C31AB92D13B4246B81", hash_generated_method = "25EA709CBA250441F08254F97B05DEE6")
    public void onFinishTemporaryDetach() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.502 -0400", hash_original_method = "5346C33A691675BA7E77EC00779EE7C7", hash_generated_method = "E772769092D21CCD5AF2C6E581672CAC")
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        KeyEvent.DispatcherState varB4EAC82CA7396A68D541C85D26508E83_1470689260 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1470689260 = mAttachInfo != null ? mAttachInfo.mKeyDispatchState : null;
        varB4EAC82CA7396A68D541C85D26508E83_1470689260.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1470689260;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.503 -0400", hash_original_method = "6BC846EF16EEF6AFE683BBB51F853755", hash_generated_method = "16597CD97266BD5C1DE1F300122F0D66")
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        boolean varA1D1F09794689B9E696354A29B1E7AC6_559969411 = (onKeyPreIme(event.getKeyCode(), event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179120382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_179120382;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.503 -0400", hash_original_method = "E10762B11C67C141BFF5425226FAC8FB", hash_generated_method = "9C3BDE8F143D26094DD5B82FD1190EB7")
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 0);
        } 
        ListenerInfo li = mListenerInfo;
        {
            boolean var1AD81DB769C1B29F43EBC2BE5F7D22DB_602378551 = (li != null && li.mOnKeyListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnKeyListener.onKey(this, event.getKeyCode(), event));
        } 
        {
            boolean varE1E9B80914776D83D3B032515F60B979_866269186 = (event.dispatch(this, mAttachInfo != null
                ? mAttachInfo.mKeyDispatchState : null, this)); 
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047146645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047146645;
        
        
            
        
        
        
                
            
        
        
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.503 -0400", hash_original_method = "24CC3891BCF06B080FB3833309F877D3", hash_generated_method = "44D80C6B76BC418B923C4299920F424B")
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        boolean varB65319FC5255424F872A964CBDE1432E_103055252 = (onKeyShortcut(event.getKeyCode(), event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63980521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_63980521;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.504 -0400", hash_original_method = "600B8A393DB97B903182B7AB1891AC3E", hash_generated_method = "CBD7D0C3BE4EA390FF94FB5FD7D65DC8")
    public boolean dispatchTouchEvent(MotionEvent event) {
        {
            mInputEventConsistencyVerifier.onTouchEvent(event, 0);
        } 
        {
            boolean var6607193D9DAC59E34045E90E7ECB0599_1039048296 = (onFilterTouchEventForSecurity(event));
            {
                ListenerInfo li = mListenerInfo;
                {
                    boolean var710CB5FED0ECEB52EC22DD1CD141A5D7_2019375306 = (li != null && li.mOnTouchListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                    && li.mOnTouchListener.onTouch(this, event));
                } 
                {
                    boolean var430E552CCD38EECE5F1A81AADC330527_865820817 = (onTouchEvent(event));
                } 
            } 
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776536300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776536300;
        
        
            
        
        
            
            
                    
                
            
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.504 -0400", hash_original_method = "D22D4E22492930B2B9E3C8840958D4D7", hash_generated_method = "44A531B304D4A5449C29401E102F85CD")
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        
        {
            boolean var702D316B06A93F4CCE85A9302F846D5C_1909895480 = ((mViewFlags & FILTER_TOUCHES_WHEN_OBSCURED) != 0
                && (event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217977519 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217977519;
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.505 -0400", hash_original_method = "7D8730AF428F1F83C6EA34686735DEE9", hash_generated_method = "13CDBBAEDC570CF1278BDFD5FEBBE197")
    public boolean dispatchTrackballEvent(MotionEvent event) {
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 0);
        } 
        boolean var138C9D0D373C5EB915EF41E377253C34_342545053 = (onTrackballEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005332689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005332689;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.505 -0400", hash_original_method = "4D54FFDFE0E351BCF8C37A3BD601042A", hash_generated_method = "4B32C48930B92B9C1CE965393B6A625D")
    public boolean dispatchGenericMotionEvent(MotionEvent event) {
        {
            mInputEventConsistencyVerifier.onGenericMotionEvent(event, 0);
        } 
        final int source = event.getSource();
        {
            final int action = event.getAction();
            {
                {
                    boolean varB883F6E8D34F34A7AC9A1C8473B6C6B6_1580182381 = (dispatchHoverEvent(event));
                } 
            } 
            {
                boolean var2FA64A05C793C37BF00E4ECBCAD6D479_409723570 = (dispatchGenericPointerEvent(event));
            } 
        } 
        {
            boolean var1E07621182DE67A8830891F3EE4A3942_1652576170 = (dispatchGenericFocusedEvent(event));
        } 
        {
            boolean varB9448C36962D13B58BD66CC5B67304A5_1885430393 = (dispatchGenericMotionEventInternal(event));
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026400728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026400728;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.506 -0400", hash_original_method = "C7F259FDC1DD0446D3E9FDACCE813628", hash_generated_method = "AA50C20515D97E9AD37E21A1C010C19C")
    private boolean dispatchGenericMotionEventInternal(MotionEvent event) {
        ListenerInfo li = mListenerInfo;
        {
            boolean varF5508584668781871F7A8EEF6203DF63_2071429342 = (li != null && li.mOnGenericMotionListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnGenericMotionListener.onGenericMotion(this, event));
        } 
        {
            boolean varB02F8946AC0F1C42DF139AA516995E2E_284857691 = (onGenericMotionEvent(event));
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 0);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982064053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_982064053;
        
        
        
                
                
            
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.506 -0400", hash_original_method = "648EC8AE542E2EA418563108E4E24BE8", hash_generated_method = "3F23E9C3941348424F0072008EA0DF15")
    protected boolean dispatchHoverEvent(MotionEvent event) {
        ListenerInfo li = mListenerInfo;
        {
            boolean varE708EAD4945B3336974BCEC5E5692CEB_177480241 = (li != null && li.mOnHoverListener != null
                && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnHoverListener.onHover(this, event));
        } 
        boolean var20FA514C60FFF8C5D29FC4243A17D964_801950268 = (onHoverEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_532226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_532226;
        
        
        
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.507 -0400", hash_original_method = "6C63870709E0BCE3150AB1DBD762BE1B", hash_generated_method = "329A5598CCCDD7F05365954A7CEC9802")
    protected boolean hasHoveredChild() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459140697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459140697;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.508 -0400", hash_original_method = "3E380A63A40D63CB8A25C818C007B9B3", hash_generated_method = "0FCB99553639522B711AC8D0717145FB")
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412850209 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_412850209;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.508 -0400", hash_original_method = "A2221AB8B5038CA8B5C4F66BF8310DCB", hash_generated_method = "5294ED71528983AB4FBA0D4609A6A423")
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_889932559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_889932559;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.509 -0400", hash_original_method = "5F3F937CAC1AD8405FC854A70098D82C", hash_generated_method = "59D969F242E66D08607FC4B7E28E95B1")
    public final boolean dispatchPointerEvent(MotionEvent event) {
        {
            boolean var15DC5053D55881959B9A5AB5DA0AE67E_1598217759 = (event.isTouchEvent());
            {
                boolean varB6BDA87406308A510ABCADF589E94032_850654837 = (dispatchTouchEvent(event));
            } 
            {
                boolean var34A3B038B9117B3BA5FBBDB0BBF251D9_207148555 = (dispatchGenericMotionEvent(event));
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318832775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318832775;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.509 -0400", hash_original_method = "F6C86F5501B65BFAFB8121E3F717BD02", hash_generated_method = "9EE6786DF4A3CDC7D219D109C602A1E2")
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        onWindowFocusChanged(hasFocus);
        addTaint(hasFocus);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.509 -0400", hash_original_method = "F57E7738E41C9719BB0FA37E2B51EE61", hash_generated_method = "1B0291007DFE33125949AA247376AD82")
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        
        InputMethodManager imm = InputMethodManager.peekInstance();
        {
            {
                boolean varF27F491A5EAB0B2989FBEF44657192A7_351307641 = (isPressed());
                {
                    setPressed(false);
                } 
            } 
            {
                imm.focusOut(this);
            } 
            removeLongPressCallback();
            removeTapCallback();
            onFocusLost();
        } 
        {
            imm.focusIn(this);
        } 
        refreshDrawableState();
        addTaint(hasWindowFocus);
        
        
        
            
                
            
            
                
            
            
            
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.510 -0400", hash_original_method = "43B27055CE530161D72F65ED0A59B9EC", hash_generated_method = "4DEE17AB43900D221EB3A50E4EDD9DA5")
    public boolean hasWindowFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011690262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011690262;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.510 -0400", hash_original_method = "5A92DDE8F02B8EC7BB05F90066C877DB", hash_generated_method = "3243E710BCE99C464D873F2CD3F3B3CF")
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        onVisibilityChanged(changedView, visibility);
        addTaint(changedView.getTaint());
        addTaint(visibility);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.510 -0400", hash_original_method = "96367A8B641E87C53B477CCACD2EFDC5", hash_generated_method = "BE002024D6470FC82F23EA0B55EDBD9C")
    protected void onVisibilityChanged(View changedView, int visibility) {
        
        {
            {
                initialAwakenScrollBars();
            } 
            {
                mPrivateFlags |= AWAKEN_SCROLL_BARS_ON_ATTACH;
            } 
        } 
        addTaint(changedView.getTaint());
        addTaint(visibility);
        
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.510 -0400", hash_original_method = "5C1461045BB49CF5D091FC620162B930", hash_generated_method = "60D369FD538ED62F4DBE65FF896401D5")
    public void dispatchDisplayHint(int hint) {
        onDisplayHint(hint);
        addTaint(hint);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.511 -0400", hash_original_method = "5A8656B423BEB4FF4CA5CD6E6B7C0CE2", hash_generated_method = "7AFA45852F4248855F8AF6C17DF3F6DF")
    protected void onDisplayHint(int hint) {
        
        addTaint(hint);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.511 -0400", hash_original_method = "3D097367CCB5A92F4CA94066B4093669", hash_generated_method = "D2986C6E5C42F87CC2951A63F2E58CF5")
    public void dispatchWindowVisibilityChanged(int visibility) {
        onWindowVisibilityChanged(visibility);
        addTaint(visibility);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.511 -0400", hash_original_method = "B52A85A1B1D14AC974ADC7B2B6CB318A", hash_generated_method = "63A3183908E1FB7A83B4B299FE6A9E1D")
    protected void onWindowVisibilityChanged(int visibility) {
        
        {
            initialAwakenScrollBars();
        } 
        addTaint(visibility);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.511 -0400", hash_original_method = "B335923547853AC72EE9B6DCDADA38B5", hash_generated_method = "1C997DF6CB0AADC2AFA4E1CD58F9C80A")
    public int getWindowVisibility() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983735886 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983735886;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.512 -0400", hash_original_method = "D236207A35AB4B4964A2350C5EB42480", hash_generated_method = "BB201B2B5167F72093B3AAEC8917C9F5")
    public void getWindowVisibleDisplayFrame(Rect outRect) {
        {
            try 
            {
                mAttachInfo.mSession.getDisplayFrame(mAttachInfo.mWindow, outRect);
            } 
            catch (RemoteException e)
            { }
            final Rect insets = mAttachInfo.mVisibleInsets;
            outRect.left += insets.left;
            outRect.top += insets.top;
            outRect.right -= insets.right;
            outRect.bottom -= insets.bottom;
        } 
        Display d = WindowManagerImpl.getDefault().getDefaultDisplay();
        d.getRectSize(outRect);
        addTaint(outRect.getTaint());
        
        
            
                
            
                
            
            
            
            
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.512 -0400", hash_original_method = "54CB795C069B52CC42B32E2AD26066B2", hash_generated_method = "2E26EAE6FBBFDA96B514A4920ABDB823")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        onConfigurationChanged(newConfig);
        addTaint(newConfig.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.512 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "466D77C1E8E53A4547ADE90D240CE428")
    protected void onConfigurationChanged(Configuration newConfig) {
        
        addTaint(newConfig.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.513 -0400", hash_original_method = "4092DD0F41D441E58BB892F3C094C4B3", hash_generated_method = "AB1108C2478BF4D14408840B84F8B890")
     void dispatchCollectViewAttributes(int visibility) {
        performCollectViewAttributes(visibility);
        addTaint(visibility);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.513 -0400", hash_original_method = "01D7FE9ADD969187268E5CA00DFC8244", hash_generated_method = "C9C7B8686D7CBA49E22487887C130AA9")
     void performCollectViewAttributes(int visibility) {
        {
            {
                mAttachInfo.mKeepScreenOn = true;
            } 
            mAttachInfo.mSystemUiVisibility |= mSystemUiVisibility;
            ListenerInfo li = mListenerInfo;
            {
                mAttachInfo.mHasSystemUiListeners = true;
            } 
        } 
        addTaint(visibility);
        
        
            
                
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.513 -0400", hash_original_method = "9FE32A4CBB26C218394F35C255A8CF99", hash_generated_method = "8D949487788757A1B8C03B02140C5163")
     void needGlobalAttributesUpdate(boolean force) {
        final AttachInfo ai = mAttachInfo;
        {
            {
                ai.mRecomputeGlobalAttributes = true;
            } 
        } 
        addTaint(force);
        
        
        
            
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.513 -0400", hash_original_method = "ED47CAF0B3847455A70DC2CFF6AB9C90", hash_generated_method = "93584102931B58B1791465BDC528B266")
    @ViewDebug.ExportedProperty
    public boolean isInTouchMode() {
        {
            boolean varFF1875034CF47A81AA6602BEECB01842_1407029566 = (ViewRootImpl.isInTouchMode());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803012207 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803012207;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.514 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "4EB4C3233B3F5821D02CBAF2CD541BC2")
    @ViewDebug.CapturedViewProperty
    public final Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1120985883 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1120985883 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_1120985883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1120985883;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.514 -0400", hash_original_method = "3F070CAC61386FAD746F2003533AED25", hash_generated_method = "49068B8D21420F3C9E3218F404BC2552")
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366521450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366521450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.515 -0400", hash_original_method = "30943D321BC4BC956C4D9D744FC13942", hash_generated_method = "805F8D753AE16F42F5512B738FD3B1D8")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        boolean result = false;
        
        {
            {
                boolean var213035B3AC0E21AB8BF383FF63EBF5BC_433141483 = (((mViewFlags & CLICKABLE) == CLICKABLE ||
                        (mViewFlags & LONG_CLICKABLE) == LONG_CLICKABLE) &&
                        (event.getRepeatCount() == 0));
                {
                    setPressed(true);
                    checkForLongClick(0);
                } 
            } 
        } 
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416652388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416652388;
        
        
        
            
            
                
                    
                
                
                        
                        
                    
                    
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.515 -0400", hash_original_method = "2A75FF2C44C4D96068DDAFC2643F0C8B", hash_generated_method = "E89E7A3A17CD47C41482A894CFECB6FB")
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_751539160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_751539160;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.516 -0400", hash_original_method = "5AB62313644D9CD032AD8CDBAB33BB4C", hash_generated_method = "89DCD3B9109ECE156525BF4FECBB74EC")
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        boolean result = false;
        
        {
            {
                boolean var22CDF6A8C6A4F6AF8C611FA66D791C64_1556560138 = ((mViewFlags & CLICKABLE) == CLICKABLE && isPressed());
                {
                    setPressed(false);
                    {
                        removeLongPressCallback();
                        result = performClick();
                    } 
                } 
            } 
        } 
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1558199917 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1558199917;
        
        
        
            
            
                
                    
                
                
                    
                    
                        
                        
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.516 -0400", hash_original_method = "E364C67ED15F0AA31C6DCFFA6137C8C0", hash_generated_method = "D47B34D867BD1E87F239C06A446DCE74")
    public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(repeatCount);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735469037 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735469037;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.517 -0400", hash_original_method = "2ECF3E4914B4B3BE2238F799B7435A51", hash_generated_method = "E37455054429511CA987D77936E58D65")
    public boolean onKeyShortcut(int keyCode, KeyEvent event) {
        
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602876026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602876026;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.517 -0400", hash_original_method = "47FC099EDD591711C69A21361EB96357", hash_generated_method = "0DDB86094E012128C6E8352932A455EE")
    public boolean onCheckIsTextEditor() {
        
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589794241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589794241;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.518 -0400", hash_original_method = "0601401EB37355AF70FCC37B4ABEB0DF", hash_generated_method = "EBAA40F7E3135A5EE08BCA0BCC5599F4")
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        
        InputConnection varB4EAC82CA7396A68D541C85D26508E83_1661387920 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1661387920 = null;
        addTaint(outAttrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1661387920.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1661387920;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.519 -0400", hash_original_method = "225D79BB0F164EDB8833C9EDCA3E1422", hash_generated_method = "D7F12549164046B31CD7B63F54CA8B2E")
    public boolean checkInputConnectionProxy(View view) {
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_556697378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_556697378;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.519 -0400", hash_original_method = "3CE367A3F7143B170AAF00E81005E914", hash_generated_method = "3D5836A5243E78E06C468D3C9BCEF478")
    public void createContextMenu(ContextMenu menu) {
        ContextMenuInfo menuInfo = getContextMenuInfo();
        ((MenuBuilder)menu).setCurrentMenuInfo(menuInfo);
        onCreateContextMenu(menu);
        ListenerInfo li = mListenerInfo;
        {
            li.mOnCreateContextMenuListener.onCreateContextMenu(menu, this, menuInfo);
        } 
        ((MenuBuilder)menu).setCurrentMenuInfo(null);
        {
            mParent.createContextMenu(menu);
        } 
        addTaint(menu.getTaint());
        
        
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.520 -0400", hash_original_method = "5F63695E16A345A992F87C295B6530DF", hash_generated_method = "DD6C66809DDC07D94C8C7BDB7E1BEBC7")
    protected ContextMenuInfo getContextMenuInfo() {
        ContextMenuInfo varB4EAC82CA7396A68D541C85D26508E83_903111251 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_903111251 = null;
        varB4EAC82CA7396A68D541C85D26508E83_903111251.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_903111251;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.520 -0400", hash_original_method = "6522DD22D3C6D7A95FA248A3D5D95901", hash_generated_method = "015D5DE2243E972B4786C923AF15F92B")
    protected void onCreateContextMenu(ContextMenu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.520 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "D56119724BFF386056E057FACA0F8937")
    public boolean onTrackballEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_393138167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_393138167;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.521 -0400", hash_original_method = "0E59A005881F30C798F764BCF32D89A3", hash_generated_method = "4EC2EFC7E0C315E45441EC0FD51DDB62")
    public boolean onGenericMotionEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1593336696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1593336696;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.521 -0400", hash_original_method = "5922A88C022E21B0C70489BC0DBE35EF", hash_generated_method = "6239189AF39F453BE9FDCB1B2483D89B")
    public boolean onHoverEvent(MotionEvent event) {
        
        final int action = event.getAction();
        {
            {
                boolean var50C2C1648FCAD417F5DFCEAC97574026_1818367983 = ((action == MotionEvent.ACTION_HOVER_ENTER
                    || action == MotionEvent.ACTION_HOVER_MOVE)
                    && !hasHoveredChild()
                    && pointInView(event.getX(), event.getY()));
                {
                    mSendingHoverAccessibilityEvents = true;
                    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_ENTER);
                } 
            } 
        } 
        {
            {
                boolean var96DFD226589477FD552DD4E5C844A258_1636080162 = (action == MotionEvent.ACTION_HOVER_EXIT
                    || (action == MotionEvent.ACTION_HOVER_MOVE
                            && !pointInView(event.getX(), event.getY())));
                {
                    mSendingHoverAccessibilityEvents = false;
                    sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_HOVER_EXIT);
                } 
            } 
        } 
        {
            boolean var25FE040CDD1CBE5B8AA6184119AEA24C_21090077 = (isHoverable());
            {
                
                setHovered(true);
                
                
                setHovered(false);
                
                dispatchGenericMotionEventInternal(event);
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_197232191 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_197232191;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.522 -0400", hash_original_method = "B9B35BD663CAB028DDAC5D67FB09103D", hash_generated_method = "B6AA1BC3FA6D730BB3ABE55B05F17E49")
    private boolean isHoverable() {
        final int viewFlags = mViewFlags;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520165774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520165774;
        
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.522 -0400", hash_original_method = "0724AE81F4A3A3591BB9677111DA3959", hash_generated_method = "9C627D6B973DB3861ED980545235EDB6")
    @ViewDebug.ExportedProperty
    public boolean isHovered() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722271636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_722271636;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.522 -0400", hash_original_method = "6A44BB0DB1E9547ADB3859B33BB1BB33", hash_generated_method = "F4C348D2D76DF2801A8E28E86F01E51D")
    public void setHovered(boolean hovered) {
        {
            {
                mPrivateFlags |= HOVERED;
                refreshDrawableState();
                onHoverChanged(true);
            } 
        } 
        {
            {
                mPrivateFlags &= ~HOVERED;
                refreshDrawableState();
                onHoverChanged(false);
            } 
        } 
        addTaint(hovered);
        
        
            
                
                
                
            
        
            
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.523 -0400", hash_original_method = "E702D19B1B952DDC0E28AFCA7C53007F", hash_generated_method = "AE8841589F9FD221B263AD22F6BB1DA2")
    public void onHoverChanged(boolean hovered) {
        
        addTaint(hovered);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.524 -0400", hash_original_method = "F0667DD3F99E763B1BFE85806FBAFB16", hash_generated_method = "2109CB450282F757704B93F0A737D596")
    public boolean onTouchEvent(MotionEvent event) {
        
        final int viewFlags = mViewFlags;
        {
            {
                boolean var603A4D4D69ECAA84FEB3324C67F6C844_929062361 = (event.getAction() == MotionEvent.ACTION_UP && (mPrivateFlags & PRESSED) != 0);
                {
                    mPrivateFlags &= ~PRESSED;
                    refreshDrawableState();
                } 
            } 
        } 
        {
            {
                boolean var2FD9894A0B8D17E7D63035FBAFAC4F4A_1962074920 = (mTouchDelegate.onTouchEvent(event));
            } 
        } 
        {
            {
                Object var96ADA7CB150D39A55358E742474108F2_567003721 = (event.getAction());
                
                boolean prepressed = (mPrivateFlags & PREPRESSED) != 0;
                
                
                {
                    boolean focusTaken = false;
                    {
                        boolean var4010B45C9110D5523B114A445C2F69F9_2109026873 = (isFocusable() && isFocusableInTouchMode() && !isFocused());
                        {
                            focusTaken = requestFocus();
                        } 
                    } 
                    {
                        mPrivateFlags |= PRESSED;
                        refreshDrawableState();
                    } 
                    {
                        removeLongPressCallback();
                        {
                            {
                                mPerformClick = new PerformClick();
                            } 
                            {
                                boolean var7529B8C360AE15DA8B22EFD2F54DEBE4_619352005 = (!post(mPerformClick));
                                {
                                    performClick();
                                } 
                            } 
                        } 
                    } 
                    {
                        mUnsetPressedState = new UnsetPressedState();
                    } 
                    {
                        postDelayed(mUnsetPressedState,
                                    ViewConfiguration.getPressedStateDuration());
                    } 
                    {
                        boolean var78C79A084528017AFFB727F82C6C54F8_1615122934 = (!post(mUnsetPressedState));
                        {
                            mUnsetPressedState.run();
                        } 
                    } 
                    removeTapCallback();
                } 
                
                
                mHasPerformedLongPress = false;
                
                
                {
                    boolean var05FA8261FD36A1DB58AD7618577A33AB_441128423 = (performButtonActionOnTouchDown(event));
                } 
                
                
                boolean isInScrollingContainer = isInScrollingContainer();
                
                
                {
                    mPrivateFlags |= PREPRESSED;
                    {
                        mPendingCheckForTap = new CheckForTap();
                    } 
                    postDelayed(mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                } 
                {
                    mPrivateFlags |= PRESSED;
                    refreshDrawableState();
                    checkForLongClick(0);
                } 
                
                
                mPrivateFlags &= ~PRESSED;
                
                
                refreshDrawableState();
                
                
                removeTapCallback();
                
                
                final int x = (int) event.getX();
                
                
                final int y = (int) event.getY();
                
                
                {
                    boolean var08A986E19E681C372CEFA5E47F3A6BEE_1558481084 = (!pointInView(x, y, mTouchSlop));
                    {
                        removeTapCallback();
                        {
                            removeLongPressCallback();
                            mPrivateFlags &= ~PRESSED;
                            refreshDrawableState();
                        } 
                    } 
                } 
                
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571864742 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571864742;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.524 -0400", hash_original_method = "7808B21D2BE87077131F031A801646DE", hash_generated_method = "7F2F18327A5E05BEEC1913930D658780")
    public boolean isInScrollingContainer() {
        ViewParent p = getParent();
        {
            {
                boolean var4881E0F2577352AD9B4EFF88E10A0FFC_1259006496 = (((ViewGroup) p).shouldDelayChildPressedState());
            } 
            p = p.getParent();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555844662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555844662;
        
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.525 -0400", hash_original_method = "A93CC85053AADAF4A404AD13182B9757", hash_generated_method = "4E0E89E0095C87865BEDCEA23B30D854")
    private void removeLongPressCallback() {
        {
            removeCallbacks(mPendingCheckForLongPress);
        } 
        
        
          
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.525 -0400", hash_original_method = "E1C00ACE8BB8560C240B3C5D040006A3", hash_generated_method = "2A0B9175108CA8E4055A6F572B30050D")
    private void removePerformClickCallback() {
        {
            removeCallbacks(mPerformClick);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.525 -0400", hash_original_method = "6062C7F52024ACE8958D902CC4268271", hash_generated_method = "D17473916BA8EEE9CD65D95E79C2DB43")
    private void removeUnsetPressCallback() {
        {
            setPressed(false);
            removeCallbacks(mUnsetPressedState);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.526 -0400", hash_original_method = "B67FA3EAF595424C7D0F48DB4ECBF54E", hash_generated_method = "29D4BD3D693368C16CBA0386A785A065")
    private void removeTapCallback() {
        {
            mPrivateFlags &= ~PREPRESSED;
            removeCallbacks(mPendingCheckForTap);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.526 -0400", hash_original_method = "B45EC6A62A5C3981A23AB3F41840A566", hash_generated_method = "B4CC4E5CE3C81DAAFE2FEB90BADA5B6E")
    public void cancelLongPress() {
        removeLongPressCallback();
        removeTapCallback();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.526 -0400", hash_original_method = "8D4D94E2FFA3D8907911FEF22F0F072D", hash_generated_method = "15573115AF3E86DFF34CBB843D8CC1D8")
    private void removeSendViewScrolledAccessibilityEventCallback() {
        {
            removeCallbacks(mSendViewScrolledAccessibilityEvent);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.527 -0400", hash_original_method = "61F54D1D0A5A4D0B5C8BE62B3B180D19", hash_generated_method = "E776BADE28CB148BB0B06BC8200B2011")
    public void setTouchDelegate(TouchDelegate delegate) {
        mTouchDelegate = delegate;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.527 -0400", hash_original_method = "C13C756E7E3DD9AFF35525DE74B6A0AE", hash_generated_method = "0964CB563AB5E124C37511C486BBF0F1")
    public TouchDelegate getTouchDelegate() {
        TouchDelegate varB4EAC82CA7396A68D541C85D26508E83_103931345 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_103931345 = mTouchDelegate;
        varB4EAC82CA7396A68D541C85D26508E83_103931345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_103931345;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.529 -0400", hash_original_method = "DB01C6D64C7923FFF91C0044F6A0DAD3", hash_generated_method = "F5F4AD600A48EA3E65DFEF668E3672CF")
     void setFlags(int flags, int mask) {
        int old = mViewFlags;
        mViewFlags = (mViewFlags & ~mask) | (flags & mask);
        int changed = mViewFlags ^ old;
        int privateFlags = mPrivateFlags;
        {
            {
                clearFocus();
            } 
            {
                mParent.focusableViewAvailable(this);
            } 
        } 
        {
            {
                mPrivateFlags |= DRAWN;
                invalidate(true);
                needGlobalAttributesUpdate(true);
                {
                    mParent.focusableViewAvailable(this);
                } 
            } 
        } 
        {
            needGlobalAttributesUpdate(false);
            requestLayout();
            {
                {
                    boolean var045EBE37E9FC6E3EB86868C8822165CE_835514865 = (hasFocus());
                    clearFocus();
                } 
                destroyDrawingCache();
                {
                    ((View) mParent).invalidate(true);
                } 
                mPrivateFlags |= DRAWN;
            } 
            {
                mAttachInfo.mViewVisibilityChanged = true;
            } 
        } 
        {
            needGlobalAttributesUpdate(false);
            mPrivateFlags |= DRAWN;
            {
                boolean varB31FEE083FA3FF4FCB5289BE9151CED2_140305152 = (((mViewFlags & VISIBILITY_MASK) == INVISIBLE) && hasFocus());
                {
                    {
                        boolean var7EE5FF448100B409C00AA55A4D5A2579_645865046 = (getRootView() != this);
                        {
                            clearFocus();
                        } 
                    } 
                } 
            } 
            {
                mAttachInfo.mViewVisibilityChanged = true;
            } 
        } 
        {
            {
                ((ViewGroup) mParent).onChildVisibilityChanged(this, (flags & VISIBILITY_MASK));
                ((View) mParent).invalidate(true);
            } 
            {
                mParent.invalidateChild(this, null);
            } 
            dispatchVisibilityChanged(this, (flags & VISIBILITY_MASK));
        } 
        {
            destroyDrawingCache();
        } 
        {
            destroyDrawingCache();
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            invalidateParentCaches();
        } 
        {
            destroyDrawingCache();
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        } 
        {
            {
                {
                    mPrivateFlags &= ~SKIP_DRAW;
                    mPrivateFlags |= ONLY_DRAWS_BACKGROUND;
                } 
                {
                    mPrivateFlags |= SKIP_DRAW;
                } 
            } 
            {
                mPrivateFlags &= ~SKIP_DRAW;
            } 
            requestLayout();
            invalidate(true);
        } 
        {
            {
                mParent.recomputeViewAttributes(this);
            } 
        } 
        {
            requestLayout();
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.530 -0400", hash_original_method = "D3A1B9777480096EBBD21F82F884FF88", hash_generated_method = "B3254F2076864AE69DB273BC05B806B7")
    public void bringToFront() {
        {
            mParent.bringChildToFront(this);
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.530 -0400", hash_original_method = "EDEAEC3E48D287D80E86A711CB6F1FA1", hash_generated_method = "EA80BAA3B36FA061DDD2AB369A18B47B")
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        
        {
            boolean varFEF5E81D9E4B252970529F0E4C094F45_958170958 = (AccessibilityManager.getInstance(mContext).isEnabled());
            {
                postSendViewScrolledAccessibilityEventCallback();
            } 
        } 
        mBackgroundSizeChanged = true;
        final AttachInfo ai = mAttachInfo;
        {
            ai.mViewScrollChanged = true;
        } 
        addTaint(l);
        addTaint(t);
        addTaint(oldl);
        addTaint(oldt);
        
        
            
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.531 -0400", hash_original_method = "B552DCA4F8335CB071F137C97CB4545F", hash_generated_method = "581C6460081BA9AED29EF85B1284ED4B")
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.531 -0400", hash_original_method = "0296ECFD4FBB578ABFB3DEE9D2F54084", hash_generated_method = "3BF445E04BA2666375DFCD58601723DA")
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.532 -0400", hash_original_method = "23990FCA043695388FDF30165FAB53F8", hash_generated_method = "31AB78B66B5E2C0BC415361769C58098")
    public final ViewParent getParent() {
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_1410259182 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1410259182 = mParent;
        varB4EAC82CA7396A68D541C85D26508E83_1410259182.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1410259182;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.532 -0400", hash_original_method = "A54235C6FCDDA2041C8AFAE3E4C1E483", hash_generated_method = "4D5E276078D4703D79AAC9E64AA62422")
    public void setScrollX(int value) {
        scrollTo(value, mScrollY);
        addTaint(value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.532 -0400", hash_original_method = "F511D71F344E6F66807E97ABB51DFE9B", hash_generated_method = "48F0CDA0C46AE53A124A91A7E04F580D")
    public void setScrollY(int value) {
        scrollTo(mScrollX, value);
        addTaint(value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.532 -0400", hash_original_method = "37E422003D62C4BD4746E9CFAAF79E84", hash_generated_method = "BF5993FD9DF647B9340A72A5E0F46F0A")
    public final int getScrollX() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915385216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915385216;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.533 -0400", hash_original_method = "1E7AE64F8D32210A6E2C97F4869FB31A", hash_generated_method = "6D5F09B675DDB129736635517399B370")
    public final int getScrollY() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799353911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799353911;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.533 -0400", hash_original_method = "FFF18028F96DB13B23AA35EC8A354DA6", hash_generated_method = "A3C7A046BF0D458AFC157ABCDE3A8E68")
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1100052130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1100052130;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.533 -0400", hash_original_method = "DB8E3D4F51A57F2E0389486CC016C662", hash_generated_method = "7EC2E2FBC8C03C31834D84C8B8CA18FB")
    @ViewDebug.ExportedProperty(category = "layout")
    public final int getHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587132222 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587132222;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.534 -0400", hash_original_method = "7CEA71A6443E0B0137E2E074FCAA909B", hash_generated_method = "06428B37B746EB9DAE5B5BA3D5265775")
    public void getDrawingRect(Rect outRect) {
        outRect.left = mScrollX;
        outRect.top = mScrollY;
        outRect.right = mScrollX + (mRight - mLeft);
        outRect.bottom = mScrollY + (mBottom - mTop);
        addTaint(outRect.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.534 -0400", hash_original_method = "A160459557267C576C1546F5990AEB19", hash_generated_method = "A8D67F3DC24150DD0F32BFCA78EAFB51")
    public final int getMeasuredWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375460821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375460821;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.534 -0400", hash_original_method = "C38A45A87603EC21B0D791190210A10A", hash_generated_method = "C963FD5DD71C62ED97897F48BF136FF2")
    public final int getMeasuredWidthAndState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_453505391 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_453505391;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.534 -0400", hash_original_method = "DA51B2F5E67991A819725ED6FD645434", hash_generated_method = "2519D04820C9BCE307E4B2BEC59CD0BA")
    public final int getMeasuredHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263281264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263281264;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.535 -0400", hash_original_method = "380B2985895F884CFF464A15E274F566", hash_generated_method = "5887CA5715891AC76E2A7120A301D443")
    public final int getMeasuredHeightAndState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790638736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790638736;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.535 -0400", hash_original_method = "12D9B5BDD1AC8F21212E58A2AB0D2736", hash_generated_method = "7BB802392CF6D104261634D33CDB88DD")
    public final int getMeasuredState() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049048252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1049048252;
        
        
                
                        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.536 -0400", hash_original_method = "B4B4CEBFEE2F615BED379C4D0CB9432E", hash_generated_method = "D37FA532C5304D8B82B2254A85AF1F6C")
    public Matrix getMatrix() {
        Matrix varB4EAC82CA7396A68D541C85D26508E83_884810014 = null; 
        Matrix varB4EAC82CA7396A68D541C85D26508E83_617440742 = null; 
        {
            updateMatrix();
            varB4EAC82CA7396A68D541C85D26508E83_884810014 = mTransformationInfo.mMatrix;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_617440742 = Matrix.IDENTITY_MATRIX;
        Matrix varA7E53CE21691AB073D9660D615818899_562133853; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_562133853 = varB4EAC82CA7396A68D541C85D26508E83_884810014;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_562133853 = varB4EAC82CA7396A68D541C85D26508E83_617440742;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_562133853.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_562133853;
        
        
            
            
        
        
    }

    
        private static boolean nonzero(float value) {
        return (value < -NONZERO_EPSILON || value > NONZERO_EPSILON);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.536 -0400", hash_original_method = "5E74D6706011574C7C512DCC96608456", hash_generated_method = "1217B40C22A95F9E31F20E7DEED5A06A")
    final boolean hasIdentityMatrix() {
        {
            updateMatrix();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_506414940 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_506414940;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.537 -0400", hash_original_method = "4153D754422EE39DF2ACBB08A45B169B", hash_generated_method = "BD5D26DA166F862ABB1F598913894B2C")
     void ensureTransformationInfo() {
        {
            mTransformationInfo = new TransformationInfo();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.538 -0400", hash_original_method = "1DF4F5A3EE086291C2134A9A06069FA8", hash_generated_method = "A2E7B43FC6FF7EA7A7EA39A7C9F14ABF")
    private void updateMatrix() {
        final TransformationInfo info = mTransformationInfo;
        {
            {
                {
                    info.mPrevWidth = mRight - mLeft;
                    info.mPrevHeight = mBottom - mTop;
                    info.mPivotX = info.mPrevWidth / 2f;
                    info.mPivotY = info.mPrevHeight / 2f;
                } 
            } 
            info.mMatrix.reset();
            {
                boolean varAB848ECD95BE565B20450DBD0CDBCCC2_1866370851 = (!nonzero(info.mRotationX) && !nonzero(info.mRotationY));
                {
                    info.mMatrix.setTranslate(info.mTranslationX, info.mTranslationY);
                    info.mMatrix.preRotate(info.mRotation, info.mPivotX, info.mPivotY);
                    info.mMatrix.preScale(info.mScaleX, info.mScaleY, info.mPivotX, info.mPivotY);
                } 
                {
                    {
                        info.mCamera = new Camera();
                        info.matrix3D = new Matrix();
                    } 
                    info.mCamera.save();
                    info.mMatrix.preScale(info.mScaleX, info.mScaleY, info.mPivotX, info.mPivotY);
                    info.mCamera.rotate(info.mRotationX, info.mRotationY, -info.mRotation);
                    info.mCamera.getMatrix(info.matrix3D);
                    info.matrix3D.preTranslate(-info.mPivotX, -info.mPivotY);
                    info.matrix3D.postTranslate(info.mPivotX + info.mTranslationX,
                        info.mPivotY + info.mTranslationY);
                    info.mMatrix.postConcat(info.matrix3D);
                    info.mCamera.restore();
                } 
            } 
            info.mMatrixDirty = false;
            info.mMatrixIsIdentity = info.mMatrix.isIdentity();
            info.mInverseMatrixDirty = true;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.540 -0400", hash_original_method = "9D52A0CAB8326A9AD998EDD411D2DD92", hash_generated_method = "E03C5CD20FAFC2A146291FCDA348DE8E")
    final Matrix getInverseMatrix() {
        Matrix varB4EAC82CA7396A68D541C85D26508E83_1456886474 = null; 
        Matrix varB4EAC82CA7396A68D541C85D26508E83_512698898 = null; 
        final TransformationInfo info = mTransformationInfo;
        {
            updateMatrix();
            {
                {
                    info.mInverseMatrix = new Matrix();
                } 
                info.mMatrix.invert(info.mInverseMatrix);
                info.mInverseMatrixDirty = false;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1456886474 = info.mInverseMatrix;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_512698898 = Matrix.IDENTITY_MATRIX;
        Matrix varA7E53CE21691AB073D9660D615818899_492765524; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_492765524 = varB4EAC82CA7396A68D541C85D26508E83_1456886474;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_492765524 = varB4EAC82CA7396A68D541C85D26508E83_512698898;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_492765524.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_492765524;
        
        
        
            
            
                
                    
                
                
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.540 -0400", hash_original_method = "210DCA800515E4777DE0E07A52837B76", hash_generated_method = "CA03DE0B122A78E2965DA53A3793C3EE")
    public void setCameraDistance(float distance) {
        invalidateParentCaches();
        invalidate(false);
        ensureTransformationInfo();
        final float dpi = mResources.getDisplayMetrics().densityDpi;
        final TransformationInfo info = mTransformationInfo;
        {
            info.mCamera = new Camera();
            info.matrix3D = new Matrix();
        } 
        info.mCamera.setLocation(0.0f, 0.0f, -Math.abs(distance) / dpi);
        info.mMatrixDirty = true;
        invalidate(false);
        addTaint(distance);
        
        
        
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.541 -0400", hash_original_method = "6D5D42AE33FC6FF98224E10EE022285B", hash_generated_method = "4A6A6BF5C7C9A5940F15688D484FCDE9")
    public float getRotation() {
        float var546ADE640B6EDFBC8A086EF31347E768_1950014598 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1950014598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.541 -0400", hash_original_method = "5A5E2BB985CAA77255785D52BE0C3968", hash_generated_method = "199C98FC8A2B3DEB657A308995CF8436")
    public void setRotation(float rotation) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotation = rotation;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(rotation);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.541 -0400", hash_original_method = "AE949F6C8375A0B1C86B95F13F6ACDFA", hash_generated_method = "FB60C15FCC7DFE5E25B204248D1423E7")
    public float getRotationY() {
        float var546ADE640B6EDFBC8A086EF31347E768_578923758 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_578923758;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.542 -0400", hash_original_method = "5A233F5FAA167B597E6F53F6A1ED05E0", hash_generated_method = "35493764D8D34DF068FF49BBCA787A02")
    public void setRotationY(float rotationY) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationY = rotationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(rotationY);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.542 -0400", hash_original_method = "A555D00D0BA60E223889AA9DD2F251D5", hash_generated_method = "F133EAA9F7A6924D447933CAD79CEF9D")
    public float getRotationX() {
        float var546ADE640B6EDFBC8A086EF31347E768_36769741 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_36769741;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.543 -0400", hash_original_method = "6E42F99146F1D6958E2B3C15F474346C", hash_generated_method = "E2EAA0CBF8BEFA11D7C2B43304F1979B")
    public void setRotationX(float rotationX) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mRotationX = rotationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(rotationX);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.543 -0400", hash_original_method = "632CD3DC31F3C9373697ECAF67FAF844", hash_generated_method = "07D00927BC77B2E8C2409D00829BCABD")
    public float getScaleX() {
        float var546ADE640B6EDFBC8A086EF31347E768_927892206 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_927892206;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.543 -0400", hash_original_method = "5D4E1982532E84086C93276B88F3BB0F", hash_generated_method = "570A0C5426091DEA5F213C4AE80A991C")
    public void setScaleX(float scaleX) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleX = scaleX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(scaleX);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.543 -0400", hash_original_method = "0DC96E7C5CC6BBD5C09BD0CF27C74A57", hash_generated_method = "03795481FC2DFC19DF7CE60CC8354046")
    public float getScaleY() {
        float var546ADE640B6EDFBC8A086EF31347E768_161725060 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_161725060;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.544 -0400", hash_original_method = "31C6EE08A123288B2AD5FB7A2AB8A50C", hash_generated_method = "6332A9DF8BB78677A390821D952C67E3")
    public void setScaleY(float scaleY) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mScaleY = scaleY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(scaleY);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.544 -0400", hash_original_method = "AEC7496CCA4C936C6BC2B5B4BAFC57DA", hash_generated_method = "60EF808A5AED3809EB4524AC2A1FD27B")
    public float getPivotX() {
        float var546ADE640B6EDFBC8A086EF31347E768_499518967 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_499518967;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.545 -0400", hash_original_method = "DBB537948450A8273883C6E25FB642C5", hash_generated_method = "0E945D6DC336C85DE6A5066844DD0883")
    public void setPivotX(float pivotX) {
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotX = pivotX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(pivotX);
        
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.545 -0400", hash_original_method = "0240E9206D9E9715A6B3E78480FB3A00", hash_generated_method = "227AA13565F0B3809E29F20489DBD40C")
    public float getPivotY() {
        float var546ADE640B6EDFBC8A086EF31347E768_158512468 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_158512468;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.545 -0400", hash_original_method = "6A61D38311657070A62B2EA4ECB210D8", hash_generated_method = "083DF3AB1561EDFEDE0B146B6A6F7E0F")
    public void setPivotY(float pivotY) {
        ensureTransformationInfo();
        mPrivateFlags |= PIVOT_EXPLICITLY_SET;
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mPivotY = pivotY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(pivotY);
        
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.546 -0400", hash_original_method = "93EFA4392922E182D3B77409B1564364", hash_generated_method = "30B2C016BCBCF971960B7883D5C4F0FE")
    public float getAlpha() {
        float var546ADE640B6EDFBC8A086EF31347E768_1789349556 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1789349556;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.546 -0400", hash_original_method = "D47D7B67C2848D6684CE263C68979D07", hash_generated_method = "22D89E6D095A50BB5F9391819749C255")
    public void setAlpha(float alpha) {
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        invalidateParentCaches();
        {
            boolean var27A92F9962D09A8451E041A66077AE9B_72260304 = (onSetAlpha((int) (alpha * 255)));
            {
                mPrivateFlags |= ALPHA_SET;
                invalidate(true);
            } 
            {
                mPrivateFlags &= ~ALPHA_SET;
                invalidate(false);
            } 
        } 
        
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.547 -0400", hash_original_method = "3CB99BAEF01722CCB474EC85E6659EEE", hash_generated_method = "D534FD082FEDBBCB29F0544237EBC713")
     boolean setAlphaNoInvalidation(float alpha) {
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        boolean subclassHandlesAlpha = onSetAlpha((int) (alpha * 255));
        {
            mPrivateFlags |= ALPHA_SET;
        } 
        {
            mPrivateFlags &= ~ALPHA_SET;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618958563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618958563;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.547 -0400", hash_original_method = "7F5BCC343553D8AF12DD736B7A32ED37", hash_generated_method = "B7554923BA34D18013CB6ED194B52EEB")
    @ViewDebug.CapturedViewProperty
    public final int getTop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159911553 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_159911553;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.549 -0400", hash_original_method = "B40CE7C2F79D3592297A6568172CADD8", hash_generated_method = "D783F8BE80D0B2BA52D1CEAB94AC3190")
    public final void setTop(int top) {
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int minTop;
                    int yLoc;
                    {
                        minTop = top;
                        yLoc = top - mTop;
                    } 
                    {
                        minTop = mTop;
                        yLoc = 0;
                    } 
                    invalidate(0, yLoc, mRight - mLeft, mBottom - minTop);
                } 
            } 
            {
                invalidate(true);
            } 
            int width = mRight - mLeft;
            int oldHeight = mBottom - mTop;
            mTop = top;
            onSizeChanged(width, mBottom - mTop, width, oldHeight);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } 
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } 
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.550 -0400", hash_original_method = "D7B6007ED4F8CEAF5E034DAB4DC51ADC", hash_generated_method = "58B5059BB354B6E09497D375205DE328")
    @ViewDebug.CapturedViewProperty
    public final int getBottom() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129688173 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_129688173;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.550 -0400", hash_original_method = "389E1BFAE78D9C18A209C3C1F1063911", hash_generated_method = "8A1FEA41848688C20EA408776C7A381A")
    public boolean isDirty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770033063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770033063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.551 -0400", hash_original_method = "23478A87AB3417F9EDAE904815FA444D", hash_generated_method = "BE6261F500B4597DA90C6456F7B9FF82")
    public final void setBottom(int bottom) {
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int maxBottom;
                    {
                        maxBottom = mBottom;
                    } 
                    {
                        maxBottom = bottom;
                    } 
                    invalidate(0, 0, mRight - mLeft, maxBottom - mTop);
                } 
            } 
            {
                invalidate(true);
            } 
            int width = mRight - mLeft;
            int oldHeight = mBottom - mTop;
            mBottom = bottom;
            onSizeChanged(width, mBottom - mTop, width, oldHeight);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } 
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } 
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.551 -0400", hash_original_method = "73B96062BAB5FB21A32F13529B38306E", hash_generated_method = "80C48DA70E59692C5AD411777E44C8D2")
    @ViewDebug.CapturedViewProperty
    public final int getLeft() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438159566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1438159566;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.551 -0400", hash_original_method = "400602AE9C159A853CD1519C8EEA2C4D", hash_generated_method = "5FE6FF68AB42940C61788C0EE3CA8DBD")
    public final void setLeft(int left) {
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int minLeft;
                    int xLoc;
                    {
                        minLeft = left;
                        xLoc = left - mLeft;
                    } 
                    {
                        minLeft = mLeft;
                        xLoc = 0;
                    } 
                    invalidate(xLoc, 0, mRight - minLeft, mBottom - mTop);
                } 
            } 
            {
                invalidate(true);
            } 
            int oldWidth = mRight - mLeft;
            int height = mBottom - mTop;
            mLeft = left;
            onSizeChanged(mRight - mLeft, height, oldWidth, height);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } 
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } 
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.552 -0400", hash_original_method = "BAA591F437367FFFE3E50F2B2874B150", hash_generated_method = "88DA5A80B32C29F4A6228A877C269602")
    @ViewDebug.CapturedViewProperty
    public final int getRight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127515766 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1127515766;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.552 -0400", hash_original_method = "2D86637EDDF21E63210ED8568FEA8F8B", hash_generated_method = "BED0D71B0BD8F57D16F7BF8E753727E5")
    public final void setRight(int right) {
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                {
                    int maxRight;
                    {
                        maxRight = mRight;
                    } 
                    {
                        maxRight = right;
                    } 
                    invalidate(0, 0, maxRight - mLeft, mBottom - mTop);
                } 
            } 
            {
                invalidate(true);
            } 
            int oldWidth = mRight - mLeft;
            int height = mBottom - mTop;
            mRight = right;
            onSizeChanged(mRight - mLeft, height, oldWidth, height);
            {
                {
                    mTransformationInfo.mMatrixDirty = true;
                } 
                mPrivateFlags |= DRAWN;
                invalidate(true);
            } 
            mBackgroundSizeChanged = true;
            invalidateParentIfNeeded();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.553 -0400", hash_original_method = "245DBA10F47190D5F336E33CB089C2B3", hash_generated_method = "2EB4874F2098E631B5E1A15181A5E1C0")
    public float getX() {
        float var546ADE640B6EDFBC8A086EF31347E768_457020163 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_457020163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.553 -0400", hash_original_method = "CF32EA1F394F68FC79E0B0DE51F0C329", hash_generated_method = "BAEE0B5E3AC636509CFAC98493EB23E6")
    public void setX(float x) {
        setTranslationX(x - mLeft);
        addTaint(x);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.553 -0400", hash_original_method = "52DD2F53B3B778139AEDE644F53CC413", hash_generated_method = "E4AF6E4402F44C7445B517B8FCB1D994")
    public float getY() {
        float var546ADE640B6EDFBC8A086EF31347E768_477905044 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_477905044;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.554 -0400", hash_original_method = "17990A784E3651A021C8D9C97053B995", hash_generated_method = "F01548C85E60534244C8021D99D8F2A1")
    public void setY(float y) {
        setTranslationY(y - mTop);
        addTaint(y);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.554 -0400", hash_original_method = "A376723ACFB723DF70FCDB72B84F3B74", hash_generated_method = "05F548EA145FDC21F86787A43EAFAA90")
    public float getTranslationX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1708875041 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1708875041;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.555 -0400", hash_original_method = "099C9E42CAA9B2F0466F96FB99A2B049", hash_generated_method = "F1EB2564758830A84811897AB3FC7C5E")
    public void setTranslationX(float translationX) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationX = translationX;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(translationX);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.555 -0400", hash_original_method = "3533DDBA4926D8143F5FEBC602AC7438", hash_generated_method = "40B6EC2CEAAE80895EC37218D1F08AA6")
    public float getTranslationY() {
        float var546ADE640B6EDFBC8A086EF31347E768_742857168 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_742857168;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.556 -0400", hash_original_method = "162C2FF9FF4565DE36BAE7FE449EEB59", hash_generated_method = "C1D748BBC905094F3B1A3125BBA820B0")
    public void setTranslationY(float translationY) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        {
            invalidateParentCaches();
            invalidate(false);
            info.mTranslationY = translationY;
            info.mMatrixDirty = true;
            mPrivateFlags |= DRAWN;
            invalidate(false);
        } 
        addTaint(translationY);
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.557 -0400", hash_original_method = "02B92D2EDB4EF774368BD328DB9464D0", hash_generated_method = "4B0D63EF28F6F6F10AD97963B843BE76")
    public void setFastTranslationX(float x) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x;
        info.mMatrixDirty = true;
        addTaint(x);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.557 -0400", hash_original_method = "7A3DD70389071B86917A72495144388B", hash_generated_method = "2E34A62476D562931046151409351F21")
    public void setFastTranslationY(float y) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y;
        info.mMatrixDirty = true;
        addTaint(y);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.558 -0400", hash_original_method = "27E5E5A6B58B43EDE1C38FBEFFB0B4F7", hash_generated_method = "2F8451A6703F284D421B366AF67CB6D2")
    public void setFastX(float x) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationX = x - mLeft;
        info.mMatrixDirty = true;
        addTaint(x);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.559 -0400", hash_original_method = "435AAC5941937B26A66754F689D5E36E", hash_generated_method = "66197D39C8C5F37B1A9A3EE163CD0091")
    public void setFastY(float y) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mTranslationY = y - mTop;
        info.mMatrixDirty = true;
        addTaint(y);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.560 -0400", hash_original_method = "8FBF5EB14D6023B3D32370623C07D6EB", hash_generated_method = "4A66207B2ABBC129FE0B1B70FA4FCB8B")
    public void setFastScaleX(float x) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleX = x;
        info.mMatrixDirty = true;
        addTaint(x);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.563 -0400", hash_original_method = "AA6BDD2065E69990CAD75C2A9525B2D0", hash_generated_method = "55A18B10D9B070D5940150081B114723")
    public void setFastScaleY(float y) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mScaleY = y;
        info.mMatrixDirty = true;
        addTaint(y);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.563 -0400", hash_original_method = "AD7F6BBA7BB1872387A16DCF0021D7AA", hash_generated_method = "621D2591E23FA811817E9AE822951428")
    public void setFastAlpha(float alpha) {
        ensureTransformationInfo();
        mTransformationInfo.mAlpha = alpha;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.564 -0400", hash_original_method = "3ADB507BF62ACDA7E6B7E6725B1B98A0", hash_generated_method = "7FEE601698C629184B05CED245AB5FEB")
    public void setFastRotationY(float y) {
        ensureTransformationInfo();
        final TransformationInfo info = mTransformationInfo;
        info.mRotationY = y;
        info.mMatrixDirty = true;
        addTaint(y);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.564 -0400", hash_original_method = "CD4FEC45EB5F7DBC5B440DED4446311E", hash_generated_method = "75A2852D2A3D0A1FED7F2173F5527E79")
    public void getHitRect(Rect outRect) {
        updateMatrix();
        final TransformationInfo info = mTransformationInfo;
        {
            outRect.set(mLeft, mTop, mRight, mBottom);
        } 
        {
            final RectF tmpRect = mAttachInfo.mTmpTransformRect;
            tmpRect.set(-info.mPivotX, -info.mPivotY,
                    getWidth() - info.mPivotX, getHeight() - info.mPivotY);
            info.mMatrix.mapRect(tmpRect);
            outRect.set((int) tmpRect.left + mLeft, (int) tmpRect.top + mTop,
                    (int) tmpRect.right + mLeft, (int) tmpRect.bottom + mTop);
        } 
        addTaint(outRect.getTaint());
        
        
        
        
            
        
            
            
                    
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.565 -0400", hash_original_method = "E2A76004025C1F44E382F6372B86BB53", hash_generated_method = "6F6D75D107F9EDE2FE63536032AB3869")
    final boolean pointInView(float localX, float localY) {
        addTaint(localX);
        addTaint(localY);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866745122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_866745122;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.565 -0400", hash_original_method = "D00244756776E7D2FD65633E1CF43263", hash_generated_method = "0B50566D2379A7771AAD3CA00A55F6D5")
    private boolean pointInView(float localX, float localY, float slop) {
        addTaint(localX);
        addTaint(localY);
        addTaint(slop);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628963469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628963469;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.566 -0400", hash_original_method = "DDDABA6E6D899E7EA47B4452312088BE", hash_generated_method = "AC09A9567DAAAEDD7A9EEB650F041E19")
    public void getFocusedRect(Rect r) {
        getDrawingRect(r);
        addTaint(r.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.566 -0400", hash_original_method = "24BDD9FA3E3C2FB6EA31ED75B384BDD9", hash_generated_method = "86527B187EB3A0EB0057492D133E04BD")
    public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
        int width = mRight - mLeft;
        int height = mBottom - mTop;
        {
            r.set(0, 0, width, height);
            {
                globalOffset.set(-mScrollX, -mScrollY);
            } 
            boolean varD0C4A40C45EF46AFF22F080E1528CE15_1711050266 = (mParent == null || mParent.getChildVisibleRect(this, r, globalOffset));
        } 
        addTaint(r.getTaint());
        addTaint(globalOffset.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968802285 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968802285;
        
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.567 -0400", hash_original_method = "EADCD4C63731C6547F1C03CEAFC09A53", hash_generated_method = "90071787CB2170A31A4BD616401FDF5E")
    public final boolean getGlobalVisibleRect(Rect r) {
        boolean varA0E19E10963694B496EAF71FD83982B3_56013314 = (getGlobalVisibleRect(r, null));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990667748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_990667748;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.567 -0400", hash_original_method = "CB024757CF5A14ECB6F9DCD9789CD2F8", hash_generated_method = "805517978FC35DBE9E01039C4DBBFB5C")
    public final boolean getLocalVisibleRect(Rect r) {
        Point offset = new Point();
        {
            boolean varBBF18CCA515610662C9382F2D4C23619_569568212 = (getGlobalVisibleRect(r, offset));
            {
                r.offset(-offset.x, -offset.y);
            } 
        } 
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643561847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643561847;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.570 -0400", hash_original_method = "5A4ADD2D1ADF5703ED27FAE1582BB62A", hash_generated_method = "87F1F7FE196FC6E9E2196A6D17DF9350")
    public void offsetTopAndBottom(int offset) {
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                final ViewParent p = mParent;
                {
                    final Rect r = mAttachInfo.mTmpInvalRect;
                    int minTop;
                    int maxBottom;
                    int yLoc;
                    {
                        minTop = mTop + offset;
                        maxBottom = mBottom;
                        yLoc = offset;
                    } 
                    {
                        minTop = mTop;
                        maxBottom = mBottom + offset;
                        yLoc = 0;
                    } 
                    r.set(0, yLoc, mRight - mLeft, maxBottom - minTop);
                    p.invalidateChild(this, r);
                } 
            } 
            {
                invalidate(false);
            } 
            mTop += offset;
            mBottom += offset;
            {
                mPrivateFlags |= DRAWN;
                invalidate(false);
            } 
            invalidateParentIfNeeded();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.571 -0400", hash_original_method = "A934BA60BC3812BC980C4328CCEB9557", hash_generated_method = "A78CEE7F2DB450938413D9FC8E939A2B")
    public void offsetLeftAndRight(int offset) {
        {
            updateMatrix();
            final boolean matrixIsIdentity = mTransformationInfo == null
                    || mTransformationInfo.mMatrixIsIdentity;
            {
                final ViewParent p = mParent;
                {
                    final Rect r = mAttachInfo.mTmpInvalRect;
                    int minLeft;
                    int maxRight;
                    {
                        minLeft = mLeft + offset;
                        maxRight = mRight;
                    } 
                    {
                        minLeft = mLeft;
                        maxRight = mRight + offset;
                    } 
                    r.set(0, 0, maxRight - minLeft, mBottom - mTop);
                    p.invalidateChild(this, r);
                } 
            } 
            {
                invalidate(false);
            } 
            mLeft += offset;
            mRight += offset;
            {
                mPrivateFlags |= DRAWN;
                invalidate(false);
            } 
            invalidateParentIfNeeded();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.571 -0400", hash_original_method = "5EB740A9A129A62709C940CDC3C1FA90", hash_generated_method = "C3DB29BAAC789913308CFB2E03B95F5E")
    @ViewDebug.ExportedProperty(deepExport = true, prefix = "layout_")
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1559371226 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1559371226 = mLayoutParams;
        varB4EAC82CA7396A68D541C85D26508E83_1559371226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1559371226;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.572 -0400", hash_original_method = "279E70A70FA2B2FEFF6E7E1E87EEDC2B", hash_generated_method = "8E0A191BC3BEC45F342B8D12A19BA2C3")
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Layout parameters cannot be null");
        } 
        mLayoutParams = params;
        requestLayout();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.577 -0400", hash_original_method = "C9DC0366B539164245F3B3ACA0A07797", hash_generated_method = "B45AAAE0DA071858A41B936BC4D9385A")
    public void scrollTo(int x, int y) {
        {
            int oldX = mScrollX;
            int oldY = mScrollY;
            mScrollX = x;
            mScrollY = y;
            invalidateParentCaches();
            onScrollChanged(mScrollX, mScrollY, oldX, oldY);
            {
                boolean varC828E793AFDA5CD988FA9008B6EB3B30_494482396 = (!awakenScrollBars());
                {
                    invalidate(true);
                } 
            } 
        } 
        
        
            
            
            
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.577 -0400", hash_original_method = "9A3BFF0D9282AAB8B07B22048D68076B", hash_generated_method = "1A9AAA4081652147B61CFEDF7EFA4EA4")
    public void scrollBy(int x, int y) {
        scrollTo(mScrollX + x, mScrollY + y);
        addTaint(x);
        addTaint(y);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.577 -0400", hash_original_method = "08F687B40826EF7DBBF2573184DC2210", hash_generated_method = "E92E5D351A2A01CCC04329A869B144D4")
    protected boolean awakenScrollBars() {
        boolean var70EE0F5768F31DAF2C1A8B4E95A75A4F_398480126 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade, true));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861456522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861456522;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.578 -0400", hash_original_method = "2B4CF6E85FAE9FF55F32C24BEFDC5081", hash_generated_method = "8746846F1CF17FB68D99728C3FE52CEB")
    private boolean initialAwakenScrollBars() {
        boolean var92AEF1EA9E316D77EDD85ABCDC19B36B_604043524 = (mScrollCache != null &&
                awakenScrollBars(mScrollCache.scrollBarDefaultDelayBeforeFade * 4, true));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945821897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945821897;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.578 -0400", hash_original_method = "D5CE7E5EDCD7F839910A14AF470AF787", hash_generated_method = "DE4753EB190FB89A20A48C33A649F0D5")
    protected boolean awakenScrollBars(int startDelay) {
        boolean varF0BE7569E2898F8A7748258008B8FAFD_1829971343 = (awakenScrollBars(startDelay, true));
        addTaint(startDelay);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659003881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659003881;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.578 -0400", hash_original_method = "CAD4350A25772201F660B41D91481A2E", hash_generated_method = "69393954864031070DA175498B24688B")
    protected boolean awakenScrollBars(int startDelay, boolean invalidate) {
        final ScrollabilityCache scrollCache = mScrollCache;
        {
            scrollCache.scrollBar = new ScrollBarDrawable();
        } 
        {
            boolean var5422F660D44B0D1544FC157071290861_1302411687 = (isHorizontalScrollBarEnabled() || isVerticalScrollBarEnabled());
            {
                {
                    invalidate(true);
                } 
                {
                    final int KEY_REPEAT_FIRST_DELAY = 750;
                    startDelay = Math.max(KEY_REPEAT_FIRST_DELAY, startDelay);
                } 
                long fadeStartTime = AnimationUtils.currentAnimationTimeMillis() + startDelay;
                scrollCache.fadeStartTime = fadeStartTime;
                scrollCache.state = ScrollabilityCache.ON;
                {
                    mAttachInfo.mHandler.removeCallbacks(scrollCache);
                    mAttachInfo.mHandler.postAtTime(scrollCache, fadeStartTime);
                } 
            } 
        } 
        addTaint(startDelay);
        addTaint(invalidate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872549432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872549432;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.579 -0400", hash_original_method = "FC7DFAD8D0391FACDB1212D1D56F8C7D", hash_generated_method = "AE1E2D5EA8E3D0F7515EA33D38BE7EC0")
    private boolean skipInvalidate() {
        boolean var8D9B0BE46D426CBE2B5119C4603A668E_191690270 = ((mViewFlags & VISIBILITY_MASK) != VISIBLE && mCurrentAnimation == null &&
                (!(mParent instanceof ViewGroup) ||
                        !((ViewGroup) mParent).isViewTransitioning(this)));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646165495 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646165495;
        
        
                
                        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.579 -0400", hash_original_method = "C9F4885B3240AC42BDB62659847A9804", hash_generated_method = "6CEDBAD0449A07E5E231FBF1AF616D40")
    public void invalidate(Rect dirty) {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } 
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_214377585 = (skipInvalidate());
        } 
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            final ViewParent p = mParent;
            final AttachInfo ai = mAttachInfo;
            {
                {
                    p.invalidateChild(this, null);
                } 
            } 
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                final Rect r = ai.mTmpInvalRect;
                r.set(dirty.left - scrollX, dirty.top - scrollY,
                        dirty.right - scrollX, dirty.bottom - scrollY);
                mParent.invalidateChild(this, r);
            } 
        } 
        addTaint(dirty.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.579 -0400", hash_original_method = "ADB8190FF1114977057C1857B6D8BC7D", hash_generated_method = "8C27023CE7D39AB9A12329C66DDD809E")
    public void invalidate(int l, int t, int r, int b) {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } 
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_863631323 = (skipInvalidate());
        } 
        {
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags |= DIRTY;
            final ViewParent p = mParent;
            final AttachInfo ai = mAttachInfo;
            {
                {
                    p.invalidateChild(this, null);
                } 
            } 
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                final Rect tmpr = ai.mTmpInvalRect;
                tmpr.set(l - scrollX, t - scrollY, r - scrollX, b - scrollY);
                p.invalidateChild(this, tmpr);
            } 
        } 
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.580 -0400", hash_original_method = "DD9880156AB041E4BB31F756D1AB2189", hash_generated_method = "BF85BB9D7AA11B7869ED1AB59ACA8EDC")
    public void invalidate() {
        invalidate(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.580 -0400", hash_original_method = "2A2B8D7DA5636907090E85C40DC13DF0", hash_generated_method = "50038C73821C9AF303D74F0774D7D2E4")
     void invalidate(boolean invalidateCache) {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE);
        } 
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_143926188 = (skipInvalidate());
        } 
        {
            boolean var5D4EC7C3849E23BFDACCE7FE932C2ED1_1311000348 = ((mPrivateFlags & (DRAWN | HAS_BOUNDS)) == (DRAWN | HAS_BOUNDS) ||
                (invalidateCache && (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID) ||
                (mPrivateFlags & INVALIDATED) != INVALIDATED || isOpaque() != mLastIsOpaque);
            {
                mLastIsOpaque = isOpaque();
                mPrivateFlags &= ~DRAWN;
                mPrivateFlags |= DIRTY;
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                } 
                final AttachInfo ai = mAttachInfo;
                final ViewParent p = mParent;
                {
                    {
                        p.invalidateChild(this, null);
                    } 
                } 
                {
                    final Rect r = ai.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    p.invalidateChild(this, r);
                } 
            } 
        } 
        addTaint(invalidateCache);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.581 -0400", hash_original_method = "9E49D44B70542B7D202A00B58BCD901B", hash_generated_method = "AE7085DA7E907421E7F09FE8EE96BCC8")
    public void fastInvalidate() {
        {
            boolean varD5DC22E7E87E4B26C6AA34C5FC18E1F5_263900203 = (skipInvalidate());
        } 
        {
            {
                ((View) mParent).mPrivateFlags |= INVALIDATED;
            } 
            mPrivateFlags &= ~DRAWN;
            mPrivateFlags |= DIRTY;
            mPrivateFlags |= INVALIDATED;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
            {
                {
                    mParent.invalidateChild(this, null);
                } 
                {
                    final Rect r = mAttachInfo.mTmpInvalRect;
                    r.set(0, 0, mRight - mLeft, mBottom - mTop);
                    mParent.invalidateChild(this, r);
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.581 -0400", hash_original_method = "74A87B1768814B24E7FEDDF99D8537F0", hash_generated_method = "259EF29A518D154D0008BBE13AE3F86A")
    protected void invalidateParentCaches() {
        {
            ((View) mParent).mPrivateFlags |= INVALIDATED;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.581 -0400", hash_original_method = "A648B59C2EE20F29A9B99BF448851618", hash_generated_method = "A43041CC3C38FC398C34689F663BEFC2")
    protected void invalidateParentIfNeeded() {
        {
            boolean var0CFA59CC9046639DFA3FC76B3FAFF415_1874936517 = (isHardwareAccelerated() && mParent instanceof View);
            {
                ((View) mParent).invalidate(true);
            } 
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.582 -0400", hash_original_method = "E9C24F17558159FB485FCFC13D70293E", hash_generated_method = "66E6DC552B8EFA164ACF534AEBA02CF5")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050452240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050452240;
        
        
                
                        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.582 -0400", hash_original_method = "497EF7DE92B2945B2FEC8F46EAD33430", hash_generated_method = "BFDF5BD3D5BCF2686A631B063AF7C993")
    protected void computeOpaqueFlags() {
        {
            boolean var4EAF945C1787CBA8CB4548E7AF4BB4B5_725321849 = (mBGDrawable != null && mBGDrawable.getOpacity() == PixelFormat.OPAQUE);
            {
                mPrivateFlags |= OPAQUE_BACKGROUND;
            } 
            {
                mPrivateFlags &= ~OPAQUE_BACKGROUND;
            } 
        } 
        final int flags = mViewFlags;
        {
            mPrivateFlags |= OPAQUE_SCROLLBARS;
        } 
        {
            mPrivateFlags &= ~OPAQUE_SCROLLBARS;
        } 
        
        
            
        
            
        
        
        
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.582 -0400", hash_original_method = "7EE186D55064FCDB5B25DFE594562441", hash_generated_method = "54A33F0F60A2CE2BD3BC2DBD44085464")
    protected boolean hasOpaqueScrollbars() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_770165906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_770165906;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.583 -0400", hash_original_method = "DDF5EC42ADE793605447903B93381C32", hash_generated_method = "D49A3E8DA9E878A1787F2F082786A3D5")
    public Handler getHandler() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_2076341788 = null; 
        Handler varB4EAC82CA7396A68D541C85D26508E83_909347433 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2076341788 = mAttachInfo.mHandler;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_909347433 = null;
        Handler varA7E53CE21691AB073D9660D615818899_1955610688; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1955610688 = varB4EAC82CA7396A68D541C85D26508E83_2076341788;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1955610688 = varB4EAC82CA7396A68D541C85D26508E83_909347433;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1955610688.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1955610688;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.583 -0400", hash_original_method = "8EDFE6EE958B917F012E9131A0AEA287", hash_generated_method = "311E980B9051F8C057FD68CE1D765119")
    public boolean post(Runnable action) {
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        {
            handler = attachInfo.mHandler;
        } 
        {
            ViewRootImpl.getRunQueue().post(action);
        } 
        boolean var4B5FBEF08D1252F680BD85D523D3F99E_2017922689 = (handler.post(action));
        addTaint(action.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313807953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313807953;
        
        
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.701 -0400", hash_original_method = "D354828971EFD085BD14FC0D83048A19", hash_generated_method = "DD64DAD608CB71D47189AE54D666B268")
    public boolean postDelayed(Runnable action, long delayMillis) {
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        {
            handler = attachInfo.mHandler;
        } 
        {
            ViewRootImpl.getRunQueue().postDelayed(action, delayMillis);
        } 
        boolean varA94056EFF6A774C97C990690CB98EF64_298157208 = (handler.postDelayed(action, delayMillis));
        addTaint(action.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678237420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_678237420;
        
        
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.702 -0400", hash_original_method = "924A8BEE16A312E53AB8660A02DEF27E", hash_generated_method = "F3D30434D9B160F94B5306A55BF0F2F8")
    public boolean removeCallbacks(Runnable action) {
        Handler handler;
        AttachInfo attachInfo = mAttachInfo;
        {
            handler = attachInfo.mHandler;
        } 
        {
            ViewRootImpl.getRunQueue().removeCallbacks(action);
        } 
        handler.removeCallbacks(action);
        addTaint(action.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316841757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316841757;
        
        
        
        
            
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.702 -0400", hash_original_method = "B784E31CF9F406A65D385399252675E5", hash_generated_method = "E1CD8F02A4425412097D3886A78B39EF")
    public void postInvalidate() {
        postInvalidateDelayed(0);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.702 -0400", hash_original_method = "F30B35993A01DC68F672A7097988A2B2", hash_generated_method = "75B38AEF6E4ACE44458A3F112ED60DFC")
    public void postInvalidate(int left, int top, int right, int bottom) {
        postInvalidateDelayed(0, left, top, right, bottom);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.703 -0400", hash_original_method = "04635C950E88519FA950A99E2186B20C", hash_generated_method = "2FB49825F2C6E7AD003B6D45596D745C")
    public void postInvalidateDelayed(long delayMilliseconds) {
        AttachInfo attachInfo = mAttachInfo;
        {
            Message msg = Message.obtain();
            msg.what = AttachInfo.INVALIDATE_MSG;
            msg.obj = this;
            attachInfo.mHandler.sendMessageDelayed(msg, delayMilliseconds);
        } 
        addTaint(delayMilliseconds);
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.704 -0400", hash_original_method = "2AD5AD2CFDC403E5ADB3F0CF5F7AB2F6", hash_generated_method = "D106C5E80CFC0D643C9ED2D26B1EE633")
    public void postInvalidateDelayed(long delayMilliseconds, int left, int top,
            int right, int bottom) {
        AttachInfo attachInfo = mAttachInfo;
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
        } 
        addTaint(delayMilliseconds);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
            
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.705 -0400", hash_original_method = "BB237226F39DBA7BCAA624BDCB91F777", hash_generated_method = "37B71AD809B5E3FDDFA60D04296093DB")
    private void postSendViewScrolledAccessibilityEventCallback() {
        {
            mSendViewScrolledAccessibilityEvent = new SendViewScrolledAccessibilityEvent();
        } 
        {
            mSendViewScrolledAccessibilityEvent.mIsPending = true;
            postDelayed(mSendViewScrolledAccessibilityEvent,
                    ViewConfiguration.getSendRecurringAccessibilityEventsInterval());
        } 
        
        
            
        
        
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.706 -0400", hash_original_method = "7821AAE99E52242CE62352C839CCDCC3", hash_generated_method = "DC60F051596188244856202A1C5C2CDD")
    public void computeScroll() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.706 -0400", hash_original_method = "2F1443E103CAC5C1C2808AA2ECBBD417", hash_generated_method = "1242A5B8F759B544B910B0B2BF7F6E01")
    public boolean isHorizontalFadingEdgeEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634525062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634525062;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.707 -0400", hash_original_method = "EC0EB62D805892CAAD99FC80B5C4BCFE", hash_generated_method = "4A6B63D5E6B6565F9C3D5C09216959A2")
    public void setHorizontalFadingEdgeEnabled(boolean horizontalFadingEdgeEnabled) {
        {
            boolean varA3A448941DEDEC343F4D869D70054393_1344920458 = (isHorizontalFadingEdgeEnabled() != horizontalFadingEdgeEnabled);
            {
                {
                    initScrollCache();
                } 
                mViewFlags ^= FADING_EDGE_HORIZONTAL;
            } 
        } 
        addTaint(horizontalFadingEdgeEnabled);
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.708 -0400", hash_original_method = "DC4B7092961F5604BD589F14B65154AC", hash_generated_method = "83F985E1F2ADC4382395C823EF9FD70E")
    public boolean isVerticalFadingEdgeEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974941962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974941962;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.708 -0400", hash_original_method = "EAF2758FE6F0D2FA48FD42C13EB7A789", hash_generated_method = "7315E184908E90ADB97BB27BD0B07195")
    public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
        {
            boolean var01488E834A57F3E5162EDF629729F011_415243358 = (isVerticalFadingEdgeEnabled() != verticalFadingEdgeEnabled);
            {
                {
                    initScrollCache();
                } 
                mViewFlags ^= FADING_EDGE_VERTICAL;
            } 
        } 
        addTaint(verticalFadingEdgeEnabled);
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.709 -0400", hash_original_method = "CA0383E2F77249B4067FF4C25AA980FC", hash_generated_method = "717160A1589F5190CC085AF6F1D8A5F2")
    protected float getTopFadingEdgeStrength() {
        {
            boolean var95C748EB7173291A5F92BA7AE0D550D8_285223175 = (computeVerticalScrollOffset() > 0);
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_103095308 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_103095308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.709 -0400", hash_original_method = "DD443087D4013745234D8B8402D9412B", hash_generated_method = "D36DDDAF615B16116744594EE6219381")
    protected float getBottomFadingEdgeStrength() {
        {
            boolean varD919087A08EBAF1D1A5831A04C61CDFE_196824522 = (computeVerticalScrollOffset() + computeVerticalScrollExtent() <
                computeVerticalScrollRange());
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1540630457 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1540630457;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.710 -0400", hash_original_method = "7D1377787749722D9D47682EF553F1ED", hash_generated_method = "4C9442A0A2CCDCA48380ECEC3A2AE83A")
    protected float getLeftFadingEdgeStrength() {
        {
            boolean var7654C1BFABAF507D7C3E35D81F9F8DFD_1847366321 = (computeHorizontalScrollOffset() > 0);
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1352277900 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1352277900;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.711 -0400", hash_original_method = "1558452CB016696B11D09745F34240BE", hash_generated_method = "57D186F7D0CFA8C0DACF8168C02EDE07")
    protected float getRightFadingEdgeStrength() {
        {
            boolean var769CCFA152889A66107FC92852AF7E99_1579767881 = (computeHorizontalScrollOffset() + computeHorizontalScrollExtent() <
                computeHorizontalScrollRange());
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_662604242 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_662604242;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.711 -0400", hash_original_method = "4C9FBABF966493498122F359EE4D62B4", hash_generated_method = "86E6434382256D5BCA95C20CC0CA108E")
    public boolean isHorizontalScrollBarEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160174821 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160174821;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.711 -0400", hash_original_method = "5F4F07B15655223ADE33A1CCE75F1A0B", hash_generated_method = "A3355BF6396FF262131FD6D29F40928A")
    public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
        {
            boolean varCE11BC275FFF6C79CD0949C3947FA397_1777034693 = (isHorizontalScrollBarEnabled() != horizontalScrollBarEnabled);
            {
                mViewFlags ^= SCROLLBARS_HORIZONTAL;
                computeOpaqueFlags();
                resolvePadding();
            } 
        } 
        addTaint(horizontalScrollBarEnabled);
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.712 -0400", hash_original_method = "0838EB3187C4C037AF0DBFBDE06C59DB", hash_generated_method = "2034B2F4B0EDC3498E7BE8FB068EE21E")
    public boolean isVerticalScrollBarEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552599141 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552599141;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.712 -0400", hash_original_method = "B0D859209D4F0DED05F4B405F254CC50", hash_generated_method = "81D8FB6436DD479B3E9D5CF9F867D8D5")
    public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
        {
            boolean varA8AB3C7A9451600FFE608568BE46B787_843649840 = (isVerticalScrollBarEnabled() != verticalScrollBarEnabled);
            {
                mViewFlags ^= SCROLLBARS_VERTICAL;
                computeOpaqueFlags();
                resolvePadding();
            } 
        } 
        addTaint(verticalScrollBarEnabled);
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.713 -0400", hash_original_method = "DC71A98728014C366336C5BC467178FD", hash_generated_method = "796EA4F4D2AC58DE61356F54ACDA4918")
    protected void recomputePadding() {
        setPadding(mUserPaddingLeft, mPaddingTop, mUserPaddingRight, mUserPaddingBottom);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.714 -0400", hash_original_method = "2388F31C9368DE1EC14347F689733603", hash_generated_method = "924104A26DB1FDA3874EEE965AF0C048")
    public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
        initScrollCache();
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        scrollabilityCache.fadeScrollBars = fadeScrollbars;
        {
            scrollabilityCache.state = ScrollabilityCache.OFF;
        } 
        {
            scrollabilityCache.state = ScrollabilityCache.ON;
        } 
        addTaint(fadeScrollbars);
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.715 -0400", hash_original_method = "95A2058DEEA36EE0618643627EDFFE13", hash_generated_method = "E06C09C2B4FF0D8E23B730E5530B80B0")
    public boolean isScrollbarFadingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_968696803 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_968696803;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.715 -0400", hash_original_method = "A645B31717E594F6C2DC0D0454AA457D", hash_generated_method = "D359C933AC2B4F10167F3A26D67F3B86")
    public void setScrollBarStyle(int style) {
        {
            mViewFlags = (mViewFlags & ~SCROLLBARS_STYLE_MASK) | (style & SCROLLBARS_STYLE_MASK);
            computeOpaqueFlags();
            resolvePadding();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.716 -0400", hash_original_method = "05D4731F6FA79F6CC5101E8AAB13BDF7", hash_generated_method = "5C8157D2CD1052E47FB52BB4BB3647B0")
    @ViewDebug.ExportedProperty(mapping = {
            @ViewDebug.IntToString(from = SCROLLBARS_INSIDE_OVERLAY, to = "INSIDE_OVERLAY"),
            @ViewDebug.IntToString(from = SCROLLBARS_INSIDE_INSET, to = "INSIDE_INSET"),
            @ViewDebug.IntToString(from = SCROLLBARS_OUTSIDE_OVERLAY, to = "OUTSIDE_OVERLAY"),
            @ViewDebug.IntToString(from = SCROLLBARS_OUTSIDE_INSET, to = "OUTSIDE_INSET")
    })
    public int getScrollBarStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798543267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798543267;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.717 -0400", hash_original_method = "70416A9E9D98F77424E9346E007FCC75", hash_generated_method = "8F4677B7C7E40CC13C2B46126C7342D9")
    protected int computeHorizontalScrollRange() {
        int varF667BBC2F2CB62FFC46148012DBF7327_1148648037 = (getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580715727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580715727;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.718 -0400", hash_original_method = "1DA5A8790403B0D1F6BBC5796ED90152", hash_generated_method = "17BD21FEC92C3B171D6C1E5AFABBA2CD")
    protected int computeHorizontalScrollOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060512107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060512107;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.718 -0400", hash_original_method = "4D7C9CACEB957F5429D7FE01BD0E831F", hash_generated_method = "13A2E7DF1CC5BE82D90E3D3D8D59A292")
    protected int computeHorizontalScrollExtent() {
        int varF667BBC2F2CB62FFC46148012DBF7327_657807356 = (getWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472945267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472945267;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.719 -0400", hash_original_method = "BA8A199276036F5D8FAFD83598D6B62F", hash_generated_method = "F52A94B49979961008E9EA44DBACE050")
    protected int computeVerticalScrollRange() {
        int var9D46C65F317DA6DFB2EFABEBB82BEC5F_2136510263 = (getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640912921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_640912921;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.719 -0400", hash_original_method = "CE20178D0022D78BDA31343037F660C9", hash_generated_method = "C9222AF2488D57099985CDB32AC5D6F6")
    protected int computeVerticalScrollOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970458743 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_970458743;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.720 -0400", hash_original_method = "3058943AF0E0D63E8ED42ACDC59A7606", hash_generated_method = "1A9C83D464F647E2657D9337F6FB0975")
    protected int computeVerticalScrollExtent() {
        int var9D46C65F317DA6DFB2EFABEBB82BEC5F_497439467 = (getHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042515450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042515450;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.720 -0400", hash_original_method = "F18C2F0ACE32F9BDC531C26946C884DB", hash_generated_method = "A8CD290E4C817550528F13741EC66675")
    public boolean canScrollHorizontally(int direction) {
        final int offset = computeHorizontalScrollOffset();
        final int range = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1369932146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1369932146;
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.721 -0400", hash_original_method = "222CDEC9A5062ECAF96BF1766D04B3AA", hash_generated_method = "52BD7B2734AC34AAD71440CAE4CC72C7")
    public boolean canScrollVertically(int direction) {
        final int offset = computeVerticalScrollOffset();
        final int range = computeVerticalScrollRange() - computeVerticalScrollExtent();
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206318799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206318799;
        
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.723 -0400", hash_original_method = "BC6A073022E6E75A0ACBB97281459E6B", hash_generated_method = "87917F130E9CB7C9C8B68C885B05BBDE")
    protected final void onDrawScrollBars(Canvas canvas) {
        
        final ScrollabilityCache cache = mScrollCache;
        {
            int state = cache.state;
            boolean invalidate = false;
            {
                {
                    cache.interpolatorValues = new float[1];
                } 
                float[] values = cache.interpolatorValues;
                {
                    boolean var34F9F3B00BE1502DFF6FE96B14D049B7_1171361423 = (cache.scrollBarInterpolator.timeToValues(values) ==
                        Interpolator.Result.FREEZE_END);
                    {
                        cache.state = ScrollabilityCache.OFF;
                    } 
                    {
                        cache.scrollBar.setAlpha(Math.round(values[0]));
                    } 
                } 
                invalidate = true;
            } 
            {
                cache.scrollBar.setAlpha(255);
            } 
            final int viewFlags = mViewFlags;
            final boolean drawHorizontalScrollBar = (viewFlags & SCROLLBARS_HORIZONTAL) == SCROLLBARS_HORIZONTAL;
            final boolean drawVerticalScrollBar = (viewFlags & SCROLLBARS_VERTICAL) == SCROLLBARS_VERTICAL
                && !isVerticalScrollBarHidden();
            {
                final int width = mRight - mLeft;
                final int height = mBottom - mTop;
                final ScrollBarDrawable scrollBar = cache.scrollBar;
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                int inside;
                inside = ~0;
                inside = 0;
                int left;
                int top;
                int right;
                int bottom;
                {
                    int size = scrollBar.getSize(false);
                    {
                        size = cache.scrollBarSize;
                    } 
                    scrollBar.setParameters(computeHorizontalScrollRange(),
                                            computeHorizontalScrollOffset(),
                                            computeHorizontalScrollExtent(), false);
                    int verticalScrollBarGap;
                    verticalScrollBarGap = getVerticalScrollbarWidth();
                    verticalScrollBarGap = 0;
                    top = scrollY + height - size - (mUserPaddingBottom & inside);
                    left = scrollX + (mPaddingLeft & inside);
                    right = scrollX + width - (mUserPaddingRight & inside) - verticalScrollBarGap;
                    bottom = top + size;
                    onDrawHorizontalScrollBar(canvas, scrollBar, left, top, right, bottom);
                    {
                        invalidate(left, top, right, bottom);
                    } 
                } 
                {
                    int size = scrollBar.getSize(true);
                    {
                        size = cache.scrollBarSize;
                    } 
                    scrollBar.setParameters(computeVerticalScrollRange(),
                                            computeVerticalScrollOffset(),
                                            computeVerticalScrollExtent(), true);
                    
                    left = scrollX + width - size - (mUserPaddingRight & inside);
                    
                    
                    left = scrollX + (mUserPaddingLeft & inside);
                    
                    top = scrollY + (mPaddingTop & inside);
                    right = left + size;
                    bottom = scrollY + height - (mUserPaddingBottom & inside);
                    onDrawVerticalScrollBar(canvas, scrollBar, left, top, right, bottom);
                    {
                        invalidate(left, top, right, bottom);
                    } 
                } 
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.723 -0400", hash_original_method = "27496C077301642151620030AE06D353", hash_generated_method = "DFB745779B25FE51816FF05661AB30D4")
    protected boolean isVerticalScrollBarHidden() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_151744999 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_151744999;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.724 -0400", hash_original_method = "2196C3E195A3664813647CA1F4571C34", hash_generated_method = "07E1C0FFD1A8985E1AF22CBEA90959AD")
    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
        
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(scrollBar.getTaint());
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.724 -0400", hash_original_method = "4DC59479DF5AED0094F453B5C8C1A8B1", hash_generated_method = "F0D29B608DF77C2213FE35532E3D924D")
    protected void onDrawVerticalScrollBar(Canvas canvas, Drawable scrollBar,
            int l, int t, int r, int b) {
        
        scrollBar.setBounds(l, t, r, b);
        scrollBar.draw(canvas);
        addTaint(canvas.getTaint());
        addTaint(scrollBar.getTaint());
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.725 -0400", hash_original_method = "88C9EEC1EB66ECE8EDFB3E744FAAD32C", hash_generated_method = "8DE2AC8CD08D4DCB5B0CCD9E40E1637E")
    protected void onDraw(Canvas canvas) {
        
        addTaint(canvas.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.725 -0400", hash_original_method = "B5B7B4C6E477A3DDB1740C53E1D10BEA", hash_generated_method = "EF16987149809AEC71C11FD659B0A8FD")
     void assignParent(ViewParent parent) {
        {
            mParent = parent;
        } 
        {
            mParent = null;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("view " + this + " being added, but"
                    + " it already has a parent");
        } 
        
        
            
        
            
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.725 -0400", hash_original_method = "6BE89DDC01776115240A35D213D194B1", hash_generated_method = "EC58119A15B64F6201CCDEADFE7DED79")
    protected void onAttachedToWindow() {
        
        {
            mParent.requestTransparentRegion(this);
        } 
        {
            initialAwakenScrollBars();
            mPrivateFlags &= ~AWAKEN_SCROLL_BARS_ON_ATTACH;
        } 
        jumpDrawablesToCurrentState();
        resolveLayoutDirectionIfNeeded();
        resolvePadding();
        resolveTextDirection();
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_2074270457 = (isFocused());
            {
                InputMethodManager imm = InputMethodManager.peekInstance();
                imm.focusIn(this);
            } 
        } 
        
        
            
        
        
            
            
        
        
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.726 -0400", hash_original_method = "6355C1E1C593C70CD9AB72CB2C730A4B", hash_generated_method = "1149543E773EFFB347C559E2845FB425")
    private void resolveLayoutDirectionIfNeeded() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED_RTL;
        resetResolvedTextDirection();
        {
            Object varEB32B57BDD0405313F1A009DC7D6D94F_1210986867 = (getLayoutDirection());
            
            {
                ViewGroup viewGroup = ((ViewGroup) mParent);
                {
                    boolean varD7173ED74EF8FD4D8C167811281857D6_684168212 = (! viewGroup.canResolveLayoutDirection());
                } 
                {
                    boolean var8E862BF7D39882400271E2867FE65A16_1012595931 = (viewGroup.getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
                    {
                        mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
                    } 
                } 
            } 
            
            
            mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
            
            
            {
                boolean var9876FCC9113762996D6F4DE738D751FA_237813750 = (isLayoutDirectionRtl(Locale.getDefault()));
                {
                    mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED_RTL;
                } 
            } 
            
        } 
        mPrivateFlags2 |= LAYOUT_DIRECTION_RESOLVED;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.727 -0400", hash_original_method = "9FC12AEA6DFF38CE52A88C8E970B863F", hash_generated_method = "AC8AB4C241DCF3F2B9D057B511B95DA2")
    protected void resolvePadding() {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_962071384 = (getResolvedLayoutDirection());
            
            {
                mUserPaddingRight = mUserPaddingStart;
            } 
            {
                mUserPaddingRight = mPaddingRight;
            } 
            
            
            {
                mUserPaddingLeft = mUserPaddingEnd;
            } 
            {
                mUserPaddingLeft = mPaddingLeft;
            } 
            
            
            {
                mUserPaddingLeft = mUserPaddingStart;
            } 
            {
                mUserPaddingLeft = mPaddingLeft;
            } 
            
            
            {
                mUserPaddingRight = mUserPaddingEnd;
            } 
            {
                mUserPaddingRight = mPaddingRight;
            } 
            
        } 
        mUserPaddingBottom = (mUserPaddingBottom >= 0) ? mUserPaddingBottom : mPaddingBottom;
        recomputePadding();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.728 -0400", hash_original_method = "2870C28D9742C58342A5849284011E72", hash_generated_method = "4817A712C76A2ED6EF43EA06643D416F")
    protected boolean canResolveLayoutDirection() {
        {
            Object varEB32B57BDD0405313F1A009DC7D6D94F_885861441 = (getLayoutDirection());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1491254190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1491254190;
        
        
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.728 -0400", hash_original_method = "A8A20BDA6F309AE6FE3C70FD4EB76C3B", hash_generated_method = "146E092F23602F5144B45F38ADE2CB14")
    protected void resetResolvedLayoutDirection() {
        mPrivateFlags2 &= ~LAYOUT_DIRECTION_RESOLVED;
        
        
    }

    
        protected static boolean isLayoutDirectionRtl(Locale locale) {
        return (LocaleUtil.TEXT_LAYOUT_DIRECTION_RTL_DO_NOT_USE ==
                LocaleUtil.getLayoutDirectionFromLocale(locale));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.730 -0400", hash_original_method = "C1067653123E460806048F14F4245D8D", hash_generated_method = "82C2297B1CF23C48EAF943AEB85EF44C")
    protected void onDetachedFromWindow() {
        
        mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        removeUnsetPressCallback();
        removeLongPressCallback();
        removePerformClickCallback();
        removeSendViewScrolledAccessibilityEventCallback();
        destroyDrawingCache();
        destroyLayer();
        {
            mDisplayList.invalidate();
        } 
        {
            mAttachInfo.mHandler.removeMessages(AttachInfo.INVALIDATE_MSG, this);
        } 
        mCurrentAnimation = null;
        resetResolvedLayoutDirection();
        resetResolvedTextDirection();
        
        
        
        
        
        
        
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.730 -0400", hash_original_method = "96241ADC2AE65F6434F9D187AAD690E3", hash_generated_method = "4D0A8CAA0C95AA296CB473222B6CFA3C")
    protected int getWindowAttachCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524653604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524653604;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.731 -0400", hash_original_method = "B5E940E178CF821C1ABFCBA8A2963390", hash_generated_method = "832D3C7DB151FF4B13787634A1692BDF")
    public IBinder getWindowToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1880693498 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1880693498 = mAttachInfo != null ? mAttachInfo.mWindowToken : null;
        varB4EAC82CA7396A68D541C85D26508E83_1880693498.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1880693498;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.731 -0400", hash_original_method = "2166F0BF16D53373B488A496114897F8", hash_generated_method = "1BFB292A3980C6A02B063103DB8458C2")
    public IBinder getApplicationWindowToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1306032545 = null; 
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1639004059 = null; 
        AttachInfo ai = mAttachInfo;
        {
            IBinder appWindowToken = ai.mPanelParentWindowToken;
            {
                appWindowToken = ai.mWindowToken;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1306032545 = appWindowToken;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1639004059 = null;
        IBinder varA7E53CE21691AB073D9660D615818899_541687267; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_541687267 = varB4EAC82CA7396A68D541C85D26508E83_1306032545;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_541687267 = varB4EAC82CA7396A68D541C85D26508E83_1639004059;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_541687267.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_541687267;
        
        
        
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.732 -0400", hash_original_method = "502E0CC6497F900AADF2990690A51539", hash_generated_method = "FFAC1057BB7ACDC9EAED62075FCD4FED")
     IWindowSession getWindowSession() {
        IWindowSession varB4EAC82CA7396A68D541C85D26508E83_1673179417 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1673179417 = mAttachInfo != null ? mAttachInfo.mSession : null;
        varB4EAC82CA7396A68D541C85D26508E83_1673179417.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1673179417;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.765 -0400", hash_original_method = "8BF487FADEB8B54B52A076F5E8F3B4CC", hash_generated_method = "58387A4133F622A154191407F61BF45E")
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        mAttachInfo = info;
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        {
            info.mTreeObserver.merge(mFloatingTreeObserver);
            mFloatingTreeObserver = null;
        } 
        {
            mAttachInfo.mScrollContainers.add(this);
            mPrivateFlags |= SCROLL_CONTAINER_ADDED;
        } 
        performCollectViewAttributes(visibility);
        onAttachedToWindow();
        ListenerInfo li = mListenerInfo;
        CopyOnWriteArrayList<OnAttachStateChangeListener> listeners;
        listeners = li.mOnAttachStateChangeListeners;
        listeners = null;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_753354905 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnAttachStateChangeListener> varE0997CFEC81DEDF84B9808E9E6718DCA_164018872 = (listeners).iterator();
                    varE0997CFEC81DEDF84B9808E9E6718DCA_164018872.hasNext();
                    OnAttachStateChangeListener listener = varE0997CFEC81DEDF84B9808E9E6718DCA_164018872.next();
                    {
                        listener.onViewAttachedToWindow(this);
                    } 
                } 
            } 
        } 
        int vis = info.mWindowVisibility;
        {
            onWindowVisibilityChanged(vis);
        } 
        {
            refreshDrawableState();
        } 
        addTaint(visibility);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.791 -0400", hash_original_method = "6B0EA8A7D63E280C74DFE6EC34A7421B", hash_generated_method = "5B3DFCE6A9FAFF712F5CF32DA55ECC1B")
     void dispatchDetachedFromWindow() {
        AttachInfo info = mAttachInfo;
        {
            int vis = info.mWindowVisibility;
            {
                onWindowVisibilityChanged(GONE);
            } 
        } 
        onDetachedFromWindow();
        ListenerInfo li = mListenerInfo;
        CopyOnWriteArrayList<OnAttachStateChangeListener> listeners;
        listeners = li.mOnAttachStateChangeListeners;
        listeners = null;
        {
            boolean varB49AD54BBDCF0D9B63D70B14581FDB17_493995359 = (listeners != null && listeners.size() > 0);
            {
                {
                    Iterator<OnAttachStateChangeListener> varE0997CFEC81DEDF84B9808E9E6718DCA_898981580 = (listeners).iterator();
                    varE0997CFEC81DEDF84B9808E9E6718DCA_898981580.hasNext();
                    OnAttachStateChangeListener listener = varE0997CFEC81DEDF84B9808E9E6718DCA_898981580.next();
                    {
                        listener.onViewDetachedFromWindow(this);
                    } 
                } 
            } 
        } 
        {
            mAttachInfo.mScrollContainers.remove(this);
            mPrivateFlags &= ~SCROLL_CONTAINER_ADDED;
        } 
        mAttachInfo = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.792 -0400", hash_original_method = "DE35B85EA98822B631F87F0518C5E70D", hash_generated_method = "25DF76D1DD427F646D947B9E90F83B45")
    public void saveHierarchyState(SparseArray<Parcelable> container) {
        dispatchSaveInstanceState(container);
        addTaint(container.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.792 -0400", hash_original_method = "946C013753556BBC605C0B72B86403CC", hash_generated_method = "9E2FD71AC767C70D6446DF5BDB5CA0B1")
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        {
            mPrivateFlags &= ~SAVE_STATE_CALLED;
            Parcelable state = onSaveInstanceState();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Derived class did not call super.onSaveInstanceState()");
            } 
            {
                container.put(mID, state);
            } 
        } 
        addTaint(container.getTaint());
        
        
            
            
            
                
                        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.793 -0400", hash_original_method = "071A0CD98D5CB5717BF4FD06D9363A03", hash_generated_method = "09D4021B1C891B6284824760631969A8")
    protected Parcelable onSaveInstanceState() {
        
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_2104524841 = null; 
        mPrivateFlags |= SAVE_STATE_CALLED;
        varB4EAC82CA7396A68D541C85D26508E83_2104524841 = BaseSavedState.EMPTY_STATE;
        varB4EAC82CA7396A68D541C85D26508E83_2104524841.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2104524841;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.794 -0400", hash_original_method = "6EAC0E9F5E844401043B6CA1D363D57E", hash_generated_method = "ED418AE0D0CD450335FE01A6AD720B3D")
    public void restoreHierarchyState(SparseArray<Parcelable> container) {
        dispatchRestoreInstanceState(container);
        addTaint(container.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.795 -0400", hash_original_method = "1E9589C1E01E87FD9C38DCF9C7B7C90F", hash_generated_method = "C1E7ECE6628D44F8CF10411D212607CA")
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        {
            Parcelable state = container.get(mID);
            {
                mPrivateFlags &= ~SAVE_STATE_CALLED;
                onRestoreInstanceState(state);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "Derived class did not call super.onRestoreInstanceState()");
                } 
            } 
        } 
        addTaint(container.getTaint());
        
        
            
            
                
                
                
                    
                            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.796 -0400", hash_original_method = "CCFCBEB3529A8F3F9E941DB1236D802B", hash_generated_method = "E15824D701CB7571D33BBB1CE5800874")
    protected void onRestoreInstanceState(Parcelable state) {
        
        mPrivateFlags |= SAVE_STATE_CALLED;
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Wrong state class, expecting View State but "
                    + "received " + state.getClass().toString() + " instead. This usually happens "
                    + "when two views of different type have the same id in the same hierarchy. "
                    + "This view's id is " + ViewDebug.resolveId(mContext, getId()) + ". Make sure "
                    + "other views do not use the same id.");
        } 
        addTaint(state.getTaint());
        
        
        
            
                    
                    
                    
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.796 -0400", hash_original_method = "120BB71A812D687D5EF2F0B8F5C8CCD2", hash_generated_method = "259108E10D2D9893F6B733F79849093C")
    public long getDrawingTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1454337144 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1454337144;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.797 -0400", hash_original_method = "CAE567A7C394D0DF999555076FD0D1ED", hash_generated_method = "4FA1EC564E386560E2AA3D0205DA225B")
    public void setDuplicateParentStateEnabled(boolean enabled) {
        setFlags(enabled ? DUPLICATE_PARENT_STATE : 0, DUPLICATE_PARENT_STATE);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.798 -0400", hash_original_method = "AF26528701A515059D58013186164554", hash_generated_method = "6F04F515A44E232A07824B309AAD4258")
    public boolean isDuplicateParentStateEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101899266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101899266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.799 -0400", hash_original_method = "280CFBA803CA9107455CB03D3F8C277D", hash_generated_method = "4561779ADEAC90033E5DD7D7384241A2")
    public void setLayerType(int layerType, Paint paint) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Layer type can only be one of: LAYER_TYPE_NONE, "
                    + "LAYER_TYPE_SOFTWARE or LAYER_TYPE_HARDWARE");
        } 
        {
            {
                mLayerPaint = paint == null ? new Paint() : paint;
                invalidateParentCaches();
                invalidate(true);
            } 
        } 
        
        destroyLayer();
        
        
        destroyDrawingCache();
        
        mLayerType = layerType;
        final boolean layerDisabled = mLayerType == LAYER_TYPE_NONE;
        mLayerPaint = layerDisabled ? null : (paint == null ? new Paint() : paint);
        mLocalDirtyRect = layerDisabled ? null : new Rect();
        invalidateParentCaches();
        invalidate(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.800 -0400", hash_original_method = "E009407DF0C30C68D152BB83BB3493E0", hash_generated_method = "72788001C31A78A88B0ABE916573F20B")
     boolean hasStaticLayer() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_792565190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_792565190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.801 -0400", hash_original_method = "10BDECB6A9FC24A5B9656AF2BA9D9819", hash_generated_method = "990D08D24EB85459557E96E1FBC32B70")
    public int getLayerType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265352125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265352125;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.802 -0400", hash_original_method = "FDD83A77B112AC8CB3AC65707C3CB088", hash_generated_method = "A2EC8AF33CC9454B749370BA14132AA2")
    public void buildLayer() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("This view must be attached to a window first");
        } 
        
        {
            boolean var938BC3BB177101C2D5D80B665B48EFE4_1371899175 = (mAttachInfo.mHardwareRenderer != null &&
                        mAttachInfo.mHardwareRenderer.isEnabled() &&
                        mAttachInfo.mHardwareRenderer.validate());
            {
                getHardwareLayer();
            } 
        } 
        
        
        buildDrawingCache(true);
        
        
        
        
            
        
        
            
                
                        
                        
                    
                
                
            
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.804 -0400", hash_original_method = "1C756BC3105DE982313252676EF7BEA5", hash_generated_method = "EFF7EA73FD9950CF82547860142E5404")
     HardwareLayer getHardwareLayer() {
        HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_781679372 = null; 
        HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_602467395 = null; 
        HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_1278372519 = null; 
        HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_976405099 = null; 
        HardwareLayer varB4EAC82CA7396A68D541C85D26508E83_2039618499 = null; 
        {
            boolean var1795335A66B1FC7BB4C3B32BDFD3180D_2047661265 = (mAttachInfo == null || mAttachInfo.mHardwareRenderer == null ||
                !mAttachInfo.mHardwareRenderer.isEnabled());
            {
                varB4EAC82CA7396A68D541C85D26508E83_781679372 = null;
            } 
        } 
        final int width = mRight - mLeft;
        final int height = mBottom - mTop;
        {
            varB4EAC82CA7396A68D541C85D26508E83_602467395 = null;
        } 
        {
            {
                mHardwareLayer = mAttachInfo.mHardwareRenderer.createHardwareLayer(
                        width, height, isOpaque());
                mLocalDirtyRect.setEmpty();
            } 
            {
                boolean var5013B1CC39A5DD383313D5E39F51669C_1477977084 = (mHardwareLayer.getWidth() != width || mHardwareLayer.getHeight() != height);
                {
                    mHardwareLayer.resize(width, height);
                    mLocalDirtyRect.setEmpty();
                } 
            } 
            {
                boolean var08F8E6CAF5391532E58CACD43013438A_31721067 = (!mHardwareLayer.isValid());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1278372519 = null;
                } 
            } 
            HardwareCanvas currentCanvas = mAttachInfo.mHardwareCanvas;
            final HardwareCanvas canvas = mHardwareLayer.start(currentCanvas);
            {
                mHardwareLayer.end(currentCanvas);
                varB4EAC82CA7396A68D541C85D26508E83_976405099 = null;
            } 
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
                {
                    mPrivateFlags &= ~DIRTY_MASK;
                    dispatchDraw(canvas);
                } 
                {
                    draw(canvas);
                } 
                canvas.restoreToCount(restoreCount);
            } 
            finally 
            {
                canvas.onPostDraw();
                mHardwareLayer.end(currentCanvas);
                mAttachInfo.mHardwareCanvas = currentCanvas;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2039618499 = mHardwareLayer;
        HardwareLayer varA7E53CE21691AB073D9660D615818899_1800321160; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1800321160 = varB4EAC82CA7396A68D541C85D26508E83_781679372;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1800321160 = varB4EAC82CA7396A68D541C85D26508E83_602467395;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1800321160 = varB4EAC82CA7396A68D541C85D26508E83_1278372519;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1800321160 = varB4EAC82CA7396A68D541C85D26508E83_976405099;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1800321160 = varB4EAC82CA7396A68D541C85D26508E83_2039618499;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1800321160.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1800321160;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.805 -0400", hash_original_method = "46CD3F4D955A0CC35E16981FB59107BF", hash_generated_method = "4CAEC9906BA0D5A74F420EBCEAEC539A")
     boolean destroyLayer() {
        {
            mHardwareLayer.destroy();
            mHardwareLayer = null;
            invalidate(true);
            invalidateParentCaches();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798779334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798779334;
        
        
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.806 -0400", hash_original_method = "2A28B7876CAFDC07E0FAFA28070957E8", hash_generated_method = "40E2B8629BC48C8FF763F010A3364CFD")
    protected void destroyHardwareResources() {
        destroyLayer();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.806 -0400", hash_original_method = "8AD6975BC71E736FF7830468F6E8AB45", hash_generated_method = "7F7B67CF162864CE8896D60184B0CEEB")
    public void setDrawingCacheEnabled(boolean enabled) {
        mCachingFailed = false;
        setFlags(enabled ? DRAWING_CACHE_ENABLED : 0, DRAWING_CACHE_ENABLED);
        addTaint(enabled);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.807 -0400", hash_original_method = "B123D3E623B7638C240DD8280788F70C", hash_generated_method = "AB8CEEBBC42D05D8195D9DD4D7EF7612")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isDrawingCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099399671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099399671;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.808 -0400", hash_original_method = "ED3E6074026E0275E7BADCEAD02A1919", hash_generated_method = "CE497152A4A14EB98A449402F72D2648")
    @SuppressWarnings({"UnusedDeclaration"})
    public void outputDirtyFlags(String indent, boolean clear, int clearMask) {
        Log.d("View", indent + this + "             DIRTY(" + (mPrivateFlags & View.DIRTY_MASK) +
                ") DRAWN(" + (mPrivateFlags & DRAWN) + ")" + " CACHE_VALID(" +
                (mPrivateFlags & View.DRAWING_CACHE_VALID) +
                ") INVALIDATED(" + (mPrivateFlags & INVALIDATED) + ")");
        {
            mPrivateFlags &= clearMask;
        } 
        {
            ViewGroup parent = (ViewGroup) this;
            final int count = parent.getChildCount();
            {
                int i = 0;
                {
                    final View child = parent.getChildAt(i);
                    child.outputDirtyFlags(indent + "  ", clear, clearMask);
                } 
            } 
        } 
        addTaint(indent.getTaint());
        addTaint(clear);
        
        
                
                
                
        
            
        
        
            
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.809 -0400", hash_original_method = "F520ED30BD4141F0E67AE80815EDDC89", hash_generated_method = "7D5447D36AD4507DE6BB8070E0DEAF7B")
    protected void dispatchGetDisplayList() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.810 -0400", hash_original_method = "AB7D77CF9F94D5BD05F1DB3F0B62C9D0", hash_generated_method = "F25D03128B3768B3FEF8DE76A940D4BF")
    public boolean canHaveDisplayList() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526070569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526070569;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.813 -0400", hash_original_method = "A79479675DF460DA0EF507C879CE4B27", hash_generated_method = "411CCE6E9F3F8B57106C88E864B65FB7")
    public DisplayList getDisplayList() {
        DisplayList varB4EAC82CA7396A68D541C85D26508E83_595399744 = null; 
        DisplayList varB4EAC82CA7396A68D541C85D26508E83_1599304422 = null; 
        DisplayList varB4EAC82CA7396A68D541C85D26508E83_604981811 = null; 
        {
            boolean var1B563759F0FD29B833433E2C0DB5143B_308122536 = (!canHaveDisplayList());
            {
                varB4EAC82CA7396A68D541C85D26508E83_595399744 = null;
            } 
        } 
        {
            boolean varCB7B81962DE3C7E60B368CFD3080CE5F_1155437664 = (((mPrivateFlags & DRAWING_CACHE_VALID) == 0 ||
                mDisplayList == null || !mDisplayList.isValid() ||
                mRecreateDisplayList));
            {
                {
                    boolean var7C6A47F38E12A6EB14BB2C741855538D_784558169 = (mDisplayList != null && mDisplayList.isValid() &&
                    !mRecreateDisplayList);
                    {
                        mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                        mPrivateFlags &= ~DIRTY_MASK;
                        dispatchGetDisplayList();
                        varB4EAC82CA7396A68D541C85D26508E83_1599304422 = mDisplayList;
                    } 
                } 
                mRecreateDisplayList = true;
                {
                    mDisplayList = mAttachInfo.mHardwareRenderer.createDisplayList();
                    invalidateParentCaches();
                } 
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
                    {
                        dispatchDraw(canvas);
                    } 
                    {
                        draw(canvas);
                    } 
                } 
                finally 
                {
                    canvas.restoreToCount(restoreCount);
                    canvas.onPostDraw();
                    mDisplayList.end();
                } 
            } 
            {
                mPrivateFlags |= DRAWN | DRAWING_CACHE_VALID;
                mPrivateFlags &= ~DIRTY_MASK;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_604981811 = mDisplayList;
        DisplayList varA7E53CE21691AB073D9660D615818899_1966683912; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1966683912 = varB4EAC82CA7396A68D541C85D26508E83_595399744;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1966683912 = varB4EAC82CA7396A68D541C85D26508E83_1599304422;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1966683912 = varB4EAC82CA7396A68D541C85D26508E83_604981811;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1966683912.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1966683912;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.814 -0400", hash_original_method = "16C485E3429312C7E841D79823374233", hash_generated_method = "92B3D63F4D871F538AEF5E3AB359916B")
    public Bitmap getDrawingCache() {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_817279241 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_817279241 = getDrawingCache(false);
        varB4EAC82CA7396A68D541C85D26508E83_817279241.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_817279241;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.815 -0400", hash_original_method = "CA92F18E14EB0519BF84A3C226CE3F4A", hash_generated_method = "3D06C1113056B985DFA4610A78F846CD")
    public Bitmap getDrawingCache(boolean autoScale) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1710361994 = null; 
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_597739886 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1710361994 = null;
        } 
        {
            buildDrawingCache(autoScale);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_597739886 = autoScale ? mDrawingCache : mUnscaledDrawingCache;
        addTaint(autoScale);
        Bitmap varA7E53CE21691AB073D9660D615818899_1771895623; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1771895623 = varB4EAC82CA7396A68D541C85D26508E83_1710361994;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1771895623 = varB4EAC82CA7396A68D541C85D26508E83_597739886;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1771895623.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1771895623;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.816 -0400", hash_original_method = "0E5E783B90E69DDC86CBB5AF4D60343F", hash_generated_method = "C9706D70B692B74D47204D29B73FA2A9")
    public void destroyDrawingCache() {
        {
            mDrawingCache.recycle();
            mDrawingCache = null;
        } 
        {
            mUnscaledDrawingCache.recycle();
            mUnscaledDrawingCache = null;
        } 
        
        
            
            
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.816 -0400", hash_original_method = "2126772517D4D51A0CCD7D5847A54B89", hash_generated_method = "6AB9CA1F59D97FF52C15A4630A0A9C3E")
    public void setDrawingCacheBackgroundColor(int color) {
        {
            mDrawingCacheBackgroundColor = color;
            mPrivateFlags &= ~DRAWING_CACHE_VALID;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.817 -0400", hash_original_method = "4BEC5ECE79612E1091BBCBD880B92D6A", hash_generated_method = "88548F42D4294A722C87C511D71E53A7")
    public int getDrawingCacheBackgroundColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591075502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_591075502;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.817 -0400", hash_original_method = "8A1B171D557613DB7E4B9E775A2E64AA", hash_generated_method = "7863622F5BA5FABAB7E5B62D4108044D")
    public void buildDrawingCache() {
        buildDrawingCache(false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.819 -0400", hash_original_method = "8AFFFACECE9FE8C2DF57758245D0721D", hash_generated_method = "B8C495DB4DD7B55B34C806173D0BAAAE")
    public void buildDrawingCache(boolean autoScale) {
        {
            mCachingFailed = false;
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.BUILD_CACHE);
            } 
            int width = mRight - mLeft;
            int height = mBottom - mTop;
            final AttachInfo attachInfo = mAttachInfo;
            final boolean scalingRequired = attachInfo != null && attachInfo.mScalingRequired;
            {
                width = (int) ((width * attachInfo.mApplicationScale) + 0.5f);
                height = (int) ((height * attachInfo.mApplicationScale) + 0.5f);
            } 
            final int drawingCacheBackgroundColor = mDrawingCacheBackgroundColor;
            final boolean opaque = drawingCacheBackgroundColor != 0 || isOpaque();
            final boolean use32BitCache = attachInfo != null && attachInfo.mUse32BitDrawingCache;
            {
                boolean var555C1BA5A9771D8E1776E57A9469E7A6_1684448360 = (width <= 0 || height <= 0 ||
                    (width * height * (opaque && !use32BitCache ? 2 : 4) >
                            ViewConfiguration.get(mContext).getScaledMaximumDrawingCacheSize())); 
                {
                    destroyDrawingCache();
                    mCachingFailed = true;
                } 
            } 
            boolean clear = true;
            Bitmap bitmap;
            bitmap = mDrawingCache;
            bitmap = mUnscaledDrawingCache;
            {
                boolean var112855DB511D640A3CBF7592003CEA59_328799470 = (bitmap == null || bitmap.getWidth() != width || bitmap.getHeight() != height);
                {
                    Bitmap.Config quality;
                    {
                        
                        quality = Bitmap.Config.ARGB_8888;
                        
                        
                        quality = Bitmap.Config.ARGB_8888;
                        
                        
                        quality = Bitmap.Config.ARGB_8888;
                        
                        
                        quality = Bitmap.Config.ARGB_8888;
                        
                    } 
                    {
                        quality = use32BitCache ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
                    } 
                    bitmap.recycle();
                    try 
                    {
                        bitmap = Bitmap.createBitmap(width, height, quality);
                        bitmap.setDensity(getResources().getDisplayMetrics().densityDpi);
                        {
                            mDrawingCache = bitmap;
                        } 
                        {
                            mUnscaledDrawingCache = bitmap;
                        } 
                        bitmap.setHasAlpha(false);
                    } 
                    catch (OutOfMemoryError e)
                    {
                        {
                            mDrawingCache = null;
                        } 
                        {
                            mUnscaledDrawingCache = null;
                        } 
                        mCachingFailed = true;
                    } 
                    clear = drawingCacheBackgroundColor != 0;
                } 
            } 
            Canvas canvas;
            {
                canvas = attachInfo.mCanvas;
                {
                    canvas = new Canvas();
                } 
                canvas.setBitmap(bitmap);
                attachInfo.mCanvas = null;
            } 
            {
                canvas = new Canvas(bitmap);
            } 
            {
                bitmap.eraseColor(drawingCacheBackgroundColor);
            } 
            computeScroll();
            final int restoreCount = canvas.save();
            {
                final float scale = attachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } 
            canvas.translate(-mScrollX, -mScrollY);
            mPrivateFlags |= DRAWN;
            {
                mPrivateFlags |= DRAWING_CACHE_VALID;
            } 
            {
                {
                    ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                } 
                mPrivateFlags &= ~DIRTY_MASK;
                dispatchDraw(canvas);
            } 
            {
                draw(canvas);
            } 
            canvas.restoreToCount(restoreCount);
            canvas.setBitmap(null);
            {
                attachInfo.mCanvas = canvas;
            } 
        } 
        addTaint(autoScale);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.823 -0400", hash_original_method = "9EC32975405209F06A6AEBC988E2ADFA", hash_generated_method = "E1E591E2A7DFC80579171E5D961E907B")
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_2116503641 = null; 
        int width = mRight - mLeft;
        int height = mBottom - mTop;
        final AttachInfo attachInfo = mAttachInfo;
        float scale;
        scale = attachInfo.mApplicationScale;
        scale = 1.0f;
        width = (int) ((width * scale) + 0.5f);
        height = (int) ((height * scale) + 0.5f);
        Bitmap bitmap = Bitmap.createBitmap(width > 0 ? width : 1, height > 0 ? height : 1, quality);
        {
            if (DroidSafeAndroidRuntime.control) throw new OutOfMemoryError();
        } 
        Resources resources = getResources();
        {
            bitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        } 
        Canvas canvas;
        {
            canvas = attachInfo.mCanvas;
            {
                canvas = new Canvas();
            } 
            canvas.setBitmap(bitmap);
            attachInfo.mCanvas = null;
        } 
        {
            canvas = new Canvas(bitmap);
        } 
        {
            bitmap.eraseColor(backgroundColor);
        } 
        computeScroll();
        final int restoreCount = canvas.save();
        canvas.scale(scale, scale);
        canvas.translate(-mScrollX, -mScrollY);
        int flags = mPrivateFlags;
        mPrivateFlags &= ~DIRTY_MASK;
        {
            dispatchDraw(canvas);
        } 
        {
            draw(canvas);
        } 
        mPrivateFlags = flags;
        canvas.restoreToCount(restoreCount);
        canvas.setBitmap(null);
        {
            attachInfo.mCanvas = canvas;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2116503641 = bitmap;
        addTaint(quality.getTaint());
        addTaint(backgroundColor);
        addTaint(skipChildren);
        varB4EAC82CA7396A68D541C85D26508E83_2116503641.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2116503641;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.823 -0400", hash_original_method = "B880B01C07154F288A73209778F72869", hash_generated_method = "44B792F8EEACDE7AD69962D22C28E713")
    public boolean isInEditMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252315401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_252315401;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.824 -0400", hash_original_method = "FAE0811CBF87AAE1D612614CB5EBE838", hash_generated_method = "36979F4BC7D1C40982399D2AF17B2C03")
    protected boolean isPaddingOffsetRequired() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1275830000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1275830000;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.824 -0400", hash_original_method = "4C949B81A8DC7FEE598CF97986A5D947", hash_generated_method = "03C0B6D4ADDC7C07C09818F6C2896A70")
    protected int getLeftPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254104562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1254104562;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.825 -0400", hash_original_method = "074FFDE548FCC46FA1E9A30627AB8A7C", hash_generated_method = "61A4008FEF1E06B615CA2C872A2C4515")
    protected int getRightPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201468333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201468333;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.825 -0400", hash_original_method = "A9CEAAEF3075A726E0EAEBF5F9AFAFB2", hash_generated_method = "6BD7A2D815A07148978199419585ECE7")
    protected int getTopPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751816503 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751816503;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.826 -0400", hash_original_method = "8428DF91FD33A9244C31B60F9D34D200", hash_generated_method = "CA7D4D1001F3E5016075CC2C34896028")
    protected int getBottomPaddingOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74824540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_74824540;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.826 -0400", hash_original_method = "6D1FD6806CEFCA87F4934C6F8CB34AD2", hash_generated_method = "898299A5109DEBC75F3BEA2E0052A3EF")
    protected int getFadeTop(boolean offsetRequired) {
        int top = mPaddingTop;
        top += getTopPaddingOffset();
        addTaint(offsetRequired);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009257731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1009257731;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.827 -0400", hash_original_method = "9B6486C3AB53B66EA69662D43A443B3A", hash_generated_method = "D964F5F1BEAC46997FE2EDDF7E3C7D88")
    protected int getFadeHeight(boolean offsetRequired) {
        int padding = mPaddingTop;
        padding += getTopPaddingOffset();
        addTaint(offsetRequired);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525528142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525528142;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.827 -0400", hash_original_method = "E6CC46F2CB7AE1B25C3F8DA9B9857709", hash_generated_method = "2F8537530F36C33CC0108E0D29C1641F")
    public boolean isHardwareAccelerated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_966341977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_966341977;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.830 -0400", hash_original_method = "788C5C753E694A468D30095348832570", hash_generated_method = "C1B76A6EFC5EBE21E8D8FCC2834836D7")
    public void draw(Canvas canvas) {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
        } 
        final int privateFlags = mPrivateFlags;
        final boolean dirtyOpaque = (privateFlags & DIRTY_MASK) == DIRTY_OPAQUE &&
                (mAttachInfo == null || !mAttachInfo.mIgnoreDirtyState);
        mPrivateFlags = (privateFlags & ~DIRTY_MASK) | DRAWN;
        int saveCount;
        {
            final Drawable background = mBGDrawable;
            {
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                {
                    background.setBounds(0, 0,  mRight - mLeft, mBottom - mTop);
                    mBackgroundSizeChanged = false;
                } 
                {
                    background.draw(canvas);
                } 
                {
                    canvas.translate(scrollX, scrollY);
                    background.draw(canvas);
                    canvas.translate(-scrollX, -scrollY);
                } 
            } 
        } 
        final int viewFlags = mViewFlags;
        boolean horizontalEdges = (viewFlags & FADING_EDGE_HORIZONTAL) != 0;
        boolean verticalEdges = (viewFlags & FADING_EDGE_VERTICAL) != 0;
        {
            onDraw(canvas);
            dispatchDraw(canvas);
            onDrawScrollBars(canvas);
        } 
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
        {
            paddingLeft += getLeftPaddingOffset();
        } 
        int left = mScrollX + paddingLeft;
        int right = left + mRight - mLeft - mPaddingRight - paddingLeft;
        int top = mScrollY + getFadeTop(offsetRequired);
        int bottom = top + getFadeHeight(offsetRequired);
        {
            right += getRightPaddingOffset();
            bottom += getBottomPaddingOffset();
        } 
        final ScrollabilityCache scrollabilityCache = mScrollCache;
        final float fadeHeight = scrollabilityCache.fadingEdgeLength;
        int length = (int) fadeHeight;
        {
            length = (bottom - top) / 2;
        } 
        {
            length = (right - left) / 2;
        } 
        {
            topFadeStrength = Math.max(0.0f, Math.min(1.0f, getTopFadingEdgeStrength()));
            drawTop = topFadeStrength * fadeHeight > 1.0f;
            bottomFadeStrength = Math.max(0.0f, Math.min(1.0f, getBottomFadingEdgeStrength()));
            drawBottom = bottomFadeStrength * fadeHeight > 1.0f;
        } 
        {
            leftFadeStrength = Math.max(0.0f, Math.min(1.0f, getLeftFadingEdgeStrength()));
            drawLeft = leftFadeStrength * fadeHeight > 1.0f;
            rightFadeStrength = Math.max(0.0f, Math.min(1.0f, getRightFadingEdgeStrength()));
            drawRight = rightFadeStrength * fadeHeight > 1.0f;
        } 
        saveCount = canvas.getSaveCount();
        int solidColor = getSolidColor();
        {
            final int flags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
            {
                canvas.saveLayer(left, top, right, top + length, null, flags);
            } 
            {
                canvas.saveLayer(left, bottom - length, right, bottom, null, flags);
            } 
            {
                canvas.saveLayer(left, top, left + length, bottom, null, flags);
            } 
            {
                canvas.saveLayer(right - length, top, right, bottom, null, flags);
            } 
        } 
        {
            scrollabilityCache.setFadeColor(solidColor);
        } 
        onDraw(canvas);
        dispatchDraw(canvas);
        final Paint p = scrollabilityCache.paint;
        final Matrix matrix = scrollabilityCache.matrix;
        final Shader fade = scrollabilityCache.shader;
        {
            matrix.setScale(1, fadeHeight * topFadeStrength);
            matrix.postTranslate(left, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, top, right, top + length, p);
        } 
        {
            matrix.setScale(1, fadeHeight * bottomFadeStrength);
            matrix.postRotate(180);
            matrix.postTranslate(left, bottom);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, bottom - length, right, bottom, p);
        } 
        {
            matrix.setScale(1, fadeHeight * leftFadeStrength);
            matrix.postRotate(-90);
            matrix.postTranslate(left, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(left, top, left + length, bottom, p);
        } 
        {
            matrix.setScale(1, fadeHeight * rightFadeStrength);
            matrix.postRotate(90);
            matrix.postTranslate(right, top);
            fade.setLocalMatrix(matrix);
            canvas.drawRect(right - length, top, right, bottom, p);
        } 
        canvas.restoreToCount(saveCount);
        onDrawScrollBars(canvas);
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.832 -0400", hash_original_method = "6ABCD0F86C11EBC98FE78FD55BB4B1CF", hash_generated_method = "00B24352C19E7DFCC9E5D44D1DEEA928")
    @ViewDebug.ExportedProperty(category = "drawing")
    public int getSolidColor() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211791898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_211791898;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.833 -0400", hash_original_method = "AB08A97FC3701C702D6BD81573091B60", hash_generated_method = "DB909E4FE39C73906EE7EFD5679F9A0A")
    public boolean isLayoutRequested() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852410919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852410919;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.834 -0400", hash_original_method = "288ECB50C55148E98CF66115292FF462", hash_generated_method = "9A3ECBDD64877FEBBE883621E0F205E3")
    @SuppressWarnings({"unchecked"})
    public void layout(int l, int t, int r, int b) {
        int oldL = mLeft;
        int oldT = mTop;
        int oldB = mBottom;
        int oldR = mRight;
        boolean changed = setFrame(l, t, r, b);
        {
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_LAYOUT);
            } 
            onLayout(changed, l, t, r, b);
            mPrivateFlags &= ~LAYOUT_REQUIRED;
            ListenerInfo li = mListenerInfo;
            {
                ArrayList<OnLayoutChangeListener> listenersCopy = (ArrayList<OnLayoutChangeListener>)li.mOnLayoutChangeListeners.clone();
                int numListeners = listenersCopy.size();
                {
                    int i = 0;
                    {
                        listenersCopy.get(i).onLayoutChange(this, l, t, r, b, oldL, oldT, oldR, oldB);
                    } 
                } 
            } 
        } 
        mPrivateFlags &= ~FORCE_LAYOUT;
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.834 -0400", hash_original_method = "E68A871B23A3BFC32DE9705D7524956B", hash_generated_method = "1B89AD1313654EB103FF1DC413353CED")
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        
        addTaint(changed);
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.836 -0400", hash_original_method = "D0D9CDE5209D8FC4BFA1DB8710882914", hash_generated_method = "793934D0379D689E8863ACB1AC97B59A")
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean changed = false;
        {
            Log.d("View", this + " View.setFrame(" + left + "," + top + ","
                    + right + "," + bottom + ")");
        } 
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
            {
                {
                    {
                        mTransformationInfo.mMatrixDirty = true;
                    } 
                } 
                onSizeChanged(newWidth, newHeight, oldWidth, oldHeight);
            } 
            {
                mPrivateFlags |= DRAWN;
                invalidate(sizeChanged);
                invalidateParentCaches();
            } 
            mPrivateFlags |= drawn;
            mBackgroundSizeChanged = true;
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_398132964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_398132964;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.836 -0400", hash_original_method = "BECA18BF96D1F48EBBDC02908C938AE4", hash_generated_method = "A5AD1675E772B469DDBDD7D413837A2E")
    protected void onFinishInflate() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.837 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "8178C084D739EB426CCA47CBC9A703D8")
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_531173259 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_531173259 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_531173259.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_531173259;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.838 -0400", hash_original_method = "1B5315B2A2E6007B07F436EFC340A168", hash_generated_method = "5AE14FF04AF03F4DFF29BDE342833855")
    public void invalidateDrawable(Drawable drawable) {
        {
            boolean var6429BFA2CE72B3A4B0873DE16CAD3D14_1732914705 = (verifyDrawable(drawable));
            {
                final Rect dirty = drawable.getBounds();
                final int scrollX = mScrollX;
                final int scrollY = mScrollY;
                invalidate(dirty.left + scrollX, dirty.top + scrollY,
                    dirty.right + scrollX, dirty.bottom + scrollY);
            } 
        } 
        addTaint(drawable.getTaint());
        
        
            
            
            
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.838 -0400", hash_original_method = "8ECDB7E126F9B8C9FE155246E2EA10DA", hash_generated_method = "9738AD2C9F426544F4CE75F9232CAE93")
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        {
            boolean var0BB4EEBD6C8C02FF72C32851AF5ED118_1598725309 = (verifyDrawable(who) && what != null);
            {
                {
                    mAttachInfo.mHandler.postAtTime(what, who, when);
                } 
                {
                    ViewRootImpl.getRunQueue().postDelayed(what, when - SystemClock.uptimeMillis());
                } 
            } 
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        addTaint(when);
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.839 -0400", hash_original_method = "20282D900D1527E5779752DD2D1E3601", hash_generated_method = "3F86B0A2C5033A45F7DD6CCC0CDE1CB3")
    public void unscheduleDrawable(Drawable who, Runnable what) {
        {
            boolean var0BB4EEBD6C8C02FF72C32851AF5ED118_895535358 = (verifyDrawable(who) && what != null);
            {
                {
                    mAttachInfo.mHandler.removeCallbacks(what, who);
                } 
                {
                    ViewRootImpl.getRunQueue().removeCallbacks(what);
                } 
            } 
        } 
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.840 -0400", hash_original_method = "5631E9137ED00BCDF82AA1F70C739531", hash_generated_method = "4FE7C72FE45902F69318841012997219")
    public void unscheduleDrawable(Drawable who) {
        {
            mAttachInfo.mHandler.removeCallbacksAndMessages(who);
        } 
        addTaint(who.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.842 -0400", hash_original_method = "AE0F8179B8268398E41F65FF0C6F4434", hash_generated_method = "9A754CB503E004D46443F7800C7DC499")
    public int getResolvedLayoutDirection(Drawable who) {
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_1517219487 = (getResolvedLayoutDirection());
        } 
        addTaint(who.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195236482 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_195236482;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.842 -0400", hash_original_method = "4F9A094C3230B8AB80716D2738225FBB", hash_generated_method = "8B571DBC15D57AFE85B4CDA7F36934A3")
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507613099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507613099;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.843 -0400", hash_original_method = "73C0FB6C39E14C0EF8F5708E9524F27F", hash_generated_method = "33D828CDB270A242E8CFF05B2F0EFC5E")
    protected void drawableStateChanged() {
        Drawable d = mBGDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_813533960 = (d != null && d.isStateful());
            {
                d.setState(getDrawableState());
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.843 -0400", hash_original_method = "3D0ECB50F3069F68F8A036B0BBF9CAA8", hash_generated_method = "9DEB8A3C22FBE9FD64896016ACB0DB36")
    public void refreshDrawableState() {
        mPrivateFlags |= DRAWABLE_STATE_DIRTY;
        drawableStateChanged();
        ViewParent parent = mParent;
        {
            parent.childDrawableStateChanged(this);
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.844 -0400", hash_original_method = "7B628D8EF95C580B0BB9FD927C61FF3F", hash_generated_method = "3C211220746660AE7754F9EF3475C019")
    public final int[] getDrawableState() {
        {
            mDrawableState = onCreateDrawableState(0);
            mPrivateFlags &= ~DRAWABLE_STATE_DIRTY;
        } 
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_460267859 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_460267859;
        
        
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.845 -0400", hash_original_method = "65DFC58C78CED9A3B9AF9F7EEF9C3470", hash_generated_method = "B69AD84F7025ADDC7F6D2F3F8CC14FD2")
    protected int[] onCreateDrawableState(int extraSpace) {
        
        {
            int[] varCE673B688BFA7856C9D2543AAE971FB2_771221734 = (((View) mParent).onCreateDrawableState(extraSpace));
        } 
        int[] drawableState;
        int privateFlags = mPrivateFlags;
        int viewStateIndex = 0;
        viewStateIndex |= VIEW_STATE_PRESSED;
        viewStateIndex |= VIEW_STATE_ENABLED;
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_1956468681 = (isFocused());
            viewStateIndex |= VIEW_STATE_FOCUSED;
        } 
        viewStateIndex |= VIEW_STATE_SELECTED;
        {
            boolean var34B5A1F13735F7DF66C5DC4570B68E80_363491035 = (hasWindowFocus());
            viewStateIndex |= VIEW_STATE_WINDOW_FOCUSED;
        } 
        viewStateIndex |= VIEW_STATE_ACTIVATED;
        {
            boolean varFEAE3CEA2D5FFAE7121F7CB82052FEED_29624357 = (mAttachInfo != null && mAttachInfo.mHardwareAccelerationRequested &&
                HardwareRenderer.isAvailable());
            {
                viewStateIndex |= VIEW_STATE_ACCELERATED;
            } 
        } 
        viewStateIndex |= VIEW_STATE_HOVERED;
        final int privateFlags2 = mPrivateFlags2;
        viewStateIndex |= VIEW_STATE_DRAG_CAN_ACCEPT;
        viewStateIndex |= VIEW_STATE_DRAG_HOVERED;
        drawableState = VIEW_STATE_SETS[viewStateIndex];
        int[] fullState;
        {
            fullState = new int[drawableState.length + extraSpace];
            System.arraycopy(drawableState, 0, fullState, 0, drawableState.length);
        } 
        {
            fullState = new int[extraSpace];
        } 
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1224650616 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1224650616;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.846 -0400", hash_original_method = "9FD34CE508D1EA4936B2EE985D9CB024", hash_generated_method = "737A8B438A0C896E7E589DCB6D2BBB55")
    public void jumpDrawablesToCurrentState() {
        {
            mBGDrawable.jumpToCurrentState();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.847 -0400", hash_original_method = "0F7EB0FE33D439CD82034214A1B516F3", hash_generated_method = "A35D4A4B2F0FC192E8191EAC0AB45D14")
    @RemotableViewMethod
    public void setBackgroundColor(int color) {
        {
            ((ColorDrawable) mBGDrawable).setColor(color);
        } 
        {
            setBackgroundDrawable(new ColorDrawable(color));
        } 
        addTaint(color);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.848 -0400", hash_original_method = "009D5DD04F6FB534689B81D1D35D5DCC", hash_generated_method = "99CF16D27129CEFFE924524B51A17663")
    @RemotableViewMethod
    public void setBackgroundResource(int resid) {
        Drawable d = null;
        {
            d = mResources.getDrawable(resid);
        } 
        setBackgroundDrawable(d);
        mBackgroundResource = resid;
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.849 -0400", hash_original_method = "925AEEB36C7C1277949151BD876A29D4", hash_generated_method = "8BE56E5AA5E19EEA3582CEC80EABA835")
    public void setBackgroundDrawable(Drawable d) {
        boolean requestLayout = false;
        mBackgroundResource = 0;
        {
            mBGDrawable.setCallback(null);
            unscheduleDrawable(mBGDrawable);
        } 
        {
            Rect padding = sThreadLocal.get();
            {
                padding = new Rect();
                sThreadLocal.set(padding);
            } 
            {
                boolean var77F8DEC95ED142E00E9340D4E6309A49_1790038541 = (d.getPadding(padding));
                {
                    {
                        Object var539EB19FF2B3A749E138242972103033_453873665 = (d.getResolvedLayoutDirectionSelf());
                        
                        setPadding(padding.right, padding.top, padding.left, padding.bottom);
                        
                        
                        setPadding(padding.left, padding.top, padding.right, padding.bottom);
                        
                    } 
                } 
            } 
            {
                boolean varD26CE81CD77ABD9AB1A61C65E203B0B1_1111316379 = (mBGDrawable == null || mBGDrawable.getMinimumHeight() != d.getMinimumHeight() ||
                    mBGDrawable.getMinimumWidth() != d.getMinimumWidth());
                {
                    requestLayout = true;
                } 
            } 
            d.setCallback(this);
            {
                boolean var732D4E5C808363BC9BF454DD27943961_777489130 = (d.isStateful());
                {
                    d.setState(getDrawableState());
                } 
            } 
            d.setVisible(getVisibility() == VISIBLE, false);
            mBGDrawable = d;
            {
                mPrivateFlags &= ~SKIP_DRAW;
                mPrivateFlags |= ONLY_DRAWS_BACKGROUND;
                requestLayout = true;
            } 
        } 
        {
            mBGDrawable = null;
            {
                mPrivateFlags &= ~ONLY_DRAWS_BACKGROUND;
                mPrivateFlags |= SKIP_DRAW;
            } 
            requestLayout = true;
        } 
        computeOpaqueFlags();
        {
            requestLayout();
        } 
        mBackgroundSizeChanged = true;
        invalidate(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.850 -0400", hash_original_method = "80971671F36DCDE8D8060A8575F1E0DF", hash_generated_method = "517330D680E77FA88B4EB5093FB1C0FE")
    public Drawable getBackground() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2102243793 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2102243793 = mBGDrawable;
        varB4EAC82CA7396A68D541C85D26508E83_2102243793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2102243793;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.853 -0400", hash_original_method = "518320784120938CAC15B0472A139DBB", hash_generated_method = "6B1CF6F0555ED827A6C9F14F1612FD19")
    public void setPadding(int left, int top, int right, int bottom) {
        boolean changed = false;
        mUserPaddingRelative = false;
        mUserPaddingLeft = left;
        mUserPaddingRight = right;
        mUserPaddingBottom = bottom;
        final int viewFlags = mViewFlags;
        {
            {
                int offset;
                offset = 0;
                offset = getVerticalScrollbarWidth();
                
                {
                    boolean varDD88345AFC6B206805F2994C7FB7F6F7_1583121693 = (getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL);
                    {
                        left += offset;
                    } 
                    {
                        right += offset;
                    } 
                } 
                
                
                right += offset;
                
                
                left += offset;
                
            } 
            {
                bottom += (viewFlags & SCROLLBARS_INSET_MASK) == 0
                        ? 0 : getHorizontalScrollbarHeight();
            } 
        } 
        {
            changed = true;
            mPaddingLeft = left;
        } 
        {
            changed = true;
            mPaddingTop = top;
        } 
        {
            changed = true;
            mPaddingRight = right;
        } 
        {
            changed = true;
            mPaddingBottom = bottom;
        } 
        {
            requestLayout();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.854 -0400", hash_original_method = "F50D0F04B3AF13DC9F9192544EA8BA6E", hash_generated_method = "7E0EF0BDF4A2862DE59CD1809BC4BA26")
    public void setPaddingRelative(int start, int top, int end, int bottom) {
        mUserPaddingRelative = true;
        mUserPaddingStart = start;
        mUserPaddingEnd = end;
        {
            Object varAFC6EB2C684D509A17B3A4EFF5D9CB9D_251942311 = (getResolvedLayoutDirection());
            
            setPadding(end, top, start, bottom);
            
            
            setPadding(start, top, end, bottom);
            
        } 
        addTaint(top);
        addTaint(bottom);
        
        
        
        
        
            
                
                
            
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.854 -0400", hash_original_method = "71BE64DF9CA1E548604AD18ADE3DFBDD", hash_generated_method = "CAAA0001E000C947E451BCEB00DE1323")
    public int getPaddingTop() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753010528 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753010528;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.854 -0400", hash_original_method = "472EE1BBE725DA831283E7FA94BE4536", hash_generated_method = "6397C1E57C44EF290EA2CFBCB577F0F0")
    public int getPaddingBottom() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927102612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927102612;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.855 -0400", hash_original_method = "F854F7F8F07B4C3AC7B7FE5B9B528BAE", hash_generated_method = "860F7CC1B34A1FFF1B9C6B64E18D9011")
    public int getPaddingLeft() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_804400739 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_804400739;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.856 -0400", hash_original_method = "78A5E196850432C8DD415DC0673D2C8F", hash_generated_method = "159A70CB27E41D1C14C63948104CE864")
    public int getPaddingStart() {
        {
            boolean varCF77AC373D50E68CC74CEB17E0D05088_2082840703 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949677510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949677510;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.856 -0400", hash_original_method = "6AC4AEB4D1AD621C23B7EB8B08E4182E", hash_generated_method = "AD48D40391972D2BE062CD5CD7779FC2")
    public int getPaddingRight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334823439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334823439;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.857 -0400", hash_original_method = "EE58EF7C85312E1C063201AE8CA23F8D", hash_generated_method = "952757986BB8C638F1F56A21C4DD4B3B")
    public int getPaddingEnd() {
        {
            boolean varCF77AC373D50E68CC74CEB17E0D05088_1899071671 = ((getResolvedLayoutDirection() == LAYOUT_DIRECTION_RTL));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372960946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372960946;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.857 -0400", hash_original_method = "84D71EDE4F7EF14E19771B4AB735B283", hash_generated_method = "46C655B5DB5F816DC854AD3F1A2E509C")
    public boolean isPaddingRelative() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1757746063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1757746063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.858 -0400", hash_original_method = "91676949986DAC4CFDCFD2A3FAD3A69B", hash_generated_method = "2AD1BA286B2A767741E035B42D243C92")
    public void setSelected(boolean selected) {
        {
            mPrivateFlags = (mPrivateFlags & ~SELECTED) | (selected ? SELECTED : 0);
            resetPressedState();
            invalidate(true);
            refreshDrawableState();
            dispatchSetSelected(selected);
        } 
        
        
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.858 -0400", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "D0F40E63E0975CE8FE5A4FA8E00A2A22")
    protected void dispatchSetSelected(boolean selected) {
        addTaint(selected);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.859 -0400", hash_original_method = "48002052E4D321A2B2BAD55BEF8E0A66", hash_generated_method = "CB764EDE2AC1F87227E3D93A2C3C5129")
    @ViewDebug.ExportedProperty
    public boolean isSelected() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42195063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42195063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.860 -0400", hash_original_method = "449C65D8ABD541EEF5AF1DFBC99BE952", hash_generated_method = "49E234D147E234DC90F8558D403E6854")
    public void setActivated(boolean activated) {
        {
            mPrivateFlags = (mPrivateFlags & ~ACTIVATED) | (activated ? ACTIVATED : 0);
            invalidate(true);
            refreshDrawableState();
            dispatchSetActivated(activated);
        } 
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.860 -0400", hash_original_method = "857B49EDB2F7375261DD6F1ED2F34094", hash_generated_method = "51446F3DB68DBD70CEFE789714FC4FCB")
    protected void dispatchSetActivated(boolean activated) {
        addTaint(activated);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.861 -0400", hash_original_method = "807E5BA633430E7244B8D5311A7423DE", hash_generated_method = "79666094C24383428BA7967B5CBE0B32")
    @ViewDebug.ExportedProperty
    public boolean isActivated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147404158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147404158;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.862 -0400", hash_original_method = "99F6A92222C13DFFEF0BA3B363A5F1C1", hash_generated_method = "4974B6608AC46EE376CA6A456B8147C6")
    public ViewTreeObserver getViewTreeObserver() {
        ViewTreeObserver varB4EAC82CA7396A68D541C85D26508E83_854379759 = null; 
        ViewTreeObserver varB4EAC82CA7396A68D541C85D26508E83_770668762 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_854379759 = mAttachInfo.mTreeObserver;
        } 
        {
            mFloatingTreeObserver = new ViewTreeObserver();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_770668762 = mFloatingTreeObserver;
        ViewTreeObserver varA7E53CE21691AB073D9660D615818899_1680518798; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1680518798 = varB4EAC82CA7396A68D541C85D26508E83_854379759;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1680518798 = varB4EAC82CA7396A68D541C85D26508E83_770668762;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1680518798.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1680518798;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.863 -0400", hash_original_method = "399BB6B1CB98987E45F7FD1BEC4104A8", hash_generated_method = "D172175AC50F7B839974707AAF7C7E5B")
    public View getRootView() {
        View varB4EAC82CA7396A68D541C85D26508E83_2065506533 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1434133190 = null; 
        {
            final View v = mAttachInfo.mRootView;
            {
                varB4EAC82CA7396A68D541C85D26508E83_2065506533 = v;
            } 
        } 
        View parent = this;
        {
            parent = (View) parent.mParent;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1434133190 = parent;
        View varA7E53CE21691AB073D9660D615818899_43270328; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_43270328 = varB4EAC82CA7396A68D541C85D26508E83_2065506533;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_43270328 = varB4EAC82CA7396A68D541C85D26508E83_1434133190;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_43270328.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_43270328;
        
        
            
            
                
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.864 -0400", hash_original_method = "6E1F3A14CB89D70C54E776D2215F970D", hash_generated_method = "479F8104DAA3F3065CA1EBCB4DAE3950")
    public void getLocationOnScreen(int[] location) {
        getLocationInWindow(location);
        final AttachInfo info = mAttachInfo;
        {
            location[0] += info.mWindowLeft;
            location[1] += info.mWindowTop;
        } 
        addTaint(location[0]);
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.865 -0400", hash_original_method = "D5745CE4077A3F8C966A99FAE28757B4", hash_generated_method = "9FF9C93A0125BBF2921EE04C1DA9AB78")
    public void getLocationInWindow(int[] location) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("location must be an array of two integers");
        } 
        float[] position = mAttachInfo.mTmpTransformLocation;
        position[0] = position[1] = 0.0f;
        {
            boolean var72C5EB038B47497B7FA123412E9ED288_1079546529 = (!hasIdentityMatrix());
            {
                getMatrix().mapPoints(position);
            } 
        } 
        position[0] += mLeft;
        position[1] += mTop;
        ViewParent viewParent = mParent;
        {
            final View view = (View) viewParent;
            position[0] -= view.mScrollX;
            position[1] -= view.mScrollY;
            {
                boolean varA98FC0C227FABB5530C6DB9897E9E044_938408472 = (!view.hasIdentityMatrix());
                {
                    view.getMatrix().mapPoints(position);
                } 
            } 
            position[0] += view.mLeft;
            position[1] += view.mTop;
            viewParent = view.mParent;
        } 
        {
            final ViewRootImpl vr = (ViewRootImpl) viewParent;
            position[1] -= vr.mCurScrollY;
        } 
        location[0] = (int) (position[0] + 0.5f);
        location[1] = (int) (position[1] + 0.5f);
        addTaint(location[0]);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.865 -0400", hash_original_method = "0641E50E124E0C6CE4C02F73E2175BDE", hash_generated_method = "7C3EF89CCBBF0D20FD47F250427EEA29")
    protected View findViewTraversal(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_1129728202 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1084346005 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1129728202 = this;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1084346005 = null;
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_1724943230; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1724943230 = varB4EAC82CA7396A68D541C85D26508E83_1129728202;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1724943230 = varB4EAC82CA7396A68D541C85D26508E83_1084346005;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1724943230.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1724943230;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.866 -0400", hash_original_method = "B50CD4B4D228C210BD89E9DF598807C7", hash_generated_method = "2E5D9274D0F06BDEF6C53AC92F2D1185")
    protected View findViewWithTagTraversal(Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_1180461312 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_57144054 = null; 
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_1826745069 = (tag != null && tag.equals(mTag));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1180461312 = this;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_57144054 = null;
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_706602336; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_706602336 = varB4EAC82CA7396A68D541C85D26508E83_1180461312;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_706602336 = varB4EAC82CA7396A68D541C85D26508E83_57144054;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_706602336.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_706602336;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.867 -0400", hash_original_method = "65DA32C16954A521B825F7D31B571CEF", hash_generated_method = "D5A94C95C39778772197D6BF25FD006C")
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_1817367320 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1966376455 = null; 
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_1458034560 = (predicate.apply(this));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1817367320 = this;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1966376455 = null;
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1955167037; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1955167037 = varB4EAC82CA7396A68D541C85D26508E83_1817367320;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1955167037 = varB4EAC82CA7396A68D541C85D26508E83_1966376455;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1955167037.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1955167037;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.867 -0400", hash_original_method = "C8E06C0ED5E3D035BF7CE8B77FB6FB02", hash_generated_method = "05A5FCBCFB9FFEF3784A50AEA0180868")
    public final View findViewById(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_761109661 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_969010305 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_761109661 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_969010305 = findViewTraversal(id);
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_539964553; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_539964553 = varB4EAC82CA7396A68D541C85D26508E83_761109661;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_539964553 = varB4EAC82CA7396A68D541C85D26508E83_969010305;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_539964553.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_539964553;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.868 -0400", hash_original_method = "DAB2723BE4C5F25FDBDAA56D4A941A95", hash_generated_method = "3356551D28225C730FC92B0FB06DBC62")
    final View findViewByAccessibilityId(int accessibilityId) {
        View varB4EAC82CA7396A68D541C85D26508E83_465926415 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_13743844 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_465926415 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_13743844 = findViewByAccessibilityIdTraversal(accessibilityId);
        addTaint(accessibilityId);
        View varA7E53CE21691AB073D9660D615818899_68291961; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_68291961 = varB4EAC82CA7396A68D541C85D26508E83_465926415;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_68291961 = varB4EAC82CA7396A68D541C85D26508E83_13743844;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_68291961.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_68291961;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.869 -0400", hash_original_method = "0033D4DC027C6D84BC9CA79DB06FA7C7", hash_generated_method = "C06F0A34FD94AF934D81CADB548E9383")
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        View varB4EAC82CA7396A68D541C85D26508E83_864747125 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_521981885 = null; 
        {
            boolean varA0F894C9F7ECB9E8C9290E6F95BA5394_1701233478 = (getAccessibilityViewId() == accessibilityId);
            {
                varB4EAC82CA7396A68D541C85D26508E83_864747125 = this;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_521981885 = null;
        addTaint(accessibilityId);
        View varA7E53CE21691AB073D9660D615818899_1100552573; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1100552573 = varB4EAC82CA7396A68D541C85D26508E83_864747125;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1100552573 = varB4EAC82CA7396A68D541C85D26508E83_521981885;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1100552573.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1100552573;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.870 -0400", hash_original_method = "DB0D3478EC5FC406F90807706EB086DC", hash_generated_method = "C46E7A06C92A6651C6598C098B81DDAD")
    public final View findViewWithTag(Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_471692459 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1671375279 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_471692459 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1671375279 = findViewWithTagTraversal(tag);
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1512702764; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1512702764 = varB4EAC82CA7396A68D541C85D26508E83_471692459;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1512702764 = varB4EAC82CA7396A68D541C85D26508E83_1671375279;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1512702764.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1512702764;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.871 -0400", hash_original_method = "1599799F36C9F7803A0B97DCCA829DED", hash_generated_method = "DF83B1DEE2E9746CD50BC215A4B302E6")
    public final View findViewByPredicate(Predicate<View> predicate) {
        View varB4EAC82CA7396A68D541C85D26508E83_801603089 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_801603089 = findViewByPredicateTraversal(predicate, null);
        addTaint(predicate.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_801603089.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_801603089;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.873 -0400", hash_original_method = "485BA369E24687F2D5FF0693ABF816B2", hash_generated_method = "7062F5937A86478BF3FD36B75AB10B35")
    public final View findViewByPredicateInsideOut(View start, Predicate<View> predicate) {
        View varB4EAC82CA7396A68D541C85D26508E83_848952811 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1220272269 = null; 
        View childToSkip = null;
        {
            View view = start.findViewByPredicateTraversal(predicate, childToSkip);
            {
                boolean var7558536A6954E6545716F82725118232_955725448 = (view != null || start == this);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_848952811 = view;
                } 
            } 
            ViewParent parent = start.getParent();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1220272269 = null;
            } 
            childToSkip = start;
            start = (View) parent;
        } 
        addTaint(start.getTaint());
        addTaint(predicate.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1350430800; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1350430800 = varB4EAC82CA7396A68D541C85D26508E83_848952811;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1350430800 = varB4EAC82CA7396A68D541C85D26508E83_1220272269;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1350430800.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1350430800;
        
        
        
            
            
                
            
            
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.874 -0400", hash_original_method = "125195EB8F3EB02BBD72A4003F2E03BD", hash_generated_method = "491B6D8B484C16297DCBDA4E3A5ECCE1")
    public void setId(int id) {
        mID = id;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.874 -0400", hash_original_method = "B06467135FDA3C6D538127B3AC355349", hash_generated_method = "E3039F9ACF302E27C0A590FA5D28A2C8")
    public void setIsRootNamespace(boolean isRoot) {
        {
            mPrivateFlags |= IS_ROOT_NAMESPACE;
        } 
        {
            mPrivateFlags &= ~IS_ROOT_NAMESPACE;
        } 
        addTaint(isRoot);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.875 -0400", hash_original_method = "74A41C2D2B744E005149431B820C27E4", hash_generated_method = "23697351BE803835F2792F15E3F260F7")
    public boolean isRootNamespace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942137142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942137142;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.875 -0400", hash_original_method = "B0378653037A8E20BF93620A5E0AA660", hash_generated_method = "CD7C1AEC8C5ACE7E83BBC9C2FD8B9EC0")
    @ViewDebug.CapturedViewProperty
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904672325 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_904672325;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.876 -0400", hash_original_method = "15C9157ADF1B79E512CAFF71050D7BD7", hash_generated_method = "92130E4877EAB42F402E7595D9E5B46E")
    @ViewDebug.ExportedProperty
    public Object getTag() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1991974308 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1991974308 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_1991974308.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1991974308;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.877 -0400", hash_original_method = "8D2B18A079B1EE90519A06D435C647B9", hash_generated_method = "A88DBE9CF3CA0D1CB8F5AC3014136EA5")
    public void setTag(final Object tag) {
        mTag = tag;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.878 -0400", hash_original_method = "8295DF3154C0458AF2AF3A51D79A598B", hash_generated_method = "2B03259EB59BC72A2EE48EB61D04F60D")
    public Object getTag(int key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_712256582 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_60464022 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_712256582 = mKeyedTags.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_60464022 = null;
        addTaint(key);
        Object varA7E53CE21691AB073D9660D615818899_1979729340; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1979729340 = varB4EAC82CA7396A68D541C85D26508E83_712256582;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1979729340 = varB4EAC82CA7396A68D541C85D26508E83_60464022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1979729340.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1979729340;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.878 -0400", hash_original_method = "C739488AB1D92CB0D6B67C6D73AEF4DA", hash_generated_method = "295E62BE5127CCE56665DED2F5D1429E")
    public void setTag(int key, final Object tag) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The key must be an application-specific "
                    + "resource id.");
        } 
        setKeyedTag(key, tag);
        addTaint(key);
        addTaint(tag.getTaint());
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.879 -0400", hash_original_method = "5A92838330F5A71B83A0155FDDE52450", hash_generated_method = "C5DB8DF53B5E4D167518DCA436949243")
    public void setTagInternal(int key, Object tag) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The key must be a framework-specific "
                    + "resource id.");
        } 
        setKeyedTag(key, tag);
        addTaint(key);
        addTaint(tag.getTaint());
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.880 -0400", hash_original_method = "0255761BE2D8372B1493AF7283C8F5B5", hash_generated_method = "06A89F7CB14EBD2C93511CB0C5FFCEA8")
    private void setKeyedTag(int key, Object tag) {
        {
            mKeyedTags = new SparseArray<Object>();
        } 
        mKeyedTags.put(key, tag);
        addTaint(key);
        addTaint(tag.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.881 -0400", hash_original_method = "C5EE38E619F11A07C2A1169818F1E749", hash_generated_method = "72EE2ED03B24B62C298C8BEB97982438")
    protected boolean dispatchConsistencyCheck(int consistency) {
        boolean var696CB6BB2A7239589CBDDD711F9F9275_1379873633 = (onConsistencyCheck(consistency));
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490236539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490236539;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.882 -0400", hash_original_method = "2064C42F46AA0108673BA11B037AF3A0", hash_generated_method = "DB76E7DA190CFEAA089D1DFEDAE7475C")
    protected boolean onConsistencyCheck(int consistency) {
        
        boolean result = true;
        final boolean checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        final boolean checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            {
                boolean varDE1E2D0AA459DE6E8FAB425D9EAC441E_662977595 = (getParent() == null);
                {
                    result = false;
                    android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " does not have a parent.");
                } 
            } 
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " is not attached to a window.");
            } 
        } 
        {
            {
                result = false;
                android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                        "View " + this + " was invalidated but its drawing cache is valid.");
            } 
        } 
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050182547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050182547;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.882 -0400", hash_original_method = "6F90E3DC82B178E80E1C9DDC98738197", hash_generated_method = "D147ED463C0B27338F948465FB673FC2")
    public void debug() {
        debug(0);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.884 -0400", hash_original_method = "3D5CB916992FEDBE62B11876DD1CF29A", hash_generated_method = "951A58DF6767A8DAA05D0D361D9DEA9E")
    protected void debug(int depth) {
        String output = debugIndent(depth - 1);
        output += "+ " + this;
        int id = getId();
        {
            output += " (id=" + id + ")";
        } 
        Object tag = getTag();
        {
            output += " (tag=" + tag + ")";
        } 
        Log.d(VIEW_LOG_TAG, output);
        {
            output = debugIndent(depth) + " FOCUSED";
            Log.d(VIEW_LOG_TAG, output);
        } 
        output = debugIndent(depth);
        output += "frame={" + mLeft + ", " + mTop + ", " + mRight
                + ", " + mBottom + "} scroll={" + mScrollX + ", " + mScrollY
                + "} ";
        Log.d(VIEW_LOG_TAG, output);
        {
            output = debugIndent(depth);
            output += "padding={" + mPaddingLeft + ", " + mPaddingTop
                    + ", " + mPaddingRight + ", " + mPaddingBottom + "}";
            Log.d(VIEW_LOG_TAG, output);
        } 
        output = debugIndent(depth);
        output += "mMeasureWidth=" + mMeasuredWidth +
                " mMeasureHeight=" + mMeasuredHeight;
        Log.d(VIEW_LOG_TAG, output);
        output = debugIndent(depth);
        {
            output += "BAD! no layout params";
        } 
        {
            output = mLayoutParams.debug(output);
        } 
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
        addTaint(depth);
        
        
    }

    
        protected static String debugIndent(int depth) {
        StringBuilder spaces = new StringBuilder((depth * 2 + 3) * 2);
        for (int i = 0; i < (depth * 2) + 3; i++) {
            spaces.append(' ').append(' ');
        }
        return spaces.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.884 -0400", hash_original_method = "04C72C8D15A6DF3440AFF547FAD30ABA", hash_generated_method = "28E7273C054DD8F9E9C5DBD2023F5BFE")
    @ViewDebug.ExportedProperty(category = "layout")
    public int getBaseline() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605262570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1605262570;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.885 -0400", hash_original_method = "B7CE3104FF9ED0677BFFACD05F948960", hash_generated_method = "E4B0B2C6769D01E8C6D13E0AF037275B")
    public void requestLayout() {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.REQUEST_LAYOUT);
        } 
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        {
            {
                mLayoutParams.resolveWithDirection(getResolvedLayoutDirection());
            } 
            {
                boolean var3A2DB0BB7B6E5FB8768388F8E364ED16_820406663 = (!mParent.isLayoutRequested());
                {
                    mParent.requestLayout();
                } 
            } 
        } 
        
        
            
        
        
        
        
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.885 -0400", hash_original_method = "5F70867C98C203969EB162B4B724A790", hash_generated_method = "1F7ADA8EF52B745DA17A5F28CC890DA3")
    public void forceLayout() {
        mPrivateFlags |= FORCE_LAYOUT;
        mPrivateFlags |= INVALIDATED;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.886 -0400", hash_original_method = "26BA2349651C8679968382F6A84D9E92", hash_generated_method = "42AD92EB4D7181C601BDC4659B482D71")
    public final void measure(int widthMeasureSpec, int heightMeasureSpec) {
        {
            mPrivateFlags &= ~MEASURED_DIMENSION_SET;
            {
                ViewDebug.trace(this, ViewDebug.HierarchyTraceType.ON_MEASURE);
            } 
            onMeasure(widthMeasureSpec, heightMeasureSpec);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("onMeasure() did not set the"
                        + " measured dimension by calling"
                        + " setMeasuredDimension()");
            } 
            mPrivateFlags |= LAYOUT_REQUIRED;
        } 
        mOldWidthMeasureSpec = widthMeasureSpec;
        mOldHeightMeasureSpec = heightMeasureSpec;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.886 -0400", hash_original_method = "2024EA7D99B2D61F149E7A5A9BB7EB8E", hash_generated_method = "A1685498757267B70C369301E6769581")
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.886 -0400", hash_original_method = "5AB327430FB1DFBD1DD895A1A32A2AA8", hash_generated_method = "8B2B36A03163D56C56910520694D78FC")
    protected final void setMeasuredDimension(int measuredWidth, int measuredHeight) {
        mMeasuredWidth = measuredWidth;
        mMeasuredHeight = measuredHeight;
        mPrivateFlags |= MEASURED_DIMENSION_SET;
        
        
        
        
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.888 -0400", hash_original_method = "B59EA0BF10E69D3FFCA86CC30267F8DC", hash_generated_method = "E168E120CC78A60C98EE85ED72DD4E9F")
    protected int getSuggestedMinimumHeight() {
        int suggestedMinHeight = mMinHeight;
        {
            final int bgMinHeight = mBGDrawable.getMinimumHeight();
            {
                suggestedMinHeight = bgMinHeight;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327540289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327540289;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.888 -0400", hash_original_method = "008B87CD2B3ED33B965CD69B13D61BFC", hash_generated_method = "2771F5ABD8252E307550F4A6A96A8215")
    protected int getSuggestedMinimumWidth() {
        int suggestedMinWidth = mMinWidth;
        {
            final int bgMinWidth = mBGDrawable.getMinimumWidth();
            {
                suggestedMinWidth = bgMinWidth;
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232864507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232864507;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.889 -0400", hash_original_method = "879BFA5FA0241047CB6974ED67682297", hash_generated_method = "A39DF7CE68D27AD1F832F37EFF38AC83")
    public void setMinimumHeight(int minHeight) {
        mMinHeight = minHeight;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.889 -0400", hash_original_method = "CE129FBEAB6CCA0889899FF1E8E78A67", hash_generated_method = "94906ED9E91744BCBB1BA063108152BC")
    public void setMinimumWidth(int minWidth) {
        mMinWidth = minWidth;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.889 -0400", hash_original_method = "CDBB00D26F9C60D5F3E6B97847853936", hash_generated_method = "F39FB7F9AAB9CBB8C30FA485CA17213D")
    public Animation getAnimation() {
        Animation varB4EAC82CA7396A68D541C85D26508E83_802281216 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_802281216 = mCurrentAnimation;
        varB4EAC82CA7396A68D541C85D26508E83_802281216.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_802281216;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.890 -0400", hash_original_method = "8B9244EE03042EB67F130AFDAD9A68F9", hash_generated_method = "0D849D6C10BD44515578B9EF5F3E1FDE")
    public void startAnimation(Animation animation) {
        animation.setStartTime(Animation.START_ON_FIRST_FRAME);
        setAnimation(animation);
        invalidateParentCaches();
        invalidate(true);
        addTaint(animation.getTaint());
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.890 -0400", hash_original_method = "743A148D3AA9DA63FB0D1635C16263C7", hash_generated_method = "D8BDC865788F545FD5DB6A92DA533D21")
    public void clearAnimation() {
        {
            mCurrentAnimation.detach();
        } 
        mCurrentAnimation = null;
        invalidateParentIfNeeded();
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.890 -0400", hash_original_method = "80992FCFACCF22F26EEB305124C3026E", hash_generated_method = "F0E380EE622343CB0DADA43AC76C72C0")
    public void setAnimation(Animation animation) {
        mCurrentAnimation = animation;
        {
            animation.reset();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.891 -0400", hash_original_method = "AAD5AA561778224F71E3AF6921CD4105", hash_generated_method = "06D6C8F61FFE52559A40E6B98F790853")
    protected void onAnimationStart() {
        
        mPrivateFlags |= ANIMATION_STARTED;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.891 -0400", hash_original_method = "F4AD81FC3499666E7AC93E3735AFEF8E", hash_generated_method = "05026BAADDDB17252B779F88E55782F5")
    protected void onAnimationEnd() {
        
        mPrivateFlags &= ~ANIMATION_STARTED;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.891 -0400", hash_original_method = "DC47911C20E58BC47F643D76AAAF3E73", hash_generated_method = "320936FCA55A9C1B35727028D248FE8A")
    protected boolean onSetAlpha(int alpha) {
        
        addTaint(alpha);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1967480969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1967480969;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.892 -0400", hash_original_method = "A01500863A3F6668743C7034A9645220", hash_generated_method = "A1B7A40E2B93BE94382C5265626C5635")
    public boolean gatherTransparentRegion(Region region) {
        final AttachInfo attachInfo = mAttachInfo;
        {
            final int pflags = mPrivateFlags;
            {
                final int[] location = attachInfo.mTransparentLocation;
                getLocationInWindow(location);
                region.op(location[0], location[1], location[0] + mRight - mLeft,
                        location[1] + mBottom - mTop, Region.Op.DIFFERENCE);
            } 
            {
                applyDrawableToTransparentRegion(mBGDrawable, region);
            } 
        } 
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645152735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_645152735;
        
        
        
            
            
                
                
                
                        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.893 -0400", hash_original_method = "92BFD91D600C047225F186391F6079B0", hash_generated_method = "FE7E390AEA40F5E6906B6AEC1465273E")
    public void playSoundEffect(int soundConstant) {
        {
            boolean var1E4326663BC68D529F79DE6FC2643778_665209657 = (mAttachInfo == null || mAttachInfo.mRootCallbacks == null || !isSoundEffectsEnabled());
        } 
        mAttachInfo.mRootCallbacks.playSoundEffect(soundConstant);
        addTaint(soundConstant);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.893 -0400", hash_original_method = "75954C55ABC6CE5681E22BCDE96F4903", hash_generated_method = "57E2A2FA179CD9559589F93B6521C08B")
    public boolean performHapticFeedback(int feedbackConstant) {
        boolean var47DA1E759FDC3E51245046642463FE5C_932613850 = (performHapticFeedback(feedbackConstant, 0));
        addTaint(feedbackConstant);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116373208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116373208;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.893 -0400", hash_original_method = "A19669526C11317AB6CCDC764945F176", hash_generated_method = "4B31E5B7D36F4D84E066E53EC33D5DCE")
    public boolean performHapticFeedback(int feedbackConstant, int flags) {
        {
            boolean varA5539A907B715B189715B7DC683584E6_262108939 = ((flags & HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING) == 0
                && !isHapticFeedbackEnabled());
        } 
        boolean var504ECB78099BB3639952FEB46DA1CEC5_1528283443 = (mAttachInfo.mRootCallbacks.performHapticFeedback(feedbackConstant,
                (flags & HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING) != 0));
        addTaint(feedbackConstant);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181986513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181986513;
        
        
            
        
        
                
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.894 -0400", hash_original_method = "1F6436CCBBD24CDC20D09B9CE44A0912", hash_generated_method = "C501877563CED89188474EC8CE497D73")
    public void setSystemUiVisibility(int visibility) {
        {
            mSystemUiVisibility = visibility;
            {
                mParent.recomputeViewAttributes(this);
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.894 -0400", hash_original_method = "FA02CCE186B627C6CF56D55D5156174E", hash_generated_method = "75E34C20ED89642B349E25EB1CE3D917")
    public int getSystemUiVisibility() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175490578 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175490578;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.894 -0400", hash_original_method = "1911D5DDAC8087DF02FDB915711E3D30", hash_generated_method = "5082BD11025AEF1DE33FFE0132594858")
    public void setOnSystemUiVisibilityChangeListener(OnSystemUiVisibilityChangeListener l) {
        getListenerInfo().mOnSystemUiVisibilityChangeListener = l;
        {
            mParent.recomputeViewAttributes(this);
        } 
        addTaint(l.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.895 -0400", hash_original_method = "31A60EE50D18A3986849FF003231E28E", hash_generated_method = "7A5B77F0F4667ABF0DD1C5F7B1550236")
    public void dispatchSystemUiVisibilityChanged(int visibility) {
        ListenerInfo li = mListenerInfo;
        {
            li.mOnSystemUiVisibilityChangeListener.onSystemUiVisibilityChange(
                    visibility & PUBLIC_STATUS_BAR_VISIBILITY_MASK);
        } 
        addTaint(visibility);
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.895 -0400", hash_original_method = "BE707BAA551F425B19E1E4FBE454F716", hash_generated_method = "B5B916E8879898F733150A22F5068C4F")
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        int val = (mSystemUiVisibility&~localChanges) | (localValue&localChanges);
        {
            setSystemUiVisibility(val);
        } 
        addTaint(localValue);
        addTaint(localChanges);
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.896 -0400", hash_original_method = "F914DF1AC479022C6AA4BFD6DD1247D7", hash_generated_method = "642345B8BC7F322EA2776D564690AA18")
    public final boolean startDrag(ClipData data, DragShadowBuilder shadowBuilder,
            Object myLocalState, int flags) {
        {
            Log.d(VIEW_LOG_TAG, "startDrag: data=" + data + " flags=" + flags);
        } 
        boolean okay = false;
        Point shadowSize = new Point();
        Point shadowTouchPoint = new Point();
        shadowBuilder.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Drag shadow dimensions must not be negative");
        } 
        {
            Log.d(VIEW_LOG_TAG, "drag shadow: width=" + shadowSize.x + " height=" + shadowSize.y
                    + " shadowX=" + shadowTouchPoint.x + " shadowY=" + shadowTouchPoint.y);
        } 
        Surface surface = new Surface();
        try 
        {
            IBinder token = mAttachInfo.mSession.prepareDrag(mAttachInfo.mWindow,
                    flags, shadowSize.x, shadowSize.y, surface);
            Log.d(VIEW_LOG_TAG, "prepareDrag returned token=" + token
                    + " surface=" + surface);
            {
                Canvas canvas = surface.lockCanvas(null);
                try 
                {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    shadowBuilder.onDrawShadow(canvas);
                } 
                finally 
                {
                    surface.unlockCanvasAndPost(canvas);
                } 
                final ViewRootImpl root = getViewRootImpl();
                root.setLocalDragState(myLocalState);
                root.getLastTouchPoint(shadowSize);
                okay = mAttachInfo.mSession.performDrag(mAttachInfo.mWindow, token,
                        shadowSize.x, shadowSize.y,
                        shadowTouchPoint.x, shadowTouchPoint.y, data);
                Log.d(VIEW_LOG_TAG, "performDrag returned " + okay);
                surface.release();
            } 
        } 
        catch (Exception e)
        {
            surface.destroy();
        } 
        addTaint(data.getTaint());
        addTaint(shadowBuilder.getTaint());
        addTaint(myLocalState.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75429935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_75429935;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.896 -0400", hash_original_method = "7E645D896E88F7A2CE991A302B5729A7", hash_generated_method = "3F8946C43CA2F817F10E7C05CBCD1603")
    public boolean onDragEvent(DragEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391810223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391810223;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.897 -0400", hash_original_method = "2E7102A43746FEAE9D11C37FDA834A21", hash_generated_method = "278155D142C912DDF3236757CB1DCFD8")
    public boolean dispatchDragEvent(DragEvent event) {
        ListenerInfo li = mListenerInfo;
        {
            boolean var335DF3A408D4F144DA69CF42853FDB1A_1212936900 = (li != null && li.mOnDragListener != null && (mViewFlags & ENABLED_MASK) == ENABLED
                && li.mOnDragListener.onDrag(this, event));
        } 
        boolean var0587795787D505B85471C0D6F567FE89_1837006441 = (onDragEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352630110 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352630110;
        
        
        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.897 -0400", hash_original_method = "C990D75777DFB098F96F21BE433F897F", hash_generated_method = "AC6AE20DA7DF6647048014F0EBC20ABF")
     boolean canAcceptDrag() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2036587614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2036587614;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.898 -0400", hash_original_method = "059265693C3FBF9CA8D6100876A0DA7C", hash_generated_method = "4027BFE56A9421810369202A60B7D2BD")
    public void onCloseSystemDialogs(String reason) {
        
        addTaint(reason.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.898 -0400", hash_original_method = "14C9DBE3395E98A8750BC15A93AD3A45", hash_generated_method = "410737B3A8D1CD57B8378596229AD715")
    public void applyDrawableToTransparentRegion(Drawable dr, Region region) {
        final Region r = dr.getTransparentRegion();
        final Rect db = dr.getBounds();
        final AttachInfo attachInfo = mAttachInfo;
        {
            final int w = getRight()-getLeft();
            final int h = getBottom()-getTop();
            {
                r.op(0, 0, db.left, h, Region.Op.UNION);
            } 
            {
                r.op(db.right, 0, w, h, Region.Op.UNION);
            } 
            {
                r.op(0, 0, w, db.top, Region.Op.UNION);
            } 
            {
                r.op(0, db.bottom, w, h, Region.Op.UNION);
            } 
            final int[] location = attachInfo.mTransparentLocation;
            getLocationInWindow(location);
            r.translate(location[0], location[1]);
            region.op(r, Region.Op.INTERSECT);
        } 
        {
            region.op(db, Region.Op.DIFFERENCE);
        } 
        addTaint(dr.getTaint());
        addTaint(region.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.899 -0400", hash_original_method = "3A330A3DE83C0EE0C70042D452F74FC4", hash_generated_method = "29B4F79DBE6EE8C697B8E208D37D084B")
    private void checkForLongClick(int delayOffset) {
        {
            mHasPerformedLongPress = false;
            {
                mPendingCheckForLongPress = new CheckForLongPress();
            } 
            mPendingCheckForLongPress.rememberWindowAttachCount();
            postDelayed(mPendingCheckForLongPress,
                    ViewConfiguration.getLongPressTimeout() - delayOffset);
        } 
        addTaint(delayOffset);
        
        
            
            
                
            
            
            
                    
        
    }

    
        public static View inflate(Context context, int resource, ViewGroup root) {
        LayoutInflater factory = LayoutInflater.from(context);
        return factory.inflate(resource, root);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.900 -0400", hash_original_method = "5E47C984391EE91860CD25320EB410A4", hash_generated_method = "E681FF355DA803A7FEA00126C5F6377B")
    @SuppressWarnings({"UnusedParameters"})
    protected boolean overScrollBy(int deltaX, int deltaY,
            int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY,
            int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent) {
        final int overScrollMode = mOverScrollMode;
        final boolean canScrollHorizontal = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        final boolean canScrollVertical = computeVerticalScrollRange() > computeVerticalScrollExtent();
        final boolean overScrollHorizontal = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollHorizontal);
        final boolean overScrollVertical = overScrollMode == OVER_SCROLL_ALWAYS ||
                (overScrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && canScrollVertical);
        int newScrollX = scrollX + deltaX;
        {
            maxOverScrollX = 0;
        } 
        int newScrollY = scrollY + deltaY;
        {
            maxOverScrollY = 0;
        } 
        final int left = -maxOverScrollX;
        final int right = maxOverScrollX + scrollRangeX;
        final int top = -maxOverScrollY;
        final int bottom = maxOverScrollY + scrollRangeY;
        boolean clampedX = false;
        {
            newScrollX = right;
            clampedX = true;
        } 
        {
            newScrollX = left;
            clampedX = true;
        } 
        boolean clampedY = false;
        {
            newScrollY = bottom;
            clampedY = true;
        } 
        {
            newScrollY = top;
            clampedY = true;
        } 
        onOverScrolled(newScrollX, newScrollY, clampedX, clampedY);
        addTaint(deltaX);
        addTaint(deltaY);
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(scrollRangeX);
        addTaint(scrollRangeY);
        addTaint(maxOverScrollX);
        addTaint(maxOverScrollY);
        addTaint(isTouchEvent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490830188 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490830188;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.901 -0400", hash_original_method = "4CE95B84751ED417CECEABF7E9F1BBA1", hash_generated_method = "F8EFF254F7D42120039BE2F323D4218D")
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        
        addTaint(scrollX);
        addTaint(scrollY);
        addTaint(clampedX);
        addTaint(clampedY);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.901 -0400", hash_original_method = "89CDC9D85B7569FFDF89FB6E096C8833", hash_generated_method = "FE070E7096D4C1759019BFEBD640DAE0")
    public int getOverScrollMode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614408459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614408459;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.903 -0400", hash_original_method = "D7A7F397651806FFF8FA254EEF23303B", hash_generated_method = "69A208CEAB0A2C4781F6242469E9A6A4")
    public void setOverScrollMode(int overScrollMode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid overscroll mode " + overScrollMode);
        } 
        mOverScrollMode = overScrollMode;
        
        
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.903 -0400", hash_original_method = "9CF1D38E8E376FF50D8C64A9F9733663", hash_generated_method = "9A611D2CAD1AAE1B43CC6E39114E8835")
    protected float getVerticalScrollFactor() {
        {
            TypedValue outValue = new TypedValue();
            {
                boolean var0AC7698B51F94BDA888C18D716FEABFB_1060796127 = (!mContext.getTheme().resolveAttribute(
                    com.android.internal.R.attr.listPreferredItemHeight, outValue, true));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "Expected theme to define listPreferredItemHeight.");
                } 
            } 
            mVerticalScrollFactor = outValue.getDimension(
                    mContext.getResources().getDisplayMetrics());
        } 
        float var546ADE640B6EDFBC8A086EF31347E768_1010695903 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1010695903;
        
        
            
            
                    
                
                        
            
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.904 -0400", hash_original_method = "E54E00038FC64298D390BA41C98DC1D8", hash_generated_method = "14C665025CA959625AD2B586530E5815")
    protected float getHorizontalScrollFactor() {
        float varB4E039AD370F52FF248539199AD3C0AB_604144725 = (getVerticalScrollFactor());
        float var546ADE640B6EDFBC8A086EF31347E768_1129285298 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1129285298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.904 -0400", hash_original_method = "66C84E939C2024746D4813377EE28DA8", hash_generated_method = "402B5BB6E63BAB99CEDAC8CDC1BCD3E9")
    public int getTextDirection() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137403697 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137403697;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.904 -0400", hash_original_method = "A0414376D9ECFBC599F5D349FFC72987", hash_generated_method = "DD1E7770572FD6A2FE8582C6C9B18489")
    public void setTextDirection(int textDirection) {
        {
            mTextDirection = textDirection;
            resetResolvedTextDirection();
            requestLayout();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.905 -0400", hash_original_method = "99501F3EA14EF54863B388ACFA67B227", hash_generated_method = "C4C20F57C7270013EA97D2268EEB77FB")
    public int getResolvedTextDirection() {
        {
            resolveTextDirection();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992143185 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992143185;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.905 -0400", hash_original_method = "DF8FC39519D36B1AC7371F6D87C199FC", hash_generated_method = "D6167440D0E281A5592F1E06303EA124")
    protected void resolveTextDirection() {
        {
            mResolvedTextDirection = mTextDirection;
        } 
        {
            mResolvedTextDirection = ((ViewGroup) mParent).getResolvedTextDirection();
        } 
        mResolvedTextDirection = TEXT_DIRECTION_FIRST_STRONG;
        
        
            
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.906 -0400", hash_original_method = "BB79EF6AB24983F71C49AA466BBC15FC", hash_generated_method = "7309B27E3B8E0EA585A6CF1593E51E30")
    protected void resetResolvedTextDirection() {
        mResolvedTextDirection = TEXT_DIRECTION_INHERIT;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.906 -0400", hash_original_method = "AF21ED671E180E70DBE0B7255059F75E", hash_generated_method = "9A6BA26B98FE57B58A6B05E019D06035")
    public void hackTurnOffWindowResizeAnim(boolean off) {
        mAttachInfo.mTurnOffWindowResizeAnim = off;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.906 -0400", hash_original_method = "E195CA02B57C3CA07D3D00B98A2A4177", hash_generated_method = "AE723DC79AD9CD9148072DE28571D395")
    public ViewPropertyAnimator animate() {
        ViewPropertyAnimator varB4EAC82CA7396A68D541C85D26508E83_1291575520 = null; 
        {
            mAnimator = new ViewPropertyAnimator(this);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1291575520 = mAnimator;
        varB4EAC82CA7396A68D541C85D26508E83_1291575520.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1291575520;
        
        
            
        
        
    }

    
    static class TransformationInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "01A5A714698019F46F7B3BE18D3A81EF", hash_generated_field = "D632FEE6EB1660D61E8B851D372C57FD")

        private final Matrix mMatrix = new Matrix();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "892FD7717D9FE700C26A99B107E83D2D", hash_generated_field = "5F11E3B225AB20CA6908F99BD2DCCD69")

        private Matrix mInverseMatrix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "E6AF1B5575F48589B11F67F181886D00", hash_generated_field = "39319A786965FE4B527A01145F904472")

        boolean mMatrixDirty = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "DFB8A8C1AC71929285F6E9C21422BD39", hash_generated_field = "0D5DDC0830CE5F8AD2A6C72FEF2EE898")

        private boolean mInverseMatrixDirty = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "91D62B45A9A6983F3FF66229817A7939", hash_generated_field = "067E11491097A23D40918282A928EBA9")

        private boolean mMatrixIsIdentity = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "114805850A4BFF346FD6EAF00216606F", hash_generated_field = "EDD47554C3CEE3D946B262053B454BFB")

        private Camera mCamera = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "CC31A142BE3901700F0A5BABD448641D", hash_generated_field = "19CC34893873FBEA96612C704706273A")

        private Matrix matrix3D = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "0E1D00ACFA6A3EE1137A1995B4598449", hash_generated_field = "888097DA3FEAC04F59E84914FC3B299F")

        private int mPrevWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "B16CB4E01E2F0EC3C3D762413BCFA3EA", hash_generated_field = "3F17D196FD1B71E4E9A79484B73B3DC2")

        private int mPrevHeight = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "8461EF13A0961B85C57153ADEACDA2AF", hash_generated_field = "5BFF8D9CD2F407BBEC3BAA9D3113E814")

        @ViewDebug.ExportedProperty float mRotationY = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "91D13B8ABAABE76FB1A1DB257483240D", hash_generated_field = "1773CD64DE2B81950EEC26683C7BFC12")

        @ViewDebug.ExportedProperty float mRotationX = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "3EA2C3E9FA82D448BC8E393E6731068D", hash_generated_field = "CBCF8195E197871A173AFD82B249BEE8")

        @ViewDebug.ExportedProperty float mRotation = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "FC3C2A4E393ED24A270EF0FBD816080B", hash_generated_field = "7E653D53DDF7B3176405F85A676F9E8E")

        @ViewDebug.ExportedProperty float mTranslationX = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "48CC9A3909395E2C748DF341969B13EE", hash_generated_field = "477946415FF37E50D7898E1A45EA53F2")

        @ViewDebug.ExportedProperty float mTranslationY = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "76B60FCE9805D699B1614259B56C0AB4", hash_generated_field = "39698B539B591C7643D57DD23054914D")

        @ViewDebug.ExportedProperty float mScaleX = 1f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "63BF484C692B6E739EBA4C830C8776F0", hash_generated_field = "37E347D4565A795C12A91CA0C0BB20C1")

        @ViewDebug.ExportedProperty float mScaleY = 1f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "64048540B5D91324BCD1C40B4709FFB9", hash_generated_field = "C294D047888DF6C232DB6BC89AB6C1DE")

        @ViewDebug.ExportedProperty float mPivotX = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "802D68E29E0889774E6BCE439C574FF3", hash_generated_field = "65227B6A59140FE7F7093243C8409FD1")

        @ViewDebug.ExportedProperty float mPivotY = 0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "14E45EEE3993C8F9A0BE01602FD0F58C", hash_generated_field = "3F07B4C8BDBAF8B8C3DFBAA769694247")

        @ViewDebug.ExportedProperty float mAlpha = 1f;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_method = "047CC1B263AEE84E056E34E366D57D72", hash_generated_method = "047CC1B263AEE84E056E34E366D57D72")
        public TransformationInfo ()
        {
            
        }


    }


    
    static class ListenerInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "5EDF09010D7E466461FD8808B8CD4E69", hash_generated_field = "E3E0A2AA3DAD3D497FEC69653B249F3D")

        protected OnFocusChangeListener mOnFocusChangeListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "80A99C2B2F1995E5AD3272A74B10D327", hash_generated_field = "3E61511956959B716B0660A267A5DDB6")

        private ArrayList<OnLayoutChangeListener> mOnLayoutChangeListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "0929A78505E1C2FDC3DC86E818DAF2F7", hash_generated_field = "7FB9E86C55D3FC29D5ABA87F653B7F5E")

        private CopyOnWriteArrayList<OnAttachStateChangeListener> mOnAttachStateChangeListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "AA894545820F13D1E6598CEEF475CCC9", hash_generated_field = "65DB77DAF20E9BC1F7135E1B0259ED25")

        public OnClickListener mOnClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "1F048D1AF1E6F6E42591AF652558180F", hash_generated_field = "5EAF3560EF7F9BB7565DBDF37FE7A2AA")

        protected OnLongClickListener mOnLongClickListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "6996D732079774CBDC0064D12CA733BA", hash_generated_field = "ADA44730A1380CB9786AA8F8DC39301D")

        protected OnCreateContextMenuListener mOnCreateContextMenuListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "2A4FF7110738976278729426D6DBEF1F", hash_generated_field = "E9EAFA3F5F183CD7232E888DAC035728")

        private OnKeyListener mOnKeyListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "E3CF51F249FF4488CF47961A962A84DF", hash_generated_field = "538D6DAEFDEDFC1E31809D314A35E30B")

        private OnTouchListener mOnTouchListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "3DD3E58D944D15D906FC81C9FFCDF4EB", hash_generated_field = "9960EE08CE022E6057B016EBE9068862")

        private OnHoverListener mOnHoverListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "1E80FECA9E68B33E73223CA0C1DB09A3", hash_generated_field = "6F0FC6D93F2673180702A6C98E43EB3F")

        private OnGenericMotionListener mOnGenericMotionListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "F02B5B95401314D0E43EFCAB5D8909E7", hash_generated_field = "BB6976B05A50BD6226C5F3224361BE75")

        private OnDragListener mOnDragListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_field = "99F78B64D05DD39CB96527A5F31D1B1F", hash_generated_field = "BCD3219BF0AB6E6E91E075D0ABDA8C97")

        private OnSystemUiVisibilityChangeListener mOnSystemUiVisibilityChangeListener;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.907 -0400", hash_original_method = "30D31F497118E5B2F2D60734B7298038", hash_generated_method = "30D31F497118E5B2F2D60734B7298038")
        public ListenerInfo ()
        {
            
        }


    }


    
    public static class DragShadowBuilder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.908 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "08E85E83D778EC246746E6855B21BE82")

        private WeakReference<View> mView;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.908 -0400", hash_original_method = "0B0DC4A9FB3A9C12A7904682E22ADAD8", hash_generated_method = "1DC795717C9F5A625AFA7215FE485718")
        public  DragShadowBuilder(View view) {
            mView = new WeakReference<View>(view);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.908 -0400", hash_original_method = "39157EB374747DFD28056DCE3D5D84EC", hash_generated_method = "1653C54FAA06D8A2D8309AF09F1D8648")
        public  DragShadowBuilder() {
            mView = new WeakReference<View>(null);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.909 -0400", hash_original_method = "12EFA38B650211F3F0DA583E081C360F", hash_generated_method = "47A851C86C1E0367F5BB64490814DD10")
        @SuppressWarnings({"JavadocReference"})
        final public View getView() {
            View varB4EAC82CA7396A68D541C85D26508E83_1673883687 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1673883687 = mView.get();
            varB4EAC82CA7396A68D541C85D26508E83_1673883687.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1673883687;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.910 -0400", hash_original_method = "7C575AFDC5B7223F530AD0DF57B52E75", hash_generated_method = "D6A565C09A3ED59B188D99E4B0AF9DFC")
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            
            final View view = mView.get();
            {
                shadowSize.set(view.getWidth(), view.getHeight());
                shadowTouchPoint.set(shadowSize.x / 2, shadowSize.y / 2);
            } 
            addTaint(shadowSize.getTaint());
            addTaint(shadowTouchPoint.getTaint());
            
            
            
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.910 -0400", hash_original_method = "F5A2B90321F064D0A4C62262ED411079", hash_generated_method = "5324124C3D622B8B69D2598EE93A2BE0")
        public void onDrawShadow(Canvas canvas) {
            
            final View view = mView.get();
            {
                view.draw(canvas);
            } 
            addTaint(canvas.getTaint());
            
            
            
                
            
                
            
        }

        
    }


    
    public static class MeasureSpec {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.910 -0400", hash_original_method = "2EA619F0F89BA048B9092F3C9EFB9775", hash_generated_method = "2EA619F0F89BA048B9092F3C9EFB9775")
        public MeasureSpec ()
        {
            
        }


                public static int makeMeasureSpec(int size, int mode) {
            return size + mode;
        }

        
                public static int getMode(int measureSpec) {
            return (measureSpec & MODE_MASK);
        }

        
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.911 -0400", hash_original_field = "2765924A26051A383644CD53D86A0033", hash_generated_field = "7E13FB3629EDD21F2BB56B2286490FD6")

        private static final int MODE_SHIFT = 30;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.912 -0400", hash_original_field = "52AD9C81A7DF8D66D374004C50CC933D", hash_generated_field = "528C4AF1BEE1BC62589DFB30A7C1B2F3")

        private static final int MODE_MASK = 0x3 << MODE_SHIFT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.912 -0400", hash_original_field = "3E92AA0FE7738A8CA58BD3891BC70636", hash_generated_field = "A67A5415D6CD099BE0676E65CF93997F")

        public static final int UNSPECIFIED = 0 << MODE_SHIFT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.912 -0400", hash_original_field = "28026BF47C29664BEB4B773976B4D4D7", hash_generated_field = "89B436B79BB9AD4BDF272AC596A5C764")

        public static final int EXACTLY     = 1 << MODE_SHIFT;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.912 -0400", hash_original_field = "0920EC621B50E1BCDC08E0162D119463", hash_generated_field = "29BD87BC74A43396432B999614D66E82")

        public static final int AT_MOST     = 2 << MODE_SHIFT;
    }


    
    class CheckForLongPress implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.912 -0400", hash_original_field = "FECF4FD7C8A3DE72E8F25B320193017C", hash_generated_field = "440C867B7432C58C78CA96D4BD4198E7")

        private int mOriginalWindowAttachCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.912 -0400", hash_original_method = "C4F936F21A8F70C0274337932B924B19", hash_generated_method = "C4F936F21A8F70C0274337932B924B19")
        public CheckForLongPress ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.913 -0400", hash_original_method = "01CD5F3DDC5391038879A6F141003B2C", hash_generated_method = "A29B6CAC7B49284CB6F55D94B6A55736")
        public void run() {
            {
                boolean varFB827A206CA2F483F96FD1D1A0A39D9F_1162210059 = (isPressed() && (mParent != null)
                    && mOriginalWindowAttachCount == mWindowAttachCount);
                {
                    {
                        boolean var9620ED46504D3117149539056E35032D_1577522130 = (performLongClick());
                        {
                            mHasPerformedLongPress = true;
                        } 
                    } 
                } 
            } 
            
            
                    
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.914 -0400", hash_original_method = "52714AB9B90C75C7141A8D07DDC0C4CA", hash_generated_method = "AB01C47E8931054C927C8BF677A5865E")
        public void rememberWindowAttachCount() {
            mOriginalWindowAttachCount = mWindowAttachCount;
            
            
        }

        
    }


    
    private final class CheckForTap implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.914 -0400", hash_original_method = "AB5DEBF7CC7D6BE3A48A21837827B410", hash_generated_method = "AB5DEBF7CC7D6BE3A48A21837827B410")
        public CheckForTap ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.914 -0400", hash_original_method = "8B4AC781B811E80364C995C3750D80D8", hash_generated_method = "AB19EB04DF28937B1DF516E63AC74EFA")
        public void run() {
            mPrivateFlags &= ~PREPRESSED;
            mPrivateFlags |= PRESSED;
            refreshDrawableState();
            checkForLongClick(ViewConfiguration.getTapTimeout());
            
            
            
            
            
        }

        
    }


    
    private final class PerformClick implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.915 -0400", hash_original_method = "88B4BB962521E66182F1BC580E9EB222", hash_generated_method = "88B4BB962521E66182F1BC580E9EB222")
        public PerformClick ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.915 -0400", hash_original_method = "566460B544C528A9D4CEF77A7D21BD20", hash_generated_method = "6E0C9FA1A1110473D753CE2E91D91FD7")
        public void run() {
            performClick();
            
            
        }

        
    }


    
    private final class UnsetPressedState implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.915 -0400", hash_original_method = "6C14B43BA30389F098070D93AD09F5B4", hash_generated_method = "6C14B43BA30389F098070D93AD09F5B4")
        public UnsetPressedState ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.915 -0400", hash_original_method = "8ADFD7FB5655235FFF1C14FE5EF3EDC3", hash_generated_method = "51E5C56E0FC59533122E120E30019564")
        public void run() {
            setPressed(false);
            
            
        }

        
    }


    
    public static class BaseSavedState extends AbsSavedState {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.916 -0400", hash_original_method = "0710B1BECA4AE2A64DE9C58BFD4A1161", hash_generated_method = "EE939DE64E4E13C6649033F638632686")
        public  BaseSavedState(Parcel source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_method = "C61013DFD638DC996F3EF4CC52F40C74", hash_generated_method = "E01D93B6DF9621DF15B2FA6FE9F6F642")
        public  BaseSavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "F69D27D6C01716FC1482B26F47E53A23", hash_generated_field = "1603EC57FF7A24DE0B9CE75D44794F2A")

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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "380F2E6581760A76AE57EA2F3E243A67")

        IWindowSession mSession;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "B4A12BFD7130A50D27FFF405887EA83D")

        IWindow mWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "2C6E9C841DFC028F3BFE93152F5069A6", hash_generated_field = "794F056D6C296F490A191063CBE7D73B")

        IBinder mWindowToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "560034CC43D7EBF06318F6BD9836E171", hash_generated_field = "D9C5224ACF349426CF4E47DACA6240CF")

        Callbacks mRootCallbacks;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "0512EB3F1C233A640787AA69FB3C6BC3", hash_generated_field = "CDD863CC905A95D66D4F1A2915FF3C29")

        HardwareCanvas mHardwareCanvas;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "03503F4E2878305C59038D192AB3AC15", hash_generated_field = "6D0C26C611FBD233667A9FA9104CED21")

        View mRootView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "53546B13F3B3308728C0CD603626602C", hash_generated_field = "942BE5BD2F034C6C8D3F0E7C02B28BE8")

        IBinder mPanelParentWindowToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "76C3E3B9188F3B101287AE8BD0308DA5", hash_generated_field = "718CD3BE0BDD64302FC8F6AC61AA9980")

        Surface mSurface;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "6AB4A5F453379ED66BAA79CE64FDFD98", hash_generated_field = "68B6EC09532005E80B3FF968D0432D9B")

        boolean mHardwareAccelerated;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "53166A41533AEFA4A0E24E658361324F", hash_generated_field = "74EE98E39C4C179E4AA66BC509EA4A56")

        boolean mHardwareAccelerationRequested;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "8B3DB6BF4469C5CF02B1DDD03F5B6055", hash_generated_field = "D13B4D472586A36E031009AA64FCFC65")

        HardwareRenderer mHardwareRenderer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "BA56BB6DE53CE1621F0CD780B0B7B006", hash_generated_field = "D30A01C9AA1020553FD9B357D21DBD2D")

        float mApplicationScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "7C5648CE63D60A3EFBF527D9F67B890F", hash_generated_field = "491DD861F0499CC9AE05718FA07FF84E")

        boolean mScalingRequired;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "A67458ADF8F3C4889CE90A27B584015A", hash_generated_field = "463612CF0072B2D91F7638B2CC4F4779")

        boolean mTurnOffWindowResizeAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "EAF515EB51AE996EDE42F4E5B627AD5E", hash_generated_field = "027A7FFA44C832AF6DBE17CAF301CFD3")

        int mWindowLeft;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "0F58D99361211F88A00F2836CB54C580", hash_generated_field = "2CCD3F58E4022E0E51EBBEE7A97CEEC6")

        int mWindowTop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "07DA16BCBAA87C3CB8254BCB048BC847", hash_generated_field = "1E46B60B1C8864BF9327E726C9FC6A9D")

        boolean mUse32BitDrawingCache;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "5E83131046575CE08F0EE6BB5ECA21AF", hash_generated_field = "7E3E0CF71C5FF5FEFC1FCFE669E40B4A")

        final Rect mContentInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "CDCC88BCD1FA2B6E7E3A22E8D09269CC", hash_generated_field = "74237CDD8A53EAC9CF0433F0AD4D3E35")

        final Rect mVisibleInsets = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "B9C1A8313191AF75B3FDD14AE8272BBF", hash_generated_field = "8A62AD277EFE6A58E30A5F0CEE7CACEB")

        final ViewTreeObserver.InternalInsetsInfo mGivenInternalInsets = new ViewTreeObserver.InternalInsetsInfo();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "19E9C980D069B1B740AB2CC0BC312416", hash_generated_field = "345FD42085C843C83F8EDE4F1834FEE6")

        final ArrayList<View> mScrollContainers = new ArrayList<View>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "D89222A2A8F942CB3BB02A6B7C95EB1C", hash_generated_field = "FFF6B9F57874D80592FB8DD373F3C84C")

        final KeyEvent.DispatcherState mKeyDispatchState = new KeyEvent.DispatcherState();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "057FC6CF6E6C2229CBCF27ECD410FEE9", hash_generated_field = "A03D646FF0D655946847407BDB557086")

        boolean mHasWindowFocus;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "9DB03FBC1019FA899D003FDB9C62771D", hash_generated_field = "3A96D9774881A4202AEE797B3EE3C1D7")

        int mWindowVisibility;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "993AB8FD817B53B283DAECCB59F45A16", hash_generated_field = "28D76E2182EF97A430A42D24DED52D44")

        long mDrawingTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "431974CC97F96D1DF9B4087E57810191", hash_generated_field = "37B2655ADC8B3B21EEDE7EC8BFE1453D")

        boolean mIgnoreDirtyState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "6C8B75CB378D7E6E081C4786CF1119C4", hash_generated_field = "E92F335BE2D9512E3DDCA1603BFA0A77")

        boolean mSetIgnoreDirtyState = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "8AA89BDDF6ED14A8B3486A6AC69598E8", hash_generated_field = "24BF563E82E7B3377EAF3AE738C5792F")

        boolean mInTouchMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "C60259BC6FCF33DB61A1381FA9E441E6", hash_generated_field = "E29840F7AED8F4EF12BD623D6B7943B5")

        boolean mRecomputeGlobalAttributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "20C86703DA01BC32FBE3795085CE94E7", hash_generated_field = "D34584B0CD3D73B43FC67A71CBBCEDA5")

        boolean mForceReportNewAttributes;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "18D19E1FD7B728605825EF18061C519E", hash_generated_field = "3FE2095DEBDC328EDDA9F609AE6396C1")

        boolean mKeepScreenOn;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "D03AF504A7FB8D1F39097D83B42BDFFD", hash_generated_field = "BA594DC97B7780A916BA2DC51EC8AB28")

        int mSystemUiVisibility;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "AE823141C20BCF628969BBCA7EBCC5B2", hash_generated_field = "DE4F434008ACCD754FC4F174AA6749F2")

        boolean mHasSystemUiListeners;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "C364A0DEF59116677330BF528B9D4525", hash_generated_field = "880659755C401DC1FD279B3CDCEB5013")

        boolean mViewVisibilityChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.917 -0400", hash_original_field = "578BCFB5A4EF012FBD6B92643DCE1C39", hash_generated_field = "EC57C8BF7094A89AF638ACD00871F015")

        boolean mViewScrollChanged;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "9686DBE15950AE62BFE7FE798270EC39", hash_generated_field = "E13EF288A8359A2A0BBA668D58D91954")

        final int[] mTransparentLocation = new int[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "EE057DEB82EEF457E13733F3DEDC0B17", hash_generated_field = "2D1B002DD69D7601933D9317EA67321A")

        final int[] mInvalidateChildLocation = new int[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "00AA4723378DFABB790D518F5A26D40E", hash_generated_field = "9464421AA3AA82093FBCB7CDAFC0B825")

        final float[] mTmpTransformLocation = new float[2];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "58CDF2679DDF2A5B177BCDC3A6E7BA17", hash_generated_field = "722D3D966A44E5DB85CE72D6A92EFD09")

        final ViewTreeObserver mTreeObserver = new ViewTreeObserver();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "B27B52DEE91FF1260919C0152F8A3F5A", hash_generated_field = "D8DB47E921EE865182E76421C432A14B")

        Canvas mCanvas;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

        Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "EBC79DD6C9AD45ACA6AB5072C3340A8B", hash_generated_field = "588DE05706C2848B18EFBA5AB5C7B09C")

        final Rect mTmpInvalRect = new Rect();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "A9C4430F886F001DD9A9AF970C3078A8", hash_generated_field = "F7AE129955F14FB825DEC531D93514BF")

        final RectF mTmpTransformRect = new RectF();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "2251E9E672C5A755A127E5EF1B510FD8", hash_generated_field = "5A9A000DB49C0CEED945C8004A36E778")

        final ArrayList<View> mFocusablesTempList = new ArrayList<View>(24);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "F4C54CBDEE3AB8CB436DCB41CB5AF49E", hash_generated_field = "2E729681C5CD99C66AC4181B19223EFE")

        int mAccessibilityWindowId = View.NO_ID;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_method = "0CDE5ADA82BD9455683884E38A135C3D", hash_generated_method = "48395FA4C7CA9BF9A79558648C28309A")
          AttachInfo(IWindowSession session, IWindow window,
                Handler handler, Callbacks effectPlayer) {
            mSession = session;
            mWindow = window;
            mWindowToken = window.asBinder();
            mHandler = handler;
            mRootCallbacks = effectPlayer;
            
            
            
            
            
            
        }

        
        static class InvalidateInfo implements Poolable<InvalidateInfo> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "E9AD1A72A0CA1F1648249A15490614B6")

            private InvalidateInfo mNext;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "224D05F4261498DA1D9DF38424832532", hash_generated_field = "BD952C5DD2D86B34B4D5F4AFE196E837")

            private boolean mIsPooled;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "42AEFBAE01D2DFD981F7DA7D823D689E", hash_generated_field = "4A3D67FC5D08B2108A5D942762FE7F37")

            View target;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "811882FECD5C7618D7099EBBD39EA254", hash_generated_field = "F8DAB7F926CD7972429F7B948D9F5533")

            int left;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "B28354B543375BFA94DABAEDA722927F", hash_generated_field = "9620536E5A5D6E12CC93092A5EBB857E")

            int top;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "7C4F29407893C334A6CB7A87BF045C0D", hash_generated_field = "49C6BE2EEC7270CFEAEFBD796F2C423B")

            int right;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_field = "71F262D796BED1AB30E8A2D5A8DDEE6F", hash_generated_field = "7F74B1869951CB3A6660AA746710A714")

            int bottom;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.918 -0400", hash_original_method = "7F8409C46E15AE6EC7087A7F4E97E2BF", hash_generated_method = "7F8409C46E15AE6EC7087A7F4E97E2BF")
            public InvalidateInfo ()
            {
                
            }


            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.919 -0400", hash_original_method = "AAFC70DDA5FB82CEF5E58C1F01C303B7", hash_generated_method = "F6E2001C60EDD672A67B8BFFD0EA80B4")
            public void setNextPoolable(InvalidateInfo element) {
                mNext = element;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.920 -0400", hash_original_method = "8D8571C3CBC87318B5EA7A031BC44388", hash_generated_method = "7C9A6C181B169C7D8772CB09725CC47A")
            public InvalidateInfo getNextPoolable() {
                InvalidateInfo varB4EAC82CA7396A68D541C85D26508E83_1961906637 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1961906637 = mNext;
                varB4EAC82CA7396A68D541C85D26508E83_1961906637.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1961906637;
                
                
            }

            
                        static InvalidateInfo acquire() {
                return sPool.acquire();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.921 -0400", hash_original_method = "8830525D8149BF52E4AE797FF2AC88D3", hash_generated_method = "E9DF48B1A3244CDF3D09900CA1C3DD95")
             void release() {
                sPool.release(this);
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.921 -0400", hash_original_method = "4CB4F04617162A1F2BEBBAC63163A5FB", hash_generated_method = "9AA13F271DA147DE197D2240DBC45638")
            public boolean isPooled() {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708403066 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_708403066;
                
                
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_method = "CCE0492C3FBB65D8A1644633FE9AA3DF", hash_generated_method = "31CEC37D69D770078DC2E4A0F4797B2A")
            public void setPooled(boolean isPooled) {
                mIsPooled = isPooled;
                
                
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "39F2AAED9AA054FDE5289F88EBF184A3", hash_generated_field = "B2FFB1CA44DC2BFD07F60AEC442C51E3")

            private static final int POOL_LIMIT = 10;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "A44E5FD188239AC11EA0848B9AD6048D", hash_generated_field = "67EB9377321F551D15C7ACB3DE2B7448")

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
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "D23B25F3A767CD848A78CCBE0431BFF8", hash_generated_field = "8A0661C8B0A6976975978FE86693F94C")

        static final int INVALIDATE_MSG = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "83760A1BB0DB99F124FB0ACBE07D9D1C", hash_generated_field = "F72E4284C0ED2AE67CE51BE3A94EBA52")

        static final int INVALIDATE_RECT_MSG = 0x2;
    }


    
    private static class ScrollabilityCache implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "36CF4BED2347A59BA24D1080B4773D94", hash_generated_field = "C6A1369EC898F10B405072E1D6B6F8F1")

        public boolean fadeScrollBars;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "6F6698AC7C7E3B95006C569A10C73321", hash_generated_field = "1655F035B56E41B8BE16E5CF56B77BA2")

        public int fadingEdgeLength;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "82987CB0DFB57EF0D7E6071CBAEED976", hash_generated_field = "0B6D856A35EB0627FF7887D758165295")

        public int scrollBarDefaultDelayBeforeFade;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.922 -0400", hash_original_field = "F330F5B1F62629DE00AA6130936F3A51", hash_generated_field = "E863540FC8628DCB2E031D759E080999")

        public int scrollBarFadeDuration;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "16D99E080DA3394608D0C10D69303259", hash_generated_field = "83B1C5317C031D0AB20405882919848B")

        public int scrollBarSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "5D1F5486649A4BAD621B1C4B13A5092E", hash_generated_field = "C08FDE67EA8E9E077C57F9B7B9A2DF77")

        public ScrollBarDrawable scrollBar;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "4CCF1E17C0001A4A25316D33537A790B", hash_generated_field = "CB96A972AA75A47BFD6582D710EC82DF")

        public float[] interpolatorValues;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "56B8BC9706D6E065A7599937E8F804CC")

        public View host;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "C1940AEEB9693A02E28C52EB85CE261C", hash_generated_field = "7AA4ED035C35711F4B33B0135B4A7789")

        public Paint paint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "21B72C0B7ADC5C7B4A50FFCB90D92DD6", hash_generated_field = "2ED3478F7527E1ECF1A41F8EA29E0792")

        public Matrix matrix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "842E3E5FE6C1B834705ABD4BCB213342", hash_generated_field = "BD5E2F7CC0958EF9E9784897D7D71294")

        public Shader shader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "9171F43D541F940B89A7FB26C6794AE8", hash_generated_field = "38B61C924838E45A7FCDE7AF77E8755E")

        public final Interpolator scrollBarInterpolator = new Interpolator(1, 2);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "83ADDA5FC3DEE395042A82E7A1746419", hash_generated_field = "FA7A925863D78B977D2FC3469F1DC9E9")

        public long fadeStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "60A253603933185CFAB4CA7DE20B9E69", hash_generated_field = "41AF84CAED377B81AC74E102DF2E9D6D")

        public int state = OFF;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.923 -0400", hash_original_field = "F62531BE971FA5E1FC4011E8E61EFD62", hash_generated_field = "AC03B4B52C8DAA90037D992009D92CB0")

        private int mLastColor;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.925 -0400", hash_original_method = "AB4B2D8281C9D79EC8FB184A37CE88FD", hash_generated_method = "05F8FAC0C3110F2BB5070A90BB23F048")
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
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_method = "96C29AC8476B3BD548A01E55E35CBC04", hash_generated_method = "0CE02932C57478EA22B2478361CDDFCF")
        public void setFadeColor(int color) {
            {
                mLastColor = color;
                color |= 0xFF000000;
                shader = new LinearGradient(0, 0, 0, 1, color | 0xFF000000,
                        color & 0x00FFFFFF, Shader.TileMode.CLAMP);
                paint.setShader(shader);
                paint.setXfermode(null);
            } 
            
            
                
                
                
                        
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_method = "14A33F30726B3AE59CE909C1A535F2F0", hash_generated_method = "33B6ECBD848CDB101F26409B95CE7BD9")
        public void run() {
            long now = AnimationUtils.currentAnimationTimeMillis();
            {
                int nextFrame = (int) now;
                int framesCount = 0;
                Interpolator interpolator = scrollBarInterpolator;
                interpolator.setKeyFrame(framesCount++, nextFrame, OPAQUE);
                nextFrame += scrollBarFadeDuration;
                interpolator.setKeyFrame(framesCount, nextFrame, TRANSPARENT);
                state = FADING;
                host.invalidate(true);
            } 
            
            
            
                
                
                
                
                
                
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_field = "5A25F59FDD7EADE938232D542AC9DF31", hash_generated_field = "7C2FCAABFF0839BC46F5A1C3AF188D77")

        public static final int OFF = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_field = "D4174A52FA4F808F71BC2954FF2D0727", hash_generated_field = "4AEC3247A48615FF5865CC0B1A3C7705")

        public static final int ON = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_field = "EC0311F896B24AC1A92AD2C030F6530B", hash_generated_field = "656FDD706C20A529B22AC373F45EB16E")

        public static final int FADING = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_field = "AE0BB3ACA40F6E07B62845DE2F1E0641", hash_generated_field = "C6ECC8F0B0BA37B0E970AFED1D0BFB91")

        private static final float[] OPAQUE = { 255 };
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_field = "128E3645098B3255219073257445D573", hash_generated_field = "52ECE7CD9B5C9B08E7595DC0D955B8C4")

        private static final float[] TRANSPARENT = { 0.0f };
    }


    
    private class SendViewScrolledAccessibilityEvent implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.926 -0400", hash_original_field = "AD12063E8FC163523FAE892D8D8BEA2B", hash_generated_field = "8E5087238AE27D181E6487D7D8E8CADB")

        public volatile boolean mIsPending;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.927 -0400", hash_original_method = "67D827D7B507D3EF133C26B0E057ECB2", hash_generated_method = "67D827D7B507D3EF133C26B0E057ECB2")
        public SendViewScrolledAccessibilityEvent ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.927 -0400", hash_original_method = "13F513362861425D1A8D234F009B3F81", hash_generated_method = "53A034A606164AD076ADC134C6992AE7")
        public void run() {
            sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_SCROLLED);
            mIsPending = false;
            
            
            
        }

        
    }


    
    public static class AccessibilityDelegate {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.927 -0400", hash_original_method = "B81C1E38B66B1195ED1D00E194D402D3", hash_generated_method = "B81C1E38B66B1195ED1D00E194D402D3")
        public AccessibilityDelegate ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.927 -0400", hash_original_method = "BC0125D947E50318963E057CA3B612F3", hash_generated_method = "11B9A1B40697495580EE81AD22F7F373")
        public void sendAccessibilityEvent(View host, int eventType) {
            host.sendAccessibilityEventInternal(eventType);
            addTaint(host.getTaint());
            addTaint(eventType);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.928 -0400", hash_original_method = "C58028C1DB413A86B928F475AB0100FB", hash_generated_method = "F977BB689C0D190F9BB723A8F0E63AF2")
        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            host.sendAccessibilityEventUncheckedInternal(event);
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.928 -0400", hash_original_method = "5A39804E8EC5B74D862B80B866B8F576", hash_generated_method = "8B8B6D03000ABF9CE2AC250FF8C56A12")
        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            boolean var07851A778B664A4380C5AF2DDC5C4AEC_783904235 = (host.dispatchPopulateAccessibilityEventInternal(event));
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432390447 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_432390447;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.929 -0400", hash_original_method = "D41C8BE91A25AAE323FB25E37AFB61F0", hash_generated_method = "8BD8A02C2629352DFDDE1159CA67BC87")
        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            
            host.onPopulateAccessibilityEventInternal(event);
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.929 -0400", hash_original_method = "D490954174BD599BC02D1199D955E569", hash_generated_method = "3B81173127E6A60F360915F54C4470BC")
        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            
            host.onInitializeAccessibilityEventInternal(event);
            addTaint(host.getTaint());
            addTaint(event.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.929 -0400", hash_original_method = "E392CA582CA236DC9AD11007B17CF1A9", hash_generated_method = "6019E578184B08E640FCA5EA063DDEF4")
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            
            host.onInitializeAccessibilityNodeInfoInternal(info);
            addTaint(host.getTaint());
            addTaint(info.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_method = "4AE2346D08FE5ECB588C47045A997DF1", hash_generated_method = "8C9DB4F03F6EB840E12C44A7030D30AC")
        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child,
                AccessibilityEvent event) {
            
            boolean var9559FB15F4F4402574377E5F8741F1FA_1018296432 = (host.onRequestSendAccessibilityEventInternal(child, event));
            addTaint(host.getTaint());
            addTaint(child.getTaint());
            addTaint(event.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113801352 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113801352;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "B21E54ADF6F1EC7B79C6C1AE44FBD181", hash_generated_field = "728AEBF400875BC43623925282C27543")

    protected static final String VIEW_LOG_TAG = "View";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "88123DE8DF5143F6086D0A4BB7B00CB8", hash_generated_field = "181E1190C48C3A15B723E1972525FFE6")

    public static final int NO_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "CFE01EBDF16FDABBC2834404C207239C", hash_generated_field = "01F44804D4B2E5BAA321A3D08FADF1E0")

    private static final int NOT_FOCUSABLE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "0AD9E0CCD4B721DF1CC94B96EC4D5898", hash_generated_field = "B60F2F3FD613AE8F66EF43CAEDBD3D6A")

    private static final int FOCUSABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "719E9855B3D953E2EE9987A580012D6B", hash_generated_field = "4A7BFB7B79B1D1A27F3C6D27933C451E")

    private static final int FOCUSABLE_MASK = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "6FB94F3D7A7CDF037678C662A9689D7D", hash_generated_field = "BF038E8C825175307230C582E611F852")

    private static final int FITS_SYSTEM_WINDOWS = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "136D41ED3DF9DD9EF3A9A81DADD58165", hash_generated_field = "829F05479D332281B757C73E71A7184A")

    public static final int VISIBLE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "0DA34D083070BE2C2BFC30813441B002", hash_generated_field = "24C25C40295AD2D0D5F7C693CBE8FFEE")

    public static final int INVISIBLE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "E019C9B7503AD69082F721EC41DE4F50", hash_generated_field = "DADE7E47CBB0DBC6ACF868046DED7DE3")

    public static final int GONE = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "638A50E778AE3706DD0D02F81C3A69AB", hash_generated_field = "46DC4CB49B4B1C753E9EF0933116882A")

    static final int VISIBILITY_MASK = 0x0000000C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "B46EF765402AAEC87B7D8B6CB93C354D", hash_generated_field = "F0ED5F92DDC8DA6B5C7B1F0EC92787C9")

    private static final int[] VISIBILITY_FLAGS = {VISIBLE, INVISIBLE, GONE};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "943A232E38D580886D6006ECC118446C", hash_generated_field = "E946149DFEA69D0B6E9AC928D5226811")

    static final int ENABLED = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "C0CCF30A42F7B85896FEB21D5D80087A", hash_generated_field = "5038EB1B1BDDC780ECAFF35A7312B00D")

    static final int DISABLED = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "09EBD9C5DC9B7133964216D0458D4EB5", hash_generated_field = "FF7AB53A5D2F6D9583260DBE04CE70E5")

    static final int ENABLED_MASK = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "223956AEDC09AE3486F61724D9FE32DF", hash_generated_field = "D9E91EE0E33950072C99789F48286A11")

    static final int WILL_NOT_DRAW = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "72902DCD9DEC9AD627AE18B829F03F6C", hash_generated_field = "8224E5760520AD61AA5C786E772EE5EC")

    static final int DRAW_MASK = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "C0E5737567CB3157DA185632001CA225", hash_generated_field = "269F3C1F1CB4BA6EE4598627F04279FD")

    static final int SCROLLBARS_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "8D26450D077C1E00326EA645922486EF", hash_generated_field = "84D26661F3B38DB7E15F3E6C3E59DCB6")

    static final int SCROLLBARS_HORIZONTAL = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "BAA86D9ECDBE9A3AEEAC46D1513B3AF6", hash_generated_field = "0CF016AFAC1CE3FE718CD07BD8D5C506")

    static final int SCROLLBARS_VERTICAL = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "AEDA673F22AC5A75D39DAD07ACEB90E6", hash_generated_field = "C7EB856B5222623AEFC3E1FE97CAEEFC")

    static final int SCROLLBARS_MASK = 0x00000300;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "73E0703DA900EFA90928C97AE715BC6D", hash_generated_field = "5BD75921BC796BD559A68AD91D052366")

    static final int FILTER_TOUCHES_WHEN_OBSCURED = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "D24F1A8E6549666B005031D398FEE558", hash_generated_field = "75E0E7DA45FF4A99E2ED6F15A7B537D2")

    static final int FADING_EDGE_NONE = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.930 -0400", hash_original_field = "3A7A261ACE5B30ECA9279C1BE5DE1696", hash_generated_field = "8AB4B1AA261BDC35537908CB321B1983")

    static final int FADING_EDGE_HORIZONTAL = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "EEC6CF3A171DE7EDA9EC195460F15A88", hash_generated_field = "D9D649DC317847AAD19E64C3E113BBC4")

    static final int FADING_EDGE_VERTICAL = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "18F27278FD3AAB92633A835806666397", hash_generated_field = "B35A040391A4C00443C19C2995B90AB0")

    static final int FADING_EDGE_MASK = 0x00003000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "45B15C364F25251A3C127619E90B5F7F", hash_generated_field = "8E82BA9946E5FC8217E2D093C0DEE86F")

    static final int CLICKABLE = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "51A3AB9F876C508B5C1D05DB9E1A930D", hash_generated_field = "D5C8DBBB19A01A4ADC1CFC3DF56604DE")

    static final int DRAWING_CACHE_ENABLED = 0x00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "D8742CC8D1D72215607E7D4AC10BC8C0", hash_generated_field = "58220690B3964939EFD247679F6DBB16")

    static final int SAVE_DISABLED = 0x000010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "A75506DA371A486D311CDD4D029A330E", hash_generated_field = "1AF7B603B206D36BAFEFE71A2856456F")

    static final int SAVE_DISABLED_MASK = 0x000010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "A6FA078274716D518128E150581D2851", hash_generated_field = "51995E9C673CBAC6019B76C649BEC0DE")

    static final int WILL_NOT_CACHE_DRAWING = 0x000020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "E03A3305D740CA16331145E801848E22", hash_generated_field = "469110FE5469C37A921A47B3637A87F0")

    static final int FOCUSABLE_IN_TOUCH_MODE = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "FA3A1555CC434AC18D966F00D2423C82", hash_generated_field = "00C745D591E053E355D9F95CAA502483")

    public static final int DRAWING_CACHE_QUALITY_LOW = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "1C715F9A3E4D054995D7540181249A42", hash_generated_field = "5C1456CB937D24EC2357B82160B57D70")

    public static final int DRAWING_CACHE_QUALITY_HIGH = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "4AF63F90FCB3729D33ED8E285AF2B74E", hash_generated_field = "1F818F030504ADAB1788120175C0B1E5")

    public static final int DRAWING_CACHE_QUALITY_AUTO = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "3207B6651A0BF5F174E5CAF999AB8905", hash_generated_field = "7060269E37AC69A7EAA5771D16F0390B")

    private static final int[] DRAWING_CACHE_QUALITY_FLAGS = {
            DRAWING_CACHE_QUALITY_AUTO, DRAWING_CACHE_QUALITY_LOW, DRAWING_CACHE_QUALITY_HIGH
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "510EB04A8874ADFC53C33C3DB0F22789", hash_generated_field = "CDA2F575CC8014BF1E2BB36F24BF1F1A")

    static final int DRAWING_CACHE_QUALITY_MASK = 0x00180000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "B2686CD8BA58915A28F18A2290D383B1", hash_generated_field = "22F50F883FF6C25DC52493F220C9ABB8")

    static final int LONG_CLICKABLE = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "6F25A9D7ED2043A0A5C3D937F4EE60B0", hash_generated_field = "B27AFB8C724A77CC01C8FE3AAC770306")

    static final int DUPLICATE_PARENT_STATE = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "2747E2837D818C6355EE71D69B9684B7", hash_generated_field = "3942DDD065BFB4D5847FE6C074D13B8C")

    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "234F4C5DCDC5DE24A3652BD6011D93D9", hash_generated_field = "99D8798FCB61EE70472EB6CEB2B1D2BD")

    public static final int SCROLLBARS_INSIDE_INSET = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "ED751E830351C6E99A81725F83CA320D", hash_generated_field = "26082E7DF00E5D63F0836B2C3593B9A1")

    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "98278E487E36D61B5EFF4EB199CD5F66", hash_generated_field = "8D486D5878BEE68EEDFC2466A5593564")

    public static final int SCROLLBARS_OUTSIDE_INSET = 0x03000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "C9838B952BE0085ABBD5F18638048C95", hash_generated_field = "8A31E0CDC781D04365F399522A814CD5")

    static final int SCROLLBARS_INSET_MASK = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "FB72F7534C13B44CC119CFC03DC847EA", hash_generated_field = "70944B9F44919B5C2B302411CDD199D0")

    static final int SCROLLBARS_OUTSIDE_MASK = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "237A29BBCB2DB13E041F3DA844444538", hash_generated_field = "129B7C59D8FDD7BACE6ECE8C3BBCA0AB")

    static final int SCROLLBARS_STYLE_MASK = 0x03000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "5A93B62D57F19F1248E061B9DF6D4586", hash_generated_field = "026A7CCCB8A871DB74312537DD84B5CB")

    public static final int KEEP_SCREEN_ON = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "EBF2D0C0B786CD060B5AE41494DA59C6", hash_generated_field = "65C2782715263C009044AB84624A4EB2")

    public static final int SOUND_EFFECTS_ENABLED = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "1078F74C572D9516578E7FA7289C750A", hash_generated_field = "104909D35DACCE7A451CA8A4158F790C")

    public static final int HAPTIC_FEEDBACK_ENABLED = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "F23DDA0E5F90CEFBF8B46DBA0BCB190F", hash_generated_field = "571D760F29262F82EDAAA90E822EBAF8")

    static final int PARENT_SAVE_DISABLED = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "6B97792AE6AB5644826FC2B8CA55EA66", hash_generated_field = "D47B48591230EE766F208E58DC2093F4")

    static final int PARENT_SAVE_DISABLED_MASK = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "042290192ED37463656C62A299DCD56C", hash_generated_field = "A688099F9FE53C57D5410ECB0B78ECF6")

    public static final int LAYOUT_DIRECTION_LTR = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "D50A627E81AC5EE86F73722012E61B2A", hash_generated_field = "1E680499F28E2DB403E520F9B378996F")

    public static final int LAYOUT_DIRECTION_RTL = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "A405E7709C580A39852B4DEBD01E0B25", hash_generated_field = "3C8F75DD79F0631A6C45E4E961B35BE6")

    public static final int LAYOUT_DIRECTION_INHERIT = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "352E9691543D117A79FEE50BA922BA21", hash_generated_field = "309700780AC169B61849F35A862B3E65")

    public static final int LAYOUT_DIRECTION_LOCALE = 0xC0000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "62FB84FF84367768D9A8010C1DE8DFE5", hash_generated_field = "6FE5303D659D6470BE6AE1DC66925B88")

    static final int LAYOUT_DIRECTION_MASK = 0xC0000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "45F3ED7F85CB672108B49A6F1CBFF483", hash_generated_field = "2B195F9D5574504A59136591EF21764E")

    private static final int[] LAYOUT_DIRECTION_FLAGS = {LAYOUT_DIRECTION_LTR,
        LAYOUT_DIRECTION_RTL, LAYOUT_DIRECTION_INHERIT, LAYOUT_DIRECTION_LOCALE};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "A4258B7D410E3ABEA2DAED93E7FC2DBF", hash_generated_field = "0FF5069567EECE1EABD2593046037335")

    private static final int LAYOUT_DIRECTION_DEFAULT = LAYOUT_DIRECTION_INHERIT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "60991A843680A700D8903D1037CD1027", hash_generated_field = "4E5D1049C9EF75861592546EF88DBF53")

    public static final int FOCUSABLES_ALL = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "75B8D0D830284C8413D9475FE15DED7B", hash_generated_field = "FDC3A4AE8FBDEDEDFB25081E70F0EAFA")

    public static final int FOCUSABLES_TOUCH_MODE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "16EA4D0DF6A96534ED21707D0DC9D7D1", hash_generated_field = "169DA3FC15889071D72206CA09A960FA")

    public static final int FOCUS_BACKWARD = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "6FAD780F10ED98A64C11256A4F65B843", hash_generated_field = "4B7B29E11785A4D3C7319284FE29BB61")

    public static final int FOCUS_FORWARD = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "3748FE498607ED50B4BEA594F402D00E", hash_generated_field = "936F919E08FC8B9F1C931D6E632F8DE0")

    public static final int FOCUS_LEFT = 0x00000011;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "8C5862526CF4B48EEE48CD48164CF908", hash_generated_field = "E877EF3790B7F3E0F15FFC2846DA5A4A")

    public static final int FOCUS_UP = 0x00000021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "7836E0401589D48A18437C3C00FB92B1", hash_generated_field = "8A54B461A03C16A38D0974EA5435F806")

    public static final int FOCUS_RIGHT = 0x00000042;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.931 -0400", hash_original_field = "DA9FCEAFDE994E9275E734E38EC26AF2", hash_generated_field = "32373BABA82126482CBABBE76E9F36D3")

    public static final int FOCUS_DOWN = 0x00000082;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "7C5B34C3F66563DEDF69054B4573D7A0", hash_generated_field = "3584CE2038396D56F00CBCE4E0AF47E7")

    public static final int MEASURED_SIZE_MASK = 0x00ffffff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "26BC6B4F75C09AA87725780145BF0053", hash_generated_field = "874FE93B404AA4B2617E7E2F47B091CC")

    public static final int MEASURED_STATE_MASK = 0xff000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "BEAD869C6CD87263DD66EA8E7F53CAB5", hash_generated_field = "859653BE0AACCFF2DA07F4D6CA30948B")

    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "58C4E838736B52712EDDA9AADE5146ED", hash_generated_field = "499640E6C451DA0A8A056EE1F14203E6")

    public static final int MEASURED_STATE_TOO_SMALL = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "51B7591E0F578681A0C2EE5DA47C2D4E", hash_generated_field = "A60706A950ABFA6787DAFE2333D1D63E")

    protected static int[] EMPTY_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "1487025A5AB6A88FEACB03AB7990FFA5", hash_generated_field = "99443560A8BB02795565A31C7E7FF7B1")

    protected static int[] ENABLED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "7263334C9DDB4A7D666B1C3DD61A0C6A", hash_generated_field = "11C8381528C7451EAC51D425793F56C2")

    protected static int[] FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "E33DADA1965FE739883D993B5AA18F9F", hash_generated_field = "3A452259C52C53C1EFB914A335939407")

    protected static int[] SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "88939EA751CCCC7A7DB0509EA010F6DA", hash_generated_field = "1150481E1245BD4252FBDD6D8BF7F65F")

    protected static int[] PRESSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "2E3E59175269A05F91C5A19CB85A694E", hash_generated_field = "8E5DAB90AC5DCA5817D14D9B6C547303")

    protected static int[] WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "6C90D4BB8E9AC1B71CDEEBC3645B2780", hash_generated_field = "7288DEFD6843DAD9B8306502492E9853")

    protected static int[] ENABLED_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "0BA64AB46B8FBDF51E936CAF79AD944B", hash_generated_field = "26F780CD73153C56C935B863B7CA60FA")

    protected static int[] ENABLED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "77BE7752F47EB351E50B3E41073FEC4B", hash_generated_field = "4E4EEFF45753D32998559D55A6EF44B8")

    protected static int[] ENABLED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "A25D57A9D8267C415AE05F818FF6AC5E", hash_generated_field = "E4F27C2333C782D6E4D173DE3B06BF18")

    protected static int[] FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "919907B0612F6254887EB3E97A22BF9C", hash_generated_field = "89F4391F6DDF155A225E114339942430")

    protected static int[] FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "611D21495AB54356BC2E7665025343B3", hash_generated_field = "94022B56BE402F58E4270EB350792883")

    protected static int[] SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "4B146E73AB4ADACFAAF2647A8B055DF1", hash_generated_field = "15E50E4B54201BE1BE6EB6674087A2FF")

    protected static int[] ENABLED_FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "8262D29B4D0A9F17177FD6254B2D3930", hash_generated_field = "FDA0C2E170F0F36949DABE497139E672")

    protected static int[] ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "FBD49E3069AD0761FCFAD89ED56531BE", hash_generated_field = "7B5D9A889C2FFA9A561E0EA4250EBE37")

    protected static int[] ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "26E63DE2BE2B46BFEBC5C441C4D6E1F9", hash_generated_field = "C7506CCBA97AA185D5649A7B40AB28D9")

    protected static int[] FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "BE4CEC84B4BE8BFFB0455DE22E885108", hash_generated_field = "21701468D299EEF2E6314D17CDA4A09B")

    protected static int[] ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "9A1FBDAD10063482B7658C13B8A0B02F", hash_generated_field = "F8383F641270D614B30774F08FA72D27")

    protected static int[] PRESSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "4B4B3833D917124D356E8A05CEE57412", hash_generated_field = "D26868EDEAAF82B3EF5953C4049C5BF8")

    protected static int[] PRESSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "945046E9CCAB02225F85C9AEF80FD0F1", hash_generated_field = "DB8F785F4FD804A28291B083216F3C9E")

    protected static int[] PRESSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "32DFD335BE0EC6D93B8CB7E154077B5A", hash_generated_field = "FF997AEB254DFD2B8E8AF4DC32EF1D31")

    protected static int[] PRESSED_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "BC1A2C878ED403A3DC4AB16C2C5236C4", hash_generated_field = "B219816DBAFB4C4AE58A96AEE6F32010")

    protected static int[] PRESSED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "10128D4A007A2E3A355578602006E698", hash_generated_field = "EB888E73506F6FA9D225D7A6FC4285F7")

    protected static int[] PRESSED_FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "13BF55722C5919CC13ABB211D7D8FC34", hash_generated_field = "DA91E046B143C9258573479BFD455473")

    protected static int[] PRESSED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "EEBB047B97E6CC005B66BB4DF8F94E74", hash_generated_field = "47A198E35052CA7F982234E83E6AE0B5")

    protected static int[] PRESSED_ENABLED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "8EA96FD8BA37E8726D3FF37428005A84", hash_generated_field = "1241C342AD96CD3177F39E12E55B08A1")

    protected static int[] PRESSED_ENABLED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "D7F5B6940CEB03AF4DB7C638C8DB86C9", hash_generated_field = "B8447E4F384C40AC956314579E0EC168")

    protected static int[] PRESSED_ENABLED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "CD5B9CAE61BF5681D131974B48D45F35", hash_generated_field = "F3A6207F343FCB93F7AD3D66BE9819DE")

    protected static int[] PRESSED_ENABLED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "2B786A01E298E73EF07DF178EFA649DE", hash_generated_field = "92A36B4EAE93002927F999631B9F3F0B")

    protected static int[] PRESSED_ENABLED_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "8C8090C7CEA34E704C4D34265493EFB7", hash_generated_field = "95A751D33F39D2426A2D5C87AED66425")

    protected static int[] PRESSED_ENABLED_FOCUSED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "EB47BA02ACDC4579D77D7F37C47E607B", hash_generated_field = "7FA35EC1F5140E40D7F86CA44E6DBA3D")

    protected static int[] PRESSED_ENABLED_FOCUSED_SELECTED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "D944FE429EDF53CE63EEC14D8093A840", hash_generated_field = "74D8BB51BDEF099D4EDB19D4AB388E56")

    protected static int[] PRESSED_ENABLED_FOCUSED_SELECTED_WINDOW_FOCUSED_STATE_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "7CACA492F8EB04441960954CE8E31F4E", hash_generated_field = "07E5728FFC69B34D451F1FFD96A500DE")

    private static int[][] VIEW_STATE_SETS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "840023F54AE77F6B7CB6EA057A29345F", hash_generated_field = "14A9EEAFA20652E17C004627513442D3")

    static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "30BF9633946B236206204B1B228F9B4E", hash_generated_field = "8F5DACC3E931BB6D45970C3D4F236044")

    static final int VIEW_STATE_SELECTED = 1 << 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.932 -0400", hash_original_field = "13F309EA19E97FDCAB0F34A82B513727", hash_generated_field = "3BDE49CD992A557C6BC150E37203E374")

    static final int VIEW_STATE_FOCUSED = 1 << 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "3DBC2F54FADC09E29BF1B8FBBEA3FB0D", hash_generated_field = "FF062786656E19CBE9DF873C32B837B4")

    static final int VIEW_STATE_ENABLED = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "73B0F4C3283212372DB4AD900092822F", hash_generated_field = "42D0A243D87878B393907AB494DF9D6F")

    static final int VIEW_STATE_PRESSED = 1 << 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "76ECEEDE7E2BE2C35DBAF0A9660EF84E", hash_generated_field = "6C91EA09E2C90C1DF3101479368CB380")

    static final int VIEW_STATE_ACTIVATED = 1 << 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "B0A3894D2E7A8DECC31DDF557084056F", hash_generated_field = "9EC9B10B5927E85F8F05CFFD3E1BCB7D")

    static final int VIEW_STATE_ACCELERATED = 1 << 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "CD5EC9C04D78EAE85439A49EE43548B7", hash_generated_field = "E89AF08FD103519565D8ACE924E0CCDE")

    static final int VIEW_STATE_HOVERED = 1 << 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "7963B56E34789A515DD35DC186470423", hash_generated_field = "1D4DC52F9C46700D3A32C0B94E81EC4A")

    static final int VIEW_STATE_DRAG_CAN_ACCEPT = 1 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "1D0657EAA0C99CDDC29972AFF5927F66", hash_generated_field = "622438F15831E9532B4F4DDFC41CF098")

    static final int VIEW_STATE_DRAG_HOVERED = 1 << 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "F0FE506AC7CE0271C963DE2DFB2246CA", hash_generated_field = "AAC5495A62AC6D4ACFA4E56618BD582F")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "BC732632754162FEA3F07CEB5C7D8AE4", hash_generated_field = "09FD46ADE03A21840451EFC738B1A7A7")

    private static final int POPULATING_ACCESSIBILITY_EVENT_TYPES = AccessibilityEvent.TYPE_VIEW_CLICKED
            | AccessibilityEvent.TYPE_VIEW_LONG_CLICKED
            | AccessibilityEvent.TYPE_VIEW_SELECTED
            | AccessibilityEvent.TYPE_VIEW_FOCUSED
            | AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            | AccessibilityEvent.TYPE_VIEW_HOVER_ENTER
            | AccessibilityEvent.TYPE_VIEW_HOVER_EXIT
            | AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED
            | AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "E3D3FC8D07AB0B919D55A05D03BD2DDA", hash_generated_field = "684181D325E3591F0B7AAD06CC900A68")

    static final ThreadLocal<Rect> sThreadLocal = new ThreadLocal<Rect>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "D7DE0ACE26DFCBFA81B727E7D697D6DC", hash_generated_field = "7D4D749E981D95615D6EBF2D704DB8B6")

    private static int sNextAccessibilityViewId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "500117F1360ECD0E2A1C758A384C6BDE", hash_generated_field = "324935551C98559798BFC98BC88D0E16")

    static final int WANTS_FOCUS = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "83B85F39C701A1CD9E8E850630AFB73D", hash_generated_field = "76144A0AFA07456ADF5BD6C61EFDD82A")

    static final int FOCUSED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "AEFAC5139B1F408F0396832810DBCEB7", hash_generated_field = "B8FCBDDA4AC19831AC8F95B5E299A019")

    static final int SELECTED = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "96DF4F8FC6E2AD4704C5C57F486C62A7", hash_generated_field = "40E315525D7E3F79CE6749FA5486016E")

    static final int IS_ROOT_NAMESPACE = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "CA7D68B3A5540FFD5359787C666DB078", hash_generated_field = "A57A7453C08B33D43AA0903652335D6B")

    static final int HAS_BOUNDS = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "ACA3CC4C13B40B8ECB3C6210C98DFCA5", hash_generated_field = "9EF7FA33897722D87B0F3A6B600D5E81")

    static final int DRAWN = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "3FB0E221E190E60E340F7D7FED25A8A9", hash_generated_field = "9DE5C056A7D09D1D07F14977B6558968")

    static final int DRAW_ANIMATION = 0x00000040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "A949A8DDF17378D569923BDB3BD3CE4D", hash_generated_field = "60FF926409B2F5933B181900B19AAC45")

    static final int SKIP_DRAW = 0x00000080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "7DEECFEEC7611D16BD2F9A3756FA2BB1", hash_generated_field = "42E39DC4A1F2A24AE76342261ED67462")

    static final int ONLY_DRAWS_BACKGROUND = 0x00000100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "2A62805F3B4B271B6D733C06F3A3786F", hash_generated_field = "6FDF9B9C295413E46CD84B530D99A3CC")

    static final int REQUEST_TRANSPARENT_REGIONS = 0x00000200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "7A69759A1E34A3948363D6F2AD631B39", hash_generated_field = "23439B38EE9E7C6C702D63C4F1ED384A")

    static final int DRAWABLE_STATE_DIRTY = 0x00000400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "6C0298510DAE034B4A70716048ADE945", hash_generated_field = "02DFB1F097A0748DE08336A975D45816")

    static final int MEASURED_DIMENSION_SET = 0x00000800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "6A440126BB00967A51CCB88DAACD1292", hash_generated_field = "945693F86F0A771A9EC4BD547C7EA2C6")

    static final int FORCE_LAYOUT = 0x00001000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "4FEA9D60E4244C5452CD42C4851D13F1", hash_generated_field = "138A2DA084E8C20D234F0FD286F24C09")

    static final int LAYOUT_REQUIRED = 0x00002000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "3B39792FDAC39DE65F7ED2FD34A515EA", hash_generated_field = "A32BF712F0570B663C9C802C05CF1890")

    private static final int PRESSED = 0x00004000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.933 -0400", hash_original_field = "CA4B0F471AC38326CCE490FE95DD9DBF", hash_generated_field = "6A22DCE014F56DCE137CB587120D93F9")

    static final int DRAWING_CACHE_VALID = 0x00008000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "C008718263AEA3F654A7431B2FEE1AE0", hash_generated_field = "042862CB0ADBC6B3E35B81806CA38E37")

    static final int ANIMATION_STARTED = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "520300B25E15DC461FC807E3DDE2EC9D", hash_generated_field = "BA4D09564EB1E0038BBEC9BC2D384011")

    private static final int SAVE_STATE_CALLED = 0x00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "7A9B464E0EC754E6120D11506C660E74", hash_generated_field = "2ADF228F56CBDA6B09A2A154F6926EFA")

    static final int ALPHA_SET = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "F2642ABC015872B1D18A10BA26436F68", hash_generated_field = "44E3C961B99F63E3A07CB003A0CA4B9B")

    static final int SCROLL_CONTAINER = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "77FD38926931873CE64CCCD9AAA636EE", hash_generated_field = "FBC3A0FBB44FEC222F3F4C8C1E04A345")

    static final int SCROLL_CONTAINER_ADDED = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "D12AE92211483CEAE28211A899954171", hash_generated_field = "96ADCAB4A37B8BB124ECD80E384642EA")

    static final int DIRTY = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "90A4B5DC715FC521F95E6BF53938EA44", hash_generated_field = "96FBB855B8A08D7EDC96EFCEC1705F07")

    static final int DIRTY_OPAQUE = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "FE623C860E0D6689B3FAA8DCFDE2DA83", hash_generated_field = "E59459A965FA6E2D0EE74CC520B7969C")

    static final int DIRTY_MASK = 0x00600000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "AD218DA12A70673BD9767DB67BAE40E2", hash_generated_field = "B74861256F94749BBD076F0EE1BB6697")

    static final int OPAQUE_BACKGROUND = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "152E9A4D03C0868595B1B3A98EC5DD59", hash_generated_field = "CB076E5ABDBD6D2DB2CAA68F9BBF25B9")

    static final int OPAQUE_SCROLLBARS = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "1FF0D2CB4E21A22B233B4091B7F3EA7A", hash_generated_field = "26BE9A5B6506A9A205564B56496E86A7")

    static final int OPAQUE_MASK = 0x01800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "F344EC503BD86AEEBCFDAC09D95E8E68", hash_generated_field = "9B3764730F327DBBF2A2D3CD5D565A0E")

    private static final int PREPRESSED = 0x02000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "89B3AE233E472F6B44029C702E7C3F9D", hash_generated_field = "9B73CB25776C9F2B49E35CE827A563CB")

    static final int CANCEL_NEXT_UP_EVENT = 0x04000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "36D406F449B7F4F8631F62229F52A4AA", hash_generated_field = "8A59740EC03CDB8433058BC75E6CC2DF")

    private static final int AWAKEN_SCROLL_BARS_ON_ATTACH = 0x08000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "682EFAC34FCD91477D1163FC4F0544CA", hash_generated_field = "5A4D1B7B954FE6E9DB7211EC1037FB16")

    private static final int HOVERED = 0x10000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "311BEC00A2A57CF70925B2CB9CFA061F", hash_generated_field = "B9DEE496A6C9D6738C4CCD97A0FFC329")

    private static final int PIVOT_EXPLICITLY_SET = 0x20000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "9E6EB47515D35AE672239BCA100D80B5", hash_generated_field = "E7C6D1F67DF39F2566312582F97AA88E")

    static final int ACTIVATED = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "38FB36FF33AF5682C9A3C817ACE91449", hash_generated_field = "0A4C84F7E1053F2B7F2C1216C1B89639")

    static final int INVALIDATED = 0x80000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "7A41027FA0D80172C61A63E1749F8522", hash_generated_field = "1E3191E90B3292678814CED4910ECCB3")

    static final int DRAG_CAN_ACCEPT = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "3AB4DF7D76BF92F0AF881CE9B561B121", hash_generated_field = "0A71D3250F076CE3F2CA33F0AFEA1360")

    static final int DRAG_HOVERED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "F115C5B400B4AD33E411E3D853951590", hash_generated_field = "533431F61C3E776BF1DC4F0C19BFFFBE")

    static final int LAYOUT_DIRECTION_RESOLVED_RTL = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "E38A74D27FDCCB03C2FA1DF706DB289B", hash_generated_field = "EB582E7E7DEA8F1CBFEE72038956E0BA")

    static final int LAYOUT_DIRECTION_RESOLVED = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "3C7B642C2343EB20487AA2B5D199EA6B", hash_generated_field = "DE17281667B863CA7CEAE6DA8567A548")

    static final int DRAG_MASK = DRAG_CAN_ACCEPT | DRAG_HOVERED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "7EB0B2502005C4CB40D46FF10A6B736D", hash_generated_field = "8F276B4C86F06142AEDE0C97A7FE2F68")

    public static final int OVER_SCROLL_ALWAYS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "67D34493973359A97A217AD3B17DA6CF", hash_generated_field = "218BFE0FF46A804B55589DCE0FFD7D0A")

    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "E1779A27D7E8D7DB9FBA34E6E8D0F4A8", hash_generated_field = "009B55485034BF3BF55F8691DA9788F7")

    public static final int OVER_SCROLL_NEVER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "BF7D37DAD8E455C992BC7E68A0990530", hash_generated_field = "125903A773621693E8ED9CD79E76CEE2")

    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "906B1D91F782CE5AC8B7F0D668A6C3DE", hash_generated_field = "D22EB113F7E463630AC5C1BF53857810")

    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "4F3ABEF5C072D169DE48CFCD8D83ACB3", hash_generated_field = "C08307181AE930BB4EB97AF7E4BA99C2")

    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "5D67A0854A678B7421A5D8EB5EE8C592", hash_generated_field = "E2BDD60871070DE88B6211D48982B8C2")

    public static final int STATUS_BAR_HIDDEN = SYSTEM_UI_FLAG_LOW_PROFILE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "0F4BC827AD7F800E9D5FBFE4091527AC", hash_generated_field = "8B75629E21794DD2B63C2EBB0F5C5651")

    public static final int STATUS_BAR_VISIBLE = SYSTEM_UI_FLAG_VISIBLE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "B8E435BADA682778215DD51A19DF8FFB", hash_generated_field = "B2C2F68118A98B0D9DC29F6548450BB1")

    public static final int STATUS_BAR_DISABLE_EXPAND = 0x00010000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "3C2F21B6325236E297702C891D965A0C", hash_generated_field = "F15A9A270E6E94C57BE4C34A504CA2E4")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ICONS = 0x00020000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "F1CA414B01FED44D125FD7D69B8A2752", hash_generated_field = "A29040D2CCE82CD2248FC7CE5DD6F34C")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_ALERTS = 0x00040000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "7FEF4130863D936A12C0424A654E5D3E", hash_generated_field = "16D9107672695454170019843C771E6E")

    public static final int STATUS_BAR_DISABLE_NOTIFICATION_TICKER = 0x00080000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "C3C38A73496A3D57718587B370F541F7", hash_generated_field = "F95F66DC605FC858FD4E71DFA5C0F9BD")

    public static final int STATUS_BAR_DISABLE_SYSTEM_INFO = 0x00100000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "7E1FCA75C299F4E34A9DD82FD57BBDFD", hash_generated_field = "AAFD5A01803D7358E81163F32EB064CC")

    public static final int STATUS_BAR_DISABLE_HOME = 0x00200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "A35BDA216974994591355F84D3B5274C", hash_generated_field = "E23FAA42E397EEA07B1B79A8F58007E0")

    public static final int STATUS_BAR_DISABLE_BACK = 0x00400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "E9E375135941614B6E6CB8C9E2379A94", hash_generated_field = "DCC7B8B91738A06DD4F62CA9D5735F60")

    public static final int STATUS_BAR_DISABLE_CLOCK = 0x00800000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "5CCE851821E73C19D62138787ABDCA10", hash_generated_field = "CCF974A2E5C1C62EC6B351C6AF50C578")

    public static final int STATUS_BAR_DISABLE_RECENT = 0x01000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "B43FB7EFDEC3382EC0990C0A9E8B271C", hash_generated_field = "0C7A3AEFD08471993D7A4F0326BFA356")

    @Deprecated
    public static final int STATUS_BAR_DISABLE_NAVIGATION = 
            STATUS_BAR_DISABLE_HOME | STATUS_BAR_DISABLE_RECENT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "C1B7F07AFA8039E59BC19145B086410C", hash_generated_field = "C93A2BBD1CA42547C4B5B418761D706E")

    public static final int PUBLIC_STATUS_BAR_VISIBILITY_MASK = 0x0000FFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "C0E867B817C5074EE01AB86DFED8F6C6", hash_generated_field = "9B73CC22DA15165280173F1866272945")

    public static final int SYSTEM_UI_CLEARABLE_FLAGS =
            SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.934 -0400", hash_original_field = "51FF96EA2D2BD34250562D6F671E164F", hash_generated_field = "7B20A663B4D3B5566CC5C719038AA2BA")

    public static final int FIND_VIEWS_WITH_TEXT = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "2EB0F42C98B29EF37AEA628C8410E67D", hash_generated_field = "DC0F2D99F610668CF27C5B6686754038")

    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "311CAB010F7D36E164A93EFE4C4E86BD", hash_generated_field = "861292948F794A707C7A0C135A7073D2")

    private static final float NONZERO_EPSILON = .001f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "C6E278D91B5DF64AC1C4D714250083AB", hash_generated_field = "C08C16CB7F1DD117251F7E01BD2A9C0A")

    public static final int DRAG_FLAG_GLOBAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "16240D771FB90A67263EFE9E2C291DEA", hash_generated_field = "A5FF12741D477D00096166439C6E6A47")

    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "D30F0164D22B00A11A1CCB2B977A764B", hash_generated_field = "DC33B736EF2AA325AA97A5FCD399D9D8")

    public static final int SCROLLBAR_POSITION_LEFT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "3DC6508AD3033900527EC4DB3791E127", hash_generated_field = "3F9EAAC738BDA10511E9A3B6436EF6E3")

    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "96AA91F8A048281129229FD083B1358D", hash_generated_field = "4B71A3CAAC0983C5CC19785C41F5E14C")

    public static final int LAYER_TYPE_NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "DCBB776A50163456B0C217708A748171", hash_generated_field = "9362C41130448D1BEC071BA7F3927A19")

    public static final int LAYER_TYPE_SOFTWARE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "047EE5E7394F65AAAF3F8809914E0CE3", hash_generated_field = "339CEE307F54C01A3C41187443B4553A")

    public static final int LAYER_TYPE_HARDWARE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "7E5F4F35F076DD4A01417879834ED5A8", hash_generated_field = "8B7A964E0E3D6E1CA183DED21E99796E")

    public static final int TEXT_DIRECTION_INHERIT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "C9DC0711FEE92DC0E5A418B930214358", hash_generated_field = "A11F693FD1415D67D865FDE1AE59FAC8")

    public static final int TEXT_DIRECTION_FIRST_STRONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "C0ED02B1DFA8E1E0002994F29FE0DBF1", hash_generated_field = "FE7C3FEA62FE2BEB4EAF36B5581E7BE1")

    public static final int TEXT_DIRECTION_ANY_RTL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "5BAC4FF9879DCA7AFE5C4CA8A82E2F9A", hash_generated_field = "7D98B23250113084506842828EB2DF5B")

    public static final int TEXT_DIRECTION_LTR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "213E189EFF089F8F261EBA1867B24AC5", hash_generated_field = "9D4940C20853BDAD0B50AED80FB5511C")

    public static final int TEXT_DIRECTION_RTL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:57.935 -0400", hash_original_field = "4E44E9C56C5AB65B582CBC8E90D683E3", hash_generated_field = "08FC45D9BA58A3E9219785E4F9BE4255")

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

