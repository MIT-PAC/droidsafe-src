package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;

public class HorizontalScrollView extends FrameLayout {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.232 -0500", hash_original_field = "3FD9DE2E7ACDE8FAD0D5A8751E971404", hash_generated_field = "4083FF51B3491C57DFF4E035C0066C80")

    private static final int ANIMATED_SCROLL_GAP = ScrollView.ANIMATED_SCROLL_GAP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.234 -0500", hash_original_field = "C9A08FFD1AE29B036C2442D3086782D5", hash_generated_field = "49356EE5727E8BD04682A1AF4FB39A2B")

    private static final float MAX_SCROLL_FACTOR = ScrollView.MAX_SCROLL_FACTOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.274 -0500", hash_original_field = "394D213079DFA0C7024EC13F5673BC94", hash_generated_field = "E2DAEB44FC73F85759FCDB42BA10BD3A")

    private static final int INVALID_POINTER = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.236 -0500", hash_original_field = "D9542227DCB2FC07C7FAE482DB504F32", hash_generated_field = "507FF60BF6AED501221786F4F9B1C4CE")

    private long mLastScroll;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.238 -0500", hash_original_field = "1732EB32F2D77CCA26590AEEA670A175", hash_generated_field = "A498F2A4744F31D22F9C4ABEBB254F2F")

    private final Rect mTempRect = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.240 -0500", hash_original_field = "63F6CA74EEC786DAEE7A49BF47815C33", hash_generated_field = "7106C69F4E49AB9D7F59F38965DF6036")

    private OverScroller mScroller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.242 -0500", hash_original_field = "AB466C21A8C0EFB1258BE5B8AEDC0AEE", hash_generated_field = "CF32CFBB2A976E850EE8DDE803F384D7")

    private EdgeEffect mEdgeGlowLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.244 -0500", hash_original_field = "D72EE1527B1D097DEA57A6FAE9C1FBB8", hash_generated_field = "304A2CBEA7C331CEDE170973F40765C0")

    private EdgeEffect mEdgeGlowRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.247 -0500", hash_original_field = "AF635AE840C182EEA99A9AE862C0C835", hash_generated_field = "90F53F7625CC0EEE4DC6EBCFF5E518A6")

    private float mLastMotionX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.249 -0500", hash_original_field = "DF1ADEB95073CF45973097626A84DFA1", hash_generated_field = "9C16E67A6EDB3E799E01AFB02BCF7815")

    private boolean mIsLayoutDirty = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.251 -0500", hash_original_field = "51DC3670A1E97DCCC76E21C86FB0723E", hash_generated_field = "7E1EAB0DC4AB4B81BAB22B01D588949E")

    private View mChildToScrollTo = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.252 -0500", hash_original_field = "07D70005FA65E4E17EF3C074C23EF454", hash_generated_field = "40AA109CDE3739730D8C499D23D26FF1")

    private boolean mIsBeingDragged = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.254 -0500", hash_original_field = "507D8F8387EDC230B54D84A5AD8E5830", hash_generated_field = "5BEE30D4541C1ECA385873E799FC4104")

    private VelocityTracker mVelocityTracker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.257 -0500", hash_original_field = "A886682D4FD7C0E913E0928B1EC54700", hash_generated_field = "16DDF79C39D64DD0F8B72040D2242A75")

    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mFillViewport;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.259 -0500", hash_original_field = "90DDBB381FF7AE3EBB8D9F811B85F0BF", hash_generated_field = "EA3AE5CC17F6060C1DBAA2AAAFFFC35C")

    private boolean mSmoothScrollingEnabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.261 -0500", hash_original_field = "D11C33EFD56B37B918E01A200C446C59", hash_generated_field = "3B323323DD6A6BF972666D993592C670")

    private int mTouchSlop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.263 -0500", hash_original_field = "0DAB51CD5AD14EAFA0DBAE048171A484", hash_generated_field = "7DBE1A18599B8760DC9B67AAFE3499E3")

    private int mMinimumVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.265 -0500", hash_original_field = "EBB696916B500EA5521AFFF60D013E17", hash_generated_field = "6F997413D0B227487940C402EB78A8FD")

    private int mMaximumVelocity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.267 -0500", hash_original_field = "3140A319F32CA873045621864B655537", hash_generated_field = "7B0107E1CAE9FFC281D766335539D7C4")

    private int mOverscrollDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.269 -0500", hash_original_field = "F239C82AEB45C28104273F86A78E6F04", hash_generated_field = "06022A8A798B4C892D35D0FFB16D2FDF")

    private int mOverflingDistance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.271 -0500", hash_original_field = "D0914C40920996908439839B104BE272", hash_generated_field = "1B464B20D80463EC30779F63AB0559BD")

    private int mActivePointerId = INVALID_POINTER;

    @DSComment("GUI ScrollView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.276 -0500", hash_original_method = "D579CCE5E39252987369F5EF7BC67FC0", hash_generated_method = "D2A1ED907989CB8AE7E671C6AA739D41")
    
public HorizontalScrollView(Context context) {
        this(context, null);
    }

    @DSComment("GUI ScrollView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.279 -0500", hash_original_method = "7F7EA51B0CF52F1D171B225CFAE9439C", hash_generated_method = "2B72C29D39762F5873CF99AA0C283574")
    
public HorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, com.android.internal.R.attr.horizontalScrollViewStyle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.281 -0500", hash_original_method = "ABF3CE2040AE9A0702C38DF91EEF10E7", hash_generated_method = "CED8F03071A47F49443E17D9C2289960")
    
public HorizontalScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initScrollView();

        TypedArray a = context.obtainStyledAttributes(attrs,
                android.R.styleable.HorizontalScrollView, defStyle, 0);

        setFillViewport(a.getBoolean(android.R.styleable.HorizontalScrollView_fillViewport, false));

        a.recycle();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.284 -0500", hash_original_method = "041555434146A9B8485461655BD1A318", hash_generated_method = "336DE90073D98B769C28AFCA6BC51D35")
    
@Override
    protected float getLeftFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }

        final int length = getHorizontalFadingEdgeLength();
        if (mScrollX < length) {
            return mScrollX / (float) length;
        }

        return 1.0f;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.287 -0500", hash_original_method = "AC1CCEB780F155A105BA88465002385B", hash_generated_method = "3BFAA2C78CD446355B6C0774F9BC879B")
    
@Override
    protected float getRightFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }

        final int length = getHorizontalFadingEdgeLength();
        final int rightEdge = getWidth() - mPaddingRight;
        final int span = getChildAt(0).getRight() - mScrollX - rightEdge;
        if (span < length) {
            return span / (float) length;
        }

        return 1.0f;
    }

    /**
     * @return The maximum amount this scroll view will scroll in response to
     *   an arrow event.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.289 -0500", hash_original_method = "F72D9B4700B8FCB550AB26E9792E603C", hash_generated_method = "9F4D0E6F3D1198C699BE79EBF1321D8D")
    
public int getMaxScrollAmount() {
        return (int) (MAX_SCROLL_FACTOR * (mRight - mLeft));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.292 -0500", hash_original_method = "02BBAF53D85E267FB240E2D4309C877F", hash_generated_method = "A421A744020FEE9AE61BC6A77CA31282")
    
private void initScrollView() {
        mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setWillNotDraw(false);
        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        mTouchSlop = configuration.getScaledTouchSlop();
        mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
        mOverscrollDistance = configuration.getScaledOverscrollDistance();
        mOverflingDistance = configuration.getScaledOverflingDistance();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.294 -0500", hash_original_method = "28BB619967A3B168E514D899D7C1C204", hash_generated_method = "9D1C3B96689DCDF0B1A49A0AB51BF9FF")
    
@Override
    public void addView(View child) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }

        super.addView(child);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.296 -0500", hash_original_method = "D082E00953E9B886F1BBE563E072EA76", hash_generated_method = "78FBFA57B283ACA3C68708D7711A7C54")
    
@Override
    public void addView(View child, int index) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }

        super.addView(child, index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.299 -0500", hash_original_method = "35F41E1C04BFB475A60C431B3898F857", hash_generated_method = "C7DA6045DF862F88C60FB26E742EB660")
    
@Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }

        super.addView(child, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.301 -0500", hash_original_method = "D331A2B6162E307FE1F025F2ABEA7C28", hash_generated_method = "87D1BBB9E4B02C31B82837630EAD72AF")
    
@Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }

        super.addView(child, index, params);
    }

    /**
     * @return Returns true this HorizontalScrollView can be scrolled
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.303 -0500", hash_original_method = "3DE53F922B0BEA48963A7A11A88BC712", hash_generated_method = "2763E0CD09B77FB67F22F58512B23C25")
    
private boolean canScroll() {
        View child = getChildAt(0);
        if (child != null) {
            int childWidth = child.getWidth();
            return getWidth() < childWidth + mPaddingLeft + mPaddingRight ;
        }
        return false;
    }

    /**
     * Indicates whether this HorizontalScrollView's content is stretched to
     * fill the viewport.
     *
     * @return True if the content fills the viewport, false otherwise.
     *
     * @attr ref android.R.styleable#HorizontalScrollView_fillViewport
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.306 -0500", hash_original_method = "801E6F065AC6A60CFB0DADB1E074F98E", hash_generated_method = "FE89B3D9E111D9452617D72FD1A81EFB")
    
public boolean isFillViewport() {
        return mFillViewport;
    }

    /**
     * Indicates this HorizontalScrollView whether it should stretch its content width
     * to fill the viewport or not.
     *
     * @param fillViewport True to stretch the content's width to the viewport's
     *        boundaries, false otherwise.
     *
     * @attr ref android.R.styleable#HorizontalScrollView_fillViewport
     */
    @DSComment("GUI ScrollView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.308 -0500", hash_original_method = "D2588C7F74D0E18DF5DFA629FE7BF270", hash_generated_method = "A64DADFD660136638B7F706FF35E5E5A")
    
public void setFillViewport(boolean fillViewport) {
        if (fillViewport != mFillViewport) {
            mFillViewport = fillViewport;
            requestLayout();
        }
    }

    /**
     * @return Whether arrow scrolling will animate its transition.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.310 -0500", hash_original_method = "D26C58327C0CB18AC1F62B7629FD16B1", hash_generated_method = "215F8489CF697616420EA3B17AADC119")
    
public boolean isSmoothScrollingEnabled() {
        return mSmoothScrollingEnabled;
    }

    /**
     * Set whether arrow scrolling will animate its transition.
     * @param smoothScrollingEnabled whether arrow scrolling will animate its transition
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.313 -0500", hash_original_method = "63C96CE84D9CD60CA1FF4EF87D7FF4F5", hash_generated_method = "99B8A5D779A7F4F6473D453EABBC7A79")
    
public void setSmoothScrollingEnabled(boolean smoothScrollingEnabled) {
        mSmoothScrollingEnabled = smoothScrollingEnabled;
    }

    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.315 -0500", hash_original_method = "1306D2831DF4DA9A5EDAD3DA6127274D", hash_generated_method = "50396C5A815C0E92BC03BEF384D611DA")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!mFillViewport) {
            return;
        }

        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        if (widthMode == MeasureSpec.UNSPECIFIED) {
            return;
        }

        if (getChildCount() > 0) {
            final View child = getChildAt(0);
            int width = getMeasuredWidth();
            if (child.getMeasuredWidth() < width) {
                final FrameLayout.LayoutParams lp = (LayoutParams) child.getLayoutParams();

                int childHeightMeasureSpec = getChildMeasureSpec(heightMeasureSpec, mPaddingTop
                        + mPaddingBottom, lp.height);
                width -= mPaddingLeft;
                width -= mPaddingRight;
                int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);

                child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.318 -0500", hash_original_method = "40D3C8E04EF2AEB04EFDF302E05EC516", hash_generated_method = "551369F2F29D29AB7F8957B48A0A5D90")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.320 -0500", hash_original_method = "59EE8B926A303894927E6FAD605B1FF1", hash_generated_method = "598276C53CB1A0FFFA8837C381C62A52")
    
public boolean executeKeyEvent(KeyEvent event) {
        mTempRect.setEmpty();

        if (!canScroll()) {
            if (isFocused()) {
                View currentFocused = findFocus();
                if (currentFocused == this) currentFocused = null;
                View nextFocused = FocusFinder.getInstance().findNextFocus(this,
                        currentFocused, View.FOCUS_RIGHT);
                return nextFocused != null && nextFocused != this &&
                        nextFocused.requestFocus(View.FOCUS_RIGHT);
            }
            return false;
        }

        boolean handled = false;
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    if (!event.isAltPressed()) {
                        handled = arrowScroll(View.FOCUS_LEFT);
                    } else {
                        handled = fullScroll(View.FOCUS_LEFT);
                    }
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    if (!event.isAltPressed()) {
                        handled = arrowScroll(View.FOCUS_RIGHT);
                    } else {
                        handled = fullScroll(View.FOCUS_RIGHT);
                    }
                    break;
                case KeyEvent.KEYCODE_SPACE:
                    pageScroll(event.isShiftPressed() ? View.FOCUS_LEFT : View.FOCUS_RIGHT);
                    break;
            }
        }

        return handled;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.323 -0500", hash_original_method = "9319BD4BC402BC56524E94C60EDF0AE3", hash_generated_method = "28B6776DFF3221F464A259D6A2A9FC06")
    
private boolean inChild(int x, int y) {
        if (getChildCount() > 0) {
            final int scrollX = mScrollX;
            final View child = getChildAt(0);
            return !(y < child.getTop()
                    || y >= child.getBottom()
                    || x < child.getLeft() - scrollX
                    || x >= child.getRight() - scrollX);
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.325 -0500", hash_original_method = "2F2E3E2ED97C397B1954EFE1C35FD1EF", hash_generated_method = "F9D22C31D08E36D4828AC957FB6E63CE")
    
private void initOrResetVelocityTracker() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        } else {
            mVelocityTracker.clear();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.328 -0500", hash_original_method = "2C2F1E0A6C232182F8110D9EE75ED47E", hash_generated_method = "25A96CF18DC9437B446AAF930F7FF708")
    
private void initVelocityTrackerIfNotExists() {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.331 -0500", hash_original_method = "FC3B581D4963BCED4340031BA20C5421", hash_generated_method = "888BC5313EDF5CCF425023EC279AC988")
    
private void recycleVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.334 -0500", hash_original_method = "C74400E8950C106883E854683AF24673", hash_generated_method = "380B42A57FDB98874C1102C177E2B33A")
    
@Override
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.338 -0500", hash_original_method = "B8EBEABAF4D085F1DC9FA2F6547DBF28", hash_generated_method = "480BABA95BAAD11F9B504B2A6E96E5FD")
    
@Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        /*
         * This method JUST determines whether we want to intercept the motion.
         * If we return true, onMotionEvent will be called and we do the actual
         * scrolling there.
         */

        /*
        * Shortcut the most recurring case: the user is in the dragging
        * state and he is moving his finger.  We want to intercept this
        * motion.
        */
        final int action = ev.getAction();
        if ((action == MotionEvent.ACTION_MOVE) && (mIsBeingDragged)) {
            return true;
        }

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_MOVE: {
                /*
                 * mIsBeingDragged == false, otherwise the shortcut would have caught it. Check
                 * whether the user has moved far enough from his original down touch.
                 */

                /*
                * Locally do absolute value. mLastMotionX is set to the x value
                * of the down event.
                */
                final int activePointerId = mActivePointerId;
                if (activePointerId == INVALID_POINTER) {
                    // If we don't have a valid id, the touch down wasn't on content.
                    break;
                }

                final int pointerIndex = ev.findPointerIndex(activePointerId);
                final float x = ev.getX(pointerIndex);
                final int xDiff = (int) Math.abs(x - mLastMotionX);
                if (xDiff > mTouchSlop) {
                    mIsBeingDragged = true;
                    mLastMotionX = x;
                    initVelocityTrackerIfNotExists();
                    mVelocityTracker.addMovement(ev);
                    if (mParent != null) mParent.requestDisallowInterceptTouchEvent(true);
                }
                break;
            }

            case MotionEvent.ACTION_DOWN: {
                final float x = ev.getX();
                if (!inChild((int) x, (int) ev.getY())) {
                    mIsBeingDragged = false;
                    recycleVelocityTracker();
                    break;
                }

                /*
                 * Remember location of down touch.
                 * ACTION_DOWN always refers to pointer index 0.
                 */
                mLastMotionX = x;
                mActivePointerId = ev.getPointerId(0);

                initOrResetVelocityTracker();
                mVelocityTracker.addMovement(ev);

                /*
                * If being flinged and user touches the screen, initiate drag;
                * otherwise don't.  mScroller.isFinished should be false when
                * being flinged.
                */
                mIsBeingDragged = !mScroller.isFinished();
                break;
            }

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                /* Release the drag */
                mIsBeingDragged = false;
                mActivePointerId = INVALID_POINTER;
                if (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0)) {
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_POINTER_DOWN: {
                final int index = ev.getActionIndex();
                mLastMotionX = ev.getX(index);
                mActivePointerId = ev.getPointerId(index);
                break;
            }
            case MotionEvent.ACTION_POINTER_UP:
                onSecondaryPointerUp(ev);
                mLastMotionX = ev.getX(ev.findPointerIndex(mActivePointerId));
                break;
        }

        /*
        * The only time we want to intercept motion events is if we are in the
        * drag mode.
        */
        return mIsBeingDragged;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.343 -0500", hash_original_method = "DC232709D0DE420641FAAFB6B744429B", hash_generated_method = "69557E58E5094EC983CF75F19A0A94FA")
    
@Override
    public boolean onTouchEvent(MotionEvent ev) {
        initVelocityTrackerIfNotExists();
        mVelocityTracker.addMovement(ev);

        final int action = ev.getAction();

        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN: {
                mIsBeingDragged = getChildCount() != 0;
                if (!mIsBeingDragged) {
                    return false;
                }

                /*
                 * If being flinged and user touches, stop the fling. isFinished
                 * will be false if being flinged.
                 */
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }

                // Remember where the motion event started
                mLastMotionX = ev.getX();
                mActivePointerId = ev.getPointerId(0);
                break;
            }
            case MotionEvent.ACTION_MOVE:
                if (mIsBeingDragged) {
                    // Scroll to follow the motion event
                    final int activePointerIndex = ev.findPointerIndex(mActivePointerId);
                    final float x = ev.getX(activePointerIndex);
                    final int deltaX = (int) (mLastMotionX - x);
                    mLastMotionX = x;

                    final int oldX = mScrollX;
                    final int oldY = mScrollY;
                    final int range = getScrollRange();
                    final int overscrollMode = getOverScrollMode();
                    final boolean canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                            (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);

                    if (overScrollBy(deltaX, 0, mScrollX, 0, range, 0,
                            mOverscrollDistance, 0, true)) {
                        // Break our velocity if we hit a scroll barrier.
                        mVelocityTracker.clear();
                    }
                    onScrollChanged(mScrollX, mScrollY, oldX, oldY);

                    if (canOverscroll) {
                        final int pulledToX = oldX + deltaX;
                        if (pulledToX < 0) {
                            mEdgeGlowLeft.onPull((float) deltaX / getWidth());
                            if (!mEdgeGlowRight.isFinished()) {
                                mEdgeGlowRight.onRelease();
                            }
                        } else if (pulledToX > range) {
                            mEdgeGlowRight.onPull((float) deltaX / getWidth());
                            if (!mEdgeGlowLeft.isFinished()) {
                                mEdgeGlowLeft.onRelease();
                            }
                        }
                        if (mEdgeGlowLeft != null
                                && (!mEdgeGlowLeft.isFinished() || !mEdgeGlowRight.isFinished())) {
                            invalidate();
                        }
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mIsBeingDragged) {
                    final VelocityTracker velocityTracker = mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                    int initialVelocity = (int) velocityTracker.getXVelocity(mActivePointerId);

                    if (getChildCount() > 0) {
                        if ((Math.abs(initialVelocity) > mMinimumVelocity)) {
                            fling(-initialVelocity);
                        } else {
                            if (mScroller.springBack(mScrollX, mScrollY, 0,
                                    getScrollRange(), 0, 0)) {
                                invalidate();
                            }
                        }
                    }

                    mActivePointerId = INVALID_POINTER;
                    mIsBeingDragged = false;
                    recycleVelocityTracker();

                    if (mEdgeGlowLeft != null) {
                        mEdgeGlowLeft.onRelease();
                        mEdgeGlowRight.onRelease();
                    }
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                if (mIsBeingDragged && getChildCount() > 0) {
                    if (mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0)) {
                        invalidate();
                    }
                    mActivePointerId = INVALID_POINTER;
                    mIsBeingDragged = false;
                    recycleVelocityTracker();

                    if (mEdgeGlowLeft != null) {
                        mEdgeGlowLeft.onRelease();
                        mEdgeGlowRight.onRelease();
                    }
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                onSecondaryPointerUp(ev);
                break;
        }
        return true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.345 -0500", hash_original_method = "15678E7D87FCB5B2E2A6D15F2CBAE390", hash_generated_method = "055FADCD9833B1418F59E6F5A177F14E")
    
private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >>
                MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == mActivePointerId) {
            // This was our active pointer going up. Choose a new
            // active pointer and adjust accordingly.
            // TODO: Make this decision more intelligent.
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionX = ev.getX(newPointerIndex);
            mActivePointerId = ev.getPointerId(newPointerIndex);
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.348 -0500", hash_original_method = "EA19C55D5CBC44B40040771841401365", hash_generated_method = "5393E5EF6AA86C5BF3616127778679A2")
    
@Override
    public boolean onGenericMotionEvent(MotionEvent event) {
        if ((event.getSource() & InputDevice.SOURCE_CLASS_POINTER) != 0) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_SCROLL: {
                    if (!mIsBeingDragged) {
                        final float hscroll;
                        if ((event.getMetaState() & KeyEvent.META_SHIFT_ON) != 0) {
                            hscroll = -event.getAxisValue(MotionEvent.AXIS_VSCROLL);
                        } else {
                            hscroll = event.getAxisValue(MotionEvent.AXIS_HSCROLL);
                        }
                        if (hscroll != 0) {
                            final int delta = (int) (hscroll * getHorizontalScrollFactor());
                            final int range = getScrollRange();
                            int oldScrollX = mScrollX;
                            int newScrollX = oldScrollX + delta;
                            if (newScrollX < 0) {
                                newScrollX = 0;
                            } else if (newScrollX > range) {
                                newScrollX = range;
                            }
                            if (newScrollX != oldScrollX) {
                                super.scrollTo(newScrollX, mScrollY);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return super.onGenericMotionEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.351 -0500", hash_original_method = "C2F251AFC67F9C484131CB8CA191D5D9", hash_generated_method = "A772FDD7D6140F1318D1965F00562411")
    
@Override
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.354 -0500", hash_original_method = "06CAD3F9DAB24C265A0AAEC7445D85D7", hash_generated_method = "A839A0778803DAA09D5A0A02E4BD85D2")
    
@Override
    protected void onOverScrolled(int scrollX, int scrollY,
            boolean clampedX, boolean clampedY) {
        // Treat animating scrolls differently; see #computeScroll() for why.
        if (!mScroller.isFinished()) {
            mScrollX = scrollX;
            mScrollY = scrollY;
            invalidateParentIfNeeded();
            if (clampedX) {
                mScroller.springBack(mScrollX, mScrollY, 0, getScrollRange(), 0, 0);
            }
        } else {
            super.scrollTo(scrollX, scrollY);
        }
        awakenScrollBars();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.356 -0500", hash_original_method = "AF8EC74B0AD4D69DC5ACACFC8749064F", hash_generated_method = "4C0E56D7630B5BEB3C07FA106058300D")
    
@Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setScrollable(getScrollRange() > 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.358 -0500", hash_original_method = "7DA515169DBC462D06A7F08F561D2E84", hash_generated_method = "9F53DC8307A3F793CB34EC1645F2B207")
    
@Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setScrollable(getScrollRange() > 0);
        event.setScrollX(mScrollX);
        event.setScrollY(mScrollY);
        event.setMaxScrollX(getScrollRange());
        event.setMaxScrollY(mScrollY);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.361 -0500", hash_original_method = "6035917F8C30F3A1C02AFED333ACB352", hash_generated_method = "5CEAFDE4682F427F7265DD9A55DACA11")
    
private int getScrollRange() {
        int scrollRange = 0;
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            scrollRange = Math.max(0,
                    child.getWidth() - (getWidth() - mPaddingLeft - mPaddingRight));
        }
        return scrollRange;
    }

    /**
     * <p>
     * Finds the next focusable component that fits in this View's bounds
     * (excluding fading edges) pretending that this View's left is located at
     * the parameter left.
     * </p>
     *
     * @param leftFocus          look for a candidate is the one at the left of the bounds
     *                           if leftFocus is true, or at the right of the bounds if leftFocus
     *                           is false
     * @param left               the left offset of the bounds in which a focusable must be
     *                           found (the fading edge is assumed to start at this position)
     * @param preferredFocusable the View that has highest priority and will be
     *                           returned if it is within my bounds (null is valid)
     * @return the next focusable component in the bounds or null if none can be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.363 -0500", hash_original_method = "B34C300D12B589B0218EA4927548AE87", hash_generated_method = "AF17F7DA43E32801C07AE88C94AAD385")
    
private View findFocusableViewInMyBounds(final boolean leftFocus,
            final int left, View preferredFocusable) {
        /*
         * The fading edge's transparent side should be considered for focus
         * since it's mostly visible, so we divide the actual fading edge length
         * by 2.
         */
        final int fadingEdgeLength = getHorizontalFadingEdgeLength() / 2;
        final int leftWithoutFadingEdge = left + fadingEdgeLength;
        final int rightWithoutFadingEdge = left + getWidth() - fadingEdgeLength;

        if ((preferredFocusable != null)
                && (preferredFocusable.getLeft() < rightWithoutFadingEdge)
                && (preferredFocusable.getRight() > leftWithoutFadingEdge)) {
            return preferredFocusable;
        }

        return findFocusableViewInBounds(leftFocus, leftWithoutFadingEdge,
                rightWithoutFadingEdge);
    }

    /**
     * <p>
     * Finds the next focusable component that fits in the specified bounds.
     * </p>
     *
     * @param leftFocus look for a candidate is the one at the left of the bounds
     *                  if leftFocus is true, or at the right of the bounds if
     *                  leftFocus is false
     * @param left      the left offset of the bounds in which a focusable must be
     *                  found
     * @param right     the right offset of the bounds in which a focusable must
     *                  be found
     * @return the next focusable component in the bounds or null if none can
     *         be found
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.366 -0500", hash_original_method = "CFAC89DA51B9853AC14992D421225DFD", hash_generated_method = "B5BB49396AC7509986D6FEFB619C1771")
    
private View findFocusableViewInBounds(boolean leftFocus, int left, int right) {

        List<View> focusables = getFocusables(View.FOCUS_FORWARD);
        View focusCandidate = null;

        /*
         * A fully contained focusable is one where its left is below the bound's
         * left, and its right is above the bound's right. A partially
         * contained focusable is one where some part of it is within the
         * bounds, but it also has some part that is not within bounds.  A fully contained
         * focusable is preferred to a partially contained focusable.
         */
        boolean foundFullyContainedFocusable = false;

        int count = focusables.size();
        for (int i = 0; i < count; i++) {
            View view = focusables.get(i);
            int viewLeft = view.getLeft();
            int viewRight = view.getRight();

            if (left < viewRight && viewLeft < right) {
                /*
                 * the focusable is in the target area, it is a candidate for
                 * focusing
                 */

                final boolean viewIsFullyContained = (left < viewLeft) &&
                        (viewRight < right);

                if (focusCandidate == null) {
                    /* No candidate, take this one */
                    focusCandidate = view;
                    foundFullyContainedFocusable = viewIsFullyContained;
                } else {
                    final boolean viewIsCloserToBoundary =
                            (leftFocus && viewLeft < focusCandidate.getLeft()) ||
                                    (!leftFocus && viewRight > focusCandidate.getRight());

                    if (foundFullyContainedFocusable) {
                        if (viewIsFullyContained && viewIsCloserToBoundary) {
                            /*
                             * We're dealing with only fully contained views, so
                             * it has to be closer to the boundary to beat our
                             * candidate
                             */
                            focusCandidate = view;
                        }
                    } else {
                        if (viewIsFullyContained) {
                            /* Any fully contained view beats a partially contained view */
                            focusCandidate = view;
                            foundFullyContainedFocusable = true;
                        } else if (viewIsCloserToBoundary) {
                            /*
                             * Partially contained view beats another partially
                             * contained view if it's closer
                             */
                            focusCandidate = view;
                        }
                    }
                }
            }
        }

        return focusCandidate;
    }

    /**
     * <p>Handles scrolling in response to a "page up/down" shortcut press. This
     * method will scroll the view by one page left or right and give the focus
     * to the leftmost/rightmost component in the new visible area. If no
     * component is a good candidate for focus, this scrollview reclaims the
     * focus.</p>
     *
     * @param direction the scroll direction: {@link android.view.View#FOCUS_LEFT}
     *                  to go one page left or {@link android.view.View#FOCUS_RIGHT}
     *                  to go one page right
     * @return true if the key event is consumed by this method, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.369 -0500", hash_original_method = "DA183CDCD6EA3DA10063DE059735FFD7", hash_generated_method = "6DCA783BA407745EB0BBBC301C29F896")
    
public boolean pageScroll(int direction) {
        boolean right = direction == View.FOCUS_RIGHT;
        int width = getWidth();

        mTempRect.addTaint(direction + width + getScrollX());
        
        if (right) {
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(0);
                mTempRect.addTaint(view.getRight());
            }
        } 

        return scrollAndFocus(direction, mTempRect.left, mTempRect.right);
    }

    /**
     * <p>Handles scrolling in response to a "home/end" shortcut press. This
     * method will scroll the view to the left or right and give the focus
     * to the leftmost/rightmost component in the new visible area. If no
     * component is a good candidate for focus, this scrollview reclaims the
     * focus.</p>
     *
     * @param direction the scroll direction: {@link android.view.View#FOCUS_LEFT}
     *                  to go the left of the view or {@link android.view.View#FOCUS_RIGHT}
     *                  to go the right
     * @return true if the key event is consumed by this method, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.371 -0500", hash_original_method = "13724385C240165AD29E108B78F9E99D", hash_generated_method = "22170C5214775821A6A8546F2BF34525")
    
public boolean fullScroll(int direction) {
        boolean right = direction == View.FOCUS_RIGHT;
        int width = getWidth();

        mTempRect.addTaint(direction + width + getChildCount());
        
        mTempRect.left = 0;
        mTempRect.right = width;

        if (right) {
            int count = getChildCount();
            if (count > 0) {
                View view = getChildAt(0);
                mTempRect.addTaint(view.getRight());
                //mTempRect.right = view.getRight();
                //mTempRect.left = mTempRect.right - width;
            }
        }

        return scrollAndFocus(direction, mTempRect.left, mTempRect.right);
    }

    /**
     * <p>Scrolls the view to make the area defined by <code>left</code> and
     * <code>right</code> visible. This method attempts to give the focus
     * to a component visible in this area. If no component can be focused in
     * the new visible area, the focus is reclaimed by this scrollview.</p>
     *
     * @param direction the scroll direction: {@link android.view.View#FOCUS_LEFT}
     *                  to go left {@link android.view.View#FOCUS_RIGHT} to right
     * @param left     the left offset of the new area to be made visible
     * @param right    the right offset of the new area to be made visible
     * @return true if the key event is consumed by this method, false otherwise
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.374 -0500", hash_original_method = "DF3968C57E4B66E8EEB56F2D4C42BFD9", hash_generated_method = "CE35ED7BBE94E4F223A30792FE6D307D")
    
private boolean scrollAndFocus(int direction, int left, int right) {
        boolean handled = true;

        int width = getWidth();
        int containerLeft = getScrollX();
        int containerRight = containerLeft + width;
        boolean goLeft = direction == View.FOCUS_LEFT;

        View newFocused = findFocusableViewInBounds(goLeft, left, right);
        if (newFocused == null) {
            newFocused = this;
        }

        if (left >= containerLeft && right <= containerRight) {
            handled = false;
        } else {
            int delta = goLeft ? (left - containerLeft) : (right - containerRight);
            doScrollX(delta);
        }

        if (newFocused != findFocus()) newFocused.requestFocus(direction);

        return handled;
    }

    /**
     * Handle scrolling in response to a left or right arrow click.
     *
     * @param direction The direction corresponding to the arrow key that was
     *                  pressed
     * @return True if we consumed the event, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.377 -0500", hash_original_method = "ED0B7D3300F52C8B0FEFDD6EE298A1FB", hash_generated_method = "9EE9A5708759F920CC4788960746954F")
    
public boolean arrowScroll(int direction) {

        View currentFocused = findFocus();
        if (currentFocused == this) currentFocused = null;

        View nextFocused = FocusFinder.getInstance().findNextFocus(this, currentFocused, direction);

        final int maxJump = getMaxScrollAmount();

        if (nextFocused != null && isWithinDeltaOfScreen(nextFocused, maxJump)) {
            nextFocused.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(nextFocused, mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            doScrollX(scrollDelta);
            nextFocused.requestFocus(direction);
        } else {
            // no new focus
            int scrollDelta = maxJump;

            if (direction == View.FOCUS_LEFT && getScrollX() < scrollDelta) {
                scrollDelta = getScrollX();
            } else if (direction == View.FOCUS_RIGHT && getChildCount() > 0) {

                int daRight = getChildAt(0).getRight();

                int screenRight = getScrollX() + getWidth();

                if (daRight - screenRight < maxJump) {
                    scrollDelta = daRight - screenRight;
                }
            }
            if (scrollDelta == 0) {
                return false;
            }
            doScrollX(direction == View.FOCUS_RIGHT ? scrollDelta : -scrollDelta);
        }

        if (currentFocused != null && currentFocused.isFocused()
                && isOffScreen(currentFocused)) {
            // previously focused item still has focus and is off screen, give
            // it up (take it back to ourselves)
            // (also, need to temporarily force FOCUS_BEFORE_DESCENDANTS so we are
            // sure to
            // get it)
            final int descendantFocusability = getDescendantFocusability();  // save
            setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
            requestFocus();
            setDescendantFocusability(descendantFocusability);  // restore
        }
        return true;
    }

    /**
     * @return whether the descendant of this scroll view is scrolled off
     *  screen.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.379 -0500", hash_original_method = "E39461866A28C70AD36F56E791C6BE3B", hash_generated_method = "1126924EF017064A63321A2C73749ACD")
    
private boolean isOffScreen(View descendant) {
        return !isWithinDeltaOfScreen(descendant, 0);
    }

    /**
     * @return whether the descendant of this scroll view is within delta
     *  pixels of being on the screen.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.381 -0500", hash_original_method = "47CB02AABD47C9E7AF2DCBC38CD370E2", hash_generated_method = "6CAA1E2BB2CEF6A988716DEFA16D917C")
    
private boolean isWithinDeltaOfScreen(View descendant, int delta) {
        descendant.getDrawingRect(mTempRect);
        offsetDescendantRectToMyCoords(descendant, mTempRect);

        return toTaintBoolean((mTempRect.right + delta) + getScrollX() +
                               mTempRect.left   + getWidth());
    }

    /**
     * Smooth scroll by a X delta
     *
     * @param delta the number of pixels to scroll by on the X axis
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.383 -0500", hash_original_method = "3F16B27E18A709EC962C39AF363F3965", hash_generated_method = "951FF2A3732E55207835FFEBF921DEB7")
    
private void doScrollX(int delta) {
        if (delta != 0) {
            if (mSmoothScrollingEnabled) {
                smoothScrollBy(delta, 0);
            } else {
                scrollBy(delta, 0);
            }
        }
    }

    /**
     * Like {@link View#scrollBy}, but scroll smoothly instead of immediately.
     *
     * @param dx the number of pixels to scroll by on the X axis
     * @param dy the number of pixels to scroll by on the Y axis
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.386 -0500", hash_original_method = "DAE9EEC093475C9AC0229EA6C3F406DC", hash_generated_method = "209CA3C49FACF8868711FD5DDC016A55")
    
public final void smoothScrollBy(int dx, int dy) {
        if (getChildCount() == 0) {
            // Nothing to do.
            return;
        }
        long duration = AnimationUtils.currentAnimationTimeMillis() - mLastScroll;
        if (duration > ANIMATED_SCROLL_GAP) {
            final int width = getWidth() - mPaddingRight - mPaddingLeft;
            final int right = getChildAt(0).getWidth();
            final int maxX = Math.max(0, right - width);
            final int scrollX = mScrollX;
            dx = Math.max(0, Math.min(scrollX + dx, maxX)) - scrollX;

            mScroller.startScroll(scrollX, mScrollY, dx, 0);
            invalidate();
        } else {
            if (!mScroller.isFinished()) {
                mScroller.abortAnimation();
            }
            scrollBy(dx, dy);
        }
        mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    /**
     * Like {@link #scrollTo}, but scroll smoothly instead of immediately.
     *
     * @param x the position where to scroll on the X axis
     * @param y the position where to scroll on the Y axis
     */
    @DSComment("GUI ScrollView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.388 -0500", hash_original_method = "EED648F6788EFF0F67B65ABAA0DE4CF2", hash_generated_method = "100B355DE0AE23DDEE74EF5E482D3B12")
    
public final void smoothScrollTo(int x, int y) {
        smoothScrollBy(x - mScrollX, y - mScrollY);
    }

    /**
     * <p>The scroll range of a scroll view is the overall width of all of its
     * children.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.390 -0500", hash_original_method = "344907C67A02819CC7A230367AD45761", hash_generated_method = "4B06F00DE2D9425181B65C93B3228913")
    
@Override
    protected int computeHorizontalScrollRange() {
        final int count = getChildCount();
        final int contentWidth = getWidth() - mPaddingLeft - mPaddingRight;
        if (count == 0) {
            return contentWidth;
        }

        int scrollRange = getChildAt(0).getRight();
        final int scrollX = mScrollX;
        final int overscrollRight = Math.max(0, scrollRange - contentWidth);
        if (scrollX < 0) {
            scrollRange -= scrollX;
        } else if (scrollX > overscrollRight) {
            scrollRange += scrollX - overscrollRight;
        }

        return scrollRange;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.393 -0500", hash_original_method = "9CF354C1D07DBC59A9E2E44E57F7657B", hash_generated_method = "9C1D22DB9316ECC99BD2010E05754C31")
    
@Override
    protected int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.396 -0500", hash_original_method = "1A4819189D92B65ABF3F692114902ED1", hash_generated_method = "2C87C4836D80729EAE3CE4179B23B251")
    
@Override
    protected void measureChild(View child, int parentWidthMeasureSpec, int parentHeightMeasureSpec) {
        ViewGroup.LayoutParams lp = child.getLayoutParams();

        int childWidthMeasureSpec;
        int childHeightMeasureSpec;

        childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec, mPaddingTop
                + mPaddingBottom, lp.height);

        childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.399 -0500", hash_original_method = "0EA8DFEAF2643806863B304E52EE38A5", hash_generated_method = "F3CD8C2A4DBDBB659025D1E5FD173F95")
    
@Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
            int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                mPaddingTop + mPaddingBottom + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                lp.leftMargin + lp.rightMargin, MeasureSpec.UNSPECIFIED);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.402 -0500", hash_original_method = "D30258BCA66C5E19407EB248DA88CE03", hash_generated_method = "8317B4C2EF76B0B7FAE50621EC2E7F4E")
    
@Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            // This is called at drawing time by ViewGroup.  We don't want to
            // re-show the scrollbars at this point, which scrollTo will do,
            // so we replicate most of scrollTo here.
            //
            //         It's a little odd to call onScrollChanged from inside the drawing.
            //
            //         It is, except when you remember that computeScroll() is used to
            //         animate scrolling. So unless we want to defer the onScrollChanged()
            //         until the end of the animated scrolling, we don't really have a
            //         choice here.
            //
            //         I agree.  The alternative, which I think would be worse, is to post
            //         something and tell the subclasses later.  This is bad because there
            //         will be a window where mScrollX/Y is different from what the app
            //         thinks it is.
            //
            int oldX = mScrollX;
            int oldY = mScrollY;
            int x = mScroller.getCurrX();
            int y = mScroller.getCurrY();

            if (oldX != x || oldY != y) {
                final int range = getScrollRange();
                final int overscrollMode = getOverScrollMode();
                final boolean canOverscroll = overscrollMode == OVER_SCROLL_ALWAYS ||
                        (overscrollMode == OVER_SCROLL_IF_CONTENT_SCROLLS && range > 0);

                overScrollBy(x - oldX, y - oldY, oldX, oldY, range, 0,
                        mOverflingDistance, 0, false);
                onScrollChanged(mScrollX, mScrollY, oldX, oldY);

                if (canOverscroll) {
                    if (x < 0 && oldX >= 0) {
                        mEdgeGlowLeft.onAbsorb((int) mScroller.getCurrVelocity());
                    } else if (x > range && oldX <= range) {
                        mEdgeGlowRight.onAbsorb((int) mScroller.getCurrVelocity());
                    }
                }
            }

            awakenScrollBars();

            // Keep on drawing until the animation has finished.
            postInvalidate();
        }
    }

    /**
     * Scrolls the view to the given child.
     *
     * @param child the View to scroll to
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.404 -0500", hash_original_method = "988A7EC33B56EE551974E7C841966101", hash_generated_method = "275D87C42D455387B12A2DBBE41F059C")
    
private void scrollToChild(View child) {
        child.getDrawingRect(mTempRect);

        /* Offset from child's local coordinates to ScrollView coordinates */
        offsetDescendantRectToMyCoords(child, mTempRect);

        int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);

        if (scrollDelta != 0) {
            scrollBy(scrollDelta, 0);
        }
    }

    /**
     * If rect is off screen, scroll just enough to get it (or at least the
     * first screen size chunk of it) on screen.
     *
     * @param rect      The rectangle.
     * @param immediate True to scroll immediately without animation
     * @return true if scrolling was performed
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.407 -0500", hash_original_method = "07633DDCD66F05F9C6104D95040C4376", hash_generated_method = "0A3B75AAA278D1333D8A6F2CA489E687")
    
private boolean scrollToChildRect(Rect rect, boolean immediate) {
        final int delta = computeScrollDeltaToGetChildRectOnScreen(rect);
        final boolean scroll = delta != 0;
        if (scroll) {
            if (immediate) {
                scrollBy(delta, 0);
            } else {
                smoothScrollBy(delta, 0);
            }
        }
        return scroll;
    }

    /**
     * Compute the amount to scroll in the X direction in order to get
     * a rectangle completely on the screen (or, if taller than the screen,
     * at least the first screen size chunk of it).
     *
     * @param rect The rect.
     * @return The scroll delta.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.409 -0500", hash_original_method = "8C5AA93676CE0EF7515972F93F61C0B6", hash_generated_method = "191467B0F9825B33B79222EA1167811D")
    
protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) return 0;

        int width = getWidth();
        int screenLeft = getScrollX();
        int screenRight = screenLeft + width;

        int fadingEdge = getHorizontalFadingEdgeLength();

        return (width + screenLeft + screenRight + fadingEdge + rect.getTaintInt());
      /*  
        // leave room for left fading edge as long as rect isn't at very left
        if (rect.left > 0) {
            screenLeft += fadingEdge;
        }

        // leave room for right fading edge as long as rect isn't at very right
        if (rect.right < getChildAt(0).getWidth()) {
            screenRight -= fadingEdge;
        }

        int scrollXDelta = 0;

        if (rect.right > screenRight && rect.left > screenLeft) {
            // need to move right to get it in view: move right just enough so
            // that the entire rectangle is in view (or at least the first
            // screen size chunk).

            if (rect.width() > width) {
                // just enough to get screen size chunk on
                scrollXDelta += (rect.left - screenLeft);
            } else {
                // get entire rect at right of screen
                scrollXDelta += (rect.right - screenRight);
            }

            // make sure we aren't scrolling beyond the end of our content
            int right = getChildAt(0).getRight();
            int distanceToRight = right - screenRight;
            scrollXDelta = Math.min(scrollXDelta, distanceToRight);

        } else if (rect.left < screenLeft && rect.right < screenRight) {
            // need to move right to get it in view: move right just enough so that
            // entire rectangle is in view (or at least the first screen
            // size chunk of it).

            if (rect.width() > width) {
                // screen size chunk
                scrollXDelta -= (screenRight - rect.right);
            } else {
                // entire rect at left
                scrollXDelta -= (screenLeft - rect.left);
            }

            // make sure we aren't scrolling any further than the left our content
            scrollXDelta = Math.max(scrollXDelta, -getScrollX());
        }
        return scrollXDelta;*/
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.412 -0500", hash_original_method = "C2C4A47D49BA76A3A98712461E581564", hash_generated_method = "98DCFF4EDA5A5C8FC7E7F6CD8CED4486")
    
@Override
    public void requestChildFocus(View child, View focused) {
        if (!mIsLayoutDirty) {
            scrollToChild(focused);
        } else {
            // The child may not be laid out yet, we can't compute the scroll yet
            mChildToScrollTo = focused;
        }
        super.requestChildFocus(child, focused);
    }

    /**
     * When looking for focus in children of a scroll view, need to be a little
     * more careful not to give focus to something that is scrolled off screen.
     *
     * This is more expensive than the default {@link android.view.ViewGroup}
     * implementation, otherwise this behavior might have been made the default.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.414 -0500", hash_original_method = "4857D3DE9468292A125F69FE9ECFC007", hash_generated_method = "8547E408B70AFC177C9A694A9401E28E")
    
@Override
    protected boolean onRequestFocusInDescendants(int direction,
            Rect previouslyFocusedRect) {

        // convert from forward / backward notation to up / down / left / right
        // (ugh).
        if (direction == View.FOCUS_FORWARD) {
            direction = View.FOCUS_RIGHT;
        } else if (direction == View.FOCUS_BACKWARD) {
            direction = View.FOCUS_LEFT;
        }

        final View nextFocus = previouslyFocusedRect == null ?
                FocusFinder.getInstance().findNextFocus(this, null, direction) :
                FocusFinder.getInstance().findNextFocusFromRect(this,
                        previouslyFocusedRect, direction);

        if (nextFocus == null) {
            return false;
        }

        if (isOffScreen(nextFocus)) {
            return false;
        }

        return nextFocus.requestFocus(direction, previouslyFocusedRect);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.417 -0500", hash_original_method = "50E2DA7CF8E403536932E3B77491E964", hash_generated_method = "B16CB776AD6E821B801CFA187CF842FA")
    
@Override
    public boolean requestChildRectangleOnScreen(View child, Rect rectangle,
            boolean immediate) {
        // offset into coordinate space of this scroll view
        rectangle.offset(child.getLeft() - child.getScrollX(),
                child.getTop() - child.getScrollY());

        return scrollToChildRect(rectangle, immediate);
    }

    @DSComment("GUI ScrollView")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.419 -0500", hash_original_method = "31751D7E496E2D7BD9B4D4E94AD28515", hash_generated_method = "B7E248DB0C1A99B91CE46EBF969ED5CA")
    
@Override
    public void requestLayout() {
        mIsLayoutDirty = true;
        super.requestLayout();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.421 -0500", hash_original_method = "51521A672083F0AD2F639BD854AB8D0F", hash_generated_method = "BCF76A80CBC53B48B76925AAE679C9CE")
    
@Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mIsLayoutDirty = false;
        // Give a child focus if it needs it
        if (mChildToScrollTo != null && isViewDescendantOf(mChildToScrollTo, this)) {
                scrollToChild(mChildToScrollTo);
        }
        mChildToScrollTo = null;

        // Calling this with the present values causes it to re-clam them
        scrollTo(mScrollX, mScrollY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.424 -0500", hash_original_method = "BFC9FDBBB166F0ED568B66B969E998B2", hash_generated_method = "531D88DB50BBC2AC64CC9FAB52AA006E")
    
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        View currentFocused = findFocus();
        if (null == currentFocused || this == currentFocused)
            return;

        final int maxJump = mRight - mLeft;

        if (isWithinDeltaOfScreen(currentFocused, maxJump)) {
            currentFocused.getDrawingRect(mTempRect);
            offsetDescendantRectToMyCoords(currentFocused, mTempRect);
            int scrollDelta = computeScrollDeltaToGetChildRectOnScreen(mTempRect);
            doScrollX(scrollDelta);
        }
    }

    /**
     * Return true if child is an descendant of parent, (or equal to the parent).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.427 -0500", hash_original_method = "25276A1ACE97D138BB17C9052B223D37", hash_generated_method = "4E4B67595C9AA38B501A2B2B2088EE51")
    
private boolean isViewDescendantOf(View child, View parent) {
        if (child == parent) {
            return true;
        }

        final ViewParent theParent = child.getParent();
        return (theParent instanceof ViewGroup) && isViewDescendantOf((View) theParent, parent);
    }

    /**
     * Fling the scroll view
     *
     * @param velocityX The initial velocity in the X direction. Positive
     *                  numbers mean that the finger/curor is moving down the screen,
     *                  which means we want to scroll towards the left.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.430 -0500", hash_original_method = "C5A2747735A9CF7D4575D6EE52958D1F", hash_generated_method = "059683897E09276870652FDEEC4AF7CE")
    
public void fling(int velocityX) {
        if (getChildCount() > 0) {
            int width = getWidth() - mPaddingRight - mPaddingLeft;
            int right = getChildAt(0).getWidth();

            mScroller.fling(mScrollX, mScrollY, velocityX, 0, 0,
                    Math.max(0, right - width), 0, 0, width/2, 0);

            final boolean movingRight = velocityX > 0;

            View currentFocused = findFocus();
            View newFocused = findFocusableViewInMyBounds(movingRight,
                    mScroller.getFinalX(), currentFocused);

            if (newFocused == null) {
                newFocused = this;
            }

            if (newFocused != currentFocused) {
                newFocused.requestFocus(movingRight ? View.FOCUS_RIGHT : View.FOCUS_LEFT);
            }

            invalidate();
        }
    }

    /**
     * {@inheritDoc}
     *
     * <p>This version also clamps the scrolling to the bounds of our child.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.432 -0500", hash_original_method = "748C5914370A5F8CDD8109B6F4611B5B", hash_generated_method = "3A1797599400A01D35584D2148E07111")
    
@Override
    public void scrollTo(int x, int y) {
        // we rely on the fact the View.scrollBy calls scrollTo.
        if (getChildCount() > 0) {
            View child = getChildAt(0);
            x = clamp(x, getWidth() - mPaddingRight - mPaddingLeft, child.getWidth());
            y = clamp(y, getHeight() - mPaddingBottom - mPaddingTop, child.getHeight());
            if (x != mScrollX || y != mScrollY) {
                super.scrollTo(x, y);
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.434 -0500", hash_original_method = "7D7EAD2993C7155FA8CA9421487AA499", hash_generated_method = "98703A791FF13BE76E446A202C89DD6C")
    
@Override
    public void setOverScrollMode(int mode) {
        if (mode != OVER_SCROLL_NEVER) {
            if (mEdgeGlowLeft == null) {
                Context context = getContext();
                mEdgeGlowLeft = new EdgeEffect(context);
                mEdgeGlowRight = new EdgeEffect(context);
            }
        } else {
            mEdgeGlowLeft = null;
            mEdgeGlowRight = null;
        }
        super.setOverScrollMode(mode);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.437 -0500", hash_original_method = "63AFEEC895B9671DC479FE83536227D7", hash_generated_method = "036084862698F19C6CD580366D263CE4")
    
@SuppressWarnings({"SuspiciousNameCombination"})
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (mEdgeGlowLeft != null) {
            final int scrollX = mScrollX;
            if (!mEdgeGlowLeft.isFinished()) {
                final int restoreCount = canvas.save();
                final int height = getHeight() - mPaddingTop - mPaddingBottom;

                canvas.rotate(270);
                canvas.translate(-height + mPaddingTop, Math.min(0, scrollX));
                mEdgeGlowLeft.setSize(height, getWidth());
                if (mEdgeGlowLeft.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(restoreCount);
            }
            if (!mEdgeGlowRight.isFinished()) {
                final int restoreCount = canvas.save();
                final int width = getWidth();
                final int height = getHeight() - mPaddingTop - mPaddingBottom;

                canvas.rotate(90);
                canvas.translate(-mPaddingTop,
                        -(Math.max(getScrollRange(), scrollX) + width));
                mEdgeGlowRight.setSize(height, width);
                if (mEdgeGlowRight.draw(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(restoreCount);
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:00.439 -0500", hash_original_method = "10E81B579101690AB90AC933866D5438", hash_generated_method = "DAEF430F6DF2ECF48CB7F061199A0034")
    
private int clamp(int n, int my, int child) {
        if (my >= child || n < 0) {
            return 0;
        }
        if ((my + n) > child) {
            return child - my;
        }
        return n;
    }
}

