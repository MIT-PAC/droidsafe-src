package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import com.android.internal.R;
import com.android.internal.util.Predicate;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.502 -0400", hash_original_field = "696495B05623D58D869C5D15A256902B", hash_generated_field = "99875A35D62FD939298A601A9F7DF5FD")

    protected ArrayList<View> mDisappearingChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.502 -0400", hash_original_field = "3F7DB39F9660F69EF1A4D273C271814A", hash_generated_field = "506B0E011CD70741D050BF2EE44FE356")

    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.502 -0400", hash_original_field = "42E518F9E3515DBB9C4BA0AD23CBAC61", hash_generated_field = "A4B16D4F5B8759534D19F2BBB80216EB")

    private View mFocused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.502 -0400", hash_original_field = "16F4F06A930B1D3A94B992BE8E780178", hash_generated_field = "E8DF69068211F73E7BD4835DA28D1F3F")

    private Transformation mChildTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.502 -0400", hash_original_field = "D8A784EF03152F38795B78B59E6687CD", hash_generated_field = "0E43FE3464FE8F2B4A13FAF73F9FFA99")

    private RectF mInvalidateRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.502 -0400", hash_original_field = "65CA6A1D57BFCD4414AFF3BF15E316A5", hash_generated_field = "1A258D5E9E5687B9DA556AF87EE040D3")

    private Transformation mInvalidationTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "3DDC2DD80BBDAAFF3D7748437C0F92DB", hash_generated_field = "278869ACFDD76183C8D171CD9E8010F4")

    private View mCurrentDragView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "70F326C41A2A7C4A33E4EBB382B916EA", hash_generated_field = "4260837AC154FE88E7ECE0B0D933BD38")

    private DragEvent mCurrentDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "6E6AEB257AE7602303150F5A2E06101C", hash_generated_field = "7C6A42655A4DC2D4BF46B4F9A41E01BC")

    private HashSet<View> mDragNotifiedChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "CB06E61812573C16C11AC1F5ED8FAC4D", hash_generated_field = "B40634C8F85313CD4FF766F9BA270DF1")

    private boolean mChildAcceptsDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "713A58D821D69EADC7B8400333D2114D", hash_generated_field = "808B6807F035EB0560F88C1C887EFD26")

    private PointF mLocalPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "EE254A0D1FB9B91AC6E612916399854B", hash_generated_field = "9303037DA96D3F26E2BF546299C3658E")

    private LayoutAnimationController mLayoutAnimationController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "D7ED5F2F2BB342E46F91D9B806A50C8F", hash_generated_field = "FE6F2E4A779D16D38F8BBFCAC393C76B")

    private Animation.AnimationListener mAnimationListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "26BDCBDC864B748F53386DFAE0C033B2", hash_generated_field = "E7D785992A22A7F38809AD101B810276")

    private TouchTarget mFirstTouchTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "2872768B4C01F416A1F5754F14B30B55", hash_generated_field = "A29A2DA0312D9EE090BC48B3458B8632")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private long mLastTouchDownTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "E1651BDE01D340FDFEDFC6ECD609DEA2", hash_generated_field = "8B2D270E66117CC663F28DDCFB87BA4F")

    @ViewDebug.ExportedProperty(category = "events") private int mLastTouchDownIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "8B01400E27E5A26EAE9410E214CEC4CB", hash_generated_field = "4CA82440F2A0B548108575FF9859A086")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "AEEE8AEDA84C3DC240ABF11CCEAF69BC", hash_generated_field = "F4574986D2BBC08122BD509305467BC4")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "7925BD3459BCDD5EDBDA3820A951C7D1", hash_generated_field = "F6A706AD2BA485262D480B431AA08D80")

    private HoverTarget mFirstHoverTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "F16BAA76122227EAC1FA8071FFD9D031", hash_generated_field = "6FD02C8ECD5E4353E1EEA59D2D252B74")

    private boolean mHoveredSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "A5BB3DDB7F77A548994B517D14DA3459", hash_generated_field = "0ABD90AE9099E56BCD9A23A2BFDD9586")

    protected int mGroupFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "CFD9A5A2BA3F2274ECC022BF6DB661C8", hash_generated_field = "5B77DDDB5E53D20BC8C371537F9D6155")

    protected int mPersistentDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "7CF7769EE949355835082685E98C8324")

    private View[] mChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "FD8A8C0C5238F97B65F22614467D44BD", hash_generated_field = "FA5DB817C33D36E210708492AC611D2B")

    private boolean mLayoutSuppressed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "A5034A70A83D3C81CEC027BDCAA166D7", hash_generated_field = "A777A0928665A4F1E7F4EF71A2259E60")

    private int mChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "E8B33C20BEE8C2EC1E2F75E228534E68", hash_generated_field = "4229E0DF467153CF57F65AC95B02B5E6")

    private Paint mCachePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "E5047FAB01E832F0446529905C5EC963")

    private LayoutTransition mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "BC704CB9A61CBF94F6C841CD3BBBC604", hash_generated_field = "C5D8A5DD8407602ED6BD80CBFE380CF3")

    private ArrayList<View> mTransitioningViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "D514310998F517320B20BEE9C067E163", hash_generated_field = "C1C569B225732CB1507D8AE1B61808FC")

    private ArrayList<View> mVisibilityChangingChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.503 -0400", hash_original_field = "09D83BDA15EFA5B57765F9C578A0ADBE", hash_generated_field = "6EF80FC61B331A8C0C9A860633C8D76D")

    @ViewDebug.ExportedProperty(category = "drawing") private boolean mDrawLayers = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.515 -0400", hash_original_field = "693F082C39142816DE048BF6C839F8C1", hash_generated_field = "8C97BD255D7304D74C15E727403A1971")

    private LayoutTransition.TransitionListener mLayoutTransitionListener = new LayoutTransition.TransitionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.514 -0400", hash_original_method = "BD73D83C5E4C50AAE7C2D0E44AB74A47", hash_generated_method = "7DFCB5C82DE7D84A396B2F6FB117206C")
        @Override
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            {
                startViewTransition(view);
            } //End block
            addTaint(transition.getTaint());
            addTaint(container.getTaint());
            addTaint(view.getTaint());
            addTaint(transitionType);
            // ---------- Original Method ----------
            //if (transitionType == LayoutTransition.DISAPPEARING) {
                //startViewTransition(view);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.515 -0400", hash_original_method = "04DFE6408D192F5CD42CA1A3B87396E7", hash_generated_method = "8F5E774E1175D870E7BAB7DBA736B4E7")
        @Override
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            {
                boolean var00EE79CB64B66FAC37BA4FE35CB2471D_881387988 = (mLayoutSuppressed && !transition.isChangingLayout());
                {
                    requestLayout();
                    mLayoutSuppressed = false;
                } //End block
            } //End collapsed parenthetic
            {
                endViewTransition(view);
            } //End block
            addTaint(transition.getTaint());
            addTaint(container.getTaint());
            addTaint(view.getTaint());
            addTaint(transitionType);
            // ---------- Original Method ----------
            //if (mLayoutSuppressed && !transition.isChangingLayout()) {
                //requestLayout();
                //mLayoutSuppressed = false;
            //}
            //if (transitionType == LayoutTransition.DISAPPEARING && mTransitioningViews != null) {
                //endViewTransition(view);
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.516 -0400", hash_original_method = "B03ADF87A05C955E785D82B4A9B527B3", hash_generated_method = "9E86527441EE6979F95DE6E48A6A7312")
    public  ViewGroup(Context context) {
        super(context);
        initViewGroup();
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //initViewGroup();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.523 -0400", hash_original_method = "01EF181B5B9BD1E2AA94519EF8FAEC5E", hash_generated_method = "D87EA6255254109A608B5FC70AF0FCE1")
    public  ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewGroup();
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        //initViewGroup();
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.523 -0400", hash_original_method = "FE20AAD08B3866F38DB1C82409548865", hash_generated_method = "082067AAFF7EA388FAD5115F033F4988")
    public  ViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViewGroup();
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        // ---------- Original Method ----------
        //initViewGroup();
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.530 -0400", hash_original_method = "8201DDC69D3895B689FCA6813D812A1F", hash_generated_method = "1BB45EED7D98F060D410D25F053D7369")
    private void initViewGroup() {
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        {
            boolean varEEA1697260544E0A5861DD090A86C488_956467932 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
            {
                mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
            } //End block
        } //End collapsed parenthetic
        setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        mChildren = new View[ARRAY_INITIAL_CAPACITY];
        mChildrenCount = 0;
        mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
        // ---------- Original Method ----------
        //setFlags(WILL_NOT_DRAW, DRAW_MASK);
        //mGroupFlags |= FLAG_CLIP_CHILDREN;
        //mGroupFlags |= FLAG_CLIP_TO_PADDING;
        //mGroupFlags |= FLAG_ANIMATION_DONE;
        //mGroupFlags |= FLAG_ANIMATION_CACHE;
        //mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        //if (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB) {
            //mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        //}
        //setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        //mChildren = new View[ARRAY_INITIAL_CAPACITY];
        //mChildrenCount = 0;
        //mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.535 -0400", hash_original_method = "4BC426CDAC642CD3FACBBAAA9F56EF39", hash_generated_method = "F37C74F8CD209AEA02E0430B8BACDE5F")
    private void initFromAttributes(Context context, AttributeSet attrs) {
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                R.styleable.ViewGroup);
        int N;
        N = a.getIndexCount();
        {
            int i;
            i = 0;
            {
                int attr;
                attr = a.getIndex(i);
                //Begin case R.styleable.ViewGroup_clipChildren 
                setClipChildren(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_clipChildren 
                //Begin case R.styleable.ViewGroup_clipToPadding 
                setClipToPadding(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_clipToPadding 
                //Begin case R.styleable.ViewGroup_animationCache 
                setAnimationCacheEnabled(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_animationCache 
                //Begin case R.styleable.ViewGroup_persistentDrawingCache 
                setPersistentDrawingCache(a.getInt(attr, PERSISTENT_SCROLLING_CACHE));
                //End case R.styleable.ViewGroup_persistentDrawingCache 
                //Begin case R.styleable.ViewGroup_addStatesFromChildren 
                setAddStatesFromChildren(a.getBoolean(attr, false));
                //End case R.styleable.ViewGroup_addStatesFromChildren 
                //Begin case R.styleable.ViewGroup_alwaysDrawnWithCache 
                setAlwaysDrawnWithCacheEnabled(a.getBoolean(attr, true));
                //End case R.styleable.ViewGroup_alwaysDrawnWithCache 
                //Begin case R.styleable.ViewGroup_layoutAnimation 
                int id;
                id = a.getResourceId(attr, -1);
                //End case R.styleable.ViewGroup_layoutAnimation 
                //Begin case R.styleable.ViewGroup_layoutAnimation 
                {
                    setLayoutAnimation(AnimationUtils.loadLayoutAnimation(mContext, id));
                } //End block
                //End case R.styleable.ViewGroup_layoutAnimation 
                //Begin case R.styleable.ViewGroup_descendantFocusability 
                setDescendantFocusability(DESCENDANT_FOCUSABILITY_FLAGS[a.getInt(attr, 0)]);
                //End case R.styleable.ViewGroup_descendantFocusability 
                //Begin case R.styleable.ViewGroup_splitMotionEvents 
                setMotionEventSplittingEnabled(a.getBoolean(attr, false));
                //End case R.styleable.ViewGroup_splitMotionEvents 
                //Begin case R.styleable.ViewGroup_animateLayoutChanges 
                boolean animateLayoutChanges;
                animateLayoutChanges = a.getBoolean(attr, false);
                //End case R.styleable.ViewGroup_animateLayoutChanges 
                //Begin case R.styleable.ViewGroup_animateLayoutChanges 
                {
                    setLayoutTransition(new LayoutTransition());
                } //End block
                //End case R.styleable.ViewGroup_animateLayoutChanges 
            } //End block
        } //End collapsed parenthetic
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.536 -0400", hash_original_method = "9DEFF27CA0C7CA0A646DEBC837B35971", hash_generated_method = "8F962539660E2F6657A4FF71F8382B7A")
    @ViewDebug.ExportedProperty(category = "focus", mapping = {
        @ViewDebug.IntToString(from = FOCUS_BEFORE_DESCENDANTS, to = "FOCUS_BEFORE_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_AFTER_DESCENDANTS, to = "FOCUS_AFTER_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_BLOCK_DESCENDANTS, to = "FOCUS_BLOCK_DESCENDANTS")
    })
    public int getDescendantFocusability() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402251863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402251863;
        // ---------- Original Method ----------
        //return mGroupFlags & FLAG_MASK_FOCUSABILITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.536 -0400", hash_original_method = "0404A0C2267D357D33DA2838086AAD01", hash_generated_method = "6777C91700ABD3CD3DF9DE9501BE5784")
    public void setDescendantFocusability(int focusability) {
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        + "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        //End case default 
        mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
        // ---------- Original Method ----------
        //switch (focusability) {
            //case FOCUS_BEFORE_DESCENDANTS:
            //case FOCUS_AFTER_DESCENDANTS:
            //case FOCUS_BLOCK_DESCENDANTS:
                //break;
            //default:
                //throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        //+ "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        //}
        //mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        //mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.557 -0400", hash_original_method = "1894A66AF55103F8230E4E4C184BE483", hash_generated_method = "2A1DBE41ABFE76B1E26C9E59815B50B8")
    @Override
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        {
            mFocused.unFocus();
            mFocused = null;
        } //End block
        super.handleFocusGainInternal(direction, previouslyFocusedRect);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        // ---------- Original Method ----------
        //if (mFocused != null) {
            //mFocused.unFocus();
            //mFocused = null;
        //}
        //super.handleFocusGainInternal(direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.558 -0400", hash_original_method = "18A4940B9B410F6E2A586E7BEB513255", hash_generated_method = "E9ADC99CAA2E22CCE522EA6FC56DFD78")
    public void requestChildFocus(View child, View focused) {
        {
            System.out.println(this + " requestChildFocus()");
        } //End block
        {
            boolean varD47ACE2ACEC5C175A0471B099816BE37_1412759975 = (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS);
        } //End collapsed parenthetic
        super.unFocus();
        {
            {
                mFocused.unFocus();
            } //End block
            mFocused = child;
        } //End block
        {
            mParent.requestChildFocus(this, focused);
        } //End block
        addTaint(focused.getTaint());
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " requestChildFocus()");
        //}
        //if (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS) {
            //return;
        //}
        //super.unFocus();
        //if (mFocused != child) {
            //if (mFocused != null) {
                //mFocused.unFocus();
            //}
            //mFocused = child;
        //}
        //if (mParent != null) {
            //mParent.requestChildFocus(this, focused);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.559 -0400", hash_original_method = "B9C632089323DEB68745C50418B61ADF", hash_generated_method = "3A5461EC50EC374BFD886934202C3530")
    public void focusableViewAvailable(View v) {
        {
            boolean varB10813EF6870F670C964BBAED5788EED_1167127299 = (mParent != null
                && (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                && !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS));
            {
                mParent.focusableViewAvailable(v);
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //if (mParent != null
                //&& (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                //&& !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS)) {
            //mParent.focusableViewAvailable(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.559 -0400", hash_original_method = "AAA08A22C93220CA5F37A81C00115203", hash_generated_method = "CA989422C959D362CDD72600D9843480")
    public boolean showContextMenuForChild(View originalView) {
        boolean varBA8B92D993B1A5B6CF969236EEAB6152_869447129 = (mParent != null && mParent.showContextMenuForChild(originalView));
        addTaint(originalView.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1177455316 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1177455316;
        // ---------- Original Method ----------
        //return mParent != null && mParent.showContextMenuForChild(originalView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.566 -0400", hash_original_method = "8C60B2F96F2B489988C14A93A463DAE3", hash_generated_method = "894C367AF63BA8F23FD45BA1471BF43B")
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_422131743 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_422131743 = mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
        addTaint(originalView.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_422131743.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_422131743;
        // ---------- Original Method ----------
        //return mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.573 -0400", hash_original_method = "32394A633C776A8BC33A6BFC48D3DC37", hash_generated_method = "4B705A319766BBC72499A70912EC72B9")
    public View focusSearch(View focused, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_195859556 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_92374281 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_10348181 = null; //Variable for return #3
        {
            boolean var6900EB30484F14AE1B69428931AEDE0D_1694133518 = (isRootNamespace());
            {
                varB4EAC82CA7396A68D541C85D26508E83_195859556 = FocusFinder.getInstance().findNextFocus(this, focused, direction);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_92374281 = mParent.focusSearch(focused, direction);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_10348181 = null;
        addTaint(focused.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_181791170; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_181791170 = varB4EAC82CA7396A68D541C85D26508E83_195859556;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_181791170 = varB4EAC82CA7396A68D541C85D26508E83_92374281;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_181791170 = varB4EAC82CA7396A68D541C85D26508E83_10348181;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_181791170.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_181791170;
        // ---------- Original Method ----------
        //if (isRootNamespace()) {
            //return FocusFinder.getInstance().findNextFocus(this, focused, direction);
        //} else if (mParent != null) {
            //return mParent.focusSearch(focused, direction);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.576 -0400", hash_original_method = "1A209ACB79681B08302166E2C48344A2", hash_generated_method = "46B978B597E6B6188776981EFB0974B2")
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935701437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_935701437;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.577 -0400", hash_original_method = "B4AA594F7D6DA64F58B166664BBA4580", hash_generated_method = "86F5652CBD331607157AE12CF7C947D2")
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        ViewParent parent;
        parent = getParent();
        boolean propagate;
        propagate = onRequestSendAccessibilityEvent(child, event);
        boolean var441FEE5B5C6B1D4A365CF02E122B98E7_1866459481 = (parent.requestSendAccessibilityEvent(this, event));
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708881920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708881920;
        // ---------- Original Method ----------
        //ViewParent parent = getParent();
        //if (parent == null) {
            //return false;
        //}
        //final boolean propagate = onRequestSendAccessibilityEvent(child, event);
        //if (!propagate) {
            //return false;
        //}
        //return parent.requestSendAccessibilityEvent(this, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.588 -0400", hash_original_method = "0D2782B4A269D15DF81200BFDAFE535A", hash_generated_method = "56F457FABF5CBA581FD694A8573C5256")
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var5A0C8D77442C96677A25BCD888A43DDA_9670400 = (mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event));
        } //End block
        {
            boolean var36AE0BB3330710CD64DFF9DF5BCECE4F_441232036 = (onRequestSendAccessibilityEventInternal(child, event));
        } //End block
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1669085279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1669085279;
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event);
        //} else {
            //return onRequestSendAccessibilityEventInternal(child, event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.588 -0400", hash_original_method = "F0DFCA5DE1F330F511BBFF62182D5BD4", hash_generated_method = "20CB91A7E107F4A1015A120EBE6C431F")
     boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017857600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017857600;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.589 -0400", hash_original_method = "E35CCEA2DF29F8696C548F55094B5B73", hash_generated_method = "6738A8F24C7A4CFBBCFC579ADFB54E00")
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        boolean var661477CC7A374E9FA1E26C430B4E7B43_1473420825 = (mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction));
        addTaint(focused.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1574057287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1574057287;
        // ---------- Original Method ----------
        //return mFocused != null &&
                //mFocused.dispatchUnhandledMove(focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.589 -0400", hash_original_method = "1A8D22FF280DB81B170D27815BE7BEAA", hash_generated_method = "220D2AF227F8192C20FF0AAD9C6E6B54")
    public void clearChildFocus(View child) {
        {
            System.out.println(this + " clearChildFocus()");
        } //End block
        mFocused = null;
        {
            mParent.clearChildFocus(this);
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " clearChildFocus()");
        //}
        //mFocused = null;
        //if (mParent != null) {
            //mParent.clearChildFocus(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.590 -0400", hash_original_method = "2A2B29C64ED25C5483BB6B32C5BD1628", hash_generated_method = "3342498F7A8B69ACA45B632AC7F311FF")
    @Override
    public void clearFocus() {
        super.clearFocus();
        {
            mFocused.clearFocus();
        } //End block
        // ---------- Original Method ----------
        //super.clearFocus();
        //if (mFocused != null) {
            //mFocused.clearFocus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.598 -0400", hash_original_method = "AD8CA09F957410559E0C3DF16ADDE822", hash_generated_method = "F120404050A1F818C6DEF3758FDB7E87")
    @Override
     void unFocus() {
        {
            System.out.println(this + " unFocus()");
        } //End block
        super.unFocus();
        {
            mFocused.unFocus();
        } //End block
        mFocused = null;
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " unFocus()");
        //}
        //super.unFocus();
        //if (mFocused != null) {
            //mFocused.unFocus();
        //}
        //mFocused = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.603 -0400", hash_original_method = "F6AEE91365C496A95D4F4B1572422CF5", hash_generated_method = "CF4B10D3FD2807D5DDCEFC560C41A51B")
    public View getFocusedChild() {
        View varB4EAC82CA7396A68D541C85D26508E83_578567347 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_578567347 = mFocused;
        varB4EAC82CA7396A68D541C85D26508E83_578567347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_578567347;
        // ---------- Original Method ----------
        //return mFocused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.603 -0400", hash_original_method = "3D9AAFDE8E8826B256A10D32D774D94B", hash_generated_method = "C0BBD72FE39EC46943EBA1C8CD977CAB")
    @Override
    public boolean hasFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_777450034 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_777450034;
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 || mFocused != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.612 -0400", hash_original_method = "8D50679A3D30F96CD0297A05342EFA70", hash_generated_method = "7A28B13B2C057457D0878E9AD4474199")
    @Override
    public View findFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_637149581 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_323434605 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_15783152 = null; //Variable for return #3
        {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        } //End block
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_274185571 = (isFocused());
            {
                varB4EAC82CA7396A68D541C85D26508E83_637149581 = this;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_323434605 = mFocused.findFocus();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_15783152 = null;
        View varA7E53CE21691AB073D9660D615818899_1642074389; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1642074389 = varB4EAC82CA7396A68D541C85D26508E83_637149581;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1642074389 = varB4EAC82CA7396A68D541C85D26508E83_323434605;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1642074389 = varB4EAC82CA7396A68D541C85D26508E83_15783152;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1642074389.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1642074389;
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println("Find focus in " + this + ": flags="
                    //+ isFocused() + ", child=" + mFocused);
        //}
        //if (isFocused()) {
            //return this;
        //}
        //if (mFocused != null) {
            //return mFocused.findFocus();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.618 -0400", hash_original_method = "415824CC4E37F2B08D458BE00E3F5A3F", hash_generated_method = "1E85B77F979FAC4232181A513A51FB68")
    @Override
    public boolean hasFocusable() {
        {
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_626144428 = (isFocusable());
        } //End collapsed parenthetic
        int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        boolean var7DC29F4EF4EE5211D58EB348F2B6AE7E_1878173548 = (child.hasFocusable());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399894862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_399894862;
        // ---------- Original Method ----------
        //if ((mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            //return false;
        //}
        //if (isFocusable()) {
            //return true;
        //}
        //final int descendantFocusability = getDescendantFocusability();
        //if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if (child.hasFocusable()) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.619 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "431825FF8AC602907ED2322848F946AB")
    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        addTaint(views.getTaint());
        addTaint(direction);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.626 -0400", hash_original_method = "A281D125D4DD0434A87F479D62DD0361", hash_generated_method = "940C83FEF2D376C9453905B90F701B91")
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        int focusableCount;
        focusableCount = views.size();
        int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        child.addFocusables(views, direction, focusableMode);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var0F1BFD0DBC136B3E2580439E8453837C_591392038 = (descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                (focusableCount == views.size()));
            {
                super.addFocusables(views, direction, focusableMode);
            } //End block
        } //End collapsed parenthetic
        addTaint(views.getTaint());
        addTaint(direction);
        addTaint(focusableMode);
        // ---------- Original Method ----------
        //final int focusableCount = views.size();
        //final int descendantFocusability = getDescendantFocusability();
        //if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                    //child.addFocusables(views, direction, focusableMode);
                //}
            //}
        //}
        //if (
            //descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                //(focusableCount == views.size())) {
            //super.addFocusables(views, direction, focusableMode);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.626 -0400", hash_original_method = "01B0DFF5DFF6A04EF473202885B21AEA", hash_generated_method = "314A8D2DC50D0F4E35BA6BC7BD106722")
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        super.findViewsWithText(outViews, text, flags);
        int childrenCount;
        childrenCount = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    child.findViewsWithText(outViews, text, flags);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(outViews.getTaint());
        addTaint(text.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //super.findViewsWithText(outViews, text, flags);
        //final int childrenCount = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < childrenCount; i++) {
            //View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    //&& (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //child.findViewsWithText(outViews, text, flags);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.634 -0400", hash_original_method = "E63784DE90D03F6D10488691622E702B", hash_generated_method = "4EC0A14068B9698089E6334815AC8EFE")
    @Override
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        View varB4EAC82CA7396A68D541C85D26508E83_360074770 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1443501280 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_1230555760 = null; //Variable for return #3
        View foundView;
        foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_360074770 = foundView;
        } //End block
        int childrenCount;
        childrenCount = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1443501280 = foundView;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1230555760 = null;
        addTaint(accessibilityId);
        View varA7E53CE21691AB073D9660D615818899_1508675099; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1508675099 = varB4EAC82CA7396A68D541C85D26508E83_360074770;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1508675099 = varB4EAC82CA7396A68D541C85D26508E83_1443501280;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1508675099 = varB4EAC82CA7396A68D541C85D26508E83_1230555760;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1508675099.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1508675099;
        // ---------- Original Method ----------
        //View foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        //if (foundView != null) {
            //return foundView;
        //}
        //final int childrenCount = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < childrenCount; i++) {
            //View child = children[i];
            //foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
            //if (foundView != null) {
                //return foundView;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.638 -0400", hash_original_method = "8947E2F3FD45B1E1CD9A8BF9F902DE4D", hash_generated_method = "D88576C81BC6A88E1D26A2BE4673EC20")
    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        super.dispatchWindowFocusChanged(hasFocus);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchWindowFocusChanged(hasFocus);
            } //End block
        } //End collapsed parenthetic
        addTaint(hasFocus);
        // ---------- Original Method ----------
        //super.dispatchWindowFocusChanged(hasFocus);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchWindowFocusChanged(hasFocus);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.643 -0400", hash_original_method = "3C050A87A5AA11FCC905DB1242C91519", hash_generated_method = "0EB872EECB32FC28FFFA1C794A89EEB1")
    @Override
    public void addTouchables(ArrayList<View> views) {
        super.addTouchables(views);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    child.addTouchables(views);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(views.getTaint());
        // ---------- Original Method ----------
        //super.addTouchables(views);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                //child.addTouchables(views);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.643 -0400", hash_original_method = "E3ECA4D0183F28678AE9A73BEBE4A4C4", hash_generated_method = "7B66CAE67ECC5D49338139FB5649F204")
    @Override
    public void dispatchDisplayHint(int hint) {
        super.dispatchDisplayHint(hint);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchDisplayHint(hint);
            } //End block
        } //End collapsed parenthetic
        addTaint(hint);
        // ---------- Original Method ----------
        //super.dispatchDisplayHint(hint);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchDisplayHint(hint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.650 -0400", hash_original_method = "39046505104385736A9526E25AC3965D", hash_generated_method = "91E54565F50C8DDCECAD14FB6B81E69E")
    protected void onChildVisibilityChanged(View child, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            {
                mTransition.showChild(this, child);
            } //End block
            {
                mTransition.hideChild(this, child);
            } //End block
            {
                {
                    mVisibilityChangingChildren = new ArrayList<View>();
                } //End block
                mVisibilityChangingChildren.add(child);
                {
                    boolean var062D8AB67088E18389484F6801BD9183_196826880 = (mTransitioningViews != null && mTransitioningViews.contains(child));
                    {
                        addDisappearingView(child);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                notifyChildOfDrag(child);
            } //End block
        } //End block
        addTaint(child.getTaint());
        addTaint(visibility);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.651 -0400", hash_original_method = "66EC1DB8C5DE29B0D05D23F4BE080169", hash_generated_method = "ABFFB111575B926E363D6E4AFD64227B")
    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        super.dispatchVisibilityChanged(changedView, visibility);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchVisibilityChanged(changedView, visibility);
            } //End block
        } //End collapsed parenthetic
        addTaint(changedView.getTaint());
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.dispatchVisibilityChanged(changedView, visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchVisibilityChanged(changedView, visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.652 -0400", hash_original_method = "110C8ADF44E81EF076420285F756776D", hash_generated_method = "B848DA60DFE16EF76D5AF410AB45A6B5")
    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        super.dispatchWindowVisibilityChanged(visibility);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchWindowVisibilityChanged(visibility);
            } //End block
        } //End collapsed parenthetic
        addTaint(visibility);
        // ---------- Original Method ----------
        //super.dispatchWindowVisibilityChanged(visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchWindowVisibilityChanged(visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.660 -0400", hash_original_method = "4BA014AA7FB311F49457CF496AD5B6EF", hash_generated_method = "B80B93BCEA583666BEE2690D4705E27F")
    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        super.dispatchConfigurationChanged(newConfig);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchConfigurationChanged(newConfig);
            } //End block
        } //End collapsed parenthetic
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //super.dispatchConfigurationChanged(newConfig);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchConfigurationChanged(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.664 -0400", hash_original_method = "F881B5C75EE06984153060972C295D8F", hash_generated_method = "45DA73E6E459E888AC4EB174E2C7D424")
    public void recomputeViewAttributes(View child) {
        {
            ViewParent parent;
            parent = mParent;
            parent.recomputeViewAttributes(this);
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            //ViewParent parent = mParent;
            //if (parent != null) parent.recomputeViewAttributes(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.665 -0400", hash_original_method = "99C97332C863B663BFCA518BE284DB35", hash_generated_method = "54869763623082057229A31F399CE55F")
    @Override
     void dispatchCollectViewAttributes(int visibility) {
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchCollectViewAttributes(visibility);
            } //End block
        } //End collapsed parenthetic
        addTaint(visibility);
        // ---------- Original Method ----------
        //visibility |= mViewFlags&VISIBILITY_MASK;
        //super.dispatchCollectViewAttributes(visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchCollectViewAttributes(visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.666 -0400", hash_original_method = "C5DA1A7419AFEADC86BA0783BA235334", hash_generated_method = "562D4821719B04DD91673C82B77D08FF")
    public void bringChildToFront(View child) {
        int index;
        index = indexOfChild(child);
        {
            removeFromArray(index);
            addInArray(child, mChildrenCount);
            child.mParent = this;
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //int index = indexOfChild(child);
        //if (index >= 0) {
            //removeFromArray(index);
            //addInArray(child, mChildrenCount);
            //child.mParent = this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.960 -0400", hash_original_method = "0B94D743FFC1DE288527F02F6E8345CD", hash_generated_method = "FBB9CF2F6F0B24F41EADBA715AC088BE")
    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        boolean retval;
        retval = false;
        float tx;
        tx = event.mX;
        float ty;
        ty = event.mY;
        ViewRootImpl root;
        root = getViewRootImpl();
        //Begin case DragEvent.ACTION_DRAG_STARTED 
        {
            mCurrentDragView = null;
            mCurrentDrag = DragEvent.obtain(event);
            {
                mDragNotifiedChildren = new HashSet<View>();
            } //End block
            {
                mDragNotifiedChildren.clear();
            } //End block
            mChildAcceptsDrag = false;
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    child.mPrivateFlags2 &= ~View.DRAG_MASK;
                    {
                        boolean var93DCAA7E24F58D6762D32E351E886EF8_484813986 = (child.getVisibility() == VISIBLE);
                        {
                            boolean handled;
                            handled = notifyChildOfDrag(children[i]);
                            {
                                mChildAcceptsDrag = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                retval = true;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_STARTED 
        //Begin case DragEvent.ACTION_DRAG_ENDED 
        {
            {
                {
                    Iterator<View> var3378C5B405A48B24956CD00DB7CCC663_1219095983 = (mDragNotifiedChildren).iterator();
                    var3378C5B405A48B24956CD00DB7CCC663_1219095983.hasNext();
                    View child = var3378C5B405A48B24956CD00DB7CCC663_1219095983.next();
                    {
                        child.dispatchDragEvent(event);
                        child.mPrivateFlags2 &= ~View.DRAG_MASK;
                        child.refreshDrawableState();
                    } //End block
                } //End collapsed parenthetic
                mDragNotifiedChildren.clear();
                mCurrentDrag.recycle();
                mCurrentDrag = null;
            } //End block
            {
                retval = true;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_ENDED 
        //Begin case DragEvent.ACTION_DRAG_LOCATION 
        {
            View target;
            target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                root.setDragFocus(target);
                int action;
                action = event.mAction;
                {
                    View view;
                    view = mCurrentDragView;
                    event.mAction = DragEvent.ACTION_DRAG_EXITED;
                    view.dispatchDragEvent(event);
                    view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                    view.refreshDrawableState();
                } //End block
                mCurrentDragView = target;
                {
                    event.mAction = DragEvent.ACTION_DRAG_ENTERED;
                    target.dispatchDragEvent(event);
                    target.mPrivateFlags2 |= View.DRAG_HOVERED;
                    target.refreshDrawableState();
                } //End block
                event.mAction = action;
            } //End block
            {
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_LOCATION 
        //Begin case DragEvent.ACTION_DRAG_EXITED 
        {
            {
                View view;
                view = mCurrentDragView;
                view.dispatchDragEvent(event);
                view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                view.refreshDrawableState();
                mCurrentDragView = null;
            } //End block
        } //End block
        //End case DragEvent.ACTION_DRAG_EXITED 
        //Begin case DragEvent.ACTION_DROP 
        {
            Log.d(View.VIEW_LOG_TAG, "Drop event: " + event);
            View target;
            target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                Log.d(View.VIEW_LOG_TAG, "   dispatch drop to " + target);
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } //End block
            {
                {
                    Log.d(View.VIEW_LOG_TAG, "   not dropped on an accepting view");
                } //End block
            } //End block
        } //End block
        //End case DragEvent.ACTION_DROP 
        {
            retval = super.dispatchDragEvent(event);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707697555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707697555;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.977 -0400", hash_original_method = "A61A140E816A1C908C27B7F105ECC965", hash_generated_method = "93744C3383FC7C7C593712CB97F097F5")
     View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint) {
        View varB4EAC82CA7396A68D541C85D26508E83_1874203829 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_107739040 = null; //Variable for return #2
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = count - 1;
            {
                View child;
                child = children[i];
                {
                    boolean varDD9451246475E78E9B9862A08B40ED39_965854033 = (!child.canAcceptDrag());
                } //End collapsed parenthetic
                {
                    boolean varB60C7CACEA3B7B85D44A4D6C320C4F52_1931952963 = (isTransformedTouchPointInView(x, y, child, outLocalPoint));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1874203829 = child;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_107739040 = null;
        addTaint(x);
        addTaint(y);
        addTaint(outLocalPoint.getTaint());
        View varA7E53CE21691AB073D9660D615818899_43223038; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_43223038 = varB4EAC82CA7396A68D541C85D26508E83_1874203829;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_43223038 = varB4EAC82CA7396A68D541C85D26508E83_107739040;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_43223038.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_43223038;
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = count - 1; i >= 0; i--) {
            //final View child = children[i];
            //if (!child.canAcceptDrag()) {
                //continue;
            //}
            //if (isTransformedTouchPointInView(x, y, child, outLocalPoint)) {
                //return child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.978 -0400", hash_original_method = "01B6DB1535B88ABBDA0897E44597D185", hash_generated_method = "F90830BAD78EF55556C1952A02B4DF34")
     boolean notifyChildOfDrag(View child) {
        {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        } //End block
        boolean canAccept;
        canAccept = false;
        {
            boolean var9513878AE6807A2BEC04686702F54F4D_240675331 = (! mDragNotifiedChildren.contains(child));
            {
                mDragNotifiedChildren.add(child);
                canAccept = child.dispatchDragEvent(mCurrentDrag);
                {
                    boolean var6E0AEBF66F234C4EF96F0B794A136F59_1418676290 = (canAccept && !child.canAcceptDrag());
                    {
                        child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                        child.refreshDrawableState();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746314015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746314015;
        // ---------- Original Method ----------
        //if (ViewDebug.DEBUG_DRAG) {
            //Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        //}
        //boolean canAccept = false;
        //if (! mDragNotifiedChildren.contains(child)) {
            //mDragNotifiedChildren.add(child);
            //canAccept = child.dispatchDragEvent(mCurrentDrag);
            //if (canAccept && !child.canAcceptDrag()) {
                //child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                //child.refreshDrawableState();
            //}
        //}
        //return canAccept;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.979 -0400", hash_original_method = "6EA017C64305C1BE29415F2C64CCEDD4", hash_generated_method = "751D28B5B262C8E84FE98D8CFC0628FC")
    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        super.dispatchSystemUiVisibilityChanged(visible);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                child.dispatchSystemUiVisibilityChanged(visible);
            } //End block
        } //End collapsed parenthetic
        addTaint(visible);
        // ---------- Original Method ----------
        //super.dispatchSystemUiVisibilityChanged(visible);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i=0; i <count; i++) {
            //final View child = children[i];
            //child.dispatchSystemUiVisibilityChanged(visible);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.979 -0400", hash_original_method = "5F03A98EA003A081CE87491B56EF094D", hash_generated_method = "FC94C820C270445F77F0419611E1EE96")
    @Override
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        super.updateLocalSystemUiVisibility(localValue, localChanges);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                child.updateLocalSystemUiVisibility(localValue, localChanges);
            } //End block
        } //End collapsed parenthetic
        addTaint(localValue);
        addTaint(localChanges);
        // ---------- Original Method ----------
        //super.updateLocalSystemUiVisibility(localValue, localChanges);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i=0; i <count; i++) {
            //final View child = children[i];
            //child.updateLocalSystemUiVisibility(localValue, localChanges);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.980 -0400", hash_original_method = "1796A9ED58069BDF38C7C072FE20CF71", hash_generated_method = "7D3162BFA1AE04647CF462319D0C7C4B")
    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        {
            boolean var69A4D5BA21F9754791BA96F9F5C71142_317173083 = (super.dispatchKeyEventPreIme(event));
        } //End block
        {
            boolean varFE2571F324BFA6DB9FF0B9BEE57E874E_644211269 = (mFocused.dispatchKeyEventPreIme(event));
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1340572901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1340572901;
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchKeyEventPreIme(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchKeyEventPreIme(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.983 -0400", hash_original_method = "1E41A7E6E3EFA9117FFB3A56DB417CA0", hash_generated_method = "4294EDB91B161D02EACF5FA873C699B7")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        } //End block
        {
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_136290811 = (super.dispatchKeyEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBA71E8F3A809B2219624C59EBC2DEB55_1511542621 = (mFocused.dispatchKeyEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803895233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803895233;
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        //}
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //if (super.dispatchKeyEvent(event)) {
                //return true;
            //}
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //if (mFocused.dispatchKeyEvent(event)) {
                //return true;
            //}
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.984 -0400", hash_original_method = "C8DF4A46704EEB88AB3A3DAEBDA2EE59", hash_generated_method = "2F9163FCAF709D3917E494332C34098F")
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        {
            boolean varF75FC08430B3CB671A7FC788738670A4_621056911 = (super.dispatchKeyShortcutEvent(event));
        } //End block
        {
            boolean var9C5A31847C19CF0D448BFF804D2D7DBC_1229857024 = (mFocused.dispatchKeyShortcutEvent(event));
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857003710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857003710;
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchKeyShortcutEvent(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchKeyShortcutEvent(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.984 -0400", hash_original_method = "CF1D00451039D1CA46B97508DE17783C", hash_generated_method = "DB5B59A98BDA8FA5A28DBA9761DE0904")
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        } //End block
        {
            {
                boolean varDD1D6069514DE34833A921C8364915DD_1643910380 = (super.dispatchTrackballEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var0FFB054D71651438CDA84A82C67C65B6_2035283793 = (mFocused.dispatchTrackballEvent(event));
            } //End collapsed parenthetic
        } //End block
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495474379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495474379;
        // ---------- Original Method ----------
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        //}
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //if (super.dispatchTrackballEvent(event)) {
                //return true;
            //}
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //if (mFocused.dispatchTrackballEvent(event)) {
                //return true;
            //}
        //}
        //if (mInputEventConsistencyVerifier != null) {
            //mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:55.991 -0400", hash_original_method = "E0F6A76AF2BEDB6076446B6A929BAC84", hash_generated_method = "9064D4793D189C93732D84402EA3BAE2")
    @SuppressWarnings({"ConstantConditions"})
    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        int action;
        action = event.getAction();
        boolean interceptHover;
        interceptHover = onInterceptHoverEvent(event);
        event.setAction(action);
        MotionEvent eventNoHistory;
        eventNoHistory = event;
        boolean handled;
        handled = false;
        HoverTarget firstOldHoverTarget;
        firstOldHoverTarget = mFirstHoverTarget;
        mFirstHoverTarget = null;
        {
            float x;
            x = event.getX();
            float y;
            y = event.getY();
            int childrenCount;
            childrenCount = mChildrenCount;
            {
                View[] children;
                children = mChildren;
                HoverTarget lastHoverTarget;
                lastHoverTarget = null;
                {
                    int i;
                    i = childrenCount - 1;
                    {
                        View child;
                        child = children[i];
                        {
                            boolean var39A5B2EF267FE4EA5711368BBCBF6FA1_552595697 = (!canViewReceivePointerEvents(child)
                            || !isTransformedTouchPointInView(x, y, child, null));
                        } //End collapsed parenthetic
                        HoverTarget hoverTarget;
                        hoverTarget = firstOldHoverTarget;
                        boolean wasHovered;
                        {
                            HoverTarget predecessor;
                            predecessor = null;
                            {
                                {
                                    hoverTarget = HoverTarget.obtain(child);
                                    wasHovered = false;
                                } //End block
                                {
                                    {
                                        predecessor.next = hoverTarget.next;
                                    } //End block
                                    {
                                        firstOldHoverTarget = hoverTarget.next;
                                    } //End block
                                    hoverTarget.next = null;
                                    wasHovered = true;
                                } //End block
                                predecessor = hoverTarget;
                                hoverTarget = hoverTarget.next;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            lastHoverTarget.next = hoverTarget;
                        } //End block
                        {
                            lastHoverTarget = hoverTarget;
                            mFirstHoverTarget = hoverTarget;
                        } //End block
                        {
                            {
                                handled |= dispatchTransformedGenericPointerEvent(
                                    event, child);
                            } //End block
                        } //End block
                        {
                            {
                                eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                                eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                                handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                                eventNoHistory.setAction(action);
                                handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                            } //End block
                            {
                                handled |= dispatchTransformedGenericPointerEvent(event, child);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            View child;
            child = firstOldHoverTarget.child;
            {
                handled |= dispatchTransformedGenericPointerEvent(
                        event, child);
            } //End block
            {
                {
                    dispatchTransformedGenericPointerEvent(
                            event, child);
                } //End block
                eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                eventNoHistory.setAction(MotionEvent.ACTION_HOVER_EXIT);
                dispatchTransformedGenericPointerEvent(
                        eventNoHistory, child);
                eventNoHistory.setAction(action);
            } //End block
            HoverTarget nextOldHoverTarget;
            nextOldHoverTarget = firstOldHoverTarget.next;
            firstOldHoverTarget.recycle();
            firstOldHoverTarget = nextOldHoverTarget;
        } //End block
        boolean newHoveredSelf;
        newHoveredSelf = !handled;
        {
            {
                handled |= super.dispatchHoverEvent(event);
            } //End block
        } //End block
        {
            {
                {
                    handled |= super.dispatchHoverEvent(event);
                } //End block
                {
                    {
                        super.dispatchHoverEvent(event);
                    } //End block
                    eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                    eventNoHistory.setAction(MotionEvent.ACTION_HOVER_EXIT);
                    super.dispatchHoverEvent(eventNoHistory);
                    eventNoHistory.setAction(action);
                } //End block
                mHoveredSelf = false;
            } //End block
            {
                {
                    handled |= super.dispatchHoverEvent(event);
                    mHoveredSelf = true;
                } //End block
                {
                    eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                    eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                    handled |= super.dispatchHoverEvent(eventNoHistory);
                    eventNoHistory.setAction(action);
                    handled |= super.dispatchHoverEvent(eventNoHistory);
                    mHoveredSelf = true;
                } //End block
            } //End block
        } //End block
        {
            eventNoHistory.recycle();
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555561768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555561768;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.010 -0400", hash_original_method = "CAF0CE39145036A2F3E98F46F45FF397", hash_generated_method = "A28B9A3AC2E557C22B5E2B526716DF37")
    @Override
    protected boolean hasHoveredChild() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803874967 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_803874967;
        // ---------- Original Method ----------
        //return mFirstHoverTarget != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.011 -0400", hash_original_method = "039A9532EA6933A3F4F8681C30CC9E2B", hash_generated_method = "3CA91F35A501593D5D898B49E5D049CA")
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957953895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957953895;
        // ---------- Original Method ----------
        //return false;
    }

    
        private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event) {
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.012 -0400", hash_original_method = "8425E6039966203E8B52A55F0ACFD97E", hash_generated_method = "807A3922112CDB02A34E2D6BB8262767")
    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        int childrenCount;
        childrenCount = mChildrenCount;
        {
            View[] children;
            children = mChildren;
            float x;
            x = event.getX();
            float y;
            y = event.getY();
            {
                int i;
                i = childrenCount - 1;
                {
                    View child;
                    child = children[i];
                    {
                        boolean var330479A3EB93BD7FBB36FC9D307449EC_694383321 = (!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null));
                    } //End collapsed parenthetic
                    {
                        boolean varE3F3EFAB7A0C507CFC1087341B7293FA_2138653525 = (dispatchTransformedGenericPointerEvent(event, child));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean var08E200417CAE6114EB8B8E0EE91851EC_1046711599 = (super.dispatchGenericPointerEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223103645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223103645;
        // ---------- Original Method ----------
        //final int childrenCount = mChildrenCount;
        //if (childrenCount != 0) {
            //final View[] children = mChildren;
            //final float x = event.getX();
            //final float y = event.getY();
            //for (int i = childrenCount - 1; i >= 0; i--) {
                //final View child = children[i];
                //if (!canViewReceivePointerEvents(child)
                        //|| !isTransformedTouchPointInView(x, y, child, null)) {
                    //continue;
                //}
                //if (dispatchTransformedGenericPointerEvent(event, child)) {
                    //return true;
                //}
            //}
        //}
        //return super.dispatchGenericPointerEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.013 -0400", hash_original_method = "EF2476E6EC182ADC11908B65D0A31365", hash_generated_method = "E69EDF9A1A4B0F7E05803EB8D9FB3686")
    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        {
            boolean varB46815DBC1BC9F2955B6C32C32EC3809_720958306 = (super.dispatchGenericFocusedEvent(event));
        } //End block
        {
            boolean varDAA7826F7D7AE31750BF98F87DE576DE_264545460 = (mFocused.dispatchGenericMotionEvent(event));
        } //End block
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1087177741 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1087177741;
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchGenericFocusedEvent(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchGenericMotionEvent(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.117 -0400", hash_original_method = "89F3902132A72D71D534028C51E6FDBB", hash_generated_method = "1DF4626D4965003A15457BDE9D5986EF")
    private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child) {
        float offsetX;
        offsetX = mScrollX - child.mLeft;
        float offsetY;
        offsetY = mScrollY - child.mTop;
        boolean handled;
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_2025586341 = (!child.hasIdentityMatrix());
            {
                MotionEvent transformedEvent;
                transformedEvent = MotionEvent.obtain(event);
                transformedEvent.offsetLocation(offsetX, offsetY);
                transformedEvent.transform(child.getInverseMatrix());
                handled = child.dispatchGenericMotionEvent(transformedEvent);
                transformedEvent.recycle();
            } //End block
            {
                event.offsetLocation(offsetX, offsetY);
                handled = child.dispatchGenericMotionEvent(event);
                event.offsetLocation(-offsetX, -offsetY);
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1771512606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1771512606;
        // ---------- Original Method ----------
        //final float offsetX = mScrollX - child.mLeft;
        //final float offsetY = mScrollY - child.mTop;
        //boolean handled;
        //if (!child.hasIdentityMatrix()) {
            //MotionEvent transformedEvent = MotionEvent.obtain(event);
            //transformedEvent.offsetLocation(offsetX, offsetY);
            //transformedEvent.transform(child.getInverseMatrix());
            //handled = child.dispatchGenericMotionEvent(transformedEvent);
            //transformedEvent.recycle();
        //} else {
            //event.offsetLocation(offsetX, offsetY);
            //handled = child.dispatchGenericMotionEvent(event);
            //event.offsetLocation(-offsetX, -offsetY);
        //}
        //return handled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.126 -0400", hash_original_method = "9A4777971E22B675E68E924B82246A95", hash_generated_method = "DC8A7DC9C2780A9EDB18F5F9DE2A0EBC")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 1);
        } //End block
        boolean handled;
        handled = false;
        {
            boolean var6CC6773C2F32650974B473D1B32A8111_1772142956 = (onFilterTouchEventForSecurity(ev));
            {
                int action;
                action = ev.getAction();
                int actionMasked;
                actionMasked = action & MotionEvent.ACTION_MASK;
                {
                    cancelAndClearTouchTargets(ev);
                    resetTouchState();
                } //End block
                boolean intercepted;
                {
                    boolean disallowIntercept;
                    disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
                    {
                        intercepted = onInterceptTouchEvent(ev);
                        ev.setAction(action);
                    } //End block
                    {
                        intercepted = false;
                    } //End block
                } //End block
                {
                    intercepted = true;
                } //End block
                boolean canceled;
                canceled = resetCancelNextUpFlag(this)
                    || actionMasked == MotionEvent.ACTION_CANCEL;
                boolean split;
                split = (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) != 0;
                TouchTarget newTouchTarget;
                newTouchTarget = null;
                boolean alreadyDispatchedToNewTouchTarget;
                alreadyDispatchedToNewTouchTarget = false;
                {
                    {
                        int actionIndex;
                        actionIndex = ev.getActionIndex();
                        int idBitsToAssign;
                        idBitsToAssign = 1 << ev.getPointerId(actionIndex);
                        idBitsToAssign = TouchTarget.ALL_POINTER_IDS;
                        removePointersFromTouchTargets(idBitsToAssign);
                        int childrenCount;
                        childrenCount = mChildrenCount;
                        {
                            View[] children;
                            children = mChildren;
                            float x;
                            x = ev.getX(actionIndex);
                            float y;
                            y = ev.getY(actionIndex);
                            {
                                int i;
                                i = childrenCount - 1;
                                {
                                    View child;
                                    child = children[i];
                                    {
                                        boolean varA03062BDD929C4635E5C5D880ED86080_215339559 = (!canViewReceivePointerEvents(child)
                                    || !isTransformedTouchPointInView(x, y, child, null));
                                    } //End collapsed parenthetic
                                    newTouchTarget = getTouchTarget(child);
                                    {
                                        newTouchTarget.pointerIdBits |= idBitsToAssign;
                                    } //End block
                                    resetCancelNextUpFlag(child);
                                    {
                                        boolean var4D2A48697299CECF9F8D426E12ED9A2F_234857652 = (dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign));
                                        {
                                            mLastTouchDownTime = ev.getDownTime();
                                            mLastTouchDownIndex = i;
                                            mLastTouchDownX = ev.getX();
                                            mLastTouchDownY = ev.getY();
                                            newTouchTarget = addTouchTarget(child, idBitsToAssign);
                                            alreadyDispatchedToNewTouchTarget = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            newTouchTarget = mFirstTouchTarget;
                            {
                                newTouchTarget = newTouchTarget.next;
                            } //End block
                            newTouchTarget.pointerIdBits |= idBitsToAssign;
                        } //End block
                    } //End block
                } //End block
                {
                    handled = dispatchTransformedTouchEvent(ev, canceled, null,
                        TouchTarget.ALL_POINTER_IDS);
                } //End block
                {
                    TouchTarget predecessor;
                    predecessor = null;
                    TouchTarget target;
                    target = mFirstTouchTarget;
                    {
                        TouchTarget next;
                        next = target.next;
                        {
                            handled = true;
                        } //End block
                        {
                            boolean cancelChild;
                            cancelChild = resetCancelNextUpFlag(target.child)
                        || intercepted;
                            {
                                boolean varEA3E26DE3C0C658C465A175EDB865343_304673401 = (dispatchTransformedTouchEvent(ev, cancelChild,
                                target.child, target.pointerIdBits));
                                {
                                    handled = true;
                                } //End block
                            } //End collapsed parenthetic
                            {
                                {
                                    mFirstTouchTarget = next;
                                } //End block
                                {
                                    predecessor.next = next;
                                } //End block
                                target.recycle();
                                target = next;
                            } //End block
                        } //End block
                        predecessor = target;
                        target = next;
                    } //End block
                } //End block
                {
                    resetTouchState();
                } //End block
                {
                    int actionIndex;
                    actionIndex = ev.getActionIndex();
                    int idBitsToRemove;
                    idBitsToRemove = 1 << ev.getPointerId(actionIndex);
                    removePointersFromTouchTargets(idBitsToRemove);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 1);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1223651246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1223651246;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.127 -0400", hash_original_method = "1B0EC47DAA405380670E223779C878A6", hash_generated_method = "FB0BEF6A0D13DDEE91DD6A9C23FE556F")
    private void resetTouchState() {
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        // ---------- Original Method ----------
        //clearTouchTargets();
        //resetCancelNextUpFlag(this);
        //mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.127 -0400", hash_original_method = "B31FF6D343B2149E4D841C0A7CD04309", hash_generated_method = "3C8A624B93AEF76AC5C7934BF9EA2203")
    private boolean resetCancelNextUpFlag(View view) {
        {
            view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        } //End block
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362577253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362577253;
        // ---------- Original Method ----------
        //if ((view.mPrivateFlags & CANCEL_NEXT_UP_EVENT) != 0) {
            //view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.143 -0400", hash_original_method = "C1060B6E54563910E15717B9621A0CC6", hash_generated_method = "8E13DFFCAD7CF241DE0CEFFDD2C00C53")
    private void clearTouchTargets() {
        TouchTarget target;
        target = mFirstTouchTarget;
        {
            {
                TouchTarget next;
                next = target.next;
                target.recycle();
                target = next;
            } //End block
            mFirstTouchTarget = null;
        } //End block
        // ---------- Original Method ----------
        //TouchTarget target = mFirstTouchTarget;
        //if (target != null) {
            //do {
                //TouchTarget next = target.next;
                //target.recycle();
                //target = next;
            //} while (target != null);
            //mFirstTouchTarget = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.144 -0400", hash_original_method = "45B19A2C35386F46FF7561697C2C88B0", hash_generated_method = "AC4E253FF69FDE76BE23EA34E7CD9F3A")
    private void cancelAndClearTouchTargets(MotionEvent event) {
        {
            boolean syntheticEvent;
            syntheticEvent = false;
            {
                long now;
                now = SystemClock.uptimeMillis();
                event = MotionEvent.obtain(now, now,
                        MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);
                event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
                syntheticEvent = true;
            } //End block
            {
                TouchTarget target;
                target = mFirstTouchTarget;
                target = target.next;
                {
                    resetCancelNextUpFlag(target.child);
                    dispatchTransformedTouchEvent(event, true, target.child, target.pointerIdBits);
                } //End block
            } //End collapsed parenthetic
            clearTouchTargets();
            {
                event.recycle();
            } //End block
        } //End block
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (mFirstTouchTarget != null) {
            //boolean syntheticEvent = false;
            //if (event == null) {
                //final long now = SystemClock.uptimeMillis();
                //event = MotionEvent.obtain(now, now,
                        //MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);
                //event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
                //syntheticEvent = true;
            //}
            //for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
                //resetCancelNextUpFlag(target.child);
                //dispatchTransformedTouchEvent(event, true, target.child, target.pointerIdBits);
            //}
            //clearTouchTargets();
            //if (syntheticEvent) {
                //event.recycle();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.145 -0400", hash_original_method = "1855BFFFC59D88D1613C9B59C4B43D4C", hash_generated_method = "DD1FA343462FCE91ABF4FB58C3773DF8")
    private TouchTarget getTouchTarget(View child) {
        TouchTarget varB4EAC82CA7396A68D541C85D26508E83_186947699 = null; //Variable for return #1
        TouchTarget varB4EAC82CA7396A68D541C85D26508E83_2022165249 = null; //Variable for return #2
        {
            TouchTarget target;
            target = mFirstTouchTarget;
            target = target.next;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_186947699 = target;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2022165249 = null;
        addTaint(child.getTaint());
        TouchTarget varA7E53CE21691AB073D9660D615818899_1555518942; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1555518942 = varB4EAC82CA7396A68D541C85D26508E83_186947699;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1555518942 = varB4EAC82CA7396A68D541C85D26508E83_2022165249;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1555518942.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1555518942;
        // ---------- Original Method ----------
        //for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
            //if (target.child == child) {
                //return target;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.154 -0400", hash_original_method = "70A66C4E824C8984FFB5B6F600FB9D61", hash_generated_method = "53EBD9DB2B4A8E1F25C3D3D3D4DACF68")
    private TouchTarget addTouchTarget(View child, int pointerIdBits) {
        TouchTarget varB4EAC82CA7396A68D541C85D26508E83_1352888746 = null; //Variable for return #1
        TouchTarget target;
        target = TouchTarget.obtain(child, pointerIdBits);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
        varB4EAC82CA7396A68D541C85D26508E83_1352888746 = target;
        addTaint(child.getTaint());
        addTaint(pointerIdBits);
        varB4EAC82CA7396A68D541C85D26508E83_1352888746.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352888746;
        // ---------- Original Method ----------
        //TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        //target.next = mFirstTouchTarget;
        //mFirstTouchTarget = target;
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.157 -0400", hash_original_method = "89D343983AE77FFA55E239C56C6BE82A", hash_generated_method = "DFDECB5569DEC14EF6252B36B38120DE")
    private void removePointersFromTouchTargets(int pointerIdBits) {
        TouchTarget predecessor;
        predecessor = null;
        TouchTarget target;
        target = mFirstTouchTarget;
        {
            TouchTarget next;
            next = target.next;
            {
                target.pointerIdBits &= ~pointerIdBits;
                {
                    {
                        mFirstTouchTarget = next;
                    } //End block
                    {
                        predecessor.next = next;
                    } //End block
                    target.recycle();
                    target = next;
                } //End block
            } //End block
            predecessor = target;
            target = next;
        } //End block
        addTaint(pointerIdBits);
        // ---------- Original Method ----------
        //TouchTarget predecessor = null;
        //TouchTarget target = mFirstTouchTarget;
        //while (target != null) {
            //final TouchTarget next = target.next;
            //if ((target.pointerIdBits & pointerIdBits) != 0) {
                //target.pointerIdBits &= ~pointerIdBits;
                //if (target.pointerIdBits == 0) {
                    //if (predecessor == null) {
                        //mFirstTouchTarget = next;
                    //} else {
                        //predecessor.next = next;
                    //}
                    //target.recycle();
                    //target = next;
                    //continue;
                //}
            //}
            //predecessor = target;
            //target = next;
        //}
    }

    
        private static boolean canViewReceivePointerEvents(View child) {
        return (child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                || child.getAnimation() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.177 -0400", hash_original_method = "DEC14653C28ED7E684FDD980020C985C", hash_generated_method = "35693AA52E35859DF8CAC6CC48C33611")
    protected boolean isTransformedTouchPointInView(float x, float y, View child,
            PointF outLocalPoint) {
        float localX;
        localX = x + mScrollX - child.mLeft;
        float localY;
        localY = y + mScrollY - child.mTop;
        {
            boolean var010B39BB8F6D9891F4618A1B3F847C15_651776383 = (! child.hasIdentityMatrix() && mAttachInfo != null);
            {
                float[] localXY;
                localXY = mAttachInfo.mTmpTransformLocation;
                localXY[0] = localX;
                localXY[1] = localY;
                child.getInverseMatrix().mapPoints(localXY);
                localX = localXY[0];
                localY = localXY[1];
            } //End block
        } //End collapsed parenthetic
        boolean isInView;
        isInView = child.pointInView(localX, localY);
        {
            outLocalPoint.set(localX, localY);
        } //End block
        addTaint(x);
        addTaint(y);
        addTaint(child.getTaint());
        addTaint(outLocalPoint.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633798666 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633798666;
        // ---------- Original Method ----------
        //float localX = x + mScrollX - child.mLeft;
        //float localY = y + mScrollY - child.mTop;
        //if (! child.hasIdentityMatrix() && mAttachInfo != null) {
            //final float[] localXY = mAttachInfo.mTmpTransformLocation;
            //localXY[0] = localX;
            //localXY[1] = localY;
            //child.getInverseMatrix().mapPoints(localXY);
            //localX = localXY[0];
            //localY = localXY[1];
        //}
        //final boolean isInView = child.pointInView(localX, localY);
        //if (isInView && outLocalPoint != null) {
            //outLocalPoint.set(localX, localY);
        //}
        //return isInView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.178 -0400", hash_original_method = "EAB22EDFF178A3FABE990E65ADB3332F", hash_generated_method = "77F4C2A95D9E41CF69C3E7C0C536DB8B")
    private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
        boolean handled;
        int oldAction;
        oldAction = event.getAction();
        {
            event.setAction(MotionEvent.ACTION_CANCEL);
            {
                handled = super.dispatchTouchEvent(event);
            } //End block
            {
                handled = child.dispatchTouchEvent(event);
            } //End block
            event.setAction(oldAction);
        } //End block
        int oldPointerIdBits;
        oldPointerIdBits = event.getPointerIdBits();
        int newPointerIdBits;
        newPointerIdBits = oldPointerIdBits & desiredPointerIdBits;
        MotionEvent transformedEvent;
        {
            {
                boolean varF3923A48A5FA342E540F86C39C1C463E_772768226 = (child == null || child.hasIdentityMatrix());
                {
                    {
                        handled = super.dispatchTouchEvent(event);
                    } //End block
                    {
                        float offsetX;
                        offsetX = mScrollX - child.mLeft;
                        float offsetY;
                        offsetY = mScrollY - child.mTop;
                        event.offsetLocation(offsetX, offsetY);
                        handled = child.dispatchTouchEvent(event);
                        event.offsetLocation(-offsetX, -offsetY);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            transformedEvent = MotionEvent.obtain(event);
        } //End block
        {
            transformedEvent = event.split(newPointerIdBits);
        } //End block
        {
            handled = super.dispatchTouchEvent(transformedEvent);
        } //End block
        {
            float offsetX;
            offsetX = mScrollX - child.mLeft;
            float offsetY;
            offsetY = mScrollY - child.mTop;
            transformedEvent.offsetLocation(offsetX, offsetY);
            {
                boolean varAB47417F79C7B7F4A08CD74D30CD9C74_1835360456 = (! child.hasIdentityMatrix());
                {
                    transformedEvent.transform(child.getInverseMatrix());
                } //End block
            } //End collapsed parenthetic
            handled = child.dispatchTouchEvent(transformedEvent);
        } //End block
        transformedEvent.recycle();
        addTaint(event.getTaint());
        addTaint(cancel);
        addTaint(child.getTaint());
        addTaint(desiredPointerIdBits);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788951365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788951365;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.179 -0400", hash_original_method = "2F47BE30FCD7EA97F91B7B6F74081615", hash_generated_method = "5B0B3D2D8A64B687DB9F0C5A1C0D4AE4")
    public void setMotionEventSplittingEnabled(boolean split) {
        {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } //End block
        {
            mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        } //End block
        addTaint(split);
        // ---------- Original Method ----------
        //if (split) {
            //mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        //} else {
            //mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.179 -0400", hash_original_method = "F89425D39488194D486F55EA5F8582C3", hash_generated_method = "CCF866276F9FB91EAC2D5A6A1B7C4CAA")
    public boolean isMotionEventSplittingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_888228768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_888228768;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.180 -0400", hash_original_method = "1DFD5D86FC853DC6CE8B88AE68ABB735", hash_generated_method = "BD20094AB0BAB14D98C2579999E8C1D4")
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } //End block
        {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        } //End block
        {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        } //End block
        addTaint(disallowIntercept);
        // ---------- Original Method ----------
        //if (disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0)) {
            //return;
        //}
        //if (disallowIntercept) {
            //mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        //} else {
            //mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        //}
        //if (mParent != null) {
            //mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.189 -0400", hash_original_method = "2FB27FC0FD3119EC0BB03A9B8DB1F75C", hash_generated_method = "AB34DE4DD0A9AE455BA000248D6D261F")
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208321049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208321049;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.197 -0400", hash_original_method = "C4273E4BE381C7F0CE1D54BE1CF759CA", hash_generated_method = "584B2E5A687A38635C66E07EE5782637")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        {
            System.out.println(this + " ViewGroup.requestFocus direction="
                    + direction);
        } //End block
        int descendantFocusability;
        descendantFocusability = getDescendantFocusability();
        //Begin case FOCUS_BLOCK_DESCENDANTS 
        boolean var47E40A2FCA4828C6DE42D7889D59C941_1852777064 = (super.requestFocus(direction, previouslyFocusedRect));
        //End case FOCUS_BLOCK_DESCENDANTS 
        //Begin case FOCUS_BEFORE_DESCENDANTS 
        {
            boolean took;
            took = super.requestFocus(direction, previouslyFocusedRect);
            {
                Object var3A5A180257AE9AD15DBCD18319037603_1269889640 = (onRequestFocusInDescendants(direction, previouslyFocusedRect));
            } //End flattened ternary
        } //End block
        //End case FOCUS_BEFORE_DESCENDANTS 
        //Begin case FOCUS_AFTER_DESCENDANTS 
        {
            boolean took;
            took = onRequestFocusInDescendants(direction, previouslyFocusedRect);
            {
                Object var7EEFFE453EE8B06336FEADC34AE77D1B_157145604 = (super.requestFocus(direction, previouslyFocusedRect));
            } //End flattened ternary
        } //End block
        //End case FOCUS_AFTER_DESCENDANTS 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("descendant focusability must be "
                        + "one of FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS "
                        + "but is " + descendantFocusability);
        //End case default 
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_415135711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_415135711;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.199 -0400", hash_original_method = "47C4A34C6E68C9FD22237D5A1759ABE2", hash_generated_method = "8016ED6D5CCD6CB635E9BFA15D492FB6")
    @SuppressWarnings({"ConstantConditions"})
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int index;
        int increment;
        int end;
        int count;
        count = mChildrenCount;
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
        View[] children;
        children = mChildren;
        {
            int i;
            i = index;
            i += increment;
            {
                View child;
                child = children[i];
                {
                    {
                        boolean var86823278073885F35F11C1598EACBFE2_2073764328 = (child.requestFocus(direction, previouslyFocusedRect));
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1637314072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1637314072;
        // ---------- Original Method ----------
        //int index;
        //int increment;
        //int end;
        //int count = mChildrenCount;
        //if ((direction & FOCUS_FORWARD) != 0) {
            //index = 0;
            //increment = 1;
            //end = count;
        //} else {
            //index = count - 1;
            //increment = -1;
            //end = -1;
        //}
        //final View[] children = mChildren;
        //for (int i = index; i != end; i += increment) {
            //View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                //if (child.requestFocus(direction, previouslyFocusedRect)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.202 -0400", hash_original_method = "C10088C0D1BE61F270AE8158B60FC677", hash_generated_method = "57EFD9E87569C626A9F08B1C2D773061")
    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchStartTemporaryDetach();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchStartTemporaryDetach();
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchStartTemporaryDetach();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.202 -0400", hash_original_method = "F13891122244193473AAFE5583088FC4", hash_generated_method = "BF5826173881135B413B26D368A082C0")
    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchFinishTemporaryDetach();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.dispatchFinishTemporaryDetach();
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchFinishTemporaryDetach();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.215 -0400", hash_original_method = "8739A5508C26F7DDD3FFEBEE4CD95BC5", hash_generated_method = "EEFB89BD32DC13B9303253E62C74BE77")
    @Override
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        visibility |= mViewFlags & VISIBILITY_MASK;
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchAttachedToWindow(info, visibility);
            } //End block
        } //End collapsed parenthetic
        addTaint(info.getTaint());
        addTaint(visibility);
        // ---------- Original Method ----------
        //mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        //super.dispatchAttachedToWindow(info, visibility);
        //mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        //visibility |= mViewFlags & VISIBILITY_MASK;
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchAttachedToWindow(info, visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.216 -0400", hash_original_method = "1EE087DB6D320A1AB0B1F5665AE9972D", hash_generated_method = "0969265D1C74684043DAFB84D357C215")
    @Override
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        boolean handled;
        handled = super.dispatchPopulateAccessibilityEventInternal(event);
        {
            int i, count;
            i = 0;
            count = getChildCount();
            {
                View child;
                child = getChildAt(i);
                {
                    handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1084370712 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1084370712;
        // ---------- Original Method ----------
        //boolean handled = super.dispatchPopulateAccessibilityEventInternal(event);
        //if (handled) {
            //return handled;
        //}
        //for (int i = 0, count = getChildCount(); i < count; i++) {
            //View child = getChildAt(i);
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                //handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                //if (handled) {
                    //return handled;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.217 -0400", hash_original_method = "D1F5A3B1D56655AA52CA4B460A89AF1D", hash_generated_method = "F13CE80CC12A94D8CE329B9E8D447585")
    @Override
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onInitializeAccessibilityNodeInfoInternal(info);
        {
            int i, count;
            i = 0;
            count = mChildrenCount;
            {
                View child;
                child = mChildren[i];
                {
                    info.addChild(child);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //super.onInitializeAccessibilityNodeInfoInternal(info);
        //for (int i = 0, count = mChildrenCount; i < count; i++) {
            //View child = mChildren[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    //&& (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //info.addChild(child);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.229 -0400", hash_original_method = "C93583B1C6CD82E84CFB16E69C063BD6", hash_generated_method = "91DD6CB93750C5E045BCEA4BDE59D520")
    @Override
     void dispatchDetachedFromWindow() {
        cancelAndClearTouchTargets(null);
        mLayoutSuppressed = false;
        mDragNotifiedChildren = null;
        {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        } //End block
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                children[i].dispatchDetachedFromWindow();
            } //End block
        } //End collapsed parenthetic
        super.dispatchDetachedFromWindow();
        // ---------- Original Method ----------
        //cancelAndClearTouchTargets(null);
        //mLayoutSuppressed = false;
        //mDragNotifiedChildren = null;
        //if (mCurrentDrag != null) {
            //mCurrentDrag.recycle();
            //mCurrentDrag = null;
        //}
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchDetachedFromWindow();
        //}
        //super.dispatchDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.230 -0400", hash_original_method = "3A8CBF91275A500D30CEFAD8D7209E14", hash_generated_method = "7D2B83FE97EED0B943BA42E5375ABC3C")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        {
            mGroupFlags |= FLAG_PADDING_NOT_NULL;
        } //End block
        {
            mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        } //End block
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        // ---------- Original Method ----------
        //super.setPadding(left, top, right, bottom);
        //if ((mPaddingLeft | mPaddingTop | mPaddingRight | mPaddingBottom) != 0) {
            //mGroupFlags |= FLAG_PADDING_NOT_NULL;
        //} else {
            //mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.230 -0400", hash_original_method = "0EF6BC3550040660942BB4435DC1568A", hash_generated_method = "A9269C9C5F23AACA779EC4831F8E501A")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        super.dispatchSaveInstanceState(container);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View c;
                c = children[i];
                {
                    c.dispatchSaveInstanceState(container);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //View c = children[i];
            //if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                //c.dispatchSaveInstanceState(container);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.233 -0400", hash_original_method = "38DCBB8C3886F11C25C07FC151CB762B", hash_generated_method = "FF48EB39207BB2570CB12B130D6DA280")
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        super.dispatchSaveInstanceState(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.234 -0400", hash_original_method = "79E9ACE6A349ACE584637F3A31A0E869", hash_generated_method = "865F9CB612D1C58F02E816E510AB5B7B")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        super.dispatchRestoreInstanceState(container);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View c;
                c = children[i];
                {
                    c.dispatchRestoreInstanceState(container);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //View c = children[i];
            //if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                //c.dispatchRestoreInstanceState(container);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.235 -0400", hash_original_method = "85A5428D5025B10E5C75238A5C358628", hash_generated_method = "5E057FFCDB2EDF6C40625C0594CC8467")
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        super.dispatchRestoreInstanceState(container);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.246 -0400", hash_original_method = "673779FD01170D0D857F4CAC6D3A5472", hash_generated_method = "9AD8F294C757455A527F7E1B9424B3AC")
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        {
            View[] children;
            children = mChildren;
            int count;
            count = mChildrenCount;
            {
                int i;
                i = 0;
                {
                    children[i].setDrawingCacheEnabled(enabled);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(enabled);
        // ---------- Original Method ----------
        //if (enabled || (mPersistentDrawingCache & PERSISTENT_ALL_CACHES) != PERSISTENT_ALL_CACHES) {
            //final View[] children = mChildren;
            //final int count = mChildrenCount;
            //for (int i = 0; i < count; i++) {
                //children[i].setDrawingCacheEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.247 -0400", hash_original_method = "C6BD5BCC8D99F50AFC626E34071E2FAF", hash_generated_method = "DA4043F4D314EAC719DFE72472E0BE07")
    @Override
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationStart();
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            boolean buildCache;
            buildCache = !isHardwareAccelerated();
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        child.setDrawingCacheEnabled(true);
                        {
                            child.buildDrawingCache(true);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        } //End block
        // ---------- Original Method ----------
        //super.onAnimationStart();
        //if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //final boolean buildCache = !isHardwareAccelerated();
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                    //child.setDrawingCacheEnabled(true);
                    //if (buildCache) {
                        //child.buildDrawingCache(true);
                    //}
                //}
            //}
            //mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.248 -0400", hash_original_method = "D937B1A7AD9A1EFB7CAF69E9B3174965", hash_generated_method = "35CEF9D8DFD04C9C6DD4F44A075F19A5")
    @Override
    protected void onAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationEnd();
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            {
                setChildrenDrawingCacheEnabled(false);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //super.onAnimationEnd();
        //if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            //mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            //if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                //setChildrenDrawingCacheEnabled(false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.266 -0400", hash_original_method = "8B8B5866E6978A8C0D1BC17BB86DCAFE", hash_generated_method = "0FC8F7A3ED95C73CB2DAFF7C1FA9921F")
    @Override
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_515286530 = null; //Variable for return #1
        int count;
        count = mChildrenCount;
        int[] visibilities;
        visibilities = null;
        {
            visibilities = new int[count];
            {
                int i;
                i = 0;
                {
                    View child;
                    child = getChildAt(i);
                    visibilities[i] = child.getVisibility();
                    {
                        child.setVisibility(INVISIBLE);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        Bitmap b;
        b = super.createSnapshot(quality, backgroundColor, skipChildren);
        {
            {
                int i;
                i = 0;
                {
                    getChildAt(i).setVisibility(visibilities[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_515286530 = b;
        addTaint(quality.getTaint());
        addTaint(backgroundColor);
        addTaint(skipChildren);
        varB4EAC82CA7396A68D541C85D26508E83_515286530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_515286530;
        // ---------- Original Method ----------
        //int count = mChildrenCount;
        //int[] visibilities = null;
        //if (skipChildren) {
            //visibilities = new int[count];
            //for (int i = 0; i < count; i++) {
                //View child = getChildAt(i);
                //visibilities[i] = child.getVisibility();
                //if (visibilities[i] == View.VISIBLE) {
                    //child.setVisibility(INVISIBLE);
                //}
            //}
        //}
        //Bitmap b = super.createSnapshot(quality, backgroundColor, skipChildren);
        //if (skipChildren) {
            //for (int i = 0; i < count; i++) {
                //getChildAt(i).setVisibility(visibilities[i]);
            //}
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.273 -0400", hash_original_method = "B43A05A63ADF740A4A15894A451E95C0", hash_generated_method = "CD783A1A23E54C698D73BE5C6DE627F7")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        int flags;
        flags = mGroupFlags;
        {
            boolean var07BB33E4D87E2B5D2A8FEE502EA9E8CD_1869865330 = ((flags & FLAG_RUN_ANIMATION) != 0 && canAnimate());
            {
                boolean cache;
                cache = (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
                boolean buildCache;
                buildCache = !isHardwareAccelerated();
                {
                    int i;
                    i = 0;
                    {
                        View child;
                        child = children[i];
                        {
                            LayoutParams params;
                            params = child.getLayoutParams();
                            attachLayoutAnimationParameters(child, params, i, count);
                            bindLayoutAnimation(child);
                            {
                                child.setDrawingCacheEnabled(true);
                                {
                                    child.buildDrawingCache(true);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                LayoutAnimationController controller;
                controller = mLayoutAnimationController;
                {
                    boolean varE5D19A1FB2EF5ECD65C0B52011051B10_1331288878 = (controller.willOverlap());
                    {
                        mGroupFlags |= FLAG_OPTIMIZE_INVALIDATE;
                    } //End block
                } //End collapsed parenthetic
                controller.start();
                mGroupFlags &= ~FLAG_RUN_ANIMATION;
                mGroupFlags &= ~FLAG_ANIMATION_DONE;
                {
                    mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
                } //End block
                {
                    mAnimationListener.onAnimationStart(controller.getAnimation());
                } //End block
            } //End block
        } //End collapsed parenthetic
        int saveCount;
        saveCount = 0;
        boolean clipToPadding;
        clipToPadding = (flags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        {
            saveCount = canvas.save();
            canvas.clipRect(mScrollX + mPaddingLeft, mScrollY + mPaddingTop,
                    mScrollX + mRight - mLeft - mPaddingRight,
                    mScrollY + mBottom - mTop - mPaddingBottom);
        } //End block
        mPrivateFlags &= ~DRAW_ANIMATION;
        mGroupFlags &= ~FLAG_INVALIDATE_REQUIRED;
        boolean more;
        more = false;
        long drawingTime;
        drawingTime = getDrawingTime();
        {
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_487940467 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[getChildDrawingOrder(count, i)];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_280480253 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            ArrayList<View> disappearingChildren;
            disappearingChildren = mDisappearingChildren;
            int disappearingCount;
            disappearingCount = disappearingChildren.size() - 1;
            {
                int i;
                i = disappearingCount;
                {
                    View child;
                    child = disappearingChildren.get(i);
                    more |= drawChild(canvas, child, drawingTime);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            canvas.restoreToCount(saveCount);
        } //End block
        flags = mGroupFlags;
        {
            invalidate(true);
        } //End block
        {
            boolean var76A6DBFAA8B517B1E30D0F77E8BBAB75_1442989000 = ((flags & FLAG_ANIMATION_DONE) == 0 && (flags & FLAG_NOTIFY_ANIMATION_LISTENER) == 0 &&
                mLayoutAnimationController.isDone() && !more);
            {
                mGroupFlags |= FLAG_NOTIFY_ANIMATION_LISTENER;
                Runnable end;
                end = new Runnable() {
               public void run() {
                   notifyAnimationListener();
               }
            };
                post(end);
            } //End block
        } //End collapsed parenthetic
        addTaint(canvas.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.274 -0400", hash_original_method = "314AC469B646186EB8E30D4AB123CD56", hash_generated_method = "E57FA2ED2278882FFE961B06FE0860E8")
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(childCount);
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639840227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1639840227;
        // ---------- Original Method ----------
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.275 -0400", hash_original_method = "396DFE394BEDDAB737694626CE3DE3EF", hash_generated_method = "99F89107A112AB4239272675542B368B")
    private void notifyAnimationListener() {
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        {
            Runnable end;
            end = new Runnable() {
               public void run() {
                   mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               }
           };
            post(end);
        } //End block
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            {
                setChildrenDrawingCacheEnabled(false);
            } //End block
        } //End block
        invalidate(true);
        // ---------- Original Method ----------
        //mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        //mGroupFlags |= FLAG_ANIMATION_DONE;
        //if (mAnimationListener != null) {
           //final Runnable end = new Runnable() {
               //public void run() {
                   //mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               //}
           //};
           //post(end);
        //}
        //if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            //mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            //if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                //setChildrenDrawingCacheEnabled(false);
            //}
        //}
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.275 -0400", hash_original_method = "F4EA27B0452D996E61B8467125C95A50", hash_generated_method = "5908DCE377B1408EFF30671FC371D424")
    @Override
    protected void dispatchGetDisplayList() {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    boolean var735C012AD3EAE6449E3DE234B2B9D1C4_1533139159 = (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    child.hasStaticLayer());
                    {
                        child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                        child.mPrivateFlags &= ~INVALIDATED;
                        child.getDisplayList();
                        child.mRecreateDisplayList = false;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View child = children[i];
            //if (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    //child.hasStaticLayer()) {
                //child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                //child.mPrivateFlags &= ~INVALIDATED;
                //child.getDisplayList();
                //child.mRecreateDisplayList = false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.335 -0400", hash_original_method = "A5CF70DDE358EAA9D1CA892FF372BD55", hash_generated_method = "0EEBAA3D449BE7FFA41D390CE073144C")
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean more;
        more = false;
        int cl;
        cl = child.mLeft;
        int ct;
        ct = child.mTop;
        int cr;
        cr = child.mRight;
        int cb;
        cb = child.mBottom;
        boolean childHasIdentityMatrix;
        childHasIdentityMatrix = child.hasIdentityMatrix();
        int flags;
        flags = mGroupFlags;
        {
            mChildTransformation.clear();
            mGroupFlags &= ~FLAG_CLEAR_TRANSFORMATION;
        } //End block
        Transformation transformToApply;
        transformToApply = null;
        Transformation invalidationTransform;
        Animation a;
        a = child.getAnimation();
        boolean concatMatrix;
        concatMatrix = false;
        boolean scalingRequired;
        scalingRequired = false;
        boolean caching;
        int layerType;
        layerType = child.getLayerType();
        layerType = LAYER_TYPE_NONE;
        boolean hardwareAccelerated;
        hardwareAccelerated = canvas.isHardwareAccelerated();
        {
            caching = true;
            scalingRequired = mAttachInfo.mScalingRequired;
        } //End block
        {
            caching = (layerType != LAYER_TYPE_NONE) || hardwareAccelerated;
        } //End block
        {
            boolean initialized;
            initialized = a.isInitialized();
            {
                a.initialize(cr - cl, cb - ct, getWidth(), getHeight());
                a.initializeInvalidateRegion(0, 0, cr - cl, cb - ct);
                child.onAnimationStart();
            } //End block
            more = a.getTransformation(drawingTime, mChildTransformation,
                    scalingRequired ? mAttachInfo.mApplicationScale : 1f);
            {
                {
                    mInvalidationTransformation = new Transformation();
                } //End block
                invalidationTransform = mInvalidationTransformation;
                a.getTransformation(drawingTime, invalidationTransform, 1f);
            } //End block
            {
                invalidationTransform = mChildTransformation;
            } //End block
            transformToApply = mChildTransformation;
            concatMatrix = a.willChangeTransformationMatrix();
            {
                {
                    boolean var489AF36514F0C5F8ABF92D9ED1EEF69B_167594803 = (!a.willChangeBounds());
                    {
                        {
                            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                        } //End block
                        {
                            mPrivateFlags |= DRAW_ANIMATION;
                            invalidate(cl, ct, cr, cb);
                        } //End block
                    } //End block
                    {
                        {
                            mInvalidateRegion = new RectF();
                        } //End block
                        RectF region;
                        region = mInvalidateRegion;
                        a.getInvalidateRegion(0, 0, cr - cl, cb - ct, region, invalidationTransform);
                        mPrivateFlags |= DRAW_ANIMATION;
                        int left;
                        left = cl + (int) region.left;
                        int top;
                        top = ct + (int) region.top;
                        invalidate(left, top, left + (int) (region.width() + .5f),
                            top + (int) (region.height() + .5f));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            boolean hasTransform;
            hasTransform = getChildStaticTransformation(child, mChildTransformation);
            {
                int transformType;
                transformType = mChildTransformation.getTransformationType();
                transformToApply = transformType != Transformation.TYPE_IDENTITY ?
                        mChildTransformation : null;
                concatMatrix = (transformType & Transformation.TYPE_MATRIX) != 0;
            } //End block
        } //End block
        concatMatrix |= !childHasIdentityMatrix;
        child.mPrivateFlags |= DRAWN;
        {
            boolean var04A9779EE766FABCC1352F467BA0AB22_341552200 = (!concatMatrix && canvas.quickReject(cl, ct, cr, cb, Canvas.EdgeType.BW) &&
                (child.mPrivateFlags & DRAW_ANIMATION) == 0);
        } //End collapsed parenthetic
        {
            child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
            child.mPrivateFlags &= ~INVALIDATED;
        } //End block
        child.computeScroll();
        int sx;
        sx = child.mScrollX;
        int sy;
        sy = child.mScrollY;
        DisplayList displayList;
        displayList = null;
        Bitmap cache;
        cache = null;
        boolean hasDisplayList;
        hasDisplayList = false;
        {
            {
                {
                    layerType = LAYER_TYPE_SOFTWARE;
                    child.buildDrawingCache(true);
                } //End block
                cache = child.getDrawingCache(true);
            } //End block
            {
                //Begin case LAYER_TYPE_SOFTWARE 
                child.buildDrawingCache(true);
                //End case LAYER_TYPE_SOFTWARE 
                //Begin case LAYER_TYPE_SOFTWARE 
                cache = child.getDrawingCache(true);
                //End case LAYER_TYPE_SOFTWARE 
                //Begin case LAYER_TYPE_NONE 
                hasDisplayList = child.canHaveDisplayList();
                //End case LAYER_TYPE_NONE 
            } //End block
        } //End block
        boolean hasNoCache;
        hasNoCache = cache == null || hasDisplayList;
        boolean offsetForScroll;
        offsetForScroll = cache == null && !hasDisplayList &&
                layerType != LAYER_TYPE_HARDWARE;
        int restoreTo;
        restoreTo = canvas.save();
        {
            canvas.translate(cl - sx, ct - sy);
        } //End block
        {
            canvas.translate(cl, ct);
            {
                float scale;
                scale = 1.0f / mAttachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } //End block
        } //End block
        float alpha;
        alpha = child.getAlpha();
        {
            boolean var934B3E69D3ACD833C0B88FE85A1125E9_1831800851 = (transformToApply != null || alpha < 1.0f || !child.hasIdentityMatrix());
            {
                {
                    int transX;
                    transX = 0;
                    int transY;
                    transY = 0;
                    {
                        transX = -sx;
                        transY = -sy;
                    } //End block
                    {
                        {
                            canvas.translate(-transX, -transY);
                            canvas.concat(transformToApply.getMatrix());
                            canvas.translate(transX, transY);
                            mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                        } //End block
                        float transformAlpha;
                        transformAlpha = transformToApply.getAlpha();
                        {
                            alpha *= transformToApply.getAlpha();
                            mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                        } //End block
                    } //End block
                    {
                        canvas.translate(-transX, -transY);
                        canvas.concat(child.getMatrix());
                        canvas.translate(transX, transY);
                    } //End block
                } //End block
                {
                    mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                    {
                        int multipliedAlpha;
                        multipliedAlpha = (int) (255 * alpha);
                        {
                            boolean varFF146FCD683FC819B246FAE0328227BA_1334959470 = (!child.onSetAlpha(multipliedAlpha));
                            {
                                int layerFlags;
                                layerFlags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
                                {
                                    layerFlags |= Canvas.CLIP_TO_LAYER_SAVE_FLAG;
                                } //End block
                                {
                                    int scrollX;
                                    scrollX = 0;
                                    scrollX = sx;
                                    int scrollY;
                                    scrollY = 0;
                                    scrollY = sy;
                                    canvas.saveLayerAlpha(scrollX, scrollY, scrollX + cr - cl,
                                    scrollY + cb - ct, multipliedAlpha, layerFlags);
                                } //End block
                            } //End block
                            {
                                child.mPrivateFlags |= ALPHA_SET;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                child.onSetAlpha(255);
                child.mPrivateFlags &= ~ALPHA_SET;
            } //End block
        } //End collapsed parenthetic
        {
            {
                canvas.clipRect(sx, sy, sx + (cr - cl), sy + (cb - ct));
            } //End block
            {
                {
                    canvas.clipRect(0, 0, cr - cl, cb - ct);
                } //End block
                {
                    canvas.clipRect(0, 0, cache.getWidth(), cache.getHeight());
                } //End block
            } //End block
        } //End block
        {
            displayList = child.getDisplayList();
            {
                boolean var9C584955B3CFEF7798B020C1B8079C6D_1594227404 = (!displayList.isValid());
                {
                    displayList = null;
                    hasDisplayList = false;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean layerRendered;
            layerRendered = false;
            {
                HardwareLayer layer;
                layer = child.getHardwareLayer();
                {
                    boolean varF47BB7BA46927B23DD4F75E227100F6C_1481209977 = (layer != null && layer.isValid());
                    {
                        child.mLayerPaint.setAlpha((int) (alpha * 255));
                        ((HardwareCanvas) canvas).drawHardwareLayer(layer, 0, 0, child.mLayerPaint);
                        layerRendered = true;
                    } //End block
                    {
                        int scrollX;
                        scrollX = 0;
                        scrollX = sx;
                        int scrollY;
                        scrollY = 0;
                        scrollY = sy;
                        canvas.saveLayer(scrollX, scrollY,
                            scrollX + cr - cl, scrollY + cb - ct, child.mLayerPaint,
                            Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    {
                        {
                            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                        } //End block
                        child.mPrivateFlags &= ~DIRTY_MASK;
                        child.dispatchDraw(canvas);
                    } //End block
                    {
                        child.draw(canvas);
                    } //End block
                } //End block
                {
                    child.mPrivateFlags &= ~DIRTY_MASK;
                    ((HardwareCanvas) canvas).drawDisplayList(displayList, cr - cl, cb - ct, null);
                } //End block
            } //End block
        } //End block
        {
            child.mPrivateFlags &= ~DIRTY_MASK;
            Paint cachePaint;
            {
                cachePaint = mCachePaint;
                {
                    cachePaint = new Paint();
                    cachePaint.setDither(false);
                    mCachePaint = cachePaint;
                } //End block
                {
                    cachePaint.setAlpha((int) (alpha * 255));
                    mGroupFlags |= FLAG_ALPHA_LOWER_THAN_ONE;
                } //End block
                {
                    cachePaint.setAlpha(255);
                    mGroupFlags &= ~FLAG_ALPHA_LOWER_THAN_ONE;
                } //End block
            } //End block
            {
                cachePaint = child.mLayerPaint;
                cachePaint.setAlpha((int) (alpha * 255));
            } //End block
            canvas.drawBitmap(cache, 0.0f, 0.0f, cachePaint);
        } //End block
        canvas.restoreToCount(restoreTo);
        {
            {
                boolean varAF4EC4CBE7F4BE862D45CC273E5600AE_1976557563 = (!hardwareAccelerated && !a.getFillAfter());
                {
                    child.onSetAlpha(255);
                } //End block
            } //End collapsed parenthetic
            finishAnimatingView(child, a);
        } //End block
        {
            invalidate(true);
            {
                boolean var14BEB88AF6F19C239671B73A03DA27C1_91013023 = (a.hasAlpha() && (child.mPrivateFlags & ALPHA_SET) == ALPHA_SET);
                {
                    child.invalidate(true);
                } //End block
            } //End collapsed parenthetic
        } //End block
        child.mRecreateDisplayList = false;
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474883580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474883580;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.337 -0400", hash_original_method = "4095F0AE1BAE27A3A14B16FD7C3431AE", hash_generated_method = "B79FE17FD8E2838989B7A83B9DC9F89B")
    public void setChildrenLayersEnabled(boolean enabled) {
        {
            mDrawLayers = enabled;
            invalidate(true);
            {
                int i;
                i = 0;
                {
                    View child;
                    child = mChildren[i];
                    {
                        child.invalidate(true);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (enabled != mDrawLayers) {
            //mDrawLayers = enabled;
            //invalidate(true);
            //for (int i = 0; i < mChildrenCount; i++) {
                //View child = mChildren[i];
                //if (child.mLayerType != LAYER_TYPE_NONE) {
                    //child.invalidate(true);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.337 -0400", hash_original_method = "1DB85DBA1331DEE146504B0E70B65BE5", hash_generated_method = "38D6A5E8338839B635ADB7C95D35DC38")
    public void setClipChildren(boolean clipChildren) {
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
        addTaint(clipChildren);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.338 -0400", hash_original_method = "863AF54978AA2727D0D7509C22DC212D", hash_generated_method = "FE6B05C3B5C693AA7797D22B0F953BD0")
    public void setClipToPadding(boolean clipToPadding) {
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
        addTaint(clipToPadding);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.338 -0400", hash_original_method = "8ABEEBF76C5626CBEA0073E7871E08E9", hash_generated_method = "07F02651376A1FCF4A4DAB48772C27B5")
    @Override
    public void dispatchSetSelected(boolean selected) {
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].setSelected(selected);
            } //End block
        } //End collapsed parenthetic
        addTaint(selected);
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setSelected(selected);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.350 -0400", hash_original_method = "2F91B8D19CDC8A9E83F3387815EB4D3F", hash_generated_method = "1C226D3D0B8CA367A77A246E39B403FD")
    @Override
    public void dispatchSetActivated(boolean activated) {
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].setActivated(activated);
            } //End block
        } //End collapsed parenthetic
        addTaint(activated);
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setActivated(activated);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.351 -0400", hash_original_method = "741F0E8D45382BBF6BA56C96532A94D8", hash_generated_method = "4850711A0865A062BEC9C85D066F6A81")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].setPressed(pressed);
            } //End block
        } //End collapsed parenthetic
        addTaint(pressed);
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setPressed(pressed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.351 -0400", hash_original_method = "BD73AAD871B8740D29315EE305D10F4B", hash_generated_method = "6725A8BB4E7F5A1EF4371361264018C1")
    protected void setStaticTransformationsEnabled(boolean enabled) {
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.352 -0400", hash_original_method = "767004ADA8C3853AF520B9D176A534BE", hash_generated_method = "DE7783D1C0CA37B4ED400CAE1E4C58CC")
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        addTaint(child.getTaint());
        addTaint(t.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1132029418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1132029418;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.361 -0400", hash_original_method = "8C56D4BEA5FE426CA6EBD73A64039E70", hash_generated_method = "692E0039D2B350D20B1F3D9C3EA240A6")
    @Override
    protected View findViewTraversal(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_2011162490 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1078718100 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_781509408 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_2011162490 = this;
        } //End block
        View[] where;
        where = mChildren;
        int len;
        len = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View v;
                v = where[i];
                {
                    v = v.findViewById(id);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1078718100 = v;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_781509408 = null;
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_555963887; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_555963887 = varB4EAC82CA7396A68D541C85D26508E83_2011162490;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_555963887 = varB4EAC82CA7396A68D541C85D26508E83_1078718100;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_555963887 = varB4EAC82CA7396A68D541C85D26508E83_781509408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_555963887.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_555963887;
        // ---------- Original Method ----------
        //if (id == mID) {
            //return this;
        //}
        //final View[] where = mChildren;
        //final int len = mChildrenCount;
        //for (int i = 0; i < len; i++) {
            //View v = where[i];
            //if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //v = v.findViewById(id);
                //if (v != null) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.377 -0400", hash_original_method = "D087F3465F923453754E64A11DB6BED1", hash_generated_method = "1C97FEAF164068A9B47B23EFBA0E9F96")
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_529330279 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_1243850004 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_1368219139 = null; //Variable for return #3
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_8229354 = (tag != null && tag.equals(mTag));
            {
                varB4EAC82CA7396A68D541C85D26508E83_529330279 = this;
            } //End block
        } //End collapsed parenthetic
        View[] where;
        where = mChildren;
        int len;
        len = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View v;
                v = where[i];
                {
                    v = v.findViewWithTag(tag);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1243850004 = v;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1368219139 = null;
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1144005048; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1144005048 = varB4EAC82CA7396A68D541C85D26508E83_529330279;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1144005048 = varB4EAC82CA7396A68D541C85D26508E83_1243850004;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1144005048 = varB4EAC82CA7396A68D541C85D26508E83_1368219139;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1144005048.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1144005048;
        // ---------- Original Method ----------
        //if (tag != null && tag.equals(mTag)) {
            //return this;
        //}
        //final View[] where = mChildren;
        //final int len = mChildrenCount;
        //for (int i = 0; i < len; i++) {
            //View v = where[i];
            //if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //v = v.findViewWithTag(tag);
                //if (v != null) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.378 -0400", hash_original_method = "0EC5116F4AD2AA9CFA72F9149C3A9529", hash_generated_method = "875F11C5886AC4FF1F1BC66EC80251D9")
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_621649310 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_2008985886 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_28437622 = null; //Variable for return #3
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_1228652945 = (predicate.apply(this));
            {
                varB4EAC82CA7396A68D541C85D26508E83_621649310 = this;
            } //End block
        } //End collapsed parenthetic
        View[] where;
        where = mChildren;
        int len;
        len = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View v;
                v = where[i];
                {
                    v = v.findViewByPredicate(predicate);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2008985886 = v;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_28437622 = null;
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_334882624; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_334882624 = varB4EAC82CA7396A68D541C85D26508E83_621649310;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_334882624 = varB4EAC82CA7396A68D541C85D26508E83_2008985886;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_334882624 = varB4EAC82CA7396A68D541C85D26508E83_28437622;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_334882624.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_334882624;
        // ---------- Original Method ----------
        //if (predicate.apply(this)) {
            //return this;
        //}
        //final View[] where = mChildren;
        //final int len = mChildrenCount;
        //for (int i = 0; i < len; i++) {
            //View v = where[i];
            //if (v != childToSkip && (v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                //v = v.findViewByPredicate(predicate);
                //if (v != null) {
                    //return v;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.378 -0400", hash_original_method = "CEC5DF3412108DC355B81A234F778717", hash_generated_method = "181C858E645E3A406557787AB3FC2125")
    public void addView(View child) {
        addView(child, -1);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //addView(child, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.378 -0400", hash_original_method = "052049806EFDCB28F8B1780970FB4D61", hash_generated_method = "1343753BA756F2BE2EF4B809A2D88488")
    public void addView(View child, int index) {
        LayoutParams params;
        params = child.getLayoutParams();
        {
            params = generateDefaultLayoutParams();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            } //End block
        } //End block
        addView(child, index, params);
        addTaint(child.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //LayoutParams params = child.getLayoutParams();
        //if (params == null) {
            //params = generateDefaultLayoutParams();
            //if (params == null) {
                //throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            //}
        //}
        //addView(child, index, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.379 -0400", hash_original_method = "04069655751E8F150919B197DB2D0EF4", hash_generated_method = "4E655D15FB349684390FAF395EA88A9F")
    public void addView(View child, int width, int height) {
        LayoutParams params;
        params = generateDefaultLayoutParams();
        params.width = width;
        params.height = height;
        addView(child, -1, params);
        addTaint(child.getTaint());
        addTaint(width);
        addTaint(height);
        // ---------- Original Method ----------
        //final LayoutParams params = generateDefaultLayoutParams();
        //params.width = width;
        //params.height = height;
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.379 -0400", hash_original_method = "CAABD1DBDF747222034CC373BA6381CC", hash_generated_method = "641806D60D8710F22CD9342A56CC8848")
    public void addView(View child, LayoutParams params) {
        addView(child, -1, params);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.380 -0400", hash_original_method = "BD78A36687CEEF62B7E0786E86501A2F", hash_generated_method = "EFB26DE6BD295DBB249DFC9C64A140D7")
    public void addView(View child, int index, LayoutParams params) {
        {
            System.out.println(this + " addView");
        } //End block
        requestLayout();
        invalidate(true);
        addViewInner(child, index, params, false);
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " addView");
        //}
        //requestLayout();
        //invalidate(true);
        //addViewInner(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.380 -0400", hash_original_method = "8137D76BAD6EAD8C2AFF7B0DC7EC38EA", hash_generated_method = "727DDFD01DC9D33F0C21F45E98D167F7")
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_1903683256 = (!checkLayoutParams(params));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8034A81DF8A049A1DEC5A101D1129C23_598665054 = (view.mParent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Given view not a child of " + this);
            } //End block
        } //End collapsed parenthetic
        view.setLayoutParams(params);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (!checkLayoutParams(params)) {
            //throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
        //}
        //if (view.mParent != this) {
            //throw new IllegalArgumentException("Given view not a child of " + this);
        //}
        //view.setLayoutParams(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.401 -0400", hash_original_method = "C2EE5015ED0F9B04763A6A0F4C905EDB", hash_generated_method = "74F2AA8B27BE7E40EA7A4EDE655956F5")
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_990502825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_990502825;
        // ---------- Original Method ----------
        //return  p != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.401 -0400", hash_original_method = "2EFEB52353D2008493D1621282A03886", hash_generated_method = "7C3C20C1075C2C96B31EA398AE09593A")
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        mOnHierarchyChangeListener = listener;
        // ---------- Original Method ----------
        //mOnHierarchyChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.402 -0400", hash_original_method = "7C8375F0DCFCC6770307465540C43F29", hash_generated_method = "3B4A13063E631F9E09957E2CE7CAEDBA")
    protected void onViewAdded(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mOnHierarchyChangeListener.onChildViewAdded(this, child);
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (mOnHierarchyChangeListener != null) {
            //mOnHierarchyChangeListener.onChildViewAdded(this, child);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.402 -0400", hash_original_method = "2969A02DF6E73517C4A5610098A20201", hash_generated_method = "E7BD940E5C959E96F9765F094B55BFF8")
    protected void onViewRemoved(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (mOnHierarchyChangeListener != null) {
            //mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.403 -0400", hash_original_method = "4EC56F492B64387EC5CDEE559C919DD8", hash_generated_method = "02C0228CDB93FF76DE8B38CF6509D155")
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        boolean varC93AA663A5550227DF73E011E019C03E_50812167 = (addViewInLayout(child, index, params, false));
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1779890173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1779890173;
        // ---------- Original Method ----------
        //return addViewInLayout(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.403 -0400", hash_original_method = "621D5EA894CECBBA3C5FE5D7159CF1D3", hash_generated_method = "BC97C809D351C724E5965D895E8C42EA")
    protected boolean addViewInLayout(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        child.mParent = null;
        addViewInner(child, index, params, preventRequestLayout);
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        addTaint(preventRequestLayout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131477653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131477653;
        // ---------- Original Method ----------
        //child.mParent = null;
        //addViewInner(child, index, params, preventRequestLayout);
        //child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.405 -0400", hash_original_method = "156A75B155CF89ADA3C99A75E911D53A", hash_generated_method = "F7447FAC479522D7F2DD4257603BD30D")
    protected void cleanupLayoutState(View child) {
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //child.mPrivateFlags &= ~View.FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.406 -0400", hash_original_method = "4623983FE5D2926EED9F934007E41D76", hash_generated_method = "DCF8B81CE7D32957CEFB94EB94348863")
    private void addViewInner(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        {
            mTransition.cancel(LayoutTransition.DISAPPEARING);
        } //End block
        {
            boolean varA3364C4A63F6A263A8814AE455A29C59_1290778692 = (child.getParent() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The specified child already has a parent. " +
                    "You must call removeView() on the child's parent first.");
            } //End block
        } //End collapsed parenthetic
        {
            mTransition.addChild(this, child);
        } //End block
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_184177066 = (!checkLayoutParams(params));
            {
                params = generateLayoutParams(params);
            } //End block
        } //End collapsed parenthetic
        {
            child.mLayoutParams = params;
        } //End block
        {
            child.setLayoutParams(params);
        } //End block
        {
            index = mChildrenCount;
        } //End block
        addInArray(child, index);
        {
            child.assignParent(this);
        } //End block
        {
            child.mParent = this;
        } //End block
        {
            boolean varDDA55DF480817D6313066967525E9186_1436757632 = (child.hasFocus());
            {
                requestChildFocus(child, child.findFocus());
            } //End block
        } //End collapsed parenthetic
        AttachInfo ai;
        ai = mAttachInfo;
        {
            boolean lastKeepOn;
            lastKeepOn = ai.mKeepScreenOn;
            ai.mKeepScreenOn = false;
            child.dispatchAttachedToWindow(mAttachInfo, (mViewFlags&VISIBILITY_MASK));
            {
                needGlobalAttributesUpdate(true);
            } //End block
            ai.mKeepScreenOn = lastKeepOn;
        } //End block
        onViewAdded(child);
        {
            mGroupFlags |= FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE;
        } //End block
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        addTaint(preventRequestLayout);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.430 -0400", hash_original_method = "3DC226B361362F1A66E4DF7340FD46AC", hash_generated_method = "D245A7E1010B3A3EECD9DE08F56C19FE")
    private void addInArray(View child, int index) {
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        int size;
        size = children.length;
        {
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, size);
                children = mChildren;
            } //End block
            children[mChildrenCount++] = child;
        } //End block
        {
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, index);
                System.arraycopy(children, index, mChildren, index + 1, count - index);
                children = mChildren;
            } //End block
            {
                System.arraycopy(children, index, children, index + 1, count - index);
            } //End block
            children[index] = child;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + " count=" + count);
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.431 -0400", hash_original_method = "666B846103F98929B6C3984DF363A458", hash_generated_method = "D24F581582A8B2BCD2BA24FB8BBACD4E")
    private void removeFromArray(int index) {
        View[] children;
        children = mChildren;
        {
            boolean varFD7C05E4772169FABFE9822CC2FF40CC_1705800270 = (!(mTransitioningViews != null && mTransitioningViews.contains(children[index])));
            {
                children[index].mParent = null;
            } //End block
        } //End collapsed parenthetic
        int count;
        count = mChildrenCount;
        {
            children[--mChildrenCount] = null;
        } //End block
        {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        {
            mLastTouchDownTime = 0;
            mLastTouchDownIndex = -1;
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //if (!(mTransitioningViews != null && mTransitioningViews.contains(children[index]))) {
            //children[index].mParent = null;
        //}
        //final int count = mChildrenCount;
        //if (index == count - 1) {
            //children[--mChildrenCount] = null;
        //} else if (index >= 0 && index < count) {
            //System.arraycopy(children, index + 1, children, index, count - index - 1);
            //children[--mChildrenCount] = null;
        //} else {
            //throw new IndexOutOfBoundsException();
        //}
        //if (mLastTouchDownIndex == index) {
            //mLastTouchDownTime = 0;
            //mLastTouchDownIndex = -1;
        //} else if (mLastTouchDownIndex > index) {
            //mLastTouchDownIndex--;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.433 -0400", hash_original_method = "7377DC4CCC7ACF33951FFC91A9C19242", hash_generated_method = "CF5C8D0F104CEB6C481F9A22ACA8C967")
    private void removeFromArray(int start, int count) {
        View[] children;
        children = mChildren;
        int childrenCount;
        childrenCount = mChildrenCount;
        start = Math.max(0, start);
        int end;
        end = Math.min(childrenCount, start + count);
        {
            {
                int i;
                i = start;
                {
                    children[i].mParent = null;
                    children[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = start;
                {
                    children[i].mParent = null;
                } //End block
            } //End collapsed parenthetic
            System.arraycopy(children, end, children, start, childrenCount - end);
            {
                int i;
                i = childrenCount - (end - start);
                {
                    children[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mChildrenCount -= (end - start);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.453 -0400", hash_original_method = "0C13B6720EDD2CD731BF86C88080EC0A", hash_generated_method = "D0BC78167EE21EAE48477BBAE124DE17")
    private void bindLayoutAnimation(View child) {
        Animation a;
        a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //Animation a = mLayoutAnimationController.getAnimationForView(child);
        //child.setAnimation(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.454 -0400", hash_original_method = "53A696BC845D59D084861C4C39417C50", hash_generated_method = "3D0EE66017143D0AE5787F46D881D67B")
    protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count) {
        LayoutAnimationController.AnimationParameters animationParams;
        animationParams = params.layoutAnimationParameters;
        {
            animationParams = new LayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } //End block
        animationParams.count = count;
        animationParams.index = index;
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(count);
        // ---------- Original Method ----------
        //LayoutAnimationController.AnimationParameters animationParams =
                    //params.layoutAnimationParameters;
        //if (animationParams == null) {
            //animationParams = new LayoutAnimationController.AnimationParameters();
            //params.layoutAnimationParameters = animationParams;
        //}
        //animationParams.count = count;
        //animationParams.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.454 -0400", hash_original_method = "D47B7EA927C9C6E9F8463F22FA8E7751", hash_generated_method = "B4A6928DAD41F623A316349C15146FB6")
    public void removeView(View view) {
        removeViewInternal(view);
        requestLayout();
        invalidate(true);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //removeViewInternal(view);
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.455 -0400", hash_original_method = "9C0189C4A93DBFF4CA9135E979534627", hash_generated_method = "CFAB7C83D15D49D12037A7C36C135022")
    public void removeViewInLayout(View view) {
        removeViewInternal(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //removeViewInternal(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.456 -0400", hash_original_method = "CCED8E1F5C1435811C77FC8E195AA3ED", hash_generated_method = "BC3DB41E3643A6FAC062F7C261CBAFF2")
    public void removeViewsInLayout(int start, int count) {
        removeViewsInternal(start, count);
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.456 -0400", hash_original_method = "C7B982345E14E4BA654D9B702D09B782", hash_generated_method = "5AE6ACDAC5A60F10B971383535FCD4EF")
    public void removeViewAt(int index) {
        removeViewInternal(index, getChildAt(index));
        requestLayout();
        invalidate(true);
        addTaint(index);
        // ---------- Original Method ----------
        //removeViewInternal(index, getChildAt(index));
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.458 -0400", hash_original_method = "295E3CFFAAE54DAD76DF23980004A9FB", hash_generated_method = "7C8BFD498DD87D4938235AC47BDFABC5")
    public void removeViews(int start, int count) {
        removeViewsInternal(start, count);
        requestLayout();
        invalidate(true);
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.458 -0400", hash_original_method = "A8C7AA662547BF9F482FBD0CAAADED6D", hash_generated_method = "7A8C81768D332821921E4A634A629932")
    private void removeViewInternal(View view) {
        int index;
        index = indexOfChild(view);
        {
            removeViewInternal(index, view);
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //final int index = indexOfChild(view);
        //if (index >= 0) {
            //removeViewInternal(index, view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.479 -0400", hash_original_method = "5145400D128FAA852B030ECA7E0E5CC6", hash_generated_method = "AD836A29FD512DD44D42A5551D3D07C8")
    private void removeViewInternal(int index, View view) {
        {
            mTransition.removeChild(this, view);
        } //End block
        boolean clearChildFocus;
        clearChildFocus = false;
        {
            view.clearFocusForRemoval();
            clearChildFocus = true;
        } //End block
        {
            boolean var74C8DDDF999D66AA3EB9771E0CD6D718_43801377 = (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)));
            {
                addDisappearingView(view);
            } //End block
            {
                view.dispatchDetachedFromWindow();
            } //End block
        } //End collapsed parenthetic
        onViewRemoved(view);
        needGlobalAttributesUpdate(false);
        removeFromArray(index);
        {
            clearChildFocus(view);
        } //End block
        addTaint(index);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //if (mTransition != null) {
            //mTransition.removeChild(this, view);
        //}
        //boolean clearChildFocus = false;
        //if (view == mFocused) {
            //view.clearFocusForRemoval();
            //clearChildFocus = true;
        //}
        //if (view.getAnimation() != null ||
                //(mTransitioningViews != null && mTransitioningViews.contains(view))) {
            //addDisappearingView(view);
        //} else if (view.mAttachInfo != null) {
           //view.dispatchDetachedFromWindow();
        //}
        //onViewRemoved(view);
        //needGlobalAttributesUpdate(false);
        //removeFromArray(index);
        //if (clearChildFocus) {
            //clearChildFocus(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.480 -0400", hash_original_method = "6CC26F3EB4840902E7233D2C3E46A07B", hash_generated_method = "B97821E95017FC95C215DC451B5D2A85")
    public void setLayoutTransition(LayoutTransition transition) {
        {
            mTransition.removeTransitionListener(mLayoutTransitionListener);
        } //End block
        mTransition = transition;
        {
            mTransition.addTransitionListener(mLayoutTransitionListener);
        } //End block
        // ---------- Original Method ----------
        //if (mTransition != null) {
            //mTransition.removeTransitionListener(mLayoutTransitionListener);
        //}
        //mTransition = transition;
        //if (mTransition != null) {
            //mTransition.addTransitionListener(mLayoutTransitionListener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.480 -0400", hash_original_method = "33E35321C94CA74A9D9819C2C9739D2F", hash_generated_method = "1C21329399A1C91BF1C6458103C0EDD9")
    public LayoutTransition getLayoutTransition() {
        LayoutTransition varB4EAC82CA7396A68D541C85D26508E83_901577326 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_901577326 = mTransition;
        varB4EAC82CA7396A68D541C85D26508E83_901577326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901577326;
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.483 -0400", hash_original_method = "F40E247B6ABF822EB65FF56F80411035", hash_generated_method = "3E678F98FC89DD3E846C182DFFA72494")
    private void removeViewsInternal(int start, int count) {
        View focused;
        focused = mFocused;
        boolean detach;
        detach = mAttachInfo != null;
        View clearChildFocus;
        clearChildFocus = null;
        View[] children;
        children = mChildren;
        int end;
        end = start + count;
        {
            int i;
            i = start;
            {
                View view;
                view = children[i];
                {
                    mTransition.removeChild(this, view);
                } //End block
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } //End block
                {
                    boolean var771BCD00CE5FBF80B4F7B15D3C6EBC5E_569442333 = (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)));
                    {
                        addDisappearingView(view);
                    } //End block
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
                } //End collapsed parenthetic
                needGlobalAttributesUpdate(false);
                onViewRemoved(view);
            } //End block
        } //End collapsed parenthetic
        removeFromArray(start, count);
        {
            clearChildFocus(clearChildFocus);
        } //End block
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.483 -0400", hash_original_method = "C167CC912DB398153B3FBDE6D6503FBD", hash_generated_method = "251074A9D0FEFE564BF870888680CE2E")
    public void removeAllViews() {
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeAllViewsInLayout();
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.484 -0400", hash_original_method = "8DFE71C1BEB57BA28106B31D5772632E", hash_generated_method = "B5638F3C91B64DFD93535E4193C0476F")
    public void removeAllViewsInLayout() {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        mChildrenCount = 0;
        View focused;
        focused = mFocused;
        boolean detach;
        detach = mAttachInfo != null;
        View clearChildFocus;
        clearChildFocus = null;
        needGlobalAttributesUpdate(false);
        {
            int i;
            i = count - 1;
            {
                View view;
                view = children[i];
                {
                    mTransition.removeChild(this, view);
                } //End block
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } //End block
                {
                    boolean var25706AD565CAAA05294A1680813DB393_1845282137 = (view.getAnimation() != null ||
                    (mTransitioningViews != null && mTransitioningViews.contains(view)));
                    {
                        addDisappearingView(view);
                    } //End block
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
                } //End collapsed parenthetic
                onViewRemoved(view);
                view.mParent = null;
                children[i] = null;
            } //End block
        } //End collapsed parenthetic
        {
            clearChildFocus(clearChildFocus);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.489 -0400", hash_original_method = "80D629C332B0E93DD7A33AD3708E672D", hash_generated_method = "EA4BAB9EC7141139491ED239D926C780")
    protected void removeDetachedView(View child, boolean animate) {
        {
            mTransition.removeChild(this, child);
        } //End block
        {
            child.clearFocus();
        } //End block
        {
            boolean varC784B3814A6616C601A69CC572D538AE_677139793 = ((animate && child.getAnimation() != null) ||
                (mTransitioningViews != null && mTransitioningViews.contains(child)));
            {
                addDisappearingView(child);
            } //End block
            {
                child.dispatchDetachedFromWindow();
            } //End block
        } //End collapsed parenthetic
        onViewRemoved(child);
        addTaint(child.getTaint());
        addTaint(animate);
        // ---------- Original Method ----------
        //if (mTransition != null) {
            //mTransition.removeChild(this, child);
        //}
        //if (child == mFocused) {
            //child.clearFocus();
        //}
        //if ((animate && child.getAnimation() != null) ||
                //(mTransitioningViews != null && mTransitioningViews.contains(child))) {
            //addDisappearingView(child);
        //} else if (child.mAttachInfo != null) {
            //child.dispatchDetachedFromWindow();
        //}
        //onViewRemoved(child);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.490 -0400", hash_original_method = "8472A11DDB1452C7DB4257A960216E78", hash_generated_method = "0152E390BCB556E03AE306BDA4BCF1A8")
    protected void attachViewToParent(View child, int index, LayoutParams params) {
        child.mLayoutParams = params;
        {
            index = mChildrenCount;
        } //End block
        addInArray(child, index);
        child.mParent = this;
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                DRAWN | INVALIDATED;
        this.mPrivateFlags |= INVALIDATED;
        {
            boolean varDDA55DF480817D6313066967525E9186_1334098800 = (child.hasFocus());
            {
                requestChildFocus(child, child.findFocus());
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //child.mLayoutParams = params;
        //if (index < 0) {
            //index = mChildrenCount;
        //}
        //addInArray(child, index);
        //child.mParent = this;
        //child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                //DRAWN | INVALIDATED;
        //this.mPrivateFlags |= INVALIDATED;
        //if (child.hasFocus()) {
            //requestChildFocus(child, child.findFocus());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.490 -0400", hash_original_method = "635C6E5D7FA712D6D6BC98C85EEAD0AE", hash_generated_method = "F8405D564C6BA31F3A7AD700E691876A")
    protected void detachViewFromParent(View child) {
        removeFromArray(indexOfChild(child));
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //removeFromArray(indexOfChild(child));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.503 -0400", hash_original_method = "6B327774A5D40749E682A0800D955866", hash_generated_method = "59E503E3446F5BDABA4C4E6174E6B64D")
    protected void detachViewFromParent(int index) {
        removeFromArray(index);
        addTaint(index);
        // ---------- Original Method ----------
        //removeFromArray(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.503 -0400", hash_original_method = "9419943F60DE9471E3CB31EABE2947F0", hash_generated_method = "1442599EBAE371CF534E26FB17509880")
    protected void detachViewsFromParent(int start, int count) {
        removeFromArray(start, count);
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        //removeFromArray(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.504 -0400", hash_original_method = "FD3027623927AF219788395D1D83AA06", hash_generated_method = "05683DB8C013E2C29E726864460B3AF0")
    protected void detachAllViewsFromParent() {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        mChildrenCount = 0;
        {
            int i;
            i = count - 1;
            {
                children[i].mParent = null;
                children[i] = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //if (count <= 0) {
            //return;
        //}
        //final View[] children = mChildren;
        //mChildrenCount = 0;
        //for (int i = count - 1; i >= 0; i--) {
            //children[i].mParent = null;
            //children[i] = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.514 -0400", hash_original_method = "063B7BC13F01F04711683C921C10A0CE", hash_generated_method = "B666CF05C2A55CB09FE7AF607422E836")
    public final void invalidateChild(View child, final Rect dirty) {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD);
        } //End block
        ViewParent parent;
        parent = this;
        AttachInfo attachInfo;
        attachInfo = mAttachInfo;
        {
            boolean drawAnimation;
            drawAnimation = (child.mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION;
            {
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.setEmpty();
                } //End block
                {
                    View view;
                    view = null;
                    {
                        view = (View) parent;
                        {
                            view.mLocalDirtyRect.setEmpty();
                            {
                                boolean var3DA0F6F5F2B1801DCC6F6E6927312986_621610474 = (view.getParent() instanceof View);
                                {
                                    View grandParent;
                                    grandParent = (View) view.getParent();
                                    grandParent.mPrivateFlags |= INVALIDATED;
                                    grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        {
                            view.mPrivateFlags |= DRAW_ANIMATION;
                        } //End block
                        {
                            ((ViewRootImpl) parent).mIsAnimating = true;
                        } //End block
                    } //End block
                    {
                        ((ViewRootImpl) parent).invalidate();
                        parent = null;
                    } //End block
                    {
                        {
                            view.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            view.mPrivateFlags |= DIRTY;
                            parent = view.mParent;
                        } //End block
                        {
                            parent = null;
                        } //End block
                    } //End block
                } //End block
            } //End block
            {
                boolean isOpaque;
                isOpaque = child.isOpaque() && !drawAnimation &&
                        child.getAnimation() == null;
                int opaqueFlag;
                opaqueFlag = DIRTY_OPAQUE;
                opaqueFlag = DIRTY;
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.union(dirty);
                } //End block
                int[] location;
                location = attachInfo.mInvalidateChildLocation;
                location[CHILD_LEFT_INDEX] = child.mLeft;
                location[CHILD_TOP_INDEX] = child.mTop;
                Matrix childMatrix;
                childMatrix = child.getMatrix();
                {
                    boolean varCFD88FFD44E20CB7F1D8D4D2556D2E8C_496198144 = (!childMatrix.isIdentity());
                    {
                        RectF boundingRect;
                        boundingRect = attachInfo.mTmpTransformRect;
                        boundingRect.set(dirty);
                        childMatrix.mapRect(boundingRect);
                        dirty.set((int) (boundingRect.left - 0.5f),
                            (int) (boundingRect.top - 0.5f),
                            (int) (boundingRect.right + 0.5f),
                            (int) (boundingRect.bottom + 0.5f));
                    } //End block
                } //End collapsed parenthetic
                {
                    View view;
                    view = null;
                    {
                        view = (View) parent;
                        {
                            boolean varC5230D1238FBEF65B7498AB998C6F0FA_1687097715 = (view.mLayerType != LAYER_TYPE_NONE &&
                                view.getParent() instanceof View);
                            {
                                View grandParent;
                                grandParent = (View) view.getParent();
                                grandParent.mPrivateFlags |= INVALIDATED;
                                grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            view.mPrivateFlags |= DRAW_ANIMATION;
                        } //End block
                        {
                            ((ViewRootImpl) parent).mIsAnimating = true;
                        } //End block
                    } //End block
                    {
                        {
                            boolean var760C0A78BE5FDB84740BECBCA8BA8947_1233891886 = ((view.mViewFlags & FADING_EDGE_MASK) != 0 &&
                                view.getSolidColor() == 0);
                            {
                                opaqueFlag = DIRTY;
                            } //End block
                        } //End collapsed parenthetic
                        {
                            view.mPrivateFlags = (view.mPrivateFlags & ~DIRTY_MASK) | opaqueFlag;
                        } //End block
                    } //End block
                    parent = parent.invalidateChildInParent(location, dirty);
                    {
                        Matrix m;
                        m = view.getMatrix();
                        {
                            boolean var8D882C39D7302E18C8FB45549919991D_2072430545 = (!m.isIdentity());
                            {
                                RectF boundingRect;
                                boundingRect = attachInfo.mTmpTransformRect;
                                boundingRect.set(dirty);
                                m.mapRect(boundingRect);
                                dirty.set((int) boundingRect.left, (int) boundingRect.top,
                                    (int) (boundingRect.right + 0.5f),
                                    (int) (boundingRect.bottom + 0.5f));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End block
        addTaint(child.getTaint());
        addTaint(dirty.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.528 -0400", hash_original_method = "DC318C38544A42EB44071D5AE866F2AB", hash_generated_method = "D02A981E57D6ED190C30D3796C192D09")
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_368702256 = null; //Variable for return #1
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_38092070 = null; //Variable for return #2
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_120600757 = null; //Variable for return #3
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD_IN_PARENT);
        } //End block
        {
            {
                dirty.offset(location[CHILD_LEFT_INDEX] - mScrollX,
                        location[CHILD_TOP_INDEX] - mScrollY);
                int left;
                left = mLeft;
                int top;
                top = mTop;
                {
                    boolean var1FD08A580F456E7C6E817E871B882F95_1383205574 = ((mGroupFlags & FLAG_CLIP_CHILDREN) != FLAG_CLIP_CHILDREN ||
                        dirty.intersect(0, 0, mRight - left, mBottom - top) ||
                        (mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION);
                    {
                        mPrivateFlags &= ~DRAWING_CACHE_VALID;
                        location[CHILD_LEFT_INDEX] = left;
                        location[CHILD_TOP_INDEX] = top;
                        {
                            mLocalDirtyRect.union(dirty);
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_368702256 = mParent;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mPrivateFlags &= ~DRAWN & ~DRAWING_CACHE_VALID;
                location[CHILD_LEFT_INDEX] = mLeft;
                location[CHILD_TOP_INDEX] = mTop;
                {
                    dirty.set(0, 0, mRight - mLeft, mBottom - mTop);
                } //End block
                {
                    dirty.union(0, 0, mRight - mLeft, mBottom - mTop);
                } //End block
                {
                    mLocalDirtyRect.union(dirty);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_38092070 = mParent;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_120600757 = null;
        addTaint(location[0]);
        addTaint(dirty.getTaint());
        ViewParent varA7E53CE21691AB073D9660D615818899_241186635; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_241186635 = varB4EAC82CA7396A68D541C85D26508E83_368702256;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_241186635 = varB4EAC82CA7396A68D541C85D26508E83_38092070;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_241186635 = varB4EAC82CA7396A68D541C85D26508E83_120600757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_241186635.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_241186635;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.528 -0400", hash_original_method = "50571ED06CB8BFD92222BA4CF106E503", hash_generated_method = "3F1C0A72877084741C4A5E321B476AC9")
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect) {
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
        addTaint(descendant.getTaint());
        addTaint(rect.getTaint());
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, true, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.529 -0400", hash_original_method = "237D31B5A43A7733C9219A4289DB54A9", hash_generated_method = "FF2B8E97E069390D318E663B481D01C4")
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect) {
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
        addTaint(descendant.getTaint());
        addTaint(rect.getTaint());
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.556 -0400", hash_original_method = "D3722A63E3ED25EA76952CBDD9156CED", hash_generated_method = "FBCC26858DBF7301274825BCB6E948AD")
     void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds) {
        {
            boolean var9866E6F62DFB6148F201138746ED5750_438787062 = (descendant == this);
        } //End collapsed parenthetic
        ViewParent theParent;
        theParent = descendant.mParent;
        {
            boolean varDD69D58089B270F3D4B28124BF640FA8_442968640 = ((theParent != null)
                && (theParent instanceof View)
                && (theParent != this));
            {
                {
                    rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
                    {
                        View p;
                        p = (View) theParent;
                        rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                    } //End block
                } //End block
                {
                    {
                        View p;
                        p = (View) theParent;
                        rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                    } //End block
                    rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
                } //End block
                descendant = (View) theParent;
                theParent = descendant.mParent;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var643C98140D61F4DFE43564E3D036760F_1276304944 = (theParent == this);
            {
                {
                    rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
                } //End block
                {
                    rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("parameter must be a descendant of this view");
            } //End block
        } //End collapsed parenthetic
        addTaint(descendant.getTaint());
        addTaint(rect.getTaint());
        addTaint(offsetFromChildToParent);
        addTaint(clipToBounds);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.557 -0400", hash_original_method = "7A1B0B3F062F0EF6FC199DD0C643A517", hash_generated_method = "A70E990251C1D3769DAACFD755B3A607")
    public void offsetChildrenTopAndBottom(int offset) {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View v;
                v = children[i];
                v.mTop += offset;
                v.mBottom += offset;
            } //End block
        } //End collapsed parenthetic
        addTaint(offset);
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View v = children[i];
            //v.mTop += offset;
            //v.mBottom += offset;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.558 -0400", hash_original_method = "5C31858D2677D0E5DD9194B8EDADFECC", hash_generated_method = "193BCD79C2CC335C304020E64222FD86")
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        RectF rect;
        rect = mAttachInfo.mTmpTransformRect;
        rect = new RectF();
        rect.set(r);
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_216341830 = (!child.hasIdentityMatrix());
            {
                child.getMatrix().mapRect(rect);
            } //End block
        } //End collapsed parenthetic
        int dx;
        dx = child.mLeft - mScrollX;
        int dy;
        dy = child.mTop - mScrollY;
        rect.offset(dx, dy);
        {
            {
                boolean var4909A00AAC5857DB675C7058066C1F45_686494941 = (!child.hasIdentityMatrix());
                {
                    float[] position;
                    position = mAttachInfo.mTmpTransformLocation;
                    position = new float[2];
                    position[0] = offset.x;
                    position[1] = offset.y;
                    child.getMatrix().mapPoints(position);
                    offset.x = (int) (position[0] + 0.5f);
                    offset.y = (int) (position[1] + 0.5f);
                } //End block
            } //End collapsed parenthetic
            offset.x += dx;
            offset.y += dy;
        } //End block
        {
            boolean var08BB32A43948A9AA882E62C649D0F6D4_1487964526 = (rect.intersect(0, 0, mRight - mLeft, mBottom - mTop));
            {
                r.set((int) (rect.left + 0.5f), (int) (rect.top + 0.5f),
                    (int) (rect.right + 0.5f), (int) (rect.bottom + 0.5f));
                boolean var815D42ADB6C99D0ABB4FA68231A12D7A_822445524 = (mParent.getChildVisibleRect(this, r, offset));
            } //End block
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        addTaint(r.getTaint());
        addTaint(offset.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1380468210 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1380468210;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.558 -0400", hash_original_method = "89A2794B62BBEA7754F18155FA121F08", hash_generated_method = "F287459F915E5BA6039321B837896FC6")
    @Override
    public final void layout(int l, int t, int r, int b) {
        {
            boolean varFB56D3D497D368E0550C6286169A3692_403610908 = (mTransition == null || !mTransition.isChangingLayout());
            {
                super.layout(l, t, r, b);
            } //End block
            {
                mLayoutSuppressed = true;
            } //End block
        } //End collapsed parenthetic
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        // ---------- Original Method ----------
        //if (mTransition == null || !mTransition.isChangingLayout()) {
            //super.layout(l, t, r, b);
        //} else {
            //mLayoutSuppressed = true;
        //}
    }

    
        @Override
protected abstract void onLayout(boolean changed,
            int l, int t, int r, int b);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.559 -0400", hash_original_method = "74094E4283ACC987205CEBE8397B866C", hash_generated_method = "4BE78B22C2212EA604D269C04582F813")
    protected boolean canAnimate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507566022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507566022;
        // ---------- Original Method ----------
        //return mLayoutAnimationController != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.581 -0400", hash_original_method = "99174EE5664A8F981F50635AC5D4970E", hash_generated_method = "0ECC36E8F4901A7D90656B097B2D8AE6")
    public void startLayoutAnimation() {
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
            requestLayout();
        } //End block
        // ---------- Original Method ----------
        //if (mLayoutAnimationController != null) {
            //mGroupFlags |= FLAG_RUN_ANIMATION;
            //requestLayout();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.581 -0400", hash_original_method = "06C0C7BBCCF19FA4957838E03EE331C8", hash_generated_method = "79A372FB31048C6468EBF3B2058D214E")
    public void scheduleLayoutAnimation() {
        mGroupFlags |= FLAG_RUN_ANIMATION;
        // ---------- Original Method ----------
        //mGroupFlags |= FLAG_RUN_ANIMATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.581 -0400", hash_original_method = "76D54B6C61296EF04870B520A219B087", hash_generated_method = "A1A99CD2FAC536BDE2BCA98A2647D6A3")
    public void setLayoutAnimation(LayoutAnimationController controller) {
        mLayoutAnimationController = controller;
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
        } //End block
        // ---------- Original Method ----------
        //mLayoutAnimationController = controller;
        //if (mLayoutAnimationController != null) {
            //mGroupFlags |= FLAG_RUN_ANIMATION;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.582 -0400", hash_original_method = "BD382B237F964A42E5B6E00A5B3A23FD", hash_generated_method = "4D8827642DE6AC8D6282760D946117D9")
    public LayoutAnimationController getLayoutAnimation() {
        LayoutAnimationController varB4EAC82CA7396A68D541C85D26508E83_299664028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_299664028 = mLayoutAnimationController;
        varB4EAC82CA7396A68D541C85D26508E83_299664028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299664028;
        // ---------- Original Method ----------
        //return mLayoutAnimationController;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.582 -0400", hash_original_method = "91C32769C37DCC6F9F6B4528E4A57D15", hash_generated_method = "DCFC6055130D565BEF9C3742DBA1B948")
    @ViewDebug.ExportedProperty
    public boolean isAnimationCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692982858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_692982858;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.582 -0400", hash_original_method = "DD639E9259A75AF16A9190E263F8776F", hash_generated_method = "DA0DE8E948A805DFDF2642F15694D67A")
    public void setAnimationCacheEnabled(boolean enabled) {
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.585 -0400", hash_original_method = "B9ACD8DAE870BEF4EFBF779A704F6EA0", hash_generated_method = "FDC1FB77FA47D5E00B3ED973E71BE356")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484873241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484873241;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.585 -0400", hash_original_method = "ACB4830CB4940DD4B9F47560853379A8", hash_generated_method = "2E52C8D67EFB5CBD1163C88861A4B0B2")
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
        addTaint(always);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.585 -0400", hash_original_method = "4364C0D051F178DD0E8ADCB73D61750A", hash_generated_method = "FB3CEABC90D3C9FC818761999A048B2F")
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawnWithCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028053934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028053934;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.586 -0400", hash_original_method = "2230D982A122AD23513779DE65F20855", hash_generated_method = "464D9C3133093F65C56F9AC879BFE67D")
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.586 -0400", hash_original_method = "5166D8925764E3FCE51BAB9F8B82BB83", hash_generated_method = "FB74A8253A4431FC2B04B4E90F378840")
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawingOrderEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555472617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555472617;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.586 -0400", hash_original_method = "206BAF2A94AC84475BA4253F279E8423", hash_generated_method = "3801A19E90B0351E485A69316EEDED90")
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
        addTaint(enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.600 -0400", hash_original_method = "DAA9F10BF0EA997E391E78BA1DF6ABEE", hash_generated_method = "CFB6787502AB266B454D58F45F25A34C")
    private void setBooleanFlag(int flag, boolean value) {
        {
            mGroupFlags |= flag;
        } //End block
        {
            mGroupFlags &= ~flag;
        } //End block
        addTaint(value);
        // ---------- Original Method ----------
        //if (value) {
            //mGroupFlags |= flag;
        //} else {
            //mGroupFlags &= ~flag;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.600 -0400", hash_original_method = "944A8E363FECEAC5FA18188B2A82EEA9", hash_generated_method = "F5A522B55D94E9C268277A158F76551A")
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
        @ViewDebug.IntToString(from = PERSISTENT_NO_CACHE,        to = "NONE"),
        @ViewDebug.IntToString(from = PERSISTENT_ANIMATION_CACHE, to = "ANIMATION"),
        @ViewDebug.IntToString(from = PERSISTENT_SCROLLING_CACHE, to = "SCROLLING"),
        @ViewDebug.IntToString(from = PERSISTENT_ALL_CACHES,      to = "ALL")
    })
    public int getPersistentDrawingCache() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140130655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140130655;
        // ---------- Original Method ----------
        //return mPersistentDrawingCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.601 -0400", hash_original_method = "E1A853399F91DFB847E7C25FCC355E2E", hash_generated_method = "8158E6575E5BC3B0CF39A9A0E9990C3F")
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
        // ---------- Original Method ----------
        //mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.602 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "AA5C057237BA7DC47B3B4A34A8566108")
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1962468814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1962468814 = new LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1962468814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1962468814;
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.602 -0400", hash_original_method = "732F05B425275E63BD87B7814AB2A9CD", hash_generated_method = "12848E07ED52BB7E30EBAD980C29647A")
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_541581806 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_541581806 = p;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_541581806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541581806;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.603 -0400", hash_original_method = "378AC11079CE6884A850F340A9660EF3", hash_generated_method = "6BA4A38CF2A3F5849E1ADA7DC64A16D6")
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_326579319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_326579319 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        varB4EAC82CA7396A68D541C85D26508E83_326579319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_326579319;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.718 -0400", hash_original_method = "4EE7CD38DD5C6A89B0A06AD3B67D59FC", hash_generated_method = "C135F5FEED213E0E3349C01F3DD9A2BB")
    @Override
    protected boolean dispatchConsistencyCheck(int consistency) {
        boolean result;
        result = super.dispatchConsistencyCheck(consistency);
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                {
                    boolean var701606913081A4231078EDA1C31F9544_1033670120 = (!children[i].dispatchConsistencyCheck(consistency));
                    result = false;
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402037928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_402037928;
        // ---------- Original Method ----------
        //boolean result = super.dispatchConsistencyCheck(consistency);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //if (!children[i].dispatchConsistencyCheck(consistency)) result = false;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.719 -0400", hash_original_method = "9938C74D91901C257958D174411BCA62", hash_generated_method = "83582C849F6F1A612C6330F8CBFD0834")
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        boolean result;
        result = super.onConsistencyCheck(consistency);
        boolean checkLayout;
        checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        boolean checkDrawing;
        checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    {
                        boolean varC3E3292263C4B7F2461A3F2B810768A5_755921533 = (children[i].getParent() != this);
                        {
                            result = false;
                            android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "View " + children[i] + " has no parent/a parent that is not " + this);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                ViewParent parent;
                parent = getParent();
                {
                    {
                        result = false;
                        android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                                "ViewGroup " + this + " is dirty but its parent is not: " + this);
                    } //End block
                } //End block
            } //End block
        } //End block
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060719752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060719752;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.720 -0400", hash_original_method = "9209AC82FBA5456C7517DF8735B229C2", hash_generated_method = "2B23C01AC5070148676AEA685207EF76")
    @Override
    protected void debug(int depth) {
        super.debug(depth);
        String output;
        {
            output = debugIndent(depth);
            output += "mFocused";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        {
            output = debugIndent(depth);
            output += "{";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                View child;
                child = mChildren[i];
                child.debug(depth + 1);
            } //End block
        } //End collapsed parenthetic
        {
            output = debugIndent(depth);
            output += "}";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        addTaint(depth);
        // ---------- Original Method ----------
        //super.debug(depth);
        //String output;
        //if (mFocused != null) {
            //output = debugIndent(depth);
            //output += "mFocused";
            //Log.d(VIEW_LOG_TAG, output);
        //}
        //if (mChildrenCount != 0) {
            //output = debugIndent(depth);
            //output += "{";
            //Log.d(VIEW_LOG_TAG, output);
        //}
        //int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //View child = mChildren[i];
            //child.debug(depth + 1);
        //}
        //if (mChildrenCount != 0) {
            //output = debugIndent(depth);
            //output += "}";
            //Log.d(VIEW_LOG_TAG, output);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.733 -0400", hash_original_method = "A3819F4FC73AAB74FEBE19CD2546FBCA", hash_generated_method = "FB6AF2F080127B3ED3FA04138A35AB0A")
    public int indexOfChild(View child) {
        int count;
        count = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492774538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_492774538;
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //if (children[i] == child) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.734 -0400", hash_original_method = "7030903D0CFC3D101159E57E177A8D82", hash_generated_method = "8028BCAFEE0D7BD56338627C9B86C5BB")
    public int getChildCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418249254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_418249254;
        // ---------- Original Method ----------
        //return mChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.734 -0400", hash_original_method = "DC55A008910617641F1AE978A0E895D4", hash_generated_method = "BF1D78413327D3B4B83A1F4C52072349")
    public View getChildAt(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_454211450 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_200801508 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_454211450 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_200801508 = mChildren[index];
        addTaint(index);
        View varA7E53CE21691AB073D9660D615818899_1663544934; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1663544934 = varB4EAC82CA7396A68D541C85D26508E83_454211450;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1663544934 = varB4EAC82CA7396A68D541C85D26508E83_200801508;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1663544934.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1663544934;
        // ---------- Original Method ----------
        //if (index < 0 || index >= mChildrenCount) {
            //return null;
        //}
        //return mChildren[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.735 -0400", hash_original_method = "542392FF7FE475C27FCC004AAEE4D21F", hash_generated_method = "765C705B7885BC7451033E037FA0E90A")
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        size = mChildrenCount;
        View[] children;
        children = mChildren;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    measureChild(child, widthMeasureSpec, heightMeasureSpec);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        // ---------- Original Method ----------
        //final int size = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < size; ++i) {
            //final View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) != GONE) {
                //measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.735 -0400", hash_original_method = "9EDA680ED83105527C80B1E780D1BEC7", hash_generated_method = "ED705987885819084CB0BBE7AE7AA412")
    protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec) {
        LayoutParams lp;
        lp = child.getLayoutParams();
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(parentHeightMeasureSpec);
        // ---------- Original Method ----------
        //final LayoutParams lp = child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight, lp.width);
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom, lp.height);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.736 -0400", hash_original_method = "DF0652AA16CC35609E8DBABD1504358F", hash_generated_method = "D647BC1EA7723C5FED7A5091EF2CB569")
    protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        MarginLayoutParams lp;
        lp = (MarginLayoutParams) child.getLayoutParams();
        int childWidthMeasureSpec;
        childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        int childHeightMeasureSpec;
        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(heightUsed);
        // ---------- Original Method ----------
        //final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        //+ widthUsed, lp.width);
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        //+ heightUsed, lp.height);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
        public static int getChildMeasureSpec(int spec, int padding, int childDimension) {
        int specMode = MeasureSpec.getMode(spec);
        int specSize = MeasureSpec.getSize(spec);
        int size = Math.max(0, specSize - padding);
        int resultSize = 0;
        int resultMode = 0;
        switch (specMode) {
        case MeasureSpec.EXACTLY:
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = size;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            }
            break;
        case MeasureSpec.AT_MOST:
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = size;
                resultMode = MeasureSpec.AT_MOST;
            }
            break;
        case MeasureSpec.UNSPECIFIED:
            if (childDimension >= 0) {
                resultSize = childDimension;
                resultMode = MeasureSpec.EXACTLY;
            } else if (childDimension == LayoutParams.MATCH_PARENT) {
                resultSize = 0;
                resultMode = MeasureSpec.UNSPECIFIED;
            } else if (childDimension == LayoutParams.WRAP_CONTENT) {
                resultSize = 0;
                resultMode = MeasureSpec.UNSPECIFIED;
            }
            break;
        }
        return MeasureSpec.makeMeasureSpec(resultSize, resultMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.737 -0400", hash_original_method = "92C99C7B01BA8D70EFEE87F46C0710D1", hash_generated_method = "20F827DDB021B8B88FD693FB75190E6C")
    public void clearDisappearingChildren() {
        {
            mDisappearingChildren.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mDisappearingChildren != null) {
            //mDisappearingChildren.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.750 -0400", hash_original_method = "EFF49544FBF4F5023D4E3259D68E48A6", hash_generated_method = "50CC426C1719042FB3370B0150CE532B")
    private void addDisappearingView(View v) {
        ArrayList<View> disappearingChildren;
        disappearingChildren = mDisappearingChildren;
        {
            disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        } //End block
        disappearingChildren.add(v);
        addTaint(v.getTaint());
        // ---------- Original Method ----------
        //ArrayList<View> disappearingChildren = mDisappearingChildren;
        //if (disappearingChildren == null) {
            //disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        //}
        //disappearingChildren.add(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.751 -0400", hash_original_method = "F02FCA79EB2173CD96A012235B90F902", hash_generated_method = "4C84A770C786E09A80C1B18DDC4EDCCA")
    private void finishAnimatingView(final View view, Animation animation) {
        ArrayList<View> disappearingChildren;
        disappearingChildren = mDisappearingChildren;
        {
            {
                boolean var469F1AC6EE958AE18E6E98146553974E_1466531606 = (disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
                    view.clearAnimation();
                    mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var43425F3101AF26F025C7208DDDA7464F_493664190 = (animation != null && !animation.getFillAfter());
            {
                view.clearAnimation();
            } //End block
        } //End collapsed parenthetic
        {
            view.onAnimationEnd();
            view.mPrivateFlags &= ~ANIMATION_STARTED;
            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
        } //End block
        addTaint(view.getTaint());
        addTaint(animation.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.752 -0400", hash_original_method = "663B00ABF4B2F32B3DAAC91DDA64BE32", hash_generated_method = "0267F1F8AAE3D9953BA7373988EE6AAF")
     boolean isViewTransitioning(View view) {
        boolean var2C744AD4F2EA7A3D608A882D8C3D4FED_180456173 = ((mTransitioningViews != null && mTransitioningViews.contains(view)));
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332065688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_332065688;
        // ---------- Original Method ----------
        //return (mTransitioningViews != null && mTransitioningViews.contains(view));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.752 -0400", hash_original_method = "3DD17A0BC43336D376B4C3E60ACB3106", hash_generated_method = "85CC65A7D997881440497C356D5A7C36")
    public void startViewTransition(View view) {
        {
            boolean varA2172F77206C7C024C24C289D1254F67_732689481 = (view.mParent == this);
            {
                {
                    mTransitioningViews = new ArrayList<View>();
                } //End block
                mTransitioningViews.add(view);
            } //End block
        } //End collapsed parenthetic
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //if (view.mParent == this) {
            //if (mTransitioningViews == null) {
                //mTransitioningViews = new ArrayList<View>();
            //}
            //mTransitioningViews.add(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.775 -0400", hash_original_method = "A78E74DD3F17BBF76B7245787E00733D", hash_generated_method = "3C66252F2A7FD3A9D2D299340DB86436")
    public void endViewTransition(View view) {
        {
            mTransitioningViews.remove(view);
            ArrayList<View> disappearingChildren;
            disappearingChildren = mDisappearingChildren;
            {
                boolean var8B6CC6761C9BD4F7C4819DDB2B1B39CF_1261777379 = (disappearingChildren != null && disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        boolean var8D124A8F477EC519F378FF84BB0D8AF5_45398332 = (mVisibilityChangingChildren != null &&
                        mVisibilityChangingChildren.contains(view));
                        {
                            mVisibilityChangingChildren.remove(view);
                        } //End block
                        {
                            {
                                view.dispatchDetachedFromWindow();
                            } //End block
                            {
                                view.mParent = null;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.776 -0400", hash_original_method = "90F24CF973A15FCB3D8EF936857F7660", hash_generated_method = "444D16351828FCDB9095A34770CFB7EF")
    @Override
    public boolean gatherTransparentRegion(Region region) {
        boolean meOpaque;
        meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        super.gatherTransparentRegion(region);
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent;
        noneOfTheChildrenAreTransparent = true;
        {
            int i;
            i = 0;
            {
                View child;
                child = children[i];
                {
                    boolean var589A259560F2788DFC2988B1FA33F37B_871777136 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                    {
                        {
                            boolean var02F3557A74971374C057D08F3D583563_1299608094 = (!child.gatherTransparentRegion(region));
                            {
                                noneOfTheChildrenAreTransparent = false;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587874986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587874986;
        // ---------- Original Method ----------
        //final boolean meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        //if (meOpaque && region == null) {
            //return true;
        //}
        //super.gatherTransparentRegion(region);
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //boolean noneOfTheChildrenAreTransparent = true;
        //for (int i = 0; i < count; i++) {
            //final View child = children[i];
            //if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) {
                //if (!child.gatherTransparentRegion(region)) {
                    //noneOfTheChildrenAreTransparent = false;
                //}
            //}
        //}
        //return meOpaque || noneOfTheChildrenAreTransparent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.776 -0400", hash_original_method = "5C4070054C131245FD376376D5198B5B", hash_generated_method = "C142B0C1975153866B5684F6D72A1D82")
    public void requestTransparentRegion(View child) {
        {
            child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            {
                mParent.requestTransparentRegion(this);
            } //End block
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if (child != null) {
            //child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            //if (mParent != null) {
                //mParent.requestTransparentRegion(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.777 -0400", hash_original_method = "055C0C5E94DF77352535F2463E2E2F92", hash_generated_method = "C1C2536B13AA1A12F88FAD7F9E26DC4E")
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        boolean done;
        done = super.fitSystemWindows(insets);
        {
            int count;
            count = mChildrenCount;
            View[] children;
            children = mChildren;
            {
                int i;
                i = 0;
                {
                    done = children[i].fitSystemWindows(insets);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(insets.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659976325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659976325;
        // ---------- Original Method ----------
        //boolean done = super.fitSystemWindows(insets);
        //if (!done) {
            //final int count = mChildrenCount;
            //final View[] children = mChildren;
            //for (int i = 0; i < count; i++) {
                //done = children[i].fitSystemWindows(insets);
                //if (done) {
                    //break;
                //}
            //}
        //}
        //return done;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.783 -0400", hash_original_method = "B3B3B12C071F8F31617EDB75C1351CBC", hash_generated_method = "4A6752E31844C25042DC1E75285BD114")
    public Animation.AnimationListener getLayoutAnimationListener() {
        Animation.AnimationListener varB4EAC82CA7396A68D541C85D26508E83_1586813020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1586813020 = mAnimationListener;
        varB4EAC82CA7396A68D541C85D26508E83_1586813020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1586813020;
        // ---------- Original Method ----------
        //return mAnimationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.783 -0400", hash_original_method = "309790593767800D49B3C7FD0CAB3F32", hash_generated_method = "93E6DA96DBB4248586F6ACA5F386E731")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
            } //End block
            View[] children;
            children = mChildren;
            int count;
            count = mChildrenCount;
            {
                int i;
                i = 0;
                {
                    View child;
                    child = children[i];
                    {
                        child.refreshDrawableState();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if ((mGroupFlags & FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE) != 0) {
            //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
                //throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        //+ " child has duplicateParentState set to true");
            //}
            //final View[] children = mChildren;
            //final int count = mChildrenCount;
            //for (int i = 0; i < count; i++) {
                //final View child = children[i];
                //if ((child.mViewFlags & DUPLICATE_PARENT_STATE) != 0) {
                    //child.refreshDrawableState();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.784 -0400", hash_original_method = "9BFEBEB244ACA3F0CF8B6DCD826B4034", hash_generated_method = "4A7E546BECC18412ED1C19A1FFFDA99F")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        View[] children;
        children = mChildren;
        int count;
        count = mChildrenCount;
        {
            int i;
            i = 0;
            {
                children[i].jumpDrawablesToCurrentState();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].jumpDrawablesToCurrentState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.785 -0400", hash_original_method = "0411A3FE715B4530882EE6CBB1252DCB", hash_generated_method = "B4083E3149B9389D2629A875C425766F")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_1922501940 = (super.onCreateDrawableState(extraSpace));
        } //End block
        int need;
        need = 0;
        int n;
        n = getChildCount();
        {
            int i;
            i = 0;
            {
                int[] childState;
                childState = getChildAt(i).getDrawableState();
                {
                    need += childState.length;
                } //End block
            } //End block
        } //End collapsed parenthetic
        int[] state;
        state = super.onCreateDrawableState(extraSpace + need);
        {
            int i;
            i = 0;
            {
                int[] childState;
                childState = getChildAt(i).getDrawableState();
                {
                    state = mergeDrawableStates(state, childState);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1499081796 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1499081796;
        // ---------- Original Method ----------
        //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) == 0) {
            //return super.onCreateDrawableState(extraSpace);
        //}
        //int need = 0;
        //int n = getChildCount();
        //for (int i = 0; i < n; i++) {
            //int[] childState = getChildAt(i).getDrawableState();
            //if (childState != null) {
                //need += childState.length;
            //}
        //}
        //int[] state = super.onCreateDrawableState(extraSpace + need);
        //for (int i = 0; i < n; i++) {
            //int[] childState = getChildAt(i).getDrawableState();
            //if (childState != null) {
                //state = mergeDrawableStates(state, childState);
            //}
        //}
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.785 -0400", hash_original_method = "1481B38AF6385F8F98E444294398E1C4", hash_generated_method = "454176A93789D7000F1E7562F2ADE8F8")
    public void setAddStatesFromChildren(boolean addsStates) {
        {
            mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        } //End block
        {
            mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        } //End block
        refreshDrawableState();
        addTaint(addsStates);
        // ---------- Original Method ----------
        //if (addsStates) {
            //mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        //} else {
            //mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        //}
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.786 -0400", hash_original_method = "026C4CEB09DFE602F5C11A5652FC3C1F", hash_generated_method = "97DAEBEC4DA1C5DFFD0E4BB6632DCE9F")
    public boolean addStatesFromChildren() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007250874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007250874;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.786 -0400", hash_original_method = "F32408C60FA79535F6423CE68328A516", hash_generated_method = "6393F6118060209F17EDFB9E35B3E982")
    public void childDrawableStateChanged(View child) {
        {
            refreshDrawableState();
        } //End block
        addTaint(child.getTaint());
        // ---------- Original Method ----------
        //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.786 -0400", hash_original_method = "CCA9986B4D287F2F006BAE825941ECAA", hash_generated_method = "28A9F6F2C654D2AA771EAFD01C6ECAA2")
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        mAnimationListener = animationListener;
        // ---------- Original Method ----------
        //mAnimationListener = animationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.804 -0400", hash_original_method = "8473FDA62EFB348A51ABA227E5F80648", hash_generated_method = "732DB274AC83F1C5356B9378AA5C84C6")
    public void requestTransitionStart(LayoutTransition transition) {
        ViewRootImpl viewAncestor;
        viewAncestor = getViewRootImpl();
        {
            viewAncestor.requestTransitionStart(transition);
        } //End block
        addTaint(transition.getTaint());
        // ---------- Original Method ----------
        //ViewRootImpl viewAncestor = getViewRootImpl();
        //if (viewAncestor != null) {
            //viewAncestor.requestTransitionStart(transition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.806 -0400", hash_original_method = "438FE65F3DA47A9BB347952B8A6B02CD", hash_generated_method = "B7B1C9A1EAAFAFAB86D49D57EB868618")
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean varB5612BFB22B66951C85039D6A4ADA2D6_566479242 = (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT);
                    {
                        child.resetResolvedLayoutDirection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.resetResolvedLayoutDirection();
        //final int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //if (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT) {
                //child.resetResolvedLayoutDirection();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.810 -0400", hash_original_method = "83014321BD6411A92FC299225A8B4B68", hash_generated_method = "DE8B62B56417DE28B29A373674245D5C")
    @Override
    protected void resetResolvedTextDirection() {
        super.resetResolvedTextDirection();
        int count;
        count = getChildCount();
        {
            int i;
            i = 0;
            {
                View child;
                child = getChildAt(i);
                {
                    boolean var97DAD7DCB6178A82512069CD3DA52554_218029352 = (child.getTextDirection() == TEXT_DIRECTION_INHERIT);
                    {
                        child.resetResolvedTextDirection();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.resetResolvedTextDirection();
        //final int count = getChildCount();
        //for (int i = 0; i < count; i++) {
            //final View child = getChildAt(i);
            //if (child.getTextDirection() == TEXT_DIRECTION_INHERIT) {
                //child.resetResolvedTextDirection();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.820 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "F9DD39F2051435267A5931807471C020")
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673955220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673955220;
        // ---------- Original Method ----------
        //return true;
    }

    
    public static class LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.820 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "E98E615247D406FD5B1F2C460414CA00")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.820 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "154449EB0055FED002CA8F596F81E1FB")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.820 -0400", hash_original_field = "32A967A061019BB85A555A08521F45C3", hash_generated_field = "A8465771210F0A9A6D04062D459407C3")

        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.821 -0400", hash_original_method = "15AB37D81442EE27D75B1677A2391AE7", hash_generated_method = "6F5C7C4E31A68D1707C8D541E89092D6")
        public  LayoutParams(Context c, AttributeSet attrs) {
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            //setBaseAttributes(a,
                    //R.styleable.ViewGroup_Layout_layout_width,
                    //R.styleable.ViewGroup_Layout_layout_height);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.821 -0400", hash_original_method = "25BDC30F3D80C9CBE1EB5EBCEE37F7CB", hash_generated_method = "61CBE5F83CA15EA93BA315DE7814BEC6")
        public  LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
            // ---------- Original Method ----------
            //this.width = width;
            //this.height = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.822 -0400", hash_original_method = "2BA3A180B45B8CE1CC5399F5BB84EEDE", hash_generated_method = "0F6B2AA4452B28B14B0088D4B6A2DB9F")
        public  LayoutParams(LayoutParams source) {
            this.width = source.width;
            this.height = source.height;
            // ---------- Original Method ----------
            //this.width = source.width;
            //this.height = source.height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.822 -0400", hash_original_method = "6916C65008FD05252A1C29A02882BE94", hash_generated_method = "45AC97A074BFD055B1BD45042F079476")
          LayoutParams() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.832 -0400", hash_original_method = "22F495DEF56CC03879FA6664450D6ACC", hash_generated_method = "E5FD1A97DBF05843B1262AD7B2A89C11")
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
            // ---------- Original Method ----------
            //width = a.getLayoutDimension(widthAttr, "layout_width");
            //height = a.getLayoutDimension(heightAttr, "layout_height");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.832 -0400", hash_original_method = "CE6F1B4BC3F83182FFE42E3A8827DEEC", hash_generated_method = "6D86F89DE956B69559B0A86CF3A2E3CD")
        protected void resolveWithDirection(int layoutDirection) {
            addTaint(layoutDirection);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.833 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "1CB4E707D2AB865419A1F4DA8EA7580B")
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_2001361370 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2001361370 = output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2001361370.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2001361370;
            // ---------- Original Method ----------
            //return output + "ViewGroup.LayoutParams={ width="
                    //+ sizeToString(width) + ", height=" + sizeToString(height) + " }";
        }

        
                protected static String sizeToString(int size) {
            if (size == WRAP_CONTENT) {
                return "wrap-content";
            }
            if (size == MATCH_PARENT) {
                return "match-parent";
            }
            return String.valueOf(size);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "B333156949B5FAA535F7E8DBDBF0D617", hash_generated_field = "B60A6144A316A76818E3F37ADD9B0E2B")

        @SuppressWarnings({"UnusedDeclaration"})
        @Deprecated
        public static final int FILL_PARENT = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "AB0F2BFD833859D7E6AF5D2D478DFEC1", hash_generated_field = "035E0815824268EA10F24139068915CD")

        public static final int MATCH_PARENT = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "331393B598CE796434D861237AC6E1F4", hash_generated_field = "33E013A8F3F409595C02468C7E3CA7AB")

        public static final int WRAP_CONTENT = -2;
    }


    
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "1419D880ADE86E149ABAFCB226F6B662", hash_generated_field = "B21196B63DA6FA861C6C44CFE61E0207")

        @ViewDebug.ExportedProperty(category = "layout") public int leftMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "F14E99EDBAA6E54CB43B2B4C3D7084CF", hash_generated_field = "C75872B6D23692F5C29153B6138A7705")

        @ViewDebug.ExportedProperty(category = "layout") public int topMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "A5E95C57F057CCC5814DC8DB40E9120B", hash_generated_field = "8215B4F64E53D75A1F217C65CCA861B0")

        @ViewDebug.ExportedProperty(category = "layout") public int rightMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "6B087389EB08EE42774D6432387E8C9A", hash_generated_field = "C9EC61B6AE185D3F68BEDBB7A02A577D")

        @ViewDebug.ExportedProperty(category = "layout") public int bottomMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "77BD249F949CA3D95A4C77016CC05819", hash_generated_field = "6BB5C7CF92CA34A599866F03AD4A8600")

        @ViewDebug.ExportedProperty(category = "layout") protected int startMargin = DEFAULT_RELATIVE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.834 -0400", hash_original_field = "FF17DEDAB668A62D7F93257CCC172E72", hash_generated_field = "0A4C2937E1B0718BA14E68C5B33ABD23")

        @ViewDebug.ExportedProperty(category = "layout") protected int endMargin = DEFAULT_RELATIVE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.852 -0400", hash_original_method = "10E5D625CF55B3D944D3843050E826C6", hash_generated_method = "40BEA9B2750D9D9DECC7DEE5AF4E23CD")
        public  MarginLayoutParams(Context c, AttributeSet attrs) {
            super();
            TypedArray a;
            a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_MarginLayout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_MarginLayout_layout_width,
                    R.styleable.ViewGroup_MarginLayout_layout_height);
            int margin;
            margin = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.ViewGroup_MarginLayout_layout_margin, -1);
            {
                leftMargin = margin;
                topMargin = margin;
                rightMargin= margin;
                bottomMargin = margin;
            } //End block
            {
                leftMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginLeft, 0);
                topMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginTop, 0);
                rightMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginRight, 0);
                bottomMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginBottom, 0);
                startMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginStart, DEFAULT_RELATIVE);
                endMargin = a.getDimensionPixelSize(
                        R.styleable.ViewGroup_MarginLayout_layout_marginEnd, DEFAULT_RELATIVE);
            } //End block
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.852 -0400", hash_original_method = "4C1C9EAF9AFA2E58AB980E97DFB147EB", hash_generated_method = "DFA5758A46EE2AF6635DD5EE5E53A838")
        public  MarginLayoutParams(int width, int height) {
            super(width, height);
            addTaint(width);
            addTaint(height);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.854 -0400", hash_original_method = "55868F7F983C11B537A625BA756EE7CC", hash_generated_method = "7035DFAA2CA4AF1F793362EF7D0AFEFE")
        public  MarginLayoutParams(MarginLayoutParams source) {
            this.width = source.width;
            this.height = source.height;
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
            this.startMargin = source.startMargin;
            this.endMargin = source.endMargin;
            // ---------- Original Method ----------
            //this.width = source.width;
            //this.height = source.height;
            //this.leftMargin = source.leftMargin;
            //this.topMargin = source.topMargin;
            //this.rightMargin = source.rightMargin;
            //this.bottomMargin = source.bottomMargin;
            //this.startMargin = source.startMargin;
            //this.endMargin = source.endMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.855 -0400", hash_original_method = "E2A57B11F6C8009C3B5E4EDAD0277412", hash_generated_method = "54FCC1DF48420A5FAD38AF8300540761")
        public  MarginLayoutParams(LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.861 -0400", hash_original_method = "A7CFD8E9AA47AE278733C57B8CF5503F", hash_generated_method = "E9FA91064C566B35F37192AF7E41F6DA")
        public void setMargins(int left, int top, int right, int bottom) {
            leftMargin = left;
            topMargin = top;
            rightMargin = right;
            bottomMargin = bottom;
            // ---------- Original Method ----------
            //leftMargin = left;
            //topMargin = top;
            //rightMargin = right;
            //bottomMargin = bottom;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.861 -0400", hash_original_method = "F5A63690A2F55CE5C4D6B1F24495E028", hash_generated_method = "142C3C1A10C4FC10B505CFEA80893BBF")
        public void setMarginsRelative(int start, int top, int end, int bottom) {
            startMargin = start;
            topMargin = top;
            endMargin = end;
            bottomMargin = bottom;
            // ---------- Original Method ----------
            //startMargin = start;
            //topMargin = top;
            //endMargin = end;
            //bottomMargin = bottom;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.865 -0400", hash_original_method = "A60FB56334BFE35432A89BE021472DEF", hash_generated_method = "C03D0EB61E84078D2C451204263865EE")
        public int getMarginStart() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340510962 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340510962;
            // ---------- Original Method ----------
            //return startMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.878 -0400", hash_original_method = "2B74CF4F3396E75552B1A46DF3D4BFD7", hash_generated_method = "24440EEC5F6FED1ABF3EE1300A60A320")
        public int getMarginEnd() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648872915 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648872915;
            // ---------- Original Method ----------
            //return endMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.885 -0400", hash_original_method = "C9EA583BDFA2583A2B96D706C959CDBC", hash_generated_method = "6D0C248B808F7D1F3825A320705EC75B")
        public boolean isMarginRelative() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928648271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_928648271;
            // ---------- Original Method ----------
            //return (startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.886 -0400", hash_original_method = "25B74C4F994FDDCB83271E7B2F9BDDEE", hash_generated_method = "7CFCDD8EC476530E2206429F2D5CDA8F")
        @Override
        protected void resolveWithDirection(int layoutDirection) {
            //Begin case View.LAYOUT_DIRECTION_RTL 
            leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
            //End case View.LAYOUT_DIRECTION_RTL 
            //Begin case View.LAYOUT_DIRECTION_RTL 
            rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
            //End case View.LAYOUT_DIRECTION_RTL 
            //Begin case View.LAYOUT_DIRECTION_LTR default 
            leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
            //End case View.LAYOUT_DIRECTION_LTR default 
            //Begin case View.LAYOUT_DIRECTION_LTR default 
            rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
            //End case View.LAYOUT_DIRECTION_LTR default 
            addTaint(layoutDirection);
            // ---------- Original Method ----------
            //switch(layoutDirection) {
                //case View.LAYOUT_DIRECTION_RTL:
                    //leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
                    //rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
                    //break;
                //case View.LAYOUT_DIRECTION_LTR:
                //default:
                    //leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
                    //rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
                    //break;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.886 -0400", hash_original_field = "9719E4AAD4FACA3BF0499294B0F32D31", hash_generated_field = "E93A5A523540F903B8815E112F84F1A8")

        static private int DEFAULT_RELATIVE = Integer.MIN_VALUE;
    }


    
    private static final class TouchTarget {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.886 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.886 -0400", hash_original_field = "F1144C2E88061517D095C11872B4C482", hash_generated_field = "530D731D7D2EE140B1D1AF75DBF79B1B")

        public int pointerIdBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.886 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "DC720CE01C505E3F8C1AAF24F8078F0D")

        public TouchTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.887 -0400", hash_original_method = "5259B67E5A6C02FEFA0EB82F43285FB5", hash_generated_method = "B32A208B999EE5B494ADD3A3C0776E12")
        private  TouchTarget() {
            // ---------- Original Method ----------
        }

        
                public static TouchTarget obtain(View child, int pointerIdBits) {
            final TouchTarget target;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    target = new TouchTarget();
                } else {
                    target = sRecycleBin;
                    sRecycleBin = target.next;
                     sRecycledCount--;
                    target.next = null;
                }
            }
            target.child = child;
            target.pointerIdBits = pointerIdBits;
            return target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "AB54E1D51CAE4173450A000EBCA7A06A")
        public void recycle() {
            {
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } //End block
                {
                    next = null;
                } //End block
                child = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized (sRecycleLock) {
                //if (sRecycledCount < MAX_RECYCLED) {
                    //next = sRecycleBin;
                    //sRecycleBin = this;
                    //sRecycledCount += 1;
                //} else {
                    //next = null;
                //}
                //child = null;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "A72E5077CE400FBB95D5EB6C205E6CD6", hash_generated_field = "E11D98AD5CB56E9C39914463ADFAD2C7")

        private static int MAX_RECYCLED = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "5E099B93496A959515A0264634CA0534", hash_generated_field = "1ECE87FACBA929F58D305CE4E80AB9FD")

        private static Object sRecycleLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "CCE02A7FF8CA5926C887F8CC8CC579A5", hash_generated_field = "E0E2F52EC1657E89F88CB94D6B19500A")

        private static TouchTarget sRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "E80DA3258C0105DF400606DD49462342", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "1B6BEB46ACAD52F4B6C908932D9CBB35", hash_generated_field = "5D0EA96D1B8E6DB25F736A1FB6B6D10D")

        public static final int ALL_POINTER_IDS = -1;
    }


    
    private static final class HoverTarget {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.896 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "3B1636D6CF959CF92CBD4352E6CBCE49")

        public HoverTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.897 -0400", hash_original_method = "5539B57739929C533DCF7E732D22C4F2", hash_generated_method = "726B690AE07312555BAF165F7E5F62F6")
        private  HoverTarget() {
            // ---------- Original Method ----------
        }

        
                public static HoverTarget obtain(View child) {
            final HoverTarget target;
            synchronized (sRecycleLock) {
                if (sRecycleBin == null) {
                    target = new HoverTarget();
                } else {
                    target = sRecycleBin;
                    sRecycleBin = target.next;
                     sRecycledCount--;
                    target.next = null;
                }
            }
            target.child = child;
            return target;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "AB54E1D51CAE4173450A000EBCA7A06A")
        public void recycle() {
            {
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } //End block
                {
                    next = null;
                } //End block
                child = null;
            } //End block
            // ---------- Original Method ----------
            //synchronized (sRecycleLock) {
                //if (sRecycledCount < MAX_RECYCLED) {
                    //next = sRecycleBin;
                    //sRecycleBin = this;
                    //sRecycledCount += 1;
                //} else {
                    //next = null;
                //}
                //child = null;
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "A72E5077CE400FBB95D5EB6C205E6CD6", hash_generated_field = "E11D98AD5CB56E9C39914463ADFAD2C7")

        private static int MAX_RECYCLED = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "5E099B93496A959515A0264634CA0534", hash_generated_field = "1ECE87FACBA929F58D305CE4E80AB9FD")

        private static Object sRecycleLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "CCE02A7FF8CA5926C887F8CC8CC579A5", hash_generated_field = "9BF05FD9D6504C47D3CD94A8F3200F82")

        private static HoverTarget sRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "E80DA3258C0105DF400606DD49462342", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
    }


    
    public interface OnHierarchyChangeListener {
        
        void onChildViewAdded(View parent, View child);

        
        void onChildViewRemoved(View parent, View child);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "093C1742536C628A897749D49426A6D3", hash_generated_field = "D6F2A5BD835CDBD2743CEAD35F3CCC65")

    private static int FLAG_CLIP_CHILDREN = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "CB5125EA3850C10828D646E68628DA9A", hash_generated_field = "88052A21B6C31ACBCF0EBCF710AEBD90")

    private static int FLAG_CLIP_TO_PADDING = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "370A6DEBEC95348BA1E5248C135A5EC8", hash_generated_field = "29D7E205035DE9A88DB2142BC9D9D660")

    private static int FLAG_INVALIDATE_REQUIRED = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "5195C625EE4E9D8027AD632CFE4CCD01", hash_generated_field = "5B1AA890AE2B4B9F6500CE681FE8A89A")

    private static int FLAG_RUN_ANIMATION = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "83472C31AED9766B248D82ED2D074D5C", hash_generated_field = "267D68912DB1DA3353A51537F05658B5")

    private static int FLAG_ANIMATION_DONE = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "08A72EA908064A83313796C485ADACDD", hash_generated_field = "5A00D0E2F602F4830187A7D75D14E887")

    private static int FLAG_PADDING_NOT_NULL = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "CAC36ACA9ED784B231117CB39D86A384", hash_generated_field = "8048CD7650597CC0952DD6F753D0DA1E")

    private static int FLAG_ANIMATION_CACHE = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "001D3068790E7E549A48976047700A5A", hash_generated_field = "A45DA42DFC07F025D2912C723AF4885C")

    private static int FLAG_OPTIMIZE_INVALIDATE = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "296952AC48605AFEFDBD310F71840975", hash_generated_field = "CF694329C51BF5456F907AEA7DB2459E")

    private static int FLAG_CLEAR_TRANSFORMATION = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "80E59BFDFA55701D5C3008682DE14EA5", hash_generated_field = "3EA954A8831C5D76869F09662291C991")

    private static int FLAG_NOTIFY_ANIMATION_LISTENER = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "174D3C1D51E7CCF138A4F39DBF69B0C9", hash_generated_field = "3BF978F41C58D3FA1BE5728DF863666C")

    protected static int FLAG_USE_CHILD_DRAWING_ORDER = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.898 -0400", hash_original_field = "880E7482176EB8093E6CCCD736E4B0A2", hash_generated_field = "6A4CD003CE61B909A7260FBE8ADE80A4")

    protected static int FLAG_SUPPORT_STATIC_TRANSFORMATIONS = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.909 -0400", hash_original_field = "064633D9895C1F26598F928072EA6CA8", hash_generated_field = "3ACC7473B5F86B327970AC2A33799457")

    private static int FLAG_ALPHA_LOWER_THAN_ONE = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.909 -0400", hash_original_field = "85691F00B62FE4647557EF0CCD322E28", hash_generated_field = "52A4C7ED4D667A69F2B8DF5730A4969F")

    private static int FLAG_ADD_STATES_FROM_CHILDREN = 0x2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.910 -0400", hash_original_field = "86601B54A4C45A57269BA0D57322442D", hash_generated_field = "AD212EAD0754E3438C487BF4548275F6")

    private static int FLAG_ALWAYS_DRAWN_WITH_CACHE = 0x4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.911 -0400", hash_original_field = "937D116FF0D4A7910D727BBF47DB86B2", hash_generated_field = "79EF3E2BA1733FCF4F0810179AC20140")

    private static int FLAG_CHILDREN_DRAWN_WITH_CACHE = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.911 -0400", hash_original_field = "7F0A72234EA920F255CBA067C2A1B93D", hash_generated_field = "12D7521089A4641BE56B09A9CFC88C53")

    private static int FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.911 -0400", hash_original_field = "548AF4B07DEB40F98E8EEB7BB82E33C6", hash_generated_field = "64B23BAF07F018DDDDF252F1D44DB75E")

    private static int FLAG_MASK_FOCUSABILITY = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.912 -0400", hash_original_field = "90E92091E4A64B96AC11794AC6BCE1ED", hash_generated_field = "BD96D757F41BA0229D767BD84AB7642D")

    public static final int FOCUS_BEFORE_DESCENDANTS = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "1AB4D8C2E6C0EB94C5E3D81186225A46", hash_generated_field = "CD9C40718F19AA89DFB0F2B888272D33")

    public static final int FOCUS_AFTER_DESCENDANTS = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "474F04A27118AAE5C55DBA97D250DCD9", hash_generated_field = "5CE7A6F853A9C0B36CFE406D68F2F862")

    public static final int FOCUS_BLOCK_DESCENDANTS = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "550A1DD8DB80915C8B1B187E90B5E0B9", hash_generated_field = "62DD782AB0DD898CBECC7A04CF6EFCC2")

    private static int[] DESCENDANT_FOCUSABILITY_FLAGS = {FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS,
                    FOCUS_BLOCK_DESCENDANTS};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "5666C3D62FF07B134BC6617531F77464", hash_generated_field = "05CA990BC9E852E8A7EE7BF7EF9D6115")

    protected static int FLAG_DISALLOW_INTERCEPT = 0x80000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "DDACBD94DD1CDF62E81361791F53DA87", hash_generated_field = "BEA976BEC6FAA09FA27952C7DF356327")

    private static int FLAG_SPLIT_MOTION_EVENTS = 0x200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "2D700E90C54045822898F506782662B3", hash_generated_field = "12A73FD8E5097D670ED11FE1420FD5A3")

    private static int FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW = 0x400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "C52B883FD05C47AA69FDA6E1F22F0ABB", hash_generated_field = "BC2E177DD2A895934D9FCE5C86AE3C65")

    public static final int PERSISTENT_NO_CACHE = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "67A61EDB48651F5C036B3346FBE5FAFA", hash_generated_field = "1F0A8E4978079659E6E30C2BA18617E8")

    public static final int PERSISTENT_ANIMATION_CACHE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "1EF42E9887D0EA5F316904FD3B9AB251", hash_generated_field = "F00BF7A2C158735CE5A6638A662B5EBF")

    public static final int PERSISTENT_SCROLLING_CACHE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.919 -0400", hash_original_field = "7C696FAA76DB6EC3A8EDD78551D1B467", hash_generated_field = "8CC8945E637E7193338DBF39D6D6A84A")

    public static final int PERSISTENT_ALL_CACHES = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.920 -0400", hash_original_field = "BC7469E2246471A573E63558ACC0C8ED", hash_generated_field = "32849DB89A345214FA4AC08C0781EC6B")

    protected static int CLIP_TO_PADDING_MASK = FLAG_CLIP_TO_PADDING | FLAG_PADDING_NOT_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.920 -0400", hash_original_field = "7A53C3B2EA29B34F35552312F91C5969", hash_generated_field = "F1B1BA8EDA98E7A3BFE1DD9334DE15EE")

    private static int CHILD_LEFT_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.920 -0400", hash_original_field = "D45F5D9EC95E07AC6931C434FF8D7294", hash_generated_field = "31685E8E53B9761A0DF5AC13FAD1A70C")

    private static int CHILD_TOP_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.920 -0400", hash_original_field = "89DFE4348E5AA246A9F1E32325C98608", hash_generated_field = "7E6DD594901BD23BCDBDBDF05F73A39A")

    private static int ARRAY_INITIAL_CAPACITY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:56.920 -0400", hash_original_field = "4333C5B7C7DF62BB1C21C6CF44CB4E1E", hash_generated_field = "BF6BDF0352A3D8869B1B2D817479B363")

    private static int ARRAY_CAPACITY_INCREMENT = 12;
}

