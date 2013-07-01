package android.support.v4.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.766 -0400", hash_original_field = "41B6E682666A6CCC9F7FD53F365400D5", hash_generated_field = "4DED95E1F9669C7056C2DE4B99A4DA42")

    private final ArrayList<ItemInfo> mItems = new ArrayList<ItemInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.766 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "2A01FA323E66B8B0477D575256463652")

    private PagerAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.767 -0400", hash_original_field = "1B622A649B9CF8B641EACDE420DF730F", hash_generated_field = "D9FBC86CB22AF6261A48272E212D5541")

    private int mCurItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.767 -0400", hash_original_field = "7F0881F185F366D7C4C89DA2DCFBB5D6", hash_generated_field = "C261E67D50992A5C20799C932967E4BF")

    private int mRestoredCurItem = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.767 -0400", hash_original_field = "80D5932F7DC6B9E1A2D3F90318652EDF", hash_generated_field = "BAEDBA8C3A0D9CA358A825101480570F")

    private Parcelable mRestoredAdapterState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.768 -0400", hash_original_field = "36BB6850115BCB6CF6A775CC42C023D1", hash_generated_field = "0B3271C0D246AD917F0B2BFC0F1E2284")

    private ClassLoader mRestoredClassLoader = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.768 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "AB39B37744A8B63C82246C1F6FE6730F")

    private Scroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.768 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "4DDBCA80DE6A7A07D8A5420B04989903")

    private PagerObserver mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.769 -0400", hash_original_field = "DDBEB3CB51E072971AA69C4D4A8D6589", hash_generated_field = "B27BEE6220E87E8571B1CC02AEF71A81")

    private int mPageMargin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.769 -0400", hash_original_field = "678E22AC030B6DC5A6AA7FC6D4579505", hash_generated_field = "5CB8BE965FCEEA70C5D18EEB2C5B06B9")

    private Drawable mMarginDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.769 -0400", hash_original_field = "39B4059A4EBD276CB2F45AB717B7F07D", hash_generated_field = "E74EA91BBE0E15AAB285398BC1D9022D")

    private int mTopPageBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.770 -0400", hash_original_field = "BA07B67C891F3DF9B5507F2B7B5CE1D7", hash_generated_field = "97C090C7D7510B1CAF63827F11C247DB")

    private int mBottomPageBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.770 -0400", hash_original_field = "93C66B79C1316E4BE0608678F9114134", hash_generated_field = "A9185C0052000A85FA411C5586609D44")

    private int mChildWidthMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.770 -0400", hash_original_field = "B97395F2F3AB7D9372B830DF0BC48F6D", hash_generated_field = "AD5DFC102B7E069BD84ECCA774ECA3DA")

    private int mChildHeightMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.771 -0400", hash_original_field = "02B7C51C439DA5E343271787FAA8C822", hash_generated_field = "AC8E671E2AA7EEF3EC800FAEB4B3A880")

    private boolean mInLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.771 -0400", hash_original_field = "7FB4BC12E46C9E48428AFBC608C49853", hash_generated_field = "525C74FB2020779EE8272F7A1D19F1C6")

    private boolean mScrollingCacheEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.771 -0400", hash_original_field = "78CBA42BBA2A626FF674F2968DBCF641", hash_generated_field = "3615C17B741EA896B2F5EB737A25E37D")

    private boolean mPopulatePending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.771 -0400", hash_original_field = "76EE8357FBE31044043523153FEF3C0F", hash_generated_field = "FD42EA2408DC7BC099DE88D000A67AD2")

    private boolean mScrolling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.772 -0400", hash_original_field = "7F99C82B6BE4E0A3165A1CBB55B8C022", hash_generated_field = "6889C67D111C39C131790ED24D71EAFB")

    private int mOffscreenPageLimit = DEFAULT_OFFSCREEN_PAGES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.772 -0400", hash_original_field = "CD7F83DE880FD2A584529B26609B9552", hash_generated_field = "B59FB434376CFD18468CB8F7DF43173C")

    private boolean mIsBeingDragged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.772 -0400", hash_original_field = "D2B38369C40C71EB69DF0F9CF593481F", hash_generated_field = "748889273C84B9C9E218E6BFA97C24D2")

    private boolean mIsUnableToDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.773 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.773 -0400", hash_original_field = "5777AFD9F80796909E38C49F4EB26657", hash_generated_field = "E8D995D721D911B655A8BA1B8E85A671")

    private float mInitialMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.773 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.774 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.774 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.774 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.775 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.775 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.775 -0400", hash_original_field = "7BF54EA094E873404B9F9B78E013E17C", hash_generated_field = "7F8D995E03C7CD7E0F196759ABA95F5F")

    private int mFlingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.776 -0400", hash_original_field = "A433486E64E1D58A4CCC7C7414F54C8F", hash_generated_field = "986D52A8EA3DCB2BCCE9B03ACB17651B")

    private boolean mFakeDragging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.781 -0400", hash_original_field = "3CE5B0D287DF6DD1EDBE8BBED34023B0", hash_generated_field = "AE83D0D9EE37D7B14D072F1E5F467A1E")

    private long mFakeDragBeginTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.781 -0400", hash_original_field = "CBB789948681D2B6CC5E9F151EA9F4E9", hash_generated_field = "9E249B56B7CAFDEEC5F0C85DF1584FF5")

    private EdgeEffectCompat mLeftEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.782 -0400", hash_original_field = "7E7953405F64EE99C6316AD67D90567C", hash_generated_field = "1100A29EE0D913080378CCB73190893C")

    private EdgeEffectCompat mRightEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.782 -0400", hash_original_field = "B846D45E3DA2FA84A2AEED6B3F297C15", hash_generated_field = "D2103C384BE0AB58542D96A0CD23C256")

    private boolean mFirstLayout = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.782 -0400", hash_original_field = "2B31708C283988DC9180CFF9247B0BB2", hash_generated_field = "0C8F00C2B17489007C5F8140505FF30F")

    private boolean mCalledSuper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.783 -0400", hash_original_field = "E737D9A665B1357B878B62E10F10BA85", hash_generated_field = "64518C389A512872C2826132B5A07F9F")

    private int mDecorChildCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.783 -0400", hash_original_field = "8FC6495F72130DD9579EAE0AF30D9792", hash_generated_field = "EE99805AC43858C068324B36ED28179F")

    private OnPageChangeListener mOnPageChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.783 -0400", hash_original_field = "6BA7D2CBD59FE696B26780EEABAEA515", hash_generated_field = "1F25B0C85CAD75C221F1467E6925256A")

    private OnPageChangeListener mInternalPageChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.784 -0400", hash_original_field = "77972A353C956888CCB6D5FF6DAEBC65", hash_generated_field = "2E3B1499B0D138F9C25DFFF849DEACEA")

    private OnAdapterChangeListener mAdapterChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.784 -0400", hash_original_field = "A671F6478D41E19963F2CBD7C42AC5E7", hash_generated_field = "1E68982A83C4D0C6AC923C110AE0A857")

    private int mScrollState = SCROLL_STATE_IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.785 -0400", hash_original_method = "167A05D4ABF68D419B8302604913DA0C", hash_generated_method = "1FE98634F091AF5A7F10EF697B97D6FF")
    public  ViewPager(Context context) {
        super(context);
        initViewPager();
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //initViewPager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.785 -0400", hash_original_method = "2DA5D82366012C7A6B734AF18B26B0B4", hash_generated_method = "24A79244595F18E3EBAD86864D624248")
    public  ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewPager();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //initViewPager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.789 -0400", hash_original_method = "DBB36B523BACF2E8831A0769B3639908", hash_generated_method = "583C6C03733EA78625EBDDD3A0EA4D2B")
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
        // ---------- Original Method ----------
        //setWillNotDraw(false);
        //setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        //setFocusable(true);
        //final Context context = getContext();
        //mScroller = new Scroller(context, sInterpolator);
        //final ViewConfiguration configuration = ViewConfiguration.get(context);
        //mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
        //mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        //mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        //mLeftEdge = new EdgeEffectCompat(context);
        //mRightEdge = new EdgeEffectCompat(context);
        //final float density = context.getResources().getDisplayMetrics().density;
        //mFlingDistance = (int) (MIN_DISTANCE_FOR_FLING * density);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.791 -0400", hash_original_method = "80EB60C09FE5B35C976F87EEFD89447E", hash_generated_method = "60402BFECBAE6FD075AB1B24DD17743F")
    private void setScrollState(int newState) {
        mScrollState = newState;
        {
            mOnPageChangeListener.onPageScrollStateChanged(newState);
        } //End block
        // ---------- Original Method ----------
        //if (mScrollState == newState) {
            //return;
        //}
        //mScrollState = newState;
        //if (mOnPageChangeListener != null) {
            //mOnPageChangeListener.onPageScrollStateChanged(newState);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.796 -0400", hash_original_method = "5B308B647844A5E9AE37DC79927B0D79", hash_generated_method = "F658E9CA399371DD9B9E9E08269DAC18")
    public void setAdapter(PagerAdapter adapter) {
        {
            mAdapter.unregisterDataSetObserver(mObserver);
            mAdapter.startUpdate(this);
            {
                int i = 0;
                boolean var07785F45BCF44D8B9F72D8C8791E045F_1555414857 = (i < mItems.size());
                {
                    final ItemInfo ii = mItems.get(i);
                    mAdapter.destroyItem(this, ii.position, ii.object);
                } //End block
            } //End collapsed parenthetic
            mAdapter.finishUpdate(this);
            mItems.clear();
            removeNonDecorViews();
            mCurItem = 0;
            scrollTo(0, 0);
        } //End block
        final PagerAdapter oldAdapter = mAdapter;
        mAdapter = adapter;
        {
            {
                mObserver = new PagerObserver();
            } //End block
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } //End block
            {
                populate();
            } //End block
        } //End block
        {
            mAdapterChangeListener.onAdapterChanged(oldAdapter, adapter);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.798 -0400", hash_original_method = "18421C7E85141EF2E7552011BA442EAC", hash_generated_method = "2724F4AEA64E2D5987FF486D9261ADC0")
    private void removeNonDecorViews() {
        {
            int i = 0;
            boolean var975114E76385FFBE15AB4C8EBFE89070_1506855103 = (i < getChildCount());
            {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                {
                    removeViewAt(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < getChildCount(); i++) {
            //final View child = getChildAt(i);
            //final LayoutParams lp = (LayoutParams) child.getLayoutParams();
            //if (!lp.isDecor) {
                //removeViewAt(i);
                //i--;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.800 -0400", hash_original_method = "F7E052C477B11777DA7EBFEE8452F40F", hash_generated_method = "ACB94D56AB7A7353028CF6EF8C33F916")
    public PagerAdapter getAdapter() {
        PagerAdapter varB4EAC82CA7396A68D541C85D26508E83_1884748645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1884748645 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1884748645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1884748645;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.801 -0400", hash_original_method = "36FAA41620F55873E46894195D62C0FE", hash_generated_method = "64B5029EE6627AF5DA8D33AFBF5EB153")
     void setOnAdapterChangeListener(OnAdapterChangeListener listener) {
        mAdapterChangeListener = listener;
        // ---------- Original Method ----------
        //mAdapterChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.802 -0400", hash_original_method = "7A2B970E4C717952A0CD3574FF0FD69D", hash_generated_method = "62E13A56F175F7FBB4A65EE925BF53FD")
    public void setCurrentItem(int item) {
        mPopulatePending = false;
        setCurrentItemInternal(item, !mFirstLayout, false);
        addTaint(item);
        // ---------- Original Method ----------
        //mPopulatePending = false;
        //setCurrentItemInternal(item, !mFirstLayout, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.803 -0400", hash_original_method = "F21F60BCB144D38A5AE0B59AB369F197", hash_generated_method = "942C693175D8DDFDE1395C7C2BFA7D66")
    public void setCurrentItem(int item, boolean smoothScroll) {
        mPopulatePending = false;
        setCurrentItemInternal(item, smoothScroll, false);
        addTaint(item);
        addTaint(smoothScroll);
        // ---------- Original Method ----------
        //mPopulatePending = false;
        //setCurrentItemInternal(item, smoothScroll, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.804 -0400", hash_original_method = "A82ABDE9609B8643904FAA59A05D3729", hash_generated_method = "C44E7210C4D7EE35840F4DFCC47EA880")
    public int getCurrentItem() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989134782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989134782;
        // ---------- Original Method ----------
        //return mCurItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.804 -0400", hash_original_method = "975AAD75311F294CDFC8362C48B3CCF3", hash_generated_method = "3FEF24C64B844075EA215DF911D7EFF5")
     void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        setCurrentItemInternal(item, smoothScroll, always, 0);
        addTaint(item);
        addTaint(smoothScroll);
        addTaint(always);
        // ---------- Original Method ----------
        //setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.810 -0400", hash_original_method = "4CC7A0E676B55FB5E3215627D71CB3FB", hash_generated_method = "6800C8EEE55F948E848B268693442059")
     void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        {
            boolean var184EA15FF1BD060C518D5D840F10745C_563704144 = (mAdapter == null || mAdapter.getCount() <= 0);
            {
                setScrollingCacheEnabled(false);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varE9CF88A8743AA53D96A667DB46509CB6_1939981080 = (!always && mCurItem == item && mItems.size() != 0);
            {
                setScrollingCacheEnabled(false);
            } //End block
        } //End collapsed parenthetic
        {
            item = 0;
        } //End block
        {
            boolean var276A79D1E09E9FD0736BCDF9883FEC47_1418989406 = (item >= mAdapter.getCount());
            {
                item = mAdapter.getCount() - 1;
            } //End block
        } //End collapsed parenthetic
        final int pageLimit = mOffscreenPageLimit;
        {
            {
                int i = 0;
                boolean var96BE0E09AF82E1926A30E64302853022_583324960 = (i<mItems.size());
                {
                    mItems.get(i).scrolling = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        final boolean dispatchSelected = mCurItem != item;
        mCurItem = item;
        populate();
        final int destX = (getWidth() + mPageMargin) * item;
        {
            smoothScrollTo(destX, 0, velocity);
            {
                mOnPageChangeListener.onPageSelected(item);
            } //End block
            {
                mInternalPageChangeListener.onPageSelected(item);
            } //End block
        } //End block
        {
            {
                mOnPageChangeListener.onPageSelected(item);
            } //End block
            {
                mInternalPageChangeListener.onPageSelected(item);
            } //End block
            completeScroll();
            scrollTo(destX, 0);
        } //End block
        addTaint(smoothScroll);
        addTaint(always);
        addTaint(velocity);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.812 -0400", hash_original_method = "FA06973225A603572F4FD6150255295F", hash_generated_method = "8762A57EBF81138B887037B32512FF60")
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        mOnPageChangeListener = listener;
        // ---------- Original Method ----------
        //mOnPageChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.813 -0400", hash_original_method = "BEC1D9D7EF0862149EE21D17618B274F", hash_generated_method = "7DC63B29E68293BEDF9A398ADD41F340")
     OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener varB4EAC82CA7396A68D541C85D26508E83_1680763602 = null; //Variable for return #1
        OnPageChangeListener oldListener = mInternalPageChangeListener;
        mInternalPageChangeListener = listener;
        varB4EAC82CA7396A68D541C85D26508E83_1680763602 = oldListener;
        varB4EAC82CA7396A68D541C85D26508E83_1680763602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1680763602;
        // ---------- Original Method ----------
        //OnPageChangeListener oldListener = mInternalPageChangeListener;
        //mInternalPageChangeListener = listener;
        //return oldListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.814 -0400", hash_original_method = "3F35BC951292D9FB1DF42BFA6208CE75", hash_generated_method = "4DB8F8D340EAC8319A5C4EE48B919CF9")
    public int getOffscreenPageLimit() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372994476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372994476;
        // ---------- Original Method ----------
        //return mOffscreenPageLimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.816 -0400", hash_original_method = "A74A93D6A42C43F22E5B6055DA99B3A5", hash_generated_method = "13BA39168AD00431F7E33B7FF56F0022")
    public void setOffscreenPageLimit(int limit) {
        {
            limit = DEFAULT_OFFSCREEN_PAGES;
        } //End block
        {
            mOffscreenPageLimit = limit;
            populate();
        } //End block
        // ---------- Original Method ----------
        //if (limit < DEFAULT_OFFSCREEN_PAGES) {
            //Log.w(TAG, "Requested offscreen page limit " + limit + " too small; defaulting to " +
                    //DEFAULT_OFFSCREEN_PAGES);
            //limit = DEFAULT_OFFSCREEN_PAGES;
        //}
        //if (limit != mOffscreenPageLimit) {
            //mOffscreenPageLimit = limit;
            //populate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.817 -0400", hash_original_method = "828EEBFA53113FADBEB7FC44B9C61C3C", hash_generated_method = "BD2552D411CB0940E31029A9F1317733")
    public void setPageMargin(int marginPixels) {
        final int oldMargin = mPageMargin;
        mPageMargin = marginPixels;
        final int width = getWidth();
        recomputeScrollPosition(width, width, marginPixels, oldMargin);
        requestLayout();
        // ---------- Original Method ----------
        //final int oldMargin = mPageMargin;
        //mPageMargin = marginPixels;
        //final int width = getWidth();
        //recomputeScrollPosition(width, width, marginPixels, oldMargin);
        //requestLayout();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.818 -0400", hash_original_method = "C374880A4C36BA236EE3B5602129BC09", hash_generated_method = "293842908FF458870EC23EB766652722")
    public int getPageMargin() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960206824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960206824;
        // ---------- Original Method ----------
        //return mPageMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.820 -0400", hash_original_method = "BA05FEAA10A774C185287C0B628011BB", hash_generated_method = "E181A09A77D577FEAB9757103B029786")
    public void setPageMarginDrawable(Drawable d) {
        mMarginDrawable = d;
        refreshDrawableState();
        setWillNotDraw(d == null);
        invalidate();
        // ---------- Original Method ----------
        //mMarginDrawable = d;
        //if (d != null) refreshDrawableState();
        //setWillNotDraw(d == null);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.821 -0400", hash_original_method = "194EE6D0EDD674D9D2DE52CA6B5FC234", hash_generated_method = "94F35DE2CAB5F9353C799FDB0D488F33")
    public void setPageMarginDrawable(int resId) {
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.822 -0400", hash_original_method = "5339E87F28FFED611E3042BEB812570C", hash_generated_method = "DC821836270DBEAB38434A80EFBAD9D1")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        boolean varF9ADF43AFC075ECCE6B63E67C822A782_587609075 = (super.verifyDrawable(who) || who == mMarginDrawable);
        addTaint(who.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811823900 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_811823900;
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || who == mMarginDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.824 -0400", hash_original_method = "D9869A333EE5ABB30D7044AE2CBD85F6", hash_generated_method = "9BD079BE1DE2887E0AE9782AEAACF1FD")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable d = mMarginDrawable;
        {
            boolean var9E4512E9555DA1255DDDA9AE20837176_2061158031 = (d != null && d.isStateful());
            {
                d.setState(getDrawableState());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //final Drawable d = mMarginDrawable;
        //if (d != null && d.isStateful()) {
            //d.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.826 -0400", hash_original_method = "3937E06E79A8643FB4C5C1D74E3AE99C", hash_generated_method = "FC56CBB5FE0DEB4FAD22D1C17EBE69EF")
     float distanceInfluenceForSnapDuration(float f) {
        f -= 0.5f;
        f *= 0.3f * Math.PI / 2.0f;
        float var9DF2F20ADCBDCB7CF29A50231AEB7584_49761091 = ((float) Math.sin(f));
        addTaint(f);
        float var546ADE640B6EDFBC8A086EF31347E768_776191013 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_776191013;
        // ---------- Original Method ----------
        //f -= 0.5f;
        //f *= 0.3f * Math.PI / 2.0f;
        //return (float) Math.sin(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.826 -0400", hash_original_method = "BC18C642FF487E008261AE9ED73575D8", hash_generated_method = "C3159A2D96F7C5E99706D1DFD232D7E3")
     void smoothScrollTo(int x, int y) {
        smoothScrollTo(x, y, 0);
        addTaint(x);
        addTaint(y);
        // ---------- Original Method ----------
        //smoothScrollTo(x, y, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.831 -0400", hash_original_method = "A4DABDC2D7B52B75CD4B2F9017BAC5A7", hash_generated_method = "1187D0776BDEBBA39AC4FA0E0017B3D6")
     void smoothScrollTo(int x, int y, int velocity) {
        {
            boolean varF370735710C80808B6618BA2D491D045_954322531 = (getChildCount() == 0);
            {
                setScrollingCacheEnabled(false);
            } //End block
        } //End collapsed parenthetic
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        {
            completeScroll();
            setScrollState(SCROLL_STATE_IDLE);
        } //End block
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
        {
            duration = 4 * Math.round(1000 * Math.abs(distance / velocity));
        } //End block
        {
            final float pageDelta = (float) Math.abs(dx) / (width + mPageMargin);
            duration = (int) ((pageDelta + 1) * 100);
        } //End block
        duration = Math.min(duration, MAX_SETTLE_DURATION);
        mScroller.startScroll(sx, sy, dx, dy, duration);
        invalidate();
        addTaint(x);
        addTaint(y);
        addTaint(velocity);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.834 -0400", hash_original_method = "4F6A5F0B8F2759342FC6F742F3401D82", hash_generated_method = "E6FBFC7F97444E34E4F7FCCC143344D7")
     void addNewItem(int position, int index) {
        ItemInfo ii = new ItemInfo();
        ii.position = position;
        ii.object = mAdapter.instantiateItem(this, position);
        {
            mItems.add(ii);
        } //End block
        {
            mItems.add(index, ii);
        } //End block
        addTaint(position);
        addTaint(index);
        // ---------- Original Method ----------
        //ItemInfo ii = new ItemInfo();
        //ii.position = position;
        //ii.object = mAdapter.instantiateItem(this, position);
        //if (index < 0) {
            //mItems.add(ii);
        //} else {
            //mItems.add(index, ii);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.854 -0400", hash_original_method = "0F425711D6B8C5B4FAAE039431564D7B", hash_generated_method = "9315ACE54687261963D17818B3B648B4")
     void dataSetChanged() {
        boolean needPopulate = mItems.size() < 3 && mItems.size() < mAdapter.getCount();
        int newCurrItem = -1;
        boolean isUpdating = false;
        {
            int i = 0;
            boolean varA716E64F67CDF20935B927C1360A38E4_81933574 = (i < mItems.size());
            {
                final ItemInfo ii = mItems.get(i);
                final int newPos = mAdapter.getItemPosition(ii.object);
                {
                    mItems.remove(i);
                    {
                        mAdapter.startUpdate(this);
                        isUpdating = true;
                    } //End block
                    mAdapter.destroyItem(this, ii.position, ii.object);
                    needPopulate = true;
                    {
                        newCurrItem = Math.max(0, Math.min(mCurItem, mAdapter.getCount() - 1));
                    } //End block
                } //End block
                {
                    {
                        newCurrItem = newPos;
                    } //End block
                    ii.position = newPos;
                    needPopulate = true;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mAdapter.finishUpdate(this);
        } //End block
        Collections.sort(mItems, COMPARATOR);
        {
            setCurrentItemInternal(newCurrItem, false, true);
            needPopulate = true;
        } //End block
        {
            populate();
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.879 -0400", hash_original_method = "70E539FA9A51CF2C9CD07D50F5400EB2", hash_generated_method = "8A587E31F9FBF7DE2493F50BFA0891F3")
     void populate() {
        {
            boolean varFF25C8C36D549896D247167EFDFCA86E_397259757 = (getWindowToken() == null);
        } //End collapsed parenthetic
        mAdapter.startUpdate(this);
        final int pageLimit = mOffscreenPageLimit;
        final int startPos = Math.max(0, mCurItem - pageLimit);
        final int N = mAdapter.getCount();
        final int endPos = Math.min(N-1, mCurItem + pageLimit);
        int lastPos = -1;
        {
            int i = 0;
            boolean var4A4E0EDDD1AFF42E2EABF8E0CFCE012A_1511327789 = (i<mItems.size());
            {
                ItemInfo ii = mItems.get(i);
                {
                    mItems.remove(i);
                    mAdapter.destroyItem(this, ii.position, ii.object);
                } //End block
                {
                    {
                        lastPos = startPos;
                    } //End block
                    {
                        addNewItem(lastPos, i);
                    } //End block
                } //End block
                lastPos = ii.position;
            } //End block
        } //End collapsed parenthetic
        lastPos = mItems.size() > 0 ? mItems.get(mItems.size()-1).position : -1;
        {
            lastPos = lastPos > startPos ? lastPos : startPos;
            {
                addNewItem(lastPos, -1);
            } //End block
        } //End block
        {
            {
                int i = 0;
                boolean var96BE0E09AF82E1926A30E64302853022_1736115571 = (i<mItems.size());
            } //End collapsed parenthetic
        } //End block
        ItemInfo curItem = null;
        {
            int i = 0;
            boolean var4A4E0EDDD1AFF42E2EABF8E0CFCE012A_1986228340 = (i<mItems.size());
            {
                {
                    boolean var526B7F7BBC73C99EEE08171F1332ADF1_995790219 = (mItems.get(i).position == mCurItem);
                    {
                        curItem = mItems.get(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mAdapter.setPrimaryItem(this, mCurItem, curItem != null ? curItem.object : null);
        mAdapter.finishUpdate(this);
        {
            boolean var259F50F8497D3BA1A7549233FDA86E87_1837174529 = (hasFocus());
            {
                View currentFocused = findFocus();
                ItemInfo ii;
                ii = infoForAnyChild(currentFocused);
                ii = null;
                {
                    {
                        int i = 0;
                        boolean var871481332F24A039FC7F63C552963614_989871452 = (i<getChildCount());
                        {
                            View child = getChildAt(i);
                            ii = infoForChild(child);
                            {
                                {
                                    boolean var072CF4168F0C6139F56B61877BD695C3_1952962439 = (child.requestFocus(FOCUS_FORWARD));
                                } //End collapsed parenthetic
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.884 -0400", hash_original_method = "14189B7A9DD30FC59304078756C5DA79", hash_generated_method = "999CBF77434386B2C48823E0C4A4E2B6")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1892189077 = null; //Variable for return #1
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.position = mCurItem;
        {
            ss.adapterState = mAdapter.saveState();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1892189077 = ss;
        varB4EAC82CA7396A68D541C85D26508E83_1892189077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1892189077;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.position = mCurItem;
        //if (mAdapter != null) {
            //ss.adapterState = mAdapter.saveState();
        //}
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.887 -0400", hash_original_method = "D24913A88F27B9FFD16DBB95EA1FF14B", hash_generated_method = "615B8CAE8F5C5EED0B2319C444A1EC36")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            super.onRestoreInstanceState(state);
        } //End block
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        {
            mAdapter.restoreState(ss.adapterState, ss.loader);
            setCurrentItemInternal(ss.position, false, true);
        } //End block
        {
            mRestoredCurItem = ss.position;
            mRestoredAdapterState = ss.adapterState;
            mRestoredClassLoader = ss.loader;
        } //End block
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //if (!(state instanceof SavedState)) {
            //super.onRestoreInstanceState(state);
            //return;
        //}
        //SavedState ss = (SavedState)state;
        //super.onRestoreInstanceState(ss.getSuperState());
        //if (mAdapter != null) {
            //mAdapter.restoreState(ss.adapterState, ss.loader);
            //setCurrentItemInternal(ss.position, false, true);
        //} else {
            //mRestoredCurItem = ss.position;
            //mRestoredAdapterState = ss.adapterState;
            //mRestoredClassLoader = ss.loader;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.892 -0400", hash_original_method = "CCA2D7E19B51FD6942892776091DF304", hash_generated_method = "D806C0281C4B4DDAA5A59CBC57B3B869")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_1832158335 = (!checkLayoutParams(params));
            {
                params = generateLayoutParams(params);
            } //End block
        } //End collapsed parenthetic
        final LayoutParams lp = (LayoutParams) params;
        lp.isDecor |= child instanceof Decor;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot add pager decor view during layout");
            } //End block
            addViewInLayout(child, index, params);
            child.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
        } //End block
        {
            super.addView(child, index, params);
        } //End block
        {
            {
                boolean var4F747A471234350315F8F3D956EB4E30_1706727846 = (child.getVisibility() != GONE);
                {
                    child.setDrawingCacheEnabled(mScrollingCacheEnabled);
                } //End block
                {
                    child.setDrawingCacheEnabled(false);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.895 -0400", hash_original_method = "3A127F64616A326BFDC211D8F4FB8341", hash_generated_method = "BCDC40F23CF5DE3495464D301860E9C3")
     ItemInfo infoForChild(View child) {
        ItemInfo varB4EAC82CA7396A68D541C85D26508E83_253027878 = null; //Variable for return #1
        ItemInfo varB4EAC82CA7396A68D541C85D26508E83_776832013 = null; //Variable for return #2
        {
            int i = 0;
            boolean var4A4E0EDDD1AFF42E2EABF8E0CFCE012A_873230392 = (i<mItems.size());
            {
                ItemInfo ii = mItems.get(i);
                {
                    boolean var1849777874F0A223C6B5DC629A9D42F2_792536310 = (mAdapter.isViewFromObject(child, ii.object));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_253027878 = ii;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_776832013 = null;
        addTaint(child.getTaint());
        ItemInfo varA7E53CE21691AB073D9660D615818899_1695655402; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1695655402 = varB4EAC82CA7396A68D541C85D26508E83_253027878;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1695655402 = varB4EAC82CA7396A68D541C85D26508E83_776832013;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1695655402.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1695655402;
        // ---------- Original Method ----------
        //for (int i=0; i<mItems.size(); i++) {
            //ItemInfo ii = mItems.get(i);
            //if (mAdapter.isViewFromObject(child, ii.object)) {
                //return ii;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.898 -0400", hash_original_method = "1D0A995632EA6711A9479487500A682E", hash_generated_method = "D4BEA9FAEB6A052A74F6109515BA3BD5")
     ItemInfo infoForAnyChild(View child) {
        ItemInfo varB4EAC82CA7396A68D541C85D26508E83_1221124580 = null; //Variable for return #1
        ItemInfo varB4EAC82CA7396A68D541C85D26508E83_130257036 = null; //Variable for return #2
        ViewParent parent;
        {
            boolean var285CA96223EDDDC809B74A05CC171846_700622119 = ((parent=child.getParent()) != this);
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1221124580 = null;
                } //End block
                child = (View)parent;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_130257036 = infoForChild(child);
        addTaint(child.getTaint());
        ItemInfo varA7E53CE21691AB073D9660D615818899_345606546; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_345606546 = varB4EAC82CA7396A68D541C85D26508E83_1221124580;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_345606546 = varB4EAC82CA7396A68D541C85D26508E83_130257036;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_345606546.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_345606546;
        // ---------- Original Method ----------
        //ViewParent parent;
        //while ((parent=child.getParent()) != this) {
            //if (parent == null || !(parent instanceof View)) {
                //return null;
            //}
            //child = (View)parent;
        //}
        //return infoForChild(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.899 -0400", hash_original_method = "55E78F1E2A11C365755D77C284D387A2", hash_generated_method = "F620B046D3F9AED0D5778C8B88C50DA3")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mFirstLayout = true;
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //mFirstLayout = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.907 -0400", hash_original_method = "52B64CDCDB17F6464B1AA9D44D4C5C01", hash_generated_method = "789AE9528988B4F2EABFEFA054494934")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int childHeightSize = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int size = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_932622243 = (child.getVisibility() != GONE);
                    {
                        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                        {
                            final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                            final int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
                            Log.d(TAG, "gravity: " + lp.gravity + " hgrav: " + hgrav + " vgrav: " + vgrav);
                            int widthMode = MeasureSpec.AT_MOST;
                            int heightMode = MeasureSpec.AT_MOST;
                            boolean consumeVertical = vgrav == Gravity.TOP || vgrav == Gravity.BOTTOM;
                            boolean consumeHorizontal = hgrav == Gravity.LEFT || hgrav == Gravity.RIGHT;
                            {
                                widthMode = MeasureSpec.EXACTLY;
                            } //End block
                            {
                                heightMode = MeasureSpec.EXACTLY;
                            } //End block
                            final int widthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, widthMode);
                            final int heightSpec = MeasureSpec.makeMeasureSpec(childHeightSize, heightMode);
                            child.measure(widthSpec, heightSpec);
                            {
                                childHeightSize -= child.getMeasuredHeight();
                            } //End block
                            {
                                childWidthSize -= child.getMeasuredWidth();
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeightSize, MeasureSpec.EXACTLY);
        mInLayout = true;
        populate();
        mInLayout = false;
        size = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1267007760 = (child.getVisibility() != GONE);
                    {
                        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                        {
                            child.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.910 -0400", hash_original_method = "D136D70D1C0AC62B68634CD89991503C", hash_generated_method = "7F993C9975B6FC2273EFA387BD115A55")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onSizeChanged(w, h, oldw, oldh);
        {
            recomputeScrollPosition(w, oldw, mPageMargin, mPageMargin);
        } //End block
        addTaint(w);
        addTaint(h);
        addTaint(oldw);
        addTaint(oldh);
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //if (w != oldw) {
            //recomputeScrollPosition(w, oldw, mPageMargin, mPageMargin);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.913 -0400", hash_original_method = "BF2EFCA6E1F80930784A0AE156969F1F", hash_generated_method = "E9D5F074D59A2B5A5AF7E3CE9DDCADC6")
    private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        final int widthWithMargin = width + margin;
        {
            final int oldScrollPos = getScrollX();
            final int oldwwm = oldWidth + oldMargin;
            final int oldScrollItem = oldScrollPos / oldwwm;
            final float scrollOffset = (float) (oldScrollPos % oldwwm) / oldwwm;
            final int scrollPos = (int) ((oldScrollItem + scrollOffset) * widthWithMargin);
            scrollTo(scrollPos, getScrollY());
            {
                boolean var11F6C92CC339B9B3B7C0C85A8DBD1165_1660032058 = (!mScroller.isFinished());
                {
                    final int newDuration = mScroller.getDuration() - mScroller.timePassed();
                    mScroller.startScroll(scrollPos, 0, mCurItem * widthWithMargin, 0, newDuration);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            int scrollPos = mCurItem * widthWithMargin;
            {
                boolean var4D677DE232687867CCEFB1130F8BB4EC_1979215423 = (scrollPos != getScrollX());
                {
                    completeScroll();
                    scrollTo(scrollPos, getScrollY());
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(width);
        addTaint(oldWidth);
        addTaint(margin);
        addTaint(oldMargin);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.934 -0400", hash_original_method = "91DBAE2CED1324F5F1E91DEC22CE5EE7", hash_generated_method = "0E7D1F43CA46F81CBD4637F2A9796B18")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var6B4F6D9B07C374A63E00C1591AF2C9D6_1166341664 = (child.getVisibility() != GONE);
                    {
                        final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                        ItemInfo ii;
                        int childLeft = 0;
                        int childTop = 0;
                        {
                            final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                            final int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
                            //Begin case default 
                            childLeft = paddingLeft;
                            //End case default 
                            //Begin case Gravity.LEFT 
                            childLeft = paddingLeft;
                            //End case Gravity.LEFT 
                            //Begin case Gravity.LEFT 
                            paddingLeft += child.getMeasuredWidth();
                            //End case Gravity.LEFT 
                            //Begin case Gravity.CENTER_HORIZONTAL 
                            childLeft = Math.max((width - child.getMeasuredWidth()) / 2,
                                    paddingLeft);
                            //End case Gravity.CENTER_HORIZONTAL 
                            //Begin case Gravity.RIGHT 
                            childLeft = width - paddingRight - child.getMeasuredWidth();
                            //End case Gravity.RIGHT 
                            //Begin case Gravity.RIGHT 
                            paddingRight += child.getMeasuredWidth();
                            //End case Gravity.RIGHT 
                            //Begin case default 
                            childTop = paddingTop;
                            //End case default 
                            //Begin case Gravity.TOP 
                            childTop = paddingTop;
                            //End case Gravity.TOP 
                            //Begin case Gravity.TOP 
                            paddingTop += child.getMeasuredHeight();
                            //End case Gravity.TOP 
                            //Begin case Gravity.CENTER_VERTICAL 
                            childTop = Math.max((height - child.getMeasuredHeight()) / 2,
                                    paddingTop);
                            //End case Gravity.CENTER_VERTICAL 
                            //Begin case Gravity.BOTTOM 
                            childTop = height - paddingBottom - child.getMeasuredHeight();
                            //End case Gravity.BOTTOM 
                            //Begin case Gravity.BOTTOM 
                            paddingBottom += child.getMeasuredHeight();
                            //End case Gravity.BOTTOM 
                            childLeft += scrollX;
                            child.layout(childLeft, childTop,
                            childLeft + child.getMeasuredWidth(),
                            childTop + child.getMeasuredHeight());
                        } //End block
                        {
                            boolean varCA3C1135218ED5E6E7022FFF410323BE_617682050 = ((ii = infoForChild(child)) != null);
                            {
                                int loff = (width + mPageMargin) * ii.position;
                                childLeft = paddingLeft + loff;
                                childTop = paddingTop;
                                child.layout(childLeft, childTop,
                            childLeft + child.getMeasuredWidth(),
                            childTop + child.getMeasuredHeight());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mTopPageBounds = paddingTop;
        mBottomPageBounds = height - paddingBottom;
        mDecorChildCount = decorCount;
        mFirstLayout = false;
        addTaint(changed);
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.943 -0400", hash_original_method = "245E7C909F76590CC461C5035FA848B9", hash_generated_method = "1EBD61B5013947FA2D915A212393A3F6")
    @Override
    public void computeScroll() {
        {
            boolean var2844BA5E42FD344CC642021B350DFDAC_1633487653 = (!mScroller.isFinished());
            {
                {
                    boolean varB2BF8492E7E3B383F95A8D09DA3F1795_1349985531 = (mScroller.computeScrollOffset());
                    {
                        int oldX = getScrollX();
                        int oldY = getScrollY();
                        int x = mScroller.getCurrX();
                        int y = mScroller.getCurrY();
                        {
                            scrollTo(x, y);
                            pageScrolled(x);
                        } //End block
                        invalidate();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        completeScroll();
        // ---------- Original Method ----------
        //if (DEBUG) Log.i(TAG, "computeScroll: finished=" + mScroller.isFinished());
        //if (!mScroller.isFinished()) {
            //if (mScroller.computeScrollOffset()) {
                //if (DEBUG) Log.i(TAG, "computeScroll: still scrolling");
                //int oldX = getScrollX();
                //int oldY = getScrollY();
                //int x = mScroller.getCurrX();
                //int y = mScroller.getCurrY();
                //if (oldX != x || oldY != y) {
                    //scrollTo(x, y);
                    //pageScrolled(x);
                //}
                //invalidate();
                //return;
            //}
        //}
        //completeScroll();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.944 -0400", hash_original_method = "07505BF167DC29F6F179D71B0816840E", hash_generated_method = "89DE1061E9CC2C7358EB003BDADC0D33")
    private void pageScrolled(int xpos) {
        final int widthWithMargin = getWidth() + mPageMargin;
        final int position = xpos / widthWithMargin;
        final int offsetPixels = xpos % widthWithMargin;
        final float offset = (float) offsetPixels / widthWithMargin;
        mCalledSuper = false;
        onPageScrolled(position, offset, offsetPixels);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "onPageScrolled did not call superclass implementation");
        } //End block
        addTaint(xpos);
        // ---------- Original Method ----------
        //final int widthWithMargin = getWidth() + mPageMargin;
        //final int position = xpos / widthWithMargin;
        //final int offsetPixels = xpos % widthWithMargin;
        //final float offset = (float) offsetPixels / widthWithMargin;
        //mCalledSuper = false;
        //onPageScrolled(position, offset, offsetPixels);
        //if (!mCalledSuper) {
            //throw new IllegalStateException(
                    //"onPageScrolled did not call superclass implementation");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.949 -0400", hash_original_method = "D3205253D12342035E86376912330E75", hash_generated_method = "7607BB24AD4CEA884A79511061EC88A1")
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            final int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            final int width = getWidth();
            final int childCount = getChildCount();
            {
                int i = 0;
                {
                    final View child = getChildAt(i);
                    final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                    final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                    int childLeft = 0;
                    //Begin case default 
                    childLeft = paddingLeft;
                    //End case default 
                    //Begin case Gravity.LEFT 
                    childLeft = paddingLeft;
                    //End case Gravity.LEFT 
                    //Begin case Gravity.LEFT 
                    paddingLeft += child.getWidth();
                    //End case Gravity.LEFT 
                    //Begin case Gravity.CENTER_HORIZONTAL 
                    childLeft = Math.max((width - child.getMeasuredWidth()) / 2,
                                paddingLeft);
                    //End case Gravity.CENTER_HORIZONTAL 
                    //Begin case Gravity.RIGHT 
                    childLeft = width - paddingRight - child.getMeasuredWidth();
                    //End case Gravity.RIGHT 
                    //Begin case Gravity.RIGHT 
                    paddingRight += child.getMeasuredWidth();
                    //End case Gravity.RIGHT 
                    childLeft += scrollX;
                    final int childOffset = childLeft - child.getLeft();
                    {
                        child.offsetLeftAndRight(childOffset);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mOnPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        } //End block
        {
            mInternalPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        } //End block
        mCalledSuper = true;
        addTaint(position);
        addTaint(offset);
        addTaint(offsetPixels);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.953 -0400", hash_original_method = "B1229287A4B4E18886EBB2FC1C1A6ECA", hash_generated_method = "607506831BB0E6D56A17259250B7B5AC")
    private void completeScroll() {
        boolean needPopulate = mScrolling;
        {
            setScrollingCacheEnabled(false);
            mScroller.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            {
                scrollTo(x, y);
            } //End block
            setScrollState(SCROLL_STATE_IDLE);
        } //End block
        mPopulatePending = false;
        mScrolling = false;
        {
            int i = 0;
            boolean var4A4E0EDDD1AFF42E2EABF8E0CFCE012A_515147157 = (i<mItems.size());
            {
                ItemInfo ii = mItems.get(i);
                {
                    needPopulate = true;
                    ii.scrolling = false;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            populate();
        } //End block
        // ---------- Original Method ----------
        //boolean needPopulate = mScrolling;
        //if (needPopulate) {
            //setScrollingCacheEnabled(false);
            //mScroller.abortAnimation();
            //int oldX = getScrollX();
            //int oldY = getScrollY();
            //int x = mScroller.getCurrX();
            //int y = mScroller.getCurrY();
            //if (oldX != x || oldY != y) {
                //scrollTo(x, y);
            //}
            //setScrollState(SCROLL_STATE_IDLE);
        //}
        //mPopulatePending = false;
        //mScrolling = false;
        //for (int i=0; i<mItems.size(); i++) {
            //ItemInfo ii = mItems.get(i);
            //if (ii.scrolling) {
                //needPopulate = true;
                //ii.scrolling = false;
            //}
        //}
        //if (needPopulate) {
            //populate();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:04.985 -0400", hash_original_method = "965C57B2E8FC3C570BE548067A40E31E", hash_generated_method = "ACE71A3A64CE1288FFC46AF0985A3FB9")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        {
            mIsBeingDragged = false;
            mIsUnableToDrag = false;
            mActivePointerId = INVALID_POINTER;
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            } //End block
        } //End block
        //Begin case MotionEvent.ACTION_MOVE 
        {
            final int activePointerId = mActivePointerId;
            final int pointerIndex = MotionEventCompat.findPointerIndex(ev, activePointerId);
            final float x = MotionEventCompat.getX(ev, pointerIndex);
            final float dx = x - mLastMotionX;
            final float xDiff = Math.abs(dx);
            final float y = MotionEventCompat.getY(ev, pointerIndex);
            final float yDiff = Math.abs(y - mLastMotionY);
            {
                boolean var0269C25175FD226381E5FA62F7817C97_1178118151 = (canScroll(this, false, (int) dx, (int) x, (int) y));
                {
                    mInitialMotionX = mLastMotionX = x;
                    mLastMotionY = y;
                } //End block
            } //End collapsed parenthetic
            {
                mIsBeingDragged = true;
                setScrollState(SCROLL_STATE_DRAGGING);
                mLastMotionX = x;
                setScrollingCacheEnabled(true);
            } //End block
            {
                {
                    mIsUnableToDrag = true;
                } //End block
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_DOWN 
        {
            mLastMotionX = mInitialMotionX = ev.getX();
            mLastMotionY = ev.getY();
            mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
            {
                mIsBeingDragged = true;
                mIsUnableToDrag = false;
                setScrollState(SCROLL_STATE_DRAGGING);
            } //End block
            {
                completeScroll();
                mIsBeingDragged = false;
                mIsUnableToDrag = false;
            } //End block
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEventCompat.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEventCompat.ACTION_POINTER_UP 
        {
            {
                mVelocityTracker = VelocityTracker.obtain();
            } //End block
            mVelocityTracker.addMovement(ev);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_820690625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_820690625;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.012 -0400", hash_original_method = "88D861E2913027BDD6B43DC3209AC688", hash_generated_method = "664B59C5CB6FFB12285925CFAAAF4FE7")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var57171E6D7ADBA12F402579C6B252DB79_265486661 = (ev.getAction() == MotionEvent.ACTION_DOWN && ev.getEdgeFlags() != 0);
        } //End collapsed parenthetic
        {
            boolean varF7149958E5F2FB898FE7DABE8D6ABA54_1314697047 = (mAdapter == null || mAdapter.getCount() == 0);
        } //End collapsed parenthetic
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        mVelocityTracker.addMovement(ev);
        final int action = ev.getAction();
        boolean needsInvalidate = false;
        //Begin case MotionEvent.ACTION_DOWN 
        {
            completeScroll();
            mLastMotionX = mInitialMotionX = ev.getX();
            mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
        } //End block
        //End case MotionEvent.ACTION_DOWN 
        //Begin case MotionEvent.ACTION_MOVE 
        {
            final int pointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
            final float x = MotionEventCompat.getX(ev, pointerIndex);
            final float xDiff = Math.abs(x - mLastMotionX);
            final float y = MotionEventCompat.getY(ev, pointerIndex);
            final float yDiff = Math.abs(y - mLastMotionY);
            {
                mIsBeingDragged = true;
                mLastMotionX = x;
                setScrollState(SCROLL_STATE_DRAGGING);
                setScrollingCacheEnabled(true);
            } //End block
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_MOVE 
        {
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
            final float rightBound = Math.min(mCurItem + 1, lastItemIndex) * widthWithMargin;
            {
                {
                    float over = -scrollX;
                    needsInvalidate = mLeftEdge.onPull(over / width);
                } //End block
                scrollX = leftBound;
            } //End block
            {
                {
                    float over = scrollX - rightBound;
                    needsInvalidate = mRightEdge.onPull(over / width);
                } //End block
                scrollX = rightBound;
            } //End block
            mLastMotionX += scrollX - (int) scrollX;
            scrollTo((int) scrollX, getScrollY());
            pageScrolled((int) scrollX);
        } //End block
        //End case MotionEvent.ACTION_MOVE 
        //Begin case MotionEvent.ACTION_UP 
        {
            final VelocityTracker velocityTracker = mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
            int initialVelocity = (int) VelocityTrackerCompat.getXVelocity(
                            velocityTracker, mActivePointerId);
            mPopulatePending = true;
            final int widthWithMargin = getWidth() + mPageMargin;
            final int scrollX = getScrollX();
            final int currentPage = scrollX / widthWithMargin;
            final float pageOffset = (float) (scrollX % widthWithMargin) / widthWithMargin;
            final int activePointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
            final float x = MotionEventCompat.getX(ev, activePointerIndex);
            final int totalDelta = (int) (x - mInitialMotionX);
            int nextPage = determineTargetPage(currentPage, pageOffset, initialVelocity,
                            totalDelta);
            setCurrentItemInternal(nextPage, true, true, initialVelocity);
            mActivePointerId = INVALID_POINTER;
            endDrag();
            needsInvalidate = mLeftEdge.onRelease() | mRightEdge.onRelease();
        } //End block
        //End case MotionEvent.ACTION_UP 
        //Begin case MotionEvent.ACTION_CANCEL 
        {
            setCurrentItemInternal(mCurItem, true, true);
            mActivePointerId = INVALID_POINTER;
            endDrag();
            needsInvalidate = mLeftEdge.onRelease() | mRightEdge.onRelease();
        } //End block
        //End case MotionEvent.ACTION_CANCEL 
        //Begin case MotionEventCompat.ACTION_POINTER_DOWN 
        {
            final int index = MotionEventCompat.getActionIndex(ev);
            final float x = MotionEventCompat.getX(ev, index);
            mLastMotionX = x;
            mActivePointerId = MotionEventCompat.getPointerId(ev, index);
        } //End block
        //End case MotionEventCompat.ACTION_POINTER_DOWN 
        //Begin case MotionEventCompat.ACTION_POINTER_UP 
        onSecondaryPointerUp(ev);
        //End case MotionEventCompat.ACTION_POINTER_UP 
        //Begin case MotionEventCompat.ACTION_POINTER_UP 
        mLastMotionX = MotionEventCompat.getX(ev,
                        MotionEventCompat.findPointerIndex(ev, mActivePointerId));
        //End case MotionEventCompat.ACTION_POINTER_UP 
        {
            invalidate();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077158050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077158050;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.017 -0400", hash_original_method = "A599F43FA0EC47D3B5F0044593C86DDF", hash_generated_method = "1454695B94A2B3A79BF033C16F0D228D")
    private int determineTargetPage(int currentPage, float pageOffset, int velocity, int deltaX) {
        int targetPage;
        {
            boolean var53617FAAB7BF150477D52223C15E8704_388314191 = (Math.abs(deltaX) > mFlingDistance && Math.abs(velocity) > mMinimumVelocity);
            {
                targetPage = velocity > 0 ? currentPage : currentPage + 1;
            } //End block
            {
                targetPage = (int) (currentPage + pageOffset + 0.5f);
            } //End block
        } //End collapsed parenthetic
        addTaint(currentPage);
        addTaint(pageOffset);
        addTaint(velocity);
        addTaint(deltaX);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434623989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434623989;
        // ---------- Original Method ----------
        //int targetPage;
        //if (Math.abs(deltaX) > mFlingDistance && Math.abs(velocity) > mMinimumVelocity) {
            //targetPage = velocity > 0 ? currentPage : currentPage + 1;
        //} else {
            //targetPage = (int) (currentPage + pageOffset + 0.5f);
        //}
        //return targetPage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.020 -0400", hash_original_method = "EFAFFAB02B49B744BACD5A955538775F", hash_generated_method = "A4DFD84BA7AF600A70449F38B1807692")
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean needsInvalidate = false;
        final int overScrollMode = ViewCompat.getOverScrollMode(this);
        {
            boolean var7AF0F0CFE23C79165317B726BD69FC79_639216431 = (overScrollMode == ViewCompat.OVER_SCROLL_ALWAYS ||
                (overScrollMode == ViewCompat.OVER_SCROLL_IF_CONTENT_SCROLLS &&
                        mAdapter != null && mAdapter.getCount() > 1));
            {
                {
                    boolean varA18D4ADB146739431C2F0CC41BF1A282_328010010 = (!mLeftEdge.isFinished());
                    {
                        final int restoreCount = canvas.save();
                        final int height = getHeight() - getPaddingTop() - getPaddingBottom();
                        canvas.rotate(270);
                        canvas.translate(-height + getPaddingTop(), 0);
                        mLeftEdge.setSize(height, getWidth());
                        needsInvalidate |= mLeftEdge.draw(canvas);
                        canvas.restoreToCount(restoreCount);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varFE549372C17B79641E19CF160FE4C021_2066162386 = (!mRightEdge.isFinished());
                    {
                        final int restoreCount = canvas.save();
                        final int width = getWidth();
                        final int height = getHeight() - getPaddingTop() - getPaddingBottom();
                        int itemCount;
                        itemCount = mAdapter.getCount();
                        itemCount = 1;
                        canvas.rotate(90);
                        canvas.translate(-getPaddingTop(),
                        -itemCount * (width + mPageMargin) + mPageMargin);
                        mRightEdge.setSize(height, width);
                        needsInvalidate |= mRightEdge.draw(canvas);
                        canvas.restoreToCount(restoreCount);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mLeftEdge.finish();
                mRightEdge.finish();
            } //End block
        } //End collapsed parenthetic
        {
            invalidate();
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.022 -0400", hash_original_method = "C696E5F5E436E83A9E43E2B41DDB422F", hash_generated_method = "18A598F88E8E6E63DF6C1CA5DE720ADC")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDraw(canvas);
        {
            final int scrollX = getScrollX();
            final int width = getWidth();
            final int offset = scrollX % (width + mPageMargin);
            {
                final int left = scrollX - offset + width;
                mMarginDrawable.setBounds(left, mTopPageBounds, left + mPageMargin,
                        mBottomPageBounds);
                mMarginDrawable.draw(canvas);
            } //End block
        } //End block
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        //super.onDraw(canvas);
        //if (mPageMargin > 0 && mMarginDrawable != null) {
            //final int scrollX = getScrollX();
            //final int width = getWidth();
            //final int offset = scrollX % (width + mPageMargin);
            //if (offset != 0) {
                //final int left = scrollX - offset + width;
                //mMarginDrawable.setBounds(left, mTopPageBounds, left + mPageMargin,
                        //mBottomPageBounds);
                //mMarginDrawable.draw(canvas);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.025 -0400", hash_original_method = "2447A911D9005F96843292B56C864341", hash_generated_method = "E8F32311B76691D158E4E36BE5C67FA5")
    public boolean beginFakeDrag() {
        mFakeDragging = true;
        setScrollState(SCROLL_STATE_DRAGGING);
        mInitialMotionX = mLastMotionX = 0;
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        {
            mVelocityTracker.clear();
        } //End block
        final long time = SystemClock.uptimeMillis();
        final MotionEvent ev = MotionEvent.obtain(time, time, MotionEvent.ACTION_DOWN, 0, 0, 0);
        mVelocityTracker.addMovement(ev);
        ev.recycle();
        mFakeDragBeginTime = time;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896361098 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_896361098;
        // ---------- Original Method ----------
        //if (mIsBeingDragged) {
            //return false;
        //}
        //mFakeDragging = true;
        //setScrollState(SCROLL_STATE_DRAGGING);
        //mInitialMotionX = mLastMotionX = 0;
        //if (mVelocityTracker == null) {
            //mVelocityTracker = VelocityTracker.obtain();
        //} else {
            //mVelocityTracker.clear();
        //}
        //final long time = SystemClock.uptimeMillis();
        //final MotionEvent ev = MotionEvent.obtain(time, time, MotionEvent.ACTION_DOWN, 0, 0, 0);
        //mVelocityTracker.addMovement(ev);
        //ev.recycle();
        //mFakeDragBeginTime = time;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.028 -0400", hash_original_method = "012F2AA21899E6B7C86DFCCAFEEFC371", hash_generated_method = "B0304FCF4845A02DC19B46ADC321DE82")
    public void endFakeDrag() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.031 -0400", hash_original_method = "3C01AF98038E7AF52A40B265C4F4693E", hash_generated_method = "80997719B2FA8EB5F8CAD2E72D48D6DE")
    public void fakeDragBy(float xOffset) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } //End block
        mLastMotionX += xOffset;
        float scrollX = getScrollX() - xOffset;
        final int width = getWidth();
        final int widthWithMargin = width + mPageMargin;
        final float leftBound = Math.max(0, (mCurItem - 1) * widthWithMargin);
        final float rightBound = Math.min(mCurItem + 1, mAdapter.getCount() - 1) * widthWithMargin;
        {
            scrollX = leftBound;
        } //End block
        {
            scrollX = rightBound;
        } //End block
        mLastMotionX += scrollX - (int) scrollX;
        scrollTo((int) scrollX, getScrollY());
        pageScrolled((int) scrollX);
        final long time = SystemClock.uptimeMillis();
        final MotionEvent ev = MotionEvent.obtain(mFakeDragBeginTime, time, MotionEvent.ACTION_MOVE,
                mLastMotionX, 0, 0);
        mVelocityTracker.addMovement(ev);
        ev.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.033 -0400", hash_original_method = "A453849F99C417376DDBB8B219E48B12", hash_generated_method = "E37B40B7F4DA86408D7608512914772E")
    public boolean isFakeDragging() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_392790862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_392790862;
        // ---------- Original Method ----------
        //return mFakeDragging;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.035 -0400", hash_original_method = "0206AC68AD27D7D682B52A43262096FD", hash_generated_method = "0328D79918DA1213EE7048BCEB2316FF")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = MotionEventCompat.getActionIndex(ev);
        final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        {
            int newPointerIndex;
            newPointerIndex = 1;
            newPointerIndex = 0;
            mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            {
                mVelocityTracker.clear();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //final int pointerIndex = MotionEventCompat.getActionIndex(ev);
        //final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        //if (pointerId == mActivePointerId) {
            //final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            //mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            //mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            //if (mVelocityTracker != null) {
                //mVelocityTracker.clear();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.037 -0400", hash_original_method = "6F589820542A60985222493865875D9E", hash_generated_method = "59DB7A2D6114027AA26FA7762464110E")
    private void endDrag() {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        } //End block
        // ---------- Original Method ----------
        //mIsBeingDragged = false;
        //mIsUnableToDrag = false;
        //if (mVelocityTracker != null) {
            //mVelocityTracker.recycle();
            //mVelocityTracker = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.039 -0400", hash_original_method = "2B073E6A9B3015E7E6D245BDA0374ADD", hash_generated_method = "BA8AE9524F40074FC128C9BB4F8CECEB")
    private void setScrollingCacheEnabled(boolean enabled) {
        {
            mScrollingCacheEnabled = enabled;
            {
                final int size = getChildCount();
                {
                    int i = 0;
                    {
                        final View child = getChildAt(i);
                        {
                            boolean var9C6E2C1B9CB3A34CE46D1781E75F2F00_791953168 = (child.getVisibility() != GONE);
                            {
                                child.setDrawingCacheEnabled(enabled);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mScrollingCacheEnabled != enabled) {
            //mScrollingCacheEnabled = enabled;
            //if (USE_CACHE) {
                //final int size = getChildCount();
                //for (int i = 0; i < size; ++i) {
                    //final View child = getChildAt(i);
                    //if (child.getVisibility() != GONE) {
                        //child.setDrawingCacheEnabled(enabled);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.041 -0400", hash_original_method = "72E1851DC28067296F340B8A32532AE8", hash_generated_method = "29BA35AB999E515EA95CB4FF2DE16B77")
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        {
            final ViewGroup group = (ViewGroup) v;
            final int scrollX = v.getScrollX();
            final int scrollY = v.getScrollY();
            final int count = group.getChildCount();
            {
                int i = count - 1;
                {
                    final View child = group.getChildAt(i);
                    {
                        boolean varD9002CA460239BA6A92970177611271B_1934345359 = (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() &&
                        y + scrollY >= child.getTop() && y + scrollY < child.getBottom() &&
                        canScroll(child, true, dx, x + scrollX - child.getLeft(),
                                y + scrollY - child.getTop()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var9A14C50229F77D815D8CED6EC15CAD29_343246961 = (checkV && ViewCompat.canScrollHorizontally(v, -dx));
        addTaint(v.getTaint());
        addTaint(checkV);
        addTaint(dx);
        addTaint(x);
        addTaint(y);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322071629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322071629;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.043 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "1B135E6FDA9D6EABD9B932DE0272C43A")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        boolean var160A6DCE359009EE36E492A233BEB313_784026318 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358633666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358633666;
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.046 -0400", hash_original_method = "017D0A0A9E198144CB9BC76029528664", hash_generated_method = "0B868BD15F828AF4A00F90357C2B2E70")
    public boolean executeKeyEvent(KeyEvent event) {
        boolean handled = false;
        {
            boolean varE78E9647F4429F5955AD42D05C6FEF7A_825745446 = (event.getAction() == KeyEvent.ACTION_DOWN);
            {
                {
                    Object varA0761DC6508339A4AD5D875712ADE561_925802148 = (event.getKeyCode());
                    //Begin case KeyEvent.KEYCODE_DPAD_LEFT 
                    handled = arrowScroll(FOCUS_LEFT);
                    //End case KeyEvent.KEYCODE_DPAD_LEFT 
                    //Begin case KeyEvent.KEYCODE_DPAD_RIGHT 
                    handled = arrowScroll(FOCUS_RIGHT);
                    //End case KeyEvent.KEYCODE_DPAD_RIGHT 
                    //Begin case KeyEvent.KEYCODE_TAB 
                    {
                        {
                            boolean var3B0ACFC3BCBBDA6B6C439A7F1EF3544C_1053667586 = (KeyEventCompat.hasNoModifiers(event));
                            {
                                handled = arrowScroll(FOCUS_FORWARD);
                            } //End block
                            {
                                boolean var891046CC944216B0B048DB693EE865A7_838691598 = (KeyEventCompat.hasModifiers(event, KeyEvent.META_SHIFT_ON));
                                {
                                    handled = arrowScroll(FOCUS_BACKWARD);
                                } //End block
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End block
                    //End case KeyEvent.KEYCODE_TAB 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_717150452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_717150452;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.053 -0400", hash_original_method = "D3FA41B6A01CF24848855E27CD47D6CF", hash_generated_method = "8E5EC3CEACC09C74244928A4079610C5")
    public boolean arrowScroll(int direction) {
        View currentFocused = findFocus();
        {
            boolean varF85CA3EE0100E1E3C5B0606F6BE9D9A9_1454511839 = (currentFocused == this);
            currentFocused = null;
        } //End collapsed parenthetic
        boolean handled = false;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused,
                direction);
        {
            {
                {
                    boolean var556B4744FB5504050F5109B0BE3E6A24_521766946 = (currentFocused != null && nextFocused.getLeft() >= currentFocused.getLeft());
                    {
                        handled = pageLeft();
                    } //End block
                    {
                        handled = nextFocused.requestFocus();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean var3606527969512105422C782854CF2BCF_367624588 = (currentFocused != null && nextFocused.getLeft() <= currentFocused.getLeft());
                    {
                        handled = pageRight();
                    } //End block
                    {
                        handled = nextFocused.requestFocus();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            handled = pageLeft();
        } //End block
        {
            handled = pageRight();
        } //End block
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        } //End block
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371734313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371734313;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.054 -0400", hash_original_method = "912A9F83854DBABFF351742D4C2540EB", hash_generated_method = "CCB7386BABB7ED715B439E78D7998F8D")
     boolean pageLeft() {
        {
            setCurrentItem(mCurItem-1, true);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1248147840 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1248147840;
        // ---------- Original Method ----------
        //if (mCurItem > 0) {
            //setCurrentItem(mCurItem-1, true);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.056 -0400", hash_original_method = "09CF7C21498AA4945971EA3F1CB23A09", hash_generated_method = "9EF25917C20212F4545B65CBE9780441")
     boolean pageRight() {
        {
            boolean varD2B05568FD5ED514EE4265D17E9B0407_1643688320 = (mAdapter != null && mCurItem < (mAdapter.getCount()-1));
            {
                setCurrentItem(mCurItem+1, true);
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_226960983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_226960983;
        // ---------- Original Method ----------
        //if (mAdapter != null && mCurItem < (mAdapter.getCount()-1)) {
            //setCurrentItem(mCurItem+1, true);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.058 -0400", hash_original_method = "F0A4B928270BC454FADC3A823B922DBC", hash_generated_method = "A2AF59D30D0FE189F889E55192C4BCC7")
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        final int focusableCount = views.size();
        final int descendantFocusability = getDescendantFocusability();
        {
            {
                int i = 0;
                boolean varB5624BB11A8621768EF8D948F9CC977E_1138945255 = (i < getChildCount());
                {
                    final View child = getChildAt(i);
                    {
                        boolean var93DCAA7E24F58D6762D32E351E886EF8_1481313664 = (child.getVisibility() == VISIBLE);
                        {
                            ItemInfo ii = infoForChild(child);
                            {
                                child.addFocusables(views, direction, focusableMode);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var0F1BFD0DBC136B3E2580439E8453837C_615005350 = (descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                (focusableCount == views.size()));
            {
                {
                    boolean var6CECAFC64A8DD8EA38BD2BD71316C48E_1545140403 = (!isFocusable());
                } //End collapsed parenthetic
                {
                    boolean varD11AEC4760D895B334E0063CF7F61643_323406068 = ((focusableMode & FOCUSABLES_TOUCH_MODE) == FOCUSABLES_TOUCH_MODE &&
                    isInTouchMode() && !isFocusableInTouchMode());
                } //End collapsed parenthetic
                {
                    views.add(this);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(views.getTaint());
        addTaint(direction);
        addTaint(focusableMode);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.061 -0400", hash_original_method = "B172770A91C5B5BBEA8CA0E8181B4D77", hash_generated_method = "230DD89CFBDDE7DAA2F116B000BD0F9F")
    @Override
    public void addTouchables(ArrayList<View> views) {
        {
            int i = 0;
            boolean var975114E76385FFBE15AB4C8EBFE89070_93640318 = (i < getChildCount());
            {
                final View child = getChildAt(i);
                {
                    boolean var8A57A58DBB883ADE24FF5A237195936C_1274176158 = (child.getVisibility() == VISIBLE);
                    {
                        ItemInfo ii = infoForChild(child);
                        {
                            child.addTouchables(views);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(views.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i < getChildCount(); i++) {
            //final View child = getChildAt(i);
            //if (child.getVisibility() == VISIBLE) {
                //ItemInfo ii = infoForChild(child);
                //if (ii != null && ii.position == mCurItem) {
                    //child.addTouchables(views);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.065 -0400", hash_original_method = "CCC0F1DB24268E606FA269C862549D2B", hash_generated_method = "7A2EC892C8F5A8272D321DF1F6ADCE82")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int index;
        int increment;
        int end;
        int count = getChildCount();
        {
            index = 0;
            increment = 1;
            end = count;
        } //End block
        {
            index = count - 1;
            increment = -1;
            end = -1;
        } //End block
        {
            int i = index;
            i += increment;
            {
                View child = getChildAt(i);
                {
                    boolean var8A57A58DBB883ADE24FF5A237195936C_1185821248 = (child.getVisibility() == VISIBLE);
                    {
                        ItemInfo ii = infoForChild(child);
                        {
                            {
                                boolean varC84830AEFD962841076673EE2C3A7CA2_526680052 = (child.requestFocus(direction, previouslyFocusedRect));
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731382466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731382466;
        // ---------- Original Method ----------
        //int index;
        //int increment;
        //int end;
        //int count = getChildCount();
        //if ((direction & FOCUS_FORWARD) != 0) {
            //index = 0;
            //increment = 1;
            //end = count;
        //} else {
            //index = count - 1;
            //increment = -1;
            //end = -1;
        //}
        //for (int i = index; i != end; i += increment) {
            //View child = getChildAt(i);
            //if (child.getVisibility() == VISIBLE) {
                //ItemInfo ii = infoForChild(child);
                //if (ii != null && ii.position == mCurItem) {
                    //if (child.requestFocus(direction, previouslyFocusedRect)) {
                        //return true;
                    //}
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.067 -0400", hash_original_method = "1C80A36EDB4BAC430A3311DB8FBFC0D6", hash_generated_method = "DDEFFD87B92FC3C463F1D6B666685E0A")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        final int childCount = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var8A57A58DBB883ADE24FF5A237195936C_915327084 = (child.getVisibility() == VISIBLE);
                    {
                        final ItemInfo ii = infoForChild(child);
                        {
                            boolean varDFCCF2BFEB2AA92D965713AC4F35AFDA_297611831 = (ii != null && ii.position == mCurItem &&
                        child.dispatchPopulateAccessibilityEvent(event));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056076891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056076891;
        // ---------- Original Method ----------
        //final int childCount = getChildCount();
        //for (int i = 0; i < childCount; i++) {
            //final View child = getChildAt(i);
            //if (child.getVisibility() == VISIBLE) {
                //final ItemInfo ii = infoForChild(child);
                //if (ii != null && ii.position == mCurItem &&
                        //child.dispatchPopulateAccessibilityEvent(event)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.069 -0400", hash_original_method = "763708F2B4B4E396A96E9D3340F0B010", hash_generated_method = "63C5546667FFECBFEDE5F72065A14933")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1871713917 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1871713917 = new LayoutParams();
        varB4EAC82CA7396A68D541C85D26508E83_1871713917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1871713917;
        // ---------- Original Method ----------
        //return new LayoutParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.070 -0400", hash_original_method = "D8A26BF8CEB61DB2275E97CE7D907FB8", hash_generated_method = "FAD0F608B53A6D468EE3B3DA2B9E9AC4")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_832648091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_832648091 = generateDefaultLayoutParams();
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_832648091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_832648091;
        // ---------- Original Method ----------
        //return generateDefaultLayoutParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.071 -0400", hash_original_method = "0820242DFB1833A79D3A037A247A735A", hash_generated_method = "07CB5671F7CC7E21B4268F843386B5CD")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        boolean varC2872163DB2409DB7613DFA59C1BE5B5_1021355671 = (p instanceof LayoutParams && super.checkLayoutParams(p));
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1642461937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1642461937;
        // ---------- Original Method ----------
        //return p instanceof LayoutParams && super.checkLayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.072 -0400", hash_original_method = "1C9B9BBEC46A39865FCD3A7288415ECD", hash_generated_method = "09F13B1C596838222FD6EAC813097E49")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        ViewGroup.LayoutParams varB4EAC82CA7396A68D541C85D26508E83_337094059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_337094059 = new LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_337094059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_337094059;
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    static class ItemInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.073 -0400", hash_original_field = "A8CFDE6331BD59EB2AC96F8911C4B666", hash_generated_field = "4725548B2F852700377486F07DBD49CE")

        Object object;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.073 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.073 -0400", hash_original_field = "EE5631E545C57660DC98FD28795CB9FF", hash_generated_field = "C4FC55BE953EA6922AFA9FA4551D7D29")

        boolean scrolling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.074 -0400", hash_original_method = "0E65939D2C485463E4F8D82E04659E59", hash_generated_method = "0E65939D2C485463E4F8D82E04659E59")
        public ItemInfo ()
        {
            //Synthesized constructor
        }


    }


    
    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.074 -0400", hash_original_method = "11664B5E2C5AD85381CB52FAE0F3E160", hash_generated_method = "11664B5E2C5AD85381CB52FAE0F3E160")
        public SimpleOnPageChangeListener ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.075 -0400", hash_original_method = "FDA1A61FADE7F0C7FCCDCC2DC76C3CF3", hash_generated_method = "B2FBB2FB94B804AD0B70502C0D4396BB")
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(position);
            addTaint(positionOffset);
            addTaint(positionOffsetPixels);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.076 -0400", hash_original_method = "53640E8AF66EBB8ED10DFFE2A0D2E8B4", hash_generated_method = "E14EBD5798939F6D36F12C55A8B6805A")
        @Override
        public void onPageSelected(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(position);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.078 -0400", hash_original_method = "257CCDCF3F3C71EC13191438C1C85826", hash_generated_method = "7D1A18F60472A016F9CCDF171AEF93EC")
        @Override
        public void onPageScrollStateChanged(int state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(state);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.078 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.079 -0400", hash_original_field = "68B24046939BFC464397E8623A7021F1", hash_generated_field = "69064C35FAD6A57FDCB5B011C3C90243")

        Parcelable adapterState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.079 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "50E7BE27A72C15B735AFB72AFA6F9C78")

        ClassLoader loader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.080 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.083 -0400", hash_original_method = "C91DCD2D2A900CBC6E45E0C16FB00296", hash_generated_method = "E8D15A1A139ED23F64705839455FCA58")
          SavedState(Parcel in, ClassLoader loader) {
            super(in);
            {
                loader = getClass().getClassLoader();
            } //End block
            position = in.readInt();
            adapterState = in.readParcelable(loader);
            this.loader = loader;
            // ---------- Original Method ----------
            //if (loader == null) {
                //loader = getClass().getClassLoader();
            //}
            //position = in.readInt();
            //adapterState = in.readParcelable(loader);
            //this.loader = loader;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.085 -0400", hash_original_method = "F4CAF3A56784E52DEBA10017E225034C", hash_generated_method = "6723C73D85A2E3F3AA47C2B9D1744E44")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(position);
            out.writeParcelable(adapterState, flags);
            addTaint(out.getTaint());
            addTaint(flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(position);
            //out.writeParcelable(adapterState, flags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.086 -0400", hash_original_method = "7E681A9714B5A31F0FD1978F434F050F", hash_generated_method = "58AE95D95BE05A943BFC45848A9BE823")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1973694339 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1973694339 = "FragmentPager.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " position=" + position + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1973694339.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1973694339;
            // ---------- Original Method ----------
            //return "FragmentPager.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " position=" + position + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.086 -0400", hash_original_field = "0C2FD1F1D20C82721A0B333C0E7E33AB", hash_generated_field = "F13036E5254809F6F751A2283CFC452E")

        public static final Parcelable.Creator<SavedState> CREATOR
                = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
                    @Override
                    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                        return new SavedState(in, loader);
                    }
                    @Override
                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                });
        /*
        // orphaned legacy method
        @Override
                    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                        return new SavedState(in, loader);
                    }
        
        // orphaned legacy method
        @Override
                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
        
        */
    }


    
    private class PagerObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.087 -0400", hash_original_method = "9650588F08E5195A8869DD8AFCD0755C", hash_generated_method = "9650588F08E5195A8869DD8AFCD0755C")
        public PagerObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.087 -0400", hash_original_method = "11C315FA7B2CA5C79402AC3B9B3CC875", hash_generated_method = "B9090479FFF1FB0FF809A60780229444")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dataSetChanged();
            // ---------- Original Method ----------
            //dataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.088 -0400", hash_original_method = "75A3C506698EAB8F326C44C7FA27D020", hash_generated_method = "0BA8DD5F6D5DD6AD703761FCA7405F9D")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dataSetChanged();
            // ---------- Original Method ----------
            //dataSetChanged();
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.089 -0400", hash_original_field = "EB40674A13237E0AB9B7F06555DDF283", hash_generated_field = "59F277E75B4C152D81D2D818BA4B0D2E")

        public boolean isDecor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.089 -0400", hash_original_field = "67F2A835697E7C9C2C5146C76ECA6038", hash_generated_field = "7B969BCD8327FD354F9843B5C2FB842F")

        public int gravity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.089 -0400", hash_original_method = "22352D37EA586BAB2B06261A9354918D", hash_generated_method = "92FA6B303DD2F574323DBD754522A067")
        public  LayoutParams() {
            super(FILL_PARENT, FILL_PARENT);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.090 -0400", hash_original_method = "1F1818866541ED0A2C469168FD0D681B", hash_generated_method = "16F86D8EAF1E463E29CA8AFC331E8793")
        public  LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
            gravity = a.getInteger(0, Gravity.NO_GRAVITY);
            a.recycle();
            addTaint(context.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
            //gravity = a.getInteger(0, Gravity.NO_GRAVITY);
            //a.recycle();
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.091 -0400", hash_original_field = "ECAAC16EEE36445573D0208F57208459", hash_generated_field = "8B95FE444EAF04E1B97E79FAA1346818")

    private static final String TAG = "ViewPager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.091 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.092 -0400", hash_original_field = "3F2A0284A6D2B9BDD5E639B3EDC89029", hash_generated_field = "650AADEFCFDF69CDD5A6A3BFC4ED1A3C")

    private static final boolean USE_CACHE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.092 -0400", hash_original_field = "5BF51089DA940C4222FC11266A787C5D", hash_generated_field = "F1B189E3CF39A86400A3C9B6652580CE")

    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.092 -0400", hash_original_field = "35CCC02F0560CE37BD5EDAE452D93297", hash_generated_field = "17654B746B84D905348C1100B6FE7760")

    private static final int MAX_SETTLE_DURATION = 600;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.092 -0400", hash_original_field = "9D3B2FCB6CED37579DA48784F072A789", hash_generated_field = "57169D2A36D11070C14E490CB3A3EB03")

    private static final int MIN_DISTANCE_FOR_FLING = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.093 -0400", hash_original_field = "B560B24442384E98AC6B1AE5E6ADABB9", hash_generated_field = "5ADDA5389845FF3454B51DCFE6C8CFF0")

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
            // ---------- Original Method ----------
            //return lhs.position - rhs.position;
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
            // ---------- Original Method ----------
            //t -= 1.0f;
            //return t * t * t * t * t + 1.0f;
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.096 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.097 -0400", hash_original_field = "060C4A2E5F98F36D06364F608B2D8973", hash_generated_field = "03E40CFF00BD7BA3937A5499974D60CF")

    public static final int SCROLL_STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.097 -0400", hash_original_field = "9C2074D05A39F45845FA4E5761D72D3D", hash_generated_field = "E3D77F42F70C954DD577EF87B0640D7E")

    public static final int SCROLL_STATE_DRAGGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.097 -0400", hash_original_field = "1A6A06468CD45B2434C9499716419C62", hash_generated_field = "18EEC92BF586A88EFE14E2C9E326DDB9")

    public static final int SCROLL_STATE_SETTLING = 2;
}

