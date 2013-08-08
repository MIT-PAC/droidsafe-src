package android.support.v4.view;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "41B6E682666A6CCC9F7FD53F365400D5", hash_generated_field = "4DED95E1F9669C7056C2DE4B99A4DA42")

    private final ArrayList<ItemInfo> mItems = new ArrayList<ItemInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "2A01FA323E66B8B0477D575256463652")

    private PagerAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "1B622A649B9CF8B641EACDE420DF730F", hash_generated_field = "D9FBC86CB22AF6261A48272E212D5541")

    private int mCurItem;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "7F0881F185F366D7C4C89DA2DCFBB5D6", hash_generated_field = "C261E67D50992A5C20799C932967E4BF")

    private int mRestoredCurItem = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "80D5932F7DC6B9E1A2D3F90318652EDF", hash_generated_field = "BAEDBA8C3A0D9CA358A825101480570F")

    private Parcelable mRestoredAdapterState = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "36BB6850115BCB6CF6A775CC42C023D1", hash_generated_field = "0B3271C0D246AD917F0B2BFC0F1E2284")

    private ClassLoader mRestoredClassLoader = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "360DD66618E954525BEA0D65B05DC7EC", hash_generated_field = "AB39B37744A8B63C82246C1F6FE6730F")

    private Scroller mScroller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "4DDBCA80DE6A7A07D8A5420B04989903")

    private PagerObserver mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "DDBEB3CB51E072971AA69C4D4A8D6589", hash_generated_field = "B27BEE6220E87E8571B1CC02AEF71A81")

    private int mPageMargin;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "678E22AC030B6DC5A6AA7FC6D4579505", hash_generated_field = "5CB8BE965FCEEA70C5D18EEB2C5B06B9")

    private Drawable mMarginDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "39B4059A4EBD276CB2F45AB717B7F07D", hash_generated_field = "E74EA91BBE0E15AAB285398BC1D9022D")

    private int mTopPageBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "BA07B67C891F3DF9B5507F2B7B5CE1D7", hash_generated_field = "97C090C7D7510B1CAF63827F11C247DB")

    private int mBottomPageBounds;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "93C66B79C1316E4BE0608678F9114134", hash_generated_field = "A9185C0052000A85FA411C5586609D44")

    private int mChildWidthMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "B97395F2F3AB7D9372B830DF0BC48F6D", hash_generated_field = "AD5DFC102B7E069BD84ECCA774ECA3DA")

    private int mChildHeightMeasureSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "02B7C51C439DA5E343271787FAA8C822", hash_generated_field = "AC8E671E2AA7EEF3EC800FAEB4B3A880")

    private boolean mInLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "7FB4BC12E46C9E48428AFBC608C49853", hash_generated_field = "525C74FB2020779EE8272F7A1D19F1C6")

    private boolean mScrollingCacheEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "78CBA42BBA2A626FF674F2968DBCF641", hash_generated_field = "3615C17B741EA896B2F5EB737A25E37D")

    private boolean mPopulatePending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "76EE8357FBE31044043523153FEF3C0F", hash_generated_field = "FD42EA2408DC7BC099DE88D000A67AD2")

    private boolean mScrolling;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "7F99C82B6BE4E0A3165A1CBB55B8C022", hash_generated_field = "6889C67D111C39C131790ED24D71EAFB")

    private int mOffscreenPageLimit = DEFAULT_OFFSCREEN_PAGES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "CD7F83DE880FD2A584529B26609B9552", hash_generated_field = "B59FB434376CFD18468CB8F7DF43173C")

    private boolean mIsBeingDragged;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.762 -0400", hash_original_field = "D2B38369C40C71EB69DF0F9CF593481F", hash_generated_field = "748889273C84B9C9E218E6BFA97C24D2")

    private boolean mIsUnableToDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "3DFFFAD10926598D18EEC50D61DE79CA", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "5777AFD9F80796909E38C49F4EB26657", hash_generated_field = "E8D995D721D911B655A8BA1B8E85A671")

    private float mInitialMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "4F6DEDF0BA2D99325BDAE4A27C301E0B", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "4925C8499D6FECBA832A37F55AA6C69B", hash_generated_field = "2D88D85D441545A6227529A03C0B4E71")

    private float mLastMotionY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "D0F34CC6DB83FC46AEC38F19CA5CE138", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "217FE873D59646EE0AC51688724FF274", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "30B0DF23DBDF2426D66E4D98494C369B", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "1C66D9179508D091F8E90C9FEBAD15CA", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "7BF54EA094E873404B9F9B78E013E17C", hash_generated_field = "7F8D995E03C7CD7E0F196759ABA95F5F")

    private int mFlingDistance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "A433486E64E1D58A4CCC7C7414F54C8F", hash_generated_field = "986D52A8EA3DCB2BCCE9B03ACB17651B")

    private boolean mFakeDragging;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "3CE5B0D287DF6DD1EDBE8BBED34023B0", hash_generated_field = "AE83D0D9EE37D7B14D072F1E5F467A1E")

    private long mFakeDragBeginTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "CBB789948681D2B6CC5E9F151EA9F4E9", hash_generated_field = "9E249B56B7CAFDEEC5F0C85DF1584FF5")

    private EdgeEffectCompat mLeftEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "7E7953405F64EE99C6316AD67D90567C", hash_generated_field = "1100A29EE0D913080378CCB73190893C")

    private EdgeEffectCompat mRightEdge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "B846D45E3DA2FA84A2AEED6B3F297C15", hash_generated_field = "D2103C384BE0AB58542D96A0CD23C256")

    private boolean mFirstLayout = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "2B31708C283988DC9180CFF9247B0BB2", hash_generated_field = "0C8F00C2B17489007C5F8140505FF30F")

    private boolean mCalledSuper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "E737D9A665B1357B878B62E10F10BA85", hash_generated_field = "64518C389A512872C2826132B5A07F9F")

    private int mDecorChildCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "8FC6495F72130DD9579EAE0AF30D9792", hash_generated_field = "EE99805AC43858C068324B36ED28179F")

    private OnPageChangeListener mOnPageChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "6BA7D2CBD59FE696B26780EEABAEA515", hash_generated_field = "1F25B0C85CAD75C221F1467E6925256A")

    private OnPageChangeListener mInternalPageChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "77972A353C956888CCB6D5FF6DAEBC65", hash_generated_field = "2E3B1499B0D138F9C25DFFF849DEACEA")

    private OnAdapterChangeListener mAdapterChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_field = "A671F6478D41E19963F2CBD7C42AC5E7", hash_generated_field = "1E68982A83C4D0C6AC923C110AE0A857")

    private int mScrollState = SCROLL_STATE_IDLE;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_method = "167A05D4ABF68D419B8302604913DA0C", hash_generated_method = "39740A762893157EF16B3102A9C33A17")
    public  ViewPager(Context context) {
        super(context);
        addTaint(context.getTaint());
        initViewPager();
        // ---------- Original Method ----------
        //initViewPager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_method = "2DA5D82366012C7A6B734AF18B26B0B4", hash_generated_method = "A8CC58E990B5E45329019D830EC0E036")
    public  ViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initViewPager();
        // ---------- Original Method ----------
        //initViewPager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.763 -0400", hash_original_method = "DBB36B523BACF2E8831A0769B3639908", hash_generated_method = "583C6C03733EA78625EBDDD3A0EA4D2B")
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.764 -0400", hash_original_method = "80EB60C09FE5B35C976F87EEFD89447E", hash_generated_method = "DC48196C2F46CD8DCCDB6109B8BFD565")
    private void setScrollState(int newState) {
        if(mScrollState == newState)        
        {
            return;
        } //End block
        mScrollState = newState;
        if(mOnPageChangeListener != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.764 -0400", hash_original_method = "5B308B647844A5E9AE37DC79927B0D79", hash_generated_method = "306322C0C1BC74A7FFEB77F6A3E9DA50")
    public void setAdapter(PagerAdapter adapter) {
        if(mAdapter != null)        
        {
            mAdapter.unregisterDataSetObserver(mObserver);
            mAdapter.startUpdate(this);
for(int i = 0;i < mItems.size();i++)
            {
                final ItemInfo ii = mItems.get(i);
                mAdapter.destroyItem(this, ii.position, ii.object);
            } //End block
            mAdapter.finishUpdate(this);
            mItems.clear();
            removeNonDecorViews();
            mCurItem = 0;
            scrollTo(0, 0);
        } //End block
        final PagerAdapter oldAdapter = mAdapter;
        mAdapter = adapter;
        if(mAdapter != null)        
        {
            if(mObserver == null)            
            {
                mObserver = new PagerObserver();
            } //End block
            mAdapter.registerDataSetObserver(mObserver);
            mPopulatePending = false;
            if(mRestoredCurItem >= 0)            
            {
                mAdapter.restoreState(mRestoredAdapterState, mRestoredClassLoader);
                setCurrentItemInternal(mRestoredCurItem, false, true);
                mRestoredCurItem = -1;
                mRestoredAdapterState = null;
                mRestoredClassLoader = null;
            } //End block
            else
            {
                populate();
            } //End block
        } //End block
        if(mAdapterChangeListener != null && oldAdapter != adapter)        
        {
            mAdapterChangeListener.onAdapterChanged(oldAdapter, adapter);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.764 -0400", hash_original_method = "18421C7E85141EF2E7552011BA442EAC", hash_generated_method = "0C8992E353EFECAD2887239ABEA18A97")
    private void removeNonDecorViews() {
for(int i = 0;i < getChildCount();i++)
        {
            final View child = getChildAt(i);
            final LayoutParams lp = (LayoutParams) child.getLayoutParams();
            if(!lp.isDecor)            
            {
                removeViewAt(i);
                i--;
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.764 -0400", hash_original_method = "F7E052C477B11777DA7EBFEE8452F40F", hash_generated_method = "8F0CFEC0AAE66B8CBC3CF2A97503FF1B")
    public PagerAdapter getAdapter() {
PagerAdapter varD72668EDE5E63ADF9340F3D8A19FD205_81394880 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_81394880.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_81394880;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.764 -0400", hash_original_method = "36FAA41620F55873E46894195D62C0FE", hash_generated_method = "64B5029EE6627AF5DA8D33AFBF5EB153")
     void setOnAdapterChangeListener(OnAdapterChangeListener listener) {
        mAdapterChangeListener = listener;
        // ---------- Original Method ----------
        //mAdapterChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.764 -0400", hash_original_method = "7A2B970E4C717952A0CD3574FF0FD69D", hash_generated_method = "50B3FFD648005336CE8228C5AD62018A")
    public void setCurrentItem(int item) {
        addTaint(item);
        mPopulatePending = false;
        setCurrentItemInternal(item, !mFirstLayout, false);
        // ---------- Original Method ----------
        //mPopulatePending = false;
        //setCurrentItemInternal(item, !mFirstLayout, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.765 -0400", hash_original_method = "F21F60BCB144D38A5AE0B59AB369F197", hash_generated_method = "CFBF819B18E7095B4B48D636907B5B00")
    public void setCurrentItem(int item, boolean smoothScroll) {
        addTaint(smoothScroll);
        addTaint(item);
        mPopulatePending = false;
        setCurrentItemInternal(item, smoothScroll, false);
        // ---------- Original Method ----------
        //mPopulatePending = false;
        //setCurrentItemInternal(item, smoothScroll, false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.765 -0400", hash_original_method = "A82ABDE9609B8643904FAA59A05D3729", hash_generated_method = "AB3B4876080CACE7299AF2FA3932D744")
    public int getCurrentItem() {
        int var1B622A649B9CF8B641EACDE420DF730F_1280743455 = (mCurItem);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632690418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632690418;
        // ---------- Original Method ----------
        //return mCurItem;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.765 -0400", hash_original_method = "975AAD75311F294CDFC8362C48B3CCF3", hash_generated_method = "A887E4396B1D04B0E0937F8D4F040D39")
     void setCurrentItemInternal(int item, boolean smoothScroll, boolean always) {
        addTaint(always);
        addTaint(smoothScroll);
        addTaint(item);
        setCurrentItemInternal(item, smoothScroll, always, 0);
        // ---------- Original Method ----------
        //setCurrentItemInternal(item, smoothScroll, always, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.765 -0400", hash_original_method = "4CC7A0E676B55FB5E3215627D71CB3FB", hash_generated_method = "69195884B5989582524FF7D3B976EE14")
     void setCurrentItemInternal(int item, boolean smoothScroll, boolean always, int velocity) {
        addTaint(velocity);
        addTaint(always);
        addTaint(smoothScroll);
        if(mAdapter == null || mAdapter.getCount() <= 0)        
        {
            setScrollingCacheEnabled(false);
            return;
        } //End block
        if(!always && mCurItem == item && mItems.size() != 0)        
        {
            setScrollingCacheEnabled(false);
            return;
        } //End block
        if(item < 0)        
        {
            item = 0;
        } //End block
        else
        if(item >= mAdapter.getCount())        
        {
            item = mAdapter.getCount() - 1;
        } //End block
        final int pageLimit = mOffscreenPageLimit;
        if(item > (mCurItem + pageLimit) || item < (mCurItem - pageLimit))        
        {
for(int i=0;i<mItems.size();i++)
            {
                mItems.get(i).scrolling = true;
            } //End block
        } //End block
        final boolean dispatchSelected = mCurItem != item;
        mCurItem = item;
        populate();
        final int destX = (getWidth() + mPageMargin) * item;
        if(smoothScroll)        
        {
            smoothScrollTo(destX, 0, velocity);
            if(dispatchSelected && mOnPageChangeListener != null)            
            {
                mOnPageChangeListener.onPageSelected(item);
            } //End block
            if(dispatchSelected && mInternalPageChangeListener != null)            
            {
                mInternalPageChangeListener.onPageSelected(item);
            } //End block
        } //End block
        else
        {
            if(dispatchSelected && mOnPageChangeListener != null)            
            {
                mOnPageChangeListener.onPageSelected(item);
            } //End block
            if(dispatchSelected && mInternalPageChangeListener != null)            
            {
                mInternalPageChangeListener.onPageSelected(item);
            } //End block
            completeScroll();
            scrollTo(destX, 0);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.765 -0400", hash_original_method = "FA06973225A603572F4FD6150255295F", hash_generated_method = "8762A57EBF81138B887037B32512FF60")
    public void setOnPageChangeListener(OnPageChangeListener listener) {
        mOnPageChangeListener = listener;
        // ---------- Original Method ----------
        //mOnPageChangeListener = listener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.765 -0400", hash_original_method = "BEC1D9D7EF0862149EE21D17618B274F", hash_generated_method = "76B82CD4EE3E20C47F3E7ADB8DEA124D")
     OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener listener) {
        OnPageChangeListener oldListener = mInternalPageChangeListener;
        mInternalPageChangeListener = listener;
OnPageChangeListener varC2E9C4C13673ECB49BE969362809B4E4_1856097957 =         oldListener;
        varC2E9C4C13673ECB49BE969362809B4E4_1856097957.addTaint(taint);
        return varC2E9C4C13673ECB49BE969362809B4E4_1856097957;
        // ---------- Original Method ----------
        //OnPageChangeListener oldListener = mInternalPageChangeListener;
        //mInternalPageChangeListener = listener;
        //return oldListener;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "3F35BC951292D9FB1DF42BFA6208CE75", hash_generated_method = "B1B182018E2322CA173D1CC304CAD257")
    public int getOffscreenPageLimit() {
        int var0860C10CA075BCA0392AC95179F36503_2045973021 = (mOffscreenPageLimit);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871166946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871166946;
        // ---------- Original Method ----------
        //return mOffscreenPageLimit;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "A74A93D6A42C43F22E5B6055DA99B3A5", hash_generated_method = "58591B7B98F4F3F1768FF6BA60E3A705")
    public void setOffscreenPageLimit(int limit) {
        if(limit < DEFAULT_OFFSCREEN_PAGES)        
        {
            limit = DEFAULT_OFFSCREEN_PAGES;
        } //End block
        if(limit != mOffscreenPageLimit)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "828EEBFA53113FADBEB7FC44B9C61C3C", hash_generated_method = "BD2552D411CB0940E31029A9F1317733")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "C374880A4C36BA236EE3B5602129BC09", hash_generated_method = "9D41BCB5D0F8C4119ABF405D26729D74")
    public int getPageMargin() {
        int varDDBEB3CB51E072971AA69C4D4A8D6589_1546588280 = (mPageMargin);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118330544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118330544;
        // ---------- Original Method ----------
        //return mPageMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "BA05FEAA10A774C185287C0B628011BB", hash_generated_method = "AD7FB3229AD5C7C4149241ED3731CE81")
    public void setPageMarginDrawable(Drawable d) {
        mMarginDrawable = d;
        if(d != null)        
        refreshDrawableState();
        setWillNotDraw(d == null);
        invalidate();
        // ---------- Original Method ----------
        //mMarginDrawable = d;
        //if (d != null) refreshDrawableState();
        //setWillNotDraw(d == null);
        //invalidate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "194EE6D0EDD674D9D2DE52CA6B5FC234", hash_generated_method = "E3AACD752C572DE470FD93F03B6F375C")
    public void setPageMarginDrawable(int resId) {
        addTaint(resId);
        setPageMarginDrawable(getContext().getResources().getDrawable(resId));
        // ---------- Original Method ----------
        //setPageMarginDrawable(getContext().getResources().getDrawable(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "5339E87F28FFED611E3042BEB812570C", hash_generated_method = "E2B00C48C9A5793DF047DFE90404BFB8")
    @Override
    protected boolean verifyDrawable(Drawable who) {
        addTaint(who.getTaint());
        boolean varB6C4A9F139D171DC8645479431980265_964464655 = (super.verifyDrawable(who) || who == mMarginDrawable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378011655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_378011655;
        // ---------- Original Method ----------
        //return super.verifyDrawable(who) || who == mMarginDrawable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "D9869A333EE5ABB30D7044AE2CBD85F6", hash_generated_method = "8B924768C6C066B957BF4DFDCCA2DA66")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final Drawable d = mMarginDrawable;
        if(d != null && d.isStateful())        
        {
            d.setState(getDrawableState());
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //final Drawable d = mMarginDrawable;
        //if (d != null && d.isStateful()) {
            //d.setState(getDrawableState());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.766 -0400", hash_original_method = "3937E06E79A8643FB4C5C1D74E3AE99C", hash_generated_method = "3680E8C15E37757B82D8F1A5C0D4E101")
     float distanceInfluenceForSnapDuration(float f) {
        addTaint(f);
        f -= 0.5f;
        f *= 0.3f * Math.PI / 2.0f;
        float varF2441E69DB56AF2E5B59E076A9D20041_1755853923 = ((float) Math.sin(f));
                float var546ADE640B6EDFBC8A086EF31347E768_1514378704 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1514378704;
        // ---------- Original Method ----------
        //f -= 0.5f;
        //f *= 0.3f * Math.PI / 2.0f;
        //return (float) Math.sin(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.767 -0400", hash_original_method = "BC18C642FF487E008261AE9ED73575D8", hash_generated_method = "102BD61C4E2FC4F3F55A4B1A47795FEE")
     void smoothScrollTo(int x, int y) {
        addTaint(y);
        addTaint(x);
        smoothScrollTo(x, y, 0);
        // ---------- Original Method ----------
        //smoothScrollTo(x, y, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.768 -0400", hash_original_method = "A4DABDC2D7B52B75CD4B2F9017BAC5A7", hash_generated_method = "CA6ADB97FE7C62867C5D48E10286D014")
     void smoothScrollTo(int x, int y, int velocity) {
        addTaint(velocity);
        addTaint(y);
        addTaint(x);
        if(getChildCount() == 0)        
        {
            setScrollingCacheEnabled(false);
            return;
        } //End block
        int sx = getScrollX();
        int sy = getScrollY();
        int dx = x - sx;
        int dy = y - sy;
        if(dx == 0 && dy == 0)        
        {
            completeScroll();
            setScrollState(SCROLL_STATE_IDLE);
            return;
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
        if(velocity > 0)        
        {
            duration = 4 * Math.round(1000 * Math.abs(distance / velocity));
        } //End block
        else
        {
            final float pageDelta = (float) Math.abs(dx) / (width + mPageMargin);
            duration = (int) ((pageDelta + 1) * 100);
        } //End block
        duration = Math.min(duration, MAX_SETTLE_DURATION);
        mScroller.startScroll(sx, sy, dx, dy, duration);
        invalidate();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.769 -0400", hash_original_method = "4F6A5F0B8F2759342FC6F742F3401D82", hash_generated_method = "7E0985EF0F767F66A8FD3F3ACF7B1334")
     void addNewItem(int position, int index) {
        addTaint(index);
        addTaint(position);
        ItemInfo ii = new ItemInfo();
        ii.position = position;
        ii.object = mAdapter.instantiateItem(this, position);
        if(index < 0)        
        {
            mItems.add(ii);
        } //End block
        else
        {
            mItems.add(index, ii);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.769 -0400", hash_original_method = "0F425711D6B8C5B4FAAE039431564D7B", hash_generated_method = "3214530FEB8531F70115E5D7EDD54447")
     void dataSetChanged() {
        boolean needPopulate = mItems.size() < 3 && mItems.size() < mAdapter.getCount();
        int newCurrItem = -1;
        boolean isUpdating = false;
for(int i = 0;i < mItems.size();i++)
        {
            final ItemInfo ii = mItems.get(i);
            final int newPos = mAdapter.getItemPosition(ii.object);
            if(newPos == PagerAdapter.POSITION_UNCHANGED)            
            {
                continue;
            } //End block
            if(newPos == PagerAdapter.POSITION_NONE)            
            {
                mItems.remove(i);
                i--;
                if(!isUpdating)                
                {
                    mAdapter.startUpdate(this);
                    isUpdating = true;
                } //End block
                mAdapter.destroyItem(this, ii.position, ii.object);
                needPopulate = true;
                if(mCurItem == ii.position)                
                {
                    newCurrItem = Math.max(0, Math.min(mCurItem, mAdapter.getCount() - 1));
                } //End block
                continue;
            } //End block
            if(ii.position != newPos)            
            {
                if(ii.position == mCurItem)                
                {
                    newCurrItem = newPos;
                } //End block
                ii.position = newPos;
                needPopulate = true;
            } //End block
        } //End block
        if(isUpdating)        
        {
            mAdapter.finishUpdate(this);
        } //End block
        Collections.sort(mItems, COMPARATOR);
        if(newCurrItem >= 0)        
        {
            setCurrentItemInternal(newCurrItem, false, true);
            needPopulate = true;
        } //End block
        if(needPopulate)        
        {
            populate();
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.770 -0400", hash_original_method = "70E539FA9A51CF2C9CD07D50F5400EB2", hash_generated_method = "343D445ACE018FBF936CA5547E162B22")
     void populate() {
        if(mAdapter == null)        
        {
            return;
        } //End block
        if(mPopulatePending)        
        {
            if(DEBUG){ }            return;
        } //End block
        if(getWindowToken() == null)        
        {
            return;
        } //End block
        mAdapter.startUpdate(this);
        final int pageLimit = mOffscreenPageLimit;
        final int startPos = Math.max(0, mCurItem - pageLimit);
        final int N = mAdapter.getCount();
        final int endPos = Math.min(N-1, mCurItem + pageLimit);
        if(DEBUG){ }        int lastPos = -1;
for(int i=0;i<mItems.size();i++)
        {
            ItemInfo ii = mItems.get(i);
            if((ii.position < startPos || ii.position > endPos) && !ii.scrolling)            
            {
                if(DEBUG){ }                mItems.remove(i);
                i--;
                mAdapter.destroyItem(this, ii.position, ii.object);
            } //End block
            else
            if(lastPos < endPos && ii.position > startPos)            
            {
                lastPos++;
                if(lastPos < startPos)                
                {
                    lastPos = startPos;
                } //End block
                while
(lastPos <= endPos && lastPos < ii.position)                
                {
                    if(DEBUG){ }                    addNewItem(lastPos, i);
                    lastPos++;
                    i++;
                } //End block
            } //End block
            lastPos = ii.position;
        } //End block
        lastPos = mItems.size() > 0 ? mItems.get(mItems.size()-1).position : -1;
        if(lastPos < endPos)        
        {
            lastPos++;
            lastPos = lastPos > startPos ? lastPos : startPos;
            while
(lastPos <= endPos)            
            {
                if(DEBUG){ }                addNewItem(lastPos, -1);
                lastPos++;
            } //End block
        } //End block
        if(DEBUG)        
        {
for(int i=0;i<mItems.size();i++)
            {
            } //End block
        } //End block
        ItemInfo curItem = null;
for(int i=0;i<mItems.size();i++)
        {
            if(mItems.get(i).position == mCurItem)            
            {
                curItem = mItems.get(i);
                break;
            } //End block
        } //End block
        mAdapter.setPrimaryItem(this, mCurItem, curItem != null ? curItem.object : null);
        mAdapter.finishUpdate(this);
        if(hasFocus())        
        {
            View currentFocused = findFocus();
            ItemInfo ii = currentFocused != null ? infoForAnyChild(currentFocused) : null;
            if(ii == null || ii.position != mCurItem)            
            {
for(int i=0;i<getChildCount();i++)
                {
                    View child = getChildAt(i);
                    ii = infoForChild(child);
                    if(ii != null && ii.position == mCurItem)                    
                    {
                        if(child.requestFocus(FOCUS_FORWARD))                        
                        {
                            break;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.770 -0400", hash_original_method = "14189B7A9DD30FC59304078756C5DA79", hash_generated_method = "3ABCE66545132560ED540D899885C11F")
    @Override
    public Parcelable onSaveInstanceState() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.position = mCurItem;
        if(mAdapter != null)        
        {
            ss.adapterState = mAdapter.saveState();
        } //End block
Parcelable var182E37827114C3F455816E0E29D81D76_780343724 =         ss;
        var182E37827114C3F455816E0E29D81D76_780343724.addTaint(taint);
        return var182E37827114C3F455816E0E29D81D76_780343724;
        // ---------- Original Method ----------
        //Parcelable superState = super.onSaveInstanceState();
        //SavedState ss = new SavedState(superState);
        //ss.position = mCurItem;
        //if (mAdapter != null) {
            //ss.adapterState = mAdapter.saveState();
        //}
        //return ss;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.770 -0400", hash_original_method = "D24913A88F27B9FFD16DBB95EA1FF14B", hash_generated_method = "E10FBB944EBBAA47E1C5DFEA5CF5E3DF")
    @Override
    public void onRestoreInstanceState(Parcelable state) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(state.getTaint());
        if(!(state instanceof SavedState))        
        {
            super.onRestoreInstanceState(state);
            return;
        } //End block
        SavedState ss = (SavedState)state;
        super.onRestoreInstanceState(ss.getSuperState());
        if(mAdapter != null)        
        {
            mAdapter.restoreState(ss.adapterState, ss.loader);
            setCurrentItemInternal(ss.position, false, true);
        } //End block
        else
        {
            mRestoredCurItem = ss.position;
            mRestoredAdapterState = ss.adapterState;
            mRestoredClassLoader = ss.loader;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.771 -0400", hash_original_method = "CCA2D7E19B51FD6942892776091DF304", hash_generated_method = "4363955189C19E7F66043B85CB920413")
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        if(!checkLayoutParams(params))        
        {
            params = generateLayoutParams(params);
        } //End block
        final LayoutParams lp = (LayoutParams) params;
        lp.isDecor |= child instanceof Decor;
        if(mInLayout)        
        {
            if(lp != null && lp.isDecor)            
            {
                IllegalStateException var7F73BD8DA61A3CEA9CD86CE713B8D2AB_2004846936 = new IllegalStateException("Cannot add pager decor view during layout");
                var7F73BD8DA61A3CEA9CD86CE713B8D2AB_2004846936.addTaint(taint);
                throw var7F73BD8DA61A3CEA9CD86CE713B8D2AB_2004846936;
            } //End block
            addViewInLayout(child, index, params);
            child.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
        } //End block
        else
        {
            super.addView(child, index, params);
        } //End block
        if(USE_CACHE)        
        {
            if(child.getVisibility() != GONE)            
            {
                child.setDrawingCacheEnabled(mScrollingCacheEnabled);
            } //End block
            else
            {
                child.setDrawingCacheEnabled(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.771 -0400", hash_original_method = "3A127F64616A326BFDC211D8F4FB8341", hash_generated_method = "4E52B7D9B0184EE0F0B16584A88BFDEA")
     ItemInfo infoForChild(View child) {
        addTaint(child.getTaint());
for(int i=0;i<mItems.size();i++)
        {
            ItemInfo ii = mItems.get(i);
            if(mAdapter.isViewFromObject(child, ii.object))            
            {
ItemInfo var271C06C7ED7711E7D563AD4C67B1449E_1369067454 =                 ii;
                var271C06C7ED7711E7D563AD4C67B1449E_1369067454.addTaint(taint);
                return var271C06C7ED7711E7D563AD4C67B1449E_1369067454;
            } //End block
        } //End block
ItemInfo var540C13E9E156B687226421B24F2DF178_592661253 =         null;
        var540C13E9E156B687226421B24F2DF178_592661253.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_592661253;
        // ---------- Original Method ----------
        //for (int i=0; i<mItems.size(); i++) {
            //ItemInfo ii = mItems.get(i);
            //if (mAdapter.isViewFromObject(child, ii.object)) {
                //return ii;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.771 -0400", hash_original_method = "1D0A995632EA6711A9479487500A682E", hash_generated_method = "981F8188EB51834E54E38DB1471A4B0C")
     ItemInfo infoForAnyChild(View child) {
        addTaint(child.getTaint());
        ViewParent parent;
        while
((parent=child.getParent()) != this)        
        {
            if(parent == null || !(parent instanceof View))            
            {
ItemInfo var540C13E9E156B687226421B24F2DF178_1197410815 =                 null;
                var540C13E9E156B687226421B24F2DF178_1197410815.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1197410815;
            } //End block
            child = (View)parent;
        } //End block
ItemInfo varCA66F906D6AD4B5FB568D7FA2EA5A868_273748540 =         infoForChild(child);
        varCA66F906D6AD4B5FB568D7FA2EA5A868_273748540.addTaint(taint);
        return varCA66F906D6AD4B5FB568D7FA2EA5A868_273748540;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.771 -0400", hash_original_method = "55E78F1E2A11C365755D77C284D387A2", hash_generated_method = "F620B046D3F9AED0D5778C8B88C50DA3")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mFirstLayout = true;
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //mFirstLayout = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.772 -0400", hash_original_method = "52B64CDCDB17F6464B1AA9D44D4C5C01", hash_generated_method = "23CC89B5212E4F5B9470A611AB4FF2CB")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        int childHeightSize = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int size = getChildCount();
for(int i = 0;i < size;++i)
        {
            final View child = getChildAt(i);
            if(child.getVisibility() != GONE)            
            {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if(lp != null && lp.isDecor)                
                {
                    final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                    final int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
                    Log.d(TAG, "gravity: " + lp.gravity + " hgrav: " + hgrav + " vgrav: " + vgrav);
                    int widthMode = MeasureSpec.AT_MOST;
                    int heightMode = MeasureSpec.AT_MOST;
                    boolean consumeVertical = vgrav == Gravity.TOP || vgrav == Gravity.BOTTOM;
                    boolean consumeHorizontal = hgrav == Gravity.LEFT || hgrav == Gravity.RIGHT;
                    if(consumeVertical)                    
                    {
                        widthMode = MeasureSpec.EXACTLY;
                    } //End block
                    else
                    if(consumeHorizontal)                    
                    {
                        heightMode = MeasureSpec.EXACTLY;
                    } //End block
                    final int widthSpec = MeasureSpec.makeMeasureSpec(childWidthSize, widthMode);
                    final int heightSpec = MeasureSpec.makeMeasureSpec(childHeightSize, heightMode);
                    child.measure(widthSpec, heightSpec);
                    if(consumeVertical)                    
                    {
                        childHeightSize -= child.getMeasuredHeight();
                    } //End block
                    else
                    if(consumeHorizontal)                    
                    {
                        childWidthSize -= child.getMeasuredWidth();
                    } //End block
                } //End block
            } //End block
        } //End block
        mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeightSize, MeasureSpec.EXACTLY);
        mInLayout = true;
        populate();
        mInLayout = false;
        size = getChildCount();
for(int i = 0;i < size;++i)
        {
            final View child = getChildAt(i);
            if(child.getVisibility() != GONE)            
            {
                if(DEBUG){ }                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if(lp == null || !lp.isDecor)                
                {
                    child.measure(mChildWidthMeasureSpec, mChildHeightMeasureSpec);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.773 -0400", hash_original_method = "D136D70D1C0AC62B68634CD89991503C", hash_generated_method = "8802688E243DF83EABC478EFA140F96E")
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(oldh);
        addTaint(oldw);
        addTaint(h);
        addTaint(w);
        super.onSizeChanged(w, h, oldw, oldh);
        if(w != oldw)        
        {
            recomputeScrollPosition(w, oldw, mPageMargin, mPageMargin);
        } //End block
        // ---------- Original Method ----------
        //super.onSizeChanged(w, h, oldw, oldh);
        //if (w != oldw) {
            //recomputeScrollPosition(w, oldw, mPageMargin, mPageMargin);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.773 -0400", hash_original_method = "BF2EFCA6E1F80930784A0AE156969F1F", hash_generated_method = "A81D3F537E19C722A760A45997DECA44")
    private void recomputeScrollPosition(int width, int oldWidth, int margin, int oldMargin) {
        addTaint(oldMargin);
        addTaint(margin);
        addTaint(oldWidth);
        addTaint(width);
        final int widthWithMargin = width + margin;
        if(oldWidth > 0)        
        {
            final int oldScrollPos = getScrollX();
            final int oldwwm = oldWidth + oldMargin;
            final int oldScrollItem = oldScrollPos / oldwwm;
            final float scrollOffset = (float) (oldScrollPos % oldwwm) / oldwwm;
            final int scrollPos = (int) ((oldScrollItem + scrollOffset) * widthWithMargin);
            scrollTo(scrollPos, getScrollY());
            if(!mScroller.isFinished())            
            {
                final int newDuration = mScroller.getDuration() - mScroller.timePassed();
                mScroller.startScroll(scrollPos, 0, mCurItem * widthWithMargin, 0, newDuration);
            } //End block
        } //End block
        else
        {
            int scrollPos = mCurItem * widthWithMargin;
            if(scrollPos != getScrollX())            
            {
                completeScroll();
                scrollTo(scrollPos, getScrollY());
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.774 -0400", hash_original_method = "91DBAE2CED1324F5F1E91DEC22CE5EE7", hash_generated_method = "17E4410CC119E2805B48194FA65FF562")
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
        addTaint(changed);
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
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
            if(child.getVisibility() != GONE)            
            {
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                ItemInfo ii;
                int childLeft = 0;
                int childTop = 0;
                if(lp.isDecor)                
                {
                    final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                    final int vgrav = lp.gravity & Gravity.VERTICAL_GRAVITY_MASK;
switch(hgrav){
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
}switch(vgrav){
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
}                    childLeft += scrollX;
                    decorCount++;
                    child.layout(childLeft, childTop,
                            childLeft + child.getMeasuredWidth(),
                            childTop + child.getMeasuredHeight());
                } //End block
                else
                if((ii = infoForChild(child)) != null)                
                {
                    int loff = (width + mPageMargin) * ii.position;
                    childLeft = paddingLeft + loff;
                    childTop = paddingTop;
                    if(DEBUG){ }                    child.layout(childLeft, childTop,
                            childLeft + child.getMeasuredWidth(),
                            childTop + child.getMeasuredHeight());
                } //End block
            } //End block
        } //End block
        mTopPageBounds = paddingTop;
        mBottomPageBounds = height - paddingBottom;
        mDecorChildCount = decorCount;
        mFirstLayout = false;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.774 -0400", hash_original_method = "245E7C909F76590CC461C5035FA848B9", hash_generated_method = "FB0D804057A6409EBE3486325D19CC63")
    @Override
    public void computeScroll() {
        if(DEBUG){ }        if(!mScroller.isFinished())        
        {
            if(mScroller.computeScrollOffset())            
            {
                if(DEBUG){ }                int oldX = getScrollX();
                int oldY = getScrollY();
                int x = mScroller.getCurrX();
                int y = mScroller.getCurrY();
                if(oldX != x || oldY != y)                
                {
                    scrollTo(x, y);
                    pageScrolled(x);
                } //End block
                invalidate();
                return;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.785 -0400", hash_original_method = "07505BF167DC29F6F179D71B0816840E", hash_generated_method = "43F6E9261B674A1B740A3B7F99473FB9")
    private void pageScrolled(int xpos) {
        addTaint(xpos);
        final int widthWithMargin = getWidth() + mPageMargin;
        final int position = xpos / widthWithMargin;
        final int offsetPixels = xpos % widthWithMargin;
        final float offset = (float) offsetPixels / widthWithMargin;
        mCalledSuper = false;
        onPageScrolled(position, offset, offsetPixels);
        if(!mCalledSuper)        
        {
            IllegalStateException var6429E79ED0893C129425181790225A79_1747401927 = new IllegalStateException(
                    "onPageScrolled did not call superclass implementation");
            var6429E79ED0893C129425181790225A79_1747401927.addTaint(taint);
            throw var6429E79ED0893C129425181790225A79_1747401927;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.785 -0400", hash_original_method = "D3205253D12342035E86376912330E75", hash_generated_method = "CDE80C75083910853F006AF200982541")
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(offsetPixels);
        addTaint(offset);
        addTaint(position);
        if(mDecorChildCount > 0)        
        {
            final int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            final int width = getWidth();
            final int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
            {
                final View child = getChildAt(i);
                final LayoutParams lp = (LayoutParams) child.getLayoutParams();
                if(!lp.isDecor)                
                continue;
                final int hgrav = lp.gravity & Gravity.HORIZONTAL_GRAVITY_MASK;
                int childLeft = 0;
switch(hgrav){
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
}                childLeft += scrollX;
                final int childOffset = childLeft - child.getLeft();
                if(childOffset != 0)                
                {
                    child.offsetLeftAndRight(childOffset);
                } //End block
            } //End block
        } //End block
        if(mOnPageChangeListener != null)        
        {
            mOnPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        } //End block
        if(mInternalPageChangeListener != null)        
        {
            mInternalPageChangeListener.onPageScrolled(position, offset, offsetPixels);
        } //End block
        mCalledSuper = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.793 -0400", hash_original_method = "B1229287A4B4E18886EBB2FC1C1A6ECA", hash_generated_method = "853BCDA6A2E3A08520FDEE0235508018")
    private void completeScroll() {
        boolean needPopulate = mScrolling;
        if(needPopulate)        
        {
            setScrollingCacheEnabled(false);
            mScroller.abortAnimation();
            int oldX = getScrollX();
            int oldY = getScrollY();
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();
            if(oldX != x || oldY != y)            
            {
                scrollTo(x, y);
            } //End block
            setScrollState(SCROLL_STATE_IDLE);
        } //End block
        mPopulatePending = false;
        mScrolling = false;
for(int i=0;i<mItems.size();i++)
        {
            ItemInfo ii = mItems.get(i);
            if(ii.scrolling)            
            {
                needPopulate = true;
                ii.scrolling = false;
            } //End block
        } //End block
        if(needPopulate)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.794 -0400", hash_original_method = "965C57B2E8FC3C570BE548067A40E31E", hash_generated_method = "33035229247070B73B925D3F2D1CC985")
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        final int action = ev.getAction() & MotionEventCompat.ACTION_MASK;
        if(action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP)        
        {
            if(DEBUG){ }            mIsBeingDragged = false;
            mIsUnableToDrag = false;
            mActivePointerId = INVALID_POINTER;
            if(mVelocityTracker != null)            
            {
                mVelocityTracker.recycle();
                mVelocityTracker = null;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_399527448 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_196811386 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_196811386;
        } //End block
        if(action != MotionEvent.ACTION_DOWN)        
        {
            if(mIsBeingDragged)            
            {
                if(DEBUG){ }                boolean varB326B5062B2F0E69046810717534CB09_466703202 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876518274 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_876518274;
            } //End block
            if(mIsUnableToDrag)            
            {
                if(DEBUG){ }                boolean var68934A3E9455FA72420237EB05902327_1866545074 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290217230 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290217230;
            } //End block
        } //End block
switch(action){
        case MotionEvent.ACTION_MOVE:
        {
            final int activePointerId = mActivePointerId;
            if(activePointerId == INVALID_POINTER)            
            {
                break;
            } //End block
            final int pointerIndex = MotionEventCompat.findPointerIndex(ev, activePointerId);
            final float x = MotionEventCompat.getX(ev, pointerIndex);
            final float dx = x - mLastMotionX;
            final float xDiff = Math.abs(dx);
            final float y = MotionEventCompat.getY(ev, pointerIndex);
            final float yDiff = Math.abs(y - mLastMotionY);
            if(DEBUG){ }            if(canScroll(this, false, (int) dx, (int) x, (int) y))            
            {
                mInitialMotionX = mLastMotionX = x;
                mLastMotionY = y;
                boolean var68934A3E9455FA72420237EB05902327_815875466 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719378205 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719378205;
            } //End block
            if(xDiff > mTouchSlop && xDiff > yDiff)            
            {
                if(DEBUG){ }                mIsBeingDragged = true;
                setScrollState(SCROLL_STATE_DRAGGING);
                mLastMotionX = x;
                setScrollingCacheEnabled(true);
            } //End block
            else
            {
                if(yDiff > mTouchSlop)                
                {
                    if(DEBUG){ }                    mIsUnableToDrag = true;
                } //End block
            } //End block
            break;
        } //End block
        case MotionEvent.ACTION_DOWN:
        {
            mLastMotionX = mInitialMotionX = ev.getX();
            mLastMotionY = ev.getY();
            mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
            if(mScrollState == SCROLL_STATE_SETTLING)            
            {
                mIsBeingDragged = true;
                mIsUnableToDrag = false;
                setScrollState(SCROLL_STATE_DRAGGING);
            } //End block
            else
            {
                completeScroll();
                mIsBeingDragged = false;
                mIsUnableToDrag = false;
            } //End block
            if(DEBUG){ }            break;
        } //End block
        case MotionEventCompat.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        break;
}        if(!mIsBeingDragged)        
        {
            if(mVelocityTracker == null)            
            {
                mVelocityTracker = VelocityTracker.obtain();
            } //End block
            mVelocityTracker.addMovement(ev);
        } //End block
        boolean varCD7F83DE880FD2A584529B26609B9552_472665534 = (mIsBeingDragged);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_82585030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_82585030;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.795 -0400", hash_original_method = "88D861E2913027BDD6B43DC3209AC688", hash_generated_method = "EBF17716CD37F41A00E6A19F2C9D5007")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mFakeDragging)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_959761120 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1470383603 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1470383603;
        } //End block
        if(ev.getAction() == MotionEvent.ACTION_DOWN && ev.getEdgeFlags() != 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_912558573 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527856367 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_527856367;
        } //End block
        if(mAdapter == null || mAdapter.getCount() == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1825327269 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226176727 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226176727;
        } //End block
        if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        mVelocityTracker.addMovement(ev);
        final int action = ev.getAction();
        boolean needsInvalidate = false;
switch(action & MotionEventCompat.ACTION_MASK){
        case MotionEvent.ACTION_DOWN:
        {
            completeScroll();
            mLastMotionX = mInitialMotionX = ev.getX();
            mActivePointerId = MotionEventCompat.getPointerId(ev, 0);
            break;
        } //End block
        case MotionEvent.ACTION_MOVE:
        if(!mIsBeingDragged)        
        {
            final int pointerIndex = MotionEventCompat.findPointerIndex(ev, mActivePointerId);
            final float x = MotionEventCompat.getX(ev, pointerIndex);
            final float xDiff = Math.abs(x - mLastMotionX);
            final float y = MotionEventCompat.getY(ev, pointerIndex);
            final float yDiff = Math.abs(y - mLastMotionY);
            if(DEBUG){ }            if(xDiff > mTouchSlop && xDiff > yDiff)            
            {
                if(DEBUG){ }                mIsBeingDragged = true;
                mLastMotionX = x;
                setScrollState(SCROLL_STATE_DRAGGING);
                setScrollingCacheEnabled(true);
            } //End block
        } //End block
        if(mIsBeingDragged)        
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
            if(scrollX < leftBound)            
            {
                if(leftBound == 0)                
                {
                    float over = -scrollX;
                    needsInvalidate = mLeftEdge.onPull(over / width);
                } //End block
                scrollX = leftBound;
            } //End block
            else
            if(scrollX > rightBound)            
            {
                if(rightBound == lastItemIndex * widthWithMargin)                
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
        break;
        case MotionEvent.ACTION_UP:
        if(mIsBeingDragged)        
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
        break;
        case MotionEvent.ACTION_CANCEL:
        if(mIsBeingDragged)        
        {
            setCurrentItemInternal(mCurItem, true, true);
            mActivePointerId = INVALID_POINTER;
            endDrag();
            needsInvalidate = mLeftEdge.onRelease() | mRightEdge.onRelease();
        } //End block
        break;
        case MotionEventCompat.ACTION_POINTER_DOWN:
        {
            final int index = MotionEventCompat.getActionIndex(ev);
            final float x = MotionEventCompat.getX(ev, index);
            mLastMotionX = x;
            mActivePointerId = MotionEventCompat.getPointerId(ev, index);
            break;
        } //End block
        case MotionEventCompat.ACTION_POINTER_UP:
        onSecondaryPointerUp(ev);
        mLastMotionX = MotionEventCompat.getX(ev,
                        MotionEventCompat.findPointerIndex(ev, mActivePointerId));
        break;
}        if(needsInvalidate)        
        {
            invalidate();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2040122359 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_791363109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_791363109;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.804 -0400", hash_original_method = "A599F43FA0EC47D3B5F0044593C86DDF", hash_generated_method = "1A7E9BB883F9F8D3F899A972DD006B46")
    private int determineTargetPage(int currentPage, float pageOffset, int velocity, int deltaX) {
        addTaint(deltaX);
        addTaint(velocity);
        addTaint(pageOffset);
        addTaint(currentPage);
        int targetPage;
        if(Math.abs(deltaX) > mFlingDistance && Math.abs(velocity) > mMinimumVelocity)        
        {
            targetPage = velocity > 0 ? currentPage : currentPage + 1;
        } //End block
        else
        {
            targetPage = (int) (currentPage + pageOffset + 0.5f);
        } //End block
        int var61859375BF4E7601AEC6CD96DD1F9E47_967063734 = (targetPage);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693068859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693068859;
        // ---------- Original Method ----------
        //int targetPage;
        //if (Math.abs(deltaX) > mFlingDistance && Math.abs(velocity) > mMinimumVelocity) {
            //targetPage = velocity > 0 ? currentPage : currentPage + 1;
        //} else {
            //targetPage = (int) (currentPage + pageOffset + 0.5f);
        //}
        //return targetPage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.804 -0400", hash_original_method = "EFAFFAB02B49B744BACD5A955538775F", hash_generated_method = "55B45872C3313F9506BCA8473DD88800")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
        super.draw(canvas);
        boolean needsInvalidate = false;
        final int overScrollMode = ViewCompat.getOverScrollMode(this);
        if(overScrollMode == ViewCompat.OVER_SCROLL_ALWAYS ||
                (overScrollMode == ViewCompat.OVER_SCROLL_IF_CONTENT_SCROLLS &&
                        mAdapter != null && mAdapter.getCount() > 1))        
        {
            if(!mLeftEdge.isFinished())            
            {
                final int restoreCount = canvas.save();
                final int height = getHeight() - getPaddingTop() - getPaddingBottom();
                canvas.rotate(270);
                canvas.translate(-height + getPaddingTop(), 0);
                mLeftEdge.setSize(height, getWidth());
                needsInvalidate |= mLeftEdge.draw(canvas);
                canvas.restoreToCount(restoreCount);
            } //End block
            if(!mRightEdge.isFinished())            
            {
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
            } //End block
        } //End block
        else
        {
            mLeftEdge.finish();
            mRightEdge.finish();
        } //End block
        if(needsInvalidate)        
        {
            invalidate();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.804 -0400", hash_original_method = "C696E5F5E436E83A9E43E2B41DDB422F", hash_generated_method = "BA89ABD73D0C8663E36897A789B1D8D4")
    @Override
    protected void onDraw(Canvas canvas) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(canvas.getTaint());
        super.onDraw(canvas);
        if(mPageMargin > 0 && mMarginDrawable != null)        
        {
            final int scrollX = getScrollX();
            final int width = getWidth();
            final int offset = scrollX % (width + mPageMargin);
            if(offset != 0)            
            {
                final int left = scrollX - offset + width;
                mMarginDrawable.setBounds(left, mTopPageBounds, left + mPageMargin,
                        mBottomPageBounds);
                mMarginDrawable.draw(canvas);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.805 -0400", hash_original_method = "2447A911D9005F96843292B56C864341", hash_generated_method = "2DBCD8DF461E7C2C685805CC08CCE4C2")
    public boolean beginFakeDrag() {
        if(mIsBeingDragged)        
        {
            boolean var68934A3E9455FA72420237EB05902327_691713480 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659075742 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659075742;
        } //End block
        mFakeDragging = true;
        setScrollState(SCROLL_STATE_DRAGGING);
        mInitialMotionX = mLastMotionX = 0;
        if(mVelocityTracker == null)        
        {
            mVelocityTracker = VelocityTracker.obtain();
        } //End block
        else
        {
            mVelocityTracker.clear();
        } //End block
        final long time = SystemClock.uptimeMillis();
        final MotionEvent ev = MotionEvent.obtain(time, time, MotionEvent.ACTION_DOWN, 0, 0, 0);
        mVelocityTracker.addMovement(ev);
        ev.recycle();
        mFakeDragBeginTime = time;
        boolean varB326B5062B2F0E69046810717534CB09_1702138810 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_564945423 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_564945423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.805 -0400", hash_original_method = "012F2AA21899E6B7C86DFCCAFEEFC371", hash_generated_method = "C7DAFAFA7FD00DD9B4D9598F2729E492")
    public void endFakeDrag() {
        if(!mFakeDragging)        
        {
            IllegalStateException var2AFCE91F76EC75632E8513C46867D9E2_1015788939 = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            var2AFCE91F76EC75632E8513C46867D9E2_1015788939.addTaint(taint);
            throw var2AFCE91F76EC75632E8513C46867D9E2_1015788939;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.806 -0400", hash_original_method = "3C01AF98038E7AF52A40B265C4F4693E", hash_generated_method = "41340A9F17C9BBA4F7FFA5CDDB5DABF8")
    public void fakeDragBy(float xOffset) {
        if(!mFakeDragging)        
        {
            IllegalStateException var2AFCE91F76EC75632E8513C46867D9E2_2119983755 = new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
            var2AFCE91F76EC75632E8513C46867D9E2_2119983755.addTaint(taint);
            throw var2AFCE91F76EC75632E8513C46867D9E2_2119983755;
        } //End block
        mLastMotionX += xOffset;
        float scrollX = getScrollX() - xOffset;
        final int width = getWidth();
        final int widthWithMargin = width + mPageMargin;
        final float leftBound = Math.max(0, (mCurItem - 1) * widthWithMargin);
        final float rightBound = Math.min(mCurItem + 1, mAdapter.getCount() - 1) * widthWithMargin;
        if(scrollX < leftBound)        
        {
            scrollX = leftBound;
        } //End block
        else
        if(scrollX > rightBound)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.811 -0400", hash_original_method = "A453849F99C417376DDBB8B219E48B12", hash_generated_method = "56103210653E58ABD956100B1E70F058")
    public boolean isFakeDragging() {
        boolean varA433486E64E1D58A4CCC7C7414F54C8F_929381672 = (mFakeDragging);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2134986237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2134986237;
        // ---------- Original Method ----------
        //return mFakeDragging;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.811 -0400", hash_original_method = "0206AC68AD27D7D682B52A43262096FD", hash_generated_method = "4927DD1F7D8C90960B9057A38242035B")
    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = MotionEventCompat.getActionIndex(ev);
        final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);
        if(pointerId == mActivePointerId)        
        {
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionX = MotionEventCompat.getX(ev, newPointerIndex);
            mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
            if(mVelocityTracker != null)            
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.811 -0400", hash_original_method = "6F589820542A60985222493865875D9E", hash_generated_method = "B3FFAD48F39B9DC40D2A2610E26DC042")
    private void endDrag() {
        mIsBeingDragged = false;
        mIsUnableToDrag = false;
        if(mVelocityTracker != null)        
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.811 -0400", hash_original_method = "2B073E6A9B3015E7E6D245BDA0374ADD", hash_generated_method = "595C47E523309F0CF1633FFA5A230E6D")
    private void setScrollingCacheEnabled(boolean enabled) {
        if(mScrollingCacheEnabled != enabled)        
        {
            mScrollingCacheEnabled = enabled;
            if(USE_CACHE)            
            {
                final int size = getChildCount();
for(int i = 0;i < size;++i)
                {
                    final View child = getChildAt(i);
                    if(child.getVisibility() != GONE)                    
                    {
                        child.setDrawingCacheEnabled(enabled);
                    } //End block
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.817 -0400", hash_original_method = "72E1851DC28067296F340B8A32532AE8", hash_generated_method = "B3B6238E62B36B123854077F15281188")
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        addTaint(y);
        addTaint(x);
        addTaint(dx);
        addTaint(checkV);
        addTaint(v.getTaint());
        if(v instanceof ViewGroup)        
        {
            final ViewGroup group = (ViewGroup) v;
            final int scrollX = v.getScrollX();
            final int scrollY = v.getScrollY();
            final int count = group.getChildCount();
for(int i = count - 1;i >= 0;i--)
            {
                final View child = group.getChildAt(i);
                if(x + scrollX >= child.getLeft() && x + scrollX < child.getRight() &&
                        y + scrollY >= child.getTop() && y + scrollY < child.getBottom() &&
                        canScroll(child, true, dx, x + scrollX - child.getLeft(),
                                y + scrollY - child.getTop()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_34065376 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929148879 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929148879;
                } //End block
            } //End block
        } //End block
        boolean var7D2815C2251A7A7D3674AA30E75CBE47_843874321 = (checkV && ViewCompat.canScrollHorizontally(v, -dx));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316441152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316441152;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.818 -0400", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "1C4A8E1ECAC8F555EFD0B44737A2E1D5")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean var4D7C358C8BD535F7098378506DB34C5F_893537207 = (super.dispatchKeyEvent(event) || executeKeyEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078360792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078360792;
        // ---------- Original Method ----------
        //return super.dispatchKeyEvent(event) || executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.818 -0400", hash_original_method = "017D0A0A9E198144CB9BC76029528664", hash_generated_method = "CEBDAC73640CE7C307386CBCF5B584D4")
    public boolean executeKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        boolean handled = false;
        if(event.getAction() == KeyEvent.ACTION_DOWN)        
        {
switch(event.getKeyCode()){
            case KeyEvent.KEYCODE_DPAD_LEFT:
            handled = arrowScroll(FOCUS_LEFT);
            break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            handled = arrowScroll(FOCUS_RIGHT);
            break;
            case KeyEvent.KEYCODE_TAB:
            if(Build.VERSION.SDK_INT >= 11)            
            {
                if(KeyEventCompat.hasNoModifiers(event))                
                {
                    handled = arrowScroll(FOCUS_FORWARD);
                } //End block
                else
                if(KeyEventCompat.hasModifiers(event, KeyEvent.META_SHIFT_ON))                
                {
                    handled = arrowScroll(FOCUS_BACKWARD);
                } //End block
            } //End block
            break;
}
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1871426407 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609341717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609341717;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.822 -0400", hash_original_method = "D3FA41B6A01CF24848855E27CD47D6CF", hash_generated_method = "0B76F8ACA401399DC1E441135569E4C2")
    public boolean arrowScroll(int direction) {
        addTaint(direction);
        View currentFocused = findFocus();
        if(currentFocused == this)        
        currentFocused = null;
        boolean handled = false;
        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused,
                direction);
        if(nextFocused != null && nextFocused != currentFocused)        
        {
            if(direction == View.FOCUS_LEFT)            
            {
                if(currentFocused != null && nextFocused.getLeft() >= currentFocused.getLeft())                
                {
                    handled = pageLeft();
                } //End block
                else
                {
                    handled = nextFocused.requestFocus();
                } //End block
            } //End block
            else
            if(direction == View.FOCUS_RIGHT)            
            {
                if(currentFocused != null && nextFocused.getLeft() <= currentFocused.getLeft())                
                {
                    handled = pageRight();
                } //End block
                else
                {
                    handled = nextFocused.requestFocus();
                } //End block
            } //End block
        } //End block
        else
        if(direction == FOCUS_LEFT || direction == FOCUS_BACKWARD)        
        {
            handled = pageLeft();
        } //End block
        else
        if(direction == FOCUS_RIGHT || direction == FOCUS_FORWARD)        
        {
            handled = pageRight();
        } //End block
        if(handled)        
        {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(direction));
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_957957506 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1098255859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1098255859;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.824 -0400", hash_original_method = "912A9F83854DBABFF351742D4C2540EB", hash_generated_method = "6D8457C8FC2E78CACE8EB8409659CD80")
     boolean pageLeft() {
        if(mCurItem > 0)        
        {
            setCurrentItem(mCurItem-1, true);
            boolean varB326B5062B2F0E69046810717534CB09_2147230713 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_256520998 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_256520998;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_967687852 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1330200777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1330200777;
        // ---------- Original Method ----------
        //if (mCurItem > 0) {
            //setCurrentItem(mCurItem-1, true);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.824 -0400", hash_original_method = "09CF7C21498AA4945971EA3F1CB23A09", hash_generated_method = "4EA2F3C07C9DBE1A218755818A0581E0")
     boolean pageRight() {
        if(mAdapter != null && mCurItem < (mAdapter.getCount()-1))        
        {
            setCurrentItem(mCurItem+1, true);
            boolean varB326B5062B2F0E69046810717534CB09_900374477 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752174572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752174572;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_198268791 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1451504479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1451504479;
        // ---------- Original Method ----------
        //if (mAdapter != null && mCurItem < (mAdapter.getCount()-1)) {
            //setCurrentItem(mCurItem+1, true);
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.824 -0400", hash_original_method = "F0A4B928270BC454FADC3A823B922DBC", hash_generated_method = "98DCC4483A1C7A5398E889E83A089BF9")
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        addTaint(focusableMode);
        addTaint(direction);
        addTaint(views.getTaint());
        final int focusableCount = views.size();
        final int descendantFocusability = getDescendantFocusability();
        if(descendantFocusability != FOCUS_BLOCK_DESCENDANTS)        
        {
for(int i = 0;i < getChildCount();i++)
            {
                final View child = getChildAt(i);
                if(child.getVisibility() == VISIBLE)                
                {
                    ItemInfo ii = infoForChild(child);
                    if(ii != null && ii.position == mCurItem)                    
                    {
                        child.addFocusables(views, direction, focusableMode);
                    } //End block
                } //End block
            } //End block
        } //End block
        if(descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                (focusableCount == views.size()))        
        {
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
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.826 -0400", hash_original_method = "B172770A91C5B5BBEA8CA0E8181B4D77", hash_generated_method = "4C9C0C5F247FCB5091EAC8621B7F0A8E")
    @Override
    public void addTouchables(ArrayList<View> views) {
        addTaint(views.getTaint());
for(int i = 0;i < getChildCount();i++)
        {
            final View child = getChildAt(i);
            if(child.getVisibility() == VISIBLE)            
            {
                ItemInfo ii = infoForChild(child);
                if(ii != null && ii.position == mCurItem)                
                {
                    child.addTouchables(views);
                } //End block
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.826 -0400", hash_original_method = "CCC0F1DB24268E606FA269C862549D2B", hash_generated_method = "3EC201E2A4D97AB0A6B6F27729D539A2")
    @Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        int index;
        int increment;
        int end;
        int count = getChildCount();
        if((direction & FOCUS_FORWARD) != 0)        
        {
            index = 0;
            increment = 1;
            end = count;
        } //End block
        else
        {
            index = count - 1;
            increment = -1;
            end = -1;
        } //End block
for(int i = index;i != end;i += increment)
        {
            View child = getChildAt(i);
            if(child.getVisibility() == VISIBLE)            
            {
                ItemInfo ii = infoForChild(child);
                if(ii != null && ii.position == mCurItem)                
                {
                    if(child.requestFocus(direction, previouslyFocusedRect))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_129077263 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393301109 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393301109;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_907646989 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_268710528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_268710528;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.827 -0400", hash_original_method = "1C80A36EDB4BAC430A3311DB8FBFC0D6", hash_generated_method = "2676C583266EE1E8B924BA537F3F6EC5")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        final int childCount = getChildCount();
for(int i = 0;i < childCount;i++)
        {
            final View child = getChildAt(i);
            if(child.getVisibility() == VISIBLE)            
            {
                final ItemInfo ii = infoForChild(child);
                if(ii != null && ii.position == mCurItem &&
                        child.dispatchPopulateAccessibilityEvent(event))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1671436683 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780762728 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780762728;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_151250814 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897358829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897358829;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.827 -0400", hash_original_method = "763708F2B4B4E396A96E9D3340F0B010", hash_generated_method = "673E64AD23B6BF9911E201E042F2334A")
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
ViewGroup.LayoutParams varD2F9AF19F351B83E6231407281521B68_2137565617 =         new LayoutParams();
        varD2F9AF19F351B83E6231407281521B68_2137565617.addTaint(taint);
        return varD2F9AF19F351B83E6231407281521B68_2137565617;
        // ---------- Original Method ----------
        //return new LayoutParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.827 -0400", hash_original_method = "D8A26BF8CEB61DB2275E97CE7D907FB8", hash_generated_method = "06C8341F14F8FDF8065A4C1C4C03543D")
    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
ViewGroup.LayoutParams var0E81305CCB52037DAA521CD210230A11_1411386694 =         generateDefaultLayoutParams();
        var0E81305CCB52037DAA521CD210230A11_1411386694.addTaint(taint);
        return var0E81305CCB52037DAA521CD210230A11_1411386694;
        // ---------- Original Method ----------
        //return generateDefaultLayoutParams();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.827 -0400", hash_original_method = "0820242DFB1833A79D3A037A247A735A", hash_generated_method = "7EAC8D815E9F2217CD8A927E4B14A968")
    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var1707AE27818A71629332993BC5C6F3DC_1360333451 = (p instanceof LayoutParams && super.checkLayoutParams(p));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1497828975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1497828975;
        // ---------- Original Method ----------
        //return p instanceof LayoutParams && super.checkLayoutParams(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "1C9B9BBEC46A39865FCD3A7288415ECD", hash_generated_method = "135BFD3B3E3471945CD0036C3B30880B")
    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
ViewGroup.LayoutParams var023B3FAAA9940C6DE114BF4C9FED2D73_994978900 =         new LayoutParams(getContext(), attrs);
        var023B3FAAA9940C6DE114BF4C9FED2D73_994978900.addTaint(taint);
        return var023B3FAAA9940C6DE114BF4C9FED2D73_994978900;
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    static class ItemInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_field = "A8CFDE6331BD59EB2AC96F8911C4B666", hash_generated_field = "4725548B2F852700377486F07DBD49CE")

        Object object;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_field = "EE5631E545C57660DC98FD28795CB9FF", hash_generated_field = "C4FC55BE953EA6922AFA9FA4551D7D29")

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


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "FDA1A61FADE7F0C7FCCDCC2DC76C3CF3", hash_generated_method = "56ED9EE580D60BE05B53133A76E9A070")
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(positionOffsetPixels);
            addTaint(positionOffset);
            addTaint(position);
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "53640E8AF66EBB8ED10DFFE2A0D2E8B4", hash_generated_method = "E14EBD5798939F6D36F12C55A8B6805A")
        @Override
        public void onPageSelected(int position) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(position);
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "257CCDCF3F3C71EC13191438C1C85826", hash_generated_method = "7D1A18F60472A016F9CCDF171AEF93EC")
        @Override
        public void onPageScrollStateChanged(int state) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(state);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class SavedState extends BaseSavedState {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "92D7808EB8CD548A137230400384C6DC")

        int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_field = "68B24046939BFC464397E8623A7021F1", hash_generated_field = "69064C35FAD6A57FDCB5B011C3C90243")

        Parcelable adapterState;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_field = "4A527F83A3A4CA7E1D70ADB26A35B72E", hash_generated_field = "50E7BE27A72C15B735AFB72AFA6F9C78")

        ClassLoader loader;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.828 -0400", hash_original_method = "89EB4EC154F05BF905ECA8E02BBD14BC", hash_generated_method = "AB11810075E98F66089A29D0DD89C4B4")
        public  SavedState(Parcelable superState) {
            super(superState);
            addTaint(superState.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_method = "C91DCD2D2A900CBC6E45E0C16FB00296", hash_generated_method = "657B832FC5D507D9AEEF8C1572736437")
          SavedState(Parcel in, ClassLoader loader) {
            super(in);
            if(loader == null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_method = "F4CAF3A56784E52DEBA10017E225034C", hash_generated_method = "4F4B1DACD113444C3AA6AED52507E853")
        @Override
        public void writeToParcel(Parcel out, int flags) {
            addTaint(flags);
            addTaint(out.getTaint());
            super.writeToParcel(out, flags);
            out.writeInt(position);
            out.writeParcelable(adapterState, flags);
            // ---------- Original Method ----------
            //super.writeToParcel(out, flags);
            //out.writeInt(position);
            //out.writeParcelable(adapterState, flags);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_method = "7E681A9714B5A31F0FD1978F434F050F", hash_generated_method = "0D179C56795D408E15D092CBA5D07830")
        @Override
        public String toString() {
String var8ED90389504921227F61E87718C80D36_1095126002 =             "FragmentPager.SavedState{"
                    + Integer.toHexString(System.identityHashCode(this))
                    + " position=" + position + "}";
            var8ED90389504921227F61E87718C80D36_1095126002.addTaint(taint);
            return var8ED90389504921227F61E87718C80D36_1095126002;
            // ---------- Original Method ----------
            //return "FragmentPager.SavedState{"
                    //+ Integer.toHexString(System.identityHashCode(this))
                    //+ " position=" + position + "}";
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_field = "0C2FD1F1D20C82721A0B333C0E7E33AB", hash_generated_field = "F13036E5254809F6F751A2283CFC452E")

        public static final Parcelable.Creator<SavedState> CREATOR
                = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<SavedState>() {
                    @DSModeled(DSC.BAN)
            @Override
                    public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                        return new SavedState(in, loader);
                    }
                    @Override
                    public SavedState[] newArray(int size) {
                        return new SavedState[size];
                    }
                });
    }


    
    private class PagerObserver extends DataSetObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.829 -0400", hash_original_method = "9650588F08E5195A8869DD8AFCD0755C", hash_generated_method = "9650588F08E5195A8869DD8AFCD0755C")
        public PagerObserver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.833 -0400", hash_original_method = "11C315FA7B2CA5C79402AC3B9B3CC875", hash_generated_method = "B9090479FFF1FB0FF809A60780229444")
        @Override
        public void onChanged() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dataSetChanged();
            // ---------- Original Method ----------
            //dataSetChanged();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.833 -0400", hash_original_method = "75A3C506698EAB8F326C44C7FA27D020", hash_generated_method = "0BA8DD5F6D5DD6AD703761FCA7405F9D")
        @Override
        public void onInvalidated() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dataSetChanged();
            // ---------- Original Method ----------
            //dataSetChanged();
        }

        
    }


    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.833 -0400", hash_original_field = "EB40674A13237E0AB9B7F06555DDF283", hash_generated_field = "59F277E75B4C152D81D2D818BA4B0D2E")

        public boolean isDecor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.833 -0400", hash_original_field = "67F2A835697E7C9C2C5146C76ECA6038", hash_generated_field = "7B969BCD8327FD354F9843B5C2FB842F")

        public int gravity;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_method = "22352D37EA586BAB2B06261A9354918D", hash_generated_method = "92FA6B303DD2F574323DBD754522A067")
        public  LayoutParams() {
            super(FILL_PARENT, FILL_PARENT);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_method = "1F1818866541ED0A2C469168FD0D681B", hash_generated_method = "9C688608162B2435714711FF4D9536F2")
        public  LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            addTaint(attrs.getTaint());
            addTaint(context.getTaint());
            final TypedArray a = context.obtainStyledAttributes(attrs, LAYOUT_ATTRS);
            gravity = a.getInteger(0, Gravity.NO_GRAVITY);
            a.recycle();
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "ECAAC16EEE36445573D0208F57208459", hash_generated_field = "8B95FE444EAF04E1B97E79FAA1346818")

    private static final String TAG = "ViewPager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "3F2A0284A6D2B9BDD5E639B3EDC89029", hash_generated_field = "650AADEFCFDF69CDD5A6A3BFC4ED1A3C")

    private static final boolean USE_CACHE = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "5BF51089DA940C4222FC11266A787C5D", hash_generated_field = "F1B189E3CF39A86400A3C9B6652580CE")

    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "35CCC02F0560CE37BD5EDAE452D93297", hash_generated_field = "17654B746B84D905348C1100B6FE7760")

    private static final int MAX_SETTLE_DURATION = 600;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "9D3B2FCB6CED37579DA48784F072A789", hash_generated_field = "57169D2A36D11070C14E490CB3A3EB03")

    private static final int MIN_DISTANCE_FOR_FLING = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "B560B24442384E98AC6B1AE5E6ADABB9", hash_generated_field = "5ADDA5389845FF3454B51DCFE6C8CFF0")

    private static final int[] LAYOUT_ATTRS = new int[] {
        android.R.attr.layout_gravity
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.094 -0400", hash_original_field = "4202665155CA1C6B56FDDCABB0AF2DC1", hash_generated_field = "5E6A95D139D1F8AE27D3F1637C286AA4")

    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {        
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:05.096 -0400", hash_original_method = "11FE6ADED2EE7422CCA03C14DA065BC8", hash_generated_method = "53761C327FF8A4A7EA67EF20258337B8")
        public float getInterpolation(float t) {
            t -= 1.0f;
            addTaint(t);
            float var546ADE640B6EDFBC8A086EF31347E768_354418954 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_354418954;
            
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "7EF8B2C57AC3A1D5EC1190F4098C6121", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "060C4A2E5F98F36D06364F608B2D8973", hash_generated_field = "03E40CFF00BD7BA3937A5499974D60CF")

    public static final int SCROLL_STATE_IDLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "9C2074D05A39F45845FA4E5761D72D3D", hash_generated_field = "E3D77F42F70C954DD577EF87B0640D7E")

    public static final int SCROLL_STATE_DRAGGING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.834 -0400", hash_original_field = "1A6A06468CD45B2434C9499716419C62", hash_generated_field = "18EEC92BF586A88EFE14E2C9E326DDB9")

    public static final int SCROLL_STATE_SETTLING = 2;
}

