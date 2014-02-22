package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashSet;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;

import com.android.internal.util.Predicate;

public abstract class ViewGroup extends View implements ViewParent, ViewManager {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static MotionEvent obtainMotionEventNoHistoryOrSelf(MotionEvent event){
		// Original method
		/*
		{
        if (event.getHistorySize() == 0) {
            return event;
        }
        return MotionEvent.obtainNoHistory(event);
    }
		*/
		return null;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean canViewReceivePointerEvents(View child){
		// Original method
		/*
		{
        return (child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                || child.getAnimation() != null;
    }
		*/
		return false;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public static int getChildMeasureSpec(int spec, int padding, int childDimension){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return 0;
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.347 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.403 -0500", hash_original_field = "13F019B6D0BD7D9D0703E2B237A3B1EA", hash_generated_field = "50FC822A7AE37AF015DC84622125EE55")

    // Set by default
    private static final int FLAG_CLIP_CHILDREN = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.406 -0500", hash_original_field = "3D5D9FB8A4AA2B7F8FD0F90FF472D810", hash_generated_field = "CA87D7C8F48F91A593020B6F702439A8")

    // Set by default
    private static final int FLAG_CLIP_TO_PADDING = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.408 -0500", hash_original_field = "18C86B99F6A1EC9908EB4CD5C3B311BC", hash_generated_field = "2E3C5A0075D0510FE29ABFB4DF15325D")

    // a child needs to be invalidated and FLAG_OPTIMIZE_INVALIDATE is set
    private static final int FLAG_INVALIDATE_REQUIRED  = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.411 -0500", hash_original_field = "88316B5C4BB87CED2C150D0277228CE7", hash_generated_field = "B26C30228855373F2358E1738754788D")

    private static final int FLAG_RUN_ANIMATION = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.413 -0500", hash_original_field = "ED8F5D7C6F3165312C5E15A7E3EAEFC1", hash_generated_field = "59964DEB624931D50B67CE7F72C07D0C")

    // animation is over
    // Set by default
    private static final int FLAG_ANIMATION_DONE = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.416 -0500", hash_original_field = "E5F69CB18414C6FDE4F67DCA446E6C51", hash_generated_field = "2219482AB39382EBBBD98AD9D10B8ED0")

    // to clip it, even if FLAG_CLIP_TO_PADDING is set
    private static final int FLAG_PADDING_NOT_NULL = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.419 -0500", hash_original_field = "B5ED86A8877B523F9DC4C769428108AC", hash_generated_field = "45B1E5E2350EEA307A665FB1B154290A")

    // Set by default
    private static final int FLAG_ANIMATION_CACHE = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.421 -0500", hash_original_field = "685D7150EBA18C3DAC7B36F9A80D4D8A", hash_generated_field = "1015C704EA23BF29DDD82E1DD4A57746")

    // layout animation; this avoid clobbering the hierarchy
    // Automatically set when the layout animation starts, depending on the animation's
    // characteristics
    private static final int FLAG_OPTIMIZE_INVALIDATE = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.425 -0500", hash_original_field = "86EF465BA21EC60D90ADA744E5846704", hash_generated_field = "3403A038D2CECBA0DA69E8CF8F169A1F")

    private static final int FLAG_CLEAR_TRANSFORMATION = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.427 -0500", hash_original_field = "85209405C9154D16BB06372A4F52B5AB", hash_generated_field = "99BC70E52DA67E3BF02F00A68CE445B3")

    // the children's Bitmap caches if necessary
    // This flag is set when the layout animation is over (after FLAG_ANIMATION_DONE is set)
    private static final int FLAG_NOTIFY_ANIMATION_LISTENER = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.430 -0500", hash_original_field = "CFE107230B0A5F74E59AEFC8E79C062D", hash_generated_field = "32BC669C68D09844C7CB0B0C44FE2F3B")

    protected static final int FLAG_USE_CHILD_DRAWING_ORDER = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.433 -0500", hash_original_field = "D7CF553BE23033E30C3916B9A763369A", hash_generated_field = "A86E922C6C59CFE079F5D7DA8B15BF89")

    protected static final int FLAG_SUPPORT_STATIC_TRANSFORMATIONS = 0x800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.435 -0500", hash_original_field = "F79D45F6688D2CD7200BB93CC1BDFD62", hash_generated_field = "D4A2F61398DF7E7DB89A495F83ACD051")

    // 1.0 and set it in mCachePaint
    private static final int FLAG_ALPHA_LOWER_THAN_ONE = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.437 -0500", hash_original_field = "3C4A73B67E84852DB4B7524C5C599D4F", hash_generated_field = "4188882F32441AE2DC85E12EAB3E6C82")

    private static final int FLAG_ADD_STATES_FROM_CHILDREN = 0x2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.440 -0500", hash_original_field = "DA0B49FB1EF99634331D505C1F660D21", hash_generated_field = "13DA24EF090D074E119DCC3C5BD90BA8")

    private static final int FLAG_ALWAYS_DRAWN_WITH_CACHE = 0x4000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.443 -0500", hash_original_field = "A04B34A282935E3010BA52C0439941EF", hash_generated_field = "AB5153FDF753CE74CA032ECE6BC04442")

    private static final int FLAG_CHILDREN_DRAWN_WITH_CACHE = 0x8000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.446 -0500", hash_original_field = "BE3EF9FDB4458B3F6DC7807A95CD09A3", hash_generated_field = "3A30818F90BA1EF84CA7AED25A16A1B7")

    private static final int FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE = 0x10000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.449 -0500", hash_original_field = "CA845754B5F1EFDD47B99105300BEE95", hash_generated_field = "4836095EA9CD6F4C22D5505B63A65920")

    private static final int FLAG_MASK_FOCUSABILITY = 0x60000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.451 -0500", hash_original_field = "A8FE08566D55C62AA39FE9A7166F48D9", hash_generated_field = "BD96D757F41BA0229D767BD84AB7642D")

    public static final int FOCUS_BEFORE_DESCENDANTS = 0x20000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.454 -0500", hash_original_field = "96D7CAD7CBDFBA881E2D8700156E4250", hash_generated_field = "CD9C40718F19AA89DFB0F2B888272D33")

    public static final int FOCUS_AFTER_DESCENDANTS = 0x40000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.457 -0500", hash_original_field = "050A6D10234F31D8649B35277C4BC35E", hash_generated_field = "5CE7A6F853A9C0B36CFE406D68F2F862")

    public static final int FOCUS_BLOCK_DESCENDANTS = 0x60000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.459 -0500", hash_original_field = "9EF30DFB756BA4CB46172DC4CECA6884", hash_generated_field = "DDDC8C4616BE00F788B917447806BD91")

    private static final int[] DESCENDANT_FOCUSABILITY_FLAGS =
            {FOCUS_BEFORE_DESCENDANTS, FOCUS_AFTER_DESCENDANTS,
                    FOCUS_BLOCK_DESCENDANTS};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.462 -0500", hash_original_field = "1A047A38FB009D42EBEC998AE42D5F1D", hash_generated_field = "C4207E2A7E9C2242EFAB0A51AF1D91BF")

    protected static final int FLAG_DISALLOW_INTERCEPT = 0x80000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.465 -0500", hash_original_field = "E653E24E9F1CAFDE345F25B8EA2A9976", hash_generated_field = "F04CB98B3B159E26FDEE9BC7D5B07159")

    private static final int FLAG_SPLIT_MOTION_EVENTS = 0x200000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.468 -0500", hash_original_field = "9C1B9161B53671E4AFA825DA0D9A6D29", hash_generated_field = "3C5BFED90B89800455E7BCFC3A10AF2B")

    private static final int FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW = 0x400000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.473 -0500", hash_original_field = "8C3C39248D17684741EEDA5661BDD37F", hash_generated_field = "BC2E177DD2A895934D9FCE5C86AE3C65")

    public static final int PERSISTENT_NO_CACHE = 0x0;
    
    private class MyTransitionListener implements LayoutTransition.TransitionListener {
        
        public MyTransitionListener(ViewGroup viewGroup) {

        }

	    @Override
	    public void startTransition(LayoutTransition transition, ViewGroup container,
            View view, int transitionType) {
		        if (transitionType == LayoutTransition.DISAPPEARING) {
		            startViewTransition(view);
		        }
		    }
	
	    @Override
	    public void endTransition(LayoutTransition transition, ViewGroup container,
	            View view, int transitionType) {
	        if (mLayoutSuppressed && !transition.isChangingLayout()) {
	            requestLayout();
	            mLayoutSuppressed = false;
	        }
	        if (transitionType == LayoutTransition.DISAPPEARING && mTransitioningViews != null) {
	            endViewTransition(view);
	        }
	    }
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.475 -0500", hash_original_field = "14E1455F5C04055E921D6104A3B4B060", hash_generated_field = "1F0A8E4978079659E6E30C2BA18617E8")

    public static final int PERSISTENT_ANIMATION_CACHE = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.478 -0500", hash_original_field = "362266F22042085BB0BBCA6D44578423", hash_generated_field = "F00BF7A2C158735CE5A6638A662B5EBF")

    public static final int PERSISTENT_SCROLLING_CACHE = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.480 -0500", hash_original_field = "1FE46760186A94E884BFE4BD71A5D590", hash_generated_field = "8CC8945E637E7193338DBF39D6D6A84A")

    public static final int PERSISTENT_ALL_CACHES = 0x3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.483 -0500", hash_original_field = "C4B307807978099E468BC5F8A95AA132", hash_generated_field = "D9383B91357843498670D009FA939F13")

    protected static final int CLIP_TO_PADDING_MASK = FLAG_CLIP_TO_PADDING | FLAG_PADDING_NOT_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.485 -0500", hash_original_field = "F5E67098B2EA6D1F3D6B7FC1B0E1D883", hash_generated_field = "FB112635D30DBDCA6CB17000D85722CA")

    private static final int CHILD_LEFT_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.487 -0500", hash_original_field = "CFADEB90183B215D5B953475BCEE4C38", hash_generated_field = "74187AE3BE9B2F6F3B52043634C8CEF0")

    private static final int CHILD_TOP_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.497 -0500", hash_original_field = "E4258241F3A2DA91326F00C23DC003E8", hash_generated_field = "406B673032561F95D3A3CE9567EB9D07")

    private static final int ARRAY_INITIAL_CAPACITY = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.501 -0500", hash_original_field = "599B24EAED31795B97E528F2C6F15622", hash_generated_field = "97400031D7E61FBA03291EAA57490BB7")

    private static final int ARRAY_CAPACITY_INCREMENT = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.349 -0500", hash_original_field = "4206688CBBE4A23BD7618B2E268000F0", hash_generated_field = "99875A35D62FD939298A601A9F7DF5FD")

    protected ArrayList<View> mDisappearingChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.352 -0500", hash_original_field = "F8AA800937407072EB5CC33824E49D48", hash_generated_field = "506B0E011CD70741D050BF2EE44FE356")

    protected OnHierarchyChangeListener mOnHierarchyChangeListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.354 -0500", hash_original_field = "7A58FD24DE9D6774ADC5C63B057DB6BC", hash_generated_field = "A4B16D4F5B8759534D19F2BBB80216EB")

    private View mFocused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.357 -0500", hash_original_field = "2749143931496FFE1BCCD4A16FB75A1C", hash_generated_field = "89EF5CAB67B25E4FDD40BCDFBB6E3EB9")

    private final Transformation mChildTransformation = new Transformation();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.360 -0500", hash_original_field = "208336EABE878987A54F3815F9C8BA3E", hash_generated_field = "0E43FE3464FE8F2B4A13FAF73F9FFA99")

    private RectF mInvalidateRegion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.362 -0500", hash_original_field = "A749AD7C58055595A06BCEC152991B46", hash_generated_field = "1A258D5E9E5687B9DA556AF87EE040D3")

    private Transformation mInvalidationTransformation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.365 -0500", hash_original_field = "025092BC7B1A6638564A2FBB4D620E8D", hash_generated_field = "278869ACFDD76183C8D171CD9E8010F4")

    private View mCurrentDragView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.367 -0500", hash_original_field = "67EAB2EB0D6AD382BAA8EFF4A958A9F9", hash_generated_field = "4260837AC154FE88E7ECE0B0D933BD38")

    private DragEvent mCurrentDrag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.369 -0500", hash_original_field = "7BAE444B5CF96C60FEAE733487C0CCDC", hash_generated_field = "7C6A42655A4DC2D4BF46B4F9A41E01BC")

    private HashSet<View> mDragNotifiedChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.372 -0500", hash_original_field = "53ECF8DCF25223C84D42AFBE0B68318D", hash_generated_field = "B40634C8F85313CD4FF766F9BA270DF1")

    private boolean mChildAcceptsDrag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.375 -0500", hash_original_field = "52324A07963D8237656B91693AFE3D8D", hash_generated_field = "ABDC85F272489DAB145CE0275A2DB3B6")

    private final PointF mLocalPoint = new PointF();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.377 -0500", hash_original_field = "4AD6779ED9C529192B7881087F4756FF", hash_generated_field = "9303037DA96D3F26E2BF546299C3658E")

    private LayoutAnimationController mLayoutAnimationController;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.380 -0500", hash_original_field = "595B1C8ABC7F3DF13846FE478A7AAC9C", hash_generated_field = "FE6F2E4A779D16D38F8BBFCAC393C76B")

    private Animation.AnimationListener mAnimationListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.383 -0500", hash_original_field = "FA50BC013B8A95CEAE5B54ADBCAA9D99", hash_generated_field = "E7D785992A22A7F38809AD101B810276")

    private TouchTarget mFirstTouchTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.385 -0500", hash_original_field = "7B32C44226AF52F40C71D7088A481FC3", hash_generated_field = "A29A2DA0312D9EE090BC48B3458B8632")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    @ViewDebug.ExportedProperty(category = "events")
    private long mLastTouchDownTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.388 -0500", hash_original_field = "98910E1688BA8C8EB53A5B5DC74BA87D", hash_generated_field = "8B2D270E66117CC663F28DDCFB87BA4F")

    @ViewDebug.ExportedProperty(category = "events")
    private int mLastTouchDownIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.390 -0500", hash_original_field = "89004E7C506362C70A208C251E434846", hash_generated_field = "4CA82440F2A0B548108575FF9859A086")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    @ViewDebug.ExportedProperty(category = "events")
    private float mLastTouchDownX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.393 -0500", hash_original_field = "765212F47CE88B8FF6159A57B2719E0F", hash_generated_field = "F4574986D2BBC08122BD509305467BC4")

    @SuppressWarnings({"FieldCanBeLocal", "UnusedDeclaration"})
    @ViewDebug.ExportedProperty(category = "events")
    private float mLastTouchDownY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.395 -0500", hash_original_field = "9F90F6177146A05650C3671F36EBCFD5", hash_generated_field = "83699357E56161C7075C4097A1612631")

    // The hover targets are children which have received ACTION_HOVER_ENTER.
    // They might not have actually handled the hover event, but we will
    // continue sending hover events to them as long as the pointer remains over
    // their bounds and the view group does not intercept hover.
    private HoverTarget mFirstHoverTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.397 -0500", hash_original_field = "ABE66CFA7ECBE841FCB93BBA784C6B0C", hash_generated_field = "6FF8A6E27A11EB4AAE4FF5B808173895")

    // It might not have actually handled the hover event.
    private boolean mHoveredSelf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.401 -0500", hash_original_field = "589F8814D380AF88CC613646720CCAC5", hash_generated_field = "0ABD90AE9099E56BCD9A23A2BFDD9586")

    protected int mGroupFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.470 -0500", hash_original_field = "D2799CF227E532824D97FE061BD3DB9E", hash_generated_field = "5B77DDDB5E53D20BC8C371537F9D6155")

    protected int mPersistentDrawingCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.490 -0500", hash_original_field = "EC737C9FACD95789AC1BCBEC64B5A87D", hash_generated_field = "7CF7769EE949355835082685E98C8324")

    private View[] mChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.492 -0500", hash_original_field = "46B842DC2CADFDAF8FCD8C8D1E1280B5", hash_generated_field = "E1E9F49BB4BA89D6828871D94E042A14")

    // considered as children

    private boolean mLayoutSuppressed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.495 -0500", hash_original_field = "617F5F6F66570FF6D60BEA8FC63B997A", hash_generated_field = "A777A0928665A4F1E7F4EF71A2259E60")

    private int mChildrenCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.503 -0500", hash_original_field = "BAE942851666D4C67E0DD8FFE347AE23", hash_generated_field = "4229E0DF467153CF57F65AC95B02B5E6")

    private Paint mCachePaint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.505 -0500", hash_original_field = "F2A416BA26E230C7546A6175176D83F1", hash_generated_field = "E5047FAB01E832F0446529905C5EC963")

    private LayoutTransition mTransition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.508 -0500", hash_original_field = "5685128C4C87EEE11A00B9E663BFDE17", hash_generated_field = "C2857FB0C2E3A83619C0401DBCDCDF19")

    // being removed that should not actually be removed from the parent yet because they are
    // being animated.
    private ArrayList<View> mTransitioningViews;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.511 -0500", hash_original_field = "5F27A9061627C68C7683FA7F7E9A673B", hash_generated_field = "7F513050F6CA8BB769661E939DCDE297")

    // views during a transition when they otherwise would have become gone/invisible
    private ArrayList<View> mVisibilityChangingChildren;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.513 -0500", hash_original_field = "FEEE716D6DFF4AE5C56430F95DDC8AA7", hash_generated_field = "6EF80FC61B331A8C0C9A860633C8D76D")

    @ViewDebug.ExportedProperty(category = "drawing")
    private boolean mDrawLayers = true;

    private LayoutTransition.TransitionListener mLayoutTransitionListener = new MyTransitionListener(this);

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.516 -0500", hash_original_method = "B03ADF87A05C955E785D82B4A9B527B3", hash_generated_method = "2535FABE5BBE40293AF3CA446AE00E22")
    
public ViewGroup(Context context) {
        super(context);
        initViewGroup();
    }
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public ViewGroup(Context context, AttributeSet attrs){
		super(context, attrs);
		initViewGroup();
		/*
		initFromAttributes(context, attrs);
		*/
	}
    
	@DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    public ViewGroup(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);// Taint tracked in super class, View.
		initViewGroup();
		/*
		initFromAttributes(context, attrs);
		*/
	}
	
	@Override
	public void droidsafeCallbackHook() {
	    super.droidsafeCallbackHook();
	    this.onRequestFocusInDescendants(DSUtils.FAKE_INT, new Rect());
	    this.onRequestSendAccessibilityEvent(this, new AccessibilityEvent(DSUtils.FAKE_INT));
	}
    
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void initViewGroup(){
		// Original method
		/*
		{
        setFlags(WILL_NOT_DRAW, DRAW_MASK);
        mGroupFlags |= FLAG_CLIP_CHILDREN;
        mGroupFlags |= FLAG_CLIP_TO_PADDING;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        mGroupFlags |= FLAG_ANIMATION_CACHE;
        mGroupFlags |= FLAG_ALWAYS_DRAWN_WITH_CACHE;
        if (mContext.getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.HONEYCOMB) {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        }
        setDescendantFocusability(FOCUS_BEFORE_DESCENDANTS);
        mChildren = new View[ARRAY_INITIAL_CAPACITY];
        mChildrenCount = 0;
        mPersistentDrawingCache = PERSISTENT_SCROLLING_CACHE;
    }
		*/
		//Return nothing
	    mChildren = new View[ARRAY_INITIAL_CAPACITY];
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void initFromAttributes(Context context, AttributeSet attrs){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(category="focus",mapping={@ViewDebug.IntToString(from=FOCUS_BEFORE_DESCENDANTS,to="FOCUS_BEFORE_DESCENDANTS"),@ViewDebug.IntToString(from=FOCUS_AFTER_DESCENDANTS,to="FOCUS_AFTER_DESCENDANTS"),@ViewDebug.IntToString(from=FOCUS_BLOCK_DESCENDANTS,to="FOCUS_BLOCK_DESCENDANTS")}) public int getDescendantFocusability(){
		// Original method
		/*
		{
        return mGroupFlags & FLAG_MASK_FOCUSABILITY;
    }
		*/
		return 0;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setDescendantFocusability(int focusability){
		// Original method
		/*
		{
        switch (focusability) {
            case FOCUS_BEFORE_DESCENDANTS:
            case FOCUS_AFTER_DESCENDANTS:
            case FOCUS_BLOCK_DESCENDANTS:
                break;
            default:
                throw new IllegalArgumentException("must be one of FOCUS_BEFORE_DESCENDANTS, "
                        + "FOCUS_AFTER_DESCENDANTS, FOCUS_BLOCK_DESCENDANTS");
        }
        mGroupFlags &= ~FLAG_MASK_FOCUSABILITY;
        mGroupFlags |= (focusability & FLAG_MASK_FOCUSABILITY);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override void handleFocusGainInternal(int direction, Rect previouslyFocusedRect){
		// Original method
		/*
		{
        if (mFocused != null) {
            mFocused.unFocus();
            mFocused = null;
        }
        super.handleFocusGainInternal(direction, previouslyFocusedRect);
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void requestChildFocus(View child, View focused){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " requestChildFocus()");
        }
        if (getDescendantFocusability() == FOCUS_BLOCK_DESCENDANTS) {
            return;
        }
        */
        super.unFocus();
        if (mFocused != child) {
            if (mFocused != null) {
                mFocused.unFocus();
            }
            mFocused = child;
        }
        if (mParent != null) {
            mParent.requestChildFocus(this, focused);
        }
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void focusableViewAvailable(View v){
		// Original method
		/*
		{
        if (mParent != null
                && (getDescendantFocusability() != FOCUS_BLOCK_DESCENDANTS)
                && !(isFocused() && getDescendantFocusability() != FOCUS_AFTER_DESCENDANTS)) {
            mParent.focusableViewAvailable(v);
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified("callback modeled")
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean showContextMenuForChild(View originalView){
		// Original method
        return mParent != null && mParent.showContextMenuForChild(originalView);
	}

    @DSVerified("callback modeled")
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public ActionMode startActionModeForChild(View originalView, ActionMode.Callback callback){
        return mParent != null ? mParent.startActionModeForChild(originalView, callback) : null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public View focusSearch(View focused, int direction){
		// Original method
		/*
		{
        if (isRootNamespace()) {
            return FocusFinder.getInstance().findNextFocus(this, focused, direction);
        } else if (mParent != null) {
            return mParent.focusSearch(focused, direction);
        }
        return null;
    }
		*/
		return null;
	}

    /**
     * {@inheritDoc}
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.552 -0500", hash_original_method = "1A209ACB79681B08302166E2C48344A2", hash_generated_method = "4FC7A971315AD74C0142BA77AB447A9A")
    @DSVerified
public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
        return false;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSVerified
    public boolean requestSendAccessibilityEvent(View child, AccessibilityEvent event){
		// Original method
        ViewParent parent = getParent();
        if (parent == null) {
            return false;
        }
        final boolean propagate = onRequestSendAccessibilityEvent(child, event);
        if (!propagate) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this, event);
	}
    
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public boolean onRequestSendAccessibilityEvent(View child, AccessibilityEvent event){
		// Original method
		/*
		{
        if (mAccessibilityDelegate != null) {
            return mAccessibilityDelegate.onRequestSendAccessibilityEvent(this, child, event);
        } else {
            return onRequestSendAccessibilityEventInternal(child, event);
        }
    }
		*/
		return false;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean onRequestSendAccessibilityEventInternal(View child, AccessibilityEvent event){
		// Original method
		/*
		{
        return true;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public boolean dispatchUnhandledMove(View focused, int direction){
		// Original method
		/*
		{
        return mFocused != null &&
                mFocused.dispatchUnhandledMove(focused, direction);
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void clearChildFocus(View child){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " clearChildFocus()");
        }
        mFocused = null;
        if (mParent != null) {
            mParent.clearChildFocus(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public void clearFocus(){
		// Original method
		/*
		{
        super.clearFocus();
        if (mFocused != null) {
            mFocused.clearFocus();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override void unFocus(){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " unFocus()");
        }
        super.unFocus();
        if (mFocused != null) {
            mFocused.unFocus();
        }
        mFocused = null;
    }
		*/
		//Return nothing
	}

    /**
     * Returns the focused child of this view, if any. The child may have focus
     * or contain focus.
     *
     * @return the focused child or null.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.572 -0500", hash_original_method = "F6AEE91365C496A95D4F4B1572422CF5", hash_generated_method = "F3AEBDF30A52AEF2B82CAA1050A37F68")
    
public View getFocusedChild() {
        return mFocused;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public boolean hasFocus(){
		// Original method
		/*
		{
        return (mPrivateFlags & FOCUSED) != 0 || mFocused != null;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override public View findFocus(){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println("Find focus in " + this + ": flags="
                    + isFocused() + ", child=" + mFocused);
        }
        if (isFocused()) {
            return this;
        }
        if (mFocused != null) {
            return mFocused.findFocus();
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public boolean hasFocusable(){
		// Original method
		/*
		{
        if ((mViewFlags & VISIBILITY_MASK) != VISIBLE) {
            return false;
        }
        if (isFocusable()) {
            return true;
        }
        final int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != FOCUS_BLOCK_DESCENDANTS) {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            for (int i = 0; i < count; i++) {
                final View child = children[i];
                if (child.hasFocusable()) {
                    return true;
                }
            }
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public void addFocusables(ArrayList<View> views, int direction){
		// Original method
        addFocusables(views, direction, FOCUSABLES_TOUCH_MODE);
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public void addFocusables(ArrayList<View> views, int direction, int focusableMode){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
        for (View view: views) {
            view.onFocusChanged(false, DSUtils.FAKE_INT, new Rect());
        }
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public void findViewsWithText(ArrayList<View> outViews, CharSequence text, int flags){
		// Original method
		/*
		{
        super.findViewsWithText(outViews, text, flags);
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < childrenCount; i++) {
            View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    && (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                child.findViewsWithText(outViews, text, flags);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override View findViewByAccessibilityIdTraversal(int accessibilityId){
		// Original method
		/*
		{
        View foundView = super.findViewByAccessibilityIdTraversal(accessibilityId);
        if (foundView != null) {
            return foundView;
        }
        final int childrenCount = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < childrenCount; i++) {
            View child = children[i];
            foundView = child.findViewByAccessibilityIdTraversal(accessibilityId);
            if (foundView != null) {
                return foundView;
            }
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchWindowFocusChanged(boolean hasFocus){
		// Original method
		/*
		{
        super.dispatchWindowFocusChanged(hasFocus);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchWindowFocusChanged(hasFocus);
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public void addTouchables(ArrayList<View> views){
		// Original method
        super.addTouchables(views);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            final View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                child.addTouchables(views);
            }
        }
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchDisplayHint(int hint){
		// Original method
		/*
		{
        super.dispatchDisplayHint(hint);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchDisplayHint(hint);
        }
    }
		*/
		//Return nothing
	}
    
    protected void onChildVisibilityChanged(View child, int visibility){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @Override protected void dispatchVisibilityChanged(View changedView, int visibility){
		// Original method
		/*
		{
        super.dispatchVisibilityChanged(changedView, visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchVisibilityChanged(changedView, visibility);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchWindowVisibilityChanged(int visibility){
		// Original method
		/*
		{
        super.dispatchWindowVisibilityChanged(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchWindowVisibilityChanged(visibility);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchConfigurationChanged(Configuration newConfig){
		// Original method
		/*
		{
        super.dispatchConfigurationChanged(newConfig);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchConfigurationChanged(newConfig);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void recomputeViewAttributes(View child){
		// Original method
		/*
		{
        if (mAttachInfo != null && !mAttachInfo.mRecomputeGlobalAttributes) {
            ViewParent parent = mParent;
            if (parent != null) parent.recomputeViewAttributes(this);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override void dispatchCollectViewAttributes(int visibility){
		// Original method
		/*
		{
        visibility |= mViewFlags&VISIBILITY_MASK;
        super.dispatchCollectViewAttributes(visibility);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchCollectViewAttributes(visibility);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void bringChildToFront(View child){
		// Original method
		/*
		{
        int index = indexOfChild(child);
        if (index >= 0) {
            removeFromArray(index);
            addInArray(child, mChildrenCount);
            child.mParent = this;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public boolean dispatchDragEvent(DragEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    View findFrontmostDroppableChildAt(float x, float y, PointF outLocalPoint){
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = count - 1; i >= 0; i--) {
            final View child = children[i];
            if (!child.canAcceptDrag()) {
                continue;
            }
            if (isTransformedTouchPointInView(x, y, child, outLocalPoint)) {
                return child;
            }
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean notifyChildOfDrag(View child){
		// Original method
		/*
		{
        if (ViewDebug.DEBUG_DRAG) {
            Log.d(View.VIEW_LOG_TAG, "Sending drag-started to view: " + child);
        }
        boolean canAccept = false;
        if (! mDragNotifiedChildren.contains(child)) {
            mDragNotifiedChildren.add(child);
            canAccept = child.dispatchDragEvent(mCurrentDrag);
            if (canAccept && !child.canAcceptDrag()) {
                child.mPrivateFlags2 |= View.DRAG_CAN_ACCEPT;
                child.refreshDrawableState();
            }
        }
        return canAccept;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchSystemUiVisibilityChanged(int visible){
		// Original method
		/*
		{
        super.dispatchSystemUiVisibilityChanged(visible);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i=0; i <count; i++) {
            final View child = children[i];
            child.dispatchSystemUiVisibilityChanged(visible);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override void updateLocalSystemUiVisibility(int localValue, int localChanges){
		// Original method
		/*
		{
        super.updateLocalSystemUiVisibility(localValue, localChanges);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i=0; i <count; i++) {
            final View child = children[i];
            child.updateLocalSystemUiVisibility(localValue, localChanges);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public boolean dispatchKeyEventPreIme(KeyEvent event){
		// Original method
		/*
		{
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            return super.dispatchKeyEventPreIme(event);
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            return mFocused.dispatchKeyEventPreIme(event);
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public boolean dispatchKeyEvent(KeyEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onKeyEvent(event, 1);
        }
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            if (super.dispatchKeyEvent(event)) {
                return true;
            }
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            if (mFocused.dispatchKeyEvent(event)) {
                return true;
            }
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public boolean dispatchKeyShortcutEvent(KeyEvent event){
		// Original method
		/*
		{
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            return super.dispatchKeyShortcutEvent(event);
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            return mFocused.dispatchKeyShortcutEvent(event);
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public boolean dispatchTrackballEvent(MotionEvent event){
		// Original method
		/*
		{
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onTrackballEvent(event, 1);
        }
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            if (super.dispatchTrackballEvent(event)) {
                return true;
            }
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            if (mFocused.dispatchTrackballEvent(event)) {
                return true;
            }
        }
        if (mInputEventConsistencyVerifier != null) {
            mInputEventConsistencyVerifier.onUnhandledEvent(event, 1);
        }
        return false;
    }
		*/
		return false;
	}
    
    @SuppressWarnings({"ConstantConditions"}) @Override protected boolean dispatchHoverEvent(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @Override protected boolean hasHoveredChild(){
		// Original method
		/*
		{
        return mFirstHoverTarget != null;
    }
		*/
		return false;
	}

    /**
     * Implement this method to intercept hover events before they are handled
     * by child views.
     * <p>
     * This method is called before dispatching a hover event to a child of
     * the view group or to the view group's own {@link #onHoverEvent} to allow
     * the view group a chance to intercept the hover event.
     * This method can also be used to watch all pointer motions that occur within
     * the bounds of the view group even when the pointer is hovering over
     * a child of the view group rather than over the view group itself.
     * </p><p>
     * The view group can prevent its children from receiving hover events by
     * implementing this method and returning <code>true</code> to indicate
     * that it would like to intercept hover events.  The view group must
     * continuously return <code>true</code> from {@link #onInterceptHoverEvent}
     * for as long as it wishes to continue intercepting hover events from
     * its children.
     * </p><p>
     * Interception preserves the invariant that at most one view can be
     * hovered at a time by transferring hover focus from the currently hovered
     * child to the view group or vice-versa as needed.
     * </p><p>
     * If this method returns <code>true</code> and a child is already hovered, then the
     * child view will first receive a hover exit event and then the view group
     * itself will receive a hover enter event in {@link #onHoverEvent}.
     * Likewise, if this method had previously returned <code>true</code> to intercept hover
     * events and instead returns <code>false</code> while the pointer is hovering
     * within the bounds of one of a child, then the view group will first receive a
     * hover exit event in {@link #onHoverEvent} and then the hovered child will
     * receive a hover enter event.
     * </p><p>
     * The default implementation always returns false.
     * </p>
     *
     * @param event The motion event that describes the hover.
     * @return True if the view group would like to intercept the hover event
     * and prevent its children from receiving it.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.656 -0500", hash_original_method = "039A9532EA6933A3F4F8681C30CC9E2B", hash_generated_method = "78BED127090E90B49508C9F21D70CD03")
    
public boolean onInterceptHoverEvent(MotionEvent event) {
        return false;
    }
    
    @Override protected boolean dispatchGenericPointerEvent(MotionEvent event){
		// Original method
		/*
		{
        final int childrenCount = mChildrenCount;
        if (childrenCount != 0) {
            final View[] children = mChildren;
            final float x = event.getX();
            final float y = event.getY();
            for (int i = childrenCount - 1; i >= 0; i--) {
                final View child = children[i];
                if (!canViewReceivePointerEvents(child)
                        || !isTransformedTouchPointInView(x, y, child, null)) {
                    continue;
                }
                if (dispatchTransformedGenericPointerEvent(event, child)) {
                    return true;
                }
            }
        }
        return super.dispatchGenericPointerEvent(event);
    }
		*/
		return false;
	}
    
    @Override protected boolean dispatchGenericFocusedEvent(MotionEvent event){
		// Original method
		/*
		{
        if ((mPrivateFlags & (FOCUSED | HAS_BOUNDS)) == (FOCUSED | HAS_BOUNDS)) {
            return super.dispatchGenericFocusedEvent(event);
        } else if (mFocused != null && (mFocused.mPrivateFlags & HAS_BOUNDS) == HAS_BOUNDS) {
            return mFocused.dispatchGenericMotionEvent(event);
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean dispatchTransformedGenericPointerEvent(MotionEvent event, View child){
		// Original method
		/*
		{
        final float offsetX = mScrollX - child.mLeft;
        final float offsetY = mScrollY - child.mTop;
        boolean handled;
        if (!child.hasIdentityMatrix()) {
            MotionEvent transformedEvent = MotionEvent.obtain(event);
            transformedEvent.offsetLocation(offsetX, offsetY);
            transformedEvent.transform(child.getInverseMatrix());
            handled = child.dispatchGenericMotionEvent(transformedEvent);
            transformedEvent.recycle();
        } else {
            event.offsetLocation(offsetX, offsetY);
            handled = child.dispatchGenericMotionEvent(event);
            event.offsetLocation(-offsetX, -offsetY);
        }
        return handled;
    }
		*/
		return false;
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override public boolean dispatchTouchEvent(MotionEvent ev){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void resetTouchState(){
		// Original method
		/*
		{
        clearTouchTargets();
        resetCancelNextUpFlag(this);
        mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean resetCancelNextUpFlag(View view){
		// Original method
		/*
		{
        if ((view.mPrivateFlags & CANCEL_NEXT_UP_EVENT) != 0) {
            view.mPrivateFlags &= ~CANCEL_NEXT_UP_EVENT;
            return true;
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void clearTouchTargets(){
		// Original method
		/*
		{
        TouchTarget target = mFirstTouchTarget;
        if (target != null) {
            do {
                TouchTarget next = target.next;
                target.recycle();
                target = next;
            } while (target != null);
            mFirstTouchTarget = null;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void cancelAndClearTouchTargets(MotionEvent event){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    private TouchTarget getTouchTarget(View child){
		// Original method
		/*
		{
        for (TouchTarget target = mFirstTouchTarget; target != null; target = target.next) {
            if (target.child == child) {
                return target;
            }
        }
        return null;
    }
		*/
		return null;
	}
    
    private TouchTarget addTouchTarget(View child, int pointerIdBits){
		// Original method
		/*
		{
        TouchTarget target = TouchTarget.obtain(child, pointerIdBits);
        target.next = mFirstTouchTarget;
        mFirstTouchTarget = target;
        return target;
    }
		*/
		return null;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removePointersFromTouchTargets(int pointerIdBits){
		// Original method
		/*
		{
        TouchTarget predecessor = null;
        TouchTarget target = mFirstTouchTarget;
        while (target != null) {
            final TouchTarget next = target.next;
            if ((target.pointerIdBits & pointerIdBits) != 0) {
                target.pointerIdBits &= ~pointerIdBits;
                if (target.pointerIdBits == 0) {
                    if (predecessor == null) {
                        mFirstTouchTarget = next;
                    } else {
                        predecessor.next = next;
                    }
                    target.recycle();
                    target = next;
                    continue;
                }
            }
            predecessor = target;
            target = next;
        }
    }
		*/
		//Return nothing
	}
    
    protected boolean isTransformedTouchPointInView(float x, float y, View child,
            PointF outLocalPoint){
		// Original method
		/*
		{
        float localX = x + mScrollX - child.mLeft;
        float localY = y + mScrollY - child.mTop;
        if (! child.hasIdentityMatrix() && mAttachInfo != null) {
            final float[] localXY = mAttachInfo.mTmpTransformLocation;
            localXY[0] = localX;
            localXY[1] = localY;
            child.getInverseMatrix().mapPoints(localXY);
            localX = localXY[0];
            localY = localXY[1];
        }
        final boolean isInView = child.pointInView(localX, localY);
        if (isInView && outLocalPoint != null) {
            outLocalPoint.set(localX, localY);
        }
        return isInView;
    }
		*/
		return false;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private boolean dispatchTransformedTouchEvent(MotionEvent event, boolean cancel,
            View child, int desiredPointerIdBits){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setMotionEventSplittingEnabled(boolean split){
		// Original method
		/*
		{
        if (split) {
            mGroupFlags |= FLAG_SPLIT_MOTION_EVENTS;
        } else {
            mGroupFlags &= ~FLAG_SPLIT_MOTION_EVENTS;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean isMotionEventSplittingEnabled(){
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_SPLIT_MOTION_EVENTS) == FLAG_SPLIT_MOTION_EVENTS;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept){
		// Original method
		/*
		{
        if (disallowIntercept == ((mGroupFlags & FLAG_DISALLOW_INTERCEPT) != 0)) {
            return;
        }
        if (disallowIntercept) {
            mGroupFlags |= FLAG_DISALLOW_INTERCEPT;
        } else {
            mGroupFlags &= ~FLAG_DISALLOW_INTERCEPT;
        }
        if (mParent != null) {
            mParent.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Implement this method to intercept all touch screen motion events.  This
     * allows you to watch events as they are dispatched to your children, and
     * take ownership of the current gesture at any point.
     *
     * <p>Using this function takes some care, as it has a fairly complicated
     * interaction with {@link View#onTouchEvent(MotionEvent)
     * View.onTouchEvent(MotionEvent)}, and using it requires implementing
     * that method as well as this one in the correct way.  Events will be
     * received in the following order:
     *
     * <ol>
     * <li> You will receive the down event here.
     * <li> The down event will be handled either by a child of this view
     * group, or given to your own onTouchEvent() method to handle; this means
     * you should implement onTouchEvent() to return true, so you will
     * continue to see the rest of the gesture (instead of looking for
     * a parent view to handle it).  Also, by returning true from
     * onTouchEvent(), you will not receive any following
     * events in onInterceptTouchEvent() and all touch processing must
     * happen in onTouchEvent() like normal.
     * <li> For as long as you return false from this function, each following
     * event (up to and including the final up) will be delivered first here
     * and then to the target's onTouchEvent().
     * <li> If you return true from here, you will not receive any
     * following events: the target view will receive the same event but
     * with the action {@link MotionEvent#ACTION_CANCEL}, and all further
     * events will be delivered to your onTouchEvent() method and no longer
     * appear here.
     * </ol>
     *
     * @param ev The motion event being dispatched down the hierarchy.
     * @return Return true to steal motion events from the children and have
     * them dispatched to this ViewGroup through onTouchEvent().
     * The current target will receive an ACTION_CANCEL event, and no further
     * messages will be delivered here.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.709 -0500", hash_original_method = "2FB27FC0FD3119EC0BB03A9B8DB1F75C", hash_generated_method = "2DC6FF14844F7869683F6E3D49AA3DCD")
    
public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public boolean requestFocus(int direction, Rect previouslyFocusedRect){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @SuppressWarnings({"ConstantConditions"}) protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect){
		// Original method
		/*
		{
        int index;
        int increment;
        int end;
        int count = mChildrenCount;
        if ((direction & FOCUS_FORWARD) != 0) {
            index = 0;
            increment = 1;
            end = count;
        } else {
            index = count - 1;
            increment = -1;
            end = -1;
        }
        final View[] children = mChildren;
        for (int i = index; i != end; i += increment) {
            View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                if (child.requestFocus(direction, previouslyFocusedRect)) {
                    return true;
                }
            }
        }
        return false;
    }
		*/
        final View[] children = mChildren;
        for (int i = 0; i != children.length; i ++) {
            View child = children[i];
            if (child.requestFocus(direction, previouslyFocusedRect)) {
                return true;
            }
        }
		return false;
	}
    
    @Override public void dispatchStartTemporaryDetach(){
		// Original method
		/*
		{
        super.dispatchStartTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchStartTemporaryDetach();
        }
    }
		*/
		//Return nothing
	}
    
    @Override public void dispatchFinishTemporaryDetach(){
		// Original method
		/*
		{
        super.dispatchFinishTemporaryDetach();
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchFinishTemporaryDetach();
        }
    }
		*/
		//Return nothing
	}
    
    @Override void dispatchAttachedToWindow(AttachInfo info, int visibility){
		// Original method
		/*
		{
        mGroupFlags |= FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        super.dispatchAttachedToWindow(info, visibility);
        mGroupFlags &= ~FLAG_PREVENT_DISPATCH_ATTACHED_TO_WINDOW;
        visibility |= mViewFlags & VISIBILITY_MASK;
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchAttachedToWindow(info, visibility);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override boolean dispatchPopulateAccessibilityEventInternal(AccessibilityEvent event){
		// Original method
		/*
		{
        boolean handled = super.dispatchPopulateAccessibilityEventInternal(event);
        if (handled) {
            return handled;
        }
        for (int i = 0, count = getChildCount(); i < count; i++) {
            View child = getChildAt(i);
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                handled = getChildAt(i).dispatchPopulateAccessibilityEvent(event);
                if (handled) {
                    return handled;
                }
            }
        }
        return false;
    }
		*/
		return false;
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override void onInitializeAccessibilityNodeInfoInternal(AccessibilityNodeInfo info){
		// Original method
		/*
		{
        super.onInitializeAccessibilityNodeInfoInternal(info);
        for (int i = 0, count = mChildrenCount; i < count; i++) {
            View child = mChildren[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE
                    && (child.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                info.addChild(child);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @Override void dispatchDetachedFromWindow(){
		// Original method
		/*
		{
        cancelAndClearTouchTargets(null);
        mLayoutSuppressed = false;
        mDragNotifiedChildren = null;
        if (mCurrentDrag != null) {
            mCurrentDrag.recycle();
            mCurrentDrag = null;
        }
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            children[i].dispatchDetachedFromWindow();
        }
        super.dispatchDetachedFromWindow();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public void setPadding(int left, int top, int right, int bottom){
		// Original method
		/*
		{
        super.setPadding(left, top, right, bottom);
        if ((mPaddingLeft | mPaddingTop | mPaddingRight | mPaddingBottom) != 0) {
            mGroupFlags |= FLAG_PADDING_NOT_NULL;
        } else {
            mGroupFlags &= ~FLAG_PADDING_NOT_NULL;
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected void dispatchSaveInstanceState(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        super.dispatchSaveInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            View c = children[i];
            if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                c.dispatchSaveInstanceState(container);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    protected void dispatchFreezeSelfOnly(SparseArray<Parcelable> container){
		// Original method
        super.dispatchSaveInstanceState(container);
		//Return nothing
	}
    @DSVerified("Calling/dispatching callbacks")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container){
		// Original method
        super.dispatchRestoreInstanceState(container);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            View c = children[i];
            if ((c.mViewFlags & PARENT_SAVE_DISABLED_MASK) != PARENT_SAVE_DISABLED) {
                c.dispatchRestoreInstanceState(container);
            }
        }
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    protected void dispatchThawSelfOnly(SparseArray<Parcelable> container){
		// Original method
		/*
		{
        super.dispatchRestoreInstanceState(container);
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    protected void setChildrenDrawingCacheEnabled(boolean enabled){
		// Original method
		/*
		{
        if (enabled || (mPersistentDrawingCache & PERSISTENT_ALL_CACHES) != PERSISTENT_ALL_CACHES) {
            final View[] children = mChildren;
            final int count = mChildrenCount;
            for (int i = 0; i < count; i++) {
                children[i].setDrawingCacheEnabled(enabled);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected void onAnimationStart(){
		// Original method
		/*
		{
        super.onAnimationStart();
        if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            final boolean buildCache = !isHardwareAccelerated();
            for (int i = 0; i < count; i++) {
                final View child = children[i];
                if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE) {
                    child.setDrawingCacheEnabled(true);
                    if (buildCache) {
                        child.buildDrawingCache(true);
                    }
                }
            }
            mGroupFlags |= FLAG_CHILDREN_DRAWN_WITH_CACHE;
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected void onAnimationEnd(){
		// Original method
		/*
		{
        super.onAnimationEnd();
        if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                setChildrenDrawingCacheEnabled(false);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @Override Bitmap createSnapshot(Bitmap.Config quality, int backgroundColor, boolean skipChildren){
		// Original method
		/*
		{
        int count = mChildrenCount;
        int[] visibilities = null;
        if (skipChildren) {
            visibilities = new int[count];
            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                visibilities[i] = child.getVisibility();
                if (visibilities[i] == View.VISIBLE) {
                    child.setVisibility(INVISIBLE);
                }
            }
        }
        Bitmap b = super.createSnapshot(quality, backgroundColor, skipChildren);
        if (skipChildren) {
            for (int i = 0; i < count; i++) {
                getChildAt(i).setVisibility(visibilities[i]);
            }
        }
        return b;
    }
		*/
		return null;
	}
    
    @DSVerified
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override protected void dispatchDraw(Canvas canvas){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
        onDraw(canvas);
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    protected int getChildDrawingOrder(int childCount, int i){
		// Original method
		/*
		{
        return i;
    }
		*/
		return 0;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void notifyAnimationListener(){
		// Original method
		/*
		{
        mGroupFlags &= ~FLAG_NOTIFY_ANIMATION_LISTENER;
        mGroupFlags |= FLAG_ANIMATION_DONE;
        if (mAnimationListener != null) {
           final Runnable end = new Runnable() {
               public void run() {
                   mAnimationListener.onAnimationEnd(mLayoutAnimationController.getAnimation());
               }
           };
           post(end);
        }
        if ((mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE) {
            mGroupFlags &= ~FLAG_CHILDREN_DRAWN_WITH_CACHE;
            if ((mPersistentDrawingCache & PERSISTENT_ANIMATION_CACHE) == 0) {
                setChildrenDrawingCacheEnabled(false);
            }
        }
        invalidate(true);
    }
		*/
		//Return nothing
	}
    
    @Override protected void dispatchGetDisplayList(){
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            final View child = children[i];
            if (((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) &&
                    child.hasStaticLayer()) {
                child.mRecreateDisplayList = (child.mPrivateFlags & INVALIDATED) == INVALIDATED;
                child.mPrivateFlags &= ~INVALIDATED;
                child.getDisplayList();
                child.mRecreateDisplayList = false;
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected boolean drawChild(Canvas canvas, View child, long drawingTime){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
        onDraw(canvas);
        child.onDraw(canvas);
		return false;
	}
    
    public void setChildrenLayersEnabled(boolean enabled){
		// Original method
		/*
		{
        if (enabled != mDrawLayers) {
            mDrawLayers = enabled;
            invalidate(true);
            for (int i = 0; i < mChildrenCount; i++) {
                View child = mChildren[i];
                if (child.mLayerType != LAYER_TYPE_NONE) {
                    child.invalidate(true);
                }
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setClipChildren(boolean clipChildren){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_CLIP_CHILDREN, clipChildren);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setClipToPadding(boolean clipToPadding){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_CLIP_TO_PADDING, clipToPadding);
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchSetSelected(boolean selected){
		// Original method
		/*
		{
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].setSelected(selected);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("potential callback called inside method")
    @DSSpec(DSCat.TO_MODEL)
    @Override public void dispatchSetActivated(boolean activated){
		// Original method
		/*
		{
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].setActivated(activated);
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected void dispatchSetPressed(boolean pressed){
		// Original method
		/*
		{
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].setPressed(pressed);
        }
    }
		*/
		//Return nothing
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    protected void setStaticTransformationsEnabled(boolean enabled){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_SUPPORT_STATIC_TRANSFORMATIONS, enabled);
    }
		*/
		//Return nothing
	}

    /**
     * {@inheritDoc}
     *
     * @see #setStaticTransformationsEnabled(boolean)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.805 -0500", hash_original_method = "767004ADA8C3853AF520B9D176A534BE", hash_generated_method = "297B5E541B315BB11D305E485C91D546")
    
protected boolean getChildStaticTransformation(View child, Transformation t) {
        return false;
    }
    
    @Override protected View findViewTraversal(int id){
		// Original method
		/*
		{
        if (id == mID) {
            return this;
        }
        final View[] where = mChildren;
        final int len = mChildrenCount;
        for (int i = 0; i < len; i++) {
            View v = where[i];
            if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                v = v.findViewById(id);
                if (v != null) {
                    return v;
                }
            }
        }
        return null;
    }
		*/
		return null;
	}
    
    @Override protected View findViewWithTagTraversal(Object tag){
		// Original method
		/*
		{
        if (tag != null && tag.equals(mTag)) {
            return this;
        }
        final View[] where = mChildren;
        final int len = mChildrenCount;
        for (int i = 0; i < len; i++) {
            View v = where[i];
            if ((v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                v = v.findViewWithTag(tag);
                if (v != null) {
                    return v;
                }
            }
        }
        return null;
    }
		*/
		return null;
	}
    
    @Override protected View findViewByPredicateTraversal(Predicate<View> predicate, View childToSkip){
		// Original method
		/*
		{
        if (predicate.apply(this)) {
            return this;
        }
        final View[] where = mChildren;
        final int len = mChildrenCount;
        for (int i = 0; i < len; i++) {
            View v = where[i];
            if (v != childToSkip && (v.mPrivateFlags & IS_ROOT_NAMESPACE) == 0) {
                v = v.findViewByPredicate(predicate);
                if (v != null) {
                    return v;
                }
            }
        }
        return null;
    }
		*/
		return null;
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addView(View child){
		// Original method
        addView(child, -1);
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addView(View child, int index){
		// Original method
        LayoutParams params = child.getLayoutParams();
        if (params == null) {
            params = generateDefaultLayoutParams();
            if (params == null) {
                throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
            }
        }
        addView(child, index, params);
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addView(View child, int width, int height){
		// Original method
        final LayoutParams params = generateDefaultLayoutParams();
        params.width = width;
        params.height = height;
        addView(child, -1, params);
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addView(View child, LayoutParams params){
		// Original method
        addView(child, -1, params);
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void addView(View child, int index, LayoutParams params){
		// Original method
		/*
		{
        if (DBG) {
            System.out.println(this + " addView");
        }
        */
        requestLayout();
        invalidate(true);
        addViewInner(child, index, params, false);
		//Return nothing
	}
    
    public void updateViewLayout(View view, ViewGroup.LayoutParams params){
		// Original method
		/*
		{
        if (!checkLayoutParams(params)) {
            throw new IllegalArgumentException("Invalid LayoutParams supplied to " + this);
        }
        if (view.mParent != this) {
            throw new IllegalArgumentException("Given view not a child of " + this);
        }
        view.setLayoutParams(params);
    }
		*/
		//Return nothing
	}
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS) 
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p){
		// Original method
		/*
		{
        return  p != null;
    }
		*/
		return false;
	}

    /**
     * Register a callback to be invoked when a child is added to or removed
     * from this view.
     *
     * @param listener the callback to invoke on hierarchy change
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.836 -0500", hash_original_method = "2EFEB52353D2008493D1621282A03886", hash_generated_method = "DDF708DFA4E0DEC6E8621E6DBC360EE5")
    
public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        mOnHierarchyChangeListener = listener;
    }
    
    protected void onViewAdded(View child){
		// Original method
		/*
		{
        if (mOnHierarchyChangeListener != null) {
            mOnHierarchyChangeListener.onChildViewAdded(this, child);
        }
    }
		*/
		//Return nothing
	}
    
    protected void onViewRemoved(View child){
		// Original method
		/*
		{
        if (mOnHierarchyChangeListener != null) {
            mOnHierarchyChangeListener.onChildViewRemoved(this, child);
        }
    }
		*/
		//Return nothing
	}
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    protected boolean addViewInLayout(View child, int index, LayoutParams params){
		// Original method
        return addViewInLayout(child, index, params, false);
	}

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    protected boolean addViewInLayout(View child, int index, LayoutParams params,
            boolean preventRequestLayout){
		// Original method
        child.mParent = null;
        addViewInner(child, index, params, preventRequestLayout);
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK) | DRAWN;
        return true;
	}
    
    protected void cleanupLayoutState(View child){
		// Original method
		/*
		{
        child.mPrivateFlags &= ~View.FORCE_LAYOUT;
    }
		*/
		//Return nothing
	}
    @DSVerified("Calling/dispatching callbacks")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    private void addViewInner(View child, int index, LayoutParams params,
            boolean preventRequestLayout){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
        //calling attching to window
        child.onAttachedToWindow();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void addInArray(View child, int index){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeFromArray(int index){
		// Original method
		/*
		{
        final View[] children = mChildren;
        if (!(mTransitioningViews != null && mTransitioningViews.contains(children[index]))) {
            children[index].mParent = null;
        }
        final int count = mChildrenCount;
        if (index == count - 1) {
            children[--mChildrenCount] = null;
        } else if (index >= 0 && index < count) {
            System.arraycopy(children, index + 1, children, index, count - index - 1);
            children[--mChildrenCount] = null;
        } else {
            throw new IndexOutOfBoundsException();
        }
        if (mLastTouchDownIndex == index) {
            mLastTouchDownTime = 0;
            mLastTouchDownIndex = -1;
        } else if (mLastTouchDownIndex > index) {
            mLastTouchDownIndex--;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeFromArray(int start, int count){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void bindLayoutAnimation(View child){
		// Original method
		/*
		{
        Animation a = mLayoutAnimationController.getAnimationForView(child);
        child.setAnimation(a);
    }
		*/
		//Return nothing
	}
    
    protected void attachLayoutAnimationParameters(View child,
            LayoutParams params, int index, int count){
		// Original method
		/*
		{
        LayoutAnimationController.AnimationParameters animationParams =
                    params.layoutAnimationParameters;
        if (animationParams == null) {
            animationParams = new LayoutAnimationController.AnimationParameters();
            params.layoutAnimationParameters = animationParams;
        }
        animationParams.count = count;
        animationParams.index = index;
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeView(View view){
		// Original method
        removeViewInternal(view);
        requestLayout();
        invalidate(true);
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeViewInLayout(View view){
		// Original method
		/*
		{
        removeViewInternal(view);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeViewsInLayout(int start, int count){
		// Original method
		/*
		{
        removeViewsInternal(start, count);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeViewAt(int index){
		// Original method
		/*
		{
        removeViewInternal(index, getChildAt(index));
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeViews(int start, int count){
		// Original method
		/*
		{
        removeViewsInternal(start, count);
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeViewInternal(View view){
		// Original method
		/*
		{
        final int index = indexOfChild(view);
        if (index >= 0) {
            removeViewInternal(index, view);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeViewInternal(int index, View view){
		// Original method
		/*
		{
        if (mTransition != null) {
            mTransition.removeChild(this, view);
        }
        boolean clearChildFocus = false;
        if (view == mFocused) {
            view.clearFocusForRemoval();
            clearChildFocus = true;
        }
        if (view.getAnimation() != null ||
                (mTransitioningViews != null && mTransitioningViews.contains(view))) {
            addDisappearingView(view);
        } else if (view.mAttachInfo != null) {
           view.dispatchDetachedFromWindow();
        }
        onViewRemoved(view);
        needGlobalAttributesUpdate(false);
        removeFromArray(index);
        if (clearChildFocus) {
            clearChildFocus(view);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setLayoutTransition(LayoutTransition transition){
		mTransition = transition;  //Preserved
		// Original method
		/*
		{
        if (mTransition != null) {
            mTransition.removeTransitionListener(mLayoutTransitionListener);
        }
        mTransition = transition;
        if (mTransition != null) {
            mTransition.addTransitionListener(mLayoutTransitionListener);
        }
    }
		*/
		//Return nothing
	}

    /**
     * Gets the LayoutTransition object for this ViewGroup. If the LayoutTransition object is
     * not null, changes in layout which occur because of children being added to or removed from
     * the ViewGroup will be animated according to the animations defined in that LayoutTransition
     * object. By default, the transition object is null (so layout changes are not animated).
     *
     * @return LayoutTranstion The LayoutTransition object that will animated changes in layout.
     * A value of <code>null</code> means no transition will run on layout changes.
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.887 -0500", hash_original_method = "33E35321C94CA74A9D9819C2C9739D2F", hash_generated_method = "D32166C13817D13F0BE7A5DE2A5BC037")
    
public LayoutTransition getLayoutTransition() {
        return mTransition;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void removeViewsInternal(int start, int count){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeAllViews(){
		// Original method
		/*
		{
        removeAllViewsInLayout();
        requestLayout();
        invalidate(true);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void removeAllViewsInLayout(){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected void removeDetachedView(View child, boolean animate){
		// Original method
		/*
		{
        if (mTransition != null) {
            mTransition.removeChild(this, child);
        }
        if (child == mFocused) {
            child.clearFocus();
        }
        if ((animate && child.getAnimation() != null) ||
                (mTransitioningViews != null && mTransitioningViews.contains(child))) {
            addDisappearingView(child);
        } else if (child.mAttachInfo != null) {
            child.dispatchDetachedFromWindow();
        }
        onViewRemoved(child);
    }
		*/
		//Return nothing
	}
    
    protected void attachViewToParent(View child, int index, LayoutParams params){
		// Original method
		/*
		{
        child.mLayoutParams = params;
        if (index < 0) {
            index = mChildrenCount;
        }
        addInArray(child, index);
        child.mParent = this;
        child.mPrivateFlags = (child.mPrivateFlags & ~DIRTY_MASK & ~DRAWING_CACHE_VALID) |
                DRAWN | INVALIDATED;
        this.mPrivateFlags |= INVALIDATED;
        if (child.hasFocus()) {
            requestChildFocus(child, child.findFocus());
        }
    }
		*/
		//Return nothing
	}
    
    protected void detachViewFromParent(View child){
		// Original method
		/*
		{
        removeFromArray(indexOfChild(child));
    }
		*/
		//Return nothing
	}
    
    protected void detachViewFromParent(int index){
		// Original method
		/*
		{
        removeFromArray(index);
    }
		*/
		//Return nothing
	}
    
    protected void detachViewsFromParent(int start, int count){
		// Original method
		/*
		{
        removeFromArray(start, count);
    }
		*/
		//Return nothing
	}
    
    protected void detachAllViewsFromParent(){
		// Original method
		/*
		{
        final int count = mChildrenCount;
        if (count <= 0) {
            return;
        }
        final View[] children = mChildren;
        mChildrenCount = 0;
        for (int i = count - 1; i >= 0; i--) {
            children[i].mParent = null;
            children[i] = null;
        }
    }
		*/
		//Return nothing
	}
    
    public final void invalidateChild(View child, final Rect dirty){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    public ViewParent invalidateChildInParent(final int[] location, final Rect dirty){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void offsetDescendantRectToMyCoords(View descendant, Rect rect){
		// Original method
		/*
		{
        offsetRectBetweenParentAndChild(descendant, rect, true, false);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public final void offsetRectIntoDescendantCoords(View descendant, Rect rect){
		// Original method
		/*
		{
        offsetRectBetweenParentAndChild(descendant, rect, false, false);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    void offsetRectBetweenParentAndChild(View descendant, Rect rect,
            boolean offsetFromChildToParent, boolean clipToBounds){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    public void offsetChildrenTopAndBottom(int offset){
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            final View v = children[i];
            v.mTop += offset;
            v.mBottom += offset;
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public boolean getChildVisibleRect(View child, Rect r, android.graphics.Point offset){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override public final void layout(int l, int t, int r, int b){
		// Original method
		/*
		{
        if (mTransition == null || !mTransition.isChangingLayout()) {
            super.layout(l, t, r, b);
        } else {
            mLayoutSuppressed = true;
        }
    }
		*/
		//Return nothing
	}

    /**
     * {@inheritDoc}
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.941 -0500", hash_original_method = "71AA4DA3A86B859FE325E7D3AB99A56D", hash_generated_method = "C9442B2DA782FC842F7449F8B61E3ED6")
    
@Override
    protected abstract void onLayout(boolean changed,
            int l, int t, int r, int b);
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected boolean canAnimate(){
		// Original method
		/*
		{
        return mLayoutAnimationController != null;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void startLayoutAnimation(){
		// Original method
		/*
		{
        if (mLayoutAnimationController != null) {
            mGroupFlags |= FLAG_RUN_ANIMATION;
            requestLayout();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void scheduleLayoutAnimation(){
		// Original method
		/*
		{
        mGroupFlags |= FLAG_RUN_ANIMATION;
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void setLayoutAnimation(LayoutAnimationController controller){
		mLayoutAnimationController = controller;  //Preserved
		// Original method
		/*
		{
        mLayoutAnimationController = controller;
        if (mLayoutAnimationController != null) {
            mGroupFlags |= FLAG_RUN_ANIMATION;
        }
    }
		*/
		//Return nothing
	}

    /**
     * Returns the layout animation controller used to animate the group's
     * children.
     *
     * @return the current animation controller
     */
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:01.954 -0500", hash_original_method = "BD382B237F964A42E5B6E00A5B3A23FD", hash_generated_method = "37C50B8717E377EF6146E93415B76D99")
    
public LayoutAnimationController getLayoutAnimation() {
        return mLayoutAnimationController;
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty public boolean isAnimationCacheEnabled(){
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_ANIMATION_CACHE) == FLAG_ANIMATION_CACHE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setAnimationCacheEnabled(boolean enabled){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_ANIMATION_CACHE, enabled);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @ViewDebug.ExportedProperty(category="drawing") public boolean isAlwaysDrawnWithCacheEnabled(){
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_ALWAYS_DRAWN_WITH_CACHE) == FLAG_ALWAYS_DRAWN_WITH_CACHE;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setAlwaysDrawnWithCacheEnabled(boolean always){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_ALWAYS_DRAWN_WITH_CACHE, always);
    }
		*/
		//Return nothing
	}
    
    @ViewDebug.ExportedProperty(category="drawing") protected boolean isChildrenDrawnWithCacheEnabled(){
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_CHILDREN_DRAWN_WITH_CACHE) == FLAG_CHILDREN_DRAWN_WITH_CACHE;
    }
		*/
		return false;
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    protected void setChildrenDrawnWithCacheEnabled(boolean enabled){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_CHILDREN_DRAWN_WITH_CACHE, enabled);
    }
		*/
		//Return nothing
	}
    
    @ViewDebug.ExportedProperty(category="drawing") protected boolean isChildrenDrawingOrderEnabled(){
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_USE_CHILD_DRAWING_ORDER) == FLAG_USE_CHILD_DRAWING_ORDER;
    }
		*/
		return false;
	}
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    protected void setChildrenDrawingOrderEnabled(boolean enabled){
		// Original method
		/*
		{
        setBooleanFlag(FLAG_USE_CHILD_DRAWING_ORDER, enabled);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void setBooleanFlag(int flag, boolean value){
		// Original method
		/*
		{
        if (value) {
            mGroupFlags |= flag;
        } else {
            mGroupFlags &= ~flag;
        }
    }
		*/
		//Return nothing
	}
    
    public static class LayoutParams {
        
        protected static String sizeToString(int size){
			// Original method
			/*
			{
            if (size == WRAP_CONTENT) {
                return "wrap-content";
            }
            if (size == MATCH_PARENT) {
                return "match-parent";
            }
            return String.valueOf(size);
        }
			*/
			return "";
		}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.085 -0500", hash_original_field = "CA9C87FB507C255B253FF70B6A24D80B", hash_generated_field = "B60A6144A316A76818E3F37ADD9B0E2B")

        @SuppressWarnings({"UnusedDeclaration"})
        @Deprecated
        public static final int FILL_PARENT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.089 -0500", hash_original_field = "9B4966B6C04E49B7085D30F54F269D61", hash_generated_field = "035E0815824268EA10F24139068915CD")

        public static final int MATCH_PARENT = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.092 -0500", hash_original_field = "F544C5DDA39931302A0101752233A40E", hash_generated_field = "33E013A8F3F409595C02468C7E3CA7AB")

        public static final int WRAP_CONTENT = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.096 -0500", hash_original_field = "1589F848FE4FF192F7CCE1B9F9E85747", hash_generated_field = "E98E615247D406FD5B1F2C460414CA00")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        })
        public int width;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.098 -0500", hash_original_field = "CE84F1587D182C1F0A32D7CD44443A18", hash_generated_field = "154449EB0055FED002CA8F596F81E1FB")

        @ViewDebug.ExportedProperty(category = "layout", mapping = {
            @ViewDebug.IntToString(from = MATCH_PARENT, to = "MATCH_PARENT"),
            @ViewDebug.IntToString(from = WRAP_CONTENT, to = "WRAP_CONTENT")
        })
        public int height;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.101 -0500", hash_original_field = "B5D78C1E17E1FDAB8BE02CF325649403", hash_generated_field = "A8465771210F0A9A6D04062D459407C3")

        public LayoutAnimationController.AnimationParameters layoutAnimationParameters;
        
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        public LayoutParams(Context c, AttributeSet attrs){
			/*
			TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.ViewGroup_Layout);
			setBaseAttributes(a,
                    R.styleable.ViewGroup_Layout_layout_width,
                    R.styleable.ViewGroup_Layout_layout_height);
			a.recycle();
			*/
		}

        /**
         * Creates a new set of layout parameters with the specified width
         * and height.
         *
         * @param width the width, either {@link #WRAP_CONTENT},
         *        {@link #FILL_PARENT} (replaced by {@link #MATCH_PARENT} in
         *        API Level 8), or a fixed size in pixels
         * @param height the height, either {@link #WRAP_CONTENT},
         *        {@link #FILL_PARENT} (replaced by {@link #MATCH_PARENT} in
         *        API Level 8), or a fixed size in pixels
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.107 -0500", hash_original_method = "25BDC30F3D80C9CBE1EB5EBCEE37F7CB", hash_generated_method = "8E7E8A7AFA1D7595B2A0F2A2F14462A8")
        
public LayoutParams(int width, int height) {
            this.width = width;
            this.height = height;
        }

        /**
         * Copy constructor. Clones the width and height values of the source.
         *
         * @param source The layout params to copy from.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.109 -0500", hash_original_method = "2BA3A180B45B8CE1CC5399F5BB84EEDE", hash_generated_method = "EC6F79F691EDE0AFA12359A87D1F6AEE")
        
public LayoutParams(LayoutParams source) {
            this.width = source.width;
            this.height = source.height;
        }

        /**
         * Used internally by MarginLayoutParams.
         * @hide
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.112 -0500", hash_original_method = "6916C65008FD05252A1C29A02882BE94", hash_generated_method = "6916C65008FD05252A1C29A02882BE94")
        
LayoutParams() {
        }
        
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        protected void setBaseAttributes(TypedArray a, int widthAttr, int heightAttr){
			// Original method
			/*
			{
            width = a.getLayoutDimension(widthAttr, "layout_width");
            height = a.getLayoutDimension(heightAttr, "layout_height");
        }
			*/
			//Return nothing
		}

        /**
         * Resolve layout parameters depending on the layout direction. Subclasses that care about
         * layoutDirection changes should override this method. The default implementation does
         * nothing.
         *
         * @param layoutDirection the direction of the layout
         *
         * {@link View#LAYOUT_DIRECTION_LTR}
         * {@link View#LAYOUT_DIRECTION_RTL}
         *
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.117 -0500", hash_original_method = "CE6F1B4BC3F83182FFE42E3A8827DEEC", hash_generated_method = "0F0191E626637C0111DC4A78D8DE1154")
        
protected void resolveWithDirection(int layoutDirection) {
        }
        
        public String debug(String output){
			// Original method
			/*
			{
            return output + "ViewGroup.LayoutParams={ width="
                    + sizeToString(width) + ", height=" + sizeToString(height) + " }";
        }
			*/
			return "";
		}
    }
    
    public static class MarginLayoutParams extends ViewGroup.LayoutParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.145 -0500", hash_original_field = "2FEDEB5C62ACC6AEDC002A4ADCDCAD40", hash_generated_field = "706B949A33ED230B911B9350FAA5912D")

        static private final int DEFAULT_RELATIVE = Integer.MIN_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.129 -0500", hash_original_field = "053CE6EC141FD5D6813EE811FD0A16B4", hash_generated_field = "B21196B63DA6FA861C6C44CFE61E0207")

        @ViewDebug.ExportedProperty(category = "layout")
        public int leftMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.131 -0500", hash_original_field = "23493BE25E602075A1B3F9F7498AAA78", hash_generated_field = "C75872B6D23692F5C29153B6138A7705")

        @ViewDebug.ExportedProperty(category = "layout")
        public int topMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.134 -0500", hash_original_field = "6C872E9D08E2E502D48A199E143FBCEC", hash_generated_field = "8215B4F64E53D75A1F217C65CCA861B0")

        @ViewDebug.ExportedProperty(category = "layout")
        public int rightMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.137 -0500", hash_original_field = "82B8AC0C8E1649E17F9204C2868AC008", hash_generated_field = "C9EC61B6AE185D3F68BEDBB7A02A577D")

        @ViewDebug.ExportedProperty(category = "layout")
        public int bottomMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.139 -0500", hash_original_field = "57E929C526952608C506C53CCE5925D7", hash_generated_field = "6BB5C7CF92CA34A599866F03AD4A8600")

        @ViewDebug.ExportedProperty(category = "layout")
        protected int startMargin = DEFAULT_RELATIVE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.142 -0500", hash_original_field = "50AADE3D3D2606EF60485CD03856295E", hash_generated_field = "0A4C2937E1B0718BA14E68C5B33ABD23")

        @ViewDebug.ExportedProperty(category = "layout")
        protected int endMargin = DEFAULT_RELATIVE;
        
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        public MarginLayoutParams(Context c, AttributeSet attrs){
			super();
			/* Original Method Too Long, Refer to Original Implementation */
		}

        /**
         * {@inheritDoc}
         */
        @DSComment("constructor")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.151 -0500", hash_original_method = "4C1C9EAF9AFA2E58AB980E97DFB147EB", hash_generated_method = "245AED6E1728C23DD137A7E19EFB1ECF")
        
public MarginLayoutParams(int width, int height) {
            super(width, height);
        }
        
        public MarginLayoutParams(MarginLayoutParams source){
			/*
			this.width = source.width;
			this.height = source.height;
			this.leftMargin = source.leftMargin;
			this.topMargin = source.topMargin;
			this.rightMargin = source.rightMargin;
			this.bottomMargin = source.bottomMargin;
			this.startMargin = source.startMargin;
			this.endMargin = source.endMargin;
			*/
		}

        /**
         * {@inheritDoc}
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.157 -0500", hash_original_method = "E2A57B11F6C8009C3B5E4EDAD0277412", hash_generated_method = "7A6F66E61F46286624966B680FE047F1")
        
public MarginLayoutParams(LayoutParams source) {
            super(source);
        }
        
        @DSComment("data structure only")
        @DSSafe(DSCat.DATA_STRUCTURE)
        public void setMargins(int left, int top, int right, int bottom){
			addTaint(left);
			leftMargin = left;  //Preserved
			addTaint(top);
			topMargin = top;  //Preserved
			addTaint(right);
			rightMargin = right;  //Preserved
			addTaint(bottom);
			bottomMargin = bottom;  //Preserved
			// Original method
			/*
			{
            leftMargin = left;
            topMargin = top;
            rightMargin = right;
            bottomMargin = bottom;
        }
			*/
			//Return nothing
		}
        
        public void setMarginsRelative(int start, int top, int end, int bottom){
			addTaint(start);
			startMargin = start;  //Preserved
			addTaint(top);
			topMargin = top;  //Preserved
			addTaint(end);
			endMargin = end;  //Preserved
			addTaint(bottom);
			bottomMargin = bottom;  //Preserved
			// Original method
			/*
			{
            startMargin = start;
            topMargin = top;
            endMargin = end;
            bottomMargin = bottom;
        }
			*/
			//Return nothing
		}
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        public int getMarginStart(){
			return getTaintInt();
			// Original method
			/*
			{
            return startMargin;
        }
			*/
		}
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        public int getMarginEnd(){
			return getTaintInt();
			// Original method
			/*
			{
            return endMargin;
        }
			*/
		}
        
        @DSSafe(DSCat.SAFE_OTHERS)
        public boolean isMarginRelative(){
			// Original method
			/*
			{
            return (startMargin != DEFAULT_RELATIVE) || (endMargin != DEFAULT_RELATIVE);
        }
			*/
			return false;
		}
        
        @Override protected void resolveWithDirection(int layoutDirection){
			// Original method
			/*
			{
            switch(layoutDirection) {
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
        }
			*/
			//Return nothing
		}
    }
    
    private static final class TouchTarget {
        
        public static TouchTarget obtain(View child, int pointerIdBits){
			// Original method
			/*
			{
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
			*/
			return null;
		}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.181 -0500", hash_original_field = "3A74AA851F9571BE25183B185857A3CA", hash_generated_field = "393219263EA5357C424C8D6A0761942D")

        private static final int MAX_RECYCLED = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.184 -0500", hash_original_field = "8B526C03B7256099E1ADC895D8D8A40C", hash_generated_field = "569BC93CDF23077487A166A9877200C9")

        private static final Object sRecycleLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.186 -0500", hash_original_field = "38FC9EFB79249079325C9B215958122E", hash_generated_field = "E0E2F52EC1657E89F88CB94D6B19500A")

        private static TouchTarget sRecycleBin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.189 -0500", hash_original_field = "F004323C500B4A3986946D1B91D84A0F", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.192 -0500", hash_original_field = "90F952884FE34CFC660B925514CBA081", hash_generated_field = "5D0EA96D1B8E6DB25F736A1FB6B6D10D")

        public static final int ALL_POINTER_IDS = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.194 -0500", hash_original_field = "E2B2B04ADE31BBC2961DC9080CB69B13", hash_generated_field = "1CCB8EE97FC7539DEBCCA058A8788B2D")

        // The touched child view.
        public View child;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.197 -0500", hash_original_field = "59338C5719C65D7C1527A00435D636BA", hash_generated_field = "530D731D7D2EE140B1D1AF75DBF79B1B")

        public int pointerIdBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.199 -0500", hash_original_field = "10C3BA9CEC77D140ABD0140F446A6A40", hash_generated_field = "DC720CE01C505E3F8C1AAF24F8078F0D")

        public TouchTarget next;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.202 -0500", hash_original_method = "5259B67E5A6C02FEFA0EB82F43285FB5", hash_generated_method = "3FD6060E7F316E76470356009D890095")
        
private TouchTarget() {
        }
        
        public void recycle(){
			// Original method
			/*
			{
            synchronized (sRecycleLock) {
                if (sRecycledCount < MAX_RECYCLED) {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } else {
                    next = null;
                }
                child = null;
            }
        }
			*/
			//Return nothing
		}
    }
    
    private static final class HoverTarget {
        
        public static HoverTarget obtain(View child){
			// Original method
			/*
			{
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
			*/
			return null;
		}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.213 -0500", hash_original_field = "3A74AA851F9571BE25183B185857A3CA", hash_generated_field = "393219263EA5357C424C8D6A0761942D")

        private static final int MAX_RECYCLED = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.216 -0500", hash_original_field = "8B526C03B7256099E1ADC895D8D8A40C", hash_generated_field = "569BC93CDF23077487A166A9877200C9")

        private static final Object sRecycleLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.219 -0500", hash_original_field = "2D2529F4D48EA65981B760444612A675", hash_generated_field = "9BF05FD9D6504C47D3CD94A8F3200F82")

        private static HoverTarget sRecycleBin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.221 -0500", hash_original_field = "F004323C500B4A3986946D1B91D84A0F", hash_generated_field = "8DBFF1570BBBBB6DA28AAC5B6FF5453C")

        private static int sRecycledCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.223 -0500", hash_original_field = "E2B2B04ADE31BBC2961DC9080CB69B13", hash_generated_field = "666EDA6D407B9C5116B55295B45230F4")

        public View child;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.226 -0500", hash_original_field = "526E36609FF8E4AA3F4F94D729B15840", hash_generated_field = "3B1636D6CF959CF92CBD4352E6CBCE49")

        public HoverTarget next;

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.229 -0500", hash_original_method = "5539B57739929C533DCF7E732D22C4F2", hash_generated_method = "3287AC7D0F65F609C74D7BC047708D05")
        
private HoverTarget() {
        }
        
        public void recycle(){
			// Original method
			/*
			{
            synchronized (sRecycleLock) {
                if (sRecycledCount < MAX_RECYCLED) {
                    next = sRecycleBin;
                    sRecycleBin = this;
                    sRecycledCount += 1;
                } else {
                    next = null;
                }
                child = null;
            }
        }
			*/
			//Return nothing
		}
    }
    
    public interface OnHierarchyChangeListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onChildViewAdded(View parent, View child);
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        void onChildViewRemoved(View parent, View child);
    }
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @ViewDebug.ExportedProperty(category="drawing",mapping={@ViewDebug.IntToString(from=PERSISTENT_NO_CACHE,to="NONE"),@ViewDebug.IntToString(from=PERSISTENT_ANIMATION_CACHE,to="ANIMATION"),@ViewDebug.IntToString(from=PERSISTENT_SCROLLING_CACHE,to="SCROLLING"),@ViewDebug.IntToString(from=PERSISTENT_ALL_CACHES,to="ALL")}) public int getPersistentDrawingCache(){
		return getTaintInt();
		// Original method
		/*
		{
        return mPersistentDrawingCache;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setPersistentDrawingCache(int drawingCacheToKeep){
		// Original method
		/*
		{
        mPersistentDrawingCache = drawingCacheToKeep & PERSISTENT_ALL_CACHES;
    }
		*/
		//Return nothing
	}
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
    public LayoutParams generateLayoutParams(AttributeSet attrs){
        return new LayoutParams(getContext(), attrs);
	}
    
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams p){
		// Original method
		/*
		{
        return p;
    }
		*/
		return null;
	}
    
    protected LayoutParams generateDefaultLayoutParams(){
		// Original method
		/*
		{
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
		*/
		return null;
	}
    
    @Override protected boolean dispatchConsistencyCheck(int consistency){
		// Original method
		/*
		{
        boolean result = super.dispatchConsistencyCheck(consistency);
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            if (!children[i].dispatchConsistencyCheck(consistency)) result = false;
        }
        return result;
    }
		*/
		return false;
	}
    
    @Override protected boolean onConsistencyCheck(int consistency){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return false;
	}
    
    @Override protected void debug(int depth){
		// Original method
		/*
		{
        super.debug(depth);
        String output;
        if (mFocused != null) {
            output = debugIndent(depth);
            output += "mFocused";
            Log.d(VIEW_LOG_TAG, output);
        }
        if (mChildrenCount != 0) {
            output = debugIndent(depth);
            output += "{";
            Log.d(VIEW_LOG_TAG, output);
        }
        int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            View child = mChildren[i];
            child.debug(depth + 1);
        }
        if (mChildrenCount != 0) {
            output = debugIndent(depth);
            output += "}";
            Log.d(VIEW_LOG_TAG, output);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public int indexOfChild(View child){
		// Original method
		/*
		{
        final int count = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < count; i++) {
            if (children[i] == child) {
                return i;
            }
        }
        return -1;
    }
		*/
		return 0;
	}

    @DSVerified
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getChildCount(){
		return getTaintInt();
	}
    
	@DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public View getChildAt(int index){
		return mChildren[0];
	}
    
    protected void measureChildren(int widthMeasureSpec, int heightMeasureSpec){
		// Original method
		/*
		{
        final int size = mChildrenCount;
        final View[] children = mChildren;
        for (int i = 0; i < size; ++i) {
            final View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) != GONE) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected void measureChild(View child, int parentWidthMeasureSpec,
            int parentHeightMeasureSpec){
		// Original method
		/*
		{
        final LayoutParams lp = child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }
		*/
		//Return nothing
	}
    
    @DSVerified
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    protected void measureChildWithMargins(View child,
            int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed){
		// Original method
		/*
		{
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        final int childWidthMeasureSpec = getChildMeasureSpec(parentWidthMeasureSpec,
                mPaddingLeft + mPaddingRight + lp.leftMargin + lp.rightMargin
                        + widthUsed, lp.width);
        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void clearDisappearingChildren(){
		// Original method
		/*
		{
        if (mDisappearingChildren != null) {
            mDisappearingChildren.clear();
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private void addDisappearingView(View v){
		// Original method
		/*
		{
        ArrayList<View> disappearingChildren = mDisappearingChildren;
        if (disappearingChildren == null) {
            disappearingChildren = mDisappearingChildren = new ArrayList<View>();
        }
        disappearingChildren.add(v);
    }
		*/
		//Return nothing
	}
    
    private void finishAnimatingView(final View view, Animation animation){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    boolean isViewTransitioning(View view){
		// Original method
		/*
		{
        return (mTransitioningViews != null && mTransitioningViews.contains(view));
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void startViewTransition(View view){
		// Original method
		/*
		{
        if (view.mParent == this) {
            if (mTransitioningViews == null) {
                mTransitioningViews = new ArrayList<View>();
            }
            mTransitioningViews.add(view);
        }
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void endViewTransition(View view){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    @Override public boolean gatherTransparentRegion(Region region){
		// Original method
		/*
		{
        final boolean meOpaque = (mPrivateFlags & View.REQUEST_TRANSPARENT_REGIONS) == 0;
        if (meOpaque && region == null) {
            return true;
        }
        super.gatherTransparentRegion(region);
        final View[] children = mChildren;
        final int count = mChildrenCount;
        boolean noneOfTheChildrenAreTransparent = true;
        for (int i = 0; i < count; i++) {
            final View child = children[i];
            if ((child.mViewFlags & VISIBILITY_MASK) == VISIBLE || child.getAnimation() != null) {
                if (!child.gatherTransparentRegion(region)) {
                    noneOfTheChildrenAreTransparent = false;
                }
            }
        }
        return meOpaque || noneOfTheChildrenAreTransparent;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void requestTransparentRegion(View child){
		// Original method
		/*
		{
        if (child != null) {
            child.mPrivateFlags |= View.REQUEST_TRANSPARENT_REGIONS;
            if (mParent != null) {
                mParent.requestTransparentRegion(this);
            }
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected boolean fitSystemWindows(Rect insets){
		// Original method
		/*
		{
        boolean done = super.fitSystemWindows(insets);
        if (!done) {
            final int count = mChildrenCount;
            final View[] children = mChildren;
            for (int i = 0; i < count; i++) {
                done = children[i].fitSystemWindows(insets);
                if (done) {
                    break;
                }
            }
        }
        return done;
    }
		*/
		return false;
	}
    
    public Animation.AnimationListener getLayoutAnimationListener(){
		return (Animation.AnimationListener)getTaint();
		// Original method
		/*
		{
        return mAnimationListener;
    }
		*/
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @Override protected void drawableStateChanged(){
		// Original method
		/*
		{
        super.drawableStateChanged();
        if ((mGroupFlags & FLAG_NOTIFY_CHILDREN_ON_DRAWABLE_STATE_CHANGE) != 0) {
            if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
                throw new IllegalStateException("addStateFromChildren cannot be enabled if a"
                        + " child has duplicateParentState set to true");
            }
            final View[] children = mChildren;
            final int count = mChildrenCount;
            for (int i = 0; i < count; i++) {
                final View child = children[i];
                if ((child.mViewFlags & DUPLICATE_PARENT_STATE) != 0) {
                    child.refreshDrawableState();
                }
            }
        }
    }
		*/
		//Return nothing
	}
    
    @Override public void jumpDrawablesToCurrentState(){
		// Original method
		/*
		{
        super.jumpDrawablesToCurrentState();
        final View[] children = mChildren;
        final int count = mChildrenCount;
        for (int i = 0; i < count; i++) {
            children[i].jumpDrawablesToCurrentState();
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected int[] onCreateDrawableState(int extraSpace){
		// Original method
		/*
		{
        if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) == 0) {
            return super.onCreateDrawableState(extraSpace);
        }
        int need = 0;
        int n = getChildCount();
        for (int i = 0; i < n; i++) {
            int[] childState = getChildAt(i).getDrawableState();
            if (childState != null) {
                need += childState.length;
            }
        }
        int[] state = super.onCreateDrawableState(extraSpace + need);
        for (int i = 0; i < n; i++) {
            int[] childState = getChildAt(i).getDrawableState();
            if (childState != null) {
                state = mergeDrawableStates(state, childState);
            }
        }
        return state;
    }
		*/
		return null;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void setAddStatesFromChildren(boolean addsStates){
		// Original method
		/*
		{
        if (addsStates) {
            mGroupFlags |= FLAG_ADD_STATES_FROM_CHILDREN;
        } else {
            mGroupFlags &= ~FLAG_ADD_STATES_FROM_CHILDREN;
        }
        refreshDrawableState();
    }
		*/
		//Return nothing
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public boolean addStatesFromChildren(){
		// Original method
		/*
		{
        return (mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0;
    }
		*/
		return false;
	}
    
    @DSComment("Normal GUI")
    @DSSafe(DSCat.GUI)
    public void childDrawableStateChanged(View child){
		// Original method
		/*
		{
        if ((mGroupFlags & FLAG_ADD_STATES_FROM_CHILDREN) != 0) {
            refreshDrawableState();
        }
    }
		*/
		//Return nothing
	}

    /**
     * Specifies the animation listener to which layout animation events must
     * be sent. Only
     * {@link android.view.animation.Animation.AnimationListener#onAnimationStart(Animation)}
     * and
     * {@link android.view.animation.Animation.AnimationListener#onAnimationEnd(Animation)}
     * are invoked.
     *
     * @param animationListener the layout animation listener
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:02.071 -0500", hash_original_method = "CCA9986B4D287F2F006BAE825941ECAA", hash_generated_method = "6B28890EA364BD54F07B7CDD3200B2AF")
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setLayoutAnimationListener(Animation.AnimationListener animationListener) {
        mAnimationListener = animationListener;

        Animation animation = getAnimation();
        if (animationListener != null && animation != null) {
            animation.setAnimationListener(animationListener);
        }
    }
    
    public void requestTransitionStart(LayoutTransition transition){
		// Original method
		/*
		{
        ViewRootImpl viewAncestor = getViewRootImpl();
        if (viewAncestor != null) {
            viewAncestor.requestTransitionStart(transition);
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected void resetResolvedLayoutDirection(){
		// Original method
		/*
		{
        super.resetResolvedLayoutDirection();
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getLayoutDirection() == LAYOUT_DIRECTION_INHERIT) {
                child.resetResolvedLayoutDirection();
            }
        }
    }
		*/
		//Return nothing
	}
    
    @Override protected void resetResolvedTextDirection(){
		// Original method
		/*
		{
        super.resetResolvedTextDirection();
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getTextDirection() == TEXT_DIRECTION_INHERIT) {
                child.resetResolvedTextDirection();
            }
        }
    }
		*/
		//Return nothing
	}
    
    public boolean shouldDelayChildPressedState(){
		// Original method
		/*
		{
        return true;
    }
		*/
		return false;
	}
}

