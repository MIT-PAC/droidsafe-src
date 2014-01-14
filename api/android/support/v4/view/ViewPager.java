package android.support.v4.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class ViewPager extends ViewGroup {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.217 -0500", hash_original_field = "2080E0DE2E8F8B2A4AA70DD6ED296F7C", hash_generated_field = "8B95FE444EAF04E1B97E79FAA1346818")

    private static final String TAG = "ViewPager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.219 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.221 -0500", hash_original_field = "07458AD7D4B0757961B31F370D0673DD", hash_generated_field = "650AADEFCFDF69CDD5A6A3BFC4ED1A3C")

    private static final boolean USE_CACHE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.224 -0500", hash_original_field = "AB2A28F31760D0A929E502832C06CB98", hash_generated_field = "F1B189E3CF39A86400A3C9B6652580CE")

    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.226 -0500", hash_original_field = "FD9103375029EF0DC7A8FDCD1D959B5C", hash_generated_field = "17654B746B84D905348C1100B6FE7760")

    private static final int MAX_SETTLE_DURATION = 600;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.229 -0500", hash_original_field = "79029D3C1720B31C416C164923A15E7B", hash_generated_field = "57169D2A36D11070C14E490CB3A3EB03")

    private static final int MIN_DISTANCE_FOR_FLING = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.232 -0500", hash_original_field = "6DBF438C7FAC0EBB2AFE33EF164ECAF2", hash_generated_field = "5ADDA5389845FF3454B51DCFE6C8CFF0")

    private static final int[] LAYOUT_ATTRS = new int[] {
        android.R.attr.layout_gravity
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.094 -0400", hash_original_field = "4202665155CA1C6B56FDDCABB0AF2DC1", hash_generated_field = "5E6A95D139D1F8AE27D3F1637C286AA4")

    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.094 -0400", hash_original_method = "E78668ADB8BEA86BCE0E7FA19199ECBB", hash_generated_method = "21DE610755713DA1A41859ACA1CC340A")
        @Override
        public int compare(ItemInfo lhs, ItemInfo rhs) {
            addTaint(lhs.getTaint());
            addTaint(rhs.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276796699 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276796699;
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.096 -0400", hash_original_field = "3DAA3CA73C29E9EEE6C4A07C4D95803A", hash_generated_field = "AAFB3424C4E3B805B840EED16A117C87")

    private static final Interpolator sInterpolator = new Interpolator() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.096 -0400", hash_original_method = "11FE6ADED2EE7422CCA03C14DA065BC8", hash_generated_method = "53761C327FF8A4A7EA67EF20258337B8")
        public float getInterpolation(float t) {
            t -= 1.0f;
            addTaint(t);
            float var546ADE640B6EDFBC8A086EF31347E768_354418954 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_354418954;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.311 -0500", hash_original_field = "394D213079DFA0C7024EC13F5673BC94", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.343 -0500", hash_original_field = "8CE62E9E2648F230973C2673DD6BD007", hash_generated_field = "03E40CFF00BD7BA3937A5499974D60CF")

    public static final int SCROLL_STATE_IDLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.346 -0500", hash_original_field = "6888DA37CE229C0AB3170109AFAD7E3D", hash_generated_field = "E3D77F42F70C954DD577EF87B0640D7E")

    public static final int SCROLL_STATE_DRAGGING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.348 -0500", hash_original_field = "AC55F8408E7A7365F12F8D4DA49F9363", hash_generated_field = "18EEC92BF586A88EFE14E2C9E326DDB9")

    public static final int SCROLL_STATE_SETTLING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.254 -0500", hash_original_field = "A9DCDAB361B83A1131D64FE935E689DF", hash_generated_field = "4DED95E1F9669C7056C2DE4B99A4DA42")

    private final ArrayList<ItemInfo> mItems = new ArrayList<ItemInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.256 -0500", hash_original_field = "BFA89288982B594812D5DAEB6D7FA98B", hash_generated_field = "2A01FA323E66B8B0477D575256463652")

    private PagerAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.258 -0500", hash_original_field = "CA3E40C4FA6B57CF393B20C7059C5EB9", hash_generated_field = "D9FBC86CB22AF6261A48272E212D5541")

    private int mCurItem;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.261 -0500", hash_original_field = "64CCE98C29722D8F17DC91369F4FF4B0", hash_generated_field = "C261E67D50992A5C20799C932967E4BF")

    private int mRestoredCurItem = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.263 -0500", hash_original_field = "FDE886B98EC2F733F8ADA220FCCFCAF5", hash_generated_field = "BAEDBA8C3A0D9CA358A825101480570F")

    private Parcelable mRestoredAdapterState = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.265 -0500", hash_original_field = "93A4495639E4CD1837384CA1138DFA3E", hash_generated_field = "0B3271C0D246AD917F0B2BFC0F1E2284")

    private ClassLoader mRestoredClassLoader = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.267 -0500", hash_original_field = "16226695B3E75E1B75AD8C16FE7698DB", hash_generated_field = "AB39B37744A8B63C82246C1F6FE6730F")

    private Scroller mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.269 -0500", hash_original_field = "B721A625608AE9377CBE464512681092", hash_generated_field = "4DDBCA80DE6A7A07D8A5420B04989903")

    private PagerObserver mObserver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.271 -0500", hash_original_field = "E158EF87FA9CF7006F4D0DC5CEADECD3", hash_generated_field = "B27BEE6220E87E8571B1CC02AEF71A81")

    private int mPageMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.273 -0500", hash_original_field = "144758355132FFB88125D8B4D610751F", hash_generated_field = "5CB8BE965FCEEA70C5D18EEB2C5B06B9")

    private Drawable mMarginDrawable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.275 -0500", hash_original_field = "5B80D7C96C6D5140A952ECD265AA9418", hash_generated_field = "E74EA91BBE0E15AAB285398BC1D9022D")

    private int mTopPageBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.277 -0500", hash_original_field = "6BDCB3F8E8764325845A09AD77C65610", hash_generated_field = "97C090C7D7510B1CAF63827F11C247DB")

    private int mBottomPageBounds;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.279 -0500", hash_original_field = "B8E06EBD93BD4D7001E3C1BC56C937C7", hash_generated_field = "A9185C0052000A85FA411C5586609D44")

    private int mChildWidthMeasureSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.282 -0500", hash_original_field = "55DDDE296A3D5DA98C8D47B619BC621D", hash_generated_field = "AD5DFC102B7E069BD84ECCA774ECA3DA")

    private int mChildHeightMeasureSpec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.284 -0500", hash_original_field = "C7463435817ABA85E5AF0081505BD656", hash_generated_field = "AC8E671E2AA7EEF3EC800FAEB4B3A880")

    private boolean mInLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.286 -0500", hash_original_field = "3BD9FEE95F32C4889FDFAAEB81585604", hash_generated_field = "525C74FB2020779EE8272F7A1D19F1C6")

    private boolean mScrollingCacheEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.288 -0500", hash_original_field = "067C04D4A7AE7EB12E1EEADE97C7AEDA", hash_generated_field = "3615C17B741EA896B2F5EB737A25E37D")

    private boolean mPopulatePending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.291 -0500", hash_original_field = "9A4545912FAAF4935BFDF2CFDFD969B5", hash_generated_field = "FD42EA2408DC7BC099DE88D000A67AD2")

    private boolean mScrolling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.293 -0500", hash_original_field = "1A4B8F6F8BD6B18C9EA9CA56CBDC3D9D", hash_generated_field = "6889C67D111C39C131790ED24D71EAFB")

    private int mOffscreenPageLimit = DEFAULT_OFFSCREEN_PAGES;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.295 -0500", hash_original_field = "73B01D10CAB8E5404C455A1ADEF4EF2A", hash_generated_field = "B59FB434376CFD18468CB8F7DF43173C")

    private boolean mIsBeingDragged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.297 -0500", hash_original_field = "573DD8A411955AA9EB56A5C801B41308", hash_generated_field = "748889273C84B9C9E218E6BFA97C24D2")

    private boolean mIsUnableToDrag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.299 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.301 -0500", hash_original_field = "25CFDFB463A965BC44C22C5B603E6082", hash_generated_field = "E8D995D721D911B655A8BA1B8E85A671")

    private float mInitialMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.303 -0500", hash_original_field = "AF635AE840C182EEA99A9AE862C0C835", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.306 -0500", hash_original_field = "3611C70C88BA02D959402D97DECB16F3", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.308 -0500", hash_original_field = "D0914C40920996908439839B104BE272", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.313 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.315 -0500", hash_original_field = "0DAB51CD5AD14EAFA0DBAE048171A484", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.317 -0500", hash_original_field = "EBB696916B500EA5521AFFF60D013E17", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.319 -0500", hash_original_field = "6AFE62851B4CD5F3F51B3D44765FA926", hash_generated_field = "7F8D995E03C7CD7E0F196759ABA95F5F")

    private int mFlingDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.321 -0500", hash_original_field = "2B86E06655022B6225B6647D6A25B48E", hash_generated_field = "986D52A8EA3DCB2BCCE9B03ACB17651B")

    private boolean mFakeDragging;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.323 -0500", hash_original_field = "4B0DEB2393CBB47F7A7E99064E38CE03", hash_generated_field = "AE83D0D9EE37D7B14D072F1E5F467A1E")

    private long mFakeDragBeginTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.326 -0500", hash_original_field = "C6B872CB47F26D2A00858234EB48A07A", hash_generated_field = "9E249B56B7CAFDEEC5F0C85DF1584FF5")

    private EdgeEffectCompat mLeftEdge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.328 -0500", hash_original_field = "C34162DD2300AAA317FA2597249C37A4", hash_generated_field = "1100A29EE0D913080378CCB73190893C")

    private EdgeEffectCompat mRightEdge;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.330 -0500", hash_original_field = "E8FBC0675E7594A5CB40D0BCA74175A7", hash_generated_field = "D2103C384BE0AB58542D96A0CD23C256")

    private boolean mFirstLayout = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.332 -0500", hash_original_field = "1EE2B1E4B9437065B8EC3242243537D8", hash_generated_field = "0C8F00C2B17489007C5F8140505FF30F")

    private boolean mCalledSuper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.334 -0500", hash_original_field = "5A7177CDAB1546AD3680BA83EFC17DE3", hash_generated_field = "64518C389A512872C2826132B5A07F9F")

    private int mDecorChildCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.337 -0500", hash_original_field = "820FED77D53B87A7AE07F65308286F45", hash_generated_field = "EE99805AC43858C068324B36ED28179F")

    private OnPageChangeListener mOnPageChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.339 -0500", hash_original_field = "5C9611BB22756E6B87889FE4AEFB709E", hash_generated_field = "1F25B0C85CAD75C221F1467E6925256A")

    private OnPageChangeListener mInternalPageChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.341 -0500", hash_original_field = "D04F34891B40293904EAAB321E50D703", hash_generated_field = "2E3B1499B0D138F9C25DFFF849DEACEA")

    private OnAdapterChangeListener mAdapterChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.350 -0500", hash_original_field = "2979B1839AFE8AA021C0414D52BC75DC", hash_generated_field = "1E68982A83C4D0C6AC923C110AE0A857")

    private int mScrollState = SCROLL_STATE_IDLE;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.370 -0500", hash_original_method = "167A05D4ABF68D419B8302604913DA0C", hash_generated_method = "62F3333EA112767F01F430A2A57F2524")
    
public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.372 -0500", hash_original_method = "2DA5D82366012C7A6B734AF18B26B0B4", hash_generated_method = "60A628B9709D77E2B006BAE809F668F9")
    
public ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewPager();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.375 -0500", hash_original_method = "DBB36B523BACF2E8831A0769B3639908", hash_generated_method = "DBB36B523BACF2E8831A0769B3639908")
    
void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setFocusable(true);
        final Context context = getContext();
        mScroller = new Scroller(context, sInterpolator);
        final ViewConfiguration configuration = ViewConfiguration.get(context);
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mLeftEdge = new EdgeEffectCompat(context);
        mRightEdge = new EdgeEffectCompat(context);

        final float density = context.getResources().getDisplayMetrics().density;
        mFlingDistance = (int) (MIN_DISTANCE_FOR_FLING * density);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.377 -0500", hash_original_method = "80EB60C09FE5B35C976F87EEFD89447E", hash_generated_method = "02274259A31687E9BC624C9CDF5151A5")
    
private void setScrollState(int newState) {
        if (mScrollState == newState) {
            return;
        }

        mScrollState = newState;
        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrollStateChanged(newState);
        }
    }

    /**
     * Set a PagerAdapter that will supply views for this pager as needed.
     *
     * @param adapter Adapter to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.380 -0500", hash_original_method = "5B308B647844A5E9AE37DC79927B0D79", hash_generated_method = "7CC96A3CB4AB83B442828C6FD216567F")
    
public void setAdapter(PagerAdapter adapter) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mObserver);
            mAdapter.startUpdate(this);
            for (int i = 0; i < mItems.size(); i++) {
                final ItemInfo ii = mItems.get(i);
                mAdapter.destroyItem(this, ii.position, ii.object);
            }
            mAdapter.finishUpdate(this);
            mItems.clear();
            removeNonDecorViews();
            mCurItem = 0;
            scrollTo(0, 0);
        }

        final PagerAdapter oldAdapter = mAdapter;
        mAdapter = adapter;

        if (mAdapter != null) {
            if (mObserver == null) {
                mObserver = new PagerObserver();
            }
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            if (mRestoredCurItem >= 0) {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } else {
                populate();
            }
        }

        if (mAdapterChangeListener != null && oldAdapter != adapter) {
            mAdapterChangeListener.onAdapterChanged(oldAdapter, adapter);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.382 -0500", hash_original_method = "18421C7E85141EF2E7552011BA442EAC", hash_generated_method = "8A221515DB3CEADBF732AA5B01E19177")
    
private void removeNonDecorViews() {
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if (!lp.isDecor) {
                removeViewAt(i);
                i--;
            }
        }
    }

    /**
     * Retrieve the current adapter supplying pages.
     *
     * @return The currently registered PagerAdapter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.384 -0500", hash_original_method = "F7E052C477B11777DA7EBFEE8452F40F", hash_generated_method = "3DEA33F0B759DE6CB68DD18B15A50E8C")
    
public PagerAdapter getAdapter() {
        return mAdapter;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.386 -0500", hash_original_method = "36FAA41620F55873E46894195D62C0FE", hash_generated_method = "36FAA41620F55873E46894195D62C0FE")
    
void setOnAdapterChangeListener(OnAdapterChangeListener listener) {
        mAdapterChangeListener = listener;
    }

    /**
     * Set the currently selected page. If the ViewPager has already been through its first
     * layout there will be a smooth animated transition between the current item and the
     * specified item.
     *
     * @param item Item index to select
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.388 -0500", hash_original_method = "7A2B970E4C717952A0CD3574FF0FD69D", hash_generated_method = "CAE1F099F051C01C04F4000A5C2C344D")
    
public void setCurrentItem(int item) {
        mPopulatePending = false;
        setCurrentItemInternal(item, !mFirstLayout, false);
    }

    /**
     * Set the currently selected page.
     *
     * @param item Item index to select
     * @param smoothScroll True to smoothly scroll to the new item, false to transition immediately
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.390 -0500", hash_original_method = "F21F60BCB144D38A5AE0B59AB369F197", hash_generated_method = "D8A9430462F114E8441CF903A905C8FD")
    
public void setCurrentItem(int item, boolean smoothScroll) {
        mPopulatePending = false;
        setCurrentItemInternal(item, smoothScroll, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.392 -0500", hash_original_method = "A82ABDE9609B8643904FAA59A05D3729", hash_generated_method = "4EA11EE08D6B462D16A2F7650D7279F1")
    
public int getCurrentItem() {
        return mCurItem;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.396 -0500", hash_original_method = "975AAD75311F294CDFC8362C48B3CCF3", hash_generated_method = "975AAD75311F294CDFC8362C48B3CCF3")
    
void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.398 -0500", hash_original_method = "4CC7A0E676B55FB5E3215627D71CB3FB", hash_generated_method = "93C4D53BA7971D7DDF2253FE4C7E19E6")
    
void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        if (mAdapter == null || mAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!always && mCurItem == item && mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (item < 0) {
            item = 0;
        } else if (item >= mAdapter.getCount()) {
            item = mAdapter.getCount() - 1;
        }
        final int pageLimit = mOffscreenPageLimit;
        if (item > (mCurItem + pageLimit) || item < (mCurItem - pageLimit)) {
            // We are doing a jump by more than one page.  To avoid
            // glitches, we want to keep all current pages in the view
            // until the scroll ends.
            for (int i=0; i<mItems.size(); i++) {
                mItems.get(i).scrolling = true;
            }
        }
        final boolean dispatchSelected = mCurItem != item;
        mCurItem = item;
        populate();
        final int destX = (getWidth() + mPageMargin) * item;
        if (smoothScroll) {
            smoothScrollTo(destX, 0, velocity);
            if (dispatchSelected && mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageSelected(item);
            }
            if (dispatchSelected && mInternalPageChangeListener != null) {
                mInternalPageChangeListener.onPageSelected(item);
            }
        } else {
            if (dispatchSelected && mOnPageChangeListener != null) {
                mOnPageChangeListener.onPageSelected(item);
            }
            if (dispatchSelected && mInternalPageChangeListener != null) {
                mInternalPageChangeListener.onPageSelected(item);
            }
            completeScroll();
            scrollTo(destX, 0);
        }
    }

    /**
     * Set a listener that will be invoked whenever the page changes or is incrementally
     * scrolled. See {@link OnPageChangeListener}.
     *
     * @param listener Listener to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.401 -0500", hash_original_method = "FA06973225A603572F4FD6150255295F", hash_generated_method = "762B37F2C89F375D1EC3189C42594BBE")
    
public void setOnPageChangeListener(OnPageChangeListener listener) {
        mOnPageChangeListener = listener;
    }

    /**
     * Set a separate OnPageChangeListener for internal use by the support library.
     *
     * @param listener Listener to set
     * @return The old listener that was set, if any.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.403 -0500", hash_original_method = "BEC1D9D7EF0862149EE21D17618B274F", hash_generated_method = "BEC1D9D7EF0862149EE21D17618B274F")
    
OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener oldListener = mInternalPageChangeListener;
        mInternalPageChangeListener = listener;
        return oldListener;
    }

    /**
     * Returns the number of pages that will be retained to either side of the
     * current page in the view hierarchy in an idle state. Defaults to 1.
     *
     * @return How many pages will be kept offscreen on either side
     * @see #setOffscreenPageLimit(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.405 -0500", hash_original_method = "3F35BC951292D9FB1DF42BFA6208CE75", hash_generated_method = "D8F32F271B52AE566D1C20E30AC6738C")
    
public int getOffscreenPageLimit() {
        return mOffscreenPageLimit;
    }

    /**
     * Set the number of pages that should be retained to either side of the
     * current page in the view hierarchy in an idle state. Pages beyond this
     * limit will be recreated from the adapter when needed.
     *
     * <p>This is offered as an optimization. If you know in advance the number
     * of pages you will need to support or have lazy-loading mechanisms in place
     * on your pages, tweaking this setting can have benefits in perceived smoothness
     * of paging animations and interaction. If you have a small number of pages (3-4)
     * that you can keep active all at once, less time will be spent in layout for
     * newly created view subtrees as the user pages back and forth.</p>
     *
     * <p>You should keep this limit low, especially if your pages have complex layouts.
     * This setting defaults to 1.</p>
     *
     * @param limit How many pages will be kept offscreen in an idle state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.407 -0500", hash_original_method = "A74A93D6A42C43F22E5B6055DA99B3A5", hash_generated_method = "5723E85FE43E25CE0ABD01861820A705")
    
public void setOffscreenPageLimit(int limit) {
        if (limit < DEFAULT_OFFSCREEN_PAGES) {
            Log.w(TAG, "Requested offscreen page limit " + limit + " too small; defaulting to " +
                    DEFAULT_OFFSCREEN_PAGES);
            limit = DEFAULT_OFFSCREEN_PAGES;
        }
        if (limit != mOffscreenPageLimit) {
            mOffscreenPageLimit = limit;
            populate();
        }
    }

    /**
     * Set the margin between pages.
     *
     * @param marginPixels Distance between adjacent pages in pixels
     * @see #getPageMargin()
     * @see #setPageMarginDrawable(Drawable)
     * @see #setPageMarginDrawable(int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.409 -0500", hash_original_method = "828EEBFA53113FADBEB7FC44B9C61C3C", hash_generated_method = "10C17A9B5820CE43A83EC6E7E79CB8DB")
    
public void setPageMargin(int marginPixels) {
        final int oldMargin = mPageMargin;
        mPageMargin = marginPixels;

        final int width = getWidth();
        recomputeScrollPosition(width, width, marginPixels, oldMargin);

        requestLayout();
    }

    /**
     * Return the margin between pages.
     *
     * @return The size of the margin in pixels
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.412 -0500", hash_original_method = "C374880A4C36BA236EE3B5602129BC09", hash_generated_method = "E10B9B86D6B41AFBE1CFB19470AB0A74")
    
public int getPageMargin() {
        return mPageMargin;
    }

    /**
     * Set a drawable that will be used to fill the margin between pages.
     *
     * @param d Drawable to display between pages
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.414 -0500", hash_original_method = "BA05FEAA10A774C185287C0B628011BB", hash_generated_method = "5F4955C560BC9697A93654DEAAC9E378")
    
public void setPageMarginDrawable(Drawable d) {
        mMarginDrawable = d;
        if (d != null) refreshDrawableState();
        setWillNotDraw(d == null);
        invalidate();
    }

    /**
     * Set a drawable that will be used to fill the margin between pages.
     *
     * @param resId Resource ID of a drawable to display between pages
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.416 -0500", hash_original_method = "194EE6D0EDD674D9D2DE52CA6B5FC234", hash_generated_method = "1BBDE39E4433597F6CF8BB52331AE552")
    
public void setPageMarginDrawable(int resId) {
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.418 -0500", hash_original_method = "5339E87F28FFED611E3042BEB812570C", hash_generated_method = "51C0FB25FCD4C98FFC0503C0E961EA6C")
    
@Override
    protected boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == mMarginDrawable;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.421 -0500", hash_original_method = "D9869A333EE5ABB30D7044AE2CBD85F6", hash_generated_method = "3A57ED623057449209675AC3507B7D4D")
    
@Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable d = mMarginDrawable;
        if (d != null && d.isStateful()) {
            d.setState(getDrawableState());
        }
    }

    // We want the duration of the page snap animation to be influenced by the distance that
    // the screen has to travel, however, we don't want this duration to be effected in a
    // purely linear fashion. Instead, we use this method to moderate the effect that the distance
    // of travel has on the overall snap duration.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.423 -0500", hash_original_method = "3937E06E79A8643FB4C5C1D74E3AE99C", hash_generated_method = "C2D664939EAFCE729E5DD220A9CB71B7")
    
float distanceInfluenceForSnapDuration(float f) {
        f -= 0.5f; // center the values about 0.
        f *= 0.3f * Math.PI / 2.0f;
        return (float) Math.sin(f);
    }

    /**
     * Like {@link View#scrollBy}, but scroll smoothly instead of immediately.
     *
     * @param x the number of pixels to scroll by on the X axis
     * @param y the number of pixels to scroll by on the Y axis
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.425 -0500", hash_original_method = "BC18C642FF487E008261AE9ED73575D8", hash_generated_method = "BC18C642FF487E008261AE9ED73575D8")
    
void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 0);
    }

    /**
     * Like {@link View#scrollBy}, but scroll smoothly instead of immediately.
     *
     * @param x the number of pixels to scroll by on the X axis
     * @param y the number of pixels to scroll by on the Y axis
     * @param velocity the velocity associated with a fling, if applicable. (0 otherwise)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.428 -0500", hash_original_method = "A4DABDC2D7B52B75CD4B2F9017BAC5A7", hash_generated_method = "651592805484A841A5DADC4C78D0455F")
    
void smoothScrollTo(int x, int y, int velocity) {
        if (getChildCount() == 0) {
            // Nothing to do.
            setScrollingCacheEnabled(false);
            return;
        }
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        if (dx == 0 && dy == 0) {
            completeScroll();
            setScrollState(SCROLL_STATE_IDLE);
            return;
        }

        setScrollingCacheEnabled(true);
        mScrolling = true;
        setScrollState(SCROLL_STATE_SETTLING);

        final int width = getWidth();
        final int halfWidth = width / 2;
        final float distanceRatio = Math.min(1f, 1.0f * Math.abs(dx) / width);
        final float distance = halfWidth + halfWidth *
                distanceInfluenceForSnapDuration(distanceRatio);

        int duration = 0;
        velocity = Math.abs(velocity);
        if (velocity > 0) {
            duration = 4 * Math.round(1000 * Math.abs(distance / velocity));
        } else {
            final float pageDelta = (float) Math.abs(dx) / (width + mPageMargin);
            duration = (int) ((pageDelta + 1) * 100);
        }
        duration = Math.min(duration, MAX_SETTLE_DURATION);

        mScroller.startScroll(sx, sy, dx, dy, duration);
        invalidate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.430 -0500", hash_original_method = "4F6A5F0B8F2759342FC6F742F3401D82", hash_generated_method = "4F6A5F0B8F2759342FC6F742F3401D82")
    
void addNewItem(int position, int index) {
        ItemInfo ii = new ItemInfo();
        ii.position = position;
        ii.object = mAdapter.instantiateItem(this, position);
        if (index < 0) {
            mItems.add(ii);
        } else {
            mItems.add(index, ii);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.433 -0500", hash_original_method = "0F425711D6B8C5B4FAAE039431564D7B", hash_generated_method = "50B764AFF54760FC37558B0D29BA54DE")
    
void dataSetChanged() {
        // This method only gets called if our observer is attached, so mAdapter is non-null.

        boolean needPopulate = mItems.size() < 3 && mItems.size() < mAdapter.getCount();
        int newCurrItem = -1;

        boolean isUpdating = false;
        for (int i = 0; i < mItems.size(); i++) {
            final ItemInfo ii = mItems.get(i);
            final int newPos = mAdapter.getItemPosition(ii.object);

            if (newPos == PagerAdapter.POSITION_UNCHANGED) {
                continue;
            }

            if (newPos == PagerAdapter.POSITION_NONE) {
                mItems.remove(i);
                i--;

                if (!isUpdating) {
                    mAdapter.startUpdate(this);
                    isUpdating = true;
                }

                mAdapter.destroyItem(this, ii.position, ii.object);
                needPopulate = true;

                if (mCurItem == ii.position) {
                    // Keep the current item in the valid range
                    newCurrItem = Math.max(0, Math.min(mCurItem, mAdapter.getCount() - 1));
                }
                continue;
            }

            if (ii.position != newPos) {
                if (ii.position == mCurItem) {
                    // Our current item changed position. Follow it.
                    newCurrItem = newPos;
                }

                ii.position = newPos;
                needPopulate = true;
            }
        }

        if (isUpdating) {
            mAdapter.finishUpdate(this);
        }

        Collections.sort(mItems, COMPARATOR);

        if (newCurrItem >= 0) {
            // TODO This currently causes a jump.
            setCurrentItemInternal(newCurrItem, false, true);
            needPopulate = true;
        }
        if (needPopulate) {
            populate();
            requestLayout();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.437 -0500", hash_original_method = "70E539FA9A51CF2C9CD07D50F5400EB2", hash_generated_method = "8AAA6902D81751F7A04D751866DCBB73")
    
void populate() {
        if (mAdapter == null) {
            return;
        }

        // Bail now if we are waiting to populate.  This is to hold off
        // on creating views from the time the user releases their finger to
        // fling to a new position until we have finished the scroll to
        // that position, avoiding glitches from happening at that point.
        if (mPopulatePending) {
            if (DEBUG) Log.i(TAG, "populate is pending, skipping for now...");
            return;
        }

        // Also, don't populate until we are attached to a window.  This is to
        // avoid trying to populate before we have restored our view hierarchy
        // state and conflicting with what is restored.
        if (getWindowToken() == null) {
            return;
        }

        mAdapter.startUpdate(this);

        final int pageLimit = mOffscreenPageLimit;
        final int startPos = Math.max(0, mCurItem - pageLimit);
        final int N = mAdapter.getCount();
        final int endPos = Math.min(N-1, mCurItem + pageLimit);

        if (DEBUG) Log.v(TAG, "populating: startPos=" + startPos + " endPos=" + endPos);

        // Add and remove pages in the existing list.
        int lastPos = -1;
        for (int i=0; i<mItems.size(); i++) {
            ItemInfo ii = mItems.get(i);
            if ((ii.position < startPos || ii.position > endPos) && !ii.scrolling) {
                if (DEBUG) Log.i(TAG, "removing: " + ii.position + " @ " + i);
                mItems.remove(i);
                i--;
                mAdapter.destroyItem(this, ii.position, ii.object);
            } else if (lastPos < endPos && ii.position > startPos) {
                // The next item is outside of our range, but we have a gap
                // between it and the last item where we want to have a page
                // shown.  Fill in the gap.
                lastPos++;
                if (lastPos < startPos) {
                    lastPos = startPos;
                }
                while (lastPos <= endPos && lastPos < ii.position) {
                    if (DEBUG) Log.i(TAG, "inserting: " + lastPos + " @ " + i);
                    addNewItem(lastPos, i);
                    lastPos++;
                    i++;
                }
            }
            lastPos = ii.position;
        }

        // Add any new pages we need at the end.
        lastPos = mItems.size() > 0 ? mItems.get(mItems.size()-1).position : -1;
        if (lastPos < endPos) {
            lastPos++;
            lastPos = lastPos > startPos ? lastPos : startPos;
            while (lastPos <= endPos) {
                if (DEBUG) Log.i(TAG, "appending: " + lastPos);
                addNewItem(lastPos, -1);
                lastPos++;
            }
        }

        if (DEBUG) {
            Log.i(TAG, "Current page list:");
            for (int i=0; i<mItems.size(); i++) {
                Log.i(TAG, "#" + i + ": page " + mItems.get(i).position);
            }
        }

        ItemInfo curItem = null;
        for (int i=0; i<mItems.size(); i++) {
            if (mItems.get(i).position == mCurItem) {
                curItem = mItems.get(i);
                break;
            }
        }
        mAdapter.setPrimaryItem(this, mCurItem, curItem != null ? curItem.object : null);

        mAdapter.finishUpdate(this);

        if (hasFocus()) {
            View currentFocused = findFocus();
            ItemInfo ii = currentFocused != null ? infoForAnyChild(currentFocused) : null;
            if (ii == null || ii.position != mCurItem) {
                for (int i=0; i<getChildCount(); i++) {
                    View child = getChildAt(i);
                    ii = infoForChild(child);
                    if (ii != null && ii.position == mCurItem) {
                        if (child.requestFocus(FOCUS_FORWARD)) {
                            break;
                        }
                    }
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.468 -0500", hash_original_method = "14189B7A9DD30FC59304078756C5DA79", hash_generated_method = "FEF58CDF7BC9E07C8A51402A3FBA90E8")
    
@Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.position = mCurItem;
        if (mAdapter != null) {
            ss.adapterState = mAdapter.saveState();
        }
        return ss;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.471 -0500", hash_original_method = "D24913A88F27B9FFD16DBB95EA1FF14B", hash_generated_method = "6051FF5F8901A8C3365CE6A1069004FF")
    
@Override
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());

        if (mAdapter != null) {
            mAdapter.restoreState(ss.adapterState, ss.loader);
            setCurrentItemInternal(ss.position, false, true);
        } else {
            mRestoredCurItem = ss.position;
            mRestoredAdapterState = ss.adapterState;
            mRestoredClassLoader = ss.loader;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.474 -0500", hash_original_method = "CCA2D7E19B51FD6942892776091DF304", hash_generated_method = "28A98287E1C1E14964DD2BB24386B5A8")
    
@Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (!checkLayoutParams(params)) {
            params = generateLayoutParams(params);
        }
        final LayoutParams lp = (LayoutParams) params;
        lp.isDecor |= child instanceof Decor;
        if (mInLayout) {
            if (lp != null && lp.isDecor) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            addViewInLayout(child, index, params);
            child.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
        } else {
            super.addView(child, index, params);
        }

        if (USE_CACHE) {
            if (child.getVisibility() != GONE) {
                child.setDrawingCacheEnabled(mScrollingCacheEnabled);
            } else {
                child.setDrawingCacheEnabled(false);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.476 -0500", hash_original_method = "3A127F64616A326BFDC211D8F4FB8341", hash_generated_method = "3A127F64616A326BFDC211D8F4FB8341")
    
ItemInfo infoForChild(View child) {
        for (int i=0; i<mItems.size(); i++) {
            ItemInfo ii = mItems.get(i);
            if (mAdapter.isViewFromObject(child, ii.object)) {
                return ii;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.478 -0500", hash_original_method = "1D0A995632EA6711A9479487500A682E", hash_generated_method = "1D0A995632EA6711A9479487500A682E")
    
ItemInfo infoForAnyChild(View child) {
        ViewParent parent;
        while ((parent=child.getParent()) != this) {
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            child = (View)parent;
        }
        return infoForChild(child);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.480 -0500", hash_original_method = "55E78F1E2A11C365755D77C284D387A2", hash_generated_method = "F4968E15513E07145315A993A80462B8")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.483 -0500", hash_original_method = "52B64CDCDB17F6464B1AA9D44D4C5C01", hash_generated_method = "44EB5175D5F835C37A058DACB1C975F2")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // For simple implementation, or internal size is always 0.
        // We depend on the container to specify the layout size of
        // our view.  We can't really know what it is since we will be
        // adding and removing different arbitrary views and do not
        // want the layout to change as this happens.
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));

        // Children are just made to fill our space.
        int childWidthSize = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int childHeightSize = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();

        /*
         * Make sure all children have been properly measured. Decor views first.
         * Right now we cheat and make this less complicated by assuming decor
         * views won't intersect. We will pin to edges based on gravity.
         */
        int size = getChildCount();
        for (int i = 0; i < size; ++i) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp != null && lp.isDecor) {
                    final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                    final int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
                    Log.d(TAG, "gravity: " + lp.gravity + " hgrav: " + hgrav + " vgrav: " + vgrav);
                    int widthMode = MeasureSpec.AT_MOST;
                    int heightMode = MeasureSpec.AT_MOST;
                    boolean consumeVertical = vgrav == Gravity.TOP || vgrav == Gravity.BOTTOM;
                    boolean consumeHorizontal = hgrav == Gravity.LEFT || hgrav == Gravity.RIGHT;

                    if (consumeVertical) {
                        widthMode = MeasureSpec.EXACTLY;
                    } else if (consumeHorizontal) {
                        heightMode = MeasureSpec.EXACTLY;
                    }

                    final int widthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, widthMode);
                    final int heightSpec = MeasureSpec.makeMeasureSpec(childHeightSize, heightMode);
                    child.measure(widthSpec, heightSpec);

                    if (consumeVertical) {
                        childHeightSize -= child.getMeasuredHeight();
                    } else if (consumeHorizontal) {
                        childWidthSize -= child.getMeasuredWidth();
                    }
                }
            }
        }

        mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeightSize, MeasureSpec.EXACTLY);

        // Make sure we have created all fragments that we need to have shown.
        mInLayout = true;
        populate();
        mInLayout = false;

        // Page views next.
        size = getChildCount();
        for (int i = 0; i < size; ++i) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                if (DEBUG) Log.v(TAG, "Measuring #" + i + " " + child
                        + ": " + mChildWidthMeasureSpec);

                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (lp == null || !lp.isDecor) {
                    child.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.486 -0500", hash_original_method = "D136D70D1C0AC62B68634CD89991503C", hash_generated_method = "204C78B20DCA698E22B2020136CB0E59")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Make sure scroll position is set correctly.
        if (w != oldw) {
            recomputeScrollPosition(w, oldw, mPageMargin, mPageMargin);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.489 -0500", hash_original_method = "BF2EFCA6E1F80930784A0AE156969F1F", hash_generated_method = "102E958BC1C4522F668B2609AF6E5E6B")
    
private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        final int widthWithMargin = width + margin;
        if (oldWidth > 0) {
            final int oldScrollPos = getScrollX();
            final int oldwwm = oldWidth + oldMargin;
            final int oldScrollItem = oldScrollPos / oldwwm;
            final float scrollOffset = (float) (oldScrollPos % oldwwm) / oldwwm;
            final int scrollPos = (int) ((oldScrollItem + scrollOffset) * widthWithMargin);
            scrollTo(scrollPos, getScrollY());
            if (!mScroller.isFinished()) {
                // We now return to your regularly scheduled scroll, already in progress.
                final int newDuration = mScroller.getDuration() - mScroller.timePassed();
                mScroller.startScroll(scrollPos, 0, mCurItem * widthWithMargin, 0, newDuration);
            }
        } else {
            int scrollPos = mCurItem * widthWithMargin;
            if (scrollPos != getScrollX()) {
                completeScroll();
                scrollTo(scrollPos, getScrollY());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.493 -0500", hash_original_method = "91DBAE2CED1324F5F1E91DEC22CE5EE7", hash_generated_method = "5E9B542C1D9FCC3DD9578EA21DAEEDC4")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mInLayout = true;
        populate();
        mInLayout = false;

        final int count = getChildCount();
        int width = r - l;
        int height = b - t;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        final int scrollX = getScrollX();

        int decorCount = 0;

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                ItemInfo ii;
                int childLeft = 0;
                int childTop = 0;
                if (lp.isDecor) {
                    final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                    final int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
                    switch (hgrav) {
                        default:
                            childLeft = paddingLeft;
                            break;
                        case Gravity.LEFT:
                            childLeft = paddingLeft;
                            paddingLeft += child.getMeasuredWidth();
                            break;
                        case Gravity.CENTER_HORIZONTAL:
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2,
                                    paddingLeft);
                            break;
                        case Gravity.RIGHT:
                            childLeft = width - paddingRight - child.getMeasuredWidth();
                            paddingRight += child.getMeasuredWidth();
                            break;
                    }
                    switch (vgrav) {
                        default:
                            childTop = paddingTop;
                            break;
                        case Gravity.TOP:
                            childTop = paddingTop;
                            paddingTop += child.getMeasuredHeight();
                            break;
                        case Gravity.CENTER_VERTICAL:
                            childTop = Math.max((height - child.getMeasuredHeight()) / 2,
                                    paddingTop);
                            break;
                        case Gravity.BOTTOM:
                            childTop = height - paddingBottom - child.getMeasuredHeight();
                            paddingBottom += child.getMeasuredHeight();
                            break;
                    }
                    childLeft += scrollX;
                    decorCount++;
                    child.layout(childLeft, childTop,
                            childLeft + child.getMeasuredWidth(),
                            childTop + child.getMeasuredHeight());
                } else if ((ii = infoForChild(child)) != null) {
                    int loff = (width + mPageMargin) * ii.position;
                    childLeft = paddingLeft + loff;
                    childTop = paddingTop;
                    if (DEBUG) Log.v(TAG, "Positioning #" + i + " " + child + " f=" + ii.object
                            + ":" + childLeft + "," + childTop + " " + child.getMeasuredWidth()
                            + "x" + child.getMeasuredHeight());
                    child.layout(childLeft, childTop,
                            childLeft + child.getMeasuredWidth(),
                            childTop + child.getMeasuredHeight());
                }
            }
        }
        mTopPageBounds = paddingTop;
        mBottomPageBounds = height - paddingBottom;
        mDecorChildCount = decorCount;
        mFirstLayout = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.496 -0500", hash_original_method = "245E7C909F76590CC461C5035FA848B9", hash_generated_method = "4DE05DB42A54DD51D415D8BBD923FA5D")
    
@Override
    public void computeScroll() {
        if (DEBUG) Log.i(TAG, "computeScroll: finished=" + mScroller.isFinished());
        if (!mScroller.isFinished()) {
            if (mScroller.computeScrollOffset()) {
                if (DEBUG) Log.i(TAG, "computeScroll: still scrolling");
                int oldX = getScrollX();
                int oldY = getScrollY();
                int x = mScroller.getCurrX();
                int y = mScroller.getCurrY();

                if (oldX != x || oldY != y) {
                    scrollTo(x, y);
                    pageScrolled(x);
                }

                // Keep on drawing until the animation has finished.
                invalidate();
                return;
            }
        }

        // Done with scroll, clean up state.
        completeScroll();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.498 -0500", hash_original_method = "07505BF167DC29F6F179D71B0816840E", hash_generated_method = "FA57818A573D0A860BDBA2D9FCC8A277")
    
private void pageScrolled(int xpos) {
        final int widthWithMargin = getWidth() + mPageMargin;
        final int position = xpos / widthWithMargin;
        final int offsetPixels = xpos % widthWithMargin;
        final float offset = (float) offsetPixels / widthWithMargin;

        mCalledSuper = false;
        onPageScrolled(position, offset, offsetPixels);
        if (!mCalledSuper) {
            throw new IllegalStateException(
                    "onPageScrolled did not call superclass implementation");
        }
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     * If you override this method you must call through to the superclass implementation
     * (e.g. super.onPageScrolled(position, offset, offsetPixels)) before onPageScrolled
     * returns.
     *
     * @param position Position index of the first page currently being displayed.
     *                 Page position+1 will be visible if positionOffset is nonzero.
     * @param offset Value from [0, 1) indicating the offset from the page at position.
     * @param offsetPixels Value in pixels indicating the offset from position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.501 -0500", hash_original_method = "D3205253D12342035E86376912330E75", hash_generated_method = "75DE84A5FA67EA0AD76E031C16F14EB0")
    
protected void onPageScrolled(int position, float offset, int offsetPixels) {
        // Offset any decor views if needed - keep them on-screen at all times.
        if (mDecorChildCount > 0) {
            final int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            final int width = getWidth();
            final int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if (!lp.isDecor) continue;

                final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                int childLeft = 0;
                switch (hgrav) {
                    default:
                        childLeft = paddingLeft;
                        break;
                    case Gravity.LEFT:
                        childLeft = paddingLeft;
                        paddingLeft += child.getWidth();
                        break;
                    case Gravity.CENTER_HORIZONTAL:
                        childLeft = Math.max((width - child.getMeasuredWidth()) / 2,
                                paddingLeft);
                        break;
                    case Gravity.RIGHT:
                        childLeft = width - paddingRight - child.getMeasuredWidth();
                        paddingRight += child.getMeasuredWidth();
                        break;
                }
                childLeft += scrollX;

                final int childOffset = childLeft - child.getLeft();
                if (childOffset != 0) {
                    child.offsetLeftAndRight(childOffset);
                }
            }
        }

        if (mOnPageChangeListener != null) {
            mOnPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        if (mInternalPageChangeListener != null) {
            mInternalPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        }
        mCalledSuper = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.504 -0500", hash_original_method = "B1229287A4B4E18886EBB2FC1C1A6ECA", hash_generated_method = "0167E41E1CA8721CBF3702448873686A")
    
private void completeScroll() {
        boolean needPopulate = mScrolling;
        if (needPopulate) {
            // Done with scroll, no longer want to cache view drawing.
            setScrollingCacheEnabled(false);
            mScroller.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            if (oldX != x || oldY != y) {
                scrollTo(x, y);
            }
            setScrollState(SCROLL_STATE_IDLE);
        }
        mPopulatePending = false;
        mScrolling = false;
        for (int i=0; i<mItems.size(); i++) {
            ItemInfo ii = mItems.get(i);
            if (ii.scrolling) {
                needPopulate = true;
                ii.scrolling = false;
            }
        }
        if (needPopulate) {
            populate();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.510 -0500", hash_original_method = "965C57B2E8FC3C570BE548067A40E31E", hash_generated_method = "0FEB19E34CA2108B1F53E6B21958A8D1")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        /*
         * This method JUST determines whether we want to intercept the motion.
         * If we return true, onMotionEvent will be called and we do the actual
         * scrolling there.
         */

        final int action = ev.getAction() & MotionEventCompat.ACTION_MASK;

        // Always take care of the touch gesture being complete.
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            // Release the drag.
            if (DEBUG) Log.v(TAG, "Intercept done!");
            mIsBeingDragged = false;
            mIsUnableToDrag = false;
            mActivePointerId = INVALID_POINTER;
            if (mVelocityTracker != null) {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            }
            return false;
        }

        // Nothing more to do here if we have decided whether or not we
        // are dragging.
        if (action != MotionEvent.ACTION_DOWN) {
            if (mIsBeingDragged) {
                if (DEBUG) Log.v(TAG, "Intercept returning true!");
                return true;
            }
            if (mIsUnableToDrag) {
                if (DEBUG) Log.v(TAG, "Intercept returning false!");
                return false;
            }
        }

        switch (action) {
            case MotionEvent.ACTION_MOVE: {
                /*
                 * mIsBeingDragged == false, otherwise the shortcut would have caught it. Check
                 * whether the user has moved far enough from his original down touch.
                 */

                /*
                * Locally do absolute value. mLastMotionY is set to the y value
                * of the down event.
                */
                final int activePointerId = mActivePointerId;
                if (activePointerId == INVALID_POINTER) {
                    // If we don't have a valid id, the touch down wasn't on content.
                    break;
                }

                final int pointerIndex = MotionEventCompat.findPointerIndex(ev, activePointerId);
                final float x = MotionEventCompat.getX(ev, pointerIndex);
                final float dx = x - mLastMotionX;
                final float xDiff = Math.abs(dx);
                final float y = MotionEventCompat.getY(ev, pointerIndex);
                final float yDiff = Math.abs(y - mLastMotionY);
                if (DEBUG) Log.v(TAG, "Moved x to " + x + "," + y + " diff=" + xDiff + "," + yDiff);

                if (canScroll(this, false, (int) dx, (int) x, (int) y)) {
                    // Nested view has scrollable area under this point. Let it be handled there.
                    mInitialMotionX = mLastMotionX = x;
                    mLastMotionY = y;
                    return false;
                }
                if (xDiff > mTouchSlop && xDiff > yDiff) {
                    if (DEBUG) Log.v(TAG, "Starting drag!");
                    mIsBeingDragged = true;
                    setScrollState(SCROLL_STATE_DRAGGING);
                    mLastMotionX = x;
                    setScrollingCacheEnabled(true);
                } else {
                    if (yDiff > mTouchSlop) {
                        // The finger has moved enough in the vertical
                        // direction to be counted as a drag...  abort
                        // any attempt to drag horizontally, to work correctly
                        // with children that have scrolling containers.
                        if (DEBUG) Log.v(TAG, "Starting unable to drag!");
                        mIsUnableToDrag = true;
                    }
                }
                break;
            }

            case MotionEvent.ACTION_DOWN: {
                /*
                 * Remember location of down touch.
                 * ACTION_DOWN always refers to pointer index 0.
                 */
                mLastMotionX = mInitialMotionX = ev.getX();
                mLastMotionY = ev.getY();
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);

                if (mScrollState == SCROLL_STATE_SETTLING) {
                    // Let the user 'catch' the pager as it animates.
                    mIsBeingDragged = true;
                    mIsUnableToDrag = false;
                    setScrollState(SCROLL_STATE_DRAGGING);
                } else {
                    completeScroll();
                    mIsBeingDragged = false;
                    mIsUnableToDrag = false;
                }

                if (DEBUG) Log.v(TAG, "Down at " + mLastMotionX + "," + mLastMotionY
                        + " mIsBeingDragged=" + mIsBeingDragged
                        + "mIsUnableToDrag=" + mIsUnableToDrag);
                break;
            }

            case MotionEventCompat.ACTION_POINTER_UP:
                onSecondaryPointerUp(ev);
                break;
        }

        if (!mIsBeingDragged) {
            // Track the velocity as long as we aren't dragging.
            // Once we start a real drag we will track in onTouchEvent.
            if (mVelocityTracker == null) {
                mVelocityTracker = VelocityTracker.obtain();
            }
            mVelocityTracker.addMovement(ev);
        }

        /*
         * The only time we want to intercept motion events is if we are in the
         * drag mode.
         */
        return mIsBeingDragged;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.516 -0500", hash_original_method = "88D861E2913027BDD6B43DC3209AC688", hash_generated_method = "F10F02C41C252D3B5D3735858457B019")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mFakeDragging) {
            // A fake drag is in progress already, ignore this real one
            // but still eat the touch events.
            // (It is likely that the user is multi-touching the screen.)
            return true;
        }

        if (ev.getAction() == MotionEvent.ACTION_DOWN && ev.getEdgeFlags() != 0) {
            // Don't handle edge touches immediately -- they may actually belong to one of our
            // descendants.
            return false;
        }

        if (mAdapter == null || mAdapter.getCount() == 0) {
            // Nothing to present or scroll; nothing to touch.
            return false;
        }

        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);

        final int action = ev.getAction();
        boolean needsInvalidate = false;

        switch (action & MotionEventCompat.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                /*
                 * If being flinged and user touches, stop the fling. isFinished
                 * will be false if being flinged.
                 */
                completeScroll();

                // Remember where the motion event started
                mLastMotionX = mInitialMotionX = ev.getX();
                mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
                break;
            }
            case MotionEvent.ACTION_MOVE:
                if (!mIsBeingDragged) {
                    final int pointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
                    final float x = MotionEventCompat.getX(ev, pointerIndex);
                    final float xDiff = Math.abs(x - mLastMotionX);
                    final float y = MotionEventCompat.getY(ev, pointerIndex);
                    final float yDiff = Math.abs(y - mLastMotionY);
                    if (DEBUG) Log.v(TAG, "Moved x to " + x + "," + y + " diff=" + xDiff + "," + yDiff);
                    if (xDiff > mTouchSlop && xDiff > yDiff) {
                        if (DEBUG) Log.v(TAG, "Starting drag!");
                        mIsBeingDragged = true;
                        mLastMotionX = x;
                        setScrollState(SCROLL_STATE_DRAGGING);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (mIsBeingDragged) {
                    // Scroll to follow the motion event
                    final int activePointerIndex = MotionEventCompat.findPointerIndex(
                            ev, mActivePointerId);
                    final float x = MotionEventCompat.getX(ev, activePointerIndex);
                    final float deltaX = mLastMotionX - x;
                    mLastMotionX = x;
                    float oldScrollX = getScrollX();
                    float scrollX = oldScrollX + deltaX;
                    final int width = getWidth();
                    final int widthWithMargin = width + mPageMargin;

                    final int lastItemIndex = mAdapter.getCount() - 1;
                    final float leftBound = Math.max(0, (mCurItem - 1) * widthWithMargin);
                    final float rightBound =
                            Math.min(mCurItem + 1, lastItemIndex) * widthWithMargin;
                    if (scrollX < leftBound) {
                        if (leftBound == 0) {
                            float over = -scrollX;
                            needsInvalidate = mLeftEdge.onPull(over / width);
                        }
                        scrollX = leftBound;
                    } else if (scrollX > rightBound) {
                        if (rightBound == lastItemIndex * widthWithMargin) {
                            float over = scrollX - rightBound;
                            needsInvalidate = mRightEdge.onPull(over / width);
                        }
                        scrollX = rightBound;
                    }
                    // Don't lose the rounded component
                    mLastMotionX += scrollX - (int) scrollX;
                    scrollTo((int) scrollX, getScrollY());
                    pageScrolled((int) scrollX);
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mIsBeingDragged) {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                    int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(
                            velocityTracker, mActivePointerId);
                    mPopulatePending = true;
                    final int widthWithMargin = getWidth() + mPageMargin;
                    final int scrollX = getScrollX();
                    final int currentPage = scrollX / widthWithMargin;
                    final float pageOffset = (float) (scrollX % widthWithMargin) / widthWithMargin;
                    final int activePointerIndex =
                            MotionEventCompat.findPointerIndex(ev, mActivePointerId);
                    final float x = MotionEventCompat.getX(ev, activePointerIndex);
                    final int totalDelta = (int) (x - mInitialMotionX);
                    int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity,
                            totalDelta);
                    setCurrentItemInternal(nextPage, true, true, initialVelocity);

                    mActivePointerId = INVALID_POINTER;
                    endDrag();
                    needsInvalidate = mLeftEdge.onRelease() | mRightEdge.onRelease();
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                if (mIsBeingDragged) {
                    setCurrentItemInternal(mCurItem, true, true);
                    mActivePointerId = INVALID_POINTER;
                    endDrag();
                    needsInvalidate = mLeftEdge.onRelease() | mRightEdge.onRelease();
                }
                break;
            case MotionEventCompat.ACTION_POINTER_DOWN: {
                final int index = MotionEventCompat.getActionIndex(ev);
                final float x = MotionEventCompat.getX(ev, index);
                mLastMotionX = x;
                mActivePointerId = MotionEventCompat.getPointerId(ev, index);
                break;
            }
            case MotionEventCompat.ACTION_POINTER_UP:
                onSecondaryPointerUp(ev);
                mLastMotionX = MotionEventCompat.getX(ev,
                        MotionEventCompat.findPointerIndex(ev, mActivePointerId));
                break;
        }
        if (needsInvalidate) {
            invalidate();
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.518 -0500", hash_original_method = "A599F43FA0EC47D3B5F0044593C86DDF", hash_generated_method = "CE43431CB867B80EAC2218414A72CD82")
    
private int determineTargetPage(int currentPage, float pageOffset, int velocity, int deltaX) {
        int targetPage;
        if (Math.abs(deltaX) > mFlingDistance && Math.abs(velocity) > mMinimumVelocity) {
            targetPage = velocity > 0 ? currentPage : currentPage + 1;
        } else {
            targetPage = (int) (currentPage + pageOffset + 0.5f);
        }

        return targetPage;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.521 -0500", hash_original_method = "EFAFFAB02B49B744BACD5A955538775F", hash_generated_method = "8B7FC5A1044602225D772E160FC533C6")
    
@Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean needsInvalidate = false;

        final int overScrollMode = ViewCompat.getOverScrollMode(this);
        if (overScrollMode == ViewCompat.OVER_SCROLL_ALWAYS ||
                (overScrollMode == ViewCompat.OVER_SCROLL_IF_CONTENT_SCROLLS &&
                        mAdapter != null && mAdapter.getCount() > 1)) {
            if (!mLeftEdge.isFinished()) {
                final int restoreCount = canvas.save();
                final int height = getHeight() - getPaddingTop() - getPaddingBottom();

                canvas.rotate(270);
                canvas.translate(-height + getPaddingTop(), 0);
                mLeftEdge.setSize(height, getWidth());
                needsInvalidate |= mLeftEdge.draw(canvas);
                canvas.restoreToCount(restoreCount);
            }
            if (!mRightEdge.isFinished()) {
                final int restoreCount = canvas.save();
                final int width = getWidth();
                final int height = getHeight() - getPaddingTop() - getPaddingBottom();
                final int itemCount = mAdapter != null ? mAdapter.getCount() : 1;

                canvas.rotate(90);
                canvas.translate(-getPaddingTop(),
                        -itemCount * (width + mPageMargin) + mPageMargin);
                mRightEdge.setSize(height, width);
                needsInvalidate |= mRightEdge.draw(canvas);
                canvas.restoreToCount(restoreCount);
            }
        } else {
            mLeftEdge.finish();
            mRightEdge.finish();
        }

        if (needsInvalidate) {
            // Keep animating
            invalidate();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.524 -0500", hash_original_method = "C696E5F5E436E83A9E43E2B41DDB422F", hash_generated_method = "E754AAB18D90887B7EF8F8453E76ACDB")
    
@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the margin drawable if needed.
        if (mPageMargin > 0 && mMarginDrawable != null) {
            final int scrollX = getScrollX();
            final int width = getWidth();
            final int offset = scrollX % (width + mPageMargin);
            if (offset != 0) {
                // Pages fit completely when settled; we only need to draw when in between
                final int left = scrollX - offset + width;
                mMarginDrawable.setBounds(left, mTopPageBounds, left + mPageMargin,
                        mBottomPageBounds);
                mMarginDrawable.draw(canvas);
            }
        }
    }

    /**
     * Start a fake drag of the pager.
     *
     * <p>A fake drag can be useful if you want to synchronize the motion of the ViewPager
     * with the touch scrolling of another view, while still letting the ViewPager
     * control the snapping motion and fling behavior. (e.g. parallax-scrolling tabs.)
     * Call {@link #fakeDragBy(float)} to simulate the actual drag motion. Call
     * {@link #endFakeDrag()} to complete the fake drag and fling as necessary.
     *
     * <p>During a fake drag the ViewPager will ignore all touch events. If a real drag
     * is already in progress, this method will return false.
     *
     * @return true if the fake drag began successfully, false if it could not be started.
     *
     * @see #fakeDragBy(float)
     * @see #endFakeDrag()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.527 -0500", hash_original_method = "2447A911D9005F96843292B56C864341", hash_generated_method = "717F1A2B8679088A9553B7BCE7158ADE")
    
public boolean beginFakeDrag() {
        if (mIsBeingDragged) {
            return false;
        }
        mFakeDragging = true;
        setScrollState(SCROLL_STATE_DRAGGING);
        mInitialMotionX = mLastMotionX = 0;
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        } else {
            mVelocityTracker.clear();
        }
        final long time = SystemClock.uptimeMillis();
        final MotionEvent ev = MotionEvent.obtain(time, time, MotionEvent.ACTION_DOWN, 0, 0, 0);
        mVelocityTracker.addMovement(ev);
        ev.recycle();
        mFakeDragBeginTime = time;
        return true;
    }

    /**
     * End a fake drag of the pager.
     *
     * @see #beginFakeDrag()
     * @see #fakeDragBy(float)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.530 -0500", hash_original_method = "012F2AA21899E6B7C86DFCCAFEEFC371", hash_generated_method = "6E52C37D4DC1861373EE52DEE2547E9E")
    
public void endFakeDrag() {
        if (!mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }

        final VelocityTracker velocityTracker = mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
        int initialVelocity = (int)VelocityTrackerCompat.getYVelocity(
                velocityTracker, mActivePointerId);
        mPopulatePending = true;
        final int totalDelta = (int) (mLastMotionX - mInitialMotionX);
        final int scrollX = getScrollX();
        final int widthWithMargin = getWidth() + mPageMargin;
        final int currentPage = scrollX / widthWithMargin;
        final float pageOffset = (float) (scrollX % widthWithMargin) / widthWithMargin;
        int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity, totalDelta);
        setCurrentItemInternal(nextPage, true, true, initialVelocity);
        endDrag();

        mFakeDragging = false;
    }

    /**
     * Fake drag by an offset in pixels. You must have called {@link #beginFakeDrag()} first.
     *
     * @param xOffset Offset in pixels to drag by.
     * @see #beginFakeDrag()
     * @see #endFakeDrag()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.533 -0500", hash_original_method = "3C01AF98038E7AF52A40B265C4F4693E", hash_generated_method = "8E5CB329244B0A5667448A52CC0A6BEC")
    
public void fakeDragBy(float xOffset) {
        if (!mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }

        mLastMotionX += xOffset;
        float scrollX = getScrollX() - xOffset;
        final int width = getWidth();
        final int widthWithMargin = width + mPageMargin;

        final float leftBound = Math.max(0, (mCurItem - 1) * widthWithMargin);
        final float rightBound =
                Math.min(mCurItem + 1, mAdapter.getCount() - 1) * widthWithMargin;
        if (scrollX < leftBound) {
            scrollX = leftBound;
        } else if (scrollX > rightBound) {
            scrollX = rightBound;
        }
        // Don't lose the rounded component
        mLastMotionX += scrollX - (int) scrollX;
        scrollTo((int) scrollX, getScrollY());
        pageScrolled((int) scrollX);

        // Synthesize an event for the VelocityTracker.
        final long time = SystemClock.uptimeMillis();
        final MotionEvent ev = MotionEvent.obtain(mFakeDragBeginTime, time, MotionEvent.ACTION_MOVE,
                mLastMotionX, 0, 0);
        mVelocityTracker.addMovement(ev);
        ev.recycle();
    }

    /**
     * Returns true if a fake drag is in progress.
     *
     * @return true if currently in a fake drag, false otherwise.
     *
     * @see #beginFakeDrag()
     * @see #fakeDragBy(float)
     * @see #endFakeDrag()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.535 -0500", hash_original_method = "A453849F99C417376DDBB8B219E48B12", hash_generated_method = "34F38D7FE93636C5AE5937E73492D579")
    
public boolean isFakeDragging() {
        return mFakeDragging;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.538 -0500", hash_original_method = "0206AC68AD27D7D682B52A43262096FD", hash_generated_method = "10CA48021E16D8469C3CB9386E27A296")
    
private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = MotionEventCompat.getActionIndex(ev);
        final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        if (pointerId == mActivePointerId) {
            // This was our active pointer going up. Choose a new
            // active pointer and adjust accordingly.
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.540 -0500", hash_original_method = "6F589820542A60985222493865875D9E", hash_generated_method = "7D9A26F3E89ABDFE52D17DF136B12E41")
    
private void endDrag() {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;

        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.543 -0500", hash_original_method = "2B073E6A9B3015E7E6D245BDA0374ADD", hash_generated_method = "3F8924C3B50E28F08F707C0688EC9CF2")
    
private void setScrollingCacheEnabled(boolean enabled) {
        if (mScrollingCacheEnabled != enabled) {
            mScrollingCacheEnabled = enabled;
            if (USE_CACHE) {
                final int size = getChildCount();
                for (int i = 0; i < size; ++i) {
                    final View child = getChildAt(i);
                    if (child.getVisibility() != GONE) {
                        child.setDrawingCacheEnabled(enabled);
                    }
                }
            }
        }
    }

    /**
     * Tests scrollability within child views of v given a delta of dx.
     *
     * @param v View to test for horizontal scrollability
     * @param checkV Whether the view v passed should itself be checked for scrollability (true),
     *               or just its children (false).
     * @param dx Delta scrolled in pixels
     * @param x X coordinate of the active touch point
     * @param y Y coordinate of the active touch point
     * @return true if child views of v can be scrolled by delta of dx.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.546 -0500", hash_original_method = "72E1851DC28067296F340B8A32532AE8", hash_generated_method = "906532A68332F21C2D8E068A5AFD9492")
    
protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof ViewGroup) {
            final ViewGroup group = (ViewGroup) v;
            final int scrollX = v.getScrollX();
            final int scrollY = v.getScrollY();
            final int count = group.getChildCount();
            // Count backwards - let topmost views consume scroll distance first.
            for (int i = count - 1; i >= 0; i--) {
                // TODO: Add versioned support here for transformed views.
                // This will not work for transformed views in Honeycomb+
                final View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() &&
                        y + scrollY >= child.getTop() && y + scrollY < child.getBottom() &&
                        canScroll(child, true, dx, x + scrollX - child.getLeft(),
                                y + scrollY - child.getTop())) {
                    return true;
                }
            }
        }

        return checkV && ViewCompat.canScrollHorizontally(v, -dx);
    }
    
    static class ItemInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.234 -0500", hash_original_field = "4725548B2F852700377486F07DBD49CE", hash_generated_field = "4725548B2F852700377486F07DBD49CE")

        Object object;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.236 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.238 -0500", hash_original_field = "C4FC55BE953EA6922AFA9FA4551D7D29", hash_generated_field = "C4FC55BE953EA6922AFA9FA4551D7D29")

        boolean scrolling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "0E65939D2C485463E4F8D82E04659E59", hash_generated_method = "0E65939D2C485463E4F8D82E04659E59")
        public ItemInfo ()
        {
            //Synthesized constructor
        }

    }
    
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "11664B5E2C5AD85381CB52FAE0F3E160", hash_generated_method = "11664B5E2C5AD85381CB52FAE0F3E160")
        public SimpleOnPageChangeListener ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.357 -0500", hash_original_method = "FDA1A61FADE7F0C7FCCDCC2DC76C3CF3", hash_generated_method = "78D99D6E8122032597983563F2377322")
        
@Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            // This space for rent
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.359 -0500", hash_original_method = "53640E8AF66EBB8ED10DFFE2A0D2E8B4", hash_generated_method = "7726B178731B984C29D4495D3BBC5FEA")
        
@Override
        public void onPageSelected(int position) {
            // This space for rent
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.362 -0500", hash_original_method = "257CCDCF3F3C71EC13191438C1C85826", hash_generated_method = "D6D6202E1E1F2123BC1B73F9E57DCF4A")
        
@Override
        public void onPageScrollStateChanged(int state) {
            // This space for rent
        }
        
    }
    
    public static class SavedState extends BaseSavedState {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_field = "0C2FD1F1D20C82721A0B333C0E7E33AB", hash_generated_field = "F13036E5254809F6F751A2283CFC452E")

        public static final Parcelable.Creator<SavedState> CREATOR
                = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.455 -0500", hash_original_method = "827740B54B4D2FB6132FF4A14CAC20AA", hash_generated_method = "6374ADD5BFE94C2149D24C170E07D0D2")
            
@Override
                    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                        return new SavedState(in, loader);
                    }
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.458 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "64E1D2A1EC44371983C9C74556451452")
            
@Override
                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                });
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.440 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.442 -0500", hash_original_field = "69064C35FAD6A57FDCB5B011C3C90243", hash_generated_field = "69064C35FAD6A57FDCB5B011C3C90243")

        Parcelable adapterState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.444 -0500", hash_original_field = "50E7BE27A72C15B735AFB72AFA6F9C78", hash_generated_field = "50E7BE27A72C15B735AFB72AFA6F9C78")

        ClassLoader loader;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.447 -0500", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "E32D4593A5A22DE64D4F3221E06324D4")
        
public SavedState(Parcelable superState) {
            super(superState);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.464 -0500", hash_original_method = "C91DCD2D2A900CBC6E45E0C16FB00296", hash_generated_method = "C91DCD2D2A900CBC6E45E0C16FB00296")
        
SavedState(Parcel in, ClassLoader loader) {
            super(in);
            if (loader == null) {
                loader = getClass().getClassLoader();
            }
            position = in.readInt();
            adapterState = in.readParcelable(loader);
            this.loader = loader;
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.449 -0500", hash_original_method = "F4CAF3A56784E52DEBA10017E225034C", hash_generated_method = "0EB1DEBE12C67421D4CFACF28CE6FD65")
        
@Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(position);
            out.writeParcelable(adapterState, flags);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.452 -0500", hash_original_method = "7E681A9714B5A31F0FD1978F434F050F", hash_generated_method = "D8CD36F88F1DF52DB6D7989DAD80B98B")
        
@Override
        public String toString() {
            return "FragmentPager.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " position=" + position + "}";
        }
    }
    
    private class PagerObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_method = "9650588F08E5195A8869DD8AFCD0755C", hash_generated_method = "9650588F08E5195A8869DD8AFCD0755C")
        public PagerObserver ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.582 -0500", hash_original_method = "11C315FA7B2CA5C79402AC3B9B3CC875", hash_generated_method = "D0A1A9841F8BDA82DD4CCCC7758D602B")
        
@Override
        public void onChanged() {
            dataSetChanged();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.585 -0500", hash_original_method = "75A3C506698EAB8F326C44C7FA27D020", hash_generated_method = "2AB64AAE41AB1CE6E345B91007057CB4")
        
@Override
        public void onInvalidated() {
            dataSetChanged();
        }
        
    }
    
    public static class LayoutParams extends ViewGroup.LayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.589 -0500", hash_original_field = "E34B784EA64A825067A6B44C3F87E09C", hash_generated_field = "59F277E75B4C152D81D2D818BA4B0D2E")

        public boolean isDecor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.593 -0500", hash_original_field = "E7FDA06D45817A851F4CCBCEDBBF1171", hash_generated_field = "7B969BCD8327FD354F9843B5C2FB842F")

        public int gravity;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.595 -0500", hash_original_method = "22352D37EA586BAB2B06261A9354918D", hash_generated_method = "7FE9663220C0107D37C7BA8C1C30C316")
        
public LayoutParams() {
            super(FILL_PARENT, FILL_PARENT);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.598 -0500", hash_original_method = "1F1818866541ED0A2C469168FD0D681B", hash_generated_method = "8BCF43DCC8CF6FD654C3AB52059C1541")
        
public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);

            final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
            gravity = a.getInteger(0, Gravity.NO_GRAVITY);
            a.recycle();
        }
        
    }
    
    public interface OnPageChangeListener {
        
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
        
        public void onPageSelected(int position);
        
        public void onPageScrollStateChanged(int state);
    }
    
    interface OnAdapterChangeListener {
        public void onAdapterChanged(PagerAdapter oldAdapter, PagerAdapter newAdapter);
    }
    
    interface Decor {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.548 -0500", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "551369F2F29D29AB7F8957B48A0A5D90")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // Let the focused view and/or our descendants get the key first
        return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    /**
     * You can call this function yourself to have the scroll view perform
     * scrolling from a key event, just as if the event had been dispatched to
     * it by the view hierarchy.
     *
     * @param event The key event to execute.
     * @return Return true if the event was handled, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.551 -0500", hash_original_method = "017D0A0A9E198144CB9BC76029528664", hash_generated_method = "426D4EDFFC97717C83960ED3DA39DBE5")
    
public boolean executeKeyEvent(KeyEvent event) {
        boolean handled = false;
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    handled = arrowScroll(FOCUS_LEFT);
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    handled = arrowScroll(FOCUS_RIGHT);
                    break;
                case KeyEvent.KEYCODE_TAB:
                    if (Build.VERSION.SDK_INT >= 11) {
                        // The focus finder had a bug handling FOCUS_FORWARD and FOCUS_BACKWARD
                        // before Android 3.0. Ignore the tab key on those devices.
                        if (KeyEventCompat.hasNoModifiers(event)) {
                            handled = arrowScroll(FOCUS_FORWARD);
                        } else if (KeyEventCompat.hasModifiers(event, KeyEvent.META_SHIFT_ON)) {
                            handled = arrowScroll(FOCUS_BACKWARD);
                        }
                    }
                    break;
            }
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.554 -0500", hash_original_method = "D3FA41B6A01CF24848855E27CD47D6CF", hash_generated_method = "5B42947A66514085763051B26A7B723D")
    
public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        if (currentFocused == this) currentFocused = null;

        boolean handled = false;

        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused,
                direction);
        if (nextFocused != null && nextFocused != currentFocused) {
            if (direction == View.FOCUS_LEFT) {
                // If there is nothing to the left, or this is causing us to
                // jump to the right, then what we really want to do is page left.
                if (currentFocused != null && nextFocused.getLeft() >= currentFocused.getLeft()) {
                    handled = pageLeft();
                } else {
                    handled = nextFocused.requestFocus();
                }
            } else if (direction == View.FOCUS_RIGHT) {
                // If there is nothing to the right, or this is causing us to
                // jump to the left, then what we really want to do is page right.
                if (currentFocused != null && nextFocused.getLeft() <= currentFocused.getLeft()) {
                    handled = pageRight();
                } else {
                    handled = nextFocused.requestFocus();
                }
            }
        } else if (direction == FOCUS_LEFT || direction == FOCUS_BACKWARD) {
            // Trying to move left and nothing there; try to page.
            handled = pageLeft();
        } else if (direction == FOCUS_RIGHT || direction == FOCUS_FORWARD) {
            // Trying to move right and nothing there; try to page.
            handled = pageRight();
        }
        if (handled) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        }
        return handled;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.556 -0500", hash_original_method = "912A9F83854DBABFF351742D4C2540EB", hash_generated_method = "912A9F83854DBABFF351742D4C2540EB")
    
boolean pageLeft() {
        if (mCurItem > 0) {
            setCurrentItem(mCurItem-1, true);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.558 -0500", hash_original_method = "09CF7C21498AA4945971EA3F1CB23A09", hash_generated_method = "09CF7C21498AA4945971EA3F1CB23A09")
    
boolean pageRight() {
        if (mAdapter != null && mCurItem < (mAdapter.getCount()-1)) {
            setCurrentItem(mCurItem+1, true);
            return true;
        }
        return false;
    }

    /**
     * We only want the current page that is being shown to be focusable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.562 -0500", hash_original_method = "F0A4B928270BC454FADC3A823B922DBC", hash_generated_method = "C79FE15EF53E2B5DB0F472F2B1AFAE09")
    
@Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        final int focusableCount = views.size();

        final int descendantFocusability = getDescendantFocusability();

        if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            for (int i = 0; i < getChildCount(); i++) {
                final View child = getChildAt(i);
                if (child.getVisibility() == VISIBLE) {
                    ItemInfo ii = infoForChild(child);
                    if (ii != null && ii.position == mCurItem) {
                        child.addFocusables(views, direction, focusableMode);
                    }
                }
            }
        }

        // we add ourselves (if focusable) in all cases except for when we are
        // FOCUS_AFTER_DESCENDANTS and there are some descendants focusable.  this is
        // to avoid the focus search finding layouts when a more precise search
        // among the focusable children would be more interesting.
        if (
            descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                // No focusable descendants
                (focusableCount == views.size())) {
            // Note that we can't call the superclass here, because it will
            // add all views in.  So we need to do the same thing View does.
            if (!isFocusable()) {
                return;
            }
            if ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                    isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            if (views != null) {
                views.add(this);
            }
        }
    }

    /**
     * We only want the current page that is being shown to be touchable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.564 -0500", hash_original_method = "B172770A91C5B5BBEA8CA0E8181B4D77", hash_generated_method = "DAEE8B9D3827CFB26140D69D55AD65A6")
    
@Override
    public void addTouchables(ArrayList<View> views) {
        // Note that we don't call super.addTouchables(), which means that
        // we don't call View.addTouchables().  This is okay because a ViewPager
        // is itself not touchable.
        for (int i = 0; i < getChildCount(); i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == VISIBLE) {
                ItemInfo ii = infoForChild(child);
                if (ii != null && ii.position == mCurItem) {
                    child.addTouchables(views);
                }
            }
        }
    }

    /**
     * We only want the current page that is being shown to be focusable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.567 -0500", hash_original_method = "CCC0F1DB24268E606FA269C862549D2B", hash_generated_method = "080A49C88BC2860672F43DD8B43A43C6")
    
@Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        int index;
        int increment;
        int end;
        int count = getChildCount();
        if ((direction & FOCUS_FORWARD) != 0) {
            index = 0;
            increment = 1;
            end = count;
        } else {
            index = count - 1;
            increment = -1;
            end = -1;
        }
        for (int i = index; i != end; i += increment) {
            View child = getChildAt(i);
            if (child.getVisibility() == VISIBLE) {
                ItemInfo ii = infoForChild(child);
                if (ii != null && ii.position == mCurItem) {
                    if (child.requestFocus(direction, previouslyFocusedRect)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.569 -0500", hash_original_method = "1C80A36EDB4BAC430A3311DB8FBFC0D6", hash_generated_method = "102DDBDF51B90F2E675EE7FCF9B6134A")
    
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        // ViewPagers should only report accessibility info for the current page,
        // otherwise things get very confusing.

        // TODO: Should this note something about the paging container?

        final int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() == VISIBLE) {
                final ItemInfo ii = infoForChild(child);
                if (ii != null && ii.position == mCurItem &&
                        child.dispatchPopulateAccessibilityEvent(event)) {
                    return true;
                }
            }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.572 -0500", hash_original_method = "763708F2B4B4E396A96E9D3340F0B010", hash_generated_method = "DA1288B08801ADDE6F9C8699A1A5E871")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.574 -0500", hash_original_method = "D8A26BF8CEB61DB2275E97CE7D907FB8", hash_generated_method = "0B4432410FDF215B1918B71D7F6285D1")
    
@Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return generateDefaultLayoutParams();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.577 -0500", hash_original_method = "0820242DFB1833A79D3A037A247A735A", hash_generated_method = "0FAAF748BA4C1D95221E65EBFCBC4B0B")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams && super.checkLayoutParams(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:24.579 -0500", hash_original_method = "1C9B9BBEC46A39865FCD3A7288415ECD", hash_generated_method = "C4E1D1D633134DBA474501AB48EC2962")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }
}

