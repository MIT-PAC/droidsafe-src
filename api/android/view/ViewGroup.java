package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.393 -0400", hash_original_field = "696495B05623D58D869C5D15A256902B", hash_generated_field = "99875A35D62FD939298A601A9F7DF5FD")

    protected ArrayList<View> mDisappearingChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.393 -0400", hash_original_field = "3F7DB39F9660F69EF1A4D273C271814A", hash_generated_field = "506B0E011CD70741D050BF2EE44FE356")

    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.393 -0400", hash_original_field = "42E518F9E3515DBB9C4BA0AD23CBAC61", hash_generated_field = "A4B16D4F5B8759534D19F2BBB80216EB")

    private View mFocused;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.393 -0400", hash_original_field = "16F4F06A930B1D3A94B992BE8E780178", hash_generated_field = "89EF5CAB67B25E4FDD40BCDFBB6E3EB9")

    private final Transformation mChildTransformation = new Transformation();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "D8A784EF03152F38795B78B59E6687CD", hash_generated_field = "0E43FE3464FE8F2B4A13FAF73F9FFA99")

    private RectF mInvalidateRegion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "65CA6A1D57BFCD4414AFF3BF15E316A5", hash_generated_field = "1A258D5E9E5687B9DA556AF87EE040D3")

    private Transformation mInvalidationTransformation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "3DDC2DD80BBDAAFF3D7748437C0F92DB", hash_generated_field = "278869ACFDD76183C8D171CD9E8010F4")

    private View mCurrentDragView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "70F326C41A2A7C4A33E4EBB382B916EA", hash_generated_field = "4260837AC154FE88E7ECE0B0D933BD38")

    private DragEvent mCurrentDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "6E6AEB257AE7602303150F5A2E06101C", hash_generated_field = "7C6A42655A4DC2D4BF46B4F9A41E01BC")

    private HashSet<View> mDragNotifiedChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "CB06E61812573C16C11AC1F5ED8FAC4D", hash_generated_field = "B40634C8F85313CD4FF766F9BA270DF1")

    private boolean mChildAcceptsDrag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "713A58D821D69EADC7B8400333D2114D", hash_generated_field = "ABDC85F272489DAB145CE0275A2DB3B6")

    private final PointF mLocalPoint = new PointF();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "EE254A0D1FB9B91AC6E612916399854B", hash_generated_field = "9303037DA96D3F26E2BF546299C3658E")

    private LayoutAnimationController mLayoutAnimationController;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "D7ED5F2F2BB342E46F91D9B806A50C8F", hash_generated_field = "FE6F2E4A779D16D38F8BBFCAC393C76B")

    private Animation.AnimationListener mAnimationListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "26BDCBDC864B748F53386DFAE0C033B2", hash_generated_field = "E7D785992A22A7F38809AD101B810276")

    private TouchTarget mFirstTouchTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "2872768B4C01F416A1F5754F14B30B55", hash_generated_field = "A29A2DA0312D9EE090BC48B3458B8632")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private long mLastTouchDownTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "E1651BDE01D340FDFEDFC6ECD609DEA2", hash_generated_field = "8B2D270E66117CC663F28DDCFB87BA4F")

    @ViewDebug.ExportedProperty(category = "events") private int mLastTouchDownIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "8B01400E27E5A26EAE9410E214CEC4CB", hash_generated_field = "4CA82440F2A0B548108575FF9859A086")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "AEEE8AEDA84C3DC240ABF11CCEAF69BC", hash_generated_field = "F4574986D2BBC08122BD509305467BC4")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"}) @ViewDebug.ExportedProperty(category = "events") private float mLastTouchDownY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "7925BD3459BCDD5EDBDA3820A951C7D1", hash_generated_field = "F6A706AD2BA485262D480B431AA08D80")

    private HoverTarget mFirstHoverTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "F16BAA76122227EAC1FA8071FFD9D031", hash_generated_field = "6FD02C8ECD5E4353E1EEA59D2D252B74")

    private boolean mHoveredSelf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.394 -0400", hash_original_field = "A5BB3DDB7F77A548994B517D14DA3459", hash_generated_field = "0ABD90AE9099E56BCD9A23A2BFDD9586")

    protected int mGroupFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "CFD9A5A2BA3F2274ECC022BF6DB661C8", hash_generated_field = "5B77DDDB5E53D20BC8C371537F9D6155")

    protected int mPersistentDrawingCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "6699FE97ED54C04992AEDA784C483D4D", hash_generated_field = "7CF7769EE949355835082685E98C8324")

    private View[] mChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "FD8A8C0C5238F97B65F22614467D44BD", hash_generated_field = "FA5DB817C33D36E210708492AC611D2B")

    private boolean mLayoutSuppressed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "A5034A70A83D3C81CEC027BDCAA166D7", hash_generated_field = "A777A0928665A4F1E7F4EF71A2259E60")

    private int mChildrenCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "E8B33C20BEE8C2EC1E2F75E228534E68", hash_generated_field = "4229E0DF467153CF57F65AC95B02B5E6")

    private Paint mCachePaint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "E5047FAB01E832F0446529905C5EC963")

    private LayoutTransition mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "BC704CB9A61CBF94F6C841CD3BBBC604", hash_generated_field = "C5D8A5DD8407602ED6BD80CBFE380CF3")

    private ArrayList<View> mTransitioningViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "D514310998F517320B20BEE9C067E163", hash_generated_field = "C1C569B225732CB1507D8AE1B61808FC")

    private ArrayList<View> mVisibilityChangingChildren;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_field = "09D83BDA15EFA5B57765F9C578A0ADBE", hash_generated_field = "6EF80FC61B331A8C0C9A860633C8D76D")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.395 -0400", hash_original_method = "B03ADF87A05C955E785D82B4A9B527B3", hash_generated_method = "A8C7430CB41AA17C462E677DBDF2DD51")
    public  ViewGroup(Context context) {
        super(context);
        addTaint(context.getTaint());
        initViewGroup();
        // ---------- Original Method ----------
        //initViewGroup();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.396 -0400", hash_original_method = "01EF181B5B9BD1E2AA94519EF8FAEC5E", hash_generated_method = "AC176154A182726EA14C92480544C579")
    public  ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initViewGroup();
        initFromAttributes(context, attrs);
        // ---------- Original Method ----------
        //initViewGroup();
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.396 -0400", hash_original_method = "FE20AAD08B3866F38DB1C82409548865", hash_generated_method = "C37137A7BB83B83DAC9BA192FD00848A")
    public  ViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        initViewGroup();
        initFromAttributes(context, attrs);
        // ---------- Original Method ----------
        //initViewGroup();
        //initFromAttributes(context, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.397 -0400", hash_original_method = "8201DDC69D3895B689FCA6813D812A1F", hash_generated_method = "B24202A0F24EC75F466AB09689E18CCE")
    private void initViewGroup() {
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
    if(mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB)        
        {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.398 -0400", hash_original_method = "4BC426CDAC642CD3FACBBAAA9F56EF39", hash_generated_method = "35BB7F816C259A0FD873991A15CEB858")
    private void initFromAttributes(Context context, AttributeSet attrs) {
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.ViewGroup);
        final int N = a.getIndexCount();
for(int i = 0;i < N;i++)
        {
            int attr = a.getIndex(i);
switch(attr){
            case R.styleable.ViewGroup_clipChildren:
            setClipChildren(a.getBoolean(attr, true));
            break;
            case R.styleable.ViewGroup_clipToPadding:
            setClipToPadding(a.getBoolean(attr, true));
            break;
            case R.styleable.ViewGroup_animationCache:
            setAnimationCacheEnabled(a.getBoolean(attr, true));
            break;
            case R.styleable.ViewGroup_persistentDrawingCache:
            setPersistentDrawingCache(a.getInt(attr, PERSISTENT_SCROLLING_CACHE));
            break;
            case R.styleable.ViewGroup_addStatesFromChildren:
            setAddStatesFromChildren(a.getBoolean(attr, false));
            break;
            case R.styleable.ViewGroup_alwaysDrawnWithCache:
            setAlwaysDrawnWithCacheEnabled(a.getBoolean(attr, true));
            break;
            case R.styleable.ViewGroup_layoutAnimation:
            int id = a.getResourceId(attr, -1);
    if(id > 0)            
            {
                setLayoutAnimation(AnimationUtils.loadLayoutAnimation(mContext, id));
            } //End block
            break;
            case R.styleable.ViewGroup_descendantFocusability:
            setDescendantFocusability(DESCENDANT_FOCUSABILITY_FLAGS[a.getInt(attr, 0)]);
            break;
            case R.styleable.ViewGroup_splitMotionEvents:
            setMotionEventSplittingEnabled(a.getBoolean(attr, false));
            break;
            case R.styleable.ViewGroup_animateLayoutChanges:
            boolean animateLayoutChanges = a.getBoolean(attr, false);
    if(animateLayoutChanges)            
            {
                setLayoutTransition(new LayoutTransition());
            } //End block
            break;
}
        } //End block
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.398 -0400", hash_original_method = "9DEFF27CA0C7CA0A646DEBC837B35971", hash_generated_method = "D3B65449AAF0AB34ACB80FAB687A25EF")
    @ViewDebug.ExportedProperty(category = "focus", mapping = {
        @ViewDebug.IntToString(from = FOCUS_BEFORE_DESCENDANTS, to = "FOCUS_BEFORE_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_AFTER_DESCENDANTS, to = "FOCUS_AFTER_DESCENDANTS"),
        @ViewDebug.IntToString(from = FOCUS_BLOCK_DESCENDANTS, to = "FOCUS_BLOCK_DESCENDANTS")
    })
    public int getDescendantFocusability() {
        int varDE65DC4F383CC3E2A0CC45BA852286F8_1568541814 = (mGroupFlags & FLAG_MASK_FOCUSABILITY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039834099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039834099;
        // ---------- Original Method ----------
        //return mGroupFlags & FLAG_MASK_FOCUSABILITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.399 -0400", hash_original_method = "0404A0C2267D357D33DA2838086AAD01", hash_generated_method = "9EBD294978FCD8EBFE4067EB4F1EDBA6")
    public void setDescendantFocusability(int focusability) {
switch(focusability){
        case FOCUS_BEFORE_DESCENDANTS:
        case FOCUS_AFTER_DESCENDANTS:
        case FOCUS_BLOCK_DESCENDANTS:
        break;
        default:
        IllegalArgumentException var3C40DAC1F803FF24E2F1E823974A078B_1581273122 = new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        + "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        var3C40DAC1F803FF24E2F1E823974A078B_1581273122.addTaint(taint);
        throw var3C40DAC1F803FF24E2F1E823974A078B_1581273122;
}        mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.399 -0400", hash_original_method = "1894A66AF55103F8230E4E4C184BE483", hash_generated_method = "0DF2718C9DA4C9490637B92CD8F24F5A")
    @Override
     void handleFocusGainInternal(int direction, Rect previouslyFocusedRect) {
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if(mFocused != null)        
        {
            mFocused.unFocus();
            mFocused = null;
        } //End block
        super.handleFocusGainInternal(direction, previouslyFocusedRect);
        // ---------- Original Method ----------
        //if (mFocused != null) {
            //mFocused.unFocus();
            //mFocused = null;
        //}
        //super.handleFocusGainInternal(direction, previouslyFocusedRect);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.399 -0400", hash_original_method = "18A4940B9B410F6E2A586E7BEB513255", hash_generated_method = "AB793E54F8704CBADDB148B0AD5FCA41")
    public void requestChildFocus(View child, View focused) {
        addTaint(focused.getTaint());
    if(DBG)        
        {
            System.out.println(this + " requestChildFocus()");
        } //End block
    if(getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS)        
        {
            return;
        } //End block
        super.unFocus();
    if(mFocused != child)        
        {
    if(mFocused != null)            
            {
                mFocused.unFocus();
            } //End block
            mFocused = child;
        } //End block
    if(mParent != null)        
        {
            mParent.requestChildFocus(this, focused);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.400 -0400", hash_original_method = "B9C632089323DEB68745C50418B61ADF", hash_generated_method = "E39AA42A49D865CB83BA15442C4FA32A")
    public void focusableViewAvailable(View v) {
        addTaint(v.getTaint());
    if(mParent != null
                && (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                && !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS))        
        {
            mParent.focusableViewAvailable(v);
        } //End block
        // ---------- Original Method ----------
        //if (mParent != null
                //&& (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                //&& !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS)) {
            //mParent.focusableViewAvailable(v);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.401 -0400", hash_original_method = "AAA08A22C93220CA5F37A81C00115203", hash_generated_method = "C08A2F71B5D2924871A38AC4CE6C835D")
    public boolean showContextMenuForChild(View originalView) {
        addTaint(originalView.getTaint());
        boolean varD43080C29435A813C96B242E11855E1A_1183039990 = (mParent != null && mParent.showContextMenuForChild(originalView));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746183562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746183562;
        // ---------- Original Method ----------
        //return mParent != null && mParent.showContextMenuForChild(originalView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.401 -0400", hash_original_method = "8C60B2F96F2B489988C14A93A463DAE3", hash_generated_method = "2B421249A23FFEAE19E9EBF61B99A867")
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback) {
        addTaint(callback.getTaint());
        addTaint(originalView.getTaint());
ActionMode varA4CB90969CA4AE0EAA9D3E65662D33E9_153117129 =         mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
        varA4CB90969CA4AE0EAA9D3E65662D33E9_153117129.addTaint(taint);
        return varA4CB90969CA4AE0EAA9D3E65662D33E9_153117129;
        // ---------- Original Method ----------
        //return mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.401 -0400", hash_original_method = "32394A633C776A8BC33A6BFC48D3DC37", hash_generated_method = "7855F3D2B0AD9B4C0E01304D4222CAAA")
    public View focusSearch(View focused, int direction) {
        addTaint(direction);
        addTaint(focused.getTaint());
    if(isRootNamespace())        
        {
View var4B697582AFCAF9BE54EF2B0BDE95A6DF_578011352 =             FocusFinder.getInstance().findNextFocus(this, focused, direction);
            var4B697582AFCAF9BE54EF2B0BDE95A6DF_578011352.addTaint(taint);
            return var4B697582AFCAF9BE54EF2B0BDE95A6DF_578011352;
        } //End block
        else
    if(mParent != null)        
        {
View varCFDB149F9AAD9A4DF9AD86DEA2C9AFB0_1744929022 =             mParent.focusSearch(focused, direction);
            varCFDB149F9AAD9A4DF9AD86DEA2C9AFB0_1744929022.addTaint(taint);
            return varCFDB149F9AAD9A4DF9AD86DEA2C9AFB0_1744929022;
        } //End block
View var540C13E9E156B687226421B24F2DF178_893367794 =         null;
        var540C13E9E156B687226421B24F2DF178_893367794.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_893367794;
        // ---------- Original Method ----------
        //if (isRootNamespace()) {
            //return FocusFinder.getInstance().findNextFocus(this, focused, direction);
        //} else if (mParent != null) {
            //return mParent.focusSearch(focused, direction);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.417 -0400", hash_original_method = "1A209ACB79681B08302166E2C48344A2", hash_generated_method = "44104C9FE7AADA8BF4F33AF647507323")
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        addTaint(immediate);
        addTaint(rectangle.getTaint());
        addTaint(child.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_79381724 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_35829835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_35829835;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.417 -0400", hash_original_method = "B4AA594F7D6DA64F58B166664BBA4580", hash_generated_method = "3BC42C1A86480C1A19013E60A3D573A1")
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        addTaint(event.getTaint());
        addTaint(child.getTaint());
        ViewParent parent = getParent();
    if(parent == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_563283531 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888247207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888247207;
        } //End block
        final boolean propagate = onRequestSendAccessibilityEvent(child, event);
    if(!propagate)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1881423283 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139184360 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139184360;
        } //End block
        boolean var12459EE8A10B8E2F8355E7B18F170464_138997106 = (parent.requestSendAccessibilityEvent(this, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510828419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510828419;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.417 -0400", hash_original_method = "0D2782B4A269D15DF81200BFDAFE535A", hash_generated_method = "445F3F071A9E492723DD748366DCB2FA")
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(child.getTaint());
    if(mAccessibilityDelegate != null)        
        {
            boolean varDEC6159CC044C7CB7315783B7FC62C32_543925167 = (mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545552098 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545552098;
        } //End block
        else
        {
            boolean varA5AE8846A1EE623EFB55210EBDCBCF74_306911962 = (onRequestSendAccessibilityEventInternal(child, event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879408342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_879408342;
        } //End block
        // ---------- Original Method ----------
        //if (mAccessibilityDelegate != null) {
            //return mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event);
        //} else {
            //return onRequestSendAccessibilityEventInternal(child, event);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.417 -0400", hash_original_method = "F0DFCA5DE1F330F511BBFF62182D5BD4", hash_generated_method = "0EDB7153580832B2497426066A375AB6")
     boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(child.getTaint());
        boolean varB326B5062B2F0E69046810717534CB09_1963531608 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_243383269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_243383269;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.418 -0400", hash_original_method = "E35CCEA2DF29F8696C548F55094B5B73", hash_generated_method = "E48200EE562CF3DBD0D65810C2E87025")
    @Override
    public boolean dispatchUnhandledMove(View focused, int direction) {
        addTaint(direction);
        addTaint(focused.getTaint());
        boolean var4788D98127D1C9314FAE41C403A0378C_1255854780 = (mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306886552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306886552;
        // ---------- Original Method ----------
        //return mFocused != null &&
                //mFocused.dispatchUnhandledMove(focused, direction);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.418 -0400", hash_original_method = "1A8D22FF280DB81B170D27815BE7BEAA", hash_generated_method = "5A562C1CDA7C20F09432B0D6B2E24713")
    public void clearChildFocus(View child) {
        addTaint(child.getTaint());
    if(DBG)        
        {
            System.out.println(this + " clearChildFocus()");
        } //End block
        mFocused = null;
    if(mParent != null)        
        {
            mParent.clearChildFocus(this);
        } //End block
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " clearChildFocus()");
        //}
        //mFocused = null;
        //if (mParent != null) {
            //mParent.clearChildFocus(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.418 -0400", hash_original_method = "2A2B29C64ED25C5483BB6B32C5BD1628", hash_generated_method = "967996658594C0B49C0157EF5C9421B8")
    @Override
    public void clearFocus() {
        super.clearFocus();
    if(mFocused != null)        
        {
            mFocused.clearFocus();
        } //End block
        // ---------- Original Method ----------
        //super.clearFocus();
        //if (mFocused != null) {
            //mFocused.clearFocus();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.418 -0400", hash_original_method = "AD8CA09F957410559E0C3DF16ADDE822", hash_generated_method = "0DEB98F8BE6E15006175695D3CDF17F5")
    @Override
     void unFocus() {
    if(DBG)        
        {
            System.out.println(this + " unFocus()");
        } //End block
        super.unFocus();
    if(mFocused != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.419 -0400", hash_original_method = "F6AEE91365C496A95D4F4B1572422CF5", hash_generated_method = "5F938ACA1354FE50C0C852DE648B82FB")
    public View getFocusedChild() {
View var2D88D1CA663928F256EE13E1B5302149_1660676793 =         mFocused;
        var2D88D1CA663928F256EE13E1B5302149_1660676793.addTaint(taint);
        return var2D88D1CA663928F256EE13E1B5302149_1660676793;
        // ---------- Original Method ----------
        //return mFocused;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.419 -0400", hash_original_method = "3D9AAFDE8E8826B256A10D32D774D94B", hash_generated_method = "7E9154501BCC0B8234537C572B2B9A93")
    @Override
    public boolean hasFocus() {
        boolean var9F9F70BB63D42AA061212110BAF2CBC7_888388596 = ((mPrivateFlags & FOCUSED) != 0 || mFocused != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125031535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_125031535;
        // ---------- Original Method ----------
        //return (mPrivateFlags & FOCUSED) != 0 || mFocused != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.419 -0400", hash_original_method = "8D50679A3D30F96CD0297A05342EFA70", hash_generated_method = "FC4738CCB9016FB70D2138007D951DA3")
    @Override
    public View findFocus() {
    if(DBG)        
        {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        } //End block
    if(isFocused())        
        {
View var72A74007B2BE62B849F475C7BDA4658B_1082528862 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1082528862.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1082528862;
        } //End block
    if(mFocused != null)        
        {
View varFE641E0984CCFFF141AB1C7E4A7E0A0C_484422346 =             mFocused.findFocus();
            varFE641E0984CCFFF141AB1C7E4A7E0A0C_484422346.addTaint(taint);
            return varFE641E0984CCFFF141AB1C7E4A7E0A0C_484422346;
        } //End block
View var540C13E9E156B687226421B24F2DF178_651174585 =         null;
        var540C13E9E156B687226421B24F2DF178_651174585.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_651174585;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.420 -0400", hash_original_method = "415824CC4E37F2B08D458BE00E3F5A3F", hash_generated_method = "2EFC58766041398D97369BA7F375CCEF")
    @Override
    public boolean hasFocusable() {
    if((mViewFlags & VISIBILITY_MASK) != VISIBLE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1237223401 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411905492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411905492;
        } //End block
    if(isFocusable())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1890537403 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372774084 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372774084;
        } //End block
        final int descendantFocusability = getDescendantFocusability();
    if(descendantFocusability != FOCUS_BLOCK_DESCENDANTS)        
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
    if(child.hasFocusable())                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1312358277 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017479955 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017479955;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_905424824 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460066897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_460066897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.420 -0400", hash_original_method = "2428CCD79B4CEE814D080BAF1161F8B9", hash_generated_method = "2C2945E0908F0098815D4E600E58A181")
    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        addTaint(direction);
        addTaint(views.getTaint());
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
        // ---------- Original Method ----------
        //addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.421 -0400", hash_original_method = "A281D125D4DD0434A87F479D62DD0361", hash_generated_method = "E3B33EFD068330A690072A4E981B01DE")
    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        addTaint(focusableMode);
        addTaint(direction);
        addTaint(views.getTaint());
        final int focusableCount = views.size();
        final int descendantFocusability = getDescendantFocusability();
    if(descendantFocusability != FOCUS_BLOCK_DESCENDANTS)        
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE)                
                {
                    child.addFocusables(views, direction, focusableMode);
                } //End block
            } //End block
        } //End block
    if(descendantFocusability != FOCUS_AFTER_DESCENDANTS ||
                (focusableCount == views.size()))        
        {
            super.addFocusables(views, direction, focusableMode);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.422 -0400", hash_original_method = "01B0DFF5DFF6A04EF473202885B21AEA", hash_generated_method = "2AEAE5A67EFB0CAD49CF9A7489CF3612")
    @Override
    public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags) {
        addTaint(flags);
        addTaint(text.getTaint());
        addTaint(outViews.getTaint());
        super.findViewsWithText(outViews, text, flags);
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < childrenCount;i++)
        {
            View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    && (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0)            
            {
                child.findViewsWithText(outViews, text, flags);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.422 -0400", hash_original_method = "E63784DE90D03F6D10488691622E702B", hash_generated_method = "54725460EB1A9333064A90AB0D48D096")
    @Override
     View findViewByAccessibilityIdTraversal(int accessibilityId) {
        addTaint(accessibilityId);
        View foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
    if(foundView != null)        
        {
View varC924E529DE927E973A786678D4C8F00A_650629638 =             foundView;
            varC924E529DE927E973A786678D4C8F00A_650629638.addTaint(taint);
            return varC924E529DE927E973A786678D4C8F00A_650629638;
        } //End block
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < childrenCount;i++)
        {
            View child = children[i];
            foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
    if(foundView != null)            
            {
View varC924E529DE927E973A786678D4C8F00A_2058865779 =                 foundView;
                varC924E529DE927E973A786678D4C8F00A_2058865779.addTaint(taint);
                return varC924E529DE927E973A786678D4C8F00A_2058865779;
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_1617927855 =         null;
        var540C13E9E156B687226421B24F2DF178_1617927855.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1617927855;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.423 -0400", hash_original_method = "8947E2F3FD45B1E1CD9A8BF9F902DE4D", hash_generated_method = "E2966F624CBF3734899A5D579E4275A6")
    @Override
    public void dispatchWindowFocusChanged(boolean hasFocus) {
        addTaint(hasFocus);
        super.dispatchWindowFocusChanged(hasFocus);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchWindowFocusChanged(hasFocus);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchWindowFocusChanged(hasFocus);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchWindowFocusChanged(hasFocus);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.423 -0400", hash_original_method = "3C050A87A5AA11FCC905DB1242C91519", hash_generated_method = "72D8CB7938F0C780D99FE664211DDA3D")
    @Override
    public void addTouchables(ArrayList<View> views) {
        addTaint(views.getTaint());
        super.addTouchables(views);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE)            
            {
                child.addTouchables(views);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.423 -0400", hash_original_method = "E3ECA4D0183F28678AE9A73BEBE4A4C4", hash_generated_method = "F40E01684BD5314F57D19ED56D0593E7")
    @Override
    public void dispatchDisplayHint(int hint) {
        addTaint(hint);
        super.dispatchDisplayHint(hint);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchDisplayHint(hint);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchDisplayHint(hint);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchDisplayHint(hint);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.424 -0400", hash_original_method = "39046505104385736A9526E25AC3965D", hash_generated_method = "C2250440708CA62DC29F0FE3B9C18947")
    protected void onChildVisibilityChanged(View child, int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(visibility);
        addTaint(child.getTaint());
    if(mTransition != null)        
        {
    if(visibility == VISIBLE)            
            {
                mTransition.showChild(this, child);
            } //End block
            else
            {
                mTransition.hideChild(this, child);
            } //End block
    if(visibility != VISIBLE)            
            {
    if(mVisibilityChangingChildren == null)                
                {
                    mVisibilityChangingChildren = new ArrayList<View>();
                } //End block
                mVisibilityChangingChildren.add(child);
    if(mTransitioningViews != null && mTransitioningViews.contains(child))                
                {
                    addDisappearingView(child);
                } //End block
            } //End block
        } //End block
    if(mCurrentDrag != null)        
        {
    if(visibility == VISIBLE)            
            {
                notifyChildOfDrag(child);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.424 -0400", hash_original_method = "66EC1DB8C5DE29B0D05D23F4BE080169", hash_generated_method = "7584F91F526D0E9FDAE3D2216F4922A6")
    @Override
    protected void dispatchVisibilityChanged(View changedView, int visibility) {
        addTaint(visibility);
        addTaint(changedView.getTaint());
        super.dispatchVisibilityChanged(changedView, visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchVisibilityChanged(changedView, visibility);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchVisibilityChanged(changedView, visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchVisibilityChanged(changedView, visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.424 -0400", hash_original_method = "110C8ADF44E81EF076420285F756776D", hash_generated_method = "7B2D6461870BDB6F18ED19E92FEBE03F")
    @Override
    public void dispatchWindowVisibilityChanged(int visibility) {
        addTaint(visibility);
        super.dispatchWindowVisibilityChanged(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchWindowVisibilityChanged(visibility);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchWindowVisibilityChanged(visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchWindowVisibilityChanged(visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.424 -0400", hash_original_method = "4BA014AA7FB311F49457CF496AD5B6EF", hash_generated_method = "1AC5012DC3B50E95BE35B0E03DC01909")
    @Override
    public void dispatchConfigurationChanged(Configuration newConfig) {
        addTaint(newConfig.getTaint());
        super.dispatchConfigurationChanged(newConfig);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchConfigurationChanged(newConfig);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchConfigurationChanged(newConfig);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchConfigurationChanged(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.425 -0400", hash_original_method = "F881B5C75EE06984153060972C295D8F", hash_generated_method = "36D3E055CFEE365CDE6F1C4B38C100A5")
    public void recomputeViewAttributes(View child) {
        addTaint(child.getTaint());
    if(mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes)        
        {
            ViewParent parent = mParent;
    if(parent != null)            
            parent.recomputeViewAttributes(this);
        } //End block
        // ---------- Original Method ----------
        //if (mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            //ViewParent parent = mParent;
            //if (parent != null) parent.recomputeViewAttributes(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.425 -0400", hash_original_method = "99C97332C863B663BFCA518BE284DB35", hash_generated_method = "0FA9C678E1D4EB475CE7DB4F1B76FA86")
    @Override
     void dispatchCollectViewAttributes(int visibility) {
        addTaint(visibility);
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchCollectViewAttributes(visibility);
        } //End block
        // ---------- Original Method ----------
        //visibility |= mViewFlags&VISIBILITY_MASK;
        //super.dispatchCollectViewAttributes(visibility);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchCollectViewAttributes(visibility);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.425 -0400", hash_original_method = "C5DA1A7419AFEADC86BA0783BA235334", hash_generated_method = "6CD0C12DBAE5A84909F46187A1AB1977")
    public void bringChildToFront(View child) {
        addTaint(child.getTaint());
        int index = indexOfChild(child);
    if(index >= 0)        
        {
            removeFromArray(index);
            addInArray(child, mChildrenCount);
            child.mParent = this;
        } //End block
        // ---------- Original Method ----------
        //int index = indexOfChild(child);
        //if (index >= 0) {
            //removeFromArray(index);
            //addInArray(child, mChildrenCount);
            //child.mParent = this;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.427 -0400", hash_original_method = "0B94D743FFC1DE288527F02F6E8345CD", hash_generated_method = "3B33663489B14CE5D49C4D6C27CBBF04")
    @Override
    public boolean dispatchDragEvent(DragEvent event) {
        boolean retval = false;
        final float tx = event.mX;
        final float ty = event.mY;
        ViewRootImpl root = getViewRootImpl();
switch(event.mAction){
        case DragEvent.ACTION_DRAG_STARTED:
        {
            mCurrentDragView = null;
            mCurrentDrag = DragEvent.obtain(event);
    if(mDragNotifiedChildren == null)            
            {
                mDragNotifiedChildren = new HashSet<View>();
            } //End block
            else
            {
                mDragNotifiedChildren.clear();
            } //End block
            mChildAcceptsDrag = false;
            final int count = mChildrenCount;
            final View[] children = mChildren;
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
                child.mPrivateFlags2 &= ~View.DRAG_MASK;
    if(child.getVisibility() == VISIBLE)                
                {
                    final boolean handled = notifyChildOfDrag(children[i]);
    if(handled)                    
                    {
                        mChildAcceptsDrag = true;
                    } //End block
                } //End block
            } //End block
    if(mChildAcceptsDrag)            
            {
                retval = true;
            } //End block
        } //End block
        break;
        case DragEvent.ACTION_DRAG_ENDED:
        {
    if(mDragNotifiedChildren != null)            
            {
for(View child : mDragNotifiedChildren)
                {
                    child.dispatchDragEvent(event);
                    child.mPrivateFlags2 &= ~View.DRAG_MASK;
                    child.refreshDrawableState();
                } //End block
                mDragNotifiedChildren.clear();
                mCurrentDrag.recycle();
                mCurrentDrag = null;
            } //End block
    if(mChildAcceptsDrag)            
            {
                retval = true;
            } //End block
        } //End block
        break;
        case DragEvent.ACTION_DRAG_LOCATION:
        {
            final View target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
    if(mCurrentDragView != target)            
            {
                root.setDragFocus(target);
                final int action = event.mAction;
    if(mCurrentDragView != null)                
                {
                    final View view = mCurrentDragView;
                    event.mAction = DragEvent.ACTION_DRAG_EXITED;
                    view.dispatchDragEvent(event);
                    view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                    view.refreshDrawableState();
                } //End block
                mCurrentDragView = target;
    if(target != null)                
                {
                    event.mAction = DragEvent.ACTION_DRAG_ENTERED;
                    target.dispatchDragEvent(event);
                    target.mPrivateFlags2 |= View.DRAG_HOVERED;
                    target.refreshDrawableState();
                } //End block
                event.mAction = action;
            } //End block
    if(target != null)            
            {
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } //End block
        } //End block
        break;
        case DragEvent.ACTION_DRAG_EXITED:
        {
    if(mCurrentDragView != null)            
            {
                final View view = mCurrentDragView;
                view.dispatchDragEvent(event);
                view.mPrivateFlags2 &= ~View.DRAG_HOVERED;
                view.refreshDrawableState();
                mCurrentDragView = null;
            } //End block
        } //End block
        break;
        case DragEvent.ACTION_DROP:
        {
    if(ViewDebug.DEBUG_DRAG)            
            Log.d(View.VIEW_LOG_TAG, "Drop event: " + event);
            View target = findFrontmostDroppableChildAt(event.mX, event.mY, mLocalPoint);
    if(target != null)            
            {
    if(ViewDebug.DEBUG_DRAG)                
                Log.d(View.VIEW_LOG_TAG, "   dispatch drop to " + target);
                event.mX = mLocalPoint.x;
                event.mY = mLocalPoint.y;
                retval = target.dispatchDragEvent(event);
                event.mX = tx;
                event.mY = ty;
            } //End block
            else
            {
    if(ViewDebug.DEBUG_DRAG)                
                {
                    Log.d(View.VIEW_LOG_TAG, "   not dropped on an accepting view");
                } //End block
            } //End block
        } //End block
        break;
}    if(!retval)        
        {
            retval = super.dispatchDragEvent(event);
        } //End block
        boolean var020B759ADEF679A47CB9AFE965BB2314_1798948435 = (retval);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334237915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_334237915;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.428 -0400", hash_original_method = "A61A140E816A1C908C27B7F105ECC965", hash_generated_method = "980DBA450243218078AFE8660DE9A568")
     View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint) {
        addTaint(outLocalPoint.getTaint());
        addTaint(y);
        addTaint(x);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = count - 1;i >= 0;i--)
        {
            final View child = children[i];
    if(!child.canAcceptDrag())            
            {
                continue;
            } //End block
    if(isTransformedTouchPointInView(x, y, child, outLocalPoint))            
            {
View var73902FD3E151130B4329B76EF04D2A54_1662350036 =                 child;
                var73902FD3E151130B4329B76EF04D2A54_1662350036.addTaint(taint);
                return var73902FD3E151130B4329B76EF04D2A54_1662350036;
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_1923179473 =         null;
        var540C13E9E156B687226421B24F2DF178_1923179473.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1923179473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.428 -0400", hash_original_method = "01B6DB1535B88ABBDA0897E44597D185", hash_generated_method = "00E472F8A59725A6EC8C518E6A61A5AF")
     boolean notifyChildOfDrag(View child) {
        addTaint(child.getTaint());
    if(ViewDebug.DEBUG_DRAG)        
        {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        } //End block
        boolean canAccept = false;
    if(! mDragNotifiedChildren.contains(child))        
        {
            mDragNotifiedChildren.add(child);
            canAccept = child.dispatchDragEvent(mCurrentDrag);
    if(canAccept && !child.canAcceptDrag())            
            {
                child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                child.refreshDrawableState();
            } //End block
        } //End block
        boolean var7C160A680BF8FE3A1442CDA61F51A3C7_513594235 = (canAccept);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735122596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735122596;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.429 -0400", hash_original_method = "6EA017C64305C1BE29415F2C64CCEDD4", hash_generated_method = "01C5EBE119D3E8069202A4D7E0CB580E")
    @Override
    public void dispatchSystemUiVisibilityChanged(int visible) {
        addTaint(visible);
        super.dispatchSystemUiVisibilityChanged(visible);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i=0;i <count;i++)
        {
            final View child = children[i];
            child.dispatchSystemUiVisibilityChanged(visible);
        } //End block
        // ---------- Original Method ----------
        //super.dispatchSystemUiVisibilityChanged(visible);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i=0; i <count; i++) {
            //final View child = children[i];
            //child.dispatchSystemUiVisibilityChanged(visible);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.429 -0400", hash_original_method = "5F03A98EA003A081CE87491B56EF094D", hash_generated_method = "488407417D53F766539D16511C0B5CA3")
    @Override
     void updateLocalSystemUiVisibility(int localValue, int localChanges) {
        addTaint(localChanges);
        addTaint(localValue);
        super.updateLocalSystemUiVisibility(localValue, localChanges);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i=0;i <count;i++)
        {
            final View child = children[i];
            child.updateLocalSystemUiVisibility(localValue, localChanges);
        } //End block
        // ---------- Original Method ----------
        //super.updateLocalSystemUiVisibility(localValue, localChanges);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i=0; i <count; i++) {
            //final View child = children[i];
            //child.updateLocalSystemUiVisibility(localValue, localChanges);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.429 -0400", hash_original_method = "1796A9ED58069BDF38C7C072FE20CF71", hash_generated_method = "44A9602F8924F35EE76EC51D451EE223")
    @Override
    public boolean dispatchKeyEventPreIme(KeyEvent event) {
        addTaint(event.getTaint());
    if((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS))        
        {
            boolean varAD26EBB665BD1801922446CC5B67330F_1990491726 = (super.dispatchKeyEventPreIme(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687509554 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687509554;
        } //End block
        else
    if(mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS)        
        {
            boolean var67EB3F9E393515134372804C53C9C518_2144336194 = (mFocused.dispatchKeyEventPreIme(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544514036 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544514036;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_608481804 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451770486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_451770486;
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchKeyEventPreIme(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchKeyEventPreIme(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.430 -0400", hash_original_method = "1E41A7E6E3EFA9117FFB3A56DB417CA0", hash_generated_method = "E9260CC5D5905555D779A299268420D0")
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        } //End block
    if((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS))        
        {
    if(super.dispatchKeyEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1682705801 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075031976 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075031976;
            } //End block
        } //End block
        else
    if(mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS)        
        {
    if(mFocused.dispatchKeyEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1283814315 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242587237 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242587237;
            } //End block
        } //End block
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1240793100 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500542872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500542872;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.431 -0400", hash_original_method = "C8DF4A46704EEB88AB3A3DAEBDA2EE59", hash_generated_method = "7A37D3B53DE10021792480335A65BE11")
    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        addTaint(event.getTaint());
    if((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS))        
        {
            boolean var45F6457C378081163B5FC74C9DEC97F3_1615964878 = (super.dispatchKeyShortcutEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124279346 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_124279346;
        } //End block
        else
    if(mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS)        
        {
            boolean var5C18B5D2EFEF2D901A4FBE828D26F883_1912897880 = (mFocused.dispatchKeyShortcutEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327979324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327979324;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1948163862 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2050467913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2050467913;
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchKeyShortcutEvent(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchKeyShortcutEvent(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.431 -0400", hash_original_method = "CF1D00451039D1CA46B97508DE17783C", hash_generated_method = "581AE5AE98FE346CE680BBD804C07916")
    @Override
    public boolean dispatchTrackballEvent(MotionEvent event) {
        addTaint(event.getTaint());
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        } //End block
    if((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS))        
        {
    if(super.dispatchTrackballEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1788607430 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578345903 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_578345903;
            } //End block
        } //End block
        else
    if(mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS)        
        {
    if(mFocused.dispatchTrackballEvent(event))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1801255499 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933761297 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_933761297;
            } //End block
        } //End block
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_920219969 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882831724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882831724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.434 -0400", hash_original_method = "E0F6A76AF2BEDB6076446B6A929BAC84", hash_generated_method = "9979862E77C3CCE72EACACEB0BD857C3")
    @SuppressWarnings({"ConstantConditions"})
    @Override
    protected boolean dispatchHoverEvent(MotionEvent event) {
        addTaint(event.getTaint());
        final int action = event.getAction();
        final boolean interceptHover = onInterceptHoverEvent(event);
        event.setAction(action);
        MotionEvent eventNoHistory = event;
        boolean handled = false;
        HoverTarget firstOldHoverTarget = mFirstHoverTarget;
        mFirstHoverTarget = null;
    if(!interceptHover && action != MotionEvent.ACTION_HOVER_EXIT)        
        {
            final float x = event.getX();
            final float y = event.getY();
            final int childrenCount = mChildrenCount;
    if(childrenCount != 0)            
            {
                final View[] children = mChildren;
                HoverTarget lastHoverTarget = null;
for(int i = childrenCount - 1;i >= 0;i--)
                {
                    final View child = children[i];
    if(!canViewReceivePointerEvents(child)
                            || !isTransformedTouchPointInView(x, y, child, null))                    
                    {
                        continue;
                    } //End block
                    HoverTarget hoverTarget = firstOldHoverTarget;
                    boolean wasHovered;
for(HoverTarget predecessor = null;;)
                    {
    if(hoverTarget == null)                        
                        {
                            hoverTarget = HoverTarget.obtain(child);
                            wasHovered = false;
                            break;
                        } //End block
    if(hoverTarget.child == child)                        
                        {
    if(predecessor != null)                            
                            {
                                predecessor.next = hoverTarget.next;
                            } //End block
                            else
                            {
                                firstOldHoverTarget = hoverTarget.next;
                            } //End block
                            hoverTarget.next = null;
                            wasHovered = true;
                            break;
                        } //End block
                        predecessor = hoverTarget;
                        hoverTarget = hoverTarget.next;
                    } //End block
    if(lastHoverTarget != null)                    
                    {
                        lastHoverTarget.next = hoverTarget;
                    } //End block
                    else
                    {
                        lastHoverTarget = hoverTarget;
                        mFirstHoverTarget = hoverTarget;
                    } //End block
    if(action == MotionEvent.ACTION_HOVER_ENTER)                    
                    {
    if(!wasHovered)                        
                        {
                            handled |= dispatchTransformedGenericPointerEvent(
                                    event, child);
                        } //End block
                    } //End block
                    else
    if(action == MotionEvent.ACTION_HOVER_MOVE)                    
                    {
    if(!wasHovered)                        
                        {
                            eventNoHistory = obtainMotionEventNoHistoryOrSelf(eventNoHistory);
                            eventNoHistory.setAction(MotionEvent.ACTION_HOVER_ENTER);
                            handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                            eventNoHistory.setAction(action);
                            handled |= dispatchTransformedGenericPointerEvent(
                                    eventNoHistory, child);
                        } //End block
                        else
                        {
                            handled |= dispatchTransformedGenericPointerEvent(event, child);
                        } //End block
                    } //End block
    if(handled)                    
                    {
                        break;
                    } //End block
                } //End block
            } //End block
        } //End block
        while
(firstOldHoverTarget != null)        
        {
            final View child = firstOldHoverTarget.child;
    if(action == MotionEvent.ACTION_HOVER_EXIT)            
            {
                handled |= dispatchTransformedGenericPointerEvent(
                        event, child);
            } //End block
            else
            {
    if(action == MotionEvent.ACTION_HOVER_MOVE)                
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
            final HoverTarget nextOldHoverTarget = firstOldHoverTarget.next;
            firstOldHoverTarget.recycle();
            firstOldHoverTarget = nextOldHoverTarget;
        } //End block
        boolean newHoveredSelf = !handled;
    if(newHoveredSelf == mHoveredSelf)        
        {
    if(newHoveredSelf)            
            {
                handled |= super.dispatchHoverEvent(event);
            } //End block
        } //End block
        else
        {
    if(mHoveredSelf)            
            {
    if(action == MotionEvent.ACTION_HOVER_EXIT)                
                {
                    handled |= super.dispatchHoverEvent(event);
                } //End block
                else
                {
    if(action == MotionEvent.ACTION_HOVER_MOVE)                    
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
    if(newHoveredSelf)            
            {
    if(action == MotionEvent.ACTION_HOVER_ENTER)                
                {
                    handled |= super.dispatchHoverEvent(event);
                    mHoveredSelf = true;
                } //End block
                else
    if(action == MotionEvent.ACTION_HOVER_MOVE)                
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
    if(eventNoHistory != event)        
        {
            eventNoHistory.recycle();
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_150702154 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762327303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762327303;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.435 -0400", hash_original_method = "CAF0CE39145036A2F3E98F46F45FF397", hash_generated_method = "9500DCC137818C9C07070E4B5AE73D79")
    @Override
    protected boolean hasHoveredChild() {
        boolean var691CB797C7D641EC9107D527AE8EF0A0_667103579 = (mFirstHoverTarget != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920938223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920938223;
        // ---------- Original Method ----------
        //return mFirstHoverTarget != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.435 -0400", hash_original_method = "039A9532EA6933A3F4F8681C30CC9E2B", hash_generated_method = "3C81184ECFE1F3C20CED7D1ABC539E82")
    public boolean onInterceptHoverEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1710225509 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355008225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355008225;
        // ---------- Original Method ----------
        //return false;
    }

    
        private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event) {
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.435 -0400", hash_original_method = "8425E6039966203E8B52A55F0ACFD97E", hash_generated_method = "43BE7E489ABDAD0AD5BA4A3091E4924D")
    @Override
    protected boolean dispatchGenericPointerEvent(MotionEvent event) {
        addTaint(event.getTaint());
        final int childrenCount = mChildrenCount;
    if(childrenCount != 0)        
        {
            final View[] children = mChildren;
            final float x = event.getX();
            final float y = event.getY();
for(int i = childrenCount - 1;i >= 0;i--)
            {
                final View child = children[i];
    if(!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null))                
                {
                    continue;
                } //End block
    if(dispatchTransformedGenericPointerEvent(event, child))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_398978752 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250492298 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250492298;
                } //End block
            } //End block
        } //End block
        boolean var8FA0858FA87CEBD93204BD9A753A90CE_369367440 = (super.dispatchGenericPointerEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910608686 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910608686;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.437 -0400", hash_original_method = "EF2476E6EC182ADC11908B65D0A31365", hash_generated_method = "00D3BE2E1278BB2BD5AEED3BDD1E7FBD")
    @Override
    protected boolean dispatchGenericFocusedEvent(MotionEvent event) {
        addTaint(event.getTaint());
    if((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS))        
        {
            boolean var06DFB0F35E9F10B2081F8C55181B9CEE_1120684451 = (super.dispatchGenericFocusedEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1320408324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1320408324;
        } //End block
        else
    if(mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS)        
        {
            boolean var1353853FA34FA9D345150925B27CC14A_1524430108 = (mFocused.dispatchGenericMotionEvent(event));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1011400456 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1011400456;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_342007857 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979365691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979365691;
        // ---------- Original Method ----------
        //if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            //return super.dispatchGenericFocusedEvent(event);
        //} else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            //return mFocused.dispatchGenericMotionEvent(event);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.437 -0400", hash_original_method = "89F3902132A72D71D534028C51E6FDBB", hash_generated_method = "8C6059D6FA64A8D2E045A6280519A798")
    private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child) {
        addTaint(child.getTaint());
        addTaint(event.getTaint());
        final float offsetX = mScrollX - child.mLeft;
        final float offsetY = mScrollY - child.mTop;
        boolean handled;
    if(!child.hasIdentityMatrix())        
        {
            MotionEvent transformedEvent = MotionEvent.obtain(event);
            transformedEvent.offsetLocation(offsetX, offsetY);
            transformedEvent.transform(child.getInverseMatrix());
            handled = child.dispatchGenericMotionEvent(transformedEvent);
            transformedEvent.recycle();
        } //End block
        else
        {
            event.offsetLocation(offsetX, offsetY);
            handled = child.dispatchGenericMotionEvent(event);
            event.offsetLocation(-offsetX, -offsetY);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_712745804 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985056586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985056586;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.438 -0400", hash_original_method = "9A4777971E22B675E68E924B82246A95", hash_generated_method = "C780289A05D3372BFBDEAC05A468DC6E")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
    if(mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onTouchEvent(ev, 1);
        } //End block
        boolean handled = false;
    if(onFilterTouchEventForSecurity(ev))        
        {
            final int action = ev.getAction();
            final int actionMasked = action & MotionEvent.ACTION_MASK;
    if(actionMasked == MotionEvent.ACTION_DOWN)            
            {
                cancelAndClearTouchTargets(ev);
                resetTouchState();
            } //End block
            boolean intercepted;
    if(actionMasked == MotionEvent.ACTION_DOWN
                    || mFirstTouchTarget != null)            
            {
                final boolean disallowIntercept = (mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0;
    if(!disallowIntercept)                
                {
                    intercepted = onInterceptTouchEvent(ev);
                    ev.setAction(action);
                } //End block
                else
                {
                    intercepted = false;
                } //End block
            } //End block
            else
            {
                intercepted = true;
            } //End block
            final boolean canceled = resetCancelNextUpFlag(this)
                    || actionMasked == MotionEvent.ACTION_CANCEL;
            final boolean split = (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) != 0;
            TouchTarget newTouchTarget = null;
            boolean alreadyDispatchedToNewTouchTarget = false;
    if(!canceled && !intercepted)            
            {
    if(actionMasked == MotionEvent.ACTION_DOWN
                        || (split && actionMasked == MotionEvent.ACTION_POINTER_DOWN)
                        || actionMasked == MotionEvent.ACTION_HOVER_MOVE)                
                {
                    final int actionIndex = ev.getActionIndex();
                    final int idBitsToAssign = split ? 1 << ev.getPointerId(actionIndex)
                            : TouchTarget.ALL_POINTER_IDS;
                    removePointersFromTouchTargets(idBitsToAssign);
                    final int childrenCount = mChildrenCount;
    if(childrenCount != 0)                    
                    {
                        final View[] children = mChildren;
                        final float x = ev.getX(actionIndex);
                        final float y = ev.getY(actionIndex);
for(int i = childrenCount - 1;i >= 0;i--)
                        {
                            final View child = children[i];
    if(!canViewReceivePointerEvents(child)
                                    || !isTransformedTouchPointInView(x, y, child, null))                            
                            {
                                continue;
                            } //End block
                            newTouchTarget = getTouchTarget(child);
    if(newTouchTarget != null)                            
                            {
                                newTouchTarget.pointerIdBits |= idBitsToAssign;
                                break;
                            } //End block
                            resetCancelNextUpFlag(child);
    if(dispatchTransformedTouchEvent(ev, false, child, idBitsToAssign))                            
                            {
                                mLastTouchDownTime = ev.getDownTime();
                                mLastTouchDownIndex = i;
                                mLastTouchDownX = ev.getX();
                                mLastTouchDownY = ev.getY();
                                newTouchTarget = addTouchTarget(child, idBitsToAssign);
                                alreadyDispatchedToNewTouchTarget = true;
                                break;
                            } //End block
                        } //End block
                    } //End block
    if(newTouchTarget == null && mFirstTouchTarget != null)                    
                    {
                        newTouchTarget = mFirstTouchTarget;
                        while
(newTouchTarget.next != null)                        
                        {
                            newTouchTarget = newTouchTarget.next;
                        } //End block
                        newTouchTarget.pointerIdBits |= idBitsToAssign;
                    } //End block
                } //End block
            } //End block
    if(mFirstTouchTarget == null)            
            {
                handled = dispatchTransformedTouchEvent(ev, canceled, null,
                        TouchTarget.ALL_POINTER_IDS);
            } //End block
            else
            {
                TouchTarget predecessor = null;
                TouchTarget target = mFirstTouchTarget;
                while
(target != null)                
                {
                    final TouchTarget next = target.next;
    if(alreadyDispatchedToNewTouchTarget && target == newTouchTarget)                    
                    {
                        handled = true;
                    } //End block
                    else
                    {
                        final boolean cancelChild = resetCancelNextUpFlag(target.child)
                        || intercepted;
    if(dispatchTransformedTouchEvent(ev, cancelChild,
                                target.child, target.pointerIdBits))                        
                        {
                            handled = true;
                        } //End block
    if(cancelChild)                        
                        {
    if(predecessor == null)                            
                            {
                                mFirstTouchTarget = next;
                            } //End block
                            else
                            {
                                predecessor.next = next;
                            } //End block
                            target.recycle();
                            target = next;
                            continue;
                        } //End block
                    } //End block
                    predecessor = target;
                    target = next;
                } //End block
            } //End block
    if(canceled
                    || actionMasked == MotionEvent.ACTION_UP
                    || actionMasked == MotionEvent.ACTION_HOVER_MOVE)            
            {
                resetTouchState();
            } //End block
            else
    if(split && actionMasked == MotionEvent.ACTION_POINTER_UP)            
            {
                final int actionIndex = ev.getActionIndex();
                final int idBitsToRemove = 1 << ev.getPointerId(actionIndex);
                removePointersFromTouchTargets(idBitsToRemove);
            } //End block
        } //End block
    if(!handled && mInputEventConsistencyVerifier != null)        
        {
            mInputEventConsistencyVerifier.onUnhandledEvent(ev, 1);
        } //End block
        boolean var98F0599AF776A1FE4101C199A40EEB8F_173169293 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996929687 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996929687;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.449 -0400", hash_original_method = "1B0EC47DAA405380670E223779C878A6", hash_generated_method = "FB0BEF6A0D13DDEE91DD6A9C23FE556F")
    private void resetTouchState() {
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        // ---------- Original Method ----------
        //clearTouchTargets();
        //resetCancelNextUpFlag(this);
        //mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.449 -0400", hash_original_method = "B31FF6D343B2149E4D841C0A7CD04309", hash_generated_method = "B753B270043C4897FBCA9AC04A4DFB08")
    private boolean resetCancelNextUpFlag(View view) {
        addTaint(view.getTaint());
    if((view.mPrivateFlags & CANCEL_NEXT_UP_EVENT) != 0)        
        {
            view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
            boolean varB326B5062B2F0E69046810717534CB09_104770072 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222216693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_222216693;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1048310698 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870722472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870722472;
        // ---------- Original Method ----------
        //if ((view.mPrivateFlags & CANCEL_NEXT_UP_EVENT) != 0) {
            //view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.449 -0400", hash_original_method = "C1060B6E54563910E15717B9621A0CC6", hash_generated_method = "20D70BF0EA31BD3D233BD810063F1C37")
    private void clearTouchTargets() {
        TouchTarget target = mFirstTouchTarget;
    if(target != null)        
        {
            do {
                {
                    TouchTarget next = target.next;
                    target.recycle();
                    target = next;
                } //End block
} while (target != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.449 -0400", hash_original_method = "45B19A2C35386F46FF7561697C2C88B0", hash_generated_method = "606D09106E32FB54FB86C0BB1FECAD08")
    private void cancelAndClearTouchTargets(MotionEvent event) {
        addTaint(event.getTaint());
    if(mFirstTouchTarget != null)        
        {
            boolean syntheticEvent = false;
    if(event == null)            
            {
                final long now = SystemClock.uptimeMillis();
                event = MotionEvent.obtain(now, now,
                        MotionEvent.ACTION_CANCEL, 0.0f, 0.0f, 0);
                event.setSource(InputDevice.SOURCE_TOUCHSCREEN);
                syntheticEvent = true;
            } //End block
for(TouchTarget target = mFirstTouchTarget;target != null;target = target.next)
            {
                resetCancelNextUpFlag(target.child);
                dispatchTransformedTouchEvent(event, true, target.child, target.pointerIdBits);
            } //End block
            clearTouchTargets();
    if(syntheticEvent)            
            {
                event.recycle();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.450 -0400", hash_original_method = "1855BFFFC59D88D1613C9B59C4B43D4C", hash_generated_method = "91CB85E47B56EC1E5A69F072D28C28AE")
    private TouchTarget getTouchTarget(View child) {
        addTaint(child.getTaint());
for(TouchTarget target = mFirstTouchTarget;target != null;target = target.next)
        {
    if(target.child == child)            
            {
TouchTarget varA7DD35DE8EDE4A2FCAF77CE202E687B3_160083869 =                 target;
                varA7DD35DE8EDE4A2FCAF77CE202E687B3_160083869.addTaint(taint);
                return varA7DD35DE8EDE4A2FCAF77CE202E687B3_160083869;
            } //End block
        } //End block
TouchTarget var540C13E9E156B687226421B24F2DF178_1089381566 =         null;
        var540C13E9E156B687226421B24F2DF178_1089381566.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1089381566;
        // ---------- Original Method ----------
        //for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
            //if (target.child == child) {
                //return target;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.452 -0400", hash_original_method = "70A66C4E824C8984FFB5B6F600FB9D61", hash_generated_method = "D7D8F1A4F361B191BCECF56FA41EF6BE")
    private TouchTarget addTouchTarget(View child, int pointerIdBits) {
        addTaint(pointerIdBits);
        addTaint(child.getTaint());
        TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
TouchTarget varA7DD35DE8EDE4A2FCAF77CE202E687B3_90947240 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_90947240.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_90947240;
        // ---------- Original Method ----------
        //TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        //target.next = mFirstTouchTarget;
        //mFirstTouchTarget = target;
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.453 -0400", hash_original_method = "89D343983AE77FFA55E239C56C6BE82A", hash_generated_method = "6E24B870B5DCA66140DD99D0A57F91FF")
    private void removePointersFromTouchTargets(int pointerIdBits) {
        addTaint(pointerIdBits);
        TouchTarget predecessor = null;
        TouchTarget target = mFirstTouchTarget;
        while
(target != null)        
        {
            final TouchTarget next = target.next;
    if((target.pointerIdBits & pointerIdBits) != 0)            
            {
                target.pointerIdBits &= ~pointerIdBits;
    if(target.pointerIdBits == 0)                
                {
    if(predecessor == null)                    
                    {
                        mFirstTouchTarget = next;
                    } //End block
                    else
                    {
                        predecessor.next = next;
                    } //End block
                    target.recycle();
                    target = next;
                    continue;
                } //End block
            } //End block
            predecessor = target;
            target = next;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.453 -0400", hash_original_method = "DEC14653C28ED7E684FDD980020C985C", hash_generated_method = "DF7065DF1E5A1E24CB162B8736DA5067")
    protected boolean isTransformedTouchPointInView(float x, float y, View child,
            PointF outLocalPoint) {
        addTaint(outLocalPoint.getTaint());
        addTaint(child.getTaint());
        addTaint(y);
        addTaint(x);
        float localX = x + mScrollX - child.mLeft;
        float localY = y + mScrollY - child.mTop;
    if(! child.hasIdentityMatrix() && mAttachInfo != null)        
        {
            final float[] localXY = mAttachInfo.mTmpTransformLocation;
            localXY[0] = localX;
            localXY[1] = localY;
            child.getInverseMatrix().mapPoints(localXY);
            localX = localXY[0];
            localY = localXY[1];
        } //End block
        final boolean isInView = child.pointInView(localX, localY);
    if(isInView && outLocalPoint != null)        
        {
            outLocalPoint.set(localX, localY);
        } //End block
        boolean varAA526901E4660D693B9B802DFC753973_527666871 = (isInView);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178707083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_178707083;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.455 -0400", hash_original_method = "EAB22EDFF178A3FABE990E65ADB3332F", hash_generated_method = "4BD35E740B0E1A6BB9711A388D6F9524")
    private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits) {
        addTaint(desiredPointerIdBits);
        addTaint(child.getTaint());
        addTaint(cancel);
        addTaint(event.getTaint());
        boolean handled;
        final int oldAction = event.getAction();
    if(cancel || oldAction == MotionEvent.ACTION_CANCEL)        
        {
            event.setAction(MotionEvent.ACTION_CANCEL);
    if(child == null)            
            {
                handled = super.dispatchTouchEvent(event);
            } //End block
            else
            {
                handled = child.dispatchTouchEvent(event);
            } //End block
            event.setAction(oldAction);
            boolean var98F0599AF776A1FE4101C199A40EEB8F_962641654 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471410853 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_471410853;
        } //End block
        final int oldPointerIdBits = event.getPointerIdBits();
        final int newPointerIdBits = oldPointerIdBits & desiredPointerIdBits;
    if(newPointerIdBits == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_515349502 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121925012 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_121925012;
        } //End block
        MotionEvent transformedEvent;
    if(newPointerIdBits == oldPointerIdBits)        
        {
    if(child == null || child.hasIdentityMatrix())            
            {
    if(child == null)                
                {
                    handled = super.dispatchTouchEvent(event);
                } //End block
                else
                {
                    final float offsetX = mScrollX - child.mLeft;
                    final float offsetY = mScrollY - child.mTop;
                    event.offsetLocation(offsetX, offsetY);
                    handled = child.dispatchTouchEvent(event);
                    event.offsetLocation(-offsetX, -offsetY);
                } //End block
                boolean var98F0599AF776A1FE4101C199A40EEB8F_419939336 = (handled);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391981910 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_391981910;
            } //End block
            transformedEvent = MotionEvent.obtain(event);
        } //End block
        else
        {
            transformedEvent = event.split(newPointerIdBits);
        } //End block
    if(child == null)        
        {
            handled = super.dispatchTouchEvent(transformedEvent);
        } //End block
        else
        {
            final float offsetX = mScrollX - child.mLeft;
            final float offsetY = mScrollY - child.mTop;
            transformedEvent.offsetLocation(offsetX, offsetY);
    if(! child.hasIdentityMatrix())            
            {
                transformedEvent.transform(child.getInverseMatrix());
            } //End block
            handled = child.dispatchTouchEvent(transformedEvent);
        } //End block
        transformedEvent.recycle();
        boolean var98F0599AF776A1FE4101C199A40EEB8F_1676167631 = (handled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69826740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69826740;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.455 -0400", hash_original_method = "2F47BE30FCD7EA97F91B7B6F74081615", hash_generated_method = "D911B2DA92C5859318E7FFC0E72C6AAB")
    public void setMotionEventSplittingEnabled(boolean split) {
        addTaint(split);
    if(split)        
        {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } //End block
        else
        {
            mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        } //End block
        // ---------- Original Method ----------
        //if (split) {
            //mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        //} else {
            //mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.455 -0400", hash_original_method = "F89425D39488194D486F55EA5F8582C3", hash_generated_method = "C4E827EB791AA7AEFE78F76FAC7272CA")
    public boolean isMotionEventSplittingEnabled() {
        boolean var6E66B9803A17F451177E1783526B17F5_1068653888 = ((mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776309373 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776309373;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.455 -0400", hash_original_method = "1DFD5D86FC853DC6CE8B88AE68ABB735", hash_generated_method = "D50F1ABE1C3946983A15BF797DA26B23")
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        addTaint(disallowIntercept);
    if(disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0))        
        {
            return;
        } //End block
    if(disallowIntercept)        
        {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } //End block
        else
        {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        } //End block
    if(mParent != null)        
        {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.456 -0400", hash_original_method = "2FB27FC0FD3119EC0BB03A9B8DB1F75C", hash_generated_method = "D3183671117DD9E15B80DB6DE32796D1")
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(ev.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1548607506 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_187996531 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_187996531;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.456 -0400", hash_original_method = "C4273E4BE381C7F0CE1D54BE1CF759CA", hash_generated_method = "54931767A226E96928D16FBF1B9676FC")
    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
    if(DBG)        
        {
            System.out.println(this + " ViewGroup.requestFocus direction="
                    + direction);
        } //End block
        int descendantFocusability = getDescendantFocusability();
switch(descendantFocusability){
        case FOCUS_BLOCK_DESCENDANTS:
        boolean var7099514E4AF279E1F75517A262FE9D78_379245190 = (super.requestFocus(direction, previouslyFocusedRect));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066911284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066911284;
        case FOCUS_BEFORE_DESCENDANTS:
        {
            final boolean took = super.requestFocus(direction, previouslyFocusedRect);
            boolean var2B62CC438A4575F03C2C63A1CE1E2659_1206018131 = (took ? took : onRequestFocusInDescendants(direction, previouslyFocusedRect));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728302752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_728302752;
        } //End block
        case FOCUS_AFTER_DESCENDANTS:
        {
            final boolean took = onRequestFocusInDescendants(direction, previouslyFocusedRect);
            boolean varE8F264ECB5528EAEC8351269E67D124D_1892393083 = (took ? took : super.requestFocus(direction, previouslyFocusedRect));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1190255878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1190255878;
        } //End block
        default:
        IllegalStateException varA66618BCDE1225525CF2A1EA5E6D183B_247001554 = new IllegalStateException("descendant focusability must be "
                        + "one of FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS "
                        + "but is " + descendantFocusability);
        varA66618BCDE1225525CF2A1EA5E6D183B_247001554.addTaint(taint);
        throw varA66618BCDE1225525CF2A1EA5E6D183B_247001554;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.456 -0400", hash_original_method = "47C4A34C6E68C9FD22237D5A1759ABE2", hash_generated_method = "344524C43791E3ADAD51A2C3F653263F")
    @SuppressWarnings({"ConstantConditions"})
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(previouslyFocusedRect.getTaint());
        addTaint(direction);
        int index;
        int increment;
        int end;
        int count = mChildrenCount;
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
        final View[] children = mChildren;
for(int i = index;i != end;i += increment)
        {
            View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE)            
            {
    if(child.requestFocus(direction, previouslyFocusedRect))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1832650788 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_873354594 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_873354594;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_365274665 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255792938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255792938;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.457 -0400", hash_original_method = "C10088C0D1BE61F270AE8158B60FC677", hash_generated_method = "F18E65C80057528430DA69FD6E3E0502")
    @Override
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchStartTemporaryDetach();
        } //End block
        // ---------- Original Method ----------
        //super.dispatchStartTemporaryDetach();
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchStartTemporaryDetach();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.457 -0400", hash_original_method = "F13891122244193473AAFE5583088FC4", hash_generated_method = "1B44BEDD5FB3475D6D10474A7809A888")
    @Override
    public void dispatchFinishTemporaryDetach() {
        super.dispatchFinishTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchFinishTemporaryDetach();
        } //End block
        // ---------- Original Method ----------
        //super.dispatchFinishTemporaryDetach();
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //children[i].dispatchFinishTemporaryDetach();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.457 -0400", hash_original_method = "8739A5508C26F7DDD3FFEBEE4CD95BC5", hash_generated_method = "161975670B1AECF370CCA09B897277EE")
    @Override
     void dispatchAttachedToWindow(AttachInfo info, int visibility) {
        addTaint(visibility);
        addTaint(info.getTaint());
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        visibility |= mViewFlags & VISIBILITY_MASK;
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchAttachedToWindow(info, visibility);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.457 -0400", hash_original_method = "1EE087DB6D320A1AB0B1F5665AE9972D", hash_generated_method = "356DCFE18DAB441DBA6EF12928A465D8")
    @Override
     boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event) {
        addTaint(event.getTaint());
        boolean handled = super.dispatchPopulateAccessibilityEventInternal(event);
    if(handled)        
        {
            boolean var98F0599AF776A1FE4101C199A40EEB8F_1919163546 = (handled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557781554 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557781554;
        } //End block
for(int i = 0, count = getChildCount();i < count;i++)
        {
            View child = getChildAt(i);
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE)            
            {
                handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
    if(handled)                
                {
                    boolean var98F0599AF776A1FE4101C199A40EEB8F_590045784 = (handled);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1804642549 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1804642549;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_185175524 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705388510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705388510;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.457 -0400", hash_original_method = "D1F5A3B1D56655AA52CA4B460A89AF1D", hash_generated_method = "5C5BD83AD2BFA01C3C671F6B2E0681FD")
    @Override
     void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(info.getTaint());
        super.onInitializeAccessibilityNodeInfoInternal(info);
for(int i = 0, count = mChildrenCount;i < count;i++)
        {
            View child = mChildren[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    && (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0)            
            {
                info.addChild(child);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.458 -0400", hash_original_method = "C93583B1C6CD82E84CFB16E69C063BD6", hash_generated_method = "E28DB1D988C403824565D1C183596ECA")
    @Override
     void dispatchDetachedFromWindow() {
        cancelAndClearTouchTargets(null);
        mLayoutSuppressed = false;
        mDragNotifiedChildren = null;
    if(mCurrentDrag != null)        
        {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        } //End block
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            children[i].dispatchDetachedFromWindow();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.458 -0400", hash_original_method = "3A8CBF91275A500D30CEFAD8D7209E14", hash_generated_method = "7299D023BE318EAC6B37B61A50A7D407")
    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        super.setPadding(left, top, right, bottom);
    if((mPaddingLeft | mPaddingTop | mPaddingRight | mPaddingBottom) != 0)        
        {
            mGroupFlags |= FLAG_PADDING_NOT_NULL;
        } //End block
        else
        {
            mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        } //End block
        // ---------- Original Method ----------
        //super.setPadding(left, top, right, bottom);
        //if ((mPaddingLeft | mPaddingTop | mPaddingRight | mPaddingBottom) != 0) {
            //mGroupFlags |= FLAG_PADDING_NOT_NULL;
        //} else {
            //mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.458 -0400", hash_original_method = "0EF6BC3550040660942BB4435DC1568A", hash_generated_method = "7DC81A94DA0BE020039ABCAF58F529F2")
    @Override
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        super.dispatchSaveInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            View c = children[i];
    if((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED)            
            {
                c.dispatchSaveInstanceState(container);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.458 -0400", hash_original_method = "38DCBB8C3886F11C25C07FC151CB762B", hash_generated_method = "AD6C26FCB08F25CD9F00A15FFF2245C0")
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        super.dispatchSaveInstanceState(container);
        // ---------- Original Method ----------
        //super.dispatchSaveInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.458 -0400", hash_original_method = "79E9ACE6A349ACE584637F3A31A0E869", hash_generated_method = "2D840581DBC43FD90A136067E8A4311B")
    @Override
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        super.dispatchRestoreInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            View c = children[i];
    if((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED)            
            {
                c.dispatchRestoreInstanceState(container);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.459 -0400", hash_original_method = "85A5428D5025B10E5C75238A5C358628", hash_generated_method = "A2BEB32EB8CEC75DFF54866B13BD1381")
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container) {
        addTaint(container.getTaint());
        super.dispatchRestoreInstanceState(container);
        // ---------- Original Method ----------
        //super.dispatchRestoreInstanceState(container);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.459 -0400", hash_original_method = "673779FD01170D0D857F4CAC6D3A5472", hash_generated_method = "2514501BE0A3CC9FFB51A5846D7A0232")
    protected void setChildrenDrawingCacheEnabled(boolean enabled) {
        addTaint(enabled);
    if(enabled || (mPersistentDrawingCache & PERSISTENT_ALL_CACHES) != PERSISTENT_ALL_CACHES)        
        {
            final View[] children = mChildren;
            final int count = mChildrenCount;
for(int i = 0;i < count;i++)
            {
                children[i].setDrawingCacheEnabled(enabled);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (enabled || (mPersistentDrawingCache & PERSISTENT_ALL_CACHES) != PERSISTENT_ALL_CACHES) {
            //final View[] children = mChildren;
            //final int count = mChildrenCount;
            //for (int i = 0; i < count; i++) {
                //children[i].setDrawingCacheEnabled(enabled);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.459 -0400", hash_original_method = "C6BD5BCC8D99F50AFC626E34071E2FAF", hash_generated_method = "A124A8FDEC4DFE54A3A982869CB8A044")
    @Override
    protected void onAnimationStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationStart();
    if((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE)        
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            final boolean buildCache = !isHardwareAccelerated();
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE)                
                {
                    child.setDrawingCacheEnabled(true);
    if(buildCache)                    
                    {
                        child.buildDrawingCache(true);
                    } //End block
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.459 -0400", hash_original_method = "D937B1A7AD9A1EFB7CAF69E9B3174965", hash_generated_method = "529B56950A58E4725CADEF109ED5C0E6")
    @Override
    protected void onAnimationEnd() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAnimationEnd();
    if((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE)        
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
    if((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.460 -0400", hash_original_method = "8B8B5866E6978A8C0D1BC17BB86DCAFE", hash_generated_method = "27EA707857B8CDBB19149AB3C0B86ECB")
    @Override
     Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren) {
        addTaint(skipChildren);
        addTaint(backgroundColor);
        addTaint(quality.getTaint());
        int count = mChildrenCount;
        int[] visibilities = null;
    if(skipChildren)        
        {
            visibilities = new int[count];
for(int i = 0;i < count;i++)
            {
                View child = getChildAt(i);
                visibilities[i] = child.getVisibility();
    if(visibilities[i] == View.VISIBLE)                
                {
                    child.setVisibility(INVISIBLE);
                } //End block
            } //End block
        } //End block
        Bitmap b = super.createSnapshot(quality, backgroundColor, skipChildren);
    if(skipChildren)        
        {
for(int i = 0;i < count;i++)
            {
                getChildAt(i).setVisibility(visibilities[i]);
            } //End block
        } //End block
Bitmap var73F89FAC8F369DF0913D10C37C1E0EA1_640024458 =         b;
        var73F89FAC8F369DF0913D10C37C1E0EA1_640024458.addTaint(taint);
        return var73F89FAC8F369DF0913D10C37C1E0EA1_640024458;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.461 -0400", hash_original_method = "B43A05A63ADF740A4A15894A451E95C0", hash_generated_method = "2F09AE7032715FB3AA000FEB3B5EB33F")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
        final int count = mChildrenCount;
        final View[] children = mChildren;
        int flags = mGroupFlags;
    if((flags & FLAG_RUN_ANIMATION) != 0 && canAnimate())        
        {
            final boolean cache = (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
            final boolean buildCache = !isHardwareAccelerated();
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE)                
                {
                    final LayoutParams params = child.getLayoutParams();
                    attachLayoutAnimationParameters(child, params, i, count);
                    bindLayoutAnimation(child);
    if(cache)                    
                    {
                        child.setDrawingCacheEnabled(true);
    if(buildCache)                        
                        {
                            child.buildDrawingCache(true);
                        } //End block
                    } //End block
                } //End block
            } //End block
            final LayoutAnimationController controller = mLayoutAnimationController;
    if(controller.willOverlap())            
            {
                mGroupFlags |= FLAG_OPTIMIZE_INVALIDATE;
            } //End block
            controller.start();
            mGroupFlags &= ~FLAG_RUN_ANIMATION;
            mGroupFlags &= ~FLAG_ANIMATION_DONE;
    if(cache)            
            {
                mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
            } //End block
    if(mAnimationListener != null)            
            {
                mAnimationListener.onAnimationStart(controller.getAnimation());
            } //End block
        } //End block
        int saveCount = 0;
        final boolean clipToPadding = (flags & CLIP_TO_PADDING_MASK) == CLIP_TO_PADDING_MASK;
    if(clipToPadding)        
        {
            saveCount = canvas.save();
            canvas.clipRect(mScrollX + mPaddingLeft, mScrollY + mPaddingTop,
                    mScrollX + mRight - mLeft - mPaddingRight,
                    mScrollY + mBottom - mTop - mPaddingBottom);
        } //End block
        mPrivateFlags &= ~DRAW_ANIMATION;
        mGroupFlags &= ~FLAG_INVALIDATE_REQUIRED;
        boolean more = false;
        final long drawingTime = getDrawingTime();
    if((flags & FLAG_USE_CHILD_DRAWING_ORDER) == 0)        
        {
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null)                
                {
                    more |= drawChild(canvas, child, drawingTime);
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = 0;i < count;i++)
            {
                final View child = children[getChildDrawingOrder(count, i)];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null)                
                {
                    more |= drawChild(canvas, child, drawingTime);
                } //End block
            } //End block
        } //End block
    if(mDisappearingChildren != null)        
        {
            final ArrayList<View> disappearingChildren = mDisappearingChildren;
            final int disappearingCount = disappearingChildren.size() - 1;
for(int i = disappearingCount;i >= 0;i--)
            {
                final View child = disappearingChildren.get(i);
                more |= drawChild(canvas, child, drawingTime);
            } //End block
        } //End block
    if(clipToPadding)        
        {
            canvas.restoreToCount(saveCount);
        } //End block
        flags = mGroupFlags;
    if((flags & FLAG_INVALIDATE_REQUIRED) == FLAG_INVALIDATE_REQUIRED)        
        {
            invalidate(true);
        } //End block
    if((flags & FLAG_ANIMATION_DONE) == 0 && (flags & FLAG_NOTIFY_ANIMATION_LISTENER) == 0 &&
                mLayoutAnimationController.isDone() && !more)        
        {
            mGroupFlags |= FLAG_NOTIFY_ANIMATION_LISTENER;
            final Runnable end = new Runnable() {
               public void run() {
                   notifyAnimationListener();
               }
            };
            post(end);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.462 -0400", hash_original_method = "314AC469B646186EB8E30D4AB123CD56", hash_generated_method = "4D1AC7BB82CDEF37027B2B458415F5FA")
    protected int getChildDrawingOrder(int childCount, int i) {
        addTaint(i);
        addTaint(childCount);
        int var865C0C0B4AB0E063E5CAA3387C1A8741_550626560 = (i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29658839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_29658839;
        // ---------- Original Method ----------
        //return i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.462 -0400", hash_original_method = "396DFE394BEDDAB737694626CE3DE3EF", hash_generated_method = "CF28FD672903EF082609ECF9A1B7A7A8")
    private void notifyAnimationListener() {
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;
    if(mAnimationListener != null)        
        {
            final Runnable end = new Runnable() {
               public void run() {
                   mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               }
           };
            post(end);
        } //End block
    if((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE)        
        {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
    if((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.463 -0400", hash_original_method = "F4EA27B0452D996E61B8467125C95A50", hash_generated_method = "20EBD4F390102F77221050EE7FD65AFB")
    @Override
    protected void dispatchGetDisplayList() {
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            final View child = children[i];
    if(((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    child.hasStaticLayer())            
            {
                child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                child.mPrivateFlags &= ~INVALIDATED;
                child.getDisplayList();
                child.mRecreateDisplayList = false;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.467 -0400", hash_original_method = "A5CF70DDE358EAA9D1CA892FF372BD55", hash_generated_method = "5AFE404B775CCE8513AE422637365A14")
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        addTaint(drawingTime);
        addTaint(child.getTaint());
        addTaint(canvas.getTaint());
        boolean more = false;
        final int cl = child.mLeft;
        final int ct = child.mTop;
        final int cr = child.mRight;
        final int cb = child.mBottom;
        final boolean childHasIdentityMatrix = child.hasIdentityMatrix();
        final int flags = mGroupFlags;
    if((flags & FLAG_CLEAR_TRANSFORMATION) == FLAG_CLEAR_TRANSFORMATION)        
        {
            mChildTransformation.clear();
            mGroupFlags &= ~FLAG_CLEAR_TRANSFORMATION;
        } //End block
        Transformation transformToApply = null;
        Transformation invalidationTransform;
        final Animation a = child.getAnimation();
        boolean concatMatrix = false;
        boolean scalingRequired = false;
        boolean caching;
        int layerType = mDrawLayers ? child.getLayerType() : LAYER_TYPE_NONE;
        final boolean hardwareAccelerated = canvas.isHardwareAccelerated();
    if((flags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE ||
                (flags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE)        
        {
            caching = true;
    if(mAttachInfo != null)            
            scalingRequired = mAttachInfo.mScalingRequired;
        } //End block
        else
        {
            caching = (layerType != LAYER_TYPE_NONE) || hardwareAccelerated;
        } //End block
    if(a != null)        
        {
            final boolean initialized = a.isInitialized();
    if(!initialized)            
            {
                a.initialize(cr - cl, cb - ct, getWidth(), getHeight());
                a.initializeInvalidateRegion(0, 0, cr - cl, cb - ct);
                child.onAnimationStart();
            } //End block
            more = a.getTransformation(drawingTime, mChildTransformation,
                    scalingRequired ? mAttachInfo.mApplicationScale : 1f);
    if(scalingRequired && mAttachInfo.mApplicationScale != 1f)            
            {
    if(mInvalidationTransformation == null)                
                {
                    mInvalidationTransformation = new Transformation();
                } //End block
                invalidationTransform = mInvalidationTransformation;
                a.getTransformation(drawingTime, invalidationTransform, 1f);
            } //End block
            else
            {
                invalidationTransform = mChildTransformation;
            } //End block
            transformToApply = mChildTransformation;
            concatMatrix = a.willChangeTransformationMatrix();
    if(more)            
            {
    if(!a.willChangeBounds())                
                {
    if((flags & (FLAG_OPTIMIZE_INVALIDATE | FLAG_ANIMATION_DONE)) ==
                            FLAG_OPTIMIZE_INVALIDATE)                    
                    {
                        mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
                    } //End block
                    else
    if((flags & FLAG_INVALIDATE_REQUIRED) == 0)                    
                    {
                        mPrivateFlags |= DRAW_ANIMATION;
                        invalidate(cl, ct, cr, cb);
                    } //End block
                } //End block
                else
                {
    if(mInvalidateRegion == null)                    
                    {
                        mInvalidateRegion = new RectF();
                    } //End block
                    final RectF region = mInvalidateRegion;
                    a.getInvalidateRegion(0, 0, cr - cl, cb - ct, region, invalidationTransform);
                    mPrivateFlags |= DRAW_ANIMATION;
                    final int left = cl + (int) region.left;
                    final int top = ct + (int) region.top;
                    invalidate(left, top, left + (int) (region.width() + .5f),
                            top + (int) (region.height() + .5f));
                } //End block
            } //End block
        } //End block
        else
    if((flags & FLAG_SUPPORT_STATIC_TRANSFORMATIONS) ==
                FLAG_SUPPORT_STATIC_TRANSFORMATIONS)        
        {
            final boolean hasTransform = getChildStaticTransformation(child, mChildTransformation);
    if(hasTransform)            
            {
                final int transformType = mChildTransformation.getTransformationType();
                transformToApply = transformType != Transformation.TYPE_IDENTITY ?
                        mChildTransformation : null;
                concatMatrix = (transformType & Transformation.TYPE_MATRIX) != 0;
            } //End block
        } //End block
        concatMatrix |= !childHasIdentityMatrix;
        child.mPrivateFlags |= DRAWN;
    if(!concatMatrix && canvas.quickReject(cl, ct, cr, cb, Canvas.EdgeType.BW) &&
                (child.mPrivateFlags & DRAW_ANIMATION) == 0)        
        {
            boolean varADDEC426932E71323700AFA1911F8F1C_190849878 = (more);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795908875 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_795908875;
        } //End block
    if(hardwareAccelerated)        
        {
            child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
            child.mPrivateFlags &= ~INVALIDATED;
        } //End block
        child.computeScroll();
        final int sx = child.mScrollX;
        final int sy = child.mScrollY;
        DisplayList displayList = null;
        Bitmap cache = null;
        boolean hasDisplayList = false;
    if(caching)        
        {
    if(!hardwareAccelerated)            
            {
    if(layerType != LAYER_TYPE_NONE)                
                {
                    layerType = LAYER_TYPE_SOFTWARE;
                    child.buildDrawingCache(true);
                } //End block
                cache = child.getDrawingCache(true);
            } //End block
            else
            {
switch(layerType){
                case LAYER_TYPE_SOFTWARE:
                child.buildDrawingCache(true);
                cache = child.getDrawingCache(true);
                break;
                case LAYER_TYPE_NONE:
                hasDisplayList = child.canHaveDisplayList();
                break;
}
            } //End block
        } //End block
        final boolean hasNoCache = cache == null || hasDisplayList;
        final boolean offsetForScroll = cache == null && !hasDisplayList &&
                layerType != LAYER_TYPE_HARDWARE;
        final int restoreTo = canvas.save();
    if(offsetForScroll)        
        {
            canvas.translate(cl - sx, ct - sy);
        } //End block
        else
        {
            canvas.translate(cl, ct);
    if(scalingRequired)            
            {
                final float scale = 1.0f / mAttachInfo.mApplicationScale;
                canvas.scale(scale, scale);
            } //End block
        } //End block
        float alpha = child.getAlpha();
    if(transformToApply != null || alpha < 1.0f || !child.hasIdentityMatrix())        
        {
    if(transformToApply != null || !childHasIdentityMatrix)            
            {
                int transX = 0;
                int transY = 0;
    if(offsetForScroll)                
                {
                    transX = -sx;
                    transY = -sy;
                } //End block
    if(transformToApply != null)                
                {
    if(concatMatrix)                    
                    {
                        canvas.translate(-transX, -transY);
                        canvas.concat(transformToApply.getMatrix());
                        canvas.translate(transX, transY);
                        mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                    } //End block
                    float transformAlpha = transformToApply.getAlpha();
    if(transformAlpha < 1.0f)                    
                    {
                        alpha *= transformToApply.getAlpha();
                        mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
                    } //End block
                } //End block
    if(!childHasIdentityMatrix)                
                {
                    canvas.translate(-transX, -transY);
                    canvas.concat(child.getMatrix());
                    canvas.translate(transX, transY);
                } //End block
            } //End block
    if(alpha < 1.0f)            
            {
                mGroupFlags |= FLAG_CLEAR_TRANSFORMATION;
    if(hasNoCache)                
                {
                    final int multipliedAlpha = (int) (255 * alpha);
    if(!child.onSetAlpha(multipliedAlpha))                    
                    {
                        int layerFlags = Canvas.HAS_ALPHA_LAYER_SAVE_FLAG;
    if((flags & FLAG_CLIP_CHILDREN) == FLAG_CLIP_CHILDREN ||
                                layerType != LAYER_TYPE_NONE)                        
                        {
                            layerFlags |= Canvas.CLIP_TO_LAYER_SAVE_FLAG;
                        } //End block
    if(layerType == LAYER_TYPE_NONE)                        
                        {
                            final int scrollX = hasDisplayList ? 0 : sx;
                            final int scrollY = hasDisplayList ? 0 : sy;
                            canvas.saveLayerAlpha(scrollX, scrollY, scrollX + cr - cl,
                                    scrollY + cb - ct, multipliedAlpha, layerFlags);
                        } //End block
                    } //End block
                    else
                    {
                        child.mPrivateFlags |= ALPHA_SET;
                    } //End block
                } //End block
            } //End block
        } //End block
        else
    if((child.mPrivateFlags & ALPHA_SET) == ALPHA_SET)        
        {
            child.onSetAlpha(255);
            child.mPrivateFlags &= ~ALPHA_SET;
        } //End block
    if((flags & FLAG_CLIP_CHILDREN) == FLAG_CLIP_CHILDREN)        
        {
    if(offsetForScroll)            
            {
                canvas.clipRect(sx, sy, sx + (cr - cl), sy + (cb - ct));
            } //End block
            else
            {
    if(!scalingRequired || cache == null)                
                {
                    canvas.clipRect(0, 0, cr - cl, cb - ct);
                } //End block
                else
                {
                    canvas.clipRect(0, 0, cache.getWidth(), cache.getHeight());
                } //End block
            } //End block
        } //End block
    if(hasDisplayList)        
        {
            displayList = child.getDisplayList();
    if(!displayList.isValid())            
            {
                displayList = null;
                hasDisplayList = false;
            } //End block
        } //End block
    if(hasNoCache)        
        {
            boolean layerRendered = false;
    if(layerType == LAYER_TYPE_HARDWARE)            
            {
                final HardwareLayer layer = child.getHardwareLayer();
    if(layer != null && layer.isValid())                
                {
                    child.mLayerPaint.setAlpha((int) (alpha * 255));
                    ((HardwareCanvas) canvas).drawHardwareLayer(layer, 0, 0, child.mLayerPaint);
                    layerRendered = true;
                } //End block
                else
                {
                    final int scrollX = hasDisplayList ? 0 : sx;
                    final int scrollY = hasDisplayList ? 0 : sy;
                    canvas.saveLayer(scrollX, scrollY,
                            scrollX + cr - cl, scrollY + cb - ct, child.mLayerPaint,
                            Canvas.HAS_ALPHA_LAYER_SAVE_FLAG | Canvas.CLIP_TO_LAYER_SAVE_FLAG);
                } //End block
            } //End block
    if(!layerRendered)            
            {
    if(!hasDisplayList)                
                {
    if((child.mPrivateFlags & SKIP_DRAW) == SKIP_DRAW)                    
                    {
    if(ViewDebug.TRACE_HIERARCHY)                        
                        {
                            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.DRAW);
                        } //End block
                        child.mPrivateFlags &= ~DIRTY_MASK;
                        child.dispatchDraw(canvas);
                    } //End block
                    else
                    {
                        child.draw(canvas);
                    } //End block
                } //End block
                else
                {
                    child.mPrivateFlags &= ~DIRTY_MASK;
                    ((HardwareCanvas) canvas).drawDisplayList(displayList, cr - cl, cb - ct, null);
                } //End block
            } //End block
        } //End block
        else
    if(cache != null)        
        {
            child.mPrivateFlags &= ~DIRTY_MASK;
            Paint cachePaint;
    if(layerType == LAYER_TYPE_NONE)            
            {
                cachePaint = mCachePaint;
    if(cachePaint == null)                
                {
                    cachePaint = new Paint();
                    cachePaint.setDither(false);
                    mCachePaint = cachePaint;
                } //End block
    if(alpha < 1.0f)                
                {
                    cachePaint.setAlpha((int) (alpha * 255));
                    mGroupFlags |= FLAG_ALPHA_LOWER_THAN_ONE;
                } //End block
                else
    if((flags & FLAG_ALPHA_LOWER_THAN_ONE) == FLAG_ALPHA_LOWER_THAN_ONE)                
                {
                    cachePaint.setAlpha(255);
                    mGroupFlags &= ~FLAG_ALPHA_LOWER_THAN_ONE;
                } //End block
            } //End block
            else
            {
                cachePaint = child.mLayerPaint;
                cachePaint.setAlpha((int) (alpha * 255));
            } //End block
            canvas.drawBitmap(cache, 0.0f, 0.0f, cachePaint);
        } //End block
        canvas.restoreToCount(restoreTo);
    if(a != null && !more)        
        {
    if(!hardwareAccelerated && !a.getFillAfter())            
            {
                child.onSetAlpha(255);
            } //End block
            finishAnimatingView(child, a);
        } //End block
    if(more && hardwareAccelerated)        
        {
            invalidate(true);
    if(a.hasAlpha() && (child.mPrivateFlags & ALPHA_SET) == ALPHA_SET)            
            {
                child.invalidate(true);
            } //End block
        } //End block
        child.mRecreateDisplayList = false;
        boolean varADDEC426932E71323700AFA1911F8F1C_1446286467 = (more);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489993297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_489993297;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.470 -0400", hash_original_method = "4095F0AE1BAE27A3A14B16FD7C3431AE", hash_generated_method = "3D450997941A142906D63FBF91271C8A")
    public void setChildrenLayersEnabled(boolean enabled) {
    if(enabled != mDrawLayers)        
        {
            mDrawLayers = enabled;
            invalidate(true);
for(int i = 0;i < mChildrenCount;i++)
            {
                View child = mChildren[i];
    if(child.mLayerType != LAYER_TYPE_NONE)                
                {
                    child.invalidate(true);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.472 -0400", hash_original_method = "1DB85DBA1331DEE146504B0E70B65BE5", hash_generated_method = "BF80C83659F52B39E6567F755FA45B69")
    public void setClipChildren(boolean clipChildren) {
        addTaint(clipChildren);
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.473 -0400", hash_original_method = "863AF54978AA2727D0D7509C22DC212D", hash_generated_method = "B533A9EF1AF362220AD494012A43E237")
    public void setClipToPadding(boolean clipToPadding) {
        addTaint(clipToPadding);
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.473 -0400", hash_original_method = "8ABEEBF76C5626CBEA0073E7871E08E9", hash_generated_method = "FA1EEB305F2B58C5E3547352F5D96530")
    @Override
    public void dispatchSetSelected(boolean selected) {
        addTaint(selected);
        final View[] children = mChildren;
        final int count = mChildrenCount;
for(int i = 0;i < count;i++)
        {
            children[i].setSelected(selected);
        } //End block
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setSelected(selected);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.474 -0400", hash_original_method = "2F91B8D19CDC8A9E83F3387815EB4D3F", hash_generated_method = "3104F0B7F5F2E3A1927C7E598C486538")
    @Override
    public void dispatchSetActivated(boolean activated) {
        addTaint(activated);
        final View[] children = mChildren;
        final int count = mChildrenCount;
for(int i = 0;i < count;i++)
        {
            children[i].setActivated(activated);
        } //End block
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setActivated(activated);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.474 -0400", hash_original_method = "741F0E8D45382BBF6BA56C96532A94D8", hash_generated_method = "6334179A2A744F78110551C2407DD00D")
    @Override
    protected void dispatchSetPressed(boolean pressed) {
        addTaint(pressed);
        final View[] children = mChildren;
        final int count = mChildrenCount;
for(int i = 0;i < count;i++)
        {
            children[i].setPressed(pressed);
        } //End block
        // ---------- Original Method ----------
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].setPressed(pressed);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.474 -0400", hash_original_method = "BD73AAD871B8740D29315EE305D10F4B", hash_generated_method = "B69CF6F68E52D80B87CD5D6F08B2855F")
    protected void setStaticTransformationsEnabled(boolean enabled) {
        addTaint(enabled);
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.475 -0400", hash_original_method = "767004ADA8C3853AF520B9D176A534BE", hash_generated_method = "3DB0F39193F29D765F568978225173B7")
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        addTaint(t.getTaint());
        addTaint(child.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_801845671 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2062593992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2062593992;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.476 -0400", hash_original_method = "8C56D4BEA5FE426CA6EBD73A64039E70", hash_generated_method = "433622F57588BEDE57A1BD8354BACD7F")
    @Override
    protected View findViewTraversal(int id) {
        addTaint(id);
    if(id == mID)        
        {
View var72A74007B2BE62B849F475C7BDA4658B_1004633405 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1004633405.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1004633405;
        } //End block
        final View[] where = mChildren;
        final int len = mChildrenCount;
for(int i = 0;i < len;i++)
        {
            View v = where[i];
    if((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0)            
            {
                v = v.findViewById(id);
    if(v != null)                
                {
View var6DC76BC51820DD65E8396280E884AA78_505705960 =                     v;
                    var6DC76BC51820DD65E8396280E884AA78_505705960.addTaint(taint);
                    return var6DC76BC51820DD65E8396280E884AA78_505705960;
                } //End block
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_770520380 =         null;
        var540C13E9E156B687226421B24F2DF178_770520380.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_770520380;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.476 -0400", hash_original_method = "D087F3465F923453754E64A11DB6BED1", hash_generated_method = "CE048034327AFC52E37378DD47DFE492")
    @Override
    protected View findViewWithTagTraversal(Object tag) {
        addTaint(tag.getTaint());
    if(tag != null && tag.equals(mTag))        
        {
View var72A74007B2BE62B849F475C7BDA4658B_2145167030 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2145167030.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2145167030;
        } //End block
        final View[] where = mChildren;
        final int len = mChildrenCount;
for(int i = 0;i < len;i++)
        {
            View v = where[i];
    if((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0)            
            {
                v = v.findViewWithTag(tag);
    if(v != null)                
                {
View var6DC76BC51820DD65E8396280E884AA78_29060201 =                     v;
                    var6DC76BC51820DD65E8396280E884AA78_29060201.addTaint(taint);
                    return var6DC76BC51820DD65E8396280E884AA78_29060201;
                } //End block
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_848845341 =         null;
        var540C13E9E156B687226421B24F2DF178_848845341.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_848845341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.476 -0400", hash_original_method = "0EC5116F4AD2AA9CFA72F9149C3A9529", hash_generated_method = "675CE06882230B553B308B0F2E344B73")
    @Override
    protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip) {
        addTaint(childToSkip.getTaint());
        addTaint(predicate.getTaint());
    if(predicate.apply(this))        
        {
View var72A74007B2BE62B849F475C7BDA4658B_612195911 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_612195911.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_612195911;
        } //End block
        final View[] where = mChildren;
        final int len = mChildrenCount;
for(int i = 0;i < len;i++)
        {
            View v = where[i];
    if(v != childToSkip && (v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0)            
            {
                v = v.findViewByPredicate(predicate);
    if(v != null)                
                {
View var6DC76BC51820DD65E8396280E884AA78_341063386 =                     v;
                    var6DC76BC51820DD65E8396280E884AA78_341063386.addTaint(taint);
                    return var6DC76BC51820DD65E8396280E884AA78_341063386;
                } //End block
            } //End block
        } //End block
View var540C13E9E156B687226421B24F2DF178_1991977945 =         null;
        var540C13E9E156B687226421B24F2DF178_1991977945.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1991977945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.476 -0400", hash_original_method = "CEC5DF3412108DC355B81A234F778717", hash_generated_method = "9557E906CBAC2A36454E636B95E6F9A1")
    public void addView(View child) {
        addTaint(child.getTaint());
        addView(child, -1);
        // ---------- Original Method ----------
        //addView(child, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.477 -0400", hash_original_method = "052049806EFDCB28F8B1780970FB4D61", hash_generated_method = "04377095328BC967EA07D36E6681C349")
    public void addView(View child, int index) {
        addTaint(index);
        addTaint(child.getTaint());
        LayoutParams params = child.getLayoutParams();
    if(params == null)        
        {
            params = generateDefaultLayoutParams();
    if(params == null)            
            {
                IllegalArgumentException varC986FBA31949518009336B3DE110AC27_2634192 = new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
                varC986FBA31949518009336B3DE110AC27_2634192.addTaint(taint);
                throw varC986FBA31949518009336B3DE110AC27_2634192;
            } //End block
        } //End block
        addView(child, index, params);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.477 -0400", hash_original_method = "04069655751E8F150919B197DB2D0EF4", hash_generated_method = "2A6DD4DE37CD2F6E25BAD69E541CAACB")
    public void addView(View child, int width, int height) {
        addTaint(height);
        addTaint(width);
        addTaint(child.getTaint());
        final LayoutParams params = generateDefaultLayoutParams();
        params.width = width;
        params.height = height;
        addView(child, -1, params);
        // ---------- Original Method ----------
        //final LayoutParams params = generateDefaultLayoutParams();
        //params.width = width;
        //params.height = height;
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.478 -0400", hash_original_method = "CAABD1DBDF747222034CC373BA6381CC", hash_generated_method = "606592A6D2B03B0011BC5E780FC5D9D2")
    public void addView(View child, LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        addView(child, -1, params);
        // ---------- Original Method ----------
        //addView(child, -1, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.478 -0400", hash_original_method = "BD78A36687CEEF62B7E0786E86501A2F", hash_generated_method = "20660A8C77CACC2F90222AADF54C9342")
    public void addView(View child, int index, LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
    if(DBG)        
        {
            System.out.println(this + " addView");
        } //End block
        requestLayout();
        invalidate(true);
        addViewInner(child, index, params, false);
        // ---------- Original Method ----------
        //if (DBG) {
            //System.out.println(this + " addView");
        //}
        //requestLayout();
        //invalidate(true);
        //addViewInner(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.478 -0400", hash_original_method = "8137D76BAD6EAD8C2AFF7B0DC7EC38EA", hash_generated_method = "639AE46E6EA04BFA4A59ED0AFC21D615")
    public void updateViewLayout(View view, ViewGroup.LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(view.getTaint());
    if(!checkLayoutParams(params))        
        {
            IllegalArgumentException varFE35611D48A20AFF08E77DA77512451F_935697306 = new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
            varFE35611D48A20AFF08E77DA77512451F_935697306.addTaint(taint);
            throw varFE35611D48A20AFF08E77DA77512451F_935697306;
        } //End block
    if(view.mParent != this)        
        {
            IllegalArgumentException var862EA8241E17B1317F48A84AF1A073A6_1216327476 = new IllegalArgumentException("Given view not a child of " + this);
            var862EA8241E17B1317F48A84AF1A073A6_1216327476.addTaint(taint);
            throw var862EA8241E17B1317F48A84AF1A073A6_1216327476;
        } //End block
        view.setLayoutParams(params);
        // ---------- Original Method ----------
        //if (!checkLayoutParams(params)) {
            //throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
        //}
        //if (view.mParent != this) {
            //throw new IllegalArgumentException("Given view not a child of " + this);
        //}
        //view.setLayoutParams(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.478 -0400", hash_original_method = "C2EE5015ED0F9B04763A6A0F4C905EDB", hash_generated_method = "0F56FC00BD6D4F0CF1CE244F50E949DE")
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
        boolean var1E5F1565E1078D66EAA4E10A30FB47AF_1942639607 = (p != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796466953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796466953;
        // ---------- Original Method ----------
        //return  p != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.479 -0400", hash_original_method = "2EFEB52353D2008493D1621282A03886", hash_generated_method = "7C3C20C1075C2C96B31EA398AE09593A")
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        mOnHierarchyChangeListener = listener;
        // ---------- Original Method ----------
        //mOnHierarchyChangeListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.479 -0400", hash_original_method = "7C8375F0DCFCC6770307465540C43F29", hash_generated_method = "988F1B5E9B349B10714473F7CB4F6087")
    protected void onViewAdded(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(child.getTaint());
    if(mOnHierarchyChangeListener != null)        
        {
            mOnHierarchyChangeListener.onChildViewAdded(this, child);
        } //End block
        // ---------- Original Method ----------
        //if (mOnHierarchyChangeListener != null) {
            //mOnHierarchyChangeListener.onChildViewAdded(this, child);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.479 -0400", hash_original_method = "2969A02DF6E73517C4A5610098A20201", hash_generated_method = "19C1E9CD1D46F5A30D9C434B5F3196ED")
    protected void onViewRemoved(View child) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(child.getTaint());
    if(mOnHierarchyChangeListener != null)        
        {
            mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        } //End block
        // ---------- Original Method ----------
        //if (mOnHierarchyChangeListener != null) {
            //mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.479 -0400", hash_original_method = "4EC56F492B64387EC5CDEE559C919DD8", hash_generated_method = "C6E477E0060DFE2C6B976B67AC012BD3")
    protected boolean addViewInLayout(View child, int index, LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        boolean varD12C22798F7F0037110E10C4AEC4EDDC_1324608677 = (addViewInLayout(child, index, params, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204117878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204117878;
        // ---------- Original Method ----------
        //return addViewInLayout(child, index, params, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.479 -0400", hash_original_method = "621D5EA894CECBBA3C5FE5D7159CF1D3", hash_generated_method = "467370305AE525359A441B0ED61CD586")
    protected boolean addViewInLayout(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        addTaint(preventRequestLayout);
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        child.mParent = null;
        addViewInner(child, index, params, preventRequestLayout);
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        boolean varB326B5062B2F0E69046810717534CB09_131659229 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861003126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_861003126;
        // ---------- Original Method ----------
        //child.mParent = null;
        //addViewInner(child, index, params, preventRequestLayout);
        //child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.480 -0400", hash_original_method = "156A75B155CF89ADA3C99A75E911D53A", hash_generated_method = "A250998716A3206F2291C31B0B214D0D")
    protected void cleanupLayoutState(View child) {
        addTaint(child.getTaint());
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
        // ---------- Original Method ----------
        //child.mPrivateFlags &= ~View.FORCE_LAYOUT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.481 -0400", hash_original_method = "4623983FE5D2926EED9F934007E41D76", hash_generated_method = "7998EF04BB3C114ED4C9E3A4404BED8E")
    private void addViewInner(View child, int index, LayoutParams params,
            boolean preventRequestLayout) {
        addTaint(preventRequestLayout);
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
    if(mTransition != null)        
        {
            mTransition.cancel(LayoutTransition.DISAPPEARING);
        } //End block
    if(child.getParent() != null)        
        {
            IllegalStateException var39C9655FD829B33D080F9E2B96D69795_641395954 = new IllegalStateException("The specified child already has a parent. " +
                    "You must call removeView() on the child's parent first.");
            var39C9655FD829B33D080F9E2B96D69795_641395954.addTaint(taint);
            throw var39C9655FD829B33D080F9E2B96D69795_641395954;
        } //End block
    if(mTransition != null)        
        {
            mTransition.addChild(this, child);
        } //End block
    if(!checkLayoutParams(params))        
        {
            params = generateLayoutParams(params);
        } //End block
    if(preventRequestLayout)        
        {
            child.mLayoutParams = params;
        } //End block
        else
        {
            child.setLayoutParams(params);
        } //End block
    if(index < 0)        
        {
            index = mChildrenCount;
        } //End block
        addInArray(child, index);
    if(preventRequestLayout)        
        {
            child.assignParent(this);
        } //End block
        else
        {
            child.mParent = this;
        } //End block
    if(child.hasFocus())        
        {
            requestChildFocus(child, child.findFocus());
        } //End block
        AttachInfo ai = mAttachInfo;
    if(ai != null && (mGroupFlags & FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW) == 0)        
        {
            boolean lastKeepOn = ai.mKeepScreenOn;
            ai.mKeepScreenOn = false;
            child.dispatchAttachedToWindow(mAttachInfo, (mViewFlags&VISIBILITY_MASK));
    if(ai.mKeepScreenOn)            
            {
                needGlobalAttributesUpdate(true);
            } //End block
            ai.mKeepScreenOn = lastKeepOn;
        } //End block
        onViewAdded(child);
    if((child.mViewFlags & DUPLICATE_PARENT_STATE) == DUPLICATE_PARENT_STATE)        
        {
            mGroupFlags |= FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.483 -0400", hash_original_method = "3DC226B361362F1A66E4DF7340FD46AC", hash_generated_method = "ECEB3C2248B12F9101990FBB4EBC777B")
    private void addInArray(View child, int index) {
        addTaint(index);
        View[] children = mChildren;
        final int count = mChildrenCount;
        final int size = children.length;
    if(index == count)        
        {
    if(size == count)            
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, size);
                children = mChildren;
            } //End block
            children[mChildrenCount++] = child;
        } //End block
        else
    if(index < count)        
        {
    if(size == count)            
            {
                mChildren = new View[size + ARRAY_CAPACITY_INCREMENT];
                System.arraycopy(children, 0, mChildren, 0, index);
                System.arraycopy(children, index, mChildren, index + 1, count - index);
                children = mChildren;
            } //End block
            else
            {
                System.arraycopy(children, index, children, index + 1, count - index);
            } //End block
            children[index] = child;
            mChildrenCount++;
    if(mLastTouchDownIndex >= index)            
            {
                mLastTouchDownIndex++;
            } //End block
        } //End block
        else
        {
            IndexOutOfBoundsException varA2DB98543D9852DA596036448F470221_1930210441 = new IndexOutOfBoundsException("index=" + index + " count=" + count);
            varA2DB98543D9852DA596036448F470221_1930210441.addTaint(taint);
            throw varA2DB98543D9852DA596036448F470221_1930210441;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.484 -0400", hash_original_method = "666B846103F98929B6C3984DF363A458", hash_generated_method = "5CE656C84FB27571D6642E1E156DB324")
    private void removeFromArray(int index) {
        addTaint(index);
        final View[] children = mChildren;
    if(!(mTransitioningViews != null && mTransitioningViews.contains(children[index])))        
        {
            children[index].mParent = null;
        } //End block
        final int count = mChildrenCount;
    if(index == count - 1)        
        {
            children[--mChildrenCount] = null;
        } //End block
        else
    if(index >= 0 && index < count)        
        {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } //End block
        else
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1464879852 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1464879852.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1464879852;
        } //End block
    if(mLastTouchDownIndex == index)        
        {
            mLastTouchDownTime = 0;
            mLastTouchDownIndex = -1;
        } //End block
        else
    if(mLastTouchDownIndex > index)        
        {
            mLastTouchDownIndex--;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.486 -0400", hash_original_method = "7377DC4CCC7ACF33951FFC91A9C19242", hash_generated_method = "8D9B289038EB9623C68B07BEFB36C7A9")
    private void removeFromArray(int start, int count) {
        addTaint(count);
        final View[] children = mChildren;
        final int childrenCount = mChildrenCount;
        start = Math.max(0, start);
        final int end = Math.min(childrenCount, start + count);
    if(start == end)        
        {
            return;
        } //End block
    if(end == childrenCount)        
        {
for(int i = start;i < end;i++)
            {
                children[i].mParent = null;
                children[i] = null;
            } //End block
        } //End block
        else
        {
for(int i = start;i < end;i++)
            {
                children[i].mParent = null;
            } //End block
            System.arraycopy(children, end, children, start, childrenCount - end);
for(int i = childrenCount - (end - start);i < childrenCount;i++)
            {
                children[i] = null;
            } //End block
        } //End block
        mChildrenCount -= (end - start);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.486 -0400", hash_original_method = "0C13B6720EDD2CD731BF86C88080EC0A", hash_generated_method = "665118E7043C4768E9C53E2B8A5A99C5")
    private void bindLayoutAnimation(View child) {
        addTaint(child.getTaint());
        Animation a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
        // ---------- Original Method ----------
        //Animation a = mLayoutAnimationController.getAnimationForView(child);
        //child.setAnimation(a);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.488 -0400", hash_original_method = "53A696BC845D59D084861C4C39417C50", hash_generated_method = "CA91F5116142FEBA33A25820204A0B26")
    protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count) {
        addTaint(count);
        addTaint(index);
        addTaint(params.getTaint());
        addTaint(child.getTaint());
        LayoutAnimationController.AnimationParameters animationParams = params.layoutAnimationParameters;
    if(animationParams == null)        
        {
            animationParams = new LayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        } //End block
        animationParams.count = count;
        animationParams.index = index;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.488 -0400", hash_original_method = "D47B7EA927C9C6E9F8463F22FA8E7751", hash_generated_method = "983A525A202F6E617A6AB378BDE0712F")
    public void removeView(View view) {
        addTaint(view.getTaint());
        removeViewInternal(view);
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeViewInternal(view);
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.488 -0400", hash_original_method = "9C0189C4A93DBFF4CA9135E979534627", hash_generated_method = "51BD2F0E93657733C5EBCC303A3B0B1D")
    public void removeViewInLayout(View view) {
        addTaint(view.getTaint());
        removeViewInternal(view);
        // ---------- Original Method ----------
        //removeViewInternal(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.488 -0400", hash_original_method = "CCED8E1F5C1435811C77FC8E195AA3ED", hash_generated_method = "A0E9A4C949A3BB47296905BCCB748750")
    public void removeViewsInLayout(int start, int count) {
        addTaint(count);
        addTaint(start);
        removeViewsInternal(start, count);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.488 -0400", hash_original_method = "C7B982345E14E4BA654D9B702D09B782", hash_generated_method = "07094032482A6B1C123263F5972C0F67")
    public void removeViewAt(int index) {
        addTaint(index);
        removeViewInternal(index, getChildAt(index));
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeViewInternal(index, getChildAt(index));
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.488 -0400", hash_original_method = "295E3CFFAAE54DAD76DF23980004A9FB", hash_generated_method = "48B292F84875CA858D0781E2E2794B6E")
    public void removeViews(int start, int count) {
        addTaint(count);
        addTaint(start);
        removeViewsInternal(start, count);
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeViewsInternal(start, count);
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.489 -0400", hash_original_method = "A8C7AA662547BF9F482FBD0CAAADED6D", hash_generated_method = "8B62BDA1A4DD615CCF8EFE5571E73CCB")
    private void removeViewInternal(View view) {
        addTaint(view.getTaint());
        final int index = indexOfChild(view);
    if(index >= 0)        
        {
            removeViewInternal(index, view);
        } //End block
        // ---------- Original Method ----------
        //final int index = indexOfChild(view);
        //if (index >= 0) {
            //removeViewInternal(index, view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.489 -0400", hash_original_method = "5145400D128FAA852B030ECA7E0E5CC6", hash_generated_method = "31EE19B56D7DA5DECCFD3202AC94C1BF")
    private void removeViewInternal(int index, View view) {
        addTaint(view.getTaint());
        addTaint(index);
    if(mTransition != null)        
        {
            mTransition.removeChild(this, view);
        } //End block
        boolean clearChildFocus = false;
    if(view == mFocused)        
        {
            view.clearFocusForRemoval();
            clearChildFocus = true;
        } //End block
    if(view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)))        
        {
            addDisappearingView(view);
        } //End block
        else
    if(view.mAttachInfo != null)        
        {
            view.dispatchDetachedFromWindow();
        } //End block
        onViewRemoved(view);
        needGlobalAttributesUpdate(false);
        removeFromArray(index);
    if(clearChildFocus)        
        {
            clearChildFocus(view);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.489 -0400", hash_original_method = "6CC26F3EB4840902E7233D2C3E46A07B", hash_generated_method = "389784AD796CB19D21493234AEF08106")
    public void setLayoutTransition(LayoutTransition transition) {
    if(mTransition != null)        
        {
            mTransition.removeTransitionListener(mLayoutTransitionListener);
        } //End block
        mTransition = transition;
    if(mTransition != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.490 -0400", hash_original_method = "33E35321C94CA74A9D9819C2C9739D2F", hash_generated_method = "C4C4BE48DFDEAB6DD878FAA82D39F25F")
    public LayoutTransition getLayoutTransition() {
LayoutTransition var370C76BDB0B670397042ABD46E153355_766315969 =         mTransition;
        var370C76BDB0B670397042ABD46E153355_766315969.addTaint(taint);
        return var370C76BDB0B670397042ABD46E153355_766315969;
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.490 -0400", hash_original_method = "F40E247B6ABF822EB65FF56F80411035", hash_generated_method = "778B63C59FC48B6CB637DB9388DF7DC9")
    private void removeViewsInternal(int start, int count) {
        addTaint(count);
        addTaint(start);
        final View focused = mFocused;
        final boolean detach = mAttachInfo != null;
        View clearChildFocus = null;
        final View[] children = mChildren;
        final int end = start + count;
for(int i = start;i < end;i++)
        {
            final View view = children[i];
    if(mTransition != null)            
            {
                mTransition.removeChild(this, view);
            } //End block
    if(view == focused)            
            {
                view.clearFocusForRemoval();
                clearChildFocus = view;
            } //End block
    if(view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view)))            
            {
                addDisappearingView(view);
            } //End block
            else
    if(detach)            
            {
                view.dispatchDetachedFromWindow();
            } //End block
            needGlobalAttributesUpdate(false);
            onViewRemoved(view);
        } //End block
        removeFromArray(start, count);
    if(clearChildFocus != null)        
        {
            clearChildFocus(clearChildFocus);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.492 -0400", hash_original_method = "C167CC912DB398153B3FBDE6D6503FBD", hash_generated_method = "251074A9D0FEFE564BF870888680CE2E")
    public void removeAllViews() {
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
        // ---------- Original Method ----------
        //removeAllViewsInLayout();
        //requestLayout();
        //invalidate(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.492 -0400", hash_original_method = "8DFE71C1BEB57BA28106B31D5772632E", hash_generated_method = "DC331EFA6EB209FA38EDD49DE1DE68E5")
    public void removeAllViewsInLayout() {
        final int count = mChildrenCount;
    if(count <= 0)        
        {
            return;
        } //End block
        final View[] children = mChildren;
        mChildrenCount = 0;
        final View focused = mFocused;
        final boolean detach = mAttachInfo != null;
        View clearChildFocus = null;
        needGlobalAttributesUpdate(false);
for(int i = count - 1;i >= 0;i--)
        {
            final View view = children[i];
    if(mTransition != null)            
            {
                mTransition.removeChild(this, view);
            } //End block
    if(view == focused)            
            {
                view.clearFocusForRemoval();
                clearChildFocus = view;
            } //End block
    if(view.getAnimation() != null ||
                    (mTransitioningViews != null && mTransitioningViews.contains(view)))            
            {
                addDisappearingView(view);
            } //End block
            else
    if(detach)            
            {
                view.dispatchDetachedFromWindow();
            } //End block
            onViewRemoved(view);
            view.mParent = null;
            children[i] = null;
        } //End block
    if(clearChildFocus != null)        
        {
            clearChildFocus(clearChildFocus);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.492 -0400", hash_original_method = "80D629C332B0E93DD7A33AD3708E672D", hash_generated_method = "808AC351FF24BC6E0C1E5FEDF12B1193")
    protected void removeDetachedView(View child, boolean animate) {
        addTaint(animate);
        addTaint(child.getTaint());
    if(mTransition != null)        
        {
            mTransition.removeChild(this, child);
        } //End block
    if(child == mFocused)        
        {
            child.clearFocus();
        } //End block
    if((animate && child.getAnimation() != null) ||
                (mTransitioningViews != null && mTransitioningViews.contains(child)))        
        {
            addDisappearingView(child);
        } //End block
        else
    if(child.mAttachInfo != null)        
        {
            child.dispatchDetachedFromWindow();
        } //End block
        onViewRemoved(child);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.497 -0400", hash_original_method = "8472A11DDB1452C7DB4257A960216E78", hash_generated_method = "2AE18C839054C2DD63E44E6E1DE6B146")
    protected void attachViewToParent(View child, int index, LayoutParams params) {
        addTaint(params.getTaint());
        addTaint(index);
        addTaint(child.getTaint());
        child.mLayoutParams = params;
    if(index < 0)        
        {
            index = mChildrenCount;
        } //End block
        addInArray(child, index);
        child.mParent = this;
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                DRAWN | INVALIDATED;
        this.mPrivateFlags |= INVALIDATED;
    if(child.hasFocus())        
        {
            requestChildFocus(child, child.findFocus());
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.498 -0400", hash_original_method = "635C6E5D7FA712D6D6BC98C85EEAD0AE", hash_generated_method = "B76E74F798F173789C908BE45CA18614")
    protected void detachViewFromParent(View child) {
        addTaint(child.getTaint());
        removeFromArray(indexOfChild(child));
        // ---------- Original Method ----------
        //removeFromArray(indexOfChild(child));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.498 -0400", hash_original_method = "6B327774A5D40749E682A0800D955866", hash_generated_method = "4F4D1DFF7CA11614EBA44EB315C094D7")
    protected void detachViewFromParent(int index) {
        addTaint(index);
        removeFromArray(index);
        // ---------- Original Method ----------
        //removeFromArray(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.498 -0400", hash_original_method = "9419943F60DE9471E3CB31EABE2947F0", hash_generated_method = "82703DB6AD9F523FE2FC9467E3ABD022")
    protected void detachViewsFromParent(int start, int count) {
        addTaint(count);
        addTaint(start);
        removeFromArray(start, count);
        // ---------- Original Method ----------
        //removeFromArray(start, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.499 -0400", hash_original_method = "FD3027623927AF219788395D1D83AA06", hash_generated_method = "7E0224B117E520B64C422B689EB459CB")
    protected void detachAllViewsFromParent() {
        final int count = mChildrenCount;
    if(count <= 0)        
        {
            return;
        } //End block
        final View[] children = mChildren;
        mChildrenCount = 0;
for(int i = count - 1;i >= 0;i--)
        {
            children[i].mParent = null;
            children[i] = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.503 -0400", hash_original_method = "063B7BC13F01F04711683C921C10A0CE", hash_generated_method = "3498AEE5E79B1CB7886834755380D422")
    public final void invalidateChild(View child, final Rect dirty) {
        addTaint(dirty.getTaint());
        addTaint(child.getTaint());
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD);
        } //End block
        ViewParent parent = this;
        final AttachInfo attachInfo = mAttachInfo;
    if(attachInfo != null)        
        {
            final boolean drawAnimation = (child.mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION;
    if(dirty == null)            
            {
    if(child.mLayerType != LAYER_TYPE_NONE)                
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.setEmpty();
                } //End block
                do {
                    {
                        View view = null;
    if(parent instanceof View)                        
                        {
                            view = (View) parent;
    if(view.mLayerType != LAYER_TYPE_NONE)                            
                            {
                                view.mLocalDirtyRect.setEmpty();
    if(view.getParent() instanceof View)                                
                                {
                                    final View grandParent = (View) view.getParent();
                                    grandParent.mPrivateFlags |= INVALIDATED;
                                    grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                                } //End block
                            } //End block
    if((view.mPrivateFlags & DIRTY_MASK) != 0)                            
                            {
                                break;
                            } //End block
                        } //End block
    if(drawAnimation)                        
                        {
    if(view != null)                            
                            {
                                view.mPrivateFlags |= DRAW_ANIMATION;
                            } //End block
                            else
    if(parent instanceof ViewRootImpl)                            
                            {
                                ((ViewRootImpl) parent).mIsAnimating = true;
                            } //End block
                        } //End block
    if(parent instanceof ViewRootImpl)                        
                        {
                            ((ViewRootImpl) parent).invalidate();
                            parent = null;
                        } //End block
                        else
    if(view != null)                        
                        {
    if((view.mPrivateFlags & DRAWN) == DRAWN ||
                                (view.mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID)                            
                            {
                                view.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                                view.mPrivateFlags |= DIRTY;
                                parent = view.mParent;
                            } //End block
                            else
                            {
                                parent = null;
                            } //End block
                        } //End block
                    } //End block
} while (parent != null);
            } //End block
            else
            {
                final boolean isOpaque = child.isOpaque() && !drawAnimation &&
                        child.getAnimation() == null;
                int opaqueFlag = isOpaque ? DIRTY_OPAQUE : DIRTY;
    if(child.mLayerType != LAYER_TYPE_NONE)                
                {
                    mPrivateFlags |= INVALIDATED;
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    child.mLocalDirtyRect.union(dirty);
                } //End block
                final int[] location = attachInfo.mInvalidateChildLocation;
                location[CHILD_LEFT_INDEX] = child.mLeft;
                location[CHILD_TOP_INDEX] = child.mTop;
                Matrix childMatrix = child.getMatrix();
    if(!childMatrix.isIdentity())                
                {
                    RectF boundingRect = attachInfo.mTmpTransformRect;
                    boundingRect.set(dirty);
                    childMatrix.mapRect(boundingRect);
                    dirty.set((int) (boundingRect.left - 0.5f),
                            (int) (boundingRect.top - 0.5f),
                            (int) (boundingRect.right + 0.5f),
                            (int) (boundingRect.bottom + 0.5f));
                } //End block
                do {
                    {
                        View view = null;
    if(parent instanceof View)                        
                        {
                            view = (View) parent;
    if(view.mLayerType != LAYER_TYPE_NONE &&
                                view.getParent() instanceof View)                            
                            {
                                final View grandParent = (View) view.getParent();
                                grandParent.mPrivateFlags |= INVALIDATED;
                                grandParent.mPrivateFlags &= ~DRAWING_CACHE_VALID;
                            } //End block
                        } //End block
    if(drawAnimation)                        
                        {
    if(view != null)                            
                            {
                                view.mPrivateFlags |= DRAW_ANIMATION;
                            } //End block
                            else
    if(parent instanceof ViewRootImpl)                            
                            {
                                ((ViewRootImpl) parent).mIsAnimating = true;
                            } //End block
                        } //End block
    if(view != null)                        
                        {
    if((view.mViewFlags & FADING_EDGE_MASK) != 0 &&
                                view.getSolidColor() == 0)                            
                            {
                                opaqueFlag = DIRTY;
                            } //End block
    if((view.mPrivateFlags & DIRTY_MASK) != DIRTY)                            
                            {
                                view.mPrivateFlags = (view.mPrivateFlags & ~DIRTY_MASK) | opaqueFlag;
                            } //End block
                        } //End block
                        parent = parent.invalidateChildInParent(location, dirty);
    if(view != null)                        
                        {
                            Matrix m = view.getMatrix();
    if(!m.isIdentity())                            
                            {
                                RectF boundingRect = attachInfo.mTmpTransformRect;
                                boundingRect.set(dirty);
                                m.mapRect(boundingRect);
                                dirty.set((int) boundingRect.left, (int) boundingRect.top,
                                    (int) (boundingRect.right + 0.5f),
                                    (int) (boundingRect.bottom + 0.5f));
                            } //End block
                        } //End block
                    } //End block
} while (parent != null);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.505 -0400", hash_original_method = "DC318C38544A42EB44071D5AE866F2AB", hash_generated_method = "DF6139D2EDDAAC46FA2DAA431EDDD40D")
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty) {
        addTaint(dirty.getTaint());
        addTaint(location[0]);
    if(ViewDebug.TRACE_HIERARCHY)        
        {
            ViewDebug.trace(this, ViewDebug.HierarchyTraceType.INVALIDATE_CHILD_IN_PARENT);
        } //End block
    if((mPrivateFlags & DRAWN) == DRAWN ||
                (mPrivateFlags & DRAWING_CACHE_VALID) == DRAWING_CACHE_VALID)        
        {
    if((mGroupFlags & (FLAG_OPTIMIZE_INVALIDATE | FLAG_ANIMATION_DONE)) !=
                        FLAG_OPTIMIZE_INVALIDATE)            
            {
                dirty.offset(location[CHILD_LEFT_INDEX] - mScrollX,
                        location[CHILD_TOP_INDEX] - mScrollY);
                final int left = mLeft;
                final int top = mTop;
    if((mGroupFlags & FLAG_CLIP_CHILDREN) != FLAG_CLIP_CHILDREN ||
                        dirty.intersect(0, 0, mRight - left, mBottom - top) ||
                        (mPrivateFlags & DRAW_ANIMATION) == DRAW_ANIMATION)                
                {
                    mPrivateFlags &= ~DRAWING_CACHE_VALID;
                    location[CHILD_LEFT_INDEX] = left;
                    location[CHILD_TOP_INDEX] = top;
    if(mLayerType != LAYER_TYPE_NONE)                    
                    {
                        mLocalDirtyRect.union(dirty);
                    } //End block
ViewParent var0FD24AAB8334CCBF65F979972AC650BD_132376194 =                     mParent;
                    var0FD24AAB8334CCBF65F979972AC650BD_132376194.addTaint(taint);
                    return var0FD24AAB8334CCBF65F979972AC650BD_132376194;
                } //End block
            } //End block
            else
            {
                mPrivateFlags &= ~DRAWN & ~DRAWING_CACHE_VALID;
                location[CHILD_LEFT_INDEX] = mLeft;
                location[CHILD_TOP_INDEX] = mTop;
    if((mGroupFlags & FLAG_CLIP_CHILDREN) == FLAG_CLIP_CHILDREN)                
                {
                    dirty.set(0, 0, mRight - mLeft, mBottom - mTop);
                } //End block
                else
                {
                    dirty.union(0, 0, mRight - mLeft, mBottom - mTop);
                } //End block
    if(mLayerType != LAYER_TYPE_NONE)                
                {
                    mLocalDirtyRect.union(dirty);
                } //End block
ViewParent var0FD24AAB8334CCBF65F979972AC650BD_2077233165 =                 mParent;
                var0FD24AAB8334CCBF65F979972AC650BD_2077233165.addTaint(taint);
                return var0FD24AAB8334CCBF65F979972AC650BD_2077233165;
            } //End block
        } //End block
ViewParent var540C13E9E156B687226421B24F2DF178_1578200718 =         null;
        var540C13E9E156B687226421B24F2DF178_1578200718.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1578200718;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.507 -0400", hash_original_method = "50571ED06CB8BFD92222BA4CF106E503", hash_generated_method = "184131799C77C7F6EC942B69119DCEE6")
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect) {
        addTaint(rect.getTaint());
        addTaint(descendant.getTaint());
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, true, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.507 -0400", hash_original_method = "237D31B5A43A7733C9219A4289DB54A9", hash_generated_method = "6AE84E407AD5C399748494B298407924")
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect) {
        addTaint(rect.getTaint());
        addTaint(descendant.getTaint());
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
        // ---------- Original Method ----------
        //offsetRectBetweenParentAndChild(descendant, rect, false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.507 -0400", hash_original_method = "D3722A63E3ED25EA76952CBDD9156CED", hash_generated_method = "A06BE0F0797F588E830F1CCE7DDE6102")
     void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds) {
        addTaint(clipToBounds);
        addTaint(offsetFromChildToParent);
        addTaint(rect.getTaint());
        addTaint(descendant.getTaint());
    if(descendant == this)        
        {
            return;
        } //End block
        ViewParent theParent = descendant.mParent;
        while
((theParent != null)
                && (theParent instanceof View)
                && (theParent != this))        
        {
    if(offsetFromChildToParent)            
            {
                rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
    if(clipToBounds)                
                {
                    View p = (View) theParent;
                    rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                } //End block
            } //End block
            else
            {
    if(clipToBounds)                
                {
                    View p = (View) theParent;
                    rect.intersect(0, 0, p.mRight - p.mLeft, p.mBottom - p.mTop);
                } //End block
                rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
            } //End block
            descendant = (View) theParent;
            theParent = descendant.mParent;
        } //End block
    if(theParent == this)        
        {
    if(offsetFromChildToParent)            
            {
                rect.offset(descendant.mLeft - descendant.mScrollX,
                        descendant.mTop - descendant.mScrollY);
            } //End block
            else
            {
                rect.offset(descendant.mScrollX - descendant.mLeft,
                        descendant.mScrollY - descendant.mTop);
            } //End block
        } //End block
        else
        {
            IllegalArgumentException varA60C75C651AEBBFE7F7318529C05F253_1404358015 = new IllegalArgumentException("parameter must be a descendant of this view");
            varA60C75C651AEBBFE7F7318529C05F253_1404358015.addTaint(taint);
            throw varA60C75C651AEBBFE7F7318529C05F253_1404358015;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.509 -0400", hash_original_method = "7A1B0B3F062F0EF6FC199DD0C643A517", hash_generated_method = "8393E9E90C5096EE6C85D8AD282614A6")
    public void offsetChildrenTopAndBottom(int offset) {
        addTaint(offset);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
            final View v = children[i];
            v.mTop += offset;
            v.mBottom += offset;
        } //End block
        // ---------- Original Method ----------
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //final View v = children[i];
            //v.mTop += offset;
            //v.mBottom += offset;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.509 -0400", hash_original_method = "5C31858D2677D0E5DD9194B8EDADFECC", hash_generated_method = "D54B57D5BBE81EA370BD7B4140CE4AB3")
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset) {
        addTaint(offset.getTaint());
        addTaint(r.getTaint());
        addTaint(child.getTaint());
        final RectF rect = mAttachInfo != null ? mAttachInfo.mTmpTransformRect : new RectF();
        rect.set(r);
    if(!child.hasIdentityMatrix())        
        {
            child.getMatrix().mapRect(rect);
        } //End block
        int dx = child.mLeft - mScrollX;
        int dy = child.mTop - mScrollY;
        rect.offset(dx, dy);
    if(offset != null)        
        {
    if(!child.hasIdentityMatrix())            
            {
                float[] position = mAttachInfo != null ? mAttachInfo.mTmpTransformLocation
                        : new float[2];
                position[0] = offset.x;
                position[1] = offset.y;
                child.getMatrix().mapPoints(position);
                offset.x = (int) (position[0] + 0.5f);
                offset.y = (int) (position[1] + 0.5f);
            } //End block
            offset.x += dx;
            offset.y += dy;
        } //End block
    if(rect.intersect(0, 0, mRight - mLeft, mBottom - mTop))        
        {
    if(mParent == null)            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1798012009 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1912217273 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1912217273;
            }
            r.set((int) (rect.left + 0.5f), (int) (rect.top + 0.5f),
                    (int) (rect.right + 0.5f), (int) (rect.bottom + 0.5f));
            boolean var923A98A5D39B2F1E49EF1BD40DCADE16_1208376893 = (mParent.getChildVisibleRect(this, r, offset));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1698128109 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1698128109;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_47732731 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942811799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942811799;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.509 -0400", hash_original_method = "89A2794B62BBEA7754F18155FA121F08", hash_generated_method = "43A028DB4F4B98169402C201D62ACFFA")
    @Override
    public final void layout(int l, int t, int r, int b) {
        addTaint(b);
        addTaint(r);
        addTaint(t);
        addTaint(l);
    if(mTransition == null || !mTransition.isChangingLayout())        
        {
            super.layout(l, t, r, b);
        } //End block
        else
        {
            mLayoutSuppressed = true;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.511 -0400", hash_original_method = "74094E4283ACC987205CEBE8397B866C", hash_generated_method = "8C888B997E7C6A2C5A8DCD54A12D060B")
    protected boolean canAnimate() {
        boolean varF64A4557C7728F3EF192131F68E42B36_412727532 = (mLayoutAnimationController != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327615722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327615722;
        // ---------- Original Method ----------
        //return mLayoutAnimationController != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.511 -0400", hash_original_method = "99174EE5664A8F981F50635AC5D4970E", hash_generated_method = "41E0958C445CBE7818080AE1748EA13C")
    public void startLayoutAnimation() {
    if(mLayoutAnimationController != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.511 -0400", hash_original_method = "06C0C7BBCCF19FA4957838E03EE331C8", hash_generated_method = "79A372FB31048C6468EBF3B2058D214E")
    public void scheduleLayoutAnimation() {
        mGroupFlags |= FLAG_RUN_ANIMATION;
        // ---------- Original Method ----------
        //mGroupFlags |= FLAG_RUN_ANIMATION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.511 -0400", hash_original_method = "76D54B6C61296EF04870B520A219B087", hash_generated_method = "A0A0A1904EFC35287777D58AAB963432")
    public void setLayoutAnimation(LayoutAnimationController controller) {
        mLayoutAnimationController = controller;
    if(mLayoutAnimationController != null)        
        {
            mGroupFlags |= FLAG_RUN_ANIMATION;
        } //End block
        // ---------- Original Method ----------
        //mLayoutAnimationController = controller;
        //if (mLayoutAnimationController != null) {
            //mGroupFlags |= FLAG_RUN_ANIMATION;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.511 -0400", hash_original_method = "BD382B237F964A42E5B6E00A5B3A23FD", hash_generated_method = "046E2414EEE85CFA53A3A3DE55D63850")
    public LayoutAnimationController getLayoutAnimation() {
LayoutAnimationController var8A452609EA18DB1E1E5EB31AC66AC9BE_1257670938 =         mLayoutAnimationController;
        var8A452609EA18DB1E1E5EB31AC66AC9BE_1257670938.addTaint(taint);
        return var8A452609EA18DB1E1E5EB31AC66AC9BE_1257670938;
        // ---------- Original Method ----------
        //return mLayoutAnimationController;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.511 -0400", hash_original_method = "91C32769C37DCC6F9F6B4528E4A57D15", hash_generated_method = "B0B7C68352E64C7CDF13F8C29C6681E4")
    @ViewDebug.ExportedProperty
    public boolean isAnimationCacheEnabled() {
        boolean var9F17249DB8879D2EEA65EE9B6E656C4C_1904311359 = ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056649805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056649805;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.514 -0400", hash_original_method = "DD639E9259A75AF16A9190E263F8776F", hash_generated_method = "42B4394AF81518ED838250292D002672")
    public void setAnimationCacheEnabled(boolean enabled) {
        addTaint(enabled);
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.514 -0400", hash_original_method = "B9ACD8DAE870BEF4EFBF779A704F6EA0", hash_generated_method = "671B791B1A3C803894B1A79703710367")
    @ViewDebug.ExportedProperty(category = "drawing")
    public boolean isAlwaysDrawnWithCacheEnabled() {
        boolean var7BFC97307655810F32F04FBCABE3CDAE_704310199 = ((mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263569164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_263569164;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.514 -0400", hash_original_method = "ACB4830CB4940DD4B9F47560853379A8", hash_generated_method = "13F9B5DD2D829B2040967A7727B8D070")
    public void setAlwaysDrawnWithCacheEnabled(boolean always) {
        addTaint(always);
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.514 -0400", hash_original_method = "4364C0D051F178DD0E8ADCB73D61750A", hash_generated_method = "2F4D1D0D5BBD020450DAA44D1EC50CAE")
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawnWithCacheEnabled() {
        boolean varC5F6B3BF85F536497CB388460DF1376E_380572164 = ((mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481196342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481196342;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.514 -0400", hash_original_method = "2230D982A122AD23513779DE65F20855", hash_generated_method = "FBDC8CDE5E7DDB3773CA116C67BDCFC6")
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled) {
        addTaint(enabled);
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.515 -0400", hash_original_method = "5166D8925764E3FCE51BAB9F8B82BB83", hash_generated_method = "1948E6748A5CA51166E931A0575F7ACD")
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean isChildrenDrawingOrderEnabled() {
        boolean varBFDCA02BAADB4FD2B2924117AAC9F43F_2025587426 = ((mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181629986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181629986;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.515 -0400", hash_original_method = "206BAF2A94AC84475BA4253F279E8423", hash_generated_method = "DD6612F2CFEDBAD9DF1AD6D0166404CA")
    protected void setChildrenDrawingOrderEnabled(boolean enabled) {
        addTaint(enabled);
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
        // ---------- Original Method ----------
        //setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "DAA9F10BF0EA997E391E78BA1DF6ABEE", hash_generated_method = "76D699AEF8A2E78C0E7D6249ABC668A5")
    private void setBooleanFlag(int flag, boolean value) {
        addTaint(value);
    if(value)        
        {
            mGroupFlags |= flag;
        } //End block
        else
        {
            mGroupFlags &= ~flag;
        } //End block
        // ---------- Original Method ----------
        //if (value) {
            //mGroupFlags |= flag;
        //} else {
            //mGroupFlags &= ~flag;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "944A8E363FECEAC5FA18188B2A82EEA9", hash_generated_method = "BC7A44768DE79342D24614DD21BE4D1C")
    @ViewDebug.ExportedProperty(category = "drawing", mapping = {
        @ViewDebug.IntToString(from = PERSISTENT_NO_CACHE,        to = "NONE"),
        @ViewDebug.IntToString(from = PERSISTENT_ANIMATION_CACHE, to = "ANIMATION"),
        @ViewDebug.IntToString(from = PERSISTENT_SCROLLING_CACHE, to = "SCROLLING"),
        @ViewDebug.IntToString(from = PERSISTENT_ALL_CACHES,      to = "ALL")
    })
    public int getPersistentDrawingCache() {
        int varCFD9A5A2BA3F2274ECC022BF6DB661C8_153778320 = (mPersistentDrawingCache);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309882017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309882017;
        // ---------- Original Method ----------
        //return mPersistentDrawingCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "E1A853399F91DFB847E7C25FCC355E2E", hash_generated_method = "8158E6575E5BC3B0CF39A9A0E9990C3F")
    public void setPersistentDrawingCache(int drawingCacheToKeep) {
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
        // ---------- Original Method ----------
        //mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "AED9080C69042489485342721EE0B0B1", hash_generated_method = "D1FD7059BBFA5AD6436DB351A22646B8")
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        addTaint(attrs.getTaint());
LayoutParams var023B3FAAA9940C6DE114BF4C9FED2D73_1334519595 =         new LayoutParams(getContext(), attrs);
        var023B3FAAA9940C6DE114BF4C9FED2D73_1334519595.addTaint(taint);
        return var023B3FAAA9940C6DE114BF4C9FED2D73_1334519595;
        // ---------- Original Method ----------
        //return new LayoutParams(getContext(), attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "732F05B425275E63BD87B7814AB2A9CD", hash_generated_method = "3CF0E7F3C0F3416134FA95DE0B1877D7")
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        addTaint(p.getTaint());
LayoutParams var74E4690D9F2A026504928C017944E149_1282140938 =         p;
        var74E4690D9F2A026504928C017944E149_1282140938.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_1282140938;
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "378AC11079CE6884A850F340A9660EF3", hash_generated_method = "238178D70AB7238B9406CA67F3A1EF18")
    protected LayoutParams generateDefaultLayoutParams() {
LayoutParams var65BA47367D3E2EC837A3E887EEE5A3B3_1683802355 =         new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        var65BA47367D3E2EC837A3E887EEE5A3B3_1683802355.addTaint(taint);
        return var65BA47367D3E2EC837A3E887EEE5A3B3_1683802355;
        // ---------- Original Method ----------
        //return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.516 -0400", hash_original_method = "4EE7CD38DD5C6A89B0A06AD3B67D59FC", hash_generated_method = "C3C89BF0409F71444D4597DBA2F9DF5A")
    @Override
    protected boolean dispatchConsistencyCheck(int consistency) {
        addTaint(consistency);
        boolean result = super.dispatchConsistencyCheck(consistency);
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
    if(!children[i].dispatchConsistencyCheck(consistency))            
            result = false;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_464948637 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361332895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361332895;
        // ---------- Original Method ----------
        //boolean result = super.dispatchConsistencyCheck(consistency);
        //final int count = mChildrenCount;
        //final View[] children = mChildren;
        //for (int i = 0; i < count; i++) {
            //if (!children[i].dispatchConsistencyCheck(consistency)) result = false;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.517 -0400", hash_original_method = "9938C74D91901C257958D174411BCA62", hash_generated_method = "8490516F37FB7A69ED9F89FCEBFD25DC")
    @Override
    protected boolean onConsistencyCheck(int consistency) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(consistency);
        boolean result = super.onConsistencyCheck(consistency);
        final boolean checkLayout = (consistency & ViewDebug.CONSISTENCY_LAYOUT) != 0;
        final boolean checkDrawing = (consistency & ViewDebug.CONSISTENCY_DRAWING) != 0;
    if(checkLayout)        
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
for(int i = 0;i < count;i++)
            {
    if(children[i].getParent() != this)                
                {
                    result = false;
                    android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                            "View " + children[i] + " has no parent/a parent that is not " + this);
                } //End block
            } //End block
        } //End block
    if(checkDrawing)        
        {
    if((mPrivateFlags & DIRTY_MASK) != 0)            
            {
                final ViewParent parent = getParent();
    if(parent != null && !(parent instanceof ViewRootImpl))                
                {
    if((((View) parent).mPrivateFlags & DIRTY_MASK) == 0)                    
                    {
                        result = false;
                        android.util.Log.d(ViewDebug.CONSISTENCY_LOG_TAG,
                                "ViewGroup " + this + " is dirty but its parent is not: " + this);
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_1790339344 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139027509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139027509;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.518 -0400", hash_original_method = "9209AC82FBA5456C7517DF8735B229C2", hash_generated_method = "183080388EFEFBFE9046A67B07FE40AD")
    @Override
    protected void debug(int depth) {
        addTaint(depth);
        super.debug(depth);
        String output;
    if(mFocused != null)        
        {
            output = debugIndent(depth);
            output += "mFocused";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
    if(mChildrenCount != 0)        
        {
            output = debugIndent(depth);
            output += "{";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
        int count = mChildrenCount;
for(int i = 0;i < count;i++)
        {
            View child = mChildren[i];
            child.debug(depth + 1);
        } //End block
    if(mChildrenCount != 0)        
        {
            output = debugIndent(depth);
            output += "}";
            Log.d(VIEW_LOG_TAG, output);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.518 -0400", hash_original_method = "A3819F4FC73AAB74FEBE19CD2546FBCA", hash_generated_method = "2F29C0EF91350CF0B81988E87AEAC590")
    public int indexOfChild(View child) {
        addTaint(child.getTaint());
        final int count = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < count;i++)
        {
    if(children[i] == child)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_2105526957 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481620002 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481620002;
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_734770138 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126529068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126529068;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.518 -0400", hash_original_method = "7030903D0CFC3D101159E57E177A8D82", hash_generated_method = "AA548A74B1496434EF521FE7E4F17FD3")
    public int getChildCount() {
        int varA5034A70A83D3C81CEC027BDCAA166D7_1237269929 = (mChildrenCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822455068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822455068;
        // ---------- Original Method ----------
        //return mChildrenCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.518 -0400", hash_original_method = "DC55A008910617641F1AE978A0E895D4", hash_generated_method = "3CC4F6B986B9F416AE14F39CE1304E04")
    public View getChildAt(int index) {
        addTaint(index);
    if(index < 0 || index >= mChildrenCount)        
        {
View var540C13E9E156B687226421B24F2DF178_1953409856 =             null;
            var540C13E9E156B687226421B24F2DF178_1953409856.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1953409856;
        } //End block
View var59DDA6BC6C72B3E73E3ACF199F9201D0_1526318259 =         mChildren[index];
        var59DDA6BC6C72B3E73E3ACF199F9201D0_1526318259.addTaint(taint);
        return var59DDA6BC6C72B3E73E3ACF199F9201D0_1526318259;
        // ---------- Original Method ----------
        //if (index < 0 || index >= mChildrenCount) {
            //return null;
        //}
        //return mChildren[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.520 -0400", hash_original_method = "542392FF7FE475C27FCC004AAEE4D21F", hash_generated_method = "DC9E167B6220F6FD6FF6C5DA7D351D88")
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec) {
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        final int size = mChildrenCount;
        final View[] children = mChildren;
for(int i = 0;i < size;++i)
        {
            final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) != GONE)            
            {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.520 -0400", hash_original_method = "9EDA680ED83105527C80B1E780D1BEC7", hash_generated_method = "25445F06E0988BF83A39496A1FEDB291")
    protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec) {
        addTaint(parentHeightMeasureSpec);
        addTaint(parentWidthMeasureSpec);
        addTaint(child.getTaint());
        final LayoutParams lp = child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
        // ---------- Original Method ----------
        //final LayoutParams lp = child.getLayoutParams();
        //final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                //mPaddingLeft + mPaddingRight, lp.width);
        //final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                //mPaddingTop + mPaddingBottom, lp.height);
        //child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.520 -0400", hash_original_method = "DF0652AA16CC35609E8DBABD1504358F", hash_generated_method = "20B96BEB9AE3737E5C3779B87FEE2D48")
    protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        addTaint(heightUsed);
        addTaint(parentHeightMeasureSpec);
        addTaint(widthUsed);
        addTaint(parentWidthMeasureSpec);
        addTaint(child.getTaint());
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.521 -0400", hash_original_method = "92C99C7B01BA8D70EFEE87F46C0710D1", hash_generated_method = "AEC59883A5105FAFAA04D4D346420EEE")
    public void clearDisappearingChildren() {
    if(mDisappearingChildren != null)        
        {
            mDisappearingChildren.clear();
        } //End block
        // ---------- Original Method ----------
        //if (mDisappearingChildren != null) {
            //mDisappearingChildren.clear();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.522 -0400", hash_original_method = "EFF49544FBF4F5023D4E3259D68E48A6", hash_generated_method = "4040921BAB7DE2F8B9CE54B26FDB1C3C")
    private void addDisappearingView(View v) {
        addTaint(v.getTaint());
        ArrayList<View> disappearingChildren = mDisappearingChildren;
    if(disappearingChildren == null)        
        {
            disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        } //End block
        disappearingChildren.add(v);
        // ---------- Original Method ----------
        //ArrayList<View> disappearingChildren = mDisappearingChildren;
        //if (disappearingChildren == null) {
            //disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        //}
        //disappearingChildren.add(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.523 -0400", hash_original_method = "F02FCA79EB2173CD96A012235B90F902", hash_generated_method = "9C63D3988E48E9EA9CECC51EB81E4756")
    private void finishAnimatingView(final View view, Animation animation) {
        addTaint(animation.getTaint());
        addTaint(view.getTaint());
        final ArrayList<View> disappearingChildren = mDisappearingChildren;
    if(disappearingChildren != null)        
        {
    if(disappearingChildren.contains(view))            
            {
                disappearingChildren.remove(view);
    if(view.mAttachInfo != null)                
                {
                    view.dispatchDetachedFromWindow();
                } //End block
                view.clearAnimation();
                mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
            } //End block
        } //End block
    if(animation != null && !animation.getFillAfter())        
        {
            view.clearAnimation();
        } //End block
    if((view.mPrivateFlags & ANIMATION_STARTED) == ANIMATION_STARTED)        
        {
            view.onAnimationEnd();
            view.mPrivateFlags &= ~ANIMATION_STARTED;
            mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.523 -0400", hash_original_method = "663B00ABF4B2F32B3DAAC91DDA64BE32", hash_generated_method = "E767111E093D8EAF4B1337899B5EB1F4")
     boolean isViewTransitioning(View view) {
        addTaint(view.getTaint());
        boolean var668E624AF39227481B993213F9102405_897420934 = ((mTransitioningViews != null && mTransitioningViews.contains(view)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780757763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780757763;
        // ---------- Original Method ----------
        //return (mTransitioningViews != null && mTransitioningViews.contains(view));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.523 -0400", hash_original_method = "3DD17A0BC43336D376B4C3E60ACB3106", hash_generated_method = "B6F202B9AFA35F53810097C186610C4E")
    public void startViewTransition(View view) {
        addTaint(view.getTaint());
    if(view.mParent == this)        
        {
    if(mTransitioningViews == null)            
            {
                mTransitioningViews = new ArrayList<View>();
            } //End block
            mTransitioningViews.add(view);
        } //End block
        // ---------- Original Method ----------
        //if (view.mParent == this) {
            //if (mTransitioningViews == null) {
                //mTransitioningViews = new ArrayList<View>();
            //}
            //mTransitioningViews.add(view);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.525 -0400", hash_original_method = "A78E74DD3F17BBF76B7245787E00733D", hash_generated_method = "F8C1295B61E7701CBDCD917D425744EA")
    public void endViewTransition(View view) {
        addTaint(view.getTaint());
    if(mTransitioningViews != null)        
        {
            mTransitioningViews.remove(view);
            final ArrayList<View> disappearingChildren = mDisappearingChildren;
    if(disappearingChildren != null && disappearingChildren.contains(view))            
            {
                disappearingChildren.remove(view);
    if(mVisibilityChangingChildren != null &&
                        mVisibilityChangingChildren.contains(view))                
                {
                    mVisibilityChangingChildren.remove(view);
                } //End block
                else
                {
    if(view.mAttachInfo != null)                    
                    {
                        view.dispatchDetachedFromWindow();
                    } //End block
    if(view.mParent != null)                    
                    {
                        view.mParent = null;
                    } //End block
                } //End block
                mGroupFlags |= FLAG_INVALIDATE_REQUIRED;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.525 -0400", hash_original_method = "90F24CF973A15FCB3D8EF936857F7660", hash_generated_method = "6CA1CA6303424008718B53566FE22B29")
    @Override
    public boolean gatherTransparentRegion(Region region) {
        addTaint(region.getTaint());
        final boolean meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
    if(meOpaque && region == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_125481710 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551394549 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551394549;
        } //End block
        super.gatherTransparentRegion(region);
        final View[] children = mChildren;
        final int count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent = true;
for(int i = 0;i < count;i++)
        {
            final View child = children[i];
    if((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null)            
            {
    if(!child.gatherTransparentRegion(region))                
                {
                    noneOfTheChildrenAreTransparent = false;
                } //End block
            } //End block
        } //End block
        boolean varCB2BC7FF4565A20F7924E844EB7028C0_1102887416 = (meOpaque || noneOfTheChildrenAreTransparent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1911556736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1911556736;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.526 -0400", hash_original_method = "5C4070054C131245FD376376D5198B5B", hash_generated_method = "8D038914887B9E14BED650384F7AABCD")
    public void requestTransparentRegion(View child) {
        addTaint(child.getTaint());
    if(child != null)        
        {
            child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
    if(mParent != null)            
            {
                mParent.requestTransparentRegion(this);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (child != null) {
            //child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            //if (mParent != null) {
                //mParent.requestTransparentRegion(this);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.526 -0400", hash_original_method = "055C0C5E94DF77352535F2463E2E2F92", hash_generated_method = "656F7708359B351667FBC28158B33490")
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        addTaint(insets.getTaint());
        boolean done = super.fitSystemWindows(insets);
    if(!done)        
        {
            final int count = mChildrenCount;
            final View[] children = mChildren;
for(int i = 0;i < count;i++)
            {
                done = children[i].fitSystemWindows(insets);
    if(done)                
                {
                    break;
                } //End block
            } //End block
        } //End block
        boolean var6B2DED51D81A4403D8A4BD25FA1E57EE_1027953378 = (done);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033777656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033777656;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.528 -0400", hash_original_method = "B3B3B12C071F8F31617EDB75C1351CBC", hash_generated_method = "160C9FF7C7D6BEF7CFCC4D98041FA267")
    public Animation.AnimationListener getLayoutAnimationListener() {
Animation.AnimationListener varAF2C9816117CD49985736EFF62CB9500_721397800 =         mAnimationListener;
        varAF2C9816117CD49985736EFF62CB9500_721397800.addTaint(taint);
        return varAF2C9816117CD49985736EFF62CB9500_721397800;
        // ---------- Original Method ----------
        //return mAnimationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.528 -0400", hash_original_method = "309790593767800D49B3C7FD0CAB3F32", hash_generated_method = "0BD706F4174ED5A138E674DC8E749B3C")
    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    if((mGroupFlags & FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE) != 0)        
        {
    if((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0)            
            {
                IllegalStateException var706E30DEC7D234066B92798F99EC5280_1631261288 = new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
                var706E30DEC7D234066B92798F99EC5280_1631261288.addTaint(taint);
                throw var706E30DEC7D234066B92798F99EC5280_1631261288;
            } //End block
            final View[] children = mChildren;
            final int count = mChildrenCount;
for(int i = 0;i < count;i++)
            {
                final View child = children[i];
    if((child.mViewFlags & DUPLICATE_PARENT_STATE) != 0)                
                {
                    child.refreshDrawableState();
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.528 -0400", hash_original_method = "9BFEBEB244ACA3F0CF8B6DCD826B4034", hash_generated_method = "D2CE898517FB92241FDF4DA86D2EC67C")
    @Override
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final View[] children = mChildren;
        final int count = mChildrenCount;
for(int i = 0;i < count;i++)
        {
            children[i].jumpDrawablesToCurrentState();
        } //End block
        // ---------- Original Method ----------
        //super.jumpDrawablesToCurrentState();
        //final View[] children = mChildren;
        //final int count = mChildrenCount;
        //for (int i = 0; i < count; i++) {
            //children[i].jumpDrawablesToCurrentState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.528 -0400", hash_original_method = "0411A3FE715B4530882EE6CBB1252DCB", hash_generated_method = "21CF04B7502A9949DEBC8626E6878A04")
    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(extraSpace);
    if((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) == 0)        
        {
            int[] var66AAC6FF29C922B79B81CD6E0D9D06DC_1924235314 = (super.onCreateDrawableState(extraSpace));
                        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1060157954 = {getTaintInt()};
            return varB4CCCA26F9DB9189C32F33E82D425CFB_1060157954;
        } //End block
        int need = 0;
        int n = getChildCount();
for(int i = 0;i < n;i++)
        {
            int[] childState = getChildAt(i).getDrawableState();
    if(childState != null)            
            {
                need += childState.length;
            } //End block
        } //End block
        int[] state = super.onCreateDrawableState(extraSpace + need);
for(int i = 0;i < n;i++)
        {
            int[] childState = getChildAt(i).getDrawableState();
    if(childState != null)            
            {
                state = mergeDrawableStates(state, childState);
            } //End block
        } //End block
        int[] var9ED39E2EA931586B6A985A6942EF573E_2071423619 = (state);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_674383153 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_674383153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.529 -0400", hash_original_method = "1481B38AF6385F8F98E444294398E1C4", hash_generated_method = "5B36C880F5B68B92BB35983A60C435C7")
    public void setAddStatesFromChildren(boolean addsStates) {
        addTaint(addsStates);
    if(addsStates)        
        {
            mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        } //End block
        else
        {
            mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        } //End block
        refreshDrawableState();
        // ---------- Original Method ----------
        //if (addsStates) {
            //mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        //} else {
            //mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        //}
        //refreshDrawableState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.530 -0400", hash_original_method = "026C4CEB09DFE602F5C11A5652FC3C1F", hash_generated_method = "8592F6E387B41B29F461DB6C06595CA3")
    public boolean addStatesFromChildren() {
        boolean var440C4FBFCBC0E99B747DBAF8B257FDF0_1894043953 = ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461157165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461157165;
        // ---------- Original Method ----------
        //return (mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.530 -0400", hash_original_method = "F32408C60FA79535F6423CE68328A516", hash_generated_method = "719D7ED1E6DADE87FE73EE48D8B4A906")
    public void childDrawableStateChanged(View child) {
        addTaint(child.getTaint());
    if((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0)        
        {
            refreshDrawableState();
        } //End block
        // ---------- Original Method ----------
        //if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
            //refreshDrawableState();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.530 -0400", hash_original_method = "CCA9986B4D287F2F006BAE825941ECAA", hash_generated_method = "28A9F6F2C654D2AA771EAFD01C6ECAA2")
    public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        mAnimationListener = animationListener;
        // ---------- Original Method ----------
        //mAnimationListener = animationListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.530 -0400", hash_original_method = "8473FDA62EFB348A51ABA227E5F80648", hash_generated_method = "6DEA955DEE26839D418B608AA61F6C25")
    public void requestTransitionStart(LayoutTransition transition) {
        addTaint(transition.getTaint());
        ViewRootImpl viewAncestor = getViewRootImpl();
    if(viewAncestor != null)        
        {
            viewAncestor.requestTransitionStart(transition);
        } //End block
        // ---------- Original Method ----------
        //ViewRootImpl viewAncestor = getViewRootImpl();
        //if (viewAncestor != null) {
            //viewAncestor.requestTransitionStart(transition);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.530 -0400", hash_original_method = "438FE65F3DA47A9BB347952B8A6B02CD", hash_generated_method = "C8AB5DABF5812F3A0DBA318A6E258F3F")
    @Override
    protected void resetResolvedLayoutDirection() {
        super.resetResolvedLayoutDirection();
        final int count = getChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
    if(child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT)            
            {
                child.resetResolvedLayoutDirection();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.545 -0400", hash_original_method = "83014321BD6411A92FC299225A8B4B68", hash_generated_method = "C660791D2F5D24CBEBA71F690BCEF982")
    @Override
    protected void resetResolvedTextDirection() {
        super.resetResolvedTextDirection();
        final int count = getChildCount();
for(int i = 0;i < count;i++)
        {
            final View child = getChildAt(i);
    if(child.getTextDirection() == TEXT_DIRECTION_INHERIT)            
            {
                child.resetResolvedTextDirection();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.545 -0400", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "81BF602D40DA82AC27426C61ABBD40ED")
    public boolean shouldDelayChildPressedState() {
        boolean varB326B5062B2F0E69046810717534CB09_2111691055 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1141552735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1141552735;
        // ---------- Original Method ----------
        //return true;
    }

    
    public static class LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.545 -0400", hash_original_field = "EAAE26A6FB20ED3EF54FB23BFA0B1FCC", hash_generated_field = "E98E615247D406FD5B1F2C460414CA00")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int width;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.545 -0400", hash_original_field = "B435E227D5DD201E1768B2BCB2E0AA81", hash_generated_field = "154449EB0055FED002CA8F596F81E1FB")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        }) public int height;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.546 -0400", hash_original_field = "32A967A061019BB85A555A08521F45C3", hash_generated_field = "A8465771210F0A9A6D04062D459407C3")

        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.546 -0400", hash_original_method = "15AB37D81442EE27D75B1677A2391AE7", hash_generated_method = "7153F7D48F151279FE2BE617604B5DD1")
        public  LayoutParams(Context c, AttributeSet attrs) {
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
            a.recycle();
            // ---------- Original Method ----------
            //TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
            //setBaseAttributes(a,
                    //R.styleable.ViewGroup_Layout_layout_width,
                    //R.styleable.ViewGroup_Layout_layout_height);
            //a.recycle();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.546 -0400", hash_original_method = "25BDC30F3D80C9CBE1EB5EBCEE37F7CB", hash_generated_method = "61CBE5F83CA15EA93BA315DE7814BEC6")
        public  LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
            // ---------- Original Method ----------
            //this.width = width;
            //this.height = height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.546 -0400", hash_original_method = "2BA3A180B45B8CE1CC5399F5BB84EEDE", hash_generated_method = "0F6B2AA4452B28B14B0088D4B6A2DB9F")
        public  LayoutParams(LayoutParams source) {
            this.width = source.width;
            this.height = source.height;
            // ---------- Original Method ----------
            //this.width = source.width;
            //this.height = source.height;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.546 -0400", hash_original_method = "6916C65008FD05252A1C29A02882BE94", hash_generated_method = "45AC97A074BFD055B1BD45042F079476")
          LayoutParams() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_method = "22F495DEF56CC03879FA6664450D6ACC", hash_generated_method = "E5FD1A97DBF05843B1262AD7B2A89C11")
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr) {
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
            // ---------- Original Method ----------
            //width = a.getLayoutDimension(widthAttr, "layout_width");
            //height = a.getLayoutDimension(heightAttr, "layout_height");
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_method = "CE6F1B4BC3F83182FFE42E3A8827DEEC", hash_generated_method = "6D86F89DE956B69559B0A86CF3A2E3CD")
        protected void resolveWithDirection(int layoutDirection) {
            addTaint(layoutDirection);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_method = "E4ABE7598543A22DA450A925C25FFDEA", hash_generated_method = "CE4E8D54F39BEE422C2A8FD469C1CEBE")
        public String debug(String output) {
            addTaint(output.getTaint());
String var415ADF52E55102ED4321EF30FF1080EF_754598537 =             output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }";
            var415ADF52E55102ED4321EF30FF1080EF_754598537.addTaint(taint);
            return var415ADF52E55102ED4321EF30FF1080EF_754598537;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "B333156949B5FAA535F7E8DBDBF0D617", hash_generated_field = "B60A6144A316A76818E3F37ADD9B0E2B")

        @SuppressWarnings({"UnusedDeclaration"})
        @Deprecated
        public static final int FILL_PARENT = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "AB0F2BFD833859D7E6AF5D2D478DFEC1", hash_generated_field = "035E0815824268EA10F24139068915CD")

        public static final int MATCH_PARENT = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "331393B598CE796434D861237AC6E1F4", hash_generated_field = "33E013A8F3F409595C02468C7E3CA7AB")

        public static final int WRAP_CONTENT = -2;
    }


    
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "1419D880ADE86E149ABAFCB226F6B662", hash_generated_field = "B21196B63DA6FA861C6C44CFE61E0207")

        @ViewDebug.ExportedProperty(category = "layout") public int leftMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "F14E99EDBAA6E54CB43B2B4C3D7084CF", hash_generated_field = "C75872B6D23692F5C29153B6138A7705")

        @ViewDebug.ExportedProperty(category = "layout") public int topMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "A5E95C57F057CCC5814DC8DB40E9120B", hash_generated_field = "8215B4F64E53D75A1F217C65CCA861B0")

        @ViewDebug.ExportedProperty(category = "layout") public int rightMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "6B087389EB08EE42774D6432387E8C9A", hash_generated_field = "C9EC61B6AE185D3F68BEDBB7A02A577D")

        @ViewDebug.ExportedProperty(category = "layout") public int bottomMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "77BD249F949CA3D95A4C77016CC05819", hash_generated_field = "6BB5C7CF92CA34A599866F03AD4A8600")

        @ViewDebug.ExportedProperty(category = "layout") protected int startMargin = DEFAULT_RELATIVE;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.547 -0400", hash_original_field = "FF17DEDAB668A62D7F93257CCC172E72", hash_generated_field = "0A4C2937E1B0718BA14E68C5B33ABD23")

        @ViewDebug.ExportedProperty(category = "layout") protected int endMargin = DEFAULT_RELATIVE;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.548 -0400", hash_original_method = "10E5D625CF55B3D944D3843050E826C6", hash_generated_method = "92AF07C46DA4B05775F36E7574BE862E")
        public  MarginLayoutParams(Context c, AttributeSet attrs) {
            super();
            addTaint(attrs.getTaint());
            addTaint(c.getTaint());
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_MarginLayout);
            setBaseAttributes(a,
                    R.styleable.ViewGroup_MarginLayout_layout_width,
                    R.styleable.ViewGroup_MarginLayout_layout_height);
            int margin = a.getDimensionPixelSize(
                    com.android.internal.R.styleable.ViewGroup_MarginLayout_layout_margin, -1);
    if(margin >= 0)            
            {
                leftMargin = margin;
                topMargin = margin;
                rightMargin= margin;
                bottomMargin = margin;
            } //End block
            else
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
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.548 -0400", hash_original_method = "4C1C9EAF9AFA2E58AB980E97DFB147EB", hash_generated_method = "606D30F33DA2082424163F252826B744")
        public  MarginLayoutParams(int width, int height) {
            super(width, height);
            addTaint(height);
            addTaint(width);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.549 -0400", hash_original_method = "55868F7F983C11B537A625BA756EE7CC", hash_generated_method = "7035DFAA2CA4AF1F793362EF7D0AFEFE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.549 -0400", hash_original_method = "E2A57B11F6C8009C3B5E4EDAD0277412", hash_generated_method = "54FCC1DF48420A5FAD38AF8300540761")
        public  MarginLayoutParams(LayoutParams source) {
            super(source);
            addTaint(source.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.549 -0400", hash_original_method = "A7CFD8E9AA47AE278733C57B8CF5503F", hash_generated_method = "E9FA91064C566B35F37192AF7E41F6DA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.552 -0400", hash_original_method = "F5A63690A2F55CE5C4D6B1F24495E028", hash_generated_method = "142C3C1A10C4FC10B505CFEA80893BBF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.552 -0400", hash_original_method = "A60FB56334BFE35432A89BE021472DEF", hash_generated_method = "5977BB05202683D0436577A6EF1EB73E")
        public int getMarginStart() {
            int varC874E28EA0EF3808AC84E8C887C093B2_174981755 = (startMargin);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989232350 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989232350;
            // ---------- Original Method ----------
            //return startMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.552 -0400", hash_original_method = "2B74CF4F3396E75552B1A46DF3D4BFD7", hash_generated_method = "77F34D6C924E9085B447D93B247A6A93")
        public int getMarginEnd() {
            int varEA04B189325C9C7BE8FFE77419F7BF62_578732345 = (endMargin);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830457025 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_830457025;
            // ---------- Original Method ----------
            //return endMargin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.552 -0400", hash_original_method = "C9EA583BDFA2583A2B96D706C959CDBC", hash_generated_method = "D92D0F843066857436BEC503714ED135")
        public boolean isMarginRelative() {
            boolean var5EFA4C87369FD13EFEA666438ECAD258_224926869 = ((startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305743348 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_305743348;
            // ---------- Original Method ----------
            //return (startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_method = "25B74C4F994FDDCB83271E7B2F9BDDEE", hash_generated_method = "6B46188643EE44AC27C32BC0234CF632")
        @Override
        protected void resolveWithDirection(int layoutDirection) {
            addTaint(layoutDirection);
switch(layoutDirection){
            case View.LAYOUT_DIRECTION_RTL:
            leftMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : leftMargin;
            rightMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : rightMargin;
            break;
            case View.LAYOUT_DIRECTION_LTR:
            default:
            leftMargin = (startMargin > DEFAULT_RELATIVE) ? startMargin : leftMargin;
            rightMargin = (endMargin > DEFAULT_RELATIVE) ? endMargin : rightMargin;
            break;
}
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_field = "9719E4AAD4FACA3BF0499294B0F32D31", hash_generated_field = "706B949A33ED230B911B9350FAA5912D")

        static private final int DEFAULT_RELATIVE = Integer.MIN_VALUE;
    }


    
    private static final class TouchTarget {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_field = "F1144C2E88061517D095C11872B4C482", hash_generated_field = "530D731D7D2EE140B1D1AF75DBF79B1B")

        public int pointerIdBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "DC720CE01C505E3F8C1AAF24F8078F0D")

        public TouchTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_method = "5259B67E5A6C02FEFA0EB82F43285FB5", hash_generated_method = "B32A208B999EE5B494ADD3A3C0776E12")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.553 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "FC2DA8796F1F045A8AB2E7A88DFBDC6D")
        public void recycle() {
            synchronized
(sRecycleLock)            {
    if(sRecycledCount < MAX_RECYCLED)                
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } //End block
                else
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "A72E5077CE400FBB95D5EB6C205E6CD6", hash_generated_field = "393219263EA5357C424C8D6A0761942D")

        private static final int MAX_RECYCLED = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "5E099B93496A959515A0264634CA0534", hash_generated_field = "569BC93CDF23077487A166A9877200C9")

        private static final Object sRecycleLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "CCE02A7FF8CA5926C887F8CC8CC579A5", hash_generated_field = "E0E2F52EC1657E89F88CB94D6B19500A")

        private static TouchTarget sRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "E80DA3258C0105DF400606DD49462342", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "1B6BEB46ACAD52F4B6C908932D9CBB35", hash_generated_field = "5D0EA96D1B8E6DB25F736A1FB6B6D10D")

        public static final int ALL_POINTER_IDS = -1;
    }


    
    private static final class HoverTarget {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "1B7D5726533AB525A8760351E9B5E415", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "3B1636D6CF959CF92CBD4352E6CBCE49")

        public HoverTarget next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.554 -0400", hash_original_method = "5539B57739929C533DCF7E732D22C4F2", hash_generated_method = "726B690AE07312555BAF165F7E5F62F6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_method = "0B1C6D1635B2332F7800E0E7CCBD2BE0", hash_generated_method = "FC2DA8796F1F045A8AB2E7A88DFBDC6D")
        public void recycle() {
            synchronized
(sRecycleLock)            {
    if(sRecycledCount < MAX_RECYCLED)                
                {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } //End block
                else
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "A72E5077CE400FBB95D5EB6C205E6CD6", hash_generated_field = "393219263EA5357C424C8D6A0761942D")

        private static final int MAX_RECYCLED = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "5E099B93496A959515A0264634CA0534", hash_generated_field = "569BC93CDF23077487A166A9877200C9")

        private static final Object sRecycleLock = new Object();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "CCE02A7FF8CA5926C887F8CC8CC579A5", hash_generated_field = "9BF05FD9D6504C47D3CD94A8F3200F82")

        private static HoverTarget sRecycleBin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "E80DA3258C0105DF400606DD49462342", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
    }


    
    public interface OnHierarchyChangeListener {
        
        void onChildViewAdded(View parent, View child);

        
        void onChildViewRemoved(View parent, View child);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "093C1742536C628A897749D49426A6D3", hash_generated_field = "47BF092971141A3134E594F7724B4190")

    private static final int FLAG_CLIP_CHILDREN = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "CB5125EA3850C10828D646E68628DA9A", hash_generated_field = "8784C03D29895C69177C2E4EC32050F7")

    private static final int FLAG_CLIP_TO_PADDING = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "370A6DEBEC95348BA1E5248C135A5EC8", hash_generated_field = "6D07E3CA6E481323A58E027BE033C02B")

    private static final int FLAG_INVALIDATE_REQUIRED = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "5195C625EE4E9D8027AD632CFE4CCD01", hash_generated_field = "B26C30228855373F2358E1738754788D")

    private static final int FLAG_RUN_ANIMATION = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "83472C31AED9766B248D82ED2D074D5C", hash_generated_field = "92F56B56474778E97B28F8B1E057D57B")

    private static final int FLAG_ANIMATION_DONE = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "08A72EA908064A83313796C485ADACDD", hash_generated_field = "6B2DE00828EED965F16F1E1887A50E1A")

    private static final int FLAG_PADDING_NOT_NULL = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "CAC36ACA9ED784B231117CB39D86A384", hash_generated_field = "A363BE181F28AF138EAE37CE19C6A175")

    private static final int FLAG_ANIMATION_CACHE = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "001D3068790E7E549A48976047700A5A", hash_generated_field = "2ECEB8CA0BBD1B97E644FE478937E0E9")

    private static final int FLAG_OPTIMIZE_INVALIDATE = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "296952AC48605AFEFDBD310F71840975", hash_generated_field = "3403A038D2CECBA0DA69E8CF8F169A1F")

    private static final int FLAG_CLEAR_TRANSFORMATION = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "80E59BFDFA55701D5C3008682DE14EA5", hash_generated_field = "4CD118091ADEC14A10FCFFA5826971C0")

    private static final int FLAG_NOTIFY_ANIMATION_LISTENER = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "174D3C1D51E7CCF138A4F39DBF69B0C9", hash_generated_field = "32BC669C68D09844C7CB0B0C44FE2F3B")

    protected static final int FLAG_USE_CHILD_DRAWING_ORDER = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "880E7482176EB8093E6CCCD736E4B0A2", hash_generated_field = "A86E922C6C59CFE079F5D7DA8B15BF89")

    protected static final int FLAG_SUPPORT_STATIC_TRANSFORMATIONS = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "064633D9895C1F26598F928072EA6CA8", hash_generated_field = "49F0EBDE6CDB520FAAFA1CE2AE891179")

    private static final int FLAG_ALPHA_LOWER_THAN_ONE = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "85691F00B62FE4647557EF0CCD322E28", hash_generated_field = "4188882F32441AE2DC85E12EAB3E6C82")

    private static final int FLAG_ADD_STATES_FROM_CHILDREN = 0x2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.556 -0400", hash_original_field = "86601B54A4C45A57269BA0D57322442D", hash_generated_field = "13DA24EF090D074E119DCC3C5BD90BA8")

    private static final int FLAG_ALWAYS_DRAWN_WITH_CACHE = 0x4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "937D116FF0D4A7910D727BBF47DB86B2", hash_generated_field = "AB5153FDF753CE74CA032ECE6BC04442")

    private static final int FLAG_CHILDREN_DRAWN_WITH_CACHE = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "7F0A72234EA920F255CBA067C2A1B93D", hash_generated_field = "3A30818F90BA1EF84CA7AED25A16A1B7")

    private static final int FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE = 0x10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "548AF4B07DEB40F98E8EEB7BB82E33C6", hash_generated_field = "4836095EA9CD6F4C22D5505B63A65920")

    private static final int FLAG_MASK_FOCUSABILITY = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "90E92091E4A64B96AC11794AC6BCE1ED", hash_generated_field = "BD96D757F41BA0229D767BD84AB7642D")

    public static final int FOCUS_BEFORE_DESCENDANTS = 0x20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "1AB4D8C2E6C0EB94C5E3D81186225A46", hash_generated_field = "CD9C40718F19AA89DFB0F2B888272D33")

    public static final int FOCUS_AFTER_DESCENDANTS = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "474F04A27118AAE5C55DBA97D250DCD9", hash_generated_field = "5CE7A6F853A9C0B36CFE406D68F2F862")

    public static final int FOCUS_BLOCK_DESCENDANTS = 0x60000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "550A1DD8DB80915C8B1B187E90B5E0B9", hash_generated_field = "DDDC8C4616BE00F788B917447806BD91")

    private static final int[] DESCENDANT_FOCUSABILITY_FLAGS = {FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS,
                    FOCUS_BLOCK_DESCENDANTS};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "5666C3D62FF07B134BC6617531F77464", hash_generated_field = "C4207E2A7E9C2242EFAB0A51AF1D91BF")

    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "DDACBD94DD1CDF62E81361791F53DA87", hash_generated_field = "F04CB98B3B159E26FDEE9BC7D5B07159")

    private static final int FLAG_SPLIT_MOTION_EVENTS = 0x200000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "2D700E90C54045822898F506782662B3", hash_generated_field = "3C5BFED90B89800455E7BCFC3A10AF2B")

    private static final int FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW = 0x400000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "C52B883FD05C47AA69FDA6E1F22F0ABB", hash_generated_field = "BC2E177DD2A895934D9FCE5C86AE3C65")

    public static final int PERSISTENT_NO_CACHE = 0x0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "67A61EDB48651F5C036B3346FBE5FAFA", hash_generated_field = "1F0A8E4978079659E6E30C2BA18617E8")

    public static final int PERSISTENT_ANIMATION_CACHE = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "1EF42E9887D0EA5F316904FD3B9AB251", hash_generated_field = "F00BF7A2C158735CE5A6638A662B5EBF")

    public static final int PERSISTENT_SCROLLING_CACHE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "7C696FAA76DB6EC3A8EDD78551D1B467", hash_generated_field = "8CC8945E637E7193338DBF39D6D6A84A")

    public static final int PERSISTENT_ALL_CACHES = 0x3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "BC7469E2246471A573E63558ACC0C8ED", hash_generated_field = "D9383B91357843498670D009FA939F13")

    protected static final int CLIP_TO_PADDING_MASK = FLAG_CLIP_TO_PADDING | FLAG_PADDING_NOT_NULL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "7A53C3B2EA29B34F35552312F91C5969", hash_generated_field = "FB112635D30DBDCA6CB17000D85722CA")

    private static final int CHILD_LEFT_INDEX = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "D45F5D9EC95E07AC6931C434FF8D7294", hash_generated_field = "74187AE3BE9B2F6F3B52043634C8CEF0")

    private static final int CHILD_TOP_INDEX = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "89DFE4348E5AA246A9F1E32325C98608", hash_generated_field = "406B673032561F95D3A3CE9567EB9D07")

    private static final int ARRAY_INITIAL_CAPACITY = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:53.557 -0400", hash_original_field = "4333C5B7C7DF62BB1C21C6CF44CB4E1E", hash_generated_field = "97400031D7E61FBA03291EAA57490BB7")

    private static final int ARRAY_CAPACITY_INCREMENT = 12;
}

