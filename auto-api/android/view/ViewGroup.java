package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "696495B05623D58D869C5D15A256902B", hash_generated_field = "99875A35D62FD939298A601A9F7DF5FD")

    protected ArrayList<View> mDisappearingChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "3F7DB39F9660F69EF1A4D273C271814A", hash_generated_field = "506B0E011CD70741D050BF2EE44FE356")

    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "42E518F9E3515DBB9C4BA0AD23CBAC61", hash_generated_field = "A4B16D4F5B8759534D19F2BBB80216EB")

    private View mFocused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "16F4F06A930B1D3A94B992BE8E780178", hash_generated_field = "89EF5CAB67B25E4FDD40BCDFBB6E3EB9")

    private final Transformation mChildTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "D8A784EF03152F38795B78B59E6687CD", hash_generated_field = "0E43FE3464FE8F2B4A13FAF73F9FFA99")

    private RectF mInvalidateRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "65CA6A1D57BFCD4414AFF3BF15E316A5", hash_generated_field = "1A258D5E9E5687B9DA556AF87EE040D3")

    private Transformation mInvalidationTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "3DDC2DD80BBDAAFF3D7748437C0F92DB", hash_generated_field = "278869ACFDD76183C8D171CD9E8010F4")

    private View mCurrentDragView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "70F326C41A2A7C4A33E4EBB382B916EA", hash_generated_field = "4260837AC154FE88E7ECE0B0D933BD38")

    private DragEvent mCurrentDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "6E6AEB257AE7602303150F5A2E06101C", hash_generated_field = "7C6A42655A4DC2D4BF46B4F9A41E01BC")

    private HashSet<View> mDragNotifiedChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "CB06E61812573C16C11AC1F5ED8FAC4D", hash_generated_field = "B40634C8F85313CD4FF766F9BA270DF1")

    private boolean mChildAcceptsDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "713A58D821D69EADC7B8400333D2114D", hash_generated_field = "ABDC85F272489DAB145CE0275A2DB3B6")

    private final PointF mLocalPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "EE254A0D1FB9B91AC6E612916399854B", hash_generated_field = "9303037DA96D3F26E2BF546299C3658E")

    private LayoutAnimationController mLayoutAnimationController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "D7ED5F2F2BB342E46F91D9B806A50C8F", hash_generated_field = "FE6F2E4A779D16D38F8BBFCAC393C76B")

    private Animation.AnimationListener mAnimationListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "26BDCBDC864B748F53386DFAE0C033B2", hash_generated_field = "E7D785992A22A7F38809AD101B810276")

    private TouchTarget mFirstTouchTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "2872768B4C01F416A1F5754F14B30B55", hash_generated_field = "A29A2DA0312D9EE090BC48B3458B8632")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private long mLastTouchDownTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.942 -0400", hash_original_field = "E1651BDE01D340FDFEDFC6ECD609DEA2", hash_generated_field = "8B2D270E66117CC663F28DDCFB87BA4F")

    @ViewDebug.ExportedProperty(category = "events") private int mLastTouchDownIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "8B01400E27E5A26EAE9410E214CEC4CB", hash_generated_field = "4CA82440F2A0B548108575FF9859A086")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "AEEE8AEDA84C3DC240ABF11CCEAF69BC", hash_generated_field = "F4574986D2BBC08122BD509305467BC4")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "7925BD3459BCDD5EDBDA3820A951C7D1", hash_generated_field = "F6A706AD2BA485262D480B431AA08D80")

    private HoverTarget mFirstHoverTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "F16BAA76122227EAC1FA8071FFD9D031", hash_generated_field = "6FD02C8ECD5E4353E1EEA59D2D252B74")

    private boolean mHoveredSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "A5BB3DDB7F77A548994B517D14DA3459", hash_generated_field = "0ABD90AE9099E56BCD9A23A2BFDD9586")

    protected int mGroupFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "CFD9A5A2BA3F2274ECC022BF6DB661C8", hash_generated_field = "5B77DDDB5E53D20BC8C371537F9D6155")

    protected int mPersistentDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "7CF7769EE949355835082685E98C8324")

    private View[] mChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "FD8A8C0C5238F97B65F22614467D44BD", hash_generated_field = "FA5DB817C33D36E210708492AC611D2B")

    private boolean mLayoutSuppressed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "A5034A70A83D3C81CEC027BDCAA166D7", hash_generated_field = "A777A0928665A4F1E7F4EF71A2259E60")

    private int mChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "E8B33C20BEE8C2EC1E2F75E228534E68", hash_generated_field = "4229E0DF467153CF57F65AC95B02B5E6")

    private Paint mCachePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "E5047FAB01E832F0446529905C5EC963")

    private LayoutTransition mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "BC704CB9A61CBF94F6C841CD3BBBC604", hash_generated_field = "C5D8A5DD8407602ED6BD80CBFE380CF3")

    private ArrayList<View> mTransitioningViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "D514310998F517320B20BEE9C067E163", hash_generated_field = "C1C569B225732CB1507D8AE1B61808FC")

    private ArrayList<View> mVisibilityChangingChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.943 -0400", hash_original_field = "09D83BDA15EFA5B57765F9C578A0ADBE", hash_generated_field = "6EF80FC61B331A8C0C9A860633C8D76D")

    @ViewDebug.ExportedProperty(category = "drawing") private boolean mDrawLayers = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.944 -0400", hash_original_field = "693F082C39142816DE048BF6C839F8C1", hash_generated_field = "6E6C4406A80D7DD83F2625603B90CB85")

    private LayoutTransition.TransitionListener mLayoutTransitionListener = new LayoutTransition.TransitionListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.944 -0400", hash_original_method = "BD73D83C5E4C50AAE7C2D0E44AB74A47", hash_generated_method = "7DFCB5C82DE7D84A396B2F6FB117206C")
        @Override
        public void startTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            {
                startViewTransition(view);
            } 
            addTaint(transition.getTaint());
            addTaint(container.getTaint());
            addTaint(view.getTaint());
            addTaint(transitionType);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.944 -0400", hash_original_method = "04DFE6408D192F5CD42CA1A3B87396E7", hash_generated_method = "08E74D2FC07D20C465A6AF26F7E23580")
        @Override
        public void endTransition(LayoutTransition transition, ViewGroup container,
                View view, int transitionType) {
            {
                boolean var00EE79CB64B66FAC37BA4FE35CB2471D_1945541521 = (mLayoutSuppressed && !transition.isChangingLayout());
                {
                    requestLayout();
                    mLayoutSuppressed = false;
                } 
            } 
            {
                endViewTransition(view);
            } 
            addTaint(transition.getTaint());
            addTaint(container.getTaint());
            addTaint(view.getTaint());
            addTaint(transitionType);
            
            
                
                
            
            
                
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.944 -0400", hash_original_method = "B03ADF87A05C955E785D82B4A9B527B3", hash_generated_method = "9E86527441EE6979F95DE6E48A6A7312")
    public  ViewGroup(Context context) {
        super(context);
        initViewGroup();
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.945 -0400", hash_original_method = "01EF181B5B9BD1E2AA94519EF8FAEC5E", hash_generated_method = "D87EA6255254109A608B5FC70AF0FCE1")
    public  ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewGroup();
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.945 -0400", hash_original_method = "FE20AAD08B3866F38DB1C82409548865", hash_generated_method = "082067AAFF7EA388FAD5115F033F4988")
    public  ViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViewGroup();
        initFromAttributes(context, attrs);
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        addTaint(defStyle);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.945 -0400", hash_original_method = "8201DDC69D3895B689FCA6813D812A1F", hash_generated_method = "8F5B305EF6384689E6459A6FB77644A1")
    private void initViewGroup() {
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        {
            boolean varEEA1697260544E0A5861DD090A86C488_611745307 = (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB);
            {
                mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
            } 
        } 
        setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        mChildren = new View[ARRAY_INITIAL_CAPACITY];
        mChildrenCount = 0;
        mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
        
        
        
        
        
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.946 -0400", hash_original_method = "4BC426CDAC642CD3FACBBAAA9F56EF39", hash_generated_method = "8F1C37EE121E05D053B7459D774BE1B5")
    private void initFromAttributes(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ViewGroup);
        final int N = a.getIndexCount();
        {
            int i = 0;
            {
                int attr = a.getIndex(i);
                
                setClipChildren(a.getBoolean(attr, true));
                
                
                setClipToPadding(a.getBoolean(attr, true));
                
                
                setAnimationCacheEnabled(a.getBoolean(attr, true));
                
                
                setPersistentDrawingCache(a.getInt(attr, PERSISTENT_SCROLLING_CACHE));
                
                
                setAddStatesFromChildren(a.getBoolean(attr, false));
                
                
                setAlwaysDrawnWithCacheEnabled(a.getBoolean(attr, true));
                
                
                int id = a.getResourceId(attr, -1);
                
                
                {
                    setLayoutAnimation(AnimationUtils.loadLayoutAnimation(mContext, id));
                } 
                
                
                setDescendantFocusability(DESCENDANT_FOCUSABILITY_FLAGS[a.getInt(attr, 0)]);
                
                
                setMotionEventSplittingEnabled(a.getBoolean(attr, false));
                
                
                boolean animateLayoutChanges = a.getBoolean(attr, false);
                
                
                {
                    setLayoutTransition(new LayoutTransition());
                } 
                
            } 
        } 
        a.recycle();
        addTaint(context.getTaint());
        addTaint(attrs.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.947 -0400", hash_original_method = "9DEFF27CA0C7CA0A646DEBC837B35971", hash_generated_method = "E1BE5E0BBABC330ABFF8FF8CAE2F4B3C")
    @ViewDebug.ExportedProperty(category = "focus", mapping = {
        @ViewDebug.IntToString(from = FOCUS_BEFORE_DESCENDANTS, to = "FOCUS_BEFORE_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_AFTER_DESCENDANTS, to = "FOCUS_AFTER_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_BLOCK_DESCENDANTS, to = "FOCUS_BLOCK_DESCENDANTS")
    })
    public int getDescendantFocusability() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916694904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_916694904;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.947 -0400", hash_original_method = "0404A0C2267D357D33DA2838086AAD01", hash_generated_method = "6777C91700ABD3CD3DF9DE9501BE5784")
    public void setDescendantFocusability(int focusability) {
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        + "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        
        mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
        
        
            
            
            
                
            
                
                        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.948 -0400", hash_original_method = "1894A66AF55103F8230E4E4C184BE483", hash_generated_method = "2A1DBE41ABFE76B1E26C9E59815B50B8")
    @Override
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        {
            mFocused.unFocus();
            mFocused = null;
        } 
        super.handleFocusGainInternal(direction, previouslyFocusedRect);
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.949 -0400", hash_original_method = "18A4940B9B410F6E2A586E7BEB513255", hash_generated_method = "504940AA5CA771877A6E9A21191E1471")
    public void requestChildFocus(View child, View focused) {
        {
            System.out.println(this + " requestChildFocus()");
        } 
        {
            boolean varD47ACE2ACEC5C175A0471B099816BE37_1848177389 = (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS);
        } 
        super.unFocus();
        {
            {
                mFocused.unFocus();
            } 
            mFocused = child;
        } 
        {
            mParent.requestChildFocus(this, focused);
        } 
        addTaint(focused.getTaint());
        
        
            
        
        
            
        
        
        
            
                
            
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.949 -0400", hash_original_method = "B9C632089323DEB68745C50418B61ADF", hash_generated_method = "6D48AE1FE234AF630E487A66DA3D8F4B")
    public void focusableViewAvailable(View v) {
        {
            boolean varB10813EF6870F670C964BBAED5788EED_1058087338 = (mParent != null
                && (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                && !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS));
            {
                mParent.focusableViewAvailable(v);
            } 
        } 
        addTaint(v.getTaint());
        
        
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.949 -0400", hash_original_method = "AAA08A22C93220CA5F37A81C00115203", hash_generated_method = "296023B99D4F1E869842D1C0B8015F1E")
    public boolean showContextMenuForChild(View originalView) {
        boolean varBA8B92D993B1A5B6CF969236EEAB6152_669547775 = (mParent != null && mParent.showContextMenuForChild(originalView));
        addTaint(originalView.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939673462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939673462;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.950 -0400", hash_original_method = "8C60B2F96F2B489988C14A93A463DAE3", hash_generated_method = "F270CFA1B751C2F73C038FDAE4DF7A1B")
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        ActionMode varB4EAC82CA7396A68D541C85D26508E83_1306296268 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1306296268 = mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
        addTaint(originalView.getTaint());
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1306296268.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1306296268;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.950 -0400", hash_original_method = "32394A633C776A8BC33A6BFC48D3DC37", hash_generated_method = "2E45788551B3AF8CA0980A4A94AE9E72")
    public View focusSearch(View focused, int direction) {
        View varB4EAC82CA7396A68D541C85D26508E83_410521484 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1624342629 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_226646072 = null; 
        {
            boolean var6900EB30484F14AE1B69428931AEDE0D_1723218640 = (isRootNamespace());
            {
                varB4EAC82CA7396A68D541C85D26508E83_410521484 = FocusFinder.getInstance().findNextFocus(this, focused, direction);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1624342629 = mParent.focusSearch(focused, direction);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_226646072 = null;
        addTaint(focused.getTaint());
        addTaint(direction);
        View varA7E53CE21691AB073D9660D615818899_1430431668; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1430431668 = varB4EAC82CA7396A68D541C85D26508E83_410521484;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1430431668 = varB4EAC82CA7396A68D541C85D26508E83_1624342629;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1430431668 = varB4EAC82CA7396A68D541C85D26508E83_226646072;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1430431668.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1430431668;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.951 -0400", hash_original_method = "1A209ACB79681B08302166E2C48344A2", hash_generated_method = "909498A7E4E60D47B5C18FE62929BD6C")
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        addTaint(child.getTaint());
        addTaint(rectangle.getTaint());
        addTaint(immediate);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348466506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_348466506;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.951 -0400", hash_original_method = "B4AA594F7D6DA64F58B166664BBA4580", hash_generated_method = "FCD74FD73E06D94C6E02AAC27F6212E6")
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        ViewParent parent = getParent();
        final boolean propagate = onRequestSendAccessibilityEvent(child, event);
        boolean var441FEE5B5C6B1D4A365CF02E122B98E7_1715056664 = (parent.requestSendAccessibilityEvent(this, event));
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656174315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_656174315;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.951 -0400", hash_original_method = "0D2782B4A269D15DF81200BFDAFE535A", hash_generated_method = "5ED33784E9BDC938F35C29528BFF28A6")
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        
        {
            boolean var5A0C8D77442C96677A25BCD888A43DDA_1676437145 = (mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event));
        } 
        {
            boolean var36AE0BB3330710CD64DFF9DF5BCECE4F_356981700 = (onRequestSendAccessibilityEventInternal(child, event));
        } 
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616174399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616174399;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.952 -0400", hash_original_method = "F0DFCA5DE1F330F511BBFF62182D5BD4", hash_generated_method = "FDDE49DFC1DD5DFDA960E159BBDE623A")
     boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event) {
        
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1852199484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1852199484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.952 -0400", hash_original_method = "E35CCEA2DF29F8696C548F55094B5B73", hash_generated_method = "131DF5FFCAF885BFFEABEB8ABC169D46")
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        boolean var661477CC7A374E9FA1E26C430B4E7B43_1065032566 = (mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction));
        addTaint(focused.getTaint());
        addTaint(direction);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1923987516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1923987516;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.952 -0400", hash_original_method = "1A8D22FF280DB81B170D27815BE7BEAA", hash_generated_method = "220D2AF227F8192C20FF0AAD9C6E6B54")
    public void clearChildFocus(View child) {
        {
            System.out.println(this + " clearChildFocus()");
        } 
        mFocused = null;
        {
            mParent.clearChildFocus(this);
        } 
        addTaint(child.getTaint());
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.953 -0400", hash_original_method = "2A2B29C64ED25C5483BB6B32C5BD1628", hash_generated_method = "3342498F7A8B69ACA45B632AC7F311FF")
    @Override
    public void clearFocus() {
        super.clearFocus();
        {
            mFocused.clearFocus();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.953 -0400", hash_original_method = "AD8CA09F957410559E0C3DF16ADDE822", hash_generated_method = "F120404050A1F818C6DEF3758FDB7E87")
    @Override
     void unFocus() {
        {
            System.out.println(this + " unFocus()");
        } 
        super.unFocus();
        {
            mFocused.unFocus();
        } 
        mFocused = null;
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.953 -0400", hash_original_method = "F6AEE91365C496A95D4F4B1572422CF5", hash_generated_method = "3A34C49C7D005CEB466185F73C2DC6D8")
    public View getFocusedChild() {
        View varB4EAC82CA7396A68D541C85D26508E83_248650730 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_248650730 = mFocused;
        varB4EAC82CA7396A68D541C85D26508E83_248650730.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_248650730;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.954 -0400", hash_original_method = "3D9AAFDE8E8826B256A10D32D774D94B", hash_generated_method = "7E7C656BFB261A26A25B9D59C0895A81")
    @Override
    public boolean hasFocus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318427078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318427078;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.954 -0400", hash_original_method = "8D50679A3D30F96CD0297A05342EFA70", hash_generated_method = "4CB87EB88AD9FF07B701864EF0333D51")
    @Override
    public View findFocus() {
        View varB4EAC82CA7396A68D541C85D26508E83_1848113700 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1997205617 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1549009055 = null; 
        {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        } 
        {
            boolean var1C23F183BE3EEE2A8667855A22865324_620532249 = (isFocused());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1848113700 = this;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1997205617 = mFocused.findFocus();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1549009055 = null;
        View varA7E53CE21691AB073D9660D615818899_1716451341; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1716451341 = varB4EAC82CA7396A68D541C85D26508E83_1848113700;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1716451341 = varB4EAC82CA7396A68D541C85D26508E83_1997205617;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1716451341 = varB4EAC82CA7396A68D541C85D26508E83_1549009055;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1716451341.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1716451341;
        
        
            
                    
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.955 -0400", hash_original_method = "415824CC4E37F2B08D458BE00E3F5A3F", hash_generated_method = "414A33CAC9F73E579ED0E2098E1028F5")
    @Override
    public boolean hasFocusable() {
        {
            boolean var586AE4CCFE144A60D22CF3B21C623ACC_1418733681 = (isFocusable());
        } 
        final int descendantFocusability = getDescendantFocusability();
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            {
                int i = 0;
                {
                    final View child = children[i];
                    {
                        boolean var7DC29F4EF4EE5211D58EB348F2B6AE7E_1965868413 = (child.hasFocusable());
                    } 
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149225511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149225511;
        
        
            
        
        
            
        
        
        
            
            
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.955 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "431825FF8AC602907ED2322848F946AB")
    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        addTaint(views.getTaint());
        addTaint(direction);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.956 -0400", hash_original_method = "A281D125D4DD0434A87F479D62DD0361", hash_generated_method = "0FF7C489805A9FFAE077F11A79830CAE")
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        final int focusableCount = views.size();
        final int descendantFocusability = getDescendantFocusability();
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            {
                int i = 0;
                {
                    final View child = children[i];
                    {
                        child.addFocusables(views, direction, focusableMode);
                    } 
                } 
            } 
        } 
        {
            boolean var0F1BFD0DBC136B3E2580439E8453837C_25946439 = (descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                (focusableCount == views.size()));
            {
                super.addFocusables(views, direction, focusableMode);
            } 
        } 
        addTaint(views.getTaint());
        addTaint(direction);
        addTaint(focusableMode);
        
        
        
        
            
            
            
                
                
                    
                
            
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.957 -0400", hash_original_method = "01B0DFF5DFF6A04EF473202885B21AEA", hash_generated_method = "1C384F8CAF57EFD30A22525108477F28")
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        super.findViewsWithText(outViews, text, flags);
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                View child = children[i];
                {
                    child.findViewsWithText(outViews, text, flags);
                } 
            } 
        } 
        addTaint(outViews.getTaint());
        addTaint(text.getTaint());
        addTaint(flags);
        
        
        
        
        
            
            
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.958 -0400", hash_original_method = "E63784DE90D03F6D10488691622E702B", hash_generated_method = "D408E5CADBE6229BF22E996F5F9A8A69")
    @Override
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        View varB4EAC82CA7396A68D541C85D26508E83_2007836568 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_159636968 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1933599470 = null; 
        View foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2007836568 = foundView;
        } 
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                View child = children[i];
                foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_159636968 = foundView;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1933599470 = null;
        addTaint(accessibilityId);
        View varA7E53CE21691AB073D9660D615818899_1616167468; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1616167468 = varB4EAC82CA7396A68D541C85D26508E83_2007836568;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1616167468 = varB4EAC82CA7396A68D541C85D26508E83_159636968;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1616167468 = varB4EAC82CA7396A68D541C85D26508E83_1933599470;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1616167468.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1616167468;
        
        
        
            
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.959 -0400", hash_original_method = "8947E2F3FD45B1E1CD9A8BF9F902DE4D", hash_generated_method = "F96EF608CB361E90A2693B207131EC10")
    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        super.dispatchWindowFocusChanged(hasFocus);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchWindowFocusChanged(hasFocus);
            } 
        } 
        addTaint(hasFocus);
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.960 -0400", hash_original_method = "3C050A87A5AA11FCC905DB1242C91519", hash_generated_method = "BA4D79BAA9E692562DBB3E7949BE15E3")
    @Override
    public void addTouchables(ArrayList<View> views) {
        super.addTouchables(views);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                final View child = children[i];
                {
                    child.addTouchables(views);
                } 
            } 
        } 
        addTaint(views.getTaint());
        
        
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.960 -0400", hash_original_method = "E3ECA4D0183F28678AE9A73BEBE4A4C4", hash_generated_method = "C8ED002026A7FA9FBCEBE30B59038880")
    @Override
    public void dispatchDisplayHint(int hint) {
        super.dispatchDisplayHint(hint);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchDisplayHint(hint);
            } 
        } 
        addTaint(hint);
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.961 -0400", hash_original_method = "39046505104385736A9526E25AC3965D", hash_generated_method = "B2F64F3B02B2ED6FA2543ED8F731202D")
    protected void onChildVisibilityChanged(View child, int visibility) {
        
        {
            {
                mTransition.showChild(this, child);
            } 
            {
                mTransition.hideChild(this, child);
            } 
            {
                {
                    mVisibilityChangingChildren = new ArrayList<View>();
                } 
                mVisibilityChangingChildren.add(child);
                {
                    boolean var062D8AB67088E18389484F6801BD9183_630423176 = (mTransitioningViews != null && mTransitioningViews.contains(child));
                    {
                        addDisappearingView(child);
                    } 
                } 
            } 
        } 
        {
            {
                notifyChildOfDrag(child);
            } 
        } 
        addTaint(child.getTaint());
        addTaint(visibility);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.961 -0400", hash_original_method = "66EC1DB8C5DE29B0D05D23F4BE080169", hash_generated_method = "3F11DA70082CC701FFF81E33C40D7E06")
    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        super.dispatchVisibilityChanged(changedView, visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchVisibilityChanged(changedView, visibility);
            } 
        } 
        addTaint(changedView.getTaint());
        addTaint(visibility);
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.961 -0400", hash_original_method = "110C8ADF44E81EF076420285F756776D", hash_generated_method = "6F001FE10C303FC73B9CE25CAF3EE77E")
    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        super.dispatchWindowVisibilityChanged(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchWindowVisibilityChanged(visibility);
            } 
        } 
        addTaint(visibility);
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.962 -0400", hash_original_method = "4BA014AA7FB311F49457CF496AD5B6EF", hash_generated_method = "7BCEBC8B4609C339C4E1E95A334E52D1")
    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        super.dispatchConfigurationChanged(newConfig);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchConfigurationChanged(newConfig);
            } 
        } 
        addTaint(newConfig.getTaint());
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.962 -0400", hash_original_method = "F881B5C75EE06984153060972C295D8F", hash_generated_method = "6944D71F9564A9FCE793F756A93535DA")
    public void recomputeViewAttributes(View child) {
        {
            ViewParent parent = mParent;
            parent.recomputeViewAttributes(this);
        } 
        addTaint(child.getTaint());
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.962 -0400", hash_original_method = "99C97332C863B663BFCA518BE284DB35", hash_generated_method = "7AB3DEACF2202405489A324FDF5E0AC1")
    @Override
     void dispatchCollectViewAttributes(int visibility) {
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchCollectViewAttributes(visibility);
            } 
        } 
        addTaint(visibility);
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.963 -0400", hash_original_method = "C5DA1A7419AFEADC86BA0783BA235334", hash_generated_method = "D28ED1B16BA6AD83380DF20ECD0CA43C")
    public void bringChildToFront(View child) {
        int index = indexOfChild(child);
        {
            removeFromArray(index);
            addInArray(child, mChildrenCount);
            child.mParent = this;
        } 
        addTaint(child.getTaint());
        
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.980 -0400", hash_original_method = "0B94D743FFC1DE288527F02F6E8345CD", hash_generated_method = "A7013D773220EA12EDB9991E3C4B7F99")
    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        boolean retval = false;
        final float tx = event.mX;
        final float ty = event.mY;
        ViewRootImpl root = getViewRootImpl();
        
        {
            mCurrentDragView = null;
            mCurrentDrag = DragEvent.obtain(event);
            {
                mDragNotifiedChildren = new HashSet<View>();
            } 
            {
                mDragNotifiedChildren.clear();
            } 
            mChildAcceptsDrag = false;
            final int count = mChildrenCount;
            final View[] children = mChildren;
            {
                int i = 0;
                {
                    final View child = children[i];
                    child.mPrivateFlags2 &= ~View.DRAG_MASK;
                    {
                        boolean var93DCAA7E24F58D6762D32E351E886EF8_1845359866 = (child.getVisibility() == VISIBLE);
                        {
                            final boolean handled = notifyChildOfDrag(children[i]);
                            {
                                mChildAcceptsDrag = true;
                            } 
                        } 
                    } 
                } 
            } 
            {
                retval = true;
            } 
        } 
        
        
        {
            {
                {
                    Iterator<View> var3378C5B405A48B24956CD00DB7CCC663_1982999624 = (mDragNotifiedChildren).iterator();
                    var3378C5B405A48B24956CD00DB7CCC663_1982999624.hasNext();
                    View child = var3378C5B405A48B24956CD00DB7CCC663_1982999624.next();
                    {
                        child.dispatchDragEvent(event);
                        child.mPrivateFlags2 &= ~View.DRAG_MASK;
                        child.refreshDrawableState();
                    } 
                } 
                mDragNotifiedChildren.clear();
                mCurrentDrag.recycle();
                mCurrentDrag = null;
            } 
            {
                retval = true;
            } 
        } 
        
        
        {
            final View target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                root.setDragFocus(target);
                final int action = event.mAction;
                {
                    final View view = mCurrentDragView;
                    event.mAction = DragEvent.ACTION_DRAG_EXITED;
                    view.dispatchDragEvent(event);
                    view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                    view.refreshDrawableState();
                } 
                mCurrentDragView = target;
                {
                    event.mAction = DragEvent.ACTION_DRAG_ENTERED;
                    target.dispatchDragEvent(event);
                    target.mPrivateFlags2 |= View.DRAG_HOVERED;
                    target.refreshDrawableState();
                } 
                event.mAction = action;
            } 
            {
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } 
        } 
        
        
        {
            {
                final View view = mCurrentDragView;
                view.dispatchDragEvent(event);
                view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                view.refreshDrawableState();
                mCurrentDragView = null;
            } 
        } 
        
        
        {
            Log.d(View.VIEW_LOG_TAG, "Drop event: " + event);
            View target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
            {
                Log.d(View.VIEW_LOG_TAG, "   dispatch drop to " + target);
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } 
            {
                {
                    Log.d(View.VIEW_LOG_TAG, "   not dropped on an accepting view");
                } 
            } 
        } 
        
        {
            retval = super.dispatchDragEvent(event);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_291723058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_291723058;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.981 -0400", hash_original_method = "A61A140E816A1C908C27B7F105ECC965", hash_generated_method = "7024E575DC23D6B77E88A1C1B29C9FAE")
     View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint) {
        View varB4EAC82CA7396A68D541C85D26508E83_205528283 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1958966238 = null; 
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = count - 1;
            {
                final View child = children[i];
                {
                    boolean varDD9451246475E78E9B9862A08B40ED39_1337188948 = (!child.canAcceptDrag());
                } 
                {
                    boolean varB60C7CACEA3B7B85D44A4D6C320C4F52_1794834151 = (isTransformedTouchPointInView(x, y, child, outLocalPoint));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_205528283 = child;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1958966238 = null;
        addTaint(x);
        addTaint(y);
        addTaint(outLocalPoint.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1997515913; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1997515913 = varB4EAC82CA7396A68D541C85D26508E83_205528283;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1997515913 = varB4EAC82CA7396A68D541C85D26508E83_1958966238;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1997515913.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1997515913;
        
        
        
        
            
            
                
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.981 -0400", hash_original_method = "01B6DB1535B88ABBDA0897E44597D185", hash_generated_method = "79FE0CCE1A112C71E26EA01D02FE0AAD")
     boolean notifyChildOfDrag(View child) {
        {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        } 
        boolean canAccept = false;
        {
            boolean var9513878AE6807A2BEC04686702F54F4D_156900274 = (! mDragNotifiedChildren.contains(child));
            {
                mDragNotifiedChildren.add(child);
                canAccept = child.dispatchDragEvent(mCurrentDrag);
                {
                    boolean var6E0AEBF66F234C4EF96F0B794A136F59_446626618 = (canAccept && !child.canAcceptDrag());
                    {
                        child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                        child.refreshDrawableState();
                    } 
                } 
            } 
        } 
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665298079 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665298079;
        
        
            
        
        
        
            
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.982 -0400", hash_original_method = "6EA017C64305C1BE29415F2C64CCEDD4", hash_generated_method = "41CD938F6A124B7B5600C4F9A0029B7B")
    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        super.dispatchSystemUiVisibilityChanged(visible);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                final View child = children[i];
                child.dispatchSystemUiVisibilityChanged(visible);
            } 
        } 
        addTaint(visible);
        
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.982 -0400", hash_original_method = "5F03A98EA003A081CE87491B56EF094D", hash_generated_method = "B03F13AF77ADAC860CC3E6291B5D4259")
    @Override
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        super.updateLocalSystemUiVisibility(localValue, localChanges);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                final View child = children[i];
                child.updateLocalSystemUiVisibility(localValue, localChanges);
            } 
        } 
        addTaint(localValue);
        addTaint(localChanges);
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.983 -0400", hash_original_method = "1796A9ED58069BDF38C7C072FE20CF71", hash_generated_method = "4591144EE6AC4B4C49BE8D1579CDAD08")
    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        {
            boolean var69A4D5BA21F9754791BA96F9F5C71142_1266985239 = (super.dispatchKeyEventPreIme(event));
        } 
        {
            boolean varFE2571F324BFA6DB9FF0B9BEE57E874E_1422193186 = (mFocused.dispatchKeyEventPreIme(event));
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388349832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388349832;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.983 -0400", hash_original_method = "1E41A7E6E3EFA9117FFB3A56DB417CA0", hash_generated_method = "F35CD5EC14C8ED0ECF3ACA1234D65BD7")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        } 
        {
            {
                boolean varCEE2CC9A2E312DCEF21BEB8A1D3D2A74_507674815 = (super.dispatchKeyEvent(event));
            } 
        } 
        {
            {
                boolean varBA71E8F3A809B2219624C59EBC2DEB55_1546109392 = (mFocused.dispatchKeyEvent(event));
            } 
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042699075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042699075;
        
        
            
        
        
            
                
            
        
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.984 -0400", hash_original_method = "C8DF4A46704EEB88AB3A3DAEBDA2EE59", hash_generated_method = "7493B8BBDED33E3FDD25ECCDE8050FCF")
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        {
            boolean varF75FC08430B3CB671A7FC788738670A4_890284502 = (super.dispatchKeyShortcutEvent(event));
        } 
        {
            boolean var9C5A31847C19CF0D448BFF804D2D7DBC_37913342 = (mFocused.dispatchKeyShortcutEvent(event));
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_501088539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_501088539;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.985 -0400", hash_original_method = "CF1D00451039D1CA46B97508DE17783C", hash_generated_method = "1A80FF40B21496FA313938597E9D7BA8")
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        } 
        {
            {
                boolean varDD1D6069514DE34833A921C8364915DD_1711105011 = (super.dispatchTrackballEvent(event));
            } 
        } 
        {
            {
                boolean var0FFB054D71651438CDA84A82C67C65B6_1154616573 = (mFocused.dispatchTrackballEvent(event));
            } 
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573917752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573917752;
        
        
            
        
        
            
                
            
        
            
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.986 -0400", hash_original_method = "E0F6A76AF2BEDB6076446B6A929BAC84", hash_generated_method = "40784748BBEDCE84298D11F24A8BB35E")
    @SuppressWarnings({"ConstantConditions"})
    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        final int action = event.getAction();
        final boolean interceptHover = onInterceptHoverEvent(event);
        event.setAction(action);
        MotionEvent eventNoHistory = event;
        boolean handled = false;
        HoverTarget firstOldHoverTarget = mFirstHoverTarget;
        mFirstHoverTarget = null;
        {
            final float x = event.getX();
            final float y = event.getY();
            final int childrenCount = mChildrenCount;
            {
                final View[] children = mChildren;
                HoverTarget lastHoverTarget = null;
                {
                    int i = childrenCount - 1;
                    {
                        final View child = children[i];
                        {
                            boolean var39A5B2EF267FE4EA5711368BBCBF6FA1_864600460 = (!canViewReceivePointerEvents(child)
                            || !isTransformedTouchPointInView(x, y, child, null));
                        } 
                        HoverTarget hoverTarget = firstOldHoverTarget;
                        boolean wasHovered;
                        {
                            HoverTarget predecessor = null;
                            {
                                {
                                    hoverTarget = HoverTarget.obtain(child);
                                    wasHovered = false;
                                } 
                                {
                                    {
                                        predecessor.next = hoverTarget.next;
                                    } 
                                    {
                                        firstOldHoverTarget = hoverTarget.next;
                                    } 
                                    hoverTarget.next = null;
                                    wasHovered = true;
                                } 
                                predecessor = hoverTarget;
                                hoverTarget = hoverTarget.next;
                            } 
                        } 
                        {
                            lastHoverTarget.next = hoverTarget;
                        } 
                        {
                            lastHoverTarget = hoverTarget;
                            mFirstHoverTarget = hoverTarget;
                        } 
                        {
                            {
                                handled |= dispatchTransformedGenericPointerEvent(
                                    event, child);
                            } 
                        } 
                        {
                            {
                                eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                                eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                                handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                                eventNoHistory.setAction(action);
                                handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                            } 
                            {
                                handled |= dispatchTransformedGenericPointerEvent(event, child);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            final View child = firstOldHoverTarget.child;
            {
                handled |= dispatchTransformedGenericPointerEvent(
                        event, child);
            } 
            {
                {
                    dispatchTransformedGenericPointerEvent(
                            event, child);
                } 
                eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                eventNoHistory.setAction(MotionEvent.ACTION_HOVER_EXIT);
                dispatchTransformedGenericPointerEvent(
                        eventNoHistory, child);
                eventNoHistory.setAction(action);
            } 
            final HoverTarget nextOldHoverTarget = firstOldHoverTarget.next;
            firstOldHoverTarget.recycle();
            firstOldHoverTarget = nextOldHoverTarget;
        } 
        boolean newHoveredSelf = !handled;
        {
            {
                handled |= super.dispatchHoverEvent(event);
            } 
        } 
        {
            {
                {
                    handled |= super.dispatchHoverEvent(event);
                } 
                {
                    {
                        super.dispatchHoverEvent(event);
                    } 
                    eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                    eventNoHistory.setAction(MotionEvent.ACTION_HOVER_EXIT);
                    super.dispatchHoverEvent(eventNoHistory);
                    eventNoHistory.setAction(action);
                } 
                mHoveredSelf = false;
            } 
            {
                {
                    handled |= super.dispatchHoverEvent(event);
                    mHoveredSelf = true;
                } 
                {
                    eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                    eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                    handled |= super.dispatchHoverEvent(eventNoHistory);
                    eventNoHistory.setAction(action);
                    handled |= super.dispatchHoverEvent(eventNoHistory);
                    mHoveredSelf = true;
                } 
            } 
        } 
        {
            eventNoHistory.recycle();
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301632704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301632704;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.987 -0400", hash_original_method = "CAF0CE39145036A2F3E98F46F45FF397", hash_generated_method = "A053B7C659FDF036E00E31B7D20BEE7F")
    @Override
    protected boolean hasHoveredChild() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102123598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102123598;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.987 -0400", hash_original_method = "039A9532EA6933A3F4F8681C30CC9E2B", hash_generated_method = "EBE3C9A9867079705C5FD4010E146071")
    public boolean onInterceptHoverEvent(MotionEvent event) {
        
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842203427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842203427;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event) {
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.988 -0400", hash_original_method = "8425E6039966203E8B52A55F0ACFD97E", hash_generated_method = "97919D65EBD75A27A292457FF887C21B")
    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        final int childrenCount = mChildrenCount;
        {
            final View[] children = mChildren;
            final float x = event.getX();
            final float y = event.getY();
            {
                int i = childrenCount - 1;
                {
                    final View child = children[i];
                    {
                        boolean var330479A3EB93BD7FBB36FC9D307449EC_992786666 = (!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null));
                    } 
                    {
                        boolean varE3F3EFAB7A0C507CFC1087341B7293FA_133408954 = (dispatchTransformedGenericPointerEvent(event, child));
                    } 
                } 
            } 
        } 
        boolean var08E200417CAE6114EB8B8E0EE91851EC_622062955 = (super.dispatchGenericPointerEvent(event));
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740344322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740344322;
        
        
        
            
            
            
            
                
                
                        
                    
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.988 -0400", hash_original_method = "EF2476E6EC182ADC11908B65D0A31365", hash_generated_method = "2156ADAB8BEEBD9D77CB4309D2942D69")
    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        {
            boolean varB46815DBC1BC9F2955B6C32C32EC3809_1329804991 = (super.dispatchGenericFocusedEvent(event));
        } 
        {
            boolean varDAA7826F7D7AE31750BF98F87DE576DE_974223605 = (mFocused.dispatchGenericMotionEvent(event));
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667226005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667226005;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.989 -0400", hash_original_method = "89F3902132A72D71D534028C51E6FDBB", hash_generated_method = "DA3C0010230E82C9EE1C111FC5B17172")
    private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child) {
        final float offsetX = mScrollX - child.mLeft;
        final float offsetY = mScrollY - child.mTop;
        boolean handled;
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_1225310831 = (!child.hasIdentityMatrix());
            {
                MotionEvent transformedEvent = MotionEvent.obtain(event);
                transformedEvent.offsetLocation(offsetX, offsetY);
                transformedEvent.transform(child.getInverseMatrix());
                handled = child.dispatchGenericMotionEvent(transformedEvent);
                transformedEvent.recycle();
            } 
            {
                event.offsetLocation(offsetX, offsetY);
                handled = child.dispatchGenericMotionEvent(event);
                event.offsetLocation(-offsetX, -offsetY);
            } 
        } 
        addTaint(event.getTaint());
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1119342538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1119342538;
        
        
        
        
        
            
            
            
            
            
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.990 -0400", hash_original_method = "9A4777971E22B675E68E924B82246A95", hash_generated_method = "78E851B99248E6E30CC9B7A0281E1075")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 1);
        } 
        boolean handled = false;
        {
            boolean var6CC6773C2F32650974B473D1B32A8111_900742287 = (onFilterTouchEventForSecurity(ev));
            {
                final int action = ev.getAction();
                final int actionMasked = action & MotionEvent.ACTION_MASK;
                {
                    cancelAndClearTouchTargets(ev);
                    resetTouchState();
                } 
                boolean intercepted;
                {
                    final boolean disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
                    {
                        intercepted = onInterceptTouchEvent(ev);
                        ev.setAction(action);
                    } 
                    {
                        intercepted = false;
                    } 
                } 
                {
                    intercepted = true;
                } 
                final boolean canceled = resetCancelNextUpFlag(this)
                    || actionMasked == MotionEvent.ACTION_CANCEL;
                final boolean split = (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) != 0;
                TouchTarget newTouchTarget = null;
                boolean alreadyDispatchedToNewTouchTarget = false;
                {
                    {
                        final int actionIndex = ev.getActionIndex();
                        int idBitsToAssign;
                        idBitsToAssign = 1 << ev.getPointerId(actionIndex);
                        idBitsToAssign = TouchTarget.ALL_POINTER_IDS;
                        removePointersFromTouchTargets(idBitsToAssign);
                        final int childrenCount = mChildrenCount;
                        {
                            final View[] children = mChildren;
                            final float x = ev.getX(actionIndex);
                            final float y = ev.getY(actionIndex);
                            {
                                int i = childrenCount - 1;
                                {
                                    final View child = children[i];
                                    {
                                        boolean varA03062BDD929C4635E5C5D880ED86080_2007532454 = (!canViewReceivePointerEvents(child)
                                    || !isTransformedTouchPointInView(x, y, child, null));
                                    } 
                                    newTouchTarget = getTouchTarget(child);
                                    {
                                        newTouchTarget.pointerIdBits |= idBitsToAssign;
                                    } 
                                    resetCancelNextUpFlag(child);
                                    {
                                        boolean var4D2A48697299CECF9F8D426E12ED9A2F_1142852320 = (dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign));
                                        {
                                            mLastTouchDownTime = ev.getDownTime();
                                            mLastTouchDownIndex = i;
                                            mLastTouchDownX = ev.getX();
                                            mLastTouchDownY = ev.getY();
                                            newTouchTarget = addTouchTarget(child, idBitsToAssign);
                                            alreadyDispatchedToNewTouchTarget = true;
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            newTouchTarget = mFirstTouchTarget;
                            {
                                newTouchTarget = newTouchTarget.next;
                            } 
                            newTouchTarget.pointerIdBits |= idBitsToAssign;
                        } 
                    } 
                } 
                {
                    handled = dispatchTransformedTouchEvent(ev, canceled, null,
                        TouchTarget.ALL_POINTER_IDS);
                } 
                {
                    TouchTarget predecessor = null;
                    TouchTarget target = mFirstTouchTarget;
                    {
                        final TouchTarget next = target.next;
                        {
                            handled = true;
                        } 
                        {
                            final boolean cancelChild = resetCancelNextUpFlag(target.child)
                        || intercepted;
                            {
                                boolean varEA3E26DE3C0C658C465A175EDB865343_984840378 = (dispatchTransformedTouchEvent(ev, cancelChild,
                                target.child, target.pointerIdBits));
                                {
                                    handled = true;
                                } 
                            } 
                            {
                                {
                                    mFirstTouchTarget = next;
                                } 
                                {
                                    predecessor.next = next;
                                } 
                                target.recycle();
                                target = next;
                            } 
                        } 
                        predecessor = target;
                        target = next;
                    } 
                } 
                {
                    resetTouchState();
                } 
                {
                    final int actionIndex = ev.getActionIndex();
                    final int idBitsToRemove = 1 << ev.getPointerId(actionIndex);
                    removePointersFromTouchTargets(idBitsToRemove);
                } 
            } 
        } 
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 1);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2096574192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2096574192;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.991 -0400", hash_original_method = "1B0EC47DAA405380670E223779C878A6", hash_generated_method = "FB0BEF6A0D13DDEE91DD6A9C23FE556F")
    private void resetTouchState() {
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.991 -0400", hash_original_method = "B31FF6D343B2149E4D841C0A7CD04309", hash_generated_method = "9B73F88F38CF5120FDB7B551D23DF7FD")
    private boolean resetCancelNextUpFlag(View view) {
        {
            view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
        } 
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693240399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693240399;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.991 -0400", hash_original_method = "C1060B6E54563910E15717B9621A0CC6", hash_generated_method = "1C82E76A7F053704AA1FC4104CF306BD")
    private void clearTouchTargets() {
        TouchTarget target = mFirstTouchTarget;
        {
            {
                TouchTarget next = target.next;
                target.recycle();
                target = next;
            } 
            mFirstTouchTarget = null;
        } 
        
        
        
            
                
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.992 -0400", hash_original_method = "45B19A2C35386F46FF7561697C2C88B0", hash_generated_method = "07D23E3DF02FB3823108D326135C9040")
    private void cancelAndClearTouchTargets(MotionEvent event) {
        {
            boolean syntheticEvent = false;
            {
                final long now = SystemClock.uptimeMillis();
                event = MotionEvent.obtain(now, now,
                        MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);
                event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
                syntheticEvent = true;
            } 
            {
                TouchTarget target = mFirstTouchTarget;
                target = target.next;
                {
                    resetCancelNextUpFlag(target.child);
                    dispatchTransformedTouchEvent(event, true, target.child, target.pointerIdBits);
                } 
            } 
            clearTouchTargets();
            {
                event.recycle();
            } 
        } 
        addTaint(event.getTaint());
        
        
            
            
                
                
                        
                
                
            
            
                
                
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.993 -0400", hash_original_method = "1855BFFFC59D88D1613C9B59C4B43D4C", hash_generated_method = "05BDB93C0270959602BA3AB8A4DDF518")
    private TouchTarget getTouchTarget(View child) {
        TouchTarget varB4EAC82CA7396A68D541C85D26508E83_991662398 = null; 
        TouchTarget varB4EAC82CA7396A68D541C85D26508E83_1325059790 = null; 
        {
            TouchTarget target = mFirstTouchTarget;
            target = target.next;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_991662398 = target;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1325059790 = null;
        addTaint(child.getTaint());
        TouchTarget varA7E53CE21691AB073D9660D615818899_733937069; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_733937069 = varB4EAC82CA7396A68D541C85D26508E83_991662398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_733937069 = varB4EAC82CA7396A68D541C85D26508E83_1325059790;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_733937069.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_733937069;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.993 -0400", hash_original_method = "70A66C4E824C8984FFB5B6F600FB9D61", hash_generated_method = "AB53CA2B5CCA01710FA6731CA540AFAE")
    private TouchTarget addTouchTarget(View child, int pointerIdBits) {
        TouchTarget varB4EAC82CA7396A68D541C85D26508E83_487636172 = null; 
        TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
        varB4EAC82CA7396A68D541C85D26508E83_487636172 = target;
        addTaint(child.getTaint());
        addTaint(pointerIdBits);
        varB4EAC82CA7396A68D541C85D26508E83_487636172.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_487636172;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.994 -0400", hash_original_method = "89D343983AE77FFA55E239C56C6BE82A", hash_generated_method = "85FCCA886F26F3196A3A91219B9E4ADE")
    private void removePointersFromTouchTargets(int pointerIdBits) {
        TouchTarget predecessor = null;
        TouchTarget target = mFirstTouchTarget;
        {
            final TouchTarget next = target.next;
            {
                target.pointerIdBits &= ~pointerIdBits;
                {
                    {
                        mFirstTouchTarget = next;
                    } 
                    {
                        predecessor.next = next;
                    } 
                    target.recycle();
                    target = next;
                } 
            } 
            predecessor = target;
            target = next;
        } 
        addTaint(pointerIdBits);
        
        
        
        
            
            
                
                
                    
                        
                    
                        
                    
                    
                    
                    
                
            
            
            
        
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean canViewReceivePointerEvents(View child) {
        return (child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                || child.getAnimation() != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.996 -0400", hash_original_method = "DEC14653C28ED7E684FDD980020C985C", hash_generated_method = "5145FA9BC80260D847E7E1071379F3DA")
    protected boolean isTransformedTouchPointInView(float x, float y, View child,
            PointF outLocalPoint) {
        float localX = x + mScrollX - child.mLeft;
        float localY = y + mScrollY - child.mTop;
        {
            boolean var010B39BB8F6D9891F4618A1B3F847C15_332644855 = (! child.hasIdentityMatrix() && mAttachInfo != null);
            {
                final float[] localXY = mAttachInfo.mTmpTransformLocation;
                localXY[0] = localX;
                localXY[1] = localY;
                child.getInverseMatrix().mapPoints(localXY);
                localX = localXY[0];
                localY = localXY[1];
            } 
        } 
        final boolean isInView = child.pointInView(localX, localY);
        {
            outLocalPoint.set(localX, localY);
        } 
        addTaint(x);
        addTaint(y);
        addTaint(child.getTaint());
        addTaint(outLocalPoint.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388563272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388563272;
        
        
        
        
            
            
            
            
            
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.997 -0400", hash_original_method = "EAB22EDFF178A3FABE990E65ADB3332F", hash_generated_method = "03D3972D06FA0C985F26885DCF45C0CF")
    private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
        boolean handled;
        final int oldAction = event.getAction();
        {
            event.setAction(MotionEvent.ACTION_CANCEL);
            {
                handled = super.dispatchTouchEvent(event);
            } 
            {
                handled = child.dispatchTouchEvent(event);
            } 
            event.setAction(oldAction);
        } 
        final int oldPointerIdBits = event.getPointerIdBits();
        final int newPointerIdBits = oldPointerIdBits & desiredPointerIdBits;
        MotionEvent transformedEvent;
        {
            {
                boolean varF3923A48A5FA342E540F86C39C1C463E_2012583046 = (child == null || child.hasIdentityMatrix());
                {
                    {
                        handled = super.dispatchTouchEvent(event);
                    } 
                    {
                        final float offsetX = mScrollX - child.mLeft;
                        final float offsetY = mScrollY - child.mTop;
                        event.offsetLocation(offsetX, offsetY);
                        handled = child.dispatchTouchEvent(event);
                        event.offsetLocation(-offsetX, -offsetY);
                    } 
                } 
            } 
            transformedEvent = MotionEvent.obtain(event);
        } 
        {
            transformedEvent = event.split(newPointerIdBits);
        } 
        {
            handled = super.dispatchTouchEvent(transformedEvent);
        } 
        {
            final float offsetX = mScrollX - child.mLeft;
            final float offsetY = mScrollY - child.mTop;
            transformedEvent.offsetLocation(offsetX, offsetY);
            {
                boolean varAB47417F79C7B7F4A08CD74D30CD9C74_301580203 = (! child.hasIdentityMatrix());
                {
                    transformedEvent.transform(child.getInverseMatrix());
                } 
            } 
            handled = child.dispatchTouchEvent(transformedEvent);
        } 
        transformedEvent.recycle();
        addTaint(event.getTaint());
        addTaint(cancel);
        addTaint(child.getTaint());
        addTaint(desiredPointerIdBits);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630144397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630144397;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.997 -0400", hash_original_method = "2F47BE30FCD7EA97F91B7B6F74081615", hash_generated_method = "5B0B3D2D8A64B687DB9F0C5A1C0D4AE4")
    public void setMotionEventSplittingEnabled(boolean split) {
        {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } 
        {
            mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        } 
        addTaint(split);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.998 -0400", hash_original_method = "F89425D39488194D486F55EA5F8582C3", hash_generated_method = "D598414A104828757F896739FF3D7EF4")
    public boolean isMotionEventSplittingEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649526292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649526292;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.998 -0400", hash_original_method = "1DFD5D86FC853DC6CE8B88AE68ABB735", hash_generated_method = "BD20094AB0BAB14D98C2579999E8C1D4")
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } 
        {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        } 
        {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        } 
        addTaint(disallowIntercept);
        
        
            
        
        
            
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.998 -0400", hash_original_method = "2FB27FC0FD3119EC0BB03A9B8DB1F75C", hash_generated_method = "BE8D52658AEC274625CECCCADCC2F544")
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        
        addTaint(ev.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480348691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480348691;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:58.999 -0400", hash_original_method = "C4273E4BE381C7F0CE1D54BE1CF759CA", hash_generated_method = "7978E0AD6BE49330198113D8B27B664D")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        {
            System.out.println(this + " ViewGroup.requestFocus direction="
                    + direction);
        } 
        int descendantFocusability = getDescendantFocusability();
        
        boolean var47E40A2FCA4828C6DE42D7889D59C941_1251399509 = (super.requestFocus(direction, previouslyFocusedRect));
        
        
        {
            final boolean took = super.requestFocus(direction, previouslyFocusedRect);
            {
                Object var3A5A180257AE9AD15DBCD18319037603_1080564610 = (onRequestFocusInDescendants(direction, previouslyFocusedRect));
            } 
        } 
        
        
        {
            final boolean took = onRequestFocusInDescendants(direction, previouslyFocusedRect);
            {
                Object var7EEFFE453EE8B06336FEADC34AE77D1B_655862469 = (super.requestFocus(direction, previouslyFocusedRect));
            } 
        } 
        
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("descendant focusability must be "
                        + "one of FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS "
                        + "but is " + descendantFocusability);
        
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421147956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421147956;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.000 -0400", hash_original_method = "47C4A34C6E68C9FD22237D5A1759ABE2", hash_generated_method = "B0D0489EC3365B951663E2F58E8594FA")
    @SuppressWarnings({"ConstantConditions"})
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        
        int index;
        int increment;
        int end;
        int count = mChildrenCount;
        {
            index = 0;
            increment = 1;
            end = count;
        } 
        {
            index = count - 1;
            increment = -1;
            end = -1;
        } 
        final View[] children = mChildren;
        {
            int i = index;
            i += increment;
            {
                View child = children[i];
                {
                    {
                        boolean var86823278073885F35F11C1598EACBFE2_1837347098 = (child.requestFocus(direction, previouslyFocusedRect));
                    } 
                } 
            } 
        } 
        addTaint(direction);
        addTaint(previouslyFocusedRect.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146215854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146215854;
        
        
        
        
        
        
            
            
            
        
            
            
            
        
        
        
            
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.000 -0400", hash_original_method = "C10088C0D1BE61F270AE8158B60FC677", hash_generated_method = "3580337FDFD563C83C06B5707A03B094")
    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchStartTemporaryDetach();
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.001 -0400", hash_original_method = "F13891122244193473AAFE5583088FC4", hash_generated_method = "F6BA90EE1CC9499E117A5DBCB6DF1F87")
    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchFinishTemporaryDetach();
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.001 -0400", hash_original_method = "8739A5508C26F7DDD3FFEBEE4CD95BC5", hash_generated_method = "F0841760DA172FEEA5CAECAFA2A73E90")
    @Override
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        visibility |= mViewFlags & VISIBILITY_MASK;
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchAttachedToWindow(info, visibility);
            } 
        } 
        addTaint(info.getTaint());
        addTaint(visibility);
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.001 -0400", hash_original_method = "1EE087DB6D320A1AB0B1F5665AE9972D", hash_generated_method = "6A4FAF7F7D486A0D1E02DA41205939AA")
    @Override
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        boolean handled = super.dispatchPopulateAccessibilityEventInternal(event);
        {
            int i = 0;
            int count = getChildCount();
            {
                View child = getChildAt(i);
                {
                    handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                } 
            } 
        } 
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2078951352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2078951352;
        
        
        
            
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.002 -0400", hash_original_method = "D1F5A3B1D56655AA52CA4B460A89AF1D", hash_generated_method = "6893005B347075798203371421BAE6F3")
    @Override
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        
        super.onInitializeAccessibilityNodeInfoInternal(info);
        {
            int i = 0;
            int count = mChildrenCount;
            {
                View child = mChildren[i];
                {
                    info.addChild(child);
                } 
            } 
        } 
        addTaint(info.getTaint());
        
        
        
            
            
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.002 -0400", hash_original_method = "C93583B1C6CD82E84CFB16E69C063BD6", hash_generated_method = "BB8CD5A85A4F3E7CBE891B08EA8C77B9")
    @Override
     void dispatchDetachedFromWindow() {
        cancelAndClearTouchTargets(null);
        mLayoutSuppressed = false;
        mDragNotifiedChildren = null;
        {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        } 
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                children[i].dispatchDetachedFromWindow();
            } 
        } 
        super.dispatchDetachedFromWindow();
        
        
        
        
        
            
            
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.003 -0400", hash_original_method = "3A8CBF91275A500D30CEFAD8D7209E14", hash_generated_method = "7D2B83FE97EED0B943BA42E5375ABC3C")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        {
            mGroupFlags |= FLAG_PADDING_NOT_NULL;
        } 
        {
            mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        } 
        addTaint(left);
        addTaint(top);
        addTaint(right);
        addTaint(bottom);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.003 -0400", hash_original_method = "0EF6BC3550040660942BB4435DC1568A", hash_generated_method = "F1E823CC23F43206BCC5BF9496AFB040")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        super.dispatchSaveInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                View c = children[i];
                {
                    c.dispatchSaveInstanceState(container);
                } 
            } 
        } 
        addTaint(container.getTaint());
        
        
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.004 -0400", hash_original_method = "38DCBB8C3886F11C25C07FC151CB762B", hash_generated_method = "FF48EB39207BB2570CB12B130D6DA280")
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        super.dispatchSaveInstanceState(container);
        addTaint(container.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.004 -0400", hash_original_method = "79E9ACE6A349ACE584637F3A31A0E869", hash_generated_method = "5126ACFA1B8765AF4D57FAD517B297F4")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        super.dispatchRestoreInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                View c = children[i];
                {
                    c.dispatchRestoreInstanceState(container);
                } 
            } 
        } 
        addTaint(container.getTaint());
        
        
        
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.005 -0400", hash_original_method = "85A5428D5025B10E5C75238A5C358628", hash_generated_method = "5E057FFCDB2EDF6C40625C0594CC8467")
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        super.dispatchRestoreInstanceState(container);
        addTaint(container.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.006 -0400", hash_original_method = "673779FD01170D0D857F4CAC6D3A5472", hash_generated_method = "17576BF1121F780F0D6BA884DF4F52B1")
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        {
            final View[] children = mChildren;
            final int count = mChildrenCount;
            {
                int i = 0;
                {
                    children[i].setDrawingCacheEnabled(enabled);
                } 
            } 
        } 
        addTaint(enabled);
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.007 -0400", hash_original_method = "C6BD5BCC8D99F50AFC626E34071E2FAF", hash_generated_method = "900F3418E6678E6258B9E91FD2C4D466")
    @Override
    protected void onAnimationStart() {
        
        super.onAnimationStart();
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            final boolean buildCache = !isHardwareAccelerated();
            {
                int i = 0;
                {
                    final View child = children[i];
                    {
                        child.setDrawingCacheEnabled(true);
                        {
                            child.buildDrawingCache(true);
                        } 
                    } 
                } 
            } 
            mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        } 
        
        
        
            
            
            
            
                
                
                    
                    
                        
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.007 -0400", hash_original_method = "D937B1A7AD9A1EFB7CAF69E9B3174965", hash_generated_method = "35CEF9D8DFD04C9C6DD4F44A075F19A5")
    @Override
    protected void onAnimationEnd() {
        
        super.onAnimationEnd();
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            {
                setChildrenDrawingCacheEnabled(false);
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.008 -0400", hash_original_method = "8B8B5866E6978A8C0D1BC17BB86DCAFE", hash_generated_method = "4EB2A0ED68FDF8505FC019C5B9DCAF24")
    @Override
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1854346948 = null; 
        int count = mChildrenCount;
        int[] visibilities = null;
        {
            visibilities = new int[count];
            {
                int i = 0;
                {
                    View child = getChildAt(i);
                    visibilities[i] = child.getVisibility();
                    {
                        child.setVisibility(INVISIBLE);
                    } 
                } 
            } 
        } 
        Bitmap b = super.createSnapshot(quality, backgroundColor, skipChildren);
        {
            {
                int i = 0;
                {
                    getChildAt(i).setVisibility(visibilities[i]);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1854346948 = b;
        addTaint(quality.getTaint());
        addTaint(backgroundColor);
        addTaint(skipChildren);
        varB4EAC82CA7396A68D541C85D26508E83_1854346948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1854346948;
        
        
        
        
            
            
                
                
                
                    
                
            
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.009 -0400", hash_original_method = "B43A05A63ADF740A4A15894A451E95C0", hash_generated_method = "A12ACCFDB33912FB9219323B788C6BCB")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        final int count = mChildrenCount;
        final View[] children = mChildren;
        int flags = mGroupFlags;
        {
            boolean var07BB33E4D87E2B5D2A8FEE502EA9E8CD_916124733 = ((flags & FLAG_RUN_ANIMATION) != 0 && canAnimate());
            {
                final boolean cache = (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
                final boolean buildCache = !isHardwareAccelerated();
                {
                    int i = 0;
                    {
                        final View child = children[i];
                        {
                            final LayoutParams params = child.getLayoutParams();
                            attachLayoutAnimationParameters(child, params, i, count);
                            bindLayoutAnimation(child);
                            {
                                child.setDrawingCacheEnabled(true);
                                {
                                    child.buildDrawingCache(true);
                                } 
                            } 
                        } 
                    } 
                } 
                final LayoutAnimationController controller = mLayoutAnimationController;
                {
                    boolean varE5D19A1FB2EF5ECD65C0B52011051B10_557415713 = (controller.willOverlap());
                    {
                        mGroupFlags |= FLAG_OPTIMIZE_INVALIDATE;
                    } 
                } 
                controller.start();
                mGroupFlags &= ~FLAG_RUN_ANIMATION;
                mGroupFlags &= ~FLAG_ANIMATION_DONE;
                {
                    mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
                } 
                {
                    mAnimationListener.onAnimationStart(controller.getAnimation());
                } 
            } 
        } 
        int saveCount = 0;
        final boolean clipToPadding = (flags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
        {
            saveCount = canvas.save();
            canvas.clipRect(mScrollX + mPaddingLeft, mScrollY + mPaddingTop,
                    mScrollX + mRight - mLeft - mPaddingRight,
                    mScrollY + mBottom - mTop - mPaddingBottom);
        } 
        mPrivateFlags &= ~DRAW_ANIMATION;
        mGroupFlags &= ~FLAG_INVALIDATE_REQUIRED;
        boolean more = false;
        final long drawingTime = getDrawingTime();
        {
            {
                int i = 0;
                {
                    final View child = children[i];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_656067474 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
                {
                    final View child = children[getChildDrawingOrder(count, i)];
                    {
                        boolean var0BDBDC6C68643B603A84C571827EFEE7_1246735006 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                        {
                            more |= drawChild(canvas, child, drawingTime);
                        } 
                    } 
                } 
            } 
        } 
        {
            final ArrayList<View> disappearingChildren = mDisappearingChildren;
            final int disappearingCount = disappearingChildren.size() - 1;
            {
                int i = disappearingCount;
                {
                    final View child = disappearingChildren.get(i);
                    more |= drawChild(canvas, child, drawingTime);
                } 
            } 
        } 
        {
            canvas.restoreToCount(saveCount);
        } 
        flags = mGroupFlags;
        {
            invalidate(true);
        } 
        {
            boolean var76A6DBFAA8B517B1E30D0F77E8BBAB75_1055230987 = ((flags & FLAG_ANIMATION_DONE) == 0 && (flags & FLAG_NOTIFY_ANIMATION_LISTENER) == 0 &&
                mLayoutAnimationController.isDone() && !more);
            {
                mGroupFlags |= FLAG_NOTIFY_ANIMATION_LISTENER;
                final Runnable end = new Runnable() {
               public void run() {
                   notifyAnimationListener();
               }
            };
                post(end);
            } 
        } 
        addTaint(canvas.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.010 -0400", hash_original_method = "314AC469B646186EB8E30D4AB123CD56", hash_generated_method = "5CD0697E864F90DA4DA7FFAFBCEEC015")
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(childCount);
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194024517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194024517;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.010 -0400", hash_original_method = "396DFE394BEDDAB737694626CE3DE3EF", hash_generated_method = "37D71548349BED70A3914C1D49760112")
    private void notifyAnimationListener() {
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        {
            final Runnable end = new Runnable() {
               public void run() {
                   mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               }
           };
            post(end);
        } 
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            {
                setChildrenDrawingCacheEnabled(false);
            } 
        } 
        invalidate(true);
        
        
        
        
           
               
                   
               
           
           
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.010 -0400", hash_original_method = "F4EA27B0452D996E61B8467125C95A50", hash_generated_method = "92392593710BDD44FC3F46ED4705AB11")
    @Override
    protected void dispatchGetDisplayList() {
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                final View child = children[i];
                {
                    boolean var735C012AD3EAE6449E3DE234B2B9D1C4_1951452355 = (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    child.hasStaticLayer());
                    {
                        child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                        child.mPrivateFlags &= ~INVALIDATED;
                        child.getDisplayList();
                        child.mRecreateDisplayList = false;
                    } 
                } 
            } 
        } 
        
        
        
        
            
            
                    
                
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.013 -0400", hash_original_method = "A5CF70DDE358EAA9D1CA892FF372BD55", hash_generated_method = "DCB8A8142E8A6637F6DACFE06BB680BA")
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        boolean more = false;
        final int cl = child.mLeft;
        final int ct = child.mTop;
        final int cr = child.mRight;
        final int cb = child.mBottom;
        final boolean childHasIdentityMatrix = child.hasIdentityMatrix();
        final int flags = mGroupFlags;
        {
            mChildTransformation.clear();
            mGroupFlags &= ~FLAG_CLEAR_TRANSFORMATION;
        } 
        Transformation transformToApply = null;
        Transformation invalidationTransform;
        final Animation a = child.getAnimation();
        boolean concatMatrix = false;
        boolean scalingRequired = false;
        boolean caching;
        int layerType;
        layerType = child.getLayerType();
        layerType = LAYER_TYPE_NONE;
        final boolean hardwareAccelerated = canvas.isHardwareAccelerated();
        {
            caching = true;
            scalingRequired = mAttachInfo.mScalingRequired;
        } 
        {
            caching = (layerType != LAYER_TYPE_NONE) || hardwareAccelerated;
        } 
        {
            final boolean initialized = a.isInitialized();
            {
                a.initialize(cr - cl, cb - ct, getWidth(), getHeight());
                a.initializeInvalidateRegion(0, 0, cr - cl, cb - ct);
                child.onAnimationStart();
            } 
            more = a.getTransformation(drawingTime, mChildTransformation,
                    scalingRequired ? mAttachInfo.mApplicationScale : 1f);
            {
                {
                    mInvalidationTransformation = new Transformation();
                } 
                invalidationTransform = mInvalidationTransformation;
                a.getTransformation(drawingTime, invalidationTransform, 1f);
            } 
            {
                invalidationTransform = mChildTransformation;
            } 
            transformToApply = mChildTransformation;
            concatMatrix = a.willChangeTransformationMatrix();
            {
                {
                    boolean var489AF36514F0C5F8ABF92D9ED1EEF69B_146032569 = (!a.willChangeBounds());
                    {
                        {
                            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                        } 
                        {
                            mPrivateFlags |= DRAW_ANIMATION;
                            invalidate(cl, ct, cr, cb);
                        } 
                    } 
                    {
                        {
                            mInvalidateRegion = new RectF();
                        } 
                        final RectF region = mInvalidateRegion;
                        a.getInvalidateRegion(0, 0, cr - cl, cb - ct, region, invalidationTransform);
                        mPrivateFlags |= DRAW_ANIMATION;
                        final int left = cl + (int) region.left;
                        final int top = ct + (int) region.top;
                        invalidate(left, top, left + (int) (region.width() + .5f),
                            top + (int) (region.height() + .5f));
                    } 
                } 
            } 
        } 
        {
            final boolean hasTransform = getChildStaticTransformation(child, mChildTransformation);
            {
                final int transformType = mChildTransformation.getTransformationType();
                transformToApply = transformType != Transformation.TYPE_IDENTITY ?
                        mChildTransformation : null;
                concatMatrix = (transformType & Transformation.TYPE_MATRIX) != 0;
            } 
        } 
        concatMatrix |= !childHasIdentityMatrix;
        child.mPrivateFlags |= DRAWN;
        {
            boolean var04A9779EE766FABCC1352F467BA0AB22_222749774 = (!concatMatrix && canvas.quickReject(cl, ct, cr, cb, Canvas.EdgeType.BW) &&
                (child.mPrivateFlags & DRAW_ANIMATION) == 0);
        } 
        {
            child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
            child.mPrivateFlags &= ~INVALIDATED;
        } 
        child.computeScroll();
        final int sx = child.mScrollX;
        final int sy = child.mScrollY;
        DisplayList displayList = null;
        Bitmap cache = null;
        boolean hasDisplayList = false;
        {
            {
                {
                    layerType = LAYER_TYPE_SOFTWARE;
                    child.buildDrawingCache(true);
                } 
                cache = child.getDrawingCache(true);
            } 
            {
                
                child.buildDrawingCache(true);
                
                
                cache = child.getDrawingCache(true);
                
                
                hasDisplayList = child.canHaveDisplayList();
                
            } 
        } 
        final boolean hasNoCache = cache == null || hasDisplayList;
        final boolean offsetForScroll = cache == null && !hasDisplayList &&
                layerType != LAYER_TYPE_HARDWARE;
        final int restoreTo = canvas.save();
        {
            canvas.translate(cl - sx, ct - sy);
        } 
        {
            canvas.translate(cl, ct);
            {
                final float scale = 1.0f / mAttachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } 
        } 
        float alpha = child.getAlpha();
        {
            boolean var934B3E69D3ACD833C0B88FE85A1125E9_65103120 = (transformToApply != null || alpha < 1.0f || !child.hasIdentityMatrix());
            {
                {
                    int transX = 0;
                    int transY = 0;
                    {
                        transX = -sx;
                        transY = -sy;
                    } 
                    {
                        {
                            canvas.translate(-transX, -transY);
                            canvas.concat(transformToApply.getMatrix());
                            canvas.translate(transX, transY);
                            mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                        } 
                        float transformAlpha = transformToApply.getAlpha();
                        {
                            alpha *= transformToApply.getAlpha();
                            mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                        } 
                    } 
                    {
                        canvas.translate(-transX, -transY);
                        canvas.concat(child.getMatrix());
                        canvas.translate(transX, transY);
                    } 
                } 
                {
                    mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                    {
                        final int multipliedAlpha = (int) (255 * alpha);
                        {
                            boolean varFF146FCD683FC819B246FAE0328227BA_972016042 = (!child.onSetAlpha(multipliedAlpha));
                            {
                                int layerFlags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
                                {
                                    layerFlags |= Canvas.CLIP_TO_LAYER_SAVE_FLAG;
                                } 
                                {
                                    int scrollX;
                                    scrollX = 0;
                                    scrollX = sx;
                                    int scrollY;
                                    scrollY = 0;
                                    scrollY = sy;
                                    canvas.saveLayerAlpha(scrollX, scrollY, scrollX + cr - cl,
                                    scrollY + cb - ct, multipliedAlpha, layerFlags);
                                } 
                            } 
                            {
                                child.mPrivateFlags |= ALPHA_SET;
                            } 
                        } 
                    } 
                } 
            } 
            {
                child.onSetAlpha(255);
                child.mPrivateFlags &= ~ALPHA_SET;
            } 
        } 
        {
            {
                canvas.clipRect(sx, sy, sx + (cr - cl), sy + (cb - ct));
            } 
            {
                {
                    canvas.clipRect(0, 0, cr - cl, cb - ct);
                } 
                {
                    canvas.clipRect(0, 0, cache.getWidth(), cache.getHeight());
                } 
            } 
        } 
        {
            displayList = child.getDisplayList();
            {
                boolean var9C584955B3CFEF7798B020C1B8079C6D_1006609125 = (!displayList.isValid());
                {
                    displayList = null;
                    hasDisplayList = false;
                } 
            } 
        } 
        {
            boolean layerRendered = false;
            {
                final HardwareLayer layer = child.getHardwareLayer();
                {
                    boolean varF47BB7BA46927B23DD4F75E227100F6C_995015808 = (layer != null && layer.isValid());
                    {
                        child.mLayerPaint.setAlpha((int) (alpha * 255));
                        ((HardwareCanvas) canvas).drawHardwareLayer(layer, 0, 0, child.mLayerPaint);
                        layerRendered = true;
                    } 
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
                    } 
                } 
            } 
            {
                {
                    {
                        {
                            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                        } 
                        child.mPrivateFlags &= ~DIRTY_MASK;
                        child.dispatchDraw(canvas);
                    } 
                    {
                        child.draw(canvas);
                    } 
                } 
                {
                    child.mPrivateFlags &= ~DIRTY_MASK;
                    ((HardwareCanvas) canvas).drawDisplayList(displayList, cr - cl, cb - ct, null);
                } 
            } 
        } 
        {
            child.mPrivateFlags &= ~DIRTY_MASK;
            Paint cachePaint;
            {
                cachePaint = mCachePaint;
                {
                    cachePaint = new Paint();
                    cachePaint.setDither(false);
                    mCachePaint = cachePaint;
                } 
                {
                    cachePaint.setAlpha((int) (alpha * 255));
                    mGroupFlags |= FLAG_ALPHA_LOWER_THAN_ONE;
                } 
                {
                    cachePaint.setAlpha(255);
                    mGroupFlags &= ~FLAG_ALPHA_LOWER_THAN_ONE;
                } 
            } 
            {
                cachePaint = child.mLayerPaint;
                cachePaint.setAlpha((int) (alpha * 255));
            } 
            canvas.drawBitmap(cache, 0.0f, 0.0f, cachePaint);
        } 
        canvas.restoreToCount(restoreTo);
        {
            {
                boolean varAF4EC4CBE7F4BE862D45CC273E5600AE_716223063 = (!hardwareAccelerated && !a.getFillAfter());
                {
                    child.onSetAlpha(255);
                } 
            } 
            finishAnimatingView(child, a);
        } 
        {
            invalidate(true);
            {
                boolean var14BEB88AF6F19C239671B73A03DA27C1_731520628 = (a.hasAlpha() && (child.mPrivateFlags & ALPHA_SET) == ALPHA_SET);
                {
                    child.invalidate(true);
                } 
            } 
        } 
        child.mRecreateDisplayList = false;
        addTaint(canvas.getTaint());
        addTaint(child.getTaint());
        addTaint(drawingTime);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829758053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829758053;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.014 -0400", hash_original_method = "4095F0AE1BAE27A3A14B16FD7C3431AE", hash_generated_method = "2DE6A392E82B94775B398BE43E9D49DB")
    public void setChildrenLayersEnabled(boolean enabled) {
        {
            mDrawLayers = enabled;
            invalidate(true);
            {
                int i = 0;
                {
                    View child = mChildren[i];
                    {
                        child.invalidate(true);
                    } 
                } 
            } 
        } 
        
        
            
            
            
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.014 -0400", hash_original_method = "1DB85DBA1331DEE146504B0E70B65BE5", hash_generated_method = "38D6A5E8338839B635ADB7C95D35DC38")
    public void setClipChildren(boolean clipChildren) {
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
        addTaint(clipChildren);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.015 -0400", hash_original_method = "863AF54978AA2727D0D7509C22DC212D", hash_generated_method = "FE6B05C3B5C693AA7797D22B0F953BD0")
    public void setClipToPadding(boolean clipToPadding) {
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
        addTaint(clipToPadding);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.015 -0400", hash_original_method = "8ABEEBF76C5626CBEA0073E7871E08E9", hash_generated_method = "878A4987E3923CAE3148B05C491B3192")
    @Override
    public void dispatchSetSelected(boolean selected) {
        final View[] children = mChildren;
        final int count = mChildrenCount;
        {
            int i = 0;
            {
                children[i].setSelected(selected);
            } 
        } 
        addTaint(selected);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.015 -0400", hash_original_method = "2F91B8D19CDC8A9E83F3387815EB4D3F", hash_generated_method = "5A1A51CCA813E32AA84591D8601DF84B")
    @Override
    public void dispatchSetActivated(boolean activated) {
        final View[] children = mChildren;
        final int count = mChildrenCount;
        {
            int i = 0;
            {
                children[i].setActivated(activated);
            } 
        } 
        addTaint(activated);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.016 -0400", hash_original_method = "741F0E8D45382BBF6BA56C96532A94D8", hash_generated_method = "D4F79F56C7FCA3657E411804EEA7E233")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        final View[] children = mChildren;
        final int count = mChildrenCount;
        {
            int i = 0;
            {
                children[i].setPressed(pressed);
            } 
        } 
        addTaint(pressed);
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.016 -0400", hash_original_method = "BD73AAD871B8740D29315EE305D10F4B", hash_generated_method = "6725A8BB4E7F5A1EF4371361264018C1")
    protected void setStaticTransformationsEnabled(boolean enabled) {
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.017 -0400", hash_original_method = "767004ADA8C3853AF520B9D176A534BE", hash_generated_method = "84F2DC0C67BEEAE6BD9D2341933B84AD")
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        addTaint(child.getTaint());
        addTaint(t.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435909983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435909983;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.018 -0400", hash_original_method = "8C56D4BEA5FE426CA6EBD73A64039E70", hash_generated_method = "BD7F3ED96960A88C795A3522C92653E0")
    @Override
    protected View findViewTraversal(int id) {
        View varB4EAC82CA7396A68D541C85D26508E83_131842363 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_486519027 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_427506726 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_131842363 = this;
        } 
        final View[] where = mChildren;
        final int len = mChildrenCount;
        {
            int i = 0;
            {
                View v = where[i];
                {
                    v = v.findViewById(id);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_486519027 = v;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_427506726 = null;
        addTaint(id);
        View varA7E53CE21691AB073D9660D615818899_941338092; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_941338092 = varB4EAC82CA7396A68D541C85D26508E83_131842363;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_941338092 = varB4EAC82CA7396A68D541C85D26508E83_486519027;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_941338092 = varB4EAC82CA7396A68D541C85D26508E83_427506726;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_941338092.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_941338092;
        
        
            
        
        
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.020 -0400", hash_original_method = "D087F3465F923453754E64A11DB6BED1", hash_generated_method = "2FE436788741F1AD654111D64BD99FEC")
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        View varB4EAC82CA7396A68D541C85D26508E83_185844916 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1461648900 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_2118019093 = null; 
        {
            boolean var400CEDD09F5544D49C9E372D9C42B91E_53075433 = (tag != null && tag.equals(mTag));
            {
                varB4EAC82CA7396A68D541C85D26508E83_185844916 = this;
            } 
        } 
        final View[] where = mChildren;
        final int len = mChildrenCount;
        {
            int i = 0;
            {
                View v = where[i];
                {
                    v = v.findViewWithTag(tag);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1461648900 = v;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2118019093 = null;
        addTaint(tag.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1844197077; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1844197077 = varB4EAC82CA7396A68D541C85D26508E83_185844916;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1844197077 = varB4EAC82CA7396A68D541C85D26508E83_1461648900;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1844197077 = varB4EAC82CA7396A68D541C85D26508E83_2118019093;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1844197077.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1844197077;
        
        
            
        
        
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.021 -0400", hash_original_method = "0EC5116F4AD2AA9CFA72F9149C3A9529", hash_generated_method = "67238C750F7B9A7F6249259AC27B6AD5")
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        View varB4EAC82CA7396A68D541C85D26508E83_802644357 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1755355367 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_945946552 = null; 
        {
            boolean var9DB3C1E357F4608DF2A7064AE311774F_1690908305 = (predicate.apply(this));
            {
                varB4EAC82CA7396A68D541C85D26508E83_802644357 = this;
            } 
        } 
        final View[] where = mChildren;
        final int len = mChildrenCount;
        {
            int i = 0;
            {
                View v = where[i];
                {
                    v = v.findViewByPredicate(predicate);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1755355367 = v;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_945946552 = null;
        addTaint(predicate.getTaint());
        addTaint(childToSkip.getTaint());
        View varA7E53CE21691AB073D9660D615818899_98539755; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_98539755 = varB4EAC82CA7396A68D541C85D26508E83_802644357;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_98539755 = varB4EAC82CA7396A68D541C85D26508E83_1755355367;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_98539755 = varB4EAC82CA7396A68D541C85D26508E83_945946552;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_98539755.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_98539755;
        
        
            
        
        
        
        
            
            
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.021 -0400", hash_original_method = "CEC5DF3412108DC355B81A234F778717", hash_generated_method = "181C858E645E3A406557787AB3FC2125")
    public void addView(View child) {
        addView(child, -1);
        addTaint(child.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.022 -0400", hash_original_method = "052049806EFDCB28F8B1780970FB4D61", hash_generated_method = "18DC8CAC5BFE5BB6A5E950F63B31EEA6")
    public void addView(View child, int index) {
        LayoutParams params = child.getLayoutParams();
        {
            params = generateDefaultLayoutParams();
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            } 
        } 
        addView(child, index, params);
        addTaint(child.getTaint());
        addTaint(index);
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.022 -0400", hash_original_method = "04069655751E8F150919B197DB2D0EF4", hash_generated_method = "903EA1C4AA122BCBF061D3ECB277EA67")
    public void addView(View child, int width, int height) {
        final LayoutParams params = generateDefaultLayoutParams();
        params.width = width;
        params.height = height;
        addView(child, -1, params);
        addTaint(child.getTaint());
        addTaint(width);
        addTaint(height);
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.022 -0400", hash_original_method = "CAABD1DBDF747222034CC373BA6381CC", hash_generated_method = "641806D60D8710F22CD9342A56CC8848")
    public void addView(View child, LayoutParams params) {
        addView(child, -1, params);
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.023 -0400", hash_original_method = "BD78A36687CEEF62B7E0786E86501A2F", hash_generated_method = "EFB26DE6BD295DBB249DFC9C64A140D7")
    public void addView(View child, int index, LayoutParams params) {
        {
            System.out.println(this + " addView");
        } 
        requestLayout();
        invalidate(true);
        addViewInner(child, index, params, false);
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.023 -0400", hash_original_method = "8137D76BAD6EAD8C2AFF7B0DC7EC38EA", hash_generated_method = "366667A113A9FCBB613DF8F656781597")
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_1706817072 = (!checkLayoutParams(params));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
            } 
        } 
        {
            boolean var8034A81DF8A049A1DEC5A101D1129C23_790275386 = (view.mParent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Given view not a child of " + this);
            } 
        } 
        view.setLayoutParams(params);
        addTaint(view.getTaint());
        addTaint(params.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.023 -0400", hash_original_method = "C2EE5015ED0F9B04763A6A0F4C905EDB", hash_generated_method = "78D8D8A9F01E64F878B4E3ABC24C0D1F")
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924207052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924207052;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.024 -0400", hash_original_method = "2EFEB52353D2008493D1621282A03886", hash_generated_method = "7C3C20C1075C2C96B31EA398AE09593A")
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        mOnHierarchyChangeListener = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.024 -0400", hash_original_method = "7C8375F0DCFCC6770307465540C43F29", hash_generated_method = "3B4A13063E631F9E09957E2CE7CAEDBA")
    protected void onViewAdded(View child) {
        
        {
            mOnHierarchyChangeListener.onChildViewAdded(this, child);
        } 
        addTaint(child.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.024 -0400", hash_original_method = "2969A02DF6E73517C4A5610098A20201", hash_generated_method = "E7BD940E5C959E96F9765F094B55BFF8")
    protected void onViewRemoved(View child) {
        
        {
            mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        } 
        addTaint(child.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.025 -0400", hash_original_method = "4EC56F492B64387EC5CDEE559C919DD8", hash_generated_method = "AA2916C238550429E34E726A93AFA952")
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        boolean varC93AA663A5550227DF73E011E019C03E_1216563172 = (addViewInLayout(child, index, params, false));
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448145848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448145848;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.025 -0400", hash_original_method = "621D5EA894CECBBA3C5FE5D7159CF1D3", hash_generated_method = "C2A170EA18C626A1A1DF901A11BEF30F")
    protected boolean addViewInLayout(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        child.mParent = null;
        addViewInner(child, index, params, preventRequestLayout);
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        addTaint(preventRequestLayout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562817598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562817598;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.026 -0400", hash_original_method = "156A75B155CF89ADA3C99A75E911D53A", hash_generated_method = "F7447FAC479522D7F2DD4257603BD30D")
    protected void cleanupLayoutState(View child) {
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
        addTaint(child.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.026 -0400", hash_original_method = "4623983FE5D2926EED9F934007E41D76", hash_generated_method = "3E56C35581026507AB35EE8C1517A9E2")
    private void addViewInner(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        {
            mTransition.cancel(LayoutTransition.DISAPPEARING);
        } 
        {
            boolean varA3364C4A63F6A263A8814AE455A29C59_1245912690 = (child.getParent() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The specified child already has a parent. " +
                    "You must call removeView() on the child's parent first.");
            } 
        } 
        {
            mTransition.addChild(this, child);
        } 
        {
            boolean varDBEE735151EA33B4B64A3ED748755A2D_1596158363 = (!checkLayoutParams(params));
            {
                params = generateLayoutParams(params);
            } 
        } 
        {
            child.mLayoutParams = params;
        } 
        {
            child.setLayoutParams(params);
        } 
        {
            index = mChildrenCount;
        } 
        addInArray(child, index);
        {
            child.assignParent(this);
        } 
        {
            child.mParent = this;
        } 
        {
            boolean varDDA55DF480817D6313066967525E9186_1324634642 = (child.hasFocus());
            {
                requestChildFocus(child, child.findFocus());
            } 
        } 
        AttachInfo ai = mAttachInfo;
        {
            boolean lastKeepOn = ai.mKeepScreenOn;
            ai.mKeepScreenOn = false;
            child.dispatchAttachedToWindow(mAttachInfo, (mViewFlags&VISIBILITY_MASK));
            {
                needGlobalAttributesUpdate(true);
            } 
            ai.mKeepScreenOn = lastKeepOn;
        } 
        onViewAdded(child);
        {
            mGroupFlags |= FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE;
        } 
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        addTaint(preventRequestLayout);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.027 -0400", hash_original_method = "3DC226B361362F1A66E4DF7340FD46AC", hash_generated_method = "2F35AFD19F34029827CAAF8ECC2A82F7")
    private void addInArray(View child, int index) {
        View[] children = mChildren;
        final int count = mChildrenCount;
        final int size = children.length;
        {
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, size);
                children = mChildren;
            } 
            children[mChildrenCount++] = child;
        } 
        {
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, index);
                System.arraycopy(children, index, mChildren, index + 1, count - index);
                children = mChildren;
            } 
            {
                System.arraycopy(children, index, children, index + 1, count - index);
            } 
            children[index] = child;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + " count=" + count);
        } 
        addTaint(index);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.029 -0400", hash_original_method = "666B846103F98929B6C3984DF363A458", hash_generated_method = "35E277EEBE6CB265C8010BDE77790FB2")
    private void removeFromArray(int index) {
        final View[] children = mChildren;
        {
            boolean varFD7C05E4772169FABFE9822CC2FF40CC_520948876 = (!(mTransitioningViews != null && mTransitioningViews.contains(children[index])));
            {
                children[index].mParent = null;
            } 
        } 
        final int count = mChildrenCount;
        {
            children[--mChildrenCount] = null;
        } 
        {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } 
        {
            mLastTouchDownTime = 0;
            mLastTouchDownIndex = -1;
        } 
        addTaint(index);
        
        
        
            
        
        
        
            
        
            
            
        
            
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.030 -0400", hash_original_method = "7377DC4CCC7ACF33951FFC91A9C19242", hash_generated_method = "41EB6CEFEC38BA88858CBEAEDBC6F830")
    private void removeFromArray(int start, int count) {
        final View[] children = mChildren;
        final int childrenCount = mChildrenCount;
        start = Math.max(0, start);
        final int end = Math.min(childrenCount, start + count);
        {
            {
                int i = start;
                {
                    children[i].mParent = null;
                    children[i] = null;
                } 
            } 
        } 
        {
            {
                int i = start;
                {
                    children[i].mParent = null;
                } 
            } 
            System.arraycopy(children, end, children, start, childrenCount - end);
            {
                int i = childrenCount - (end - start);
                {
                    children[i] = null;
                } 
            } 
        } 
        mChildrenCount -= (end - start);
        addTaint(count);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.030 -0400", hash_original_method = "0C13B6720EDD2CD731BF86C88080EC0A", hash_generated_method = "BF744C98ADAC0531660F3065C9E4D3F9")
    private void bindLayoutAnimation(View child) {
        Animation a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
        addTaint(child.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.030 -0400", hash_original_method = "53A696BC845D59D084861C4C39417C50", hash_generated_method = "2CC4761E9A77F5F5C2CF73CA86745C87")
    protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count) {
        LayoutAnimationController.AnimationParameters animationParams = params.layoutAnimationParameters;
        {
            animationParams = new LayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } 
        animationParams.count = count;
        animationParams.index = index;
        addTaint(child.getTaint());
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(count);
        
        
                    
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.031 -0400", hash_original_method = "D47B7EA927C9C6E9F8463F22FA8E7751", hash_generated_method = "B4A6928DAD41F623A316349C15146FB6")
    public void removeView(View view) {
        removeViewInternal(view);
        requestLayout();
        invalidate(true);
        addTaint(view.getTaint());
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.031 -0400", hash_original_method = "9C0189C4A93DBFF4CA9135E979534627", hash_generated_method = "CFAB7C83D15D49D12037A7C36C135022")
    public void removeViewInLayout(View view) {
        removeViewInternal(view);
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.031 -0400", hash_original_method = "CCED8E1F5C1435811C77FC8E195AA3ED", hash_generated_method = "BC3DB41E3643A6FAC062F7C261CBAFF2")
    public void removeViewsInLayout(int start, int count) {
        removeViewsInternal(start, count);
        addTaint(start);
        addTaint(count);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.032 -0400", hash_original_method = "C7B982345E14E4BA654D9B702D09B782", hash_generated_method = "5AE6ACDAC5A60F10B971383535FCD4EF")
    public void removeViewAt(int index) {
        removeViewInternal(index, getChildAt(index));
        requestLayout();
        invalidate(true);
        addTaint(index);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.032 -0400", hash_original_method = "295E3CFFAAE54DAD76DF23980004A9FB", hash_generated_method = "7C8BFD498DD87D4938235AC47BDFABC5")
    public void removeViews(int start, int count) {
        removeViewsInternal(start, count);
        requestLayout();
        invalidate(true);
        addTaint(start);
        addTaint(count);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.032 -0400", hash_original_method = "A8C7AA662547BF9F482FBD0CAAADED6D", hash_generated_method = "343F963527A14A711007C30F0151AB76")
    private void removeViewInternal(View view) {
        final int index = indexOfChild(view);
        {
            removeViewInternal(index, view);
        } 
        addTaint(view.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.033 -0400", hash_original_method = "5145400D128FAA852B030ECA7E0E5CC6", hash_generated_method = "FE3514E042F873414BD0742384B3B62D")
    private void removeViewInternal(int index, View view) {
        {
            mTransition.removeChild(this, view);
        } 
        boolean clearChildFocus = false;
        {
            view.clearFocusForRemoval();
            clearChildFocus = true;
        } 
        {
            boolean var74C8DDDF999D66AA3EB9771E0CD6D718_2137500750 = (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)));
            {
                addDisappearingView(view);
            } 
            {
                view.dispatchDetachedFromWindow();
            } 
        } 
        onViewRemoved(view);
        needGlobalAttributesUpdate(false);
        removeFromArray(index);
        {
            clearChildFocus(view);
        } 
        addTaint(index);
        addTaint(view.getTaint());
        
        
            
        
        
        
            
            
        
        
                
            
        
           
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.033 -0400", hash_original_method = "6CC26F3EB4840902E7233D2C3E46A07B", hash_generated_method = "B97821E95017FC95C215DC451B5D2A85")
    public void setLayoutTransition(LayoutTransition transition) {
        {
            mTransition.removeTransitionListener(mLayoutTransitionListener);
        } 
        mTransition = transition;
        {
            mTransition.addTransitionListener(mLayoutTransitionListener);
        } 
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.033 -0400", hash_original_method = "33E35321C94CA74A9D9819C2C9739D2F", hash_generated_method = "06392D28E22B097227DC208FC0135457")
    public LayoutTransition getLayoutTransition() {
        LayoutTransition varB4EAC82CA7396A68D541C85D26508E83_1464901344 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1464901344 = mTransition;
        varB4EAC82CA7396A68D541C85D26508E83_1464901344.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1464901344;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.034 -0400", hash_original_method = "F40E247B6ABF822EB65FF56F80411035", hash_generated_method = "DD666CAEA53785876B4C2DC4A6CCC88D")
    private void removeViewsInternal(int start, int count) {
        final View focused = mFocused;
        final boolean detach = mAttachInfo != null;
        View clearChildFocus = null;
        final View[] children = mChildren;
        final int end = start + count;
        {
            int i = start;
            {
                final View view = children[i];
                {
                    mTransition.removeChild(this, view);
                } 
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } 
                {
                    boolean var771BCD00CE5FBF80B4F7B15D3C6EBC5E_1748476551 = (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)));
                    {
                        addDisappearingView(view);
                    } 
                    {
                        view.dispatchDetachedFromWindow();
                    } 
                } 
                needGlobalAttributesUpdate(false);
                onViewRemoved(view);
            } 
        } 
        removeFromArray(start, count);
        {
            clearChildFocus(clearChildFocus);
        } 
        addTaint(start);
        addTaint(count);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.034 -0400", hash_original_method = "C167CC912DB398153B3FBDE6D6503FBD", hash_generated_method = "251074A9D0FEFE564BF870888680CE2E")
    public void removeAllViews() {
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.035 -0400", hash_original_method = "8DFE71C1BEB57BA28106B31D5772632E", hash_generated_method = "849D17553B5744CC17AB29FB25D6EEAB")
    public void removeAllViewsInLayout() {
        final int count = mChildrenCount;
        final View[] children = mChildren;
        mChildrenCount = 0;
        final View focused = mFocused;
        final boolean detach = mAttachInfo != null;
        View clearChildFocus = null;
        needGlobalAttributesUpdate(false);
        {
            int i = count - 1;
            {
                final View view = children[i];
                {
                    mTransition.removeChild(this, view);
                } 
                {
                    view.clearFocusForRemoval();
                    clearChildFocus = view;
                } 
                {
                    boolean var25706AD565CAAA05294A1680813DB393_1319997401 = (view.getAnimation() != null ||
                    (mTransitioningViews != null && mTransitioningViews.contains(view)));
                    {
                        addDisappearingView(view);
                    } 
                    {
                        view.dispatchDetachedFromWindow();
                    } 
                } 
                onViewRemoved(view);
                view.mParent = null;
                children[i] = null;
            } 
        } 
        {
            clearChildFocus(clearChildFocus);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.036 -0400", hash_original_method = "80D629C332B0E93DD7A33AD3708E672D", hash_generated_method = "42D657DC7032922132EB1F4D96B39131")
    protected void removeDetachedView(View child, boolean animate) {
        {
            mTransition.removeChild(this, child);
        } 
        {
            child.clearFocus();
        } 
        {
            boolean varC784B3814A6616C601A69CC572D538AE_767374823 = ((animate && child.getAnimation() != null) ||
                (mTransitioningViews != null && mTransitioningViews.contains(child)));
            {
                addDisappearingView(child);
            } 
            {
                child.dispatchDetachedFromWindow();
            } 
        } 
        onViewRemoved(child);
        addTaint(child.getTaint());
        addTaint(animate);
        
        
            
        
        
            
        
        
                
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.036 -0400", hash_original_method = "8472A11DDB1452C7DB4257A960216E78", hash_generated_method = "EEF4F60BE8A6EA1AAD7AA1A6BC783CC3")
    protected void attachViewToParent(View child, int index, LayoutParams params) {
        child.mLayoutParams = params;
        {
            index = mChildrenCount;
        } 
        addInArray(child, index);
        child.mParent = this;
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                DRAWN | INVALIDATED;
        this.mPrivateFlags |= INVALIDATED;
        {
            boolean varDDA55DF480817D6313066967525E9186_1742874310 = (child.hasFocus());
            {
                requestChildFocus(child, child.findFocus());
            } 
        } 
        addTaint(child.getTaint());
        addTaint(index);
        addTaint(params.getTaint());
        
        
        
            
        
        
        
        
                
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.037 -0400", hash_original_method = "635C6E5D7FA712D6D6BC98C85EEAD0AE", hash_generated_method = "F8405D564C6BA31F3A7AD700E691876A")
    protected void detachViewFromParent(View child) {
        removeFromArray(indexOfChild(child));
        addTaint(child.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.037 -0400", hash_original_method = "6B327774A5D40749E682A0800D955866", hash_generated_method = "59E503E3446F5BDABA4C4E6174E6B64D")
    protected void detachViewFromParent(int index) {
        removeFromArray(index);
        addTaint(index);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.038 -0400", hash_original_method = "9419943F60DE9471E3CB31EABE2947F0", hash_generated_method = "1442599EBAE371CF534E26FB17509880")
    protected void detachViewsFromParent(int start, int count) {
        removeFromArray(start, count);
        addTaint(start);
        addTaint(count);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.039 -0400", hash_original_method = "FD3027623927AF219788395D1D83AA06", hash_generated_method = "E1C8CC9917C1C829E56744D2FCBF632A")
    protected void detachAllViewsFromParent() {
        final int count = mChildrenCount;
        final View[] children = mChildren;
        mChildrenCount = 0;
        {
            int i = count - 1;
            {
                children[i].mParent = null;
                children[i] = null;
            } 
        } 
        
        
        
            
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.041 -0400", hash_original_method = "063B7BC13F01F04711683C921C10A0CE", hash_generated_method = "8C66C9599EE9B1AC1D9CA6B9E6E4CFBB")
    public final void invalidateChild(View child, final Rect dirty) {
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD);
        } 
        ViewParent parent = this;
        final AttachInfo attachInfo = mAttachInfo;
        {
            final boolean drawAnimation = (child.mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION;
            {
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.setEmpty();
                } 
                {
                    View view = null;
                    {
                        view = (View) parent;
                        {
                            view.mLocalDirtyRect.setEmpty();
                            {
                                boolean var3DA0F6F5F2B1801DCC6F6E6927312986_1145488932 = (view.getParent() instanceof View);
                                {
                                    final View grandParent = (View) view.getParent();
                                    grandParent.mPrivateFlags |= INVALIDATED;
                                    grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                                } 
                            } 
                        } 
                    } 
                    {
                        {
                            view.mPrivateFlags |= DRAW_ANIMATION;
                        } 
                        {
                            ((ViewRootImpl) parent).mIsAnimating = true;
                        } 
                    } 
                    {
                        ((ViewRootImpl) parent).invalidate();
                        parent = null;
                    } 
                    {
                        {
                            view.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            view.mPrivateFlags |= DIRTY;
                            parent = view.mParent;
                        } 
                        {
                            parent = null;
                        } 
                    } 
                } 
            } 
            {
                final boolean isOpaque = child.isOpaque() && !drawAnimation &&
                        child.getAnimation() == null;
                int opaqueFlag;
                opaqueFlag = DIRTY_OPAQUE;
                opaqueFlag = DIRTY;
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.union(dirty);
                } 
                final int[] location = attachInfo.mInvalidateChildLocation;
                location[CHILD_LEFT_INDEX] = child.mLeft;
                location[CHILD_TOP_INDEX] = child.mTop;
                Matrix childMatrix = child.getMatrix();
                {
                    boolean varCFD88FFD44E20CB7F1D8D4D2556D2E8C_375491493 = (!childMatrix.isIdentity());
                    {
                        RectF boundingRect = attachInfo.mTmpTransformRect;
                        boundingRect.set(dirty);
                        childMatrix.mapRect(boundingRect);
                        dirty.set((int) (boundingRect.left - 0.5f),
                            (int) (boundingRect.top - 0.5f),
                            (int) (boundingRect.right + 0.5f),
                            (int) (boundingRect.bottom + 0.5f));
                    } 
                } 
                {
                    View view = null;
                    {
                        view = (View) parent;
                        {
                            boolean varC5230D1238FBEF65B7498AB998C6F0FA_320423021 = (view.mLayerType != LAYER_TYPE_NONE &&
                                view.getParent() instanceof View);
                            {
                                final View grandParent = (View) view.getParent();
                                grandParent.mPrivateFlags |= INVALIDATED;
                                grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            } 
                        } 
                    } 
                    {
                        {
                            view.mPrivateFlags |= DRAW_ANIMATION;
                        } 
                        {
                            ((ViewRootImpl) parent).mIsAnimating = true;
                        } 
                    } 
                    {
                        {
                            boolean var760C0A78BE5FDB84740BECBCA8BA8947_932763525 = ((view.mViewFlags & FADING_EDGE_MASK) != 0 &&
                                view.getSolidColor() == 0);
                            {
                                opaqueFlag = DIRTY;
                            } 
                        } 
                        {
                            view.mPrivateFlags = (view.mPrivateFlags & ~DIRTY_MASK) | opaqueFlag;
                        } 
                    } 
                    parent = parent.invalidateChildInParent(location, dirty);
                    {
                        Matrix m = view.getMatrix();
                        {
                            boolean var8D882C39D7302E18C8FB45549919991D_1684102547 = (!m.isIdentity());
                            {
                                RectF boundingRect = attachInfo.mTmpTransformRect;
                                boundingRect.set(dirty);
                                m.mapRect(boundingRect);
                                dirty.set((int) boundingRect.left, (int) boundingRect.top,
                                    (int) (boundingRect.right + 0.5f),
                                    (int) (boundingRect.bottom + 0.5f));
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(child.getTaint());
        addTaint(dirty.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.042 -0400", hash_original_method = "DC318C38544A42EB44071D5AE866F2AB", hash_generated_method = "BC3958F5AD967A8FCE0C9BBC9B587CB1")
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_844645566 = null; 
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_341450184 = null; 
        ViewParent varB4EAC82CA7396A68D541C85D26508E83_1454207075 = null; 
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD_IN_PARENT);
        } 
        {
            {
                dirty.offset(location[CHILD_LEFT_INDEX] - mScrollX,
                        location[CHILD_TOP_INDEX] - mScrollY);
                final int left = mLeft;
                final int top = mTop;
                {
                    boolean var1FD08A580F456E7C6E817E871B882F95_1861037365 = ((mGroupFlags & FLAG_CLIP_CHILDREN) != FLAG_CLIP_CHILDREN ||
                        dirty.intersect(0, 0, mRight - left, mBottom - top) ||
                        (mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION);
                    {
                        mPrivateFlags &= ~DRAWING_CACHE_VALID;
                        location[CHILD_LEFT_INDEX] = left;
                        location[CHILD_TOP_INDEX] = top;
                        {
                            mLocalDirtyRect.union(dirty);
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_844645566 = mParent;
                    } 
                } 
            } 
            {
                mPrivateFlags &= ~DRAWN & ~DRAWING_CACHE_VALID;
                location[CHILD_LEFT_INDEX] = mLeft;
                location[CHILD_TOP_INDEX] = mTop;
                {
                    dirty.set(0, 0, mRight - mLeft, mBottom - mTop);
                } 
                {
                    dirty.union(0, 0, mRight - mLeft, mBottom - mTop);
                } 
                {
                    mLocalDirtyRect.union(dirty);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_341450184 = mParent;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1454207075 = null;
        addTaint(location[0]);
        addTaint(dirty.getTaint());
        ViewParent varA7E53CE21691AB073D9660D615818899_1793980010; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1793980010 = varB4EAC82CA7396A68D541C85D26508E83_844645566;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1793980010 = varB4EAC82CA7396A68D541C85D26508E83_341450184;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1793980010 = varB4EAC82CA7396A68D541C85D26508E83_1454207075;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1793980010.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1793980010;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.042 -0400", hash_original_method = "50571ED06CB8BFD92222BA4CF106E503", hash_generated_method = "3F1C0A72877084741C4A5E321B476AC9")
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect) {
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
        addTaint(descendant.getTaint());
        addTaint(rect.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.043 -0400", hash_original_method = "237D31B5A43A7733C9219A4289DB54A9", hash_generated_method = "FF2B8E97E069390D318E663B481D01C4")
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect) {
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
        addTaint(descendant.getTaint());
        addTaint(rect.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.043 -0400", hash_original_method = "D3722A63E3ED25EA76952CBDD9156CED", hash_generated_method = "58C2436A1AA316D2AE25F5D540BABE4E")
     void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds) {
        {
            boolean var9866E6F62DFB6148F201138746ED5750_1084831032 = (descendant == this);
        } 
        ViewParent theParent = descendant.mParent;
        {
            boolean varDD69D58089B270F3D4B28124BF640FA8_692766925 = ((theParent != null)
                && (theParent instanceof View)
                && (theParent != this));
            {
                {
                    rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
                    {
                        View p = (View) theParent;
                        rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                    } 
                } 
                {
                    {
                        View p = (View) theParent;
                        rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                    } 
                    rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
                } 
                descendant = (View) theParent;
                theParent = descendant.mParent;
            } 
        } 
        {
            boolean var643C98140D61F4DFE43564E3D036760F_1168455771 = (theParent == this);
            {
                {
                    rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
                } 
                {
                    rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
                } 
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("parameter must be a descendant of this view");
            } 
        } 
        addTaint(descendant.getTaint());
        addTaint(rect.getTaint());
        addTaint(offsetFromChildToParent);
        addTaint(clipToBounds);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.044 -0400", hash_original_method = "7A1B0B3F062F0EF6FC199DD0C643A517", hash_generated_method = "0B90DB87631D075649326F1C92128CE9")
    public void offsetChildrenTopAndBottom(int offset) {
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                final View v = children[i];
                v.mTop += offset;
                v.mBottom += offset;
            } 
        } 
        addTaint(offset);
        
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.044 -0400", hash_original_method = "5C31858D2677D0E5DD9194B8EDADFECC", hash_generated_method = "A0CEB707D76D42634AA0E5AA72BB21B3")
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        RectF rect;
        rect = mAttachInfo.mTmpTransformRect;
        rect = new RectF();
        rect.set(r);
        {
            boolean varF2532639FE5A165827FD7F7643C31EF0_879643958 = (!child.hasIdentityMatrix());
            {
                child.getMatrix().mapRect(rect);
            } 
        } 
        int dx = child.mLeft - mScrollX;
        int dy = child.mTop - mScrollY;
        rect.offset(dx, dy);
        {
            {
                boolean var4909A00AAC5857DB675C7058066C1F45_937058031 = (!child.hasIdentityMatrix());
                {
                    float[] position;
                    position = mAttachInfo.mTmpTransformLocation;
                    position = new float[2];
                    position[0] = offset.x;
                    position[1] = offset.y;
                    child.getMatrix().mapPoints(position);
                    offset.x = (int) (position[0] + 0.5f);
                    offset.y = (int) (position[1] + 0.5f);
                } 
            } 
            offset.x += dx;
            offset.y += dy;
        } 
        {
            boolean var08BB32A43948A9AA882E62C649D0F6D4_1513401499 = (rect.intersect(0, 0, mRight - mLeft, mBottom - mTop));
            {
                r.set((int) (rect.left + 0.5f), (int) (rect.top + 0.5f),
                    (int) (rect.right + 0.5f), (int) (rect.bottom + 0.5f));
                boolean var815D42ADB6C99D0ABB4FA68231A12D7A_1225988188 = (mParent.getChildVisibleRect(this, r, offset));
            } 
        } 
        addTaint(child.getTaint());
        addTaint(r.getTaint());
        addTaint(offset.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130970052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130970052;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.045 -0400", hash_original_method = "89A2794B62BBEA7754F18155FA121F08", hash_generated_method = "89672F8270E1EEC7AE702617D2E70732")
    @Override
    public final void layout(int l, int t, int r, int b) {
        {
            boolean varFB56D3D497D368E0550C6286169A3692_2033240017 = (mTransition == null || !mTransition.isChangingLayout());
            {
                super.layout(l, t, r, b);
            } 
            {
                mLayoutSuppressed = true;
            } 
        } 
        addTaint(l);
        addTaint(t);
        addTaint(r);
        addTaint(b);
        
        
            
        
            
        
    }

    
        @Override
protected abstract void onLayout(boolean changed,
            int l, int t, int r, int b);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.045 -0400", hash_original_method = "74094E4283ACC987205CEBE8397B866C", hash_generated_method = "BE74298C95F92D1FEE181988D74813DF")
    protected boolean canAnimate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099598494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099598494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.046 -0400", hash_original_method = "99174EE5664A8F981F50635AC5D4970E", hash_generated_method = "0ECC36E8F4901A7D90656B097B2D8AE6")
    public void startLayoutAnimation() {
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
            requestLayout();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.046 -0400", hash_original_method = "06C0C7BBCCF19FA4957838E03EE331C8", hash_generated_method = "79A372FB31048C6468EBF3B2058D214E")
    public void scheduleLayoutAnimation() {
        mGroupFlags |= FLAG_RUN_ANIMATION;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.046 -0400", hash_original_method = "76D54B6C61296EF04870B520A219B087", hash_generated_method = "A1A99CD2FAC536BDE2BCA98A2647D6A3")
    public void setLayoutAnimation(LayoutAnimationController controller) {
        mLayoutAnimationController = controller;
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.047 -0400", hash_original_method = "BD382B237F964A42E5B6E00A5B3A23FD", hash_generated_method = "9BEA79C5E369BCE61004A9B8B47F0348")
    public LayoutAnimationController getLayoutAnimation() {
        LayoutAnimationController varB4EAC82CA7396A68D541C85D26508E83_1928464835 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1928464835 = mLayoutAnimationController;
        varB4EAC82CA7396A68D541C85D26508E83_1928464835.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1928464835;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.047 -0400", hash_original_method = "91C32769C37DCC6F9F6B4528E4A57D15", hash_generated_method = "D8217961AED8E0042F4A5F743C051416")
    @ViewDebug.ExportedProperty
    public boolean isAnimationCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530640225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530640225;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.048 -0400", hash_original_method = "DD639E9259A75AF16A9190E263F8776F", hash_generated_method = "DA0DE8E948A805DFDF2642F15694D67A")
    public void setAnimationCacheEnabled(boolean enabled) {
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.049 -0400", hash_original_method = "B9ACD8DAE870BEF4EFBF779A704F6EA0", hash_generated_method = "BD018985EC2FD2221501313AA009BC0A")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515962271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_515962271;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.049 -0400", hash_original_method = "ACB4830CB4940DD4B9F47560853379A8", hash_generated_method = "2E52C8D67EFB5CBD1163C88861A4B0B2")
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
        addTaint(always);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.050 -0400", hash_original_method = "4364C0D051F178DD0E8ADCB73D61750A", hash_generated_method = "86A23B089671A191991046DA36D83CEE")
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawnWithCacheEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412153386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_412153386;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.050 -0400", hash_original_method = "2230D982A122AD23513779DE65F20855", hash_generated_method = "464D9C3133093F65C56F9AC879BFE67D")
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.050 -0400", hash_original_method = "5166D8925764E3FCE51BAB9F8B82BB83", hash_generated_method = "B3983ECB46B5058360D3510FFC40407D")
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawingOrderEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1948753736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1948753736;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.051 -0400", hash_original_method = "206BAF2A94AC84475BA4253F279E8423", hash_generated_method = "3801A19E90B0351E485A69316EEDED90")
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.051 -0400", hash_original_method = "DAA9F10BF0EA997E391E78BA1DF6ABEE", hash_generated_method = "CFB6787502AB266B454D58F45F25A34C")
    private void setBooleanFlag(int flag, boolean value) {
        {
            mGroupFlags |= flag;
        } 
        {
            mGroupFlags &= ~flag;
        } 
        addTaint(value);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.051 -0400", hash_original_method = "944A8E363FECEAC5FA18188B2A82EEA9", hash_generated_method = "E4E5820829167D497655ECA022DE06FF")
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
        @ViewDebug.IntToString(from = PERSISTENT_NO_CACHE,        to = "NONE"),
        @ViewDebug.IntToString(from = PERSISTENT_ANIMATION_CACHE, to = "ANIMATION"),
        @ViewDebug.IntToString(from = PERSISTENT_SCROLLING_CACHE, to = "SCROLLING"),
        @ViewDebug.IntToString(from = PERSISTENT_ALL_CACHES,      to = "ALL")
    })
    public int getPersistentDrawingCache() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145088961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145088961;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.051 -0400", hash_original_method = "E1A853399F91DFB847E7C25FCC355E2E", hash_generated_method = "8158E6575E5BC3B0CF39A9A0E9990C3F")
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.052 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "E920DF8FA66A47886E3047FA275D8380")
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_782810830 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_782810830 = new LayoutParams(getContext(), attrs);
        addTaint(attrs.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_782810830.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_782810830;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.053 -0400", hash_original_method = "732F05B425275E63BD87B7814AB2A9CD", hash_generated_method = "ECA42C90F79AF8B206E28F17438C95AD")
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_282164468 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_282164468 = p;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_282164468.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_282164468;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.055 -0400", hash_original_method = "378AC11079CE6884A850F340A9660EF3", hash_generated_method = "18AFE975F06EFB0CCEEA693E811F3E48")
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams varB4EAC82CA7396A68D541C85D26508E83_1324821332 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1324821332 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        varB4EAC82CA7396A68D541C85D26508E83_1324821332.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1324821332;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.055 -0400", hash_original_method = "4EE7CD38DD5C6A89B0A06AD3B67D59FC", hash_generated_method = "6EEAA74F53049235C5CEC323FF726F01")
    @Override
    protected boolean dispatchConsistencyCheck(int consistency) {
        boolean result = super.dispatchConsistencyCheck(consistency);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                {
                    boolean var701606913081A4231078EDA1C31F9544_1548456037 = (!children[i].dispatchConsistencyCheck(consistency));
                    result = false;
                } 
            } 
        } 
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010771463 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010771463;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.056 -0400", hash_original_method = "9938C74D91901C257958D174411BCA62", hash_generated_method = "D6801ADB746BD42EF3B12CBCC5C0BBD0")
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        
        boolean result = super.onConsistencyCheck(consistency);
        final boolean checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        final boolean checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            {
                int i = 0;
                {
                    {
                        boolean varC3E3292263C4B7F2461A3F2B810768A5_1070928911 = (children[i].getParent() != this);
                        {
                            result = false;
                            android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "View " + children[i] + " has no parent/a parent that is not " + this);
                        } 
                    } 
                } 
            } 
        } 
        {
            {
                final ViewParent parent = getParent();
                {
                    {
                        result = false;
                        android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                                "ViewGroup " + this + " is dirty but its parent is not: " + this);
                    } 
                } 
            } 
        } 
        addTaint(consistency);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852805761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852805761;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.057 -0400", hash_original_method = "9209AC82FBA5456C7517DF8735B229C2", hash_generated_method = "1F9F548A05353C25B0B22B077A25227A")
    @Override
    protected void debug(int depth) {
        super.debug(depth);
        String output;
        {
            output = debugIndent(depth);
            output += "mFocused";
            Log.d(VIEW_LOG_TAG, output);
        } 
        {
            output = debugIndent(depth);
            output += "{";
            Log.d(VIEW_LOG_TAG, output);
        } 
        int count = mChildrenCount;
        {
            int i = 0;
            {
                View child = mChildren[i];
                child.debug(depth + 1);
            } 
        } 
        {
            output = debugIndent(depth);
            output += "}";
            Log.d(VIEW_LOG_TAG, output);
        } 
        addTaint(depth);
        
        
        
        
            
            
            
        
        
            
            
            
        
        
        
            
            
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.058 -0400", hash_original_method = "A3819F4FC73AAB74FEBE19CD2546FBCA", hash_generated_method = "BC1DAE6F01A8AF6045F023814A2EDADC")
    public int indexOfChild(View child) {
        final int count = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
        } 
        addTaint(child.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995214362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995214362;
        
        
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.059 -0400", hash_original_method = "7030903D0CFC3D101159E57E177A8D82", hash_generated_method = "6ADA900C446B825FE7AA43F0B303FB44")
    public int getChildCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060367866 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060367866;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.060 -0400", hash_original_method = "DC55A008910617641F1AE978A0E895D4", hash_generated_method = "B31F32B6A39DF12D51BEA828A9618B58")
    public View getChildAt(int index) {
        View varB4EAC82CA7396A68D541C85D26508E83_238295834 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_2004819038 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_238295834 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2004819038 = mChildren[index];
        addTaint(index);
        View varA7E53CE21691AB073D9660D615818899_461397419; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_461397419 = varB4EAC82CA7396A68D541C85D26508E83_238295834;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_461397419 = varB4EAC82CA7396A68D541C85D26508E83_2004819038;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_461397419.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_461397419;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.060 -0400", hash_original_method = "542392FF7FE475C27FCC004AAEE4D21F", hash_generated_method = "3005F528DB44840F1B08D49CE89373E2")
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        final int size = mChildrenCount;
        final View[] children = mChildren;
        {
            int i = 0;
            {
                final View child = children[i];
                {
                    measureChild(child, widthMeasureSpec, heightMeasureSpec);
                } 
            } 
        } 
        addTaint(widthMeasureSpec);
        addTaint(heightMeasureSpec);
        
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.061 -0400", hash_original_method = "9EDA680ED83105527C80B1E780D1BEC7", hash_generated_method = "11247665E07FE4A0B2673E8AB25FA95E")
    protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec) {
        final LayoutParams lp = child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(parentHeightMeasureSpec);
        
        
        
                
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.061 -0400", hash_original_method = "DF0652AA16CC35609E8DBABD1504358F", hash_generated_method = "2B458672ABC57180063A884727756921")
    protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        addTaint(child.getTaint());
        addTaint(parentWidthMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(heightUsed);
        
        
        
                
                        
        
                
                        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.062 -0400", hash_original_method = "92C99C7B01BA8D70EFEE87F46C0710D1", hash_generated_method = "20F827DDB021B8B88FD693FB75190E6C")
    public void clearDisappearingChildren() {
        {
            mDisappearingChildren.clear();
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.062 -0400", hash_original_method = "EFF49544FBF4F5023D4E3259D68E48A6", hash_generated_method = "800E0B7DEA3515B9EDB3975CF18911A2")
    private void addDisappearingView(View v) {
        ArrayList<View> disappearingChildren = mDisappearingChildren;
        {
            disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        } 
        disappearingChildren.add(v);
        addTaint(v.getTaint());
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.063 -0400", hash_original_method = "F02FCA79EB2173CD96A012235B90F902", hash_generated_method = "BACA5523BDD300A1E8EEDB5D6942FEAA")
    private void finishAnimatingView(final View view, Animation animation) {
        final ArrayList<View> disappearingChildren = mDisappearingChildren;
        {
            {
                boolean var469F1AC6EE958AE18E6E98146553974E_316467064 = (disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        view.dispatchDetachedFromWindow();
                    } 
                    view.clearAnimation();
                    mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                } 
            } 
        } 
        {
            boolean var43425F3101AF26F025C7208DDDA7464F_1664208840 = (animation != null && !animation.getFillAfter());
            {
                view.clearAnimation();
            } 
        } 
        {
            view.onAnimationEnd();
            view.mPrivateFlags &= ~ANIMATION_STARTED;
            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
        } 
        addTaint(view.getTaint());
        addTaint(animation.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.063 -0400", hash_original_method = "663B00ABF4B2F32B3DAAC91DDA64BE32", hash_generated_method = "03F56319E37B8755DA01B5F9D493DE34")
     boolean isViewTransitioning(View view) {
        boolean var2C744AD4F2EA7A3D608A882D8C3D4FED_1138856980 = ((mTransitioningViews != null && mTransitioningViews.contains(view)));
        addTaint(view.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1241509513 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1241509513;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.064 -0400", hash_original_method = "3DD17A0BC43336D376B4C3E60ACB3106", hash_generated_method = "577BED63E0A303F381EB10E1FBFD38E8")
    public void startViewTransition(View view) {
        {
            boolean varA2172F77206C7C024C24C289D1254F67_1147181668 = (view.mParent == this);
            {
                {
                    mTransitioningViews = new ArrayList<View>();
                } 
                mTransitioningViews.add(view);
            } 
        } 
        addTaint(view.getTaint());
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.064 -0400", hash_original_method = "A78E74DD3F17BBF76B7245787E00733D", hash_generated_method = "17931D35228650A9A0D17EB0C4104E60")
    public void endViewTransition(View view) {
        {
            mTransitioningViews.remove(view);
            final ArrayList<View> disappearingChildren = mDisappearingChildren;
            {
                boolean var8B6CC6761C9BD4F7C4819DDB2B1B39CF_317411640 = (disappearingChildren != null && disappearingChildren.contains(view));
                {
                    disappearingChildren.remove(view);
                    {
                        boolean var8D124A8F477EC519F378FF84BB0D8AF5_1872116846 = (mVisibilityChangingChildren != null &&
                        mVisibilityChangingChildren.contains(view));
                        {
                            mVisibilityChangingChildren.remove(view);
                        } 
                        {
                            {
                                view.dispatchDetachedFromWindow();
                            } 
                            {
                                view.mParent = null;
                            } 
                        } 
                    } 
                    mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                } 
            } 
        } 
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.065 -0400", hash_original_method = "90F24CF973A15FCB3D8EF936857F7660", hash_generated_method = "D4A94C4117F4DD2A0548E0C83F79774E")
    @Override
    public boolean gatherTransparentRegion(Region region) {
        final boolean meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        super.gatherTransparentRegion(region);
        final View[] children = mChildren;
        final int count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent = true;
        {
            int i = 0;
            {
                final View child = children[i];
                {
                    boolean var589A259560F2788DFC2988B1FA33F37B_888668474 = ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null);
                    {
                        {
                            boolean var02F3557A74971374C057D08F3D583563_458786122 = (!child.gatherTransparentRegion(region));
                            {
                                noneOfTheChildrenAreTransparent = false;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        addTaint(region.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1270124833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1270124833;
        
        
        
            
        
        
        
        
        
        
            
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.065 -0400", hash_original_method = "5C4070054C131245FD376376D5198B5B", hash_generated_method = "C142B0C1975153866B5684F6D72A1D82")
    public void requestTransparentRegion(View child) {
        {
            child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            {
                mParent.requestTransparentRegion(this);
            } 
        } 
        addTaint(child.getTaint());
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.065 -0400", hash_original_method = "055C0C5E94DF77352535F2463E2E2F92", hash_generated_method = "6643972027BF2193E87F85C9F075459F")
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        boolean done = super.fitSystemWindows(insets);
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            {
                int i = 0;
                {
                    done = children[i].fitSystemWindows(insets);
                } 
            } 
        } 
        addTaint(insets.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194157066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_194157066;
        
        
        
            
            
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.066 -0400", hash_original_method = "B3B3B12C071F8F31617EDB75C1351CBC", hash_generated_method = "8A90E36BA25E7DD373E9954363EF02B6")
    public Animation.AnimationListener getLayoutAnimationListener() {
        Animation.AnimationListener varB4EAC82CA7396A68D541C85D26508E83_1012811494 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1012811494 = mAnimationListener;
        varB4EAC82CA7396A68D541C85D26508E83_1012811494.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1012811494;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.067 -0400", hash_original_method = "309790593767800D49B3C7FD0CAB3F32", hash_generated_method = "817BE2B727535DBCDD31941506CDB2A3")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
            } 
            final View[] children = mChildren;
            final int count = mChildrenCount;
            {
                int i = 0;
                {
                    final View child = children[i];
                    {
                        child.refreshDrawableState();
                    } 
                } 
            } 
        } 
        
        
        
            
                
                        
            
            
            
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.067 -0400", hash_original_method = "9BFEBEB244ACA3F0CF8B6DCD826B4034", hash_generated_method = "919AD7465396B7224F6AE6AD2AF9114B")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final View[] children = mChildren;
        final int count = mChildrenCount;
        {
            int i = 0;
            {
                children[i].jumpDrawablesToCurrentState();
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.068 -0400", hash_original_method = "0411A3FE715B4530882EE6CBB1252DCB", hash_generated_method = "9CDF581B771840CEEC84784B9733444C")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        
        {
            int[] varEB7CD746CBB534A0BF67F4323334429E_207050741 = (super.onCreateDrawableState(extraSpace));
        } 
        int need = 0;
        int n = getChildCount();
        {
            int i = 0;
            {
                int[] childState = getChildAt(i).getDrawableState();
                {
                    need += childState.length;
                } 
            } 
        } 
        int[] state = super.onCreateDrawableState(extraSpace + need);
        {
            int i = 0;
            {
                int[] childState = getChildAt(i).getDrawableState();
                {
                    state = mergeDrawableStates(state, childState);
                } 
            } 
        } 
        addTaint(extraSpace);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1060938712 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1060938712;
        
        
            
        
        
        
        
            
            
                
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.069 -0400", hash_original_method = "1481B38AF6385F8F98E444294398E1C4", hash_generated_method = "454176A93789D7000F1E7562F2ADE8F8")
    public void setAddStatesFromChildren(boolean addsStates) {
        {
            mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        } 
        {
            mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        } 
        refreshDrawableState();
        addTaint(addsStates);
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.070 -0400", hash_original_method = "026C4CEB09DFE602F5C11A5652FC3C1F", hash_generated_method = "D11D03BF518823A922E808E2E426B369")
    public boolean addStatesFromChildren() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725745348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725745348;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.070 -0400", hash_original_method = "F32408C60FA79535F6423CE68328A516", hash_generated_method = "6393F6118060209F17EDFB9E35B3E982")
    public void childDrawableStateChanged(View child) {
        {
            refreshDrawableState();
        } 
        addTaint(child.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.071 -0400", hash_original_method = "CCA9986B4D287F2F006BAE825941ECAA", hash_generated_method = "28A9F6F2C654D2AA771EAFD01C6ECAA2")
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        mAnimationListener = animationListener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.071 -0400", hash_original_method = "8473FDA62EFB348A51ABA227E5F80648", hash_generated_method = "1ABCC40702F444C927D0505F90E085CC")
    public void requestTransitionStart(LayoutTransition transition) {
        ViewRootImpl viewAncestor = getViewRootImpl();
        {
            viewAncestor.requestTransitionStart(transition);
        } 
        addTaint(transition.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.072 -0400", hash_original_method = "438FE65F3DA47A9BB347952B8A6B02CD", hash_generated_method = "2E5D570C8A33F45CA575D13ED3B4669C")
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        final int count = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean varB5612BFB22B66951C85039D6A4ADA2D6_464402542 = (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT);
                    {
                        child.resetResolvedLayoutDirection();
                    } 
                } 
            } 
        } 
        
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.072 -0400", hash_original_method = "83014321BD6411A92FC299225A8B4B68", hash_generated_method = "08FD56EC65699A17E3CC0736CA33ED78")
    @Override
    protected void resetResolvedTextDirection() {
        super.resetResolvedTextDirection();
        final int count = getChildCount();
        {
            int i = 0;
            {
                final View child = getChildAt(i);
                {
                    boolean var97DAD7DCB6178A82512069CD3DA52554_1902002348 = (child.getTextDirection() == TEXT_DIRECTION_INHERIT);
                    {
                        child.resetResolvedTextDirection();
                    } 
                } 
            } 
        } 
        
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.073 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "B6BE81D433D62228E9EF5FDA149813C5")
    public boolean shouldDelayChildPressedState() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913787253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913787253;
        
        
    }

    
    public static class LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.073 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "E98E615247D406FD5B1F2C460414CA00")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.073 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "154449EB0055FED002CA8F596F81E1FB")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.073 -0400", hash_original_field = "32A967A061019BB85A555A08521F45C3", hash_generated_field = "A8465771210F0A9A6D04062D459407C3")

        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.073 -0400", hash_original_method = "15AB37D81442EE27D75B1677A2391AE7", hash_generated_method = "465F6B46B33478394A54D1F7E21C96DA")
        public  LayoutParams(Context c, AttributeSet attrs) {
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
            
            
                    
                    
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.073 -0400", hash_original_method = "25BDC30F3D80C9CBE1EB5EBCEE37F7CB", hash_generated_method = "61CBE5F83CA15EA93BA315DE7814BEC6")
        public  LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.074 -0400", hash_original_method = "2BA3A180B45B8CE1CC5399F5BB84EEDE", hash_generated_method = "0F6B2AA4452B28B14B0088D4B6A2DB9F")
        public  LayoutParams(LayoutParams source) {
            this.width = source.width;
            this.height = source.height;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.074 -0400", hash_original_method = "6916C65008FD05252A1C29A02882BE94", hash_generated_method = "45AC97A074BFD055B1BD45042F079476")
          LayoutParams() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.074 -0400", hash_original_method = "22F495DEF56CC03879FA6664450D6ACC", hash_generated_method = "E5FD1A97DBF05843B1262AD7B2A89C11")
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.075 -0400", hash_original_method = "CE6F1B4BC3F83182FFE42E3A8827DEEC", hash_generated_method = "6D86F89DE956B69559B0A86CF3A2E3CD")
        protected void resolveWithDirection(int layoutDirection) {
            addTaint(layoutDirection);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.075 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "199DCD2AC13AA3F973D02E8BCFC594AB")
        public String debug(String output) {
            String varB4EAC82CA7396A68D541C85D26508E83_1514225409 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1514225409 = output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }";
            addTaint(output.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1514225409.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1514225409;
            
            
                    
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.075 -0400", hash_original_field = "B333156949B5FAA535F7E8DBDBF0D617", hash_generated_field = "B60A6144A316A76818E3F37ADD9B0E2B")

        @SuppressWarnings({"UnusedDeclaration"})
        @Deprecated
        public static final int FILL_PARENT = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "AB0F2BFD833859D7E6AF5D2D478DFEC1", hash_generated_field = "035E0815824268EA10F24139068915CD")

        public static final int MATCH_PARENT = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "331393B598CE796434D861237AC6E1F4", hash_generated_field = "33E013A8F3F409595C02468C7E3CA7AB")

        public static final int WRAP_CONTENT = -2;
    }


    
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "1419D880ADE86E149ABAFCB226F6B662", hash_generated_field = "B21196B63DA6FA861C6C44CFE61E0207")

        @ViewDebug.ExportedProperty(category = "layout") public int leftMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "F14E99EDBAA6E54CB43B2B4C3D7084CF", hash_generated_field = "C75872B6D23692F5C29153B6138A7705")

        @ViewDebug.ExportedProperty(category = "layout") public int topMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "A5E95C57F057CCC5814DC8DB40E9120B", hash_generated_field = "8215B4F64E53D75A1F217C65CCA861B0")

        @ViewDebug.ExportedProperty(category = "layout") public int rightMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "6B087389EB08EE42774D6432387E8C9A", hash_generated_field = "C9EC61B6AE185D3F68BEDBB7A02A577D")

        @ViewDebug.ExportedProperty(category = "layout") public int bottomMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "77BD249F949CA3D95A4C77016CC05819", hash_generated_field = "6BB5C7CF92CA34A599866F03AD4A8600")

        @ViewDebug.ExportedProperty(category = "layout") protected int startMargin = DEFAULT_RELATIVE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.076 -0400", hash_original_field = "FF17DEDAB668A62D7F93257CCC172E72", hash_generated_field = "0A4C2937E1B0718BA14E68C5B33ABD23")

        @ViewDebug.ExportedProperty(category = "layout") protected int endMargin = DEFAULT_RELATIVE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.077 -0400", hash_original_method = "10E5D625CF55B3D944D3843050E826C6", hash_generated_method = "CD39C3EF5CAFDABE8FFBC91D2770FF3E")
        public  MarginLayoutParams(Context c, AttributeSet attrs) {
            super();
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_MarginLayout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_MarginLayout_layout_width,
                    R.styleable.ViewGroup_MarginLayout_layout_height);
            int margin = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.ViewGroup_MarginLayout_layout_margin, -1);
            {
                leftMargin = margin;
                topMargin = margin;
                rightMargin= margin;
                bottomMargin = margin;
            } 
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
            } 
            a.recycle();
            addTaint(c.getTaint());
            addTaint(attrs.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.077 -0400", hash_original_method = "4C1C9EAF9AFA2E58AB980E97DFB147EB", hash_generated_method = "DFA5758A46EE2AF6635DD5EE5E53A838")
        public  MarginLayoutParams(int width, int height) {
            super(width, height);
            addTaint(width);
            addTaint(height);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.078 -0400", hash_original_method = "55868F7F983C11B537A625BA756EE7CC", hash_generated_method = "7035DFAA2CA4AF1F793362EF7D0AFEFE")
        public  MarginLayoutParams(MarginLayoutParams source) {
            this.width = source.width;
            this.height = source.height;
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
            this.startMargin = source.startMargin;
            this.endMargin = source.endMargin;
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.079 -0400", hash_original_method = "E2A57B11F6C8009C3B5E4EDAD0277412", hash_generated_method = "54FCC1DF48420A5FAD38AF8300540761")
        public  MarginLayoutParams(LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.080 -0400", hash_original_method = "A7CFD8E9AA47AE278733C57B8CF5503F", hash_generated_method = "E9FA91064C566B35F37192AF7E41F6DA")
        public void setMargins(int left, int top, int right, int bottom) {
            leftMargin = left;
            topMargin = top;
            rightMargin = right;
            bottomMargin = bottom;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.080 -0400", hash_original_method = "F5A63690A2F55CE5C4D6B1F24495E028", hash_generated_method = "142C3C1A10C4FC10B505CFEA80893BBF")
        public void setMarginsRelative(int start, int top, int end, int bottom) {
            startMargin = start;
            topMargin = top;
            endMargin = end;
            bottomMargin = bottom;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.081 -0400", hash_original_method = "A60FB56334BFE35432A89BE021472DEF", hash_generated_method = "38B717C05A7369B32D81D8E7772FAFCD")
        public int getMarginStart() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14114264 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_14114264;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.081 -0400", hash_original_method = "2B74CF4F3396E75552B1A46DF3D4BFD7", hash_generated_method = "3CD78C1AC684133957D2FCB732A4CE95")
        public int getMarginEnd() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085583979 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085583979;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.081 -0400", hash_original_method = "C9EA583BDFA2583A2B96D706C959CDBC", hash_generated_method = "43F04FA0A5070ACA8C61610FBDAB75DE")
        public boolean isMarginRelative() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960763005 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_960763005;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.082 -0400", hash_original_method = "25B74C4F994FDDCB83271E7B2F9BDDEE", hash_generated_method = "7CFCDD8EC476530E2206429F2D5CDA8F")
        @Override
        protected void resolveWithDirection(int layoutDirection) {
            
            leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
            
            
            rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
            
            
            leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
            
            
            rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
            
            addTaint(layoutDirection);
            
            
                
                    
                    
                    
                
                
                    
                    
                    
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.082 -0400", hash_original_field = "9719E4AAD4FACA3BF0499294B0F32D31", hash_generated_field = "706B949A33ED230B911B9350FAA5912D")

        static private final int DEFAULT_RELATIVE = Integer.MIN_VALUE;
    }


    
    private static final class TouchTarget {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.082 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.082 -0400", hash_original_field = "F1144C2E88061517D095C11872B4C482", hash_generated_field = "530D731D7D2EE140B1D1AF75DBF79B1B")

        public int pointerIdBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.082 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "DC720CE01C505E3F8C1AAF24F8078F0D")

        public TouchTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.082 -0400", hash_original_method = "5259B67E5A6C02FEFA0EB82F43285FB5", hash_generated_method = "B32A208B999EE5B494ADD3A3C0776E12")
        private  TouchTarget() {
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "AB54E1D51CAE4173450A000EBCA7A06A")
        public void recycle() {
            {
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } 
                {
                    next = null;
                } 
                child = null;
            } 
            
            
                
                    
                    
                    
                
                    
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "A72E5077CE400FBB95D5EB6C205E6CD6", hash_generated_field = "393219263EA5357C424C8D6A0761942D")

        private static final int MAX_RECYCLED = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "5E099B93496A959515A0264634CA0534", hash_generated_field = "569BC93CDF23077487A166A9877200C9")

        private static final Object sRecycleLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "CCE02A7FF8CA5926C887F8CC8CC579A5", hash_generated_field = "E0E2F52EC1657E89F88CB94D6B19500A")

        private static TouchTarget sRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "E80DA3258C0105DF400606DD49462342", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "1B6BEB46ACAD52F4B6C908932D9CBB35", hash_generated_field = "5D0EA96D1B8E6DB25F736A1FB6B6D10D")

        public static final int ALL_POINTER_IDS = -1;
    }


    
    private static final class HoverTarget {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "3B1636D6CF959CF92CBD4352E6CBCE49")

        public HoverTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.083 -0400", hash_original_method = "5539B57739929C533DCF7E732D22C4F2", hash_generated_method = "726B690AE07312555BAF165F7E5F62F6")
        private  HoverTarget() {
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "AB54E1D51CAE4173450A000EBCA7A06A")
        public void recycle() {
            {
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } 
                {
                    next = null;
                } 
                child = null;
            } 
            
            
                
                    
                    
                    
                
                    
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "A72E5077CE400FBB95D5EB6C205E6CD6", hash_generated_field = "393219263EA5357C424C8D6A0761942D")

        private static final int MAX_RECYCLED = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "5E099B93496A959515A0264634CA0534", hash_generated_field = "569BC93CDF23077487A166A9877200C9")

        private static final Object sRecycleLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "CCE02A7FF8CA5926C887F8CC8CC579A5", hash_generated_field = "9BF05FD9D6504C47D3CD94A8F3200F82")

        private static HoverTarget sRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "E80DA3258C0105DF400606DD49462342", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
    }


    
    public interface OnHierarchyChangeListener {
        
        void onChildViewAdded(View parent, View child);

        
        void onChildViewRemoved(View parent, View child);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "093C1742536C628A897749D49426A6D3", hash_generated_field = "47BF092971141A3134E594F7724B4190")

    private static final int FLAG_CLIP_CHILDREN = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "CB5125EA3850C10828D646E68628DA9A", hash_generated_field = "8784C03D29895C69177C2E4EC32050F7")

    private static final int FLAG_CLIP_TO_PADDING = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "370A6DEBEC95348BA1E5248C135A5EC8", hash_generated_field = "6D07E3CA6E481323A58E027BE033C02B")

    private static final int FLAG_INVALIDATE_REQUIRED = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "5195C625EE4E9D8027AD632CFE4CCD01", hash_generated_field = "B26C30228855373F2358E1738754788D")

    private static final int FLAG_RUN_ANIMATION = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "83472C31AED9766B248D82ED2D074D5C", hash_generated_field = "92F56B56474778E97B28F8B1E057D57B")

    private static final int FLAG_ANIMATION_DONE = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "08A72EA908064A83313796C485ADACDD", hash_generated_field = "6B2DE00828EED965F16F1E1887A50E1A")

    private static final int FLAG_PADDING_NOT_NULL = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "CAC36ACA9ED784B231117CB39D86A384", hash_generated_field = "A363BE181F28AF138EAE37CE19C6A175")

    private static final int FLAG_ANIMATION_CACHE = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "001D3068790E7E549A48976047700A5A", hash_generated_field = "2ECEB8CA0BBD1B97E644FE478937E0E9")

    private static final int FLAG_OPTIMIZE_INVALIDATE = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "296952AC48605AFEFDBD310F71840975", hash_generated_field = "3403A038D2CECBA0DA69E8CF8F169A1F")

    private static final int FLAG_CLEAR_TRANSFORMATION = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "80E59BFDFA55701D5C3008682DE14EA5", hash_generated_field = "4CD118091ADEC14A10FCFFA5826971C0")

    private static final int FLAG_NOTIFY_ANIMATION_LISTENER = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "174D3C1D51E7CCF138A4F39DBF69B0C9", hash_generated_field = "32BC669C68D09844C7CB0B0C44FE2F3B")

    protected static final int FLAG_USE_CHILD_DRAWING_ORDER = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "880E7482176EB8093E6CCCD736E4B0A2", hash_generated_field = "A86E922C6C59CFE079F5D7DA8B15BF89")

    protected static final int FLAG_SUPPORT_STATIC_TRANSFORMATIONS = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "064633D9895C1F26598F928072EA6CA8", hash_generated_field = "49F0EBDE6CDB520FAAFA1CE2AE891179")

    private static final int FLAG_ALPHA_LOWER_THAN_ONE = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "85691F00B62FE4647557EF0CCD322E28", hash_generated_field = "4188882F32441AE2DC85E12EAB3E6C82")

    private static final int FLAG_ADD_STATES_FROM_CHILDREN = 0x2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "86601B54A4C45A57269BA0D57322442D", hash_generated_field = "13DA24EF090D074E119DCC3C5BD90BA8")

    private static final int FLAG_ALWAYS_DRAWN_WITH_CACHE = 0x4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "937D116FF0D4A7910D727BBF47DB86B2", hash_generated_field = "AB5153FDF753CE74CA032ECE6BC04442")

    private static final int FLAG_CHILDREN_DRAWN_WITH_CACHE = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "7F0A72234EA920F255CBA067C2A1B93D", hash_generated_field = "3A30818F90BA1EF84CA7AED25A16A1B7")

    private static final int FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "548AF4B07DEB40F98E8EEB7BB82E33C6", hash_generated_field = "4836095EA9CD6F4C22D5505B63A65920")

    private static final int FLAG_MASK_FOCUSABILITY = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "90E92091E4A64B96AC11794AC6BCE1ED", hash_generated_field = "BD96D757F41BA0229D767BD84AB7642D")

    public static final int FOCUS_BEFORE_DESCENDANTS = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "1AB4D8C2E6C0EB94C5E3D81186225A46", hash_generated_field = "CD9C40718F19AA89DFB0F2B888272D33")

    public static final int FOCUS_AFTER_DESCENDANTS = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "474F04A27118AAE5C55DBA97D250DCD9", hash_generated_field = "5CE7A6F853A9C0B36CFE406D68F2F862")

    public static final int FOCUS_BLOCK_DESCENDANTS = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "550A1DD8DB80915C8B1B187E90B5E0B9", hash_generated_field = "DDDC8C4616BE00F788B917447806BD91")

    private static final int[] DESCENDANT_FOCUSABILITY_FLAGS = {FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS,
                    FOCUS_BLOCK_DESCENDANTS};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.084 -0400", hash_original_field = "5666C3D62FF07B134BC6617531F77464", hash_generated_field = "C4207E2A7E9C2242EFAB0A51AF1D91BF")

    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "DDACBD94DD1CDF62E81361791F53DA87", hash_generated_field = "F04CB98B3B159E26FDEE9BC7D5B07159")

    private static final int FLAG_SPLIT_MOTION_EVENTS = 0x200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "2D700E90C54045822898F506782662B3", hash_generated_field = "3C5BFED90B89800455E7BCFC3A10AF2B")

    private static final int FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW = 0x400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "C52B883FD05C47AA69FDA6E1F22F0ABB", hash_generated_field = "BC2E177DD2A895934D9FCE5C86AE3C65")

    public static final int PERSISTENT_NO_CACHE = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "67A61EDB48651F5C036B3346FBE5FAFA", hash_generated_field = "1F0A8E4978079659E6E30C2BA18617E8")

    public static final int PERSISTENT_ANIMATION_CACHE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "1EF42E9887D0EA5F316904FD3B9AB251", hash_generated_field = "F00BF7A2C158735CE5A6638A662B5EBF")

    public static final int PERSISTENT_SCROLLING_CACHE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "7C696FAA76DB6EC3A8EDD78551D1B467", hash_generated_field = "8CC8945E637E7193338DBF39D6D6A84A")

    public static final int PERSISTENT_ALL_CACHES = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "BC7469E2246471A573E63558ACC0C8ED", hash_generated_field = "D9383B91357843498670D009FA939F13")

    protected static final int CLIP_TO_PADDING_MASK = FLAG_CLIP_TO_PADDING | FLAG_PADDING_NOT_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "7A53C3B2EA29B34F35552312F91C5969", hash_generated_field = "FB112635D30DBDCA6CB17000D85722CA")

    private static final int CHILD_LEFT_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "D45F5D9EC95E07AC6931C434FF8D7294", hash_generated_field = "74187AE3BE9B2F6F3B52043634C8CEF0")

    private static final int CHILD_TOP_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "89DFE4348E5AA246A9F1E32325C98608", hash_generated_field = "406B673032561F95D3A3CE9567EB9D07")

    private static final int ARRAY_INITIAL_CAPACITY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:59.085 -0400", hash_original_field = "4333C5B7C7DF62BB1C21C6CF44CB4E1E", hash_generated_field = "97400031D7E61FBA03291EAA57490BB7")

    private static final int ARRAY_CAPACITY_INCREMENT = 12;
}

