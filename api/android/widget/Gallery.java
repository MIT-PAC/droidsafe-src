package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.HapticFeedbackConstants;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;

import com.android.internal.R;

public class Gallery extends AbsSpinner implements GestureDetector.OnGestureListener {
    
    /**
     * @return The center of the given view.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.678 -0500", hash_original_method = "EB22A7FE8A7FE8AF79ECEB2165A42E06", hash_generated_method = "1F0AF854ACC8DC4ED8F3AA836D09B504")
    
private static int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.575 -0500", hash_original_field = "99B681AEE1A9575269905F6967720DCD", hash_generated_field = "86E3B6121245E31C4D677E593D737E58")

    private static final String TAG = "Gallery";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.577 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "761D2619615A389BF902F171CC86D6A4")

    private static final boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.579 -0500", hash_original_field = "551B75520263D4E4E845E37C828D00A5", hash_generated_field = "F9ED17A16043F2269968A297C3B5536A")

    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.581 -0500", hash_original_field = "DD05BF0548EE999C4E00E82EA2D6234B", hash_generated_field = "6908B47F1286FF0E8F257052A45F19C3")

    private int mSpacing = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.583 -0500", hash_original_field = "9DBC768262F44ECA2E289D2F045FF2C0", hash_generated_field = "7DDC30AC361091A9B237602A7998D4FE")

    private int mAnimationDuration = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.585 -0500", hash_original_field = "BEAC2F3B0BEF61B0E169EBF66E69E4B4", hash_generated_field = "16F130EDB3F8F019BBCA898590B37D9A")

    private float mUnselectedAlpha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.587 -0500", hash_original_field = "A4FF90979332C4462A9692651F47B845", hash_generated_field = "E0ED55B65924CD7E2D39F0DD730F1D49")

    private int mLeftMost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.590 -0500", hash_original_field = "C97629EDB22B4A0E6831555E516EF9BC", hash_generated_field = "943D3EE9E3A99AC4AE3E674CB5292A7B")

    private int mRightMost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.592 -0500", hash_original_field = "E8D24DE70DE8CB945622B4CE486A90EA", hash_generated_field = "ACF14A395FB2702990553CD0EFA1BDCC")

    private int mGravity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.595 -0500", hash_original_field = "AB20CE05616A647AECFCD053AA0A7A3C", hash_generated_field = "DA7C2146C29AB67A18FA4519D8BF6725")

    private GestureDetector mGestureDetector;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.597 -0500", hash_original_field = "3183DCC1BF12DFC8F30501203120C4BB", hash_generated_field = "48D58026A8B3F70D3312B75231403F47")

    private int mDownTouchPosition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.599 -0500", hash_original_field = "3072364B95D62D267D25C94E7DAD6714", hash_generated_field = "E5931B84C9656513FA35F3B36B7A34ED")

    private View mDownTouchView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.601 -0500", hash_original_field = "67AE18713B44F3DF5554B5A71FA0D8F3", hash_generated_field = "287089796DE9AC8B1BED30B6D71A8BCF")

    private FlingRunnable mFlingRunnable = new FlingRunnable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:59.960 -0400", hash_original_field = "CA72A41BFA85D123FCEBDA446C142B0D", hash_generated_field = "7D17FC7B784C4DFE85940485A53D6A7C")

    private Runnable mDisableSuppressSelectionChangedRunnable = new Runnable() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.604 -0500", hash_original_method = "6390BF84CDDE59DC47728D8159023DBB", hash_generated_method = "EC53DAA1910EBD75CF282B72F9F30C01")
        
@Override
        public void run() {
            mSuppressSelectionChanged = false;
            selectionChanged();
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.608 -0500", hash_original_field = "7B60D2C103BF6688B37159D200FDF777", hash_generated_field = "4F33C08AF070CABF3FDDD85E87BAE951")

    private boolean mShouldStopFling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.610 -0500", hash_original_field = "D4EF764B0E5E0052644959E99E9ACC23", hash_generated_field = "F58C1145D53A71FE5D77D5307858E3E5")

    private View mSelectedChild;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.612 -0500", hash_original_field = "0EBAE7043481CC5A16D724DFC294B5D9", hash_generated_field = "32030A2B3ED2EA65C29B698806417240")

    private boolean mShouldCallbackDuringFling = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.615 -0500", hash_original_field = "EC09ECDD5861EC8771BA7D2CFA213E07", hash_generated_field = "F31BFDB883A3EF2414ED5384B6FD1E82")

    private boolean mShouldCallbackOnUnselectedItemClick = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.617 -0500", hash_original_field = "52481CE3B67FAB2510AE42EAFE7ECAE9", hash_generated_field = "DC1B7A71E07C07D553D8BFB5CAB0B978")

    private boolean mSuppressSelectionChanged;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.619 -0500", hash_original_field = "739A152DDA7D4E58BE3C0916CC93D5DB", hash_generated_field = "E9741D547D745DB9FE491BC5B86C4FBF")

    private boolean mReceivedInvokeKeyDown;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.621 -0500", hash_original_field = "C94522091847EFE024AFBF98B499E629", hash_generated_field = "66F1ED7DD74887E9F376183A8E9DD9C2")
    
    private AdapterContextMenuInfo mContextMenuInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.624 -0500", hash_original_field = "E78AEB5AB1838B9A5CFCE72673CD417E", hash_generated_field = "853C1D061612824EBF4A0E2663C313BA")

    private boolean mIsFirstScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.625 -0500", hash_original_field = "A9E26DAE29829FC7FCD5D4482628BA17", hash_generated_field = "DDDFBF43887528504DF780774BEC6E8B")

    private boolean mIsRtl = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.628 -0500", hash_original_method = "475E2614DCD8BCA86D0A9A2D522E9160", hash_generated_method = "5D2B28164208956EDB8DB13C5E51AD07")
    
public Gallery(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.630 -0500", hash_original_method = "6F70D7EE2D6B35912A9443CBD20034EA", hash_generated_method = "21ED4F65019F580F3C31181AE87FE21C")
    
public Gallery(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.galleryStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.633 -0500", hash_original_method = "D87B27451B638EC2EE79D6B32CF2AC05", hash_generated_method = "3554C9B7B729D4C75C7512891DA0C273")
    
public Gallery(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        mGestureDetector = new GestureDetector(context, this);
        mGestureDetector.setIsLongpressEnabled(true);
        
        TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.Gallery, defStyle, 0);

        int index = a.getInt(com.android.internal.R.styleable.Gallery_gravity, -1);
        if (index >= 0) {
            setGravity(index);
        }

        int animationDuration =
                a.getInt(com.android.internal.R.styleable.Gallery_animationDuration, -1);
        if (animationDuration > 0) {
            setAnimationDuration(animationDuration);
        }

        int spacing =
                a.getDimensionPixelOffset(com.android.internal.R.styleable.Gallery_spacing, 0);
        setSpacing(spacing);

        float unselectedAlpha = a.getFloat(
                com.android.internal.R.styleable.Gallery_unselectedAlpha, 0.5f);
        setUnselectedAlpha(unselectedAlpha);
        
        a.recycle();

        // We draw the selected item last (because otherwise the item to the
        // right overlaps it)
        mGroupFlags |= FLAG_USE_CHILD_DRAWING_ORDER;
        
        mGroupFlags |= FLAG_SUPPORT_STATIC_TRANSFORMATIONS;
    }

    /**
     * Whether or not to callback on any {@link #getOnItemSelectedListener()}
     * while the items are being flinged. If false, only the final selected item
     * will cause the callback. If true, all items between the first and the
     * final will cause callbacks.
     * 
     * @param shouldCallback Whether or not to callback on the listener while
     *            the items are being flinged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.636 -0500", hash_original_method = "BF4DA518E23220545D4D17CD06D2812B", hash_generated_method = "70CB2781C94A34625452A7D803EB966E")
    
public void setCallbackDuringFling(boolean shouldCallback) {
        mShouldCallbackDuringFling = shouldCallback;
    }

    /**
     * Whether or not to callback when an item that is not selected is clicked.
     * If false, the item will become selected (and re-centered). If true, the
     * {@link #getOnItemClickListener()} will get the callback.
     * 
     * @param shouldCallback Whether or not to callback on the listener when a
     *            item that is not selected is clicked.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.638 -0500", hash_original_method = "35BE7A0536455C2A0F09BBAE9D2D6389", hash_generated_method = "3A988DF1C1F2F81A017B01C4E9486F37")
    
public void setCallbackOnUnselectedItemClick(boolean shouldCallback) {
        mShouldCallbackOnUnselectedItemClick = shouldCallback;
    }
    
    /**
     * Sets how long the transition animation should run when a child view
     * changes position. Only relevant if animation is turned on.
     * 
     * @param animationDurationMillis The duration of the transition, in
     *        milliseconds.
     * 
     * @attr ref android.R.styleable#Gallery_animationDuration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.640 -0500", hash_original_method = "C4B72670DAE1EC61056CA78802FA094C", hash_generated_method = "03BC760DD65A22259AAA791BFC3D3A2E")
    
public void setAnimationDuration(int animationDurationMillis) {
        mAnimationDuration = animationDurationMillis;
    }

    /**
     * Sets the spacing between items in a Gallery
     * 
     * @param spacing The spacing in pixels between items in the Gallery
     * 
     * @attr ref android.R.styleable#Gallery_spacing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.642 -0500", hash_original_method = "5E8A11776A8EA8D02696ABF29BE14ED6", hash_generated_method = "A4F52B18F8DACA81E64B6E401103C782")
    
public void setSpacing(int spacing) {
        mSpacing = spacing;
    }

    /**
     * Sets the alpha of items that are not selected in the Gallery.
     * 
     * @param unselectedAlpha the alpha for the items that are not selected.
     * 
     * @attr ref android.R.styleable#Gallery_unselectedAlpha
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.644 -0500", hash_original_method = "4DB3B67BF1B9A3FA2A4736C5F1CFBEA1", hash_generated_method = "3AC3D11B4758658A0FB111FFB0BDC418")
    
public void setUnselectedAlpha(float unselectedAlpha) {
        mUnselectedAlpha = unselectedAlpha;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.646 -0500", hash_original_method = "8BDE9EE3EBF8484A23D1B160F2ED960C", hash_generated_method = "BD6D40D4AF5C2119D524B23D309A77DD")
    
@Override
    protected boolean getChildStaticTransformation(View child, Transformation t) {
        
        t.clear();
        t.setAlpha(child == mSelectedChild ? 1.0f : mUnselectedAlpha);
        
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.649 -0500", hash_original_method = "79AE40AE7044F70B8A2DE0C11DA2A6EC", hash_generated_method = "84D1EDA14C2E859FA31802E15D1900CE")
    
@Override
    protected int computeHorizontalScrollExtent() {
        // Only 1 item is considered to be selected
        return 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.651 -0500", hash_original_method = "2692EBC36C6BF52C61AC22E6B166DF8E", hash_generated_method = "CC47A49124E46BDB7F03D8EC76E5130A")
    
@Override
    protected int computeHorizontalScrollOffset() {
        // Current scroll position is the same as the selected position
        return mSelectedPosition;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.653 -0500", hash_original_method = "80D0AAD3D44B58246BF39F244D8B4F36", hash_generated_method = "58F6EE08F7CB90AD4A8E433893AED827")
    
@Override
    protected int computeHorizontalScrollRange() {
        // Scroll range is the same as the item count
        return mItemCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.655 -0500", hash_original_method = "E5E3FCBA546B7CFE2F525BEFE910A396", hash_generated_method = "8E8F0BEBF3E59660E5FA9B2761F7834C")
    
@Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.657 -0500", hash_original_method = "B595E0482905B38051CD63239BB5F8BA", hash_generated_method = "F04F425EAA932DD15846B3A8E447FBE2")
    
@Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.660 -0500", hash_original_method = "1C9B9BBEC46A39865FCD3A7288415ECD", hash_generated_method = "C4E1D1D633134DBA474501AB48EC2962")
    
@Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.662 -0500", hash_original_method = "45A5836088105736B1AA4CBE86661268", hash_generated_method = "D208F355A7FCDE9DDEFFE73EB71D544C")
    
@Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        /*
         * Gallery expects Gallery.LayoutParams.
         */
        return new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.664 -0500", hash_original_method = "2F25E46AB3A307ED9F0C91E6C81BDCD4", hash_generated_method = "AA5BDEB98EB273C7281DC1FF179AD43A")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        
        /*
         * Remember that we are in layout to prevent more layout request from
         * being generated.
         */
        mInLayout = true;
        layout(0, false);
        mInLayout = false;
    }

    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.667 -0500", hash_original_method = "44D3B1A6F440757321735895159CF3F5", hash_generated_method = "0BC0A54504E0107F1965D37EDEFEAF5D")
    
@Override
    int getChildHeight(View child) {
        return child.getMeasuredHeight();
    }

    /**
     * Tracks a motion scroll. In reality, this is used to do just about any
     * movement to items (touch scroll, arrow-key scroll, set an item as selected).
     * 
     * @param deltaX Change in X from the previous event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.669 -0500", hash_original_method = "CF0F4FD99D6D1B74E2AB7A4A0D0FE283", hash_generated_method = "44E44BDA28644E4921175850ACFF8056")
    
void trackMotionScroll(int deltaX) {

        if (getChildCount() == 0) {
            return;
        }
        
        boolean toLeft = deltaX < 0;
        
        int limitedDeltaX = getLimitedMotionScrollAmount(toLeft, deltaX);
        if (limitedDeltaX != deltaX) {
            // The above call returned a limited amount, so stop any scrolls/flings
            mFlingRunnable.endFling(false);
            onFinishedMovement();
        }
        
        offsetChildrenLeftAndRight(limitedDeltaX);
        
        detachOffScreenChildren(toLeft);
        
        if (toLeft) {
            // If moved left, there will be empty space on the right
            fillToGalleryRight();
        } else {
            // Similarly, empty space on the left
            fillToGalleryLeft();
        }
        
        // Clear unused views
        mRecycler.clear();
        
        setSelectionToCenterChild();

        onScrollChanged(0, 0, 0, 0); // dummy values, View's implementation does not use these.

        invalidate();
    }

    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.671 -0500", hash_original_method = "1E51C3862CE74D6B831F0305D11D86D1", hash_generated_method = "48A532ABC49B28429FF311906A9D4CBA")
    
int getLimitedMotionScrollAmount(boolean motionToLeft, int deltaX) {
        int extremeItemPosition = motionToLeft != mIsRtl ? mItemCount - 1 : 0;
        View extremeChild = getChildAt(extremeItemPosition - mFirstPosition);
        
        if (extremeChild == null) {
            return deltaX;
        }
        
        int extremeChildCenter = getCenterOfView(extremeChild);
        int galleryCenter = getCenterOfGallery();
        
        if (motionToLeft) {
            if (extremeChildCenter <= galleryCenter) {
                
                // The extreme child is past his boundary point!
                return 0;
            }
        } else {
            if (extremeChildCenter >= galleryCenter) {

                // The extreme child is past his boundary point!
                return 0;
            }
        }
        
        int centerDifference = galleryCenter - extremeChildCenter;

        return motionToLeft
                ? Math.max(centerDifference, deltaX)
                : Math.min(centerDifference, deltaX); 
    }

    /**
     * Offset the horizontal location of all children of this view by the
     * specified number of pixels.
     * 
     * @param offset the number of pixels to offset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.673 -0500", hash_original_method = "4EEE31555E188404F99AA8E4E9247689", hash_generated_method = "D9055B18C19E5B672900C34B338EABA1")
    
private void offsetChildrenLeftAndRight(int offset) {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            getChildAt(i).offsetLeftAndRight(offset);
        }
    }
    
    /**
     * @return The center of this Gallery.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.676 -0500", hash_original_method = "7DE2375AA3E30D760C22927E49BD5683", hash_generated_method = "BCA86A94109D5D9BC9ACF7FB309CE5CB")
    
private int getCenterOfGallery() {
        return (getWidth() - mPaddingLeft - mPaddingRight) / 2 + mPaddingLeft;
    }
    
    /**
     * Detaches children that are off the screen (i.e.: Gallery bounds).
     * 
     * @param toLeft Whether to detach children to the left of the Gallery, or
     *            to the right.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.681 -0500", hash_original_method = "D8B7CD82B13D6307CBAC6FD1D2419AAD", hash_generated_method = "4998544A91819B4B7C9FD64C661C81E8")
    
private void detachOffScreenChildren(boolean toLeft) {
        int numChildren = getChildCount();
        int firstPosition = mFirstPosition;
        int start = 0;
        int count = 0;

        if (toLeft) {
            final int galleryLeft = mPaddingLeft;
            for (int i = 0; i < numChildren; i++) {
                int n = mIsRtl ? (numChildren - 1 - i) : i;
                final View child = getChildAt(n);
                if (child.getRight() >= galleryLeft) {
                    break;
                } else {
                    start = n;
                    count++;
                    mRecycler.put(firstPosition + n, child);
                }
            }
            if (!mIsRtl) {
                start = 0;
            }
        } else {
            final int galleryRight = getWidth() - mPaddingRight;
            for (int i = numChildren - 1; i >= 0; i--) {
                int n = mIsRtl ? numChildren - 1 - i : i;
                final View child = getChildAt(n);
                if (child.getLeft() <= galleryRight) {
                    break;
                } else {
                    start = n;
                    count++;
                    mRecycler.put(firstPosition + n, child);
                }
            }
            if (mIsRtl) {
                start = 0;
            }
        }

        detachViewsFromParent(start, count);
        
        if (toLeft != mIsRtl) {
            mFirstPosition += count;
        }
    }
    
    /**
     * Scrolls the items so that the selected item is in its 'slot' (its center
     * is the gallery's center).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.684 -0500", hash_original_method = "7B136AF27CDBDA451A86F0C558D92536", hash_generated_method = "AADC47DFFEB747DA251688B348BDD88D")
    
private void scrollIntoSlots() {
        
        if (getChildCount() == 0 || mSelectedChild == null) return;
        
        int selectedCenter = getCenterOfView(mSelectedChild);
        int targetCenter = getCenterOfGallery();
        
        int scrollAmount = targetCenter - selectedCenter;
        if (scrollAmount != 0) {
            mFlingRunnable.startUsingDistance(scrollAmount);
        } else {
            onFinishedMovement();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.686 -0500", hash_original_method = "73E6CA1691599BC4ECD7D5DB3D8073AD", hash_generated_method = "71FC46A355914A60AE2501B77FE75C0E")
    
private void onFinishedMovement() {
        if (mSuppressSelectionChanged) {
            mSuppressSelectionChanged = false;
            
            // We haven't been callbacking during the fling, so do it now
            super.selectionChanged();
        }
        invalidate();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.688 -0500", hash_original_method = "FFD143793C4BF3C1C0F88DAC5604B8EB", hash_generated_method = "72AF5079CF760FD436F6A272827E6D99")
    
@Override
    void selectionChanged() {
        if (!mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    /**
     * Looks for the child that is closest to the center and sets it as the
     * selected child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.691 -0500", hash_original_method = "99F459BBFD91AC2E00EAA95D53F6B222", hash_generated_method = "92A0B0724D4757624BDFB5A33F112486")
    
private void setSelectionToCenterChild() {
        
        View selView = mSelectedChild;
        if (mSelectedChild == null) return;
        
        int galleryCenter = getCenterOfGallery();
        
        // Common case where the current selected position is correct
        if (selView.getLeft() <= galleryCenter && selView.getRight() >= galleryCenter) {
            return;
        }
        
        // TODO better search
        int closestEdgeDistance = Integer.MAX_VALUE;
        int newSelectedChildIndex = 0;
        for (int i = getChildCount() - 1; i >= 0; i--) {
            
            View child = getChildAt(i);
            
            if (child.getLeft() <= galleryCenter && child.getRight() >=  galleryCenter) {
                // This child is in the center
                newSelectedChildIndex = i;
                break;
            }
            
            int childClosestEdgeDistance = Math.min(Math.abs(child.getLeft() - galleryCenter),
                    Math.abs(child.getRight() - galleryCenter));
            if (childClosestEdgeDistance < closestEdgeDistance) {
                closestEdgeDistance = childClosestEdgeDistance;
                newSelectedChildIndex = i;
            }
        }
        
        int newPos = mFirstPosition + newSelectedChildIndex;
        
        if (newPos != mSelectedPosition) {
            setSelectedPositionInt(newPos);
            setNextSelectedPositionInt(newPos);
            checkSelectionChanged();
        }
    }

    /**
     * Creates and positions all views for this Gallery.
     * <p>
     * We layout rarely, most of the time {@link #trackMotionScroll(int)} takes
     * care of repositioning, adding, and removing children.
     * 
     * @param delta Change in the selected position. +1 means the selection is
     *            moving to the right, so views are scrolling to the left. -1
     *            means the selection is moving to the left.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.694 -0500", hash_original_method = "D35D4AE43FE4EA4BE64F388903B9B437", hash_generated_method = "EF47E26112783A6DCAC5E205AD308B9F")
    
@Override
    void layout(int delta, boolean animate) {

        mIsRtl = isLayoutRtl();

        int childrenLeft = mSpinnerPadding.left;
        int childrenWidth = mRight - mLeft - mSpinnerPadding.left - mSpinnerPadding.right;

        if (mDataChanged) {
            handleDataChanged();
        }

        // Handle an empty gallery by removing all views.
        if (mItemCount == 0) {
            resetList();
            return;
        }

        // Update to the new selected position.
        if (mNextSelectedPosition >= 0) {
            setSelectedPositionInt(mNextSelectedPosition);
        }

        // All views go in recycler while we are in layout
        recycleAllViews();

        // Clear out old views
        //removeAllViewsInLayout();
        detachAllViewsFromParent();

        /*
         * These will be used to give initial positions to views entering the
         * gallery as we scroll
         */
        mRightMost = 0;
        mLeftMost = 0;

        // Make selected view and center it
        
        /*
         * mFirstPosition will be decreased as we add views to the left later
         * on. The 0 for x will be offset in a couple lines down.
         */  
        mFirstPosition = mSelectedPosition;
        View sel = makeAndAddView(mSelectedPosition, 0, 0, true);
        
        // Put the selected child in the center
        int selectedOffset = childrenLeft + (childrenWidth / 2) - (sel.getWidth() / 2);
        sel.offsetLeftAndRight(selectedOffset);

        fillToGalleryRight();
        fillToGalleryLeft();
        
        // Flush any cached views that did not get reused above
        mRecycler.clear();

        invalidate();
        checkSelectionChanged();

        mDataChanged = false;
        mNeedSync = false;
        setNextSelectedPositionInt(mSelectedPosition);
        
        updateSelectedItemMetadata();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.696 -0500", hash_original_method = "839F6A1D55F5AD62226A4A3F94B7F961", hash_generated_method = "4A1EA5174AF2F51CE04F36842AF6AC16")
    
private void fillToGalleryLeft() {
        if (mIsRtl) {
            fillToGalleryLeftRtl();
        } else {
            fillToGalleryLeftLtr();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.699 -0500", hash_original_method = "D862865A48DB37456DB450C522985E2D", hash_generated_method = "F870AAF39BADAC416033045E6D974E6B")
    
private void fillToGalleryLeftRtl() {
        int itemSpacing = mSpacing;
        int galleryLeft = mPaddingLeft;
        int numChildren = getChildCount();
        int numItems = mItemCount;

        // Set state for initial iteration
        View prevIterationView = getChildAt(numChildren - 1);
        int curPosition;
        int curRightEdge;

        if (prevIterationView != null) {
            curPosition = mFirstPosition + numChildren;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
        } else {
            // No children available!
            mFirstPosition = curPosition = mItemCount - 1;
            curRightEdge = mRight - mLeft - mPaddingRight;
            mShouldStopFling = true;
        }

        while (curRightEdge > galleryLeft && curPosition < mItemCount) {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curRightEdge, false);

            // Set state for next iteration
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
            curPosition++;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.701 -0500", hash_original_method = "0FAB0D6FB4467E7662D35717D4E5328D", hash_generated_method = "C99177644619DF89DCCB6647B84A6FD5")
    
private void fillToGalleryLeftLtr() {
        int itemSpacing = mSpacing;
        int galleryLeft = mPaddingLeft;
        
        // Set state for initial iteration
        View prevIterationView = getChildAt(0);
        int curPosition;
        int curRightEdge;
        
        if (prevIterationView != null) {
            curPosition = mFirstPosition - 1;
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
        } else {
            // No children available!
            curPosition = 0; 
            curRightEdge = mRight - mLeft - mPaddingRight;
            mShouldStopFling = true;
        }
                
        while (curRightEdge > galleryLeft && curPosition >= 0) {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curRightEdge, false);

            // Remember some state
            mFirstPosition = curPosition;
            
            // Set state for next iteration
            curRightEdge = prevIterationView.getLeft() - itemSpacing;
            curPosition--;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.703 -0500", hash_original_method = "4542FD5BB1889445E8F3BFB504C9CA2C", hash_generated_method = "9A2565BFC859EDF1B9E0DB56BA46515A")
    
private void fillToGalleryRight() {
        if (mIsRtl) {
            fillToGalleryRightRtl();
        } else {
            fillToGalleryRightLtr();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.705 -0500", hash_original_method = "ACF31DBB20E84F8382BE455EB92D3A14", hash_generated_method = "C38537387D28055C31E0C11017E8A936")
    
private void fillToGalleryRightRtl() {
        int itemSpacing = mSpacing;
        int galleryRight = mRight - mLeft - mPaddingRight;

        // Set state for initial iteration
        View prevIterationView = getChildAt(0);
        int curPosition;
        int curLeftEdge;

        if (prevIterationView != null) {
            curPosition = mFirstPosition -1;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
        } else {
            curPosition = 0;
            curLeftEdge = mPaddingLeft;
            mShouldStopFling = true;
        }

        while (curLeftEdge < galleryRight && curPosition >= 0) {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curLeftEdge, true);

            // Remember some state
            mFirstPosition = curPosition;

            // Set state for next iteration
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
            curPosition--;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.708 -0500", hash_original_method = "79C0AF4129796B1D40A0EF3F484CF7D9", hash_generated_method = "AB453D8F210EC7C8F6D9532F0C121DD7")
    
private void fillToGalleryRightLtr() {
        int itemSpacing = mSpacing;
        int galleryRight = mRight - mLeft - mPaddingRight;
        int numChildren = getChildCount();
        int numItems = mItemCount;
        
        // Set state for initial iteration
        View prevIterationView = getChildAt(numChildren - 1);
        int curPosition;
        int curLeftEdge;
        
        if (prevIterationView != null) {
            curPosition = mFirstPosition + numChildren;
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
        } else {
            mFirstPosition = curPosition = mItemCount - 1;
            curLeftEdge = mPaddingLeft;
            mShouldStopFling = true;
        }
                
        while (curLeftEdge < galleryRight && curPosition < numItems) {
            prevIterationView = makeAndAddView(curPosition, curPosition - mSelectedPosition,
                    curLeftEdge, true);

            // Set state for next iteration
            curLeftEdge = prevIterationView.getRight() + itemSpacing;
            curPosition++;
        }
    }

    /**
     * Obtain a view, either by pulling an existing view from the recycler or by
     * getting a new one from the adapter. If we are animating, make sure there
     * is enough information in the view's layout parameters to animate from the
     * old to new positions.
     * 
     * @param position Position in the gallery for the view to obtain
     * @param offset Offset from the selected position
     * @param x X-coordinate indicating where this view should be placed. This
     *        will either be the left or right edge of the view, depending on
     *        the fromLeft parameter
     * @param fromLeft Are we positioning views based on the left edge? (i.e.,
     *        building from left to right)?
     * @return A view that has been added to the gallery
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.711 -0500", hash_original_method = "EBA268158DBADCF4BD34E1D13045F6D1", hash_generated_method = "4101D2F68B664258179ACA5C3C440E40")
    
private View makeAndAddView(int position, int offset, int x, boolean fromLeft) {

        View child;
        if (!mDataChanged) {
            child = mRecycler.get(position);
            if (child != null) {
                // Can reuse an existing view
                int childLeft = child.getLeft();
                
                // Remember left and right edges of where views have been placed
                mRightMost = Math.max(mRightMost, childLeft 
                        + child.getMeasuredWidth());
                mLeftMost = Math.min(mLeftMost, childLeft);

                // Position the view
                setUpChild(child, offset, x, fromLeft);

                return child;
            }
        }

        // Nothing found in the recycler -- ask the adapter for a view
        child = mAdapter.getView(position, null, this);

        // Position the view
        setUpChild(child, offset, x, fromLeft);

        return child;
    }

    /**
     * Helper for makeAndAddView to set the position of a view and fill out its
     * layout parameters.
     * 
     * @param child The view to position
     * @param offset Offset from the selected position
     * @param x X-coordinate indicating where this view should be placed. This
     *        will either be the left or right edge of the view, depending on
     *        the fromLeft parameter
     * @param fromLeft Are we positioning views based on the left edge? (i.e.,
     *        building from left to right)?
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.714 -0500", hash_original_method = "3126A82E5C4A08FF6B321D23FF86AF72", hash_generated_method = "BA7FEA21759AB707AFE6C68E4BBAFAC8")
    
private void setUpChild(View child, int offset, int x, boolean fromLeft) {

        // Respect layout params that are already in the view. Otherwise
        // make some up...
        Gallery.LayoutParams lp = (Gallery.LayoutParams) child.getLayoutParams();
        if (lp == null) {
            lp = (Gallery.LayoutParams) generateDefaultLayoutParams();
        }

        addViewInLayout(child, fromLeft != mIsRtl ? -1 : 0, lp);

        child.setSelected(offset == 0);

        // Get measure specs
        int childHeightSpec = ViewGroup.getChildMeasureSpec(mHeightMeasureSpec,
                mSpinnerPadding.top + mSpinnerPadding.bottom, lp.height);
        int childWidthSpec = ViewGroup.getChildMeasureSpec(mWidthMeasureSpec,
                mSpinnerPadding.left + mSpinnerPadding.right, lp.width);

        // Measure child
        child.measure(childWidthSpec, childHeightSpec);

        int childLeft;
        int childRight;

        // Position vertically based on gravity setting
        int childTop = calculateTop(child, true);
        int childBottom = childTop + child.getMeasuredHeight();

        int width = child.getMeasuredWidth();
        if (fromLeft) {
            childLeft = x;
            childRight = childLeft + width;
        } else {
            childLeft = x - width;
            childRight = x;
        }

        child.layout(childLeft, childTop, childRight, childBottom);
    }

    /**
     * Figure out vertical placement based on mGravity
     * 
     * @param child Child to place
     * @return Where the top of the child should be
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.716 -0500", hash_original_method = "D35AB7435540D0F4BFFD2328F86D6A01", hash_generated_method = "107BFF018AB9A289802BDEAFD968A9A7")
    
private int calculateTop(View child, boolean duringLayout) {
        int myHeight = duringLayout ? getMeasuredHeight() : getHeight();
        int childHeight = duringLayout ? child.getMeasuredHeight() : child.getHeight();
        
        int childTop = 0;

        switch (mGravity) {
        case Gravity.TOP:
            childTop = mSpinnerPadding.top;
            break;
        case Gravity.CENTER_VERTICAL:
            int availableSpace = myHeight - mSpinnerPadding.bottom
                    - mSpinnerPadding.top - childHeight;
            childTop = mSpinnerPadding.top + (availableSpace / 2);
            break;
        case Gravity.BOTTOM:
            childTop = myHeight - mSpinnerPadding.bottom - childHeight;
            break;
        }
        return childTop;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.719 -0500", hash_original_method = "E3817DF605584D2699E850A6FB85E3EE", hash_generated_method = "6421945AA01D8D94E2D98D8C1C1D7DE7")
    
@Override
    public boolean onTouchEvent(MotionEvent event) {

        // Give everything to the gesture detector
        boolean retValue = mGestureDetector.onTouchEvent(event);

        int action = event.getAction();
        if (action == MotionEvent.ACTION_UP) {
            // Helper method for lifted finger
            onUp();
        } else if (action == MotionEvent.ACTION_CANCEL) {
            onCancel();
        }
        
        return retValue;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.722 -0500", hash_original_method = "19210549229636CE2242C372109B66CE", hash_generated_method = "5F54BEDA3A470E8393EDECDB5EB67EBE")
    
@Override
    public boolean onSingleTapUp(MotionEvent e) {

        if (mDownTouchPosition >= 0) {
            
            // An item tap should make it selected, so scroll to this child.
            scrollToChild(mDownTouchPosition - mFirstPosition);

            // Also pass the click so the client knows, if it wants to.
            if (mShouldCallbackOnUnselectedItemClick || mDownTouchPosition == mSelectedPosition) {
                performItemClick(mDownTouchView, mDownTouchPosition, mAdapter
                        .getItemId(mDownTouchPosition));
            }
            
            return true;
        }
        
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.724 -0500", hash_original_method = "FF9AB11CCCE118D19142CC6F38731AB8", hash_generated_method = "0C7145EAEFE08E6BECEE52314B3CA311")
    
@Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        
        if (!mShouldCallbackDuringFling) {
            // We want to suppress selection changes
            
            // Remove any future code to set mSuppressSelectionChanged = false
            removeCallbacks(mDisableSuppressSelectionChangedRunnable);

            // This will get reset once we scroll into slots
            if (!mSuppressSelectionChanged) mSuppressSelectionChanged = true;
        }
        
        // Fling the gallery!
        mFlingRunnable.startUsingVelocity((int) -velocityX);
        
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.727 -0500", hash_original_method = "31AEC3B6889F8B31520E6C555165373C", hash_generated_method = "36F7490D851D27D946F6036397710B79")
    
@Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        if (localLOGV) Log.v(TAG, String.valueOf(e2.getX() - e1.getX()));
        
        /*
         * Now's a good time to tell our parent to stop intercepting our events!
         * The user has moved more than the slop amount, since GestureDetector
         * ensures this before calling this method. Also, if a parent is more
         * interested in this touch's events than we are, it would have
         * intercepted them by now (for example, we can assume when a Gallery is
         * in the ListView, a vertical scroll would not end up in this method
         * since a ListView would have intercepted it by now).
         */
        mParent.requestDisallowInterceptTouchEvent(true);
        
        // As the user scrolls, we want to callback selection changes so related-
        // info on the screen is up-to-date with the gallery's selection
        if (!mShouldCallbackDuringFling) {
            if (mIsFirstScroll) {
                /*
                 * We're not notifying the client of selection changes during
                 * the fling, and this scroll could possibly be a fling. Don't
                 * do selection changes until we're sure it is not a fling.
                 */
                if (!mSuppressSelectionChanged) mSuppressSelectionChanged = true;
                postDelayed(mDisableSuppressSelectionChangedRunnable, SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT);
            }
        } else {
            if (mSuppressSelectionChanged) mSuppressSelectionChanged = false;
        }
        
        // Track the motion
        trackMotionScroll(-1 * (int) distanceX);
       
        mIsFirstScroll = false;
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.729 -0500", hash_original_method = "79E55760FD5CE82C40C265BE8CDD4846", hash_generated_method = "7C075FF0D1620BB011034A95375D4E60")
    
@Override
    public boolean onDown(MotionEvent e) {

        // Kill any existing fling/scroll
        mFlingRunnable.stop(false);

        // Get the item's view that was touched
        mDownTouchPosition = pointToPosition((int) e.getX(), (int) e.getY());
        
        if (mDownTouchPosition >= 0) {
            mDownTouchView = getChildAt(mDownTouchPosition - mFirstPosition);
            mDownTouchView.setPressed(true);
        }
        
        // Reset the multiple-scroll tracking state
        mIsFirstScroll = true;
        
        // Must return true to get matching events for this down event.
        return true;
    }

    /**
     * Called when a touch event's action is MotionEvent.ACTION_UP.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.731 -0500", hash_original_method = "DF867D53E770A9464F52B7BCD42362AA", hash_generated_method = "DF867D53E770A9464F52B7BCD42362AA")
    
void onUp() {
        
        if (mFlingRunnable.mScroller.isFinished()) {
            scrollIntoSlots();
        }
        
        dispatchUnpress();
    }
    
    /**
     * Called when a touch event's action is MotionEvent.ACTION_CANCEL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.733 -0500", hash_original_method = "BB906BFFF3DF010D02CEEC7D1D49931B", hash_generated_method = "BB906BFFF3DF010D02CEEC7D1D49931B")
    
void onCancel() {
        onUp();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.736 -0500", hash_original_method = "950A20F4ED2CBD08065028F466CBAED0", hash_generated_method = "E2C73A1A4E27F25B082F9C937882FF58")
    
@Override
    public void onLongPress(MotionEvent e) {
        
        if (mDownTouchPosition < 0) {
            return;
        }
        
        performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        long id = getItemIdAtPosition(mDownTouchPosition);
        dispatchLongPress(mDownTouchView, mDownTouchPosition, id);
    }

    // Unused methods from GestureDetector.OnGestureListener below
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.738 -0500", hash_original_method = "54A2BF3809B435C5302401FC76B54B22", hash_generated_method = "3305222AE6E8BD09D6A57E3FA5D84531")
    
@Override
    public void onShowPress(MotionEvent e) {
    }

    // Unused methods from GestureDetector.OnGestureListener above
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.740 -0500", hash_original_method = "1D9BFD40F04CA79251504E98D313D5F0", hash_generated_method = "A9ED28094450555F21715B7A83DBED71")
    
private void dispatchPress(View child) {
        
        if (child != null) {
            child.setPressed(true);
        }
        
        setPressed(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.743 -0500", hash_original_method = "E1E46A91FBA826DABF74EF3365F5DA5C", hash_generated_method = "8433D9EC7E1828B51EF62B94001C04D7")
    
private void dispatchUnpress() {
        
        for (int i = getChildCount() - 1; i >= 0; i--) {
            getChildAt(i).setPressed(false);
        }
        
        setPressed(false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.745 -0500", hash_original_method = "64CD219059FB9E526665FE8867E1D4B8", hash_generated_method = "3D4567BB4218E68A36E41367FF2B71A6")
    
@Override
    public void dispatchSetSelected(boolean selected) {
        /*
         * We don't want to pass the selected state given from its parent to its
         * children since this widget itself has a selected state to give to its
         * children.
         */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.747 -0500", hash_original_method = "E41129AA485100A2EB69B5BDBC887DF8", hash_generated_method = "0A657DB5970B390B0C3A3705BECA3094")
    
@Override
    protected void dispatchSetPressed(boolean pressed) {
        
        // Show the pressed state on the selected child
        if (mSelectedChild != null) {
            mSelectedChild.setPressed(pressed);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.750 -0500", hash_original_method = "9F181134B78CDA48AEB577EDC6EC32D7", hash_generated_method = "C74931322D1253C60B3FA17254B847DB")
    
@Override
    protected ContextMenuInfo getContextMenuInfo() {
        return mContextMenuInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.752 -0500", hash_original_method = "DF59CF50500B4E9CE839452AD8F1A8F9", hash_generated_method = "F501CD069421095487B440BBADA03483")
    
@Override
    public boolean showContextMenuForChild(View originalView) {

        final int longPressPosition = getPositionForView(originalView);
        if (longPressPosition < 0) {
            return false;
        }
        
        final long longPressId = mAdapter.getItemId(longPressPosition);
        return dispatchLongPress(originalView, longPressPosition, longPressId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.754 -0500", hash_original_method = "13C9F6F3E3362B5D837B194E32B9E579", hash_generated_method = "416684C83F05A37987896A87A8E87C2F")
    
@Override
    public boolean showContextMenu() {
        
        if (isPressed() && mSelectedPosition >= 0) {
            int index = mSelectedPosition - mFirstPosition;
            View v = getChildAt(index);
            return dispatchLongPress(v, mSelectedPosition, mSelectedRowId);
        }
        
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.757 -0500", hash_original_method = "087BDC5665C59A77437D4D81045FF0E8", hash_generated_method = "7C7542789A57FAF04017148C0D05A387")
    
private boolean dispatchLongPress(View view, int position, long id) {
        boolean handled = false;
        
        if (mOnItemLongClickListener != null) {
            handled = mOnItemLongClickListener.onItemLongClick(this, mDownTouchView,
                    mDownTouchPosition, id);
        }

        if (!handled) {
            mContextMenuInfo = new AdapterContextMenuInfo(view, position, id);
            handled = super.showContextMenuForChild(this);
        }

        if (handled) {
            performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
        }
        
        return handled;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.759 -0500", hash_original_method = "3AE09BEF1C913F03964B3B1FAAECBEDB", hash_generated_method = "8B4C961C9741B8B4B4BFDD9C057CC6D4")
    
@Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        // Gallery steals all key events
        return event.dispatch(this, null, null);
    }

    /**
     * Handles left, right, and clicking
     * @see android.view.View#onKeyDown
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.762 -0500", hash_original_method = "869521EFCB7C5245B063DFB17EC10284", hash_generated_method = "C1528D544A2327E9216257B325B00EE3")
    
@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            
        case KeyEvent.KEYCODE_DPAD_LEFT:
            if (movePrevious()) {
                playSoundEffect(SoundEffectConstants.NAVIGATION_LEFT);
            }
            return true;

        case KeyEvent.KEYCODE_DPAD_RIGHT:
            if (moveNext()) {
                playSoundEffect(SoundEffectConstants.NAVIGATION_RIGHT);
            }
            return true;

        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER:
            mReceivedInvokeKeyDown = true;
            // fallthrough to default handling
        }
        
        return super.onKeyDown(keyCode, event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.768 -0500", hash_original_method = "35A1E5E2696C4EED13BCBB9C99C03D0D", hash_generated_method = "71C6D66516CD89A5505DC5591A94C23E")
    
@Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_CENTER:
        case KeyEvent.KEYCODE_ENTER: {
            
            if (mReceivedInvokeKeyDown) {
                if (mItemCount > 0) {
    
                    dispatchPress(mSelectedChild);
                    postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dispatchUnpress();
                        }
                    }, ViewConfiguration.getPressedStateDuration());
    
                    int selectedIndex = mSelectedPosition - mFirstPosition;
                    performItemClick(getChildAt(selectedIndex), mSelectedPosition, mAdapter
                            .getItemId(mSelectedPosition));
                }
            }
            
            // Clear the flag
            mReceivedInvokeKeyDown = false;
            
            return true;
        }
        }

        return super.onKeyUp(keyCode, event);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.770 -0500", hash_original_method = "B9B4077A4E7C2CAD102566E406F7FE8F", hash_generated_method = "B9B4077A4E7C2CAD102566E406F7FE8F")
    
boolean movePrevious() {
        if (mItemCount > 0 && mSelectedPosition > 0) {
            scrollToChild(mSelectedPosition - mFirstPosition - 1);
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.773 -0500", hash_original_method = "AB8E3EDC49D155A48AE82C24C38C480C", hash_generated_method = "AB8E3EDC49D155A48AE82C24C38C480C")
    
boolean moveNext() {
        if (mItemCount > 0 && mSelectedPosition < mItemCount - 1) {
            scrollToChild(mSelectedPosition - mFirstPosition + 1);
            return true;
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.775 -0500", hash_original_method = "5A90FC6E5774B3D3ABB7606C34F54E47", hash_generated_method = "8D1AC1B5C868498241972945C66D30DE")
    
private boolean scrollToChild(int childPosition) {
        View child = getChildAt(childPosition);
        
        if (child != null) {
            int distance = getCenterOfGallery() - getCenterOfView(child);
            mFlingRunnable.startUsingDistance(distance);
            return true;
        }
        
        return false;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.777 -0500", hash_original_method = "82657633CA542FCF70C69B7A0BF2796A", hash_generated_method = "5883635F027EAC83B7089E6761FD3333")
    
@Override
    void setSelectedPositionInt(int position) {
        super.setSelectedPositionInt(position);

        // Updates any metadata we keep about the selected item.
        updateSelectedItemMetadata();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.780 -0500", hash_original_method = "5BE8AB05B464B00AB61974AD30001B4B", hash_generated_method = "50F5C67EF899416DEFB94C04CFAF5216")
    
private void updateSelectedItemMetadata() {
        
        View oldSelectedChild = mSelectedChild;

        View child = mSelectedChild = getChildAt(mSelectedPosition - mFirstPosition);
        if (child == null) {
            return;
        }

        child.setSelected(true);
        child.setFocusable(true);

        if (hasFocus()) {
            child.requestFocus();
        }

        // We unfocus the old child down here so the above hasFocus check
        // returns true
        if (oldSelectedChild != null && oldSelectedChild != child) {

            // Make sure its drawable state doesn't contain 'selected'
            oldSelectedChild.setSelected(false);
            
            // Make sure it is not focusable anymore, since otherwise arrow keys
            // can make this one be focused
            oldSelectedChild.setFocusable(false);
        }
        
    }
    
    private class FlingRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.791 -0500", hash_original_field = "16226695B3E75E1B75AD8C16FE7698DB", hash_generated_field = "AB39B37744A8B63C82246C1F6FE6730F")

        private Scroller mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.793 -0500", hash_original_field = "1292A9CAAEB1FAA8B992CC3019E978E2", hash_generated_field = "F42B0D92269D459078CB705414F5747B")

        private int mLastFlingX;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.795 -0500", hash_original_method = "264C65CD320EB0D5C27B975805273D03", hash_generated_method = "2A799263EBB05BE2ADD6D543B41F7241")
        
public FlingRunnable() {
            mScroller = new Scroller(getContext());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.797 -0500", hash_original_method = "3F5AABA0482FB6C4BDC6EF9DB417DE5D", hash_generated_method = "3E5E7C56528D7F64B0A4B71837AD8310")
        
private void startCommon() {
            // Remove any pending flings
            removeCallbacks(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.800 -0500", hash_original_method = "955705EE1931522BF2E85D1EE1E713EB", hash_generated_method = "E7AE5E764D6E98FA14D8107CAE39AB06")
        
public void startUsingVelocity(int initialVelocity) {
            if (initialVelocity == 0) return;
            
            startCommon();
            
            int initialX = initialVelocity < 0 ? Integer.MAX_VALUE : 0;
            mLastFlingX = initialX;
            mScroller.fling(initialX, 0, initialVelocity, 0,
                    0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            post(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.802 -0500", hash_original_method = "6C25F473B54155D80760EA13DABD7B6F", hash_generated_method = "4221E65D2EF2EAA8EE8C67D155905621")
        
public void startUsingDistance(int distance) {
            if (distance == 0) return;
            
            startCommon();
            
            mLastFlingX = 0;
            mScroller.startScroll(0, 0, -distance, 0, mAnimationDuration);
            post(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.805 -0500", hash_original_method = "6E0F8E80A40548586D045381AEB2168E", hash_generated_method = "1F984A3D6043C8A3C58B063EDB1D77B4")
        
public void stop(boolean scrollIntoSlots) {
            removeCallbacks(this);
            endFling(scrollIntoSlots);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.807 -0500", hash_original_method = "E61C8A0CE9EFA11B9E0089A9EE90DD3F", hash_generated_method = "3D0F24645D45FB84D01DADF14D4D4E80")
        
private void endFling(boolean scrollIntoSlots) {
            /*
             * Force the scroller's status to finished (without setting its
             * position to the end)
             */
            mScroller.forceFinished(true);
            
            if (scrollIntoSlots) scrollIntoSlots();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.810 -0500", hash_original_method = "201C15A7F851961F5BCBCACEEAE4B252", hash_generated_method = "B66377B3D3DA3C00F95C7EB3E42BD424")
        
@Override
        public void run() {

            if (mItemCount == 0) {
                endFling(true);
                return;
            }

            mShouldStopFling = false;
            
            final Scroller scroller = mScroller;
            boolean more = scroller.computeScrollOffset();
            final int x = scroller.getCurrX();

            // Flip sign to convert finger direction to list items direction
            // (e.g. finger moving down means list is moving towards the top)
            int delta = mLastFlingX - x;

            // Pretend that each frame of a fling scroll is a touch scroll
            if (delta > 0) {
                // Moving towards the left. Use leftmost view as mDownTouchPosition
                mDownTouchPosition = mIsRtl ? (mFirstPosition + getChildCount() - 1) :
                    mFirstPosition;

                // Don't fling more than 1 screen
                delta = Math.min(getWidth() - mPaddingLeft - mPaddingRight - 1, delta);
            } else {
                // Moving towards the right. Use rightmost view as mDownTouchPosition
                int offsetToLast = getChildCount() - 1;
                mDownTouchPosition = mIsRtl ? mFirstPosition :
                    (mFirstPosition + getChildCount() - 1);

                // Don't fling more than 1 screen
                delta = Math.max(-(getWidth() - mPaddingRight - mPaddingLeft - 1), delta);
            }

            trackMotionScroll(delta);

            if (more && !mShouldStopFling) {
                mLastFlingX = x;
                post(this);
            } else {
               endFling(true);
            }
        }
        
    }
    
    public static class LayoutParams extends ViewGroup.LayoutParams {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.816 -0500", hash_original_method = "35869249D2D5BC08819A8507F87D33FD", hash_generated_method = "72A2ECA2CF4C647C2D28F670D4DC27E1")
        
public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.819 -0500", hash_original_method = "979C42732F8B715475115A738CE7596D", hash_generated_method = "A7516D57E99F3298A4CB1C063C44A289")
        
public LayoutParams(int w, int h) {
            super(w, h);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.822 -0500", hash_original_method = "E78B3F1574E2791FC4B55C9E6B90274C", hash_generated_method = "35FAB65EFD30EE5BC910187CB4DA6F67")
        
public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
        
    }
    
    /**
     * Describes how the child views are aligned.
     * @param gravity
     * 
     * @attr ref android.R.styleable#Gallery_gravity
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.783 -0500", hash_original_method = "9F21F0E85C8E2888CEB908FEF2F39583", hash_generated_method = "72EFEA5FC54F1383B478C276F211C3F6")
    
public void setGravity(int gravity)
    {
        if (mGravity != gravity) {
            mGravity = gravity;
            requestLayout();
        }
    }

    @DSSource({DSSourceKind.IMAGE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.785 -0500", hash_original_method = "34F7E6D982F42148FE21035817D6C89A", hash_generated_method = "41F5743BA289E5E9B29F59B4FE53F3E8")
    
@Override
    protected int getChildDrawingOrder(int childCount, int i) {
        int selectedIndex = mSelectedPosition - mFirstPosition;
        
        // Just to be safe
        if (selectedIndex < 0) return i;
        
        if (i == childCount - 1) {
            // Draw the selected child last
            return selectedIndex;
        } else if (i >= selectedIndex) {
            // Move the children after the selected child earlier one
            return i + 1;
        } else {
            // Keep the children before the selected child the same
            return i;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.788 -0500", hash_original_method = "4530040537B7815650EC9BAF20F8ED51", hash_generated_method = "8990BA1CE6B5FF5C38C53FE8C5355CD2")
    
@Override
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        
        /*
         * The gallery shows focus by focusing the selected item. So, give
         * focus to our selected item instead. We steal keys from our
         * selected item elsewhere.
         */
        if (gainFocus && mSelectedChild != null) {
            mSelectedChild.requestFocus(direction);
            mSelectedChild.setSelected(true);
        }

    }
}

